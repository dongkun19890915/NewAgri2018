package com.sinosoft.agriclaim.api.workflowmanage.dto;

import com.sinosoft.framework.dto.BaseRequest;

import java.io.Serializable;

public class ResponseQueryEndCaseDto extends BaseRequest  implements Serializable {
    private static final long serialVersionUID = 1L;
    /** 保单号*/
    private String policyNo ;
    /** 报案号*/
    private String registNo ;
    /** 立案号*/
    private String claimNo ;
    /** 被保险人*/
    private String insuredName ;
    /** 流入时间*/
    private String flowInTime ;
    /** 处理人员*/
    private String handlerName ;
    /** 案件状态*/
    private String state ;
    /** 险种代码*/
    private String riskCode;
    /** 险种名称*/
    private String riskCodeName;

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

    public String getFlowInTime() {
        return flowInTime;
    }

    public void setFlowInTime(String flowInTime) {
        this.flowInTime = flowInTime;
    }

    public String getHandlerName() {
        return handlerName;
    }

    public void setHandlerName(String handlerName) {
        this.handlerName = handlerName;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getRiskCodeName() {
        return riskCodeName;
    }

    public void setRiskCodeName(String riskCodeName) {
        this.riskCodeName = riskCodeName;
    }

    public String getRiskCode() {
        return riskCode;
    }

    public void setRiskCode(String riskCode) {
        this.riskCode = riskCode;
    }
}
