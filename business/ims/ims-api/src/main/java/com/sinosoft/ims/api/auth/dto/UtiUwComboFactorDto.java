package com.sinosoft.ims.api.auth.dto;

import java.io.Serializable;

import com.sinosoft.framework.dto.BaseRequest;
/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-11-05 01:11:08.689 
 * UtiUwComboFactorApi操作对象
 */
public class UtiUwComboFactorDto extends BaseRequest implements Serializable{
	private static final long serialVersionUID = 1L;
	/** 属性uwType/uwType */
	private String uwType ;		
	/** 属性classCode/classCode */
	private String classCode ;		
	/** 属性factorCode/factorCode */
	private String factorCode ;		
	/** 属性serialNo/serialNo */
	private java.lang.Integer serialNo ;		
	/** 属性codeType/codeType */
	private String codeType ;		
	/** 属性typeName/typeName */
	private String typeName ;		
	/** 属性validStatus/validStatus */
	private String validStatus ;		
	/** 属性flag/flag */
	private String flag ;		
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
	 * 属性serialNo/serialNo的getter方法
	 */
	public java.lang.Integer getSerialNo() {
		return serialNo;
	}
	/**
	 * 属性serialNo/serialNo的setter方法
	 */
	public void setSerialNo(java.lang.Integer serialNo) {
		this.serialNo = serialNo;
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
	/**
	 * 属性typeName/typeName的getter方法
	 */
	public String getTypeName() {
		return typeName;
	}
	/**
	 * 属性typeName/typeName的setter方法
	 */
	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}	
	/**
	 * 属性validStatus/validStatus的getter方法
	 */
	public String getValidStatus() {
		return validStatus;
	}
	/**
	 * 属性validStatus/validStatus的setter方法
	 */
	public void setValidStatus(String validStatus) {
		this.validStatus = validStatus;
	}	
	/**
	 * 属性flag/flag的getter方法
	 */
	public String getFlag() {
		return flag;
	}
	/**
	 * 属性flag/flag的setter方法
	 */
	public void setFlag(String flag) {
		this.flag = flag;
	}	
}
