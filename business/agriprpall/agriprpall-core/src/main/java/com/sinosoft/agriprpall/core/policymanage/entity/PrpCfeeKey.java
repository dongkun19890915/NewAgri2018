package com.sinosoft.agriprpall.core.policymanage.entity;

import com.sinosoft.framework.core.dao.BasePKImpl;
import javax.persistence.*;

/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-10-24 07:46:04.010 
 * 保单保额保费表主键操作对象
 */
public class PrpCfeeKey extends BasePKImpl{
	private static final long serialVersionUID = 1L;
	public PrpCfeeKey(){}
	public PrpCfeeKey(String policyNo,String currency){
		this.policyNo = policyNo;
		this.currency = currency;
	}
	/** 属性保单号/保单号 */
	@Column(name = "policyNo")
	private String policyNo ;
	/** 属性currency/currency */
	@Column(name = "currency")
	private String currency ;
	/**
	 * 属性保单号/保单号的getter方法
	 */
	public String getPolicyNo() {
    		return policyNo;
	}
	/**
	 * 属性保单号/保单号的setter方法
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