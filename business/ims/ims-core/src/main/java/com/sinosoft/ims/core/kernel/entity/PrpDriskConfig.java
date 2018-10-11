package com.sinosoft.ims.core.kernel.entity;

import com.sinosoft.framework.core.dao.BaseEntityImpl;

import javax.persistence.*;

/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-11-05 01:10:12.703 
 * PrpDriskConfig实体操作对象
 */
@Entity
@Table(name = "PrpDriskConfigAgri")
@IdClass(PrpDriskConfigKey.class)
public class PrpDriskConfig extends BaseEntityImpl{

	private static final long serialVersionUID = 1L;
	/** 属性comCode/comCode */
	@Id
	@Column(name = "comCode")
	private String comCode ;/** 属性riskCode/riskCode */
	@Id
	@Column(name = "riskCode")
	private String riskCode ;/** 属性configCode/configCode */
	@Id
	@Column(name = "configCode")
	private String configCode ;	



	/** 属性configName/configName */
	@Column(name = "configName")
	private String configName ;
	/** 属性configValue/configValue */
	@Column(name = "configValue")
	private String configValue ;
	/** 属性configValueDesc/configValueDesc */
	@Column(name = "configValueDesc")
	private String configValueDesc ;
	/**
	 * 属性comCode/comCode的getter方法
	 */
	public String getComCode() {
		return comCode;
	}
	/**
	 * 属性comCode/comCode的setter方法
	 */
	public void setComCode(String comCode) {
		this.comCode = comCode;
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
	 * 属性configName/configName的getter方法
	 */
	public String getConfigName() {
		return configName;
	}
	/**
	 * 属性configName/configName的setter方法
	 */
	public void setConfigName(String configName) {
		this.configName = configName;
	} 	
	/**
	 * 属性configValue/configValue的getter方法
	 */
	public String getConfigValue() {
		return configValue;
	}
	/**
	 * 属性configValue/configValue的setter方法
	 */
	public void setConfigValue(String configValue) {
		this.configValue = configValue;
	} 	
	/**
	 * 属性configValueDesc/configValueDesc的getter方法
	 */
	public String getConfigValueDesc() {
		return configValueDesc;
	}
	/**
	 * 属性configValueDesc/configValueDesc的setter方法
	 */
	public void setConfigValueDesc(String configValueDesc) {
		this.configValueDesc = configValueDesc;
	} 	
}