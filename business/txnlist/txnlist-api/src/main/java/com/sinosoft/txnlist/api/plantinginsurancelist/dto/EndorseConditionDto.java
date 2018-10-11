package com.sinosoft.txnlist.api.plantinginsurancelist.dto;

import com.sinosoft.framework.dto.BaseRequest;

import java.io.Serializable;

public class EndorseConditionDto extends BaseRequest implements Serializable {
    private static final long serialVersionUID = 1L;

    /**批改类型 */
   private String endoretype;
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

    /**
     * add by 王心洋 2017-11-07
     */
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
    //批改手续费（57）农险暂不需要
    private String currency;
    private String disRate;
    private String changeDisFee;
    private String changeTaxDisFee;//手续费变化量金额
    private String taxDisFee;//手续费总金额
    //批改管理费比例（59）
    private String manageFeeRate;
    //批改特殊因子（58）农险暂不需要
    private String middleCostRate;
    private String changeMiddleCostFee;
    //批改绩效比例（77）
    private String basePerformanceRate;
    private String basePerformance;
    //赔款后恢复保额（13）、赔款后减少保额（14）
    private String compensateNo;
    //业务来源批改（76）
    private String businessNature;
    private String handlerCode;
    private String agentCode;
    private String agreementNo;
    //业务员批改（85）
    private String handler1Code;
    //分户信息收集
    private String fCode;
    private String fIdCard;
    private String earLabel;
    private String fName;
    private String bankCard;
    //保单遗失（03）：OthFlag[5]=1
//add by 王心洋 2017-11-14  end


    public String getfCode() {
        return fCode;
    }

    public void setfCode(String fCode) {
        this.fCode = fCode;
    }

    public String getfIdCard() {
        return fIdCard;
    }

    public void setfIdCard(String fIdCard) {
        this.fIdCard = fIdCard;
    }

    public String getEarLabel() {
        return earLabel;
    }

    public void setEarLabel(String earLabel) {
        this.earLabel = earLabel;
    }

    public String getfName() {
        return fName;
    }

    public void setfName(String fName) {
        this.fName = fName;
    }

    public String getBankCard() {
        return bankCard;
    }

    public void setBankCard(String bankCard) {
        this.bankCard = bankCard;
    }

    public String getCompensateNo() {
        return compensateNo;
    }

    public void setCompensateNo(String compensateNo) {
        this.compensateNo = compensateNo;
    }

    public String getBusinessNature() {
        return businessNature;
    }

    public void setBusinessNature(String businessNature) {
        this.businessNature = businessNature;
    }

    public String getHandlerCode() {
        return handlerCode;
    }

    public void setHandlerCode(String handlerCode) {
        this.handlerCode = handlerCode;
    }

    public String getAgentCode() {
        return agentCode;
    }

    public void setAgentCode(String agentCode) {
        this.agentCode = agentCode;
    }

    public String getAgreementNo() {
        return agreementNo;
    }

    public void setAgreementNo(String agreementNo) {
        this.agreementNo = agreementNo;
    }

    public String getHandler1Code() {
        return handler1Code;
    }

    public void setHandler1Code(String handler1Code) {
        this.handler1Code = handler1Code;
    }

    public String getBasePerformanceRate() {
        return basePerformanceRate;
    }

    public void setBasePerformanceRate(String basePerformanceRate) {
        this.basePerformanceRate = basePerformanceRate;
    }

    public String getBasePerformance() {
        return basePerformance;
    }

    public void setBasePerformance(String basePerformance) {
        this.basePerformance = basePerformance;
    }

    public String getMiddleCostRate() {
        return middleCostRate;
    }

    public void setMiddleCostRate(String middleCostRate) {
        this.middleCostRate = middleCostRate;
    }

    public String getChangeMiddleCostFee() {
        return changeMiddleCostFee;
    }

    public void setChangeMiddleCostFee(String changeMiddleCostFee) {
        this.changeMiddleCostFee = changeMiddleCostFee;
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

    public String getManageFeeRate() {
        return manageFeeRate;
    }

    public void setManageFeeRate(String manageFeeRate) {
        this.manageFeeRate = manageFeeRate;
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

    public String getCoinsFlag() {
        return coinsFlag;
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
}
