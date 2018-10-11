package com.sinosoft.dms.core.dict.entity;

import com.sinosoft.framework.core.dao.BasePKImpl;
import javax.persistence.*;

/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-11-05 01:02:29.563 
 * UtiAdminDistrict主键操作对象
 */
public class UtiAdminDistrictKey extends BasePKImpl{
	private static final long serialVersionUID = 1L;
	public UtiAdminDistrictKey(){}
	public UtiAdminDistrictKey(String districtCode){
		this.districtCode = districtCode;
	}
	/** 属性districtcode/districtcode */
	@Column(name = "districtCode")
	private String districtCode ;
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
}