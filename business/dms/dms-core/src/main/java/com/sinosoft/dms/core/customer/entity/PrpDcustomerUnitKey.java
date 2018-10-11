package com.sinosoft.dms.core.customer.entity;

import com.sinosoft.framework.core.dao.BasePKImpl;
import javax.persistence.*;

/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-11-05 01:01:56.447 
 * 集体客户代码表主键操作对象
 */
public class PrpDcustomerUnitKey extends BasePKImpl{
	private static final long serialVersionUID = 1L;
	public PrpDcustomerUnitKey(){}
	public PrpDcustomerUnitKey(String customerCode){
		this.customerCode = customerCode;
	}
	/** 属性客户代码/客户代码 */
	@Column(name = "customerCode")
	private String customerCode ;
	/**
	 * 属性客户代码/客户代码的getter方法
	 */
	public String getCustomerCode() {
    		return customerCode;
	}
	/**
	 * 属性客户代码/客户代码的setter方法
	 */
	public void setCustomerCode(String customerCode) {
		this.customerCode = customerCode;
	} 
}