package com.sinosoft.pms.core.kernel.entity;

import com.sinosoft.framework.core.dao.BasePKImpl;

/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-09-15 09:19:57.041 
 * 限额免赔险种分类子表主键操作对象
 */
public class PrpDlimitClassKey extends BasePKImpl{
	private static final long serialVersionUID = 1L;
	public PrpDlimitClassKey(){}
	public PrpDlimitClassKey(String limitCode,String classCode){
		this.limitCode = limitCode;
		this.classCode = classCode;
	}
	/** 属性限额\免赔代码/限额\免赔代码 */
	private String limitCode ;
	/** 属性险种分类代码/险种分类代码 */
	private String classCode ;
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
	/**
	 * 属性险种分类代码/险种分类代码的getter方法
	 */
	public String getClassCode() {
    		return classCode;
	}
	/**
	 * 属性险种分类代码/险种分类代码的setter方法
	 */
	public void setClassCode(String classCode) {
		this.classCode = classCode;
	} 
}