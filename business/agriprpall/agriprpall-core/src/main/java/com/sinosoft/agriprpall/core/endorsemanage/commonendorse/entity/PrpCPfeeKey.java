package com.sinosoft.agriprpall.core.endorsemanage.commonendorse.entity;

import com.sinosoft.framework.core.dao.BasePKImpl;

import javax.persistence.Column;

/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-10-24 03:06:48.016 
 * 保单保额保费表 主键操作对象
 */
public class PrpCPfeeKey extends BasePKImpl{
	private static final long serialVersionUID = 1L;
	public PrpCPfeeKey(){}
	public PrpCPfeeKey(String policyNo,String currency){
		this.policyNo = policyNo;
		this.currency = currency;
	}
	/** 属性policyNo/policyNo */
	@Column(name = "policyNo")
	private String policyNo ;
	/** 属性currency/currency */
	@Column(name = "currency")
	private String currency ;
	/**
	 * 属性policyNo/policyNo的getter方法
	 */
	public String getPolicyNo() {
    		return policyNo;
	}
	/**
	 * 属性policyNo/policyNo的setter方法
	 */
	public void setPolicyNo(String policyNo) {
		this.policyNo = policyNo;
	} 
	/**
	 * 属性currency/currency的getter方法
	 */
	public String getCurrency() {
    		return currency;
	}
	/**
	 * 属性currency/currency的setter方法
	 */
	public void setCurrency(String currency) {
		this.currency = currency;
	} 
}