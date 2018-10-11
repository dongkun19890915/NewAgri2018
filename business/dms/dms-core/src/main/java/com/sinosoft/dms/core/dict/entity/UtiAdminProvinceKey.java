package com.sinosoft.dms.core.dict.entity;

import com.sinosoft.framework.core.dao.BasePKImpl;
import javax.persistence.*;

/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-11-05 01:02:29.563 
 * UtiAdminProvince主键操作对象
 */
public class UtiAdminProvinceKey extends BasePKImpl{
	private static final long serialVersionUID = 1L;
	public UtiAdminProvinceKey(){}
	public UtiAdminProvinceKey(String provinceCode){
		this.provinceCode = provinceCode;
	}
	/** 属性provinceCode/provinceCode */
	@Column(name = "provinceCode")
	private String provinceCode ;
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
}