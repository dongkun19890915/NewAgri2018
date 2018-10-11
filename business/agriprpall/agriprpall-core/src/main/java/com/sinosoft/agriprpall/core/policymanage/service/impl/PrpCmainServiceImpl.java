package com.sinosoft.agriprpall.core.policymanage.service.impl;

import com.sinosoft.agriprpall.api.endorsemanage.dto.PrpCPmainDto;
import com.sinosoft.agriprpall.api.endorsemanage.dto.PrpPmainDto;
import com.sinosoft.agriprpall.api.policymanage.dto.PrpCmainDto;
import com.sinosoft.agriprpall.api.policymanage.dto.PrpCmainRequestDto;
import com.sinosoft.agriprpall.api.policymanage.dto.RequestPrpCmainInfoDto;
import com.sinosoft.agriprpall.api.policymanage.dto.ResponsePrpCmainInfoDto;
import com.sinosoft.agriprpall.core.policymanage.dao.PrpCmainDao;
import com.sinosoft.agriprpall.core.policymanage.entity.PrpCmain;
import com.sinosoft.agriprpall.core.policymanage.entity.PrpCmainKey;
import com.sinosoft.agriprpall.core.policymanage.service.PrpCinsuredService;
import com.sinosoft.agriprpall.core.policymanage.service.PrpCmainService;
import com.sinosoft.framework.agri.core.service.impl.BaseCustomServiceImpl;
import com.sinosoft.framework.core.utils.StringUtils;
import com.sinosoft.framework.dto.PageInfo;
import com.sinosoft.framework.exception.DataVerifyException;
import com.sinosoft.ims.api.kernel.PrpDuserApi;
import com.sinosoft.ims.api.kernel.dto.PrpDuserDto;
import com.sinosoft.txnlist.api.insuremainlist.InsureMainListApi;
import com.sinosoft.txnlist.api.insuremainlist.dto.InsureMainListDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class PrpCmainServiceImpl extends BaseCustomServiceImpl implements PrpCmainService{
    /** log日志 */
    private static final Logger LOGGER = LoggerFactory.getLogger(PrpCplanServiceImpl.class);
    @Autowired
    private PrpCmainDao prpCmainDao;
    @Autowired
    private PrpCinsuredService prpCinsuredService;
    @PersistenceContext
    private EntityManager entityManager;
    @Value("${sysconfig.common.systemFlag}")
    private String systemFlag;//新农险标识（prptmian表中的systemflag,用于区分新农险系统与老系统的数据）
    @Autowired
    private InsureMainListApi insureMainListApi;

    @Autowired
    private PrpDuserApi prpDuserApi;

    /**
     *  根据主键查询PrpCMain保单基本信息表信息
     * @author: 田慧
     * @date: 2017/12/3 11:53
     * @param policyNo 保单号
     * @return
     */
    @Override
    public PrpCmainDto queryByPK(String policyNo) {
        PrpCmainKey prpCmainKey = new PrpCmainKey(policyNo);
        PrpCmain prpCmain = prpCmainDao.findOne(prpCmainKey);
        PrpCmainDto prpCmainDto = this.convert(prpCmain,PrpCmainDto.class);
        if (prpCmainDto!=null && !systemFlag.equals(prpCmainDto.getSystemFlag())){
            return null;
        }
        return prpCmainDto;
    }
    /**
     * * （根据保单号查看是否已经打印）
     * @author: 田慧
     * @date: 20:02
     * @param  prpCmainRequestDto 保单号集合
     * @return resultMap
     * @throws Exception
     */
    @Override
    public Map<String,String> queryPrintNo(PrpCmainRequestDto prpCmainRequestDto)throws Exception{
        List<String> policyNoList = prpCmainRequestDto.getPolicyNoList();
        if(policyNoList.size()==0){
            throw new DataVerifyException("保单号不能为空！");
        }
        StringBuilder stringBuilder = new StringBuilder();
        Map<String,String> resultMap = new HashMap<>();
        List<PrpCmain> prpCmainList = prpCmainDao.queryPrintNo(policyNoList);
        List<PrpCmainDto> prpCmainDtoList = new ArrayList<>();
        convertCollection(prpCmainList,prpCmainDtoList,PrpCmainDto.class);
        for (PrpCmainDto p:prpCmainDtoList) {
            if (StringUtils.isEmpty(p.getPrintNo())) {
                stringBuilder.append(p.getPolicyNo() + "  ");
            }
        }
        if(StringUtils.isNotEmpty(stringBuilder)){
            stringBuilder.append(" 未打印，请先进行打印！");
        }
        resultMap.put("message",stringBuilder.toString());
        return resultMap;

    }
    /**
     *  分页查询PrpCMainDto（保单基本信息表Dto）结果集
     * @author: 田慧
     * @date: 2017/11/21 10:47
     * @param prpCmainRequestDto prpCMainDto包括保单号、投保人姓名、保单起期、保单止期、页码、每页记录数
    riskCodeList 险种集合
    policyNoList 保单号集合
     * @return  返回pageInfo  分页查询主表信息（包含保单主表信息集合（PrpCMainDto）
    、当前页数、总记录数）
     * @throws Exception
     */
    @Override
    public PageInfo<PrpCmainDto> queryPolicyListInfo(PrpCmainRequestDto prpCmainRequestDto) throws Exception{
        int pageNo = prpCmainRequestDto.getPrpCmainDto().getPageNo();
        int pageSize = prpCmainRequestDto.getPrpCmainDto().getPageSize();
        PrpCmainDto prpCmainDto = prpCmainRequestDto.getPrpCmainDto();
        if (pageNo < 1) {
            throw new DataVerifyException("页码不能小于1");
        }
        if (pageSize < 1) {
            throw new DataVerifyException("每页数量不能小于1");
        }
        Map<String, Object> paraMap = new HashMap<String, Object>();
        StringBuilder countSql = new StringBuilder("select count(1) from PrpCmain pc  ");
        StringBuilder stringBuilder = new StringBuilder("select pc from PrpCmain pc ");
        String dataCondition;
        List<String> strWhere = new ArrayList<String>();
        //添加新老系统表示systemFlag为agri
        strWhere.add(" and pc.systemFlag = 'agri'");
        //若保单号不为空，则不拼接保单起期、保单止期信息
        if (StringUtils.isNotEmpty(prpCmainDto.getPolicyNo())) {
            strWhere.add(" and pc.policyNo like :policyNo");
            paraMap.put("policyNo", "%"+prpCmainDto.getPolicyNo()+"%");
        } else {
            if (prpCmainDto.getStartDate() != null&&prpCmainDto.getStartEndDate()!=null&&prpCmainDto.getEndDate() != null&&prpCmainDto.getEndEndDate()!=null) {
                strWhere.add(" and  pc.startDate >=:startDate");
                paraMap.put("startDate", prpCmainDto.getStartDate());
                strWhere.add(" and  pc.startDate <=:startEndDate");
                paraMap.put("startEndDate", prpCmainDto.getStartEndDate());
                strWhere.add(" and  pc.endDate >=:endDate");
                paraMap.put("endDate", prpCmainDto.getEndDate());
                strWhere.add(" and  pc.endDate <=:endEndDate");
                paraMap.put("endEndDate",prpCmainDto.getEndEndDate() );
            } else {
                //只输入起保日期的起期的情况下,查询起保日期大于该起保日期起期的所有保单
                if (prpCmainDto.getStartDate() != null) {
                    strWhere.add(" and  pc.startDate >=:startDate");
                    paraMap.put("startDate", prpCmainDto.getStartDate());
                }
                //只输入起保日期的止期的情况下,查询起保日期小于该起保日期止期的所有保单
                if (prpCmainDto.getStartEndDate() != null) {
                    strWhere.add(" and  pc.startDate <=:startEndDate");
                    paraMap.put("startEndDate", prpCmainDto.getStartEndDate());
                }
                //只输入终保日期的起期的情况下,查询终保日期大于该终保日期起期的所有保单
                if (prpCmainDto.getEndDate() != null) {
                    strWhere.add(" and  pc.endDate >=:endDate");
                    paraMap.put("endDate", prpCmainDto.getEndDate());
                }
                //只输入终保日期的止期的情况下,查询终保日期小于该终保日期止期的所有保单
                if (prpCmainDto.getEndEndDate() != null) {
                    strWhere.add(" and  pc.endDate <=:endEndDate");
                    paraMap.put("endEndDate", prpCmainDto.getEndEndDate());
                }
            }


        }
        if (StringUtils.isNotEmpty(prpCmainRequestDto.getIdentifyNumber())) {
            strWhere.add(" and exists(select 1 from PrpCinsured p where p.identifyNumber=:identifyNumber");
            paraMap.put("identifyNumber", prpCmainRequestDto.getIdentifyNumber());
            strWhere.add(" and p.policyNo = pc.policyNo ) ");
        }
        if (prpCmainRequestDto.getPolicyNoList() != null) {
            if (prpCmainRequestDto.getPolicyNoList().size() ==0){
                return new PageInfo<PrpCmainDto>() ;
            }
            strWhere.add(" and pc.policyNo in:policyNoList");
            paraMap.put("policyNoList", prpCmainRequestDto.getPolicyNoList());
        }
        //投保人姓名appliName
        if (StringUtils.isNotEmpty(prpCmainDto.getAppliName())) {
            strWhere.add(" AND pc.appliName =:appliName");
            paraMap.put("appliName", prpCmainDto.getAppliName());
        }
       // riskCodeList 险种集合
        if (StringUtils.isNotEmpty(prpCmainDto.getInsuredName())){
            strWhere.add(" AND pc.insuredName like :insuredName");
            String insuredName = prpCmainDto.getInsuredName()+"%";
            paraMap.put("insuredName",insuredName);
        }
        //riskCodeList 险种集合
        if (prpCmainRequestDto.getRiskCodeList() != null && prpCmainRequestDto.getRiskCodeList().size() > 0) {
            strWhere.add(" and pc.riskCode in :riskCodeList");
            paraMap.put("riskCodeList", prpCmainRequestDto.getRiskCodeList());
        }
             strWhere.add(" and pc.systemFlag = :systemFlag order by pc.policyNo desc");
             paraMap.put("systemFlag",systemFlag);
        if (strWhere.size() > 0) {
            dataCondition = this.joinCondition(strWhere);

            countSql.append(" where ");
            countSql.append(dataCondition);

            stringBuilder.append(" where ");
            stringBuilder.append(dataCondition);
        }
        Query dataResult = entityManager.createQuery(stringBuilder.toString());
        Query countResult = entityManager.createQuery(countSql.toString());
        this.setQueryParam(dataResult, pageNo, pageSize, paraMap);
        this.setQueryParam(countResult, paraMap);
        //查询总条数
        Long totalSize = (Long) countResult.getSingleResult();
        //查询结果
        List<PrpCmain> prpCmainList = dataResult.getResultList();
        List<PrpCmainDto> prpCmainDtoList = new ArrayList<PrpCmainDto>();
        this.convertCollection(prpCmainList, prpCmainDtoList, PrpCmainDto.class);
        List<PrpCmainDto> prpCmainDtoList1=new ArrayList<>();
        if (StringUtils.isNotEmpty(prpCmainRequestDto.getIdentifyNumber())){
            prpCmainDtoList1=prpCinsuredService.queryPolicyById(prpCmainRequestDto.getIdentifyNumber());
            List<PrpCmainDto> newPrpCmainDtoList = new ArrayList<>();
            // prpCmainDtoList.retainAll(prpCmainDtoList1);
            //循环身份证满足的保单号和自己查询满足的保单号 取两者的交集拼成满足的条件
            Long time1= System.currentTimeMillis();
            for (int i = 0;i<prpCmainDtoList1.size();i ++){
                String policyNo=prpCmainDtoList1.get(i).getPolicyNo();
                for (int j = 0; j<prpCmainDtoList.size();j++){
                    String policyNoOld=prpCmainDtoList.get(j).getPolicyNo();
                    if (policyNo.equals(policyNoOld)){
                        newPrpCmainDtoList.add(prpCmainDtoList.get(j));
                    }
                }
            }
            Long time2=System.currentTimeMillis();
            System.out.println("================="+(time2-time1));
            prpCmainDtoList = newPrpCmainDtoList;
        }
        PageInfo<PrpCmainDto> pageInfo = this.setPageInfo(prpCmainDtoList, pageNo, totalSize, PrpCmainDto.class);
        return pageInfo;
    }
    /**
     * P表记录转为C表记录
     * @author: 王保良
     * @date: 2017/11/18
     * @param prpPmainDto
     * @return PrpCmainDto
     * @throws Exception
     */
    @Override
    public PrpCmainDto PEvaluateC(PrpPmainDto prpPmainDto) throws Exception {
        PrpCmainDto prpCmainDto=new PrpCmainDto();
        prpCmainDto.setPolicyNo(prpPmainDto.getPolicyNo());
        prpCmainDto.setClassCode (prpPmainDto.getClassCode());
        prpCmainDto.setRiskCode (prpPmainDto.getRiskCode());
        prpCmainDto.setProposalNo (prpPmainDto.getProposalNo());
        prpCmainDto.setContractNo(prpPmainDto.getContractNo());
        prpCmainDto.setPolicySort(prpPmainDto.getPolicySort());
        prpCmainDto.setPolicyType(prpPmainDto.getPolicyType());
        //modified by zengzhu 2007-11-15 begin reason：统计用的保单农险标志需求，为保单添加一个保单业务类型字段 PolicyBizType
        prpCmainDto.setPolicyBizType(prpPmainDto.getPolicyBizType());
        //modified by zengzhu 2007-11-15 end
        prpCmainDto.setPrintNo(prpPmainDto.getPrintNo());
        prpCmainDto.setBusinessNature(prpPmainDto.getBusinessNature());
        prpCmainDto.setLanguage(prpPmainDto.getLanguage());
        prpCmainDto.setAppliCode(prpPmainDto.getAppliCode());
        prpCmainDto.setAppliName(prpPmainDto.getAppliName());
        prpCmainDto.setAppliAddress(prpPmainDto.getAppliAddress());
        prpCmainDto.setInsuredCode(prpPmainDto.getInsuredCode());
        prpCmainDto.setInsuredName(prpPmainDto.getInsuredName());
        prpCmainDto.setInsuredAddress(prpPmainDto.getInsuredAddress());
        prpCmainDto.setOperateDate(prpPmainDto.getOperateDate());
        prpCmainDto.setStartDate(prpPmainDto.getStartDate());
        prpCmainDto.setStartHour(prpPmainDto.getStartHour());
        prpCmainDto.setEndDate(prpPmainDto.getEndDate());
        prpCmainDto.setEndHour(prpPmainDto.getEndHour());
        prpCmainDto.setPureRate(prpPmainDto.getPureRate());
        prpCmainDto.setDisRate (prpPmainDto.getDisRate ());
        prpCmainDto.setDiscount (prpPmainDto.getDiscount());
        prpCmainDto.setCurrency (prpPmainDto.getCurrency());
        prpCmainDto.setSumValue (prpPmainDto.getSumValue());
        prpCmainDto.setSumAmount (prpPmainDto.getSumAmount());
        prpCmainDto.setSumDiscount (prpPmainDto.getSumDiscount());
        prpCmainDto.setSumPremium (prpPmainDto.getSumPremium());
        prpCmainDto.setSumSubPrem (prpPmainDto.getSumSubPrem());
        prpCmainDto.setSumQuantity (prpPmainDto.getSumQuantity());
        prpCmainDto.setJudicalScope (prpPmainDto.getJudicalScope());
        prpCmainDto.setAutoTransRenewFlag(prpPmainDto.getAutoTransRenewFlag());
        prpCmainDto.setArgueSolution(prpPmainDto.getArgueSolution());
        prpCmainDto.setArbitBoardName(prpPmainDto.getArbitBoardName());
        prpCmainDto.setPayTimes(prpPmainDto.getPayTimes());
        prpCmainDto.setEndorseTimes(prpPmainDto.getEndorseTimes());
        prpCmainDto.setClaimTimes(prpPmainDto.getClaimTimes());
        prpCmainDto.setMakeCom(prpPmainDto.getMakeCom());
        prpCmainDto.setOperateSite(prpPmainDto.getOperateSite());
        prpCmainDto.setComCode(prpPmainDto.getComCode());
        prpCmainDto.setHandlerCode(prpPmainDto.getHandlerCode());
        prpCmainDto.setHandler1Code(prpPmainDto.getHandler1Code());
        prpCmainDto.setApproverCode(prpPmainDto.getApproverCode());
        prpCmainDto.setUnderwriteCode(prpPmainDto.getUnderwriteCode());
        prpCmainDto.setUnderwriteName(prpPmainDto.getUnderwriteName());
        prpCmainDto.setOperatorCode(prpPmainDto.getOperatorCode());
        prpCmainDto.setInputDate(prpPmainDto.getInputDate());
        prpCmainDto.setInputHour(prpPmainDto.getInputHour());
        prpCmainDto.setUnderwriteEndDate(prpPmainDto.getUnderwriteEndDate());
        prpCmainDto.setStatisticSym(prpPmainDto.getStatisticSym());
        prpCmainDto.setAgentCode(prpPmainDto.getAgentCode());
        prpCmainDto.setCoinsFlag(prpPmainDto.getCoinsFlag());
        prpCmainDto.setReinsFlag(prpPmainDto.getReinsFlag());
        prpCmainDto.setAllinsFlag(prpPmainDto.getAllinsFlag());
        prpCmainDto.setUnderwriteFlag(prpPmainDto.getUnderwriteFlag());
        prpCmainDto.setOthFlag(prpPmainDto.getOthFlag());
        prpCmainDto.setFlag(prpPmainDto.getFlag());
        prpCmainDto.setDisRate1(prpPmainDto.getDisRate1());
        prpCmainDto.setBusinessFlag(prpPmainDto.getBusinessFlag());
        prpCmainDto.setPayMode(prpPmainDto.getPayMode());
        prpCmainDto.setUpdaterCode(prpPmainDto.getUpdaterCode());
        prpCmainDto.setUpdateDate(prpPmainDto.getUpdateDate());
        prpCmainDto.setUpdateHour(prpPmainDto.getUpdateHour());
        prpCmainDto.setSignDate(prpPmainDto.getSignDate());
        prpCmainDto.setShareholderFlag(prpPmainDto.getShareHolderFlag());
        prpCmainDto.setAgreementNo(prpPmainDto.getAgreementNo());
        prpCmainDto.setInquiryNo(prpPmainDto.getInquiryNo());
        prpCmainDto.setRemark(prpPmainDto.getRemark());
        prpCmainDto.setVersionNo(prpPmainDto.getVersionNo());
        //ADD BY CHENKAI REASON:保单补录需求 begin
        prpCmainDto.setManualType(prpPmainDto.getManualType());
        prpCmainDto.setVisaCode(prpPmainDto.getVisaCode());
        /**
         * 国元项目组 fenglei
         * 农险新统计制度增加字段BusinessType;BusinessType1;UnitCode;StatQuantity;StatUnitCode;SumInsured;
         * 2007-12-25
         */
        prpCmainDto.setBusinessType(prpPmainDto.getBusinessType());
        prpCmainDto.setBusinessType1(prpPmainDto.getBusinessType1());
        prpCmainDto.setUnitCode(prpPmainDto.getUnitCode());
        prpCmainDto.setStatQuantity(prpPmainDto.getStatQuantity());
        prpCmainDto.setStatUnitCode(prpPmainDto.getStatUnitCode());
        prpCmainDto.setSumInsured(prpPmainDto.getSumInsured());
        prpCmainDto.setSumInsured(prpPmainDto.getSumInsured());
        //ADD BY CHENKAI REASON:保单补录需求 end
        //健康险统计
        prpCmainDto.setArticleType(prpPmainDto.getArticleType());

        prpCmainDto.setBusinessProvince(prpPmainDto.getBusinessProvince());
        prpCmainDto.setBusinessTown(prpPmainDto.getBusinessTown());
        prpCmainDto.setBusinessCounty(prpPmainDto.getBusinessCounty());
        prpCmainDto.setBusinessCity(prpPmainDto.getBusinessCity());
        prpCmainDto.setBusinessAreaName(prpPmainDto.getBusinessAreaName());
        prpCmainDto.setAllianceRate(prpPmainDto.getAllianceRate()); //联办比例
        prpCmainDto.setBusinessArea(prpPmainDto.getBusinessArea());

        prpCmainDto.setPrintDate(prpPmainDto.getPrintDate());
        prpCmainDto.setPayDate(prpPmainDto.getPayDate());
        prpCmainDto.setStartMinute(prpPmainDto.getStartMinute());
        prpCmainDto.setEndMinute(prpPmainDto.getEndMinute());
        // prpCmainDto.setUndwrtUsercode(prpPmainDto.getUndwrtUsercode());
        prpCmainDto.setLimitAmount(prpPmainDto.getLimitAmount());
        prpCmainDto.setAgentRemark(prpPmainDto.getAgentRemark());
        prpCmainDto.setThirdKnow(prpPmainDto.getThirdKnow());
        prpCmainDto.setnCarPerpFlag(prpPmainDto.getNCarPerpFlag());
        prpCmainDto.setGroupNo(prpPmainDto.getGroupNo());
        prpCmainDto.setGroupFlag(prpPmainDto.getGroupFlag());
        prpCmainDto.setBasePerformanceRate(prpPmainDto.getBasePerformanceRate());
        prpCmainDto.setEncouragePerformanceRate(prpPmainDto.getEncouragePerformanceRate());
        prpCmainDto.setSumRate(prpPmainDto.getSumRate());
        prpCmainDto.setStandardRate(prpPmainDto.getStandardRate());
        prpCmainDto.setAgriFlag(prpPmainDto.getAgriFlag());

        //大病医疗
        prpCmainDto.setBigMedicalType(prpPmainDto.getBigMedicalType());
        prpCmainDto.setEarningsRate(prpPmainDto.getEarningsRate());
        prpCmainDto.setInsuredListType(prpPmainDto.getInsuredListType());

        prpCmainDto.setCoinsPremiumType(prpPmainDto.getCoinsPremiumType()) ;
        prpCmainDto.setEccFlag(prpPmainDto.getEccFlag()) ;
        prpCmainDto.setSsProposalNo(prpPmainDto.getSsProposalNo()); ;
        //zf1100000004
        prpCmainDto.setBusinessYear(prpPmainDto.getBusinessYear()) ;
        prpCmainDto.setMakeArea(prpPmainDto.getMakeArea()) ;
        prpCmainDto.setTopCommisionRate(prpPmainDto.getTopCommisionRate());
        prpCmainDto.setIntCommisionRate(prpPmainDto.getIntCommisionRate());
        prpCmainDto.setSumNoTaxPremium(prpPmainDto.getSumNoTaxPremium());
        prpCmainDto.setSumTaxFee(prpPmainDto.getSumTaxFee());
        prpCmainDto.setNotificationFlag(prpPmainDto.getNotificationFlag());
        prpCmainDto.setInceptionFlag(prpPmainDto.getInceptionFlag());
        return prpCmainDto;
    }

    /**
     * P表记录转为C表记录
     * @author: 王保良
     * @date: 2017/11/18
     * @param prpCPmainDto
     * @return PrpCmainDto
     * @throws Exception
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public PrpCmainDto generatePrpCmain(PrpCPmainDto prpCPmainDto) throws Exception {
        PrpCmainDto prpCmainDto=new PrpCmainDto();
        prpCmainDto.setPolicyNo(prpCPmainDto.getPolicyNo());
        prpCmainDto.setClassCode(prpCPmainDto.getClassCode());
        prpCmainDto.setRiskCode(prpCPmainDto.getRiskCode());
        prpCmainDto.setProposalNo(prpCPmainDto.getProposalNo());
        prpCmainDto.setContractNo(prpCPmainDto.getContractNo());
        prpCmainDto.setPolicySort(prpCPmainDto.getPolicySort());
        prpCmainDto.setPrintNo(prpCPmainDto.getPrintNo());
        prpCmainDto.setBusinessNature(prpCPmainDto.getBusinessNature());
        prpCmainDto.setLanguage(prpCPmainDto.getLanguage());
        prpCmainDto.setPolicyType(prpCPmainDto.getPolicyType());
        //modified by zengzhu 2007-11-15 begin reason：统计用的保单农险标志需求，为保单添加一个保单业务类型字段 PolicyBizType
        prpCmainDto.setPolicyBizType(prpCPmainDto.getPolicyBizType());
        //modified by zengzhu 2007-11-15 end
        prpCmainDto.setAppliCode(prpCPmainDto.getAppliCode());
        prpCmainDto.setAppliName(prpCPmainDto.getAppliName());
        prpCmainDto.setAppliAddress(prpCPmainDto.getAppliAddress());
        prpCmainDto.setInsuredCode(prpCPmainDto.getInsuredCode());
        prpCmainDto.setInsuredName(prpCPmainDto.getInsuredName());
        prpCmainDto.setInsuredAddress(prpCPmainDto.getInsuredAddress());
        prpCmainDto.setOperateDate(prpCPmainDto.getOperateDate());
        prpCmainDto.setStartDate(prpCPmainDto.getStartDate());
        prpCmainDto.setStartHour(prpCPmainDto.getStartHour());
        prpCmainDto.setEndDate(prpCPmainDto.getEndDate());
        prpCmainDto.setEndHour(prpCPmainDto.getEndHour());
        prpCmainDto.setPureRate(prpCPmainDto.getPureRate());
        prpCmainDto.setDisRate(prpCPmainDto.getDisRate());
        prpCmainDto.setDiscount(prpCPmainDto.getDiscount());
        prpCmainDto.setCurrency(prpCPmainDto.getCurrency());
        prpCmainDto.setSumValue(prpCPmainDto.getSumValue());
        prpCmainDto.setSumAmount(prpCPmainDto.getSumAmount());
        prpCmainDto.setSumDiscount(prpCPmainDto.getSumDiscount());
        prpCmainDto.setSumPremium(prpCPmainDto.getSumPremium());
        prpCmainDto.setSumSubPrem(prpCPmainDto.getSumSubPrem());
        prpCmainDto.setSumQuantity(prpCPmainDto.getSumQuantity());
        prpCmainDto.setJudicalCode(prpCPmainDto.getJudicalCode());
        prpCmainDto.setJudicalScope(prpCPmainDto.getJudicalScope());
        prpCmainDto.setAutoTransRenewFlag(prpCPmainDto.getAutoTransRenewFlag());
        prpCmainDto.setArgueSolution(prpCPmainDto.getArgueSolution());
        prpCmainDto.setArbitBoardName(prpCPmainDto.getArbitBoardName());
        prpCmainDto.setPayTimes(prpCPmainDto.getPayTimes());
        prpCmainDto.setEndorseTimes(prpCPmainDto.getEndorseTimes());
        prpCmainDto.setClaimTimes(prpCPmainDto.getClaimTimes());
        prpCmainDto.setMakeCom(prpCPmainDto.getMakeCom());
        prpCmainDto.setOperateSite(prpCPmainDto.getOperateSite());
        prpCmainDto.setComCode(prpCPmainDto.getComCode());
        prpCmainDto.setHandlerCode(prpCPmainDto.getHandlerCode());
        prpCmainDto.setHandler1Code(prpCPmainDto.getHandler1Code());
        prpCmainDto.setApproverCode(prpCPmainDto.getApproverCode());
        prpCmainDto.setUnderwriteCode(prpCPmainDto.getUnderwriteCode());
        prpCmainDto.setUnderwriteName(prpCPmainDto.getUnderwriteName());
        prpCmainDto.setOperatorCode(prpCPmainDto.getOperatorCode());
        prpCmainDto.setInputDate(prpCPmainDto.getInputDate());
        prpCmainDto.setInputHour(prpCPmainDto.getInputHour());
        prpCmainDto.setUnderwriteEndDate(prpCPmainDto.getUnderwriteEndDate());
        prpCmainDto.setStatisticSym(prpCPmainDto.getStatisticSym());
        prpCmainDto.setAgentCode(prpCPmainDto.getAgentCode());
        prpCmainDto.setCoinsFlag(prpCPmainDto.getCoinsFlag());
        prpCmainDto.setReinsFlag(prpCPmainDto.getReinsFlag());
        prpCmainDto.setAllinsFlag(prpCPmainDto.getAllinsFlag());
        prpCmainDto.setUnderwriteFlag(prpCPmainDto.getUnderwriteFlag());
        prpCmainDto.setOthFlag(prpCPmainDto.getOthFlag());
        prpCmainDto.setFlag(prpCPmainDto.getFlag());
        prpCmainDto.setDisRate1(prpCPmainDto.getDisRate1());
        prpCmainDto.setBusinessFlag(prpCPmainDto.getBusinessFlag());
        prpCmainDto.setUpdaterCode(prpCPmainDto.getUpdaterCode());
        prpCmainDto.setUpdateDate(prpCPmainDto.getUpdateDate());
        prpCmainDto.setUpdateHour(prpCPmainDto.getUpdateHour());
        prpCmainDto.setSignDate(prpCPmainDto.getSignDate());
        prpCmainDto.setShareholderFlag(prpCPmainDto.getShareholderFlag());
        prpCmainDto.setAgreementNo(prpCPmainDto.getAgreementNo());
        prpCmainDto.setInquiryNo(prpCPmainDto.getInquiryNo());
        prpCmainDto.setRemark(prpCPmainDto.getRemark());
        prpCmainDto.setPayMode(prpCPmainDto.getPayMode());
        prpCmainDto.setVisaCode(prpCPmainDto.getVisaCode());
        prpCmainDto.setClassCodeName(prpCPmainDto.getClassCodeName());
        /**
         * 国元项目组 fenglei
         * 农险新统计制度增加字段BusinessType;BusinessType1;UnitCode;StatQuantity;StatUnitCode;SumInsured;
         * 2007-12-25
         */
        prpCmainDto.setBusinessType(prpCPmainDto.getBusinessType());
        prpCmainDto.setBusinessType1(prpCPmainDto.getBusinessType1());
        prpCmainDto.setUnitCode(prpCPmainDto.getUnitCode());
        prpCmainDto.setStatQuantity(prpCPmainDto.getStatQuantity());
        prpCmainDto.setStatUnitCode(prpCPmainDto.getStatUnitCode());
        prpCmainDto.setSumInsured(prpCPmainDto.getSumInsured());
        //add by wuzheng 20080601 健康险统计制度增加字段记录专项信息
        prpCmainDto.setArticleType(prpCPmainDto.getArticleType());

        prpCmainDto.setBusinessProvince(prpCPmainDto.getBusinessProvince());
        prpCmainDto.setBusinessTown(prpCPmainDto.getBusinessTown());
        prpCmainDto.setBusinessCounty(prpCPmainDto.getBusinessCounty());
        prpCmainDto.setBusinessAreaName(prpCPmainDto.getBusinessAreaName());
        prpCmainDto.setStartMinute(prpCPmainDto.getStartMinute());
        prpCmainDto.setEndMinute(prpCPmainDto.getEndMinute());
        prpCmainDto.setThirdKnow(prpCPmainDto.getThirdKnow());
        prpCmainDto.setnCarPerpFlag(prpCPmainDto.getnCarPerpFlag());
        prpCmainDto.setAgentRemark(prpCPmainDto.getAgentRemark());
        prpCmainDto.setLimitAmount(prpCPmainDto.getLimitAmount());
        //区域和大户代码
        prpCmainDto.setRichflyAreasCode(prpCPmainDto.getRichflyAreasCode());
        prpCmainDto.setRichflyAreasCName(prpCPmainDto.getRichflyAreasCName());
        prpCmainDto.setRichflyCode(prpCPmainDto.getRichflyCode());
        prpCmainDto.setRichflyCName(prpCPmainDto.getRichflyCName());
        prpCmainDto.setGroupNo(prpCPmainDto.getGroupNo());
        prpCmainDto.setGroupFlag(prpCPmainDto.getGroupFlag());
        prpCmainDto.setBasePerformanceRate(prpCPmainDto.getBasePerformanceRate());
        prpCmainDto.setEncouragePerformanceRate(prpCPmainDto.getEncouragePerformanceRate());
        prpCmainDto.setSumRate(prpCPmainDto.getSumRate());
        prpCmainDto.setStandardRate(prpCPmainDto.getStandardRate());
        prpCmainDto.setAgriFlag(prpCPmainDto.getAgriFlag());
        //prpCmainDto.setValidCountDate(prpCPmainDto.getValidCountDate());
        //prpCmainDto.setIsSeeFeeFlag(prpCPmainDto.getIsSeeFeeFlag());
        prpCmainDto.setVersionNo(prpCPmainDto.getVersionNo());

        prpCmainDto.setBigMedicalType(prpCPmainDto.getBigMedicalType());
        prpCmainDto.setEarningsRate(prpCPmainDto.getEarningsRate());
        prpCmainDto.setCoinsPremiumType(prpCPmainDto.getCoinsPremiumType());
        prpCmainDto.setBusinessCity(prpCPmainDto.getBusinessCity());
        prpCmainDto.setAllianceRate(prpCPmainDto.getAllianceRate());
        prpCmainDto.setBusinessArea(prpCPmainDto.getBusinessArea());

        prpCmainDto.setEccFlag(prpCPmainDto.getEccFlag()) ;
        prpCmainDto.setSsProposalNo(prpCPmainDto.getSsProposalNo()); ;
        //zf1100000002
        prpCmainDto.setBusinessYear(prpCPmainDto.getBusinessYear()) ;
        prpCmainDto.setMakeArea(prpCPmainDto.getMakeArea()) ;
        prpCmainDto.setTopCommisionRate(prpCPmainDto.getTopCommisionRate());
        prpCmainDto.setIntCommisionRate(prpCPmainDto.getIntCommisionRate());
        prpCmainDto.setSumNoTaxPremium(prpCPmainDto.getSumNoTaxPremium());
        prpCmainDto.setSumTaxFee(prpCPmainDto.getSumTaxFee());
        prpCmainDto.setNotificationFlag(prpCPmainDto.getNotificationFlag());
        prpCmainDto.setInceptionFlag(prpCPmainDto.getInceptionFlag());
        prpCmainDto.setBusinessProvinceName(prpCPmainDto.getBusinessProvinceName());
        prpCmainDto.setBusinessTownName(prpCPmainDto.getBusinessTownName());
        prpCmainDto.setBusinessCountyName(prpCPmainDto.getBusinessCountyName());
        prpCmainDto.setBusinessCityName(prpCPmainDto.getBusinessCityName());
        prpCmainDto.setBusinessAreaName(prpCPmainDto.getBusinessAreaName());
        prpCmainDto.setComName(prpCPmainDto.getComName());
        prpCmainDto.settHandlerName(prpCPmainDto.gettHandlerName());
        prpCmainDto.settHandler1Name(prpCPmainDto.gettHandler1Name());
        prpCmainDto.setUpdaterName(prpCPmainDto.getUpdaterName());
        prpCmainDto.setOperatorName(prpCPmainDto.getOperatorName());
        prpCmainDto.setRiskCodeName(prpCPmainDto.getRiskCodeName());
        return prpCmainDto;
    }

    /**
     *  根据policyNo保单号、riskCode险种代码检查保单号是否存在
     * @author: 田慧
     * @date: 2017/12/1 14:38
     * @param policyNo 保单号
     * @param riskCode 险种代码
     * @return prpCmainDto 保单基本信息表信息
     * @throws Exception
     */
    @Override
    public List<PrpCmainDto> checkPolicyNo(String policyNo,String riskCode)throws Exception{
        List<PrpCmain> prpCmainList = prpCmainDao.queryPrpCMain(policyNo,riskCode);
        for (int i=0;i<prpCmainList.size();i++){
            if (!systemFlag.equals(prpCmainList.get(i).getSystemFlag())){
                prpCmainList.remove(i);
            }
        }
        List<PrpCmainDto> prpCmainDtoList = new ArrayList<PrpCmainDto>();
        convertCollection(prpCmainList,prpCmainDtoList,PrpCmainDto.class);
        return prpCmainDtoList;
    }

    /* *  根据保单号检验是否存在
    * @author: 钱浩
    * @date: 2017/12/1 14:38
           * @param map 包括保单号
    * @return Integer 条数
    * @throws Exception
    */
    public Integer queryPolicyNo(String policyNo) throws Exception {
        if (StringUtils.isEmpty(policyNo)) {
            throw new DataVerifyException("保单号不能为空");
        }
        Integer count = prpCmainDao.queryPrpcMainCount(policyNo);
        return count;
    }

    @Override
    public List<PrpCmainDto> queryByOldPolicyNo(String oldPolicyNo) throws Exception {
        List<PrpCmain> prpCmainList=prpCmainDao.findByOldPolicyNo(oldPolicyNo);
        List<PrpCmainDto> prpCmainDtoList=new ArrayList<>();
        convertCollection(prpCmainList,prpCmainDtoList,PrpCmainDto.class);
        return prpCmainDtoList;
    }

    @Override
    public void updatePrpCmain(List<PrpCmainDto> prpCmainDtoList) throws Exception {
        List<PrpCmain> prpCmainList=new ArrayList<>();
        convertCollection(prpCmainDtoList,prpCmainList,PrpCmain.class);
        prpCmainDao.save(prpCmainList);
    }

    /**
     * 根据保单号回写PrpCmain表的理赔次数claimTimes字段
     * @author: 宋振振
     * @date: 2017/12/15 9:58
     * @param policyNo 保单号
     * @throws Exception
     */
    public void modifyPrpCmainAddClaimTimes(String policyNo)throws Exception{
        if(StringUtils.isEmpty(policyNo)){
            throw new DataVerifyException("保单号不能为空!");
        }
        prpCmainDao.modifyPrpCmainAddClaimTimes(policyNo);
    }

    /**
     * 批量查询保单信息
     *
     * @param policyNos 多个保单号
     * @return List<PrpCmainDto>
     * @date: 2018/4/12 10:48
     * @author: 何伟东
     */
    @Override
    public List<PrpCmainDto> queryPolicyInfoByPolicyNos(List<String> policyNos) throws Exception {
        if (policyNos == null || policyNos.size() < 1) {
            throw new DataVerifyException("保单号不能为空！");
        }
        List<PrpCmain> prpCmains = prpCmainDao.queryPolicyInfoByPolicyNos(systemFlag, policyNos);
        List<PrpCmainDto> prpCmainDtos = new ArrayList<>();
        if (prpCmains != null || prpCmains.size() > 0) {
            convertCollection(prpCmains, prpCmainDtos, PrpCmainDto.class);
        }
        return prpCmainDtos;
    }

    /**
     * 关联清单查询重复性保单数据
     * @author: 刘曼曼
     * @date: 16:32 16:32
     * @param requestPrpCmainInfoDto 清单号，页码，条数
     * @return PageInfo<ResponsePrpDclauseCodeDto> 保单数据集合
     * @throws Exception
     */
    @Override
    public PageInfo<ResponsePrpCmainInfoDto> queryPrpCmainInfo(RequestPrpCmainInfoDto requestPrpCmainInfoDto) throws Exception{
        if(requestPrpCmainInfoDto == null){
            throw new DataVerifyException("请求参数不可为空！");
        }
        if(StringUtils.isEmpty(requestPrpCmainInfoDto.getGisInsureListCode())){
            throw new DataVerifyException("金禾清单编号不能为空！");
        }

        Map<String,String> map = new HashMap<>();
        map.put("gisInsureListCode",requestPrpCmainInfoDto.getGisInsureListCode());

        //查询保单号
        List<String> policyNos=insureMainListApi.queryByGisInsureListCode(map);

        PageInfo<ResponsePrpCmainInfoDto> pageInfo=new PageInfo<ResponsePrpCmainInfoDto>();
                
        //原生SQL
        StringBuilder dataSql=new StringBuilder("select distinct c.* from PrpCmain c left join PrpPhead p on c.policyNo=p.policyNo " +
                "where c.policyNo in (:policyNos) and c.underwriteFlag in('1','3') and " +
                "(p.endorType is null or (p.underwriteflag in ('1', '3') and TRUNC(sysdate) >= TRUNC(c.startDate) and TRUNC(sysdate)<=c.endDate))");

        StringBuilder countSql=new StringBuilder("select count(1) from ( select distinct c.* from  PrpCmain c left join PrpPhead p on c.policyNo=p.policyNo " +
                "where c.policyNo in (:policyNos) and c.underwriteFlag in ('1','3') and " +
                "(p.endorType is null or (p.underwriteflag in ('1', '3') and TRUNC(sysdate) >= TRUNC(c.startDate) and TRUNC(sysdate)<=c.endDate)))");

        //设置参数
        Map<String,Object> paraMap = new HashMap<>();
        if(policyNos != null && policyNos.size()>0){
            paraMap.put("policyNos",policyNos);
        }else{
            return pageInfo;
        }


        //执行sql
        Query dataQuery= entityManager.createNativeQuery(dataSql.toString(),PrpCmain.class);
        Query countQuery = entityManager.createNativeQuery(countSql.toString());
        this.setQueryParam(dataQuery,requestPrpCmainInfoDto.getPageNo(),requestPrpCmainInfoDto.getPageSize(),paraMap);
        this.setQueryParam(countQuery,paraMap);

        //查询总条数
        Long totalSize = Long.valueOf(countQuery.getSingleResult().toString());
        //查询结果
        List<PrpCmain> prpCmainList = dataQuery.getResultList();
        List<ResponsePrpCmainInfoDto> responsePrpCmainInfoDtoList=new ArrayList<ResponsePrpCmainInfoDto>();

        //获取所需数据
        if(prpCmainList.size()>0){
            //获取操作员代码
            List<String> operatorCodes=new ArrayList<String>();
            for(PrpCmain prpCmain : prpCmainList){
                if(StringUtils.isNotEmpty(prpCmain.getOperatorCode())){
                    operatorCodes.add(prpCmain.getOperatorCode());
                }
            }
            //获得操作员名称
            List<PrpDuserDto> prpDuserDtoList=new ArrayList<PrpDuserDto>();
            if(operatorCodes.size()>0){
                prpDuserDtoList=prpDuserApi.getOperatorCode(operatorCodes);
            }

                for(PrpCmain prpCmain : prpCmainList) {
                    ResponsePrpCmainInfoDto responsePrpCmainInfoDto = new ResponsePrpCmainInfoDto();
                    //如果名称有值
                    if(prpDuserDtoList.size()>0){
                        for (PrpDuserDto prpDuserDto : prpDuserDtoList) {
                            if (StringUtils.isNotEmpty(prpCmain.getOperatorCode()) && prpCmain.getOperatorCode().equals(prpDuserDto.getUserCode())) {
                                responsePrpCmainInfoDto.setOperatorName(prpDuserDto.getUserName());
                            }
                        }
                        responsePrpCmainInfoDto.setPolicyNo(prpCmain.getPolicyNo());
                        responsePrpCmainInfoDto.setAppliCode(prpCmain.getAppliCode());
                        responsePrpCmainInfoDto.setAppliName(prpCmain.getAppliName());
                        responsePrpCmainInfoDto.setOperatorCode(prpCmain.getOperatorCode());
                        responsePrpCmainInfoDto.setStartDate(prpCmain.getStartDate());
                        responsePrpCmainInfoDto.setEndDate(prpCmain.getEndDate());
                        responsePrpCmainInfoDtoList.add(responsePrpCmainInfoDto);
                    }
                }
            }

        //统一封装
        pageInfo=this.setPageInfo(responsePrpCmainInfoDtoList,requestPrpCmainInfoDto.getPageNo(),totalSize,ResponsePrpCmainInfoDto.class);

        return pageInfo;
    }

    /**
     * 关联清单查询当前投保单是否同时存在
     * @author: 汪强
     * @date: 16:32 16:32
     * @param requestPrpCmainInfoDto 清单号，页码，条数
     * @return PageInfo<ResponsePrpDclauseCodeDto> 保单数据集合
     * @throws Exception
     */
    @Override
    public PageInfo<ResponsePrpCmainInfoDto> queryByPrpNoPrpCmainInfo(RequestPrpCmainInfoDto requestPrpCmainInfoDto) throws Exception{
        if(requestPrpCmainInfoDto == null){
            throw new DataVerifyException("请求参数不可为空！");
        }
        if(StringUtils.isEmpty(requestPrpCmainInfoDto.getGisInsureListCode())){
            throw new DataVerifyException("金禾清单编号不能为空！");
        }

        Map<String,String> map = new HashMap<>();
        map.put("gisInsureListCode",requestPrpCmainInfoDto.getGisInsureListCode());

        //查询保单号
        List<String> policyNoS=insureMainListApi.queryByGisInsureListCode(map);
        return getResponsePrpCmainInfoDtoPageInfo(requestPrpCmainInfoDto, policyNoS);
    }

    /**
     * 关联清单查询当前投保单是否同时存在
     * @author: 汪强
     * @date: 16:32 16:32
     * @param requestPrpCmainInfoDto 清单号，页码，条数
     * @return PageInfo<ResponsePrpDclauseCodeDto> 保单数据集合
     * @throws Exception
     */
    @Override
    public PageInfo<ResponsePrpCmainInfoDto> queryByPrpNoPrpCmainInfoList(RequestPrpCmainInfoDto requestPrpCmainInfoDto) throws Exception{
        PageInfo<ResponsePrpCmainInfoDto> pageInfo=new PageInfo<ResponsePrpCmainInfoDto>();
        if(requestPrpCmainInfoDto == null){
            throw new DataVerifyException("请求参数不可为空！");
        }
        if(requestPrpCmainInfoDto.getProposalNos()==null && requestPrpCmainInfoDto.getProposalNos().size()==0){
            throw new DataVerifyException("金禾清单编号不能为空！");
        }

        Map<String,List<String>> map = new HashMap<>();
        map.put("proposalNos",requestPrpCmainInfoDto.getProposalNos());
        //根据投保单号查询清单主表信息
        List<InsureMainListDto> insureMainListDtos=insureMainListApi.findAllByProposalNos(map);

        return PrpCmainInfo(requestPrpCmainInfoDto,insureMainListDtos);
    }

    /**
     * 公共方法
     * @param requestPrpCmainInfoDto
     * @param insureMainListDtos
     * @return
     * @throws Exception
     */
    private PageInfo<ResponsePrpCmainInfoDto> PrpCmainInfo(RequestPrpCmainInfoDto requestPrpCmainInfoDto,List<InsureMainListDto>  insureMainListDtos)throws Exception{


        List<String> policyNoS=new ArrayList<>();
        for(InsureMainListDto dto:insureMainListDtos){
            policyNoS.add(dto.getPolicyNo());
        }
        return getResponsePrpCmainInfoDtoPageInfo(requestPrpCmainInfoDto, policyNoS);
    }

    /**
     * 将公共查询的方法抽取出来
     * @author: 田健
     * @date: 2018/4/26 22:03
     * @param requestPrpCmainInfoDto 条件信息：险种、政策性、起始时间、终保时间、页码、显示数量
     * @param policyNoS 保单集合
     * @return 可疑单号集合
     * @throws Exception
     */
    private PageInfo<ResponsePrpCmainInfoDto> getResponsePrpCmainInfoDtoPageInfo(RequestPrpCmainInfoDto requestPrpCmainInfoDto, List<String> policyNoS) throws Exception {
        PageInfo<ResponsePrpCmainInfoDto> pageInfo=new PageInfo<ResponsePrpCmainInfoDto>();
        String policyNoCodition=parseListCondition(" c.policyNo",policyNoS);
        if(policyNoCodition==null){
            policyNoCodition="";
        }else{
            policyNoCodition=" and "+policyNoCodition;
        }

        StringBuilder dataSql=new StringBuilder("select distinct c.*");
        dataSql.append("from prpcmain c");
        dataSql.append(" left join PrpPhead p");
        dataSql.append(" on c.policyNo = p.policyNo");
        dataSql.append(" where c.underwriteFlag in ('1','3')");
        dataSql.append(" and to_char(c.enddate, 'YYYY-MM-dd') >= to_char(sysdate, 'YYYY-MM-dd')");
        dataSql.append(" and (p.endorType is null or (p.endorType not in ('19', '21') and");
        dataSql.append(" (to_char(c.startdate, 'YYYY-MM-dd') between :startDate and");
        dataSql.append(" :endDate or to_char(c.endDate, 'YYYY-MM-dd') between");
        dataSql.append(" :startDate and :endDate or");
        dataSql.append(" to_date(:startDate, 'YYYY-MM-dd') between c.startdate and");
        dataSql.append(" c.endDate)))");
        dataSql.append(policyNoCodition);
        dataSql.append(" and c.riskCode = :riskcode");
        dataSql.append(" and c.BusinessType1 = :businessType1");
//        dataSql.append(" ((p.endorType in ('19', '21') and");
//        dataSql.append(" (to_char(p.validdate, 'YYYY-MM-dd') between :startDate and");
//        dataSql.append(" to_char(c.EndDate, 'YYYY-MM-dd') or");
//        dataSql.append(" to_char(p.validdate, 'YYYY-MM-dd') between");
//        dataSql.append(" to_char(c.startdate, 'YYYY-MM-dd') and :endDate))))");

        StringBuilder countSql=new StringBuilder("select count(1) from (");
        countSql.append("select distinct c.*");
        countSql.append("from prpcmain c");
        countSql.append(" left join PrpPhead p");
        countSql.append(" on c.policyNo = p.policyNo");
        countSql.append(" where c.underwriteFlag in ('1','3')");
        countSql.append(" and to_char(c.enddate, 'YYYY-MM-dd') >= to_char(sysdate, 'YYYY-MM-dd')");
        countSql.append(" and (p.endorType is null or (p.underwriteflag in ('1', '3') and");
        countSql.append(" (to_char(c.startdate, 'YYYY-MM-dd') between :startDate and");
        countSql.append(" :endDate or to_char(c.endDate, 'YYYY-MM-dd') between");
        countSql.append(" :startDate and :endDate or");
        countSql.append(" to_date(:startDate, 'YYYY-MM-dd') between c.startdate and");
        countSql.append(" c.endDate)))");
        countSql.append(policyNoCodition);
        countSql.append(" and c.riskCode = :riskcode");
        countSql.append(" and c.BusinessType1 = :businessType1");
//        countSql.append(" ((p.endorType in ('19', '21') and");
//        countSql.append(" (to_char(p.validdate, 'YYYY-MM-dd') between :startDate and");
//        countSql.append(" to_char(c.EndDate, 'YYYY-MM-dd') or");
//        countSql.append(" to_char(p.validdate, 'YYYY-MM-dd') between");
//        countSql.append(" to_char(c.startdate, 'YYYY-MM-dd') and :endDate))))");
        countSql.append(")");


        //设置参数
        Map<String,Object> paraMap = new HashMap<>();
        if(policyNoS != null && policyNoS.size()>0){
            paraMap.put("riskcode",requestPrpCmainInfoDto.getRiskCode());
            paraMap.put("businessType1",requestPrpCmainInfoDto.getBusinessType1());
            paraMap.put("startDate",requestPrpCmainInfoDto.getStartDate());
            paraMap.put("endDate",requestPrpCmainInfoDto.getEndDate());
        }else{
            return pageInfo;
        }

        //执行sql
        Query dataQuery= entityManager.createNativeQuery(dataSql.toString(),PrpCmain.class);
        Query countQuery = entityManager.createNativeQuery(countSql.toString());
        this.setQueryParam(dataQuery,requestPrpCmainInfoDto.getPageNo(),requestPrpCmainInfoDto.getPageSize(),paraMap);
        this.setQueryParam(countQuery,paraMap);

        //查询总条数
        Long totalSize = Long.valueOf(countQuery.getSingleResult().toString());
        //查询结果
        List<PrpCmain> prpCmainList = dataQuery.getResultList();
        List<ResponsePrpCmainInfoDto> responsePrpCmainInfoDtoList=new ArrayList<ResponsePrpCmainInfoDto>();


        //获取所需数据
        if(prpCmainList.size()>0){
            //获取操作员代码
            List<String> operatorCodes=new ArrayList<String>();
            for(PrpCmain prpCmain : prpCmainList){
                if(StringUtils.isNotEmpty(prpCmain.getOperatorCode())){
                    operatorCodes.add(prpCmain.getOperatorCode());
                }
            }
            //获得操作员名称
            List<PrpDuserDto> prpDuserDtoList=new ArrayList<PrpDuserDto>();
            if(operatorCodes.size()>0){
                prpDuserDtoList=prpDuserApi.getOperatorCode(operatorCodes);
            }

            for(PrpCmain prpCmain : prpCmainList) {
                ResponsePrpCmainInfoDto responsePrpCmainInfoDto = new ResponsePrpCmainInfoDto();
                //如果名称有值
                if(prpDuserDtoList.size()>0){
                    for (PrpDuserDto prpDuserDto : prpDuserDtoList) {
                        if (StringUtils.isNotEmpty(prpCmain.getOperatorCode()) && prpCmain.getOperatorCode().equals(prpDuserDto.getUserCode())) {
                            responsePrpCmainInfoDto.setOperatorName(prpDuserDto.getUserName());
                        }
                    }
                    responsePrpCmainInfoDto.setPolicyNo(prpCmain.getPolicyNo());
                    responsePrpCmainInfoDto.setAppliCode(prpCmain.getAppliCode());
                    responsePrpCmainInfoDto.setAppliName(prpCmain.getAppliName());
                    responsePrpCmainInfoDto.setOperatorCode(prpCmain.getOperatorCode());
                    responsePrpCmainInfoDto.setStartDate(prpCmain.getStartDate());
                    responsePrpCmainInfoDto.setEndDate(prpCmain.getEndDate());
                    responsePrpCmainInfoDtoList.add(responsePrpCmainInfoDto);
                }
            }
        }
        //统一封装
        pageInfo=this.setPageInfo(responsePrpCmainInfoDtoList,requestPrpCmainInfoDto.getPageNo(),totalSize,ResponsePrpCmainInfoDto.class);

        return pageInfo;
    }

    /**
     * 理赔更新有效保额
     * @author: 刘曼曼
     * @date: 19:50 19:50
     * @param policyNo 保单号
     * @param chgSumAmount 变化量
     * @return Map 更新信息
     */
    @Modifying
    @Override
    public Map<String,String> modifyBypolicy(String policyNo,Double chgSumAmount)throws Exception{
        if(StringUtils.isEmpty(policyNo)){
            throw new DataVerifyException("保单号不能为空!");
        }
        if(chgSumAmount == null){
            throw new DataVerifyException("变化量不能为空!");
        }
        PrpCmainDto prpCmainDto= queryByPK(policyNo);
        PrpCmain prpCmain=convert(prpCmainDto,PrpCmain.class);
        Map<String,String> map = new HashMap<>();
        try {
            if (prpCmain != null) {
                prpCmain.setSumAmount(prpCmain.getSumAmount() - chgSumAmount);
                prpCmainDao.save(prpCmain);
                map.put("messege","保存成功");
            }
        }catch (Exception e){
            map.put("messege","保存失败");
        }
        return map;
    }

    /**
     * sql in 1000条拆分
     * @param field 字段
     * @param list 条件集合
     * @return
     */
    private  String parseListCondition(String field,List<String> list){
        if(list.isEmpty()){
            return null;
        }
        int splitn=50;
        StringBuilder sb=new StringBuilder("("+field+" in(");
        for (int i = 0; i <list.size(); i++) {
            if(i>0&&i%splitn==0){
                sb.append(") ");
                sb.append("or "+field+" in(");
            }else if(i>0){
                sb.append( ",");
            }
            sb.append(list.get(i));
        }
        sb.append("))");

        return sb.toString();
    }
}
