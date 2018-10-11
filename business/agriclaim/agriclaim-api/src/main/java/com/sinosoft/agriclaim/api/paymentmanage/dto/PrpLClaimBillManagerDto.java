package com.sinosoft.agriclaim.api.paymentmanage.dto;

import java.io.Serializable;

import com.sinosoft.framework.dto.BaseRequest;
/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2018-01-11 08:55:21.509 
 * 理赔清单数据管理表Api操作对象
 */
public class PrpLClaimBillManagerDto extends BaseRequest implements Serializable{
	private static final long serialVersionUID = 1L;
	/** 属性报案号/报案号 */
	private String registNo ;		
	/** 属性保单号/保单号 */
	private String policyNo ;		
	/** 属性理算书号/理算书号 */
	private String compensateNo ;		
	/** 属性序号/序号 */
	private int serialNo ;
	/** 属性姓名/姓名 */
	private String payName ;		
	/** 属性身份证号/身份证号 */
	private String identifyNumber ;		
	/** 属性农户编码/客户代码/农户编码/客户代码 */
	private String insuredCode ;		
	/** 属性开户行所在省/开户行所在省 */
	private String provinceName ;		
	/** 属性开户行所在市/开户行所在市 */
	private String cityName ;		
	/** 属性属性accounttype/属性accounttype */
	private String accountType ;		
	/** 属性银行名称/银行名称 */
	private String bankName ;		
	/** 属性开户行/开户行 */
	private String openBank ;		
	/** 属性账号/账号 */
	private String bankAccount ;		
	/** 属性支付金额/支付金额 */
	private Double sumPaid ;
	/** 属性待支付剩余金额/待支付剩余金额 */
	private Double payAmount ;
	/** 属性支付处理标志: 1-已处理,0-未处理,2-退回/支付处理标志: 1-已处理,0-未处理,2-退回 */
	private String payFlag ;		
	/** 属性属性flag/属性flag */
	private String flag ;		
	/** 属性属性operatorcode/属性operatorcode */
	private String operatorCode ;		
	/** 属性账号类型/账号类型 */
	private String accountFlag ;		
	/** 属性支付行号/支付行号 */
	private String routeNum ;		
	/** 属性属性mobilephone/属性mobilephone */
	private String mobilePhone ;		
	/** 属性属性address/属性address */
	private String address ;		
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
	/**
	 * 属性理算书号/理算书号的getter方法
	 */
	public String getCompensateNo() {
		return compensateNo;
	}
	/**
	 * 属性理算书号/理算书号的setter方法
	 */
	public void setCompensateNo(String compensateNo) {
		this.compensateNo = compensateNo;
	}	
	/**
	 * 属性序号/序号的getter方法
	 */
	public int getSerialNo() {
		return serialNo;
	}
	/**
	 * 属性序号/序号的setter方法
	 */
	public void setSerialNo(int serialNo) {
		this.serialNo = serialNo;
	}	
	/**
	 * 属性姓名/姓名的getter方法
	 */
	public String getPayName() {
		return payName;
	}
	/**
	 * 属性姓名/姓名的setter方法
	 */
	public void setPayName(String payName) {
		this.payName = payName;
	}	
	/**
	 * 属性身份证号/身份证号的getter方法
	 */
	public String getIdentifyNumber() {
		return identifyNumber;
	}
	/**
	 * 属性身份证号/身份证号的setter方法
	 */
	public void setIdentifyNumber(String identifyNumber) {
		this.identifyNumber = identifyNumber;
	}	
	/**
	 * 属性农户编码/客户代码/农户编码/客户代码的getter方法
	 */
	public String getInsuredCode() {
		return insuredCode;
	}
	/**
	 * 属性农户编码/客户代码/农户编码/客户代码的setter方法
	 */
	public void setInsuredCode(String insuredCode) {
		this.insuredCode = insuredCode;
	}	
	/**
	 * 属性开户行所在省/开户行所在省的getter方法
	 */
	public String getProvinceName() {
		return provinceName;
	}
	/**
	 * 属性开户行所在省/开户行所在省的setter方法
	 */
	public void setProvinceName(String provinceName) {
		this.provinceName = provinceName;
	}	
	/**
	 * 属性开户行所在市/开户行所在市的getter方法
	 */
	public String getCityName() {
		return cityName;
	}
	/**
	 * 属性开户行所在市/开户行所在市的setter方法
	 */
	public void setCityName(String cityName) {
		this.cityName = cityName;
	}	
	/**
	 * 属性属性accounttype/属性accounttype的getter方法
	 */
	public String getAccountType() {
		return accountType;
	}
	/**
	 * 属性属性accounttype/属性accounttype的setter方法
	 */
	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}	
	/**
	 * 属性银行名称/银行名称的getter方法
	 */
	public String getBankName() {
		return bankName;
	}
	/**
	 * 属性银行名称/银行名称的setter方法
	 */
	public void setBankName(String bankName) {
		this.bankName = bankName;
	}	
	/**
	 * 属性开户行/开户行的getter方法
	 */
	public String getOpenBank() {
		return openBank;
	}
	/**
	 * 属性开户行/开户行的setter方法
	 */
	public void setOpenBank(String openBank) {
		this.openBank = openBank;
	}	
	/**
	 * 属性账号/账号的getter方法
	 */
	public String getBankAccount() {
		return bankAccount;
	}
	/**
	 * 属性账号/账号的setter方法
	 */
	public void setBankAccount(String bankAccount) {
		this.bankAccount = bankAccount;
	}	
	/**
	 * 属性支付金额/支付金额的getter方法
	 */
	public Double getSumPaid() {
		return sumPaid;
	}
	/**
	 * 属性支付金额/支付金额的setter方法
	 */
	public void setSumPaid(Double sumPaid) {
		this.sumPaid = sumPaid;
	}	
	/**
	 * 属性待支付剩余金额/待支付剩余金额的getter方法
	 */
	public Double getPayAmount() {
		return payAmount;
	}
	/**
	 * 属性待支付剩余金额/待支付剩余金额的setter方法
	 */
	public void setPayAmount(Double payAmount) {
		this.payAmount = payAmount;
	}	
	/**
	 * 属性支付处理标志: 1-已处理,0-未处理,2-退回/支付处理标志: 1-已处理,0-未处理,2-退回的getter方法
	 */
	public String getPayFlag() {
		return payFlag;
	}
	/**
	 * 属性支付处理标志: 1-已处理,0-未处理,2-退回/支付处理标志: 1-已处理,0-未处理,2-退回的setter方法
	 */
	public void setPayFlag(String payFlag) {
		this.payFlag = payFlag;
	}	
	/**
	 * 属性属性flag/属性flag的getter方法
	 */
	public String getFlag() {
		return flag;
	}
	/**
	 * 属性属性flag/属性flag的setter方法
	 */
	public void setFlag(String flag) {
		this.flag = flag;
	}	
	/**
	 * 属性属性operatorcode/属性operatorcode的getter方法
	 */
	public String getOperatorCode() {
		return operatorCode;
	}
	/**
	 * 属性属性operatorcode/属性operatorcode的setter方法
	 */
	public void setOperatorCode(String operatorCode) {
		this.operatorCode = operatorCode;
	}	
	/**
	 * 属性账号类型/账号类型的getter方法
	 */
	public String getAccountFlag() {
		return accountFlag;
	}
	/**
	 * 属性账号类型/账号类型的setter方法
	 */
	public void setAccountFlag(String accountFlag) {
		this.accountFlag = accountFlag;
	}	
	/**
	 * 属性支付行号/支付行号的getter方法
	 */
	public String getRouteNum() {
		return routeNum;
	}
	/**
	 * 属性支付行号/支付行号的setter方法
	 */
	public void setRouteNum(String routeNum) {
		this.routeNum = routeNum;
	}	
	/**
	 * 属性属性mobilephone/属性mobilephone的getter方法
	 */
	public String getMobilePhone() {
		return mobilePhone;
	}
	/**
	 * 属性属性mobilephone/属性mobilephone的setter方法
	 */
	public void setMobilePhone(String mobilePhone) {
		this.mobilePhone = mobilePhone;
	}	
	/**
	 * 属性属性address/属性address的getter方法
	 */
	public String getAddress() {
		return address;
	}
	/**
	 * 属性属性address/属性address的setter方法
	 */
	public void setAddress(String address) {
		this.address = address;
	}	
}
