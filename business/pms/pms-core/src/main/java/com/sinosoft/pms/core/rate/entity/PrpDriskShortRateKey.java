package com.sinosoft.pms.core.rate.entity;

import com.sinosoft.framework.core.dao.BasePKImpl;

/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-09-15 09:24:37.739 
 * 产品短期费率表主键操作对象
 */
public class PrpDriskShortRateKey extends BasePKImpl{
	private static final long serialVersionUID = 1L;
	public PrpDriskShortRateKey(){}
	public PrpDriskShortRateKey(String riskCode,String shortRateId,String clauseCode,java.lang.Integer serialNo){
		this.riskCode = riskCode;
		this.shortRateId = shortRateId;
		this.clauseCode = clauseCode;
		this.serialNo = serialNo;
	}
	/** 属性产品代码/产品代码 */
	private String riskCode ;
	/** 属性短期费率代码/短期费率代码 */
	private String shortRateId ;
	/** 属性条款代码/条款代码 */
	private String clauseCode ;
	/** 属性序号/序号 */
	private java.lang.Integer serialNo ;
	/**
	 * 属性产品代码/产品代码的getter方法
	 */
	public String getRiskCode() {
    		return riskCode;
	}
	/**
	 * 属性产品代码/产品代码的setter方法
	 */
	public void setRiskCode(String riskCode) {
		this.riskCode = riskCode;
	} 
	/**
	 * 属性短期费率代码/短期费率代码的getter方法
	 */
	public String getShortRateId() {
    		return shortRateId;
	}
	/**
	 * 属性短期费率代码/短期费率代码的setter方法
	 */
	public void setShortRateId(String shortRateId) {
		this.shortRateId = shortRateId;
	} 
	/**
	 * 属性条款代码/条款代码的getter方法
	 */
	public String getClauseCode() {
    		return clauseCode;
	}
	/**
	 * 属性条款代码/条款代码的setter方法
	 */
	public void setClauseCode(String clauseCode) {
		this.clauseCode = clauseCode;
	} 
	/**
	 * 属性序号/序号的getter方法
	 */
	public java.lang.Integer getSerialNo() {
    		return serialNo;
	}
	/**
	 * 属性序号/序号的setter方法
	 */
	public void setSerialNo(java.lang.Integer serialNo) {
		this.serialNo = serialNo;
	} 
}