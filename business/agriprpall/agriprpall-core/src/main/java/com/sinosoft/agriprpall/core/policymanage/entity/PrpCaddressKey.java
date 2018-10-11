package com.sinosoft.agriprpall.core.policymanage.entity;

import com.sinosoft.framework.core.dao.BasePKImpl;

import javax.persistence.Column;

/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-10-16 09:56:41.944 
 * 保单保险地址表主键操作对象
 */
public class PrpCaddressKey extends BasePKImpl{
	private static final long serialVersionUID = 1L;
	public PrpCaddressKey(){}
	public PrpCaddressKey(String policyNo,Integer addressNo){
		this.policyNo = policyNo;
		this.addressNo = addressNo;
	}
	/** 属性保单号码/保单号码 */
	@Column(name = "policyNo")
	private String policyNo ;
	/** 属性地址序号C/地址序号C */
	@Column(name = "addressNo")
	private Integer addressNo ;
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
	 * 属性地址序号C/地址序号C的getter方法
	 */
	public Integer getAddressNo() {
    		return addressNo;
	}
	/**
	 * 属性地址序号C/地址序号C的setter方法
	 */
	public void setAddressNo(Integer addressNo) {
		this.addressNo = addressNo;
	} 
}