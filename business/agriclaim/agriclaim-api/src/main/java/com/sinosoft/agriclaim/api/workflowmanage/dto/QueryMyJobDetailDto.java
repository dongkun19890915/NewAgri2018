package com.sinosoft.agriclaim.api.workflowmanage.dto;

import com.sinosoft.framework.dto.BasePageableRequest;

public class QueryMyJobDetailDto  extends BasePageableRequest{
	private static final long serialVersionUID = 1L;
	/**属性当前操作人*/
	private String handlerCode;
	/**属性工作流号*/
	private String flowId;
	/**属性工作流的点*/
	private java.lang.Integer logNo;
	/**属性保单号*/
	private String policyNo;
	/**属性报案号*/	
	private String registNo;
	/**属性节点名称*/
	private String nodeType;
	/**属性节点状态*/
	private String nodeStatus;
	/**属性案件状态*/
	private String nodeStatusName;
	/**属性报案时间*/
	private java.util.Date reportDate;

	private String businessNo;

	public String getBusinessNo() {
		return businessNo;
	}

	public void setBusinessNo(String businessNo) {
		this.businessNo = businessNo;
	}

	/**
	 * @return the handlerCode
	 */
	public String getHandlerCode() {
		return handlerCode;
	}
	/**
	 * @param handlerCode the handlerCode to set
	 */
	public void setHandlerCode(String handlerCode) {
		this.handlerCode = handlerCode;
	}
	/**
	 * @return the flowId
	 */
	public String getFlowId() {
		return flowId;
	}
	/**
	 * @param flowId the flowId to set
	 */
	public void setFlowId(String flowId) {
		this.flowId = flowId;
	}
	/**
	 * @return the logNo
	 */
	public java.lang.Integer getLogNo() {
		return logNo;
	}
	/**
	 * @param logNo the logNo to set
	 */
	public void setLogNo(java.lang.Integer logNo) {
		this.logNo = logNo;
	}
	/**
	 * @return the policyNo
	 */
	public String getPolicyNo() {
		return policyNo;
	}
	/**
	 * @param policyNo the policyNo to set
	 */
	public void setPolicyNo(String policyNo) {
		this.policyNo = policyNo;
	}
	/**
	 * @return the registNo
	 */
	public String getRegistNo() {
		return registNo;
	}
	/**
	 * @param registNo the registNo to set
	 */
	public void setRegistNo(String registNo) {
		this.registNo = registNo;
	}
	/**
	 * @return the nodeType
	 */
	public String getNodeType() {
		return nodeType;
	}
	/**
	 * @param nodeType the nodeType to set
	 */
	public void setNodeType(String nodeType) {
		this.nodeType = nodeType;
	}
	/**
	 * @return the nodeStatus
	 */
	public String getNodeStatus() {
		return nodeStatus;
	}
	/**
	 * @param nodeStatus the nodeStatus to set
	 */
	public void setNodeStatus(String nodeStatus) {
		this.nodeStatus = nodeStatus;
	}
	/**
	 * @return the nodeStatusName
	 */
	public String getNodeStatusName() {
		return nodeStatusName;
	}
	/**
	 * @param nodeStatusName the nodeStatusName to set
	 */
	public void setNodeStatusName(String nodeStatusName) {
		this.nodeStatusName = nodeStatusName;
	}
	/**
	 * @return the reportDate
	 */
	public java.util.Date getReportDate() {
		return reportDate;
	}
	/**
	 * @param reportDate the reportDate to set
	 */
	public void setReportDate(java.util.Date reportDate) {
		this.reportDate = reportDate;
	}
	
}
