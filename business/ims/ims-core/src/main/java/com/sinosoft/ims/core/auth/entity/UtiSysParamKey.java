package com.sinosoft.ims.core.auth.entity;

import com.sinosoft.framework.core.dao.BasePKImpl;
import javax.persistence.*;

/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-11-05 01:10:45.148 
 * UtiSysParam主键操作对象
 */
public class UtiSysParamKey extends BasePKImpl{
	private static final long serialVersionUID = 1L;
	public UtiSysParamKey(){}
	public UtiSysParamKey(String systemCode,String paramCode){
		this.systemCode = systemCode;
		this.paramCode = paramCode;
	}
	/** 属性systemCode/systemCode */
	@Column(name = "systemCode")
	private String systemCode ;
	/** 属性paramCode/paramCode */
	@Column(name = "paramCode")
	private String paramCode ;
	/**
	 * 属性systemCode/systemCode的getter方法
	 */
	public String getSystemCode() {
    		return systemCode;
	}
	/**
	 * 属性systemCode/systemCode的setter方法
	 */
	public void setSystemCode(String systemCode) {
		this.systemCode = systemCode;
	} 
	/**
	 * 属性paramCode/paramCode的getter方法
	 */
	public String getParamCode() {
    		return paramCode;
	}
	/**
	 * 属性paramCode/paramCode的setter方法
	 */
	public void setParamCode(String paramCode) {
		this.paramCode = paramCode;
	} 
}