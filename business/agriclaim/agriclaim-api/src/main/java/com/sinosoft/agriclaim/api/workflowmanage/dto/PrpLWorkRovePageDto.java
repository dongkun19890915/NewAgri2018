/**
 * 
 */
package com.sinosoft.agriclaim.api.workflowmanage.dto;

import java.util.List;

/**
 * @author 闫磊
 * @time  2017-11-10
 * 任务转交Api操作对象
 */
public class PrpLWorkRovePageDto {
	private static final long serialVersionUID = 1L;
	/** 属性流程编号/流程编号 */
	private String swfLogFlowID ;
	/** 属性序号/序号 */
	private java.lang.Integer swfLogLogNo ;
	/** 属性险种信息/险种信息 */
	private String riskCode ;
	/** 属性险种名称/险种名称*/
	private String riskName ;
	/** 属性机构信息/机构信息 */
	private String comCode ;
	/** 属性报案号/报案号 */
	private String registNo ;
	/** 属性批量报案号/批量报案号 */
	private List<String> registNos ;
	/** 属性转交类型代码/转交类型代码 */
	private String nodeType ;
	/** 属性转交类型名称/转交类型名称 */
	private String nodeName ;	
	/** 属性出险标的/出险标的  */
	private String lossName ;
	/** 属性流入时间/流入时间 */
	private String flowInTime ;
	/** 属性受理机构/受理机构*/
	private String handleCode ;	
	/** 属性受理机构名称/受理机构名称*/
	private String handleName ;
	/** 属性受理人/受理人 */
	private String handlerCode ;
	/** 属性受理人名称/受理人名称 */
	private String handlerName ;
	/** 属性转交时间/转交时间*/
	private String inputDate ;		
	/** 属性处理人/处理人 */
	private String operatorCode ;
	/** 属性处理人名称/处理人名称 */
	private String operatorName ;
	/** 属性转交描述/转交描述 */
	private String context ;
	
	/**
	 * 属性流程编号/流程编号的getter方法
	 */
	public String getSwfLogFlowID() {
		return swfLogFlowID;
	}
	/**
	 * 属性流程编号/流程编号的setter方法
	 */
	public void setSwfLogFlowID(String swfLogFlowID) {
		this.swfLogFlowID = swfLogFlowID;
	}
	/**
	 * 属性序号/序号的getter方法
	 */
	public Integer getSwfLogLogNo() {
		return swfLogLogNo;
	}
	/**
	 * 属性序号/序号的setter方法
	 */
	public void setSwfLogLogNo(Integer swfLogLogNo) {
		this.swfLogLogNo = swfLogLogNo;
	}
	/**
	 * 属性险种信息/险种信息的getter方法
	 */
	public String getRiskCode() {
		return riskCode;
	}
	/**
	 * 属性险种信息/险种信息的setter方法
	 */
	public void setRiskCode(String riskCode) {
		this.riskCode = riskCode;
	}
	/**
	 * 属性险种名称/险种名称的getter方法
	 */
	public String getRiskName() {
		return riskName;
	}
	/**
	 * 属性险种名称/险种名称的setter方法
	 */
	public void setRiskName(String riskName) {
		this.riskName = riskName;
	}
	/**
	 * 属性机构信息/机构信息的getter方法
	 */
	public String getComCode() {
		return comCode;
	}
	/**
	 * 属性机构信息/机构信息的setter方法
	 */
	public void setComCode(String comCode) {
		this.comCode = comCode;
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
	 * 属性批量报案号/批量报案号的getter方法
	 */
	public List<String> getRegistNos() {
		return registNos;
	}
	/**
	 * 属性批量报案号/批量报案号的setter方法
	 */
	public void setRegistNos(List<String> registNos) {
		this.registNos = registNos;
	}
	/**
	 * 属性转交类型代码/转交类型代码的getter方法
	 */
	public String getNodeType() {
		return nodeType;
	}
	/**
	 * 属性转交类型代码/转交类型代码的setter方法
	 */
	public void setNodeType(String nodeType) {
		this.nodeType = nodeType;
	}
	/**
	 * 属性转交类型名称/转交类型名称的getter方法
	 */
	public String getNodeName() {
		return nodeName;
	}
	/**
	 * 属性转交类型名称/转交类型名称的setter方法
	 */
	public void setNodeName(String nodeName) {
		this.nodeName = nodeName;
	}
	/**
	 * 属性出险标的/出险标的的getter方法
	 */
	public String getLossName() {
		return lossName;
	}
	/**
	 * 属性出险标的/出险标的的setter方法
	 */
	public void setLossName(String lossName) {
		this.lossName = lossName;
	}
	/**
	 * 属性流入时间/流入时间的getter方法
	 */
	public String getFlowInTime() {
		return flowInTime;
	}
	/**
	 * 属性流入时间/流入时间的setter方法
	 */
	public void setFlowInTime(String flowInTime) {
		this.flowInTime = flowInTime;
	}
	/**
	 * 属性受理机构/受理机构的getter方法
	 */
	public String getHandleCode() {
		return handleCode;
	}
	/**
	 * 属性受理机构/受理机构的setter方法
	 */
	public void setHandleCode(String handleCode) {
		this.handleCode = handleCode;
	}
	/**
	 * 属性受理机构名称/受理机构名称的getter方法
	 */
	public String getHandleName() {
		return handleName;
	}
	/**
	 * 属性受理机构名称/受理机构名称的setter方法
	 */
	public void setHandleName(String handleName) {
		this.handleName = handleName;
	}
	/**
	 * 属性受理人/受理人的getter方法
	 */
	public String getHandlerCode() {
		return handlerCode;
	}
	/**
	 * 属性受理人/受理人号的setter方法
	 */
	public void setHandlerCode(String handlerCode) {
		this.handlerCode = handlerCode;
	}
	/**
	 * 属性受理人名称/受理人名称的getter方法
	 */
	public String getHandlerName() {
		return handlerName;
	}
	/**
	 * 属性受理人名称/受理人名称的setter方法
	 */
	public void setHandlerName(String handlerName) {
		this.handlerName = handlerName;
	}
	/**
	 * 属性转交时间/转交时间的getter方法
	 */
	public String getInputDate() {
		return inputDate;
	}
	/**
	 * 属性转交时间/转交时间的setter方法
	 */
	public void setInputDate(String inputDate) {
		this.inputDate = inputDate;
	}
	/**
	 * 属性处理人/处理人的getter方法
	 */
	public String getOperatorCode() {
		return operatorCode;
	}
	/**
	 * 属性处理人/处理人的setter方法
	 */
	public void setOperatorCode(String operatorCode) {
		this.operatorCode = operatorCode;
	}
	/**
	 * 属性处理人名称/处理人名称的getter方法
	 */
	public String getOperatorName() {
		return operatorName;
	}
	/**
	 * 属性处理人名称/处理人名称的setter方法
	 */
	public void setOperatorName(String operatorName) {
		this.operatorName = operatorName;
	}
	/**
	 * 属性转交描述/转交描述的getter方法
	 */
	public String getContext() {
		return context;
	}
	/**
	 * 属性转交描述/转交描述的setter方法
	 */
	public void setContext(String context) {
		this.context = context;
	}
}
