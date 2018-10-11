package com.sinosoft.pms.core.coinsrate.entity;

import com.sinosoft.framework.core.dao.BasePK;
import com.sinosoft.framework.core.dao.BasePKImpl;

import java.util.Date;
/**
 * @author codegen@研发中心
 * @mail yinqingzhu@sinosoft.com.cn
 * @time  2016-09-17 09:51:06.937 
 * PrpDcoinsRate-共同体成员比例配置表 主键操作类
 */
public class PrpDcoinsRateKey extends BasePKImpl {
	private static final long serialVersionUID = 1L;
	/** 属性VersionNo/版次号 */
	private String versionNo ;
	/** 属性RiskCode/产品代码 */
	private String riskCode ;
	/** 属性ComCode/成员公司代码 */
	private String comCode ;
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
	 * 属性ComCode/成员公司代码的getter方法
	 */
	public String getComCode() {
		return comCode;
	}
	/**
	 * 属性ComCode/成员公司代码的setter方法
	 */
	public void setComCode(String comCode) {
		this.comCode = comCode;
	}
}