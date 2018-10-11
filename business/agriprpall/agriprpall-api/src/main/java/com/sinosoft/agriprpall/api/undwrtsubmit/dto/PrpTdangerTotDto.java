package com.sinosoft.agriprpall.api.undwrtsubmit.dto;

import java.io.Serializable;

import com.sinosoft.framework.dto.BaseRequest;
/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-10-18 03:18:29.180 
 * PrpTdangerTotApi操作对象
 */
public class PrpTdangerTotDto extends BaseRequest implements Serializable{
	private static final long serialVersionUID = 1L;
	/** 属性proposalNo/proposalNo */
	private String proposalNo ;		
	/** 属性dangerNo/dangerNo */
	private Integer dangerNo ;
	/** 属性scurrency/scurrency */
	private String scurrency ;		
	/** 属性amount/amount */
	private Double amount ;
	/** 属性premium/premium */
	private Double premium ;
	/** 属性tcurrency/tcurrency */
	private String tcurrency ;		
	/** 属性exchrate/exchrate */
	private Double exchrate ;
	/** 属性amountex/amountex */
	private Double amountex ;
	/** 属性premiumex/premiumex */
	private Double premiumex ;
	/** 属性flag/flag */
	private String flag ;		
	/**
	 * 属性proposalNo/proposalNo的getter方法
	 */
	public String getProposalNo() {
		return proposalNo;
	}
	/**
	 * 属性proposalNo/proposalNo的setter方法
	 */
	public void setProposalNo(String proposalNo) {
		this.proposalNo = proposalNo;
	}	
	/**
	 * 属性dangerNo/dangerNo的getter方法
	 */
	public Integer getDangerNo() {
		return dangerNo;
	}
	/**
	 * 属性dangerNo/dangerNo的setter方法
	 */
	public void setDangerNo(Integer dangerNo) {
		this.dangerNo = dangerNo;
	}	
	/**
	 * 属性scurrency/scurrency的getter方法
	 */
	public String getScurrency() {
		return scurrency;
	}
	/**
	 * 属性scurrency/scurrency的setter方法
	 */
	public void setScurrency(String scurrency) {
		this.scurrency = scurrency;
	}	
	/**
	 * 属性amount/amount的getter方法
	 */
	public Double getAmount() {
		return amount;
	}
	/**
	 * 属性amount/amount的setter方法
	 */
	public void setAmount(Double amount) {
		this.amount = amount;
	}	
	/**
	 * 属性premium/premium的getter方法
	 */
	public Double getPremium() {
		return premium;
	}
	/**
	 * 属性premium/premium的setter方法
	 */
	public void setPremium(Double premium) {
		this.premium = premium;
	}	
	/**
	 * 属性tcurrency/tcurrency的getter方法
	 */
	public String getTcurrency() {
		return tcurrency;
	}
	/**
	 * 属性tcurrency/tcurrency的setter方法
	 */
	public void setTcurrency(String tcurrency) {
		this.tcurrency = tcurrency;
	}	
	/**
	 * 属性exchrate/exchrate的getter方法
	 */
	public Double getExchrate() {
		return exchrate;
	}
	/**
	 * 属性exchrate/exchrate的setter方法
	 */
	public void setExchrate(Double exchrate) {
		this.exchrate = exchrate;
	}	
	/**
	 * 属性amountex/amountex的getter方法
	 */
	public Double getAmountex() {
		return amountex;
	}
	/**
	 * 属性amountex/amountex的setter方法
	 */
	public void setAmountex(Double amountex) {
		this.amountex = amountex;
	}	
	/**
	 * 属性premiumex/premiumex的getter方法
	 */
	public Double getPremiumex() {
		return premiumex;
	}
	/**
	 * 属性premiumex/premiumex的setter方法
	 */
	public void setPremiumex(Double premiumex) {
		this.premiumex = premiumex;
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
}
