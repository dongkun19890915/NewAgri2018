package com.sinosoft.ims.api.auth.dto;

import java.io.Serializable;

import com.sinosoft.framework.dto.BaseRequest;
/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-11-05 01:10:45.148 
 * UtiSystemApi操作对象
 */
public class UtiSystemDto extends BaseRequest implements Serializable{
	private static final long serialVersionUID = 1L;
	/** 属性flag/flag */
	private String utiSystem ;		
	/**
	 * 属性flag/flag的getter方法
	 */
	public String getUtiSystem() {
		return utiSystem;
	}
	/**
	 * 属性flag/flag的setter方法
	 */
	public void setUtiSystem(String utiSystem) {
		this.utiSystem = utiSystem;
	}	
}
