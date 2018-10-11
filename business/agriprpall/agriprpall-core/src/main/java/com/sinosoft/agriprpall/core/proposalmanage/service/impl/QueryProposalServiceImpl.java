package com.sinosoft.agriprpall.core.proposalmanage.service.impl;

import com.sinosoft.agriprpall.api.proposalmanage.dto.*;
import com.sinosoft.agriprpall.core.policymanage.dao.PrpCmainDao;
import com.sinosoft.agriprpall.core.policymanage.entity.PrpCmain;
import com.sinosoft.agriprpall.core.proposalmanage.dao.*;
import com.sinosoft.agriprpall.core.proposalmanage.dao.specification.QueryProposalSpecBuilder;
import com.sinosoft.agriprpall.core.proposalmanage.entity.*;
import com.sinosoft.agriprpall.core.proposalmanage.service.QueryProposalService;
import com.sinosoft.dms.api.customer.PrpDcustomerTaxPayInfoApi;
import com.sinosoft.dms.api.customer.dto.PrpDcustomerTaxPayInfoDto;
import com.sinosoft.dms.api.dict.PrpDcodeApi;
import com.sinosoft.dms.api.dict.dto.PrpDcodeDto;
import com.sinosoft.framework.core.service.impl.BaseServiceImpl;
import com.sinosoft.framework.core.utils.DateUtils;
import com.sinosoft.framework.core.utils.StringUtils;
import com.sinosoft.framework.dto.PageInfo;
import com.sinosoft.framework.exception.DataVerifyException;
import com.sinosoft.ims.api.auth.UtiGroupApi;
import com.sinosoft.ims.api.auth.dto.AddCodePowerConditionDto;
import com.sinosoft.ims.api.kernel.PrpDcompanyApi;
import com.sinosoft.ims.api.kernel.PrpDuserApi;
import com.sinosoft.ims.api.kernel.dto.PrpDuserDto;
import com.sinosoft.pms.api.kernel.PrpDriskApi;
import com.sinosoft.pms.api.kernel.PrpdclassApi;
import com.sinosoft.txnlist.api.gisinsurelist.GisInsureListApi;
import com.sinosoft.txnlist.api.gisinsurelist.dto.GisInsureMainListDto;
import com.sinosoft.txnlist.api.insuremainlist.InsureMainListApi;
import com.sinosoft.txnlist.api.insuremainlist.dto.InsureMainListDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;


/**
 * @Description: 投保单信息查询实现类
 * @Author: 何伟东
 * @Date: 2017/10/15 11:00
 */

@Service
public class QueryProposalServiceImpl extends BaseServiceImpl implements QueryProposalService {
    /**
     * log日志
     */
    private static final Logger LOGGER = LoggerFactory.getLogger(QueryProposalServiceImpl.class);

    /**
     * prpDcode服务Api
     */
    @Autowired
    private PrpDcodeApi prpDcodeApi;

    @Autowired
    private InsureMainListApi insureMainListApi;

    @PersistenceContext
    private EntityManager entityManager;

    @Autowired
    private PrpTmainDao prpTmainDao;

    @Autowired
    private PrpTmainAgriDao prpTmainAgriDao;

    @Autowired
    private PrpTitemKindDao prpTitemKindDao;

    @Autowired
    private PrpCmainDao prpCmainDao;

    @Autowired
    private PrpTitemKindAgriDao prpTitemKindAgriDao;

    @Autowired
    private PrpTsubsidyDao prpTsubsidyDao;

    @Autowired
    private PrpTfeeDao prpTfeeDao;

    @Autowired
    private PrpTplanDao prpTplanDao;

    @Autowired
    private PrpTinsuredDao prpTinsuredDao;

    @Autowired
    private PrpTaddressDao prpTaddressDao;

    @Autowired
    private PrpTengageDao prpTengageDao;

    @Autowired
    private PrpTcoinsDao prpTcoinsDao;

    @Autowired
    private PrpTcoinsDetailDao prpTcoinsDetailDao;
    @Autowired
    private PrpTplanCoinsDao prpTplanCoinsDao;
    @Autowired
    private PrpDuserApi prpDuserApi;
    @Autowired
    private PrpDcompanyApi prpDcompanyApi;
    @Autowired
    private PrpDcustomerTaxPayInfoApi prpDcustomerTaxPayInfoApi;
    @Autowired
    private UtiGroupApi utiGroupApi;
    @Autowired
    private PrpDriskApi prpDriskApi;
    @Autowired
    private GisInsureListApi gisInsureListApi;
    @Autowired
    private PrpdclassApi prpdclassApi;
    @Value("${sysconfig.common.systemFlag}")
    private String systemFlag;//新农险标识（mian表中的systemflag,用于区分新农险系统与老系统的数据）

