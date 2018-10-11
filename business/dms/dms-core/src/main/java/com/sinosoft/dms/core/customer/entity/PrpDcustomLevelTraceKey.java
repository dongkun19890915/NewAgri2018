package com.sinosoft.dms.core.customer.entity;

import com.sinosoft.framework.core.dao.BasePKImpl;
import javax.persistence.*;

/**
 * @author codegen@研发中心
 * @mail codegen@sinosoft.com.cn
 * @time  2017-10-21 02:23:45.341 
 * 客户风险等级轨迹表主键操作对象
 */
public class PrpDcustomLevelTraceKey extends BasePKImpl{
	private static final long serialVersionUID = 1L;
	public PrpDcustomLevelTraceKey(){}
	public PrpDcustomLevelTraceKey(String customerCode,Integer lineNo){
		this.customerCode = customerCode;
		this.lineNo = lineNo;
	}
	/** 属性客户代码/客户代码 */
	@Column(name = "customerCode")
	private String customerCode ;
	/** 属性序号/序号 */
	@Column(name = "lineNo")
	private Integer lineNo ;
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
	/**
	 * 属性序号/序号的getter方法
	 */
	public Integer getLineNo() {
    		return lineNo;
	}
	/**
	 * 属性序号/序号的setter方法
	 */
	public void setLineNo(Integer lineNo) {
		this.lineNo = lineNo;
	} 
}