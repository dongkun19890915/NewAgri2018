package com.sinosoft.pms.core.kernel.entity;

import com.sinosoft.framework.core.dao.BasePKImpl;

/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-09-15 09:19:57.041 
 * 条款标的表主键操作对象
 */
public class PrpDclauseItemKey extends BasePKImpl{
	private static final long serialVersionUID = 1L;
	public PrpDclauseItemKey(){}
	public PrpDclauseItemKey(String clauseCode,String itemCode){
		this.clauseCode = clauseCode;
		this.itemCode = itemCode;
	}
	/** 属性条款代码/条款代码 */
	private String clauseCode ;
	/** 属性标的代码/标的代码 */
	private String itemCode ;
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
	 * 属性标的代码/标的代码的getter方法
	 */
	public String getItemCode() {
    		return itemCode;
	}
	/**
	 * 属性标的代码/标的代码的setter方法
	 */
	public void setItemCode(String itemCode) {
		this.itemCode = itemCode;
	} 
}