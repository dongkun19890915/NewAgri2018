package com.sinosoft.pms.core.kernel.entity;

import com.sinosoft.framework.core.dao.BaseEntityImpl;

import javax.persistence.*;

/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-11-04 10:42:46.546 
 * 月短期费率表实体操作对象
 */
@Entity
@Table(name = "PrpDshortRateAgri")
@IdClass(PrpDshortRateKey.class)
public class PrpDshortRate extends BaseEntityImpl{

	private static final long serialVersionUID = 1L;
	/** 属性险种代码/险种代码 */
	@Id
	@Column(name = "riskCode")
	private String riskCode ;/** 属性月份数/月份数 */
	@Id
	@Column(name = "months")
	private java.lang.Integer months ;

	/** 属性费率/费率 */
	@Column(name = "shortRate")
	private java.lang.Double shortRate ;
	/** 属性状态/状态 */
	@Column(name = "validStatus")
	private String validStatus ;
	/** 属性状态位/状态位 */
	@Column(name = "flag")
	private String flag ;
	/**
	 * 属性险种代码/险种代码的getter方法
	 */
	public String getRiskCode() {
		return riskCode;
	}
	/**
	 * 属性险种代码/险种代码的setter方法
	 */
	public void setRiskCode(String riskCode) {
		this.riskCode = riskCode;
	} 	
	/**
	 * 属性月份数/月份数的getter方法
	 */
	public java.lang.Integer getMonths() {
		return months;
	}
	/**
	 * 属性月份数/月份数的setter方法
	 */
	public void setMonths(java.lang.Integer months) {
		this.months = months;
	} 	
	/**
	 * 属性费率/费率的getter方法
	 */
	public java.lang.Double getShortRate() {
		return shortRate;
	}
	/**
	 * 属性费率/费率的setter方法
	 */
	public void setShortRate(java.lang.Double shortRate) {
		this.shortRate = shortRate;
	} 	
	/**
	 * 属性状态/状态的getter方法
	 */
	public String getValidStatus() {
		return validStatus;
	}
	/**
	 * 属性状态/状态的setter方法
	 */
	public void setValidStatus(String validStatus) {
		this.validStatus = validStatus;
	} 	
	/**
	 * 属性状态位/状态位的getter方法
	 */
	public String getFlag() {
		return flag;
	}
	/**
	 * 属性状态位/状态位的setter方法
	 */
	public void setFlag(String flag) {
		this.flag = flag;
	} 	
}