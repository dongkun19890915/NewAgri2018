package com.sinosoft.dms.core.customer.service.impl;

import com.sinosoft.dms.api.bill.BillApi;
import com.sinosoft.dms.api.customer.dto.*;
import com.sinosoft.dms.core.customer.dao.*;
import com.sinosoft.dms.core.customer.entity.*;
import com.sinosoft.dms.core.customer.service.PrpDcustomerService;
import com.sinosoft.framework.agri.core.service.impl.BaseCustomServiceImpl;
import com.sinosoft.framework.dto.PageInfo;
import com.sinosoft.framework.exception.BusinessException;
import com.sinosoft.framework.exception.DataVerifyException;
import com.sinosoft.ims.api.auth.UtiPlatConfigRuleApi;
import com.sinosoft.ims.api.auth.dto.UtiPlatConfigRuleDto;
import com.sinosoft.ims.api.kernel.PrpDuserApi;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.text.SimpleDateFormat;
import java.util.*;


/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time 2017-10-24 01:57:51.087
 * @description 客户信息表Core接口实现
 */
@Service
public class PrpDcustomerServiceImpl extends BaseCustomServiceImpl implements PrpDcustomerService {
    /**
     * log日志
     */
    private static final Logger LOGGER = LoggerFactory.getLogger(PrpDcustomerServiceImpl.class);

    @Autowired
    private PrpDcustomerDao prpDcustomerDao;
    @Autowired
    private PrpDcustomLevelTraceDao prpDcustomLevelTraceDao;
    @Autowired
    private PrpDcustomerIdvDao prpDcustomerIdvDao;
    @Autowired
    private PrpDcustomerUnitDao prpDcustomerUnitDao;
    @Autowired
    private BillApi billApi;
    @Autowired
    private UtiPlatConfigRuleApi utiPlatConfigRuleApi;
    @Autowired
    private PrpDuserApi prpDuserApi;
    @PersistenceContext
    private EntityManager entityManager;
    @Autowired
    private PrpDcustomerTaxPayInfoDao prpDCustomerTaxPayInfoDao;

    /**
     * @param
     * @description 新增
     */
    public void save(PrpDcustomerDto prpDcustomerDto) {
        PrpDcustomer prpDcustomer = this.convert(prpDcustomerDto, PrpDcustomer.class);
        prpDcustomerDao.save(prpDcustomer);
    }
    /**
     *  批量保存客户信息主表（国元应该只有一个客户信息，信达可能有多个）
     * @author: 田健
     * @date: 2017/12/28 10:53
     * @param prpDcustomerDtos 客户主表信息集合
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public void saveByList(List<PrpDcustomerDto> prpDcustomerDtos) {
        List<PrpDcustomer> prpDcustomerList = new ArrayList<PrpDcustomer>();
        this.convertCollection(prpDcustomerDtos,prpDcustomerList,PrpDcustomer.class);
        prpDcustomerDao.save(prpDcustomerList);
    }

    /**
     * @param
     * @description 删除
     */
    public void remove(String customerCode) {
        PrpDcustomerKey prpDcustomerKey = new PrpDcustomerKey(customerCode);
        prpDcustomerDao.delete(prpDcustomerKey);
    }

    /**
     * @param
     * @description
     */
    public void modify(PrpDcustomerDto prpDcustomerDto) {
        PrpDcustomer prpDcustomer = this.convert(prpDcustomerDto, PrpDcustomer.class);
        System.out.println("123");
        prpDcustomerDao.save(prpDcustomer);
    }

    /**
     * @param
     * @description 按主键查询实体
     */
    public PrpDcustomerDto queryByPK(String customerCode) {
        PrpDcustomerKey prpDcustomerKey = new PrpDcustomerKey(customerCode);
        PrpDcustomer prpDcustomer = prpDcustomerDao.findOne(prpDcustomerKey);
        return this.convert(prpDcustomer, PrpDcustomerDto.class);
    }

    /**
     * 集体客户根据号查询
     *
     * @param socialCode 机构代码
     * @param pageNo     页码
     * @param pageSize   条数
     * @return ResponseDto ： PageInfo<PrpDcustomerUnitDto>对象
     * @throws Exception
     * @author: 钱浩
     * @date: 2017/11/1 15:29
     */
    public PageInfo<PrpDcustomerUnitDto> queryPrpDcustomerUnitByCondition(String socialCode, Integer pageNo, Integer pageSize) throws Exception {
        if (StringUtils.isEmpty(socialCode)) {
            throw new BusinessException("客户名称不能为空！");
        }
        if (pageNo < 1) {
            throw new BusinessException("页码不能小于1");
        }
        if (pageSize < 1) {
            throw new BusinessException("每页数量不能小于1");
        }
        String totalSize = "";
        Long totalSizeStrLon = null;
        List<PrpDcustomerUnitDto> prpDcustomerUnitDtoList = new ArrayList<PrpDcustomerUnitDto>();
        PrpDcustomerUnitDto prpDcustomerUnitDto = new PrpDcustomerUnitDto();
        prpDcustomerUnitDto.setSocialCode(socialCode);
        StringBuilder strWhereUnti = new StringBuilder(" select t from PrpDcustomerUnit t where t.socialCode like :socialCode  order by  t.customerCode ");
        StringBuilder strWhereUntiCount = new StringBuilder(" select count(t) from PrpDcustomerUnit t where t.socialCode like :socialCode ");
        Query queryUnti = entityManager.createQuery(strWhereUnti.toString());
        //查询总条数
        Query queryUntiCount = entityManager.createQuery(strWhereUntiCount.toString());
        queryUntiCount.setParameter("socialCode", "%" + prpDcustomerUnitDto.getSocialCode() + "%");
        Object object = queryUntiCount.getSingleResult();
        totalSize = object.toString();
        if (pageNo != null) {
            queryUnti.setFirstResult((pageNo.intValue() - 1) * pageSize.intValue());
        }
        if (pageSize != null) {
            queryUnti.setMaxResults(pageSize.intValue());
        }
        queryUnti.setParameter("socialCode", "%" + prpDcustomerUnitDto.getSocialCode() + "%");
        List<PrpDcustomerUnit> prpDcustomerUnitList = queryUnti.getResultList();
        convertCollection(prpDcustomerUnitList, prpDcustomerUnitDtoList, PrpDcustomerUnitDto.class);

        totalSizeStrLon = Long.valueOf(totalSize);
        PageInfo<PrpDcustomerUnitDto> pageInfo = this.setPageInfo(prpDcustomerUnitDtoList, pageNo, totalSizeStrLon, PrpDcustomerUnitDto.class);
        return pageInfo;
    }

