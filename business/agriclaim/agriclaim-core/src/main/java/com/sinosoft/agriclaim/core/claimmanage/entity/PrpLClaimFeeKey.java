package com.sinosoft.agriclaim.core.claimmanage.entity;

import com.sinosoft.framework.core.dao.BasePKImpl;
import javax.persistence.*;

/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-11-08 05:39:53.061 
 * 估损金额表主键操作对象
 */
public class PrpLClaimFeeKey extends BasePKImpl{
	private static final long serialVersionUID = 1L;
	public PrpLClaimFeeKey(){}
	public PrpLClaimFeeKey(String claimNo,String currency){
		this.claimNo = claimNo;
		this.currency = currency;
	}
	/** 属性立案号号/立案号号 */
	@Column(name = "claimNo")
	private String claimNo ;
	/** 属性币别代码/币别代码 */
	@Column(name = "currency")
	private String currency ;
	/**
	 * 属性立案号号/立案号号的getter方法
	 */
	public String getClaimNo() {
    		return claimNo;
	}
	/**
	 * 属性立案号号/立案号号的setter方法
	 */
	public void setClaimNo(String claimNo) {
		this.claimNo = claimNo;
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