package com.sinosoft.agriprpall.core.policymanage.entity;

import com.sinosoft.framework.core.dao.BaseEntityImpl;
import javax.persistence.*;
import java.util.Date;

/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-11-05 01:01:20.710 
 * 原始保单费用信息表实体操作对象
 */
@Entity
@Table(name = "PrpCexpenseOrigin")
@IdClass(PrpCexpenseOriginKey.class)
public class PrpCexpenseOrigin extends BaseEntityImpl{

	private static final long serialVersionUID = 1L;
	/** 属性保单号/保单号 */
	@Id
	@Column(name = "policyNo")
	private String policyNo ;	

	/** 属性险种/险种 */
	@Column(name = "riskCode")
	private String riskCode ;
	/** 属性manageFeeRate/manageFeeRate */
	@Column(name = "manageFeeRate")
	private java.lang.Double manageFeeRate ;
	/** 属性maxManageFeeRate/maxManageFeeRate */
	@Column(name = "maxManageFeeRate")
	private java.lang.Double maxManageFeeRate ;
	/** 属性备注/备注 */
	@Column(name = "flag")
	private String flag ;
	/** 属性salvationRate/salvationRate */
	@Column(name = "salvationRate")
	private java.lang.Double salvationRate ;
	/** 属性salvationFee/salvationFee */
	@Column(name = "salvationFee")
	private java.lang.Double salvationFee ;
	/** 属性currency/currency */
	@Column(name = "currency")
	private String currency ;
	/** 属性baseperFormanceRate/baseperFormanceRate */
	@Column(name = "basePerformanceRate")
	private java.lang.Double basePerformanceRate ;
	/** 属性baseperFormance/baseperFormance */
	@Column(name = "basePerformance")
	private java.lang.Double basePerformance ;
	/** 属性encourageperFormanceRate/encourageperFormanceRate */
	@Column(name = "encouragePerformanceRate")
	private java.lang.Double encouragePerformanceRate ;
	/** 属性encourageperFormance/encourageperFormance */
	@Column(name = "encouragePerformance")
	private java.lang.Double encouragePerformance ;
	/** 属性手续费(不含税)/手续费(不含税) */
	@Column(name = "noTaxFee")
	private java.lang.Double noTaxFee ;
	/** 属性手续费对应税率/手续费对应税率 */
	@Column(name = "taxRate")
	private java.lang.Double taxRate ;
	/** 属性手续费对应税额/手续费对应税额 */
	@Column(name = "taxFee")
	private java.lang.Double taxFee ;
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
	public java.lang.Double getManageFeeRate() {
		return manageFeeRate;
	}
	/**
	 * 属性manageFeeRate/manageFeeRate的setter方法
	 */
	public void setManageFeeRate(java.lang.Double manageFeeRate) {
		this.manageFeeRate = manageFeeRate;
	} 	
	/**
	 * 属性maxManageFeeRate/maxManageFeeRate的getter方法
	 */
	public java.lang.Double getMaxManageFeeRate() {
		return maxManageFeeRate;
	}
	/**
	 * 属性maxManageFeeRate/maxManageFeeRate的setter方法
	 */
	public void setMaxManageFeeRate(java.lang.Double maxManageFeeRate) {
		this.maxManageFeeRate = maxManageFeeRate;
	} 	
	/**
	 * 属性备注/备注的getter方法
	 */
	public String getFlag() {
		return flag;
	}
	/**
	 * 属性备注/备注的setter方法
	 */
	public void setFlag(String flag) {
		this.flag = flag;
	} 	
	/**
	 * 属性salvationRate/salvationRate的getter方法
	 */
	public java.lang.Double getSalvationRate() {
		return salvationRate;
	}
	/**
	 * 属性salvationRate/salvationRate的setter方法
	 */
	public void setSalvationRate(java.lang.Double salvationRate) {
		this.salvationRate = salvationRate;
	} 	
	/**
	 * 属性salvationFee/salvationFee的getter方法
	 */
	public java.lang.Double getSalvationFee() {
		return salvationFee;
	}
	/**
	 * 属性salvationFee/salvationFee的setter方法
	 */
	public void setSalvationFee(java.lang.Double salvationFee) {
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
	 * 属性baseperFormanceRate/baseperFormanceRate的getter方法
	 */
	public java.lang.Double getBasePerformanceRate() {
		return basePerformanceRate;
	}
	/**
	 * 属性baseperFormanceRate/baseperFormanceRate的setter方法
	 */
	public void setBasePerformanceRate(java.lang.Double basePerformanceRate) {
		this.basePerformanceRate = basePerformanceRate;
	} 	
	/**
	 * 属性baseperFormance/baseperFormance的getter方法
	 */
	public java.lang.Double getBasePerformance() {
		return basePerformance;
	}
	/**
	 * 属性baseperFormance/baseperFormance的setter方法
	 */
	public void setBasePerformance(java.lang.Double basePerformance) {
		this.basePerformance = basePerformance;
	} 	
	/**
	 * 属性encourageperFormanceRate/encourageperFormanceRate的getter方法
	 */
	public java.lang.Double getEncouragePerformanceRate() {
		return encouragePerformanceRate;
	}
	/**
	 * 属性encourageperFormanceRate/encourageperFormanceRate的setter方法
	 */
	public void setEncouragePerformanceRate(java.lang.Double encouragePerformanceRate) {
		this.encouragePerformanceRate = encouragePerformanceRate;
	} 	
	/**
	 * 属性encourageperFormance/encourageperFormance的getter方法
	 */
	public java.lang.Double getEncouragePerformance() {
		return encouragePerformance;
	}
	/**
	 * 属性encourageperFormance/encourageperFormance的setter方法
	 */
	public void setEncouragePerformance(java.lang.Double encouragePerformance) {
		this.encouragePerformance = encouragePerformance;
	} 	
	/**
	 * 属性手续费(不含税)/手续费(不含税)的getter方法
	 */
	public java.lang.Double getNoTaxFee() {
		return noTaxFee;
	}
	/**
	 * 属性手续费(不含税)/手续费(不含税)的setter方法
	 */
	public void setNoTaxFee(java.lang.Double noTaxFee) {
		this.noTaxFee = noTaxFee;
	} 	
	/**
	 * 属性手续费对应税率/手续费对应税率的getter方法
	 */
	public java.lang.Double getTaxRate() {
		return taxRate;
	}
	/**
	 * 属性手续费对应税率/手续费对应税率的setter方法
	 */
	public void setTaxRate(java.lang.Double taxRate) {
		this.taxRate = taxRate;
	} 	
	/**
	 * 属性手续费对应税额/手续费对应税额的getter方法
	 */
	public java.lang.Double getTaxFee() {
		return taxFee;
	}
	/**
	 * 属性手续费对应税额/手续费对应税额的setter方法
	 */
	public void setTaxFee(java.lang.Double taxFee) {
		this.taxFee = taxFee;
	} 	
}