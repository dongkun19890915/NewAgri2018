package com.sinosoft.agriprpall.core.policymanage.service.impl;

import com.sinosoft.agriprpall.api.policymanage.dto.RequestBusinessListDto;
import com.sinosoft.agriprpall.api.policymanage.dto.ResponseBusinessListDto;
import com.sinosoft.agriprpall.api.policymanage.dto.SumAmountAndPremiumDto;
import com.sinosoft.agriprpall.core.common.util.file.FileUtil;
import com.sinosoft.agriprpall.core.policymanage.service.BusinessListService;
import com.sinosoft.framework.agri.core.excel.POIUtils;
import com.sinosoft.framework.agri.core.utils.DateUtil;
import com.sinosoft.framework.agri.core.utils.QuicklyExportExcel;
import com.sinosoft.framework.core.context.SinoRequestContext;
import com.sinosoft.framework.core.service.impl.BaseServiceImpl;
import com.sinosoft.framework.core.utils.StringUtils;
import com.sinosoft.framework.dto.PageInfo;
import com.sinosoft.framework.exception.DataVerifyException;
import com.sinosoft.ims.api.kernel.PrpDcompanyApi;
import com.sinosoft.ims.api.kernel.PrpDuserApi;
import com.sinosoft.ims.api.kernel.dto.PrpDcompanyDto;
import com.sinosoft.ims.api.kernel.dto.PrpDuserDto;
import com.sinosoft.pms.api.kernel.PrpDriskApi;
import com.sinosoft.pms.api.kernel.dto.PrpDriskDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.io.File;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.*;

/**
*业务清单查询(当日清单 未缴费保单 应收保费)
* @Author: 陈道洋
* @Date: 2017/11/4 15:04
*/
@Service
public class BusinessListServiceImpl extends BaseServiceImpl implements BusinessListService {
    /** log日志 */
    private static final Logger LOGGER = LoggerFactory.getLogger(BusinessListServiceImpl.class);
    @Autowired
    private EntityManager entityManager;
    @Value("${sysconfig.policyManage.payReason}")
    private String payReason;
    @Value("${sysconfig.policyManage.subsidy}")
    private String subsidy;
    @Autowired
    private PrpDuserApi prpDuserApi;
    @Autowired
    private PrpDriskApi prpDriskApi;
    @Autowired
    private PrpDcompanyApi prpDcompanyApi;

    @Value("${sysconfig.common.systemFlag}")
    private String systemFlag;//新农险标识（prptmian表中的systemflag,用于区分新农险系统与老系统的数据）



    /**
     * Excel导出的版本配置
     */
    @Value("${exportExcelType}")
    private String exportExcelType;

    /**
     * fileService的服务器地址
     */
    @Value("${fileService.url}")
    private String fileServiceUrl;