    /**
     * 个体客户根据证件号查询
     *
     * @param identifyNumber 证件号码
     * @param pageNo         页码
     * @param pageSize       条数
     * @return ResponseDto ：PageInfo<PrpDcustomerIdvDto>  大对象
     * @throws Exception
     * @author: 钱浩
     * @date: 2017/10/13 18:39
     */
    public PageInfo<PrpDcustomerIdvDto> queryPrpDcustomerIdvByCondition(String identifyNumber, Integer pageNo, Integer pageSize) throws Exception {
        if (StringUtils.isEmpty(identifyNumber)) {
            throw new BusinessException("客户名称不能为空！");
        }
        if (pageNo < 1) {
            throw new BusinessException("页码不能小于1");
        }
        if (pageSize < 1) {
            throw new BusinessException("每页数量不能小于1");
        }
        String totalSize = "";
        Long totalSizeStrLon = null;
        List<PrpDcustomerIdvDto> prpDcustomerIdvDtoList = new ArrayList<PrpDcustomerIdvDto>();
        PrpDcustomerIdvDto prpDcustomerIdvDto = new PrpDcustomerIdvDto();
        //个人客户
        prpDcustomerIdvDto.setIdentifyNumber(identifyNumber);
        StringBuilder strWhereIdv = new StringBuilder("select t from PrpDcustomerIdv t where t.identifyNumber like :identifyNumber  order by  t.customerCode ");
        StringBuilder strWhereIdvCount = new StringBuilder("select count(t) from PrpDcustomerIdv t where t.identifyNumber like :identifyNumber ");
        System.out.print(strWhereIdv.toString());
        Query queryIdv = entityManager.createQuery(strWhereIdv.toString());
        //查询总条数
        Query queryCount = entityManager.createQuery(strWhereIdvCount.toString());
        queryCount.setParameter("identifyNumber", "%" + prpDcustomerIdvDto.getIdentifyNumber() + "%");
        Object object = queryCount.getSingleResult();
        totalSize = object.toString();
        if (pageNo != null) {
            queryIdv.setFirstResult((pageNo.intValue() - 1) * pageSize.intValue());
        }
        if (pageSize != null) {
            queryIdv.setMaxResults(pageSize.intValue());
        }
        queryIdv.setParameter("identifyNumber", "%" + prpDcustomerIdvDto.getIdentifyNumber() + "%");
        List<PrpDcustomerIdv> prpDcustomerIdvList = queryIdv.getResultList();
        convertCollection(prpDcustomerIdvList, prpDcustomerIdvDtoList, PrpDcustomerIdvDto.class);
        totalSizeStrLon = Long.valueOf(totalSize);
        PageInfo<PrpDcustomerIdvDto> pageInfo = this.setPageInfo(prpDcustomerIdvDtoList, pageNo, totalSizeStrLon, PrpDcustomerIdvDto.class);
        return pageInfo;
    }

