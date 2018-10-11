package com.sinosoft.agriclaim.api.checkmanage.dto;

import java.io.Serializable;

import com.sinosoft.framework.dto.BaseRequest;
/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-11-10 02:44:49.773 
 * 质量评审内容表Api操作对象
 */
public class PrplQualityCheckDto extends BaseRequest implements Serializable{
	private static final long serialVersionUID = 1L;
	/** 属性报案号码/报案号码 */
	private String registNo ;		
	/** 属性业务类型/业务类型 */
	private String qualityCheckType ;		
	/** 属性序号/序号 */
	private java.lang.Integer serialNo ;		
	/** 属性评审项目代码/评审项目代码 */
	private String typeCode ;		
	/** 属性评审项目名称/评审项目名称 */
	private String typeName ;		
	/** 属性回访结果/回访结果 */
	private String checkResult ;		
	/** 属性问题备注/问题备注 */
	private String checkRemark ;		
	/** 属性标志字段/标志字段 */
	private String flag ;		
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
	/**
	 * 属性评审项目代码/评审项目代码的getter方法
	 */
	public String getTypeCode() {
		return typeCode;
	}
	/**
	 * 属性评审项目代码/评审项目代码的setter方法
	 */
	public void setTypeCode(String typeCode) {
		this.typeCode = typeCode;
	}	
	/**
	 * 属性评审项目名称/评审项目名称的getter方法
	 */
	public String getTypeName() {
		return typeName;
	}
	/**
	 * 属性评审项目名称/评审项目名称的setter方法
	 */
	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}	
	/**
	 * 属性回访结果/回访结果的getter方法
	 */
	public String getCheckResult() {
		return checkResult;
	}
	/**
	 * 属性回访结果/回访结果的setter方法
	 */
	public void setCheckResult(String checkResult) {
		this.checkResult = checkResult;
	}	
	/**
	 * 属性问题备注/问题备注的getter方法
	 */
	public String getCheckRemark() {
		return checkRemark;
	}
	/**
	 * 属性问题备注/问题备注的setter方法
	 */
	public void setCheckRemark(String checkRemark) {
		this.checkRemark = checkRemark;
	}	
	/**
	 * 属性标志字段/标志字段的getter方法
	 */
	public String getFlag() {
		return flag;
	}
	/**
	 * 属性标志字段/标志字段的setter方法
	 */
	public void setFlag(String flag) {
		this.flag = flag;
	}	
}
