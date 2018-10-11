package com.sinosoft.ims.api.auth.dto;

import java.io.Serializable;

import com.sinosoft.framework.dto.BaseRequest;
/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-11-05 01:10:12.703 
 * UtiCodeTransferApi操作对象
 */
public class UtiCodeTransferDto extends BaseRequest implements Serializable{
	private static final long serialVersionUID = 1L;
	/** 属性configCode/configCode */
	private String configCode ;		
	/** 属性outerCode/outerCode */
	private String outerCode ;		
	/** 属性innerCode/innerCode */
	private String innerCode ;		
	/** 属性codeType/codeType */
	private String codeType ;		
	/** 属性validStatus/validStatus */
	private String validStatus ;		
	/** 属性riskType/riskType */
	private String riskType ;		
	/**
	 * 属性configCode/configCode的getter方法
	 */
	public String getConfigCode() {
		return configCode;
	}
	/**
	 * 属性configCode/configCode的setter方法
	 */
	public void setConfigCode(String configCode) {
		this.configCode = configCode;
	}	
	/**
	 * 属性outerCode/outerCode的getter方法
	 */
	public String getOuterCode() {
		return outerCode;
	}
	/**
	 * 属性outerCode/outerCode的setter方法
	 */
	public void setOuterCode(String outerCode) {
		this.outerCode = outerCode;
	}	
	/**
	 * 属性innerCode/innerCode的getter方法
	 */
	public String getInnerCode() {
		return innerCode;
	}
	/**
	 * 属性innerCode/innerCode的setter方法
	 */
	public void setInnerCode(String innerCode) {
		this.innerCode = innerCode;
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
	 * 属性riskType/riskType的getter方法
	 */
	public String getRiskType() {
		return riskType;
	}
	/**
	 * 属性riskType/riskType的setter方法
	 */
	public void setRiskType(String riskType) {
		this.riskType = riskType;
	}	
}