    /**
     * 业务清单查询
     * @author: 陈道洋
     * @date: 2017/11/4 15:04
     * @param requestBusinessListDto 请求Dto
     * @return 业务清单查询所需的结果
     * @throws Exception
     */
     @Override
    public PageInfo<ResponseBusinessListDto> queryBusinessListByCondition(RequestBusinessListDto requestBusinessListDto) throws Exception {
      String classCode=requestBusinessListDto.getClassCode();//险种大类
      String listType=requestBusinessListDto.getListType();//清单类型
      String startDate=requestBusinessListDto.getStartDate();//操作时间起期
      String endDate=requestBusinessListDto.getEndDate();//操作时间止期
      String comCode =requestBusinessListDto.getComCode();//机构代码
      int pageNo=requestBusinessListDto.getPageNo();//页数
      int pageSize=requestBusinessListDto.getPageSize();//每页条数
      StringBuilder comCodeSql1=new StringBuilder();//拼接机构代码（保单）
      StringBuilder comCodeSql2=new StringBuilder();//拼接机构代码（批单）
       if(StringUtils.isEmpty(listType)){
           throw new DataVerifyException("清单类型不能为空！");
       }
       if (!listType.equals("D") && !listType.equals("W") && !listType.equals("S")){
           throw new DataVerifyException("清单类型不正确！");
       }
       if (StringUtils.isEmpty(comCode)) {
           throw new DataVerifyException("机构代码不能为空！");
       }
       //定义日期格式
       SimpleDateFormat year = new SimpleDateFormat("yyyy");
       SimpleDateFormat month = new SimpleDateFormat("MM");
       SimpleDateFormat day = new SimpleDateFormat("dd");
       Date date = new Date();
       if (StringUtils.isEmpty(startDate)){
           if (listType.equals("D")){
               startDate = year.format(date)+"-"+month.format(date)+"-"+day.format(date);//默认今天
           }else {
               startDate = DateUtil.getMonthFirstDay();//本月一号
           }
       }
       if (StringUtils.isEmpty(endDate)){
           endDate = DateUtil.getMonthLastDay();//本月最后一天
       }
       //缴费原因：配置文件读取的数据转换成List
       List<String> payType;
       if ("D".equals(listType) || "W".equals(listType)){
           payType = Arrays.asList(payReason.split(","));
       }else{
           payType = Arrays.asList(subsidy.split(","));
       }
       //原生SQL 查询数据sql
       StringBuilder dataSql = new StringBuilder("select cc.policyno," +
               " cc.riskcode," +
               " cc.insuredname," +
               " cc.operatedate," +
               " sum(mm.sumamount), " +
               " sum(mm.sumpremium)," +
               " cc.operatorcode, " +
               " sum(mm.sumPlanFee)," +
               " sum(mm.sumDelinquentFee)" +
               " from prpcmain cc ,(");
       //查询总数sql
       StringBuilder countSql = new StringBuilder("select count(1) from (");
       //保单部分
       if(listType.equals("D")){//当日签单清单
           dataSql.append("select cm.policyno, " +
                   "  cm.sumpremium as sumpremium, " +
                   "  sumamount,j.payreffee as sumPlanFee," +
                   "  (cm.sumpremium-j.payreffee) as sumDelinquentFee "+
                   " from prpcmainorigin cm, prpjpayrefrec j "+
                   " where j.certino = cm.policyno and j.policyno = cm.policyno " +
                   "  and j.payrefdate is not null and j.payrefno is not null and j.certitype = 'P' " +
                   "  and underwriteflag in ('1', '3') and cm.systemflag = :systemFlag " +
                   "  and j.payrefdate = to_date(:startDate,'yyyy-MM-dd')"
              );
       }else if(listType.equals("W")){//未缴费保单清单
            dataSql.append("select cm.policyno, " +
                    "   cm.sumpremium as sumpremium, " +
                    "   sumamount,0 as sumPlanFee, " +
                    "   sumpremium as sumDelinquentFee" +
                    "   from prpcmainorigin cm" +
                    "   where underwriteflag in ('1', '3','4')" +
                    "   and not exists (select 1 from prpjpayrefrec j" +
                    "       where j.certino = cm.policyno and j.policyno = cm.policyno" +
                    "       and j.payrefdate is not null and j.payrefno is not null and certitype = 'P'" +
                    "   ) and cm.systemflag = :systemFlag" +
                    "   and cm.operateDate >= to_date(:startDate,'yyyy-MM-dd')" +
                    "   and cm.operateDate <= to_date(:endDate,'yyyy-MM-dd')"
            );
       }else if(listType.equals("S")){//应收保费清单
            dataSql.append("select cm.policyno, " +
                    "   cm.sumpremium as sumpremium, " +
                    "   sumamount,j.payreffee as sumPlanFee," +
                    "   (cm.sumpremium-j.payreffee) as sumDelinquentFee" +
                    "   from prpcmainorigin cm, prpjpayrefrec j " +
                    "   where exists(select 1 from prpcplan plan " +
                    "       where cm.policyno = plan.policyno and plan.endorseno is null " +
                    "       and plan.payreason in (:payType) and plan.delinquentfee >0)" +
                    "   and j.certino = cm.policyno and j.policyno = cm.policyno " +
                    "   and j.payrefdate is not null and j.payrefno is not null and j.certitype = 'P'" +
                    "   and cm.underwriteflag in ('1', '3') and cm.systemflag = :systemFlag" +
                    "   and cm.operateDate >= to_date(:startDate,'yyyy-MM-dd')" +
                    "   and cm.operateDate <= to_date(:endDate,'yyyy-MM-dd')"
            );
       }
       //根据机构代码查询下属机构代码
       Map<String,String> map=new HashMap<>();
       map.put("comCode",comCode);
       List<PrpDcompanyDto> prpDcompanyDtoList = prpDcompanyApi.querySubordinateCompany(map);
       if (prpDcompanyDtoList.size() > 0) {
           comCodeSql1.append(" AND cm.comCode in (");
           comCodeSql2.append(" AND pm.comCode in (");
       }else{
           comCodeSql1.append(" AND cm.comCode in ('"+comCode+"')");
           comCodeSql2.append(" AND pm.comCode in ('"+comCode+"')");
       }
       for (int i = 0; i < prpDcompanyDtoList.size(); i++) {
           //机构大于1000个 处理方式是 拼接 or comCode in ()
           if (i < 1000) {
               if (i == prpDcompanyDtoList.size() - 1 || i == 999) {
                   comCodeSql1.append("'" + prpDcompanyDtoList.get(i).getComCode() + "'");
                   comCodeSql2.append("'" + prpDcompanyDtoList.get(i).getComCode() + "'");
               } else {
                   comCodeSql1.append("'" + prpDcompanyDtoList.get(i).getComCode() + "'" + ",");
                   comCodeSql2.append("'" + prpDcompanyDtoList.get(i).getComCode() + "'" + ",");
               }
           } else if (i == 1000) {
               if (i == prpDcompanyDtoList.size() - 1) {
                   comCodeSql1.append(" ) OR cm.comCode In ( '" + prpDcompanyDtoList.get(i).getComCode() + "'");
                   comCodeSql2.append(" ) OR pm.comCode In ( '" + prpDcompanyDtoList.get(i).getComCode() + "'");
               } else {
                   comCodeSql1.append(" ) OR cm.comCode In ( '" + prpDcompanyDtoList.get(i).getComCode() + "',");
                   comCodeSql2.append(" ) OR pm.comCode In ( '" + prpDcompanyDtoList.get(i).getComCode() + "',");
               }
           } else {
               if (i == prpDcompanyDtoList.size() - 1) {
                   comCodeSql1.append(" '" + prpDcompanyDtoList.get(i).getComCode() + "'");
                   comCodeSql2.append(" '" + prpDcompanyDtoList.get(i).getComCode() + "'");
               } else {
                   comCodeSql1.append("'" + prpDcompanyDtoList.get(i).getComCode() + "',");
                   comCodeSql2.append("'" + prpDcompanyDtoList.get(i).getComCode() + "',");
               }
           }
       }
       if (prpDcompanyDtoList.size() > 0) {
           comCodeSql1.append(" ) ");
           comCodeSql2.append(" ) ");
       }
       //保单部分拼接险种大类
       if(StringUtils.isNotEmpty(classCode)){
           dataSql.append(" AND cm.classCode=:classCode");
       }else{
           dataSql.append(" AND cm.classCode in ('31','32')");
       }
       //保单部分拼接机构代码
       dataSql.append(comCodeSql1);
       //批单部分
//       if(listType.equals("D")){//当日签单清单
//           dataSql.append("union all " +
//                   "  select ph.policyno, " +
//                   "  pm.chgpremium as sumpremium," +
//                   "  pm.chgamount as sumamount, "+
//                   "  j.payreffee as sumPlanFee, " +
//                   "  (pm.chgpremium-j.payreffee) as delinquentfee "+
//                   " from prpphead ph, prppmain pm, prpjpayrefrec j " +
//                   "  where j.certino = pm.endorseno and j.policyno = pm.policyno and pm.endorseno = ph.endorseno" +
//                   "  and j.payrefdate is not null and j.payrefno is not null and j.certitype = 'E' " +
//                   "  and ph.underwriteflag in ('1', '3') and pm.systemflag = :systemFlag "+
//                   "  and j.payrefdate = to_date(:startDate,'yyyy-MM-dd')"
//           );
//       }else if(listType.equals("W")){//未缴费保单清单
//           dataSql.append("union all " +
//                   "   select ph.policyno," +
//                   "   pm.chgpremium as sumpremium," +
//                   "   pm.chgamount       as sumamount," +
//                   "   0 as sumPlanFee," +
//                   "   pm.chgpremium as sumDelinquentFee" +
//                   "   from prpphead ph, prppmain pm" +
//                   "   where pm.endorseno = ph.endorseno" +
//                   "   and ph.underwriteflag in ('1', '3', '4')" +
//                   "   and not exists (select 1 from prpjpayrefrec j " +
//                   "       where j.certino = pm.endorseno and j.policyno = pm.policyno" +
//                   "       and j.payrefdate is not null and j.payrefno is not null and certitype = 'E'" +
//                   "   ) and pm.systemflag = :systemFlag"+
//                   "   and ph.inputdate >= to_date(:startDate,'yyyy-MM-dd')" +
//                   "   and ph.inputdate <= to_date(:endDate,'yyyy-MM-dd')"
//           );
//        }else if(listType.equals("S")){//应收保费清单
//            dataSql.append("union all " +
//                    "   select ph.policyno," +
//                    "   pm.chgpremium as sumpremium," +
//                    "   pm.chgamount as sumamount," +
//                    "   j.payreffee as sumPlanFee," +
//                    "   (pm.chgpremium-j.payreffee) as delinquentfee" +
//                    "   from prpphead ph, prppmain pm, prpjpayrefrec j" +
//                    "   where exists(select 1 from prpcplan plan " +
//                    "       where pm.endorseno = plan.endorseno and plan.endorseno is not null " +
//                    "       and plan.payreason in (:payType) and plan.delinquentfee >0)" +
//                    "   and j.certino = pm.endorseno and j.policyno = pm.policyno and pm.endorseno = ph.endorseno " +
//                    "   and j.payrefdate is not null and j.payrefno is not null and j.certitype = 'E'" +
//                    "   and ph.underwriteflag in ('1', '3') and pm.systemflag = :systemFlag" +
//                    "   and ph.inputdate >= to_date(:startDate,'yyyy-MM-dd')" +
//                    "   and ph.inputdate <= to_date(:endDate,'yyyy-MM-dd')"
//            );
//        }
//         //批单部分拼接险种大类
//         if(StringUtils.isNotEmpty(classCode)){
//             dataSql.append(" AND pm.classCode=:classCode");
//         }else{
//             dataSql.append(" AND pm.classCode in ('31','32')");
//         }
//        //批单部分拼接机构代码
//        dataSql.append(comCodeSql2);
        dataSql.append(" ) mm where cc.policyno = mm.policyno " +
                "   group by cc.policyno,cc.riskcode,cc.insuredname,cc.operatedate,cc.operatorcode"
        );
        countSql.append(dataSql+")");
        Query dateQuery = entityManager.createNativeQuery(dataSql.toString());
        Query countQuery = entityManager.createNativeQuery(countSql.toString());
        dateQuery.setParameter("systemFlag",systemFlag);
        dateQuery.setParameter("startDate",startDate);
         countQuery.setParameter("systemFlag",systemFlag);
         countQuery.setParameter("startDate",startDate);
        if(!listType.equals("D")){
            dateQuery.setParameter("endDate",endDate);
            countQuery.setParameter("endDate",endDate);
        }
        if(listType.equals("S")){
            dateQuery.setParameter("payType",payType);
            countQuery.setParameter("payType",payType);
        }
        if(StringUtils.isNotEmpty(classCode)){
            dateQuery.setParameter("classCode",classCode);
            countQuery.setParameter("classCode",classCode);
        }

        //查询数据总条数
        long countNum = ((BigDecimal) countQuery.getSingleResult()).longValue();
        if(pageNo!= -1){
            dateQuery.setFirstResult((pageNo-1)*pageSize);//从第几条开始查
            dateQuery.setMaxResults(pageSize);//查的条数
        }
        List<Object []> list = new ArrayList<>();
        List<ResponseBusinessListDto> responseBusinessListDtoList = new ArrayList<>();
         DecimalFormat decimalFormat = new DecimalFormat("0.00");
         if(countNum>0){
            List<String> riskCodeList = new ArrayList<>();
            List<String> operatorCodeList = new ArrayList<>();
            list = dateQuery.getResultList();
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            for(Object [] obj : list) {
                ResponseBusinessListDto responseBusinessListDto = new ResponseBusinessListDto();
                responseBusinessListDto.setPolicyNo(obj[0].toString());
                String riskCode = obj[1].toString();
                responseBusinessListDto.setRiskName(riskCode);
                if (!riskCodeList.contains(riskCode)) {
                    riskCodeList.add(riskCode);
                }
                responseBusinessListDto.setInsuredName(obj[2].toString());
                responseBusinessListDto.setDate(sdf.format(obj[3]));
                responseBusinessListDto.setSumAmount(decimalFormat.format(obj[4]));
                responseBusinessListDto.setSumPremium(decimalFormat.format(obj[5]));
                String operatorCode = obj[6].toString();
                responseBusinessListDto.setOperatorName(operatorCode);
                if (!operatorCodeList.contains(operatorCode)) {
                    operatorCodeList.add(operatorCode);
                }
                responseBusinessListDto.setPlanFee(decimalFormat.format(obj[7]));
                responseBusinessListDto.setDelinQuentFee(decimalFormat.format(obj[8]));
                responseBusinessListDtoList.add(responseBusinessListDto);
            }
            List<PrpDuserDto> prpDuserDtoList = prpDuserApi.queryByUserCodeList(operatorCodeList);
            Map<String,String> userMap = new HashMap<>();
            for (PrpDuserDto prpDuserDto : prpDuserDtoList) {
                userMap.put(prpDuserDto.getUserCode(),prpDuserDto.getUserName());
            }
            List<PrpDriskDto> prpDriskDtoList = prpDriskApi.queryByRiskCodeList(riskCodeList);
            Map<String,String> riskMap = new HashMap<>();
            for (PrpDriskDto prpDriskDto : prpDriskDtoList) {
                riskMap.put(prpDriskDto.getRiskCode(),prpDriskDto.getRiskCName());
            }
            for (ResponseBusinessListDto businessListDto: responseBusinessListDtoList) {
                String riskCode = businessListDto.getRiskName();
                String userCode = businessListDto.getOperatorName();
                businessListDto.setRiskName(riskMap.get(riskCode));
                businessListDto.setOperatorName(userMap.get(userCode));
            }
         }
         // 统一封装分页响应dto
        PageInfo<ResponseBusinessListDto> pageinfo = new PageInfo<>();
        pageinfo.setContent(responseBusinessListDtoList);
        pageinfo.setPages(pageNo);
        pageinfo.setTotalCount(countNum);
        return pageinfo;
    }