    /**
     * 1.判断customerType为1走个体客户，否则集体客户
     * 2.风险轨迹表PrpDcustomLevelTrace保存
     * 3.客户纳税人信息表 prpDCustomerTaxPayInfo保存
     *
     * @param prpDcustomerSaveDto 增加或者修改客户封装dto
     * @return ResponseDto： 成功或失败
     * @throws Exception
     * @author: 钱浩
     * @date: 2017/10/21 15:00
     */
    public Map<String,String> saveCustomerInfo(PrpDcustomerSaveDto prpDcustomerSaveDto) throws Exception {
        String userCode = prpDcustomerSaveDto.getUserCode();
        String comCode = prpDcustomerSaveDto.getComCode();
        String customerType = prpDcustomerSaveDto.getCustomerType();
        PrpDcustomerIdvDto prpDcustomerIdvDto = prpDcustomerSaveDto.getPrpDcustomerIdvDto();
        PrpDcustomerUnitDto prpDcustomerUnitDto = prpDcustomerSaveDto.getPrpDcustomerUnitDto();
        PrpDcustomerTaxPayInfoDto prpDcustomerTaxPayInfoDto = prpDcustomerSaveDto.getPrpDcustomerTaxPayInfoDto();
        if (StringUtils.isEmpty(customerType)) {
            throw new Exception("用户类型不能为空");
        }
        com.sinosoft.dms.api.customer.dto.PrpDcustomerDto prpDcustomerDto = new com.sinosoft.dms.api.customer.dto.PrpDcustomerDto();
        String EditType = "M";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-hh");
        String inputDate = simpleDateFormat.format(new Date());
        String oldUserCode = "";
        String customerCode = "";
        String strNewRiskLevel = "";
        //1.判断customerType为1走个体客户，否则集体客户
        if ("1".equals(customerType)) {
            prpDcustomerDto.setCustomerCName(prpDcustomerIdvDto.getCustomerCName());
            prpDcustomerDto.setCustomerEName(prpDcustomerIdvDto.getCustomerEName());
            prpDcustomerDto.setAddressCName(prpDcustomerIdvDto.getAddressCName());
            prpDcustomerDto.setAddressEName(prpDcustomerIdvDto.getAddressEName());
            prpDcustomerDto.setValidStatus("1");
            prpDcustomerDto.setCustomerType(customerType);
            strNewRiskLevel = prpDcustomerIdvDto.getRiskLevel();
            //判断CustomerCode是否为空，为空走生成CustomerCode逻辑
            if (StringUtils.isEmpty(prpDcustomerIdvDto.getCustomerCode())) {
                EditType = "I";
            } else {
                customerCode = prpDcustomerIdvDto.getCustomerCode();
            }
            if (EditType.equals("I")) {
                //生成新CustomerCode
                customerCode = addCustomer(prpDcustomerDto, comCode);
                prpDcustomerIdvDto.setCustomerCode(customerCode);
            }
            prpDcustomerIdvDto.setNewCustomerCode(customerCode);
            if (EditType.equals("M")) {
                PrpDcustomerIdv prpDcustomerIdv1 = prpDcustomerIdvDao.findOne(new PrpDcustomerIdvKey(customerCode));
                if (prpDcustomerIdv1.getInputDate() == null || "".equals(prpDcustomerIdv1.getInputDate())) {
                    inputDate = null;
                } else {
                    inputDate = simpleDateFormat.format(prpDcustomerIdv1.getInputDate());
                }
                oldUserCode = prpDcustomerIdv1.getOperatorCode();
            }
            prpDcustomerIdvDto.setValidStatus("1");
            if (EditType.equals("I")) {
                //新增时才需要填这两项shuxing
                prpDcustomerIdvDto.setOperatorCode(userCode);
                prpDcustomerIdvDto.setInputDate(simpleDateFormat.parse(inputDate));
            } else {
                if (com.sinosoft.framework.core.utils.StringUtils.isEmpty(inputDate)) {
                } else {
                    prpDcustomerIdvDto.setInputDate(simpleDateFormat.parse(inputDate));
                }
                prpDcustomerIdvDto.setOperatorCode(oldUserCode);
            }
            PrpDcustomerIdv prpDcustomerIdv = convert(prpDcustomerIdvDto, PrpDcustomerIdv.class);
            //更新
            prpDcustomerIdvDao.save(prpDcustomerIdv);
        } else {
            prpDcustomerDto.setCustomerCName(prpDcustomerUnitDto.getCustomerCName());
            prpDcustomerDto.setCustomerEName(prpDcustomerUnitDto.getCustomerEName());
            prpDcustomerDto.setAddressCName(prpDcustomerUnitDto.getAddressCName());
            prpDcustomerDto.setAddressEName(prpDcustomerUnitDto.getAddressEName());
            prpDcustomerDto.setValidStatus("1");
            prpDcustomerDto.setCustomerType(customerType);
            strNewRiskLevel = prpDcustomerUnitDto.getRiskLevel();
            if (StringUtils.isEmpty(prpDcustomerUnitDto.getCustomerCode())) {
                EditType = "I";
            } else {
                customerCode = prpDcustomerUnitDto.getCustomerCode();
            }
            if (EditType.equals("I")) {
                customerCode = addCustomer(prpDcustomerDto, comCode);
                prpDcustomerUnitDto.setCustomerCode(customerCode);
            }
            prpDcustomerUnitDto.setNewCustomerCode(customerCode);
            if (EditType.equals("M")) {
                PrpDcustomerUnit prpDcustomerUnit1 = prpDcustomerUnitDao.findOne(new PrpDcustomerUnitKey(customerCode));
                if (prpDcustomerUnit1.getInputDate() == null || "".equals(prpDcustomerUnit1.getInputDate())) {
                    inputDate = null;
                } else {
                    inputDate = simpleDateFormat.format(prpDcustomerUnit1.getInputDate());
                }
                oldUserCode = prpDcustomerUnit1.getOperatorCode();
            }
            prpDcustomerUnitDto.setValidStatus("1");
            if (EditType.equals("I")) {
                //新增时才需要填这两项
                prpDcustomerUnitDto.setOperatorCode(userCode);
                prpDcustomerUnitDto.setInputDate(simpleDateFormat.parse(inputDate));
            } else {
                if (com.sinosoft.framework.core.utils.StringUtils.isEmpty(inputDate)) {
                } else {
                    prpDcustomerUnitDto.setInputDate(simpleDateFormat.parse(inputDate));
                }
                prpDcustomerUnitDto.setOperatorCode(oldUserCode);
            }
            PrpDcustomerUnit prpDcustomerUnit = convert(prpDcustomerUnitDto, PrpDcustomerUnit.class);
            prpDcustomerUnitDao.save(prpDcustomerUnit);
        }
        //2.风险轨迹表PrpDcustomLevelTrace保存
        int maxLineNo = 1;

        PrpDcustomLevelTraceDto prpDcustomLevelTraceDto = queryPrpDcustomLevelTraceByConnection(customerCode);
        PrpDcustomLevelTraceDto prpDcustomLevelTraceDto1 = new com.sinosoft.dms.api.customer.dto.PrpDcustomLevelTraceDto();
        if (prpDcustomLevelTraceDto.getCustomerCode() != null) {
            prpDcustomLevelTraceDto1.setOldRiskLevel(prpDcustomLevelTraceDto.getNewRiskLevel());
            maxLineNo = prpDcustomLevelTraceDto.getLineNo() + 1;
        }
        prpDcustomLevelTraceDto1.setCustomerCode(customerCode);
        prpDcustomLevelTraceDto1.setLineNo(maxLineNo);
        prpDcustomLevelTraceDto1.setNewRiskLevel(strNewRiskLevel);
        prpDcustomLevelTraceDto1.setOperateCode(userCode);
        if (com.sinosoft.framework.core.utils.StringUtils.isEmpty(inputDate)) {
        } else {
            prpDcustomLevelTraceDto1.setOperateDate(simpleDateFormat.parse(inputDate));
        }
        save(prpDcustomLevelTraceDto1);
        //3.客户纳税人信息表 prpDCustomerTaxPayInfo保存
        if (StringUtils.isEmpty(prpDcustomerTaxPayInfoDto.getTaxpayerType())) {
            throw new Exception("纳税人身份不能为空");
        }
        prpDcustomerTaxPayInfoDto.setCustomerCode(customerCode);
        if (customerType.trim().equals("1")) {//个人客户
            prpDcustomerTaxPayInfoDto.setCustomerName(prpDcustomerIdvDto.getCustomerCName());
            prpDcustomerTaxPayInfoDto.setCustomerType(customerType);

        } else {//单位用户
            prpDcustomerTaxPayInfoDto.setCustomerName(prpDcustomerUnitDto.getCustomerCName());
            prpDcustomerTaxPayInfoDto.setCustomerType(customerType);
        }
        PrpDcustomerTaxPayInfo prpDCustomerTaxPayInfo = convert(prpDcustomerTaxPayInfoDto, PrpDcustomerTaxPayInfo.class);
        prpDCustomerTaxPayInfoDao.save(prpDCustomerTaxPayInfo);
        Map<String,String> map=new HashMap<String,String>();
        map.put("message","保存成功!");
        return map;
    }

