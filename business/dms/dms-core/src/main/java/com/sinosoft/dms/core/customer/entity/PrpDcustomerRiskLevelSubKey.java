package com.sinosoft.dms.core.customer.entity;

import com.sinosoft.framework.core.dao.BasePKImpl;

import javax.persistence.Column;

/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-10-24 01:57:51.087 
 * 记录客户风险等级详细表主键操作对象
 */
public class PrpDcustomerRiskLevelSubKey extends BasePKImpl{
	private static final long serialVersionUID = 1L;
	public PrpDcustomerRiskLevelSubKey(){}
	public PrpDcustomerRiskLevelSubKey(String customerRiskLevelId){
		this.customerRiskLevelId = customerRiskLevelId;
	}
	/** 属性ID号/ID号 */
	@Column(name = "customerRiskLevelId")
	private String customerRiskLevelId ;
	/**
	 * 属性ID号/ID号的getter方法
	 */
	public String getCustomerRiskLevelId() {
    		return customerRiskLevelId;
	}
	/**
	 * 属性ID号/ID号的setter方法
	 */
	public void setCustomerRiskLevelId(String customerRiskLevelId) {
		this.customerRiskLevelId = customerRiskLevelId;
	} 
}