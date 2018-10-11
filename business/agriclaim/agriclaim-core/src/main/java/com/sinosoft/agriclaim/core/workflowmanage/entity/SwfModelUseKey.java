package com.sinosoft.agriclaim.core.workflowmanage.entity;

import com.sinosoft.framework.core.dao.BasePKImpl;
import javax.persistence.*;

/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-11-08 05:47:03.090 
 * 模板使用设置主键操作对象
 */
public class SwfModelUseKey extends BasePKImpl{
	private static final long serialVersionUID = 1L;
	public SwfModelUseKey(){}
	public SwfModelUseKey(java.lang.Integer modelNo,String riskCode,String comCode,String modelType){
		this.modelNo = modelNo;
		this.riskCode = riskCode;
		this.comCode = comCode;
		this.modelType = modelType;
	}
	/** 属性模板编号/模板编号 */
	@Column(name = "modelNo")
	private java.lang.Integer modelNo ;
	/** 属性险种代码/险种代码 */
	@Column(name = "riskCode")
	private String riskCode ;
	/** 属性部门编码/部门编码 */
	@Column(name = "comCode")
	private String comCode ;
	/** 属性模板类型/模板类型 */
	@Column(name = "modelType")
	private String modelType ;
	/**
	 * 属性模板编号/模板编号的getter方法
	 */
	public java.lang.Integer getModelNo() {
    		return modelNo;
	}
	/**
	 * 属性模板编号/模板编号的setter方法
	 */
	public void setModelNo(java.lang.Integer modelNo) {
		this.modelNo = modelNo;
	} 
	/**
	 * 属性险种代码/险种代码的getter方法
	 */
	public String getRiskCode() {
    		return riskCode;
	}
	/**
	 * 属性险种代码/险种代码的setter方法
	 */
	public void setRiskCode(String riskCode) {
		this.riskCode = riskCode;
	} 
	/**
	 * 属性部门编码/部门编码的getter方法
	 */
	public String getComCode() {
    		return comCode;
	}
	/**
	 * 属性部门编码/部门编码的setter方法
	 */
	public void setComCode(String comCode) {
		this.comCode = comCode;
	} 
	/**
	 * 属性模板类型/模板类型的getter方法
	 */
	public String getModelType() {
    		return modelType;
	}
	/**
	 * 属性模板类型/模板类型的setter方法
	 */
	public void setModelType(String modelType) {
		this.modelType = modelType;
	} 
}