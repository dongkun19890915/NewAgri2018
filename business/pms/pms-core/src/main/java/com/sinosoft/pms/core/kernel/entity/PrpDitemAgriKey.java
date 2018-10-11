package com.sinosoft.pms.core.kernel.entity;

import com.sinosoft.framework.core.dao.BasePKImpl;

import javax.persistence.Column;

/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-11-04 10:42:46.546 
 * 标的项目代码表主键操作对象
 */
public class PrpDitemAgriKey extends BasePKImpl{
	private static final long serialVersionUID = 1L;
	public PrpDitemAgriKey(){}
	public PrpDitemAgriKey(String riskCode, String itemCode){
		this.riskCode = riskCode;
		this.itemCode = itemCode;
	}
	/** 属性险种代码/险种代码 */
	@Column(name = "riskCode")
	private String riskCode ;
	/** 属性标的项目代码/标的项目代码 */
	@Column(name = "itemCode")
	private String itemCode ;
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
	 * 属性标的项目代码/标的项目代码的getter方法
	 */
	public String getItemCode() {
    		return itemCode;
	}
	/**
	 * 属性标的项目代码/标的项目代码的setter方法
	 */
	public void setItemCode(String itemCode) {
		this.itemCode = itemCode;
	} 
}