package com.sinosoft.agriclaim.core.businessutilmanage.entity;

import com.sinosoft.framework.core.dao.BasePKImpl;
import javax.persistence.*;

/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-11-08 05:35:28.283 
 * 理赔冲减保额表主键操作对象
 */
public class PrpLEndorKey extends BasePKImpl{
	private static final long serialVersionUID = 1L;
	public PrpLEndorKey(){}
	public PrpLEndorKey(String compensateNo,String policyNo,String endorType){
		this.compensateNo = compensateNo;
		this.policyNo = policyNo;
		this.endorType = endorType;
	}
	/** 属性赔款计算书号码/赔款计算书号码 */
	@Column(name = "compensateNo")
	private String compensateNo ;
	/** 属性保单号码/保单号码 */
	@Column(name = "policyNo")
	private String policyNo ;
	/** 属性批单类型/批单类型 */
	@Column(name = "endorType")
	private String endorType ;
	/**
	 * 属性赔款计算书号码/赔款计算书号码的getter方法
	 */
	public String getCompensateNo() {
    		return compensateNo;
	}
	/**
	 * 属性赔款计算书号码/赔款计算书号码的setter方法
	 */
	public void setCompensateNo(String compensateNo) {
		this.compensateNo = compensateNo;
	} 
	/**
	 * 属性保单号码/保单号码的getter方法
	 */
	public String getPolicyNo() {
    		return policyNo;
	}
	/**
	 * 属性保单号码/保单号码的setter方法
	 */
	public void setPolicyNo(String policyNo) {
		this.policyNo = policyNo;
	} 
	/**
	 * 属性批单类型/批单类型的getter方法
	 */
	public String getEndorType() {
    		return endorType;
	}
	/**
	 * 属性批单类型/批单类型的setter方法
	 */
	public void setEndorType(String endorType) {
		this.endorType = endorType;
	} 
}