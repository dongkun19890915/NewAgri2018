package com.sinosoft.dms.core.dict.entity;

import com.sinosoft.framework.core.dao.BaseEntityImpl;
import javax.persistence.*;
import java.util.Date;

/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-11-05 01:02:29.563 
 * UtiAdminProvince实体操作对象
 */
@Entity
@Table(name = "UtiAdminProvince")
@IdClass(UtiAdminProvinceKey.class)
public class UtiAdminProvince extends BaseEntityImpl{

	private static final long serialVersionUID = 1L;
	/** 属性provinceCode/provinceCode */
	@Id
	@Column(name = "provinceCode")
	private String provinceCode ;	

	/** 属性provinceName/provinceName */
	@Column(name = "provinceName")
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