package com.sinosoft.pms.api.rate.dto;

import java.io.Serializable;

import com.sinosoft.framework.dto.BaseRequest;
/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-09-15 09:24:37.739 
 * 费率代码表Api操作对象
 */
public class PrpDrateUsualDto extends BaseRequest implements Serializable{
	private static final long serialVersionUID = 1L;
	/** 属性险种代码▲/险种代码▲ */
	private String riskCode ;		
	/** 属性险别代码/险别代码 */
	private String kindCode ;		
	/** 属性费率期数/费率期数 */
	private java.lang.Integer ratePeriod ;		
	/** 属性生效日期/生效日期 */
	private java.util.Date validDate ;		
	/** 属性费率代码▲/费率代码▲ */
	private String rateCode ;		
	/** 属性币别/币别 */
	private String currency ;		
	/** 属性基准保费/基准保费 */
	private java.lang.Double basePremium ;		
	/** 属性基准费率/基准费率 */
	private java.lang.Double rate ;		
	/** 属性标志字段/标志字段 */
	private String flag ;		
	/** 属性是否有效/是否有效 */
	private String validStatus ;		
			
			
			
			
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
	 * 属性生效日期/生效日期的getter方法
	 */
	public java.util.Date getValidDate() {
		return validDate;
	}
	/**
	 * 属性生效日期/生效日期的setter方法
	 */
	public void setValidDate(java.util.Date validDate) {
		this.validDate = validDate;
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
	/**
	 * 属性基准保费/基准保费的getter方法
	 */
	public java.lang.Double getBasePremium() {
		return basePremium;
	}
	/**
	 * 属性基准保费/基准保费的setter方法
	 */
	public void setBasePremium(java.lang.Double basePremium) {
		this.basePremium = basePremium;
	}	
	/**
	 * 属性基准费率/基准费率的getter方法
	 */
	public java.lang.Double getRate() {
		return rate;
	}
	/**
	 * 属性基准费率/基准费率的setter方法
	 */
	public void setRate(java.lang.Double rate) {
		this.rate = rate;
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
	/**
	 * 属性是否有效/是否有效的getter方法
	 */
	public String getValidStatus() {
		return validStatus;
	}
	/**
	 * 属性是否有效/是否有效的setter方法
	 */
	public void setValidStatus(String validStatus) {
		this.validStatus = validStatus;
	}	
		
		
		
		
}
