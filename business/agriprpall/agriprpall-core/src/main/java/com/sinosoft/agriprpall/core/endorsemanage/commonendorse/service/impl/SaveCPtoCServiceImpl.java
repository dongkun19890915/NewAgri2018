package com.sinosoft.agriprpall.core.endorsemanage.commonendorse.service.impl;

import com.sinosoft.agriprpall.api.endorsemanage.dto.*;
import com.sinosoft.agriprpall.core.endorsemanage.commonendorse.dao.PrpCitemAgriDao;
import com.sinosoft.agriprpall.core.endorsemanage.commonendorse.service.SaveCPtoCService;
import com.sinosoft.agriprpall.core.endorsemanage.queryendorse.service.QueryCPservice;
import com.sinosoft.agriprpall.core.policymanage.dao.*;
import com.sinosoft.agriprpall.core.policymanage.entity.*;
import com.sinosoft.framework.core.service.impl.BaseServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * @description 用cp表更新c表服务实现类
 * @throws Exception
 * @author 王保良,李东松
 * @date 2017年10月27日
 */
@Service
public class SaveCPtoCServiceImpl extends BaseServiceImpl implements SaveCPtoCService {
    @Autowired
    private QueryCPservice queryCPservice;
    @Autowired
    private PrpCengageDao prpCengageDao;
    @Autowired
    private PrpCitemAgriDao prpCitemAgriDao;
    @Autowired
    private PrpCcoinsDao prpCcoinsDao;
    @Autowired
    private PrpCexpenseDao prpCexpenseDao;
    @Autowired
    private PrpCsubsidyDao prpCsubsidyDao;
    @Autowired
    private PrpCinsuredDao prpCinsuredDao;

    @Autowired
    private PrpCmainDao prpCmainDao;
    @Autowired
    private PrpCitemKindDao prpCitemKindDao;
    @Autowired
    private PrpCaddressDao prpCaddressDao;
    @Autowired
    private PrpCfeeDao prpCfeeDao;
    @Autowired
    private PrpCplanDao prpCplanDao;
    @Autowired
    private PrpCmainAgriDao prpCmainAgriDao;


    /**
     * @description 用cp表更新c表
     * @param  policyNo
     * @return boolean
     * @throws Exception
     * @author 王保良,李东松
     * @date 2017年10月27日
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean saveCPtoC(String policyNo) throws Exception {
        /**调用CPservice服务根据保单号查询出CP表中的最新数据,并放在一个大对象中*/
        CPpolicyDto cPpolicyDto=queryCPservice.queryCPolicyInfo(policyNo);

        /**将这个大对象中的每个小Dto取出*/

        /**取出主对象信息的Dto*/
        PrpCPmainDto prpCPmainDto=cPpolicyDto.getPrpCPmainDto();
        /**取出标的信息的Dto*/
        List<PrpCPitemKindDto> prpCPitemKindDtoList =cPpolicyDto.getPrpCPitemKindDtoList();
        /**取出保额保费信息的Dto*/
        List<PrpCPfeeDto> prpCPfeeDtoList=cPpolicyDto.getPrpCPfeeDtoList();
        /**取出保单缴费计划信息的Dto*/
        List<PrpCPplanDto> prpCPplanDtoList =cPpolicyDto.getPrpCPplanDtoList();
        /**取出地址信息的Dto*/
        List<PrpCPaddressDto> prpCPaddressDtoList=cPpolicyDto.getPrpCPaddressDtoList();
        /**取出农业险信息的Dto*/
        PrpCPmainAgriDto prpCPmainAgriDto=cPpolicyDto.getPrpCPmainAgriDto();
        /**取出特别约定信息的Dto*/
        List<PrpCPengageDto> prpCPengageDtoList =cPpolicyDto.getPrpCPengageDtoList();
        /***/
        List<PrpCPitemAgriDto> prpCPitemAgriDtoList=cPpolicyDto.getPrpCPitemAgriDtoList();
        /**取出共保信息Dto*/
        List<PrpCPcoinsDto> prpCPcoinsDtoList=cPpolicyDto.getPrpCPcoinsDtoList();
        /**取出费用信息Dtl*/
        PrpCPexpenseDto prpCPexpenseDto =cPpolicyDto.getPrpCPexpenseDto();
        /**取出政府补贴信息的Dto*/
        List<PrpCPsubsidyDto> prpCPsubsidyDtoList=cPpolicyDto.getPrpCPsubsidyDtoList();
        /**取出客户资料信息的Dto*/
        List<PrpCPinsuredDto> prpCPinsuredDtoList=cPpolicyDto.getPrpCPinsuredDtoList();


        savePrpCmain(prpCPmainDto);

        /**判断并执行*/
        boolean flag=true;
        /**特别约定表*/
        if(prpCPengageDtoList !=null&& prpCPengageDtoList.size()>0){
            flag=savePrpCEngageList(prpCPengageDtoList,policyNo)&&flag;
        }
        /**农业险保单信息表*/
        if(prpCPitemAgriDtoList!=null&&prpCPitemAgriDtoList.size()>0){
            flag=savePrpCitemAgri(prpCPitemAgriDtoList,policyNo)&&flag;
        }
        /**共保信息表*/
        if(prpCPcoinsDtoList!=null&&prpCPcoinsDtoList.size()>0){
            flag=savePrpCcoins(prpCPcoinsDtoList,policyNo)&&flag;
        }
        /**保单保费信息表*/
        if(prpCPexpenseDto !=null){
            flag=savePrpCexpense(prpCPexpenseDto,policyNo)&&flag;
        }
        /**政府补贴信息表*/
        if(prpCPsubsidyDtoList!=null&&prpCPsubsidyDtoList.size()>0){
            flag=savePrpCsubsidy(prpCPsubsidyDtoList,policyNo)&&flag;
        }
        /**客户资料信息表*/
        if(prpCPinsuredDtoList!=null&&prpCPinsuredDtoList.size()>0){
            flag=savePrpCinsured(prpCPinsuredDtoList,policyNo)&&flag;
        }
        if (prpCPfeeDtoList!=null&&prpCPfeeDtoList.size()>0) {
            flag=savePrpCfee(prpCPfeeDtoList,policyNo)&&flag;
        }
        if (prpCPmainAgriDto!=null) {
            flag=savePrpCmainAgri(prpCPmainAgriDto)&&flag;
        }
        if (prpCPitemKindDtoList !=null&& prpCPitemKindDtoList.size()>0) {
            flag=savaPrpCItemKind(prpCPitemKindDtoList, policyNo)&&flag;
        }
        if (prpCPaddressDtoList!=null&&prpCPaddressDtoList.size()>0) {
            flag=savePrpCaddress(prpCPaddressDtoList, policyNo)&&flag;
        }
        if (prpCPplanDtoList !=null&& prpCPplanDtoList.size()>0) {
            flag=savePrpCplan(prpCPplanDtoList, policyNo)&&flag;
        }


