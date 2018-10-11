package com.sinosoft.dms.api.dict.dto;

import java.io.Serializable;

import com.sinosoft.framework.dto.BaseRequest;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-08-22 03:00:01.505 
 * 通用代码表Api操作对象
 */
@ApiModel(value = "PrpDnewCodeDto", description = "通用代码对象")
public class PrpDnewCodeDto extends BaseRequest implements Serializable{
	private static final long serialVersionUID = 1L;
	/** 属性代码类型/代码类型 */
	@ApiModelProperty(value="代码类型",notes = "代码类型1",example="001")
	private String codeType ;
	/** 属性业务代码/业务代码 */
    @ApiModelProperty(value="业务代码",notes = "业务代码",example="0001")
	private String codeCode ;
	/** 属性代码中文含义/代码中文含义 */
    @ApiModelProperty(value="代码中文含义",notes = "代码中文含义",example="身份证")
	private String codeCName ;
	/** 属性业务代码英文含义/业务代码英文含义 */
	private String codeEName ;
	/** 属性业务代码上级代码/业务代码上级代码 */
	private String upperCode ;
	/** 属性旧代码类型/旧代码类型 */
	private String oldCodeType ;
	/** 属性旧业务代码/旧业务代码 */
	private String oldCodeCode ;
	/** 属性新的业务代码/新的业务代码 */
	private String newCodeCode ;
	/** 属性统一标志/统一标志 */
	private String commonFlag ;
	/** 属性生效日期/生效日期 */
	private java.util.Date validDate ;
	/** 属性在生效日期中/在生效日期中 */
	private java.util.Date invalidDate ;
	/** 属性是否有效/是否有效 */
	private String validStatus ;
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
	 * 属性代码中文含义/代码中文含义的getter方法
	 */
	public String getCodeCName() {
		return codeCName;
	}
	/**
	 * 属性代码中文含义/代码中文含义的setter方法
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
	 * 属性业务代码上级代码/业务代码上级代码的getter方法
	 */
	public String getUpperCode() {
		return upperCode;
	}
	/**
	 * 属性业务代码上级代码/业务代码上级代码的setter方法
	 */
	public void setUpperCode(String upperCode) {
		this.upperCode = upperCode;
	}
	/**
	 * 属性旧代码类型/旧代码类型的getter方法
	 */
	public String getOldCodeType() {
		return oldCodeType;
	}
	/**
	 * 属性旧代码类型/旧代码类型的setter方法
	 */
	public void setOldCodeType(String oldCodeType) {
		this.oldCodeType = oldCodeType;
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
	 * 属性统一标志/统一标志的getter方法
	 */
	public String getCommonFlag() {
		return commonFlag;
	}
	/**
	 * 属性统一标志/统一标志的setter方法
	 */
	public void setCommonFlag(String commonFlag) {
		this.commonFlag = commonFlag;
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
	 * 属性在生效日期中/在生效日期中的getter方法
	 */
	public java.util.Date getInvalidDate() {
		return invalidDate;
	}
	/**
	 * 属性在生效日期中/在生效日期中的setter方法
	 */
	public void setInvalidDate(java.util.Date invalidDate) {
		this.invalidDate = invalidDate;
	}
	/**
	 * 属性是否有效/是否有效的getter方法
	 */
	public String getValidStatus() {
		return validStatus;
	}
	/**
	 * 属性是否有效/是否有效的setter方法
	 */
	public void setValidStatus(String validStatus) {
		this.validStatus = validStatus;
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
