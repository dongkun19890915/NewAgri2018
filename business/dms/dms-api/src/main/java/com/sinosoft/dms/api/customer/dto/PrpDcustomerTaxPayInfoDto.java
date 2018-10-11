package com.sinosoft.dms.api.customer.dto;

import com.sinosoft.framework.dto.BaseRequest;

import java.io.Serializable;

/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-10-17 13:04:37.553 
 * 客户纳税人信息表Api操作对象
 */
public class PrpDcustomerTaxPayInfoDto extends BaseRequest implements Serializable{
	private static final long serialVersionUID = 1L;
	/** 属性客户代码/客户代码 */
	private String customerCode ;		
	/** 属性客户名称/客户名称 */
	private String customerName ;		
	/** 属性客户类型；1-自然人，2-法人/客户类型；1-自然人，2-法人 */
	private String customerType ;		
	/** 属性纳税人身份/纳税人身份 */
	private String taxpayerType ;
	/** 属性纳税人识别号（税务登记证号或统一信用代码）/纳税人识别号（税务登记证号或统一信用代码） */
	private String taxpayerNo ;
	/** 属性地址/地址 */
	private String address ;		
	/** 属性电话/电话 */
	private String phone ;		
	/** 属性开户银行名称/开户银行名称 */
	private String accountBank ;		
	/** 属性开户银行帐号/开户银行帐号 */
	private String accountNo ;		
	/** 属性开票对象/开票对象 */
	private String payInfoObject ;		
	/** 属性发票类型/发票类型 */
	private String invoiceType ;		
	/** 属性邮寄地址/邮寄地址 */
	private String postAddress ;		
	/** 属性收件人电话/收件人电话 */
	private String postPhone ;		
	/** 属性收件人名称/收件人名称 */
	private String postName ;		
	/** 属性备注/备注 */
	private String remark ;
	private String postCode;

	public String getPostCode() {
		return postCode;
	}

	public void setPostCode(String postCode) {
		this.postCode = postCode;
	}


	public String getCustomerCode() {
		return customerCode;
	}

	public void setCustomerCode(String customerCode) {
		this.customerCode = customerCode;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getCustomerType() {
		return customerType;
	}

	public void setCustomerType(String customerType) {
		this.customerType = customerType;
	}

	public String getTaxpayerType() {
		return taxpayerType;
	}

	public void setTaxpayerType(String taxpayerType) {
		this.taxpayerType = taxpayerType;
	}

	public String getTaxpayerNo() {
		return taxpayerNo;
	}

	public void setTaxpayerNo(String taxpayerNo) {
		this.taxpayerNo = taxpayerNo;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getAccountBank() {
		return accountBank;
	}

	public void setAccountBank(String accountBank) {
		this.accountBank = accountBank;
	}

	public String getAccountNo() {
		return accountNo;
	}

	public void setAccountNo(String accountNo) {
		this.accountNo = accountNo;
	}

	public String getPayInfoObject() {
		return payInfoObject;
	}

	public void setPayInfoObject(String payInfoObject) {
		this.payInfoObject = payInfoObject;
	}

	public String getInvoiceType() {
		return invoiceType;
	}

	public void setInvoiceType(String invoiceType) {
		this.invoiceType = invoiceType;
	}

	public String getPostAddress() {
		return postAddress;
	}

	public void setPostAddress(String postAddress) {
		this.postAddress = postAddress;
	}

	public String getPostPhone() {
		return postPhone;
	}

	public void setPostPhone(String postPhone) {
		this.postPhone = postPhone;
	}

	public String getPostName() {
		return postName;
	}

	public void setPostName(String postName) {
		this.postName = postName;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}
}
