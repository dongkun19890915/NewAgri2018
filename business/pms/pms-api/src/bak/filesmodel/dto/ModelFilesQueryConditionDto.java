package com.sinosoft.pms.api.filesmodel.dto;

public class ModelFilesQueryConditionDto implements java.io.Serializable {
	
	private static final long serialVersionUID = 1L;
	
	/** 属性RiskCode/产品 */
	private String riskCode ;
	/** 属性ModelType/模板类型 */
	private String modelType ;
	
	
	public String getRiskCode() {
		return riskCode;
	}
	public void setRiskCode(String riskCode) {
		this.riskCode = riskCode;
	}
	public String getModelType() {
		return modelType;
	}
	public void setModelType(String modelType) {
		this.modelType = modelType;
	}
	
	
	
}
