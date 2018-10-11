package com.sinosoft.ims.core.auth.entity;

import com.sinosoft.framework.core.dao.BasePKImpl;
import javax.persistence.*;

/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-11-05 01:11:08.689 
 * UwGroup主键操作对象
 */
public class UwGroupKey extends BasePKImpl{
	private static final long serialVersionUID = 1L;
	public UwGroupKey(){}
	public UwGroupKey(java.lang.Integer groupNo,String comCode,String riskCode,String classCode){
		this.groupNo = groupNo;
		this.comCode = comCode;
		this.riskCode = riskCode;
		this.classCode = classCode;
	}
	/** 属性groupNo/groupNo */
	@Column(name = "groupNo")
	private java.lang.Integer groupNo ;
	/** 属性comCode/comCode */
	@Column(name = "comCode")
	private String comCode ;
	/** 属性riskCode/riskCode */
	@Column(name = "riskCode")
	private String riskCode ;
	/** 属性险类/险类 */
	@Column(name = "classCode")
	private String classCode ;
	/**
	 * 属性groupNo/groupNo的getter方法
	 */
	public java.lang.Integer getGroupNo() {
    		return groupNo;
	}
	/**
	 * 属性groupNo/groupNo的setter方法
	 */
	public void setGroupNo(java.lang.Integer groupNo) {
		this.groupNo = groupNo;
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
	 * 属性险类/险类的getter方法
	 */
	public String getClassCode() {
    		return classCode;
	}
	/**
	 * 属性险类/险类的setter方法
	 */
	public void setClassCode(String classCode) {
		this.classCode = classCode;
	} 
}