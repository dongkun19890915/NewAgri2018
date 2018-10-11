package com.sinosoft.pms.core.productrule.entity;

import com.sinosoft.framework.core.dao.BasePK;
import com.sinosoft.framework.core.dao.BasePKImpl;

import java.util.Date;
/**
 * @author codegen@研发中心
 * @mail handongwei@sinosoft.com.cn
 * @time  2016-09-18 20:27:00.111 
 * UtiFactor 主键操作类
 */
public class UtiFactorKey extends BasePKImpl {
	private static final long serialVersionUID = 1L;
	/** 属性RiskCode/ */
	private String riskCode ;
	/** 属性FactorCode/ */
	private String factorCode ;
	/**
	 * 属性RiskCode/的getter方法
	 */
	public String getRiskCode() {
		return riskCode;
	}
	/**
	 * 属性RiskCode/的setter方法
	 */
	public void setRiskCode(String riskCode) {
		this.riskCode = riskCode;
	} 
	/**
	 * 属性FactorCode/的getter方法
	 */
	public String getFactorCode() {
		return factorCode;
	}
	/**
	 * 属性FactorCode/的setter方法
	 */
	public void setFactorCode(String factorCode) {
		this.factorCode = factorCode;
	} 
}