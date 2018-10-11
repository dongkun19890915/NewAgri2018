package com.sinosoft.agriprpall.api.endorsemanage.dto;

import com.sinosoft.framework.dto.BaseRequest;

import java.io.Serializable;

public class PrpPcoinsDetailCopyDto extends BaseRequest implements Serializable{
    private static final long serialVersionUID = 1L;
    /** 属性批单号/批单号 */
    private String endorseNo ;
    /** 属性保单号/保单号 */
    private String policyNo ;
    /** 属性序号/序号 */
    private Integer serialNo ;
    /** 属性coinsCode/coinsCode */
    private String coinsCode ;
    /** 属性coinsName/coinsName */
    private String coinsName ;
    /** 属性币别信息/币别信息 */
    private String currency ;
    /** 属性coinsAmount/coinsAmount */
    private Double coinsAmount ;
    /** 属性coinsPremium/coinsPremium */
    private Double coinsPremium ;
    /** 属性agentFee/agentFee */
    private Double agentFee ;
    /** 属性operateFee/operateFee */
    private Double operateFee ;
    /** 属性chgCoinsAmount/chgCoinsAmount */
    private Double chgCoinsAmount ;
    /** 属性chgCoinsPremium/chgCoinsPremium */
    private Double chgCoinsPremium ;
    /** 属性chgAgentFee/chgAgentFee */
    private Double chgAgentFee ;
    /** 属性chgOperateFee/chgOperateFee */
    private Double chgOperateFee ;
    /** 属性middleCostFee/middleCostFee */
    private Double middleCostFee ;
    /** 属性chgMiddleCostFee/chgMiddleCostFee */
    private Double chgMiddleCostFee ;
    /** 属性标志字段/标志字段 */
    private String flag ;
    /** 属性currency2/currency2 */
    private String currency2 ;
    /** 属性exchangeRateCny/exchangeRateCny */
    private Double exchangeRateCNY ;
    /** 属性planFee2/planFee2 */
    private Double planFee2 ;
    /** 属性proportionFee/proportionFee */
    private Double proportionFee ;
    /** 属性共保总不含税保费/共保总不含税保费 */
    private Double coinsNoTaxPremium ;
    /** 属性共保总不含税保费变化量/共保总不含税保费变化量 */
    private Double chgCoinsNoTaxPremium ;
    /** 属性共保总税额/共保总税额 */
    private Double coinsTaxFee ;
    /** 属性共保总税额变化量/共保总税额变化量 */
    private Double chgCoinsTaxFee ;
    /** 属性共保不含税出单费/共保不含税出单费 */
    private Double operateNoTaxPremium ;
    /** 属性共保不含税出单费变化量/共保不含税出单费变化量 */
    private Double chgOperateNoTaxPremium ;
    /** 属性共保出单费税率/共保出单费税率 */
    private Double operateTaxRate ;
    /** 属性共保不含税出单费税额/共保不含税出单费税额 */
    private Double operateTaxFee ;
    /** 属性共保不含税出单费变化量1/共保不含税出单费变化量1 */
    private Double chgOperateTaxFee ;
    /** 属性共保不含税手续费/共保不含税手续费 */
    private Double agentNoTaxPremium ;
    /** 属性共保不含税手续费变化量/共保不含税手续费变化量 */
    private Double chgAgentNoTaxPremium ;
    /** 属性共保不含税手续费税额/共保不含税手续费税额 */
    private Double agentTaxFee ;
    /** 属性共保不含税手续费税额1/共保不含税手续费税额1 */
    private Double chgAgentTaxFee ;

    public String getEndorseNo() {
        return endorseNo;
    }

    public void setEndorseNo(String endorseNo) {
        this.endorseNo = endorseNo;
    }

    public String getPolicyNo() {
        return policyNo;
    }

    public void setPolicyNo(String policyNo) {
        this.policyNo = policyNo;
    }

    public Integer getSerialNo() {
        return serialNo;
    }

    public void setSerialNo(Integer serialNo) {
        this.serialNo = serialNo;
    }

    public String getCoinsCode() {
        return coinsCode;
    }

    public void setCoinsCode(String coinsCode) {
        this.coinsCode = coinsCode;
    }

    public String getCoinsName() {
        return coinsName;
    }

