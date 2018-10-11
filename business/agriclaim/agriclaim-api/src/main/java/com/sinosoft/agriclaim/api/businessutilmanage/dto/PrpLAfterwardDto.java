package com.sinosoft.agriclaim.api.businessutilmanage.dto;

import java.io.Serializable;

import com.sinosoft.framework.dto.BaseRequest;
/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-11-08 05:35:28.283 
 * 案后费用处理表Api操作对象
 */
public class PrpLAfterwardDto extends BaseRequest implements Serializable{
	private static final long serialVersionUID = 1L;
	/** 属性立案号/立案号 */
	private String claimNo ;		
	/** 属性序号/序号 */
	private java.lang.Double serialNo ;		
	/** 属性险别代码/险别代码 */
	private String kindCode ;		
	/** 属性费用类别代码/费用类别代码 */
	private String chargeCode ;		
	/** 属性费用名称/费用名称 */
	private String chargeName ;		
	/** 属性币别/币别 */
	private String currency ;		
	/** 属性费用金额/费用金额 */
	private java.lang.Double chargeAmount ;		
	/** 属性计入赔款金额/计入赔款金额 */
	private java.lang.Double sumRealay ;		
	/** 属性处理日期/处理日期 */
	private java.util.Date dealDate ;		
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
	 * 属性序号/序号的getter方法
	 */
	public java.lang.Double getSerialNo() {
		return serialNo;
	}
	/**
	 * 属性序号/序号的setter方法
	 */
	public void setSerialNo(java.lang.Double serialNo) {
		this.serialNo = serialNo;
	}	
	/**
	 * 属性险别代码/险别代码的getter方法
	 */
	public String getKindCode() {
		return kindCode;
	}
	/**
	 * 属性险别代码/险别代码的setter方法
	 */
	public void setKindCode(String kindCode) {
		this.kindCode = kindCode;
	}	
	/**
	 * 属性费用类别代码/费用类别代码的getter方法
	 */
	public String getChargeCode() {
		return chargeCode;
	}
	/**
	 * 属性费用类别代码/费用类别代码的setter方法
	 */
	public void setChargeCode(String chargeCode) {
		this.chargeCode = chargeCode;
	}	
	/**
	 * 属性费用名称/费用名称的getter方法
	 */
	public String getChargeName() {
		return chargeName;
	}
	/**
	 * 属性费用名称/费用名称的setter方法
	 */
	public void setChargeName(String chargeName) {
		this.chargeName = chargeName;
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
	 * 属性费用金额/费用金额的getter方法
	 */
	public java.lang.Double getChargeAmount() {
		return chargeAmount;
	}
	/**
	 * 属性费用金额/费用金额的setter方法
	 */
	public void setChargeAmount(java.lang.Double chargeAmount) {
		this.chargeAmount = chargeAmount;
	}	
	/**
	 * 属性计入赔款金额/计入赔款金额的getter方法
	 */
	public java.lang.Double getSumRealay() {
		return sumRealay;
	}
	/**
	 * 属性计入赔款金额/计入赔款金额的setter方法
	 */
	public void setSumRealay(java.lang.Double sumRealay) {
		this.sumRealay = sumRealay;
	}	
	/**
	 * 属性处理日期/处理日期的getter方法
	 */
	public java.util.Date getDealDate() {
		return dealDate;
	}
	/**
	 * 属性处理日期/处理日期的setter方法
	 */
	public void setDealDate(java.util.Date dealDate) {
		this.dealDate = dealDate;
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
