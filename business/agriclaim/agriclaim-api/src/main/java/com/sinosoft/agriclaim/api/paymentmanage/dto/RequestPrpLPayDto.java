package com.sinosoft.agriclaim.api.paymentmanage.dto;

import java.io.Serializable;

public class RequestPrpLPayDto implements Serializable{
    /** 支付审核标志*/
    private String payType;
    /** 流程号*/
    private String lflowID;
    /** 节点号*/
    private Integer llogNo;
    /** 业务号*/
    private String businessNo;
    /** 审核信息*/
    private String notionInfo;
    /** 处理人代码*/
    private String handlerCode;

    public String getPayType() {
        return payType;
    }

    public void setPayType(String payType) {
        this.payType = payType;
    }

    public String getLflowID() {
        return lflowID;
    }

    public void setLflowID(String lflowID) {
        this.lflowID = lflowID;
    }

    public Integer getLlogNo() {
        return llogNo;
    }

    public void setLlogNo(Integer llogNo) {
        this.llogNo = llogNo;
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
}
