package com.sinosoft.agriprpall.api.endorsemanage.dto;

import java.io.Serializable;

import com.sinosoft.framework.dto.BaseRequest;
/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-11-04 10:07:09.217 
 * PrpPdangerTotApi操作对象
 */
public class PrpPdangerTotDto extends BaseRequest implements Serializable{
	private static final long serialVersionUID = 1L;
	/** 属性endorseno/endorseno */
	private String endorseNo ;		
	/** 属性危险单位序号/危险单位序号 */
	private Integer dangerNo ;
	/** 属性币别/币别 */
	private String sCurrency ;		
	/** 属性保额/保额 */
	private Double amount ;
	/** 属性保费/保费 */
	private Double premium ;
	/** 属性chgamount/chgamount */
	private Double chgAmount ;
	/** 属性chgpremium/chgpremium */
	private Double chgPremium ;
	/** 属性tcurrency/tcurrency */
	private String tCurrency ;		
	/** 属性exchrate/exchrate */
	private Double exchRate ;
	/** 属性amountex/amountex */
	private Double amountEx ;
	/** 属性premiumex/premiumex */
	private Double premiumEx ;
	/** 属性chgamountex/chgamountex */
	private Double chgAmountEx ;
	/** 属性chgpremiumex/chgpremiumex */
	private Double chgPremiumEx ;
	/** 属性标志字段/标志字段 */
	private String flag ;		
	/**
	 * 属性endorseno/endorseno的getter方法
	 */
	public String getEndorseNo() {
		return endorseNo;
	}
	/**
	 * 属性endorseno/endorseno的setter方法
	 */
	public void setEndorseNo(String endorseNo) {
		this.endorseNo = endorseNo;
	}	
	/**
	 * 属性危险单位序号/危险单位序号的getter方法
	 */
	public Integer getDangerNo() {
		return dangerNo;
	}
	/**
	 * 属性危险单位序号/危险单位序号的setter方法
	 */
	public void setDangerNo(Integer dangerNo) {
		this.dangerNo = dangerNo;
	}	
	/**
	 * 属性币别/币别的getter方法
	 */
	public String getSCurrency() {
		return sCurrency;
	}
	/**
	 * 属性币别/币别的setter方法
	 */
	public void setSCurrency(String sCurrency) {
		this.sCurrency = sCurrency;
	}	
	/**
	 * 属性保额/保额的getter方法
	 */
	public Double getAmount() {
		return amount;
	}
	/**
	 * 属性保额/保额的setter方法
	 */
	public void setAmount(Double amount) {
		this.amount = amount;
	}	
	/**
	 * 属性保费/保费的getter方法
	 */
	public Double getPremium() {
		return premium;
	}
	/**
	 * 属性保费/保费的setter方法
	 */
	public void setPremium(Double premium) {
		this.premium = premium;
	}	
	/**
	 * 属性chgamount/chgamount的getter方法
	 */
	public Double getChgAmount() {
		return chgAmount;
	}
	/**
	 * 属性chgamount/chgamount的setter方法
	 */
	public void setChgAmount(Double chgAmount) {
		this.chgAmount = chgAmount;
	}	
	/**
	 * 属性chgpremium/chgpremium的getter方法
	 */
	public Double getChgPremium() {
		return chgPremium;
	}
	/**
	 * 属性chgpremium/chgpremium的setter方法
	 */
	public void setChgPremium(Double chgPremium) {
		this.chgPremium = chgPremium;
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
	 * 属性exchrate/exchrate的getter方法
	 */
	public Double getExchRate() {
		return exchRate;
	}
	/**
	 * 属性exchrate/exchrate的setter方法
	 */
	public void setExchRate(Double exchRate) {
		this.exchRate = exchRate;
	}	
	/**
	 * 属性amountex/amountex的getter方法
	 */
	public Double getAmountEx() {
		return amountEx;
	}
	/**
	 * 属性amountex/amountex的setter方法
	 */
	public void setAmountEx(Double amountEx) {
		this.amountEx = amountEx;
	}	
	/**
	 * 属性premiumex/premiumex的getter方法
	 */
	public Double getPremiumEx() {
		return premiumEx;
	}
	/**
	 * 属性premiumex/premiumex的setter方法
	 */
	public void setPremiumEx(Double premiumEx) {
		this.premiumEx = premiumEx;
	}	
	/**
	 * 属性chgamountex/chgamountex的getter方法
	 */
	public Double getChgAmountEx() {
		return chgAmountEx;
	}
	/**
	 * 属性chgamountex/chgamountex的setter方法
	 */
	public void setChgAmountEx(Double chgAmountEx) {
		this.chgAmountEx = chgAmountEx;
	}	
	/**
	 * 属性chgpremiumex/chgpremiumex的getter方法
	 */
	public Double getChgPremiumEx() {
		return chgPremiumEx;
	}
	/**
	 * 属性chgpremiumex/chgpremiumex的setter方法
	 */
	public void setChgPremiumEx(Double chgPremiumEx) {
		this.chgPremiumEx = chgPremiumEx;
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
