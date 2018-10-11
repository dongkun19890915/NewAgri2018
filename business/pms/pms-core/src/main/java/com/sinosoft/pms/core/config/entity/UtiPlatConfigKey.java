package com.sinosoft.pms.core.config.entity;

import com.sinosoft.framework.core.dao.BasePKImpl;

/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-09-15 09:26:56.234 
 * 平台配置表主键操作对象
 */
public class UtiPlatConfigKey extends BasePKImpl{
	private static final long serialVersionUID = 1L;
	public UtiPlatConfigKey(){}
	public UtiPlatConfigKey(String systemCode,String paramCode){
		this.systemCode = systemCode;
		this.paramCode = paramCode;
	}
	/** 属性系统代码/系统代码 */
	private String systemCode ;
	/** 属性参数名/参数名 */
	private String paramCode ;
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
	/**
	 * 属性参数名/参数名的getter方法
	 */
	public String getParamCode() {
    		return paramCode;
	}
	/**
	 * 属性参数名/参数名的setter方法
	 */
	public void setParamCode(String paramCode) {
		this.paramCode = paramCode;
	} 
}