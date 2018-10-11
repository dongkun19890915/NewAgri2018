package com.sinosoft.ims.api.auth.dto;

import java.io.Serializable;

import com.sinosoft.framework.dto.BasePageableRequest;

public class PowerConditionDto extends BasePageableRequest implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private String systemCode;
	
	private String userCode;

    private String riskCode;
    
    private String comCode;
    
    private String queryComType;//查询的机构方式
    
    private String dataUserCode;
    
    private String dataComCode;
    
    private String tableName;
    
    private String gradeCodes;//岗位代码列表（多个时逗号分割)
    
    private String taskCodes;//任务代码列表（多个时逗号分割)
    
    private String userCodeFields;//用户字段名称列表（多个时逗号分割)
    
    private String comCodeFields;//机构字段名称列表（多个时逗号分割)

	public String getSystemCode() {
		return systemCode;
	}

	public void setSystemCode(String systemCode) {
		this.systemCode = systemCode;
	}

	public String getUserCode() {
		return userCode;
	}

	public void setUserCode(String userCode) {
		this.userCode = userCode;
	}

	public String getRiskCode() {
		return riskCode;
	}

	public void setRiskCode(String riskCode) {
		this.riskCode = riskCode;
	}

	public String getComCode() {
		return comCode;
	}

	public void setComCode(String comCode) {
		this.comCode = comCode;
	}

	public String getDataUserCode() {
		return dataUserCode;
	}

	public void setDataUserCode(String dataUserCode) {
		this.dataUserCode = dataUserCode;
	}

	public String getDataComCode() {
		return dataComCode;
	}

	public void setDataComCode(String dataComCode) {
		this.dataComCode = dataComCode;
	}

	public String getTableName() {
		return tableName;
	}

	public void setTableName(String tableName) {
		this.tableName = tableName;
	}

	public String getGradeCodes() {
		return gradeCodes;
	}

	public void setGradeCodes(String gradeCodes) {
		this.gradeCodes = gradeCodes;
	}

	public String getTaskCodes() {
		return taskCodes;
	}

	public void setTaskCodes(String taskCodes) {
		this.taskCodes = taskCodes;
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

	public String getQueryComType() {
		return queryComType;
	}

	public void setQueryComType(String queryComType) {
		this.queryComType = queryComType;
	}

}
