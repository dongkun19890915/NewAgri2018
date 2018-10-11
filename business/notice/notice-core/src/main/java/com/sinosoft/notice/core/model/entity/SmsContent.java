package com.sinosoft.notice.core.model.entity;

import com.sinosoft.framework.core.dao.BaseEntityImpl;

import javax.persistence.*;
import java.util.Date;

/**
 * @author 潘峰
 * @date 2017/11/22 上午9:59
 */
@Entity
@Table(name = "SmsContent")
@IdClass(SmsContentKey.class)
public class SmsContent extends BaseEntityImpl implements Cloneable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "id")
    private String id;

    /**
     * 业务号码
     */
    @Column(name = "businessNo")
    private String businessNo;

    @Column(name = "policyNo")
    private String policyNo;

    @Column(name = "insuredName")
    private String insuredName;

    /**
     * 投保人名称
     */
    @Column(name = "appName")
    private String appName;

    @Column(name = "sendTime")
    private Date sendTime;

    @Column(name = "content")
    private String content;

    @Column(name = "phoneNo")
    private String phoneNo;

    /**
     * 出单机构
     */
    @Column(name = "makeCom")
    private String makeCom;

    /**
     * 险种名称
     */
    @Column(name = "kindName")
    private String kindName;

    /**
     * 投保人代码
     */
    @Column(name = "appCode")
    private String appCode;

    /**
     * 被保险人代码
     */
    @Column(name = "insuredCode")
    private String insuredCode;

    /**
     * 起保日期
     */
    @Column(name = "startDate")
    private Date startDate;

    /**
     * 终保保日期
     */
    @Column(name = "endDate")
    private Date endDate;

    /**
     * 短信发送三种状态 0 发送失败 1 未发送  2 正在发送 3 发送成功
     * 分布式业务无关字段，防止重发短信
     */
    @Column(name = "distributed")
    private String distributed;

    /**
     * 重写父类 clone 方法
     *
     * @return
     * @author: 潘峰
     * @date: 2017/12/27 上午11:40
     */
    @Override
    public SmsContent clone() {
        SmsContent smsContent = null;
        try {
            smsContent = (SmsContent) super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return smsContent;
    }

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