    /**
     * @param requestDto 封装查询条件数据以及查询方式、页码信息请求参数
     * @return pageInfo 分页查询结果
     * @throws Exception 数据校验异常、数据库异常
     * @description: 类功能简述：根据查询入参的条件以及查询方式分页查询投保单列表信息
     * 实现逻辑概述：1.校验关键入参是否为空，校验页码是否页码信息
     * 2.根据入参拼接查询条件
     * 3.用封装的查询条件查询总记录数
     * 4.总记录数>0时，查询投保单列表信息
     * 5.遍历查询结果将投保单列表信息封装到PageInfo返回给前端
     * @author: 何伟东
     * @date: 2017/10/15 11:01
     */
    @Override
    public PageInfo<ResponseQueryProposalListInfoDto> queryProposalListInfoByConditon(RequestQueryProposalListInfoDto requestDto) throws Exception {
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

        // 查询数据HQL
        StringBuilder dataHql = new StringBuilder("select pt from PrpTmain pt where ");
        // 查询总数量的HQL
        StringBuilder countHql = new StringBuilder("select count(1) from PrpTmain pt where");
        // 条件hql拼接
        StringBuilder condition = new StringBuilder();
        Map<String, Object> conditions = new HashMap<>();
        //区分新老系统标识
        condition.append(" AND pt.systemFlag = :systemFlag");
        conditions.put("systemFlag", systemFlag);
        //投保单号proposalNo
        if (StringUtils.isNotEmpty(requestDto.getProposalNo())) {
            condition.append(" AND pt.proposalNo like :proposalNo");
            conditions.put("proposalNo", requestDto.getProposalNo() + "%");
        }
        //扶贫险种标志验证
        if (StringUtils.isNotEmpty(requestDto.getHpFlag())) {
            if ("1".equals(requestDto.getHpFlag())) {// 团体投保---贫困户
                condition.append(" AND pt.policyType in ('H23','I27','Q1','E1')");
            } else if ("2".equals(requestDto.getHpFlag())) {// 个体投保---规模经营主体
                condition.append(" AND pt.policyType in ('H24','I28','Q2','E2')");
            }
        }
        //获取权限查询条件
        AddCodePowerConditionDto addCodePowerConditionDto = new AddCodePowerConditionDto(requestDto.getUserCode(), requestDto.getLoginComCode(),
                requestDto.getLoginGradeCodes(), requestDto.getTableName(), requestDto.getUserCodeFields(),
                requestDto.getComCodeFields(), "", "pt", true);
        String codePower = utiGroupApi.addCodePower(addCodePowerConditionDto);
        condition.append(codePower);
        //合同号contractNo
        if (StringUtils.isNotEmpty(requestDto.getContractNo())) {
            condition.append(" AND pt.contractNo = :contractNo");
            conditions.put("contractNo", requestDto.getContractNo());
        }
        //印刷号printNo
        if (StringUtils.isNotEmpty(requestDto.getPrintNo())) {
            if ("0".equals(requestDto.getPrintNo())) {
                condition.append(" AND pt.printNo is null  ");
            } else {
                condition.append(" AND pt.printNo is not NULL ");
            }
        }
        //投保人代码appliCode
        if (StringUtils.isNotEmpty(requestDto.getAppliCode())) {
            condition.append(" AND pt.appliCode = :appliCode");
            conditions.put("appliCode", requestDto.getAppliCode());
        }
        //投保人名称appliName
        if (StringUtils.isNotEmpty(requestDto.getAppliName())) {
            condition.append(" AND pt.appliName like :appliName");
            conditions.put("appliName", "%" + requestDto.getAppliName() + "%");
        }
        //被保险人代码insuredCode
        if (StringUtils.isNotEmpty(requestDto.getInsuredCode())) {
            condition.append("  AND pt.insuredCode = :insuredCode");
            conditions.put("insuredCode", requestDto.getInsuredCode());
        }
        //被保险人名称insuredName
        if (StringUtils.isNotEmpty(requestDto.getInsuredName())) {
            condition.append(" AND pt.insuredName LIKE :insuredName");
            conditions.put("insuredName", "%" + requestDto.getInsuredName() + "%");
        }
        // 日期类条件校验逻辑说明，仅接收查询方式 >, <, >=, <=, = 其他参数全部按照精确查询（=）处理，以下日期处理逻辑相同
        //起保日期startDate 区间
        if (StringUtils.isNotEmpty(requestDto.getStartDate())) {
            condition.append(" AND pt.startDate >= to_date(:startDate, 'yyyy-mm-dd hh24:mi:ss')");
            conditions.put("startDate", requestDto.getStartDate());
        }
        if (StringUtils.isNotEmpty(requestDto.getStartDateEnd())) {
            condition.append(" AND pt.startDate <= to_date(:startDateEnd, 'yyyy-mm-dd hh24:mi:ss')");
            conditions.put("startDateEnd", requestDto.getStartDateEnd());
        }
        //终保日期endDate 区间
        if (StringUtils.isNotEmpty(requestDto.getEndDate())) {
            condition.append(" AND pt.endDate <= to_date(:endDate, 'yyyy-mm-dd hh24:mi:ss')");
            conditions.put("endDate", requestDto.getEndDate());
        }
        if (StringUtils.isNotEmpty(requestDto.getEndStartDate())) {
            condition.append(" AND pt.endDate >= to_date(:endStartDate, 'yyyy-mm-dd hh24:mi:ss')");
            conditions.put("endStartDate", requestDto.getEndStartDate());
        }
        //总保额sumAmount
        if (StringUtils.isNotEmpty(requestDto.getSumAmount())) {
            condition.append(" AND pt.sumAmount = :sumAmount");
            conditions.put("sumAmount", Double.parseDouble(requestDto.getSumAmount()));
        }
        //总保费sumPremium
        if (StringUtils.isNotEmpty(requestDto.getSumPremium())) {
            condition.append(" AND pt.sumPremium = :sumPremium");
            conditions.put("sumPremium", Double.parseDouble(requestDto.getSumPremium()));
        }
        //出单机构makeCom
        if (StringUtils.isNotEmpty(requestDto.getMakeCom())) {
            condition.append(" AND pt.makeCom = :makeCom");
            conditions.put("makeCom", requestDto.getMakeCom());
        }
        //经办人代码handlerCode
        if (StringUtils.isNotEmpty(requestDto.getHandlerCode())) {
            condition.append(" AND pt.handlerCode = :handlerCode");
            conditions.put("handlerCode", requestDto.getHandlerCode());
        }
        //操作员代码operatorCode
        if (StringUtils.isNotEmpty(requestDto.getOperatorCode())) {
            condition.append(" AND pt.operatorCode = :operatorCode");
            conditions.put("operatorCode", requestDto.getOperatorCode());
        }
        //制单日期operateStartDate and 制单日期operateDateEnd 区间
        if (StringUtils.isNotEmpty(requestDto.getOperateStartDate())) {
            condition.append(" AND pt.operateDate >= to_date(:operateStartDate, 'yyyy-mm-dd hh24:mi:ss')");
            conditions.put("operateStartDate", requestDto.getOperateStartDate());

        }
        if (StringUtils.isNotEmpty(requestDto.getOperateDateEnd())) {
            condition.append(" AND pt.operateDate <= to_date(:operateDateEnd, 'yyyy-mm-dd hh24:mi:ss')");
            conditions.put("operateDateEnd", requestDto.getOperateDateEnd());
        }
        //输入日期inputDate
        if (StringUtils.isNotEmpty(requestDto.getInputDate())) {
            condition.append(" AND pt.inputDate <= to_date(:inputDate, 'yyyy-mm-dd hh24:mi:ss')");
            conditions.put("inputDate", requestDto.getInputDate());
        }
        //核保标志underWriteFlag
        if (StringUtils.isNotEmpty(requestDto.getUnderWriteFlag())) {
            String underWriteFlag = requestDto.getUnderWriteFlag();
            if (!"10".equals(underWriteFlag) && !"11".equals(underWriteFlag) && !"2".equals(underWriteFlag)) {
                if ("0".equals(underWriteFlag)) {
                    condition.append(" AND pt.underwriteFlag in('0','8') AND substr(pt.othFlag,4,1) <> '2' ");
                } else {
                    condition.append(" AND pt.underwriteFlag =:underwriteFlag AND substr(pt.othFlag,4,1) <> '2' ");
                    conditions.put("underwriteFlag", underWriteFlag);
                }
            } else if ("10".equals(underWriteFlag)) {// 核保退回
                condition.append(" AND pt.underwriteFlag='2'  AND substr(pt.othFlag,4,1) <>'3'  ");
            } else if ("11".equals(underWriteFlag)) {//已撤单
                condition.append(" AND substr(pt.othFlag,4,1) = '2' ");
            } else if ("2".equals(underWriteFlag)) {//不通过（拒保）
                condition.append(" AND pt.underwriteFlag='2' AND substr(pt.othFlag,4,1) ='3'  ");
            }
        }
        //政策/商业标志businessType1
        if (StringUtils.isNotEmpty(requestDto.getBusinessType1())) {
            condition.append(" AND pt.businessType1 = :businessType1");
            conditions.put("businessType1", requestDto.getBusinessType1());
        }
        // 查询总数据量的Hql拼接
        String where = condition.toString().replaceFirst("AND", "");
        countHql.append(where);
        // 查询数据hql拼接条件以及排序hql
        dataHql.append(where).append(" order by pt.proposalNo desc");
        javax.persistence.Query countQuery = entityManager.createQuery(countHql.toString());
        javax.persistence.Query dataQuery = entityManager.createQuery(dataHql.toString());
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
        List<PrpTmain> dataList;
        List<ResponseQueryProposalListInfoDto> responseList = new ArrayList<>();
        // 当查询到的总记录数大于0才继续查询
        if (countNum > 0) {
            List<String> proposalNos = new ArrayList<>();
            dataList = dataQuery.getResultList();
            ResponseQueryProposalListInfoDto responseQueryProposalListInfoDto;
            //迭代查询结果
            for (int i = 0; i < dataList.size(); i++) {
                PrpTmain prptmain = dataList.get(i);
                responseQueryProposalListInfoDto = new ResponseQueryProposalListInfoDto();
                String proposalNo = prptmain.getProposalNo();
                responseQueryProposalListInfoDto.setProposalNo(proposalNo);
                proposalNos.add(proposalNo);
                responseQueryProposalListInfoDto.setContractNo(prptmain.getContractNo());
                responseQueryProposalListInfoDto.setInsuredName(prptmain.getInsuredName());
                responseQueryProposalListInfoDto.setAppliName(prptmain.getAppliName());
                responseQueryProposalListInfoDto.setStartDate(DateUtils.dateToStr(prptmain.getStartDate()));
                responseQueryProposalListInfoDto.setEndDate(DateUtils.dateToStr(prptmain.getEndDate()));
                responseQueryProposalListInfoDto.setOperatorCode(prptmain.getOperatorCode());
                responseQueryProposalListInfoDto.setRiskCode(prptmain.getRiskCode());
                responseQueryProposalListInfoDto.setBusinessType1(prptmain.getBusinessType1());
                Map<String, String> map = new HashMap<>();
                map.put("riskCode", prptmain.getRiskCode());
                map.put("isChinese", "zh-CN");
                if (prptmain.getRiskCode() != null) {
                    responseQueryProposalListInfoDto.setRiskCname(prpDriskApi.translateCode(map));
                }
                // 操作员名称转译需要调用其他应用服务暂无法实现：暂设置为操作员代码
                responseQueryProposalListInfoDto.setOperatorName(this.getPrpDuserName(prptmain.getOperatorCode()));
                responseQueryProposalListInfoDto.setOperateDate(DateUtils.dateToStr(prptmain.getOperateDate()));
                responseQueryProposalListInfoDto.setUnderWriteFlag(prptmain.getUnderwriteFlag());
                responseQueryProposalListInfoDto.setOthFlag(prptmain.getOthFlag());
                responseList.add(responseQueryProposalListInfoDto);
            }

            // 校验是否重复投保
            Map<String, List<String>> paramMap = new HashMap<>();
            paramMap.put("proposalNos", proposalNos);
            // 根据投保单号查询该投保单对应的gis清单下所有的投保清单信息
            List<InsureMainListDto> insureMainListDtos = insureMainListApi.queryByProposalNos(paramMap);
            Map<String,String> gisInsureListCodeByProposalNo = new HashMap<>();
            insureMainListDtos.forEach(insureMainListDto -> gisInsureListCodeByProposalNo.put(insureMainListDto.getProposalNo(), insureMainListDto.getGisInsureListCode()));
            Map<String, List<InsureMainListDto>> insureMainListGroupByGisInsureListCode = insureMainListDtos.stream().collect(Collectors.groupingBy(InsureMainListDto::getGisInsureListCode));
            responseList.forEach(responseDto -> {
                String proposalNo = responseDto.getProposalNo();
                String gisInsureListCode = gisInsureListCodeByProposalNo.get(proposalNo);
                List<InsureMainListDto> _insureMainListDtos = insureMainListGroupByGisInsureListCode.get(gisInsureListCode);
                boolean repeatFlag = checkRepeatInsured(responseDto.getRiskCode(), responseDto.getBusinessType1(), responseDto.getStartDate(), responseDto.getEndDate(), _insureMainListDtos);
                responseDto.setRepeatFlag(repeatFlag);
            });
        }
        // 统一封装分页响应dto
        PageInfo<ResponseQueryProposalListInfoDto> pageInfo = new PageInfo<>();
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
        List<String> list = new ArrayList<>();
        list.add(code);
        List<String> nameList = prpDuserApi.queryOperatorName(list);
        String name = "";
        if (nameList != null && nameList.size() > 0) {
            name = nameList.get(0);
        }

        return name;
    }

