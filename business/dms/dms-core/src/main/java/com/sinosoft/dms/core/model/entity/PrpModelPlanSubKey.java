package com.sinosoft.dms.core.model.entity;

import com.sinosoft.framework.core.dao.BasePKImpl;

import javax.persistence.Column;

/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-10-18 03:10:49.566 
 * 收费计划表主键操作对象
 */
public class PrpModelPlanSubKey extends BasePKImpl{
	private static final long serialVersionUID = 1L;
	public PrpModelPlanSubKey(){}

	public PrpModelPlanSubKey(String modelCode, Integer serialNo) {
		this.modelCode = modelCode;
		this.serialNo = serialNo;
	}

	/** 属性投保单号码/投保单号码 */
	@Column(name = "modelCode")
	private String modelCode ;
	/** 属性交费次数序号/交费次数序号 */
	@Column(name = "serialNo")
	private Integer serialNo ;

	public String getModelCode() {
		return modelCode;
	}

	public void setModelCode(String modelCode) {
		this.modelCode = modelCode;
	}

	/**
	 * 属性交费次数序号/交费次数序号的getter方法
	 */
	public Integer getSerialNo() {
    		return serialNo;
	}
	/**
	 * 属性交费次数序号/交费次数序号的setter方法
	 */
	public void setSerialNo(Integer serialNo) {
		this.serialNo = serialNo;
	} 
}