package com.sinosoft.agriprpall.api.endorsemanage.dto;

import java.io.Serializable;

import com.sinosoft.framework.dto.BaseRequest;
/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-10-24 09:50:49.498 
 * PrpPExpenseApi操作对象
 */
public class PrpPexpenseDto extends BaseRequest implements Serializable{
	private static final long serialVersionUID = 1L;
	/** 属性批单号/批单号 */
	private String endorseNo ;		
	/** 属性保单号/保单号 */
	private String policyNo ;		
	/** 属性险种/险种 */
	private String riskCode ;		
	/** 属性manageFeeRate/manageFeeRate */
	private Double manageFeeRate ;
	/** 属性maxManageFeeRate/maxManageFeeRate */
	private Double maxManageFeeRate ;
	/** 属性flag/flag */
	private String flag ;		
	/** 属性salvationRate/salvationRate */
	private Double salvationRate ;
	/** 属性salvationFee/salvationFee */
	private Double salvationFee ;
	/** 属性currency/currency */
	private String currency ;		
	/** 属性basePerformanceRate/basePerformanceRate */
	private Double basePerformanceRate ;
	/** 属性basePerformance/basePerformance */
	private Double basePerformance ;
	/** 属性encouragePerformanceRate/encouragePerformanceRate */
	private Double encouragePerformanceRate ;
	/** 属性encouragePerformance/encouragePerformance */
	private Double encouragePerformance ;
	/** 属性chgBasePerformance/chgBasePerformance */
	private Double chgBasePerformance ;
	/** 属性chgEncouragePerformance/chgEncouragePerformance */
	private Double chgEncouragePerformance ;
	/** 属性手续费(不含税)/手续费(不含税) */
	private Double noTaxFee ;
	/** 属性手续费对应税率/手续费对应税率 */
	private Double taxRate ;
	/** 属性手续费对应税额/手续费对应税额 */
	private Double taxFee ;
	/** 属性手续费对应税额变化量/手续费对应税额变化量 */
	private Double chgTaxFee ;
	/**
	 * 属性批单号/批单号的getter方法
	 */
	public String getEndorseNo() {
		return endorseNo;
	}
	/**
	 * 属性批单号/批单号的setter方法
	 */
	public void setEndorseNo(String endorseNo) {
		this.endorseNo = endorseNo;
	}	
	/**
	 * 属性保单号/保单号的getter方法
	 */
	public String getPolicyNo() {
		return policyNo;
	}
	/**
	 * 属性保单号/保单号的setter方法
	 */
	public void setPolicyNo(String policyNo) {
		this.policyNo = policyNo;
	}	
	/**
	 * 属性险种/险种的getter方法
	 */
	public String getRiskCode() {
		return riskCode;
	}
	/**
	 * 属性险种/险种的setter方法
	 */
	public void setRiskCode(String riskCode) {
		this.riskCode = riskCode;
	}	
	/**
	 * 属性manageFeeRate/manageFeeRate的getter方法
	 */
	public Double getManageFeeRate() {
		return manageFeeRate;
	}
	/**
	 * 属性manageFeeRate/manageFeeRate的setter方法
	 */
	public void setManageFeeRate(Double manageFeeRate) {
		this.manageFeeRate = manageFeeRate;
	}	
	/**
	 * 属性maxManageFeeRate/maxManageFeeRate的getter方法
	 */
	public Double getMaxManageFeeRate() {
		return maxManageFeeRate;
	}
	/**
	 * 属性maxManageFeeRate/maxManageFeeRate的setter方法
	 */
	public void setMaxManageFeeRate(Double maxManageFeeRate) {
		this.maxManageFeeRate = maxManageFeeRate;
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
	/**
	 * 属性salvationRate/salvationRate的getter方法
	 */
	public Double getSalvationRate() {
		return salvationRate;
	}
	/**
	 * 属性salvationRate/salvationRate的setter方法
	 */
	public void setSalvationRate(Double salvationRate) {
		this.salvationRate = salvationRate;
	}	
	/**
	 * 属性salvationFee/salvationFee的getter方法
	 */
	public Double getSalvationFee() {
		return salvationFee;
	}
	/**
	 * 属性salvationFee/salvationFee的setter方法
	 */
	public void setSalvationFee(Double salvationFee) {
		this.salvationFee = salvationFee;
	}	
	/**
	 * 属性currency/currency的getter方法
	 */
	public String getCurrency() {
		return currency;
	}
	/**
	 * 属性currency/currency的setter方法
	 */
	public void setCurrency(String currency) {
		this.currency = currency;
	}	
	/**
	 * 属性basePerformanceRate/basePerformanceRate的getter方法
	 */
	public Double getBasePerformanceRate() {
		return basePerformanceRate;
	}
	/**
	 * 属性basePerformanceRate/basePerformanceRate的setter方法
	 */
	public void setBasePerformanceRate(Double basePerformanceRate) {
		this.basePerformanceRate = basePerformanceRate;
	}	
	/**
	 * 属性basePerformance/basePerformance的getter方法
	 */
	public Double getBasePerformance() {
		return basePerformance;
	}
	/**
	 * 属性basePerformance/basePerformance的setter方法
	 */
	public void setBasePerformance(Double basePerformance) {
		this.basePerformance = basePerformance;
	}	
	/**
	 * 属性encouragePerformanceRate/encouragePerformanceRate的getter方法
	 */
	public Double getEncouragePerformanceRate() {
		return encouragePerformanceRate;
	}
	/**
	 * 属性encouragePerformanceRate/encouragePerformanceRate的setter方法
	 */
	public void setEncouragePerformanceRate(Double encouragePerformanceRate) {
		this.encouragePerformanceRate = encouragePerformanceRate;
	}	
	/**
	 * 属性encouragePerformance/encouragePerformance的getter方法
	 */
	public Double getEncouragePerformance() {
		return encouragePerformance;
	}
	/**
	 * 属性encouragePerformance/encouragePerformance的setter方法
	 */
	public void setEncouragePerformance(Double encouragePerformance) {
		this.encouragePerformance = encouragePerformance;
	}	
	/**
	 * 属性chgBasePerformance/chgBasePerformance的getter方法
	 */
	public Double getChgBasePerformance() {
		return chgBasePerformance;
	}
	/**
	 * 属性chgBasePerformance/chgBasePerformance的setter方法
	 */
	public void setChgBasePerformance(Double chgBasePerformance) {
		this.chgBasePerformance = chgBasePerformance;
	}	
	/**
	 * 属性chgEncouragePerformance/chgEncouragePerformance的getter方法
	 */
	public Double getChgEncouragePerformance() {
		return chgEncouragePerformance;
	}
	/**
	 * 属性chgEncouragePerformance/chgEncouragePerformance的setter方法
	 */
	public void setChgEncouragePerformance(Double chgEncouragePerformance) {
		this.chgEncouragePerformance = chgEncouragePerformance;
	}	
	/**
	 * 属性手续费(不含税)/手续费(不含税)的getter方法
	 */
	public Double getNoTaxFee() {
		return noTaxFee;
	}
	/**
	 * 属性手续费(不含税)/手续费(不含税)的setter方法
	 */
	public void setNoTaxFee(Double noTaxFee) {
		this.noTaxFee = noTaxFee;
	}	
	/**
	 * 属性手续费对应税率/手续费对应税率的getter方法
	 */
	public Double getTaxRate() {
		return taxRate;
	}
	/**
	 * 属性手续费对应税率/手续费对应税率的setter方法
	 */
	public void setTaxRate(Double taxRate) {
		this.taxRate = taxRate;
	}	
	/**
	 * 属性手续费对应税额/手续费对应税额的getter方法
	 */
	public Double getTaxFee() {
		return taxFee;
	}
	/**
	 * 属性手续费对应税额/手续费对应税额的setter方法
	 */
	public void setTaxFee(Double taxFee) {
		this.taxFee = taxFee;
	}	
	/**
	 * 属性手续费对应税额变化量/手续费对应税额变化量的getter方法
	 */
	public Double getChgTaxFee() {
		return chgTaxFee;
	}
	/**
	 * 属性手续费对应税额变化量/手续费对应税额变化量的setter方法
	 */
	public void setChgTaxFee(Double chgTaxFee) {
		this.chgTaxFee = chgTaxFee;
	}	
}
