package com.sinosoft.dms.core.dict.entity;

import com.sinosoft.framework.core.dao.BasePKImpl;

import javax.persistence.Column;

/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-10-10 06:45:04.724 
 * 行政区域表主键操作对象
 */
public class AreasKey extends BasePKImpl{
	private static final long serialVersionUID = 1L;
	public AreasKey(){}
	public AreasKey(String areaCode){
		this.areaCode = areaCode;
	}
	/** 属性行政区域代码/行政区域代码 */
	@Column(name = "area_Code")
	private String areaCode ;
	/**
	 * 属性行政区域代码/行政区域代码的getter方法
	 */
	public String getAreaCode() {
    		return areaCode;
	}
	/**
	 * 属性行政区域代码/行政区域代码的setter方法
	 */
	public void setAreaCode(String areaCode) {
		this.areaCode = areaCode;
	} 
}