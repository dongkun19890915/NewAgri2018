package com.sinosoft.pms.api.kernel.dto;

public class RiskQueryConditionDto {
	
	/** 险类代码 */
	private String classCode;
	
	/** 险种代码 */
	private String riskCode;
	
	/** 险种名称 */
	private String riskCName;
	
	/** 有效标志 */
	private String validStatus;

	public String getClassCode() {
		return classCode;
	}

	public void setClassCode(String classCode) {
		this.classCode = classCode;
	}

	public String getRiskCode() {
		return riskCode;
	}

	public void setRiskCode(String riskCode) {
		this.riskCode = riskCode;
	}

	public String getRiskCName() {
		return riskCName;
	}

	public void setRiskCName(String riskCName) {
		this.riskCName = riskCName;
	}

	public String getValidStatus() {
		return validStatus;
	}

	public void setValidStatus(String validStatus) {
		this.validStatus = validStatus;
	}

}
