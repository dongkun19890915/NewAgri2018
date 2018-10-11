package com.sinosoft.agriclaim.core.prepaymanage.entity;

import com.sinosoft.framework.core.dao.BasePKImpl;
import javax.persistence.*;

/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-11-08 05:44:02.119 
 * 逾款欠款清单表主键操作对象
 */
public class PrpLArrearageKey extends BasePKImpl{
	private static final long serialVersionUID = 1L;
	public PrpLArrearageKey(){}
	public PrpLArrearageKey(String policyNo,java.util.Date arrearageEndDate){
		this.policyNo = policyNo;
		this.arrearageEndDate = arrearageEndDate;
	}
	/** 属性保单号/保单号 */
	@Column(name = "policyNo")
	private String policyNo ;
	/** 属性本期应还款截止日期/本期应还款截止日期 */
	@Column(name = "arrearageEndDate")
	private java.util.Date arrearageEndDate ;
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
	 * 属性本期应还款截止日期/本期应还款截止日期的getter方法
	 */
	public java.util.Date getArrearageEndDate() {
    		return arrearageEndDate;
	}
	/**
	 * 属性本期应还款截止日期/本期应还款截止日期的setter方法
	 */
	public void setArrearageEndDate(java.util.Date arrearageEndDate) {
		this.arrearageEndDate = arrearageEndDate;
	} 
}