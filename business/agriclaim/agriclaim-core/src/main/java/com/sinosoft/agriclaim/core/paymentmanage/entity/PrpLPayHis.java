package com.sinosoft.agriclaim.core.paymentmanage.entity;

import com.sinosoft.framework.core.dao.BaseEntityImpl;

import javax.persistence.*;
import java.util.Date;

/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-11-08 05:43:17.258 
 * 支付信息子表实体操作对象
 */
@Entity
@Table(name = "PrpLPayHis")
@IdClass(PrpLPayHisKey.class)
public class PrpLPayHis extends BaseEntityImpl{

	private static final long serialVersionUID = 1L;
	/** 属性序号/序号 */
	@Id
	@Column(name = "serialNo")
	private String serialNo ;/** 属性新增序号列，联合主键/新增序号列，联合主键 */
	@Id
	@Column(name = "serialNo2")
	private String serialNo2 ;
	/** 属性立案号/立案号 */
	@Column(name = "claimNo")
	private String claimNo ;

	/** 属性业务号，预赔环节就是预赔号，理算环节就是理算号。/业务号，预赔环节就是预赔号，理算环节就是理算号。 */
	@Column(name = "compensateNo")
	private String compensateNo ;
	/** 属性险类代码/险类代码 */
	@Column(name = "classCode")
	private String classCode ;
	/** 属性险种代码/险种代码 */
	@Column(name = "riskCode")
	private String riskCode ;
	/** 属性报案号/报案号 */
	@Column(name = "registNo")
	private String registNo ;
	/** 属性保单号码/保单号码 */
	@Column(name = "policyNo")
	private String policyNo ;
	/** 属性支付类型(预赔，支付，垫付，结案支付)/支付类型(预赔，支付，垫付，结案支付) */
	@Column(name = "payType")
	private String payType ;
	/** 属性领款人类型（被保险人、委托个人代理索赔、委托单位代理索赔）/领款人类型（被保险人、委托个人代理索赔、委托单位代理索赔） */
	@Column(name = "receiverType")
	private String receiverType ;
	/** 属性支付金额/支付金额 */
	@Column(name = "payAmount")
	private Double payAmount ;
	/** 属性银行大类/银行大类 */
	@Column(name = "bankType")
	private String bankType ;
	/** 属性开户银行/开户银行 */
	@Column(name = "bank")
	private String bank ;
	/** 属性开户行明细/开户行明细 */
	@Column(name = "bankSite")
	private String bankSite ;
	/** 属性账号类型（个人、单位）/账号类型（个人、单位） */
	@Column(name = "accountType")
	private String accountType ;
	/** 属性领款人全称/领款人全称 */
	@Column(name = "receiverFullName")
	private String receiverFullName ;
	/** 属性证件类型（身份证、户口本、军官证、护照）/证件类型（身份证、户口本、军官证、护照） */
	@Column(name = "certiftype")
	private String certiftype ;
	/** 属性详细地址/详细地址 */
	@Column(name = "address")
	private String address ;
	/** 属性证件号码/证件号码 */
	@Column(name = "certifNo")
	private String certifNo ;
	/** 属性家庭电话/家庭电话 */
	@Column(name = "familyPhone")
	private String familyPhone ;
	/** 属性办公电话/办公电话 */
	@Column(name = "officePhone")
	private String officePhone ;
	/** 属性手机号/手机号 */
	@Column(name = "mobilePhone")
	private String mobilePhone ;
	/** 属性支付说明/支付说明 */
	@Column(name = "payRemark")
	private String payRemark ;
	/** 属性操作员代码/操作员代码 */
	@Column(name = "operatorCode")
	private String operatorCode ;
	/** 属性输入日期/输入日期 */
	@Column(name = "inputDate")
	private Date inputDate ;
	/** 属性支付日期/支付日期 */
	@Column(name = "payDate")
	private Date payDate ;
	/** 属性支付员代码/支付员代码 */
	@Column(name = "payCode")
	private String payCode ;
	/** 属性支付标志/支付标志 */
	@Column(name = "payFlag")
	private String payFlag ;
	/** 属性赔款类型/赔款类型 */
	@Column(name = "paymentType")
	private String paymentType ;
	/** 属性银行账号/银行账号 */
	@Column(name = "bankAccount")
	private String bankAccount ;
	/** 属性节点/节点 */
	@Column(name = "node")
	private String node ;
	/** 属性uploadSerialNo/uploadSerialNo */
	@Column(name = "uploadSerialNo")
	private String uploadSerialNo ;
	/** 属性赔付信息审核平台状态字段:空为未处理，2为正在审核，3为退回，4为通过 8审核通过，数据到总公司/赔付信息审核平台状态字段:空为未处理，2为正在审核，3为退回，4为通过 8审核通过，数据到总公司 */
	@Column(name = "vFlag")
	private String vFlag ;
	/** 属性机构代码/机构代码 */
	@Column(name = "comCode")
	private String comCode ;
	/** 属性operatorComcode/operatorComcode */
	@Column(name = "operatorComcode")
	private String operatorComcode ;
	/** 属性联共保人代码/联共保人代码 */
	@Column(name = "coinsCode")
	private String coinsCode ;
	/** 属性provinceCode/provinceCode */
	@Column(name = "provinceCode")
	private String provinceCode ;
	/** 属性cityCode/cityCode */
	@Column(name = "cityCode")
	private String cityCode ;
	/** 属性urgentType/urgentType */
	@Column(name = "urgentType")
	private String urgentType ;
	/** 属性qqNumber/qqNumber */
	@Column(name = "qqNumber")
	private String qqNumber ;
	/** 属性email/email */
	@Column(name = "email")
	private String email ;
	/** 属性unitLink/unitLink */
	@Column(name = "unitLink")
	private String unitLink ;
	/** 属性postCode/postCode */
	@Column(name = "postCode")
	private String postCode ;
	/** 属性editDate/editDate */
	@Column(name = "editDate")
	private String editDate ;
	/** 属性receiverTypeOtherName/receiverTypeOtherName */
	@Column(name = "receiverTypeOtherName")
	private String receiverTypeOtherName ;
	/** 属性payWay/payWay */
	@Column(name = "payWay")
	private String payWay ;
	/** 属性payReason/payReason */
	@Column(name = "payReason")
	private String payReason ;
	/** 属性payPurpose/payPurpose */
	@Column(name = "payPurpose")
	private String payPurpose ;
	/** 属性accountFlag/accountFlag */
	@Column(name = "accountFlag")
	private String accountFlag ;
	/** 属性interType/interType */
	@Column(name = "interType")
	private String interType ;
	/** 属性routEnum/routEnum */
	@Column(name = "routeNum")
	private String routeNum ;
	/** 属性thirdPayType/thirdPayType */
	@Column(name = "thirdPayType")
	private String thirdPayType ;

