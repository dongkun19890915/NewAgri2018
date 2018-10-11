package com.sinosoft.agriclaim.api.claimmanage.dto;

import java.io.Serializable;

import com.sinosoft.framework.dto.BaseRequest;
/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-11-08 05:39:53.061 
 * 立案保单清单表Api操作对象
 */
public class PrpLClaimPolicyDto extends BaseRequest implements Serializable{
	private static final long serialVersionUID = 1L;
	/** 属性立案号/立案号 */
	private String claimNo ;		
	/** 属性保单号/保单号 */
	private String policNo ;		
	/** 属性币别/币别 */
	private String currency ;		
	/** 属性总保额/总保额 */
	private java.lang.Double sumAmount ;		
	/** 属性总保费/总保费 */
	private java.lang.Double sumPremium ;		
	/** 属性标志字段/标志字段 */
	private String flag ;		
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
	 * 属性保单号/保单号的getter方法
	 */
	public String getPolicNo() {
		return policNo;
	}
	/**
	 * 属性保单号/保单号的setter方法
	 */
	public void setPolicNo(String policNo) {
		this.policNo = policNo;
	}	
	/**
	 * 属性币别/币别的getter方法
	 */
	public String getCurrency() {
		return currency;
	}
	/**
	 * 属性币别/币别的setter方法
	 */
	public void setCurrency(String currency) {
		this.currency = currency;
	}	
	/**
	 * 属性总保额/总保额的getter方法
	 */
	public java.lang.Double getSumAmount() {
		return sumAmount;
	}
	/**
	 * 属性总保额/总保额的setter方法
	 */
	public void setSumAmount(java.lang.Double sumAmount) {
		this.sumAmount = sumAmount;
	}	
	/**
	 * 属性总保费/总保费的getter方法
	 */
	public java.lang.Double getSumPremium() {
		return sumPremium;
	}
	/**
	 * 属性总保费/总保费的setter方法
	 */
	public void setSumPremium(java.lang.Double sumPremium) {
		this.sumPremium = sumPremium;
	}	
	/**
	 * 属性标志字段/标志字段的getter方法
	 */
	public String getFlag() {
		return flag;
	}
	/**
	 * 属性标志字段/标志字段的setter方法
	 */
	public void setFlag(String flag) {
		this.flag = flag;
	}	
}
