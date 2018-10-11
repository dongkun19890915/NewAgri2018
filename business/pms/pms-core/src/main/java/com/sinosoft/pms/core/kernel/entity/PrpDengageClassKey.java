package com.sinosoft.pms.core.kernel.entity;

import com.sinosoft.framework.core.dao.BasePKImpl;

/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-09-15 09:19:57.041 
 * 特别约定险类表主键操作对象
 */
public class PrpDengageClassKey extends BasePKImpl{
	private static final long serialVersionUID = 1L;
	public PrpDengageClassKey(){}
	public PrpDengageClassKey(String engageCode,String classCode){
		this.engageCode = engageCode;
		this.classCode = classCode;
	}
	/** 属性特别约定代码/特别约定代码 */
	private String engageCode ;
	/** 属性险种分类代码/险种分类代码 */
	private String classCode ;
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