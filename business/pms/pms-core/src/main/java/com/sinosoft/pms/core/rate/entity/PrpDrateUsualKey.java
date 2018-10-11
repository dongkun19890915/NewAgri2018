package com.sinosoft.pms.core.rate.entity;

import com.sinosoft.framework.core.dao.BasePKImpl;

/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-09-15 09:24:37.739 
 * 费率代码表主键操作对象
 */
public class PrpDrateUsualKey extends BasePKImpl{
	private static final long serialVersionUID = 1L;
	public PrpDrateUsualKey(){}
	public PrpDrateUsualKey(String riskCode,String kindCode,java.lang.Integer ratePeriod,String rateCode,String currency){
		this.riskCode = riskCode;
		this.kindCode = kindCode;
		this.ratePeriod = ratePeriod;
		this.rateCode = rateCode;
		this.currency = currency;
	}
	/** 属性险种代码▲/险种代码▲ */
	private String riskCode ;
	/** 属性险别代码/险别代码 */
	private String kindCode ;
	/** 属性费率期数/费率期数 */
	private java.lang.Integer ratePeriod ;
	/** 属性费率代码▲/费率代码▲ */
	private String rateCode ;
	/** 属性币别/币别 */
	private String currency ;
	/**
	 * 属性险种代码▲/险种代码▲的getter方法
	 */
	public String getRiskCode() {
    		return riskCode;
	}
	/**
	 * 属性险种代码▲/险种代码▲的setter方法
	 */
	public void setRiskCode(String riskCode) {
		this.riskCode = riskCode;
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
	 * 属性费率期数/费率期数的getter方法
	 */
	public java.lang.Integer getRatePeriod() {
    		return ratePeriod;
	}
	/**
	 * 属性费率期数/费率期数的setter方法
	 */
	public void setRatePeriod(java.lang.Integer ratePeriod) {
		this.ratePeriod = ratePeriod;
	} 
	/**
	 * 属性费率代码▲/费率代码▲的getter方法
	 */
	public String getRateCode() {
    		return rateCode;
	}
	/**
	 * 属性费率代码▲/费率代码▲的setter方法
	 */
	public void setRateCode(String rateCode) {
		this.rateCode = rateCode;
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
}