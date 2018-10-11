package com.sinosoft.dms.api.dict.dto;

import java.io.Serializable;

import com.sinosoft.framework.dto.BaseRequest;
/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-11-05 01:02:29.563 
 * UtiAdmincityApi操作对象
 */
public class UtiAdmincityDto extends BaseRequest implements Serializable{
	private static final long serialVersionUID = 1L;
	/** 属性citycode/citycode */
	private String cityCode ;		
	/** 属性cityname/cityname */
	private String cityName ;		
	/** 属性provincecode/provincecode */
	private String provinceCode ;		
	/** 属性addresscode/addresscode */
	private String addressCode ;		
	/** 属性licensenopre/licensenopre */
	private String licenseNoPre ;		
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
	/**
	 * 属性cityname/cityname的getter方法
	 */
	public String getCityName() {
		return cityName;
	}
	/**
	 * 属性cityname/cityname的setter方法
	 */
	public void setCityName(String cityName) {
		this.cityName = cityName;
	}	
	/**
	 * 属性provincecode/provincecode的getter方法
	 */
	public String getProvinceCode() {
		return provinceCode;
	}
	/**
	 * 属性provincecode/provincecode的setter方法
	 */
	public void setProvinceCode(String provinceCode) {
		this.provinceCode = provinceCode;
	}	
	/**
	 * 属性addresscode/addresscode的getter方法
	 */
	public String getAddressCode() {
		return addressCode;
	}
	/**
	 * 属性addresscode/addresscode的setter方法
	 */
	public void setAddressCode(String addressCode) {
		this.addressCode = addressCode;
	}	
	/**
	 * 属性licensenopre/licensenopre的getter方法
	 */
	public String getLicenseNoPre() {
		return licenseNoPre;
	}
	/**
	 * 属性licensenopre/licensenopre的setter方法
	 */
	public void setLicenseNoPre(String licenseNoPre) {
		this.licenseNoPre = licenseNoPre;
	}	
}
