package com.sinosoft.uap.dto;

public class ResultResponseDto {

	private String resultType;
	private String errorType;
	private String errorInfo;
	private String configValue;
	private String certiNo;
	private String infoLogText;
	private String endorseNo;
	public String getConfigValue() {
		return configValue;
	}
	public void setConfigValue(String configValue) {
		this.configValue = configValue;
	}
	public ResultResponseDto() {
		errorType = "";
		errorInfo = "";
	}
	public String getResultType() {
		return resultType;
	}
	public void setResultType(String resultType) {
		this.resultType = resultType;
	}
	public String getErrorType() {
		return errorType;
	}
	public void setErrorType(String errorType) {
		this.errorType = errorType;
	}
	public String getErrorInfo() {
		return errorInfo;
	}
	public void setErrorInfo(String errorInfo) {
		this.errorInfo = errorInfo;
	}
	public String getCertiNo() {
		return certiNo;
	}
	public void setCertiNo(String certiNo) {
		this.certiNo = certiNo;
	}
	public String getInfoLogText() {
		return infoLogText;
	}
	public void setInfoLogText(String infoLogText) {
		this.infoLogText = infoLogText;
	}
	public String getEndorseNo() {
		return endorseNo;
	}
	public void setEndorseNo(String endorseNo) {
		this.endorseNo = endorseNo;
	}
	
}
