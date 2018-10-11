package com.sinosoft.agriprpall.core.policymanage.service.impl;

import com.sinosoft.agriprpall.api.client.changepassword.AgriPrpallSelfQueryService;
import com.sinosoft.agriprpall.api.client.dto.RequestUpdatePassWordDto;
import com.sinosoft.agriprpall.api.client.dto.ResponseUpdatePassWordDto;
import com.sinosoft.agriprpall.api.policymanage.dto.*;
import com.sinosoft.agriprpall.api.proposalmanage.dto.ItemKingAgriSubDto;
import com.sinosoft.agriprpall.api.proposalmanage.dto.PremiumConDto;
import com.sinosoft.agriprpall.api.proposalmanage.dto.QueryProposalPrpTengageDto;
import com.sinosoft.agriprpall.core.policymanage.dao.*;
import com.sinosoft.agriprpall.core.policymanage.dao.specification.PolicyPrintSpecBuilder;
import com.sinosoft.agriprpall.core.policymanage.dao.specification.QueryPolicySpecBuilder;
import com.sinosoft.agriprpall.core.policymanage.entity.*;
import com.sinosoft.agriprpall.core.policymanage.service.PolicyQueryService;
import com.sinosoft.dms.api.customer.PrpDcustomLevelTraceApi;
import com.sinosoft.dms.api.customer.PrpDcustomerTaxPayInfoApi;
import com.sinosoft.dms.api.customer.dto.PrpDcustomerTaxPayInfoDto;
import com.sinosoft.dms.api.dict.PrpCountryCodeApi;
import com.sinosoft.dms.api.dict.PrpDcodeApi;
import com.sinosoft.dms.api.dict.PrpDcurrencyApi;
import com.sinosoft.dms.api.dict.PrpTownCodeApi;
import com.sinosoft.dms.api.dict.dto.PrpCountryCodeDto;
import com.sinosoft.dms.api.dict.dto.PrpDcodeDto;
import com.sinosoft.dms.api.dict.dto.PrpTownCodeDto;
import com.sinosoft.framework.agri.core.constant.LanguageFlagConstant;
import com.sinosoft.framework.agri.core.dto.HeadDto;
import com.sinosoft.framework.agri.core.dto.PacketDto;
import com.sinosoft.framework.agri.core.utils.Str;
import com.sinosoft.framework.agri.core.utils.XmlUtil;
import com.sinosoft.framework.core.context.SinoRequestContext;
import com.sinosoft.framework.core.service.impl.BaseServiceImpl;
import com.sinosoft.framework.core.utils.DateUtils;
import com.sinosoft.framework.core.utils.StringUtils;
import com.sinosoft.framework.dto.PageInfo;
import com.sinosoft.framework.exception.BusinessException;
import com.sinosoft.framework.exception.DataVerifyException;
import com.sinosoft.ims.api.auth.UtiGroupApi;
import com.sinosoft.ims.api.auth.dto.AddCodePowerConditionDto;
import com.sinosoft.ims.api.kernel.PrpDcompanyApi;
import com.sinosoft.ims.api.kernel.PrpDuserApi;
import com.sinosoft.ims.api.kernel.dto.PrpDcompanyDto;
import com.sinosoft.ims.api.kernel.dto.PrpDuserDto;
import com.sinosoft.pms.api.kernel.*;
import com.sinosoft.pms.api.kernel.dto.*;
import com.sinosoft.txnlist.api.gisinsurelist.GisInsureListApi;
import com.sinosoft.txnlist.api.gisinsurelist.dto.GisInsureListDto;
import com.sinosoft.txnlist.api.gisinsurelist.dto.GisInsureMainListDto;
import com.sinosoft.txnlist.api.insuremainlist.InsureMainListApi;
import com.sinosoft.txnlist.api.insuremainlist.QueryPoilcyListApi;
import com.sinosoft.txnlist.api.insuremainlist.dto.InsureMainListDto;
import com.sinosoft.txnlist.api.insuremainlist.dto.RequestQueryPolicyDto;
import com.sinosoft.txnlist.api.plantinginsurancelist.InsurePreliminaryConfirmApi;
import com.sinosoft.txnlist.api.plantinginsurancelist.dto.InsurePreliminaryConfirmDto;
import org.apache.cxf.jaxws.JaxWsProxyFactoryBean;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *  投保单信息查询实现类
 * @Author: 王心洋
 * @Date: 2017/10/26 19:00
 */

@Service
public class PolicyQueryServiceImpl extends BaseServiceImpl implements PolicyQueryService {
    /** log日志 */
    private static final Logger LOGGER = LoggerFactory.getLogger(PolicyQueryServiceImpl.class);

    @PersistenceContext
    private EntityManager entityManager;

    @Autowired
    private PrpCmainDao prpCmainDao;

    @Autowired
    private PrpCmainAgriDao prpCmainAgriDao;
    @Autowired
    private PrpCrenewalDao prpCrenewalDao;
    @Autowired
    private PrpCinsuredDao prpCinsuredDao;
    @Autowired
    private PrpCitemKindAgriDao prpCitemKindAgriDao;
    @Autowired
    private PrpCexpenseDao      prpCexpenseDao;
    @Autowired
    private PrpCaddressDao      prpCaddressDao;
    @Autowired
    private PrpCsubsidyDao      prpCsubsidyDao;
    @Autowired
    private PrpCitemKindDao     prpCitemKindDao;
    @Autowired
    private PrpCengageDao       prpCengageDao;
    @Autowired
    private PrpCfeildDao        prpCfeildDao;
    @Autowired
    private PrpCfeeDao          prpCfeeDao;
    @Autowired
    private PrpCplanDao         prpCplanDao;
    @Autowired
    private PrpCcoinsDao        prpCcoinsDao;
    @Autowired
    private PrpCcoinsDetailDao  prpCcoinsDetailDao;
    @Autowired
    private PrpCplanCoinsDao    prpCplanCoinsDao;
    @Autowired
    private PrpDcodeApi prpDcodeApi;
    @Autowired
    private PrpTownCodeApi prpTownCodeApi ;
    @Autowired
    private PrpCountryCodeApi prpCountryCodeApi;
    @Autowired
    private PrpDcustomLevelTraceApi prpDcustomLevelTraceApi ;
    @Autowired
    private PrpDcurrencyApi prpDcurrencyApi ;
    @Autowired
    private PrpDuserApi prpDuserApi ;
    @Autowired
    private UtiGroupApi utiGroupApi;
    @Autowired
    private PolicyQueryDao policyQueryDao;
    @Autowired
    private PrpDcompanyApi prpDcompanyApi;
    @Autowired
    private InsureMainListApi insureMainListApi;
    @Autowired
    private InsurePreliminaryConfirmApi insurePreliminaryConfirmApi;
    @Autowired
    private PrpDcustomerTaxPayInfoApi prpDcustomerTaxPayInfoApi;
    @Autowired
    private PrpDriskApi prpDriskApi;
    @Autowired
    private PrpDrelationClauseCodeApi prpDrelationClauseCodeApi  ;
    @Autowired
    private PrpDclauseApi prpDclauseApi;
    @Autowired
    private GisInsureListApi gisInsureListApi;
    @Autowired
    private PrpdclassApi prpdclassApi;
    @Autowired
    private QueryPoilcyListApi queryPoilcyListApi;
    @Autowired
    private PrpDclauseCodeApi prpDclauseCodeApi;
    @Value("${sysconfig.common.systemFlag}")
    private String systemFlag;//新农险标识（mian表中的systemflag,用于区分新农险系统与老系统的数据）

    @Value("${webservice.webAgriPrpallService.url}")
    private String webAgriPrpallServiceUrl;
    /**
     * 定义返回的失败码为9999
     */
    private String failCode = "9999";
    /**
     *  类功能简述：根据查询入参的条件以及查询方式分页查询保单列表信息
     *               实现逻辑概述：1.校验关键入参是否为空，校验页码是否页码信息
     *                            2.根据入参拼接查询条件
     *                            3.用封装的查询条件查询总记录数
     *                            4.总记录数>0时，查询投保单列表信息
     *                            5.遍历查询结果将投保单列表信息封装到PageInfo返回给前端
     * @author: 王心洋
     * @date: 2017/10/26 19:22
     * @param requestDto 封装查询条件数据以及查询方式、页码信息请求参数
     * @return pageInfo 分页查询结果
     * @throws Exception 数据校验异常、数据库异常
     */
    @Override
    public PageInfo<ResponseQueryPolicyListInfoDto> queryPolicyListByConditon(RequestQueryPolicyListInfoDto requestDto) throws Exception {
        // 查询数据HQL
        StringBuilder dataHql=new StringBuilder("select pt from PrpCmain pt where");
        // 查询总数量的HQL
        StringBuilder countHql=new StringBuilder("select count(1) from PrpCmain pt where");
        // 条件hql拼接
        StringBuilder condition=new StringBuilder();
        Map<String, Object> conditions = new HashMap<>();
        // 存放条件数据
        /*// 验证登录机构comCode 改造
        if (!"0000000000".equals(requestDto.getPowerSystemCode())) {
            condition.append(" pt.comCode NOT LIKE '%YL%'");
        }*/
        //区分新老系统标识
        condition.append(" AND pt.systemFlag = :systemFlag");
        conditions.put("systemFlag",systemFlag);
        if ("imagingSystemFlag".equals(requestDto.getImagingSystemFlag())) {
            requestDto.setProposalNo("");
        }
        //投保单号proposalNo
        if (StringUtils.isNotEmpty(requestDto.getProposalNo())) {
            condition.append(" AND pt.proposalNo like :proposalNo ");
            conditions.put("proposalNo", requestDto.getProposalNo() + "%");
        }
        //获取权限查询条件
        AddCodePowerConditionDto addCodePowerConditionDto =new AddCodePowerConditionDto(requestDto.getUserCode(),requestDto.getLoginComCode(),
                requestDto.getLoginGradeCodes(),requestDto.getTableName(),requestDto.getUserCodeFields(),
                requestDto.getComCodeFields(), "", "pt", true);
        String codePower = utiGroupApi.addCodePower(addCodePowerConditionDto);
        condition.append(codePower);
        //打印状态printFlag 1
        if (StringUtils.isNotEmpty(requestDto.getPrintFlag())) {
            if ("0".equals(requestDto.getPrintFlag())) {
                condition.append(" AND pt.printNo is NULL  ");
            } else if ("1".equals(requestDto.getPrintFlag()))
                condition.append(" AND pt.printNo is not NULL ");
        }
        if (StringUtils.isNotEmpty(requestDto.getfName()) || StringUtils.isNotEmpty(requestDto.getfCode())) {
            RequestQueryPolicyDto requestQueryPolicyDto = new RequestQueryPolicyDto();
            requestQueryPolicyDto.setfName(requestDto.getfName());
            requestQueryPolicyDto.setfCode(requestDto.getfCode());
            Map<String, String> stringMap = queryPoilcyListApi.queryPoilcyNo(requestQueryPolicyDto);
            if (StringUtils.isEmpty(stringMap.get("policyWhere"))) {
                condition.append(" AND pt.policyNo is null ");
            } else {
                condition.append(" AND pt.policyNo in ( " + stringMap.get("policyWhere") + ") ");
            }
        }
        //验证险种riskCode
        if (StringUtils.isNotEmpty(requestDto.getRiskCode())) {
            condition.append(" AND pt.riskCode = :riskCode ");
            conditions.put("riskCode", requestDto.getRiskCode());
        }
        //保单号policyNo 1-保单查询，2-特殊批改保单查询 1
        if ("1".equals(requestDto.getQueryFlag())) {
            if (StringUtils.isNotEmpty(requestDto.getPolicyNo())) {
                condition.append(" AND pt.policyNo like :policyNo ");
                conditions.put("policyNo", requestDto.getPolicyNo() + "%");
            }
        } else if ("2".equals(requestDto.getQueryFlag())) {
            if (StringUtils.isNotEmpty(requestDto.getPolicyNo())) {
                condition.append(" AND pt.policyNo between :policyNo and :policyNoEnd ");
                conditions.put("policyNo", requestDto.getPolicyNo());
                conditions.put("policyNoEnd", requestDto.getPolicyNoEnd());
            }
            if (requestDto.getPolicyNoRan() != null && requestDto.getPolicyNoRan().size() > 0) {
                StringBuffer stringBuffer1 = new StringBuffer();
                for (String billNo : requestDto.getPolicyNoRan()) {
                    stringBuffer1.append("'" + billNo + "',");
                }
                String str = stringBuffer1.toString().substring(0, stringBuffer1.toString().length() - 1);
                condition.append(" AND pt.policyNo in (" + str + ") ");
            }
        }

        //投保人代码appliCode 1
        if (StringUtils.isNotEmpty(requestDto.getAppliCode())) {
            condition.append(" AND pt.appliCode = :appliCode ");
            conditions.put("appliCode",requestDto.getAppliCode());
        }
        //投保人名称appliName 1
        if (StringUtils.isNotEmpty(requestDto.getAppliName())) {
            condition.append(" AND pt.appliName like :appliName ");
            conditions.put("appliName","%" +requestDto.getAppliName()+ "%");
        }
        //被保险人代码insuredCode 1
        if (StringUtils.isNotEmpty(requestDto.getInsuredCode())) {
            condition.append("  AND pt.insuredCode = :insuredCode ");
            conditions.put("insuredCode",requestDto.getInsuredCode());
        }
        //被保险人名称insuredName 1
        if (StringUtils.isNotEmpty(requestDto.getInsuredName())) {
            condition.append(" AND pt.insuredName LIKE :insuredName ");
            conditions.put("insuredName","%"+requestDto.getInsuredName()+"%");
        }
        //起保日期startDate 区间
        if (StringUtils.isNotEmpty(requestDto.getStartDate())) {
            condition.append(" AND pt.startDate >= to_date(:startDate, 'yyyy-mm-dd hh24:mi:ss') ");
            conditions.put("startDate",requestDto.getStartDate());
        }
        if (StringUtils.isNotEmpty(requestDto.getStartDateEnd())) {
            condition.append(" AND pt.startDate <= to_date(:startDateEnd, 'yyyy-mm-dd hh24:mi:ss') ");
            conditions.put("startDateEnd", requestDto.getStartDateEnd());
        }
        //终保日期endDate 区间
        if (StringUtils.isNotEmpty(requestDto.getEndDate())) {
            condition.append(" AND pt.endDate >= to_date(:endDate, 'yyyy-mm-dd hh24:mi:ss') ");
            conditions.put("endDate",requestDto.getEndDate());
        }
        if (StringUtils.isNotEmpty(requestDto.getEndStartDate())) {
            condition.append(" AND pt.endDate <= to_date(:endStartDate, 'yyyy-mm-dd hh24:mi:ss') ");
            conditions.put("endStartDate", requestDto.getEndStartDate());
        }
        //总保额sumAmount 1
        if (StringUtils.isNotEmpty(requestDto.getSumAmount())) {
            condition.append(" AND pt.sumAmount = :sumAmount ");
            conditions.put("sumAmount", Double.parseDouble(requestDto.getSumAmount()));
        }
        //总保费sumPremium 1
        if(StringUtils.isNotEmpty(requestDto.getSumPremium())) {
            condition.append(" AND pt.sumPremium = :sumPremium ");
            conditions.put("sumPremium", Double.parseDouble(requestDto.getSumPremium()));
        }
        //出单机构makeCom 1
        if (StringUtils.isNotEmpty(requestDto.getComCode())) {
            condition.append(" AND pt.comCode = :comCode ");
            conditions.put("comCode",requestDto.getComCode());
        }
        //业务员代码handlerCode 1
        if (StringUtils.isNotEmpty(requestDto.getHandlerCode())) {
            condition.append(" AND pt.handlerCode = :handlerCode ");
            conditions.put("handlerCode",requestDto.getHandlerCode());
        }
        //操作员代码operatorCode 1
        if (StringUtils.isNotEmpty(requestDto.getOperatorCode())) {
            condition.append(" AND pt.operatorCode = :operatorCode ");
            conditions.put("operatorCode",requestDto.getOperatorCode());
        }
        //制单日期operateDate 1
        if (StringUtils.isNotEmpty(requestDto.getOperateDateStart())) {
            condition.append(" AND pt.operateDate >= to_date(:operateDateStart, 'yyyy-mm-dd hh24:mi:ss') ");
            conditions.put("operateDateStart", requestDto.getOperateDateStart());
        }
        if (StringUtils.isNotEmpty(requestDto.getOperateDateEnd())) {
            condition.append(" AND pt.operateDate <= to_date(:operateDateEnd, 'yyyy-mm-dd hh24:mi:ss') ");
            conditions.put("operateDateEnd", requestDto.getOperateDateEnd());
        }


        //政策/商业标志businessType1 1
        if (StringUtils.isNotEmpty(requestDto.getBusinessType1())) {
            condition.append(" AND pt.businessType1 = :businessType1 ");
            conditions.put("businessType1",requestDto.getBusinessType1());
        }

        //核保状态
        if (StringUtils.isNotEmpty(requestDto.getUnderWriteFlag())) {
            condition.append(" AND pt.underWriteFlag :underWriteFlag ");
            conditions.put("underWriteFlag", requestDto.getUnderWriteFlag());
        }
        // 查询总数据量的Hql拼接
        String where = condition.toString().replaceFirst("AND", "");
        countHql.append(where);
        // 查询数据hql拼接条件以及排序hql
        dataHql.append(where).append(" order by pt.policyNo desc ");
        javax.persistence.Query countQuery = entityManager.createQuery(countHql.toString());
        javax.persistence.Query dataQuery = entityManager.createQuery(dataHql.toString());
        // 设置参数
        for (String key:conditions.keySet()) {
            countQuery.setParameter(key,conditions.get(key));
            dataQuery.setParameter(key,conditions.get(key));
        }
        // 查询数据总条数
        long countNum = (long) countQuery.getSingleResult();
        dataQuery.setFirstResult((requestDto.getPageNo()-1)*requestDto.getPageSize());
        dataQuery.setMaxResults(requestDto.getPageSize());
// 查询数据
        List<PrpCmain> dataList = new ArrayList<>();
        List<ResponseQueryPolicyListInfoDto> responseList= new ArrayList<>();
        if(countNum>0) {// 当查询到的总记录数大于0才继续查询
            dataList = dataQuery.getResultList();
            ResponseQueryPolicyListInfoDto responseDto=null;
            //迭代查询结果
            for (int i = 0; i < dataList.size(); i++) {
                PrpCmain prpCmain = dataList.get(i);
                responseDto = new ResponseQueryPolicyListInfoDto();
                responseDto.setPolicyNo(prpCmain.getPolicyNo());
                responseDto.setContractNo(prpCmain.getContractNo());
                responseDto.setInsuredName(prpCmain.getInsuredName());
                responseDto.setAppliName(prpCmain.getAppliName());
                responseDto.setStartDate(DateUtils.dateToStr(prpCmain.getStartDate()));
                responseDto.setEndDate(DateUtils.dateToStr(prpCmain.getEndDate()));
                responseDto.setOperatorCode(prpCmain.getOperatorCode());
                responseDto.setOperatorName(this.getPrpDuserName(prpCmain.getOperatorCode()));
                responseDto.setInputDate(DateUtils.dateToStr(prpCmain.getInputDate()));
                responseDto.setUnderWriteFlag(prpCmain.getUnderwriteFlag());
                responseDto.setOthFlag(prpCmain.getOthFlag());
                responseDto.setPrintNo(prpCmain.getPrintNo());
                responseDto.setRiskCode(prpCmain.getRiskCode());
                responseDto.setOperateDate(DateUtils.dateToStr(prpCmain.getOperateDate()));
                responseDto.setProposalNo(prpCmain.getProposalNo());
                responseDto.setComCode(prpCmain.getComCode());
                responseDto.setBusinessType1(prpCmain.getBusinessType1());
                responseDto.setIsSeeFeeFlag(prpCmain.getIsSeeFeeFlag());
                String riskName="";
                if(StringUtils.isNotEmpty(prpCmain.getRiskCode())) {
                    Map map = new HashMap();
                    map.put("riskCode",prpCmain.getRiskCode());
                    map.put("isChinese",LanguageFlagConstant.CHINESE);
                    riskName=prpDriskApi.translateCode(map);
                }
                responseDto.setRiskName(riskName);
                responseList.add(responseDto);
            }
        }
        // 统一封装分页响应dto
        PageInfo<ResponseQueryPolicyListInfoDto> pageInfo=new PageInfo<>();
        pageInfo.setContent(responseList);// 数据存放dto集合
        pageInfo.setPages(requestDto.getPageNo());// 当前页数
        pageInfo.setTotalCount(countNum);// 总记录数
        return pageInfo;
    }

