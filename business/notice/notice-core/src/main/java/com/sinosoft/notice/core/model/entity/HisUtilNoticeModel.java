package com.sinosoft.notice.core.model.entity;

import com.sinosoft.framework.core.dao.BaseEntityImpl;

import javax.persistence.*;
import java.util.Date;

/**
 * @author 潘峰
 * @date 2017/12/4 上午11:22
 */
@Entity
@Table(name = "HisUtilNoticeModel")
@IdClass(HisUtilNoticeModel.class)
public class HisUtilNoticeModel extends BaseEntityImpl {

    private static final long serialVersionUID = 1L;
    /**
     * 属性通知类型：短信1,邮件2/通知类型：短信1,邮件2
     */
    @Id
    @Column(name = "noticeType")
    private String noticeType;
    /**
     * 属性模板编号/模板编号
     */
    @Id
    @Column(name = "noticeCode")
    private String noticeCode;
    /**
     * 序号：考虑多次修改的情况
     */
    @Id
    @Column(name = "serialNo")
    private Integer serialNo = 0;

    /**
     * 险种代码
     */
    @Column(name = "riskCode")
    private String riskCode;
    /**
     * 属性模板名称/模板名称
     */
    @Column(name = "noticeName")
    private String noticeName;
    /**
     * 属性模板内容/模板内容
     */
    @Column(name = "noticeContent")
    private String noticeContent;
    /**
     * 系统或模块编码（先在短信平台里注册01-99）-国元短信平台需要
     */
    @Column(name = "moduleCode")
    private String moduleCode;

    /**
     * 启用状态 0 不启用 1 启用
     */
    @Column(name = "status")
    private String status;
    /**
     * 有效开始时间
     */
    @Column(name = "validStartDate")
    private Date validStartDate;
    /**
     * 有效开始时间
     */
    @Column(name = "validEndDate")
    private Date validEndDate;
    /**
     * 登录机构
     */
    @Column(name = "comCode")
    private String comCode;
    /**
     * 是否逻辑删除 1 没有删除 0 删除
     */
    @Column(name = "deleteFlag")
    private String deleteFlag;

    public String getDeleteFlag() {
        return deleteFlag;
    }

    public void setDeleteFlag(String deleteFlag) {
        this.deleteFlag = deleteFlag;
    }

    public String getRiskCode() {
        return riskCode;
    }

    public void setRiskCode(String riskCode) {
        this.riskCode = riskCode;
    }

    public Integer getSerialNo() {
        return serialNo;
    }

    public void setSerialNo(Integer serialNo) {
        this.serialNo = serialNo;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getValidStartDate() {
        return validStartDate;
    }

    public void setValidStartDate(Date validStartDate) {
        this.validStartDate = validStartDate;
    }

    public Date getValidEndDate() {
        return validEndDate;
    }

    public void setValidEndDate(Date validEndDate) {
        this.validEndDate = validEndDate;
    }

    public String getComCode() {
        return comCode;
    }

    public void setComCode(String comCode) {
        this.comCode = comCode;
    }

    /**
     * 属性通知类型：短信1,邮件2/通知类型：短信1,邮件2的getter方法
     */
    public String getNoticeType() {
        return noticeType;
    }

    /**
     * 属性通知类型：短信1,邮件2/通知类型：短信1,邮件2的setter方法
     */
    public void setNoticeType(String noticeType) {
        this.noticeType = noticeType;
    }

    /**
     * 属性模板编号/模板编号的getter方法
     */
    public String getNoticeCode() {
        return noticeCode;
    }

    /**
     * 属性模板编号/模板编号的setter方法
     */
    public void setNoticeCode(String noticeCode) {
        this.noticeCode = noticeCode;
    }

    /**
     * 属性模板名称/模板名称的getter方法
     */
    public String getNoticeName() {
        return noticeName;
    }

    /**
     * 属性模板名称/模板名称的setter方法
     */
    public void setNoticeName(String noticeName) {
        this.noticeName = noticeName;
    }

    /**
     * 属性模板内容/模板内容的getter方法
     */
    public String getNoticeContent() {
        return noticeContent;
    }

    /**
     * 属性模板内容/模板内容的setter方法
     */
    public void setNoticeContent(String noticeContent) {
        this.noticeContent = noticeContent;
    }



    public String getModuleCode() {
        return moduleCode;
    }

    public void setModuleCode(String moduleCode) {
        this.moduleCode = moduleCode;
    }
}