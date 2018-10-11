package com.sinosoft.dms.core.dict.entity;

import com.sinosoft.framework.core.dao.BasePKImpl;
import javax.persistence.*;

/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-11-05 01:01:56.447 
 * 兑换率表主键操作对象
 */
public class PrpDexchKey extends BasePKImpl{
	private static final long serialVersionUID = 1L;
	public PrpDexchKey(){}
	public PrpDexchKey(java.util.Date exchDate,String baseCurrency,String exchCurrency){
		this.exchDate = exchDate;
		this.baseCurrency = baseCurrency;
		this.exchCurrency = exchCurrency;
	}
	/** 属性汇率日期/汇率日期 */
	@Column(name = "exchDate")
	private java.util.Date exchDate ;
	/** 属性基准币别/基准币别 */
	@Column(name = "baseCurrency")
	private String baseCurrency ;
	/** 属性兑换币别/兑换币别 */
	@Column(name = "exchCurrency")
	private String exchCurrency ;
	/**
	 * 属性汇率日期/汇率日期的getter方法
	 */
	public java.util.Date getExchDate() {
    		return exchDate;
	}
	/**
	 * 属性汇率日期/汇率日期的setter方法
	 */
	public void setExchDate(java.util.Date exchDate) {
		this.exchDate = exchDate;
	} 
	/**
	 * 属性基准币别/基准币别的getter方法
	 */
	public String getBaseCurrency() {
    		return baseCurrency;
	}
	/**
	 * 属性基准币别/基准币别的setter方法
	 */
	public void setBaseCurrency(String baseCurrency) {
		this.baseCurrency = baseCurrency;
	} 
	/**
	 * 属性兑换币别/兑换币别的getter方法
	 */
	public String getExchCurrency() {
    		return exchCurrency;
	}
	/**
	 * 属性兑换币别/兑换币别的setter方法
	 */
	public void setExchCurrency(String exchCurrency) {
		this.exchCurrency = exchCurrency;
	} 
}