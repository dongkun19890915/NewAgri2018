package com.sinosoft.agriclaim.core.checkmanage.entity;

import com.sinosoft.framework.core.dao.BasePKImpl;
import javax.persistence.*;

/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-11-17 08:28:31.346 
 * 核损明细表主键操作对象
 */
public class PrpLverifyLossItemKey extends BasePKImpl{
	private static final long serialVersionUID = 1L;
	public PrpLverifyLossItemKey(){}
	public PrpLverifyLossItemKey(String registNo,String policyNo){
		this.registNo = registNo;
		this.policyNo = policyNo;
	}
	/** 属性报案号/报案号 */
	@Column(name = "RegistNo")
	private String registNo ;
	/** 属性保单号/保单号 */
	@Column(name = "PolicyNo")
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