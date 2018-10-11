package com.sinosoft.agriprpall.api.endorsemanage.dto;

import java.util.Date;

public class EndorsePrintDto {
    private String endorseTexts;
    private String handlerName ;
    private String underwriteName ;
    private String operatorName ;
    private String endorDate ;
    private String dataFlag ;
    private String oneFlag ;
    private String twoFlag ;
    private String threeFlag ;

    public String getDataFlag() {
        return dataFlag;
    }

    public void setDataFlag(String dataFlag) {
        this.dataFlag = dataFlag;
    }

    public String getOneFlag() {
        return oneFlag;
    }

    public void setOneFlag(String oneFlag) {
        this.oneFlag = oneFlag;
    }

    public String getTwoFlag() {
        return twoFlag;
    }

    public void setTwoFlag(String twoFlag) {
        this.twoFlag = twoFlag;
    }

    public String getThreeFlag() {
        return threeFlag;
    }

    public void setThreeFlag(String threeFlag) {
        this.threeFlag = threeFlag;
    }

    public String getEndorseTexts() {
        return endorseTexts;
    }

    public void setEndorseTexts(String endorseTexts) {
        this.endorseTexts = endorseTexts;
    }

    public String getHandlerName() {
        return handlerName;
    }

    public void setHandlerName(String handlerName) {
        this.handlerName = handlerName;
    }

    public String getUnderwriteName() {
        return underwriteName;
    }

    public void setUnderwriteName(String underwriteName) {
        this.underwriteName = underwriteName;
    }

    public String getOperatorName() {
        return operatorName;
    }

    public void setOperatorName(String operatorName) {
        this.operatorName = operatorName;
    }

    public String getEndorDate() {
        return endorDate;
    }

    public void setEndorDate(String endorDate) {
        this.endorDate = endorDate;
    }
}
