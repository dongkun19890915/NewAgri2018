package com.sinosoft.dms.core.customer.entity;

import com.sinosoft.framework.core.dao.BasePKImpl;
import javax.persistence.*;

/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-11-05 01:01:56.447 
 * 客户风险等级审核补充说明主键操作对象
 */
public class PrpDcustomerRiskLevelextKey extends BasePKImpl{
	private static final long serialVersionUID = 1L;
	public PrpDcustomerRiskLevelextKey(){}
	public PrpDcustomerRiskLevelextKey(String customerRiskLevelSign,java.lang.Integer serialNo){
		this.customerRiskLevelSign = customerRiskLevelSign;
		this.serialNo = serialNo;
	}
	/** 属性客户号/客户号 */
	@Column(name = "customerRiskLevelSign")
	private String customerRiskLevelSign ;
	/** 属性序号/序号 */
	@Column(name = "serialNo")
	private java.lang.Integer serialNo ;
	/**
	 * 属性客户号/客户号的getter方法
	 */
	public String getCustomerRiskLevelSign() {
    		return customerRiskLevelSign;
	}
	/**
	 * 属性客户号/客户号的setter方法
	 */
	public void setCustomerRiskLevelSign(String customerRiskLevelSign) {
		this.customerRiskLevelSign = customerRiskLevelSign;
	} 
	/**
	 * 属性序号/序号的getter方法
	 */
	public java.lang.Integer getSerialNo() {
    		return serialNo;
	}
	/**
	 * 属性序号/序号的setter方法
	 */
	public void setSerialNo(java.lang.Integer serialNo) {
		this.serialNo = serialNo;
	} 
}