    /**
     * 保存客户信息，自动生成客户号
     *
     * @param iPrpDcustomerSchema 客户记录
     * @param comCode             机构代码
     * @throws Exception
     * @author: 钱浩
     * @date: 2017/11/10 16:46
     */
    public String addCustomer(PrpDcustomerDto iPrpDcustomerSchema, String comCode)
            throws Exception {
        String strCustomerCode = this.apply(iPrpDcustomerSchema.getCustomerType(), comCode);
        iPrpDcustomerSchema.setCustomerCode(strCustomerCode);
        PrpDcustomer prpDcustomer = convert(iPrpDcustomerSchema, PrpDcustomer.class);
        prpDcustomerDao.save(prpDcustomer);
        return strCustomerCode;
    }

    /**
     * 生成客户号
     *
     * @param iCustomerType 客户类型
     * @param iMakeCom
     * @return
     * @throws Exception
     * @author: 钱浩
     * @date: 2017/10/20 19:36
     */
    public String apply(String iCustomerType, String iMakeCom)
            throws Exception {
        String strWherePart = "";
        String strCustomerCode = "";
        String sql = "";
        // 平台配置系统交互
        /*String dbType=getProperty("DBTYPE");*/
        //TODO 与平台交互暂时注掉，等待国元开发完成链接测试 String dbType = getRuleInUtiPlatConfigRuleApi.queryfindOne("prpall", "DBTYPE", "1");
        UtiPlatConfigRuleDto utiPlatConfigRuleDto = utiPlatConfigRuleApi.queryByPK("prpall", "DBTYPE", 1);
        String dbType = utiPlatConfigRuleDto.getRule();
        if (dbType.endsWith("ORACLE")) {
            sql = " Select * From (Select * From Prpdcustomer  where  ";
        }
        if (dbType.endsWith("DB2")) {
            sql = " Select * From (Select row_number() over(Order By Customercode desc)  As Linenum ,Prpdcustomer.* From Prpdcustomer  where  ";
        }
        if (iCustomerType.equals("1")) {
            strWherePart = "Substr(CustomerCode,1,7) ='" + "5" + iMakeCom.trim().substring(0, 6)
                    + "'";
        } else {
            strWherePart = "Substr(CustomerCode,1,7) ='" + "0" + iMakeCom.trim().substring(0, 6)
                    + "'";
        }
        String strsql = " SELECT COUNT(*) FROM PrpDcustomer WHERE " + strWherePart;
        Query query = entityManager.createNativeQuery(strsql);
        Object obj = query.getSingleResult();
        int integer = Integer.parseInt(obj.toString());
        if (integer == 0) {
            if (iCustomerType.equals("1")) {
                strCustomerCode = "5" + iMakeCom.trim().substring(0, 6) + "000000001";
            } else {
                strCustomerCode = "0" + iMakeCom.trim().substring(0, 6) + "000000001";
            }
        } else {
            if (dbType.endsWith("ORACLE")) {
                sql = sql + strWherePart + "  AND LENGTH(Trim(CustomerCode))=16  Order By Customercode Desc) T  Where Rownum = 1";
            } else {
                sql = sql + strWherePart + "  AND LENGTH(rtrim(ltrim(CustomerCode)))=16   ) T  Where Linenum = 1";
            }
            Query query1 = entityManager.createNativeQuery(sql, PrpDcustomer.class);
            List<PrpDcustomer> list = query1.getResultList();
            PrpDcustomer prpDcustomer1 = list.get(0);
            int intcode = Integer.parseInt(prpDcustomer1.getCustomerCode().trim().substring(7, 16));
            intcode++;
            String strcode = "" + intcode;
            int intlimit = 9 - strcode.length();
            for (int i = 0; i < intlimit; i++) {
                strcode = "0" + strcode;
            }
            strCustomerCode = prpDcustomer1.getCustomerCode().substring(0, 7) + strcode;
        }
        return strCustomerCode;
    }

