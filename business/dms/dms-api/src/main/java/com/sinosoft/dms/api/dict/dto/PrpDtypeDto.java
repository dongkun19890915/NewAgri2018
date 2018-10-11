package com.sinosoft.dms.api.dict.dto;

import java.io.Serializable;

import com.sinosoft.framework.dto.BaseRequest;
/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-11-05 01:02:29.563 
 * 通用代码类表Api操作对象
 */
public class PrpDtypeDto extends BaseRequest implements Serializable{
	private static final long serialVersionUID = 1L;
	/** 属性代码类型/代码类型 */
	private String codeType ;		
	/** 属性代码类型描述/代码类型描述 */
	private String codeTypeDesc ;		
	/** 属性新的代码类型/新的代码类型 */
	private String newCodeType ;		
	/** 属性效力状态(0失效/1有效)/效力状态(0失效/1有效) */
	private String validStatus ;		
	/** 属性标志字段/标志字段 */
	private String flag ;		
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
	 * 属性代码类型描述/代码类型描述的getter方法
	 */
	public String getCodeTypeDesc() {
		return codeTypeDesc;
	}
	/**
	 * 属性代码类型描述/代码类型描述的setter方法
	 */
	public void setCodeTypeDesc(String codeTypeDesc) {
		this.codeTypeDesc = codeTypeDesc;
	}	
	/**
	 * 属性新的代码类型/新的代码类型的getter方法
	 */
	public String getNewCodeType() {
		return newCodeType;
	}
	/**
	 * 属性新的代码类型/新的代码类型的setter方法
	 */
	public void setNewCodeType(String newCodeType) {
		this.newCodeType = newCodeType;
	}	
	/**
	 * 属性效力状态(0失效/1有效)/效力状态(0失效/1有效)的getter方法
	 */
	public String getValidStatus() {
		return validStatus;
	}
	/**
	 * 属性效力状态(0失效/1有效)/效力状态(0失效/1有效)的setter方法
	 */
	public void setValidStatus(String validStatus) {
		this.validStatus = validStatus;
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
