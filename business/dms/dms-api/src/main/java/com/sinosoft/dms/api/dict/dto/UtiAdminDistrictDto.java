package com.sinosoft.dms.api.dict.dto;

import java.io.Serializable;

import com.sinosoft.framework.dto.BaseRequest;
/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-11-05 01:02:29.563 
 * UtiAdminDistrictApi操作对象
 */
public class UtiAdminDistrictDto extends BaseRequest implements Serializable{
	private static final long serialVersionUID = 1L;
	/** 属性districtcode/districtcode */
	private String districtCode ;		
	/** 属性districtname/districtname */
	private String districtName ;		
	/** 属性citycode/citycode */
	private String cityCode ;		
	/**
	 * 属性districtcode/districtcode的getter方法
	 */
	public String getDistrictCode() {
		return districtCode;
	}
	/**
	 * 属性districtcode/districtcode的setter方法
	 */
	public void setDistrictCode(String districtCode) {
		this.districtCode = districtCode;
	}	
	/**
	 * 属性districtname/districtname的getter方法
	 */
	public String getDistrictName() {
		return districtName;
	}
	/**
	 * 属性districtname/districtname的setter方法
	 */
	public void setDistrictName(String districtName) {
		this.districtName = districtName;
	}	
	/**
	 * 属性citycode/citycode的getter方法
	 */
	public String getCityCode() {
		return cityCode;
	}
	/**
	 * 属性citycode/citycode的setter方法
	 */
	public void setCityCode(String cityCode) {
		this.cityCode = cityCode;
	}	
}
