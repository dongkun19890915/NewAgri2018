package com.sinosoft.dms.core.model.entity;

import com.sinosoft.framework.core.dao.BasePKImpl;

import javax.persistence.Column;

/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-11-13 11:42:08.278 
 * 模板特别约定表主键操作对象
 */
public class PrpModelEngageSubKey extends BasePKImpl{
	private static final long serialVersionUID = 1L;
	public PrpModelEngageSubKey(){}

	public PrpModelEngageSubKey(String modelCode, Integer serialNo, Integer lineNo) {
		this.modelCode = modelCode;
		this.serialNo = serialNo;
		this.lineNo = lineNo;
	}

	/** 属性模板号码/模板号码 */
	@Column(name = "modelCode")
	private String modelCode ;
	@Column(name = "serialNo")
	private Integer serialNo;
	@Column(name = "lineNo")
	private Integer lineNo;
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

	public Integer getSerialNo() {
		return serialNo;
	}

	public void setSerialNo(Integer serialNo) {
		this.serialNo = serialNo;
	}

	public Integer getLineNo() {
		return lineNo;
	}

	public void setLineNo(Integer lineNo) {
		this.lineNo = lineNo;
	}
}