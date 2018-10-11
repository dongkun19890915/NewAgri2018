package com.sinosoft.pms.core.kernel.entity;

import com.sinosoft.framework.core.dao.BasePKImpl;

/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-09-15 09:19:57.041 
 * 限额\免陪额表主键操作对象
 */
public class PrpDlimitKey extends BasePKImpl{
	private static final long serialVersionUID = 1L;
	public PrpDlimitKey(){}
	public PrpDlimitKey(String limitCode){
		this.limitCode = limitCode;
	}
	/** 属性限额\免赔代码/限额\免赔代码 */
	private String limitCode ;
	/**
	 * 属性限额\免赔代码/限额\免赔代码的getter方法
	 */
	public String getLimitCode() {
    		return limitCode;
	}
	/**
	 * 属性限额\免赔代码/限额\免赔代码的setter方法
	 */
	public void setLimitCode(String limitCode) {
		this.limitCode = limitCode;
	} 
}