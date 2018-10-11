package com.sinosoft.agriprpall.core.policymanage.service.impl;

import com.sinosoft.agriprpall.api.policymanage.dto.QueryMyJobCountDto;
import com.sinosoft.agriprpall.api.policymanage.dto.RequestMyJobDto;
import com.sinosoft.agriprpall.api.policymanage.dto.ResponseMyJobDto;
import com.sinosoft.agriprpall.core.policymanage.service.QueryMyJobService;
import com.sinosoft.framework.agri.core.constant.LanguageFlagConstant;
import com.sinosoft.framework.core.service.impl.BaseServiceImpl;
import com.sinosoft.framework.core.utils.StringUtils;
import com.sinosoft.framework.dto.PageInfo;
import com.sinosoft.framework.exception.DataVerifyException;
import com.sinosoft.ims.api.kernel.PrpDuserApi;
import com.sinosoft.pms.api.kernel.PrpDriskApi;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**(我的任务查询)
 * @Author: 刘曼曼
 * @Date: 2017/11/14 15:09
 */
@Service
@Transactional
public class QueryMyJobServiceImpl extends BaseServiceImpl implements QueryMyJobService {
    /** log日志 */
    private static final Logger LOGGER = LoggerFactory.getLogger(QueryMyJobServiceImpl.class);
    @Autowired
    private EntityManager entityManager;

    @Autowired
    private PrpDriskApi prpDriskApi;

    @Autowired
    private PrpDuserApi prpDuserApi;

    @Value("${sysconfig.common.systemFlag}")
    private String systemFlag;//新农险标识（prptmian表中的systemflag,用于区分新农险系统与老系统的数据）

