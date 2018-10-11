package com.sinosoft.agriclaim.core.workflowmanage.entity;

import com.sinosoft.framework.core.dao.BaseEntityImpl;

import javax.persistence.*;

/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-11-08 05:47:03.090 
 * 模板使用设置实体操作对象
 */
@Entity
@Table(name = "SwfModelUse")
@IdClass(SwfModelUseKey.class)
public class SwfModelUse extends BaseEntityImpl{

	private static final long serialVersionUID = 1L;
	/** 属性模板编号/模板编号 */
	@Id
	@Column(name = "modelNo")
	private java.lang.Integer modelNo ;/** 属性险种代码/险种代码 */
	@Id
	@Column(name = "riskCode")
	private String riskCode ;/** 属性部门编码/部门编码 */
	@Id
	@Column(name = "comCode")
	private String comCode ;/** 属性模板类型/模板类型 */
	@Id
	@Column(name = "modelType")
	private String modelType ;	




	/** 属性模板状态/模板状态 */
	@Column(name = "modelStatus")
	private String modelStatus ;
	/** 属性标志/标志 */
	@Column(name = "flag")
	private String flag ;
	@Column(name = "systemFlag")
	private String systemFlag;




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
	/**
	 * 属性模板状态/模板状态的getter方法
	 */
	public String getModelStatus() {
		return modelStatus;
	}
	/**
	 * 属性模板状态/模板状态的setter方法
	 */
	public void setModelStatus(String modelStatus) {
		this.modelStatus = modelStatus;
	} 	
	/**
	 * 属性标志/标志的getter方法
	 */
	public String getFlag() {
		return flag;
	}
	/**
	 * 属性标志/标志的setter方法
	 */
	public void setFlag(String flag) {
		this.flag = flag;
	}

	public String getSystemFlag() {
		return systemFlag;
	}

	public void setSystemFlag(String systemFlag) {
		this.systemFlag = systemFlag;
	}
}