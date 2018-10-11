package com.sinosoft.pms.core.rate.entity;

import com.sinosoft.framework.core.dao.BasePKImpl;

/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-09-15 10:03:16.817 
 * 条款短期费率表主键操作对象
 */
public class PrpDclauseShortRateKey extends BasePKImpl{
	private static final long serialVersionUID = 1L;
	public PrpDclauseShortRateKey(){}
	public PrpDclauseShortRateKey(String clauseCode,String shortRateId,java.lang.Integer serialNo){
		this.clauseCode = clauseCode;
		this.shortRateId = shortRateId;
		this.serialNo = serialNo;
	}
	/** 属性条款代码/条款代码 */
	private String clauseCode ;
	/** 属性短期费率代码/短期费率代码 */
	private String shortRateId ;
	/** 属性序号/序号 */
	private java.lang.Integer serialNo ;
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