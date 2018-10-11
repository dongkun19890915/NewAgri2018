package com.sinosoft.agriclaim.core.claimmanage.entity;

import com.sinosoft.framework.core.dao.BasePKImpl;
import javax.persistence.*;

/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-12-01 01:33:42.103 
 * 耳标号表主键操作对象
 */
public class PrpLEarKey extends BasePKImpl{
	private static final long serialVersionUID = 1L;
	public PrpLEarKey(){}
	public PrpLEarKey(String policyNo,String earNo,String registNo){
		this.policyNo = policyNo;
		this.earNo = earNo;
		this.registNo = registNo;
	}
	/** 属性保单号/保单号 */
	@Column(name = "policyNo")
	private String policyNo ;
	/** 属性耳标号/耳标号 */
	@Column(name = "earNo")
	private String earNo ;
	/** 属性报案号/报案号 */
	@Column(name = "registNo")
	private String registNo ;
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
	 * 属性耳标号/耳标号的getter方法
	 */
	public String getEarNo() {
    		return earNo;
	}
	/**
	 * 属性耳标号/耳标号的setter方法
	 */
	public void setEarNo(String earNo) {
		this.earNo = earNo;
	} 
	/**
	 * 属性报案号/报案号的getter方法
	 */
	public String getRegistNo() {
    		return registNo;
	}
	/**
	 * 属性报案号/报案号的setter方法
	 */
	public void setRegistNo(String registNo) {
		this.registNo = registNo;
	} 
}