    /**
     * 用户名称
     *
     * @param code 用户代码
     * @return
     */
    public String getPrpDuserName(String code) throws Exception {
        List<String> list = new ArrayList<String>();
        list.add(code);
        List<String> nameList = prpDuserApi.queryOperatorName(list);
        String name = "";
        if (nameList != null && nameList.size() > 0) {
            name = nameList.get(0);
        }

        return name;
    }
    /**
     * 根据保单号码查询保单详细信息
     * @author: 王心洋
     * @date: 2017/10/26 19:22
     * @param map policyNo 保单号
     * @param map languageFlag 语言标志
     * @param map loginComCode 登录机构
     * @param map userCode 人员代码
     * @return ResponseQueryPolicyInfoDto 保单详细信息Dto
     * @throws Exception
     */
    @Override
    public ResponseQueryPolicyInfoDto queryPolicyInfoByPolicyNo(String policyNo, String languageFlag,String loginComCode,String userCode) throws Exception {

        if(StringUtils.isEmpty(languageFlag)){
            languageFlag = LanguageFlagConstant.CHINESE;
        }
        //获取权限查询条件
        String codePower = "";
        if (StringUtils.isNotEmpty(loginComCode) && StringUtils.isNotEmpty(userCode)) {
            AddCodePowerConditionDto addCodePowerConditionDto = new AddCodePowerConditionDto(userCode, loginComCode,
                    "", "PrpDcompany", "userCode",
                    "comCode", "", "p", true);
            codePower = utiGroupApi.addCodePower(addCodePowerConditionDto);
            if (StringUtils.isEmpty(codePower)) {//没有权限就返回null
                return null;
            }
        }
        StringBuilder checkSql = new StringBuilder("select p from PrpCmain p where policyNo=:policyNo and systemFlag=:systemFlag ");
        checkSql.append(codePower);
        Query checkQuery = entityManager.createQuery(checkSql.toString());
        checkQuery.setParameter("policyNo",policyNo);
        checkQuery.setParameter("systemFlag",systemFlag);
        List<PrpCmain> prpCmainList = checkQuery.getResultList();
        if(prpCmainList.size()<=0){//查询出来集合为空就放null
            return null;
        }
        //团单显示时不查询客户资料数据出来
        PrpCmain prpCmain = prpCmainList.get(0);
        if(prpCmain == null){
            throw new DataVerifyException("保单"+policyNo+"不存在！");
        }
        if(prpCmain==null || !systemFlag.equals(prpCmain.getSystemFlag())){//如果不是新系统数据，则返回空
            return null;
        }
        /**判断是否为团单*/
        /*String messType = prpCmain.getFlag();
        if(messType!=null && messType.length()>1){
            messType = messType.substring(1,2);
        }else{
            messType = "";
        }*/



        PrpCmainDto prpCmainDto                                ;
        PrpCmainAgriDto prpCmainAgriDto                            ;
        PrpCrenewalDto            prpCrenewalDto                             ;
        PrpCexpenseDto            prpCexpenseDto                             ;
        List<PrpCinsuredDto>      prpCinsuredDtoList      = new ArrayList<>();
        List<PrpCitemKindAgriDto> prpCitemKindAgriDtoList = new ArrayList<>();
        List<PrpCaddressDto     > prpCaddressDtoList      = new ArrayList<>();
        List<PrpCsubsidyDto     > prpCsubsidyDtoList      = new ArrayList<>();
        List<PrpCitemKindDto    > prpCitemKindDtoList     = new ArrayList<>();
        List<PrpCengageDto      > prpCengageDtoList       = new ArrayList<>();
        List<PrpCfeildDto       > prpCfeildDtoList        = new ArrayList<>();
        List<PrpCfeeDto         > prpCfeeDtoList          = new ArrayList<>();
        List<PrpCplanDto        > prpCplanDtoList         = new ArrayList<>();
        List<PrpCcoinsDto       > prpCcoinsDtoList        = new ArrayList<>();
        List<PrpCcoinsDetailDto > prpCcoinsDetailDtoList  = new ArrayList<>();
        List<PrpCplanCoinsDto   > prpCplanCoinsDtoList    = new ArrayList<>();
        InsurePreliminaryConfirmDto insurePreliminaryConfirmDto = new InsurePreliminaryConfirmDto();
        PrpDcustomerTaxPayInfoDto prpDcustomerTaxPayInfoDto = new PrpDcustomerTaxPayInfoDto();
        //被保险人
        PrpCinsuredDto prpCinsuredDtoIns = new PrpCinsuredDto();

        PrpCmainAgri prpCmainAgri         = prpCmainAgriDao.findOne(new PrpCmainAgriKey(policyNo));
        PrpCrenewal prpCrenewal          = prpCrenewalDao.findOne(new PrpCrenewalKey(policyNo));
        PrpCexpense prpCexpense          = prpCexpenseDao.findOne(new PrpCexpenseKey(policyNo));
        List<PrpCinsured>      prpCinsuredList      = prpCinsuredDao.findAll(QueryPolicySpecBuilder.findPrpCinsuredByPolicyNo(policyNo));
        List<PrpCitemKindAgri> prpCitemKindAgriList = prpCitemKindAgriDao.findAll(QueryPolicySpecBuilder.findPrpCitemKindAgriByPolicyNo(policyNo));
        List<PrpCaddress     > prpCaddressList      = prpCaddressDao.findAll(QueryPolicySpecBuilder.findPrpCaddressByPolicyNo(policyNo));
        List<PrpCsubsidy     > prpCsubsidyList      = prpCsubsidyDao.findAll(QueryPolicySpecBuilder.findPrpCsubsidyByPolicyNo(policyNo));
        List<PrpCitemKind    > prpCitemKindList     = prpCitemKindDao.findAll(QueryPolicySpecBuilder.findPrpCitemKindByPolicyNo(policyNo));
        List<PrpCengage     > prpCengageList       = prpCengageDao.findByPolicyNo(policyNo);
        List<PrpCfeild       > prpCfeildList        = prpCfeildDao.findAll(QueryPolicySpecBuilder.findPrpCfeildByPolicyNo(policyNo));
        List<PrpCfee         > prpCfeeList          = prpCfeeDao.findAll(QueryPolicySpecBuilder.findPrpCfeeByPolicyNo(policyNo));
        List<PrpCplan        > prpCplanList         = prpCplanDao.findAll(QueryPolicySpecBuilder.findPrpCplanByPolicyNo(policyNo));
        List<PrpCcoins       > prpCcoinsList        = prpCcoinsDao.findAll(QueryPolicySpecBuilder.findPrpCcoinsByPolicyNo(policyNo));
        List<PrpCcoinsDetail > prpCcoinsDetailList  = prpCcoinsDetailDao.findAll(QueryPolicySpecBuilder.findPrpCcoinsDetailByPolicyNo(policyNo));
        List<PrpCplanCoins   > prpCplanCoinsList    = prpCplanCoinsDao.findAll(QueryPolicySpecBuilder.findPrpCplanCoinsByPolicyNo(policyNo));

        prpCmainDto = this.convert(prpCmain,PrpCmainDto.class);
        prpCmainAgriDto = this.convert(prpCmainAgri,PrpCmainAgriDto.class);
        prpCrenewalDto = this.convert(prpCrenewal,PrpCrenewalDto.class);
        prpCexpenseDto = this.convert(prpCexpense,PrpCexpenseDto.class);
        this.convertCollection(prpCinsuredList,prpCinsuredDtoList,PrpCinsuredDto.class);
        this.convertCollection(prpCitemKindAgriList,prpCitemKindAgriDtoList,PrpCitemKindAgriDto.class);
        this.convertCollection(prpCaddressList,prpCaddressDtoList,PrpCaddressDto.class);
        this.convertCollection(prpCsubsidyList,prpCsubsidyDtoList,PrpCsubsidyDto.class);
        this.convertCollection(prpCitemKindList,prpCitemKindDtoList,PrpCitemKindDto.class);
        this.convertCollection(prpCengageList,prpCengageDtoList,PrpCengageDto.class);
        this.convertCollection(prpCfeildList,prpCfeildDtoList,PrpCfeildDto.class);
        this.convertCollection(prpCfeeList,prpCfeeDtoList,PrpCfeeDto.class);
        this.convertCollection(prpCplanList,prpCplanDtoList,PrpCplanDto.class);
        this.convertCollection(prpCcoinsList,prpCcoinsDtoList,PrpCcoinsDto.class);
        this.convertCollection(prpCcoinsDetailList,prpCcoinsDetailDtoList,PrpCcoinsDetailDto.class);
        this.convertCollection(prpCplanCoinsList,prpCplanCoinsDtoList,PrpCplanCoinsDto.class);


        String listTypeFlag="";
        String insureListCode="";
        GisInsureMainListDto gisInsureMainListDto=new GisInsureMainListDto();
        /** 获取金禾清单号，添加金禾清单对象 add by 王心洋 20180104 */
        List<InsureMainListDto> insureMainListDtoList = insureMainListApi.queryByPolicyNo(policyNo);
        if (insureMainListDtoList!=null && insureMainListDtoList.size()!=0) {
            String gisInsureListCode = "";
            Map<String, String> map = new HashMap<>();
            gisInsureListCode = insureMainListDtoList.get(0).getGisInsureListCode();
            Integer serialNo = insureMainListDtoList.get(0).getSerialNo();

            String serialNo1 = String.valueOf(serialNo);
            Map<String, String> map5 = new HashMap<>();
            map5.put("gisInsureMainListCode", gisInsureListCode);
            map5.put("serialNo", serialNo1);
            map5.get("serialNo");
            gisInsureMainListDto=gisInsureListApi.queryByPk(map5);
            //因为删除数据理赔不能用 加了个非空判断为了让代码过去 有问题请找我 王保良
            if (gisInsureMainListDto != null) {
                listTypeFlag = gisInsureMainListDto.getListType();
                insureListCode = gisInsureMainListDto.getInsureListCode();
            }
        }

//        if(StringUtils.isNotEmpty(gisInsureListCode)){
//            map.put("insureListCode",gisInsureListCode);
//            insurePreliminaryConfirmDto = insurePreliminaryConfirmApi.queryInsurePreliminarydConfirm(map);
//        }


        String riskCode = prpCmain.getRiskCode();

        String businessProvinceName = "";
        String businessTownName = "";
        String businessCountyName = "";
        String businessCityName = "";
        String businessAreaName = "";
        String jobtitleName = "";
        String businessSortName = "";
        String insuredIdentityName = "";
        String riskLevelName = "";
        String insuredTypeName = "";
        String insuredFlagName = "";
        String insuredNatureName = "";
        String insuredLanguageName = "";
        String feeCurrencyName = "";
        String feeCurrencyName1 = "";
        String feeCurrencyName2 = "";
        String planCurrencyName = "";
        //归属机构
        String comName = "";
        //经办人
        String tHandlerName = "";
        //归属业务员
        String tHandler1Name = "";
        //最近修改员
        String updaterName = "";
        //操作员
        String operatorName = "";
        //险种名称
        String riskCodeName = "";
        //险类名称
        String className="";


        //下拉选内容，单独放入ResponseDto里
        List<PrpDcodeDto> riskCodeNameList = prpDcodeApi.queryCodeInfoByCodeType("PolicyType",riskCode);
        List<PrpDcodeDto> languageNameList = prpDcodeApi.queryCodeInfoByCodeType("Language",riskCode);
        List<PrpDcodeDto> businessNatureNameList = prpDcodeApi.queryCodeInfoByCodeType("Language",riskCode);
        List<PrpDcodeDto> policySortNameList = prpDcodeApi.queryCodeInfoByCodeType("PolicySort",riskCode);
        List<PrpDcodeDto> businessTypeNameList = prpDcodeApi.queryCodeInfoByCodeType("BusinessType0",riskCode);
        List<PrpDcodeDto> businessTypeNameList1 = prpDcodeApi.queryCodeInfoByCodeType("BusinessType1",riskCode);
        List<PrpDcodeDto> statUnitCodeNameList = prpDcodeApi.queryCodeInfoByCodeType("Unit",riskCode);
        List<PrpDcodeDto> articleTypeNameList = prpDcodeApi.queryCodeInfoByCodeType("ArticleType",riskCode);
        List<PrpDcodeDto> cattleTypeNameList = prpDcodeApi.queryCodeInfoByCodeType("CattleType",riskCode);
        List<PrpDcodeDto> raiseTypeNameList = new ArrayList<>();

        if(StringUtils.isNotEmpty(prpCmain.getBusinessProvince())) {
            businessProvinceName = prpDcodeApi.translateCode("BusinessZone", prpCmain.getBusinessProvince(), languageFlag);
        }
        if(StringUtils.isNotEmpty(prpCmain.getBusinessTown())) {
            businessTownName = prpDcodeApi.translateCode("BusinessZone", prpCmain.getBusinessTown(), languageFlag);
        }
        if(StringUtils.isNotEmpty(prpCmain.getBusinessCounty())) {
            businessCountyName = prpDcodeApi.translateCode("BusinessZone", prpCmain.getBusinessTown(), languageFlag);
        }
        if(StringUtils.isNotEmpty(prpCmain.getBusinessCity())) {
            PrpTownCodeDto prpTownCodeDto = prpTownCodeApi.queryByPK(prpCmainDto.getBusinessCity());
            if (prpTownCodeDto!=null){
                businessCityName = prpTownCodeDto.getCodeCname();
            }
        }
        if(StringUtils.isNotEmpty(prpCmain.getBusinessArea())) {
            PrpCountryCodeDto prpCountryCodeDto = prpCountryCodeApi.queryByCodeCode(prpCmainDto.getBusinessArea());
            if (prpCountryCodeDto != null){
                businessAreaName = prpCountryCodeDto.getCodeCName();
            }
        }
        if(StringUtils.isNotEmpty(riskCode)) {
            Map<String,String> map1 = new HashMap<>();
            map1.put("riskCode",riskCode);
            PrpDriskDto prpDriskDto = prpDriskApi.queryByPK(map1);
            if (prpDriskDto!= null){
                riskCodeName = prpDriskDto.getRiskCName();
            }
        }

        if(StringUtils.isNotEmpty(prpCmainDto.getClassCode())){
            PrpDclassDto prpDclassDto=prpdclassApi.queryByPK(prpCmainDto.getClassCode());
            if(prpDclassDto!=null){
                className=prpDclassDto.getClassName();
            }
        }
        if(LanguageFlagConstant.CHINESE.equals(languageFlag)){
            if(StringUtils.isNotEmpty(prpCmainDto.getComCode())) {
                PrpDcompanyDto prpDcompanyDto = prpDcompanyApi.queryByPK(prpCmainDto.getComCode());
                if (prpDcompanyDto!= null){
                    comName = prpDcompanyDto.getComCName();
                }
            }
            if(StringUtils.isNotEmpty(prpCmainDto.getHandlerCode())) {
                PrpDuserDto prpDuserDto = prpDuserApi.queryByPK(prpCmainDto.getHandlerCode());
                if (prpDuserDto!=null) {
                    tHandlerName = prpDuserDto.getUserName();
                }
            }
            if(StringUtils.isNotEmpty(prpCmainDto.getHandler1Code())) {
                PrpDuserDto prpDuserDto = prpDuserApi.queryByPK(prpCmainDto.getHandler1Code());
                if (prpDuserDto!=null) {
                    tHandler1Name = prpDuserDto.getUserName();
                }
            }
            if(StringUtils.isNotEmpty(prpCmainDto.getUpdaterCode())){
                PrpDuserDto prpDuserDto = prpDuserApi.queryByPK(prpCmainDto.getUpdaterCode());
                if (prpDuserDto!=null){
                    updaterName = prpDuserDto.getUserName();
                }
            }
            if(StringUtils.isNotEmpty(prpCmainDto.getOperatorCode())){
                PrpDuserDto prpDuserDto = prpDuserApi.queryByPK(prpCmainDto.getOperatorCode());
                if (prpDuserDto != null ){
                    operatorName = prpDuserDto.getUserName();
                }
            }
        }else{
            if(StringUtils.isNotEmpty(prpCmainDto.getComCode())) {
                PrpDcompanyDto prpDcompanyDto = prpDcompanyApi.queryByPK(prpCmainDto.getComCode());
                if (prpDcompanyDto!= null){
                    comName = prpDcompanyDto.getComEName();
                }
            }
            if(StringUtils.isNotEmpty(prpCmainDto.getHandlerCode())) {
                PrpDuserDto prpDuserDto = prpDuserApi.queryByPK(prpCmainDto.getHandlerCode());
                if (prpDuserDto!= null){
                    tHandlerName = prpDuserDto.getUserEName();
                }
            }
            if(StringUtils.isNotEmpty(prpCmainDto.getHandler1Code())) {
                PrpDuserDto prpDuserDto = prpDuserApi.queryByPK(prpCmainDto.getHandler1Code());
                if (prpDuserDto != null){
                    tHandler1Name = prpDuserDto.getUserEName();
                }
            }
            if(StringUtils.isNotEmpty(prpCmainDto.getUpdaterCode())){
                PrpDuserDto prpDuserDto = prpDuserApi.queryByPK(prpCmainDto.getUpdaterCode());
                if (prpDuserDto!= null){
                    updaterName = prpDuserDto.getUserEName();
                }
            }
        }

        prpCmainDto.setBusinessProvinceName(businessProvinceName);
        prpCmainDto.setBusinessTownName(businessTownName);
        prpCmainDto.setBusinessCountyName(businessCountyName);
        prpCmainDto.setBusinessCityName(businessCityName);
        prpCmainDto.setBusinessAreaName(businessAreaName);
        prpCmainDto.setComName(comName);
        prpCmainDto.settHandlerName(tHandlerName);
        prpCmainDto.settHandler1Name(tHandler1Name);
        prpCmainDto.setUpdaterName(updaterName);
        prpCmainDto.setOperatorName(operatorName);
        prpCmainDto.setRiskCodeName(riskCodeName);
        prpCmainDto.setClassCodeName(className);


        //prpCinsured表数据
        for(int i=0;i<prpCinsuredDtoList.size();i++){
            jobtitleName = prpCinsuredDtoList.get(i).getJobTitle();
            businessSortName = prpCinsuredDtoList.get(i).getBusinessSort();
            insuredIdentityName = prpCinsuredDtoList.get(i).getInsuredIdentity();
            if(StringUtils.isNotEmpty(prpCinsuredDtoList.get(i).getInsuredCode())) {
                riskLevelName = prpDcustomLevelTraceApi.findRiskLevelByCode(prpCinsuredDtoList.get(i).getInsuredCode());
            }
            insuredTypeName = prpCinsuredDtoList.get(i).getInsuredType();
            insuredFlagName = prpCinsuredDtoList.get(i).getInsuredFlag();
            insuredNatureName = prpCinsuredDtoList.get(i).getInsuredNature();
            insuredLanguageName = prpCinsuredDtoList.get(i).getLanguage();
            if(StringUtils.isEmpty(jobtitleName)){
                jobtitleName = "00";
            }
            if(StringUtils.isEmpty(businessSortName)){
                businessSortName = "9999";
            }
            if(StringUtils.isNotEmpty(jobtitleName)){
                jobtitleName = prpDcodeApi.translateCode("BusinessType",jobtitleName,languageFlag);
            }
            if(StringUtils.isNotEmpty(businessSortName)){
                businessSortName = prpDcodeApi.translateCode("BusinessSort",businessSortName,languageFlag);
            }
            if(StringUtils.isNotEmpty(insuredIdentityName)) {
                insuredIdentityName = prpDcodeApi.translateCode("InsuredIdentity", insuredIdentityName, languageFlag);
            }
            if(StringUtils.isNotEmpty(riskLevelName)) {
                riskLevelName = prpDcodeApi.translateCode("RiskLevel", riskLevelName, languageFlag);
            }
            if(StringUtils.isNotEmpty(insuredTypeName)) {
                insuredTypeName = prpDcodeApi.translateCode("InsuredType", insuredTypeName, languageFlag);
            }
            if(StringUtils.isNotEmpty(insuredFlagName)) {
                insuredFlagName = prpDcodeApi.translateCode("InsuredFlag", insuredFlagName, languageFlag);
            }
            if(StringUtils.isNotEmpty(insuredNatureName)) {
                insuredNatureName = prpDcodeApi.translateCode("BusinessDetail", insuredNatureName, languageFlag);
            }
            if(StringUtils.isNotEmpty(insuredLanguageName)) {
                insuredLanguageName = prpDcodeApi.translateCode("Language", insuredLanguageName, languageFlag);
            }

            prpCinsuredDtoList.get(i).setJobtitleName(jobtitleName);
            prpCinsuredDtoList.get(i).setBusinessSortName(businessSortName);
            prpCinsuredDtoList.get(i).setInsuredIdentityName(insuredIdentityName);
            prpCinsuredDtoList.get(i).setRiskLevelName(riskLevelName);
            prpCinsuredDtoList.get(i).setInsuredTypeName(insuredTypeName);
            prpCinsuredDtoList.get(i).setInsuredFlagName(insuredFlagName);
            prpCinsuredDtoList.get(i).setInsuredNatureName(insuredNatureName);
            prpCinsuredDtoList.get(i).setInsuredLanguageName(insuredLanguageName);

            //根据投保人查询发票信息
            if(prpCinsuredDtoList.get(i)!= null && "2".equals(prpCinsuredDtoList.get(i).getInsuredFlag())){//投保人
                PrpCinsuredDto prpCinsuredDto = prpCinsuredDtoList.get(i);
                if (prpCinsuredDto!= null){
                    prpDcustomerTaxPayInfoDto = prpDcustomerTaxPayInfoApi.queryByPK(prpCinsuredDto.getInsuredCode());
                }
            }
            if(prpCinsuredDtoList.get(i) != null && "1".equals(prpCinsuredDtoList.get(i).getInsuredFlag())){//被保人
                prpCinsuredDtoIns = prpCinsuredDtoList.get(i);
            }
        }
        //处理发票信息
        if(prpCinsuredDtoIns != null && prpDcustomerTaxPayInfoDto!= null){
            if(prpDcustomerTaxPayInfoDto.getPayInfoObject()!=null && "2".equals(prpDcustomerTaxPayInfoDto.getPayInfoObject())){
                prpDcustomerTaxPayInfoDto = prpDcustomerTaxPayInfoApi.queryByPK(prpCinsuredDtoIns.getInsuredCode());
            }
        } else {
            prpDcustomerTaxPayInfoDto = prpDcustomerTaxPayInfoApi.queryByPK(prpCinsuredDtoIns.getInsuredCode());
        }


        //prpcMainAgri表翻译
        if(prpCmainAgriDto!=null){
            if("3137".equals(riskCode)||"3139".equals(riskCode)||"3173".equals(riskCode)){
                raiseTypeNameList = prpDcodeApi.queryCodeInfoByCodeType("HRaiseType",riskCode);
            }
        }
        //prpCfee表
        for(int i=0;i<prpCfeeDtoList.size();i++){
            //翻译币别名称
            String currency2Name=prpDcodeApi.queryByPK("CURRENCY_CI",prpCfeeDtoList.get(i).getCurrency2()).getCodeCName();
            prpCfeeDtoList.get(i).setCurrency2Name(currency2Name);

            feeCurrencyName = prpCfeeDtoList.get(i).getCurrency();
            if(StringUtils.isNotEmpty(feeCurrencyName)) {
                feeCurrencyName = prpDcurrencyApi.translateCode(feeCurrencyName, languageFlag);
            }
            if(feeCurrencyName1.length()==0){
                feeCurrencyName1 = prpCfeeDtoList.get(i).getCurrency1();
                if(StringUtils.isNotEmpty(feeCurrencyName1)) {
                    feeCurrencyName1 = prpDcurrencyApi.translateCode(feeCurrencyName1, languageFlag);
                }
                feeCurrencyName2 = prpCfeeDtoList.get(i).getCurrency2();
                if(StringUtils.isNotEmpty(feeCurrencyName2)) {
                    feeCurrencyName2 = prpDcurrencyApi.translateCode(feeCurrencyName2, languageFlag);
                }
            }
            prpCfeeDtoList.get(i).setFeeCurrencyName(feeCurrencyName);
            prpCfeeDtoList.get(i).setFeeCurrencyName1(feeCurrencyName1);
            prpCfeeDtoList.get(i).setFeeCurrencyName2(feeCurrencyName2);
        }
        //prpCplan表
        for(int i=0;i<prpCplanDtoList.size();i++){
            planCurrencyName = prpCplanDtoList.get(i).getCurrency();
            if(StringUtils.isNotEmpty(planCurrencyName)) {
                planCurrencyName = prpDcurrencyApi.translateCode(planCurrencyName, languageFlag);
            }
            prpCplanDtoList.get(i).setPlanCurrencyName(planCurrencyName);
        }
        // 特别约定信息
        List<QueryProposalPrpTengageDto> prpTengageDtoList = new ArrayList<>();
        QueryProposalPrpTengageDto prpTengageDto = null;
        for (PrpCengage prpCengage : prpCengageList) {
            if (prpTengageDto == null || !prpCengage.getClauseCode().equals(prpTengageDto.getClauseCode())) {
                prpTengageDto = new QueryProposalPrpTengageDto();
                prpTengageDto.setClauseCode(prpCengage.getClauseCode());
                prpTengageDto.setSerialNo(prpCengage.getSerialNo());
                prpTengageDto.setFlag(prpCengage.getFlag());
                prpTengageDtoList.add(prpTengageDto);
            }
            // t特约标题名称
            if ("0".equals(prpCengage.getTitleFlag())) {
                prpTengageDto.setClauseName(prpCengage.getClauses());
            } else {
                if (StringUtils.isEmpty(prpTengageDto.getClausesContent())) {
                    prpTengageDto.setClausesContent(prpCengage.getClauses());
                } else {
                    prpTengageDto.setClausesContent(prpTengageDto.getClausesContent() + prpCengage.getClauses());
                }
            }
        }

        GisInsureListDto gisInsureListDto= new GisInsureListDto();
        gisInsureListDto.setGisInsureMainListDto(gisInsureMainListDto);



        ResponseQueryPolicyInfoDto responseDto = new ResponseQueryPolicyInfoDto();
        responseDto.setGisInsureListDto(gisInsureListDto);
        responseDto.setPrpCengageDtoList(prpCengageDtoList);
        responseDto.setQueryProposalPrpTengageDtoList(prpTengageDtoList);
        responseDto.setPrpCmainDto(prpCmainDto);
        responseDto.setPrpCmainAgriDto(prpCmainAgriDto);
        responseDto.setPrpCrenewalDto(prpCrenewalDto);
        responseDto.setPrpCinsuredDtoList(prpCinsuredDtoList);
        responseDto.setPrpCitemKindAgriDtoList(prpCitemKindAgriDtoList);
        responseDto.setPrpCexpenseDto(prpCexpenseDto);
        responseDto.setPrpCaddressDtoList(prpCaddressDtoList);
        responseDto.setPrpCsubsidyDtoList(prpCsubsidyDtoList);
        responseDto.setPrpCitemKindDtoList(prpCitemKindDtoList);
        responseDto.setPrpCfeildDtoList(prpCfeildDtoList);
        responseDto.setPrpCfeeDtoList(prpCfeeDtoList);
        responseDto.setPrpCplanDtoList(prpCplanDtoList);
        responseDto.setPrpCcoinsDtoList(prpCcoinsDtoList);
        responseDto.setPrpCcoinsDetailDtoList(prpCcoinsDetailDtoList);
        responseDto.setPrpCplanCoinsDtoList(prpCplanCoinsDtoList);
        responseDto.setRiskCodeNameList(riskCodeNameList);
        responseDto.setLanguageNameList(languageNameList);
        responseDto.setBusinessNatureNameList(businessNatureNameList);
        responseDto.setPolicySortNameList(policySortNameList);
        responseDto.setBusinessTypeNameList(businessTypeNameList);
        responseDto.setBusinessTypeNameList1(businessTypeNameList1);
        responseDto.setStatUnitCodeNameList(statUnitCodeNameList);
        responseDto.setArticleTypeNameList(articleTypeNameList);
        responseDto.setCattleTypeNameList(cattleTypeNameList);
        responseDto.setRaiseTypeNameList(raiseTypeNameList);
        responseDto.setInsurePreliminaryConfirmDto(insurePreliminaryConfirmDto);
        responseDto.setPrpDcustomerTaxPayInfoDto(prpDcustomerTaxPayInfoDto);
        responseDto.setListTypeFlag(listTypeFlag);
        responseDto.setInsureListCode(insureListCode);
        return responseDto;
    }

