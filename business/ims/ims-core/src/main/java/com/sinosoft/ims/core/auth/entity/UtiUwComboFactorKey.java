package com.sinosoft.ims.core.auth.entity;

import com.sinosoft.framework.core.dao.BasePKImpl;
import javax.persistence.*;

/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-11-05 01:11:08.689 
 * UtiUwComboFactor主键操作对象
 */
public class UtiUwComboFactorKey extends BasePKImpl{
	private static final long serialVersionUID = 1L;
	public UtiUwComboFactorKey(){}
	public UtiUwComboFactorKey(String uwType,String classCode,String factorCode,String codeType){
		this.uwType = uwType;
		this.classCode = classCode;
		this.factorCode = factorCode;
		this.codeType = codeType;
	}
	/** 属性uwType/uwType */
	@Column(name = "uwType")
	private String uwType ;
	/** 属性classCode/classCode */
	@Column(name = "classCode")
	private String classCode ;
	/** 属性factorCode/factorCode */
	@Column(name = "factorCode")
	private String factorCode ;
	/** 属性codeType/codeType */
	@Column(name = "codeType")
	private String codeType ;
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
	 * 属性codeType/codeType的getter方法
	 */
	public String getCodeType() {
    		return codeType;
	}
	/**
	 * 属性codeType/codeType的setter方法
	 */
	public void setCodeType(String codeType) {
		this.codeType = codeType;
	} 
}