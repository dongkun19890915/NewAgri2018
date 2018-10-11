package com.sinosoft.agriclaim.api.workflowmanage.dto;

import com.sinosoft.framework.dto.BasePageableRequest;

public class QueryMyJobSwfLogDto extends BasePageableRequest{
	private static final long serialVersionUID = 1L;
	/**属性用户代码*/
	private String handlerCode ;
	/**属性节点名称*/
	private String nodeType;
	/**属性节点名称*/
	private String nodeName;
	/**属性保单号*/
	private String policyNo;
	/**属性报案号*/
	private String registNo;
	/**属性待处理数量*/
	private java.lang.Integer pendingNo;
	/**属性已处理数量*/
	private java.lang.Integer alreadyNo;
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
	 * @return the nodeName
	 */
	public String getNodeName() {
		return nodeName;
	}
	/**
	 * @param nodeName the nodeName to set
	 */
	public void setNodeName(String nodeName) {
		this.nodeName = nodeName;
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
	 * @return the pendingNo
	 */
	public java.lang.Integer getPendingNo() {
		return pendingNo;
	}
	/**
	 * @param pendingNo the pendingNo to set
	 */
	public void setPendingNo(java.lang.Integer pendingNo) {
		this.pendingNo = pendingNo;
	}
	/**
	 * @return the alreadyNo
	 */
	public java.lang.Integer getAlreadyNo() {
		return alreadyNo;
	}
	/**
	 * @param alreadyNo the alreadyNo to set
	 */
	public void setAlreadyNo(java.lang.Integer alreadyNo) {
		this.alreadyNo = alreadyNo;
	}
	
}
