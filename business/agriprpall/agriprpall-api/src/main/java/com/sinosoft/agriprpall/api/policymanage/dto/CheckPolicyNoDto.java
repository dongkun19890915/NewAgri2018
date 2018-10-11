package com.sinosoft.agriprpall.api.policymanage.dto;

public class CheckPolicyNoDto {
    //保单号
    private String policyNo;
    //险种代码
    private String riskCode;

    public String getPolicyNo() {
        return policyNo;
    }

    public void setPolicyNo(String policyNo) {
        this.policyNo = policyNo;
    }

    public String getRiskCode() {
        return riskCode;
    }

    public void setRiskCode(String riskCode) {
        this.riskCode = riskCode;
    }
}