    /**
     * 根据起始保单号，结束保单号区间查询保单号
     * @author: 刘曼曼
     * @date: 2017/11/22 17:02
     * @param startPolicyNo 起始保单号
     * @param endPolicyNo  结束保单号
     * @return List<String> 保单号集合
     */
    public List<String> queryPolicyNoList(String startPolicyNo,String endPolicyNo) throws Exception{
        if(StringUtils.isEmpty(startPolicyNo)){
            throw  new DataVerifyException("起始保单号不能为空！");
        }
        if(StringUtils.isEmpty(startPolicyNo)){
            throw  new DataVerifyException("结束保单号不能为空！");
        }
        if(startPolicyNo.length() != 21 || endPolicyNo.length() != 21){
            throw new DataVerifyException("保单号位数不正确");
        }
        String reg="^\\d*$";
        if(!startPolicyNo.matches(reg)||!endPolicyNo.matches(reg)){
            throw new DataVerifyException("保单号不正确");
        }

        List<String> policyList=prpCmainDao.queryPolicyNoList(startPolicyNo,endPolicyNo);

        return policyList;
    }

    /**
     * 根据保单号获取保单
     * @author: 刘曼曼
     * @date: 2017/11/29 8:55
     * @param policyNo 保单号
     * @return ResponseQueryPolicyInfoDto保单大对象
     * @throws Exception
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public ResponseQueryPolicyInfoDto queryPolicyInfoByPolicyNo(String policyNo) throws Exception {
        if (StringUtils.isEmpty(policyNo)){
            throw new DataVerifyException("保单号不能为空");
        }
        PrpCmainDto prpCmainDto;
        PrpCmainAgriDto prpCmainAgriDto;
        PrpCrenewalDto            prpCrenewalDto;
        PrpCexpenseDto            prpCexpenseDto;
        List<PrpCinsuredDto>      prpCinsuredDtoList      = new ArrayList<>();
        List<PrpCitemKindAgriDto> prpCitemKindAgriDtoList = new ArrayList<>();
        List<PrpCaddressDto     > prpCaddressDtoList      = new ArrayList<>();
        List<PrpCsubsidyDto     > prpCsubsidyDtoList      = new ArrayList<>();
        List<PrpCitemKindDto    > prpCitemKindDtoList     = new ArrayList<>();
        List<PrpCengageDto      > prpCengageDtoList       = new ArrayList<>();
        List<PrpCfeildDto       > prpCfeildDtoList        = new ArrayList<>();
        List<PrpCfeeDto         > prpCfeeDtoList          = new ArrayList<>();
        List<PrpCplanDto        > prpCplanDtoList         = new ArrayList<>();
        List<PrpCcoinsDto       > prpCcoinsDtoList        = new ArrayList<>();
        List<PrpCcoinsDetailDto > prpCcoinsDetailDtoList  = new ArrayList<>();
        List<PrpCplanCoinsDto   > prpCplanCoinsDtoList    = new ArrayList<>();

        PrpCmain prpCmain = prpCmainDao.findOne(new PrpCmainKey(policyNo));
        if (prpCmain==null){
            throw new DataVerifyException("保单号"+policyNo+"不存在");
        }
        if(prpCmain==null || !systemFlag.equals(prpCmain.getSystemFlag())){//如果不是新系统数据，则返回空
            return null;
        }
        PrpCmainAgri prpCmainAgri         = prpCmainAgriDao.findOne(new PrpCmainAgriKey(policyNo));
        PrpCrenewal prpCrenewal          = prpCrenewalDao.findOne(new PrpCrenewalKey(policyNo));
        PrpCexpense prpCexpense          = prpCexpenseDao.findOne(new PrpCexpenseKey(policyNo));
        List<PrpCinsured>      prpCinsuredList      = prpCinsuredDao.findAll(QueryPolicySpecBuilder.findPrpCinsuredByPolicyNo(policyNo));
        List<PrpCitemKindAgri> prpCitemKindAgriList = prpCitemKindAgriDao.findAll(QueryPolicySpecBuilder.findPrpCitemKindAgriByPolicyNo(policyNo));
        List<PrpCaddress     > prpCaddressList      = prpCaddressDao.findAll(QueryPolicySpecBuilder.findPrpCaddressByPolicyNo(policyNo));
        List<PrpCsubsidy     > prpCsubsidyList      = prpCsubsidyDao.findAll(QueryPolicySpecBuilder.findPrpCsubsidyByPolicyNo(policyNo));
        List<PrpCitemKind    > prpCitemKindList     = prpCitemKindDao.findAll(QueryPolicySpecBuilder.findPrpCitemKindByPolicyNo(policyNo));
        List<PrpCengage      > prpCengageList       = prpCengageDao.findAll(QueryPolicySpecBuilder.findPrpCengageByPolicyNo(policyNo));
        List<PrpCfeild       > prpCfeildList        = prpCfeildDao.findAll(QueryPolicySpecBuilder.findPrpCfeildByPolicyNo(policyNo));
        List<PrpCfee         > prpCfeeList          = prpCfeeDao.findAll(QueryPolicySpecBuilder.findPrpCfeeByPolicyNo(policyNo));
        List<PrpCplan        > prpCplanList         = prpCplanDao.findAll(QueryPolicySpecBuilder.findPrpCplanByPolicyNo(policyNo));
        List<PrpCcoins       > prpCcoinsList        = prpCcoinsDao.findAll(QueryPolicySpecBuilder.findPrpCcoinsByPolicyNo(policyNo));
        List<PrpCcoinsDetail > prpCcoinsDetailList  = prpCcoinsDetailDao.findAll(QueryPolicySpecBuilder.findPrpCcoinsDetailByPolicyNo(policyNo));
        List<PrpCplanCoins   > prpCplanCoinsList    = prpCplanCoinsDao.findAll(QueryPolicySpecBuilder.findPrpCplanCoinsByPolicyNo(policyNo));

        prpCmainDto = this.convert(prpCmain,PrpCmainDto.class);
        prpCmainAgriDto = this.convert(prpCmainAgri,PrpCmainAgriDto.class);
        prpCrenewalDto = this.convert(prpCrenewal,PrpCrenewalDto.class);
        prpCexpenseDto = this.convert(prpCexpense,PrpCexpenseDto.class);
        this.convertCollection(prpCinsuredList,prpCinsuredDtoList,PrpCinsuredDto.class);
        this.convertCollection(prpCitemKindAgriList,prpCitemKindAgriDtoList,PrpCitemKindAgriDto.class);
        this.convertCollection(prpCaddressList,prpCaddressDtoList,PrpCaddressDto.class);
        this.convertCollection(prpCsubsidyList,prpCsubsidyDtoList,PrpCsubsidyDto.class);
        this.convertCollection(prpCitemKindList,prpCitemKindDtoList,PrpCitemKindDto.class);
        this.convertCollection(prpCengageList,prpCengageDtoList,PrpCengageDto.class);
        this.convertCollection(prpCfeildList,prpCfeildDtoList,PrpCfeildDto.class);
        this.convertCollection(prpCfeeList,prpCfeeDtoList,PrpCfeeDto.class);
        this.convertCollection(prpCplanList,prpCplanDtoList,PrpCplanDto.class);
        this.convertCollection(prpCcoinsList,prpCcoinsDtoList,PrpCcoinsDto.class);
        this.convertCollection(prpCcoinsDetailList,prpCcoinsDetailDtoList,PrpCcoinsDetailDto.class);
        this.convertCollection(prpCplanCoinsList,prpCplanCoinsDtoList,PrpCplanCoinsDto.class);

        prpCmainDto.getClassCode();
        Map<String,String> map=new HashMap<>();
        map.put("riskCode",prpCmainDto.getRiskCode());
        map.put("isChinese","zh-CN");
        prpCmainDto.setRiskCodeName(prpDriskApi.translateCode(map));
        prpCmainDto.setClassCodeName(prpdclassApi.queryByPK(prpCmainDto.getClassCode()).getClassName());
        prpCmainDto.setOperatorName(prpDuserApi.translateCodeByPK(prpCmainDto.getOperatorCode()));
        prpCmainDto.setUpdaterName(prpDuserApi.translateCodeByPK(prpCmainDto.getUpdaterCode()));
        ResponseQueryPolicyInfoDto responseQueryPolicyInfoDto=new ResponseQueryPolicyInfoDto();
        responseQueryPolicyInfoDto.setPrpCmainDto(prpCmainDto);
        responseQueryPolicyInfoDto.setPrpCmainAgriDto(prpCmainAgriDto);
        responseQueryPolicyInfoDto.setPrpCrenewalDto(prpCrenewalDto);
        responseQueryPolicyInfoDto.setPrpCexpenseDto(prpCexpenseDto);
        responseQueryPolicyInfoDto.setPrpCinsuredDtoList(prpCinsuredDtoList);
        responseQueryPolicyInfoDto.setPrpCitemKindAgriDtoList(prpCitemKindAgriDtoList);
        responseQueryPolicyInfoDto.setPrpCaddressDtoList(prpCaddressDtoList);
        responseQueryPolicyInfoDto.setPrpCsubsidyDtoList(prpCsubsidyDtoList);
        responseQueryPolicyInfoDto.setPrpCitemKindDtoList(prpCitemKindDtoList);
        responseQueryPolicyInfoDto.setPrpCengageDtoList(prpCengageDtoList);
        responseQueryPolicyInfoDto.setPrpCfeildDtoList(prpCfeildDtoList);
        responseQueryPolicyInfoDto.setPrpCfeeDtoList(prpCfeeDtoList);
        responseQueryPolicyInfoDto.setPrpCplanDtoList(prpCplanDtoList);
        responseQueryPolicyInfoDto.setPrpCcoinsDtoList(prpCcoinsDtoList);
        responseQueryPolicyInfoDto.setPrpCcoinsDetailDtoList(prpCcoinsDetailDtoList);
        responseQueryPolicyInfoDto.setPrpCplanCoinsDtoList(prpCplanCoinsDtoList);
        return responseQueryPolicyInfoDto;
    }

    /**
     * 根据保单号，分户序号数组获取保单
     * @author: 刘曼曼
     * @date: 2017/11/29 9:00
     * @param policyNo 保单号
     * @param familyNos 分户序号数组
     * @return ResponseQueryPolicyInfoDto保单大对象
     * @throws Exception
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public ResponseQueryPolicyInfoDto queryPolicyInfoByCondition(String policyNo, String[] familyNos) throws Exception {
        StringBuffer buffer=new StringBuffer();
        for (int i=0;i<familyNos.length;i++){
            buffer.append(familyNos[i]);
            if (i<familyNos.length-1){
                buffer.append(",");
            }
        }
        if (buffer.length()>0){
            buffer.append(",");
        }
        buffer.append("1");
        String str=buffer.toString();

        PrpCmainDto prpCmainDto                                ;
        PrpCmainAgriDto prpCmainAgriDto                            ;
        PrpCrenewalDto            prpCrenewalDto                             ;
        PrpCexpenseDto            prpCexpenseDto                             ;
        List<PrpCinsuredDto>      prpCinsuredDtoList      = new ArrayList<>();
        List<PrpCitemKindAgriDto> prpCitemKindAgriDtoList = new ArrayList<>();
        List<PrpCaddressDto     > prpCaddressDtoList      = new ArrayList<>();
        List<PrpCsubsidyDto     > prpCsubsidyDtoList      = new ArrayList<>();
        List<PrpCitemKindDto    > prpCitemKindDtoList     = new ArrayList<>();
        List<PrpCengageDto      > prpCengageDtoList       = new ArrayList<>();
        List<PrpCfeildDto       > prpCfeildDtoList        = new ArrayList<>();
        List<PrpCfeeDto         > prpCfeeDtoList          = new ArrayList<>();
        List<PrpCplanDto        > prpCplanDtoList         = new ArrayList<>();
        List<PrpCcoinsDto       > prpCcoinsDtoList        = new ArrayList<>();
        List<PrpCcoinsDetailDto > prpCcoinsDetailDtoList  = new ArrayList<>();
        List<PrpCplanCoinsDto   > prpCplanCoinsDtoList    = new ArrayList<>();


        PrpCmain prpCmain = prpCmainDao.findOne(new PrpCmainKey(policyNo));
        if (prpCmain==null){
            throw new DataVerifyException("保单号"+policyNo+"不存在");
        }
        if(prpCmain ==null || !systemFlag.equals(prpCmain.getSystemFlag())){//如果不是新系统数据，则返回空
            return null;
        }
        PrpCmainAgri prpCmainAgri         = prpCmainAgriDao.findOne(new PrpCmainAgriKey(policyNo));
        PrpCrenewal prpCrenewal          = prpCrenewalDao.findOne(new PrpCrenewalKey(policyNo));
        PrpCexpense prpCexpense          = prpCexpenseDao.findOne(new PrpCexpenseKey(policyNo));
        List<PrpCinsured>      prpCinsuredList      = prpCinsuredDao.findAllByCondition(policyNo,str);
        List<PrpCitemKindAgri> prpCitemKindAgriList = prpCitemKindAgriDao.findAll(QueryPolicySpecBuilder.findPrpCitemKindAgriByPolicyNo(policyNo));
        List<PrpCaddress     > prpCaddressList      = prpCaddressDao.findAll(QueryPolicySpecBuilder.findPrpCaddressByPolicyNo(policyNo));
        List<PrpCsubsidy     > prpCsubsidyList      = prpCsubsidyDao.findAll(QueryPolicySpecBuilder.findPrpCsubsidyByPolicyNo(policyNo));
        List<PrpCitemKind    > prpCitemKindList     = prpCitemKindDao.findAllByCondition(policyNo,str);
        List<PrpCengage      > prpCengageList       = prpCengageDao.findAll(QueryPolicySpecBuilder.findPrpCengageByPolicyNo(policyNo));
        List<PrpCfeild       > prpCfeildList        = prpCfeildDao.findAll(QueryPolicySpecBuilder.findPrpCfeildByPolicyNo(policyNo));
        List<PrpCfee         > prpCfeeList          = prpCfeeDao.findAll(QueryPolicySpecBuilder.findPrpCfeeByPolicyNo(policyNo));
        List<PrpCplan        > prpCplanList         = prpCplanDao.findAll(QueryPolicySpecBuilder.findPrpCplanByPolicyNo(policyNo));
        List<PrpCcoins       > prpCcoinsList        = prpCcoinsDao.findAll(QueryPolicySpecBuilder.findPrpCcoinsByPolicyNo(policyNo));
        List<PrpCcoinsDetail > prpCcoinsDetailList  = prpCcoinsDetailDao.findAll(QueryPolicySpecBuilder.findPrpCcoinsDetailByPolicyNo(policyNo));
        List<PrpCplanCoins   > prpCplanCoinsList    = prpCplanCoinsDao.findAll(QueryPolicySpecBuilder.findPrpCplanCoinsByPolicyNo(policyNo));

        prpCmainDto = this.convert(prpCmain,PrpCmainDto.class);
        prpCmainAgriDto = this.convert(prpCmainAgri,PrpCmainAgriDto.class);
        prpCrenewalDto = this.convert(prpCrenewal,PrpCrenewalDto.class);
        prpCexpenseDto = this.convert(prpCexpense,PrpCexpenseDto.class);
        this.convertCollection(prpCinsuredList,prpCinsuredDtoList,PrpCinsuredDto.class);
        this.convertCollection(prpCitemKindAgriList,prpCitemKindAgriDtoList,PrpCitemKindAgriDto.class);
        this.convertCollection(prpCaddressList,prpCaddressDtoList,PrpCaddressDto.class);
        this.convertCollection(prpCsubsidyList,prpCsubsidyDtoList,PrpCsubsidyDto.class);
        this.convertCollection(prpCitemKindList,prpCitemKindDtoList,PrpCitemKindDto.class);
        this.convertCollection(prpCengageList,prpCengageDtoList,PrpCengageDto.class);
        this.convertCollection(prpCfeildList,prpCfeildDtoList,PrpCfeildDto.class);
        this.convertCollection(prpCfeeList,prpCfeeDtoList,PrpCfeeDto.class);
        this.convertCollection(prpCplanList,prpCplanDtoList,PrpCplanDto.class);
        this.convertCollection(prpCcoinsList,prpCcoinsDtoList,PrpCcoinsDto.class);
        this.convertCollection(prpCcoinsDetailList,prpCcoinsDetailDtoList,PrpCcoinsDetailDto.class);
        this.convertCollection(prpCplanCoinsList,prpCplanCoinsDtoList,PrpCplanCoinsDto.class);

        ResponseQueryPolicyInfoDto responseQueryPolicyInfoDto=new ResponseQueryPolicyInfoDto();
        responseQueryPolicyInfoDto.setPrpCmainDto(prpCmainDto);
        responseQueryPolicyInfoDto.setPrpCmainAgriDto(prpCmainAgriDto);
        responseQueryPolicyInfoDto.setPrpCrenewalDto(prpCrenewalDto);
        responseQueryPolicyInfoDto.setPrpCexpenseDto(prpCexpenseDto);
        responseQueryPolicyInfoDto.setPrpCinsuredDtoList(prpCinsuredDtoList);
        responseQueryPolicyInfoDto.setPrpCitemKindAgriDtoList(prpCitemKindAgriDtoList);
        responseQueryPolicyInfoDto.setPrpCaddressDtoList(prpCaddressDtoList);
        responseQueryPolicyInfoDto.setPrpCsubsidyDtoList(prpCsubsidyDtoList);
        responseQueryPolicyInfoDto.setPrpCitemKindDtoList(prpCitemKindDtoList);
        responseQueryPolicyInfoDto.setPrpCengageDtoList(prpCengageDtoList);
        responseQueryPolicyInfoDto.setPrpCfeildDtoList(prpCfeildDtoList);
        responseQueryPolicyInfoDto.setPrpCfeeDtoList(prpCfeeDtoList);
        responseQueryPolicyInfoDto.setPrpCplanDtoList(prpCplanDtoList);
        responseQueryPolicyInfoDto.setPrpCcoinsDtoList(prpCcoinsDtoList);
        responseQueryPolicyInfoDto.setPrpCcoinsDetailDtoList(prpCcoinsDetailDtoList);
        responseQueryPolicyInfoDto.setPrpCplanCoinsDtoList(prpCplanCoinsDtoList);
        return responseQueryPolicyInfoDto;
    }


    /**
     * 正本限制
     */
    @Value("${sysconfig.policyManage.editType.master}")
    private String SysConfigMaster;

