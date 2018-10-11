package com.sinosoft.dms.core.model.entity;

import com.sinosoft.framework.core.dao.BasePKImpl;

import javax.persistence.Column;

/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-11-13 11:42:08.278 
 * 模板保险地址表主键操作对象
 */
public class PrpModelAddressSubKey extends BasePKImpl{
	private static final long serialVersionUID = 1L;
	public PrpModelAddressSubKey(){}

	public PrpModelAddressSubKey(String modelCode, Integer addressNo) {
		this.modelCode = modelCode;
		this.addressNo = addressNo;
	}

	/** 属性模板号码/模板号码 */
	@Column(name = "modelCode")
	private String modelCode ;

	/** 属性地址序号/地址序号 */
	@Column(name = "addressNo")
	private Integer addressNo ;
	/**
	 * 属性模板号码/模板号码的getter方法
	 */
	public String getModelCode() {
    		return modelCode;
	}
	/**
	 * 属性模板号码/模板号码的setter方法
	 */
	public void setModelCode(String modelCode) {
		this.modelCode = modelCode;
	}

	public Integer getAddressNo() {
		return addressNo;
	}

	public void setAddressNo(Integer addressNo) {
		this.addressNo = addressNo;
	}
}