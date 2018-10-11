package com.sinosoft.dms.api.dict.dto;

import java.io.Serializable;

import com.sinosoft.framework.dto.BaseRequest;
/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-11-05 01:01:20.710 
 * 通用代码表Api操作对象
 */
public class PrpDcodeDto extends BaseRequest implements Serializable{
	private static final long serialVersionUID = 1L;
	/** 属性代码类型(见PrpDtype表)/代码类型(见PrpDtype表) */
	private String codeType ;		
	/** 属性业务代码/业务代码 */
	private String codeCode ;		
	/** 属性业务代码中文含义/业务代码中文含义 */
	private String codeCName ;		
	/** 属性业务代码英文含义/业务代码英文含义 */
	private String codeEName ;		
	/** 属性新的业务代码/新的业务代码 */
	private String newCodeCode ;		
	/** 属性效力状态(0失效/1有效)/效力状态(0失效/1有效) */
	private String validStatus ;		
	/** 属性标志字段/标志字段 */
	private String flag ;		
	/** 属性旧业务代码/旧业务代码 */
	private String oldCodeCode ;		
	/** 属性旧的代码类型/旧的代码类型 */
	private String oldCodeType ;		
	/** 属性新的代码类型/新的代码类型 */
	private String newCodeType ;		
	/** 属性代码级别/代码级别 */
	private String codeLevel ;		
	/** 属性上级代码/上级代码 */
	private String upperCode ;		
	/** 属性代码中文描述/代码中文描述 */
	private String codeCDesc ;		
	/** 属性生效日期/生效日期 */
	private java.util.Date validDate ;		
	/** 属性失效日期/失效日期 */
	private java.util.Date invalidDate ;
	/** 排序序号 */
	private Integer serialNo ;
	/**
	 * 属性代码类型(见PrpDtype表)/代码类型(见PrpDtype表)的getter方法
	 */
	public String getCodeType() {
		return codeType;
	}
	/**
	 * 属性代码类型(见PrpDtype表)/代码类型(见PrpDtype表)的setter方法
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
	 * 属性业务代码中文含义/业务代码中文含义的getter方法
	 */
	public String getCodeCName() {
		return codeCName;
	}
	/**
	 * 属性业务代码中文含义/业务代码中文含义的setter方法
	 */
	public void setCodeCName(String codeCName) {
		this.codeCName = codeCName;
	}	
	/**
	 * 属性业务代码英文含义/业务代码英文含义的getter方法
	 */
	public String getCodeEName() {
		return codeEName;
	}
	/**
	 * 属性业务代码英文含义/业务代码英文含义的setter方法
	 */
	public void setCodeEName(String codeEName) {
		this.codeEName = codeEName;
	}	
	/**
	 * 属性新的业务代码/新的业务代码的getter方法
	 */
	public String getNewCodeCode() {
		return newCodeCode;
	}
	/**
	 * 属性新的业务代码/新的业务代码的setter方法
	 */
	public void setNewCodeCode(String newCodeCode) {
		this.newCodeCode = newCodeCode;
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
	/**
	 * 属性旧业务代码/旧业务代码的getter方法
	 */
	public String getOldCodeCode() {
		return oldCodeCode;
	}
	/**
	 * 属性旧业务代码/旧业务代码的setter方法
	 */
	public void setOldCodeCode(String oldCodeCode) {
		this.oldCodeCode = oldCodeCode;
	}	
	/**
	 * 属性旧的代码类型/旧的代码类型的getter方法
	 */
	public String getOldCodeType() {
		return oldCodeType;
	}
	/**
	 * 属性旧的代码类型/旧的代码类型的setter方法
	 */
	public void setOldCodeType(String oldCodeType) {
		this.oldCodeType = oldCodeType;
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
	 * 属性代码级别/代码级别的getter方法
	 */
	public String getCodeLevel() {
		return codeLevel;
	}
	/**
	 * 属性代码级别/代码级别的setter方法
	 */
	public void setCodeLevel(String codeLevel) {
		this.codeLevel = codeLevel;
	}	
	/**
	 * 属性上级代码/上级代码的getter方法
	 */
	public String getUpperCode() {
		return upperCode;
	}
	/**
	 * 属性上级代码/上级代码的setter方法
	 */
	public void setUpperCode(String upperCode) {
		this.upperCode = upperCode;
	}	
	/**
	 * 属性代码中文描述/代码中文描述的getter方法
	 */
	public String getCodeCDesc() {
		return codeCDesc;
	}
	/**
	 * 属性代码中文描述/代码中文描述的setter方法
	 */
	public void setCodeCDesc(String codeCDesc) {
		this.codeCDesc = codeCDesc;
	}	
	/**
	 * 属性生效日期/生效日期的getter方法
	 */
	public java.util.Date getValidDate() {
		return validDate;
	}
	/**
	 * 属性生效日期/生效日期的setter方法
	 */
	public void setValidDate(java.util.Date validDate) {
		this.validDate = validDate;
	}	
	/**
	 * 属性失效日期/失效日期的getter方法
	 */
	public java.util.Date getInvalidDate() {
		return invalidDate;
	}
	/**
	 * 属性失效日期/失效日期的setter方法
	 */
	public void setInvalidDate(java.util.Date invalidDate) {
		this.invalidDate = invalidDate;
	}

	public Integer getSerialNo() {
		return serialNo;
	}

	public void setSerialNo(Integer serialNo) {
		this.serialNo = serialNo;
	}
}
