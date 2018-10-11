package com.sinosoft.pms.core.rate.entity;

import com.sinosoft.framework.core.dao.BasePKImpl;

/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-09-15 09:24:37.739 
 * 折旧率表主键操作对象
 */
public class PrpDdepreCateRateKey extends BasePKImpl{
	private static final long serialVersionUID = 1L;
	public PrpDdepreCateRateKey(){}
	public PrpDdepreCateRateKey(String riskCode,String clauseType,String carKindCode){
		this.riskCode = riskCode;
		this.clauseType = clauseType;
		this.carKindCode = carKindCode;
	}
	/** 属性险种代码/险种代码 */
	private String riskCode ;
	/** 属性条款类别/条款类别 */
	private String clauseType ;
	/** 属性车辆种类代码/车辆种类代码 */
	private String carKindCode ;
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
	 * 属性条款类别/条款类别的getter方法
	 */
	public String getClauseType() {
    		return clauseType;
	}
	/**
	 * 属性条款类别/条款类别的setter方法
	 */
	public void setClauseType(String clauseType) {
		this.clauseType = clauseType;
	} 
	/**
	 * 属性车辆种类代码/车辆种类代码的getter方法
	 */
	public String getCarKindCode() {
    		return carKindCode;
	}
	/**
	 * 属性车辆种类代码/车辆种类代码的setter方法
	 */
	public void setCarKindCode(String carKindCode) {
		this.carKindCode = carKindCode;
	} 
}