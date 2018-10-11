package com.sinosoft.agriprpall.api.endorsemanage.dto;

import java.io.Serializable;

import com.sinosoft.framework.dto.BaseRequest;
/**
 * @author codegen@研发中心
 * @mail codegen@sinosoft.com.cn
 * @time  2017-10-21 08:59:58.361
 * 共保信息表Api操作对象
 */
public class PrpCcoinsInfoDto extends BaseRequest implements Serializable{
    private static final long serialVersionUID = 1L;
    /** 属性保单号码/保单号码 */
    private String policyNo ;
    /** 属性序号/序号 */
    private java.lang.Integer serialNo ;
    /** 属性主保单号码/主保单号码 */
    private String mainPolicyNo ;
    /** 属性共保人机构代码/共保人机构代码 */
    private String coinsCode ;
    /** 属性共保人名称/共保人名称 */
    private String coinsName ;
    /** 属性共保份额/共保份额 */
    private String coinsType ;
    /** 属性共保类型--** 1-系统内--** 2-系统外/共保类型--** 1-系统内--** 2-系统外 */
    private java.lang.Double coinsRate ;
    /** 属性标志字段/标志字段 */
    private String flag ;
    /** 属性首席标志/首席标志 */
    private String chiefFlag ;
    /** 属性分摊标志/分摊标志 */
    private String proportionFlag ;
    /** 属性共保协议号/共保协议号 */
    private String coinStreatyNo ;
    /** 属性分保类型1-是分出公司 2-不是分出公司/分保类型1-是分出公司 2-不是分出公司 */
    private String coinsFlag ;
    /** 属性业务类型 1-分出业务 2-分入业务/业务类型 1-分出业务 2-分入业务 */
    private String reinsciFlag ;
    /** 属性修改人/修改人 */
    private String updateBy ;
    /** 属性修改时间/修改时间 */
    private java.util.Date updateDate ;
//    /** 属性保单号/保单号 */
//    private String policyNo ;
//    /** 属性序列号/序列号 */
//    private java.lang.Integer serialNo ;
//    /** 属性共保人机构代码/共保人机构代码 */
//    private String coinsCode ;
//    /** 属性共保人名称/共保人名称 */
//    private String coinsName ;
    /** 属性币别/币别 */
    private String currency ;
    /** 属性共保保额/共保保额 */
    private java.lang.Double coinsAmount ;
    /** 属性共保保费/共保保费 */
    private java.lang.Double coinsPremium ;
    /** 属性agentFee/agentFee */
    private java.lang.Double agentFee ;
    /** 属性operateFee/operateFee */
    private java.lang.Double operateFee ;
//    /** 属性备注/备注 */
//    private String flag ;
    /** 属性middleCostFee/middleCostFee */
    private java.lang.Double middleCostFee ;
    /** 属性currency3/currency3 */
    private String currency2 ;
    /** 属性exchangeRateCny/exchangeRateCny */
    private java.lang.Double exchangeRateCny ;
    /** 属性planFee3/planFee3 */
    private java.lang.Double planFee2 ;
    /** 属性proportionFee/proportionFee */
    private java.lang.Double proportionFee ;
    /** 属性共保总不含税保费/共保总不含税保费 */
    private java.lang.Double coinsNoTaxPremium ;
    /** 属性共保总税额/共保总税额 */
    private java.lang.Double coinsTaxFee ;
    /** 属性共保不含税出单费/共保不含税出单费 */
    private java.lang.Double operateNoTaxPremium ;
    /** 属性共保出单费税率/共保出单费税率 */
    private java.lang.Double operateTaxRate ;
    /** 属性共保不含税出单费税额/共保不含税出单费税额 */
    private java.lang.Double operateTaxFee ;
    /** 属性共保不含税手续费/共保不含税手续费 */
    private java.lang.Double agentNoTaxPremium ;
    /** 属性共保不含税手续费税额/共保不含税手续费税额 */
    private java.lang.Double agentTaxFee ;

    private String coinspremiumtype;

    private String Coinsflag;

    public String getCoinspremiumtype() {
        return coinspremiumtype;
    }

    public void setCoinspremiumtype(String coinspremiumtype) {
        this.coinspremiumtype = coinspremiumtype;
    }

