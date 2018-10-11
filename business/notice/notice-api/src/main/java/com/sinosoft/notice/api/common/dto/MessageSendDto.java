package com.sinosoft.notice.api.common.dto;

import com.sinosoft.framework.dto.BaseRequest;

import java.io.Serializable;

public class MessageSendDto extends BaseRequest implements Serializable{

    private String mobilePhones;
    private String content;
    private String priority;
    private String moduleCode;
    private String receiveCode;
    private String noticeType;
    private String businessNo1;

    public String getBusinessNo1() {
        return businessNo1;
    }

    public void setBusinessNo1(String businessNo1) {
        this.businessNo1 = businessNo1;
    }

    public String getNoticeType() {
        return noticeType;
    }

    public void setNoticeType(String noticeType) {
        this.noticeType = noticeType;
    }

    public String getMobilePhones() {
        return mobilePhones;
    }

    public void setMobilePhones(String mobilePhones) {
        this.mobilePhones = mobilePhones;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getPriority() {
        return priority;
    }

    public void setPriority(String priority) {
        this.priority = priority;
    }

    public String getModuleCode() {
        return moduleCode;
    }

    public void setModuleCode(String moduleCode) {
        this.moduleCode = moduleCode;
    }

    public String getReceiveCode() {
        return receiveCode;
    }

    public void setReceiveCode(String receiveCode) {
        this.receiveCode = receiveCode;
    }
}
