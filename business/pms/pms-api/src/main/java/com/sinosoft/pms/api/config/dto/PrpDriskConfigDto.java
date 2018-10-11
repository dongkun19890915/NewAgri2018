package com.sinosoft.pms.api.config.dto;

import java.io.Serializable;

import com.sinosoft.framework.dto.BaseRequest;
/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-09-15 09:26:56.234 
 * 信息配置表Api操作对象
 */
public class PrpDriskConfigDto extends BaseRequest implements Serializable{
	private static final long serialVersionUID = 1L;
	/** 属性归属机构/归属机构 */
	private String comCode ;		
	/** 属性险种代码/险种代码 */
	private String riskCode ;		
	/** 属性配置代码/配置代码 */
	private String configCode ;		
	/** 属性配置名称/配置名称 */
	private String configName ;		
	/** 属性配置值/配置值 */
	private String configValue ;		
	/** 属性配置值描述/配置值描述 */
	private String configValueDesc ;		
	/** 属性扩展配置/扩展配置 */
	private String extendValue ;		
	/** 属性标志位字段/标志位字段 */
	private String flag ;		
	/** 属性是否有效标志/是否有效标志 */
	private String validStatus ;		
			
			
			
			
	/**
	 * 属性归属机构/归属机构的getter方法
	 */
	public String getComCode() {
		return comCode;
	}
	/**
	 * 属性归属机构/归属机构的setter方法
	 */
	public void setComCode(String comCode) {
		this.comCode = comCode;
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
	 * 属性配置代码/配置代码的getter方法
	 */
	public String getConfigCode() {
		return configCode;
	}
	/**
	 * 属性配置代码/配置代码的setter方法
	 */
	public void setConfigCode(String configCode) {
		this.configCode = configCode;
	}	
	/**
	 * 属性配置名称/配置名称的getter方法
	 */
	public String getConfigName() {
		return configName;
	}
	/**
	 * 属性配置名称/配置名称的setter方法
	 */
	public void setConfigName(String configName) {
		this.configName = configName;
	}	
	/**
	 * 属性配置值/配置值的getter方法
	 */
	public String getConfigValue() {
		return configValue;
	}
	/**
	 * 属性配置值/配置值的setter方法
	 */
	public void setConfigValue(String configValue) {
		this.configValue = configValue;
	}	
	/**
	 * 属性配置值描述/配置值描述的getter方法
	 */
	public String getConfigValueDesc() {
		return configValueDesc;
	}
	/**
	 * 属性配置值描述/配置值描述的setter方法
	 */
	public void setConfigValueDesc(String configValueDesc) {
		this.configValueDesc = configValueDesc;
	}	
	/**
	 * 属性扩展配置/扩展配置的getter方法
	 */
	public String getExtendValue() {
		return extendValue;
	}
	/**
	 * 属性扩展配置/扩展配置的setter方法
	 */
	public void setExtendValue(String extendValue) {
		this.extendValue = extendValue;
	}	
	/**
	 * 属性标志位字段/标志位字段的getter方法
	 */
	public String getFlag() {
		return flag;
	}
	/**
	 * 属性标志位字段/标志位字段的setter方法
	 */
	public void setFlag(String flag) {
		this.flag = flag;
	}	
	/**
	 * 属性是否有效标志/是否有效标志的getter方法
	 */
	public String getValidStatus() {
		return validStatus;
	}
	/**
	 * 属性是否有效标志/是否有效标志的setter方法
	 */
	public void setValidStatus(String validStatus) {
		this.validStatus = validStatus;
	}	
		
		
		
		
}
