package com.sinosoft.dms.api.customer.dto;

import java.io.Serializable;

import com.sinosoft.framework.dto.BaseRequest;
/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-11-05 01:01:56.447 
 * 客户风险等级审核补充说明Api操作对象
 */
public class PrpDcustomerRiskLevelextDto extends BaseRequest implements Serializable{
	private static final long serialVersionUID = 1L;
	/** 属性客户号/客户号 */
	private String customerRiskLevelSign ;		
	/** 属性序号/序号 */
	private java.lang.Integer serialNo ;		
	/** 属性操作人员代码/操作人员代码 */
	private String operaterCode ;		
	/** 属性操作人员姓名/操作人员姓名 */
	private String operaterName ;		
	/** 属性操作级别 0操作员 1初审人员 2复审人员/操作级别 0操作员 1初审人员 2复审人员 */
	private String operateLevel ;		
	/** 属性输入日期/输入日期 */
	private java.util.Date inputDate ;		
	/** 属性意见内容/意见内容 */
	private String content ;		
	/**
	 * 属性客户号/客户号的getter方法
	 */
	public String getCustomerRiskLevelSign() {
		return customerRiskLevelSign;
	}
	/**
	 * 属性客户号/客户号的setter方法
	 */
	public void setCustomerRiskLevelSign(String customerRiskLevelSign) {
		this.customerRiskLevelSign = customerRiskLevelSign;
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
	 * 属性操作人员代码/操作人员代码的getter方法
	 */
	public String getOperaterCode() {
		return operaterCode;
	}
	/**
	 * 属性操作人员代码/操作人员代码的setter方法
	 */
	public void setOperaterCode(String operaterCode) {
		this.operaterCode = operaterCode;
	}	
	/**
	 * 属性操作人员姓名/操作人员姓名的getter方法
	 */
	public String getOperaterName() {
		return operaterName;
	}
	/**
	 * 属性操作人员姓名/操作人员姓名的setter方法
	 */
	public void setOperaterName(String operaterName) {
		this.operaterName = operaterName;
	}	
	/**
	 * 属性操作级别 0操作员 1初审人员 2复审人员/操作级别 0操作员 1初审人员 2复审人员的getter方法
	 */
	public String getOperateLevel() {
		return operateLevel;
	}
	/**
	 * 属性操作级别 0操作员 1初审人员 2复审人员/操作级别 0操作员 1初审人员 2复审人员的setter方法
	 */
	public void setOperateLevel(String operateLevel) {
		this.operateLevel = operateLevel;
	}	
	/**
	 * 属性输入日期/输入日期的getter方法
	 */
	public java.util.Date getInputDate() {
		return inputDate;
	}
	/**
	 * 属性输入日期/输入日期的setter方法
	 */
	public void setInputDate(java.util.Date inputDate) {
		this.inputDate = inputDate;
	}	
	/**
	 * 属性意见内容/意见内容的getter方法
	 */
	public String getContent() {
		return content;
	}
	/**
	 * 属性意见内容/意见内容的setter方法
	 */
	public void setContent(String content) {
		this.content = content;
	}	
}
