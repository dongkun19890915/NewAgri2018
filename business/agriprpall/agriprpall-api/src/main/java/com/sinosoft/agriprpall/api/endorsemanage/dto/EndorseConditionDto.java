package com.sinosoft.agriprpall.api.endorsemanage.dto;

import com.sinosoft.framework.dto.BaseRequest;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class EndorseConditionDto extends BaseRequest implements Serializable {
    private static final long serialVersionUID = 1L;

    /**批改类型 */
   private String endoretype;
    private Date endorDate; //批改日期
    private Date validDate; //批改生效日期
    /**保单头批改标志 */
    private String mainHeadFlag;

    private String endorseOption;
    /**扶贫标志 */
    private String hpFlag;
    /**保险区间批改标志 */
    private String periodFlag;
    /**投保人批改标志 */
    private String[] arrInsuredFlag;
    /**主险标志 */
    private String[] arrItemKindMainFlag;
    /**大棚蔬菜专用修改标志*/
    private String[] arrForUpdateFlag;
    /**主保单信息批改标识 */
    private String   tailFlag;
    /**增加耳标号批改标识 */
    private String[] itemKindFlag;
    /**地址批改标识 */
    private String arrAddressFlag;
    /**特约及附加信息批改标志 */
    private String[] arrEngageFlag;
    /**保单印刷号 核保通过后自动销号 */
    private String printNoFlag;
    //险种3119的附加险条款一单独做批改
    private String itemKindSubDriver1Flag;
    private String itemKindSubDriver2Flag;
    /**农险附表信息批改标识 */
    private String mainAgriFlag;
    /**补贴信息批改标识 */
    private String[] arrSubsidyFlag;
    /**投保人批改标识 */
    private String appliInsuredFlag;
    /**业务类型 自营/分入 */
    private String businessFlag;
    /**共保标识 */
    private String coinsFlag;
    /**登录用户的机构代码 */
    private String userComCode;
    /**录入方式(非大客户团单/大客户团单) */
    private String messType;
    /**被保人代码 */
    private String[] insuredInsuredCode;
    /**被保人名称 */
    private String[] insuredInsuredName;
    /**被保人地址 */
    private String[] insuredInsuredAddress;
    /**被续保单号 */
    private String oldPolicyNoRenewal;
    /**股东名称 */
    private String shareHolderName;
    /**业务大类 */
    private String[] businessCategory;

    private String loginComCode;

    private String[] subsidyCode;

    /** 机构代码用于生成批次号*/
    private String comCode;

    /** 批次号用于给所涉及的批单赋值 */
    private String batchNo;

    public String getBatchNo() {
        return batchNo;
    }

    public void setBatchNo(String batchNo) {
        this.batchNo = batchNo;
    }

    public String getComCode() {
        return comCode;
    }

    public void setComCode(String comCode) {
        this.comCode = comCode;
    }

    /**
     * add by 王心洋 2017-11-07
     */
    private String   plantingFarmerListFlag;//中央政策险
    private String   nyxSingleFarmerListFlag;
    private String   nyxMultipleFarmerListFlag;
    private String   endorseTypeEndDate;

    private String   inusreListCode;
    private String   insuranceCode;
    private String   agriStartDate;
    private String   agriEndDate;
    private String   breedingFarmerFlag;
    private String   benMarkPremiumMainEqualFlag;
    private String   vChgUnitPremium;
    private String   familyNos;
    private String[] itemKindNoMain;
    private String[] familyNoMain;
    private String[] kindCodeMain;
    private String[] kindNameMain;
    private String[] startDateMain;
    private String[] endDateMain;
    private String[] currencyMain;
    private String[] shortRateFlagMain;
    private String[] premiumCalMethodMain;
    private String[] forestUseMain;
    private String[] shortRateMain;
    private String[] itemCodeMain;
    private String[] itemDetailNameMain;
    private String[] prpItemKindAddressNoMain;
    private String[] modeCodeMain;
    private String[] modeNameMain;
    private String[] modelMain;
    private String[] calculateFlagMain;//记入总保额标志
    private String[] unitAmountMain;
    private String[] quantityMain;
    private String[] unitMain;
    private String[] amountMain;
    private String[] rateMain;
    private String[] adjustRateMain;    //农险用于无赔款优待处理
    private String[] premiumMain;
    private String[] itemKindMain_Flag;
    private String[] benMarkPremiumMain;//标准保费
    private String[] disCountMain;//投保比例
    private String[] cattleType;//3221肉牛类型
    private String[] deductibleRateMain;//中央政策性农险的每次事故免赔率
    private String[] triggerPoint;//中央政策性农险的起赔点
    private String[] totalLossRatio;//中央政策性农险的全损损失率
    private String[] equalFlagMain;//中央政策性农险分户计算短期费率标志
    private String[] medicalRateMain;//风险调整系数3229用
    private String[] itemKindNoSub;
    private String[] startDateSub;
    private String[] endDateSub;
    private String[] currencySub;
    private String[] shortRateFlagSub;
    private String[] premiumCalMethodSub;
    private String[] forestUseSub;
    private String[] deductibleRateSub;
    private String[] triggerPointSub;
    private String[] totalLossRatioSub;
    private String[] shortRateSub;
    private String[] modeCodeSub;
    private String[] modeNameSub;
    private String[] modelSub;
    private String[] calculateFlagSub;//记入总保额标志
    private String[] kindCodeSub;
    private String[] kindNameSub;
    private String[] itemCodeSub;
    private String[] unitAmountSub;
    private String[] quantitySub;
    private String[] itemDetailNameSub;
    private String[] prpItemKindAddressNoSub;
    private String[] amountSub;
    private String[] rateSub;
    private String[] premiumSub;
    private String[] itemKindSub_Flag;
    private String[] benMarkPremiumSub;//标准保费
    private String[] disCountSub;//投保比例
    private String[] familyNoSub;
    private String[] equalFlagSub;//中央政策性农险分户计算短期费率标志
    private String[] serialNoSubEngage;
    private String[] itemKindSub_Context;
    private String[] itemKindSubEngage_Flag;
    private String[] agriUnitOutputMain;//单位产量
    private String[] agriUnitCostMain;   //单位成本
    private String[] agriProportionMain;
    private String[] disCountMainType;//折扣
    private String[] agriDepreciationRateMain;//折旧率
    private String[] agriUnitAmountMain;//单位保险金额
    private String[] agriGrossQuantityMain;//种养总量
    private String[] agriInsureAreaMain;//每株烟草有效叶片基数
    private String[] agriStyleMain;//桑蚕张种规格
    private String[] agriTimesAmountMain;//中央政策性种植险借助本字段存放约定单价
    private String[] agriUnitOutputSub;//单位产量
    private String[] agriUnitCostSub;   //单位成本
    private String[] agriProportionSub;//折扣
    private String[] agriDepreciationRateSub;//折旧率
    private String[] disCountSubType;
    private String[] agriUnitAmountSub;//单位保险金额
    private String[] agriGrossQuantitySub;//种养总量
    private String[] agriInsureAreaSub;//每株烟草有效叶片基数
    private String[] subsidyRate;
    private String[] unitPremiumMain;

//add by 王心洋 2017-11-14  begin
    //特殊批改处理传入参数
    private String shortRateFlag; //短期费率方式
    private String endorType;//批改类型
    private String iRate;//退保手续费比例
    private String breedingFarmerListFlag;
    //变更保险期限（01）
    private String startDate;//起保日期
    private String startHour;
    private String endDate;
    private String endHour;//终保日期
    //批改手续费（57）
    private String editTypeCommission;
    private String currency;
    private String disRate;
    private String changeDisFee;
    private String changeTaxDisFee;//手续费变化量金额
    private String taxDisFee;//手续费总金额
    private String editTypeManageFeeRate;
    private String manageFeeRate;
    //业务员批改(85)
    private String handlerCode;
    private String handler1Code;


    public String getHandlerCode() {
        return handlerCode;
    }

    public void setHandlerCode(String handlerCode) {
        this.handlerCode = handlerCode;
    }

    public String getHandler1Code() {
        return handler1Code;
    }

    public void setHandler1Code(String handler1Code) {
        this.handler1Code = handler1Code;
    }

    //add by 李冬松 2017-11-28
    private String[] coins_Flag;
    private String[] serialNoCoins;
    private String[] sameToPolicyNo;
    private String[] MainPolicyNo;
    private String[] coinsType;
    private String[] chiefType;
    private String[] coinsCode;
    private String[] coinsName;
    private String[] coinsRate;
    private String[] flagDetail;
    private String[] serialNoDetail;
    private String[] coinsCodeDetail;
    private String[] coinsNameDetail;
    private String[] currencyDetail;
    private String[] coinsAmount;
    private String[] coinsPremium;
    private String[] agentFee;
    private String[] middleCostFee;

    private String[] CoinsPlan_Flag;
    private String[] CoinsEndorseNoCplan;
    private String[] CoinsPayNo;
    private String[] CoinsCodePlan;
    private String[] CoinsPayReason;
    private String[] CoinsPlanStartDate;
    private String[] CoinsPlanDate;
    private String[] CoinsPrpPlanCurrency;
    private String[] CoinsPlanRate;
    private String[] CoinsPlanFee;
    private String[] CoinsDelinquentFee;

    private String[] CoinsGovPlan_Flag;
    private String[] CoinsGovEndorseNoCplan;
    private String[] CoinsGovPayNo;
    private String[] CoinsGovCodePlan;
    private String[] CoinsGovPayReason;
    private String[] CoinsGovPlanStartDate;
    private String[] CoinsGovPlanDate;
    private String[] CoinsGovPrpPlanCurrency;
    private String[] CoinsGovPlanRate;
    private String[] CoinsGovPlanFee;
    private String[] CoinsGovDelinquentFee;
    private String validHour;

    /**
     * 调整补贴信息批改
     */
    private List<String> subsidyCodeList;
    private List<String> subsidyTypeList;
    private List<Double> subsidyRateList;
    private List<Double> subsidyPremium;


    /*批单保存前，批文修改的最新数据  李冬松*/
    private String strText;
    private String endorseReason;


    private String userCode;

    private String loginGradeCode;
    private String operatorCode;

    private String remark;

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getEndorseReason() {
        return endorseReason;
    }

    public void setEndorseReason(String endorseReason) {
        this.endorseReason = endorseReason;
    }

    public String getOperatorCode() {
        return operatorCode;
    }

    public void setOperatorCode(String operatorCode) {
        this.operatorCode = operatorCode;
    }

    public String getLoginGradeCode() {
        return loginGradeCode;
    }

    public void setLoginGradeCode(String loginGradeCode) {
        this.loginGradeCode = loginGradeCode;
    }

    public String getUserCode() {
        return userCode;
    }

    public void setUserCode(String userCode) {
        this.userCode = userCode;
    }

    public Date getValidDate() {
        return validDate;
    }

    public void setValidDate(Date validDate) {
        this.validDate = validDate;
    }

    public Date getEndorDate() {
        return endorDate;
    }

    public void setEndorDate(Date endorDate) {
        this.endorDate = endorDate;
    }

    public String getStrText() {
        return strText;
    }

    public void setStrText(String strText) {
        this.strText = strText;
    }

    public List<Double> getSubsidyPremium() {
        return subsidyPremium;
    }

    public void setSubsidyPremium(List<Double> subsidyPremium) {
        this.subsidyPremium = subsidyPremium;
    }

    public List<String> getSubsidyCodeList() {
        return subsidyCodeList;
    }

    public void setSubsidyCodeList(List<String> subsidyCodeList) {
        this.subsidyCodeList = subsidyCodeList;
    }

    public List<String> getSubsidyTypeList() {
        return subsidyTypeList;
    }

    public void setSubsidyTypeList(List<String> subsidyTypeList) {
        this.subsidyTypeList = subsidyTypeList;
    }

    public List<Double> getSubsidyRateList() {
        return subsidyRateList;
    }

    public void setSubsidyRateList(List<Double> subsidyRateList) {
        this.subsidyRateList = subsidyRateList;
    }

    public String getValidHour() {
        return validHour;
    }

    public void setValidHour(String validHour) {
        this.validHour = validHour;
    }

    public String getCoinsFlag() {
        return coinsFlag;
    }

    public String[] getCoins_Flag() {
        return coins_Flag;
    }

    public void setCoins_Flag(String[] coins_Flag) {
        this.coins_Flag = coins_Flag;
    }

    public String[] getSerialNoCoins() {
        return serialNoCoins;
    }

    public void setSerialNoCoins(String[] serialNoCoins) {
        this.serialNoCoins = serialNoCoins;
    }

    public String getEditTypeCommission() {
        return editTypeCommission;
    }

    public void setEditTypeCommission(String editTypeCommission) {
        this.editTypeCommission = editTypeCommission;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getDisRate() {
        return disRate;
    }

    public void setDisRate(String disRate) {
        this.disRate = disRate;
    }

    public String getChangeDisFee() {
        return changeDisFee;
    }

    public void setChangeDisFee(String changeDisFee) {
        this.changeDisFee = changeDisFee;
    }

    public String getChangeTaxDisFee() {
        return changeTaxDisFee;
    }

    public void setChangeTaxDisFee(String changeTaxDisFee) {
        this.changeTaxDisFee = changeTaxDisFee;
    }

    public String getTaxDisFee() {
        return taxDisFee;
    }

    public void setTaxDisFee(String taxDisFee) {
        this.taxDisFee = taxDisFee;
    }

    public String getEditTypeManageFeeRate() {
        return editTypeManageFeeRate;
    }

    public void setEditTypeManageFeeRate(String editTypeManageFeeRate) {
        this.editTypeManageFeeRate = editTypeManageFeeRate;
    }


    public String getManageFeeRate() {
        return manageFeeRate;
    }

    public void setManageFeeRate(String manageFeeRate) {
        this.manageFeeRate = manageFeeRate;
    }

    public String[] getSameToPolicyNo() {
        return sameToPolicyNo;
    }

    public void setSameToPolicyNo(String[] sameToPolicyNo) {
        this.sameToPolicyNo = sameToPolicyNo;
    }

    public String[] getMainPolicyNo() {
        return MainPolicyNo;
    }

    public void setMainPolicyNo(String[] mainPolicyNo) {
        MainPolicyNo = mainPolicyNo;
    }

    public String[] getCoinsType() {
        return coinsType;
    }

    public void setCoinsType(String[] coinsType) {
        this.coinsType = coinsType;
    }

    public String[] getChiefType() {
        return chiefType;
    }

    public void setChiefType(String[] chiefType) {
        this.chiefType = chiefType;
    }

    public String[] getCoinsCode() {
        return coinsCode;
    }

    public void setCoinsCode(String[] coinsCode) {
        this.coinsCode = coinsCode;
    }

    public String[] getCoinsName() {
        return coinsName;
    }

    public void setCoinsName(String[] coinsName) {
        this.coinsName = coinsName;
    }

    public String[] getCoinsRate() {
        return coinsRate;
    }

    public void setCoinsRate(String[] coinsRate) {
        this.coinsRate = coinsRate;
    }


    public String[] getFlagDetail() {
        return flagDetail;
    }

    public void setFlagDetail(String[] flagDetail) {
        this.flagDetail = flagDetail;
    }

    public String[] getSerialNoDetail() {
        return serialNoDetail;
    }

    public void setSerialNoDetail(String[] serialNoDetail) {
        this.serialNoDetail = serialNoDetail;
    }

    public String[] getCoinsCodeDetail() {
        return coinsCodeDetail;
    }

    public void setCoinsCodeDetail(String[] coinsCodeDetail) {
        this.coinsCodeDetail = coinsCodeDetail;
    }

    public String[] getCoinsNameDetail() {
        return coinsNameDetail;
    }

    public void setCoinsNameDetail(String[] coinsNameDetail) {
        this.coinsNameDetail = coinsNameDetail;
    }

    public String[] getCurrencyDetail() {
        return currencyDetail;
    }

    public void setCurrencyDetail(String[] currencyDetail) {
        this.currencyDetail = currencyDetail;
    }

    public String[] getCoinsAmount() {
        return coinsAmount;
    }

    public void setCoinsAmount(String[] coinsAmount) {
        this.coinsAmount = coinsAmount;
    }

    public String[] getCoinsPremium() {
        return coinsPremium;
    }

    public void setCoinsPremium(String[] coinsPremium) {
        this.coinsPremium = coinsPremium;
    }

    public String[] getAgentFee() {
        return agentFee;
    }

    public void setAgentFee(String[] agentFee) {
        this.agentFee = agentFee;
    }

    public String[] getMiddleCostFee() {
        return middleCostFee;
    }

    public void setMiddleCostFee(String[] middleCostFee) {
        this.middleCostFee = middleCostFee;
    }

    public String[] getCoinsPlan_Flag() {
        return CoinsPlan_Flag;
    }

    public void setCoinsPlan_Flag(String[] coinsPlan_Flag) {
        CoinsPlan_Flag = coinsPlan_Flag;
    }

    public String[] getCoinsEndorseNoCplan() {
        return CoinsEndorseNoCplan;
    }

    public void setCoinsEndorseNoCplan(String[] coinsEndorseNoCplan) {
        CoinsEndorseNoCplan = coinsEndorseNoCplan;
    }

    public String[] getCoinsPayNo() {
        return CoinsPayNo;
    }

    public void setCoinsPayNo(String[] coinsPayNo) {
        CoinsPayNo = coinsPayNo;
    }

    public String[] getCoinsCodePlan() {
        return CoinsCodePlan;
    }

    public void setCoinsCodePlan(String[] coinsCodePlan) {
        CoinsCodePlan = coinsCodePlan;
    }

    public String[] getCoinsPayReason() {
        return CoinsPayReason;
    }

    public void setCoinsPayReason(String[] coinsPayReason) {
        CoinsPayReason = coinsPayReason;
    }

    public String[] getCoinsPlanStartDate() {
        return CoinsPlanStartDate;
    }

    public void setCoinsPlanStartDate(String[] coinsPlanStartDate) {
        CoinsPlanStartDate = coinsPlanStartDate;
    }

    public String[] getCoinsPlanDate() {
        return CoinsPlanDate;
    }

    public void setCoinsPlanDate(String[] coinsPlanDate) {
        CoinsPlanDate = coinsPlanDate;
    }

    public String[] getCoinsPrpPlanCurrency() {
        return CoinsPrpPlanCurrency;
    }

    public void setCoinsPrpPlanCurrency(String[] coinsPrpPlanCurrency) {
        CoinsPrpPlanCurrency = coinsPrpPlanCurrency;
    }

    public String[] getCoinsPlanRate() {
        return CoinsPlanRate;
    }

    public void setCoinsPlanRate(String[] coinsPlanRate) {
        CoinsPlanRate = coinsPlanRate;
    }

    public String[] getCoinsPlanFee() {
        return CoinsPlanFee;
    }

    public void setCoinsPlanFee(String[] coinsPlanFee) {
        CoinsPlanFee = coinsPlanFee;
    }

    public String[] getCoinsDelinquentFee() {
        return CoinsDelinquentFee;
    }

    public void setCoinsDelinquentFee(String[] coinsDelinquentFee) {
        CoinsDelinquentFee = coinsDelinquentFee;
    }

    public String[] getCoinsGovPlan_Flag() {
        return CoinsGovPlan_Flag;
    }

    public void setCoinsGovPlan_Flag(String[] coinsGovPlan_Flag) {
        CoinsGovPlan_Flag = coinsGovPlan_Flag;
    }

    public String[] getCoinsGovEndorseNoCplan() {
        return CoinsGovEndorseNoCplan;
    }

    public void setCoinsGovEndorseNoCplan(String[] coinsGovEndorseNoCplan) {
        CoinsGovEndorseNoCplan = coinsGovEndorseNoCplan;
    }

    public String[] getCoinsGovPayNo() {
        return CoinsGovPayNo;
    }

    public void setCoinsGovPayNo(String[] coinsGovPayNo) {
        CoinsGovPayNo = coinsGovPayNo;
    }

    public String[] getCoinsGovCodePlan() {
        return CoinsGovCodePlan;
    }

    public void setCoinsGovCodePlan(String[] coinsGovCodePlan) {
        CoinsGovCodePlan = coinsGovCodePlan;
    }

    public String[] getCoinsGovPayReason() {
        return CoinsGovPayReason;
    }

    public void setCoinsGovPayReason(String[] coinsGovPayReason) {
        CoinsGovPayReason = coinsGovPayReason;
    }

    public String[] getCoinsGovPlanStartDate() {
        return CoinsGovPlanStartDate;
    }

    public void setCoinsGovPlanStartDate(String[] coinsGovPlanStartDate) {
        CoinsGovPlanStartDate = coinsGovPlanStartDate;
    }

    public String[] getCoinsGovPlanDate() {
        return CoinsGovPlanDate;
    }

    public void setCoinsGovPlanDate(String[] coinsGovPlanDate) {
        CoinsGovPlanDate = coinsGovPlanDate;
    }

    public String[] getCoinsGovPrpPlanCurrency() {
        return CoinsGovPrpPlanCurrency;
    }

    public void setCoinsGovPrpPlanCurrency(String[] coinsGovPrpPlanCurrency) {
        CoinsGovPrpPlanCurrency = coinsGovPrpPlanCurrency;
    }

    public String[] getCoinsGovPlanRate() {
        return CoinsGovPlanRate;
    }

    public void setCoinsGovPlanRate(String[] coinsGovPlanRate) {
        CoinsGovPlanRate = coinsGovPlanRate;
    }

    public String[] getCoinsGovPlanFee() {
        return CoinsGovPlanFee;
    }

    public void setCoinsGovPlanFee(String[] coinsGovPlanFee) {
        CoinsGovPlanFee = coinsGovPlanFee;
    }

    public String[] getCoinsGovDelinquentFee() {
        return CoinsGovDelinquentFee;
    }

    public void setCoinsGovDelinquentFee(String[] coinsGovDelinquentFee) {
        CoinsGovDelinquentFee = coinsGovDelinquentFee;
    }

    public String getLoginComCode() {
        return loginComCode;
    }

    public void setLoginComCode(String loginComCode) {
        this.loginComCode = loginComCode;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getStartHour() {
        return startHour;
    }

    public void setStartHour(String startHour) {
        this.startHour = startHour;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public String getEndHour() {
        return endHour;
    }

    public void setEndHour(String endHour) {
        this.endHour = endHour;
    }

    public String getBreedingFarmerListFlag() {
        return breedingFarmerListFlag;
    }

    public void setBreedingFarmerListFlag(String breedingFarmerListFlag) {
        this.breedingFarmerListFlag = breedingFarmerListFlag;
    }

    public String getShortRateFlag() {
        return shortRateFlag;
    }

    public void setShortRateFlag(String shortRateFlag) {
        this.shortRateFlag = shortRateFlag;
    }

    public String getEndorType() {
        return endorType;
    }

    public void setEndorType(String endorType) {
        this.endorType = endorType;
    }

    public String getiRate() {
        return iRate;
    }

    public void setiRate(String iRate) {
        this.iRate = iRate;
    }

    public String getPlantingFarmerListFlag() {
        return plantingFarmerListFlag;
    }

    public void setPlantingFarmerListFlag(String plantingFarmerListFlag) {
        this.plantingFarmerListFlag = plantingFarmerListFlag;
    }

    public String getNyxSingleFarmerListFlag() {
        return nyxSingleFarmerListFlag;
    }

    public void setNyxSingleFarmerListFlag(String nyxSingleFarmerListFlag) {
        this.nyxSingleFarmerListFlag = nyxSingleFarmerListFlag;
    }

    public String getNyxMultipleFarmerListFlag() {
        return nyxMultipleFarmerListFlag;
    }

    public void setNyxMultipleFarmerListFlag(String nyxMultipleFarmerListFlag) {
        this.nyxMultipleFarmerListFlag = nyxMultipleFarmerListFlag;
    }

    public String getEndorseTypeEndDate() {
        return endorseTypeEndDate;
    }

    public void setEndorseTypeEndDate(String endorseTypeEndDate) {
        this.endorseTypeEndDate = endorseTypeEndDate;
    }

    public String getFamilyNos() {
        return familyNos;
    }

    public void setFamilyNos(String familyNos) {
        this.familyNos = familyNos;
    }

    public String getInusreListCode() {
        return inusreListCode;
    }

    public void setInusreListCode(String inusreListCode) {
        this.inusreListCode = inusreListCode;
    }

    public String getInsuranceCode() {
        return insuranceCode;
    }

    public void setInsuranceCode(String insuranceCode) {
        this.insuranceCode = insuranceCode;
    }

    public String getAgriStartDate() {
        return agriStartDate;
    }

    public void setAgriStartDate(String agriStartDate) {
        this.agriStartDate = agriStartDate;
    }

    public String getAgriEndDate() {
        return agriEndDate;
    }

    public void setAgriEndDate(String agriEndDate) {
        this.agriEndDate = agriEndDate;
    }

    public String getBreedingFarmerFlag() {
        return breedingFarmerFlag;
    }

    public void setBreedingFarmerFlag(String breedingFarmerFlag) {
        this.breedingFarmerFlag = breedingFarmerFlag;
    }

    public String getBenMarkPremiumMainEqualFlag() {
        return benMarkPremiumMainEqualFlag;
    }

    public void setBenMarkPremiumMainEqualFlag(String benMarkPremiumMainEqualFlag) {
        this.benMarkPremiumMainEqualFlag = benMarkPremiumMainEqualFlag;
    }

    public String getvChgUnitPremium() {
        return vChgUnitPremium;
    }

    public void setvChgUnitPremium(String vChgUnitPremium) {
        this.vChgUnitPremium = vChgUnitPremium;
    }

    public String[] getUnitPremiumMain() {
        return unitPremiumMain;
    }

    public void setUnitPremiumMain(String[] unitPremiumMain) {
        this.unitPremiumMain = unitPremiumMain;
    }

    public String[] getItemKindNoMain() {
        return itemKindNoMain;
    }

    public void setItemKindNoMain(String[] itemKindNoMain) {
        this.itemKindNoMain = itemKindNoMain;
    }

    public String[] getFamilyNoMain() {
        return familyNoMain;
    }

    public void setFamilyNoMain(String[] familyNoMain) {
        this.familyNoMain = familyNoMain;
    }

    public String[] getKindCodeMain() {
        return kindCodeMain;
    }

    public void setKindCodeMain(String[] kindCodeMain) {
        this.kindCodeMain = kindCodeMain;
    }

    public String[] getKindNameMain() {
        return kindNameMain;
    }

    public void setKindNameMain(String[] kindNameMain) {
        this.kindNameMain = kindNameMain;
    }

    public String[] getStartDateMain() {
        return startDateMain;
    }

    public void setStartDateMain(String[] startDateMain) {
        this.startDateMain = startDateMain;
    }

    public String[] getEndDateMain() {
        return endDateMain;
    }

    public void setEndDateMain(String[] endDateMain) {
        this.endDateMain = endDateMain;
    }

    public String[] getCurrencyMain() {
        return currencyMain;
    }

    public void setCurrencyMain(String[] currencyMain) {
        this.currencyMain = currencyMain;
    }

    public String[] getShortRateFlagMain() {
        return shortRateFlagMain;
    }

    public void setShortRateFlagMain(String[] shortRateFlagMain) {
        this.shortRateFlagMain = shortRateFlagMain;
    }

    public String[] getPremiumCalMethodMain() {
        return premiumCalMethodMain;
    }

    public void setPremiumCalMethodMain(String[] premiumCalMethodMain) {
        this.premiumCalMethodMain = premiumCalMethodMain;
    }

    public String[] getForestUseMain() {
        return forestUseMain;
    }

    public void setForestUseMain(String[] forestUseMain) {
        this.forestUseMain = forestUseMain;
    }

    public String[] getShortRateMain() {
        return shortRateMain;
    }

    public void setShortRateMain(String[] shortRateMain) {
        this.shortRateMain = shortRateMain;
    }

    public String[] getItemCodeMain() {
        return itemCodeMain;
    }

    public void setItemCodeMain(String[] itemCodeMain) {
        this.itemCodeMain = itemCodeMain;
    }

    public String[] getItemDetailNameMain() {
        return itemDetailNameMain;
    }

    public void setItemDetailNameMain(String[] itemDetailNameMain) {
        this.itemDetailNameMain = itemDetailNameMain;
    }

    public String[] getPrpItemKindAddressNoMain() {
        return prpItemKindAddressNoMain;
    }

    public void setPrpItemKindAddressNoMain(String[] prpItemKindAddressNoMain) {
        this.prpItemKindAddressNoMain = prpItemKindAddressNoMain;
    }

    public String[] getModeCodeMain() {
        return modeCodeMain;
    }

    public void setModeCodeMain(String[] modeCodeMain) {
        this.modeCodeMain = modeCodeMain;
    }

    public String[] getModeNameMain() {
        return modeNameMain;
    }

    public void setModeNameMain(String[] modeNameMain) {
        this.modeNameMain = modeNameMain;
    }

    public String[] getModelMain() {
        return modelMain;
    }

    public void setModelMain(String[] modelMain) {
        this.modelMain = modelMain;
    }

    public String[] getCalculateFlagMain() {
        return calculateFlagMain;
    }

    public void setCalculateFlagMain(String[] calculateFlagMain) {
        this.calculateFlagMain = calculateFlagMain;
    }

    public String[] getUnitAmountMain() {
        return unitAmountMain;
    }

    public void setUnitAmountMain(String[] unitAmountMain) {
        this.unitAmountMain = unitAmountMain;
    }

    public String[] getQuantityMain() {
        return quantityMain;
    }

    public void setQuantityMain(String[] quantityMain) {
        this.quantityMain = quantityMain;
    }

    public String[] getUnitMain() {
        return unitMain;
    }

    public void setUnitMain(String[] unitMain) {
        this.unitMain = unitMain;
    }

    public String[] getAmountMain() {
        return amountMain;
    }

    public void setAmountMain(String[] amountMain) {
        this.amountMain = amountMain;
    }

    public String[] getRateMain() {
        return rateMain;
    }

    public void setRateMain(String[] rateMain) {
        this.rateMain = rateMain;
    }

    public String[] getAdjustRateMain() {
        return adjustRateMain;
    }

    public void setAdjustRateMain(String[] adjustRateMain) {
        this.adjustRateMain = adjustRateMain;
    }

    public String[] getPremiumMain() {
        return premiumMain;
    }

    public void setPremiumMain(String[] premiumMain) {
        this.premiumMain = premiumMain;
    }

    public String[] getItemKindMain_Flag() {
        return itemKindMain_Flag;
    }

    public void setItemKindMain_Flag(String[] itemKindMain_Flag) {
        this.itemKindMain_Flag = itemKindMain_Flag;
    }

    public String[] getBenMarkPremiumMain() {
        return benMarkPremiumMain;
    }

    public void setBenMarkPremiumMain(String[] benMarkPremiumMain) {
        this.benMarkPremiumMain = benMarkPremiumMain;
    }

    public String[] getDisCountMain() {
        return disCountMain;
    }

    public void setDisCountMain(String[] disCountMain) {
        this.disCountMain = disCountMain;
    }

    public String[] getCattleType() {
        return cattleType;
    }

    public void setCattleType(String[] cattleType) {
        this.cattleType = cattleType;
    }

    public String[] getDeductibleRateMain() {
        return deductibleRateMain;
    }

    public void setDeductibleRateMain(String[] deductibleRateMain) {
        this.deductibleRateMain = deductibleRateMain;
    }

    public String[] getTriggerPoint() {
        return triggerPoint;
    }

    public void setTriggerPoint(String[] triggerPoint) {
        this.triggerPoint = triggerPoint;
    }

    public String[] getTotalLossRatio() {
        return totalLossRatio;
    }

    public void setTotalLossRatio(String[] totalLossRatio) {
        this.totalLossRatio = totalLossRatio;
    }

    public String[] getEqualFlagMain() {
        return equalFlagMain;
    }

    public void setEqualFlagMain(String[] equalFlagMain) {
        this.equalFlagMain = equalFlagMain;
    }

    public String[] getMedicalRateMain() {
        return medicalRateMain;
    }

    public void setMedicalRateMain(String[] medicalRateMain) {
        this.medicalRateMain = medicalRateMain;
    }

    public String[] getItemKindNoSub() {
        return itemKindNoSub;
    }

    public void setItemKindNoSub(String[] itemKindNoSub) {
        this.itemKindNoSub = itemKindNoSub;
    }

    public String[] getStartDateSub() {
        return startDateSub;
    }

    public void setStartDateSub(String[] startDateSub) {
        this.startDateSub = startDateSub;
    }

    public String[] getEndDateSub() {
        return endDateSub;
    }

    public void setEndDateSub(String[] endDateSub) {
        this.endDateSub = endDateSub;
    }

    public String[] getCurrencySub() {
        return currencySub;
    }

    public void setCurrencySub(String[] currencySub) {
        this.currencySub = currencySub;
    }

    public String[] getShortRateFlagSub() {
        return shortRateFlagSub;
    }

    public void setShortRateFlagSub(String[] shortRateFlagSub) {
        this.shortRateFlagSub = shortRateFlagSub;
    }

    public String[] getPremiumCalMethodSub() {
        return premiumCalMethodSub;
    }

    public void setPremiumCalMethodSub(String[] premiumCalMethodSub) {
        this.premiumCalMethodSub = premiumCalMethodSub;
    }

    public String[] getForestUseSub() {
        return forestUseSub;
    }

    public void setForestUseSub(String[] forestUseSub) {
        this.forestUseSub = forestUseSub;
    }

    public String[] getDeductibleRateSub() {
        return deductibleRateSub;
    }

    public void setDeductibleRateSub(String[] deductibleRateSub) {
        this.deductibleRateSub = deductibleRateSub;
    }

    public String[] getTriggerPointSub() {
        return triggerPointSub;
    }

    public void setTriggerPointSub(String[] triggerPointSub) {
        this.triggerPointSub = triggerPointSub;
    }

    public String[] getTotalLossRatioSub() {
        return totalLossRatioSub;
    }

    public void setTotalLossRatioSub(String[] totalLossRatioSub) {
        this.totalLossRatioSub = totalLossRatioSub;
    }

    public String[] getShortRateSub() {
        return shortRateSub;
    }

    public void setShortRateSub(String[] shortRateSub) {
        this.shortRateSub = shortRateSub;
    }

    public String[] getModeCodeSub() {
        return modeCodeSub;
    }

    public void setModeCodeSub(String[] modeCodeSub) {
        this.modeCodeSub = modeCodeSub;
    }

    public String[] getModeNameSub() {
        return modeNameSub;
    }

    public void setModeNameSub(String[] modeNameSub) {
        this.modeNameSub = modeNameSub;
    }

    public String[] getModelSub() {
        return modelSub;
    }

    public void setModelSub(String[] modelSub) {
        this.modelSub = modelSub;
    }

    public String[] getCalculateFlagSub() {
        return calculateFlagSub;
    }

    public void setCalculateFlagSub(String[] calculateFlagSub) {
        this.calculateFlagSub = calculateFlagSub;
    }

    public String[] getKindCodeSub() {
        return kindCodeSub;
    }

    public void setKindCodeSub(String[] kindCodeSub) {
        this.kindCodeSub = kindCodeSub;
    }

    public String[] getKindNameSub() {
        return kindNameSub;
    }

    public void setKindNameSub(String[] kindNameSub) {
        this.kindNameSub = kindNameSub;
    }

    public String[] getItemCodeSub() {
        return itemCodeSub;
    }

    public void setItemCodeSub(String[] itemCodeSub) {
        this.itemCodeSub = itemCodeSub;
    }

    public String[] getUnitAmountSub() {
        return unitAmountSub;
    }

    public void setUnitAmountSub(String[] unitAmountSub) {
        this.unitAmountSub = unitAmountSub;
    }

    public String[] getQuantitySub() {
        return quantitySub;
    }

    public void setQuantitySub(String[] quantitySub) {
        this.quantitySub = quantitySub;
    }

    public String[] getItemDetailNameSub() {
        return itemDetailNameSub;
    }

    public void setItemDetailNameSub(String[] itemDetailNameSub) {
        this.itemDetailNameSub = itemDetailNameSub;
    }

    public String[] getPrpItemKindAddressNoSub() {
        return prpItemKindAddressNoSub;
    }

    public void setPrpItemKindAddressNoSub(String[] prpItemKindAddressNoSub) {
        this.prpItemKindAddressNoSub = prpItemKindAddressNoSub;
    }

    public String[] getAmountSub() {
        return amountSub;
    }

    public void setAmountSub(String[] amountSub) {
        this.amountSub = amountSub;
    }

    public String[] getRateSub() {
        return rateSub;
    }

    public void setRateSub(String[] rateSub) {
        this.rateSub = rateSub;
    }

    public String[] getPremiumSub() {
        return premiumSub;
    }

    public void setPremiumSub(String[] premiumSub) {
        this.premiumSub = premiumSub;
    }

    public String[] getItemKindSub_Flag() {
        return itemKindSub_Flag;
    }

    public void setItemKindSub_Flag(String[] itemKindSub_Flag) {
        this.itemKindSub_Flag = itemKindSub_Flag;
    }

    public String[] getBenMarkPremiumSub() {
        return benMarkPremiumSub;
    }

    public void setBenMarkPremiumSub(String[] benMarkPremiumSub) {
        this.benMarkPremiumSub = benMarkPremiumSub;
    }

    public String[] getDisCountSub() {
        return disCountSub;
    }

    public void setDisCountSub(String[] disCountSub) {
        this.disCountSub = disCountSub;
    }

    public String[] getFamilyNoSub() {
        return familyNoSub;
    }

    public void setFamilyNoSub(String[] familyNoSub) {
        this.familyNoSub = familyNoSub;
    }

    public String[] getEqualFlagSub() {
        return equalFlagSub;
    }

    public void setEqualFlagSub(String[] equalFlagSub) {
        this.equalFlagSub = equalFlagSub;
    }

    public String[] getSerialNoSubEngage() {
        return serialNoSubEngage;
    }

    public void setSerialNoSubEngage(String[] serialNoSubEngage) {
        this.serialNoSubEngage = serialNoSubEngage;
    }

    public String[] getItemKindSub_Context() {
        return itemKindSub_Context;
    }

    public void setItemKindSub_Context(String[] itemKindSub_Context) {
        this.itemKindSub_Context = itemKindSub_Context;
    }

    public String[] getItemKindSubEngage_Flag() {
        return itemKindSubEngage_Flag;
    }

    public void setItemKindSubEngage_Flag(String[] itemKindSubEngage_Flag) {
        this.itemKindSubEngage_Flag = itemKindSubEngage_Flag;
    }

    public String[] getAgriUnitOutputMain() {
        return agriUnitOutputMain;
    }

    public void setAgriUnitOutputMain(String[] agriUnitOutputMain) {
        this.agriUnitOutputMain = agriUnitOutputMain;
    }

    public String[] getAgriUnitCostMain() {
        return agriUnitCostMain;
    }

    public void setAgriUnitCostMain(String[] agriUnitCostMain) {
        this.agriUnitCostMain = agriUnitCostMain;
    }

    public String[] getAgriProportionMain() {
        return agriProportionMain;
    }

    public void setAgriProportionMain(String[] agriProportionMain) {
        this.agriProportionMain = agriProportionMain;
    }

    public String[] getDisCountMainType() {
        return disCountMainType;
    }

    public void setDisCountMainType(String[] disCountMainType) {
        this.disCountMainType = disCountMainType;
    }

    public String[] getAgriDepreciationRateMain() {
        return agriDepreciationRateMain;
    }

    public void setAgriDepreciationRateMain(String[] agriDepreciationRateMain) {
        this.agriDepreciationRateMain = agriDepreciationRateMain;
    }

    public String[] getAgriUnitAmountMain() {
        return agriUnitAmountMain;
    }

    public void setAgriUnitAmountMain(String[] agriUnitAmountMain) {
        this.agriUnitAmountMain = agriUnitAmountMain;
    }

    public String[] getAgriGrossQuantityMain() {
        return agriGrossQuantityMain;
    }

    public void setAgriGrossQuantityMain(String[] agriGrossQuantityMain) {
        this.agriGrossQuantityMain = agriGrossQuantityMain;
    }

    public String[] getAgriInsureAreaMain() {
        return agriInsureAreaMain;
    }

    public void setAgriInsureAreaMain(String[] agriInsureAreaMain) {
        this.agriInsureAreaMain = agriInsureAreaMain;
    }

    public String[] getAgriStyleMain() {
        return agriStyleMain;
    }

    public void setAgriStyleMain(String[] agriStyleMain) {
        this.agriStyleMain = agriStyleMain;
    }

    public String[] getAgriTimesAmountMain() {
        return agriTimesAmountMain;
    }

    public void setAgriTimesAmountMain(String[] agriTimesAmountMain) {
        this.agriTimesAmountMain = agriTimesAmountMain;
    }

    public String[] getAgriUnitOutputSub() {
        return agriUnitOutputSub;
    }

    public void setAgriUnitOutputSub(String[] agriUnitOutputSub) {
        this.agriUnitOutputSub = agriUnitOutputSub;
    }

    public String[] getAgriUnitCostSub() {
        return agriUnitCostSub;
    }

    public void setAgriUnitCostSub(String[] agriUnitCostSub) {
        this.agriUnitCostSub = agriUnitCostSub;
    }

    public String[] getAgriProportionSub() {
        return agriProportionSub;
    }

    public void setAgriProportionSub(String[] agriProportionSub) {
        this.agriProportionSub = agriProportionSub;
    }

    public String[] getAgriDepreciationRateSub() {
        return agriDepreciationRateSub;
    }

    public void setAgriDepreciationRateSub(String[] agriDepreciationRateSub) {
        this.agriDepreciationRateSub = agriDepreciationRateSub;
    }

    public String[] getDisCountSubType() {
        return disCountSubType;
    }

    public void setDisCountSubType(String[] disCountSubType) {
        this.disCountSubType = disCountSubType;
    }

    public String[] getAgriUnitAmountSub() {
        return agriUnitAmountSub;
    }

    public void setAgriUnitAmountSub(String[] agriUnitAmountSub) {
        this.agriUnitAmountSub = agriUnitAmountSub;
    }

    public String[] getAgriGrossQuantitySub() {
        return agriGrossQuantitySub;
    }

    public void setAgriGrossQuantitySub(String[] agriGrossQuantitySub) {
        this.agriGrossQuantitySub = agriGrossQuantitySub;
    }

    public String[] getAgriInsureAreaSub() {
        return agriInsureAreaSub;
    }

    public void setAgriInsureAreaSub(String[] agriInsureAreaSub) {
        this.agriInsureAreaSub = agriInsureAreaSub;
    }

    public String[] getSubsidyRate() {
        return subsidyRate;
    }

    public void setSubsidyRate(String[] subsidyRate) {
        this.subsidyRate = subsidyRate;
    }

    public String getEndoretype() {
        return endoretype;
    }

    public void setEndoretype(String endoretype) {
        this.endoretype = endoretype;
    }

    public String getMainHeadFlag() {
        return mainHeadFlag;
    }

    public void setMainHeadFlag(String mainHeadFlag) {
        this.mainHeadFlag = mainHeadFlag;
    }

    public String getEndorseOption() {
        return endorseOption;
    }

    public void setEndorseOption(String endorseOption) {
        this.endorseOption = endorseOption;
    }

    public String getPeriodFlag() {
        return periodFlag;
    }

    public void setPeriodFlag(String periodFlag) {
        this.periodFlag = periodFlag;
    }

    public String[] getArrInsuredFlag() {
        return arrInsuredFlag;
    }

    public void setArrInsuredFlag(String[] arrInsuredFlag) {
        this.arrInsuredFlag = arrInsuredFlag;
    }

    public String[] getArrItemKindMainFlag() {
        return arrItemKindMainFlag;
    }

    public void setArrItemKindMainFlag(String[] arrItemKindMainFlag) {
        this.arrItemKindMainFlag = arrItemKindMainFlag;
    }

    public String[] getArrForUpdateFlag() {
        return arrForUpdateFlag;
    }

    public void setArrForUpdateFlag(String[] arrForUpdateFlag) {
        this.arrForUpdateFlag = arrForUpdateFlag;
    }

    public String getTailFlag() {
        return tailFlag;
    }

    public void setTailFlag(String tailFlag) {
        this.tailFlag = tailFlag;
    }

    public String[] getItemKindFlag() {
        return itemKindFlag;
    }

    public void setItemKindFlag(String[] itemKindFlag) {
        this.itemKindFlag = itemKindFlag;
    }

    public String getArrAddressFlag() {
        return arrAddressFlag;
    }

    public void setArrAddressFlag(String arrAddressFlag) {
        this.arrAddressFlag = arrAddressFlag;
    }

    public String[] getArrEngageFlag() {
        return arrEngageFlag;
    }

    public void setArrEngageFlag(String[] arrEngageFlag) {
        this.arrEngageFlag = arrEngageFlag;
    }

    public String getPrintNoFlag() {
        return printNoFlag;
    }

    public void setPrintNoFlag(String printNoFlag) {
        this.printNoFlag = printNoFlag;
    }

    public String getItemKindSubDriver1Flag() {
        return itemKindSubDriver1Flag;
    }

    public void setItemKindSubDriver1Flag(String itemKindSubDriver1Flag) {
        this.itemKindSubDriver1Flag = itemKindSubDriver1Flag;
    }

    public String getItemKindSubDriver2Flag() {
        return itemKindSubDriver2Flag;
    }

    public void setItemKindSubDriver2Flag(String itemKindSubDriver2Flag) {
        this.itemKindSubDriver2Flag = itemKindSubDriver2Flag;
    }

    public String getMainAgriFlag() {
        return mainAgriFlag;
    }

    public void setMainAgriFlag(String mainAgriFlag) {
        this.mainAgriFlag = mainAgriFlag;
    }

    public String[] getArrSubsidyFlag() {
        return arrSubsidyFlag;
    }

    public void setArrSubsidyFlag(String[] arrSubsidyFlag) {
        this.arrSubsidyFlag = arrSubsidyFlag;
    }

    public String getHpFlag() {
        return hpFlag;
    }

    public void setHpFlag(String hpFlag) {
        this.hpFlag = hpFlag;
    }

    public String getAppliInsuredFlag() {
        return appliInsuredFlag;
    }

    public void setAppliInsuredFlag(String appliInsuredFlag) {
        this.appliInsuredFlag = appliInsuredFlag;
    }

    public String getBusinessFlag() {
        return businessFlag;
    }

    public void setBusinessFlag(String businessFlag) {
        this.businessFlag = businessFlag;
    }



    public void setCoinsFlag(String coinsFlag) {
        this.coinsFlag = coinsFlag;
    }

    public String getUserComCode() {
        return userComCode;
    }

    public void setUserComCode(String userComCode) {
        this.userComCode = userComCode;
    }

    public String getMessType() {
        return messType;
    }

    public void setMessType(String messType) {
        this.messType = messType;
    }

    public String[] getInsuredInsuredCode() {
        return insuredInsuredCode;
    }

    public void setInsuredInsuredCode(String[] insuredInsuredCode) {
        this.insuredInsuredCode = insuredInsuredCode;
    }

    public String[] getInsuredInsuredName() {
        return insuredInsuredName;
    }

    public void setInsuredInsuredName(String[] insuredInsuredName) {
        this.insuredInsuredName = insuredInsuredName;
    }

    public String[] getInsuredInsuredAddress() {
        return insuredInsuredAddress;
    }

    public void setInsuredInsuredAddress(String[] insuredInsuredAddress) {
        this.insuredInsuredAddress = insuredInsuredAddress;
    }

    public String getOldPolicyNoRenewal() {
        return oldPolicyNoRenewal;
    }

    public void setOldPolicyNoRenewal(String oldPolicyNoRenewal) {
        this.oldPolicyNoRenewal = oldPolicyNoRenewal;
    }

    public String getShareHolderName() {
        return shareHolderName;
    }

    public void setShareHolderName(String shareHolderName) {
        this.shareHolderName = shareHolderName;
    }

    public String[] getBusinessCategory() {
        return businessCategory;
    }

    public void setBusinessCategory(String[] businessCategory) {
        this.businessCategory = businessCategory;
    }

    public String[] getSubsidyCode() {
        return subsidyCode;
    }

    public void setSubsidyCode(String[] subsidyCode) {
        this.subsidyCode = subsidyCode;
    }
}