    /**
     * 查询签单总保额、总保费，未交费保单总保额、总保费，应收保费总保额、总保费
     * @author: 刘曼曼
     * @date: 2017/11/13 11:20
     * @param comCode 机构代码
     * @return SumAmountAndPremiumDto总保额、总保费查询所需结果
     * @throws Exception
     */
    @Override
    public SumAmountAndPremiumDto queryPremiumInfo(String comCode) throws Exception {
        if (StringUtils.isEmpty(comCode)) {
            throw new DataVerifyException("机构代码不能为空！");
        }

        //创建总保额保费Dto接收返回值
        SumAmountAndPremiumDto sumAmountAndPremiumDto = new SumAmountAndPremiumDto();
        //根据机构代码查询下属机构代码
        Map<String,String> map=new HashMap<>();
        map.put("comCode",comCode);
        List<PrpDcompanyDto> prpDcompanyDtoList = prpDcompanyApi.querySubordinateCompany(map);
        //当前签单，保费收费日期必须为当天日期 add by:解明建 2018-05-23
        SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");
        Date date = new Date();
        String paydate = sf.format(date);
        //查询签单总保额，总保费
        //原生SQL
        StringBuilder comCodeSql1=new StringBuilder();
        StringBuilder comCodeSql2=new StringBuilder();
        StringBuilder sqlSingBill = new StringBuilder("select sum(sumAmount) as sumAmount ,sum(sumPremium) as sumPremium " +
                          "  from (select policyno, cm.sumnotaxpremium as sumpremium, sumamount " +
                          "  from prpcmainorigin cm " +
                          "  where underwriteflag in ('1', '3') " +
                          "  and systemflag = :systemFlag" +
                          "  and exists (select 1 from prpjpayrefrec ref where cm.policyno = ref.certino " +
                          "  and ref.payrefno is not null and ref.certitype = 'P'" +
                          "  and ref.payrefdate = to_date(:paydate,'yyyy-MM-dd'))" );
//                          "  and cm.isseefeeflag = '0' " +
//                          "  and cm.underwriteenddate = TRUNC(sysdate) ");

        if (prpDcompanyDtoList.size() > 0) {
            comCodeSql1.append(" AND cm.comCode in (");
            comCodeSql2.append(" AND pm.comCode in (");
        }else{
            comCodeSql1.append(" AND cm.comCode in ('"+comCode+"')");
            comCodeSql2.append(" AND pm.comCode in ('"+comCode+"')");
        }
        for (int i = 0; i < prpDcompanyDtoList.size(); i++) {
            //机构大于1000个 处理方式是 拼接 or comCode in ()
            if (i < 1000) {
                if (i == prpDcompanyDtoList.size() - 1 || i == 999) {
                    comCodeSql1.append("'" + prpDcompanyDtoList.get(i).getComCode() + "'");
                    comCodeSql2.append("'" + prpDcompanyDtoList.get(i).getComCode() + "'");
                } else {
                    comCodeSql1.append("'" + prpDcompanyDtoList.get(i).getComCode() + "'" + ",");
                    comCodeSql2.append("'" + prpDcompanyDtoList.get(i).getComCode() + "'" + ",");
                }
            } else if (i == 1000) {
                if (i == prpDcompanyDtoList.size() - 1) {
                    comCodeSql1.append(" ) OR cm.comCode In ( '" + prpDcompanyDtoList.get(i).getComCode() + "'");
                    comCodeSql2.append(" ) OR pm.comCode In ( '" + prpDcompanyDtoList.get(i).getComCode() + "'");
                } else {
                    comCodeSql1.append(" ) OR cm.comCode In ( '" + prpDcompanyDtoList.get(i).getComCode() + "',");
                    comCodeSql2.append(" ) OR pm.comCode In ( '" + prpDcompanyDtoList.get(i).getComCode() + "',");
                }
            } else {
                if (i == prpDcompanyDtoList.size() - 1) {
                    comCodeSql1.append(" '" + prpDcompanyDtoList.get(i).getComCode() + "'");
                    comCodeSql2.append(" '" + prpDcompanyDtoList.get(i).getComCode() + "'");
                } else {
                    comCodeSql1.append("'" + prpDcompanyDtoList.get(i).getComCode() + "',");
                    comCodeSql2.append("'" + prpDcompanyDtoList.get(i).getComCode() + "',");
                }
            }
        }
        if (prpDcompanyDtoList.size() > 0) {
            comCodeSql1.append(" ) ");
            comCodeSql2.append(" ) ");
        }
        sqlSingBill.append(comCodeSql1);
//        sqlSingBill.append( "  union all " +
//                         "  select ph.policyno, " +
//                         "  pm.chgpremium as sumpremium, " +
//                         "  pm.chgamount  as sumamount " +
//                         "  from prpphead ph, prppmain pm " +
//                         "  where pm.endorseno = ph.endorseno " +
//                         "  and ph.underwriteflag in ('1', '3') " +
//                         "  and pm.systemflag =:systemFlag " +
//                         "  and exists (select 1 from prpjpayrefrec ref where pm.endorseno = ref.certino and pm.policyno = ref.policyno " +
//                         "  and ref.payrefno is not null and ref.certitype = 'E'" +
//                         "  and ref.payrefdate = to_date(:paydate,'yyyy-MM-dd'))" );
////                         "  and ph.isseefeeflag = '0' ");
//        sqlSingBill.append(comCodeSql2);
        sqlSingBill.append(" ) ");

        //查询数据
        Query sumQuery1 = entityManager.createNativeQuery(sqlSingBill.toString());
        //设置参数
        sumQuery1.setParameter("systemFlag",systemFlag);
        sumQuery1.setParameter("paydate",paydate);
        //接收结果
        List<Object[]> singBillList = sumQuery1.getResultList();
        for(Object[] result:singBillList)

        {
            if (null != result[0]) {
                Double sumAmount = transFromMoney(Double.valueOf(result[0].toString()));
                sumAmountAndPremiumDto.setSumAmount(sumAmount);
            }
            if (null != result[1]) {
                Double sumPremium = transFromMoney(Double.valueOf(result[1].toString()));
                sumAmountAndPremiumDto.setSumPremium(sumPremium);
            }
        }

        //未缴费保单总保额，总保费
        // 原生SQL
        StringBuilder sqlUnpaidComcodeSql1=new StringBuilder();
        StringBuilder sqlUnpaidComcodeSql2=new StringBuilder();
        StringBuilder sqlUnpaid =new StringBuilder( " select sum(sumamount), sum(sumpremium)" +
                "  from (select policyno, cm.sumpremium, sumamount" +
                "  from prpcmainorigin cm " +
                "  where underwriteflag in ('1', '3' , '4') " +
                "  and systemflag = :systemFlag " +
                "  and not exists " +
                "  (select 1 " +
                "  from prpjpayrefrec j " +
                "  where j.certino = cm.policyno " +
                "  and j.policyno = cm.policyno " +
                "  and j.payrefdate is not null " +
                "  and j.payrefno is not null " +
                "  and certitype = 'P' " +
                "  and cm.systemflag =:systemFlag )");

//        if (prpDcompanyDtoList.size() > 0) {
//            sqlUnpaidComcodeSql1.append(" AND cm.comCode in (");
//            sqlUnpaidComcodeSql2.append(" AND pm.comCode in (");
//        }else{
//            sqlUnpaidComcodeSql1.append(" AND cm.comCode in ('"+comCode+"')");
//            sqlUnpaidComcodeSql2.append(" AND pm.comCode in ('"+comCode+"')");
//        }
//        for (int i = 0; i < prpDcompanyDtoList.size(); i++) {
//            //机构大于1000个 处理方式是 拼接 or comCode in ()
//            if (i < 1000) {
//                if (i == prpDcompanyDtoList.size() - 1 || i == 999) {
//                    sqlUnpaidComcodeSql1.append("'" + prpDcompanyDtoList.get(i).getComCode() + "'");
//                    sqlUnpaidComcodeSql2.append("'" + prpDcompanyDtoList.get(i).getComCode() + "'");
//                } else {
//                    sqlUnpaidComcodeSql1.append("'" + prpDcompanyDtoList.get(i).getComCode() + "'" + ",");
//                    sqlUnpaidComcodeSql2.append("'" + prpDcompanyDtoList.get(i).getComCode() + "'" + ",");
//                }
//            } else if (i == 1000) {
//                if (i == prpDcompanyDtoList.size() - 1) {
//                    sqlUnpaidComcodeSql1.append(" ) OR pm.comCode In ( '" + prpDcompanyDtoList.get(i).getComCode() + "'");
//                    sqlUnpaidComcodeSql2.append(" ) OR cm.comCode In ( '" + prpDcompanyDtoList.get(i).getComCode() + "'");
//                } else {
//                    sqlUnpaidComcodeSql1.append(" ) OR cm.comCode In ( '" +prpDcompanyDtoList.get(i).getComCode() + "',");
//                    sqlUnpaidComcodeSql2.append(" ) OR pm.comCode In ( '" +prpDcompanyDtoList.get(i).getComCode() + "',");
//                }
//            } else {
//                if (i == prpDcompanyDtoList.size() - 1) {
//                    sqlUnpaidComcodeSql1.append(" '" + prpDcompanyDtoList.get(i).getComCode() + "'");
//                    sqlUnpaidComcodeSql2.append(" '" + prpDcompanyDtoList.get(i).getComCode() + "'");
//                } else {
//                    sqlUnpaidComcodeSql1.append("'" + prpDcompanyDtoList.get(i).getComCode() + "',");
//                    sqlUnpaidComcodeSql2.append("'" + prpDcompanyDtoList.get(i).getComCode() + "',");
//                }
//            }
//        }
//        if (prpDcompanyDtoList.size() > 0) {
//            sqlUnpaidComcodeSql1.append(")");
//            sqlUnpaidComcodeSql2.append(")");
//        }
        sqlUnpaid.append(comCodeSql1);
//        sqlUnpaid.append("union all " +
//                "  select ph.policyno, " +
//                "  pm.chgpremium as sumpremium, " +
//                "  pm.chgamount as sumamount " +
//                "  from prpphead ph, prppmain pm " +
//                "  where pm.endorseno = ph.endorseno " +
//                "  and ph.underwriteflag in ('1', '3' , '4') " +
//                "  and pm.systemflag =:systemFlag " +
//                "  and not exists (select 1 " +
//                "  from prpjpayrefrec j   " +
//                "  where j.certino = pm.endorseno " +
//                "  and j.policyno = pm.policyno " +
//                "  and j.payrefdate is not null " +
//                "  and j.payrefno is not null " +
//                "  and certitype = 'E' " +
//                "  and pm.systemflag =:systemFlag) ");
//        sqlUnpaid.append(comCodeSql2);
        sqlUnpaid.append(" ) ");
        Query sumQuery2 = entityManager.createNativeQuery(sqlUnpaid.toString());
        //设置参数
        sumQuery2.setParameter("systemFlag",systemFlag);
        //接收结果
        List<Object[]> unpaidList = sumQuery2.getResultList();
        for(Object[] result:unpaidList){
            if (null != result[0]) {
                Double delinQuentFeeSumAmount = transFromMoney(Double.valueOf(result[0].toString()) );
                sumAmountAndPremiumDto.setDelinQuentFeeSumAmount(delinQuentFeeSumAmount);
            }
            if (null != result[1]) {
                Double delinQuentFeePremium = transFromMoney(Double.valueOf(result[1].toString()));
                sumAmountAndPremiumDto.setDelinQuentFeeSumPremium(delinQuentFeePremium);//未繳保費
            }

        }

        //应收保费总保额，总保费
        //应收保费指的是已投保成功，且自缴已完成，财政补贴尚未收取的保单  modify by:解明建 2018-05-23
        //配置文件读取的数据转换成List
        List<String> subsidyPayType = Arrays.asList(subsidy.split(","));//缴费原因：政府补贴
        //原生SQL
        StringBuilder sqlReceivableComcodeSql1=new StringBuilder();
        StringBuilder sqlReceivableComcodeSql2=new StringBuilder();
        StringBuilder sqlReceivable =new StringBuilder( " select sum(sumamount), sum(sumpremium) " +
                "   from (select policyno, cm.sumnotaxpremium as sumpremium, sumamount " +
                "   from prpcmainorigin cm " +
                "   where exists (select 1 from prpcplan plan where cm.policyno = plan.policyno " +
                "   and plan.endorseno is null and plan.payreason in (:payType) and plan.delinquentfee > 0)" +
                "   and exists (select 1 " +
                "   from prpjpayrefrec j" +
                "   where j.certino = cm.policyno " +
                "   and j.policyno = cm.policyno " +
                "   and j.payrefdate is not null " +
                "   and j.payrefno is not null " +
                "   and certitype = 'P' " +
                "   and cm.systemflag =:systemFlag) "+
                "   and cm.underwriteflag in ('1', '3') "
        );

//        if (prpDcompanyDtoList.size() > 0) {
//            sqlReceivableComcodeSql1.append(" AND cm.comCode in (");
//            sqlReceivableComcodeSql2.append(" AND pm.comCode in (");
//        }else{
//            sqlReceivableComcodeSql1.append(" AND cm.comCode in ('"+comCode+"') ");
//            sqlReceivableComcodeSql2.append(" AND pm.comCode in ('"+comCode+"') ");
//        }
//        for (int i = 0; i < prpDcompanyDtoList.size(); i++) {
//            //机构大于1000个 处理方式是 拼接 or comCode in ()
//            if (i < 1000) {
//                if (i == prpDcompanyDtoList.size() - 1 || i == 999) {
//                    sqlReceivableComcodeSql1.append("'" + prpDcompanyDtoList.get(i).getComCode() + "'");
//                    sqlReceivableComcodeSql2.append("'" + prpDcompanyDtoList.get(i).getComCode() + "'");
//                } else {
//                    sqlReceivableComcodeSql1.append("'" + prpDcompanyDtoList.get(i).getComCode() + "'" + ",");
//                    sqlReceivableComcodeSql2.append("'" + prpDcompanyDtoList.get(i).getComCode() + "'" + ",");
//                }
//            } else if (i == 1000) {
//                if (i == prpDcompanyDtoList.size() - 1) {
//                    sqlReceivableComcodeSql1.append(" ) OR cm.comCode In ( '" +prpDcompanyDtoList.get(i).getComCode() + "'");
//                    sqlReceivableComcodeSql2.append(" ) OR pm.comCode In ( '" +prpDcompanyDtoList.get(i).getComCode() + "'");
//                } else {
//                    sqlReceivableComcodeSql1.append(" ) OR cm.comCode In ( '" + prpDcompanyDtoList.get(i).getComCode() + "',");
//                    sqlReceivableComcodeSql2.append(" ) OR pm.comCode In ( '" + prpDcompanyDtoList.get(i).getComCode() + "',");
//                }
//            } else {
//                if (i == prpDcompanyDtoList.size() - 1) {
//                    sqlReceivableComcodeSql1.append(" '" + prpDcompanyDtoList.get(i).getComCode() + "'");
//                    sqlReceivableComcodeSql2.append(" '" + prpDcompanyDtoList.get(i).getComCode() + "'");
//                } else {
//                    sqlReceivableComcodeSql1.append("'" + prpDcompanyDtoList.get(i).getComCode() + "',");
//                    sqlReceivableComcodeSql2.append("'" + prpDcompanyDtoList.get(i).getComCode() + "',");
//                }
//            }
//        }
//        if (prpDcompanyDtoList.size() > 0) {
//            sqlReceivableComcodeSql1.append(")");
//            sqlReceivableComcodeSql2.append(")");
//        }
//        sqlReceivable.append(sqlReceivableComcodeSql1);
        sqlReceivable.append(comCodeSql1);
//        sqlReceivable.append(
//                " union all " +
//                " select ph.policyno, " +
//                " pm.chgnotaxpremium as sumpremium, " +
//                " pm.chgamount       as sumamount " +
//                " from prpphead ph, prppmain pm " +
//                " where pm.endorseno = ph.endorseno " +
//                " and exists (select 1 from prpcplan plan where ph.endorseno = plan.endorseno " +
//                " and plan.endorseno is not null and plan.payreason in (:payType) and plan.delinquentfee > 0)" +
//                " and exists (select 1 " +
//                " from prpjpayrefrec j, prpcmainorigin cm " +
//                " where j.certino = pm.endorseno " +
//                " and j.policyno = cm.policyno " +
//                " and j.payrefdate is not null " +
//                " and j.payrefno is not null " +
//                " and certitype = 'E' " +
//                " and cm.systemflag =:systemFlag) ");
////        sqlReceivable.append(sqlReceivableComcodeSql2);
//        sqlReceivable.append(comCodeSql2);
//        sqlReceivable.append("and ph.underwriteflag in ('1', '3') " +
//                " and pm.systemflag =:systemFlag) ");
        sqlReceivable.append(")");
        //查询结果
        Query sumQuery3 = entityManager.createNativeQuery(sqlReceivable.toString());
        //设置参数
        sumQuery3.setParameter("payType",subsidyPayType);
        sumQuery3.setParameter("systemFlag",systemFlag);
        //接收结果
        List<Object[]> receivableList = sumQuery3.getResultList();
        for( Object[] result:receivableList){
            if (null != result[0]) {
                Double unpaidSumAmount = transFromMoney(Double.valueOf(result[0].toString()));
                sumAmountAndPremiumDto.setUnpaidSumAmount(unpaidSumAmount);
            }
            if (null != result[1]) {
                Double unpaidSumPremium = transFromMoney(Double.valueOf(result[1].toString()));
                sumAmountAndPremiumDto.setUnpaidSumPremium(unpaidSumPremium);
            }
        }
        return sumAmountAndPremiumDto;
    }

