package com.sinosoft.agriprpall.api.proposalmanage.dto;

import java.io.Serializable;

import com.sinosoft.framework.dto.BaseRequest;
/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-10-24 01:57:51.087 
 * 税表Api操作对象
 */
public class PrpTexpenseDto extends BaseRequest implements Serializable{
	private static final long serialVersionUID = 1L;
	/** 属性投保单号 /投保单号  */
	private String proposalNo ;		
	/** 属性险种代码 /险种代码  */
	private String riskCode ;		
	/** 属性管理费率/管理费率 */
	private Double manageFeeRate ;
	/** 属性最大管理费率/最大管理费率 */
	private Double maxManageFeeRate ;
	/** 属性flag/flag */
	private String flag ;		
	/** 属性补贴比例/补贴比例 */
	private Double salvationRate ;
	/** 属性补贴费用/补贴费用 */
	private Double salvationFee ;
	/** 属性币别 /币别  */
	private String currency ;		
	/** 属性基础绩效比例/基础绩效比例 */
	private Double basePerformanceRate ;
	/** 属性基础绩效/基础绩效 */
	private Double basePerformance ;
	/** 属性encouragePerformanceRate/encouragePerformanceRate */
	private Double encouragePerformanceRate ;
	/** 属性encouragePerformance/encouragePerformance */
	private Double encouragePerformance ;
	/** 属性手续费(不含税)/手续费(不含税) */
	private Double noTaxFee ;
	/** 属性手续费对应税率/手续费对应税率 */
	private Double taxRate ;
	/** 属性手续费对应税额/手续费对应税额 */
	private Double taxFee ;
	/** 属性免税比例/免税比例 */
	private Double dutyRatio ;
	/** 属性转出税额/转出税额 */
	private Double transferTax ;
	/**
	 * 属性投保单号 /投保单号 的getter方法
	 */
	public String getProposalNo() {
		return proposalNo;
	}
	/**
	 * 属性投保单号 /投保单号 的setter方法
	 */
	public void setProposalNo(String proposalNo) {
		this.proposalNo = proposalNo;
	}	
	/**
	 * 属性险种代码 /险种代码 的getter方法
	 */
	public String getRiskCode() {
		return riskCode;
	}
	/**
	 * 属性险种代码 /险种代码 的setter方法
	 */
	public void setRiskCode(String riskCode) {
		this.riskCode = riskCode;
	}	
	/**
	 * 属性管理费率/管理费率的getter方法
	 */
	public Double getManageFeeRate() {
		return manageFeeRate;
	}
	/**
	 * 属性管理费率/管理费率的setter方法
	 */
	public void setManageFeeRate(Double manageFeeRate) {
		this.manageFeeRate = manageFeeRate;
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
	 * 属性补贴比例/补贴比例的getter方法
	 */
	public Double getSalvationRate() {
		return salvationRate;
	}
	/**
	 * 属性补贴比例/补贴比例的setter方法
	 */
	public void setSalvationRate(Double salvationRate) {
		this.salvationRate = salvationRate;
	}	
	/**
	 * 属性补贴费用/补贴费用的getter方法
	 */
	public Double getSalvationFee() {
		return salvationFee;
	}
	/**
	 * 属性补贴费用/补贴费用的setter方法
	 */
	public void setSalvationFee(Double salvationFee) {
		this.salvationFee = salvationFee;
	}	
	/**
	 * 属性币别 /币别 的getter方法
	 */
	public String getCurrency() {
		return currency;
	}
	/**
	 * 属性币别 /币别 的setter方法
	 */
	public void setCurrency(String currency) {
		this.currency = currency;
	}

	public Double getMaxManageFeeRate() {
		return maxManageFeeRate;
	}

	public void setMaxManageFeeRate(Double maxManageFeeRate) {
		this.maxManageFeeRate = maxManageFeeRate;
	}

	public Double getBasePerformanceRate() {
		return basePerformanceRate;
	}

	public void setBasePerformanceRate(Double basePerformanceRate) {
		this.basePerformanceRate = basePerformanceRate;
	}

	public Double getBasePerformance() {
		return basePerformance;
	}

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
	 * 属性免税比例/免税比例的getter方法
	 */
	public Double getDutyRatio() {
		return dutyRatio;
	}
	/**
	 * 属性免税比例/免税比例的setter方法
	 */
	public void setDutyRatio(Double dutyRatio) {
		this.dutyRatio = dutyRatio;
	}	
	/**
	 * 属性转出税额/转出税额的getter方法
	 */
	public Double getTransferTax() {
		return transferTax;
	}
	/**
	 * 属性转出税额/转出税额的setter方法
	 */
	public void setTransferTax(Double transferTax) {
		this.transferTax = transferTax;
	}	
}
