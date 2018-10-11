package com.sinosoft.agriprpall.core.policymanage.entity;

import com.sinosoft.framework.core.dao.BasePKImpl;
import javax.persistence.*;

/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-11-05 01:01:20.710 
 * PrpCcoinsDetailOrigin主键操作对象
 */
public class PrpCcoinsDetailOriginKey extends BasePKImpl{
	private static final long serialVersionUID = 1L;
	public PrpCcoinsDetailOriginKey(){}
	public PrpCcoinsDetailOriginKey(String policyNo,java.lang.Integer serialNo,String currency){
		this.policyNo = policyNo;
		this.serialNo = serialNo;
		this.currency = currency;
	}
	/** 属性保单号/保单号 */
	@Column(name = "policyNo")
	private String policyNo ;
	/** 属性序列号/序列号 */
	@Column(name = "serialNo")
	private java.lang.Integer serialNo ;
	/** 属性币别/币别 */
	@Column(name = "currency")
	private String currency ;
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
	 * 属性序列号/序列号的getter方法
	 */
	public java.lang.Integer getSerialNo() {
    		return serialNo;
	}
	/**
	 * 属性序列号/序列号的setter方法
	 */
	public void setSerialNo(java.lang.Integer serialNo) {
		this.serialNo = serialNo;
	} 
	/**
	 * 属性币别/币别的getter方法
	 */
	public String getCurrency() {
    		return currency;
	}
	/**
	 * 属性币别/币别的setter方法
	 */
	public void setCurrency(String currency) {
		this.currency = currency;
	} 
}