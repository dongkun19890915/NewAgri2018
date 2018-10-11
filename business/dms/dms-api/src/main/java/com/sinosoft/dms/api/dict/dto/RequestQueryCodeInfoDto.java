package com.sinosoft.dms.api.dict.dto;

import java.io.Serializable;

import com.sinosoft.framework.dto.BaseRequest;
/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-11-05 01:01:20.710 
 * PrpDCodeApi操作对象
 */
public class RequestQueryCodeInfoDto extends BaseRequest implements Serializable{
	private static final long serialVersionUID = 1L;
	/** 属性 编辑类型/编辑类型 */
	private String codeType ;		
	/** 属性 险种代码/险种代码 */
	private String riskCode ;		
	/** 属性 业务代码名称/ 业务代码名称 */
	private String codeCName ;		
	/** 属性 业务代码/ 业务代码 */
	private String codeCode ;	
	
	/**
	 * 属性codetype/codetype的getter方法
	 */
	public String getCodeType() {
		return codeType;
	}
	/**
	 * 属性codetype/codetype的setter方法
	 */
	public void setCodeType(String codeType) {
		this.codeType = codeType;
	}
	/**
	 * 属性riskCode/riskCode的getter方法
	 */
	public String getRiskCode() {
		return riskCode;
	}
	/**
	 * 属性riskCode/riskCode的setter方法
	 */
	public void setRiskCode(String riskCode) {
		this.riskCode = riskCode;
	}
	/**
	 * 属性codeCName/codeCName的getter方法
	 */
	public String getCodeCName() {
		return codeCName;
	}
	/**
	 * 属性codeCName/codeCName的setter方法
	 */
	public void setCodeCName(String codeCName) {
		this.codeCName = codeCName;
	}
	/**
	 * 属性codeCode/codeCode的getter方法
	 */
	public String getCodeCode() {
		return codeCode;
	}
	/**
	 * 属性codeCode/codeCode的setter方法
	 */
	public void setCodeCode(String codeCode) {
		this.codeCode = codeCode;
	}	

}