    /**
     * 我的任务条件分页查询
     * @author: 刘曼曼
     * @date: 2017/11/14 18:08
     * @param requestMyJobDto 查询所需数据Dto
     * @return PageInfo<ResponseMyJobDto> 暂存单，投保单，保单，批单返回数据的Dto 集合
     * @throws Exception
     */
    @Override
    public PageInfo<ResponseMyJobDto> queryMyJobByCondition(RequestMyJobDto requestMyJobDto)throws Exception{
        if(StringUtils.isEmpty(requestMyJobDto.getUserCode())) {
            throw new DataVerifyException("用户名不能为空");
        }
        if(StringUtils.isEmpty(requestMyJobDto.getQueryFlag())){
            throw new DataVerifyException("业务类型标识符不能为空");
        }
        if (requestMyJobDto.getPageNo() < 1) {
            throw new DataVerifyException("页码不能小于1");
        }
        if (requestMyJobDto.getPageSize() < 1) {
            throw new DataVerifyException("每页数量不能小于1");
        }
        StringBuilder dataSql = new StringBuilder();
        StringBuilder countSql= new StringBuilder ();
        StringBuilder strSql= new StringBuilder ();
        if(requestMyJobDto.getQueryFlag().equals("1")){
            //待处理暂存单查询 原生SQL
            dataSql.append(" SELECT t.proposalno AS businessNo " +
                            " ,t.riskcode " +
                            " ,'暂存单' AS businessType " +
                            " ,t.startDate " +
                            " ,t.insuredName " +
                            " ,t.operatorcode " +
                            " ,t.operateDate " +
                            " ,'待保存' AS status " +
                            " ,t.endDate "+
                            " ,t.appliName " +
                            " ,t.businessType1 "+
                            " ,t.printNo "+
                            " FROM prpTmain t " +
                            " WHERE t.underwriteFlag = '8' " +
                            " AND t.classCode in ('31','32') "+
                            " and t.systemFlag=:systemFlag "+
                            " AND t.operatorCode =:userCode  " +
                            " AND substr(t.othflag,4,1)<> '2' ");
            countSql.append(" SELECT COUNT(1) " +
                            " FROM prpTmain t  " +
                            " WHERE t.underwriteFlag = '8' " +
                            " AND t.classCode in ('31','32') "+
                            " and t.systemFlag=:systemFlag "+
                            " AND t.operatorCode =:userCode " +
                           " AND substr(t.othflag,4,1)<> '2' " );
            if(StringUtils.isNotEmpty(requestMyJobDto.getBusinessNo())){
                dataSql.append(" AND t.proposalno like :businessNo ");
                countSql.append(" AND t.proposalno like :businessNo ");
            }
//            if(StringUtils.isNotEmpty(requestMyJobDto.getStatus())){
//                dataSql.append(" and t.underwriteFlag=:status ");
//                countSql.append(" and t.underwriteFlag=:status ");
//            }
            if(StringUtils.isNotEmpty(requestMyJobDto.getStatus())&&!"0".equals(requestMyJobDto.getStatus())){
                if("1".equals(requestMyJobDto.getStatus())){
                    dataSql.append(" and t.underwriteFlag= '0' ");
                    countSql.append(" and t.underwriteFlag= '0' ");
                }else if("2".equals(requestMyJobDto.getStatus())){
                    dataSql.append(" and t.underwriteFlag= '2' ");
                    countSql.append(" and t.underwriteFlag= '2' ");
                }else if("3".equals(requestMyJobDto.getStatus())){
                    dataSql.append(" and t.printNo IS NULL ");
                    countSql.append(" and t.printNo IS NULL ");
                }else if("4".equals(requestMyJobDto.getStatus())){
                    dataSql.append(" and t.underwriteFlag= '8'  ");
                    countSql.append(" and t.underwriteFlag= '8'  ");
                }
            }
            dataSql.append(" order by t.proposalno desc ");
            countSql.append(" order by t.proposalno desc  ");
        }else if(requestMyJobDto.getQueryFlag().equals("2")){
            //待处理投保单查询 原生SQL
            dataSql.append(" SELECT t.proposalno AS businessNo " +
                            " ,t.riskcode " +
                            " ,'投保单' AS businessType " +
                            " ,t.startDate " +
                            " ,t.insuredName " +
                            " ,t.operatorcode " +
                            " ,t.operateDate " +
                            " ,DECODE(t.underwriteFlag,'0','待提交核保','2','核保退回待修改','1','核保通过') AS status " +
                            " ,t.endDate "+
                            " ,t.appliName " +
                            " ,t.businessType1 "+
                            " ,t.printNo "+
                            " FROM prpTmain t " +
                            " WHERE t.underwriteFlag in ('0','2','1') " +
                            " and t.printNo IS NULL  "+
                            " AND t.classCode in ('31','32') "+
                            " and t.systemFlag=:systemFlag "+
                            " AND t.operatorCode =:userCode " +
                            " AND substr(t.othflag,4,1)<> '2' ");
            countSql.append(" SELECT COUNT(1) " +
                            " FROM prpTmain t  " +
                            " WHERE t.underwriteFlag in ('0','2','1') " +
                            " and t.printNo IS NULL "+
                            " AND t.classCode in ('31','32') "+
                            " and t.systemFlag=:systemFlag "+
                            " AND t.operatorCode =:userCode "+
                            " AND substr(t.othflag,4,1)<> '2'  ");
            if(StringUtils.isNotEmpty(requestMyJobDto.getBusinessNo())){
                  dataSql.append(" AND t.proposalno  like :businessNo ");
                  countSql.append(" AND t.proposalno like :businessNo ");
                }

            if(StringUtils.isNotEmpty(requestMyJobDto.getStatus())&&!"0".equals(requestMyJobDto.getStatus())){
                if("1".equals(requestMyJobDto.getStatus())){//待提交核保
                    dataSql.append(" and t.underwriteFlag= '0' ");
                    countSql.append(" and t.underwriteFlag= '0' ");
                }else if("2".equals(requestMyJobDto.getStatus())){//核保退回待修改
                    dataSql.append(" and t.underwriteFlag= '2' ");
                    countSql.append(" and t.underwriteFlag= '2' ");
                }else if("5".equals(requestMyJobDto.getStatus())){//待打印前端传的是5
                    dataSql.append(" and t.printNo IS NULL  ");
                    countSql.append(" and t.printNo IS NULL ");
                }else if("4".equals(requestMyJobDto.getStatus())){
                    dataSql.append(" and t.underwriteFlag= '8'  ");
                    countSql.append(" and t.underwriteFlag= '8'  ");
                }
            }

            dataSql.append(" order by t.proposalno desc ");
            countSql.append(" order by t.proposalno desc   ");

        }else if(requestMyJobDto.getQueryFlag().equals("3")){
            //待处理保单查询　原生SQL
            dataSql.append(" SELECT t.policyNo AS businessNo " +
                            " ,t.riskcode " +
                            " ,'保单' AS businessType " +
                            " ,t.startDate " +
                            " ,t.insuredName " +
                            " ,t.operatorcode " +
                            " ,t.operateDate " +
                            " ,'待打印' AS status " +
                            " ,t.endDate "+
                            " ,t.appliName "+
                            " ,t.businessType1 "+
                            " ,t.printNo "+
                            " FROM prpCmain t " +
                            " WHERE t.underwriteFlag in ('1','3') " +
                            " AND t.printNo IS NULL " +
                            " AND t.classCode in ('31','32') " +
                            " and t.systemFlag=:systemFlag "+
                            " AND t.operatorCode =:userCode " );
            countSql.append("SELECT COUNT(1) " +
                            " FROM prpCmain t " +
                            " WHERE t.underwriteFlag in ('1','3') " +
                            " AND t.printNo IS NULL " +
                            " AND t.classCode in ('31','32') " +
                            " and t.systemFlag=:systemFlag "+
                            " AND t.operatorCode =:userCode ");
            if(StringUtils.isNotEmpty(requestMyJobDto.getBusinessNo())){
                dataSql.append(" AND t.policyNo like :businessNo ");
                countSql.append(" AND t.policyNo like :businessNo ");
            }

//            if(StringUtils.isNotEmpty(requestMyJobDto.getStatus())){
//                dataSql.append(" and t.underwriteFlag=:status ");
//                countSql.append(" and t.underwriteFlag=:status ");
//            }
            if(StringUtils.isNotEmpty(requestMyJobDto.getStatus())&&!"0".equals(requestMyJobDto.getStatus())){
                if("1".equals(requestMyJobDto.getStatus())){
                    dataSql.append(" and t.underwriteFlag= '0' ");
                    countSql.append(" and t.underwriteFlag= '0' ");
                }else if("2".equals(requestMyJobDto.getStatus())){
                    dataSql.append(" and t.underwriteFlag= '2' ");
                    countSql.append(" and t.underwriteFlag= '2' ");
                }else if("5".equals(requestMyJobDto.getStatus())){
                    dataSql.append(" and t.printNo IS NULL ");
                    countSql.append(" and t.printNo IS NULL ");
                }else if("4".equals(requestMyJobDto.getStatus())){
                    dataSql.append(" and t.underwriteFlag= '8'  ");
                    countSql.append(" and t.underwriteFlag= '8'  ");
                }
            }

            dataSql.append(" order by t.policyNo desc ");
            countSql.append(" order by t.policyNo desc ");

        }else if(requestMyJobDto.getQueryFlag().equals("4")){
            //待处理批单查询方法 原生SQL
            dataSql.append(" SELECT ph.endorseNo AS businessNo " +
                            " ,pm.riskcode " +
                            " ,'批单' AS businessType " +
                            " ,pm.startDate " +
                            " ,pm.insuredName " +
                            " ,ph.operatorcode " +
                            " ,pm.operateDate " +
                            " ,DECODE(ph.underwriteFlag,'0','待提交核批','2','核批退回待修改','1','核批通过') AS status " +
                            " ,pm.endDate "+
                            " ,pm.appliName "+
                            " ,pm.businessType1 "+
                            " ,pm.printNo "+
                            " FROM prpPhead ph " +
                            " ,prpPmain pm " +
                            " WHERE ph.endorseNo = pm.endorseNo " +
                            " AND ph.underwriteFlag in ('0','2','1') " +
                            " and pm.printNo IS NULL "+
                            " AND pm.classCode in ('31','32') "+
                            " and pm.systemFlag=:systemFlag "+
                            " AND ph.operatorCode =:userCode ");
            countSql.append(" SELECT　COUNT(1) " +
                            " FROM prpPhead ph " +
                            " ,prpPmain pm " +
                            " WHERE ph.endorseNo = pm.endorseNo " +
                            " AND ph.underwriteFlag in ('0','2','1') " +
                            " and pm.printNo IS NULL "+
                            " AND pm.classCode in ('31','32') " +
                            " and pm.systemFlag=:systemFlag "+
                            " AND ph.operatorCode =:userCode ");
            if(StringUtils.isNotEmpty(requestMyJobDto.getBusinessNo())){
                dataSql.append(" AND ph.endorseNo like :businessNo ");
                countSql.append(" AND ph.endorseNo like :businessNo ");
            }
//            if(StringUtils.isNotEmpty(requestMyJobDto.getStatus())){
//                dataSql.append(" and ph.underwriteFlag=:status ");
//                countSql.append(" and ph.underwriteFlag=:status ");
//            }
            if(StringUtils.isNotEmpty(requestMyJobDto.getStatus())&&!"0".equals(requestMyJobDto.getStatus())){
                if("3".equals(requestMyJobDto.getStatus())){//前端传的状态是3，待核批
                    dataSql.append(" and ph.underwriteFlag= '0' ");
                    countSql.append(" and ph.underwriteFlag= '0' ");
                }else if("4".equals(requestMyJobDto.getStatus())){//核批退回待修改
                    dataSql.append(" and ph.underwriteFlag= '2' ");
                    countSql.append(" and ph.underwriteFlag= '2' ");
                }else if("5".equals(requestMyJobDto.getStatus())){
                    dataSql.append(" and pm.printNo IS NULL ");
                    countSql.append(" and pm.printNo IS NULL ");
                }else if("7".equals(requestMyJobDto.getStatus())){
                    dataSql.append(" and ph.underwriteFlag= '8' ");
                    countSql.append(" and ph.underwriteFlag= '8' ");
                }
            }
            dataSql.append(" order by ph.endorseNo desc ");
            countSql.append(" order by ph.endorseNo desc ");
        }else{//查询全部
            strSql.append(" SELECT t.proposalno AS businessNo " +
                            " ,t.riskcode " +
                            " ,'暂存单' AS businessType " +
                            " ,t.startDate " +
                            " ,t.insuredName " +
                            " ,t.operatorcode " +
                            " ,t.operateDate " +
                            " ,'待保存' AS status " +
                            " ,t.endDate "+
                            " ,t.appliName "+
                            " ,t.businessType1 "+
                            " ,t.printNo "+
                            " FROM prpTmain t " +
                            " WHERE t.underwriteFlag = '8' " +
                            " AND t.classCode in ('31','32') "+
                            " and t.systemFlag=:systemFlag "+
                            " AND t.operatorCode =:userCode " +
                            " AND substr(t.othflag,4,1)<> '2' ");
            if(StringUtils.isNotEmpty(requestMyJobDto.getBusinessNo())){
                strSql.append(" AND t.proposalno like :businessNo ");
            }
            if(StringUtils.isNotEmpty(requestMyJobDto.getStatus())&&!"0".equals(requestMyJobDto.getStatus())){
                if("1".equals(requestMyJobDto.getStatus())){
                    strSql.append(" and t.underwriteFlag= '0' ");
                }else if("2".equals(requestMyJobDto.getStatus())){
                    strSql.append(" and t.underwriteFlag= '2' ");
                }else if("3".equals(requestMyJobDto.getStatus())){
                    strSql.append(" and t.printNo IS NULL ");
                }else if("4".equals(requestMyJobDto.getStatus())){
                    strSql.append(" and t.underwriteFlag= '8' ");
                }
            }
            strSql.append(" union all " +
                            "SELECT t.proposalno AS businessNo " +
                            " ,t.riskcode " +
                            " ,'投保单' AS businessType " +
                            " ,t.startDate " +
                            " ,t.insuredName " +
                            " ,t.operatorcode " +
                            " ,t.operateDate " +
                            " ,DECODE(t.underwriteFlag,'0','待提交核保','2','核保退回待修改','1','核保通过') AS status " +
                            " ,t.endDate "+
                            " ,t.appliName "+
                            " ,t.businessType1 "+
                            " ,t.printNo "+
                            " FROM prpTmain t " +
                            " WHERE t.underwriteFlag in ('0','2','1') " +
                            " and t.printNo IS NULL "+
                            " AND t.classCode in ('31','32') "+
                            " and t.systemFlag=:systemFlag "+
                            " AND t.operatorCode =:userCode " +
                            " AND substr(t.othflag,4,1)<> '2'  ");
            if(StringUtils.isNotEmpty(requestMyJobDto.getBusinessNo())){
                strSql.append(" AND t.proposalno  like :businessNo ");
            }
            if(StringUtils.isNotEmpty(requestMyJobDto.getStatus())&&!"0".equals(requestMyJobDto.getStatus())){
                if("1".equals(requestMyJobDto.getStatus())){
                    strSql.append(" and t.underwriteFlag= '0' ");
                }else if("2".equals(requestMyJobDto.getStatus())){
                    strSql.append(" and t.underwriteFlag= '2' ");
                }else if("3".equals(requestMyJobDto.getStatus())){
                    strSql.append(" and t.printNo IS NULL ");
                }else if("4".equals(requestMyJobDto.getStatus())){
                    strSql.append(" and t.underwriteFlag= '8'  ");
                }
            }
            strSql.append(" union all " +
                            " SELECT t.policyNo AS businessNo " +
                            " ,t.riskcode " +
                            " ,'保单' AS businessType " +
                            " ,t.startDate " +
                            " ,t.insuredName " +
                            " ,t.operatorcode " +
                            " ,t.operateDate " +
                            " ,'待打印' AS status " +
                            " ,t.endDate "+
                            " ,t.appliName "+
                            " ,t.businessType1 "+
                            " ,t.printNo "+
                            " FROM prpCmain t " +
                            " WHERE t.underwriteFlag in ('1','3','2') " +
                            " AND t.printNo IS NULL " +
                            " AND t.classCode in ('31','32') " +
                            " and t.systemFlag=:systemFlag "+
                            " AND t.operatorCode =:userCode ");
            if(StringUtils.isNotEmpty(requestMyJobDto.getBusinessNo())){
                strSql.append(" AND t.policyNo like :businessNo ");
            }
            if(StringUtils.isNotEmpty(requestMyJobDto.getStatus())&&!"0".equals(requestMyJobDto.getStatus())){
                if("1".equals(requestMyJobDto.getStatus())){
                    strSql.append(" and t.underwriteFlag= '0' ");
                }else if("2".equals(requestMyJobDto.getStatus())){
                    strSql.append(" and t.underwriteFlag= '2' ");
                }else if("3".equals(requestMyJobDto.getStatus())){
                    strSql.append(" and t.printNo IS NULL ");
                }else if("4".equals(requestMyJobDto.getStatus())){
                    strSql.append(" and t.underwriteFlag= '8'  ");
                }
            }
            strSql.append(" union all " +
                             " SELECT ph.endorseNo AS businessNo " +
                            " ,pm.riskcode " +
                            " ,'批单' AS businessType " +
                            " ,pm.startDate " +
                            " ,pm.insuredName " +
                            " ,ph.operatorcode " +
                            " ,pm.operateDate " +
                            " ,DECODE(ph.underwriteFlag,'0','待提交核批','2','核批退回待修改','1','核批通过') AS status " +
                            " ,pm.endDate "+
                            " ,pm.appliName "+
                            " ,pm.businessType1 "+
                            " ,t.printNo "+
                            " FROM prpPhead ph " +
                            " ,prpPmain pm " +
                            " WHERE ph.endorseNo = pm.endorseNo " +
                            " AND ph.underwriteFlag in ('0','2','1') " +
                            " and pm.printNo IS NULL "+
                            " AND pm.classCode in ('31','32') "+
                            " and pm.systemFlag=:systemFlag "+
                            " AND ph.operatorCode =:userCode ");
            if(StringUtils.isNotEmpty(requestMyJobDto.getBusinessNo())){
                strSql.append(" AND ph.endorseNo like :businessNo ");
            }
            if(StringUtils.isNotEmpty(requestMyJobDto.getStatus())&&!"0".equals(requestMyJobDto.getStatus())){
                if("1".equals(requestMyJobDto.getStatus())){
                    strSql.append(" and ph.underwriteFlag= '0' ");
                }else if("2".equals(requestMyJobDto.getStatus())){
                    strSql.append(" and ph.underwriteFlag= '2' ");
                }else if("3".equals(requestMyJobDto.getStatus())){
                    strSql.append(" and pm.printNo IS NULL ");
                }else if("4".equals(requestMyJobDto.getStatus())){
                    strSql.append(" and ph.underwriteFlag= '8'  ");
                }
            }
            dataSql.append("select * from ( ").append(strSql).append(" ) order by businessNo ");
            countSql.append("select count(1) from ( ").append(strSql).append(" ) ");
        }

        //查询数据
        Query dataQuery = entityManager.createNativeQuery(dataSql.toString());
        Query countQuery = entityManager.createNativeQuery(countSql.toString());
        //查询数据总条数
        //设置参数
        dataQuery.setParameter("userCode",requestMyJobDto.getUserCode());
        dataQuery.setParameter("systemFlag",systemFlag);
        countQuery.setParameter("userCode",requestMyJobDto.getUserCode());
        countQuery.setParameter("systemFlag",systemFlag);
        //业务单号不为空时设置业务单号参数
        if(StringUtils.isNotEmpty(requestMyJobDto.getBusinessNo())){
            dataQuery.setParameter("businessNo",requestMyJobDto.getBusinessNo()+"%");
            countQuery.setParameter("businessNo",requestMyJobDto.getBusinessNo()+"%");
        }
//        if(StringUtils.isNotEmpty(requestMyJobDto.getStatus())&&!"0".equals(requestMyJobDto.getStatus())){
//            dataQuery.setParameter("status",requestMyJobDto.getStatus());
//            countQuery.setParameter("status",requestMyJobDto.getStatus());
//        }

        //接收数据
        Long countNum =Long.valueOf(countQuery.getSingleResult().toString());
        dataQuery.setFirstResult((requestMyJobDto.getPageNo()-1)*requestMyJobDto.getPageSize());//从第几条开始查
        dataQuery.setMaxResults(requestMyJobDto.getPageSize());//查的条数

        List<Object []> list = new ArrayList<>();
        List<ResponseMyJobDto> responseMyJobDtoList = new ArrayList<>();
        list=dataQuery.getResultList();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        for(Object [] obj : list){
            ResponseMyJobDto responseMyJobDto =new ResponseMyJobDto();
            responseMyJobDto.setBusinessNo(obj[0].toString());
            responseMyJobDto.setRiskCode(obj[1].toString());
            Map<String,String> map1 =new HashMap<>();
            String riskName="";
            if(StringUtils.isNotEmpty(obj[1].toString())){
                map1.put("riskCode",obj[1].toString());
                map1.put("isChinese",LanguageFlagConstant.CHINESE);
                riskName = prpDriskApi.translateCode(map1);
            }
            responseMyJobDto.setRiskName(riskName);
            if(obj[2]!=null){
                responseMyJobDto.setBusinessType(obj[2].toString());
            }
            if(obj[3]!=null){
                responseMyJobDto.setStartDate(sdf.parse(obj[3].toString()));
            }
            if(obj[4]!=null){
                responseMyJobDto.setInsuredName(obj[4].toString());
            }
            if(obj[5]!=null){
                responseMyJobDto.setOperatorCode(obj[5].toString());
            }
            Map<String,String> map=new HashMap<>();
            String userName="";
            if(StringUtils.isNotEmpty(obj[5].toString())){
                map.put("userCode",obj[5].toString());
                map.put("isChinese",LanguageFlagConstant.CHINESE);
                userName=prpDuserApi.translateCode(map);
            }
            responseMyJobDto.setOperatorName(userName);
            if(obj[6]!=null){
                responseMyJobDto.setOperateDate(sdf.parse(obj[6].toString()));
            }
            if(obj[7]!=null){
                responseMyJobDto.setStatus(obj[7].toString());
            }
            if(obj[8]!=null){
                responseMyJobDto.setEndDate(sdf.parse(obj[8].toString()));
            }
            if(obj[9]!=null){
                responseMyJobDto.setAppliName(obj[9].toString());
            }
            if(obj[10]!=null){
                responseMyJobDto.setBusinessType1(obj[10].toString());
            }
            if(obj[11]==null){
                responseMyJobDto.setPrintNo("");
            }else{
                responseMyJobDto.setPrintNo(obj[11].toString());
            }
            responseMyJobDtoList.add(responseMyJobDto);
        }
        //根据操作员代码查询操作员名称
//        List<String> listUserCode = new ArrayList<String>();
//        for(ResponseMyJobDto responseMyJobDto : responseMyJobDtoList){
//            listUserCode.add(responseMyJobDto.getOperatorCode());
//        }
//        //把查询到的操作员名称放到responseMyJobDtoList集合中
//        if(listUserCode.size()>0){
//            List<String> operatorNames= prpDuserApi.queryOperatorName(listUserCode);
//            for(int i=0;i<operatorNames.size();i++){
//                String operatorName=operatorNames.get(i);
//                responseMyJobDtoList.get(i).setOperatorName(operatorName);
//            }
//        }
        // 统一封装分页响应dto
        PageInfo<ResponseMyJobDto> pageInfo = new PageInfo<>();
        pageInfo.setContent(responseMyJobDtoList);
        pageInfo.setPages(requestMyJobDto.getPageNo());
        pageInfo.setTotalCount(countNum);
        return pageInfo;
    }