    /**
     * @param requestDto 封装查询条件数据以及查询方式、页码信息请求参数
     * @return pageInfo 分页查询结果
     * @throws Exception 数据校验异常、数据库异常
     * @description: 类功能简述：根据查询入参的条件以及查询方式分页查询保单列表信息
     * 实现逻辑概述：1.校验关键入参是否为空，校验页码是否页码信息
     * 2.根据入参拼接查询条件
     * 3.用封装的查询条件查询总记录数
     * 4.总记录数>0时，查询投保单列表信息
     * 5.遍历查询结果将投保单列表信息封装到PageInfo返回给前端
     * @author: 潘峰
     * @date: 2017/10/15 11:01
     */
    @Override
    public PageInfo<ResponsePolicyQueryDto> queryPolicylListInfoByConditon(RequestPolicyQueryDto requestDto) throws Exception {
        //请求参数不为空校验，以及页码校验
        if (requestDto == null) {
            throw new DataVerifyException("请求参数不能为空！");
        }
        if (requestDto.getPageNo() < 1) {
            throw new DataVerifyException("查询页码不能小于1！");
        }
        if (requestDto.getPageSize() < 1) {
            throw new DataVerifyException("查询每页数量不能小于1！");
        }

        // 登录机构代码、登录用户代码：网关层封装暂时写死
//        requestDto.setPowerSystemCode("34000000");
        requestDto.setGlobalUserCode(SinoRequestContext.getCurrentContext().getUserCode());
        // 查询数据HQL
        StringBuilder dataHql = new StringBuilder("select pc from PrpCmain pc where");
        // 查询总数量的HQL
        StringBuilder countHql = new StringBuilder("select count(1) from PrpCmain pc where");
        // 条件hql拼接
        StringBuilder condition = new StringBuilder();
        // 存放条件数据
        Map<String, String> conditions = new HashMap<>();

        //区分新老系统标识
        condition.append(" AND pc.systemFlag = :systemFlag");
        conditions.put("systemFlag",systemFlag);
        //验证登录机构comCode
        if (!"".equals(requestDto.getPowerSystemCode())) {
            if (requestDto.getPowerSystemCode().indexOf("YL") != -1) {
                condition.append(" pc.comCode LIKE '%YL%'");
            } else {
                condition.append(" pc.comCode NOT LIKE '%YL%'");
            }
        } else {
            throw new DataVerifyException("登录机构参数不能为空！");
        }

        //扶贫险种标志验证
        if (org.apache.commons.lang3.StringUtils.isNotEmpty(requestDto.getHpFlag())) {
            if (requestDto.getHpFlag().equals("1")) {// 团体投保---贫困户
                condition.append(" AND pc.policyType in ('H23','I27','Q1','E1')");
            } else if (requestDto.getHpFlag().equals("2")) {// 个体投保---规模经营主体
                condition.append(" AND pc.policyType in ('H24','I28','Q2','E2')");
            }
        }
        //保单号proposalNo
        if (org.apache.commons.lang3.StringUtils.isNotEmpty(requestDto.getPolicyNo())) {
            condition.append(" AND pc.policyNo = :policyNo");
            conditions.put("policyNo", requestDto.getPolicyNo());
        }
        //投保单号proposalNo
        if (org.apache.commons.lang3.StringUtils.isNotEmpty(requestDto.getProposalNo())) {
            condition.append(" AND pc.proposalNo = :proposalNo");
            conditions.put("proposalNo", requestDto.getProposalNo());
        }
        //投保人名称appliName
        if (org.apache.commons.lang3.StringUtils.isNotEmpty(requestDto.getAppliName())) {
            if (org.apache.commons.lang3.StringUtils.isNotEmpty(requestDto.getQueryAppliNameMethod()) && requestDto.getQueryAppliNameMethod().equals("*")) {
                condition.append(" AND pc.appliName LIKE :appliName");
                conditions.put("appliName", "%" + requestDto.getAppliName() + "%");
            } else {
                condition.append(" AND pc.appliName = :appliName");
                conditions.put("appliName", requestDto.getAppliName());
            }
        }

        //投保人代码appliCode
        if (org.apache.commons.lang3.StringUtils.isNotEmpty(requestDto.getAppliCode())) {
            if (org.apache.commons.lang3.StringUtils.isNotEmpty(requestDto.getQueryAppliCodeMethod()) && requestDto.getQueryAppliCodeMethod().equals("*")) {
                condition.append(" AND pc.appliCode LIKE :appliCode");
                conditions.put("appliCode", "%" + requestDto.getAppliCode() + "%");
            } else {
                condition.append(" AND pc.applicode = :appliCode");
                conditions.put("appliCode", requestDto.getAppliCode());
            }
        }
        //被保险人名称insuredName
        if (org.apache.commons.lang3.StringUtils.isNotEmpty(requestDto.getInsuredName())) {
            if (org.apache.commons.lang3.StringUtils.isNotEmpty(requestDto.getQueryInsuredNameMethod()) && requestDto.getQueryInsuredNameMethod().equals("*")) {
                condition.append(" AND pc.insuredName LIKE :insuredName");
                conditions.put("insuredName", "%" + requestDto.getInsuredName() + "%");
            } else {
                condition.append(" AND pc.insuredName = :insuredName");
                conditions.put("insuredName", requestDto.getInsuredName());
            }
        }

        //被保险人代码insuredCode
        if (org.apache.commons.lang3.StringUtils.isNotEmpty(requestDto.getInsuredCode())) {
            if (org.apache.commons.lang3.StringUtils.isNotEmpty(requestDto.getQueryInsuredCodeMethod()) && requestDto.getQueryInsuredCodeMethod().equals("*")) {
                condition.append(" AND pc.insuredCode LIKE :insuredCode");
                conditions.put("insuredCode", requestDto.getInsuredCode() + "%");
            } else {
                condition.append("  AND pc.insuredCode = :insuredCode");
                conditions.put("insuredCode", requestDto.getInsuredCode());
            }
        }
        //总保额sumAmount
        if (org.apache.commons.lang3.StringUtils.isNotEmpty(requestDto.getSumAmount())) {
            if (org.apache.commons.lang3.StringUtils.isNotEmpty(requestDto.getQuerySumAmountMethod()) && requestDto.getQuerySumAmountMethod().equals("*")) {
                condition.append(" AND pc.sumAmount LIKE :sumAmount");
                conditions.put("sumAmount", requestDto.getSumAmount() + "%");
            } else {
                condition.append(" AND pc.sumAmount = :sumAmount");
                conditions.put("sumAmount", requestDto.getSumAmount());
            }
        }
        //总保费sumPremium
        if (org.apache.commons.lang3.StringUtils.isNotEmpty(requestDto.getSumPremium())) {
            if (org.apache.commons.lang3.StringUtils.isNotEmpty(requestDto.getQuerySumPremiumMethod()) && requestDto.getQuerySumPremiumMethod().equals("*")) {
                condition.append(" AND pc.sumPremium LIKE :sumPremium");
                conditions.put("sumPremium", requestDto.getSumPremium() + "%");
            } else {
                condition.append(" AND pc.sumPremium = :sumPremium");
                conditions.put("sumPremium", requestDto.getSumPremium());
            }
        }

        //归属业务员代码 handler1Code
        if (org.apache.commons.lang3.StringUtils.isNotEmpty(requestDto.getHandler1Code())) {
            if (org.apache.commons.lang3.StringUtils.isNotEmpty(requestDto.getQueryHandler1CodeMethod()) && requestDto.getQueryHandler1CodeMethod().equals("*")) {
                condition.append(" AND pc.handler1Code LIKE :handler1Code");
                conditions.put("handler1Code", requestDto.getHandler1Code() + "%");
            } else {
                condition.append(" AND pc.handler1Code = :handler1Code");
                conditions.put("handler1Code", requestDto.getHandler1Code());
            }
        }
        //操作员代码operatorCode
        if (org.apache.commons.lang3.StringUtils.isNotEmpty(requestDto.getOperatorCode())) {
            if (org.apache.commons.lang3.StringUtils.isNotEmpty(requestDto.getQueryOperatorCodeMethod()) && requestDto.getQueryOperateDateMethod().equals("*")) {
                condition.append(" AND pc.operatorCode LIKE :operatorCode");
                conditions.put("operatorCode", requestDto.getOperatorCode() + "%");
            } else {
                condition.append(" AND pc.operatorCode = :operatorCode");
                conditions.put("operatorCode", requestDto.getOperatorCode());
            }
        }

        // 日期类条件校验逻辑说明，仅接收查询方式 >, <, >=, <=, = 其他参数全部按照精确查询（=）处理，以下日期处理逻辑相同
        //起保日期startDate
        if (org.apache.commons.lang3.StringUtils.isNotEmpty(requestDto.getStartDate())) {
            if (org.apache.commons.lang3.StringUtils.isNotEmpty(requestDto.getQueryStartDateMethod()) && !requestDto.getQueryStartDateMethod().equals("=")) {
                switch (requestDto.getQueryStartDateMethod()) {
                    case ">":
                        condition.append(" AND pc.startDate > to_date(:startDate, 'yyyy-mm-dd hh24:mi:ss')");
                        break;
                    case "<":
                        condition.append(" AND pc.startDate < to_date(:startDate, 'yyyy-mm-dd hh24:mi:ss')");
                        break;
                    case ">=":
                        condition.append(" AND pc.startDate >= to_date(:startDate, 'yyyy-mm-dd hh24:mi:ss')");
                        break;
                    case "<=":
                        condition.append(" AND pc.startDate <= to_date(:startDate, 'yyyy-mm-dd hh24:mi:ss')");
                        break;
                    default:
                        condition.append(" AND pc.startDate = to_date(:startDate, 'yyyy-mm-dd hh24:mi:ss')");
                        break;
                }
            } else {
                condition.append(" AND pc.startDate <= to_date(:startDate, 'yyyy-mm-dd hh24:mi:ss')");
            }
            conditions.put("startDate", requestDto.getStartDate());
        }
        //终保日期endDate
        if (org.apache.commons.lang3.StringUtils.isNotEmpty(requestDto.getEndDate())) {
            if (org.apache.commons.lang3.StringUtils.isNotEmpty(requestDto.getQueryEndDateMethod()) && !requestDto.getQueryEndDateMethod().equals("=")) {
                switch (requestDto.getQueryEndDateMethod()) {
                    case ">":
                        condition.append(" AND pc.endDate > to_date(:endDate, 'yyyy-mm-dd hh24:mi:ss')");
                        break;
                    case "<":
                        condition.append(" AND pc.endDate < to_date(:endDate, 'yyyy-mm-dd hh24:mi:ss')");
                        break;
                    case ">=":
                        condition.append(" AND pc.endDate >= to_date(:endDate, 'yyyy-mm-dd hh24:mi:ss')");
                        break;
                    case "<=":
                        condition.append(" AND pc.endDate <= to_date(:endDate, 'yyyy-mm-dd hh24:mi:ss')");
                        break;
                    default:
                        condition.append(" AND pc.endDate = to_date(:endDate, 'yyyy-mm-dd hh24:mi:ss')");
                        break;
                }
            } else {
                condition.append(" AND pc.endDate = to_date(:endDate, 'yyyy-mm-dd hh24:mi:ss')");
            }
            conditions.put("endDate", requestDto.getEndDate());
        }

        //制单日期operateDate
        if (org.apache.commons.lang3.StringUtils.isNotEmpty(requestDto.getOperateDate())) {
            if (org.apache.commons.lang3.StringUtils.isNotEmpty(requestDto.getQueryOperateDateMethod()) && !requestDto.getQueryOperateDateMethod().equals("=")) {
                switch (requestDto.getQueryOperateDateMethod()) {
                    case ">":
                        condition.append(" AND pc.operateDate > to_date(:operateDate, 'yyyy-mm-dd hh24:mi:ss')");
                        break;
                    case "<":
                        condition.append(" AND pc.operateDate < to_date(:operateDate, 'yyyy-mm-dd hh24:mi:ss')");
                        break;
                    case ">=":
                        condition.append(" AND pc.operateDate >= to_date(:operateDate, 'yyyy-mm-dd hh24:mi:ss')");
                        break;
                    case "<=":
                        condition.append(" AND pc.operateDate <= to_date(:operateDate, 'yyyy-mm-dd hh24:mi:ss')");
                        break;
                    default:
                        condition.append(" AND pc.operateDate = to_date(:operateDate, 'yyyy-mm-dd hh24:mi:ss')");
                        break;
                }
            } else {
                condition.append(" AND pc.operateDate = to_date(:operateDate, 'yyyy-mm-dd hh24:mi:ss')");
            }
            conditions.put("operateDate", requestDto.getOperateDate());
        }

        //政策/商业标志businessType1
        if (org.apache.commons.lang3.StringUtils.isNotEmpty(requestDto.getBusinessType1())) {
            condition.append(" AND pc.businessType1 = :businessType1");
            conditions.put("businessType1", requestDto.getBusinessType1());
        }

        //印刷号printNo 1已打印，2未打印
        if ("1".equals(requestDto.getPrintStatus())) {
            condition.append(" AND (pc.printNo IS NOT NULL)");
        } else {
            condition.append(" AND pc.printNo IS NULL ");
        }

        //增加正本限制 全单退保的不能打 ，已经注销的不能打 1.已经通过的 3.无需审核的
        if (SysConfigMaster.equals(requestDto.getEditType())) {
            //strCondition += " and not (othflag[4] = '1') ";
            condition.append(" and not (SUBSTR(OthFlag,4,1) = '1' or SUBSTR(OthFlag,3,1) = '1')");
            condition.append(" and (UnderWriteFlag='1'  or UnderWriteFlag='3')");
        }
            //TODO 此处应拼接权限校验条件，暂无无法实现

        // 查询总数据量的Hql拼接
        countHql.append(condition);
        // 查询数据hql拼接条件以及排序hql
        dataHql.append(condition).append(" order by pc.policyNo desc");
        Query countQuery = entityManager.createQuery(countHql.toString());
        Query dataQuery = entityManager.createQuery(dataHql.toString());
        // 设置参数
        for (String key : conditions.keySet()) {
            countQuery.setParameter(key, conditions.get(key));
            dataQuery.setParameter(key, conditions.get(key));
        }
        // 查询数据总条数
        long countNum = (long) countQuery.getSingleResult();
        dataQuery.setFirstResult((requestDto.getPageNo() - 1) * requestDto.getPageSize());
        dataQuery.setMaxResults(requestDto.getPageSize());
        // 查询数据
        List<PrpCmain> dataList = new ArrayList<PrpCmain>();
        List<ResponsePolicyQueryDto> responseList = new ArrayList<>();
        if (countNum > 0) {// 当查询到的总记录数大于0才继续查询
            dataList = dataQuery.getResultList();
            ResponsePolicyQueryDto reponseQueryPrpCMainDto = null;
            //迭代查询结果
            for (int i = 0; i < dataList.size(); i++) {
                PrpCmain prpcmain = dataList.get(i);
                reponseQueryPrpCMainDto = new ResponsePolicyQueryDto();
                reponseQueryPrpCMainDto.setPolicyNo(prpcmain.getPolicyNo());
                reponseQueryPrpCMainDto.setInsuredName(prpcmain.getInsuredName());
                reponseQueryPrpCMainDto.setAppliName(prpcmain.getAppliName());
                reponseQueryPrpCMainDto.setStartDate(DateUtils.dateToStr(prpcmain.getStartDate()));
                reponseQueryPrpCMainDto.setEndDate(DateUtils.dateToStr(prpcmain.getEndDate()));
                // 操作员名称转译需要调用其他应用服务暂无法实现：暂设置为操作员代码
                Map<String,String> map = new HashMap<>();
                map.put("userCode",prpcmain.getOperatorCode());
                map.put("isChinese",LanguageFlagConstant.CHINESE);
                reponseQueryPrpCMainDto.setOperatorName(prpDuserApi.translateCode(map));
                reponseQueryPrpCMainDto.setOperateDate(DateUtils.dateToStr(prpcmain.getOperateDate()));
                reponseQueryPrpCMainDto.setUnderWriteFlag(prpcmain.getUnderwriteFlag());
                responseList.add(reponseQueryPrpCMainDto);
            }
        }
        // 统一封装分页响应dto
        PageInfo<ResponsePolicyQueryDto> pageInfo = new PageInfo<>();
        pageInfo.setContent(responseList);// 数据存放dto集合
        pageInfo.setPages(requestDto.getPageNo());// 当前页数
        pageInfo.setTotalCount(countNum);// 总记录数
        return pageInfo;
    }

