package com.sinosoft.agriclaim.core.businessutilmanage.entity;

import com.sinosoft.framework.core.dao.BasePKImpl;
import javax.persistence.*;

/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-11-08 05:35:28.283 
 * 特别约定表主键操作对象
 */
public class PrpCEngageKey extends BasePKImpl{
	private static final long serialVersionUID = 1L;
	public PrpCEngageKey(){}
	public PrpCEngageKey(String policyNo,java.lang.Integer serialNo,java.lang.Integer lineNo){
		this.policyNo = policyNo;
		this.serialNo = serialNo;
		this.lineNo = lineNo;
	}
	/** 属性保单号码/保单号码 */
	@Column(name = "policyNo")
	private String policyNo ;
	/** 属性序号/序号 */
	@Column(name = "serialNo")
	private java.lang.Integer serialNo ;
	/** 属性行序号/行序号 */
	@Column(name = "lineNo")
	private java.lang.Integer lineNo ;
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
	/**
	 * 属性行序号/行序号的getter方法
	 */
	public java.lang.Integer getLineNo() {
    		return lineNo;
	}
	/**
	 * 属性行序号/行序号的setter方法
	 */
	public void setLineNo(java.lang.Integer lineNo) {
		this.lineNo = lineNo;
	} 
}