package com.sinosoft.agriclaim.api.recasemanage.dto;

import com.sinosoft.framework.dto.BaseRequest;

import java.io.Serializable;

public class UndwrtWriteBackReCaseDto extends BaseRequest implements Serializable {
    private static final long serialVersionUID = 1L;

    private String LflowID;

    private int LlogNo;

    private String businessNo;

    private String notionInfo;

    private String handlerCode;

    private String undwrtFlag;

    private String nodeNo ;

    public String getLflowID() {
        return LflowID;
    }

    public void setLflowID(String lflowID) {
        LflowID = lflowID;
    }

    public int getLlogNo() {
        return LlogNo;
    }

    public void setLlogNo(int llogNo) {
        LlogNo = llogNo;
    }

    public String getBusinessNo() {
        return businessNo;
    }

    public void setBusinessNo(String businessNo) {
        this.businessNo = businessNo;
    }

    public String getNotionInfo() {
        return notionInfo;
    }

    public void setNotionInfo(String notionInfo) {
        this.notionInfo = notionInfo;
    }

    public String getHandlerCode() {
        return handlerCode;
    }

    public void setHandlerCode(String handlerCode) {
        this.handlerCode = handlerCode;
    }

    public String getUndwrtFlag() {
        return undwrtFlag;
    }

    public void setUndwrtFlag(String undwrtFlag) {
        this.undwrtFlag = undwrtFlag;
    }

    public String getNodeNo() {
        return nodeNo;
    }

    public void setNodeNo(String nodeNo) {
        this.nodeNo = nodeNo;
    }
}
