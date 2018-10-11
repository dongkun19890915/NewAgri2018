package com.sinosoft.ims.core.kernel.entity;

import com.sinosoft.framework.core.dao.BasePKImpl;

/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-09-15 09:26:56.234 
 * 信息配置表主键操作对象
 */
public class PrpDriskConfigKey extends BasePKImpl{
	private static final long serialVersionUID = 1L;
	public PrpDriskConfigKey(){}
	public PrpDriskConfigKey(String comCode, String riskCode, String configCode){
		this.comCode = comCode;
		this.riskCode = riskCode;
		this.configCode = configCode;
	}
	/** 属性归属机构/归属机构 */
	private String comCode ;
	/** 属性险种代码/险种代码 */
	private String riskCode ;
	/** 属性配置代码/配置代码 */
	private String configCode ;
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
}