    /**
     * 根据customerCode查询
     *
     * @param customerCode
     * @return
     * @author: 钱浩
     * @date: 2017/10/21 14:10
     */
    public PrpDcustomLevelTraceDto queryPrpDcustomLevelTraceByConnection(String customerCode) throws Exception {

        StringBuilder stringBuilder = new StringBuilder();
        PrpDcustomLevelTraceDto prpDcustomLevelTraceDto = new PrpDcustomLevelTraceDto();
        stringBuilder.append(" select t from  PrpDcustomLevelTrace t where t.customerCode=:customerCode ");
        Query managerQuery = entityManager.createQuery(stringBuilder.toString());
        managerQuery.setParameter("customerCode", customerCode);
        List<PrpDcustomLevelTrace> prpDcustomLevelTraceList = managerQuery.getResultList();
        for (PrpDcustomLevelTrace prpDcustomLevelTrace : prpDcustomLevelTraceList) {
            prpDcustomLevelTraceDto = convert(prpDcustomLevelTrace, PrpDcustomLevelTraceDto.class);
        }
        return prpDcustomLevelTraceDto;
    }

    /**
     * PrpDcustomLevelTraceDto新增
     *
     * @param
     * @author: 钱浩
     * @date: 2017/11/10 16:39
     */
    public void save(PrpDcustomLevelTraceDto prpDcustomLevelTraceDto) {
        PrpDcustomLevelTrace prpDcustomLevelTrace = this.convert(prpDcustomLevelTraceDto, PrpDcustomLevelTrace.class);
        prpDcustomLevelTraceDao.save(prpDcustomLevelTrace);
    }

    /**
     * 客户查询接口
     *
     * @param customerInfoDto 入参Dto
     * @return
     * @throws Exception
     * @author: 钱浩
     * @date: 2017/11/16 12:01
     */
    public PageInfo<RCustomerInfoDto> queryCustomerInfo(CustomerInfoDto customerInfoDto) throws Exception {
        if (StringUtils.isEmpty(customerInfoDto.getCustomerType())) {
            throw new DataVerifyException("客户类型不能为空");
        }
        if (customerInfoDto.getPageNo() < 1) {
            throw new DataVerifyException("页码不能小于1");
        }
        if (customerInfoDto.getPageSize() < 1) {
            throw new DataVerifyException("每页条数不能小于1");
        }
        //sql拼接
        StringBuilder builder = new StringBuilder();
        StringBuilder builder1 = new StringBuilder();
        builder.append(" select * from ( ");
        builder1.append(" select count(*) from ( ");
        builder.append(" select ");
        builder1.append(" select ");
//        builder.append("  decode(h.customertype,'1','个人','单位') as customertype, ");
//        builder1.append("  decode(h.customertype,'1','个人','单位') as customertype, ");
        builder.append("   customertype, ");
        builder1.append("   customertype, ");
        builder.append(" h.customercode as customercode , ");
        builder1.append(" h.customercode as customercode , ");
        builder.append(" h.customercname as  customercname , ");
        builder1.append(" h.customercname as  customercname , ");
        builder.append(" ( select codecname from prpdcode where codetype='IdentifyType' and ");
        builder1.append(" ( select codecname from prpdcode where codetype='IdentifyType' and ");
        builder.append(" codecode=(decode(h.customertype,'1',(select i.identifytype from prpdcustomeridv i ");
        builder1.append(" codecode=(decode(h.customertype,'1',(select i.identifytype from prpdcustomeridv i ");
        builder.append(" where i.customercode=h.customercode),(select  p.identifytype from prpdcustomerunit p ");
        builder1.append(" where i.customercode=h.customercode),(select  p.identifytype from prpdcustomerunit p ");
        builder.append(" where p.customercode=h.customercode)))) as dcustomeridv,  ");
        builder1.append(" where p.customercode=h.customercode)))) as dcustomeridv,  ");
        builder.append(" decode(h.customertype,'1',(select i.identifynumber from prpdcustomeridv i where i.customercode=h.customercode), ");
        builder1.append(" decode(h.customertype,'1',(select i.identifynumber from prpdcustomeridv i where i.customercode=h.customercode), ");
        builder.append(" (select  p.organizecode from prpdcustomerunit p where p.customercode=h.customercode)) as customernumber ");
        builder1.append(" (select  p.organizecode from prpdcustomerunit p where p.customercode=h.customercode)) as customernumber ");
        builder.append(" from prpdcustomer h ");
        builder1.append(" from prpdcustomer h ");
        builder.append(" ) where  ");
        builder1.append(" ) where  ");
        if (StringUtils.isNotEmpty(customerInfoDto.getCustomerType()) && !"0".equals(customerInfoDto.getCustomerType())) {
            builder.append(" CustomerType='");
            builder1.append(" CustomerType='");
            builder.append(customerInfoDto.getCustomerType());
            builder1.append(customerInfoDto.getCustomerType());
            builder.append("'");
            builder1.append("'");
        }
        if (StringUtils.isNotEmpty(customerInfoDto.getCustomerCname())) {
            builder.append(" and CustomerCname like '");
            builder1.append(" and CustomerCname like '");
            builder.append("%" + customerInfoDto.getCustomerCname() + "%");
            builder1.append("%" + customerInfoDto.getCustomerCname() + "%");
            builder.append("'");
            builder1.append("'");
        }
        if (StringUtils.isNotEmpty(customerInfoDto.getCustomerCode())) {
            builder.append(" and CustomerCode like '");
            builder1.append(" and CustomerCode like '");
            builder.append("%" + customerInfoDto.getCustomerCode() + "%");
            builder1.append("%" + customerInfoDto.getCustomerCode() + "%");
            builder.append("'");
            builder1.append("'");
        }
        if (StringUtils.isNotEmpty(customerInfoDto.getCustomerNumber())) {
            builder.append(" and CustomerNumber like '");
            builder1.append(" and CustomerNumber like '");
            builder.append("%" + customerInfoDto.getCustomerNumber() + "%");
            builder1.append("%" + customerInfoDto.getCustomerNumber() + "%");
            builder.append("'");
            builder1.append("'");
        }
        builder.append("  order by customercode ");
        builder1.append("  order by customercode ");
        //查询总数，及分页
        Query nativeQuery = entityManager.createNativeQuery(builder.toString(), RCustomerInfo.class);
        Query nativeQuery1 = entityManager.createNativeQuery(builder1.toString());
        Object object = nativeQuery1.getSingleResult();
        Long totalSizeStrLon = Long.valueOf(object.toString());
        if (customerInfoDto.getPageNo() != null) {
            nativeQuery.setFirstResult((customerInfoDto.getPageNo().intValue() - 1) * customerInfoDto.getPageSize().intValue());
        }
        if (customerInfoDto.getPageSize() != null) {
            nativeQuery.setMaxResults(customerInfoDto.getPageSize().intValue());
        }
        List<RCustomerInfo> rCustomerInfoList = nativeQuery.getResultList();
        List<RCustomerInfoDto> rCustomerInfoDtoList = new ArrayList<RCustomerInfoDto>();
        convertCollection(rCustomerInfoList, rCustomerInfoDtoList, RCustomerInfoDto.class);
        PageInfo<RCustomerInfoDto> pageInfo = this.setPageInfo(rCustomerInfoDtoList, customerInfoDto.getPageNo(), totalSizeStrLon, RCustomerInfoDto.class);
        return pageInfo;
    }

