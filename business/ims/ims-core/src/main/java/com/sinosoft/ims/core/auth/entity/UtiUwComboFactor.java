package com.sinosoft.ims.core.auth.entity;

import com.sinosoft.framework.core.dao.BaseEntityImpl;
import javax.persistence.*;
import java.util.Date;

/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-11-05 01:11:08.689 
 * UtiUwComboFactor实体操作对象
 */
@Entity
@Table(name = "UtiUwComboFactor")
@IdClass(UtiUwComboFactorKey.class)
public class UtiUwComboFactor extends BaseEntityImpl{

	private static final long serialVersionUID = 1L;
	/** 属性uwType/uwType */
	@Id
	@Column(name = "uwType")
	private String uwType ;/** 属性classCode/classCode */
	@Id
	@Column(name = "classCode")
	private String classCode ;/** 属性factorCode/factorCode */
	@Id
	@Column(name = "factorCode")
	private String factorCode ;/** 属性codeType/codeType */
	@Id
	@Column(name = "codeType")
	private String codeType ;	



	/** 属性serialNo/serialNo */
	@Column(name = "serialNo")
	private java.lang.Integer serialNo ;

	/** 属性typeName/typeName */
	@Column(name = "typeName")
	private String typeName ;
	/** 属性validStatus/validStatus */
	@Column(name = "validStatus")
	private String validStatus ;
	/** 属性flag/flag */
	@Column(name = "flag")
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