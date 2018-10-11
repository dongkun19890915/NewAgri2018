package com.sinosoft.agriprpall.core.TransformationUtil;

import com.sinosoft.agriprpall.core.policymanage.entity.*;
import com.sinosoft.agriprpall.core.proposalmanage.entity.*;

/**
* 主要用于将prpt表数据转换为prpc表数据
* @Author: 宋振振
* @Date: 17:39 2017/11/3
*/
public class TransformTToC {

    /**
     * 将PrpTaddress转换成PrpCaddress
     * @author: 宋振振
     * @date: 2017/11/5 18:07
     * @param prpTaddress
     * @return prpCaddress
     */
    public static PrpCaddress setPrpTaddressToPrpCaddress(PrpTaddress prpTaddress){
        PrpCaddress prpCaddress=new PrpCaddress();
        prpCaddress.setRiskCode(prpTaddress.getRiskCode());
        prpCaddress.setAddressNo(prpTaddress.getAddressNo());
        prpCaddress.setAddressCode(prpTaddress.getAddressCode());
        prpCaddress.setAddressName(prpTaddress.getAddressName());
        prpCaddress.setFlag(prpTaddress.getFlag());
        prpCaddress.setProjectName(prpTaddress.getProjectName());
        prpCaddress.setCityCode(prpTaddress.getCityCode());
        prpCaddress.setCityFlag(prpTaddress.getCityFlag());
        prpCaddress.setCityName(prpTaddress.getCityName());
        prpCaddress.setDistrictCode(prpTaddress.getDistrictCode());
        prpCaddress.setDistrictFlag(prpTaddress.getDistrictFlag());
        prpCaddress.setDistrictName(prpTaddress.getDistrictName());
        prpCaddress.setProvinceCode(prpTaddress.getProvinceCode());
        prpCaddress.setProvinceFlag(prpTaddress.getProvinceFlag());
        prpCaddress.setProvinceName(prpTaddress.getProvinceName());
        prpCaddress.setRemark(prpTaddress.getRemark());
        return prpCaddress;
    }
    /**
     * 将PrpTcoins转换成PrpCcoins
     * @author: 宋振振
     * @date: 2017/11/5 18:07
     * @param prpTcoins
     * @return prpCcoins
     */
    public static PrpCcoins setPrpTcoinsToPrpCcoins(PrpTcoins prpTcoins){
        PrpCcoins prpCcoins=new PrpCcoins();
        prpCcoins.setSerialNo(prpTcoins.getSerialNo());
        prpCcoins.setMainPolicyNo(prpTcoins.getMainProposalNo());
        prpCcoins.setCoinsCode(prpTcoins.getCoinsCode());
        prpCcoins.setCoinsName(prpTcoins.getCoinsName());
        prpCcoins.setCoinsType(prpTcoins.getCoinsType());
        prpCcoins.setCoinsRate(prpTcoins.getCoinsRate());
        prpCcoins.setFlag(prpTcoins.getFlag());
        prpCcoins.setChiefFlag(prpTcoins.getChiefFlag());
        prpCcoins.setProportionFlag(prpTcoins.getProportionFlag());
        prpCcoins.setCoinsTreatyNo(prpTcoins.getCoinsTreatyNo());
        prpCcoins.setCoinsFlag(prpTcoins.getCoinsFlag());
        prpCcoins.setReinsCiFlag(prpTcoins.getReinsCiFlag());
        return prpCcoins;
    }
    /**
     * 将PrpTcoinsDetail转换成PrpCcoinsDetail
     * @author: 宋振振
     * @date: 2017/11/5 18:09
     * @param prpTcoinsDetail
     * @return prpCcoinsDetail
     */
    public static PrpCcoinsDetail setPrpTcoinsDetailToPrpCcoinsDetail(PrpTcoinsDetail prpTcoinsDetail){
        PrpCcoinsDetail prpCcoinsDetail=new PrpCcoinsDetail();
        prpCcoinsDetail.setSerialNo (prpTcoinsDetail.getSerialNo());
        prpCcoinsDetail.setCoinsCode (prpTcoinsDetail.getCoinsCode());
        prpCcoinsDetail.setCoinsName (prpTcoinsDetail.getCoinsName());
        prpCcoinsDetail.setCurrency (prpTcoinsDetail.getCurrency());
        prpCcoinsDetail.setCoinsAmount (prpTcoinsDetail.getCoinsAmount());
        prpCcoinsDetail.setCoinsPremium (prpTcoinsDetail.getCoinsPremium());
        prpCcoinsDetail.setAgentFee (prpTcoinsDetail.getAgentFee());
        prpCcoinsDetail.setOperateFee (prpTcoinsDetail.getOperateFee());
        prpCcoinsDetail.setFlag (prpTcoinsDetail.getFlag());
        prpCcoinsDetail.setMiddleCostFee (prpTcoinsDetail.getMiddleCostFee());
        prpCcoinsDetail.setCurrency2 (prpTcoinsDetail.getCurrency2());
        prpCcoinsDetail.setExchangeRateCNY (prpTcoinsDetail.getExchangeRateCNY());
        prpCcoinsDetail.setPlanFee2 (prpTcoinsDetail.getPlanFee2());
        prpCcoinsDetail.setProportionFee (prpTcoinsDetail.getProportionFee());
        prpCcoinsDetail.setCoinsNoTaxPremium (prpTcoinsDetail.getCoinsNoTaxPremium());
        prpCcoinsDetail.setCoinsTaxFee (prpTcoinsDetail.getCoinsTaxFee());
        prpCcoinsDetail.setOperateNoTaxPremium (prpTcoinsDetail.getOperateNoTaxPremium());
        prpCcoinsDetail.setOperateTaxRate (prpTcoinsDetail.getOperateTaxRate());
        prpCcoinsDetail.setOperateTaxFee (prpTcoinsDetail.getOperateTaxFee());
        prpCcoinsDetail.setAgentNoTaxPremium (prpTcoinsDetail.getAgentNoTaxPremium());
        prpCcoinsDetail.setAgentTaxFee (prpTcoinsDetail.getAgentTaxFee());
        return prpCcoinsDetail;
    }
    /**
     * 将PrpTcoinsDetail转换成PrpCcoinsDetailOrigin
     * @author: 宋振振
     * @date: 2017/11/5 18:09
     * @param prpTcoinsDetail
     * @return prpCcoinsDetailOrigin
     */
    public static PrpCcoinsDetailOrigin setPrpTcoinsDetailToPrpCcoinsDetailOrigin(PrpTcoinsDetail prpTcoinsDetail,String policyNo){
        PrpCcoinsDetailOrigin prpCcoinsDetailOrigin=new PrpCcoinsDetailOrigin();
        prpCcoinsDetailOrigin.setPolicyNo(policyNo);
        prpCcoinsDetailOrigin.setSerialNo(prpTcoinsDetail.getSerialNo());
        prpCcoinsDetailOrigin.setCoinsCode(prpTcoinsDetail.getCoinsCode());
        prpCcoinsDetailOrigin.setCoinsName(prpTcoinsDetail.getCoinsName());
        prpCcoinsDetailOrigin.setCurrency(prpTcoinsDetail.getCurrency());
        prpCcoinsDetailOrigin.setCoinsAmount(prpTcoinsDetail.getCoinsAmount());
        prpCcoinsDetailOrigin.setCoinsPremium(prpTcoinsDetail.getCoinsPremium());
        prpCcoinsDetailOrigin.setAgentFee(prpTcoinsDetail.getAgentFee());
        prpCcoinsDetailOrigin.setOperateFee(prpTcoinsDetail.getOperateFee());
        prpCcoinsDetailOrigin.setMiddleCostFee(prpTcoinsDetail.getMiddleCostFee());
        prpCcoinsDetailOrigin.setFlag(prpTcoinsDetail.getFlag());
        prpCcoinsDetailOrigin.setExchangerAteCNY(prpTcoinsDetail.getExchangeRateCNY());
        prpCcoinsDetailOrigin.setCurrency2(prpTcoinsDetail.getCurrency2());
        prpCcoinsDetailOrigin.setPlanFee2(prpTcoinsDetail.getPlanFee2());
        prpCcoinsDetailOrigin.setProportionFee(prpTcoinsDetail.getProportionFee());
        prpCcoinsDetailOrigin.setProposalNo(prpTcoinsDetail.getProposalNo());
        prpCcoinsDetailOrigin.setCoinsNoTaxPremium(prpTcoinsDetail.getCoinsNoTaxPremium());
        prpCcoinsDetailOrigin.setCoinsTaxFee(prpTcoinsDetail.getCoinsTaxFee());
        prpCcoinsDetailOrigin.setOperateNoTaxPremium(prpTcoinsDetail.getOperateNoTaxPremium());
        prpCcoinsDetailOrigin.setOperateTaxRate(prpTcoinsDetail.getOperateTaxRate());
        prpCcoinsDetailOrigin.setOperateTaxFee(prpTcoinsDetail.getOperateTaxFee());
        prpCcoinsDetailOrigin.setAgentNoTaxPremium(prpTcoinsDetail.getAgentNoTaxPremium());
        prpCcoinsDetailOrigin.setAgentTaxFee(prpTcoinsDetail.getAgentTaxFee());
        return prpCcoinsDetailOrigin;
    }
    /**
     * 将PrpTcoins转换成PrpCcoinsOrigin
     * @author: 宋振振
     * @date: 2017/11/5 18:09
     * @param prpTcoins,policyNo
     * @return prpCcoinsOrigin
     */
    public static PrpCcoinsOrigin setPrpTcoinsToPrpCcoinsOrigin(PrpTcoins prpTcoins,String policyNo){
        PrpCcoinsOrigin prpCcoinsOrigin=new PrpCcoinsOrigin();
        prpCcoinsOrigin.setPolicyNo(policyNo);
        prpCcoinsOrigin.setSerialNo(prpTcoins.getSerialNo());
        prpCcoinsOrigin.setMainPolicyNo(prpTcoins.getMainProposalNo());
        prpCcoinsOrigin.setCoinsCode(prpTcoins.getCoinsCode());
        prpCcoinsOrigin.setCoinsName(prpTcoins.getCoinsName());
        prpCcoinsOrigin.setCoinsType(prpTcoins.getCoinsType());
        prpCcoinsOrigin.setCoinsRate(prpTcoins.getCoinsRate());
        prpCcoinsOrigin.setChiefFlag(prpTcoins.getChiefFlag());
        prpCcoinsOrigin.setProportionFlag(prpTcoins.getProportionFlag());
        prpCcoinsOrigin.setFlag(prpTcoins.getFlag());
        prpCcoinsOrigin.setCoinsTreatyNo(prpTcoins.getCoinsTreatyNo());
        prpCcoinsOrigin.setReinsCiFlag(prpTcoins.getReinsCiFlag());
        prpCcoinsOrigin.setCoinsFlag(prpTcoins.getCoinsFlag());
        prpCcoinsOrigin.setProposalNo(prpTcoins.getProposalNo());
        return prpCcoinsOrigin;
    }
    /**
     * 将PrpTengage转换成PrpCengage
     * @author: 宋振振
     * @date: 2017/11/5 18:09
     * @param prpTengage
     * @return prpCengage
     */
    public static PrpCengage setPrpTengageTOPrpCengage(PrpTengage prpTengage){
        PrpCengage prpCengage=new PrpCengage();
        prpCengage.setRiskCode (prpTengage.getRiskCode());
        prpCengage.setSerialNo (prpTengage.getSerialNo());
        prpCengage.setLineNo (prpTengage.getLineNo());
        prpCengage.setClauseCode (prpTengage.getClauseCode());
        prpCengage.setClauses (prpTengage.getClauses());
        prpCengage.setTitleFlag (prpTengage.getTitleFlag());
        prpCengage.setFlag (prpTengage.getFlag());
        prpCengage.setClauseName (prpTengage.getClauseName());
        return prpCengage;
    }
    /**
     * 将PrpTexpense转换成PrpCexpense
     * @author: 宋振振
     * @date: 2017/11/5 18:09
     * @param prpTexpense
     * @return prpCexpense
     */
    public static PrpCexpense setPrpTexpenseToPrpCexpense(PrpTexpense prpTexpense){
        PrpCexpense prpCexpense=new PrpCexpense();
        prpCexpense.setRiskCode (prpTexpense.getRiskCode());
        prpCexpense.setManageFeeRate (prpTexpense.getManageFeeRate());
        prpCexpense.setMaxManageFeeRate (prpTexpense.getMaxManageFeeRate());
        prpCexpense.setFlag (prpTexpense.getFlag());
        prpCexpense.setSalvationRate (prpTexpense.getSalvationRate());
        prpCexpense.setSalvationFee (prpTexpense.getSalvationFee());
        prpCexpense.setCurrency (prpTexpense.getCurrency());
        prpCexpense.setBasePerformanceRate (prpTexpense.getBasePerformanceRate());
        prpCexpense.setBasePerformance (prpTexpense.getBasePerformance());
        prpCexpense.setEncouragePerformanceRate (prpTexpense.getEncouragePerformanceRate());
        prpCexpense.setEncouragePerformance (prpTexpense.getEncouragePerformance());
        prpCexpense.setNoTaxFee (prpTexpense.getNoTaxFee());
        prpCexpense.setTaxRate (prpTexpense.getTaxRate());
        prpCexpense.setTaxFee (prpTexpense.getTaxFee());
        return prpCexpense;
    }
    /**
     * 将PrpTexpense转换成PrpCexpenseOrigin
     * @author: 宋振振
     * @date: 2017/11/5 18:09
     * @param prpTexpense
     * @return prpCexpenseOrigin
     */
    public static PrpCexpenseOrigin setPrpTexpenseToPrpCexpenseOrigin(PrpTexpense prpTexpense,String policyNo){
        PrpCexpenseOrigin prpCexpenseOrigin=new PrpCexpenseOrigin();
        prpCexpenseOrigin.setPolicyNo(policyNo);
        prpCexpenseOrigin.setRiskCode(prpTexpense.getRiskCode());
        prpCexpenseOrigin.setManageFeeRate(prpTexpense.getManageFeeRate());
        prpCexpenseOrigin.setMaxManageFeeRate(prpTexpense.getMaxManageFeeRate());
        prpCexpenseOrigin.setFlag(prpTexpense.getFlag());
        prpCexpenseOrigin.setSalvationRate(prpTexpense.getSalvationRate());
        prpCexpenseOrigin.setSalvationFee(prpTexpense.getSalvationFee());
        prpCexpenseOrigin.setCurrency(prpTexpense.getCurrency());
        prpCexpenseOrigin.setBasePerformanceRate(prpTexpense.getBasePerformanceRate());
        prpCexpenseOrigin.setBasePerformance(prpTexpense.getBasePerformance());
        prpCexpenseOrigin.setEncouragePerformanceRate(prpTexpense.getEncouragePerformanceRate());
        prpCexpenseOrigin.setEncouragePerformance(prpTexpense.getEncouragePerformance());
        prpCexpenseOrigin.setNoTaxFee(prpTexpense.getNoTaxFee());
        prpCexpenseOrigin.setTaxRate(prpTexpense.getTaxRate());
        prpCexpenseOrigin.setTaxFee(prpTexpense.getTaxFee());
        return prpCexpenseOrigin;
    }
    /**
     * 将PrpTfee转换成PrpCfee
     * @author: 宋振振
     * @date: 2017/11/5 18:09
     * @param prpTfee
     * @return prpCfee
     */
    public static PrpCfee setPrpTfeeToPrpCfee(PrpTfee prpTfee){
        PrpCfee prpCfee=new PrpCfee();
        prpCfee.setRiskCode (prpTfee.getRiskCode());
        prpCfee.setCurrency (prpTfee.getCurrency());
        prpCfee.setAmount (prpTfee.getAmount());
        prpCfee.setPremium (prpTfee.getPremium());
        prpCfee.setFlag (prpTfee.getFlag());
        prpCfee.setCurrency1 (prpTfee.getCurrency1());
        prpCfee.setExchangeRate1 (prpTfee.getExchangeRate1());
        prpCfee.setAmount1 (prpTfee.getAmount1());
        prpCfee.setPremium1 (prpTfee.getPremium1());
        prpCfee.setCurrency2 (prpTfee.getCurrency2());
        prpCfee.setExchangeRate2 (prpTfee.getExchangeRate2());
        prpCfee.setAmount2 (prpTfee.getAmount2());
        prpCfee.setPremium2 (prpTfee.getPremium2());
        prpCfee.setNoTaxPremium (prpTfee.getNoTaxPremium());
        prpCfee.setTaxFee (prpTfee.getTaxFee());
        prpCfee.setNoTaxPremium1 (prpTfee.getNoTaxPremium1());
        prpCfee.setTaxFee1 (prpTfee.getTaxFee1());
        prpCfee.setNoTaxPremium2 (prpTfee.getNoTaxPremium2());
        prpCfee.setTaxFee2 (prpTfee.getTaxFee2());
        return prpCfee;
    }
    /**
     * 将PrpTfee转换成PrpCfeeOrigin
     * @author: 宋振振
     * @date: 2017/11/5 18:14
     * @param prpTfee
     * @param policyNo
     * @return prpCfeeOrigin
     */
    public static PrpCfeeOrigin setPrpTfeeToPrpCfeeOrigin(PrpTfee prpTfee,String policyNo){
        PrpCfeeOrigin prpCfeeOrigin=new PrpCfeeOrigin();
        prpCfeeOrigin.setPolicyNo(policyNo);
        prpCfeeOrigin.setRiskCode(prpTfee.getRiskCode());
        prpCfeeOrigin.setCurrency(prpTfee.getCurrency());
        prpCfeeOrigin.setAmount(prpTfee.getAmount());
        prpCfeeOrigin.setPremium(prpTfee.getPremium());
        prpCfeeOrigin.setFlag(prpTfee.getFlag());
        prpCfeeOrigin.setCurrency1(prpTfee.getCurrency1());
        prpCfeeOrigin.setExchangeRate1(prpTfee.getExchangeRate1());
        prpCfeeOrigin.setAmount1(prpTfee.getAmount1());
        prpCfeeOrigin.setPremium1(prpTfee.getPremium1());
        prpCfeeOrigin.setCurrency2(prpTfee.getCurrency2());
        prpCfeeOrigin.setExchangeRate2(prpTfee.getExchangeRate2());
        prpCfeeOrigin.setAmount2(prpTfee.getAmount2());
        prpCfeeOrigin.setPremium2(prpTfee.getPremium2());
        prpCfeeOrigin.setNoTaxPremium(prpTfee.getNoTaxPremium());
        prpCfeeOrigin.setTaxFee(prpTfee.getTaxFee());
        prpCfeeOrigin.setNoTaxPremium1(prpTfee.getNoTaxPremium1());
        prpCfeeOrigin.setTaxFee1(prpTfee.getTaxFee1());
        prpCfeeOrigin.setNoTaxPremium2(prpTfee.getNoTaxPremium2());
        prpCfeeOrigin.setTaxFee2(prpTfee.getTaxFee2());
        return prpCfeeOrigin;
    }
    /**
     * 将PrpTfeild转换成PrpCfeild
     * @author: 宋振振
     * @date: 2017/11/5 18:15
     * @param prpTfeild
     * @return prpCfeild
     */
    public static PrpCfeild setPrpTfeildToPrpCfeild(PrpTfeild prpTfeild){
        PrpCfeild prpCfeild=new PrpCfeild();
        prpCfeild.setProposalNo (prpTfeild.getProposalNo());
        prpCfeild.setFeildNo (prpTfeild.getFeildNo());
        prpCfeild.setFeildName (prpTfeild.getFeildName());
        prpCfeild.setFeildArea (prpTfeild.getFeildArea());
        prpCfeild.setRichflyCode (prpTfeild.getRichflyCode());
        prpCfeild.setRichflyCName (prpTfeild.getRichflyCName());
        return prpCfeild;
    }
    /**
     * 将PrpTinsured转换成PrpCinsured
     * @author: 宋振振
     * @date: 2017/11/5 18:15
     * @param prpTinsured
     * @return prpCinsured
     */
    public static PrpCinsured setPrpTinsuredToPrpCinsured(PrpTinsured prpTinsured){
        PrpCinsured prpCinsured=new PrpCinsured();
        prpCinsured.setRiskCode(prpTinsured.getRiskCode());
        prpCinsured.setSerialNo(prpTinsured.getSerialNo());
        prpCinsured.setLanguage(prpTinsured.getLanguage());
        prpCinsured.setInsuredType(prpTinsured.getInsuredType());
        prpCinsured.setInsuredCode(prpTinsured.getInsuredCode());
        prpCinsured.setInsuredName(prpTinsured.getInsuredName());
        prpCinsured.setInsuredAddress(prpTinsured.getInsuredAddress());
        prpCinsured.setInsuredNature(prpTinsured.getInsuredNature());
        prpCinsured.setInsuredFlag(prpTinsured.getInsuredFlag());
        prpCinsured.setInsuredIdentity(prpTinsured.getInsuredIdentity());
        prpCinsured.setRelateSerialNo(prpTinsured.getRelateSerialNo());
        prpCinsured.setIdentifyType(prpTinsured.getIdentifyType());
        prpCinsured.setIdentifyNumber(prpTinsured.getIdentifyNumber());
        prpCinsured.setCreditLevel(prpTinsured.getCreditLevel());
        prpCinsured.setPossessNature(prpTinsured.getPossessNature());
        prpCinsured.setBusinessSource(prpTinsured.getBusinessSource());
        prpCinsured.setBusinessSort(prpTinsured.getBusinessSort());
        prpCinsured.setOccupationCode(prpTinsured.getOccupationCode());
        prpCinsured.setEducationCode(prpTinsured.getEducationCode());
        prpCinsured.setBank(prpTinsured.getBank());
        prpCinsured.setAccountName(prpTinsured.getAccountName());
        prpCinsured.setAccount(prpTinsured.getAccount());
        prpCinsured.setLinkerName(prpTinsured.getLinkerName());
        prpCinsured.setPostAddress(prpTinsured.getPostAddress());
        prpCinsured.setPostCode(prpTinsured.getPostCode());
        prpCinsured.setPhoneNumber(prpTinsured.getPhoneNumber());
        prpCinsured.setMobile(prpTinsured.getMobile());
        prpCinsured.setEmail(prpTinsured.getEmail());
        prpCinsured.setBenefitRate(prpTinsured.getBenefitRate());
        prpCinsured.setBenefitFlag(prpTinsured.getBenefitFlag());
        prpCinsured.setFlag(prpTinsured.getFlag());
        prpCinsured.setOccupationGrade(prpTinsured.getOccupationGrade());
        prpCinsured.setRiskLevel(prpTinsured.getRiskLevel());
        prpCinsured.setIsCareClaim(prpTinsured.getIsCareClaim());
        prpCinsured.setCashFocus(prpTinsured.getCashFocus());
        prpCinsured.setValidPeriod3(prpTinsured.getValidPeriod3());
        prpCinsured.setJobTitle(prpTinsured.getJobTitle());
        prpCinsured.setNationality(prpTinsured.getNationality());
        prpCinsured.setBusinessCode(prpTinsured.getBusinessCode());
        prpCinsured.setRevenueRegistNo(prpTinsured.getRevenueRegistNo());
        prpCinsured.setBusinessValidPeriod(prpTinsured.getBusinessValidPeriod());
        prpCinsured.setRevenueRegistValidPeriod(prpTinsured.getRevenueRegistValidPeriod());
        prpCinsured.setOtherCodeNo(prpTinsured.getOtherCodeNo());
        prpCinsured.setOtherCodeValidPeriod(prpTinsured.getOtherCodeValidPeriod());
        prpCinsured.setSex(prpTinsured.getSex());
        prpCinsured.setWechatNo(prpTinsured.getWechatNo());
        prpCinsured.setVipFlag(prpTinsured.getVipFlag());
        prpCinsured.setCertificateName(prpTinsured.getCertificateName());
        prpCinsured.setCustomerKind(prpTinsured.getCustomerKind());
        prpCinsured.setInsuredSort(prpTinsured.getInsuredSort());
        prpCinsured.setLicenseStartDate(prpTinsured.getLicenseStartDate());
        prpCinsured.setNationFlag(prpTinsured.getNationFlag());
        prpCinsured.setBenefitType(prpTinsured.getBenefitType());
        prpCinsured.setAge(prpTinsured.getAge());
        prpCinsured.setApplyRealation(prpTinsured.getApplyRealation());
        prpCinsured.setCustomerSequenceNo(prpTinsured.getCustomerSequenceNo());
        return prpCinsured;
    }
    /**
     * 将PrpTitemKind转换成PrpCitemKind
     * @author: 宋振振
     * @date: 2017/11/5 18:15
     * @param prpTitemKind
     * @return prpCitemKind
     */
    public static PrpCitemKind setPrpTitemKindToPrpCitemKind(PrpTitemKind prpTitemKind){
        PrpCitemKind prpCitemKind=new PrpCitemKind();
        prpCitemKind.setRiskCode (prpTitemKind.getRiskCode());
        prpCitemKind.setItemKindNo (prpTitemKind.getItemKindNo());
        prpCitemKind.setFamilyNo (prpTitemKind.getFamilyNo());
        prpCitemKind.setFamilyName (prpTitemKind.getFamilyName());
        prpCitemKind.setRationType (prpTitemKind.getRationType());
        prpCitemKind.setKindCode (prpTitemKind.getKindCode());
        prpCitemKind.setKindName (prpTitemKind.getKindName());
        prpCitemKind.setItemNo (prpTitemKind.getItemNo());
        prpCitemKind.setItemCode (prpTitemKind.getItemCode());
        prpCitemKind.setItemDetailName (prpTitemKind.getItemDetailName());
        prpCitemKind.setModeCode (prpTitemKind.getModeCode());
        prpCitemKind.setModeName (prpTitemKind.getModeName());
        prpCitemKind.setStartDate (prpTitemKind.getStartDate());
        prpCitemKind.setStartHour (prpTitemKind.getStartHour());
        prpCitemKind.setEndDate (prpTitemKind.getEndDate());
        prpCitemKind.setEndHour (prpTitemKind.getEndHour());
        prpCitemKind.setModel (prpTitemKind.getModel());
        prpCitemKind.setBuyDate (prpTitemKind.getBuyDate());
        prpCitemKind.setAddressNo (prpTitemKind.getAddressNo());
        prpCitemKind.setCalculateFlag (prpTitemKind.getCalculateFlag());
        prpCitemKind.setCurrency (prpTitemKind.getCurrency());
        prpCitemKind.setUnitAmount (prpTitemKind.getUnitAmount());
        prpCitemKind.setQuantity (prpTitemKind.getQuantity());
        prpCitemKind.setUnit (prpTitemKind.getUnit());
        prpCitemKind.setValue (prpTitemKind.getValue());
        prpCitemKind.setAmount (prpTitemKind.getAmount());
        prpCitemKind.setRatePeriod (prpTitemKind.getRatePeriod());
        prpCitemKind.setRate (prpTitemKind.getRate());
        prpCitemKind.setShortRateFlag (prpTitemKind.getShortRateFlag());
        prpCitemKind.setShortRate (prpTitemKind.getShortRate());
        prpCitemKind.setBasePremium (prpTitemKind.getBedPremium());
        prpCitemKind.setBenchmarkPremium (prpTitemKind.getBenchmarkPremium());
        prpCitemKind.setDiscount (prpTitemKind.getDiscount());
        prpCitemKind.setAdjustRate (prpTitemKind.getAdjustRate());
        prpCitemKind.setPremium (prpTitemKind.getPremium());
        prpCitemKind.setDeductibleRate (prpTitemKind.getDeductibleRate());
        prpCitemKind.setDeductible (prpTitemKind.getDeductible());
        prpCitemKind.setFlag (prpTitemKind.getFlag());
        prpCitemKind.setRegionRate (prpTitemKind.getRegionRate());
        prpCitemKind.setDrinkRate (prpTitemKind.getDrinkRate());
        prpCitemKind.setDrunkRate (prpTitemKind.getDrunkRate());
        prpCitemKind.setCattleType (prpTitemKind.getCattleType());
        prpCitemKind.setUnitPersonLimitAmount (prpTitemKind.getUnitPersonLimitAmount());
        prpCitemKind.setUnitPersonAmount (prpTitemKind.getUnitPersonAmount());
        prpCitemKind.setUnitDayAmountSub (prpTitemKind.getUnitDayAmountSub());
        prpCitemKind.setDaySub (prpTitemKind.getDaySub());
        prpCitemKind.setPersonType (prpTitemKind.getPersonType());
        prpCitemKind.setTriggerPoint (prpTitemKind.getTriggerPoint());
        prpCitemKind.setTotalLossRatio (prpTitemKind.getTotalLossRatio());
        prpCitemKind.setLawsuitAmount (prpTitemKind.getLawsuitAmount());
        prpCitemKind.setBedNum (prpTitemKind.getBedNum());
        prpCitemKind.setBedPremium (prpTitemKind.getBedPremium());
        prpCitemKind.setHospitalPremium (prpTitemKind.getHospitalPremium());
        prpCitemKind.setKindWorkerNum (prpTitemKind.getKindWorkerNum());
        prpCitemKind.setKindWorkerPremium (prpTitemKind.getKindWorkerPremium());
        prpCitemKind.setClinicNum (prpTitemKind.getClinicNum());
        prpCitemKind.setClinicPremium (prpTitemKind.getClinicPremium());
        prpCitemKind.setnClinicNum (prpTitemKind.getnClinicNum());
        prpCitemKind.setnClinicPremium (prpTitemKind.getnClinicPremium());
        prpCitemKind.setRoomNum (prpTitemKind.getRoomNum());
        prpCitemKind.setRoomPremium (prpTitemKind.getRoomPremium());
        prpCitemKind.setNurseNum (prpTitemKind.getNurseNum());
        prpCitemKind.setNursePremium (prpTitemKind.getPremium());
        prpCitemKind.setWorkerPremium (prpTitemKind.getWorkerPremium());
        prpCitemKind.setWorkerNum (prpTitemKind.getWorkerNum());
        prpCitemKind.setQuantityNewborn (prpTitemKind.getQuantityNewborn());
        prpCitemKind.setChargeNewbornFlag (prpTitemKind.getChargeNewbornFlag());
        prpCitemKind.setUnitPremium (prpTitemKind.getUnitPremium());
        prpCitemKind.setOperationNum (prpTitemKind.getOperationNum());
        prpCitemKind.setOperationPremium (prpTitemKind.getOperationPremium());
        prpCitemKind.setMedicalRate (prpTitemKind.getMedicalRate());
        prpCitemKind.setPostRate (prpTitemKind.getPostRate());
        prpCitemKind.setBenefitRate (prpTitemKind.getBenefitRate());
        prpCitemKind.setDeductibleValue (prpTitemKind.getDeductibleValue());
        prpCitemKind.setDeductibleDiscount (prpTitemKind.getDeductibleDiscount());
        prpCitemKind.setKindBenchmarkPremiumm (prpTitemKind.getKindBenchmarkPremiumm());
        prpCitemKind.setGuestAmount (prpTitemKind.getGuestAmount());
        prpCitemKind.setDriverAmount (prpTitemKind.getDriverAmount());
        prpCitemKind.setThirdPeopleAmount (prpTitemKind.getThirdPeopleAmount());
        prpCitemKind.setIsSpecGlass (prpTitemKind.getIsSpecGlass());
        prpCitemKind.setClauseCode (prpTitemKind.getClauseCode());
        prpCitemKind.setCompensationDays (prpTitemKind.getCompensationDays());
        prpCitemKind.setCurrency2 (prpTitemKind.getCurrency2());
        prpCitemKind.setDeductibleDesc (prpTitemKind.getDeductibleDesc());
        prpCitemKind.setDiscountCharge (prpTitemKind.getDiscountCharge());
        prpCitemKind.setExchangeRate2 (prpTitemKind.getExchangeRate2());
        prpCitemKind.setExchangeRateCNY (prpTitemKind.getExchangeRateCNY());
        prpCitemKind.setInsuredValueType (prpTitemKind.getInsuredValueType());
        prpCitemKind.setInsuredValueTypeName (prpTitemKind.getInsuredValueTypeName());
        prpCitemKind.setKindPremiumm (prpTitemKind.getKindPremiumm());
        prpCitemKind.setLastPurePremium (prpTitemKind.getLastPurePremium());
        prpCitemKind.setLowerRate (prpTitemKind.getLowerRate());
        prpCitemKind.setManageCharge (prpTitemKind.getManageCharge());
        prpCitemKind.setMotorRate (prpTitemKind.getMotorRate());
        prpCitemKind.setNewEndDate (prpTitemKind.getNewEndDate());
        prpCitemKind.setNewStartDate (prpTitemKind.getNewStartDate());
        prpCitemKind.setPaymentRate (prpTitemKind.getPaymentRate());
        prpCitemKind.setPremium2 (prpTitemKind.getPremium2());
        prpCitemKind.setPremiumCNY (prpTitemKind.getPremiumCNY());
        prpCitemKind.setProductCode (prpTitemKind.getProductCode());
        prpCitemKind.setProfitScale (prpTitemKind.getProfitScale());
        prpCitemKind.setPurePremium (prpTitemKind.getPurePremium());
        prpCitemKind.setRate1 (prpTitemKind.getRate1());
        prpCitemKind.setRateType (prpTitemKind.getRateType());
        prpCitemKind.setRateValidDate (prpTitemKind.getRateValidDate());
        prpCitemKind.setReliefFund (prpTitemKind.getReliefFund());
        prpCitemKind.setReliefFundRate (prpTitemKind.getReliefFundRate());
        prpCitemKind.setReplyNo (prpTitemKind.getReplyNo());
        prpCitemKind.setSpecialCharge (prpTitemKind.getSpecialCharge());
        prpCitemKind.setStabilityFund (prpTitemKind.getStabilityFund());
        prpCitemKind.setStabilityFundRate (prpTitemKind.getStabilityFundRate());
        prpCitemKind.setStorageRate (prpTitemKind.getStorageRate()+"");
        prpCitemKind.setStructureNo (prpTitemKind.getStructureNo());
        prpCitemKind.setCostPrem (prpTitemKind.getCostPrem());
        prpCitemKind.setCostDiscount (prpTitemKind.getCostDiscount());
        prpCitemKind.setRecommenDiscount (prpTitemKind.getRecommenDiscount());
        prpCitemKind.setExpDiscount (prpTitemKind.getExpDiscount());
        prpCitemKind.setUwritingDiscount (prpTitemKind.getUwritingDiscount());
        prpCitemKind.setNoTaxPremium (prpTitemKind.getNoTaxPremium());
        prpCitemKind.setTaxFlag (prpTitemKind.getTaxFlag());
        prpCitemKind.setTaxRate (prpTitemKind.getTaxRate());
        prpCitemKind.setTaxFee (prpTitemKind.getTaxFee());
        prpCitemKind.setPremiumCalMethod (prpTitemKind.getPremiumCalMethod());
        prpCitemKind.setForestUse (prpTitemKind.getForestUse());
        return prpCitemKind;
    }
    /**
     * 将PrpTitemKindAgri转换成PrpCitemKindAgri
     * @author: 宋振振
     * @date: 2017/11/5 18:17
     * @param prpTitemKindAgri
     * @return prpCitemKindAgri
     */
    public static PrpCitemKindAgri setPrpTitemKindAgriToPrpCitemKindAgri(PrpTitemKindAgri prpTitemKindAgri){
        PrpCitemKindAgri prpCitemKindAgri=new PrpCitemKindAgri();
        prpCitemKindAgri.setRiskCode (prpTitemKindAgri.getRiskCode());
        prpCitemKindAgri.setItemKindNo (prpTitemKindAgri.getItemKindNo());
        prpCitemKindAgri.setKindCode (prpTitemKindAgri.getKindCode());
        prpCitemKindAgri.setUnitOutput (prpTitemKindAgri.getUnitOutput());
        prpCitemKindAgri.setUnitCost (prpTitemKindAgri.getUnitCost());
        prpCitemKindAgri.setProportion (prpTitemKindAgri.getProportion());
        prpCitemKindAgri.setDepreciationRate (prpTitemKindAgri.getDepreciationRate());
        prpCitemKindAgri.setUnitAmount (prpTitemKindAgri.getUnitAmount());
        prpCitemKindAgri.setGrossQuantity (prpTitemKindAgri.getGrossQuantity());
        prpCitemKindAgri.setDiscountType (prpTitemKindAgri.getDiscountType());
        prpCitemKindAgri.setFlag (prpTitemKindAgri.getFlag());
        prpCitemKindAgri.setRemark (prpTitemKindAgri.getRemark());
        prpCitemKindAgri.setTimes (prpTitemKindAgri.getTimes());
        prpCitemKindAgri.setStratDate (prpTitemKindAgri.getStratDate());
        prpCitemKindAgri.setEndDate (prpTitemKindAgri.getEndDate());
        prpCitemKindAgri.setDistributingRate (prpTitemKindAgri.getDistributingRate());
        prpCitemKindAgri.setInsureArea (prpTitemKindAgri.getInsureArea());
        prpCitemKindAgri.setTimesAmount (prpTitemKindAgri.getTimesAmount());
        return prpCitemKindAgri;
    }
    /**
     * 将PrpTitemKind转换成PrpCitemKindOrigin
     * @author: 宋振振
     * @date: 2017/11/5 18:17
     * @param prpTitemKind
     * @param policyNo
     * @return prpCitemKindOrigin
     */
    public static PrpCitemKindOrigin setPrpTitemKindToPrpCitemKindOrigin(PrpTitemKind prpTitemKind,String policyNo){
        PrpCitemKindOrigin prpCitemKindOrigin=new PrpCitemKindOrigin();
        prpCitemKindOrigin.setPolicyNo (policyNo);
        prpCitemKindOrigin.setRiskCode (prpTitemKind.getRiskCode());
        prpCitemKindOrigin.setItemKindNo (prpTitemKind.getItemKindNo());
        prpCitemKindOrigin.setFamilyNo (prpTitemKind.getFamilyNo());
        prpCitemKindOrigin.setFamilyName (prpTitemKind.getFamilyName());
        prpCitemKindOrigin.setRationType (prpTitemKind.getRationType());
        prpCitemKindOrigin.setKindCode (prpTitemKind.getKindCode());
        prpCitemKindOrigin.setKindName (prpTitemKind.getKindName());
        prpCitemKindOrigin.setItemNo (prpTitemKind.getItemNo());
        prpCitemKindOrigin.setItemCode (prpTitemKind.getItemCode());
        prpCitemKindOrigin.setItemDetailName (prpTitemKind.getItemDetailName());
        prpCitemKindOrigin.setModeCode (prpTitemKind.getModeCode());
        prpCitemKindOrigin.setModeName (prpTitemKind.getModeName());
        prpCitemKindOrigin.setStartDate (prpTitemKind.getStartDate());
        prpCitemKindOrigin.setStartHour (prpTitemKind.getStartHour());
        prpCitemKindOrigin.setEndDate (prpTitemKind.getEndDate());
        prpCitemKindOrigin.setEndHour (prpTitemKind.getEndHour());
        prpCitemKindOrigin.setModel (prpTitemKind.getModel());
        prpCitemKindOrigin.setBuyDate (prpTitemKind.getBuyDate());
        prpCitemKindOrigin.setAddressNo (prpTitemKind.getAddressNo());
        prpCitemKindOrigin.setCalculateFlag (prpTitemKind.getCalculateFlag());
        prpCitemKindOrigin.setCurrency (prpTitemKind.getCurrency());
        prpCitemKindOrigin.setUnitAmount (prpTitemKind.getUnitAmount());
        prpCitemKindOrigin.setQuantity (prpTitemKind.getQuantity());
        prpCitemKindOrigin.setUnit (prpTitemKind.getUnit());
        prpCitemKindOrigin.setValue (prpTitemKind.getValue());
        prpCitemKindOrigin.setAmount (prpTitemKind.getAmount());
        prpCitemKindOrigin.setRatePeriod (prpTitemKind.getRatePeriod());
        prpCitemKindOrigin.setRate (prpTitemKind.getRate());
        prpCitemKindOrigin.setShortRateFlag (prpTitemKind.getShortRateFlag());
        prpCitemKindOrigin.setShortRate (prpTitemKind.getShortRate());
        prpCitemKindOrigin.setBasePremium (prpTitemKind.getBedPremium());
        prpCitemKindOrigin.setBenchmarkPremium (prpTitemKind.getBenchmarkPremium());
        prpCitemKindOrigin.setDiscount (prpTitemKind.getDiscount());
        prpCitemKindOrigin.setAdjustRate (prpTitemKind.getAdjustRate());
        prpCitemKindOrigin.setPremium (prpTitemKind.getPremium());
        prpCitemKindOrigin.setDeductibleRate (prpTitemKind.getDeductibleRate());
        prpCitemKindOrigin.setDeductible (prpTitemKind.getDeductible());
        prpCitemKindOrigin.setFlag (prpTitemKind.getFlag());
        prpCitemKindOrigin.setRegionRate (prpTitemKind.getRegionRate());
        prpCitemKindOrigin.setDrinkRate (prpTitemKind.getDrinkRate());
        prpCitemKindOrigin.setDrunkRate (prpTitemKind.getDrunkRate());
        prpCitemKindOrigin.setCattleType (prpTitemKind.getCattleType());
        prpCitemKindOrigin.setUnitPersonLimitAmount (prpTitemKind.getUnitPersonLimitAmount());
        prpCitemKindOrigin.setUnitPersonAmount (prpTitemKind.getUnitPersonAmount());
        prpCitemKindOrigin.setUnitDayAmountSub (prpTitemKind.getUnitDayAmountSub());
        prpCitemKindOrigin.setDaySub (prpTitemKind.getDaySub());
        prpCitemKindOrigin.setPersonType (prpTitemKind.getPersonType());
        prpCitemKindOrigin.setTriggerPoint (prpTitemKind.getTriggerPoint());
        prpCitemKindOrigin.setTotalLossRatio (prpTitemKind.getTotalLossRatio());
        prpCitemKindOrigin.setLawsuitAmount (prpTitemKind.getLawsuitAmount());
        prpCitemKindOrigin.setBedNum (prpTitemKind.getBedNum());
        prpCitemKindOrigin.setBedPremium (prpTitemKind.getBedPremium());
        prpCitemKindOrigin.setHospitalPremium (prpTitemKind.getHospitalPremium());
        prpCitemKindOrigin.setKindWorkerNum (prpTitemKind.getKindWorkerNum());
        prpCitemKindOrigin.setKindWorkerPremium (prpTitemKind.getKindWorkerPremium());
        prpCitemKindOrigin.setClinicNum (prpTitemKind.getClinicNum());
        prpCitemKindOrigin.setClinicPremium (prpTitemKind.getClinicPremium());
        prpCitemKindOrigin.setNClinicNum (prpTitemKind.getnClinicNum());
        prpCitemKindOrigin.setNClinicPremium (prpTitemKind.getnClinicPremium());
        prpCitemKindOrigin.setRoomNum (prpTitemKind.getRoomNum());
        prpCitemKindOrigin.setRoomPremium (prpTitemKind.getRoomPremium());
        prpCitemKindOrigin.setNurseNum (prpTitemKind.getNurseNum());
        prpCitemKindOrigin.setNursePremium (prpTitemKind.getNursePremium());
        prpCitemKindOrigin.setWorkerPremium (prpTitemKind.getWorkerPremium());
        prpCitemKindOrigin.setWorkerNum (prpTitemKind.getWorkerNum());
        prpCitemKindOrigin.setUnitPremium (prpTitemKind.getUnitPremium());
        prpCitemKindOrigin.setOperationNum (prpTitemKind.getOperationNum());
        prpCitemKindOrigin.setOperationPremium (prpTitemKind.getOperationPremium());
        prpCitemKindOrigin.setMedicalRate (prpTitemKind.getMedicalRate());
        prpCitemKindOrigin.setPostRate (prpTitemKind.getPostRate());
        prpCitemKindOrigin.setCurrency2 (prpTitemKind.getCurrency2());
        prpCitemKindOrigin.setExchangeRate2 (prpTitemKind.getExchangeRate2());
        prpCitemKindOrigin.setExchangeRateCNY (prpTitemKind.getExchangeRateCNY());
        prpCitemKindOrigin.setInsuredValueType (prpTitemKind.getInsuredValueType());
        prpCitemKindOrigin.setInsuredValueTypeName (prpTitemKind.getInsuredValueTypeName());
        prpCitemKindOrigin.setNewEndDate (prpTitemKind.getNewEndDate());
        prpCitemKindOrigin.setNewStartDate (prpTitemKind.getNewStartDate());
        prpCitemKindOrigin.setPremium2 (prpTitemKind.getPremium2());
        prpCitemKindOrigin.setPremiumCNY (prpTitemKind.getPremiumCNY());
        prpCitemKindOrigin.setNoTaxPremium (prpTitemKind.getNoTaxPremium());
        prpCitemKindOrigin.setTaxFlag (prpTitemKind.getTaxFlag());
        prpCitemKindOrigin.setTaxRate (prpTitemKind.getTaxRate());
        prpCitemKindOrigin.setTaxFee (prpTitemKind.getTaxFee());
        prpCitemKindOrigin.setPremiumCalMethod (prpTitemKind.getPremiumCalMethod());
        prpCitemKindOrigin.setForestUse (prpTitemKind.getForestUse());
        return prpCitemKindOrigin;
    }
    /**
     * 将PrpTmain转换成PrpCmain
     * @author: 宋振振
     * @date: 2017/11/5 18:17
     * @param prpTmain
     * @return prpCmain
     */
    public static PrpCmain setPrpTmainToPrpCmain(PrpTmain prpTmain){
        PrpCmain prpCmain=new PrpCmain();
        prpCmain.setPolicyNo(prpTmain.getPolicyNo());
        prpCmain.setClassCode(prpTmain.getClassCode());
        prpCmain.setRiskCode(prpTmain.getRiskCode());
        prpCmain.setProposalNo(prpTmain.getProposalNo());
        prpCmain.setContractNo(prpTmain.getContractNo());
        prpCmain.setPolicySort(prpTmain.getPolicySort());
        prpCmain.setPrintNo(prpTmain.getPrintNo());
        prpCmain.setBusinessNature(prpTmain.getBusinessNature());
        prpCmain.setLanguage(prpTmain.getLanguage());
        prpCmain.setPolicyType(prpTmain.getPolicyType());
        prpCmain.setAppliCode(prpTmain.getAppliCode());
        prpCmain.setAppliName(prpTmain.getAppliName());
        prpCmain.setAppliAddress(prpTmain.getAppliAddress());
        prpCmain.setInsuredCode(prpTmain.getInsuredCode());
        prpCmain.setInsuredName(prpTmain.getInsuredName());
        prpCmain.setInsuredAddress(prpTmain.getInsuredAddress());
        prpCmain.setOperateDate(prpTmain.getOperateDate());
        prpCmain.setStartDate(prpTmain.getStartDate());
        prpCmain.setStartHour(prpTmain.getStartHour());
        prpCmain.setEndDate(prpTmain.getEndDate());
        prpCmain.setEndHour(prpTmain.getEndHour());
        prpCmain.setPureRate(prpTmain.getPureRate());
        prpCmain.setDisRate(prpTmain.getDisRate());
        prpCmain.setDiscount(prpTmain.getDiscount());
        prpCmain.setCurrency(prpTmain.getCurrency());
        prpCmain.setSumValue(prpTmain.getSumValue());
        prpCmain.setSumAmount(prpTmain.getSumAmount());
        prpCmain.setSumDiscount(prpTmain.getSumDiscount());
        prpCmain.setSumPremium(prpTmain.getSumPremium());
        prpCmain.setSumSubPrem(prpTmain.getSumSubPrem());
        prpCmain.setSumQuantity(prpTmain.getSumQuantity());
        prpCmain.setJudicalCode(prpTmain.getJudicalCode());
        prpCmain.setJudicalScope(prpTmain.getJudicalScope());
        prpCmain.setAutoTransRenewFlag(prpTmain.getAutoTransRenewFlag());
        prpCmain.setArgueSolution(prpTmain.getArgueSolution());
        prpCmain.setArbitBoardName(prpTmain.getArbitBoardName());
        prpCmain.setPayTimes(prpTmain.getPayTimes());
        prpCmain.setEndorseTimes(prpTmain.getEndorseTimes());
        prpCmain.setClaimTimes(prpTmain.getClaimTimes());
        prpCmain.setMakeCom(prpTmain.getMakeCom());
        prpCmain.setOperateSite(prpTmain.getOperateSite());
        prpCmain.setComCode(prpTmain.getComCode());
        prpCmain.setHandlerCode(prpTmain.getHandlerCode());
        prpCmain.setHandler1Code(prpTmain.getHandler1Code());
        prpCmain.setApproverCode(prpTmain.getApproverCode());
        prpCmain.setUnderwriteCode(prpTmain.getUnderwriteCode());
        prpCmain.setUnderwriteName(prpTmain.getUnderwriteName());
        prpCmain.setOperatorCode(prpTmain.getOperatorCode());
        prpCmain.setInputDate(prpTmain.getInputDate());
        prpCmain.setInputHour(prpTmain.getInputHour());
        prpCmain.setUnderwriteEndDate(prpTmain.getUnderwriteEndDate());
        prpCmain.setStatisticSym(prpTmain.getStatisticSym());
        prpCmain.setAgentCode(prpTmain.getAgentCode());
        prpCmain.setCoinsFlag(prpTmain.getCoinsFlag());
        prpCmain.setReinsFlag(prpTmain.getReinsFlag());
        prpCmain.setAllinsFlag(prpTmain.getAllinsFlag());
        prpCmain.setUnderwriteFlag(prpTmain.getUnderwriteFlag());
        prpCmain.setOthFlag(prpTmain.getOthFlag());
        prpCmain.setFlag(prpTmain.getFlag());
        prpCmain.setDisRate1(prpTmain.getDisRate1());
        prpCmain.setBusinessFlag(prpTmain.getBusinessFlag());
        prpCmain.setUpdaterCode(prpTmain.getUpdaterCode());
        prpCmain.setUpdateDate(prpTmain.getUpdateDate());
        prpCmain.setUpdateHour(prpTmain.getUpdateHour());
        prpCmain.setSignDate(prpTmain.getSignDate());
        prpCmain.setShareholderFlag(prpTmain.getShareholderFlag());
        prpCmain.setAgreementNo(prpTmain.getAgreementNo());
        prpCmain.setInquiryNo(prpTmain.getInquiryNo());
        prpCmain.setPayMode(prpTmain.getPayMode());
        prpCmain.setRemark(prpTmain.getRemark());
        prpCmain.setVisaCode(prpTmain.getVisaCode());
        prpCmain.setManualType(prpTmain.getManualType());
        prpCmain.setPolicyBizType(prpTmain.getPolicyBizType());
        prpCmain.setBusinessType(prpTmain.getBusinessType());
        prpCmain.setBusinessType1(prpTmain.getBusinessType1());
        prpCmain.setUnitCode(prpTmain.getUnitCode());
        prpCmain.setStatQuantity(prpTmain.getStatQuantity());
        prpCmain.setStatUnitCode(prpTmain.getStatUnitCode());
        prpCmain.setSumInsured(prpTmain.getSumInsured());
        prpCmain.setArticleType(prpTmain.getArticleType());
        prpCmain.setBusinessProvince(prpTmain.getBusinessProvince());
        prpCmain.setBusinessTown(prpTmain.getBusinessTown());
        prpCmain.setBusinessCounty(prpTmain.getBusinessCounty());
        prpCmain.setBusinessAreaName(prpTmain.getBusinessAreaName());
        prpCmain.setStartMinute(prpTmain.getStartMinute());
        prpCmain.setEndMinute(prpTmain.getEndMinute());
        prpCmain.setLimitAmount(prpTmain.getLimitAmount());
        prpCmain.setThirdKnow(prpTmain.getThirdKnow());
        prpCmain.setAgentRemark(prpTmain.getAgentRemark());
        prpCmain.setnCarPerpFlag(prpTmain.getnCarPerpFlag());
        prpCmain.setRichflyAreasCode(prpTmain.getRichflyAreasCode());
        prpCmain.setRichflyAreasCName(prpTmain.getRichflyAreasCName());
        prpCmain.setRichflyCode(prpTmain.getRichflyCode());
        prpCmain.setRichflyCName(prpTmain.getRichflyCName());
        prpCmain.setGroupNo(prpTmain.getGroupNo());
        prpCmain.setGroupFlag(prpTmain.getGroupFlag());
        prpCmain.setBasePerformanceRate(prpTmain.getBasePerformanceRate());
        prpCmain.setEncouragePerformanceRate(prpTmain.getEncouragePerformanceRate());
        prpCmain.setIsSeeFeeFlag(prpTmain.getIsSeeFeeFlag());
        prpCmain.setValidCountDate(prpTmain.getValidCountDate());
        prpCmain.setSumRate(prpTmain.getSumRate());
        prpCmain.setStandardRate(prpTmain.getStandardRate());
        prpCmain.setAgriFlag(prpTmain.getAgriFlag());
        prpCmain.setVersionNo(prpTmain.getVersionNo());
        prpCmain.setBigMedicalType(prpTmain.getBigMedicalType());
        prpCmain.setEarningsRate(prpTmain.getEarningsRate());
        prpCmain.setInsuredListType(prpTmain.getInsuredListType());
        prpCmain.setCoinsPremiumType(prpTmain.getCoinsPremiumType());
        prpCmain.setBusinessCity(prpTmain.getBusinessCity());
        prpCmain.setAllianceRate(prpTmain.getAllianceRate());
        prpCmain.setEccFlag(prpTmain.getEccFlag());
        prpCmain.setSsProposalNo(prpTmain.getSsProposalNo());
        prpCmain.setBusinessYear(prpTmain.getBusinessYear());
        prpCmain.setMakeArea(prpTmain.getMakeArea());
        prpCmain.setBusinessArea(prpTmain.getBusinessArea());
        prpCmain.setjFeeFlag(prpTmain.getjFeeFlag());
        prpCmain.setPrintTime(prpTmain.getPrintTime());
        prpCmain.setProjectsFlag(prpTmain.getProjectsFlag());
        prpCmain.setProposalLevel(prpTmain.getProposalLevel());
        prpCmain.setRateEndDate(prpTmain.getRateEndDate());
        prpCmain.setRatePeriod(prpTmain.getRatePeriod());
        prpCmain.setRatePeriodOld(prpTmain.getRatePeriodOld());
        prpCmain.setRatePeriodType(prpTmain.getRatePeriodType());
        prpCmain.setRateStartDate(prpTmain.getRateStartDate());
        prpCmain.setRsnNoRenewal(prpTmain.getRsnNoRenewal());
        prpCmain.setStartStages(prpTmain.getStartStages());
        prpCmain.setStopTimes(prpTmain.getStopTimes());
        prpCmain.setSubBusinessNature(prpTmain.getSubBusinessNature());
        prpCmain.setTradeVanId(prpTmain.getTradeVanId());
        prpCmain.setUndwrtMark(prpTmain.getUndwrtMark());
        prpCmain.setPreInvoiceFlag(prpTmain.getPreInvoiceFlag());
        prpCmain.setMiFlag(prpTmain.getMiFlag());
        prpCmain.setSubmitUndwrtFlag(prpTmain.getSubmitUndwrtFlag());
        prpCmain.setTypeFgEditFlag(prpTmain.getTypeFgEditFlag());
        prpCmain.setInputType(prpTmain.getInputType());
        prpCmain.setPeriodFlag(prpTmain.getPeriodFlag());
        prpCmain.setHangupFlag(prpTmain.getHangupFlag());
        prpCmain.setInstallmentFlag(prpTmain.getInstallmentFlag());
        prpCmain.setPaybackFlag(prpTmain.getPaybackFlag());
        prpCmain.setChannelAdjustValue(prpTmain.getChannelAdjustValue());
        prpCmain.setAutonomyAdjustValue(prpTmain.getAutonomyAdjustValue());
        prpCmain.setClauseType(prpTmain.getClauseType());
        prpCmain.setLocalModelDiscountZ(prpTmain.getLocalModelDiscountZ());
        prpCmain.setLocalModelPremium(prpTmain.getLocalModelPremium());
        prpCmain.setLocalModelDiscountQ(prpTmain.getLocalModelDiscountQ());
        prpCmain.setEffectFlag(prpTmain.getEffectFlag());
        prpCmain.setAgentClass(prpTmain.getAgentClass());
        prpCmain.setTopCommisionRate(prpTmain.getTopCommisionRate());
        prpCmain.setIntCommisionRate(prpTmain.getIntCommisionRate());
        prpCmain.setHandler2Address(prpTmain.getHandler2Address());
        prpCmain.setHandler2Code(prpTmain.getHandler2Code());
        prpCmain.setHandler2Id(prpTmain.getHandler2Id());
        prpCmain.setHandler2IdType(prpTmain.getHandler2IdType());
        prpCmain.setHandler2Mobile(prpTmain.getHandler2Mobile());
        prpCmain.setHandler2Name(prpTmain.getHandler2Name());
        prpCmain.setHandler2Post(prpTmain.getHandler2Post());
        prpCmain.setHandlerIdentifyNumber(prpTmain.getHandlerIdentifyNumber());
        prpCmain.setHandlerName(prpTmain.getHandlerName());
        prpCmain.setIntroducerId(prpTmain.getIntroducerId());
        prpCmain.setIntroducerName(prpTmain.getIntroducerName());
        prpCmain.setIsUndwrtFlag(prpTmain.getIsUndwrtFlag());
        prpCmain.setjFeePayType(prpTmain.getjFeePayType());
        prpCmain.setLastInsurerCode(prpTmain.getLastInsurerCode());
        prpCmain.setLastInsurerCom(prpTmain.getLastInsurerCom());
        prpCmain.setLastPrintNo(prpTmain.getLastPrintNo());
        prpCmain.setLockerCode(prpTmain.getLockerCode());
        prpCmain.setNationFlag(prpTmain.getNationFlag());
        prpCmain.setNewEndDate(prpTmain.getNewEndDate());
        prpCmain.setNewStartDate(prpTmain.getNewStartDate());
        prpCmain.setNotRenewalRegist(prpTmain.getNotRenewalRegist());
        prpCmain.setOperateWayFlag(prpTmain.getOperateWayFlag());
        prpCmain.setPayrefCode(prpTmain.getPayrefCode());
        prpCmain.setPayrefName(prpTmain.getPayrefName());
        prpCmain.setPayrefTime(prpTmain.getPayrefTime());
        prpCmain.setSystemFlag(prpTmain.getSystemFlag());
        prpCmain.setAgent1Code(prpTmain.getAgent1Code());
        prpCmain.setAgentMaxComission(prpTmain.getAgentMaxComission());
        prpCmain.setAgentName(prpTmain.getAgentName());
        prpCmain.setAgentTypeNo(prpTmain.getAgentTypeNo());
        prpCmain.setAgriType(prpTmain.getAgriType());
        prpCmain.setAssignNo(prpTmain.getAssignNo());
        prpCmain.setBankCode(prpTmain.getBankCode());
        prpCmain.setBankFlag(prpTmain.getBankFlag());
        prpCmain.setBizNoSysFlag(prpTmain.getBizNoSysFlag());
        prpCmain.setBusinessRecMark(prpTmain.getBusinessRecMark());
        prpCmain.setBusinessTypeFlag(prpTmain.getBusinessTypeFlag());
        prpCmain.setCaseNo(prpTmain.getCaseNo());
        prpCmain.setChannelCode(prpTmain.getChannelCode());
        prpCmain.setChannelType(prpTmain.getChannelType());
        prpCmain.setContributionLevel(prpTmain.getContributionLevel());
        prpCmain.setDeclareFlag(prpTmain.getDeclareFlag());
        prpCmain.setEditFlag(prpTmain.getEditFlag());
        prpCmain.setEffectiveImmediatelyFlag(prpTmain.getEffectiveImmediatelyFlag());
        prpCmain.setExchangeRate(prpTmain.getExchangeRate());
        prpCmain.setExtraComCode(prpTmain.getExtraComCode());
        prpCmain.setExtraComName(prpTmain.getExtraComName());
        prpCmain.setFactorPlaceCode(prpTmain.getFactorPlaceCode());
        prpCmain.setFactorPlaceName(prpTmain.getFactorPlaceName());
        prpCmain.setFycFlag(prpTmain.getFycFlag());
        prpCmain.setGovPurchaseFlag(prpTmain.getGovPurchaseFlag());
        prpCmain.setGroupType(prpTmain.getGroupType());
        prpCmain.setHandler1Name(prpTmain.getHandler1Name());
        prpCmain.setInputTime(prpTmain.getInputTime());
        prpCmain.setSaveTime(prpTmain.getSaveTime());
        prpCmain.setSaleName(prpTmain.getSaleName());
        prpCmain.setSalePhone(prpTmain.getSalePhone());
        prpCmain.setSaleComCode(prpTmain.getSaleComCode());
        prpCmain.setSaleComName(prpTmain.getSaleComName());
        prpCmain.setSaleComAddress(prpTmain.getSaleComAddress());
        prpCmain.setSaleAgentAddress(prpTmain.getSaleAgentAddress());
        prpCmain.setSaleAgentPersonName(prpTmain.getSaleAgentPersonName());
        prpCmain.setSaleAgentPersonId(prpTmain.getSaleAgentPersonId());
        prpCmain.setSaleAgentPermitNo(prpTmain.getSaleAgentPermitNo());
        prpCmain.setComCostPrem(prpTmain.getComCostPrem());
        prpCmain.setCtpCostPrem(prpTmain.getCtpCostPrem());
        prpCmain.setEntireCostDiscount(prpTmain.getEntireCostDiscount());
        prpCmain.setEntireRecommenDiscount(prpTmain.getEntireRecommenDiscount());
        prpCmain.setEntireExpDiscount(prpTmain.getEntireExpDiscount());
        prpCmain.setEntireUwritingDiscount(prpTmain.getEntireUwritingDiscount());
        prpCmain.setOldAutonomyAdjustValue(prpTmain.getOldAutonomyAdjustValue());
        prpCmain.setOldChannelAdjustValue(prpTmain.getOldChannelAdjustValue());
        prpCmain.setOldDiscount(prpTmain.getOldDiscount());
        prpCmain.setHopeDiscount(prpTmain.getHopeDiscount());
        prpCmain.setAdjustClaimReasonCode(prpTmain.getAdjustClaimReasonCode());
        prpCmain.setAdjustClaimReasonRate(prpTmain.getAdjustClaimReasonRate());
        prpCmain.setPrecheckDate(prpTmain.getPrecheckDate());
        prpCmain.setSpecialBusinessNo(prpTmain.getSpecialBusinessNo());
        prpCmain.setAgent1Name(prpTmain.getAgent1Name());
        prpCmain.setSumNoTaxPremium(prpTmain.getSumNoTaxPremium());
        prpCmain.setSumTaxFee(prpTmain.getSumTaxFee());
        prpCmain.setIsThirdBusiness(prpTmain.getIsThirdBusiness());
        prpCmain.setRecordCode(prpTmain.getRecordCode());
        prpCmain.setTaxType(prpTmain.getTaxType());
        prpCmain.setIsRepairCode(prpTmain.getIsRepairCode());
        prpCmain.setRepairCode(prpTmain.getRepairCode());
        prpCmain.setRepairName(prpTmain.getRepairName());
        prpCmain.setWxChannelCode(prpTmain.getWxChannelCode());
        prpCmain.setIsOnline(prpTmain.getIsOnline());
        prpCmain.setIsCustomer(prpTmain.getIsCustomer());
        prpCmain.setInceptionFlag(prpTmain.getInceptionFlag());
        prpCmain.setNotificationFlag(prpTmain.getNotificationFlag());
        prpCmain.setAgentBusinessType(prpTmain.getAgentBusinessType());
        prpCmain.setAgentBusinessTypeName(prpTmain.getAgentBusinessTypeName());
        prpCmain.setCtpElr(prpTmain.getCtpElr());
        prpCmain.setComElr(prpTmain.getComElr());
        prpCmain.setElr(prpTmain.getElr());
        return prpCmain;
    }
    /**
     * 将PrpTmainAgri转换成PrpCmainAgri
     * @author: 宋振振
     * @date: 2017/11/5 18:17
     * @param prpTmainAgri
     * @return prpCmainAgri
     */
    public static PrpCmainAgri setPrpTmainAgriToPrpCmainAgri(PrpTmainAgri prpTmainAgri){
        PrpCmainAgri prpCmainAgri=new PrpCmainAgri();
        prpCmainAgri.setRiskCode (prpTmainAgri.getRiskCode());
        prpCmainAgri.setRaiseDate (prpTmainAgri.getRaiseDate());
        prpCmainAgri.setRaiseSite (prpTmainAgri.getRaiseSite());
        prpCmainAgri.setInsureArea (prpTmainAgri.getInsureArea());
        prpCmainAgri.setRemark (prpTmainAgri.getRemark());
        prpCmainAgri.setFlag (prpTmainAgri.getFlag());
        prpCmainAgri.setObservePeriod (prpTmainAgri.getObservePeriod());
        prpCmainAgri.setObserveStartDate (prpTmainAgri.getObserveStartDate());
        prpCmainAgri.setObserveStartHour (prpTmainAgri.getObserveStartHour());
        prpCmainAgri.setObserveEndDate (prpTmainAgri.getObserveEndDate());
        prpCmainAgri.setObserveEndHour (prpTmainAgri.getObserveEndHour());
        prpCmainAgri.setValueRate (prpTmainAgri.getValueRate());
        prpCmainAgri.setSelfPremium (prpTmainAgri.getSelfPremium());
        prpCmainAgri.setDeptName (prpTmainAgri.getDeptName());
        prpCmainAgri.setDeptAddress (prpTmainAgri.getDeptAddress());
        prpCmainAgri.setAreaFlag (prpTmainAgri.getAreaFlag());
        prpCmainAgri.setRaiseType (prpTmainAgri.getRaiseType());
        prpCmainAgri.setRelationListNo (prpTmainAgri.getRelationListNo());
        prpCmainAgri.setRelationListNoRemark (prpTmainAgri.getRelationListNoRemark());
        prpCmainAgri.setCirculationCode (prpTmainAgri.getCirculationCode());
        prpCmainAgri.setReclamationArea (prpTmainAgri.getReclamationArea());
        prpCmainAgri.setCirculationArea (prpTmainAgri.getCirculationArea());
        return prpCmainAgri;
    }
    /**
     * 将PrpTmainLoan转换成PrpCmainLoan
     * @author: 宋振振
     * @date: 2017/11/5 18:17
     * @param prpTmainLoan
     * @return prpCmainLoan
     */
    public static PrpCmainLoan setPrpTmainLoanToPrpCmainLoan(PrpTmainLoan prpTmainLoan){
        PrpCmainLoan prpCmainLoan=new PrpCmainLoan();
        prpCmainLoan.setRiskCode (prpTmainLoan.getRiskCode());
        prpCmainLoan.setRiskKind (prpTmainLoan.getRiskKind());
        prpCmainLoan.setGuaranteeType (prpTmainLoan.getGuaranteeType());
        prpCmainLoan.setGuaranteeName (prpTmainLoan.getGuaranteeName());
        prpCmainLoan.setMortgageNo (prpTmainLoan.getMortgageNo());
        prpCmainLoan.setWarrantorCode (prpTmainLoan.getWarrantorCode());
        prpCmainLoan.setWarrantorName (prpTmainLoan.getWarrantorName());
        prpCmainLoan.setLoanNo1 (prpTmainLoan.getLoanNo1());
        prpCmainLoan.setLoanNo2 (prpTmainLoan.getLoanNo2());
        prpCmainLoan.setInstallmentFlag (prpTmainLoan.getInstallmentFlag());
        prpCmainLoan.setDeliverDate (prpTmainLoan.getDeliverDate());
        prpCmainLoan.setLoanContractNo (prpTmainLoan.getLoanContractNo());
        prpCmainLoan.setLoanWay (prpTmainLoan.getLoanWay());
        prpCmainLoan.setLoanNature (prpTmainLoan.getLoanNature());
        prpCmainLoan.setLoanBankCode (prpTmainLoan.getLoanBankCode());
        prpCmainLoan.setLoanBankName (prpTmainLoan.getLoanBankName());
        prpCmainLoan.setLoanUsage (prpTmainLoan.getLoanUsage());
        prpCmainLoan.setLoanStartDate (prpTmainLoan.getLoanStartDate());
        prpCmainLoan.setLoanEndDate (prpTmainLoan.getLoanEndDate());
        prpCmainLoan.setLoanYear (prpTmainLoan.getLoanYear());
        prpCmainLoan.setPlanAmount (prpTmainLoan.getPlanAmount());
        prpCmainLoan.setFirstRate (prpTmainLoan.getFirstRate());
        prpCmainLoan.setFirstPaid (prpTmainLoan.getFirstPaid());
        prpCmainLoan.setCurrency (prpTmainLoan.getCurrency());
        prpCmainLoan.setLoanAmount (prpTmainLoan.getLoanAmount());
        prpCmainLoan.setLoanRate (prpTmainLoan.getLoanRate());
        prpCmainLoan.setRepaidType (prpTmainLoan.getRepaidType());
        prpCmainLoan.setPaidTimes (prpTmainLoan.getPaidTimes());
        prpCmainLoan.setPerRepaidAmount (prpTmainLoan.getPerRepaidAmount());
        prpCmainLoan.setRemark (prpTmainLoan.getRemark());
        prpCmainLoan.setFlag (prpTmainLoan.getFlag());
        prpCmainLoan.setWarrantorAddress (prpTmainLoan.getWarrantorAddress());
        prpCmainLoan.setLoanAddress (prpTmainLoan.getLoanAddress());
        prpCmainLoan.setLoanInterest (prpTmainLoan.getLoanInterest());
        prpCmainLoan.setInitialCreditorName (prpTmainLoan.getInitialCreditorName());
        prpCmainLoan.setContactAddress (prpTmainLoan.getContactAddress());
        prpCmainLoan.setLinkMan (prpTmainLoan.getLinkMan());
        prpCmainLoan.setContactNumber (prpTmainLoan.getContactNumber());
        prpCmainLoan.setAccReceiveAmount (prpTmainLoan.getAccReceiveAmount());
        prpCmainLoan.setRepurchaseDate (prpTmainLoan.getRepurchaseDate());
        prpCmainLoan.setBondAmount (prpTmainLoan.getBondAmount());
        prpCmainLoan.setEffectiveProperty (prpTmainLoan.getEffectiveProperty());
        return prpCmainLoan;
    }
    /**
     * 将PrpTmain转换成PrpCmainOrigin
     * @author: 宋振振
     * @date: 2017/11/5 18:17
     * @param prpTmain
     * @param policyNo
     * @return prpCmainOrigin
     */
    public static PrpCmainOrigin setPrpTmainToPrpCmainOrigin(PrpTmain prpTmain,String policyNo){
        PrpCmainOrigin prpCmainOrigin=new PrpCmainOrigin();
        prpCmainOrigin.setPolicyNo (policyNo);
        prpCmainOrigin.setClassCode (prpTmain.getClassCode());
        prpCmainOrigin.setRiskCode (prpTmain.getRiskCode());
        prpCmainOrigin.setProposalNo (prpTmain.getProposalNo());
        prpCmainOrigin.setContractNo (prpTmain.getContractNo());
        prpCmainOrigin.setPolicySort (prpTmain.getPolicySort());
        prpCmainOrigin.setPrintNo (prpTmain.getPrintNo());
        prpCmainOrigin.setBusinessNature (prpTmain.getBusinessNature());
        prpCmainOrigin.setLanguage (prpTmain.getLanguage());
        prpCmainOrigin.setPolicyType (prpTmain.getPolicyType());
        prpCmainOrigin.setAppliCode (prpTmain.getAppliCode());
        prpCmainOrigin.setAppliName (prpTmain.getAppliName());
        prpCmainOrigin.setAppliAddress (prpTmain.getAppliAddress());
        prpCmainOrigin.setInsuredCode (prpTmain.getInsuredCode());
        prpCmainOrigin.setInsuredName (prpTmain.getInsuredName());
        prpCmainOrigin.setInsuredAddress (prpTmain.getInsuredAddress());
        prpCmainOrigin.setOperateDate (prpTmain.getOperateDate());
        prpCmainOrigin.setStartDate (prpTmain.getStartDate());
        prpCmainOrigin.setStartHour (prpTmain.getStartHour());
        prpCmainOrigin.setEndDate (prpTmain.getEndDate());
        prpCmainOrigin.setEndHour (prpTmain.getEndHour());
        prpCmainOrigin.setPureRate (prpTmain.getPureRate());
        prpCmainOrigin.setDisRate (prpTmain.getDisRate());
        prpCmainOrigin.setDisCount (prpTmain.getDiscount());
        prpCmainOrigin.setCurrency (prpTmain.getCurrency());
        prpCmainOrigin.setSumValue (prpTmain.getSumValue());
        prpCmainOrigin.setSumAmount (prpTmain.getSumAmount());
        prpCmainOrigin.setSumDiscount (prpTmain.getSumDiscount());
        prpCmainOrigin.setSumPremium (prpTmain.getSumPremium());
        prpCmainOrigin.setSumSubPrem (prpTmain.getSumSubPrem());
        prpCmainOrigin.setJudicalCode (prpTmain.getJudicalCode());
        prpCmainOrigin.setJudicalScope (prpTmain.getJudicalScope());
        prpCmainOrigin.setAutoTransRenewFlag (prpTmain.getAutoTransRenewFlag());
        prpCmainOrigin.setArgueSolution (prpTmain.getArgueSolution());
        prpCmainOrigin.setArbitBoardName (prpTmain.getArbitBoardName());
        prpCmainOrigin.setPayTimes (prpTmain.getPayTimes());
        prpCmainOrigin.setEndorseTimes (prpTmain.getEndorseTimes());
        prpCmainOrigin.setClaimTimes (prpTmain.getClaimTimes());
        prpCmainOrigin.setMakeCom (prpTmain.getMakeCom());
        prpCmainOrigin.setOperateSite (prpTmain.getOperateSite());
        prpCmainOrigin.setComCode (prpTmain.getComCode());
        prpCmainOrigin.setHandlerCode (prpTmain.getHandlerCode());
        prpCmainOrigin.setHandler1Code (prpTmain.getHandler1Code());
        prpCmainOrigin.setApproverCode (prpTmain.getApproverCode());
        prpCmainOrigin.setUnderwriteCode (prpTmain.getUnderwriteCode());
        prpCmainOrigin.setUnderwriteName (prpTmain.getUnderwriteName());
        prpCmainOrigin.setOperatorCode (prpTmain.getOperatorCode());
        prpCmainOrigin.setInputDate (prpTmain.getInputDate());
        prpCmainOrigin.setInputHour (prpTmain.getInputHour());
        prpCmainOrigin.setUnderwriteEndDate (prpTmain.getUnderwriteEndDate());
        prpCmainOrigin.setStatisticSym (prpTmain.getStatisticSym());
        prpCmainOrigin.setAgentCode (prpTmain.getAgentCode());
        prpCmainOrigin.setCoinsFlag (prpTmain.getCoinsFlag());
        prpCmainOrigin.setReinsFlag (prpTmain.getReinsFlag());
        prpCmainOrigin.setAllinsFlag (prpTmain.getAllinsFlag());
        prpCmainOrigin.setUnderwriteFlag (prpTmain.getUnderwriteFlag());
        prpCmainOrigin.setOthFlag (prpTmain.getOthFlag());
        prpCmainOrigin.setFlag (prpTmain.getFlag());
        prpCmainOrigin.setDisRate1 (prpTmain.getDisRate1());
        prpCmainOrigin.setBusinessFlag (prpTmain.getBusinessFlag());
        prpCmainOrigin.setUpdaterCode (prpTmain.getUpdaterCode());
        prpCmainOrigin.setUpdateDate (prpTmain.getUpdateDate());
        prpCmainOrigin.setUpdateHour (prpTmain.getUpdateHour());
        prpCmainOrigin.setPayMode (prpTmain.getPayMode());
        prpCmainOrigin.setSignDate (prpTmain.getSignDate());
        prpCmainOrigin.setShareholderFlag (prpTmain.getShareholderFlag());
        prpCmainOrigin.setAgreementNo (prpTmain.getAgreementNo());
        prpCmainOrigin.setInquiryNo (prpTmain.getInquiryNo());
        prpCmainOrigin.setRemark (prpTmain.getRemark());
        prpCmainOrigin.setVisaCode (prpTmain.getVisaCode());
        prpCmainOrigin.setManualType (prpTmain.getManualType());
        prpCmainOrigin.setSumQuantity (prpTmain.getSumQuantity());
        prpCmainOrigin.setPolicyBizType (prpTmain.getPolicyBizType());
        prpCmainOrigin.setBusinessType (prpTmain.getBusinessType());
        prpCmainOrigin.setBusinessType1 (prpTmain.getBusinessType1());
        prpCmainOrigin.setUnitCode (prpTmain.getUnitCode());
        prpCmainOrigin.setStatQuantity (prpTmain.getStatQuantity());
        prpCmainOrigin.setStatUnitCode (prpTmain.getStatUnitCode());
        prpCmainOrigin.setSumInsured (prpTmain.getSumInsured());
        prpCmainOrigin.setArticleType (prpTmain.getArticleType());
        prpCmainOrigin.setBusinessProvince (prpTmain.getBusinessProvince());
        prpCmainOrigin.setBusinessTown (prpTmain.getBusinessTown());
        prpCmainOrigin.setBusinessCounty (prpTmain.getBusinessCounty());
        prpCmainOrigin.setBusinessAreaName (prpTmain.getBusinessAreaName());
        prpCmainOrigin.setStartMinute (prpTmain.getStartMinute());
        prpCmainOrigin.setEndMinute (prpTmain.getEndMinute());
        prpCmainOrigin.setLimitAmount (prpTmain.getLimitAmount());
        prpCmainOrigin.setThirdKnow (prpTmain.getThirdKnow());
        prpCmainOrigin.setAgentRemark (prpTmain.getAgentRemark());
        prpCmainOrigin.setNCarPerpFlag (prpTmain.getnCarPerpFlag());
        prpCmainOrigin.setGroupNo (prpTmain.getGroupNo());
        prpCmainOrigin.setGroupFlag (prpTmain.getGroupFlag());
        prpCmainOrigin.setBasePerformanceRate (prpTmain.getBasePerformanceRate());
        prpCmainOrigin.setEncouragePerformanceRate (prpTmain.getEncouragePerformanceRate());
        prpCmainOrigin.setIsSeeFeeFlag (prpTmain.getIsSeeFeeFlag());
        prpCmainOrigin.setValidCountDate (prpTmain.getValidCountDate());
        prpCmainOrigin.setSumRate (prpTmain.getSumRate());
        prpCmainOrigin.setStandardRate (prpTmain.getStandardRate());
        prpCmainOrigin.setAgriFlag (prpTmain.getAgriFlag());
        prpCmainOrigin.setVersionNo (prpTmain.getVersionNo());
        prpCmainOrigin.setCoinsPremiumType (prpTmain.getCoinsPremiumType());
        prpCmainOrigin.setEccFlag (prpTmain.getEccFlag());
        prpCmainOrigin.setSsProposalNo (prpTmain.getSsProposalNo());
        prpCmainOrigin.setBusinessYear (prpTmain.getBusinessYear());
        prpCmainOrigin.setMakeArea (prpTmain.getMakeArea());
        prpCmainOrigin.setBusinessCity (prpTmain.getBusinessCity());
        prpCmainOrigin.setBusinessArea (prpTmain.getBusinessArea());
        prpCmainOrigin.setAllianceRate (prpTmain.getAllianceRate());
        prpCmainOrigin.setLastInsurerCom (prpTmain.getLastInsurerCom());
        prpCmainOrigin.setLastPrintNo (prpTmain.getLastPrintNo());
        prpCmainOrigin.setNationFlag (prpTmain.getNationFlag());
        prpCmainOrigin.setNewEndDate (prpTmain.getNewEndDate());
        prpCmainOrigin.setNewStartDate (prpTmain.getNewStartDate());
        prpCmainOrigin.setProjectsFlag (prpTmain.getProjectsFlag());
        prpCmainOrigin.setProposalLevel (prpTmain.getProposalLevel());
        prpCmainOrigin.setStartstAges (prpTmain.getStartStages());
        prpCmainOrigin.setStopTimes (prpTmain.getStopTimes());
        prpCmainOrigin.setSubBusinessNature (prpTmain.getSubBusinessNature());
        prpCmainOrigin.setPreInvoiceFlag (prpTmain.getPreInvoiceFlag());
        prpCmainOrigin.setPeriodFlag (prpTmain.getPeriodFlag());
        prpCmainOrigin.setHangupFlag (prpTmain.getHangupFlag());
        prpCmainOrigin.setChannelAdjustValue (prpTmain.getChannelAdjustValue());
        prpCmainOrigin.setAutonomyAdjustValue (prpTmain.getAutonomyAdjustValue());
        prpCmainOrigin.setLocalModelDiscountZ (prpTmain.getLocalModelDiscountZ());
        prpCmainOrigin.setLocalModelPremium (prpTmain.getLocalModelPremium());
        prpCmainOrigin.setClauseType (prpTmain.getClauseType());
        prpCmainOrigin.setLocalModelDiscountQ (prpTmain.getLocalModelDiscountQ());
        prpCmainOrigin.setSystemFlag (prpTmain.getSystemFlag());
        prpCmainOrigin.setAgriType (prpTmain.getAgriType());
        prpCmainOrigin.setBankCode (prpTmain.getBankCode());
        prpCmainOrigin.setChannelType (prpTmain.getChannelType());
        prpCmainOrigin.setEffectiveImmediatelyFlag (prpTmain.getEffectiveImmediatelyFlag());
        prpCmainOrigin.setLastInsurerCode (prpTmain.getLastInsurerCode());
        prpCmainOrigin.setGroupType (prpTmain.getGroupType());
        prpCmainOrigin.setSaleName (prpTmain.getSaleName());
        prpCmainOrigin.setSalePhone (prpTmain.getSalePhone());
        prpCmainOrigin.setSaleComCode (prpTmain.getSaleComCode());
        prpCmainOrigin.setSaleComName (prpTmain.getSaleComName());
        prpCmainOrigin.setSaleComAddress (prpTmain.getSaleComAddress());
        prpCmainOrigin.setSaleAgentAddress (prpTmain.getSaleAgentAddress());
        prpCmainOrigin.setSaleAgentPersonName (prpTmain.getSaleAgentPersonName());
        prpCmainOrigin.setSaleAgentPersonId (prpTmain.getSaleAgentPersonId());
        prpCmainOrigin.setSaleAgentPermitNo (prpTmain.getSaleAgentPermitNo());
        prpCmainOrigin.setEffectFlag (prpTmain.getEffectFlag());
        prpCmainOrigin.setAgentClass (prpTmain.getAgentClass());
        prpCmainOrigin.setTopCommisionRate (prpTmain.getTopCommisionRate());
        prpCmainOrigin.setIntCommisionRate (prpTmain.getIntCommisionRate());
        prpCmainOrigin.setExchangeRate (prpTmain.getExchangeRate());
        prpCmainOrigin.setAdjustClaimReasonCode (prpTmain.getAdjustClaimReasonCode());
        prpCmainOrigin.setAdjustClaimReasonRate (prpTmain.getAdjustClaimReasonRate());
        prpCmainOrigin.setComCostPrem (prpTmain.getComCostPrem());
        prpCmainOrigin.setCtpCostPrem (prpTmain.getCtpCostPrem());
        prpCmainOrigin.setEntireCostDiscount (prpTmain.getEntireCostDiscount());
        prpCmainOrigin.setEntireRecommenDiscount (prpTmain.getEntireRecommenDiscount());
        prpCmainOrigin.setEntireExpDiscount (prpTmain.getEntireCostDiscount());
        prpCmainOrigin.setEntireUwritingDiscount (prpTmain.getEntireUwritingDiscount());
        prpCmainOrigin.setHopeDiscount (prpTmain.getHopeDiscount());
        prpCmainOrigin.setUpdate_By (prpTmain.getUpdatedBy());
        prpCmainOrigin.setUpdate_Date (prpTmain.getUpdateDate());
        prpCmainOrigin.setSumNoTaxPremium (prpTmain.getSumNoTaxPremium());
        prpCmainOrigin.setSumTaxFee (prpTmain.getSumTaxFee());
        prpCmainOrigin.setIsThirdBusiness (prpTmain.getIsThirdBusiness());
        prpCmainOrigin.setRecordCode (prpTmain.getRecordCode());
        prpCmainOrigin.setTaxType (prpTmain.getTaxType());
        prpCmainOrigin.setIsRepairCode (prpTmain.getIsRepairCode());
        prpCmainOrigin.setRepairCode (prpTmain.getRepairCode());
        prpCmainOrigin.setRepairName (prpTmain.getRepairName());
        prpCmainOrigin.setWxChannelCode (prpTmain.getWxChannelCode());
        prpCmainOrigin.setIsOnline (prpTmain.getIsOnline());
        prpCmainOrigin.setIsCustomer (prpTmain.getIsCustomer());
        prpCmainOrigin.setInceptionFlag (prpTmain.getInceptionFlag());
        prpCmainOrigin.setNotificationFlag (prpTmain.getNotificationFlag());
        prpCmainOrigin.setAgentBusinessType (prpTmain.getAgentBusinessType());
        prpCmainOrigin.setAgentBusinessTypeName (prpTmain.getAgentBusinessTypeName());
        prpCmainOrigin.setCtpElr (prpTmain.getCtpElr());
        prpCmainOrigin.setComElr (prpTmain.getComElr());
        prpCmainOrigin.setElr (prpTmain.getElr());
        return prpCmainOrigin;
    }
    /**
     * 将PrpTplan转换PrpCplan
     * @author: 宋振振
     * @date: 2017/11/5 18:22
     * @param prpTplan
     * @return prpCplan
     */
    public static PrpCplan setPrpTplanToPrpCplan(PrpTplan prpTplan){
        PrpCplan prpCplan=new PrpCplan();
        prpCplan.setEndorseNo (prpTplan.getEndorseNo());
        prpCplan.setSerialNo (prpTplan.getSerialNo());
        prpCplan.setPayNo (prpTplan.getPayNo());
        prpCplan.setPayReason (prpTplan.getPayReason());
        prpCplan.setPlanDate (prpTplan.getPlanDate());
        prpCplan.setCurrency (prpTplan.getCurrency());
        prpCplan.setPlanFee (prpTplan.getPlanFee());
        prpCplan.setDelinquentFee (prpTplan.getDelinquentFee());
        prpCplan.setFlag (prpTplan.getFlag());
        prpCplan.setPlanStartDate (prpTplan.getPlanStartDate());
        prpCplan.setPlanRate (prpTplan.getPlanRate());
        prpCplan.setCurrency2 (prpTplan.getCurrency2());
        prpCplan.setPlanFee2 (prpTplan.getPlanFee2());
        prpCplan.setExchangeRateCNY (prpTplan.getExchangeRateCNY());
        prpCplan.setNoTaxPremium (prpTplan.getNoTaxPremium());
        prpCplan.setTaxFee (prpTplan.getTaxFee());
        return prpCplan;
    }
    /**
     * 将PrpTplanCoins转换PrpCplanCoins
     * @author: 宋振振
     * @date: 2017/11/5 18:22
     * @param prpTplanCoins
     * @return prpCplanCoins
     */
    public static PrpCplanCoins setPrpCplanCoinsToPrpCplanCoins(PrpTplanCoins prpTplanCoins){
        PrpCplanCoins prpCplanCoins=new PrpCplanCoins();
        prpCplanCoins.setEndorseNo (prpTplanCoins.getEndorseNo());
        prpCplanCoins.setCoinsCode (prpTplanCoins.getCoinsCode());
        prpCplanCoins.setSerialNo (prpTplanCoins.getSerialNo());
        prpCplanCoins.setPayNo (prpTplanCoins.getPayNo());
        prpCplanCoins.setPayReason (prpTplanCoins.getPayReason());
        prpCplanCoins.setPlanDate (prpTplanCoins.getPlanDate());
        prpCplanCoins.setCurrency (prpTplanCoins.getCurrency());
        prpCplanCoins.setPlanFee (prpTplanCoins.getPlanFee());
        prpCplanCoins.setDelinquentFee (prpTplanCoins.getDelinquentFee());
        prpCplanCoins.setFlag (prpTplanCoins.getFlag());
        prpCplanCoins.setPlanStartDate (prpTplanCoins.getPlanStartDate());
        prpCplanCoins.setPlanRate (prpTplanCoins.getPlanRate());
        prpCplanCoins.setNoTaxPremium (prpTplanCoins.getNoTaxPremium());
        prpCplanCoins.setTaxFee (prpTplanCoins.getTaxFee());
        return prpCplanCoins;
    }
    /**
     * 将PrpTrenewal转换PrpCrenewal
     * @author: 宋振振
     * @date: 2017/11/5 18:22
     * @param prpTrenewal
     * @return prpCrenewal
     */
    public static PrpCrenewal setPrpTrenewalToPrpCrenewal(PrpTrenewal prpTrenewal){
        PrpCrenewal prpCrenewal=new PrpCrenewal();
        prpCrenewal.setOldPolicyNo(prpTrenewal.getOldPolicyNo());
        prpCrenewal.setFlag(prpTrenewal.getFlag());
        return prpCrenewal;
    }
    /**
     * 将PrpTsubsidy转换PrpCsubsidy
     * @author: 宋振振
     * @date: 2017/11/5 18:22
     * @param prpTsubsidy
     * @return prpCsubsidy
     */
    public static PrpCsubsidy setPrpTsubsidyToPrpCsubsidy(PrpTsubsidy prpTsubsidy){
        PrpCsubsidy prpCsubsidy=new PrpCsubsidy();
        prpCsubsidy.setProposalNo (prpTsubsidy.getProposalNo());
        prpCsubsidy.setContractNo (prpTsubsidy.getContractNo());
        prpCsubsidy.setRiskCode (prpTsubsidy.getRiskCode());
        prpCsubsidy.setClassCode (prpTsubsidy.getClassCode());
        prpCsubsidy.setComCode (prpTsubsidy.getComCode());
        prpCsubsidy.setCurrency (prpTsubsidy.getCurrency());
        prpCsubsidy.setBenchmarkPremium (prpTsubsidy.getBenchmarkPremium());
        prpCsubsidy.setSubsidyCode (prpTsubsidy.getSubsidyCode());
        prpCsubsidy.setSubsidyName (prpTsubsidy.getSubsidyName());
        prpCsubsidy.setSubsidyType (prpTsubsidy.getSubsidyType());
        prpCsubsidy.setSubsidyTypeName (prpTsubsidy.getSubsidyTypeName());
        prpCsubsidy.setSubsidyDepartment (prpTsubsidy.getSubsidyDepartment());
        prpCsubsidy.setSubsidyRate (prpTsubsidy.getSubsidyRate());
        prpCsubsidy.setSubsidyPremium (prpTsubsidy.getSubsidyPremium());
        return prpCsubsidy;
    }
}
