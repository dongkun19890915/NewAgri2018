package com.sinosoft.agriclaim.api.prepaymanage.dto;


import java.io.Serializable;

import com.sinosoft.framework.dto.BaseRequest;

public class PrepayApplicationDto extends BaseRequest implements Serializable{
	private static final long serialVersionUID = 1L;
	/** 属性流程编号 */
	private String flowID;
	/** 属性序号 */
	private Integer logNo;
	/** 申请原因 */
	private String content;
	 /** 属性类型标志 */
	private String typeFlag;
	 /** 立案号 */
	private String claimNo;
	/** 原来节点的状态 */
	private String nodeStatus;
	
	public String getFlowID() {
		return flowID;
	}
	public void setFlowID(String flowID) {
		this.flowID = flowID;
	}
	public String getTypeFlag() {
		return typeFlag;
	}
	public void setTypeFlag(String typeFlag) {
		this.typeFlag = typeFlag;
	}
	public Integer getLogNo() {
		return logNo;
	}
	public void setLogNo(Integer logNo) {
		this.logNo = logNo;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getClaimNo() {
		return claimNo;
	}
	public void setClaimNo(String claimNo) {
		this.claimNo = claimNo;
	}
	public String getNodeStatus() {
		return nodeStatus;
	}
	public void setNodeStatus(String nodeStatus) {
		this.nodeStatus = nodeStatus;
	}
	
	
}
