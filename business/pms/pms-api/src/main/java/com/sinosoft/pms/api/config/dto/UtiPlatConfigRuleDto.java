package com.sinosoft.pms.api.config.dto;

import java.io.Serializable;

import com.sinosoft.framework.dto.BaseRequest;
/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-09-15 09:26:56.234 
 * 平台配置规则表Api操作对象
 */
public class UtiPlatConfigRuleDto extends BaseRequest implements Serializable{
	private static final long serialVersionUID = 1L;
	/** 属性系统代码/系统代码 */
	private String systemCode ;		
	/** 属性参数名/参数名 */
	private String paramCode ;		
	/** 属性序号/序号 */
	private java.lang.Integer serialNo ;		
	/** 属性规则/规则 */
	private String rule ;		
	/** 属性标志/标志 */
	private String flag ;		
			
			
			
			
	/**
	 * 属性系统代码/系统代码的getter方法
	 */
	public String getSystemCode() {
		return systemCode;
	}
	/**
	 * 属性系统代码/系统代码的setter方法
	 */
	public void setSystemCode(String systemCode) {
		this.systemCode = systemCode;
	}	
	/**
	 * 属性参数名/参数名的getter方法
	 */
	public String getParamCode() {
		return paramCode;
	}
	/**
	 * 属性参数名/参数名的setter方法
	 */
	public void setParamCode(String paramCode) {
		this.paramCode = paramCode;
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
	 * 属性规则/规则的getter方法
	 */
	public String getRule() {
		return rule;
	}
	/**
	 * 属性规则/规则的setter方法
	 */
	public void setRule(String rule) {
		this.rule = rule;
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
		
		
		
		
}
