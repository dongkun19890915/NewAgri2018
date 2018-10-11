package com.sinosoft.agriprpall.api.proposalmanage.dto;

import com.sinosoft.framework.dto.BaseRequest;

import java.io.Serializable;

/**
 * @Description: 投保单查询列表信息responseDtoApi操作对象
 * @Author: 何伟东
 * @Date: 2017/10/15 11:19
 */
public class ResponseQueryProposalListInfoDto extends BaseRequest implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * 金禾的清单号码
     */
    private String gisInsureListCode;
    /**
     * 政策标志
     */
    private String businessType1;
    /**
     * 属性投保单号/投保单号
     */
    private String proposalNo;
    /**
     * 属性合同号/合同号
     */
    private String contractNo;
    /**
     * 属性被保险人名称/被保险人名称
     */
    private String insuredName;
    /**
     * 属性投保人名称/投保人名称
     */
    private String appliName;
    /**
     * 属性保险起期/保险起期
     */
    private String startDate;
    /**
     * 属性险种
     */
    private String riskCode;
    /**
     * 属性险种名称
     */
    private String riskCname;
    /**
     * 属性终保日期/终保日期
     */
    private String endDate;
    /**
     * 属性操作员代码/操作员代码
     */
    private String operatorCode;
    /**
     * 属性操作员名称/操作员名称
     */
    private String operatorName;
    /**
     * 属性输入日期/输入日期
     */
    private String inputDate;
    /**
     * 属性投保状态0初始值,1通过,2不通过,3无需核保,9待核保/投保状态0初始值,1通过,2不通过,3无需核保,9待核保
     */
    private String underWriteFlag;
    /**
     * 属性其它标志字段/其它标志字段
     */
    private String othFlag;
    /**
     * 属性签单日期（制单日期）/签单日期（制单日期）
     */
    private String operateDate;
    /**
     * 是否重复投保标志
     */
    private Boolean repeatFlag = false;

    public String getGisInsureListCode() {
        return gisInsureListCode;
    }

    public void setGisInsureListCode(String gisInsureListCode) {
        this.gisInsureListCode = gisInsureListCode;
    }

    public String getBusinessType1() {
        return businessType1;
    }

    public void setBusinessType1(String businessType1) {
        this.businessType1 = businessType1;
    }

    public String getProposalNo() {
        return proposalNo;
    }

    public void setProposalNo(String proposalNo) {
        this.proposalNo = proposalNo;
    }

    public String getContractNo() {
        return contractNo;
    }

    public void setContractNo(String contractNo) {
        this.contractNo = contractNo;
    }

    public String getInsuredName() {
        return insuredName;
    }

    public void setInsuredName(String insuredName) {
        this.insuredName = insuredName;
    }

    public String getAppliName() {
        return appliName;
    }

    public void setAppliName(String appliName) {
        this.appliName = appliName;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getRiskCode() {
        return riskCode;
    }

    public void setRiskCode(String riskCode) {
        this.riskCode = riskCode;
    }

    public String getRiskCname() {
        return riskCname;
    }

    public void setRiskCname(String riskCname) {
        this.riskCname = riskCname;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public String getOperatorCode() {
        return operatorCode;
    }

    public void setOperatorCode(String operatorCode) {
        this.operatorCode = operatorCode;
    }

    public String getOperatorName() {
        return operatorName;
    }

    public void setOperatorName(String operatorName) {
        this.operatorName = operatorName;
    }

    public String getInputDate() {
        return inputDate;
    }

    public void setInputDate(String inputDate) {
        this.inputDate = inputDate;
    }

    public String getUnderWriteFlag() {
        return underWriteFlag;
    }

    public void setUnderWriteFlag(String underWriteFlag) {
        this.underWriteFlag = underWriteFlag;
    }

    public String getOthFlag() {
        return othFlag;
    }

    public void setOthFlag(String othFlag) {
        this.othFlag = othFlag;
    }

    public String getOperateDate() {
        return operateDate;
    }

    public void setOperateDate(String operateDate) {
        this.operateDate = operateDate;
    }

    public Boolean getRepeatFlag() {
        return repeatFlag;
    }

    public void setRepeatFlag(Boolean repeatFlag) {
        this.repeatFlag = repeatFlag;
    }
}
