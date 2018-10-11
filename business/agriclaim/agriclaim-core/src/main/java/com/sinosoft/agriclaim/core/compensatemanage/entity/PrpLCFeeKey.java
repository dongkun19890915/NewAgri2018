package com.sinosoft.agriclaim.core.compensatemanage.entity;

import com.sinosoft.framework.core.dao.BasePKImpl;
import javax.persistence.*;

/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-11-08 05:40:44.225 
 * 赔款计算金额表主键操作对象
 */
public class PrpLCFeeKey extends BasePKImpl{
	private static final long serialVersionUID = 1L;
	public PrpLCFeeKey(){}
	public PrpLCFeeKey(String compensateNo,String policyNo,String currency){
		this.compensateNo = compensateNo;
		this.policyNo = policyNo;
		this.currency = currency;
	}
	/** 属性赔款计算书号/赔款计算书号 */
	@Column(name = "compensateNo")
	private String compensateNo ;
	/** 属性保单号/保单号 */
	@Column(name = "policyNo")
	private String policyNo ;
	/** 属性币别代码/币别代码 */
	@Column(name = "currency")
	private String currency ;
	/**
	 * 属性赔款计算书号/赔款计算书号的getter方法
	 */
	public String getCompensateNo() {
    		return compensateNo;
	}
	/**
	 * 属性赔款计算书号/赔款计算书号的setter方法
	 */
	public void setCompensateNo(String compensateNo) {
		this.compensateNo = compensateNo;
	} 
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
	 * 属性币别代码/币别代码的getter方法
	 */
	public String getCurrency() {
    		return currency;
	}
	/**
	 * 属性币别代码/币别代码的setter方法
	 */
	public void setCurrency(String currency) {
		this.currency = currency;
	} 
}