    /**
     * @param policyNo 保单号
     * @return ResponseDto
     * @throws Exception 数据校验异常、数据库异常
     * @description: 类功能简述：根据保单号来查特别约定打印
     * @author: 潘峰
     */
    @Override
    public ResponseSpecificallyAgreedPrintDto specificallyAgreedPrint(String policyNo) throws Exception {
        if (org.apache.commons.lang3.StringUtils.isEmpty(policyNo)) {
            throw new DataVerifyException("保单号不能为空！");
        }
        StringBuilder stringBuffer = new StringBuilder();
        ResponseSpecificallyAgreedPrintDto responseSpecificallyAgreedPrintDto = new ResponseSpecificallyAgreedPrintDto();

        List<ResponseSpecificallyAgreedPrintDto> responseSpecificallyAgreedPrintDtoList = policyQueryDao.queryPolicyno(policyNo);
        for (ResponseSpecificallyAgreedPrintDto responseSpecificallyAgreedPrint : responseSpecificallyAgreedPrintDtoList) {
            if(!"0".equals(responseSpecificallyAgreedPrint.getTitleFlag())){
                stringBuffer.append(responseSpecificallyAgreedPrint.getClauses()+"\n");
            }
        }
        responseSpecificallyAgreedPrintDto.setClauses(stringBuffer.toString());
        if (responseSpecificallyAgreedPrintDtoList.size() > 0) {
            responseSpecificallyAgreedPrintDto.setPolicyNo(responseSpecificallyAgreedPrintDtoList.get(0).getPolicyNo());
            responseSpecificallyAgreedPrintDto.setOperatedate(responseSpecificallyAgreedPrintDtoList.get(0).getOperatedate());
        }
        return responseSpecificallyAgreedPrintDto;

    }

