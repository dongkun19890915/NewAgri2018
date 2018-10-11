package com.sinosoft.ims.api.auth.dto;

import java.io.Serializable;

import com.sinosoft.framework.dto.BaseRequest;
/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-11-05 01:11:08.689 
 * UtiUwLevelApi操作对象
 */
public class UtiUwLevelDto extends BaseRequest implements Serializable{
	private static final long serialVersionUID = 1L;
	/** 属性userCode/userCode */
	private String userCode ;		
	/** 属性comCode/comCode */
	private String comCode ;		
	/** 属性riskCode/riskCode */
	private String riskCode ;		
	/** 属性modelNo/modelNo */
	private java.lang.Integer modelNo ;		
	/** 属性nodeNo/nodeNo */
	private java.lang.Integer nodeNo ;		
	/** 属性startDate/startDate */
	private String startDate ;		
	/** 属性endDate/endDate */
	private String endDate ;		
	/** 属性validStatus/validStatus */
	private String validStatus ;		
	/** 属性flag/flag */
	private String flag ;		
	/** 属性uwType/uwType */
	private String uwType ;		
	/**
	 * 属性userCode/userCode的getter方法
	 */
	public String getUserCode() {
		return userCode;
	}
	/**
	 * 属性userCode/userCode的setter方法
	 */
	public void setUserCode(String userCode) {
		this.userCode = userCode;
	}	
	/**
	 * 属性comCode/comCode的getter方法
	 */
	public String getComCode() {
		return comCode;
	}
	/**
	 * 属性comCode/comCode的setter方法
	 */
	public void setComCode(String comCode) {
		this.comCode = comCode;
	}	
	/**
	 * 属性riskCode/riskCode的getter方法
	 */
	public String getRiskCode() {
		return riskCode;
	}
	/**
	 * 属性riskCode/riskCode的setter方法
	 */
	public void setRiskCode(String riskCode) {
		this.riskCode = riskCode;
	}	
	/**
	 * 属性modelNo/modelNo的getter方法
	 */
	public java.lang.Integer getModelNo() {
		return modelNo;
	}
	/**
	 * 属性modelNo/modelNo的setter方法
	 */
	public void setModelNo(java.lang.Integer modelNo) {
		this.modelNo = modelNo;
	}	
	/**
	 * 属性nodeNo/nodeNo的getter方法
	 */
	public java.lang.Integer getNodeNo() {
		return nodeNo;
	}
	/**
	 * 属性nodeNo/nodeNo的setter方法
	 */
	public void setNodeNo(java.lang.Integer nodeNo) {
		this.nodeNo = nodeNo;
	}	
	/**
	 * 属性startDate/startDate的getter方法
	 */
	public String getStartDate() {
		return startDate;
	}
	/**
	 * 属性startDate/startDate的setter方法
	 */
	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}	
	/**
	 * 属性endDate/endDate的getter方法
	 */
	public String getEndDate() {
		return endDate;
	}
	/**
	 * 属性endDate/endDate的setter方法
	 */
	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}	
	/**
	 * 属性validStatus/validStatus的getter方法
	 */
	public String getValidStatus() {
		return validStatus;
	}
	/**
	 * 属性validStatus/validStatus的setter方法
	 */
	public void setValidStatus(String validStatus) {
		this.validStatus = validStatus;
	}	
	/**
	 * 属性flag/flag的getter方法
	 */
	public String getFlag() {
		return flag;
	}
	/**
	 * 属性flag/flag的setter方法
	 */
	public void setFlag(String flag) {
		this.flag = flag;
	}	
	/**
	 * 属性uwType/uwType的getter方法
	 */
	public String getUwType() {
		return uwType;
	}
	/**
	 * 属性uwType/uwType的setter方法
	 */
	public void setUwType(String uwType) {
		this.uwType = uwType;
	}	
}
