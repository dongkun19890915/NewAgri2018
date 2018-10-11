package com.sinosoft.dms.core.dict.entity;

import com.sinosoft.framework.core.dao.BaseEntityImpl;
import javax.persistence.*;
import java.util.Date;

/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-11-05 01:02:29.563 
 * UtiAdmincity实体操作对象
 */
@Entity
@Table(name = "UtiAdmincity")
@IdClass(UtiAdmincityKey.class)
public class UtiAdmincity extends BaseEntityImpl{

	private static final long serialVersionUID = 1L;
	/** 属性citycode/citycode */
	@Id
	@Column(name = "cityCode")
	private String cityCode ;	

	/** 属性cityname/cityname */
	@Column(name = "cityName")
	private String cityName ;
	/** 属性provincecode/provincecode */
	@Column(name = "provinceCode")
	private String provinceCode ;
	/** 属性addresscode/addresscode */
	@Column(name = "addressCode")
	private String addressCode ;
	/** 属性licensenopre/licensenopre */
	@Column(name = "licenseNoPre")
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