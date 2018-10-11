package com.sinosoft.ims.core.auth.entity;

import com.sinosoft.framework.core.dao.BasePKImpl;
import javax.persistence.*;

/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-11-05 01:11:08.689 
 * UtiUwFactor主键操作对象
 */
public class UtiUwFactorKey extends BasePKImpl{
	private static final long serialVersionUID = 1L;
	public UtiUwFactorKey(){}
	public UtiUwFactorKey(String uwType,String factorCode,String classCode){
		this.uwType = uwType;
		this.factorCode = factorCode;
		this.classCode = classCode;
	}
	/** 属性uwType/uwType */
	@Column(name = "uwType")
	private String uwType ;
	/** 属性factorCode/factorCode */
	@Column(name = "factorCode")
	private String factorCode ;
	/** 属性classCode/classCode */
	@Column(name = "classCode")
	private String classCode ;
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
}