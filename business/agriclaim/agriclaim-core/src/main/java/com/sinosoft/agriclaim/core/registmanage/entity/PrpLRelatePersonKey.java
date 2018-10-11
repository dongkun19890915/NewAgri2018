package com.sinosoft.agriclaim.core.registmanage.entity;

import com.sinosoft.framework.core.dao.BasePKImpl;
import javax.persistence.*;

/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-11-08 05:45:22.527 
 * 联系人表主键操作对象
 */
public class PrpLRelatePersonKey extends BasePKImpl{
	private static final long serialVersionUID = 1L;
	public PrpLRelatePersonKey(){}
	public PrpLRelatePersonKey(String registNo,String personType,java.lang.Integer serialNo){
		this.registNo = registNo;
		this.personType = personType;
		this.serialNo = serialNo;
	}
	/** 属性报案号码/报案号码 */
	@Column(name = "registNo")
	private String registNo ;
	/** 属性人员类型/人员类型 */
	@Column(name = "personType")
	private String personType ;
	/** 属性序号/序号 */
	@Column(name = "serialNo")
	private java.lang.Integer serialNo ;
	/**
	 * 属性报案号码/报案号码的getter方法
	 */
	public String getRegistNo() {
    		return registNo;
	}
	/**
	 * 属性报案号码/报案号码的setter方法
	 */
	public void setRegistNo(String registNo) {
		this.registNo = registNo;
	} 
	/**
	 * 属性人员类型/人员类型的getter方法
	 */
	public String getPersonType() {
    		return personType;
	}
	/**
	 * 属性人员类型/人员类型的setter方法
	 */
	public void setPersonType(String personType) {
		this.personType = personType;
	} 
	/**
	 * 属性序号/序号的getter方法
	 */
	public java.lang.Integer getSerialNo() {
    		return serialNo;
	}
	/**
	 * 属性序号/序号的setter方法
	 */
	public void setSerialNo(java.lang.Integer serialNo) {
		this.serialNo = serialNo;
	} 
}