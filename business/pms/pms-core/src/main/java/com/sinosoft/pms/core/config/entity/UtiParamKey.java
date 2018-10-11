package com.sinosoft.pms.core.config.entity;

import com.sinosoft.framework.core.dao.BasePKImpl;

/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-09-15 09:26:56.234 
 * 参数定义表主键操作对象
 */
public class UtiParamKey extends BasePKImpl{
	private static final long serialVersionUID = 1L;
	public UtiParamKey(){}
	public UtiParamKey(String paramCode){
		this.paramCode = paramCode;
	}
	/** 属性参数名/参数名 */
	private String paramCode ;
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