    /**
     * 按照条件查询PrpDcustomerIdvDto个人客户代码表信息
     *
     * @param queryCustomerInfoByConditionDto customerType客户类型、identifyNumber证件号码、customerCName客户中文名称、
     *                                        customerCode客户代码、startupdatedate endupdatedate维护日期、username员工名称
     * @return 返回PrpDcustomerIdvDto集合
     * @throws Exception
     * @author: 田慧
     * @date: 2017/12/4 15:07
     */
    @Override
    public PageInfo<PrpDcustomerIdvDto> queryPrpDcustomerIdvInfoByCondition(QueryCustomerInfoByConditionDto queryCustomerInfoByConditionDto) throws Exception {
        int pageNo = queryCustomerInfoByConditionDto.getPageNo();
        int pageSize = queryCustomerInfoByConditionDto.getPageSize();
        if (pageNo < 1) {
            throw new DataVerifyException("页码不能小于1!");
        }
        if (pageSize < 1) {
            throw new DataVerifyException("每页大小不能小于1!");
        }
        Map<String, Object> map = new HashMap<String, Object>();
        //拼接SQL
        StringBuilder countSql = new StringBuilder("SELECT count(1) FROM PrpDcustomerIdv p ");
        StringBuilder resultSql = new StringBuilder("SELECT p FROM PrpDcustomerIdv p ");
        String dataCondition;
        List<String> list = new ArrayList<String>();
        //证件类型
        if (StringUtils.isNotEmpty(queryCustomerInfoByConditionDto.getIdentifyType())) {
            list.add(" AND p.identifyType=:identifyType");
            map.put("identifyType", queryCustomerInfoByConditionDto.getIdentifyType());
        }
        //证件号码identifyNumber
        if (StringUtils.isNotEmpty(queryCustomerInfoByConditionDto.getIdentifyNumber())) {
            list.add(" AND p.identifyNumber=:identifyNumber");
            map.put("identifyNumber", queryCustomerInfoByConditionDto.getIdentifyNumber());
        }
        //客户中文名称customerCName
        if (StringUtils.isNotEmpty(queryCustomerInfoByConditionDto.getCustomerCName())) {
            list.add(" AND p.customerCName=:customerCName");
            map.put("customerCName", queryCustomerInfoByConditionDto.getCustomerCName());
        }
        //客户代码customerCode
        if (StringUtils.isNotEmpty(queryCustomerInfoByConditionDto.getCustomerCode())) {
            list.add(" AND p.customerCode=:customerCode");
            map.put("customerCode", queryCustomerInfoByConditionDto.getCustomerCode());
        }
        //维护日期startupdatedate
        if (queryCustomerInfoByConditionDto.getStartUpDateDate() != null) {
            list.add(" AND p.updateDate>=:startUpDateDate");
            map.put("startUpDateDate", queryCustomerInfoByConditionDto.getStartUpDateDate());
        }
        //维护日期endupdatedate
        if (queryCustomerInfoByConditionDto.getEndUpDateDate() != null) {
            list.add(" AND p.updateDate<=:endUpDateDate");
            map.put("endUpDateDate", queryCustomerInfoByConditionDto.getEndUpDateDate());
        }

        //根据username查询维护人名称(最后一次修改人)updatercode
        if (StringUtils.isNotEmpty(queryCustomerInfoByConditionDto.getUserName())) {
            List<String> prpDuserList = prpDuserApi.queryByUserName(queryCustomerInfoByConditionDto.getUserName());
            if(prpDuserList !=null && prpDuserList.size()>0) {
                list.add(" AND p.updaterCode in:prpDuserDtoList");
                map.put("prpDuserDtoList", prpDuserList);
            }else {
                return null;
            }
        }
        if (list.size() > 0) {
            dataCondition = this.joinCondition(list);

            countSql.append(" where ");
            countSql.append(dataCondition);

            resultSql.append(" where ");
            resultSql.append(dataCondition);
        }
        Query dataResult = entityManager.createQuery(resultSql.toString());
        Query countResult = entityManager.createQuery(countSql.toString());
        this.setQueryParam(dataResult, pageNo, pageSize, map);
        this.setQueryParam(countResult, map);
        //查询总条数
        Long totalSize = (Long) countResult.getSingleResult();
        //查询结果
        List<PrpDcustomerIdv> prpDcustomerIdvList = dataResult.getResultList();
        List<PrpDcustomerIdvDto> prpDcustomerIdvDtoList = new ArrayList<PrpDcustomerIdvDto>();
        convertCollection(prpDcustomerIdvList, prpDcustomerIdvDtoList, PrpDcustomerIdvDto.class);
        PageInfo<PrpDcustomerIdvDto> pageInfo = this.setPageInfo(prpDcustomerIdvDtoList, pageNo, totalSize, PrpDcustomerIdvDto.class);
        return pageInfo;
    }

