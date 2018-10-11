package com.sinosoft.ims.core.auth.entity;

import com.sinosoft.framework.core.dao.BasePKImpl;
import javax.persistence.*;

/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-11-05 01:11:08.689 
 * UtiUwLevel主键操作对象
 */
public class UtiUwLevelKey extends BasePKImpl{
	private static final long serialVersionUID = 1L;
	public UtiUwLevelKey(){}
	public UtiUwLevelKey(String userCode,String comCode,String riskCode,java.lang.Integer modelNo,java.lang.Integer nodeNo,String uwType){
		this.userCode = userCode;
		this.comCode = comCode;
		this.riskCode = riskCode;
		this.modelNo = modelNo;
		this.nodeNo = nodeNo;
		this.uwType = uwType;
	}
	/** 属性userCode/userCode */
	@Column(name = "userCode")
	private String userCode ;
	/** 属性comCode/comCode */
	@Column(name = "comCode")
	private String comCode ;
	/** 属性riskCode/riskCode */
	@Column(name = "riskCode")
	private String riskCode ;
	/** 属性modelNo/modelNo */
	@Column(name = "modelNo")
	private java.lang.Integer modelNo ;
	/** 属性nodeNo/nodeNo */
	@Column(name = "nodeNo")
	private java.lang.Integer nodeNo ;
	/** 属性uwType/uwType */
	@Column(name = "uwType")
	private String uwType ;
	/**
	 * 属性userCode/userCode的getter方法
	 */
	public String getUserCode() {
    		return userCode;
	}
	/**
	 * 属性userCode/userCode的setter方法
	 */
	public void setUserCode(String userCode) {
		this.userCode = userCode;
	} 
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
}