package com.sinosoft.agriclaim.api.workflowmanage.dto;

import java.io.Serializable;

import com.sinosoft.framework.dto.BaseRequest;
/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-11-10 02:50:26.122 
 * 回访工作流表Api操作对象
 */
public class PrplReturnVisitSwflogDto extends BaseRequest implements Serializable{
	private static final long serialVersionUID = 1L;
	/** 属性业务号/业务号 */
	private String businessNo ;		
	/** 属性节点/节点 */
	private String nodeType ;		
	/** 属性报案号/报案号 */
	private String registNo ;		
	/** 属性保单号/保单号 */
	private String policyNo ;		
	/** 属性承保机构/承保机构 */
	private String comCode ;		
	/** 属性承保机构名称/承保机构名称 */
	private String comCodeName ;		
	/** 属性被保险人/被保险人 */
	private String insuredName ;		
	/** 属性报案时间/报案时间 */
	private java.util.Date reportDate ;		
	/** 属性结案时间/结案时间 */
	private java.util.Date ceaseDate ;		
	/** 属性车牌号/车牌号 */
	private String licenseNo ;		
	/** 属性处理人ID/处理人ID */
	private String handlerCode ;		
	/** 属性处理人/处理人 */
	private String handlerName ;		
	/** 属性处理机构/处理机构 */
	private String handlerComCode ;		
	/** 属性流入时间/流入时间 */
	private java.util.Date flowintoTime ;		
	/** 属性结束时间/结束时间 */
	private java.util.Date ceaseTime ;		
	/** 属性险类/险类 */
	private String classCode ;		
	/** 属性状态(0未处理，2正在处理，4已经处理)/状态(0未处理，2正在处理，4已经处理) */
	private String state ;		
	/** 属性险种代码/险种代码 */
	private String riskCode ;		
	/** 属性修改人/修改人 */
	private String updateBy ;		
	/** 属性修改时间/修改时间 */
	private java.util.Date updateDate ;		
	/**
	 * 属性业务号/业务号的getter方法
	 */
	public String getBusinessNo() {
		return businessNo;
	}
	/**
	 * 属性业务号/业务号的setter方法
	 */
	public void setBusinessNo(String businessNo) {
		this.businessNo = businessNo;
	}	
	/**
	 * 属性节点/节点的getter方法
	 */
	public String getNodeType() {
		return nodeType;
	}
	/**
	 * 属性节点/节点的setter方法
	 */
	public void setNodeType(String nodeType) {
		this.nodeType = nodeType;
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
	 * 属性承保机构/承保机构的getter方法
	 */
	public String getComCode() {
		return comCode;
	}
	/**
	 * 属性承保机构/承保机构的setter方法
	 */
	public void setComCode(String comCode) {
		this.comCode = comCode;
	}	
	/**
	 * 属性承保机构名称/承保机构名称的getter方法
	 */
	public String getComCodeName() {
		return comCodeName;
	}
	/**
	 * 属性承保机构名称/承保机构名称的setter方法
	 */
	public void setComCodeName(String comCodeName) {
		this.comCodeName = comCodeName;
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
	 * 属性报案时间/报案时间的getter方法
	 */
	public java.util.Date getReportDate() {
		return reportDate;
	}
	/**
	 * 属性报案时间/报案时间的setter方法
	 */
	public void setReportDate(java.util.Date reportDate) {
		this.reportDate = reportDate;
	}	
	/**
	 * 属性结案时间/结案时间的getter方法
	 */
	public java.util.Date getCeaseDate() {
		return ceaseDate;
	}
	/**
	 * 属性结案时间/结案时间的setter方法
	 */
	public void setCeaseDate(java.util.Date ceaseDate) {
		this.ceaseDate = ceaseDate;
	}	
	/**
	 * 属性车牌号/车牌号的getter方法
	 */
	public String getLicenseNo() {
		return licenseNo;
	}
	/**
	 * 属性车牌号/车牌号的setter方法
	 */
	public void setLicenseNo(String licenseNo) {
		this.licenseNo = licenseNo;
	}	
	/**
	 * 属性处理人ID/处理人ID的getter方法
	 */
	public String getHandlerCode() {
		return handlerCode;
	}
	/**
	 * 属性处理人ID/处理人ID的setter方法
	 */
	public void setHandlerCode(String handlerCode) {
		this.handlerCode = handlerCode;
	}	
	/**
	 * 属性处理人/处理人的getter方法
	 */
	public String getHandlerName() {
		return handlerName;
	}
	/**
	 * 属性处理人/处理人的setter方法
	 */
	public void setHandlerName(String handlerName) {
		this.handlerName = handlerName;
	}	
	/**
	 * 属性处理机构/处理机构的getter方法
	 */
	public String getHandlerComCode() {
		return handlerComCode;
	}
	/**
	 * 属性处理机构/处理机构的setter方法
	 */
	public void setHandlerComCode(String handlerComCode) {
		this.handlerComCode = handlerComCode;
	}	
	/**
	 * 属性流入时间/流入时间的getter方法
	 */
	public java.util.Date getFlowintoTime() {
		return flowintoTime;
	}
	/**
	 * 属性流入时间/流入时间的setter方法
	 */
	public void setFlowintoTime(java.util.Date flowintoTime) {
		this.flowintoTime = flowintoTime;
	}	
	/**
	 * 属性结束时间/结束时间的getter方法
	 */
	public java.util.Date getCeaseTime() {
		return ceaseTime;
	}
	/**
	 * 属性结束时间/结束时间的setter方法
	 */
	public void setCeaseTime(java.util.Date ceaseTime) {
		this.ceaseTime = ceaseTime;
	}	
	/**
	 * 属性险类/险类的getter方法
	 */
	public String getClassCode() {
		return classCode;
	}
	/**
	 * 属性险类/险类的setter方法
	 */
	public void setClassCode(String classCode) {
		this.classCode = classCode;
	}	
	/**
	 * 属性状态(0未处理，2正在处理，4已经处理)/状态(0未处理，2正在处理，4已经处理)的getter方法
	 */
	public String getState() {
		return state;
	}
	/**
	 * 属性状态(0未处理，2正在处理，4已经处理)/状态(0未处理，2正在处理，4已经处理)的setter方法
	 */
	public void setState(String state) {
		this.state = state;
	}	
	/**
	 * 属性险种代码/险种代码的getter方法
	 */
	public String getRiskCode() {
		return riskCode;
	}
	/**
	 * 属性险种代码/险种代码的setter方法
	 */
	public void setRiskCode(String riskCode) {
		this.riskCode = riskCode;
	}	
	/**
	 * 属性修改人/修改人的getter方法
	 */
	public String getUpdateBy() {
		return updateBy;
	}
	/**
	 * 属性修改人/修改人的setter方法
	 */
	public void setUpdateBy(String updateBy) {
		this.updateBy = updateBy;
	}	
	/**
	 * 属性修改时间/修改时间的getter方法
	 */
	public java.util.Date getUpdateDate() {
		return updateDate;
	}
	/**
	 * 属性修改时间/修改时间的setter方法
	 */
	public void setUpdateDate(java.util.Date updateDate) {
		this.updateDate = updateDate;
	}	
}
