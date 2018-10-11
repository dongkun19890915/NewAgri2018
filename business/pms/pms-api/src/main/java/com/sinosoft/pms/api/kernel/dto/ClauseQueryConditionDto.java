package com.sinosoft.pms.api.kernel.dto;

public class ClauseQueryConditionDto {
	
	/** 条款代码 */
	private String clauseCode;
	
	/** 险类代码 */
	private String classCode;
	
	/** 险类名称 */
	private String clauseCName;
	
	/** 条款内容 */
	private String conText;
	
	/** 有效标志 */
	private String validStatus;

	public String getClauseCode() {
		return clauseCode;
	}

	public void setClauseCode(String clauseCode) {
		this.clauseCode = clauseCode;
	}

	public String getClassCode() {
		return classCode;
	}

	public void setClassCode(String classCode) {
		this.classCode = classCode;
	}

	public String getClauseCName() {
		return clauseCName;
	}

	public void setClauseCName(String clauseCName) {
		this.clauseCName = clauseCName;
	}

	public String getConText() {
		return conText;
	}

	public void setConText(String conText) {
		this.conText = conText;
	}

	public String getValidStatus() {
		return validStatus;
	}

	public void setValidStatus(String validStatus) {
		this.validStatus = validStatus;
	}

}
