package com.sinosoft.pms.core.misc.entity;

import com.sinosoft.framework.core.dao.BasePKImpl;

/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-09-15 09:15:28.416 
 * 地区限额控制配置表主键操作对象
 */
public class PrpDareaLimitKey extends BasePKImpl{
	private static final long serialVersionUID = 1L;
	public PrpDareaLimitKey(){}
	public PrpDareaLimitKey(String riskCode,String areaCode,String versionNo){
		this.riskCode = riskCode;
		this.areaCode = areaCode;
		this.versionNo = versionNo;
	}
	/** 属性产品代码/产品代码 */
	private String riskCode ;
	/** 属性地区代码/地区代码 */
	private String areaCode ;
	/** 属性版次号/版次号 */
	private String versionNo ;
	/**
	 * 属性产品代码/产品代码的getter方法
	 */
	public String getRiskCode() {
    		return riskCode;
	}
	/**
	 * 属性产品代码/产品代码的setter方法
	 */
	public void setRiskCode(String riskCode) {
		this.riskCode = riskCode;
	} 
	/**
	 * 属性地区代码/地区代码的getter方法
	 */
	public String getAreaCode() {
    		return areaCode;
	}
	/**
	 * 属性地区代码/地区代码的setter方法
	 */
	public void setAreaCode(String areaCode) {
		this.areaCode = areaCode;
	} 
	/**
	 * 属性版次号/版次号的getter方法
	 */
	public String getVersionNo() {
    		return versionNo;
	}
	/**
	 * 属性版次号/版次号的setter方法
	 */
	public void setVersionNo(String versionNo) {
		this.versionNo = versionNo;
	} 
}