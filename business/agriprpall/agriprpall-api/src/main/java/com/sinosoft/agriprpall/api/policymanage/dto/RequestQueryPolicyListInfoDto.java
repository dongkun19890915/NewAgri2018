package com.sinosoft.agriprpall.api.policymanage.dto;

import com.sinosoft.framework.dto.BasePageableRequest;

import java.io.Serializable;
import java.util.List;

/**
 *  保单查询列表信息requestDtoApi操作对象
 * @Author: 王心洋
 * @Date: 2017/10/26 16:13
 */
public class RequestQueryPolicyListInfoDto extends BasePageableRequest implements Serializable {

    private String loginComCode;
    private static final long serialVersionUID = 1L;
    /**属性保单号码*/
    private String policyNo;
    /** 属性投保单号/投保单号 */
    private String proposalNo ;
    /** 属性险种代码/险种代码 */
    private String riskCode ;
    /** 属性投保人代码/投保人代码 */
    private String appliCode ;
    /** 属性投保人名称/投保人名称 */
    private String appliName ;
    /** 属性被保险人代码/被保险人代码 */
    private String insuredCode ;
    /** 属性被保险人名称/被保险人名称 */
    private String insuredName ;
    /** 属性总保额/总保额 */
    private String sumAmount ;
    /** 属性总保费/总保费 */
    private String sumPremium ;
    /** 属性归属机构/归属机构 */
    private String comCode ;
    /** 属性经办人代码/业务员代码 */
    private String handlerCode ;
    /** 属性操作员代码/操作员代码 */
    private String operatorCode ;
    /**属性制单日期起期*/
    private String operateDateStart ;
    /**属性制单日期止期*/
    private String operateDateEnd ;
    /**
     * 属性起保日期/起保日期 区间
     */
    private String startDate;
    private String startDateEnd;
    /** 属性终保日期/终保日期 区间 */
    private String endDate;
    private String endStartDate ;
    /** 属性政策/商业标志 00商业险,01中央政策性,02地方政策性 */
    private String businessType1 ;
    /**属性印刷标志*/
    private String printFlag;
    /**属性查询标志，1-保单查询，2-特殊批改保单查询*/
    private  String queryFlag;
    /**属性保单号码止*/
    private String policyNoEnd;

    private List<String> policyNoRan;
    /**
     * 核保状态
     */
    private String underWriteFlag;
    /*用户代码*/
    private String userCode;
    /*用户登录机构代码*/
    /*用户登录岗位代码*/
    private String loginGradeCodes;
    /*表名*/
    private String tableName;
    /*userCode字段*/
    private String userCodeFields;
    /*comCode字段*/
    private String comCodeFields;

    private String imagingSystemFlag;
    /**
     * 属性农户姓名 /农户姓名(种植险专用)
     */
    private String fName;
    /**
     * 属性农户代码
     */
    private String fCode;

    public String getfName() {
        return fName;
    }

    public void setfName(String fName) {
        this.fName = fName;
    }

    public String getfCode() {
        return fCode;
    }

    public void setfCode(String fCode) {
        this.fCode = fCode;
    }

    public String getImagingSystemFlag() {
        return imagingSystemFlag;
    }

    public void setImagingSystemFlag(String imagingSystemFlag) {
        this.imagingSystemFlag = imagingSystemFlag;
    }

    public List<String> getPolicyNoRan() {
        return policyNoRan;
    }

    public void setPolicyNoRan(List<String> policyNoRan) {
        this.policyNoRan = policyNoRan;
    }

    public String getStartDateEnd() {
        return startDateEnd;
    }

    public void setStartDateEnd(String startDateEnd) {
        this.startDateEnd = startDateEnd;
    }

    public String getEndStartDate() {
        return endStartDate;
    }

    public void setEndStartDate(String endStartDate) {
        this.endStartDate = endStartDate;
    }

    public String getUnderWriteFlag() {
        return underWriteFlag;
    }

