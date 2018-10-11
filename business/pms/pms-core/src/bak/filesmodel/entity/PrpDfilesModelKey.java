package com.sinosoft.pms.core.filesmodel.entity;

import com.sinosoft.framework.core.dao.BasePK;
import com.sinosoft.framework.core.dao.BasePKImpl;

/**
 * @author codegen@研发中心
 * @mail handongwei@sinosoft.com.cn
 * @time  2016-09-19 10:53:22.125 
 * PrpDexcelModel 主键操作类
 */
public class PrpDfilesModelKey extends BasePKImpl {
	private static final long serialVersionUID = 1L;
	/** 属性RiskCode/产品 */
	private String riskCode ;
	/** 属性ModelType/模板类型 */
	private String modelType ;
	/**
	 * 属性RiskCode/产品的getter方法
	 */
	public String getRiskCode() {
		return riskCode;
	}
	/**
	 * 属性RiskCode/产品的setter方法
	 */
	public void setRiskCode(String riskCode) {
		this.riskCode = riskCode;
	} 
	/**
	 * 属性ModelType/模板类型的getter方法
	 */
	public String getModelType() {
		return modelType;
	}
	/**
	 * 属性ModelType/模板类型的setter方法
	 */
	public void setModelType(String modelType) {
		this.modelType = modelType;
	} 
}