    /**
     * 将保额保费取到万位，并进行四舍五入
     * @author: 刘曼曼
     * @date: 2017/11/21 9:13
     * @param money
     * @return
     */
    public Double transFromMoney(Double money){
        double sumMoney= new BigDecimal(money/10000).setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
        return sumMoney;
    }

    /**
     * 业务清单查询导出Excel
     *
     * @param classCode 险类代码
     * @param listType  清单类型
     * @param startDate 开始日期
     * @param endDate   结束日期
     * @return shortLink 文件下载短链接
     * @throws Exception
     * @author: 何伟东
     * @date: 2017/11/23 16:41
     */
    @Override
    public String businessListExportExcel(String classCode, String listType, String startDate, String endDate) throws Exception {
        RequestBusinessListDto businessListDto = new RequestBusinessListDto();
        businessListDto.setClassCode(classCode);
        businessListDto.setListType(listType);
        businessListDto.setStartDate(startDate);
        businessListDto.setEndDate(endDate);
        businessListDto.setPageNo(-1);
        //调用查询接口
        PageInfo<ResponseBusinessListDto> pageInfo = this.queryBusinessListByCondition(businessListDto);
        List<ResponseBusinessListDto> businessListDtoList = pageInfo.getContent();
        String shortLinkId;
        String titleName = "";
        String excelName = "";
        // 采用反射的方式动态修改注解内容
        Class<ResponseBusinessListDto> businessListClass = ResponseBusinessListDto.class;
        if (listType.equals("D")) {
            // 当日清单通过动态修改注解的方式屏蔽delinQuentFee字段为不导出到Excel
            POIUtils.modfiyAnnotationKey(businessListClass, "delinQuentFee", "enabled", false);
            // 通过动态修改注解的方式修改planFee字段为导出到Excel
            POIUtils.modfiyAnnotationKey(businessListClass, "planFee", "enabled", true);
            excelName = titleName = "国元保险业务清单（当日清单）";
        } else if (listType.equals("S")) {
            POIUtils.modfiyAnnotationKey(businessListClass, "delinQuentFee", "enabled", true);
            POIUtils.modfiyAnnotationKey(businessListClass, "planFee", "enabled", false);
            POIUtils.modfiyAnnotationKey(businessListClass, "delinQuentFee", "value", "应收保费");
            excelName = titleName = "国元保险业务清单（应收保费清单）";
        } else if (listType.equals("W")) {
            POIUtils.modfiyAnnotationKey(businessListClass, "delinQuentFee", "enabled", true);
            POIUtils.modfiyAnnotationKey(businessListClass, "planFee", "enabled", false);
            POIUtils.modfiyAnnotationKey(businessListClass, "delinQuentFee", "value", "未缴保险费");
            excelName = titleName = "国元保险业务清单（未缴费保单）";
        }
        for (int i = 0; i < businessListDtoList.size(); i++) {
            businessListDtoList.get(i).setId(i + 1);
        }
        File file = null;
        try {
            file = new QuicklyExportExcel().quicklyExport(exportExcelType, excelName, titleName, titleName, businessListDtoList, 1, 8, businessListClass);
            shortLinkId = new FileUtil().uploadFile(fileServiceUrl, file, SinoRequestContext.getCurrentContext().getUserCode(), "agri/tempfile", "agriprpall_BusinessList");
        } finally {
            // 删除本地的临时文件
            if (file != null) {
                file.delete();
            }
        }
        return shortLinkId;
    }
}

