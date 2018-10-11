package com.sinosoft.pms.core.kernel.entity;

import com.sinosoft.framework.core.dao.BasePKImpl;

/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-09-15 10:17:12.257 
 * 标的险种分类子表主键操作对象
 */
public class PrpDitemClassKey extends BasePKImpl{
	private static final long serialVersionUID = 1L;
	public PrpDitemClassKey(){}
	public PrpDitemClassKey(String itemCode   ){
		this.itemCode    = itemCode   ;
	}
	/** 属性标的代码/标的代码 */
	private String itemCode    ;
	/**
	 * 属性标的代码/标的代码的getter方法
	 */
	public String getItemCode   () {
    		return itemCode   ;
	}
	/**
	 * 属性标的代码/标的代码的setter方法
	 */
	public void setItemCode   (String itemCode   ) {
		this.itemCode    = itemCode   ;
	} 
}