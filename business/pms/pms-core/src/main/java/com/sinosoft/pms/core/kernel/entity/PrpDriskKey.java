package com.sinosoft.pms.core.kernel.entity;

import com.sinosoft.framework.core.dao.BasePKImpl;

/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-09-15 09:19:57.041 
 * 产品定义表主键操作对象
 */
public class PrpDriskKey extends BasePKImpl{
	private static final long serialVersionUID = 1L;
	public PrpDriskKey(){}
	public PrpDriskKey(String riskCode){
		this.riskCode = riskCode;
	}
	/** 属性险种代码/险种代码 */
	private String riskCode ;
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
}