package com.sinosoft.dms.core.model.entity;

import com.sinosoft.framework.core.dao.BasePKImpl;

import javax.persistence.Column;

/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-10-18 03:10:49.566 
 * 保单保额保费表主键操作对象
 */
public class PrpModelFeeSubKey extends BasePKImpl{
	private static final long serialVersionUID = 1L;
	public PrpModelFeeSubKey(){}

	public PrpModelFeeSubKey(String modelCode, String currency) {
		this.modelCode = modelCode;
		this.currency = currency;
	}

	/** 属性投保单号码/投保单号码 */
	@Column(name = "modelCode")
	private String modelCode ;
	/** 属性原币别代码/原币别代码 */
	@Column(name = "currency")
	private String currency ;

	public String getModelCode() {
		return modelCode;
	}

	public void setModelCode(String modelCode) {
		this.modelCode = modelCode;
	}

	/**
	 * 属性原币别代码/原币别代码的getter方法
	 */
	public String getCurrency() {
    		return currency;
	}
	/**
	 * 属性原币别代码/原币别代码的setter方法
	 */
	public void setCurrency(String currency) {
		this.currency = currency;
	} 
}