    public void setUnderWriteFlag(String underWriteFlag) {
        this.underWriteFlag = underWriteFlag;
    }

    public String getPolicyNoEnd() {
        return policyNoEnd;
    }

    public void setPolicyNoEnd(String policyNoEnd) {
        this.policyNoEnd = policyNoEnd;
    }

    public String getQueryFlag() {
        return queryFlag;
    }

    public void setQueryFlag(String queryFlag) {
        this.queryFlag = queryFlag;
    }

    public String getPolicyNo() {
        return policyNo;
    }

    public void setPolicyNo(String policyNo) {
        this.policyNo = policyNo;
    }

    public String getProposalNo() {
        return proposalNo;
    }

    public void setProposalNo(String proposalNo) {
        this.proposalNo = proposalNo;
    }

    public String getRiskCode() {
        return riskCode;
    }

    public void setRiskCode(String riskCode) {
        this.riskCode = riskCode;
    }

    public String getAppliCode() {
        return appliCode;
    }

    public void setAppliCode(String appliCode) {
        this.appliCode = appliCode;
    }

    public String getAppliName() {
        return appliName;
    }

    public void setAppliName(String appliName) {
        this.appliName = appliName;
    }

    public String getInsuredCode() {
        return insuredCode;
    }

    public void setInsuredCode(String insuredCode) {
        this.insuredCode = insuredCode;
    }

    public String getInsuredName() {
        return insuredName;
    }

    public void setInsuredName(String insuredName) {
        this.insuredName = insuredName;
    }

    public String getSumAmount() {
        return sumAmount;
    }

    public void setSumAmount(String sumAmount) {
        this.sumAmount = sumAmount;
    }

    public String getSumPremium() {
        return sumPremium;
    }

    public void setSumPremium(String sumPremium) {
        this.sumPremium = sumPremium;
    }

    public String getComCode() {
        return comCode;
    }

    public void setComCode(String comCode) {
        this.comCode = comCode;
    }

    public String getHandlerCode() {
        return handlerCode;
    }

    public void setHandlerCode(String handlerCode) {
        this.handlerCode = handlerCode;
    }

    public String getOperatorCode() {
        return operatorCode;
    }

    public void setOperatorCode(String operatorCode) {
        this.operatorCode = operatorCode;
    }

    public String getOperateDateStart() {
        return operateDateStart;
    }

    public void setOperateDateStart(String operateDateStart) {
        this.operateDateStart = operateDateStart;
    }

    public String getOperateDateEnd() {
        return operateDateEnd;
    }

    public void setOperateDateEnd(String operateDateEnd) {
        this.operateDateEnd = operateDateEnd;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public String getBusinessType1() {
        return businessType1;
    }

    public void setBusinessType1(String businessType1) {
        this.businessType1 = businessType1;
    }

    public String getPrintFlag() {
        return printFlag;
    }

    public void setPrintFlag(String printFlag) {
        this.printFlag = printFlag;
    }

    public String getUserCode() {
        return userCode;
    }

    public void setUserCode(String userCode) {
        this.userCode = userCode;
    }

    public String getLoginComCode() {
        return loginComCode;
    }

    public void setLoginComCode(String loginComCode) {
        this.loginComCode = loginComCode;
    }

    public String getLoginGradeCodes() {
        return loginGradeCodes;
    }

    public void setLoginGradeCodes(String loginGradeCodes) {
        this.loginGradeCodes = loginGradeCodes;
    }

    public String getTableName() {
        return tableName;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName;
    }

    public String getUserCodeFields() {
        return userCodeFields;
    }

    public void setUserCodeFields(String userCodeFields) {
        this.userCodeFields = userCodeFields;
    }

    public String getComCodeFields() {
        return comCodeFields;
    }

    public void setComCodeFields(String comCodeFields) {
        this.comCodeFields = comCodeFields;
    }
}