    /**
     * @param proposalNo 投保单号
     * @return
     * @throws Exception
     * @description: 方法功能简述：根据投保单号码查询投保单详细信息
     * @author: 何伟东, 王保良
     * @date: 2017/10/18 11:53
     */
    @Override
    public ResponseQueryProposalInfoDto queryProposalInfoByProposalNoAndFamilyNos(String proposalNo, String familyNos) throws Exception {
        //根据投保单号查询保单号
        List<PrpCmain> prpcmainList = prpCmainDao.findByProposalNo(proposalNo);
        // 投保单主表信息查询
        PrpTmain prpTmain = prpTmainDao.findOne(new PrpTmainKey(proposalNo));
        if (prpTmain == null || !systemFlag.equals(prpTmain.getSystemFlag())) {//如果不是新系统数据，则返回null
            return null;
        }
        //messType的含义 这个现在已经不需要了 但是暂时放在这里避免报错
        String messType = prpTmain.getFlag();
        StringBuilder familyConditions = new StringBuilder();
        if (StringUtils.isNotEmpty(messType)) {
            messType = messType.substring(1, 2);
        } else {
            messType = "";
        }
        // 团单时blPrpTitemKind、blPrpTinsured
        if (StringUtils.isNotEmpty(messType)) {//团单
            familyConditions.append(familyNos);
        }

        // 农业保险主信息
        PrpTmainAgri prpTmainAgri = prpTmainAgriDao.findOne(new PrpTmainAgriKey(proposalNo));
        // 地址信息
        PrpTaddress prpTaddress = prpTaddressDao.findOne(new PrpTaddressKey(proposalNo, 1));
        // 保额保费信息
        PrpTfee prpTfee = prpTfeeDao.findOne(new PrpTfeeKey(proposalNo, prpTmain.getCurrency()));
        // 缴费计划表
        List<PrpTplan> prpTplanList = prpTplanDao.findAll(QueryProposalSpecBuilder.prpTplanByProposalNoSpecification(proposalNo));
        // 标的信息（主险、附加险）
        List<PrpTitemKind> prpTitemKindList = prpTitemKindDao.findAll(QueryProposalSpecBuilder.prpTitemKindByProposalNoSpecification(proposalNo, familyConditions.toString()));
        // 农险标的信息
        List<PrpTitemKindAgri> prpTitemKindAgriList = prpTitemKindAgriDao.findAll(QueryProposalSpecBuilder.prpTitemKindAgriByProposalNoSpecification(proposalNo));
        // 政府补贴信息
        List<PrpTsubsidy> prpTsubsidyList = prpTsubsidyDao.findAll(QueryProposalSpecBuilder.prpTsubsidyByProposalNoSpecification(proposalNo));
        // 客户资料信息
        List<PrpTinsured> prpTinsuredList = prpTinsuredDao.findAll(QueryProposalSpecBuilder.prpTinsuredByProposalNoSpecification(proposalNo, familyConditions.toString()));
        // 共保信息
        List<PrpTcoins> prpTcoinsList = prpTcoinsDao.findAll(QueryProposalSpecBuilder.prpTcoinsByProposalNoSpecification(proposalNo));
        // 共保明细信息
        List<PrpTcoinsDetail> prpTcoinsDetailList = prpTcoinsDetailDao.findAll(QueryProposalSpecBuilder.prpTcoinsDetailByProposalNoSpecification(proposalNo));
        //共保方收费计划信息
        List<PrpTplanCoins> prpTplanCoinsList = prpTplanCoinsDao.findAll(QueryProposalSpecBuilder.prpTplanCoinsByProposalNoSpecification(proposalNo));
        // 特别约定
        List<PrpTengage> prpTengageList = prpTengageDao.findByProposalNo(proposalNo);

        // 投保单基本信息赋值
        PrpTmainDto prpTmainDto = convert(prpTmain, PrpTmainDto.class);
        //保单号
        if (prpcmainList.size() > 0) {
            prpTmainDto.setPolicyNo(prpcmainList.get(0).getPolicyNo());
        }
        // 调用机构查询comName服务查询机构名称
        prpTmainDto.setComName(prpDcompanyApi.queryByPK(prpTmain.getComCode()).getComCName());
        //GroupNo中保存的是模板号modelCode
        prpTmainDto.setModelCode(prpTmain.getGroupNo());
        Map<String, String> map = new HashMap<>();
        map.put("riskCode", prpTmain.getRiskCode());
        map.put("isChinese", "zh-CN");
        //翻译险种名称 得到险种代码+险种名称的字符串
        prpTmainDto.setRiskCodeName(prpDriskApi.translateCode(map));
        prpTmainDto.setClassName(prpdclassApi.queryByPK(prpTmain.getClassCode()).getClassName());


        //现在存的是扶贫标志
        prpTmainDto.setPovertyFlag(prpTmain.getEccFlag());
        // [操作员名称] 和 [最近修改人名称]
        PrpDuserDto prpDuserDto = prpDuserApi.queryByPK(prpTmain.getOperatorCode());

        prpTmainDto.setOperatorName(prpDuserDto.getUserName());
        prpTmainDto.setUpdaterName(prpDuserApi.queryByPK(prpTmain.getUpdaterCode()).getUserName());

        PrpTmainAgriDto prpTmainAgriDto = new PrpTmainAgriDto();
        //合同信息由prpTfee表转换而来
        ContractinfoDto contractinfoDto = convert(prpTfee, ContractinfoDto.class);
        prpTmainAgriDto = convert(prpTmainAgri, PrpTmainAgriDto.class);
        contractinfoDto.setPrpTmainAgriDto(prpTmainAgriDto);
        // 调用清单系统查询insureMainList表 此处加入判断是否为空 但是一定非空 保单必然和清单关联
        List<InsureMainListDto> insureMainListDtoList = insureMainListApi.queryByProposalNo(proposalNo);
        GisInsureMainListDto gisInsureMainListDto = new GisInsureMainListDto();
        if (insureMainListDtoList.size() > 0) {
            InsureMainListDto insureMainListDto = insureMainListDtoList.get(0);
            String gisInsureMainListCode = insureMainListDto.getGisInsureListCode();
            Integer serialNo = insureMainListDto.getSerialNo();
            String serial = String.valueOf(serialNo);
            Map<String, String> map1 = new HashMap<>();
            map1.put("gisInsureMainListCode", gisInsureMainListCode);
            map1.put("serialNo", serial);
            gisInsureMainListDto = gisInsureListApi.queryByPk(map1);

            //清单类型(D:大户 S:散户)
            String listTypeFlag = gisInsureMainListDto.getListType();
            contractinfoDto.setListTypeFlag(listTypeFlag);
            contractinfoDto.setGisInsureListCode(gisInsureMainListCode);
            // 承保清单归属区域
            contractinfoDto.setFareaCode(insureMainListDto.getfAreaCode());
            // 清单编号
            contractinfoDto.setInsureListCode(insureMainListDto.getInusreListCode());
            // 清单备注
            contractinfoDto.setRemark(prpTmainAgri.getRelationListNoRemark());
            // 清单类型 (不是这个字段,清单类型在上面)
            contractinfoDto.setValicity(insureMainListDto.getValidity());
        }

        // 合同信息-币别信息赋值
        contractinfoDto.setPolicyType(prpTmain.getPolicyType());
        contractinfoDto.setProposalType(prpTmainAgri.getRemark());
        contractinfoDto.setRaiseType(prpTmainAgri.getRaiseType());
        contractinfoDto.setStatQuantity(prpTmain.getStatQuantity());
        contractinfoDto.setSumInsured(prpTmain.getSumInsured());
        contractinfoDto.setRaiseDate(prpTmainAgri.getRaiseDate());
        //翻译币别名称
        String currency2Name = prpDcodeApi.queryByPK("CURRENCY_CI", prpTfee.getCurrency2()).getCodeCName();
        contractinfoDto.setCurrency2Name(currency2Name);

        contractinfoDto.setAddressNo(prpTaddress.getAddressNo());
        contractinfoDto.setAddressCode(prpTaddress.getAddressCode());
        contractinfoDto.setAddressName(prpTaddress.getAddressName());
        contractinfoDto.setPayTimes(prpTmain.getPayTimes());

        // 主险附加险
        List<PrpTitemKindDto> prpTitemKindDtoList = new ArrayList<>();
        for (PrpTitemKind prpTitemKind : prpTitemKindList) {
            PrpTitemKindDto prpTitemKindDto = convert(prpTitemKind, PrpTitemKindDto.class);
            for (PrpTitemKindAgri prpTitemKindAgri : prpTitemKindAgriList) {// 主险承保明细赋值
                if (prpTitemKind.getProposalNo().equals(prpTitemKindAgri.getProposalNo())
                        && prpTitemKind.getItemKindNo().equals(prpTitemKindAgri.getItemKindNo())
                        && prpTitemKind.getKindCode().equals(prpTitemKindAgri.getKindCode())
                        //这里加入判断UnitAmount不为空，是为了防止茬次信息存在影响数据
                        && prpTitemKindAgri.getUnitAmount() != null) {
                    prpTitemKindDto.setUnitAmount(prpTitemKindAgri.getUnitAmount());
                    prpTitemKindDto.setInsureArea(prpTitemKindAgri.getInsureArea());
                    prpTitemKindDto.setAgriGrossQuantityMain(prpTitemKindAgri.getGrossQuantity());
                    prpTitemKindDto.setUnitCost(prpTitemKindAgri.getUnitCost());
                    prpTitemKindDto.setAgriTimesAmount(prpTitemKindAgri.getTimesAmount());
                    prpTitemKindDto.setProportion(prpTitemKindAgri.getProportion());
                    //根据单位生产成本和一定的生产成本的结果是不一样的,从itemkindagri中取值也不一样
                    // 表示是参照生产成本确定 页面上3条
//                    if ("1".equals(prpTmainAgri.getRemark())){
//                        prpTitemKindDto.setAgriUnitCostMain(prpTitemKindAgri.getUnitCost());
//                    }
//                    // 表示是根据单位保额和单位保费确定 页面上4条
//                    else {
//                        prpTitemKindDto.setAgriUnitCostMain(prpTitemKindAgri.getUnitOutput());
//                    }
                    prpTitemKindDto.setAgriUnitCostMain(prpTitemKindAgri.getUnitCost());
                    prpTitemKindDto.setAgriUnitOutputMain(prpTitemKindAgri.getUnitOutput());
                    prpTitemKindDto.setAgriStartDate(prpTitemKindAgri.getStratDate());
                    prpTitemKindDto.setAgriEndDate(prpTitemKindAgri.getEndDate());
                }
            }
            prpTitemKindDtoList.add(prpTitemKindDto);
        }

        //茬次信息
        List<PrpTitemKindAgriDto> prpTitemKindAgriDtoList = new ArrayList<PrpTitemKindAgriDto>();
        if ("3134".equals(prpTmainDto.getRiskCode()) || "3147".equals(prpTmainDto.getRiskCode()) || "3141".equals(prpTmainDto.getRiskCode()) || "3102".equals(prpTmainDto.getRiskCode())) {
            PrpTitemKindAgriDto prpTitemKindAgriDto = null;
            for (PrpTitemKindAgri prpTitemKindAgri : prpTitemKindAgriList) {
                if (prpTitemKindAgri.getDistributingRate() != null && prpTitemKindAgri.getTimesAmount() != null
                        && prpTitemKindAgri.getStratDate() != null && prpTitemKindAgri.getEndDate() != null) {
                    prpTitemKindAgriDto = convert(prpTitemKindAgri, PrpTitemKindAgriDto.class);
                    prpTitemKindAgriDtoList.add(prpTitemKindAgriDto);
                }
            }
        }

        // 补贴信息 没什么特别的 直接转换即可
        List<PrpTsubsidyDto> prpTsubsidyDtoList = new ArrayList<>();
        convertCollection(prpTsubsidyList, prpTsubsidyDtoList, PrpTsubsidyDto.class);

        // 缴费计划信息
        // 循环 需要翻译prpDcodeApi 并且翻译付款原因
        List<PrpTplanDto> prpTplanDtoList = new ArrayList<>();
        for (PrpTplan prpTplan : prpTplanList) {
            PrpTplanDto prpTplanDto = convert(prpTplan, PrpTplanDto.class);
            prpTplanDto.setPayreFee(prpTplan.getPlanFee() - prpTplan.getDelinquentFee());
            PrpDcodeDto prpDcodeDto = prpDcodeApi.queryByPK("PayRefReason", prpTplan.getPayReason());
            if (prpDcodeDto != null) {
                prpTplanDto.setPayReasonName(prpDcodeDto.getCodeCName());
            }
            prpTplanDtoList.add(prpTplanDto);
        }
        // 合同信息数据赋值
        /**合同信息中包括补贴信息,主险附加险信息以及缴费计划 */
        contractinfoDto.setPrpTitemKindList(prpTitemKindDtoList);
        contractinfoDto.setPrpTsubsidyList(prpTsubsidyDtoList);
        contractinfoDto.setPrpTplanList(prpTplanDtoList);
        contractinfoDto.setPrpTitemKindAgriDtoList(prpTitemKindAgriDtoList);

        /** customerinfodto 中包括 保险人信息,被保险人信息,以及发票购货方信息*/
        CustomerInfoDto customerInfoDto = new CustomerInfoDto();
        PrpTinsuredDto appliInsuredDto = null;// 投保人
        PrpTinsuredDto insuredDto = null;// 被保险人
        //循环客户资料信息 insured2代表投保人 1代表被保险人 将投保人信息和被投保人信息带出来 放到两个对象中
        for (PrpTinsured prpTinsured : prpTinsuredList) {
            if ("2".equals(prpTinsured.getInsuredFlag())) {
                appliInsuredDto = convert(prpTinsured, PrpTinsuredDto.class);
                String codeCode = appliInsuredDto.getIdentifyType();
                if (StringUtils.isNotEmpty(codeCode)) {
                    PrpDcodeDto prpDcodeDto = prpDcodeApi.queryByPK("IdentifyType", codeCode);
                    if (prpDcodeDto != null) {
                        String identifyName = prpDcodeDto.getCodeCName();
                        appliInsuredDto.setIdentifyTypeName(identifyName);
                    }
                }
            } else if ("1".equals(prpTinsured.getInsuredFlag())) {
                insuredDto = convert(prpTinsured, PrpTinsuredDto.class);
                String codeCode = insuredDto.getIdentifyType();
                if (StringUtils.isNotEmpty(codeCode)) {
                    PrpDcodeDto prpDcodeDto = prpDcodeApi.queryByPK("IdentifyType", codeCode);
                    if (prpDcodeDto != null) {
                        String identifyName = prpDcodeDto.getCodeCName();
                        insuredDto.setIdentifyTypeName(identifyName);
                    }
                }
            }
        }
        // 发票购方信息
        List<PrpDcustomerTaxPayInfoDto> prpDcustomerTaxPayInfoDtoList = new ArrayList<>();
        //customerInfoDto中放置投保人信息和被投保人信息
        customerInfoDto.setInsuredDto(insuredDto);
        customerInfoDto.setAppliInsuredDto(appliInsuredDto);

        // 发票购方信息(纳税人信息)赋值，需要调用dms系统查询prpDcustomerTaxPayInfo
        //用投保人信息的客户代码去查询发票购货方表 投保人和被保险人在大多数情况下都是同一个人 但是
        //发票购货方信息总要有一个匹配的,即是投保人或者被保险人
        PrpDcustomerTaxPayInfoDto prpDcustomerTaxPayInfoDto = prpDcustomerTaxPayInfoApi.queryByPK(appliInsuredDto.getInsuredCode());
        //如果查到了
        if (prpDcustomerTaxPayInfoDto != null) {
            //获取发表购货方的类型:投保人或者被保险人 2代表被保险人
            if ("2".equals(prpDcustomerTaxPayInfoDto.getPayInfoObject())) {
                prpDcustomerTaxPayInfoDto = prpDcustomerTaxPayInfoApi.queryByPK(insuredDto.getInsuredCode());
                prpDcustomerTaxPayInfoDto.setPostCode(insuredDto.getPostCode());
            }
            //存入邮政编码 之前不能解释,之所以要设置这个是因为发票购货方信息中没有postcode字段 现在发票购货方信息中已经加入了这个字段
            prpDcustomerTaxPayInfoDto.setPostCode(appliInsuredDto.getPostCode());
        }
        //如果没查到 直接说明了就是被保险人的,拿被保险人的insureCode去查询
        else {
            //如果是被保险人
            prpDcustomerTaxPayInfoDto = prpDcustomerTaxPayInfoApi.queryByPK(insuredDto.getInsuredCode());
            //同样也要设置发票购货方信息的邮编
            prpDcustomerTaxPayInfoDto.setPostCode(insuredDto.getPostCode());
        }
        prpDcustomerTaxPayInfoDtoList.add(prpDcustomerTaxPayInfoDto);
        //再将这个集合set进customerInfo中
        customerInfoDto.setCustomerTaxPayInfoDtoList(prpDcustomerTaxPayInfoDtoList);

        // 其他信息
        OtherInfoDto otherInfoDto = new OtherInfoDto();
        otherInfoDto.setCoinsFlag(prpTmain.getCoinsFlag());
        otherInfoDto.setCoinsPremiumType(prpTmain.getCoinsPremiumType());

        // 共保信息
        List<PrpTcoinsDto> prpTcoinsDtoList = new ArrayList<>();
        List<PrpTcoinsDetailDto> prpCitemKindAgriDtoList = new ArrayList<>();
        this.convertCollection(prpTcoinsDetailList, prpCitemKindAgriDtoList, PrpTcoinsDetailDto.class);
        otherInfoDto.setPrpTcoinsDetailDtoList(prpCitemKindAgriDtoList);
        List<PrpTplanCoinsDto> prpTplanCoinsDtoList = new ArrayList<>();
        this.convertCollection(prpTplanCoinsList, prpTplanCoinsDtoList, PrpTplanCoinsDto.class);
        otherInfoDto.setPrpTplanCoinsDtoList(prpTplanCoinsDtoList);
        for (PrpTcoins prpTcoins : prpTcoinsList) {
            PrpTcoinsDto prpTcoinsDto = convert(prpTcoins, PrpTcoinsDto.class);
            double amount = 0, permium = 0;
            // 计算保额保费
            for (PrpTcoinsDetail prpTcoinsDetail : prpTcoinsDetailList) {
                if (prpTcoins.getProposalNo().equals(prpTcoinsDetail.getProposalNo())
                        && prpTcoins.getSerialNo().equals(prpTcoinsDetail.getSerialNo())) {
                    amount += prpTcoinsDetail.getCoinsAmount();
                    permium += prpTcoinsDetail.getCoinsPremium();
                }
            }
            prpTcoinsDto.setCoinsAmount(amount);
            prpTcoinsDto.setCoinsPremium(permium);
            prpTcoinsDtoList.add(prpTcoinsDto);
        }
        // 特别约定信息 要经过特殊处理,将4个拼接成一个
        List<QueryProposalPrpTengageDto> prpTengageDtoList = new ArrayList<>();
        QueryProposalPrpTengageDto prpTengageDto = null;
        for (PrpTengage prpTengage : prpTengageList) {
            if (prpTengageDto == null || !prpTengage.getClauseCode().equals(prpTengageDto.getClauseCode())) {
                prpTengageDto = new QueryProposalPrpTengageDto();
                prpTengageDto.setClauseCode(prpTengage.getClauseCode());
                prpTengageDto.setSerialNo(prpTengage.getSerialNo());
                prpTengageDtoList.add(prpTengageDto);
            }
            // 条款标题名称
            if ("0".equals(prpTengage.getTitleFlag())) {
                prpTengageDto.setClauseName(prpTengage.getClauses());
            } else {
                if (StringUtils.isEmpty(prpTengageDto.getClausesContent())) {
                    prpTengageDto.setClausesContent(prpTengage.getClauses());
                } else {
                    prpTengageDto.setClausesContent(prpTengageDto.getClausesContent() + prpTengage.getClauses());
                }
            }
        }
        /** otherInfoDto中包括 共保信息以及特约信息 */

        otherInfoDto.setPrpTcoinsDtoList(prpTcoinsDtoList);
        otherInfoDto.setPrpTengageList(prpTengageDtoList);
        // 信息汇总返回
        ResponseQueryProposalInfoDto responseQueryProposalInfoDto = new ResponseQueryProposalInfoDto();
        responseQueryProposalInfoDto.setPrpTmainDto(prpTmainDto);
        responseQueryProposalInfoDto.setContractinfoDto(contractinfoDto);
        responseQueryProposalInfoDto.setCustomerDto(customerInfoDto);
        responseQueryProposalInfoDto.setOtherInfoDto(otherInfoDto);
        responseQueryProposalInfoDto.setGisInsureMainListDto(gisInsureMainListDto);
        return responseQueryProposalInfoDto;
    }

