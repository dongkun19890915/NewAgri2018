package com.sinosoft.uap.dto;

public class HeadResponseDto {

	private String requestType;
	private String requestSeqNo;
	private String flowInTime;
	public String getRequestType() {
		return requestType;
	}
	public void setRequestType(String requestType) {
		this.requestType = requestType;
	}
	
	public String getRequestSeqNo() {
		return requestSeqNo;
	}
	public void setRequestSeqNo(String requestSeqNo) {
		this.requestSeqNo = requestSeqNo;
	}
	public String getFlowInTime() {
		return flowInTime;
	}
	public void setFlowInTime(String flowInTime) {
		this.flowInTime = flowInTime;
	}
	
}