    /**
     * @param policyNo 保单号
     * @return ResponseDto
     * @throws Exception 数据校验异常、数据库异常
     * @description: 类功能简述：根据保单号来查缴费计划打印
     * @author: 潘峰
     */
    @Override
    public List<ResponsePaymentPlanPrintDto> paymentPlanPrint(String policyNo) throws Exception {
        if (org.apache.commons.lang3.StringUtils.isEmpty(policyNo)) {
            throw new DataVerifyException("保单号不能为空！");
        }
        List<ResponsePaymentPlanPrintDto> responsePaymentPlanPrintDtos = policyQueryDao.queryPaymentPlan(policyNo);
        return responsePaymentPlanPrintDtos;
    }

    /**
     * @param policyNo 保单号
     * @return ResponseDto
     * @throws Exception 数据校验异常、数据库异常
     * @description: 类功能简述：根据保单号来打印承保卷宗封面
     * 机构名称 险种名称
     * @author: 潘峰
     */
    @Override
    public ResponseFileCoverPrintDto fileCoverPrint(String policyNo) throws Exception {
        if (StringUtils.isEmpty(policyNo)) {
            throw new DataVerifyException("保单号不能为空");
        }
        PrpCmain prpCmain = prpCmainDao.findOne(new PrpCmainKey(policyNo));

        PrpDcodeDto prpDcodeDto = null;
        if (StringUtils.isNotEmpty(prpCmain.getStatUnitCode())) {
            prpDcodeDto = prpDcodeApi.queryByPK("Unit", prpCmain.getStatUnitCode());
        }

        String codeCName = prpDcodeDto.getCodeCName();
        List<ResponseFileCoverPrintDto> responseFileCoverPrintDtos = policyQueryDao.queryfileCoverPrint(policyNo);
        ResponseFileCoverPrintDto responseFileCoverPrintDto;
        if (responseFileCoverPrintDtos.size() > 0 && null != responseFileCoverPrintDtos) {
            responseFileCoverPrintDto = responseFileCoverPrintDtos.get(0);
            Map map = new HashMap();
            map.put("riskCode", prpCmain.getRiskCode());
            map.put("isChinese", LanguageFlagConstant.CHINESE);
            String riskName = prpDriskApi.translateCode(map);
            responseFileCoverPrintDto.setRiskName(riskName);
            String comName = prpDcompanyApi.translateCodeByPK(prpCmain.getComCode());
            responseFileCoverPrintDto.setComName(comName);
            responseFileCoverPrintDto.setCodeCName(codeCName);
        } else {
            throw new DataVerifyException("承保卷宗封面为空");
        }
        return responseFileCoverPrintDto;
    }

