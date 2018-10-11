package com.sinosoft.agriclaim.api.workflowmanage.dto;

import com.sinosoft.framework.dto.BaseRequest;

import java.io.Serializable;

public class RequestQueryEndCaseDto extends BaseRequest implements Serializable {
    private static final long serialVersionUID = 1L;
    /** 保单号*/
    private String policyNo ;
    /** 报案号*/
    private String registNo ;
    /** 立案号*/
    private String claimNo ;
    /** 被保险人*/
    private String insuredName ;
    /** 流入时间从*/
    private String flowInStartDate ;
    /** 流入时间到*/
    private String flowInEndDate ;
    /** 险种大类*/
    private String riskClaimType ;
    /** 案件状态*/
    private String state ;
    /** 节点类型*/
    private String nodeType ;
    /** 处理人员代码*/
    private String handlerCode ;
    /** 跳转到多少页*/
    private Integer pageNo ;
    /** 每页多少条*/
    private Integer pageSize ;

    private String userCode;

    public String getUserCode() {
        return userCode;
    }

    public void setUserCode(String userCode) {
        this.userCode = userCode;
    }

    public String getFlowInStartDate() {
        return flowInStartDate;
    }

    public void setFlowInStartDate(String flowInStartDate) {
        this.flowInStartDate = flowInStartDate;
    }

    public String getFlowInEndDate() {
        return flowInEndDate;
    }

    public void setFlowInEndDate(String flowInEndDate) {
        this.flowInEndDate = flowInEndDate;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public Integer getPageNo() {
        return pageNo;
    }

    public void setPageNo(Integer pageNo) {
        this.pageNo = pageNo;
    }

    public String getNodeType() {
        return nodeType;
    }

    public void setNodeType(String nodeType) {
        this.nodeType = nodeType;
    }

    public String getHandlerCode() {
        return handlerCode;
    }

    public void setHandlerCode(String handlerCode) {
        this.handlerCode = handlerCode;
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

    public String getClaimNo() {
        return claimNo;
    }

    public void setClaimNo(String claimNo) {
        this.claimNo = claimNo;
    }

    public String getInsuredName() {
        return insuredName;
    }

    public void setInsuredName(String insuredName) {
        this.insuredName = insuredName;
    }

    public String getRiskClaimType() {
        return riskClaimType;
    }

    public void setRiskClaimType(String riskClaimType) {
        this.riskClaimType = riskClaimType;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }
}
