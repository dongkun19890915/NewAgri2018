package com.sinosoft.pms.core.config.entity;

import com.sinosoft.framework.core.dao.BasePKImpl;

/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-09-15 09:26:56.234 
 * 系统参数关联表主键操作对象
 */
public class UtiSysParamKey extends BasePKImpl{
	private static final long serialVersionUID = 1L;
	public UtiSysParamKey(){}
	public UtiSysParamKey(String systemCode,String paramCode){
		this.systemCode = systemCode;
		this.paramCode = paramCode;
	}
	/** 属性系统编码/系统编码 */
	private String systemCode ;
	/** 属性系统参数值/系统参数值 */
	private String paramCode ;
	/**
	 * 属性系统编码/系统编码的getter方法
	 */
	public String getSystemCode() {
    		return systemCode;
	}
	/**
	 * 属性系统编码/系统编码的setter方法
	 */
	public void setSystemCode(String systemCode) {
		this.systemCode = systemCode;
	} 
	/**
	 * 属性系统参数值/系统参数值的getter方法
	 */
	public String getParamCode() {
    		return paramCode;
	}
	/**
	 * 属性系统参数值/系统参数值的setter方法
	 */
	public void setParamCode(String paramCode) {
		this.paramCode = paramCode;
	} 
}