package com.sinosoft.dms.core.model.entity;

import com.sinosoft.framework.core.dao.BasePKImpl;

import javax.persistence.Column;

/**
 * @author codegen@研发中心
 * @mail codegen@sinosoft.com.cn
 * @time  2017-10-21 05:54:45.680 
 * 共保明细信息表主键操作对象
 */
public class PrpModelCoinsDetailKey extends BasePKImpl{
	private static final long serialVersionUID = 1L;
	public PrpModelCoinsDetailKey(){}

	public PrpModelCoinsDetailKey(String modelCode, Integer serialNo, String currency) {
		this.modelCode = modelCode;
		this.serialNo = serialNo;
		this.currency = currency;
	}

	/** 属性proposalNo/proposalNo */
	@Column(name = "modelCode")
	private String modelCode ;
	/** 属性serialNo/serialNo */
	@Column(name = "serialNo")
	private Integer serialNo ;
	@Column(name = "currency")
	private String currency;


	public String getModelCode() {
		return modelCode;
	}

	public void setModelCode(String modelCode) {
		this.modelCode = modelCode;
	}

	/**
	 * 属性serialNo/serialNo的getter方法
	 */
	public Integer getSerialNo() {
    		return serialNo;
	}
	/**
	 * 属性serialNo/serialNo的setter方法
	 */
	public void setSerialNo(Integer serialNo) {
		this.serialNo = serialNo;
	}

	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}
}