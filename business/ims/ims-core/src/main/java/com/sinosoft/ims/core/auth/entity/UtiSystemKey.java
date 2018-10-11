package com.sinosoft.ims.core.auth.entity;

import com.sinosoft.framework.core.dao.BasePKImpl;

/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-08-22 03:00:50.124 
 * 系统定义表主键操作对象
 */
public class UtiSystemKey extends BasePKImpl{
	private static final long serialVersionUID = 1L;
	public UtiSystemKey(){}
	public UtiSystemKey(String systemCode){
		this.systemCode = systemCode;
	}
	/** 属性系统代码/系统代码 */
	private String systemCode ;
	/**
	 * 属性系统代码/系统代码的getter方法
	 */
	public String getSystemCode() {
    		return systemCode;
	}
	/**
	 * 属性系统代码/系统代码的setter方法
	 */
	public void setSystemCode(String systemCode) {
		this.systemCode = systemCode;
	} 
}