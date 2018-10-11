package com.sinosoft.ims.api.auth.dto;

import java.io.Serializable;

import com.sinosoft.framework.dto.BaseRequest;
/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-11-05 01:11:08.689 
 * UwGroupApi操作对象
 */
public class UwGroupDto extends BaseRequest implements Serializable{
	private static final long serialVersionUID = 1L;
	/** 属性groupNo/groupNo */
	private java.lang.Integer groupNo ;		
	/** 属性groupDesc/groupDesc */
	private String groupDesc ;		
	/** 属性comCode/comCode */
	private String comCode ;		
	/** 属性riskCode/riskCode */
	private String riskCode ;		
	/** 属性险类/险类 */
	private String classCode ;		
	/** 属性除外险种/除外险种 */
	private String exceptRiskCode ;		
	/**
	 * 属性groupNo/groupNo的getter方法
	 */
	public java.lang.Integer getGroupNo() {
		return groupNo;
	}
	/**
	 * 属性groupNo/groupNo的setter方法
	 */
	public void setGroupNo(java.lang.Integer groupNo) {
		this.groupNo = groupNo;
	}	
	/**
	 * 属性groupDesc/groupDesc的getter方法
	 */
	public String getGroupDesc() {
		return groupDesc;
	}
	/**
	 * 属性groupDesc/groupDesc的setter方法
	 */
	public void setGroupDesc(String groupDesc) {
		this.groupDesc = groupDesc;
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
	 * 属性除外险种/除外险种的getter方法
	 */
	public String getExceptRiskCode() {
		return exceptRiskCode;
	}
	/**
	 * 属性除外险种/除外险种的setter方法
	 */
	public void setExceptRiskCode(String exceptRiskCode) {
		this.exceptRiskCode = exceptRiskCode;
	}	
}
