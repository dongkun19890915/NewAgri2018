package com.sinosoft.agriclaim.api.checkmanage.dto;

import java.io.Serializable;

import com.sinosoft.framework.dto.BaseRequest;
/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-11-08 05:38:49.324 
 * 查勘/代查勘扩展表Api操作对象
 */
public class PrpLCheckExtDto extends BaseRequest implements Serializable{
	private static final long serialVersionUID = 1L;
	/** 属性报案号码/报案号码 */
	private String registNo ;		
	/** 属性立案号码/立案号码 */
	private String claimNo ;		
	/** 属性险种代码/险种代码 */
	private String riskCode ;		
	/** 属性保单号码/保单号码 */
	private String policyNo ;		
	/** 属性序号/序号 */
	private java.lang.Integer serialNo ;		
	/** 属性查勘项目代码/查勘项目代码 */
	private String columnName ;		
	/** 属性查勘项目名称/查勘项目名称 */
	private String displayName ;		
	/** 属性扩充字段内容/扩充字段内容 */
	private String columnValue ;		
	/** 属性标志/标志 */
	private String flag ;		
	/** 属性关联理赔车辆序号/关联理赔车辆序号 */
	private java.lang.Integer referSerialNo ;		
	/**
	 * 属性报案号码/报案号码的getter方法
	 */
	public String getRegistNo() {
		return registNo;
	}
	/**
	 * 属性报案号码/报案号码的setter方法
	 */
	public void setRegistNo(String registNo) {
		this.registNo = registNo;
	}	
	/**
	 * 属性立案号码/立案号码的getter方法
	 */
	public String getClaimNo() {
		return claimNo;
	}
	/**
	 * 属性立案号码/立案号码的setter方法
	 */
	public void setClaimNo(String claimNo) {
		this.claimNo = claimNo;
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
	 * 属性保单号码/保单号码的getter方法
	 */
	public String getPolicyNo() {
		return policyNo;
	}
	/**
	 * 属性保单号码/保单号码的setter方法
	 */
	public void setPolicyNo(String policyNo) {
		this.policyNo = policyNo;
	}	
	/**
	 * 属性序号/序号的getter方法
	 */
	public java.lang.Integer getSerialNo() {
		return serialNo;
	}
	/**
	 * 属性序号/序号的setter方法
	 */
	public void setSerialNo(java.lang.Integer serialNo) {
		this.serialNo = serialNo;
	}	
	/**
	 * 属性查勘项目代码/查勘项目代码的getter方法
	 */
	public String getColumnName() {
		return columnName;
	}
	/**
	 * 属性查勘项目代码/查勘项目代码的setter方法
	 */
	public void setColumnName(String columnName) {
		this.columnName = columnName;
	}	
	/**
	 * 属性查勘项目名称/查勘项目名称的getter方法
	 */
	public String getDisplayName() {
		return displayName;
	}
	/**
	 * 属性查勘项目名称/查勘项目名称的setter方法
	 */
	public void setDisplayName(String displayName) {
		this.displayName = displayName;
	}	
	/**
	 * 属性扩充字段内容/扩充字段内容的getter方法
	 */
	public String getColumnValue() {
		return columnValue;
	}
	/**
	 * 属性扩充字段内容/扩充字段内容的setter方法
	 */
	public void setColumnValue(String columnValue) {
		this.columnValue = columnValue;
	}	
	/**
	 * 属性标志/标志的getter方法
	 */
	public String getFlag() {
		return flag;
	}
	/**
	 * 属性标志/标志的setter方法
	 */
	public void setFlag(String flag) {
		this.flag = flag;
	}	
	/**
	 * 属性关联理赔车辆序号/关联理赔车辆序号的getter方法
	 */
	public java.lang.Integer getReferSerialNo() {
		return referSerialNo;
	}
	/**
	 * 属性关联理赔车辆序号/关联理赔车辆序号的setter方法
	 */
	public void setReferSerialNo(java.lang.Integer referSerialNo) {
		this.referSerialNo = referSerialNo;
	}	
}
