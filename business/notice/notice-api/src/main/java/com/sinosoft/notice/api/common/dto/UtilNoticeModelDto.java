package com.sinosoft.notice.api.common.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.sinosoft.framework.dto.BasePageableRequest;
import com.sinosoft.ims.api.kernel.dto.CompanyListDto;

import java.util.Date;
import java.util.List;

/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time 2017-11-30 07:15:42.402
 * 通知模板表实体操作对象
 */
public class UtilNoticeModelDto extends BasePageableRequest implements java.io.Serializable {

    private static final long serialVersionUID = 1L;
    /**
     * 属性通知类型：短信1,邮件2/通知类型：短信1,邮件2
     */
    private String noticeType;
    /**
     * 属性模板编号/模板编号
     */
    private String noticeCode;
    /**
     * 适用险种
     */
    private String riskCode;
    /**
     * 属性模板名称/模板名称
     */
    private String noticeName;
    /**
     * 属性模板内容/模板内容
     */
    private String noticeContent;
    /**
     * 属性优先级（1，2，3）其中3的级别最高/优先级（1，2，3）其中3的级别最高-国元短信平台需要
     */
    private String priority;
    /**
     * 系统或模块编码（先在短信平台里注册01-99）-国元短信平台需要
     */
    private String moduleCode;
    /**
     * 启用状态 0 不启用 1 启用
     */
    private String status;
    /**
     * 有效开始时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd",timezone = "GMT+8")
    private Date validStartDate;
    /**
     * 有效开始时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd",timezone = "GMT+8")
    private Date validEndDate;
    /**
     * 登录机构
     */
    private String comCode;
    /**
     * 是否逻辑删除 1 没有删除 0 删除
     */
    private String deleteFlag;

    private List<String> comCodeList;

    private String modelCreatedBy;

    private List<CompanyListDto> companyListDtos;

    public List<CompanyListDto> getCompanyListDtos() {
        return companyListDtos;
    }

    public void setCompanyListDtos(List<CompanyListDto> companyListDtos) {
        this.companyListDtos = companyListDtos;
    }

    /**
     * 短信模板创建时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    private Date createdTime;


    public String getModelCreatedBy() {
        return modelCreatedBy;
    }

    public void setModelCreatedBy(String modelCreatedBy) {
        this.modelCreatedBy = modelCreatedBy;
    }

    public Date getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(Date createdTime) {
        this.createdTime = createdTime;
    }

    public List<String> getComCodeList() {
        return comCodeList;
    }

    public void setComCodeList(List<String> comCodeList) {
        this.comCodeList = comCodeList;
    }

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

    /**
     * 属性优先级（1，2，3）其中3的级别最高/优先级（1，2，3）其中3的级别最高的getter方法
     */
    public String getPriority() {
        return priority;
    }

    /**
     * 属性优先级（1，2，3）其中3的级别最高/优先级（1，2，3）其中3的级别最高的setter方法
     */
    public void setPriority(String priority) {
        this.priority = priority;
    }

    public String getModuleCode() {
        return moduleCode;
    }

    public void setModuleCode(String moduleCode) {
        this.moduleCode = moduleCode;
    }
}