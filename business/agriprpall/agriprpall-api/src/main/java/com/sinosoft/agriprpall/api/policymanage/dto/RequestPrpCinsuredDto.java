package com.sinosoft.agriprpall.api.policymanage.dto;

public class RequestPrpCinsuredDto {
    //保单号
    private String policyNo;
    //序号
    private Integer serialNo;

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
}
