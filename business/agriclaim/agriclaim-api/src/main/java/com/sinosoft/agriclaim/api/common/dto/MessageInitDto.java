package com.sinosoft.agriclaim.api.common.dto;

import com.sinosoft.framework.dto.BaseRequest;

import java.io.Serializable;
import java.util.List;

public class MessageInitDto extends BaseRequest implements Serializable{

    private List<String> message;

    private String handlerName;

    private String handlerPhoneNumber;

    private String reportorName;

    private String reportorPhoneNumber;

    private String insuredName;

    private String insuredPhoneNumber;


    public String getHandlerName() {
        return handlerName;
    }

    public void setHandlerName(String handlerName) {
        this.handlerName = handlerName;
    }

    public String getHandlerPhoneNumber() {
        return handlerPhoneNumber;
    }

    public void setHandlerPhoneNumber(String handlerPhoneNumber) {
        this.handlerPhoneNumber = handlerPhoneNumber;
    }

    public String getReportorName() {
        return reportorName;
    }

    public void setReportorName(String reportorName) {
        this.reportorName = reportorName;
    }

    public String getReportorPhoneNumber() {
        return reportorPhoneNumber;
    }

    public void setReportorPhoneNumber(String reportorPhoneNumber) {
        this.reportorPhoneNumber = reportorPhoneNumber;
    }

    public String getInsuredName() {
        return insuredName;
    }

    public void setInsuredName(String insuredName) {
        this.insuredName = insuredName;
    }

    public String getInsuredPhoneNumber() {
        return insuredPhoneNumber;
    }

    public void setInsuredPhoneNumber(String insuredPhoneNumber) {
        this.insuredPhoneNumber = insuredPhoneNumber;
    }

    public List<String> getMessage() {
        return message;
    }

    public void setMessage(List<String> message) {
        this.message = message;
    }
}
