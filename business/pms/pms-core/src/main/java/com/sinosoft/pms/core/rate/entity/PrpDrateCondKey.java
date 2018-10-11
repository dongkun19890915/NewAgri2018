package com.sinosoft.pms.core.rate.entity;

import com.sinosoft.framework.core.dao.BasePKImpl;

/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-09-15 09:24:37.739 
 * 费率条件表主键操作对象
 */
public class PrpDrateCondKey extends BasePKImpl{
	private static final long serialVersionUID = 1L;
	public PrpDrateCondKey(){}
	public PrpDrateCondKey(String comCode,String riskCode,String factorType,String kindCode,java.lang.Integer ratePeriod,String factorCode){
		this.comCode = comCode;
		this.riskCode = riskCode;
		this.factorType = factorType;
		this.kindCode = kindCode;
		this.ratePeriod = ratePeriod;
		this.factorCode = factorCode;
	}
	/** 属性公司代码/公司代码 */
	private String comCode ;
	/** 属性险种代码/险种代码 */
	private String riskCode ;
	/** 属性因子类型/因子类型 */
	private String factorType ;
	/** 属性险别代码/险别代码 */
	private String kindCode ;
	/** 属性费率期数/费率期数 */
	private java.lang.Integer ratePeriod ;
	/** 属性因子代码/因子代码 */
	private String factorCode ;
	/**
	 * 属性公司代码/公司代码的getter方法
	 */
	public String getComCode() {
    		return comCode;
	}
	/**
	 * 属性公司代码/公司代码的setter方法
	 */
	public void setComCode(String comCode) {
		this.comCode = comCode;
	} 
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
	 * 属性因子类型/因子类型的getter方法
	 */
	public String getFactorType() {
    		return factorType;
	}
	/**
	 * 属性因子类型/因子类型的setter方法
	 */
	public void setFactorType(String factorType) {
		this.factorType = factorType;
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
	 * 属性因子代码/因子代码的getter方法
	 */
	public String getFactorCode() {
    		return factorCode;
	}
	/**
	 * 属性因子代码/因子代码的setter方法
	 */
	public void setFactorCode(String factorCode) {
		this.factorCode = factorCode;
	} 
}