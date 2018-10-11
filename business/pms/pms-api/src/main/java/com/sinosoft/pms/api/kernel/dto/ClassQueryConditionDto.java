package com.sinosoft.pms.api.kernel.dto;

public class ClassQueryConditionDto {
	
	/** 险类代码 */
	private String classCode;
	
	/** 险类名称 */
	private String className;
	
	/** 有效标志 */
	private String validStatus;

	public String getClassCode() {
		return classCode;
	}

	public void setClassCode(String classCode) {
		this.classCode = classCode;
	}

	public String getClassName() {
		return className;
	}

	public void setClassName(String className) {
		this.className = className;
	}

	public String getValidStatus() {
		return validStatus;
	}

	public void setValidStatus(String validStatus) {
		this.validStatus = validStatus;
	}

}