    /**
     * 按照条件查询PrpDcustomerUnit集体客户代码表信息
     *
     * @param queryCustomerInfoByConditionDto customerType客户类型、socialcode1:组织机构代码 2:统一社会信用代码'、customerCName客户中文名称、
     *                                        customerCode客户代码、startupdatedate endupdatedate维护日期、username员工名称
     * @return 返回PrpDcustomerUnitDto集合
     * @throws Exception
     * @author: 田慧
     * @date: 2017/12/4 15:07
     */
    @Override
    public PageInfo<PrpDcustomerUnitDto> queryPrpDcustomerUnitInfoByCondition(QueryCustomerInfoByConditionDto queryCustomerInfoByConditionDto) throws Exception {
        int pageNo = queryCustomerInfoByConditionDto.getPageNo();
        int pageSize = queryCustomerInfoByConditionDto.getPageSize();
        if (pageNo < 1) {
            throw new DataVerifyException("页码不能小于1!");
        }
        if (pageSize < 1) {
            throw new DataVerifyException("每页大小不能小于1!");
        }
        Map<String, Object> map = new HashMap<String, Object>();
        //拼接SQL
        StringBuilder countSql = new StringBuilder("SELECT count(1) FROM PrpDcustomerUnit p ");
        StringBuilder resultSql = new StringBuilder("SELECT p FROM PrpDcustomerUnit p ");
        String dataCondition;
        List<String> list = new ArrayList<String>();
        //证件类型
        if (StringUtils.isNotEmpty(queryCustomerInfoByConditionDto.getIdentifyType())) {
            list.add(" AND p.identifyType=:identifyType");
            map.put("identifyType", queryCustomerInfoByConditionDto.getIdentifyType());
        }
        //1:组织机构代码 2:统一社会信用代码socialcode
        if (StringUtils.isNotEmpty(queryCustomerInfoByConditionDto.getSocialCode())) {
            list.add(" AND p.socialCode=:socialCode");
            map.put("socialCode", queryCustomerInfoByConditionDto.getSocialCode());
        }
        //客户中文名称customerCName
        if (StringUtils.isNotEmpty(queryCustomerInfoByConditionDto.getCustomerCName())) {
            list.add(" AND p.customerCName=:customerCName");
            map.put("customerCName", queryCustomerInfoByConditionDto.getCustomerCName());
        }
        //客户代码customerCode
        if (StringUtils.isNotEmpty(queryCustomerInfoByConditionDto.getCustomerCode())) {
            list.add(" AND p.customerCode=:customerCode");
            map.put("customerCode", queryCustomerInfoByConditionDto.getCustomerCode());
        }
        //维护日期startupdatedate
        if (queryCustomerInfoByConditionDto.getStartUpDateDate()!= null) {
            list.add(" AND p.updateDate>=:startUpDateDate");
            map.put("startUpDateDate", queryCustomerInfoByConditionDto.getStartUpDateDate());
        }
        //维护日期endupdatedate
        if (queryCustomerInfoByConditionDto.getEndUpDateDate()!= null) {
            list.add(" AND p.updateDate<=:endUpDateDate");
            map.put("endUpDateDate", queryCustomerInfoByConditionDto.getEndUpDateDate());
        }

        //根据username查询维护人名称(最后一次修改人)updatercode
        if (StringUtils.isNotEmpty(queryCustomerInfoByConditionDto.getUserName())) {
            list.add(" AND p.updaterCode in:prpDuserDtoList");
            map.put("prpDuserDtoList", prpDuserApi.queryByUserName(queryCustomerInfoByConditionDto.getUserName()));
        }
        if (list.size() > 0) {
            dataCondition = this.joinCondition(list);

            countSql.append(" where ");
            countSql.append(dataCondition);

            resultSql.append(" where ");
            resultSql.append(dataCondition);
        }
        Query dataResult = entityManager.createQuery(resultSql.toString());
        Query countResult = entityManager.createQuery(countSql.toString());
        this.setQueryParam(dataResult, pageNo, pageSize, map);
        this.setQueryParam(countResult, map);
        //查询总条数
        Long totalSize = (Long) countResult.getSingleResult();
        //查询结果
        List<PrpDcustomerUnit> prpDcustomerUnitList = dataResult.getResultList();
        List<PrpDcustomerUnitDto> prpDcustomerUnitDtoList = new ArrayList<PrpDcustomerUnitDto>();
        convertCollection(prpDcustomerUnitList, prpDcustomerUnitDtoList, PrpDcustomerUnitDto.class);
        PageInfo<PrpDcustomerUnitDto> pageInfo = this.setPageInfo(prpDcustomerUnitDtoList, pageNo, totalSize, PrpDcustomerUnitDto.class);
        return pageInfo;
    }