    public void setCoinsName(String coinsName) {
        this.coinsName = coinsName;
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

    public Double getChgCoinsAmount() {
        return chgCoinsAmount;
    }

    public void setChgCoinsAmount(Double chgCoinsAmount) {
        this.chgCoinsAmount = chgCoinsAmount;
    }

    public Double getChgCoinsPremium() {
        return chgCoinsPremium;
    }

    public void setChgCoinsPremium(Double chgCoinsPremium) {
        this.chgCoinsPremium = chgCoinsPremium;
    }

    public Double getChgAgentFee() {
        return chgAgentFee;
    }

    public void setChgAgentFee(Double chgAgentFee) {
        this.chgAgentFee = chgAgentFee;
    }

    public Double getChgOperateFee() {
        return chgOperateFee;
    }

    public void setChgOperateFee(Double chgOperateFee) {
        this.chgOperateFee = chgOperateFee;
    }

    public Double getMiddleCostFee() {
        return middleCostFee;
    }

    public void setMiddleCostFee(Double middleCostFee) {
        this.middleCostFee = middleCostFee;
    }

    public Double getChgMiddleCostFee() {
        return chgMiddleCostFee;
    }

    public void setChgMiddleCostFee(Double chgMiddleCostFee) {
        this.chgMiddleCostFee = chgMiddleCostFee;
    }

    public String getFlag() {
        return flag;
    }

    public void setFlag(String flag) {
        this.flag = flag;
    }

    public String getCurrency2() {
        return currency2;
    }

    public void setCurrency2(String currency2) {
        this.currency2 = currency2;
    }

    public Double getExchangeRateCNY() {
        return exchangeRateCNY;
    }

    public void setExchangeRateCNY(Double exchangeRateCNY) {
        this.exchangeRateCNY = exchangeRateCNY;
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

    public Double getChgCoinsNoTaxPremium() {
        return chgCoinsNoTaxPremium;
    }

    public void setChgCoinsNoTaxPremium(Double chgCoinsNoTaxPremium) {
        this.chgCoinsNoTaxPremium = chgCoinsNoTaxPremium;
    }

    public Double getCoinsTaxFee() {
        return coinsTaxFee;
    }

    public void setCoinsTaxFee(Double coinsTaxFee) {
        this.coinsTaxFee = coinsTaxFee;
    }

    public Double getChgCoinsTaxFee() {
        return chgCoinsTaxFee;
    }

    public void setChgCoinsTaxFee(Double chgCoinsTaxFee) {
        this.chgCoinsTaxFee = chgCoinsTaxFee;
    }

    public Double getOperateNoTaxPremium() {
        return operateNoTaxPremium;
    }

    public void setOperateNoTaxPremium(Double operateNoTaxPremium) {
        this.operateNoTaxPremium = operateNoTaxPremium;
    }

    public Double getChgOperateNoTaxPremium() {
        return chgOperateNoTaxPremium;
    }

    public void setChgOperateNoTaxPremium(Double chgOperateNoTaxPremium) {
        this.chgOperateNoTaxPremium = chgOperateNoTaxPremium;
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

    public Double getChgOperateTaxFee() {
        return chgOperateTaxFee;
    }

    public void setChgOperateTaxFee(Double chgOperateTaxFee) {
        this.chgOperateTaxFee = chgOperateTaxFee;
    }

    public Double getAgentNoTaxPremium() {
        return agentNoTaxPremium;
    }

    public void setAgentNoTaxPremium(Double agentNoTaxPremium) {
        this.agentNoTaxPremium = agentNoTaxPremium;
    }

    public Double getChgAgentNoTaxPremium() {
        return chgAgentNoTaxPremium;
    }

    public void setChgAgentNoTaxPremium(Double chgAgentNoTaxPremium) {
        this.chgAgentNoTaxPremium = chgAgentNoTaxPremium;
    }

    public Double getAgentTaxFee() {
        return agentTaxFee;
    }

    public void setAgentTaxFee(Double agentTaxFee) {
        this.agentTaxFee = agentTaxFee;
    }

    public Double getChgAgentTaxFee() {
        return chgAgentTaxFee;
    }

    public void setChgAgentTaxFee(Double chgAgentTaxFee) {
        this.chgAgentTaxFee = chgAgentTaxFee;
    }
}
