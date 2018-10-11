package com.sinosoft.agriprpall.api.client.dto;

public class RequestQueryVisaCodeDto {
    /**
     * ��֤����
     * p-������E-����
     */
    private String certiType;
    /**
     * ��������
     */
    private String comCode;
    /**
     * ���ִ���
     */
    private String riskCode;

    public String getCertiType() {
        return certiType;
    }

    public void setCertiType(String certiType) {
        this.certiType = certiType;
    }

    public String getComCode() {
        return comCode;
    }

    public void setComCode(String comCode) {
        this.comCode = comCode;
    }

    public String getRiskCode() {
        return riskCode;
    }

    public void setRiskCode(String riskCode) {
        this.riskCode = riskCode;
    }

}
