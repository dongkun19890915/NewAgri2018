package com.sinosoft.pms.core.kernel.entity;

import com.sinosoft.framework.core.dao.BasePKImpl;

/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-09-15 09:19:57.041 
 * 标的分类表主键操作对象
 */
public class PrpDitemTypeKey extends BasePKImpl{
	private static final long serialVersionUID = 1L;
	public PrpDitemTypeKey(){}
	public PrpDitemTypeKey(String itemCode,String itemTypeBase,String itemTypeCode){
		this.itemCode = itemCode;
		this.itemTypeBase = itemTypeBase;
		this.itemTypeCode = itemTypeCode;
	}
	/** 属性标的代码/标的代码 */
	private String itemCode ;
	/** 属性标的分类标准/标的分类标准 */
	private String itemTypeBase ;
	/** 属性标的分类代码/标的分类代码 */
	private String itemTypeCode ;
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
	/**
	 * 属性标的分类标准/标的分类标准的getter方法
	 */
	public String getItemTypeBase() {
    		return itemTypeBase;
	}
	/**
	 * 属性标的分类标准/标的分类标准的setter方法
	 */
	public void setItemTypeBase(String itemTypeBase) {
		this.itemTypeBase = itemTypeBase;
	} 
	/**
	 * 属性标的分类代码/标的分类代码的getter方法
	 */
	public String getItemTypeCode() {
    		return itemTypeCode;
	}
	/**
	 * 属性标的分类代码/标的分类代码的setter方法
	 */
	public void setItemTypeCode(String itemTypeCode) {
		this.itemTypeCode = itemTypeCode;
	} 
}