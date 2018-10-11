package com.sinosoft.notice.api.common.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.sinosoft.framework.dto.BaseRequest;

import java.io.Serializable;
import java.util.Date;

/**
 * @author 潘峰
 * @date 2017/11/22 上午10:51
 */
public class ReqMessageDto extends BaseRequest implements Serializable {
    private static final long serialVersionUID = 1L;

    //保单号码
    private String policyNo;

    //短信模板编号
    private String moduleCode;

    //短信模板内容
    private String noticeContent;


    //计划发送时间
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm", timezone = "GMT+8")
    private Date sendTime;

    //发送类型，1为短信，2为邮件
    private String noticeType;

    //发送优先权 1，2，3 1最低，3最高
    private String priority;


    //立即发送 t
    private Boolean immediatelySend;

    public Boolean getImmediatelySend() {
        return immediatelySend;
    }

    public void setImmediatelySend(Boolean immediatelySend) {
        this.immediatelySend = immediatelySend;
    }


    public String getPriority() {
        return priority;
    }

    public void setPriority(String priority) {
        this.priority = priority;
    }

    public String getNoticeType() {
        return noticeType;
    }

    public void setNoticeType(String noticeType) {
        this.noticeType = noticeType;
    }

    public String getPolicyNo() {
        return policyNo;
    }

    public void setPolicyNo(String policyNo) {
        this.policyNo = policyNo;
    }

    public String getModuleCode() {
        return moduleCode;
    }

    public void setModuleCode(String moduleCode) {
        this.moduleCode = moduleCode;
    }

    public String getNoticeContent() {
        return noticeContent;
    }

    public void setNoticeContent(String noticeContent) {
        this.noticeContent = noticeContent;
    }

    public Date getSendTime() {
        return sendTime;
    }

    public void setSendTime(Date sendTime) {
        this.sendTime = sendTime;
    }
}
