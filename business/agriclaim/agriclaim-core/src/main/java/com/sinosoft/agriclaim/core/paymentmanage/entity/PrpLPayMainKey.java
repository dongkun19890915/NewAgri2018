package com.sinosoft.agriclaim.core.paymentmanage.entity;

import com.sinosoft.framework.core.dao.BasePKImpl;
import javax.persistence.*;

/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-12-14 09:04:11.816 
 * 支付信息主表主键操作对象
 */
public class PrpLPayMainKey extends BasePKImpl{
	private static final long serialVersionUID = 1L;
	public PrpLPayMainKey(){}
	public PrpLPayMainKey(String paymentNo){
		this.paymentNo = paymentNo;
	}
	/** 属性paymentNo/paymentNo */
	@Column(name = "paymentNo")
	private String paymentNo ;
	/**
	 * 属性paymentNo/paymentNo的getter方法
	 */
	public String getPaymentNo() {
    		return paymentNo;
	}
	/**
	 * 属性paymentNo/paymentNo的setter方法
	 */
	public void setPaymentNo(String paymentNo) {
		this.paymentNo = paymentNo;
	} 
}