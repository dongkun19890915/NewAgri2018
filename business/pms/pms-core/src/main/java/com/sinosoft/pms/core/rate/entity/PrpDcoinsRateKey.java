package com.sinosoft.pms.core.rate.entity;

import com.sinosoft.framework.core.dao.BasePKImpl;

/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-09-15 09:24:37.739 
 * 共同体成员比例配置表主键操作对象
 */
public class PrpDcoinsRateKey extends BasePKImpl{
	private static final long serialVersionUID = 1L;
	public PrpDcoinsRateKey(){}
	public PrpDcoinsRateKey(String riskCode,String comCode,String versionNo){
		this.riskCode = riskCode;
		this.comCode = comCode;
		this.versionNo = versionNo;
	}
	/** 属性产品代码/产品代码 */
	private String riskCode ;
	/** 属性成员公司代码/成员公司代码 */
	private String comCode ;
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
	 * 属性成员公司代码/成员公司代码的getter方法
	 */
	public String getComCode() {
    		return comCode;
	}
	/**
	 * 属性成员公司代码/成员公司代码的setter方法
	 */
	public void setComCode(String comCode) {
		this.comCode = comCode;
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