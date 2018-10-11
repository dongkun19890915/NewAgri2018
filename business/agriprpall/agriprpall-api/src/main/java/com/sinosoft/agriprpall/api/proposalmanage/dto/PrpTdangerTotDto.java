package com.sinosoft.agriprpall.api.proposalmanage.dto;

import java.io.Serializable;

import com.sinosoft.framework.dto.BaseRequest;
/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-11-04 09:41:15.792 
 * PrpTdangerTotApi操作对象
 */
public class PrpTdangerTotDto extends BaseRequest implements Serializable{
	private static final long serialVersionUID = 1L;
	/** 属性保单号码/保单号码 */
	private String proposalNo ;		
	/** 属性危险单位序号/危险单位序号 */
	private java.lang.Integer dangerNo ;		
	/** 属性原币/原币 */
	private String sCurrency ;		
	/** 属性保额/保额 */
	private java.lang.Double amount ;		
	/** 属性保费/保费 */
	private java.lang.Double premium ;		
	/** 属性tcurrency/tcurrency */
	private String tCurrency ;		
	/** 属性兑换率/兑换率 */
	private java.lang.Double exchRate ;		
	/** 属性折币保额/折币保额 */
	private java.lang.Double amountEx ;		
	/** 属性折币保费/折币保费 */
	private java.lang.Double premiumEx ;		
	/** 属性标志字段/标志字段 */
	private String flag ;		
	/**
	 * 属性保单号码/保单号码的getter方法
	 */
	public String getProposalNo() {
		return proposalNo;
	}
	/**
	 * 属性保单号码/保单号码的setter方法
	 */
	public void setProposalNo(String proposalNo) {
		this.proposalNo = proposalNo;
	}	
	/**
	 * 属性危险单位序号/危险单位序号的getter方法
	 */
	public java.lang.Integer getDangerNo() {
		return dangerNo;
	}
	/**
	 * 属性危险单位序号/危险单位序号的setter方法
	 */
	public void setDangerNo(java.lang.Integer dangerNo) {
		this.dangerNo = dangerNo;
	}	
	/**
	 * 属性原币/原币的getter方法
	 */
	public String getSCurrency() {
		return sCurrency;
	}
	/**
	 * 属性原币/原币的setter方法
	 */
	public void setSCurrency(String sCurrency) {
		this.sCurrency = sCurrency;
	}	
	/**
	 * 属性保额/保额的getter方法
	 */
	public java.lang.Double getAmount() {
		return amount;
	}
	/**
	 * 属性保额/保额的setter方法
	 */
	public void setAmount(java.lang.Double amount) {
		this.amount = amount;
	}	
	/**
	 * 属性保费/保费的getter方法
	 */
	public java.lang.Double getPremium() {
		return premium;
	}
	/**
	 * 属性保费/保费的setter方法
	 */
	public void setPremium(java.lang.Double premium) {
		this.premium = premium;
	}	
	/**
	 * 属性tcurrency/tcurrency的getter方法
	 */
	public String getTCurrency() {
		return tCurrency;
	}
	/**
	 * 属性tcurrency/tcurrency的setter方法
	 */
	public void setTCurrency(String tCurrency) {
		this.tCurrency = tCurrency;
	}	
	/**
	 * 属性兑换率/兑换率的getter方法
	 */
	public java.lang.Double getExchRate() {
		return exchRate;
	}
	/**
	 * 属性兑换率/兑换率的setter方法
	 */
	public void setExchRate(java.lang.Double exchRate) {
		this.exchRate = exchRate;
	}	
	/**
	 * 属性折币保额/折币保额的getter方法
	 */
	public java.lang.Double getAmountEx() {
		return amountEx;
	}
	/**
	 * 属性折币保额/折币保额的setter方法
	 */
	public void setAmountEx(java.lang.Double amountEx) {
		this.amountEx = amountEx;
	}	
	/**
	 * 属性折币保费/折币保费的getter方法
	 */
	public java.lang.Double getPremiumEx() {
		return premiumEx;
	}
	/**
	 * 属性折币保费/折币保费的setter方法
	 */
	public void setPremiumEx(java.lang.Double premiumEx) {
		this.premiumEx = premiumEx;
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
