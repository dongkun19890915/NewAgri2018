package com.sinosoft.pms.core.rate.entity;

import com.sinosoft.framework.core.dao.BasePKImpl;

/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-09-15 09:24:37.739 
 * 费率分组表主键操作对象
 */
public class PrpDrateGroupKey extends BasePKImpl{
	private static final long serialVersionUID = 1L;
	public PrpDrateGroupKey(){}
	public PrpDrateGroupKey(String comCode,String rateType,String riskCode,String kindCode,String rateGroupCode,java.lang.Integer ratePeriod){
		this.comCode = comCode;
		this.rateType = rateType;
		this.riskCode = riskCode;
		this.kindCode = kindCode;
		this.rateGroupCode = rateGroupCode;
		this.ratePeriod = ratePeriod;
	}
	/** 属性公司代码/公司代码 */
	private String comCode ;
	/** 属性系数分组类型/系数分组类型 */
	private String rateType ;
	/** 属性险种代码/险种代码 */
	private String riskCode ;
	/** 属性险别代码/险别代码 */
	private String kindCode ;
	/** 属性系数分组代码/系数分组代码 */
	private String rateGroupCode ;
	/** 属性费率期数/费率期数 */
	private java.lang.Integer ratePeriod ;
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
	 * 属性系数分组代码/系数分组代码的getter方法
	 */
	public String getRateGroupCode() {
    		return rateGroupCode;
	}
	/**
	 * 属性系数分组代码/系数分组代码的setter方法
	 */
	public void setRateGroupCode(String rateGroupCode) {
		this.rateGroupCode = rateGroupCode;
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