package com.sinosoft.newagriprpall.webservice.dto;

public class RequestUnderwriteSubmitDto {
	/**
	 * ģ������
	 */
	private String modelType;
	/**
	 * ҵ������
	 */
	private String certiType;
	/**
	 * ҵ���
	 */
	private String businessNo;
	/**
	 * ���ִ���
	 */
	private String riskCode;
	/**
	 * �������
	 */
	private String classCode;
	/**
	 * ҵ���������
	 */
	private String comCode;
	/**
	 * ��������
	 */
	private String makecom;
	/**
	 * ��¼�û�����
	 */
	private String userCode;
	/**
	 * �����˴���
	 */
	private String handlerCode;
	/**
	 * ����ҵ��Ա����
	 */
	private String handler1Code;
	/**
	 * ��ͬ��
	 */
	private String contractNo;

	/**
	 * ҵ������
	 */
	private String flowId;

    private String lflowID;//���⹤��������
    private String llogNo;//���⹤�����ڵ����
	
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
