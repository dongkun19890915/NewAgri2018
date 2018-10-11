package com.sinosoft.agriclaim.api.schedulemanage.dto;

import com.sinosoft.framework.dto.BasePageableRequest;

import java.io.Serializable;

/**
 * @author zhangjin
 * @mail zhangjin2017@sinosoft.com.cn
 * @time 2017-10-27 15:25 调度任务入参操作对象
 */
public class InParameterSchedulDto extends BasePageableRequest implements Serializable {
    private static final long serialVersionUID = 1L;
   
    /** 节点状态*/
    private String status;
    /** 节点类型*/
    private String nodeType;
    /** 报案号*/
    private String registNo;
    /** 保单号*/
    private String policyNo;
    /**被保人姓名*/
    private String insuredName;
    /**流入结束时间*/
    private String flowInTimeEnd;
    /** 流入开始时间*/
    private String flowInTimeStart;
    /** 节点状态*/
    private String nodeStatus;
    /** 险种代码*/
    private String riskCode;
    /** 险种大类*/
    private String riskType;
    /*用户登录机构代码*/
    private String loginComCode;
    /*用户代码*/
    private String userCode;
    /*用户登录岗位代码*/
    private String loginGradeCodes;
    /*表名*/
    private String tableName;
    /*userCode字段*/
    private String userCodeFields;
    /*comCode字段*/
    private String comCodeFields;

    public InParameterSchedulDto() {
        super();
    }

    public String getNodeType() {
        return nodeType;
    }

    public void setNodeType(String nodeType) {
        this.nodeType = nodeType;
    }

    public String getRegistNo() {
        return registNo;
    }

    public void setRegistNo(String registNo) {
        this.registNo = registNo;
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

    public String getFlowInTimeEnd() {
        return flowInTimeEnd;
    }

    public void setFlowInTimeEnd(String flowInTimeEnd) {
        this.flowInTimeEnd = flowInTimeEnd;
    }

    public String getFlowInTimeStart() {
        return flowInTimeStart;
    }

    public void setFlowInTimeStart(String flowInTimeStart) {
        this.flowInTimeStart = flowInTimeStart;
    }

    public String getNodeStatus() {
        return nodeStatus;
    }

    public void setNodeStatus(String nodeStatus) {
        this.nodeStatus = nodeStatus;
    }

    public static long getSerialversionuid() {
        return serialVersionUID;
    }

    public String getRiskCode() {
        return riskCode;
    }

    public void setRiskCode(String riskCode) {
        this.riskCode = riskCode;
    }

    public String getRiskType() {
        return riskType;
    }

    public void setRiskType(String riskType) {
        this.riskType = riskType;
    }

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

    public String getLoginComCode() {
        return loginComCode;
    }

    public void setLoginComCode(String loginComCode) {
        this.loginComCode = loginComCode;
    }

    public String getUserCode() {
        return userCode;
    }

    public void setUserCode(String userCode) {
        this.userCode = userCode;
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
