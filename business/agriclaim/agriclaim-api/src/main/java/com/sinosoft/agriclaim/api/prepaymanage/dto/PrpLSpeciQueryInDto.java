package com.sinosoft.agriclaim.api.prepaymanage.dto;

import com.sinosoft.framework.dto.BasePageableRequest;

import java.io.Serializable;

/**
 * @author 闫磊
 * @time  2017-11-10 02:44:49.773 
 * 特殊赔案查询入参Api操作对象
 */
public class PrpLSpeciQueryInDto extends BasePageableRequest implements Serializable {

	private static final long serialVersionUID = 1L;
	/** 属性当前节点号/当前节点号 */
	private String nodeType ;
	/** 属性立案号/立案号*/
	private String claimNo ;
	/** 属性报案号/报案号 */
	private String registNo ;		
	/** 属性保单号码/保单号码 */
	private String policyNo ;		
	/** 属性被保险人/被保险人 */
	private String insuredName ;		
	/** 属性流入时间起始/流入时间起始 */
	private String flowInTimeStart ;		
	/** 属性流入时间终止/流入时间终止*/
	private String flowInTimeEnd ;
	/** 属性险种大类/险种大类 */
	private String riskType ;
	/** 属性险种种类/险种种类 */
	private String riskCode ;		
	/** 属性案件状态/案件状态 */
	private String nodeStatus ;
	/** 属性处理人/处理人 */
	private String handlerCode ;
	/** 属性处理人名称/处理人名称 */
	private String handlerName ;
	/** 属性机构代码/机构代码*/
	private String handleCode ;	
	/** 属性机构名称/机构名称*/
	private String handleName ;
	/** 属性特殊赔案号/特殊赔案号*/
	private String businessNo ;
	
	/**
	 * 属性当前节点号/当前节点号的getter方法
	 */
	public String getNodeType() {
		return nodeType;
	}
	/**
	 * 属性当前节点号/当前节点号的setter方法
	 */
	public void setNodeType(String nodeType) {
		this.nodeType = nodeType;
	}
	/**
	 * 属性立案号/立案号的getter方法
	 */
	public String getClaimNo() {
		return claimNo;
	}
	/**
	 * 属性立案号/立案号的setter方法
	 */
	public void setClaimNo(String claimNo) {
		this.claimNo = claimNo;
	}
	/**
	 * 属性报案号/报案号的getter方法
	 */
	public String getRegistNo() {
		return registNo;
	}
	/**
	 * 属性报案号/报案号的setter方法
	 */
	public void setRegistNo(String registNo) {
		this.registNo = registNo;
	}
	/**
	 * 属性保单号/保单号的getter方法
	 */
	public String getPolicyNo() {
		return policyNo;
	}
	/**
	 * 属性保单号/保单号的setter方法
	 */
	public void setPolicyNo(String policyNo) {
		this.policyNo = policyNo;
	}
	/**
	 * 属性被保险人/被保险人的getter方法
	 */
	public String getInsuredName() {
		return insuredName;
	}
	/**
	 * 属性被保险人/被保险人的setter方法
	 */
	public void setInsuredName(String insuredName) {
		this.insuredName = insuredName;
	}
	/**
	 * 属性流入时间起始/流入时间起始的getter方法
	 */
	public String getFlowInTimeStart() {
		return flowInTimeStart;
	}
	/**
	 * 属性流入时间起始/流入时间起始的setter方法
	 */
	public void setFlowInTimeStart(String flowInTimeStart) {
		this.flowInTimeStart = flowInTimeStart;
	}
	/**
	 * 属性流入时间终止/流入时间终止的getter方法
	 */
	public String getFlowInTimeEnd() {
		return flowInTimeEnd;
	}
	/**
	 * 属性流入时间终止/流入时间终止的setter方法
	 */
	public void setFlowInTimeEnd(String flowInTimeEnd) {
		this.flowInTimeEnd = flowInTimeEnd;
	}
	/**
	 * 属性险种大类/险种大类的getter方法
	 */
	public String getRiskType() {
		return riskType;
	}
	/**
	 * 属性险种大类/险种大类的setter方法
	 */
	public void setRiskType(String riskType) {
		this.riskType = riskType;
	}
	/**
	 * 属性险种种类/险种种类的getter方法
	 */
	public String getRiskCode() {
		return riskCode;
	}
	/**
	 * 属性险种种类/险种种类的setter方法
	 */
	public void setRiskCode(String riskCode) {
		this.riskCode = riskCode;
	}
	/**
	 * 属性案件状态/案件状态的getter方法
	 */
	public String getNodeStatus() {
		return nodeStatus;
	}
	/**
	 * 属性案件状态/案件状态的setter方法
	 */
	public void setNodeStatus(String nodeStatus) {
		this.nodeStatus = nodeStatus;
	}
	/**
	 * 属性处理人/处理人 的getter方法
	 */
	public String getHandlerCode() {
		return handlerCode;
	}
	/**
	 * 属性处理人/处理人 的setter方法
	 */
	public void setHandlerCode(String handlerCode) {
		this.handlerCode = handlerCode;
	}
	/**
	 * 属性处理人名称/处理人名称的getter方法
	 */
	public String getHandlerName() {
		return handlerName;
	}
	/**
	 * 属性处理人名称/处理人名称的setter方法
	 */
	public void setHandlerName(String handlerName) {
		this.handlerName = handlerName;
	}
	/**
	 * 属性机构代码/机构代码的getter方法
	 */
	public String getHandleCode() {
		return handleCode;
	}
	/**
	 * 属性机构代码/机构代码的setter方法
	 */
	public void setHandleCode(String handleCode) {
		this.handleCode = handleCode;
	}
	/**
	 * 属性机构名称/机构名称的getter方法
	 */
	public String getHandleName() {
		return handleName;
	}
	/**
	 * 属性机构名称/机构名称的setter方法
	 */
	public void setHandleName(String handleName) {
		this.handleName = handleName;
	}

	public String getBusinessNo() {
		return businessNo;
	}

	public void setBusinesNo(String businessNo) {
		this.businessNo = businessNo;
	}
}
