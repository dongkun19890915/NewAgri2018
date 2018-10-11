package com.sinosoft.dms.api.dict.dto;

import java.io.Serializable;

import com.sinosoft.framework.dto.BaseRequest;
/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-08-22 03:00:01.505 
 * 通用代码险种对照表Api操作对象
 */
public class PrpDnewCodeRiskDto extends BaseRequest implements Serializable{
	private static final long serialVersionUID = 1L;
	/** 属性代码类型/代码类型 */
	private String codeType ;
	/** 属性业务代码/业务代码 */
	private String codeCode ;
	/** 属性险种代码/险种代码 */
	private String riskCode ;
	/** 属性标志/标志 */
	private String flag ;
	/** 属性创建人/创建人 */
	private String createdBy ;
	/** 属性创建时间/创建时间 */
	private java.util.Date createdTime ;
	/** 属性更新人/更新人 */
	private String updatedBy ;
	/** 属性更新时间/更新时间 */
	private java.util.Date updatedTime ;
	/**
	 * 属性代码类型/代码类型的getter方法
	 */
	public String getCodeType() {
		return codeType;
	}
	/**
	 * 属性代码类型/代码类型的setter方法
	 */
	public void setCodeType(String codeType) {
		this.codeType = codeType;
	}
	/**
	 * 属性业务代码/业务代码的getter方法
	 */
	public String getCodeCode() {
		return codeCode;
	}
	/**
	 * 属性业务代码/业务代码的setter方法
	 */
	public void setCodeCode(String codeCode) {
		this.codeCode = codeCode;
	}
	/**
	 * 属性险种代码/险种代码的getter方法
	 */
	public String getRiskCode() {
		return riskCode;
	}
	/**
	 * 属性险种代码/险种代码的setter方法
	 */
	public void setRiskCode(String riskCode) {
		this.riskCode = riskCode;
	}
	/**
	 * 属性标志/标志的getter方法
	 */
	public String getFlag() {
		return flag;
	}
	/**
	 * 属性标志/标志的setter方法
	 */
	public void setFlag(String flag) {
		this.flag = flag;
	}
	/**
	 * 属性创建人/创建人的getter方法
	 */
	public String getCreatedBy() {
		return createdBy;
	}
	/**
	 * 属性创建人/创建人的setter方法
	 */
	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}
	/**
	 * 属性创建时间/创建时间的getter方法
	 */
	public java.util.Date getCreatedTime() {
		return createdTime;
	}
	/**
	 * 属性创建时间/创建时间的setter方法
	 */
	public void setCreatedTime(java.util.Date createdTime) {
		this.createdTime = createdTime;
	}
	/**
	 * 属性更新人/更新人的getter方法
	 */
	public String getUpdatedBy() {
		return updatedBy;
	}
	/**
	 * 属性更新人/更新人的setter方法
	 */
	public void setUpdatedBy(String updatedBy) {
		this.updatedBy = updatedBy;
	}
	/**
	 * 属性更新时间/更新时间的getter方法
	 */
	public java.util.Date getUpdatedTime() {
		return updatedTime;
	}
	/**
	 * 属性更新时间/更新时间的setter方法
	 */
	public void setUpdatedTime(java.util.Date updatedTime) {
		this.updatedTime = updatedTime;
	}
}
