package com.sinosoft.agriprpall.api.client.dto;

import java.util.List;

public class RequesttrashTranDto {

    private String userCode;

    private String visaCode;
    private List<String> businessNos;

    public String getUserCode() {
        return userCode;
    }

    public String getVisaCode() {
        return visaCode;
    }

    public void setVisaCode(String visaCode) {
        this.visaCode = visaCode;
    }

    public void setUserCode(String userCode) {
        this.userCode = userCode;
    }

    public List<String> getBusinessNos() {
        return businessNos;
    }

    public void setBusinessNos(List<String> businessNos) {
        this.businessNos = businessNos;
    }
}
