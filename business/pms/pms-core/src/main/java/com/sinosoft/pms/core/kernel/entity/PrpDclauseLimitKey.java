package com.sinosoft.pms.core.kernel.entity;

import com.sinosoft.framework.core.dao.BasePKImpl;

/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-09-15 09:19:57.041 
 * 条款限额免赔保额表主键操作对象
 */
public class PrpDclauseLimitKey extends BasePKImpl{
	private static final long serialVersionUID = 1L;
	public PrpDclauseLimitKey(){}
	public PrpDclauseLimitKey(String clauseCode,java.lang.Integer serialNo,String limitCode){
		this.clauseCode = clauseCode;
		this.serialNo = serialNo;
		this.limitCode = limitCode;
	}
	/** 属性条款代码/条款代码 */
	private String clauseCode ;
	/** 属性限额/免赔序号/限额/免赔序号 */
	private java.lang.Integer serialNo ;
	/** 属性限额/免陪代码/限额/免陪代码 */
	private String limitCode ;
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
	 * 属性限额/免赔序号/限额/免赔序号的getter方法
	 */
	public java.lang.Integer getSerialNo() {
    		return serialNo;
	}
	/**
	 * 属性限额/免赔序号/限额/免赔序号的setter方法
	 */
	public void setSerialNo(java.lang.Integer serialNo) {
		this.serialNo = serialNo;
	} 
	/**
	 * 属性限额/免陪代码/限额/免陪代码的getter方法
	 */
	public String getLimitCode() {
    		return limitCode;
	}
	/**
	 * 属性限额/免陪代码/限额/免陪代码的setter方法
	 */
	public void setLimitCode(String limitCode) {
		this.limitCode = limitCode;
	} 
}