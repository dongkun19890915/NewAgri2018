package com.sinosoft.agriprpall.api.endorsemanage.dto;

import com.sinosoft.framework.dto.BaseRequest;

import java.io.Serializable;

/**
 *  不分流程的coinsDetail实体类
 * @author 王心洋
 * @time 2017-11-06
 */
public class CoinsDetailDto extends BaseRequest implements Serializable,Comparable<CoinsDetailDto>{
    private static final long serialVersionUID = 1L;
    // 业务单号 BusinessNo
    private String businessNo = "";
    // 险种 RiskCode
    private String riskCode = "";
    // 属性SerialNo
    private String serialNo = "";
    // 属性CoinsCode
    private String coinsCode = "";
    // 属性Currency
    private String currency = "";
    //共保比例
    private double coinsRate;
    // 属性CoinsAmount
    private double coinsAmount;
    // 属性CoinsPremium 共保含税保费
    private double coinsPremium;
    // coinsNoTaxPremium 共保总不含税保费
    private double coinsNoTaxPremium;
    // coinsTaxFee 共保总税额
    private double coinsTaxFee;
    // 属性AgentFee 共保含税手续费
    private double agentFee;
    // agentNoTaxPremium 共保不含税手续费
    private double agentNoTaxPremium;
    // agenttaxfee 共保不含税手续费税额
    private double agenttaxfee;
    // 属性OperateFee 出单费
    private double operateFee;
    // operateNoTaxPremium 共保不含税出单费
    private double operateNoTaxPremium;
    // operatetaxrate 共保出单费税率
    private double operatetaxrate;
    // operatetaxfee 共保不含税出单费税额
    private double operatetaxfee;
    // 属性MiddleCostFee
    private double middleCostFee;
    // 出单费分摊比例
    private double operateFeeRate;
    // 结算方式(收取：01，支付：02)
    private String settleMode = "";
    //是否我方标志 1-我方  2-他方
    private String comFlag = "";

    public String getBusinessNo() {
        return businessNo;
    }

    public void setBusinessNo(String businessNo) {
        this.businessNo = businessNo;
    }

    public String getRiskCode() {
        return riskCode;
    }

    public void setRiskCode(String riskCode) {
        this.riskCode = riskCode;
    }

    public String getSerialNo() {
        return serialNo;
    }

    public void setSerialNo(String serialNo) {
        this.serialNo = serialNo;
    }

    public String getCoinsCode() {
        return coinsCode;
    }

    public void setCoinsCode(String coinsCode) {
        this.coinsCode = coinsCode;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public double getCoinsRate() {
        return coinsRate;
    }

    public void setCoinsRate(double coinsRate) {
        this.coinsRate = coinsRate;
    }

    public double getCoinsAmount() {
        return coinsAmount;
    }

    public void setCoinsAmount(double coinsAmount) {
        this.coinsAmount = coinsAmount;
    }

    public double getCoinsPremium() {
        return coinsPremium;
    }

    public void setCoinsPremium(double coinsPremium) {
        this.coinsPremium = coinsPremium;
    }

    public double getCoinsNoTaxPremium() {
        return coinsNoTaxPremium;
    }

    public void setCoinsNoTaxPremium(double coinsNoTaxPremium) {
        this.coinsNoTaxPremium = coinsNoTaxPremium;
    }

    public double getCoinsTaxFee() {
        return coinsTaxFee;
    }

    public void setCoinsTaxFee(double coinsTaxFee) {
        this.coinsTaxFee = coinsTaxFee;
    }

    public double getAgentFee() {
        return agentFee;
    }

    public void setAgentFee(double agentFee) {
        this.agentFee = agentFee;
    }

    public double getAgentNoTaxPremium() {
        return agentNoTaxPremium;
    }

    public void setAgentNoTaxPremium(double agentNoTaxPremium) {
        this.agentNoTaxPremium = agentNoTaxPremium;
    }

    public double getAgenttaxfee() {
        return agenttaxfee;
    }

    public void setAgenttaxfee(double agenttaxfee) {
        this.agenttaxfee = agenttaxfee;
    }

    public double getOperateFee() {
        return operateFee;
    }

    public void setOperateFee(double operateFee) {
        this.operateFee = operateFee;
    }

    public double getOperateNoTaxPremium() {
        return operateNoTaxPremium;
    }

    public void setOperateNoTaxPremium(double operateNoTaxPremium) {
        this.operateNoTaxPremium = operateNoTaxPremium;
    }

    public double getOperatetaxrate() {
        return operatetaxrate;
    }

    public void setOperatetaxrate(double operatetaxrate) {
        this.operatetaxrate = operatetaxrate;
    }

    public double getOperatetaxfee() {
        return operatetaxfee;
    }

    public void setOperatetaxfee(double operatetaxfee) {
        this.operatetaxfee = operatetaxfee;
    }

    public double getMiddleCostFee() {
        return middleCostFee;
    }

    public void setMiddleCostFee(double middleCostFee) {
        this.middleCostFee = middleCostFee;
    }

    public double getOperateFeeRate() {
        return operateFeeRate;
    }

    public void setOperateFeeRate(double operateFeeRate) {
        this.operateFeeRate = operateFeeRate;
    }

    public String getSettleMode() {
        return settleMode;
    }

    public void setSettleMode(String settleMode) {
        this.settleMode = settleMode;
    }

    public String getComFlag() {
        return comFlag;
    }

    public void setComFlag(String comFlag) {
        this.comFlag = comFlag;
    }

    public int compareTo(CoinsDetailDto o) {
        // TODO Auto-generated method stub
        double coinsRate1 = this.coinsRate*100;
        double coinsRate2 = o.getCoinsRate()*100;

        return (int)(coinsRate1-coinsRate2);
    }

}