    /**
     * @param policyNo
     * @return
     * @throws Exception
     * @description:保单打印
     * @author: 潘峰
     * @date: 2017/10/23 14:07
     */
    @Override
    public ResponsePolicyPrintDto queryPolicyPrintByCondition(String policyNo) throws Exception {
        //TODO 流水号校验，后期增加
        if (StringUtils.isEmpty(policyNo)) {
            throw new DataVerifyException("保单号不能为空");
        }
        //保单号，保险期间，总保险金额，总保险费查询
        PrpCmain prpCmain = prpCmainDao.findOne(new PrpCmainKey(policyNo));
        if(prpCmain==null || !systemFlag.equals(prpCmain.getSystemFlag())){//如果不是新系统数据，则返回空
            return null;
        }
        List<PrpDrelationClauseCodeDto> prpDrelationClauseCodeDtoList = new ArrayList<>();
        String clauseName="";
        if(prpCmain.getVersionNo()!=null){
            prpDrelationClauseCodeDtoList = prpDrelationClauseCodeApi.queryByClauseCode(prpCmain.getVersionNo());
            Map<String,String> map=new HashMap<>();
            map.put("clauseCode",prpCmain.getVersionNo());
            PrpDclauseCodeDto prpDclauseCodeDto=prpDclauseCodeApi.queryByPK(map);
            if(prpDclauseCodeDto!=null){
                clauseName=prpDclauseCodeDto.getClauseName();
            }
        }

//        String versionNo=prpCmain.getVersionNo();
        String comcode = prpCmain.getComCode();
        String operatorCode = prpCmain.getOperatorCode();
        String handlerCode = prpCmain.getHandlerCode();
        String StatUnitCode = prpCmain.getStatUnitCode();
        PrpDcompanyDto prpDcompanyDto = prpDcompanyApi.queryByPK(comcode);
        PrpCmainAgri prpCmainAgri = prpCmainAgriDao.findOne(new PrpCmainAgriKey(policyNo));
        //名称，短信，地址，邮编查询
        //名称，短信，地址，邮编查询
        Specification<PrpCinsured> prpCinsuredSpecification = PolicyPrintSpecBuilder.prpCinsuredByPolicyNoSpecification(policyNo);
        List<PrpCinsured> prpCinsuredList = prpCinsuredDao.findAll(prpCinsuredSpecification);
        //投保面积，单位约定产量，约定价格，单位保险金额查询
        Specification<PrpCitemKindAgri> prpCitemKindAgriSpecification = PolicyPrintSpecBuilder.prpCitemKindAgriByPolicyNoSpecification(policyNo);
        List<PrpCitemKindAgri> prpCitemKindAgriList = prpCitemKindAgriDao.findAll(prpCitemKindAgriSpecification);
        //保险金额，费率，保险费，主险保费，附加险保费查询
        Specification<PrpCitemKind> prpCitemKindSpecification = PolicyPrintSpecBuilder.prpCitemKindByPolicyNoSpecification(policyNo);
        List<PrpCitemKind> prpCitemKindlist = prpCitemKindDao.findAll(prpCitemKindSpecification);
        //投保财产地点查询
        Specification<PrpCaddress> prpCaddressSpecification = PolicyPrintSpecBuilder.prpCaddressByPolicyNoSpecification(policyNo);
        List<PrpCaddress> prpCaddressList = prpCaddressDao.findAll(prpCaddressSpecification);
        //付费日期查询
        Specification<PrpCplan> prpCplanSpecification = PolicyPrintSpecBuilder.prpCplanByPolicyNoSpecification(policyNo);
        List<PrpCplan> prpCplanList = prpCplanDao.findAll(prpCplanSpecification);
        //绝对免赔率，特约信息查询
        Specification<PrpCengage> prpCengageSpecification = PolicyPrintSpecBuilder.prpCengagePolicyNoSpecification(policyNo);
        List<PrpCengage> prpCengageList = prpCengageDao.findAll(prpCengageSpecification);
        //保险费构成
        Specification<PrpCsubsidy> prpCsubsidySpecification = PolicyPrintSpecBuilder.prpCsubsidyPolicyNoSpecification(policyNo);
        List<PrpCsubsidy> prpCsubsidyList = prpCsubsidyDao.findAll(prpCsubsidySpecification);

        //todo PrpDrisk公共服务
        //todo PrpDcompany公共服务,prpduser

        PrpDuserDto prpDuserDto = prpDuserApi.queryByPK(operatorCode);

        //被保险人信息赋值，
        //定义被保险人信息对象

        InsuredInfoDto insuredInfoDto = new InsuredInfoDto();
        String codecode = "";
        for (PrpCinsured prpCinsured : prpCinsuredList) {
            if ("1".equals(prpCinsured.getInsuredFlag())) {
                codecode = prpCinsured.getInsuredIdentity();
                insuredInfoDto.setInsuredName(prpCinsured.getInsuredName());
                insuredInfoDto.setMobile(prpCinsured.getPhoneNumber());
                insuredInfoDto.setInsureAddress(prpCinsured.getInsuredAddress());
                insuredInfoDto.setPostCode(prpCinsured.getPostCode());
                insuredInfoDto.setInsuredIdNum(prpCinsured.getIdentifyNumber());
            } else if ("2".equals(prpCinsured.getInsuredFlag())) {
                insuredInfoDto.setAppInsuredName(prpCinsured.getInsuredName());
            }
        }
        insuredInfoDto.setAddressName(prpCaddressList.get(0).getAddressName());
        insuredInfoDto.setInsuredCode(prpCmain.getInsuredCode());
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy年MM月dd日");
        insuredInfoDto.setOperateDate(simpleDateFormat.format(prpCmain.getOperateDate()));
        insuredInfoDto.setUnderWriteName(prpCmain.getUnderwriteName());
        if (prpCmainAgri != null) {
            insuredInfoDto.setRemark(prpCmainAgri.getRemark());
            String raiseType="";
            if(StringUtils.isNotEmpty(prpCmainAgri.getRaiseType())){
                raiseType=prpDcodeApi.translateCode("RaiseType",prpCmainAgri.getRaiseType(),"zh-CN");
            }
            insuredInfoDto.setRaiseType(raiseType);
        }
        insuredInfoDto.setPolicyType(prpCmain.getPolicyType());
        insuredInfoDto.setSumInsured(prpCmain.getSumInsured().toString());

        //主信息赋值

        ResponsePolicyPrintDto responsePolicyPrintDto = new ResponsePolicyPrintDto();
        List<PrpDclauseDto> prpDclauseDtos=new ArrayList<>();
        for(PrpDrelationClauseCodeDto prpDrelationClauseCodeDto:prpDrelationClauseCodeDtoList){
            if(prpDrelationClauseCodeDto.getInsuranceCode()!=null){
                prpDclauseDtos = prpDclauseApi.queryClauseByClauseCode(prpDrelationClauseCodeDto.getInsuranceCode());
            }
            for(PrpDclauseDto prpDclauseDto:prpDclauseDtos){
                if(prpDclauseDto.getClauseCode().substring(0,2).equals("BX")){
                    responsePolicyPrintDto.setText((responsePolicyPrintDto.getText()==null?"":responsePolicyPrintDto.getText())+prpDclauseDto.getContext());
                }else{
                    responsePolicyPrintDto.setText1((responsePolicyPrintDto.getText1()==null?"":responsePolicyPrintDto.getText1())+prpDclauseDto.getContext());
                }
            }
        }
//        for(PrpDclauseDto prpDclauseDto:prpDclauseDtos){
//            if(prpDclauseDto.getTitleFlag()!="1"){
//                responsePolicyPrintDto.setText((responsePolicyPrintDto.getText()==null?"":responsePolicyPrintDto.getText())+prpDclauseDto.getContext());
//            }
//        }
        String com=prpCmain.getComCode().substring(0,6);
        if(StringUtils.isNotEmpty(prpCmain.getComCode())){
            String comName=prpDcodeApi.translateCode("BusinessZone",com,"zh-CN");
            responsePolicyPrintDto.setComName(comName);
        }
        String riskName="";
        if(StringUtils.isNotEmpty(prpCmain.getRiskCode())) {
            Map map = new HashMap();
            map.put("riskCode",prpCmain.getRiskCode());
            map.put("isChinese",LanguageFlagConstant.CHINESE);
            riskName=prpDriskApi.translateCode(map);
        }
        responsePolicyPrintDto.setRiskCName(riskName);
        responsePolicyPrintDto.setClauseName(clauseName);
        responsePolicyPrintDto.setPostCode(prpDcompanyDto.getPostCode());
        responsePolicyPrintDto.setAddressCName(prpDcompanyDto.getAddressCName());
        responsePolicyPrintDto.setFaxNumber(prpDcompanyDto.getFaxNumber());
        responsePolicyPrintDto.setReportPhone(prpDcompanyDto.getReportPhone());
        responsePolicyPrintDto.setHandlerName(prpDcompanyDto.getComCName());
        responsePolicyPrintDto.setOperateName(prpDuserDto.getUserName());
        responsePolicyPrintDto.setArgueSolution(prpCmain.getArgueSolution());
        if("2".equals(prpCmain.getArgueSolution())){
            if("34".equals(com)){
                responsePolicyPrintDto.setArbitBoardName("合肥市仲裁委员会");
            }else if("41".equals(com)){
                responsePolicyPrintDto.setArbitBoardName("郑州市仲裁委员会");
            }else if("42".equals(com)){
                responsePolicyPrintDto.setArbitBoardName("武汉市仲裁委员会");
            }else if("52".equals(com)){
                responsePolicyPrintDto.setArbitBoardName("贵州市仲裁委员会");
            }
        }
        responsePolicyPrintDto.setPolicyNo(prpCmain.getPolicyNo());
        PrpDcodeDto prpDcode1Dto = prpDcodeApi.queryByPK("CrossCode", "01");
        PrpDcodeDto prpDcode2Dto = prpDcodeApi.queryByPK("CrossCode", "02");
        PrpDcodeDto prpDcode3Dto = prpDcodeApi.queryByPK("CrossCode", "03");
        if (org.apache.commons.lang3.StringUtils.isNotEmpty(codecode)) {
            PrpDcodeDto prpDcode4Dto = prpDcodeApi.queryByPK("InsuredIdentity", codecode);
            insuredInfoDto.setInsuredInsuredidenty(prpDcode4Dto.getCodeCName());
        }
        responsePolicyPrintDto.setCode1(prpDcode1Dto.getCodeCName());
        responsePolicyPrintDto.setCode2(prpDcode2Dto.getCodeCName());
        responsePolicyPrintDto.setCode3(prpDcode3Dto.getCodeCName());


        //保险期间赋值
        insuredInfoDto.setStartDate(simpleDateFormat.format(prpCmain.getStartDate()));
        insuredInfoDto.setEndDate(simpleDateFormat.format(prpCmain.getEndDate()));
        responsePolicyPrintDto.setInsuredInfo(insuredInfoDto);

        //总保费，总保额赋值
        InsuraneItemsDto insuraneItemsDto = new InsuraneItemsDto();
        insuraneItemsDto.setSumAmount(this.doubleToStr(prpCmain.getSumAmount(),2));
        insuraneItemsDto.setSumPremium(this.doubleToStr(prpCmain.getSumPremium(),2));

        //补贴交付比例赋值
//        List<PremiumConDto> list = new ArrayList<>();
        PremiumConDto premiumConDto = new PremiumConDto();
        double subSidy10Rate=0;
        for (PrpCsubsidy prpCsubsidy : prpCsubsidyList) {
            //TODO 0304 注释
            if ("03".equals(prpCsubsidy.getSubsidyCode())) {
                premiumConDto.setSubSidy03Rate(this.doubleToStr(prpCsubsidy.getSubsidyRate(),2));
                subSidy10Rate+=prpCsubsidy.getSubsidyRate();
            }
            if ("04".equals(prpCsubsidy.getSubsidyCode())) {
                premiumConDto.setSubSidy04Rate(this.doubleToStr(prpCsubsidy.getSubsidyRate(),2));
                subSidy10Rate+=prpCsubsidy.getSubsidyRate();
            }
            if ("05".equals(prpCsubsidy.getSubsidyCode())) {
                premiumConDto.setSubSidy05Rate(this.doubleToStr(prpCsubsidy.getSubsidyRate(),2));
                subSidy10Rate+=prpCsubsidy.getSubsidyRate();
            }
            if ("06".equals(prpCsubsidy.getSubsidyCode())) {
                premiumConDto.setSubSidy06Rate(this.doubleToStr(prpCsubsidy.getSubsidyRate(),2));
                subSidy10Rate+=prpCsubsidy.getSubsidyRate();
            }
            if ("07".equals(prpCsubsidy.getSubsidyCode())) {
                premiumConDto.setSubSidy07Rate(this.doubleToStr(prpCsubsidy.getSubsidyRate(),2));
                subSidy10Rate+=prpCsubsidy.getSubsidyRate();
            }
        }
        premiumConDto.setSubSidy10Rate(this.doubleToStr(100-subSidy10Rate,2));

        //承保明细赋值
        List<ItemKingAgriDto> itemKingAgriDtoList = new ArrayList<>();
        List<ItemKingAgriSubDto> itemKingAgriSubDtoList = new ArrayList<>();
        List<ItemKingAgriccDto> itemKingAgriccDtoList=new ArrayList<>();
        ItemKingAgriDto itemKingAgriDto = new ItemKingAgriDto();
        ItemKingAgriSubDto itemKingAgriSubDto = new ItemKingAgriSubDto();
        ItemKingAgriccDto itemKingAgriccDto = new ItemKingAgriccDto();
        PrpCitemKind prpCitemKind = null;
        List<PrpCitemKindAgri> prpTitemKindAgrilist1 = new ArrayList<PrpCitemKindAgri>();
        List<PrpCitemKind> listMain = new ArrayList<PrpCitemKind>();//主险
        List<PrpCitemKind> listSub = new ArrayList<PrpCitemKind>();//附加险
        PrpCitemKind listKind = null;
        PrpCitemKind listKindSub = null;
        PrpCitemKindAgri listAgri = null;

        for (PrpCitemKindAgri prpTitemKindAgri : prpCitemKindAgriList) {
            prpTitemKindAgrilist1.add(prpTitemKindAgri);
            if(prpTitemKindAgri.getEndDate()!=null&&prpTitemKindAgri.getStratDate()!=null){
                SimpleDateFormat format=new SimpleDateFormat("yyyy年MM月dd日");
                long days=prpTitemKindAgri.getEndDate().getTime()-prpTitemKindAgri.getStratDate().getTime();
                responsePolicyPrintDto.setCmStartDate(format.format(prpTitemKindAgri.getStratDate()));
                responsePolicyPrintDto.setCmEndDate(format.format(prpTitemKindAgri.getEndDate()));
                responsePolicyPrintDto.setDaySum((days/(1000*3600*24))+"");
            }

        }
        for (int i = 0; i < prpCitemKindlist.size(); i++) {
            prpCitemKind = prpCitemKindlist.get(i);
            if(prpCitemKind.getFlag()!=null) {
                if ("1".equals(prpCitemKind.getFlag().substring(1, 2))) {//主险
                    listMain.add(prpCitemKind);
                } else if ("2".equals(prpCitemKind.getFlag().substring(1, 2))) {//附加险
                    listSub.add(prpCitemKind);
                }
            }
        }
        for (int i = 0; i < listMain.size(); i++) {//prpcitemkind主险赋值
            itemKingAgriDto = new ItemKingAgriDto();
            if (listMain.size() > 4) {
                if(!"详见主险清单".equals(itemKingAgriDtoList.get(0).getItemDetailName())){
                    itemKingAgriDto.setItemDetailName("详见主险清单");
                    itemKingAgriDtoList.add(itemKingAgriDto);
                }
            }
            listKind = listMain.get(i);
            for (int j = 0; j < prpTitemKindAgrilist1.size(); j++) {//prpcitemkindagri
                listAgri = prpTitemKindAgrilist1.get(j);
                //茬次信息
                itemKingAgriccDto = new ItemKingAgriccDto();
                if(("3102".equals(listAgri.getRiskCode())||"3141".equals(listAgri.getRiskCode())||"3147".equals(listAgri.getRiskCode())||"3134".equals(listAgri.getRiskCode()))&&0!=listAgri.getTimes()){
                    itemKingAgriccDto.setItems(listAgri.getTimes()+"");
                    SimpleDateFormat format=new SimpleDateFormat("yyyy-MM-dd");
                    if(listAgri.getStratDate()!=null&&listAgri.getEndDate()!=null){
                        itemKingAgriccDto.setItemsDate("自"+format.format(listAgri.getStratDate())+"日起至"+format.format(listAgri.getEndDate())+"日止");
                    }
                    itemKingAgriccDto.setDistributingrate(this.doubleToStr(listAgri.getDistributingRate(),2));
                }
                if(0!=listAgri.getTimes()&&(listKind.getItemKindNo()==listAgri.getItemKindNo())){
                    itemKingAgriccDtoList.add(itemKingAgriccDto);
                }
                //主险标的信息
                 if (0==listAgri.getTimes()&&listKind.getItemKindNo().equals(listAgri.getItemKindNo())&&listMain.size()< 4) {//取主险标的信息
                    itemKingAgriDto.setItemDetailName(listKind.getItemDetailName());
                    itemKingAgriDto.setInsureArea(listAgri.getInsureArea());
                    itemKingAgriDto.setUnitOutPut(this.doubleToStr(listAgri.getUnitOutput(),2));
                    itemKingAgriDto.setUnitCost(this.doubleToStr(listAgri.getUnitCost(),2));
                    itemKingAgriDto.setUnitAmount(this.doubleToStr(listAgri.getUnitAmount(),2));
                    itemKingAgriDto.setAmount(this.doubleToStr(listKind.getAmount(),2));
                    itemKingAgriDto.setRate(this.doubleToStr(listKind.getRate(),2));
                    itemKingAgriDto.setAdjuStrate(this.doubleToStr(listKind.getPremium(),2));
                    itemKingAgriDto.setDeductibleRate(this.doubleToStr(listKind.getDeductibleRate(),2));
                    itemKingAgriDto.setGrossQuantity(this.doubleToStr(listAgri.getGrossQuantity(),2));
                    itemKingAgriDto.setTimesAmount(this.doubleToStr(listAgri.getTimesAmount(),2));
                    itemKingAgriDto.setProportion(this.doubleToStr(listAgri.getProportion(),2));
                    if (org.apache.commons.lang3.StringUtils.isNotEmpty(StatUnitCode)) {
                        PrpDcodeDto prpDcode5Dto = prpDcodeApi.queryByPK("Unit", StatUnitCode);
                        itemKingAgriDto.setUnit(prpDcode5Dto.getCodeCName());
                    }
                    itemKingAgriDtoList.add(itemKingAgriDto);
                }

            }

        }
        responsePolicyPrintDto.setItemKingAgriccDto(itemKingAgriccDto);
        responsePolicyPrintDto.setItemKingAgriccDtoList(itemKingAgriccDtoList);

        for (int i = 0; i < listSub.size(); i++) {//附加险赋值
            itemKingAgriSubDto=new ItemKingAgriSubDto();
            if (listSub.size() > 3) {
                itemKingAgriSubDto.setSubitemDetailName("详见附加险清单");
                itemKingAgriSubDtoList.add(itemKingAgriSubDto);
                break;
            }
            listKindSub = listSub.get(i);
            for (int j = 0; j < prpTitemKindAgrilist1.size(); j++) {
                listAgri = prpTitemKindAgrilist1.get(j);
                if (listKindSub.getItemKindNo().equals(listAgri.getItemKindNo())) {
                    itemKingAgriSubDto.setSubitemDetailName(listKindSub.getItemDetailName());
                    itemKingAgriSubDto.setSubinsureArea(listAgri.getInsureArea());
                    itemKingAgriSubDto.setSubunitOutPut(this.doubleToStr(listAgri.getUnitOutput(),2));
                    itemKingAgriSubDto.setSubunitCost(this.doubleToStr(listAgri.getUnitCost(),2));
                    itemKingAgriSubDto.setSubunitAmount(this.doubleToStr(listAgri.getUnitAmount(),2));
                    itemKingAgriSubDto.setSubamount(this.doubleToStr(listKindSub.getAmount(),2));
                    itemKingAgriSubDto.setSubrate(this.doubleToStr(listKindSub.getRate(),2));
                    itemKingAgriSubDto.setSubadjuStrate(this.doubleToStr(listKindSub.getPremium(),2));
                    itemKingAgriSubDto.setSubdeductibleRate(this.doubleToStr(listKind.getDeductibleRate(),2));
                    itemKingAgriSubDto.setSubgrossQuantity(this.doubleToStr(listAgri.getGrossQuantity(),2));
                    itemKingAgriSubDto.setSubtimesAmount(this.doubleToStr(listAgri.getTimesAmount(),2));
                    if (org.apache.commons.lang3.StringUtils.isNotEmpty(StatUnitCode)) {
                        PrpDcodeDto prpDcode5Dto = prpDcodeApi.queryByPK("Unit", StatUnitCode);
                        itemKingAgriSubDto.setSubunit(prpDcode5Dto.getCodeCName());
                    }
                    itemKingAgriSubDtoList.add(itemKingAgriSubDto);
                }
            }

        }

        //主险保费
        double amountMain = 0;
        for (int i = 0; i < listMain.size(); i++) {
            amountMain += listMain.get(i).getPremium();
        }
        itemKingAgriDto.setPremium1(amountMain);
        //附加险保费
        double amountSub = 0;
        for (int i = 0; i < listSub.size(); i++) {
            amountSub += listSub.get(i).getPremium();
        }
        if (amountSub > 0) {
            itemKingAgriSubDto.setSubpremium(Double.toString(amountSub));
        }
        responsePolicyPrintDto.setItemKindAgriList(itemKingAgriDtoList);
        responsePolicyPrintDto.setItemKindAgriSubList(itemKingAgriSubDtoList);


        //付费日期赋值
        Double subsidySum=0.00;
        for (PrpCplan prpCplan : prpCplanList) {
            SimpleDateFormat format=new SimpleDateFormat("yyyy年MM月dd日");
            if (1 == prpCplan.getPayNo()) {
                insuraneItemsDto.setPlanStartdate(format.format(prpCplan.getPlanStartDate()));
            }
            insuraneItemsDto.setPlanDate(format.format(prpCplan.getPlanDate()));
//           PremiumConDto premiumConDto = new PremiumConDto();
            //TODO
            if ("RS3".equals(prpCplan.getPayReason()) || "PS3".equals(prpCplan.getPayReason())) {
                subsidySum+=prpCplan.getPlanFee();
                premiumConDto.setSubSidy03Premuim(premiumConDto.getSubSidy03Premuim() != null ? premiumConDto.getSubSidy03Premuim() :this.doubleToStr(prpCplan.getPlanFee(),2));
            }
            if ("RS4".equals(prpCplan.getPayReason()) || "PS4".equals(prpCplan.getPayReason())) {
                subsidySum+=prpCplan.getPlanFee();
                premiumConDto.setSubSidy04Premuim(premiumConDto.getSubSidy04Premuim() != null ? premiumConDto.getSubSidy04Premuim() :this.doubleToStr(prpCplan.getPlanFee(),2));
            }
            if ("RS5".equals(prpCplan.getPayReason()) || "PS5".equals(prpCplan.getPayReason())) {
                subsidySum+=prpCplan.getPlanFee();
                premiumConDto.setSubSidy05Premuim(premiumConDto.getSubSidy05Premuim() != null ? premiumConDto.getSubSidy05Premuim() :this.doubleToStr(prpCplan.getPlanFee(),2));
            }
            if ("RS6".equals(prpCplan.getPayReason()) || "PS6".equals(prpCplan.getPayReason())) {
                subsidySum+=prpCplan.getPlanFee();
                premiumConDto.setSubSidy06Premuim(premiumConDto.getSubSidy06Premuim() != null ? premiumConDto.getSubSidy06Premuim() :this.doubleToStr(prpCplan.getPlanFee(),2));
            }
            if ("RS7".equals(prpCplan.getPayReason()) || "PS7".equals(prpCplan.getPayReason())) {
                subsidySum+=prpCplan.getPlanFee();
                premiumConDto.setSubSidy07Premuim(premiumConDto.getSubSidy07Premuim() != null ? premiumConDto.getSubSidy07Premuim() :this.doubleToStr(prpCplan.getPlanFee(),2));
            }
//            if ("R10".equals(prpCplan.getPayReason()) || "P10".equals(prpCplan.getPayReason())) {
//                premiumConDto.setSubSidy10Premuim(premiumConDto.getSubSidy10Premuim() != null ? premiumConDto.getSubSidy10Premuim() :this.doubleToStr(prpCplan.getPlanFee(),2));
//            }
//            list.add(premiumConDto);
        }
        //农户自缴保费
        Double z=prpCmain.getSumPremium()-subsidySum;
        premiumConDto.setSubSidy10Premuim(this.doubleToStr(z,2));
        responsePolicyPrintDto.setPremiumConDto(premiumConDto);

        //特约内容赋值
        PrpCengage prpTengage = new PrpCengage();
        String ClauseCode;
        List<PrpCengage> prpTengages = new ArrayList<PrpCengage>();
        for (int i = 0; i < prpCengageList.size(); i++) {
            prpTengage = prpCengageList.get(i);
            prpTengages.add(prpTengage);
            ClauseCode = prpTengage.getClauseCode();
            if (ClauseCode!=null&&ClauseCode.trim().substring(0, 1).equals("T") && !(ClauseCode.trim().substring(0, 2).equals("TX"))&&prpTengage.getLineNo()!=1) {
                insuraneItemsDto.setClauses((insuraneItemsDto.getClauses()==null?"":insuraneItemsDto.getClauses())+prpTengage.getClauses());
            }
        }
        //绝对免赔率赋值
        DecimalFormat decimalFormat = new DecimalFormat("#,##0.00");
        String result = "";
        for (int i = 0; i < prpCengageList.size(); i++) {
            prpTengage = prpCengageList.get(i);
            if (prpTengage.getClauseCode() != null && prpTengage.getClauseCode().startsWith("TX001") && "1".equals(prpTengage.getTitleFlag())) {
                result = prpTengage.getClauses();
            }
        }
        //免赔说明
        String deduText = "";
        for (int i = 0; i < prpCengageList.size(); i++) {
            prpTengage = prpCengageList.get(i);
            if (prpTengage.getClauseCode() != null && prpTengage.getClauseCode().startsWith("TX004") && "1".equals(prpTengage.getTitleFlag())) {
                deduText = prpTengage.getClauses();
            }
        }

        result = decimalFormat.format(Double.parseDouble(Str.chgStrZero(result)));
        insuraneItemsDto.setDeductible(result);
        insuraneItemsDto.setDeduText(deduText);
        responsePolicyPrintDto.setInsuraneitems(insuraneItemsDto);
        return responsePolicyPrintDto;

    }
    private String doubleToStr(Double val, int i) {
        String patten="#,##0.0";
        for (int a=1;a<i;a++) {
            patten += "0";
        }
        DecimalFormat decimalFormat = new DecimalFormat(patten);
        val = val == null ? 0.0 : val;
        String strVal = decimalFormat.format(val);
        return strVal;
    }

