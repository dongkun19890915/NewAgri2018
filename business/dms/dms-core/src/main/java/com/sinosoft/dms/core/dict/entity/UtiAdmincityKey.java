package com.sinosoft.dms.core.dict.entity;

import com.sinosoft.framework.core.dao.BasePKImpl;
import javax.persistence.*;

/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-11-05 01:02:29.563 
 * UtiAdmincity主键操作对象
 */
public class UtiAdmincityKey extends BasePKImpl{
	private static final long serialVersionUID = 1L;
	public UtiAdmincityKey(){}
	public UtiAdmincityKey(String cityCode){
		this.cityCode = cityCode;
	}
	/** 属性citycode/citycode */
	@Column(name = "cityCode")
	private String cityCode ;
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