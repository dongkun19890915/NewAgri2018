package com.sinosoft.agriclaim.core.paymentmanage.entity;

import com.sinosoft.framework.core.dao.BaseEntityImpl;
import javax.persistence.*;
import java.util.Date;

/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-12-14 09:04:11.816 
 * 支付信息主表实体操作对象
 */
@Entity
@Table(name = "PrpLPayMain")
@IdClass(PrpLPayMainKey.class)
public class PrpLPayMain extends BaseEntityImpl{

	private static final long serialVersionUID = 1L;
	/** 属性paymentNo/paymentNo */
	@Id
	@Column(name = "paymentNo")
	private String paymentNo ;	

	/** 属性支付类型/支付类型 */
	@Column(name = "payType")
	private String payType ;
	/** 属性receiverType/receiverType */
	@Column(name = "receiverType")
	private String receiverType ;
	/** 属性payAmount/payAmount */
	@Column(name = "payAmount")
	private Double payAmount ;
	/** 属性bankType/bankType */
	@Column(name = "bankType")
	private String bankType ;
	/** 属性bank/bank */
	@Column(name = "bank")
	private String bank ;
	/** 属性bankSite/bankSite */
	@Column(name = "bankSite")
	private String bankSite ;
	/** 属性账号属性/账号属性 */
	@Column(name = "accountType")
	private String accountType ;
	/** 属性receiverFullName/receiverFullName */
	@Column(name = "receiverFullName")
	private String receiverFullName ;
	/** 属性证件类型/证件类型 */
	@Column(name = "certifType")
	private String certifType ;
	/** 属性address/address */
	@Column(name = "address")
	private String address ;
	/** 属性certifNo/certifNo */
	@Column(name = "certifNo")
	private String certifNo ;
	/** 属性familyPhone/familyPhone */
	@Column(name = "familyPhone")
	private String familyPhone ;
	/** 属性officePhone/officePhone */
	@Column(name = "officePhone")
	private String officePhone ;
	/** 属性mobilePhone/mobilePhone */
	@Column(name = "mobilePhone")
	private String mobilePhone ;
	/** 属性payRemark/payRemark */
	@Column(name = "payRemark")
	private String payRemark ;
	/** 属性operatorCode/operatorCode */
	@Column(name = "operatorCode")
	private String operatorCode ;
	/** 属性inputDate/inputDate */
	@Column(name = "inputDate")
	private Date inputDate ;
	/** 属性payDate/payDate */
	@Column(name = "payDate")
	private Date payDate ;
	/** 属性payCode/payCode */
	@Column(name = "payCode")
	private String payCode ;
	/** 属性payFlag/payFlag */
	@Column(name = "payFlag")
	private String payFlag ;
	/** 属性paymentType/paymentType */
	@Column(name = "paymentType")
	private String paymentType ;
	/** 属性bankAccount/bankAccount */
	@Column(name = "bankAccount")
	private String bankAccount ;
	/** 属性node/node */
	@Column(name = "node")
	private String node ;
	/** 属性uploadSerialNo/uploadSerialNo */
	@Column(name = "uploadSerialNo")
	private String uploadSerialNo ;
	/** 属性vFlag/vFlag */
	@Column(name = "vFlag")
	private String vFlag ;
	/** 属性comCode/comCode */
	@Column(name = "comCode")
	private String comCode ;
	/** 属性领款人代码/领款人代码 */
	@Column(name = "receiverFullCode")
	private String receiverFullCode ;
	/** 属性合并下发标志/合并下发标志 */
	@Column(name = "mergerFlag")
	private String mergerFlag ;
	/** 属性总支付金额/总支付金额 */
	@Column(name = "payTotalAmount")
	private Double payTotalAmount ;
	/** 属性紧急程度/紧急程度 */
	@Column(name = "urgentType")
	private String urgentType ;
	/** 属性领款人类型代码/领款人类型代码 */
	@Column(name = "receiverTypeOther")
	private String receiverTypeOther ;
	/** 属性领款人类型名称/领款人类型名称 */
	@Column(name = "receiverTypeOtherName")
	private String receiverTypeOtherName ;
	/** 属性qq号码/qq号码 */
	@Column(name = "qqNumber")
	private String qqNumber ;
	/** 属性电子邮件/电子邮件 */
	@Column(name = "email")
	private String email ;
	/** 属性单位联系人/单位联系人 */
	@Column(name = "unitLink")
	private String unitLink ;
	/** 属性邮政编码/邮政编码 */
	@Column(name = "postCode")
	private String postCode ;
	/** 属性审核方式/审核方式 */
	@Column(name = "verifyFlag")
	private String verifyFlag ;
	/** 属性通知单号/通知单号 */
	@Column(name = "noticeNo")
	private String noticeNo ;
	/** 属性provinceCode/provinceCode */
	@Column(name = "provinceCode")
	private String provinceCode ;
	/** 属性cityCode/cityCode */
	@Column(name = "cityCode")
	private String cityCode ;
	/** 属性backDate/backDate */
	@Column(name = "backDate")
	private Date backDate ;
	/** 属性backOperatorCode/backOperatorCode */
	@Column(name = "backOperatorCode")
	private String backOperatorCode ;
	/** 属性backComCode/backComCode */
	@Column(name = "backComCode")
	private String backComCode ;
	/** 属性第三方支付标识/第三方支付标识 */
	@Column(name = "thirdPayFlag")
	private String thirdPayFlag ;
	/** 属性支付方式/支付方式 */
	@Column(name = "payWay")
	private String payWay ;
	/** 属性传统方式支付原因/传统方式支付原因 */
	@Column(name = "payReason")
	private String payReason ;
	/** 属性用途说明/用途说明 */
	@Column(name = "payPurpose")
	private String payPurpose ;
	/** 属性账号类型/账号类型 */
	@Column(name = "accountFlag")
	private String accountFlag ;
	/** 属性接口类型/接口类型 */
	@Column(name = "interType")
	private String interType ;
	/** 属性支付行号/支付行号 */
	@Column(name = "routeNum")
	private String routeNum ;
	/** 属性是否有清单/是否有清单 */
	@Column(name = "billFlag")
	private String billFlag ;
	/** 属性第三方支付类型/第三方支付类型 */
	@Column(name = "thirdPayType")
	private String thirdPayType ;
	/** 属性无理赔清单是否支付清单导入/无理赔清单是否支付清单导入 */
	@Column(name = "nobillFlag")
	private String nobillFlag ;
	/** 属性sendFlag/sendFlag */
	@Column(name = "sendFlag")
	private String sendFlag ;
	@Column(name = "cancelFlag")
	private String cancelFlag ;

