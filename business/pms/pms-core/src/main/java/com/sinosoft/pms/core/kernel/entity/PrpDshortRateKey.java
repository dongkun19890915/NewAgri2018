package com.sinosoft.pms.core.kernel.entity;

import com.sinosoft.framework.core.dao.BasePKImpl;
import javax.persistence.*;

/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-11-04 10:42:46.546 
 * 月短期费率表主键操作对象
 */
public class PrpDshortRateKey extends BasePKImpl{
	private static final long serialVersionUID = 1L;
	public PrpDshortRateKey(){}
	public PrpDshortRateKey(String riskCode,java.lang.Integer months){
		this.riskCode = riskCode;
		this.months = months;
	}
	/** 属性险种代码/险种代码 */
	@Column(name = "riskCode")
	private String riskCode ;
	/** 属性月份数/月份数 */
	@Column(name = "months")
	private java.lang.Integer months ;
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
	 * 属性月份数/月份数的getter方法
	 */
	public java.lang.Integer getMonths() {
    		return months;
	}
	/**
	 * 属性月份数/月份数的setter方法
	 */
	public void setMonths(java.lang.Integer months) {
		this.months = months;
	} 
}