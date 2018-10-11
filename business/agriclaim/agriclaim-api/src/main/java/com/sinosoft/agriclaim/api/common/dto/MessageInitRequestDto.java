package com.sinosoft.agriclaim.api.common.dto;

import com.sinosoft.framework.dto.BaseRequest;

import java.io.Serializable;

public class MessageInitRequestDto extends BaseRequest implements Serializable{

    /** 保单号 */
    private String policyNo;

    /**报案号 */
    private String registNo;

    /**发送类型 0-发送给查勘人员 1-发送给报案人员 2-发送给被保险人 */
    private String messageType;

    /** 查勘定损人员代码 */
    private String handlerCode;

    /** 查勘定损人员姓名 */
    private String handlerName;

    public String getHandlerCode() {
        return handlerCode;
    }

    public void setHandlerCode(String handlerCode) {
        this.handlerCode = handlerCode;
    }

    public String getHandlerName() {
        return handlerName;
    }

    public void setHandlerName(String handlerName) {
        this.handlerName = handlerName;
    }

    public String getPolicyNo() {
        return policyNo;
    }

    public void setPolicyNo(String policyNo) {
        this.policyNo = policyNo;
    }

    public String getRegistNo() {
        return registNo;
    }

    public void setRegistNo(String registNo) {
        this.registNo = registNo;
    }

    public String getMessageType() {
        return messageType;
    }

    public void setMessageType(String messageType) {
        this.messageType = messageType;
    }
}
