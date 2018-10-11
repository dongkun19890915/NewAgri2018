package com.sinosoft.notice.api.common.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.sinosoft.framework.dto.BaseRequest;

import java.io.Serializable;
import java.util.Date;

/**
 * 短信内容表dto
 * @author: 何伟东
 * @date: 2017/12/12 10:38
 */
public class SmsContentDto extends BaseRequest implements Serializable {
    private static final long serialVersionUID = 1L;

    private String id;

    /**
     * 业务号码
     */
    private String businessNo;

    private String policyNo;

    private String insuredName;

    /**
     * 投保人名称
     */
    private String appName;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm", timezone = "GMT+8")
    private Date sendTime;

    private String content;

    private String phoneNo;

    /**
     * 出单机构
     */
    private String makeCom;

    /**
     * 险种名称
     */
    private String kindName;

    /**
     * 投保人代码
     */
    private String appCode;

    /**
     * 被保险人代码
     */
    private String insuredCode;


    /**
     * 起保日期
     */
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    private Date startDate;

    /**
     * 终保保日期
     */
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    private Date endDate;

    /**
     * 短信发送三种状态 0 发送失败 1 未发送  2 正在发送 3 发送成功
     * 分布式业务无关字段，防止重发短信
     */
    private String distributed;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getBusinessNo() {
        return businessNo;
    }

    public void setBusinessNo(String businessNo) {
        this.businessNo = businessNo;
    }

    public String getPolicyNo() {
        return policyNo;
    }

    public void setPolicyNo(String policyNo) {
        this.policyNo = policyNo;
    }

    public String getInsuredName() {
        return insuredName;
    }

    public void setInsuredName(String insuredName) {
        this.insuredName = insuredName;
    }

    public String getAppName() {
        return appName;
    }

    public void setAppName(String appName) {
        this.appName = appName;
    }

    public Date getSendTime() {
        return sendTime;
    }

    public void setSendTime(Date sendTime) {
        this.sendTime = sendTime;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
    }

    public String getMakeCom() {
        return makeCom;
    }

    public void setMakeCom(String makeCom) {
        this.makeCom = makeCom;
    }

    public String getKindName() {
        return kindName;
    }

    public void setKindName(String kindName) {
        this.kindName = kindName;
    }

    public String getAppCode() {
        return appCode;
    }

    public void setAppCode(String appCode) {
        this.appCode = appCode;
    }

    public String getInsuredCode() {
        return insuredCode;
    }

    public void setInsuredCode(String insuredCode) {
        this.insuredCode = insuredCode;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public String getDistributed() {
        return distributed;
    }

    public void setDistributed(String distributed) {
        this.distributed = distributed;
    }
}