	/**
	 * 属性立案号/立案号的getter方法
	 */
	public String getClaimNo() {
		return claimNo;
	}
	/**
	 * 属性立案号/立案号的setter方法
	 */
	public void setClaimNo(String claimNo) {
		this.claimNo = claimNo;
	}
	/**
	 * 属性序号/序号的getter方法
	 */
	public String getSerialNo() {
		return serialNo;
	}
	/**
	 * 属性序号/序号的setter方法
	 */
	public void setSerialNo(String serialNo) {
		this.serialNo = serialNo;
	}
	/**
	 * 属性业务号，预赔环节就是预赔号，理算环节就是理算号。/业务号，预赔环节就是预赔号，理算环节就是理算号。的getter方法
	 */
	public String getCompensateNo() {
		return compensateNo;
	}
	/**
	 * 属性业务号，预赔环节就是预赔号，理算环节就是理算号。/业务号，预赔环节就是预赔号，理算环节就是理算号。的setter方法
	 */
	public void setCompensateNo(String compensateNo) {
		this.compensateNo = compensateNo;
	}
	/**
	 * 属性险类代码/险类代码的getter方法
	 */
	public String getClassCode() {
		return classCode;
	}
	/**
	 * 属性险类代码/险类代码的setter方法
	 */
	public void setClassCode(String classCode) {
		this.classCode = classCode;
	}
	/**
	 * 属性险种代码/险种代码的getter方法
	 */
	public String getRiskCode() {
		return riskCode;
	}
	/**
	 * 属性险种代码/险种代码的setter方法
	 */
	public void setRiskCode(String riskCode) {
		this.riskCode = riskCode;
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
	 * 属性支付类型(预赔，支付，垫付，结案支付)/支付类型(预赔，支付，垫付，结案支付)的getter方法
	 */
	public String getPayType() {
		return payType;
	}
	/**
	 * 属性支付类型(预赔，支付，垫付，结案支付)/支付类型(预赔，支付，垫付，结案支付)的setter方法
	 */
	public void setPayType(String payType) {
		this.payType = payType;
	}
	/**
	 * 属性领款人类型（被保险人、委托个人代理索赔、委托单位代理索赔）/领款人类型（被保险人、委托个人代理索赔、委托单位代理索赔）的getter方法
	 */
	public String getReceiverType() {
		return receiverType;
	}
	/**
	 * 属性领款人类型（被保险人、委托个人代理索赔、委托单位代理索赔）/领款人类型（被保险人、委托个人代理索赔、委托单位代理索赔）的setter方法
	 */
	public void setReceiverType(String receiverType) {
		this.receiverType = receiverType;
	}
	/**
	 * 属性支付金额/支付金额的getter方法
	 */
	public Double getPayAmount() {
		return payAmount;
	}
	/**
	 * 属性支付金额/支付金额的setter方法
	 */
	public void setPayAmount(Double payAmount) {
		this.payAmount = payAmount;
	}
	/**
	 * 属性银行大类/银行大类的getter方法
	 */
	public String getBankType() {
		return bankType;
	}
	/**
	 * 属性银行大类/银行大类的setter方法
	 */
	public void setBankType(String bankType) {
		this.bankType = bankType;
	}
	/**
	 * 属性开户银行/开户银行的getter方法
	 */
	public String getBank() {
		return bank;
	}
	/**
	 * 属性开户银行/开户银行的setter方法
	 */
	public void setBank(String bank) {
		this.bank = bank;
	}
	/**
	 * 属性开户行明细/开户行明细的getter方法
	 */
	public String getBankSite() {
		return bankSite;
	}
	/**
	 * 属性开户行明细/开户行明细的setter方法
	 */
	public void setBankSite(String bankSite) {
		this.bankSite = bankSite;
	}
	/**
	 * 属性账号类型（个人、单位）/账号类型（个人、单位）的getter方法
	 */
	public String getAccountType() {
		return accountType;
	}
	/**
	 * 属性账号类型（个人、单位）/账号类型（个人、单位）的setter方法
	 */
	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}
	/**
	 * 属性领款人全称/领款人全称的getter方法
	 */
	public String getReceiverFullName() {
		return receiverFullName;
	}
	/**
	 * 属性领款人全称/领款人全称的setter方法
	 */
	public void setReceiverFullName(String receiverFullName) {
		this.receiverFullName = receiverFullName;
	}
	/**
	 * 属性证件类型（身份证、户口本、军官证、护照）/证件类型（身份证、户口本、军官证、护照）的getter方法
	 */
	public String getCertiftype() {
		return certiftype;
	}
	/**
	 * 属性证件类型（身份证、户口本、军官证、护照）/证件类型（身份证、户口本、军官证、护照）的setter方法
	 */
	public void setCertiftype(String certiftype) {
		this.certiftype = certiftype;
	}
	/**
	 * 属性详细地址/详细地址的getter方法
	 */
	public String getAddress() {
		return address;
	}
	/**
	 * 属性详细地址/详细地址的setter方法
	 */
	public void setAddress(String address) {
		this.address = address;
	}
	/**
	 * 属性证件号码/证件号码的getter方法
	 */
	public String getCertifNo() {
		return certifNo;
	}
	/**
	 * 属性证件号码/证件号码的setter方法
	 */
	public void setCertifNo(String certifNo) {
		this.certifNo = certifNo;
	}
	/**
	 * 属性家庭电话/家庭电话的getter方法
	 */
	public String getFamilyPhone() {
		return familyPhone;
	}
	/**
	 * 属性家庭电话/家庭电话的setter方法
	 */
	public void setFamilyPhone(String familyPhone) {
		this.familyPhone = familyPhone;
	}
	/**
	 * 属性办公电话/办公电话的getter方法
	 */
	public String getOfficePhone() {
		return officePhone;
	}
	/**
	 * 属性办公电话/办公电话的setter方法
	 */
	public void setOfficePhone(String officePhone) {
		this.officePhone = officePhone;
	}
	/**
	 * 属性手机号/手机号的getter方法
	 */
	public String getMobilePhone() {
		return mobilePhone;
	}
	/**
	 * 属性手机号/手机号的setter方法
	 */
	public void setMobilePhone(String mobilePhone) {
		this.mobilePhone = mobilePhone;
	}
	/**
	 * 属性支付说明/支付说明的getter方法
	 */
	public String getPayRemark() {
		return payRemark;
	}
	/**
	 * 属性支付说明/支付说明的setter方法
	 */
	public void setPayRemark(String payRemark) {
		this.payRemark = payRemark;
	}
	/**
	 * 属性操作员代码/操作员代码的getter方法
	 */
	public String getOperatorCode() {
		return operatorCode;
	}
	/**
	 * 属性操作员代码/操作员代码的setter方法
	 */
	public void setOperatorCode(String operatorCode) {
		this.operatorCode = operatorCode;
	}
	/**
	 * 属性输入日期/输入日期的getter方法
	 */
	public Date getInputDate() {
		return inputDate;
	}
	/**
	 * 属性输入日期/输入日期的setter方法
	 */
	public void setInputDate(Date inputDate) {
		this.inputDate = inputDate;
	}
	/**
	 * 属性支付日期/支付日期的getter方法
	 */
	public Date getPayDate() {
		return payDate;
	}
	/**
	 * 属性支付日期/支付日期的setter方法
	 */
	public void setPayDate(Date payDate) {
		this.payDate = payDate;
	}
	/**
	 * 属性支付员代码/支付员代码的getter方法
	 */
	public String getPayCode() {
		return payCode;
	}
	/**
	 * 属性支付员代码/支付员代码的setter方法
	 */
	public void setPayCode(String payCode) {
		this.payCode = payCode;
	}
	/**
	 * 属性支付标志/支付标志的getter方法
	 */
	public String getPayFlag() {
		return payFlag;
	}
	/**
	 * 属性支付标志/支付标志的setter方法
	 */
	public void setPayFlag(String payFlag) {
		this.payFlag = payFlag;
	}
	/**
	 * 属性赔款类型/赔款类型的getter方法
	 */
	public String getPaymentType() {
		return paymentType;
	}
	/**
	 * 属性赔款类型/赔款类型的setter方法
	 */
	public void setPaymentType(String paymentType) {
		this.paymentType = paymentType;
	}
	/**
	 * 属性银行账号/银行账号的getter方法
	 */
	public String getBankAccount() {
		return bankAccount;
	}
	/**
	 * 属性银行账号/银行账号的setter方法
	 */
	public void setBankAccount(String bankAccount) {
		this.bankAccount = bankAccount;
	}
	/**
	 * 属性节点/节点的getter方法
	 */
	public String getNode() {
		return node;
	}
	/**
	 * 属性节点/节点的setter方法
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
	 * 属性赔付信息审核平台状态字段:空为未处理，2为正在审核，3为退回，4为通过 8审核通过，数据到总公司/赔付信息审核平台状态字段:空为未处理，2为正在审核，3为退回，4为通过 8审核通过，数据到总公司的getter方法
	 */
	public String getVFlag() {
		return vFlag;
	}
	/**
	 * 属性赔付信息审核平台状态字段:空为未处理，2为正在审核，3为退回，4为通过 8审核通过，数据到总公司/赔付信息审核平台状态字段:空为未处理，2为正在审核，3为退回，4为通过 8审核通过，数据到总公司的setter方法
	 */
	public void setVFlag(String vFlag) {
		this.vFlag = vFlag;
	}
	/**
	 * 属性机构代码/机构代码的getter方法
	 */
	public String getComCode() {
		return comCode;
	}
	/**
	 * 属性机构代码/机构代码的setter方法
	 */
	public void setComCode(String comCode) {
		this.comCode = comCode;
	}
	/**
	 * 属性新增序号列，联合主键/新增序号列，联合主键的getter方法
	 */
	public String getSerialNo2() {
		return serialNo2;
	}
	/**
	 * 属性新增序号列，联合主键/新增序号列，联合主键的setter方法
	 */
	public void setSerialNo2(String serialNo2) {
		this.serialNo2 = serialNo2;
	}
	/**
	 * 属性operatorComcode/operatorComcode的getter方法
	 */
	public String getOperatorComcode() {
		return operatorComcode;
	}
	/**
	 * 属性operatorComcode/operatorComcode的setter方法
	 */
	public void setOperatorComcode(String operatorComcode) {
		this.operatorComcode = operatorComcode;
	}
	/**
	 * 属性联共保人代码/联共保人代码的getter方法
	 */
	public String getCoinsCode() {
		return coinsCode;
	}
	/**
	 * 属性联共保人代码/联共保人代码的setter方法
	 */
	public void setCoinsCode(String coinsCode) {
		this.coinsCode = coinsCode;
	}

