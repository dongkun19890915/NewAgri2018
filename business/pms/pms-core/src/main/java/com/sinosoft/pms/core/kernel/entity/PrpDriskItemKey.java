package com.sinosoft.pms.core.kernel.entity;

import com.sinosoft.framework.core.dao.BasePKImpl;

/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-09-15 09:19:57.041 
 * 产品标的表主键操作对象
 */
public class PrpDriskItemKey extends BasePKImpl{
	private static final long serialVersionUID = 1L;
	public PrpDriskItemKey(){}
	public PrpDriskItemKey(String riskCode,String clauseCode,String itemCode){
		this.riskCode = riskCode;
		this.clauseCode = clauseCode;
		this.itemCode = itemCode;
	}
	/** 属性产品代码/产品代码 */
	private String riskCode ;
	/** 属性条款代码/条款代码 */
	private String clauseCode ;
	/** 属性标的代码/标的代码 */
	private String itemCode ;
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