    /**
     * 根据客户中文名称查询prpDcustomerIdv 个人客户代码表信息
     *
     * @param  queryCustomerInfoDto 客户中文名称customerCName、页码pageNo、每页大小pageSize
     * @return 返回pageInfo 分页信息
     * @throws Exception
     * @author: 田慧
     * @date: 2017/12/1 17:39
     */
    @Override
    public PageInfo<PrpDcustomerIdvDto> queryPrpDcustomerIdvByCondition(QueryCustomerInfoDto queryCustomerInfoDto) throws Exception {
        int pageNo = queryCustomerInfoDto.getPageNo();
        int pageSize = queryCustomerInfoDto.getPageSize();
        String customerCName = queryCustomerInfoDto.getCustomerCName();
        if (pageNo < 1) {
            throw new DataVerifyException("页码不能小于1");
        }
        if (pageSize < 1) {
            throw new DataVerifyException("每页数量不能小于1");
        }
//        Map<String, Object> map = new HashMap<String, Object>();
//        if (StringUtils.isEmpty(customerCName)) {
//            throw new DataVerifyException("客户中文名称不能为空！");
//        }
//        //拼接SQL
//        StringBuilder countSql = new StringBuilder("SELECT count(1) FROM prpDcustomerIdv p where p.customerCName=:customerCName");
//        StringBuilder resultSql = new StringBuilder("SELECT count(1) FROM prpDcustomerIdv p where p.customerCName=:customerCName");
//        map.put("customerCName", customerCName);
//        Query dataResult = entityManager.createQuery(resultSql.toString());
//        Query countResult = entityManager.createQuery(countSql.toString());
//
//        this.setQueryParam(dataResult, pageNo, pageSize, map);
//        this.setQueryParam(countResult, map);
//        //查询总条数
//        Long totalSize = (Long) countResult.getSingleResult();
//        //查询结果
//        List<PrpDcustomerIdv> prpDcustomerIdvList = dataResult.getResultList();
        List<PrpDcustomerIdv> prpDcustomerIdvList = prpDcustomerIdvDao.queryPrpDcustomerIdvByCondition(customerCName);
        int totalSize = prpDcustomerIdvList.size();
        List<PrpDcustomerIdvDto> prpDcustomerIdvDtoList = new ArrayList<PrpDcustomerIdvDto>();
        convertCollection(prpDcustomerIdvList, prpDcustomerIdvDtoList, PrpDcustomerIdvDto.class);
        PageInfo<PrpDcustomerIdvDto> pageInfo = this.setPageInfo(prpDcustomerIdvDtoList, pageNo, totalSize, PrpDcustomerIdvDto.class);
        return pageInfo;

    }

    /**
     * 根据客户中文名称查询 prpdcustomerunit集体客户代码表信息
     *
     * @param queryCustomerInfoDto 客户中文名称customerCName、页码pageNo、每页大小pageSize
     * @return 返回pageInfo 分页信息
     * @throws Exception
     * @author: 田慧
     * @date: 2017/12/1 17:39
     */
    @Override
    public PageInfo<PrpDcustomerUnitDto> queryPrpDcustomerUnitByCondition(QueryCustomerInfoDto queryCustomerInfoDto) throws Exception {
        int pageNo = queryCustomerInfoDto.getPageNo();
        int pageSize = queryCustomerInfoDto.getPageSize();
        String customerCName = queryCustomerInfoDto.getCustomerCName();
        if (pageNo < 1) {
            throw new DataVerifyException("页码不能小于1");
        }
        if (pageSize < 1) {
            throw new DataVerifyException("每页数量不能小于1");
        }
//        Map<String, Object> map = new HashMap<String, Object>();
//        if (StringUtils.isEmpty(customerCName)) {
//            throw new DataVerifyException("客户中文名称不能为空！");
//        }
//        //拼接SQL
//        //拼接SQL
//        StringBuilder countSql = new StringBuilder("SELECT count(1) FROM prpdcustomerunit p where p.customerCName=:customerCName");
//        StringBuilder resultSql = new StringBuilder("SELECT count(1) FROM prpdcustomerunit p where p.customerCName=:customerCName");
//        map.put("customerCName", customerCName);
//        Query dataResult = entityManager.createQuery(resultSql.toString());
//        Query countResult = entityManager.createQuery(countSql.toString());
//
//        this.setQueryParam(dataResult, pageNo, pageSize, map);
//        this.setQueryParam(countResult, map);
//        //查询总条数
//        Long totalSize = (Long) countResult.getSingleResult();
//        //查询结果
        List<PrpDcustomerUnit> prpDcustomerUnitList = prpDcustomerUnitDao.findPrpDcustomerUnitByCustomerCName(customerCName);
        int totalSize = prpDcustomerUnitList.size();
        List<PrpDcustomerUnitDto> prpDcustomerUnitDtoList = new ArrayList<PrpDcustomerUnitDto>();
        convertCollection(prpDcustomerUnitList, prpDcustomerUnitDtoList, PrpDcustomerUnitDto.class);
        PageInfo<PrpDcustomerUnitDto> pageInfo = this.setPageInfo(prpDcustomerUnitDtoList, pageNo, totalSize, PrpDcustomerUnitDto.class);
        return pageInfo;

    }

    /**
     * 根据散户名称去基础表中查询是否有该散户的信息
     * @param
     * @return
     * @throws Exception
     * @author: 王保良
     * @date: 2017/12/1 17:39
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public List<PrpDcustomerDto> queryPrpDcustomerByInsureName(String insureName) throws Exception {
        if (StringUtils.isEmpty(insureName)){
            throw new DataVerifyException("客户名称不能为空");
        }
        List<PrpDcustomer> prpDcustomerList=prpDcustomerDao.queryByCustomerCName(insureName);
        List<PrpDcustomerDto> prpDcustomerDtoList=new ArrayList<>();
        convertCollection(prpDcustomerList,prpDcustomerDtoList,PrpDcustomerDto.class);

        return prpDcustomerDtoList;
    }

}