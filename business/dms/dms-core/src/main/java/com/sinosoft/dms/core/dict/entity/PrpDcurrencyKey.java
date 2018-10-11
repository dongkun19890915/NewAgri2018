package com.sinosoft.dms.core.dict.entity;

import com.sinosoft.framework.core.dao.BasePKImpl;
import javax.persistence.*;

/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-10-29 03:33:56.492 
 * 币别代码表主键操作对象
 */
public class PrpDcurrencyKey extends BasePKImpl{
	private static final long serialVersionUID = 1L;
	public PrpDcurrencyKey(){}
	public PrpDcurrencyKey(String currencyCode){
		this.currencyCode = currencyCode;
	}
	/** 属性币别代码/币别代码 */
	@Column(name = "currencyCode")
	private String currencyCode ;
	/**
	 * 属性币别代码/币别代码的getter方法
	 */
	public String getCurrencyCode() {
    		return currencyCode;
	}
	/**
	 * 属性币别代码/币别代码的setter方法
	 */
	public void setCurrencyCode(String currencyCode) {
		this.currencyCode = currencyCode;
	} 
}