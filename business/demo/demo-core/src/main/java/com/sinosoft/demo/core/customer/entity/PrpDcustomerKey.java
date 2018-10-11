package com.sinosoft.demo.core.customer.entity;

import com.sinosoft.framework.core.dao.BasePKImpl;

/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-08-28 10:03:40.135 
 * 客户信息表主键操作对象
 */
public class PrpDcustomerKey extends BasePKImpl{
	private static final long serialVersionUID = 1L;
	public PrpDcustomerKey(){}
	public PrpDcustomerKey(Long customerCode){
		this.customerCode = customerCode;
	}
	/** 属性客户代码/客户代码 */
	private Long customerCode ;
	/**
	 * 属性客户代码/客户代码的getter方法
	 */
	public Long getCustomerCode() {
    		return customerCode;
	}
	/**
	 * 属性客户代码/客户代码的setter方法
	 */
	public void setCustomerCode(Long customerCode) {
		this.customerCode = customerCode;
	} 
}