        return flag;
    }


    /**
     * @description 用cp表更新c表(PrpCmain)
     * @param  prpCPmainDto
     * @return boolean
     * @throws Exception
     * @author 王保良
     * @date 2017年10月27日
     */
    @Transactional(rollbackFor = Exception.class)
    public boolean savePrpCmain(PrpCPmainDto prpCPmainDto) throws Exception{
        PrpCmain prpCmain=new PrpCmain();

        prpCmain.setPolicyNo(prpCPmainDto.getPolicyNo());
        prpCmain.setClassCode(prpCPmainDto.getClassCode());
        prpCmain.setRiskCode(prpCPmainDto.getRiskCode());
        prpCmain.setProposalNo(prpCPmainDto.getProposalNo());
        prpCmain.setContractNo(prpCPmainDto.getContractNo());
        prpCmain.setPolicySort(prpCPmainDto.getPolicySort());
        prpCmain.setPrintNo(prpCPmainDto.getPrintNo());
        prpCmain.setBusinessNature(prpCPmainDto.getBusinessNature());
        prpCmain.setLanguage(prpCPmainDto.getLanguage());
        prpCmain.setPolicyType(prpCPmainDto.getPolicyType());

        prpCmain.setAppliCode(prpCPmainDto.getAppliCode());
        prpCmain.setAppliName(prpCPmainDto.getAppliName());
        prpCmain.setAppliAddress(prpCPmainDto.getAppliAddress());
        prpCmain.setInsuredCode(prpCPmainDto.getInsuredCode());
        prpCmain.setInsuredName(prpCPmainDto.getInsuredName());
        prpCmain.setInsuredAddress(prpCPmainDto.getInsuredAddress());
        prpCmain.setOperateDate(prpCPmainDto.getOperateDate());
        prpCmain.setStartDate(prpCPmainDto.getStartDate());
        prpCmain.setStartHour(prpCPmainDto.getStartHour());
        prpCmain.setEndDate(prpCPmainDto.getEndDate());

        prpCmain.setEndHour(prpCPmainDto.getEndHour());
        prpCmain.setPureRate(prpCPmainDto.getPureRate());
        prpCmain.setDisRate(prpCPmainDto.getDisRate());
        prpCmain.setDiscount(prpCPmainDto.getDiscount());
        prpCmain.setCurrency(prpCPmainDto.getCurrency());
        prpCmain.setSumValue(prpCPmainDto.getSumValue());
        prpCmain.setSumAmount(prpCPmainDto.getSumAmount());
        prpCmain.setSumDiscount(prpCPmainDto.getSumDiscount());
        prpCmain.setSumPremium(prpCPmainDto.getSumPremium());
        prpCmain.setSumSubPrem(prpCPmainDto.getSumSubPrem());

        prpCmain.setSumQuantity(prpCPmainDto.getSumQuantity());
        prpCmain.setJudicalCode(prpCPmainDto.getJudicalCode());
        prpCmain.setJudicalScope(prpCPmainDto.getJudicalScope());
        prpCmain.setAutoTransRenewFlag(prpCPmainDto.getAutoTransRenewFlag());
        prpCmain.setArgueSolution(prpCPmainDto.getArgueSolution());
        prpCmain.setArbitBoardName(prpCPmainDto.getArbitBoardName());
        prpCmain.setPayTimes(prpCPmainDto.getPayTimes());
        prpCmain.setEndorseTimes(prpCPmainDto.getEndorseTimes());
        prpCmain.setClaimTimes(prpCPmainDto.getClaimTimes());
        prpCmain.setMakeCom(prpCPmainDto.getMakeCom());

        prpCmain.setOperateSite(prpCPmainDto.getOperateSite());
        prpCmain.setComCode(prpCPmainDto.getComCode());
        prpCmain.setHandlerCode(prpCPmainDto.getHandlerCode());
        prpCmain.setHandler1Code(prpCPmainDto.getHandler1Code());
        prpCmain.setApproverCode(prpCPmainDto.getApproverCode());
        prpCmain.setUnderwriteCode(prpCPmainDto.getUnderwriteCode());
        prpCmain.setUnderwriteName(prpCPmainDto.getUnderwriteName());
        prpCmain.setOperatorCode(prpCPmainDto.getOperatorCode());
        prpCmain.setInputDate(prpCPmainDto.getInputDate());
        prpCmain.setInputHour(prpCPmainDto.getInputHour());

        prpCmain.setUnderwriteEndDate(prpCPmainDto.getUnderwriteEndDate());
        prpCmain.setStatisticSym(prpCPmainDto.getStatisticSym());
        prpCmain.setAgentCode(prpCPmainDto.getAgentCode());
        prpCmain.setCoinsFlag(prpCPmainDto.getCoinsFlag());
        prpCmain.setReinsFlag(prpCPmainDto.getReinsFlag());
        prpCmain.setAllinsFlag(prpCPmainDto.getAllinsFlag());
        prpCmain.setUnderwriteFlag(prpCPmainDto.getUnderwriteFlag());
        prpCmain.setOthFlag(prpCPmainDto.getOthFlag());
        prpCmain.setFlag(prpCPmainDto.getFlag());
        prpCmain.setDisRate1(prpCPmainDto.getDisRate1());

        prpCmain.setBusinessFlag(prpCPmainDto.getBusinessFlag());
        prpCmain.setUpdaterCode(prpCPmainDto.getUpdaterCode());
        prpCmain.setUpdateDate(prpCPmainDto.getUpdateDate());
        prpCmain.setUpdateHour(prpCPmainDto.getUpdateHour());
        prpCmain.setSignDate(prpCPmainDto.getSignDate());
        prpCmain.setShareholderFlag(prpCPmainDto.getShareholderFlag());
        prpCmain.setAgreementNo(prpCPmainDto.getAgreementNo());
        prpCmain.setInquiryNo(prpCPmainDto.getInquiryNo());
        prpCmain.setPayMode(prpCPmainDto.getPayMode());
        prpCmain.setRemark(prpCPmainDto.getRemark());

        prpCmain.setVisaCode(prpCPmainDto.getVisaCode());
        prpCmain.setManualType(prpCPmainDto.getManualType());
        prpCmain.setPolicyBizType(prpCPmainDto.getPolicyBizType());
        prpCmain.setBusinessType(prpCPmainDto.getBusinessType());
        prpCmain.setBusinessType1(prpCPmainDto.getBusinessType1());
        prpCmain.setUnitCode(prpCPmainDto.getUnitCode());
        prpCmain.setStatQuantity(prpCPmainDto.getStatQuantity());
        prpCmain.setStatUnitCode(prpCPmainDto.getStatUnitCode());
        prpCmain.setSumInsured(prpCPmainDto.getSumInsured());
        prpCmain.setArticleType(prpCPmainDto.getArticleType());

        prpCmain.setBusinessProvince(prpCPmainDto.getBusinessProvince());
        prpCmain.setBusinessTown(prpCPmainDto.getBusinessTown());
        prpCmain.setBusinessCounty(prpCPmainDto.getBusinessCounty());
        prpCmain.setBusinessAreaName(prpCPmainDto.getBusinessAreaName());
        prpCmain.setPrintDate(prpCPmainDto.getPrintDate());
        prpCmain.setPayDate(prpCPmainDto.getPayDate());
        prpCmain.setStartMinute(prpCPmainDto.getStartMinute());
        prpCmain.setEndMinute(prpCPmainDto.getEndMinute());
        prpCmain.setLimitAmount(prpCPmainDto.getLimitAmount());
        prpCmain.setThirdKnow(prpCPmainDto.getThirdKnow());

//        prpCmain.setSmsFlag("");
//        prpCmain.setSmssEnder("");
//        prpCmain.setSmssEndDate(new Date());

        prpCmain.setAgentRemark(prpCPmainDto.getAgentRemark());
        prpCmain.setnCarPerpFlag(prpCPmainDto.getnCarPerpFlag());
        prpCmain.setRichflyAreasCode(prpCPmainDto.getRichflyAreasCode());
        prpCmain.setRichflyAreasCName(prpCPmainDto.getRichflyAreasCName());
        prpCmain.setRichflyCode(prpCPmainDto.getRichflyCode());
        prpCmain.setRichflyCName(prpCPmainDto.getRichflyCName());
        prpCmain.setGroupNo(prpCPmainDto.getGroupNo());
        prpCmain.setGroupFlag(prpCPmainDto.getGroupFlag());
        prpCmain.setBasePerformanceRate(prpCPmainDto.getBasePerformanceRate());
        prpCmain.setEncouragePerformanceRate(prpCPmainDto.getEncouragePerformanceRate());


//        prpCmain.setIsSeeFeeFlag("");
//        prpCmain.setValidcountDate(new Date());


        prpCmain.setSumRate(prpCPmainDto.getSumRate());
        prpCmain.setStandardRate(prpCPmainDto.getStandardRate());
        prpCmain.setAgriFlag(prpCPmainDto.getAgriFlag());
        prpCmain.setVersionNo(prpCPmainDto.getVersionNo());
        prpCmain.setBigMedicalType(prpCPmainDto.getBigMedicalType());
        prpCmain.setEarningsRate(prpCPmainDto.getEarningsRate());

//        prpCmain.setInsuredListType("");

        prpCmain.setCoinsPremiumType(prpCPmainDto.getCoinsPremiumType());
        prpCmain.setBusinessCity(prpCPmainDto.getBusinessCity());
        prpCmain.setAllianceRate(prpCPmainDto.getAllianceRate());
        prpCmain.setEccFlag(prpCPmainDto.getEccFlag());
        prpCmain.setSsProposalNo(prpCPmainDto.getSsProposalNo());
        prpCmain.setBusinessYear(prpCPmainDto.getBusinessYear());
        prpCmain.setMakeArea(prpCPmainDto.getMakeArea());
        prpCmain.setBusinessArea(prpCPmainDto.getBusinessArea());

//        prpCmain.setJFeeFlag("");

        prpCmain.setPrintTime(prpCPmainDto.getPrintTime());
        prpCmain.setProjectsFlag(prpCPmainDto.getProjectsFlag());
        prpCmain.setProposalLevel(prpCPmainDto.getProposalLevel());
        prpCmain.setRateEndDate(prpCPmainDto.getRateEndDate());
        prpCmain.setRatePeriod(prpCPmainDto.getRatePeriod());
        prpCmain.setRatePeriodOld(prpCPmainDto.getRatePeriodOld());
        prpCmain.setRatePeriodType(prpCPmainDto.getRatePeriodType());
        prpCmain.setRateStartDate(prpCPmainDto.getRateStartDate());
        prpCmain.setRsnNoRenewal(prpCPmainDto.getRsnNoRenewal());
        prpCmain.setStartStages(prpCPmainDto.getStartStages());

        prpCmain.setStopTimes(prpCPmainDto.getStopTimes());
        prpCmain.setSubBusinessNature(prpCPmainDto.getSubBusinessNature());
        prpCmain.setTradeVanId(prpCPmainDto.getTradeVanId());
        prpCmain.setUndwrtMark(prpCPmainDto.getUndwrtMark());
        prpCmain.setPreInvoiceFlag(prpCPmainDto.getPreInvoiceFlag());
        prpCmain.setMiFlag(prpCPmainDto.getMiFlag());
        prpCmain.setSubmitUndwrtFlag(prpCPmainDto.getSubmitUndwrtFlag());
        prpCmain.setTypeFgEditFlag(prpCPmainDto.getTypeFgEditFlag());
        prpCmain.setInputType(prpCPmainDto.getInputType());
        prpCmain.setPeriodFlag(prpCPmainDto.getPeriodFlag());

        prpCmain.setHangupFlag(prpCPmainDto.getHangupFlag());
        prpCmain.setInstallmentFlag(prpCPmainDto.getInstallmentFlag());
        prpCmain.setPaybackFlag(prpCPmainDto.getPaybackFlag());
        prpCmain.setChannelAdjustValue(prpCPmainDto.getChannelAdjustValue());
        prpCmain.setAutonomyAdjustValue(prpCPmainDto.getAutonomyAdjustValue());
        prpCmain.setClauseType(prpCPmainDto.getClauseType());
        prpCmain.setLocalModelDiscountZ(prpCPmainDto.getLocalModelDiscountZ());
        prpCmain.setLocalModelPremium(prpCPmainDto.getLocalModelPremium());
        prpCmain.setLocalModelDiscountQ(prpCPmainDto.getLocalModelDiscountQ());
        prpCmain.setEffectFlag(prpCPmainDto.getEffectFlag());

        prpCmain.setAgentClass(prpCPmainDto.getAgentClass());
        prpCmain.setTopCommisionRate(prpCPmainDto.getTopCommisionRate());
        prpCmain.setIntCommisionRate(prpCPmainDto.getIntCommisionRate());
        prpCmain.setHandler2Address(prpCPmainDto.getHandler2Address());
        prpCmain.setHandler2Code(prpCPmainDto.getHandler2Code());
        prpCmain.setHandler2Id(prpCPmainDto.getHandler2Id());
        prpCmain.setHandler2IdType(prpCPmainDto.getHandler2IdType());
        prpCmain.setHandler2Mobile(prpCPmainDto.getHandler2Mobile());
        prpCmain.setHandler2Name(prpCPmainDto.getHandler2Name());
        prpCmain.setHandler2Post(prpCPmainDto.getHandler2Post());

        prpCmain.setHandlerIdentifyNumber(prpCPmainDto.getHandlerIdentifyNumber());
        prpCmain.setHandlerName(prpCPmainDto.getHandlerName());
        prpCmain.setIntroducerId(prpCPmainDto.getIntroducerId());
        prpCmain.setIntroducerName(prpCPmainDto.getIntroducerName());
        prpCmain.setIsUndwrtFlag(prpCPmainDto.getIsUndwrtFlag());
        prpCmain.setjFeePayType(prpCPmainDto.getjFeePayType());
        prpCmain.setLastInsurerCode(prpCPmainDto.getLastInsurerCode());
        prpCmain.setLastInsurerCom(prpCPmainDto.getLastInsurerCom());
        prpCmain.setLastPrintNo(prpCPmainDto.getLastPrintNo());
        prpCmain.setLockerCode(prpCPmainDto.getLockerCode());

        prpCmain.setNationFlag(prpCPmainDto.getNationFlag());
        prpCmain.setNewEndDate(prpCPmainDto.getNewEndDate());
        prpCmain.setNewStartDate(prpCPmainDto.getNewStartDate());
        prpCmain.setNotRenewalRegist(prpCPmainDto.getNotRenewalRegist());
        prpCmain.setOperateWayFlag(prpCPmainDto.getOperateWayFlag());
        prpCmain.setPayrefCode(prpCPmainDto.getPayrefCode());
        prpCmain.setPayrefName(prpCPmainDto.getPayrefName());
        prpCmain.setPayrefTime(prpCPmainDto.getPayrefTime());
        prpCmain.setSystemFlag(prpCPmainDto.getSystemFlag());
        prpCmain.setAgent1Code(prpCPmainDto.getAgent1Code());

        prpCmain.setAgentMaxComission(prpCPmainDto.getAgentMaxComission());
        prpCmain.setAgentName(prpCPmainDto.getAgentName());
        prpCmain.setAgentTypeNo(prpCPmainDto.getAgentTypeNo());
        prpCmain.setAgriType(prpCPmainDto.getAgriType());
        prpCmain.setAssignNo(prpCPmainDto.getAssignNo());
        prpCmain.setBankCode(prpCPmainDto.getBankCode());
        prpCmain.setBankFlag(prpCPmainDto.getBankFlag());
        prpCmain.setBizNoSysFlag(prpCPmainDto.getBizNoSysFlag());
        prpCmain.setBusinessRecMark(prpCPmainDto.getBusinessRecMark());
        prpCmain.setBusinessTypeFlag(prpCPmainDto.getBusinessTypeFlag());

        prpCmain.setCaseNo(prpCPmainDto.getCaseNo());
        prpCmain.setChannelCode(prpCPmainDto.getChannelCode());
        prpCmain.setChannelType(prpCPmainDto.getChannelType());
        prpCmain.setContributionLevel(prpCPmainDto.getContributionLevel());
        prpCmain.setDeclareFlag(prpCPmainDto.getDeclareFlag());
        prpCmain.setEditFlag(prpCPmainDto.getEditFlag());
        prpCmain.setEffectiveImmediatelyFlag(prpCPmainDto.getEffectiveImmediatelyFlag());
        prpCmain.setExchangeRate(prpCPmainDto.getExchangeRate());
        prpCmain.setExtraComCode(prpCPmainDto.getExtraComName());

        prpCmain.setExtraComCode(prpCPmainDto.getExtraComCode());
        prpCmain.setFactorPlaceCode(prpCPmainDto.getFactorPlaceCode());
        prpCmain.setFactorPlaceName(prpCPmainDto.getFactorPlaceName());
        prpCmain.setFycFlag(prpCPmainDto.getFycFlag());
        prpCmain.setGovPurchaseFlag(prpCPmainDto.getGovPurchaseFlag());
        prpCmain.setGroupType(prpCPmainDto.getGroupType());
        prpCmain.setHandler1Name(prpCPmainDto.getHandler1Name());
        prpCmain.setInputTime(prpCPmainDto.getInputTime());
        prpCmain.setSaveTime(prpCPmainDto.getSaveTime());
        prpCmain.setSaleName(prpCPmainDto.getSaleName());

        prpCmain.setSalePhone(prpCPmainDto.getSalePhone());
        prpCmain.setSaleComCode(prpCPmainDto.getSaleComCode());
        prpCmain.setSaleComName(prpCPmainDto.getSaleComName());
        prpCmain.setSaleComAddress(prpCPmainDto.getSaleComAddress());
        prpCmain.setSaleAgentPersonName(prpCPmainDto.getSaleAgentPersonName());
        prpCmain.setSaleAgentPersonId(prpCPmainDto.getSaleAgentPersonId());
        prpCmain.setSaleAgentPermitNo(prpCPmainDto.getSaleAgentPermitNo());
        prpCmain.setComCostPrem(prpCPmainDto.getComCostPrem());
        prpCmain.setCtpCostPrem(prpCPmainDto.getCtpCostPrem());
        prpCmain.setEntireCostDiscount(prpCPmainDto.getEntireCostDiscount());
        prpCmain.setEntireRecommenDiscount(prpCPmainDto.getEntireRecommenDiscount());
        prpCmain.setEntireExpDiscount(prpCPmainDto.getEntireExpDiscount());
        prpCmain.setEntireUwritingDiscount(prpCPmainDto.getEntireUwritingDiscount());
        prpCmain.setOldAutonomyAdjustValue(prpCPmainDto.getOldAutonomyAdjustValue());
        prpCmain.setOldChannelAdjustValue(prpCPmainDto.getOldChannelAdjustValue());
        prpCmain.setOldDiscount(prpCPmainDto.getOldDiscount());
        prpCmain.setHopeDiscount(prpCPmainDto.getHopeDiscount());
        prpCmain.setAdjustClaimReasonCode(prpCPmainDto.getAdjustClaimReasonCode());
        prpCmain.setAdjustClaimReasonRate(prpCPmainDto.getAdjustClaimReasonRate());
        prpCmain.setPrecheckDate(prpCPmainDto.getPrecheckDate());
        prpCmain.setSpecialBusinessNo(prpCPmainDto.getSpecialBusinessNo());
        prpCmain.setValidTime(prpCPmainDto.getValidTime());
        prpCmain.setAgent1Name(prpCPmainDto.getAgent1Name());

//        prpCmain.setUpdate_By("");
//        prpCmain.setUpdate_Date(new Date());

        prpCmain.setSumNoTaxPremium(prpCPmainDto.getSumNoTaxPremium());
        prpCmain.setSumTaxFee(prpCPmainDto.getSumTaxFee());
        prpCmain.setIsThirdBusiness(prpCPmainDto.getIsThirdBusiness());
        prpCmain.setRecordCode(prpCPmainDto.getRecordCode());
        prpCmain.setTaxType(prpCPmainDto.getTaxType());
        prpCmain.setIsRepairCode(prpCPmainDto.getIsRepairCode());
        prpCmain.setRepairCode(prpCPmainDto.getRepairCode());
        prpCmain.setRepairName(prpCPmainDto.getRepairName());
        prpCmain.setWxChannelCode(prpCPmainDto.getWxChannelCode());
        prpCmain.setIsOnline(prpCPmainDto.getIsOnline());
        prpCmain.setIsCustomer(prpCPmainDto.getIsCustomer());
        prpCmain.setInceptionFlag(prpCPmainDto.getInceptionFlag());
        prpCmain.setNotificationFlag(prpCPmainDto.getNotificationFlag());
        prpCmain.setAgentBusinessType(prpCPmainDto.getAgentBusinessType());
        prpCmain.setAgentBusinessTypeName(prpCPmainDto.getAgentBusinessTypeName());
        prpCmain.setCtpElr(prpCPmainDto.getCtpElr());
        prpCmain.setComElr(prpCPmainDto.getComElr());
        prpCmain.setElr(prpCPmainDto.getElr());

        PrpCmain prpCmain1=prpCmainDao.save(prpCmain);
        if (prpCmain1==null){
            return false;
        }
        return true;
    }













    /**
     * @description 特约信息保存
     * @param prpCPengageDtoList, policyNo
     * @return boolean
     * @throws Exception
     * @author 李冬松
     * @date 14:34 2017/10/27
     */
    @Transactional(rollbackFor = Exception.class)
    public boolean savePrpCEngageList(List<PrpCPengageDto> prpCPengageDtoList, String policyNo)throws Exception{
        prpCengageDao.deleteAllByCondition(policyNo);
        List<PrpCengage> prpCengageList=new ArrayList<PrpCengage>();
        PrpCengage prpCengage;
        for(PrpCPengageDto prpCPengageDto : prpCPengageDtoList){
            prpCengage=new PrpCengage();
            prpCengage.setPolicyNo(prpCPengageDto.getPolicyNo());
            prpCengage.setSerialNo(prpCPengageDto.getSerialNo());
            prpCengage.setLineNo(prpCPengageDto.getLineNo());
            prpCengage.setRiskCode(prpCPengageDto.getRiskCode());
            prpCengage.setClauseCode(prpCPengageDto.getClauseCode());
            prpCengage.setClauses(prpCPengageDto.getClauses());
            prpCengage.setTitleFlag(prpCPengageDto.getTitleFlag());
            prpCengage.setFlag(prpCPengageDto.getFlag());
            prpCengage.setClauseName(prpCPengageDto.getClauseName());
            prpCengageList.add(prpCengage);
        }
        List<PrpCengage> prpCengageSaveList=prpCengageDao.save(prpCengageList);
        if(prpCengageSaveList!=null&&prpCengageSaveList.size()>0){
            return true;
        }else {
            return false;
        }
    }
    /**
     * @description
     * @param prpCPitemAgriDtoList, policyNo
     * @return boolean
     * @throws Exception
     * @author 李冬松
     * @date 14:34 2017/10/27
     */
    @Transactional(rollbackFor = Exception.class)
    public boolean savePrpCitemAgri(List<PrpCPitemAgriDto> prpCPitemAgriDtoList,String policyNo)throws Exception{
        prpCitemAgriDao.deleteAllByCondition(policyNo);
        List<PrpCitemAgri> prpCitemAgriList=new ArrayList<>();
        PrpCitemAgri prpCitemAgri;
        for(PrpCPitemAgriDto prpCPitemAgriDto:prpCPitemAgriDtoList){
            prpCitemAgri=new PrpCitemAgri();
            prpCitemAgri.setPolicyNo(prpCPitemAgriDto.getPolicyNo());
            prpCitemAgri.setRiskCode(prpCPitemAgriDto.getRiskCode());
            prpCitemAgri.setItemNo(prpCPitemAgriDto.getItemNo());
            prpCitemAgri.setLongitudeStart(prpCPitemAgriDto.getLongitudeStart());
            prpCitemAgri.setLongitudeEnd(prpCPitemAgriDto.getLongitudeEnd());
            prpCitemAgri.setLatitudeStart(prpCPitemAgriDto.getLatitudeStart());
            prpCitemAgri.setLatitudeEnd(prpCPitemAgriDto.getLatitudeEnd());

            prpCitemAgri.setUnitCost(prpCPitemAgriDto.getUnitCost());
            prpCitemAgri.setUnitPrice(prpCPitemAgriDto.getUnitPrice());
            prpCitemAgri.setUnitProduct(prpCPitemAgriDto.getUnitProduct());
            prpCitemAgri.setItemAge(prpCPitemAgriDto.getItemAge());
            prpCitemAgri.setDensity(prpCPitemAgriDto.getDensity());
            prpCitemAgri.setRemark(prpCPitemAgriDto.getRemark());
            prpCitemAgri.setFlag(prpCPitemAgriDto.getFlag());
            prpCitemAgriList.add(prpCitemAgri);
        }
        List<PrpCitemAgri> prpCitemAgriSaveList=prpCitemAgriDao.save(prpCitemAgriList);
        if(prpCitemAgriSaveList!=null&&prpCitemAgriSaveList.size()>0){
            return true;
        }else {
            return false;
        }
    }
    /**
     * @description 共保信息保存
     * @param prpCPcoinsDtoList, policyNo
     * @return boolean
     * @throws Exception
     * @author 李冬松
     * @date 14:34 2017/10/27
     */
    @Transactional(rollbackFor = Exception.class)
    public boolean savePrpCcoins(List<PrpCPcoinsDto> prpCPcoinsDtoList,String policyNo)throws Exception{
        prpCcoinsDao.deleteAllByCondition(policyNo);
        List<PrpCcoins> prpCcoinsList=new ArrayList<>();
        PrpCcoins prpCcoins;
        for(PrpCPcoinsDto prpCPcoinsDto:prpCPcoinsDtoList){
            prpCcoins=new PrpCcoins();
            prpCcoins.setPolicyNo(prpCPcoinsDto.getPolicyNo());
            prpCcoins.setSerialNo(prpCPcoinsDto.getSerialNo());
            prpCcoins.setMainPolicyNo(prpCPcoinsDto.getMainPolicyNo());
            prpCcoins.setCoinsCode(prpCPcoinsDto.getCoinsCode());
            prpCcoins.setCoinsName(prpCPcoinsDto.getCoinsName());
            prpCcoins.setCoinsType(prpCPcoinsDto.getCoinsType());

            prpCcoins.setCoinsRate(prpCPcoinsDto.getCoinsRate());
            prpCcoins.setFlag(prpCPcoinsDto.getFlag());
            prpCcoins.setChiefFlag(prpCPcoinsDto.getChiefFlag());
            prpCcoins.setProportionFlag(prpCPcoinsDto.getProportionFlag());
            prpCcoins.setCoinsTreatyNo(prpCPcoinsDto.getCoinsTreatyNo());
            prpCcoins.setCoinsFlag(prpCPcoinsDto.getCoinsFlag());
            prpCcoins.setReinsCiFlag(prpCPcoinsDto.getReinsCiFlag());
            prpCcoinsList.add(prpCcoins);
        }

        List<PrpCcoins> prpCcoinsSaveList=prpCcoinsDao.save(prpCcoinsList);
        if(prpCcoinsSaveList!=null&&prpCcoinsSaveList.size()>0){
            return true;
        }else {
            return false;
        }
    }
    /**
     * @description 保单保费信息保存
     * @param prpCPexpenseDto, policyNo
     * @return boolean
     * @throws Exception
     * @author 李冬松
     * @date 14:34 2017/10/27
     */
    @Transactional(rollbackFor = Exception.class)
    public boolean savePrpCexpense(PrpCPexpenseDto prpCPexpenseDto, String policyNo)throws Exception{
        prpCexpenseDao.deleteAllByCondition(policyNo);
        PrpCexpense prpCexpense=new PrpCexpense();
        prpCexpense.setPolicyNo(prpCPexpenseDto.getPolicyNo());
        prpCexpense.setRiskCode(prpCPexpenseDto.getRiskCode());
        prpCexpense.setManageFeeRate(prpCPexpenseDto.getManageFeeRate());
        prpCexpense.setMaxManageFeeRate(prpCPexpenseDto.getMaxManageFeeRate());
        prpCexpense.setFlag(prpCPexpenseDto.getFlag());
        prpCexpense.setSalvationRate(prpCPexpenseDto.getSalvationRate());
        prpCexpense.setSalvationFee(prpCPexpenseDto.getSalvationFee());
        prpCexpense.setCurrency(prpCPexpenseDto.getCurrency());

        prpCexpense.setBasePerformanceRate(prpCPexpenseDto.getBasePerformanceRate());
        prpCexpense.setBasePerformance(prpCPexpenseDto.getBasePerformance());
        prpCexpense.setEncouragePerformanceRate(prpCPexpenseDto.getEncouragePerformanceRate());
        prpCexpense.setEncouragePerformance(prpCPexpenseDto.getEncouragePerformance());
        prpCexpense.setNoTaxFee(prpCPexpenseDto.getNoTaxFee());
        prpCexpense.setTaxRate(prpCPexpenseDto.getTaxRate());
        prpCexpense.setTaxFee(prpCPexpenseDto.getTaxFee());
        PrpCexpense prpCexpenseSave=prpCexpenseDao.save(prpCexpense);
        if(prpCexpenseSave!=null){
            return true;
        }else {
            return false;
        }
    }
    /**
     * @description 政府补贴信息保存
     * @param prpCPsubsidyDtoList, policyNo
     * @return boolean
     * @throws Exception
     * @author 李冬松
     * @date 14:35 2017/10/27
     */
    @Transactional(rollbackFor = Exception.class)
    public boolean savePrpCsubsidy(List<PrpCPsubsidyDto> prpCPsubsidyDtoList,String policyNo)throws Exception{
        prpCsubsidyDao.deleteAllByCondition(policyNo);
        List<PrpCsubsidy> prpCsubsidyList=new ArrayList<>();
        PrpCsubsidy prpCsubsidy;
        for(PrpCPsubsidyDto prpCPsubsidyDto:prpCPsubsidyDtoList){
            prpCsubsidy=new PrpCsubsidy();
            prpCsubsidy.setPolicyNo(prpCPsubsidyDto.getPolicyNo());
            prpCsubsidy.setSubsidyCode(prpCPsubsidyDto.getSubsidyCode());
            prpCsubsidy.setSubsidyType(prpCPsubsidyDto.getSubsidyType());
            prpCsubsidy.setProposalNo(prpCPsubsidyDto.getProposalNo());
            prpCsubsidy.setContractNo(prpCPsubsidyDto.getContractNo());
            prpCsubsidy.setRiskCode(prpCPsubsidyDto.getRiskCode());
            prpCsubsidy.setClassCode(prpCPsubsidyDto.getClassCode());

            prpCsubsidy.setComCode(prpCPsubsidyDto.getComCode());
            prpCsubsidy.setCurrency(prpCPsubsidyDto.getCurrency());
            prpCsubsidy.setBenchmarkPremium(prpCPsubsidyDto.getBenchmarkPremium());
            prpCsubsidy.setSubsidyName(prpCPsubsidyDto.getSubsidyName());
            prpCsubsidy.setSubsidyTypeName(prpCPsubsidyDto.getSubsidyTypeName());
            prpCsubsidy.setSubsidyDepartment(prpCPsubsidyDto.getSubsidyDepartment());
            prpCsubsidy.setSubsidyRate(prpCPsubsidyDto.getSubsidyRate());
            prpCsubsidy.setSubsidyPremium(prpCPsubsidyDto.getSubsidyPremium());
            prpCsubsidy.setOperationFlag(prpCPsubsidyDto.getOperationFlag());
            prpCsubsidyList.add(prpCsubsidy);
        }

        List<PrpCsubsidy> prpCsubsidySaveList=prpCsubsidyDao.save(prpCsubsidyList);
        if(prpCsubsidySaveList!=null&&prpCsubsidySaveList.size()>0){
            return true;
        }else {
            return false;
        }
    }
    /**
     * @description 保险人信息保存
     * @param prpCPinsuredDtoList, policyNo
     * @return boolean
     * @throws Exception
     * @author 李冬松
     * @date 14:35 2017/10/27
     */
    @Transactional(rollbackFor = Exception.class)
    public boolean savePrpCinsured(List<PrpCPinsuredDto> prpCPinsuredDtoList,String policyNo)throws Exception{
        prpCinsuredDao.deleteAllByCondition(policyNo);
        List<PrpCinsured> prpCinsuredList=new ArrayList<>();
        PrpCinsured prpCinsured;
        for(PrpCPinsuredDto prpCPinsuredDto:prpCPinsuredDtoList){
            prpCinsured=new PrpCinsured();
            prpCinsured.setPolicyNo(prpCPinsuredDto.getPolicyNo());
            prpCinsured.setSerialNo(prpCPinsuredDto.getSerialNo());
            prpCinsured.setRiskCode(prpCPinsuredDto.getRiskCode());
            prpCinsured.setLanguage(prpCPinsuredDto.getLanguage());
            prpCinsured.setInsuredType(prpCPinsuredDto.getInsuredType());
            prpCinsured.setInsuredCode(prpCPinsuredDto.getInsuredCode());
            prpCinsured.setInsuredName(prpCPinsuredDto.getInsuredName());
            prpCinsured.setInsuredAddress(prpCPinsuredDto.getInsuredAddress());
            prpCinsured.setInsuredNature(prpCPinsuredDto.getInsuredNature());
            prpCinsured.setInsuredFlag(prpCPinsuredDto.getInsuredFlag());
            prpCinsured.setInsuredIdentity(prpCPinsuredDto.getInsuredIdentity());

            prpCinsured.setRelateSerialNo(prpCPinsuredDto.getRelateSerialNo());
            prpCinsured.setIdentifyType(prpCPinsuredDto.getIdentifyType());
            prpCinsured.setIdentifyNumber(prpCPinsuredDto.getIdentifyNumber());
            prpCinsured.setCreditLevel(prpCPinsuredDto.getCreditLevel());
            prpCinsured.setPossessNature(prpCPinsuredDto.getPossessNature());
            prpCinsured.setBusinessSource(prpCPinsuredDto.getBusinessSource());
            prpCinsured.setBusinessSort(prpCPinsuredDto.getBusinessSort());
            prpCinsured.setOccupationCode(prpCPinsuredDto.getOccupationCode());
            prpCinsured.setEducationCode(prpCPinsuredDto.getEducationCode());

            prpCinsured.setBank(prpCPinsuredDto.getBank());
            prpCinsured.setAccountName(prpCPinsuredDto.getAccountName());
            prpCinsured.setAccount(prpCPinsuredDto.getAccount());
            prpCinsured.setLinkerName(prpCPinsuredDto.getLinkerName());
            prpCinsured.setPostAddress(prpCPinsuredDto.getPostAddress());
            prpCinsured.setPostCode(prpCPinsuredDto.getPostCode());
            prpCinsured.setPhoneNumber(prpCPinsuredDto.getPhoneNumber());
            prpCinsured.setMobile(prpCPinsuredDto.getMobile());
            prpCinsured.setEmail(prpCPinsuredDto.getEmail());

            prpCinsured.setBenefitRate(prpCPinsuredDto.getBenefitRate());
            prpCinsured.setBenefitFlag(prpCPinsuredDto.getBenefitFlag());
            prpCinsured.setFlag(prpCPinsuredDto.getFlag());
            prpCinsured.setOccupationGrade(prpCPinsuredDto.getOccupationGrade());
            prpCinsured.setRiskLevel(prpCPinsuredDto.getRiskLevel());
            prpCinsured.setIsCareClaim(prpCPinsuredDto.getIsCareClaim());
            prpCinsured.setCashFocus(prpCPinsuredDto.getCashFocus());
            prpCinsured.setValidPeriod3(prpCPinsuredDto.getValidPeriod3());
            prpCinsured.setJobTitle(prpCPinsuredDto.getJobTitle());

            prpCinsured.setNationality(prpCPinsuredDto.getNationality());
            prpCinsured.setBusinessCode(prpCPinsuredDto.getBusinessCode());
            prpCinsured.setRevenueRegistNo(prpCPinsuredDto.getRevenueRegistNo());
            prpCinsured.setBusinessValidPeriod(prpCPinsuredDto.getBusinessValidPeriod());
            prpCinsured.setRevenueRegistValidPeriod(prpCPinsuredDto.getRevenueRegistValidPeriod());
            prpCinsured.setOtherCodeNo(prpCPinsuredDto.getOtherCodeNo());
            prpCinsured.setOtherCodeValidPeriod(prpCPinsuredDto.getOtherCodeValidPeriod());
            prpCinsured.setSex(prpCPinsuredDto.getSex());
            prpCinsured.setWechatNo(prpCPinsuredDto.getWechatNo());

            prpCinsured.setVipFlag(prpCPinsuredDto.getVipFlag());
            prpCinsured.setCertificateName(prpCPinsuredDto.getCertificateName());
            prpCinsured.setCustomerKind(prpCPinsuredDto.getCustomerKind());
            prpCinsured.setInsuredSort(prpCPinsuredDto.getInsuredSort());
            prpCinsured.setLicenseStartDate(prpCPinsuredDto.getLicenseStartDate());
            prpCinsured.setNationFlag(prpCPinsuredDto.getNationFlag());
            prpCinsured.setBenefitType(prpCPinsuredDto.getBenefitType());
            prpCinsured.setAge(prpCPinsuredDto.getAge());
            prpCinsuredList.add(prpCinsured);
            /**以下字段CP表中没有*/
            /**
             * prpCinsured.setUpdate_By("");
             * prpCinsured.setApplyRealation("");
             * prpCinsured.setCustomerSequenceNo("");
             */
        }

        List<PrpCinsured> prpCinsuredSaveList=prpCinsuredDao.save(prpCinsuredList);
        if(prpCinsuredSaveList!=null&&prpCinsuredSaveList.size()>0){
            return true;
        }else {
            return false;
        }





    }

    /**
     * @description 用cp表更新c表(包含先从c表删除操作 PrpCitemKind)
     * @param   prpCPitemKindDtoList, policyNo
     * @return boolean
     * @throws Exception
     * @author 王保良
     * @date 2017年10月27日
     */
    @Transactional(rollbackFor = Exception.class)
    public boolean savaPrpCItemKind(List<PrpCPitemKindDto> prpCPitemKindDtoList, String policyNo) throws Exception{
        prpCitemKindDao.deleteByPolicyNo(policyNo);
        PrpCitemKind prpCitemKind;
        List<PrpCitemKind> prpCitemKindList=new ArrayList<PrpCitemKind>();
        for (PrpCPitemKindDto prpCPitemKindDto : prpCPitemKindDtoList){
            prpCitemKind=new PrpCitemKind();
            prpCitemKind.setPolicyNo(prpCPitemKindDto.getPolicyNo());
            prpCitemKind.setRiskCode(prpCPitemKindDto.getRiskCode());
            prpCitemKind.setItemKindNo(prpCPitemKindDto.getItemKindNo());
            prpCitemKind.setFamilyNo(prpCPitemKindDto.getFamilyNo());
            prpCitemKind.setFamilyName(prpCPitemKindDto.getFamilyName());
            prpCitemKind.setRationType(prpCPitemKindDto.getRationType());
            prpCitemKind.setKindCode(prpCPitemKindDto.getKindCode());
            prpCitemKind.setKindName(prpCPitemKindDto.getKindName());
            prpCitemKind.setItemNo(prpCPitemKindDto.getItemNo());
            prpCitemKind.setItemCode(prpCPitemKindDto.getItemCode());
            prpCitemKind.setItemDetailName(prpCPitemKindDto.getItemDetailName());
            prpCitemKind.setModeCode(prpCPitemKindDto.getModeCode());
            prpCitemKind.setModeName(prpCPitemKindDto.getModeName());
            prpCitemKind.setStartDate(prpCPitemKindDto.getStartDate());
            prpCitemKind.setStartHour(prpCPitemKindDto.getStartHour());
            prpCitemKind.setEndDate(prpCPitemKindDto.getEndDate());
            prpCitemKind.setEndHour(prpCPitemKindDto.getEndHour());
            prpCitemKind.setModel(prpCPitemKindDto.getModel());
            prpCitemKind.setBuyDate(prpCPitemKindDto.getBuyDate());
            prpCitemKind.setAddressNo(prpCPitemKindDto.getAddressNo());
            prpCitemKind.setCalculateFlag(prpCPitemKindDto.getCalculateFlag());
            prpCitemKind.setCurrency(prpCPitemKindDto.getCurrency());
            prpCitemKind.setUnitAmount(prpCPitemKindDto.getUnitAmount());
            prpCitemKind.setQuantity(prpCPitemKindDto.getQuantity());
            prpCitemKind.setUnit(prpCPitemKindDto.getUnit());
            prpCitemKind.setValue(prpCPitemKindDto.getValue());
            prpCitemKind.setAmount(prpCPitemKindDto.getAmount());
            prpCitemKind.setRatePeriod(prpCPitemKindDto.getRatePeriod());
            prpCitemKind.setRate(prpCPitemKindDto.getRate());
            prpCitemKind.setShortRateFlag(prpCPitemKindDto.getShortRateFlag());
            prpCitemKind.setShortRate(prpCPitemKindDto.getShortRate());
            prpCitemKind.setBasePremium(prpCPitemKindDto.getBasePremium());
            prpCitemKind.setBenchmarkPremium(prpCPitemKindDto.getBenchmarkPremium());
            prpCitemKind.setDiscount(prpCPitemKindDto.getDiscount());
            prpCitemKind.setAdjustRate(prpCPitemKindDto.getAdjustRate());
            prpCitemKind.setPremium(prpCPitemKindDto.getPremium());
            prpCitemKind.setDeductibleRate(prpCPitemKindDto.getDeductibleRate());
            prpCitemKind.setDeductible(prpCPitemKindDto.getDeductible());
            prpCitemKind.setFlag(prpCPitemKindDto.getFlag());
            prpCitemKind.setRegionRate(prpCPitemKindDto.getRegionRate());
            prpCitemKind.setDrinkRate(prpCPitemKindDto.getDrinkRate());
            prpCitemKind.setDrunkRate(prpCPitemKindDto.getDrunkRate());
            prpCitemKind.setCattleType(prpCPitemKindDto.getCattleType());
            prpCitemKind.setUnitPersonLimitAmount(prpCPitemKindDto.getUnitPersonLimitAmount());
            prpCitemKind.setUnitPersonAmount(prpCPitemKindDto.getUnitPersonAmount());
            prpCitemKind.setUnitDayAmountSub(prpCPitemKindDto.getUnitDayAmountSub());
            prpCitemKind.setDaySub(prpCPitemKindDto.getDaySub());
            prpCitemKind.setPersonType(prpCPitemKindDto.getPersonType());
            prpCitemKind.setTriggerPoint(prpCPitemKindDto.getTriggerPoint());
            prpCitemKind.setTotalLossRatio(prpCPitemKindDto.getTotalLossRatio());
            prpCitemKind.setLawsuitAmount(prpCPitemKindDto.getLawsuitAmount());
            prpCitemKind.setBedNum(prpCPitemKindDto.getBedNum());
            prpCitemKind.setBedPremium(prpCPitemKindDto.getBedPremium());
            prpCitemKind.setHospitalPremium(prpCPitemKindDto.getHospitalPremium());
            prpCitemKind.setKindWorkerNum(prpCPitemKindDto.getKindWorkerNum());
            prpCitemKind.setKindWorkerPremium(prpCPitemKindDto.getKindWorkerPremium());
            prpCitemKind.setClinicNum(prpCPitemKindDto.getClinicNum());
            prpCitemKind.setClinicPremium(prpCPitemKindDto.getClinicPremium());
            prpCitemKind.setnClinicNum(prpCPitemKindDto.getnClinicNum());
            prpCitemKind.setnClinicPremium(prpCPitemKindDto.getnClinicPremium());
            prpCitemKind.setRoomNum(prpCPitemKindDto.getRoomNum());
            prpCitemKind.setRoomPremium(prpCPitemKindDto.getRoomPremium());
            prpCitemKind.setNurseNum(prpCPitemKindDto.getNurseNum());
            prpCitemKind.setNursePremium(prpCPitemKindDto.getNursePremium());
            prpCitemKind.setWorkerNum(prpCPitemKindDto.getWorkerNum());
            prpCitemKind.setWorkerPremium(prpCPitemKindDto.getWorkerPremium());
            prpCitemKind.setQuantityNewborn(prpCPitemKindDto.getQuantityNewborn());
            prpCitemKind.setChargeNewbornFlag(prpCPitemKindDto.getChargeNewbornFlag());
            prpCitemKind.setUnitPremium(prpCPitemKindDto.getUnitPremium());
            prpCitemKind.setOperationNum(prpCPitemKindDto.getOperationNum());
            prpCitemKind.setOperationPremium(prpCPitemKindDto.getOperationPremium());
            prpCitemKind.setMedicalRate(prpCPitemKindDto.getMedicalRate());
            prpCitemKind.setPostRate(prpCPitemKindDto.getPostRate());

//            prpCitemKind.setBenefitRate(0.0);

            prpCitemKind.setDeductibleValue(prpCPitemKindDto.getDeductibleValue());
            prpCitemKind.setDeductibleDiscount(prpCPitemKindDto.getDeductibleDiscount());
            prpCitemKind.setKindBenchmarkPremiumm(prpCPitemKindDto.getKindBenchmarkPremiumm());
            prpCitemKind.setGuestAmount(prpCPitemKindDto.getGuestAmount());
            prpCitemKind.setDriverAmount(prpCPitemKindDto.getDriverAmount());
            prpCitemKind.setThirdPeopleAmount(prpCPitemKindDto.getThirdPeopleAmount());
            prpCitemKind.setIsSpecGlass(prpCPitemKindDto.getIsSpecGlass());
            prpCitemKind.setClauseCode(prpCPitemKindDto.getClauseCode());

//            prpCitemKind.setCompensationDays("");

//            prpCitemKind.setCurrency2(prpCPitemKindDto.getCurrency2());

//            prpCitemKind.setDeductibleDesc("");

            prpCitemKind.setDeductibleType(prpCPitemKindDto.getDeductibleType());
            prpCitemKind.setDiscountCharge(prpCPitemKindDto.getDiscountCharge());
            prpCitemKind.setEndorType(prpCPitemKindDto.getEndorType());
            prpCitemKind.setExchangeRate2(prpCPitemKindDto.getExchangeRate2());
            prpCitemKind.setExchangeRateCNY(prpCPitemKindDto.getExchangeRateCNY());
            prpCitemKind.setInsuredValueType(prpCPitemKindDto.getInsuredValueType());
            prpCitemKind.setInsuredValueTypeName(prpCPitemKindDto.getInsuredValueTypeName());
            prpCitemKind.setKindPremiumm(prpCPitemKindDto.getKindPremiumm());
            prpCitemKind.setLastPurePremium(prpCPitemKindDto.getLastPurePremium());
            prpCitemKind.setLowerRate(prpCPitemKindDto.getLowerRate());
            prpCitemKind.setManageCharge(prpCPitemKindDto.getManageCharge());
            prpCitemKind.setMotorRate(prpCPitemKindDto.getMotorRate());
            prpCitemKind.setNewEndDate(prpCPitemKindDto.getNewEndDate());
            prpCitemKind.setNewStartDate(prpCPitemKindDto.getNewStartDate());

//            prpCitemKind.setPaymentRate(0.0);

            prpCitemKind.setPremium2(prpCPitemKindDto.getPremium2());
            prpCitemKind.setPremiumCNY(prpCPitemKindDto.getPremiumCNY());
            prpCitemKind.setProductCode(prpCPitemKindDto.getProductCode());
            prpCitemKind.setProfitScale(prpCPitemKindDto.getProfitScale());
            prpCitemKind.setPurePremium(prpCPitemKindDto.getPurePremium());

//            prpCitemKind.setRate1(0.0);

            prpCitemKind.setRateType(prpCPitemKindDto.getRateType());
            prpCitemKind.setRateValidDate(prpCPitemKindDto.getRateValidDate());
            prpCitemKind.setReliefFund(prpCPitemKindDto.getReliefFund());
            prpCitemKind.setReliefFundRate(prpCPitemKindDto.getReliefFundRate());
            prpCitemKind.setReplyNo(prpCPitemKindDto.getReplyNo());
            prpCitemKind.setSpecialCharge(prpCPitemKindDto.getSpecialCharge());
            prpCitemKind.setStabilityFund(prpCPitemKindDto.getStabilityFund());
            prpCitemKind.setStabilityFundRate(prpCPitemKindDto.getStabilityFundRate());
            prpCitemKind.setStorageRate(prpCPitemKindDto.getStorageRate());
            prpCitemKind.setStructureNo(prpCPitemKindDto.getStructureNo());

//            prpCitemKind.setCostPrem(0);

//            prpCitemKind.setCostDiscount(0);

//            prpCitemKind.setRecommenDiscount(0);

//            prpCitemKind.setExpDiscount(0);

//            prpCitemKind.setUwritingDiscount(0);

//            prpCitemKind.setUpdateBy("");

//            prpCitemKind.setUpdateDate(new Date());

            prpCitemKind.setNoTaxPremium(prpCPitemKindDto.getNoTaxPremium());
            prpCitemKind.setTaxFlag(prpCPitemKindDto.getTaxFlag());
            prpCitemKind.setTaxRate(prpCPitemKindDto.getTaxRate());
            prpCitemKind.setTaxFee(prpCPitemKindDto.getTaxFee());
            prpCitemKind.setPremiumCalMethod(prpCPitemKindDto.getPremiumCalMethod());
            prpCitemKind.setForestUse(prpCPitemKindDto.getForestUse());

            prpCitemKindList.add(prpCitemKind);

        }
        List<PrpCitemKind> list=prpCitemKindDao.save(prpCitemKindList);
        if (list.size()==0){
            return false;
        }
        return true;
    }


    /**
     * @description 用cp表更新c表(包含先从c表删除操作 PrpCaddress)
     * @param   prpCPaddressDtoList, policyNo
     * @return boolean
     * @throws Exception
     * @author 王保良
     * @date 2017年10月27日
     */
    @Transactional(rollbackFor = Exception.class)
    public boolean savePrpCaddress(List<PrpCPaddressDto> prpCPaddressDtoList,String policyNo) throws Exception{
        prpCaddressDao.deleteByPolicyNo(policyNo);
        PrpCaddress prpCaddress;
        List<PrpCaddress> prpCaddressList=new ArrayList<PrpCaddress>();
        for (PrpCPaddressDto prpCPaddressDto:prpCPaddressDtoList){
            prpCaddress=new PrpCaddress();
            prpCaddress.setPolicyNo(prpCPaddressDto.getPolicyNo());
            prpCaddress.setRiskCode(prpCPaddressDto.getRiskCode());
            prpCaddress.setAddressNo(prpCPaddressDto.getAddressNo());
            prpCaddress.setAddressCode(prpCPaddressDto.getAddressCode());
            prpCaddress.setAddressName(prpCPaddressDto.getAddressName());
            prpCaddress.setFlag(prpCPaddressDto.getFlag());
            prpCaddress.setProjectName(prpCPaddressDto.getProjectName());
            prpCaddress.setCityCode(prpCPaddressDto.getCityCode());
            prpCaddress.setCityFlag(prpCPaddressDto.getCityFlag());
            prpCaddress.setCityName(prpCPaddressDto.getCityName());
            prpCaddress.setDistrictCode(prpCPaddressDto.getDistrictCode());
            prpCaddress.setDistrictFlag(prpCPaddressDto.getDistrictFlag());
            prpCaddress.setDistrictName(prpCPaddressDto.getDistrictName());
            prpCaddress.setProvinceCode(prpCPaddressDto.getProvinceCode());
            prpCaddress.setProvinceFlag(prpCPaddressDto.getProvinceFlag());
            prpCaddress.setProvinceName(prpCPaddressDto.getProvinceName());
            prpCaddress.setRemark(prpCPaddressDto.getRemark());

            prpCaddressList.add(prpCaddress);
        }
        List<PrpCaddress> list=prpCaddressDao.save(prpCaddressList);
        if (list.size()==0){
            return false;
        }
        return true;
    }
    /**
     * @description 用cp表更新c表(包含先从c表删除操作  PrpCfee)
     * @param
     * @return boolean
     * @throws Exception
     * @author 王保良
     * @date 2017年10月27日
     */
    @Transactional(rollbackFor = Exception.class)
    public boolean savePrpCfee(List<PrpCPfeeDto> prpCPfeeDtoList,String policyNo) throws Exception{
        prpCfeeDao.deleteAllByPolicyNo(policyNo);
        PrpCfee prpCfee;
        List<PrpCfee> prpCfeeList=new ArrayList<>();
        for(PrpCPfeeDto prpCPfeeDto:prpCPfeeDtoList){
            prpCfee=new PrpCfee();
            prpCfee.setPolicyNo(prpCPfeeDto.getPolicyNo());
            prpCfee.setRiskCode(prpCPfeeDto.getRiskCode());
            prpCfee.setCurrency(prpCPfeeDto.getCurrency());
            prpCfee.setAmount(prpCPfeeDto.getAmount());
            prpCfee.setPremium(prpCPfeeDto.getPremium());
            prpCfee.setFlag(prpCPfeeDto.getFlag());
            prpCfee.setCurrency1(prpCPfeeDto.getCurrency1());
            prpCfee.setExchangeRate1(prpCPfeeDto.getExchangeRate1());
            prpCfee.setAmount1(prpCPfeeDto.getAmount1());
            prpCfee.setPremium1(prpCPfeeDto.getPremium1());
            prpCfee.setCurrency2(prpCPfeeDto.getCurrency2());
            prpCfee.setExchangeRate2(prpCPfeeDto.getExchangeRate2());
            prpCfee.setAmount2(prpCPfeeDto.getAmount2());
            prpCfee.setPremium2(prpCPfeeDto.getPremium2());
            prpCfee.setNoTaxPremium(prpCPfeeDto.getNoTaxPremium());
            prpCfee.setTaxFee(prpCPfeeDto.getTaxFee());
            prpCfee.setNoTaxPremium1(prpCPfeeDto.getNoTaxPremium1());
            prpCfee.setTaxFee1(prpCPfeeDto.getTaxFee1());
            prpCfee.setNoTaxPremium2(prpCPfeeDto.getNoTaxPremium2());
            prpCfee.setTaxFee2(prpCPfeeDto.getTaxFee2());
            prpCfeeList.add(prpCfee);
        }


        List<PrpCfee> list=prpCfeeDao.save(prpCfeeList);
        if (list.size()==0){
            return false;
        }

        return true;
    }

    /**
     * @description 用cp表更新c表(包含先从c表删除操作 PrpCplan)
     * @param   prpCPplanDtoList, policyNo
     * @return boolean
     * @throws Exception
     * @author 王保良
     * @date 2017年10月27日
     */
    @Transactional
    public boolean savePrpCplan(List<PrpCPplanDto> prpCPplanDtoList, String policyNo) throws  Exception{
        prpCplanDao.deleteByPolicyNo(policyNo);
        PrpCplan prpCplan;
        List<PrpCplan> prpCplanList=new ArrayList<PrpCplan>();
        for (PrpCPplanDto prpCPplanDto : prpCPplanDtoList){
            prpCplan=new PrpCplan();
            prpCplan.setPolicyNo(prpCPplanDto.getPolicyNo());
            prpCplan.setEndorseNo(prpCPplanDto.getEndorseNo());
            prpCplan.setSerialNo(prpCPplanDto.getSerialNo());
            prpCplan.setPayNo(prpCPplanDto.getPayNo());
            prpCplan.setPayReason(prpCPplanDto.getPayReason());
            prpCplan.setPlanDate(prpCPplanDto.getPlanDate());
            prpCplan.setCurrency(prpCPplanDto.getCurrency());
            prpCplan.setPlanFee(prpCPplanDto.getPlanFee());
            prpCplan.setDelinquentFee(prpCPplanDto.getDelinquentFee());
            prpCplan.setFlag(prpCPplanDto.getFlag());
            prpCplan.setPlanStartDate(prpCPplanDto.getPlanStartDate());
            prpCplan.setPlanRate(prpCPplanDto.getPlanRate());
            prpCplan.setCurrency2(prpCPplanDto.getCurrency2());
            prpCplan.setPlanFee2(prpCPplanDto.getPlanFee2());
            prpCplan.setExchangeRateCNY(prpCPplanDto.getExchangeRateCNY());

//            prpCplan.setUpdateBy("");

//            prpCplan.setUpdateDate(new Date());

            prpCplan.setNoTaxPremium(prpCPplanDto.getNoTaxPremium());
            prpCplan.setTaxFee(prpCPplanDto.getTaxFee());

            prpCplanList.add(prpCplan);
        }
        List<PrpCplan> list=prpCplanDao.save(prpCplanList);
        if (list.size()==0){
            return false;
        }
        return true;
    }

    /**
     * @description 用cp表更新c表(PrpCmainAgri)
     * @param  prpCPmainAgriDto
     * @return boolean
     * @throws Exception
     * @author 王保良
     * @date 2017年10月27日
     */
    @Transactional(rollbackFor = Exception.class)
    public boolean savePrpCmainAgri(PrpCPmainAgriDto prpCPmainAgriDto) throws Exception{
        PrpCmainAgri prpCmainAgri=new PrpCmainAgri();

        prpCmainAgri.setPolicyNo(prpCPmainAgriDto.getPolicyNo());
        prpCmainAgri.setRiskCode(prpCPmainAgriDto.getRiskCode());
        prpCmainAgri.setRaiseDate(prpCPmainAgriDto.getRaiseDate());
        prpCmainAgri.setRaiseSite(prpCPmainAgriDto.getRaiseSite());
        prpCmainAgri.setInsureArea(prpCPmainAgriDto.getInsureArea());
        prpCmainAgri.setRemark(prpCPmainAgriDto.getRemark());
        prpCmainAgri.setFlag(prpCPmainAgriDto.getFlag());
        prpCmainAgri.setObservePeriod(prpCPmainAgriDto.getObservePeriod());
        prpCmainAgri.setObserveStartDate(prpCPmainAgriDto.getObserveStartDate());
        prpCmainAgri.setObserveStartHour(prpCPmainAgriDto.getObserveStartHour());
        prpCmainAgri.setObserveEndDate(prpCPmainAgriDto.getObserveEndDate());
        prpCmainAgri.setObserveEndHour(prpCPmainAgriDto.getObserveEndHour());
        prpCmainAgri.setValueRate(prpCPmainAgriDto.getValueRate());
        prpCmainAgri.setSelfPremium(prpCPmainAgriDto.getSelfPremium());
        prpCmainAgri.setDeptName(prpCPmainAgriDto.getDeptName());
        prpCmainAgri.setDeptAddress(prpCPmainAgriDto.getDeptAddress());
        prpCmainAgri.setAreaFlag(prpCPmainAgriDto.getAreaFlag());
        prpCmainAgri.setRaiseType(prpCPmainAgriDto.getRaiseType());
        prpCmainAgri.setRelationListNo(prpCPmainAgriDto.getRelationListNo());
        prpCmainAgri.setRelationListNoRemark(prpCPmainAgriDto.getRelationListNoRemark());
        prpCmainAgri.setCirculationCode(prpCPmainAgriDto.getCirculationCode());
        prpCmainAgri.setReclamationArea(prpCPmainAgriDto.getReclamationArea());
        prpCmainAgri.setCirculationArea(prpCPmainAgriDto.getCirculationArea());

        PrpCmainAgri prpCmainAgri1=prpCmainAgriDao.save(prpCmainAgri);
        if (prpCmainAgri1==null){
            return false;
        }
        return true;

    }

}





































