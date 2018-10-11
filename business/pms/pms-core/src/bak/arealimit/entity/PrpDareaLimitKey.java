package com.sinosoft.pms.core.arealimit.entity;

import com.sinosoft.framework.core.dao.BasePKImpl;
/**
 * @author codegen@研发中心
 * @mail yinqingzhu@sinosoft.com.cn
 * @time  2016-09-17 09:50:13.946 
 * PrpDareaLimit-地区限额控制配置表 主键操作类
 */
public class PrpDareaLimitKey extends BasePKImpl{
	private static final long serialVersionUID = 1L;
	/** 属性VersionNo/版次号 */
	private String versionNo ;
	/** 属性RiskCode/产品代码 */
	private String riskCode ;
	/** 属性AreaCode/地区代码 */
	private String areaCode ;
	/**
	 * 属性VersionNo/版次号的getter方法
	 */
	public String getVersionNo() {
		return versionNo;
	}
	/**
	 * 属性VersionNo/版次号的setter方法
	 */
	public void setVersionNo(String versionNo) {
		this.versionNo = versionNo;
	} 
	/**
	 * 属性RiskCode/产品代码的getter方法
	 */
	public String getRiskCode() {
		return riskCode;
	}
	/**
	 * 属性RiskCode/产品代码的setter方法
	 */
	public void setRiskCode(String riskCode) {
		this.riskCode = riskCode;
	} 
	/**
	 * 属性AreaCode/地区代码的getter方法
	 */
	public String getAreaCode() {
		return areaCode;
	}
	/**
	 * 属性AreaCode/地区代码的setter方法
	 */
	public void setAreaCode(String areaCode) {
		this.areaCode = areaCode;
	} 
}