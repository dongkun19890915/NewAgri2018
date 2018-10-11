package com.sinosoft.pms.core.kernel.entity;

import com.sinosoft.framework.core.dao.BasePKImpl;

/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-09-15 09:19:57.041 
 * 条款特别约定表主键操作对象
 */
public class PrpDclauseEngageKey extends BasePKImpl{
	private static final long serialVersionUID = 1L;
	public PrpDclauseEngageKey(){}
	public PrpDclauseEngageKey(String clauseCode,String engageCode){
		this.clauseCode = clauseCode;
		this.engageCode = engageCode;
	}
	/** 属性条款代码/条款代码 */
	private String clauseCode ;
	/** 属性特别约定代码/特别约定代码 */
	private String engageCode ;
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
	 * 属性特别约定代码/特别约定代码的getter方法
	 */
	public String getEngageCode() {
    		return engageCode;
	}
	/**
	 * 属性特别约定代码/特别约定代码的setter方法
	 */
	public void setEngageCode(String engageCode) {
		this.engageCode = engageCode;
	} 
}