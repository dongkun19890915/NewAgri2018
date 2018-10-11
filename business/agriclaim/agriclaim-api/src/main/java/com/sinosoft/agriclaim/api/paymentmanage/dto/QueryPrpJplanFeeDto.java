package com.sinosoft.agriclaim.api.paymentmanage.dto;

public class QueryPrpJplanFeeDto {
    //属性 计算书号
    private String certiNo = "";
    //属性 报案号码
    private String registNo = "";
    //属性 保单号码
    private String policyNo = "";
    //属性 赔款类型
    private String payRefReason = "";
    //属性 被保险人名称
    private String insuredName = "";
    //属性 流入时间起
    private String flowStartDate = "";
    //属性 流入时间止
    private String flowEndDate = "";
    //属性 案件类型
    private String comCode = "";
    //属性 支付类型
    private String certiType = "";

    public String getCertiNo() {
        return certiNo;
    }

    public void setCertiNo(String certiNo) {
        this.certiNo = certiNo;
    }

    public String getRegistNo() {
        return registNo;
    }

    public void setRegistNo(String registNo) {
        this.registNo = registNo;
    }

    public String getPolicyNo() {
        return policyNo;
    }

    public void setPolicyNo(String policyNo) {
        this.policyNo = policyNo;
    }

    public String getInsuredName() {
        return insuredName;
    }

    public void setInsuredName(String insuredName) {
        this.insuredName = insuredName;
    }

    public String getFlowStartDate() {
        return flowStartDate;
    }

    public void setFlowStartDate(String flowStartDate) {
        this.flowStartDate = flowStartDate;
    }

    public String getFlowEndDate() {
        return flowEndDate;
    }

    public void setFlowEndDate(String flowEndDate) {
        this.flowEndDate = flowEndDate;
    }

    public String getComCode() {
        return comCode;
    }

    public void setComCode(String comCode) {
        this.comCode = comCode;
    }

    public String getCertiType() {
        return certiType;
    }

    public void setCertiType(String certiType) {
        this.certiType = certiType;
    }

    public String getPayRefReason() {
        return payRefReason;
    }

    public void setPayRefReason(String payRefReason) {
        this.payRefReason = payRefReason;
    }
}
