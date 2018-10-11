package com.sinosoft.pms.core.rate.entity;

import com.sinosoft.framework.core.dao.BasePKImpl;

/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-09-15 09:24:37.739 
 * 费率因子表主键操作对象
 */
public class PrpDrateFactorKey extends BasePKImpl{
	private static final long serialVersionUID = 1L;
	public PrpDrateFactorKey(){}
	public PrpDrateFactorKey(String riskCode,String factorType,String factorCode,String factorTable,String rateType,java.lang.Integer ratePeriod){
		this.riskCode = riskCode;
		this.factorType = factorType;
		this.factorCode = factorCode;
		this.factorTable = factorTable;
		this.rateType = rateType;
		this.ratePeriod = ratePeriod;
	}
	/** 属性险种代码/险种代码 */
	private String riskCode ;
	/** 属性因子类型/因子类型 */
	private String factorType ;
	/** 属性费率因子代码/费率因子代码 */
	private String factorCode ;
	/** 属性费率因子所在表名/费率因子所在表名 */
	private String factorTable ;
	/** 属性系数分组类型/系数分组类型 */
	private String rateType ;
	/** 属性费率期数/费率期数 */
	private java.lang.Integer ratePeriod ;
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
	 * 属性费率因子代码/费率因子代码的getter方法
	 */
	public String getFactorCode() {
    		return factorCode;
	}
	/**
	 * 属性费率因子代码/费率因子代码的setter方法
	 */
	public void setFactorCode(String factorCode) {
		this.factorCode = factorCode;
	} 
	/**
	 * 属性费率因子所在表名/费率因子所在表名的getter方法
	 */
	public String getFactorTable() {
    		return factorTable;
	}
	/**
	 * 属性费率因子所在表名/费率因子所在表名的setter方法
	 */
	public void setFactorTable(String factorTable) {
		this.factorTable = factorTable;
	} 
	/**
	 * 属性系数分组类型/系数分组类型的getter方法
	 */
	public String getRateType() {
    		return rateType;
	}
	/**
	 * 属性系数分组类型/系数分组类型的setter方法
	 */
	public void setRateType(String rateType) {
		this.rateType = rateType;
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
}