	public String getvFlag() {
		return vFlag;
	}

	public void setvFlag(String vFlag) {
		this.vFlag = vFlag;
	}

	public String getProvinceCode() {
		return provinceCode;
	}

	public void setProvinceCode(String provinceCode) {
		this.provinceCode = provinceCode;
	}

	public String getCityCode() {
		return cityCode;
	}

	public void setCityCode(String cityCode) {
		this.cityCode = cityCode;
	}

	public String getUrgentType() {
		return urgentType;
	}

	public void setUrgentType(String urgentType) {
		this.urgentType = urgentType;
	}

	public String getQqNumber() {
		return qqNumber;
	}

	public void setQqNumber(String qqNumber) {
		this.qqNumber = qqNumber;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getUnitLink() {
		return unitLink;
	}

	public void setUnitLink(String unitLink) {
		this.unitLink = unitLink;
	}

	public String getPostCode() {
		return postCode;
	}

	public void setPostCode(String postCode) {
		this.postCode = postCode;
	}

	public String getEditDate() {
		return editDate;
	}

	public void setEditDate(String editDate) {
		this.editDate = editDate;
	}

	public String getReceiverTypeOtherName() {
		return receiverTypeOtherName;
	}

	public void setReceiverTypeOtherName(String receiverTypeOtherName) {
		this.receiverTypeOtherName = receiverTypeOtherName;
	}

	public String getPayWay() {
		return payWay;
	}

	public void setPayWay(String payWay) {
		this.payWay = payWay;
	}

	public String getPayReason() {
		return payReason;
	}

	public void setPayReason(String payReason) {
		this.payReason = payReason;
	}

	public String getPayPurpose() {
		return payPurpose;
	}

	public void setPayPurpose(String payPurpose) {
		this.payPurpose = payPurpose;
	}

	public String getAccountFlag() {
		return accountFlag;
	}

	public void setAccountFlag(String accountFlag) {
		this.accountFlag = accountFlag;
	}

	public String getInterType() {
		return interType;
	}

	public void setInterType(String interType) {
		this.interType = interType;
	}

	public String getRouteNum() {
		return routeNum;
	}

	public void setRouteNum(String routeNum) {
		this.routeNum = routeNum;
	}

	public String getThirdPayType() {
		return thirdPayType;
	}

	public void setThirdPayType(String thirdPayType) {
		this.thirdPayType = thirdPayType;
	}
}