package com.sinosoft.agriprpall.api.proposalmanage.dto;

import com.sinosoft.framework.dto.BaseRequest;

import java.io.Serializable;

/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-10-18 13:10:01.639 
 * 纳税人信息Api操作对象
 */
public class CustomerTaxPayInfoDto extends BaseRequest implements Serializable{
	private static final long serialVersionUID = 1L;
	/** 属性发票抬头/发票抬头 */
	private String customerName ;		
	/** 属性发票类型/发票类型 */
	private String invoiceType ;		
	/** 属性税务登记证号/税务登记证号 */
	private String taxpayerNo ;		
	/** 属性纳税人身份/纳税人身份 */
	private String taxpayerType ;		
	/** 属性购方地址/购方地址 */
	private String address ;		
	/** 属性购方电话/购方电话 */
	private String phone ;		
	/** 属性购方开户银行/购方开户银行 */
	private String accountBank ;		
	/** 属性购方银行账户/购方银行账户 */
	private String accountNo ;		
	/** 属性邮寄名称/邮寄名称 */
	private String postName;
	/** 属性邮寄电话/邮寄电话 */
	private String postPhone ;		
	/** 属性邮寄地址/邮寄地址 */
	private String postAddress ;		
	/** 属性邮政编码/邮政编码 */
	private String postCode ;		
	/** 属性备注/备注 */
	private String remark ;		
	/**
	 * 属性发票抬头/发票抬头的getter方法
	 */
	public String getCustomerName() {
		return customerName;
	}
	/**
	 * 属性发票抬头/发票抬头的setter方法
	 */
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}	
	/**
	 * 属性发票类型/发票类型的getter方法
	 */
	public String getInvoiceType() {
		return invoiceType;
	}
	/**
	 * 属性发票类型/发票类型的setter方法
	 */
	public void setInvoiceType(String invoiceType) {
		this.invoiceType = invoiceType;
	}	
	/**
	 * 属性税务登记证号/税务登记证号的getter方法
	 */
	public String getTaxpayerNo() {
		return taxpayerNo;
	}
	/**
	 * 属性税务登记证号/税务登记证号的setter方法
	 */
	public void setTaxpayerNo(String taxpayerNo) {
		this.taxpayerNo = taxpayerNo;
	}	
	/**
	 * 属性纳税人身份/纳税人身份的getter方法
	 */
	public String getTaxpayerType() {
		return taxpayerType;
	}
	/**
	 * 属性纳税人身份/纳税人身份的setter方法
	 */
	public void setTaxpayerType(String taxpayerType) {
		this.taxpayerType = taxpayerType;
	}	
	/**
	 * 属性购方地址/购方地址的getter方法
	 */
	public String getAddress() {
		return address;
	}
	/**
	 * 属性购方地址/购方地址的setter方法
	 */
	public void setAddress(String address) {
		this.address = address;
	}	
	/**
	 * 属性购方电话/购方电话的getter方法
	 */
	public String getPhone() {
		return phone;
	}
	/**
	 * 属性购方电话/购方电话的setter方法
	 */
	public void setPhone(String phone) {
		this.phone = phone;
	}	
	/**
	 * 属性购方开户银行/购方开户银行的getter方法
	 */
	public String getAccountBank() {
		return accountBank;
	}
	/**
	 * 属性购方开户银行/购方开户银行的setter方法
	 */
	public void setAccountBank(String accountBank) {
		this.accountBank = accountBank;
	}	
	/**
	 * 属性购方银行账户/购方银行账户的getter方法
	 */
	public String getAccountNo() {
		return accountNo;
	}
	/**
	 * 属性购方银行账户/购方银行账户的setter方法
	 */
	public void setAccountNo(String accountNo) {
		this.accountNo = accountNo;
	}	
	/**
	 * 属性邮寄名称/邮寄名称的getter方法
	 */
	public String getPostName() {
		return postName;
	}
	/**
	 * 属性邮寄名称/邮寄名称的setter方法
	 */
	public void setPostName(String postName) {
		this.postName = postName;
	}	
	/**
	 * 属性邮寄电话/邮寄电话的getter方法
	 */
	public String getPostPhone() {
		return postPhone;
	}
	/**
	 * 属性邮寄电话/邮寄电话的setter方法
	 */
	public void setPostPhone(String postPhone) {
		this.postPhone = postPhone;
	}	
	/**
	 * 属性邮寄地址/邮寄地址的getter方法
	 */
	public String getPostAddress() {
		return postAddress;
	}
	/**
	 * 属性邮寄地址/邮寄地址的setter方法
	 */
	public void setPostAddress(String postAddress) {
		this.postAddress = postAddress;
	}	
	/**
	 * 属性邮政编码/邮政编码的getter方法
	 */
	public String getPostCode() {
		return postCode;
	}
	/**
	 * 属性邮政编码/邮政编码的setter方法
	 */
	public void setPostCode(String postCode) {
		this.postCode = postCode;
	}	
	/**
	 * 属性备注/备注的getter方法
	 */
	public String getRemark() {
		return remark;
	}
	/**
	 * 属性备注/备注的setter方法
	 */
	public void setRemark(String remark) {
		this.remark = remark;
	}	
}