    /**
     * 查询待处理暂存单，待处理投保单，待处理保单，待处理批单总条数
     * @author: 刘曼曼
     * @date: 2017/11/19 11:48
     * @param userCode 用户代码
     * @return QueryMyJobCountDto 总条数Dto
     * @throws Exception
     */
    @Override
    public QueryMyJobCountDto queryMyJobByCount(String userCode)throws Exception{

        //待处理暂存单总条数  原生SQL
        StringBuilder tempProposalSql=new StringBuilder(" SELECT COUNT(1) " +
                                                        " FROM prpTmain t  " +
                                                        " WHERE t.underwriteFlag = '8' " +
                                                        " AND t.classCode in ('31','32') "+
                                                        " and t.systemFlag=:systemFlag "+
                                                        " AND t.operatorCode =:userCode ");
        //待处理投保单总条数   原生SQL
        StringBuilder proposalSql=new StringBuilder(" SELECT COUNT(1) " +
                                                    " FROM prpTmain t  " +
                                                    " WHERE t.underwriteFlag in ('0','2','1') " +
                                                    " AND t.printNo IS NULL " +
                                                    " AND t.classCode in ('31','32') "+
                                                    " and t.systemFlag=:systemFlag "+
                                                    " AND t.operatorCode =:userCode ");
        //待处理保单总条数  原生SQL
        StringBuilder policysql=new StringBuilder("SELECT COUNT(1) " +
                                                    " FROM prpCmain t " +
                                                    " WHERE t.underwriteFlag in ('1','3') " +
                                                    " AND t.printNo IS NULL " +
                                                    " AND t.classCode in ('31','32') " +
                                                    " and t.systemFlag=:systemFlag "+
                                                    " AND t.operatorCode =:userCode ");
        //待处理批单总条数 原生SQL
        StringBuilder endorsSql=new StringBuilder(" SELECT　COUNT(1) " +
                                                    " FROM prpPhead ph " +
                                                    " ,prpPmain pm " +
                                                    " WHERE ph.endorseNo = pm.endorseNo " +
                                                    " AND ph.underwriteFlag in ('0','2','1') " +
                                                    " AND pm.classCode in ('31','32') "+
                                                    " AND pm.printNo IS NULL " +
                                                    " and pm.systemFlag=:systemFlag "+
                                                    " AND ph.operatorCode =:userCode ");

        //查询数据
        Query tempProposal = entityManager.createNativeQuery(tempProposalSql.toString());
        Query proposal = entityManager.createNativeQuery(proposalSql.toString());
        Query policy = entityManager.createNativeQuery(policysql.toString());
        Query endors = entityManager.createNativeQuery(endorsSql.toString());

        //设置参数
        tempProposal.setParameter("userCode",userCode);
        tempProposal.setParameter("systemFlag",systemFlag);
        proposal.setParameter("userCode",userCode);
        proposal.setParameter("systemFlag",systemFlag);
        policy.setParameter("userCode",userCode);
        policy.setParameter("systemFlag",systemFlag);
        endors.setParameter("userCode",userCode);
        endors.setParameter("systemFlag",systemFlag);
        //接收结果
        QueryMyJobCountDto queryMyJobCountDto =new QueryMyJobCountDto();
        queryMyJobCountDto.setTempProposal(Long.valueOf(tempProposal.getSingleResult().toString()));
        queryMyJobCountDto.setProposal(Long.valueOf(proposal.getSingleResult().toString()));
        queryMyJobCountDto.setPolicy(Long.valueOf(policy.getSingleResult().toString()));
        queryMyJobCountDto.setEndors(Long.valueOf(endors.getSingleResult().toString()));

        return queryMyJobCountDto;
    }
}
