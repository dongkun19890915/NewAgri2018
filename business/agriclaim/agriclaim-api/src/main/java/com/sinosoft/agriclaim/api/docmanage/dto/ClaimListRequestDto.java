package com.sinosoft.agriclaim.api.docmanage.dto;

import com.sinosoft.framework.dto.BaseRequest;

public class ClaimListRequestDto extends BaseRequest{

	private static final long serialVersionUID = 1L;
	private String status;
	private String nodeType;  //节点类型
	private String flowId; //工作流id
	private String logNo;  //工作日志no
	private String registNo;     //报案号
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getNodeType() {
		return nodeType;
	}
	public void setNodeType(String nodeType) {
		this.nodeType = nodeType;
	}
	public String getFlowId() {
		return flowId;
	}
	public void setFlowId(String flowId) {
		this.flowId = flowId;
	}
	public String getLogNo() {
		return logNo;
	}
	public void setLogNo(String logNo) {
		this.logNo = logNo;
	}
	public String getRegistNo() {
		return registNo;
	}
	public void setRegistNo(String registNo) {
		this.registNo = registNo;
	}
	
}
