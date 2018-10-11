package com.sinosoft.newagriprpall.webservice.dto;

public class RequestUnderwriteSubmitDto {
	/**
	 * 模板类型
	 */
	private String modelType;
	/**
	 * 业务类型
	 */
	private String certiType;
	/**
	 * 业务号
	 */
	private String businessNo;
	/**
	 * 险种代码
	 */
	private String riskCode;
	/**
	 * 险类代码
	 */
	private String classCode;
	/**
	 * 业务归属机构
	 */
	private String comCode;
	/**
	 * 出单机构
	 */
	private String makecom;
	/**
	 * 登录用户代码
	 */
	private String userCode;
	/**
	 * 经办人代码
	 */
	private String handlerCode;
	/**
	 * 归属业务员代码
	 */
	private String handler1Code;
	/**
	 * 合同号
	 */
	private String contractNo;

	/**
	 * 业务流号
	 */
	private String flowId;

    private String lflowID;//理赔工作流号码
    private String llogNo;//理赔工作流节点号码
	
	public String getFlowId() {
		return flowId;
	}

	public void setFlowId(String flowId) {
		this.flowId = flowId;
	}
	public String getModelType() {
		return modelType;
	}

	public void setModelType(String modelType) {
		this.modelType = modelType;
	}

	public String getCertiType() {
		return certiType;
	}

	public void setCertiType(String certiType) {
		this.certiType = certiType;
	}

	public String getBusinessNo() {
		return businessNo;
	}

	public void setBusinessNo(String businessNo) {
		this.businessNo = businessNo;
	}

	public String getRiskCode() {
		return riskCode;
	}

	public void setRiskCode(String riskCode) {
		this.riskCode = riskCode;
	}

	public String getClassCode() {
		return classCode;
	}

	public void setClassCode(String classCode) {
		this.classCode = classCode;
	}

	public String getComCode() {
		return comCode;
	}

	public void setComCode(String comCode) {
		this.comCode = comCode;
	}

	public String getMakecom() {
		return makecom;
	}

	public void setMakecom(String makecom) {
		this.makecom = makecom;
	}

	public String getUserCode() {
		return userCode;
	}

	public void setUserCode(String userCode) {
		this.userCode = userCode;
	}

	public String getHandlerCode() {
		return handlerCode;
	}

	public void setHandlerCode(String handlerCode) {
		this.handlerCode = handlerCode;
	}

	public String getHandler1Code() {
		return handler1Code;
	}

	public void setHandler1Code(String handler1Code) {
		this.handler1Code = handler1Code;
	}

	public String getContractNo() {
		return contractNo;
	}

	public void setContractNo(String contractNo) {
		this.contractNo = contractNo;
	}

	public String getLflowID() {
		return lflowID;
	}

	public void setLflowID(String lflowID) {
		this.lflowID = lflowID;
	}

	public String getLlogNo() {
		return llogNo;
	}

	public void setLlogNo(String llogNo) {
		this.llogNo = llogNo;
	}

}
