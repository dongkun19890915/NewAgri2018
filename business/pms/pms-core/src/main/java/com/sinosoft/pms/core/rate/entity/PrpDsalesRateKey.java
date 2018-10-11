package com.sinosoft.pms.core.rate.entity;

import com.sinosoft.framework.core.dao.BasePKImpl;

/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-09-15 09:24:37.739 
 * 销售费用率配置表主键操作对象
 */
public class PrpDsalesRateKey extends BasePKImpl{
	private static final long serialVersionUID = 1L;
	public PrpDsalesRateKey(){}
	public PrpDsalesRateKey(String riskCode,String businessNature,String versionNo){
		this.riskCode = riskCode;
		this.businessNature = businessNature;
		this.versionNo = versionNo;
	}
	/** 属性产品代码/产品代码 */
	private String riskCode ;
	/** 属性业务来源/业务来源 */
	private String businessNature ;
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
	 * 属性业务来源/业务来源的getter方法
	 */
	public String getBusinessNature() {
    		return businessNature;
	}
	/**
	 * 属性业务来源/业务来源的setter方法
	 */
	public void setBusinessNature(String businessNature) {
		this.businessNature = businessNature;
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