    /**
     * 校验是否重复投保
     *
     * @param riskCode      险种代码
     * @param businessType1 政策性标志
     * @param startDate     起保日期
     * @param endDate       终保日期
     * @author: 何伟东
     * @date: 2018/4/21 16:20
     */
    private boolean checkRepeatInsured(String riskCode, String businessType1, String startDate, String endDate, List<InsureMainListDto> insureMainListDtos) {
        List<String> policyNoS = new ArrayList<>();
        for (InsureMainListDto dto : insureMainListDtos) {
            policyNoS.add(dto.getPolicyNo());
        }
        String policyNoCodition = parseListCondition(" c.policyNo", policyNoS);
        if (policyNoCodition == null) {
            policyNoCodition = "";
        } else {
            policyNoCodition = " and " + policyNoCodition;
        }
        StringBuilder sql = new StringBuilder("select count(1)");
        sql.append(" from (select distinct c.*");
        sql.append(" from prpcmain c");
        sql.append(" left join PrpPhead p");
        sql.append(" on c.policyNo = p.policyNo");
        sql.append(" where c.underwriteFlag in ('1', '3')");
        sql.append(policyNoCodition);
        sql.append(" and c.riskCode = :riskCode");
        sql.append(" and c.BusinessType1 = :businessType1");
        sql.append(" and to_char(c.endDate, 'YYYY-MM-dd') >= to_char(sysdate, 'YYYY-MM-dd')");
        sql.append(" and ((p.endorType not in ('19', '21') and");
        sql.append(" (to_char(c.startDate, 'YYYY-MM-dd') between :startDate and");
        sql.append(" :endDate or to_char(c.endDate, 'YYYY-MM-dd') between");
        sql.append(" :startDate and :endDate or");
        sql.append(" to_date(:startDate, 'YYYY-MM-dd') between c.startDate and");
        sql.append(" c.endDate)) or");
        sql.append(" ((p.endorType in ('19', '21') and");
        sql.append(" (to_char(p.validdate, 'YYYY-MM-dd') between :startDate and");
        sql.append(" to_char(c.EndDate, 'YYYY-MM-dd') or");
        sql.append(" to_char(p.validdate, 'YYYY-MM-dd') between");
        sql.append(" to_char(c.startdate, 'YYYY-MM-dd') and :endDate)))))");
        Query dataQuery = entityManager.createNativeQuery(sql.toString());
        dataQuery.setParameter("riskCode", riskCode);
        dataQuery.setParameter("businessType1", businessType1);
        dataQuery.setParameter("startDate", startDate);
        dataQuery.setParameter("endDate", endDate);
        Long countSize = Long.valueOf(dataQuery.getSingleResult().toString());
        if (countSize > 0) {
            return true;
        }
        return false;
    }

    /**
     * sql in 1000条拆分
     *
     * @param field 字段
     * @param list  条件集合
     * @return
     */
    private String parseListCondition(String field, List<String> list) {
        if (list.isEmpty()) {
            return null;
        }
        int splitn = 50;
        StringBuilder sb = new StringBuilder("(" + field + " in(");
        for (int i = 0; i < list.size(); i++) {
            if (i > 0 && i % splitn == 0) {
                sb.append(") ");
                sb.append("or " + field + " in(");
            } else if (i > 0) {
                sb.append(",");
            }
            sb.append(list.get(i));
        }
        sb.append("))");

        return sb.toString();
    }
}