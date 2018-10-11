package com.sinosoft.dms.api.dict.dto;

import java.io.Serializable;

import com.sinosoft.framework.dto.BaseRequest;
/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-11-05 01:02:29.563 
 * UtiAdminProvinceApi操作对象
 */
public class UtiAdminProvinceDto extends BaseRequest implements Serializable{
	private static final long serialVersionUID = 1L;
	/** 属性provinceCode/provinceCode */
	private String provinceCode ;		
	/** 属性provinceName/provinceName */
	private String provinceName ;		
	/**
	 * 属性provinceCode/provinceCode的getter方法
	 */
	public String getProvinceCode() {
		return provinceCode;
	}
	/**
	 * 属性provinceCode/provinceCode的setter方法
	 */
	public void setProvinceCode(String provinceCode) {
		this.provinceCode = provinceCode;
	}	
	/**
	 * 属性provinceName/provinceName的getter方法
	 */
	public String getProvinceName() {
		return provinceName;
	}
	/**
	 * 属性provinceName/provinceName的setter方法
	 */
	public void setProvinceName(String provinceName) {
		this.provinceName = provinceName;
	}	
}
