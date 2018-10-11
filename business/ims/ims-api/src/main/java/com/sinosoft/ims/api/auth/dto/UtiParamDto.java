package com.sinosoft.ims.api.auth.dto;

import java.io.Serializable;

import com.sinosoft.framework.dto.BaseRequest;
/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-11-05 01:10:45.148 
 * UtiParamApi操作对象
 */
public class UtiParamDto extends BaseRequest implements Serializable{
	private static final long serialVersionUID = 1L;
	/** 属性paramCode/paramCode */
	private String paramCode ;		
	/** 属性paramDesc/paramDesc */
	private String paramDesc ;		
	/** 属性paramType/paramType */
	private String paramType ;		
	/** 属性modifyFlag/modifyFlag */
	private String modifyFlag ;		
	/** 属性validStatus/validStatus */
	private String validStatus ;		
	/** 属性remark/remark */
	private String remark ;		
	/** 属性flag/flag */
	private String flag ;		
	/**
	 * 属性paramCode/paramCode的getter方法
	 */
	public String getParamCode() {
		return paramCode;
	}
	/**
	 * 属性paramCode/paramCode的setter方法
	 */
	public void setParamCode(String paramCode) {
		this.paramCode = paramCode;
	}	
	/**
	 * 属性paramDesc/paramDesc的getter方法
	 */
	public String getParamDesc() {
		return paramDesc;
	}
	/**
	 * 属性paramDesc/paramDesc的setter方法
	 */
	public void setParamDesc(String paramDesc) {
		this.paramDesc = paramDesc;
	}	
	/**
	 * 属性paramType/paramType的getter方法
	 */
	public String getParamType() {
		return paramType;
	}
	/**
	 * 属性paramType/paramType的setter方法
	 */
	public void setParamType(String paramType) {
		this.paramType = paramType;
	}	
	/**
	 * 属性modifyFlag/modifyFlag的getter方法
	 */
	public String getModifyFlag() {
		return modifyFlag;
	}
	/**
	 * 属性modifyFlag/modifyFlag的setter方法
	 */
	public void setModifyFlag(String modifyFlag) {
		this.modifyFlag = modifyFlag;
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
	 * 属性remark/remark的getter方法
	 */
	public String getRemark() {
		return remark;
	}
	/**
	 * 属性remark/remark的setter方法
	 */
	public void setRemark(String remark) {
		this.remark = remark;
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