	public String getvFlag() {
		return vFlag;
	}

	public void setvFlag(String vFlag) {
		this.vFlag = vFlag;
	}

	public String getCancelFlag() {
		return cancelFlag;
	}

	public void setCancelFlag(String cancelFlag) {
		this.cancelFlag = cancelFlag;
	}

	/**
	 * 属性paymentNo/paymentNo的getter方法
	 */
	public String getPaymentNo() {
		return paymentNo;
	}
	/**
	 * 属性paymentNo/paymentNo的setter方法
	 */
	public void setPaymentNo(String paymentNo) {
		this.paymentNo = paymentNo;
	} 	
	/**
	 * 属性支付类型/支付类型的getter方法
	 */
	public String getPayType() {
		return payType;
	}
	/**
	 * 属性支付类型/支付类型的setter方法
	 */
	public void setPayType(String payType) {
		this.payType = payType;
	} 	
	/**
	 * 属性receiverType/receiverType的getter方法
	 */
	public String getReceiverType() {
		return receiverType;
	}
	/**
	 * 属性receiverType/receiverType的setter方法
	 */
	public void setReceiverType(String receiverType) {
		this.receiverType = receiverType;
	} 	
	/**
	 * 属性payAmount/payAmount的getter方法
	 */
	public Double getPayAmount() {
		return payAmount;
	}
	/**
	 * 属性payAmount/payAmount的setter方法
	 */
	public void setPayAmount(Double payAmount) {
		this.payAmount = payAmount;
	} 	
	/**
	 * 属性bankType/bankType的getter方法
	 */
	public String getBankType() {
		return bankType;
	}
	/**
	 * 属性bankType/bankType的setter方法
	 */
	public void setBankType(String bankType) {
		this.bankType = bankType;
	} 	
	/**
	 * 属性bank/bank的getter方法
	 */
	public String getBank() {
		return bank;
	}
	/**
	 * 属性bank/bank的setter方法
	 */
	public void setBank(String bank) {
		this.bank = bank;
	} 	
	/**
	 * 属性bankSite/bankSite的getter方法
	 */
	public String getBankSite() {
		return bankSite;
	}
	/**
	 * 属性bankSite/bankSite的setter方法
	 */
	public void setBankSite(String bankSite) {
		this.bankSite = bankSite;
	} 	
	/**
	 * 属性账号属性/账号属性的getter方法
	 */
	public String getAccountType() {
		return accountType;
	}
	/**
	 * 属性账号属性/账号属性的setter方法
	 */
	public void setAccountType(String accountType) {
		this.accountType = accountType;
	} 	
	/**
	 * 属性receiverFullName/receiverFullName的getter方法
	 */
	public String getReceiverFullName() {
		return receiverFullName;
	}
	/**
	 * 属性receiverFullName/receiverFullName的setter方法
	 */
	public void setReceiverFullName(String receiverFullName) {
		this.receiverFullName = receiverFullName;
	} 	
	/**
	 * 属性证件类型/证件类型的getter方法
	 */
	public String getCertifType() {
		return certifType;
	}
	/**
	 * 属性证件类型/证件类型的setter方法
	 */
	public void setCertifType(String certifType) {
		this.certifType = certifType;
	} 	
	/**
	 * 属性address/address的getter方法
	 */
	public String getAddress() {
		return address;
	}
	/**
	 * 属性address/address的setter方法
	 */
	public void setAddress(String address) {
		this.address = address;
	} 	
	/**
	 * 属性certifNo/certifNo的getter方法
	 */
	public String getCertifNo() {
		return certifNo;
	}
	/**
	 * 属性certifNo/certifNo的setter方法
	 */
	public void setCertifNo(String certifNo) {
		this.certifNo = certifNo;
	} 	
	/**
	 * 属性familyPhone/familyPhone的getter方法
	 */
	public String getFamilyPhone() {
		return familyPhone;
	}
	/**
	 * 属性familyPhone/familyPhone的setter方法
	 */
	public void setFamilyPhone(String familyPhone) {
		this.familyPhone = familyPhone;
	} 	
	/**
	 * 属性officePhone/officePhone的getter方法
	 */
	public String getOfficePhone() {
		return officePhone;
	}
	/**
	 * 属性officePhone/officePhone的setter方法
	 */
	public void setOfficePhone(String officePhone) {
		this.officePhone = officePhone;
	} 	
	/**
	 * 属性mobilePhone/mobilePhone的getter方法
	 */
	public String getMobilePhone() {
		return mobilePhone;
	}
	/**
	 * 属性mobilePhone/mobilePhone的setter方法
	 */
	public void setMobilePhone(String mobilePhone) {
		this.mobilePhone = mobilePhone;
	} 	
	/**
	 * 属性payRemark/payRemark的getter方法
	 */
	public String getPayRemark() {
		return payRemark;
	}
	/**
	 * 属性payRemark/payRemark的setter方法
	 */
	public void setPayRemark(String payRemark) {
		this.payRemark = payRemark;
	} 	
	/**
	 * 属性operatorCode/operatorCode的getter方法
	 */
	public String getOperatorCode() {
		return operatorCode;
	}
	/**
	 * 属性operatorCode/operatorCode的setter方法
	 */
	public void setOperatorCode(String operatorCode) {
		this.operatorCode = operatorCode;
	} 	
	/**
	 * 属性inputDate/inputDate的getter方法
	 */
	public Date getInputDate() {
		return inputDate;
	}
	/**
	 * 属性inputDate/inputDate的setter方法
	 */
	public void setInputDate(Date inputDate) {
		this.inputDate = inputDate;
	} 	
	/**
	 * 属性payDate/payDate的getter方法
	 */
	public Date getPayDate() {
		return payDate;
	}
	/**
	 * 属性payDate/payDate的setter方法
	 */
	public void setPayDate(Date payDate) {
		this.payDate = payDate;
	} 	
	/**
	 * 属性payCode/payCode的getter方法
	 */
	public String getPayCode() {
		return payCode;
	}
	/**
	 * 属性payCode/payCode的setter方法
	 */
	public void setPayCode(String payCode) {
		this.payCode = payCode;
	} 	
	/**
	 * 属性payFlag/payFlag的getter方法
	 */
	public String getPayFlag() {
		return payFlag;
	}
	/**
	 * 属性payFlag/payFlag的setter方法
	 */
	public void setPayFlag(String payFlag) {
		this.payFlag = payFlag;
	} 	
	/**
	 * 属性paymentType/paymentType的getter方法
	 */
	public String getPaymentType() {
		return paymentType;
	}
	/**
	 * 属性paymentType/paymentType的setter方法
	 */
	public void setPaymentType(String paymentType) {
		this.paymentType = paymentType;
	} 	
	/**
	 * 属性bankAccount/bankAccount的getter方法
	 */
	public String getBankAccount() {
		return bankAccount;
	}
	/**
	 * 属性bankAccount/bankAccount的setter方法
	 */
	public void setBankAccount(String bankAccount) {
		this.bankAccount = bankAccount;
	} 	
	/**
	 * 属性node/node的getter方法
	 */
	public String getNode() {
		return node;
	}
	/**
	 * 属性node/node的setter方法
	 */
	public void setNode(String node) {
		this.node = node;
	} 	
	/**
	 * 属性uploadSerialNo/uploadSerialNo的getter方法
	 */
	public String getUploadSerialNo() {
		return uploadSerialNo;
	}
	/**
	 * 属性uploadSerialNo/uploadSerialNo的setter方法
	 */
	public void setUploadSerialNo(String uploadSerialNo) {
		this.uploadSerialNo = uploadSerialNo;
	} 	
	/**
	 * 属性vFlag/vFlag的getter方法
	 */
	public String getVFlag() {
		return vFlag;
	}
	/**
	 * 属性vFlag/vFlag的setter方法
	 */
	public void setVFlag(String vFlag) {
		this.vFlag = vFlag;
	} 	
	/**
	 * 属性comCode/comCode的getter方法
	 */
	public String getComCode() {
		return comCode;
	}
	/**
	 * 属性comCode/comCode的setter方法
	 */
	public void setComCode(String comCode) {
		this.comCode = comCode;
	} 	
	/**
	 * 属性领款人代码/领款人代码的getter方法
	 */
	public String getReceiverFullCode() {
		return receiverFullCode;
	}
	/**
	 * 属性领款人代码/领款人代码的setter方法
	 */
	public void setReceiverFullCode(String receiverFullCode) {
		this.receiverFullCode = receiverFullCode;
	} 	
	/**
	 * 属性合并下发标志/合并下发标志的getter方法
	 */
	public String getMergerFlag() {
		return mergerFlag;
	}
	/**
	 * 属性合并下发标志/合并下发标志的setter方法
	 */
	public void setMergerFlag(String mergerFlag) {
		this.mergerFlag = mergerFlag;
	} 	
	/**
	 * 属性总支付金额/总支付金额的getter方法
	 */
	public Double getPayTotalAmount() {
		return payTotalAmount;
	}
	/**
	 * 属性总支付金额/总支付金额的setter方法
	 */
	public void setPayTotalAmount(Double payTotalAmount) {
		this.payTotalAmount = payTotalAmount;
	} 	
	/**
	 * 属性紧急程度/紧急程度的getter方法
	 */
	public String getUrgentType() {
		return urgentType;
	}
	/**
	 * 属性紧急程度/紧急程度的setter方法
	 */
	public void setUrgentType(String urgentType) {
		this.urgentType = urgentType;
	} 	
	/**
	 * 属性领款人类型代码/领款人类型代码的getter方法
	 */
	public String getReceiverTypeOther() {
		return receiverTypeOther;
	}
	/**
	 * 属性领款人类型代码/领款人类型代码的setter方法
	 */
	public void setReceiverTypeOther(String receiverTypeOther) {
		this.receiverTypeOther = receiverTypeOther;
	} 	
	/**
	 * 属性领款人类型名称/领款人类型名称的getter方法
	 */
	public String getReceiverTypeOtherName() {
		return receiverTypeOtherName;
	}
	/**
	 * 属性领款人类型名称/领款人类型名称的setter方法
	 */
	public void setReceiverTypeOtherName(String receiverTypeOtherName) {
		this.receiverTypeOtherName = receiverTypeOtherName;
	} 	
	/**
	 * 属性qq号码/qq号码的getter方法
	 */
	public String getQqNumber() {
		return qqNumber;
	}
	/**
	 * 属性qq号码/qq号码的setter方法
	 */
	public void setQqNumber(String qqNumber) {
		this.qqNumber = qqNumber;
	} 	
	/**
	 * 属性电子邮件/电子邮件的getter方法
	 */
	public String getEmail() {
		return email;
	}
	/**
	 * 属性电子邮件/电子邮件的setter方法
	 */
	public void setEmail(String email) {
		this.email = email;
	} 	
	/**
	 * 属性单位联系人/单位联系人的getter方法
	 */
	public String getUnitLink() {
		return unitLink;
	}
	/**
	 * 属性单位联系人/单位联系人的setter方法
	 */
	public void setUnitLink(String unitLink) {
		this.unitLink = unitLink;
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
	 * 属性审核方式/审核方式的getter方法
	 */
	public String getVerifyFlag() {
		return verifyFlag;
	}
	/**
	 * 属性审核方式/审核方式的setter方法
	 */
	public void setVerifyFlag(String verifyFlag) {
		this.verifyFlag = verifyFlag;
	} 	
	/**
	 * 属性通知单号/通知单号的getter方法
	 */
	public String getNoticeNo() {
		return noticeNo;
	}
	/**
	 * 属性通知单号/通知单号的setter方法
	 */
	public void setNoticeNo(String noticeNo) {
		this.noticeNo = noticeNo;
	} 	
	/**
	 * 属性provinceCode/provinceCode的getter方法
	 */
	public String getProvinceCode() {
		return provinceCode;
	}
	/**
	 * 属性provinceCode/provinceCode的setter方法
	 */
	public void setProvinceCode(String provinceCode) {
		this.provinceCode = provinceCode;
	} 	
	/**
	 * 属性cityCode/cityCode的getter方法
	 */
	public String getCityCode() {
		return cityCode;
	}
	/**
	 * 属性cityCode/cityCode的setter方法
	 */
	public void setCityCode(String cityCode) {
		this.cityCode = cityCode;
	} 	
	/**
	 * 属性backDate/backDate的getter方法
	 */
	public Date getBackDate() {
		return backDate;
	}
	/**
	 * 属性backDate/backDate的setter方法
	 */
	public void setBackDate(Date backDate) {
		this.backDate = backDate;
	} 	
	/**
	 * 属性backOperatorCode/backOperatorCode的getter方法
	 */
	public String getBackOperatorCode() {
		return backOperatorCode;
	}
	/**
	 * 属性backOperatorCode/backOperatorCode的setter方法
	 */
	public void setBackOperatorCode(String backOperatorCode) {
		this.backOperatorCode = backOperatorCode;
	} 	
	/**
	 * 属性backComCode/backComCode的getter方法
	 */
	public String getBackComCode() {
		return backComCode;
	}
	/**
	 * 属性backComCode/backComCode的setter方法
	 */
	public void setBackComCode(String backComCode) {
		this.backComCode = backComCode;
	} 	
	/**
	 * 属性第三方支付标识/第三方支付标识的getter方法
	 */
	public String getThirdPayFlag() {
		return thirdPayFlag;
	}
	/**
	 * 属性第三方支付标识/第三方支付标识的setter方法
	 */
	public void setThirdPayFlag(String thirdPayFlag) {
		this.thirdPayFlag = thirdPayFlag;
	} 	
	/**
	 * 属性支付方式/支付方式的getter方法
	 */
	public String getPayWay() {
		return payWay;
	}
	/**
	 * 属性支付方式/支付方式的setter方法
	 */
	public void setPayWay(String payWay) {
		this.payWay = payWay;
	} 	
	/**
	 * 属性传统方式支付原因/传统方式支付原因的getter方法
	 */
	public String getPayReason() {
		return payReason;
	}
	/**
	 * 属性传统方式支付原因/传统方式支付原因的setter方法
	 */
	public void setPayReason(String payReason) {
		this.payReason = payReason;
	} 	
	/**
	 * 属性用途说明/用途说明的getter方法
	 */
	public String getPayPurpose() {
		return payPurpose;
	}
	/**
	 * 属性用途说明/用途说明的setter方法
	 */
	public void setPayPurpose(String payPurpose) {
		this.payPurpose = payPurpose;
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
	 * 属性接口类型/接口类型的getter方法
	 */
	public String getInterType() {
		return interType;
	}
	/**
	 * 属性接口类型/接口类型的setter方法
	 */
	public void setInterType(String interType) {
		this.interType = interType;
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
	 * 属性是否有清单/是否有清单的getter方法
	 */
	public String getBillFlag() {
		return billFlag;
	}
	/**
	 * 属性是否有清单/是否有清单的setter方法
	 */
	public void setBillFlag(String billFlag) {
		this.billFlag = billFlag;
	} 	
	/**
	 * 属性第三方支付类型/第三方支付类型的getter方法
	 */
	public String getThirdPayType() {
		return thirdPayType;
	}
	/**
	 * 属性第三方支付类型/第三方支付类型的setter方法
	 */
	public void setThirdPayType(String thirdPayType) {
		this.thirdPayType = thirdPayType;
	} 	
	/**
	 * 属性无理赔清单是否支付清单导入/无理赔清单是否支付清单导入的getter方法
	 */
	public String getNobillFlag() {
		return nobillFlag;
	}
	/**
	 * 属性无理赔清单是否支付清单导入/无理赔清单是否支付清单导入的setter方法
	 */
	public void setNobillFlag(String nobillFlag) {
		this.nobillFlag = nobillFlag;
	} 	
	/**
	 * 属性sendFlag/sendFlag的getter方法
	 */
	public String getSendFlag() {
		return sendFlag;
	}
	/**
	 * 属性sendFlag/sendFlag的setter方法
	 */
	public void setSendFlag(String sendFlag) {
		this.sendFlag = sendFlag;
	}
}