    /**
     * @param policyNo
     * @return
     * @throws Exception
     * @description:打印流水号回写
     * @author: 潘峰
     * @date: 2017/10/19 14:07
     */
    @Transactional
    @Modifying(clearAutomatically = true)
    @Override
    public String upDatePrintNo(String policyNo, String printNo) throws Exception {
        if (org.apache.commons.lang3.StringUtils.isEmpty(policyNo)) {
            throw new DataVerifyException("保单号不能为空");
        }
        StringBuilder Sql = new StringBuilder("UPDATE  prpCmain t SET");
        Sql.append(" t.printNo='").append(printNo).append("'");
        Sql.append(" WHERE t.policyNo='").append(policyNo).append("'");
        Query dataQuery = entityManager.createQuery(Sql.toString());
        int i = dataQuery.executeUpdate();
        if (i > 0) {
            return "Success";
        }
        return "Fail";
    }

    @Override
    public ResponseUpdatePassWordDto changePassword(RequestUpdatePassWordDto requestUpdatePassWordDto) {
        if (StringUtils.isEmpty(requestUpdatePassWordDto.getUserCode())) {
            throw new DataVerifyException("请先录入用户代码");
        }
        if (StringUtils.isEmpty(requestUpdatePassWordDto.getUserName())) {
            throw new DataVerifyException("请先录入用户名");
        }
        if (StringUtils.isEmpty(requestUpdatePassWordDto.getOldPassword())) {
            throw new DataVerifyException("请先录入旧密码");
        }
        if (StringUtils.isEmpty(requestUpdatePassWordDto.getUserName())) {
            throw new DataVerifyException("请先录入新密码");
        }
        PacketDto packetDto = new PacketDto();
        packetDto.setHead(new HeadDto(requestUpdatePassWordDto.getUserCode(), requestUpdatePassWordDto.getOldPassword()));
        packetDto.setBody(requestUpdatePassWordDto);
        XmlUtil xmlUtil = new XmlUtil();
        String requestXml = xmlUtil.packetDtoToXml_bodyDto(packetDto);

//        发送给webService
        JaxWsProxyFactoryBean jaxWsProxyFactoryBean = new JaxWsProxyFactoryBean();
        jaxWsProxyFactoryBean.setServiceClass(AgriPrpallSelfQueryService.class);
        jaxWsProxyFactoryBean.setAddress(webAgriPrpallServiceUrl + "/webAgriPrpallService/services/AgriPrpallSelfQueryService?wsdl".trim());
        AgriPrpallSelfQueryService agriPrpallSelfQueryService = (AgriPrpallSelfQueryService) jaxWsProxyFactoryBean.create();
        String responseXml = agriPrpallSelfQueryService.updatePassWord(requestXml);

//        获取ResponseXml后解析为Dto 根据状态码抛出异常或者返回对象
        PacketDto<ResponseUpdatePassWordDto> responseDto = xmlUtil.xmlToPacketDto_bodyDto(responseXml, ResponseUpdatePassWordDto.class);
        String statusCode = responseDto.getHead().getReturnStatusCode();
        if (failCode.equals(statusCode)) {
            throw new BusinessException(responseDto.getHead().getReturnMessage());
        }
        ResponseUpdatePassWordDto responseUpdatePassWordDtos = responseDto.getBody();
        return responseUpdatePassWordDtos;

    }

}
