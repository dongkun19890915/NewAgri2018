package com.sinosoft.agriprpall.api.proposalmanage.dto;

/**
 * 响应返回参数的Dto
 */
public class ResponsePrpTmainDto {
    /** 险种代码*/
    private String riskcode;
    /** 操作员*/
    private String operatorName;
    /** 单量*/
    private String sumValue;
    /** 总保额*/
    private String sumAmount;
    /** 总保费*/
    private String sumPremium;

    public String getRiskcode() {
        return riskcode;
    }

    public void setRiskcode(String riskcode) {
        this.riskcode = riskcode;
    }

    public String getOperatorName() {
        return operatorName;
    }

    public void setOperatorName(String operatorName) {
        this.operatorName = operatorName;
    }

    public String getSumValue() {
        return sumValue;
    }

    public void setSumValue(String sumValue) {
        this.sumValue = sumValue;
    }

    public String getSumAmount() {
        return sumAmount;
    }

    public void setSumAmount(String sumAmount) {
        this.sumAmount = sumAmount;
    }

    public String getSumPremium() {
        return sumPremium;
    }

    public void setSumPremium(String sumPremium) {
        this.sumPremium = sumPremium;
    }
}
