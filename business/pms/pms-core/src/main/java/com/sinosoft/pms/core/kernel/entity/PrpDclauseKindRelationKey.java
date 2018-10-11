package com.sinosoft.pms.core.kernel.entity;

import com.sinosoft.framework.core.dao.BasePKImpl;

/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-09-15 09:19:57.041 
 * 条款/条款责任间关系表主键操作对象
 */
public class PrpDclauseKindRelationKey extends BasePKImpl{
	private static final long serialVersionUID = 1L;
	public PrpDclauseKindRelationKey(){}
	public PrpDclauseKindRelationKey(String clauseCode,String relationCode,java.lang.Integer serialNo){
		this.clauseCode = clauseCode;
		this.relationCode = relationCode;
		this.serialNo = serialNo;
	}
	/** 属性条款代码/条款代码 */
	private String clauseCode ;
	/** 属性关系代码/关系代码 */
	private String relationCode ;
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
	 * 属性关系代码/关系代码的getter方法
	 */
	public String getRelationCode() {
    		return relationCode;
	}
	/**
	 * 属性关系代码/关系代码的setter方法
	 */
	public void setRelationCode(String relationCode) {
		this.relationCode = relationCode;
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