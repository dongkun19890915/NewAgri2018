package com.sinosoft.agriclaim.core.checkmanage.entity;

import com.sinosoft.framework.core.dao.BasePKImpl;
import javax.persistence.*;

/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-11-10 02:44:49.773 
 * 质量评审内容表主键操作对象
 */
public class PrplQualityCheckKey extends BasePKImpl{
	private static final long serialVersionUID = 1L;
	public PrplQualityCheckKey(){}
	public PrplQualityCheckKey(String registNo,String qualityCheckType,java.lang.Integer serialNo){
		this.registNo = registNo;
		this.qualityCheckType = qualityCheckType;
		this.serialNo = serialNo;
	}
	/** 属性报案号码/报案号码 */
	@Column(name = "registNo")
	private String registNo ;
	/** 属性业务类型/业务类型 */
	@Column(name = "qualityCheckType")
	private String qualityCheckType ;
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
	 * 属性业务类型/业务类型的getter方法
	 */
	public String getQualityCheckType() {
    		return qualityCheckType;
	}
	/**
	 * 属性业务类型/业务类型的setter方法
	 */
	public void setQualityCheckType(String qualityCheckType) {
		this.qualityCheckType = qualityCheckType;
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