    public String getCoinsflag() {
        return Coinsflag;
    }

    public void setCoinsflag(String coinsflag) {
        Coinsflag = coinsflag;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public Double getCoinsAmount() {
        return coinsAmount;
    }

    public void setCoinsAmount(Double coinsAmount) {
        this.coinsAmount = coinsAmount;
    }

    public Double getCoinsPremium() {
        return coinsPremium;
    }

    public void setCoinsPremium(Double coinsPremium) {
        this.coinsPremium = coinsPremium;
    }

    public Double getAgentFee() {
        return agentFee;
    }

    public void setAgentFee(Double agentFee) {
        this.agentFee = agentFee;
    }

    public Double getOperateFee() {
        return operateFee;
    }

    public void setOperateFee(Double operateFee) {
        this.operateFee = operateFee;
    }

    public Double getMiddleCostFee() {
        return middleCostFee;
    }

    public void setMiddleCostFee(Double middleCostFee) {
        this.middleCostFee = middleCostFee;
    }

    public String getCurrency2() {
        return currency2;
    }

    public void setCurrency2(String currency2) {
        this.currency2 = currency2;
    }

    public Double getExchangeRateCny() {
        return exchangeRateCny;
    }

    public void setExchangeRateCny(Double exchangeRateCny) {
        this.exchangeRateCny = exchangeRateCny;
    }

    public Double getPlanFee2() {
        return planFee2;
    }

    public void setPlanFee2(Double planFee2) {
        this.planFee2 = planFee2;
    }

    public Double getProportionFee() {
        return proportionFee;
    }

    public void setProportionFee(Double proportionFee) {
        this.proportionFee = proportionFee;
    }

    public Double getCoinsNoTaxPremium() {
        return coinsNoTaxPremium;
    }

    public void setCoinsNoTaxPremium(Double coinsNoTaxPremium) {
        this.coinsNoTaxPremium = coinsNoTaxPremium;
    }

    public Double getCoinsTaxFee() {
        return coinsTaxFee;
    }

    public void setCoinsTaxFee(Double coinsTaxFee) {
        this.coinsTaxFee = coinsTaxFee;
    }

    public Double getOperateNoTaxPremium() {
        return operateNoTaxPremium;
    }

    public void setOperateNoTaxPremium(Double operateNoTaxPremium) {
        this.operateNoTaxPremium = operateNoTaxPremium;
    }

    public Double getOperateTaxRate() {
        return operateTaxRate;
    }

    public void setOperateTaxRate(Double operateTaxRate) {
        this.operateTaxRate = operateTaxRate;
    }

    public Double getOperateTaxFee() {
        return operateTaxFee;
    }

    public void setOperateTaxFee(Double operateTaxFee) {
        this.operateTaxFee = operateTaxFee;
    }

    public Double getAgentNoTaxPremium() {
        return agentNoTaxPremium;
    }

    public void setAgentNoTaxPremium(Double agentNoTaxPremium) {
        this.agentNoTaxPremium = agentNoTaxPremium;
    }

    public Double getAgentTaxFee() {
        return agentTaxFee;
    }

    public void setAgentTaxFee(Double agentTaxFee) {
        this.agentTaxFee = agentTaxFee;
    }

    /**
     * 属性保单号码/保单号码的getter方法
     */
    public String getPolicyNo() {
        return policyNo;
    }
    /**
     * 属性保单号码/保单号码的setter方法
     */
    public void setPolicyNo(String policyNo) {
        this.policyNo = policyNo;
    }
    /**
     * 属性序号/序号的getter方法
     */
    public java.lang.Integer getSerialNo() {
        return serialNo;
    }
    /**
     * 属性序号/序号的setter方法
     */
    public void setSerialNo(java.lang.Integer serialNo) {
        this.serialNo = serialNo;
    }
    /**
     * 属性主保单号码/主保单号码的getter方法
     */
    public String getMainPolicyNo() {
        return mainPolicyNo;
    }
    /**
     * 属性主保单号码/主保单号码的setter方法
     */
    public void setMainPolicyNo(String mainPolicyNo) {
        this.mainPolicyNo = mainPolicyNo;
    }
    /**
     * 属性共保人机构代码/共保人机构代码的getter方法
     */
    public String getCoinsCode() {
        return coinsCode;
    }
    /**
     * 属性共保人机构代码/共保人机构代码的setter方法
     */
    public void setCoinsCode(String coinsCode) {
        this.coinsCode = coinsCode;
    }
    /**
     * 属性共保人名称/共保人名称的getter方法
     */
    public String getCoinsName() {
        return coinsName;
    }
    /**
     * 属性共保人名称/共保人名称的setter方法
     */
    public void setCoinsName(String coinsName) {
        this.coinsName = coinsName;
    }
    /**
     * 属性共保份额/共保份额的getter方法
     */
    public String getCoinsType() {
        return coinsType;
    }
    /**
     * 属性共保份额/共保份额的setter方法
     */
    public void setCoinsType(String coinsType) {
        this.coinsType = coinsType;
    }
    /**
     * 属性共保类型--** 1-系统内--** 2-系统外/共保类型--** 1-系统内--** 2-系统外的getter方法
     */
    public java.lang.Double getCoinsRate() {
        return coinsRate;
    }
    /**
     * 属性共保类型--** 1-系统内--** 2-系统外/共保类型--** 1-系统内--** 2-系统外的setter方法
     */
    public void setCoinsRate(java.lang.Double coinsRate) {
        this.coinsRate = coinsRate;
    }
    /**
     * 属性标志字段/标志字段的getter方法
     */
    public String getFlag() {
        return flag;
    }
    /**
     * 属性标志字段/标志字段的setter方法
     */
    public void setFlag(String flag) {
        this.flag = flag;
    }
    /**
     * 属性首席标志/首席标志的getter方法
     */
    public String getChiefFlag() {
        return chiefFlag;
    }
    /**
     * 属性首席标志/首席标志的setter方法
     */
    public void setChiefFlag(String chiefFlag) {
        this.chiefFlag = chiefFlag;
    }
    /**
     * 属性分摊标志/分摊标志的getter方法
     */
    public String getProportionFlag() {
        return proportionFlag;
    }
    /**
     * 属性分摊标志/分摊标志的setter方法
     */
    public void setProportionFlag(String proportionFlag) {
        this.proportionFlag = proportionFlag;
    }
    /**
     * 属性共保协议号/共保协议号的getter方法
     */
    public String getCoinStreatyNo() {
        return coinStreatyNo;
    }
    /**
     * 属性共保协议号/共保协议号的setter方法
     */
    public void setCoinStreatyNo(String coinStreatyNo) {
        this.coinStreatyNo = coinStreatyNo;
    }
    /**
     * 属性分保类型1-是分出公司 2-不是分出公司/分保类型1-是分出公司 2-不是分出公司的getter方法
     */
    public String getCoinsFlag() {
        return coinsFlag;
    }
    /**
     * 属性分保类型1-是分出公司 2-不是分出公司/分保类型1-是分出公司 2-不是分出公司的setter方法
     */
    public void setCoinsFlag(String coinsFlag) {
        this.coinsFlag = coinsFlag;
    }
    /**
     * 属性业务类型 1-分出业务 2-分入业务/业务类型 1-分出业务 2-分入业务的getter方法
     */
    public String getReinsciFlag() {
        return reinsciFlag;
    }
    /**
     * 属性业务类型 1-分出业务 2-分入业务/业务类型 1-分出业务 2-分入业务的setter方法
     */
    public void setReinsciFlag(String reinsciFlag) {
        this.reinsciFlag = reinsciFlag;
    }
    /**
     * 属性修改人/修改人的getter方法
     */
    public String getUpdateBy() {
        return updateBy;
    }
    /**
     * 属性修改人/修改人的setter方法
     */
    public void setUpdateBy(String updateBy) {
        this.updateBy = updateBy;
    }
    /**
     * 属性修改时间/修改时间的getter方法
     */
    public java.util.Date getUpdateDate() {
        return updateDate;
    }
    /**
     * 属性修改时间/修改时间的setter方法
     */
    public void setUpdateDate(java.util.Date updateDate) {
        this.updateDate = updateDate;
    }




}
