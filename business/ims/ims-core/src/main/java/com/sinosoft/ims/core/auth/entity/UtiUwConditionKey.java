package com.sinosoft.ims.core.auth.entity;

import com.sinosoft.framework.core.dao.BasePKImpl;
import javax.persistence.*;

/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-11-05 01:11:08.689 
 * UtiUwCondition主键操作对象
 */
public class UtiUwConditionKey extends BasePKImpl{
	private static final long serialVersionUID = 1L;
	public UtiUwConditionKey(){}
	public UtiUwConditionKey(String comCode,java.lang.Integer modelNo,java.lang.Integer nodeNo,String riskCode,String classCode,String uwType,String factorCode){
		this.comCode = comCode;
		this.modelNo = modelNo;
		this.nodeNo = nodeNo;
		this.riskCode = riskCode;
		this.classCode = classCode;
		this.uwType = uwType;
		this.factorCode = factorCode;
	}
	/** 属性comCode/comCode */
	@Column(name = "comCode")
	private String comCode ;
	/** 属性modelNo/modelNo */
	@Column(name = "modelNo")
	private java.lang.Integer modelNo ;
	/** 属性nodeNo/nodeNo */
	@Column(name = "nodeNo")
	private java.lang.Integer nodeNo ;
	/** 属性riskCode/riskCode */
	@Column(name = "riskCode")
	private String riskCode ;
	/** 属性classCode/classCode */
	@Column(name = "classCode")
	private String classCode ;
	/** 属性uwType/uwType */
	@Column(name = "uwType")
	private String uwType ;
	/** 属性factorCode/factorCode */
	@Column(name = "factorCode")
	private String factorCode ;
	/**
	 * 属性comCode/comCode的getter方法
	 */
	public String getComCode() {
    		return comCode;
	}
	/**
	 * 属性comCode/comCode的setter方法
	 */
	public void setComCode(String comCode) {
		this.comCode = comCode;
	} 
	/**
	 * 属性modelNo/modelNo的getter方法
	 */
	public java.lang.Integer getModelNo() {
    		return modelNo;
	}
	/**
	 * 属性modelNo/modelNo的setter方法
	 */
	public void setModelNo(java.lang.Integer modelNo) {
		this.modelNo = modelNo;
	} 
	/**
	 * 属性nodeNo/nodeNo的getter方法
	 */
	public java.lang.Integer getNodeNo() {
    		return nodeNo;
	}
	/**
	 * 属性nodeNo/nodeNo的setter方法
	 */
	public void setNodeNo(java.lang.Integer nodeNo) {
		this.nodeNo = nodeNo;
	} 
	/**
	 * 属性riskCode/riskCode的getter方法
	 */
	public String getRiskCode() {
    		return riskCode;
	}
	/**
	 * 属性riskCode/riskCode的setter方法
	 */
	public void setRiskCode(String riskCode) {
		this.riskCode = riskCode;
	} 
	/**
	 * 属性classCode/classCode的getter方法
	 */
	public String getClassCode() {
    		return classCode;
	}
	/**
	 * 属性classCode/classCode的setter方法
	 */
	public void setClassCode(String classCode) {
		this.classCode = classCode;
	} 
	/**
	 * 属性uwType/uwType的getter方法
	 */
	public String getUwType() {
    		return uwType;
	}
	/**
	 * 属性uwType/uwType的setter方法
	 */
	public void setUwType(String uwType) {
		this.uwType = uwType;
	} 
	/**
	 * 属性factorCode/factorCode的getter方法
	 */
	public String getFactorCode() {
    		return factorCode;
	}
	/**
	 * 属性factorCode/factorCode的setter方法
	 */
	public void setFactorCode(String factorCode) {
		this.factorCode = factorCode;
	} 
}