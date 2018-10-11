package com.sinosoft.pms.core.kernel.entity;

import com.sinosoft.framework.core.dao.BaseEntityImpl;

import javax.persistence.*;

/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-11-05 01:02:29.563 
 * UtiAdminDistrict实体操作对象
 */
@Entity
@Table(name = "UtiAdminDistrict")
@IdClass(UtiAdminDistrictKey.class)
public class UtiAdminDistrict extends BaseEntityImpl{

	private static final long serialVersionUID = 1L;
	/** 属性districtcode/districtcode */
	@Id
	@Column(name = "districtCode")
	private String districtCode ;	

	/** 属性districtname/districtname */
	@Column(name = "districtName")
	private String districtName ;
	/** 属性citycode/citycode */
	@Column(name = "cityCode")
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