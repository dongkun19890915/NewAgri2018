package com.sinosoft.agriclaim.core.registmanage.entity;

import com.sinosoft.framework.core.dao.BasePKImpl;
import javax.persistence.*;

/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-11-08 05:45:22.527 
 * 赔案保单关联表主键操作对象
 */
public class PrpLRegistRPolicyKey extends BasePKImpl{
	private static final long serialVersionUID = 1L;
	public PrpLRegistRPolicyKey(){}
	public PrpLRegistRPolicyKey(String registNo,String policyNo){
		this.registNo = registNo;
		this.policyNo = policyNo;
	}
	/** 属性报案号/报案号 */
	@Column(name = "registNo")
	private String registNo ;
	/** 属性保单号/保单号 */
	@Column(name = "policyNo")
	private String policyNo ;
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
}