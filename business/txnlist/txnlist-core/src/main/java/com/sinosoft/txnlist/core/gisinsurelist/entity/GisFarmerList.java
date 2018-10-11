package com.sinosoft.txnlist.core.gisinsurelist.entity;

import com.sinosoft.framework.core.dao.BaseEntityImpl;
import javax.persistence.*;
import java.util.Date;

/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2018-01-15 07:18:08.821 
 * 投保预确认农户清单表实体操作对象
 */
@Entity
@Table(name = "GisFarmerList")
@IdClass(GisFarmerListKey.class)
public class GisFarmerList extends BaseEntityImpl{

	private static final long serialVersionUID = 1L;
	/** 属性清单编号/清单编号 */
	@Id
	@Column(name = "insureListCode")
	private String insureListCode ;/** 属性序列号/序列号 */
	@Id
	@Column(name = "serialNo")
	private Integer serialNo ;/** 属性农户代码/农户代码 */
	@Id
	@Column(name = "fCode")
	private String fCode ;	



	/** 属性农户姓名/农户姓名 */
	@Column(name = "fName")
	private String fName ;
	/** 属性证件类型/证件类型 */
	@Column(name = "fIdType")
	private String fIdType ;
	/** 属性证件号码/证件号码 */
	@Column(name = "fIdCard")
	private String fIdCard ;
	/** 属性组别/组别 */
	@Column(name = "teamName")
	private String teamName ;
	/** 属性联系电话号码/联系电话号码 */
	@Column(name = "fTel")
	private String fTel ;
	/** 属性联系手机号码/联系手机号码 */
	@Column(name = "fPhone")
	private String fPhone ;
	/** 属性联系地址/联系地址 */
	@Column(name = "fAddress")
	private String fAddress ;
	/** 属性微信号/微信号 */
	@Column(name = "fWechatAc")
	private String fWechatAc ;
	/** 属性支付宝号/支付宝号 */
	@Column(name = "fAlipayAc")
	private String fAlipayAc ;
	/** 属性开户银行大类代码/开户银行大类代码 */
	@Column(name = "bankTypeCode")
	private String bankTypeCode ;
	/** 属性开户银行大类名称/开户银行大类名称 */
	@Column(name = "bankTypeName")
	private String bankTypeName ;
	/** 属性开户银行所在省代码/开户银行所在省代码 */
	@Column(name = "brovinceCode")
	private String brovinceCode ;
	/** 属性开户银行所在省名称/开户银行所在省名称 */
	@Column(name = "brovinceName")
	private String brovinceName ;
	/** 属性开户银行所在市代码/开户银行所在市代码 */
	@Column(name = "bcityCode")
	private String bcityCode ;
	/** 属性开户银行所在市名称/开户银行所在市名称 */
	@Column(name = "bcityName")
	private String bcityName ;
	/** 属性开户银行代码/开户银行代码 */
	@Column(name = "bankCode")
	private String bankCode ;
	/** 属性开户银行名称/开户银行名称 */
	@Column(name = "bankName")
	private String bankName ;
	/** 属性开户银行联行号/开户银行联行号 */
	@Column(name = "bankNumber")
	private String bankNumber ;
	/** 属性开户户名/开户户名 */
	@Column(name = "accountName")
	private String accountName ;
	/** 属性开户账号/开户账号 */
	@Column(name = "accountNo")
	private String accountNo ;
	/** 属性土地确权证号码/土地确权证号码 */
	@Column(name = "landCard")
	private String landCard ;
	/** 属性土地确权总面积/土地确权总面积 */
	@Column(name = "landArea")
	private Double landArea ;
	/** 属性土地实际总面积/土地实际总面积 */
	@Column(name = "realArea")
	private Double realArea ;
	/** 属性投保总面积/投标总数量/投保总面积/投标总数量 */
	@Column(name = "insureArea")
	private Double insureArea ;
	/** 属性实际投保总面积/实际投保总面积 */
	@Column(name = "tinsurEarea")
	private Double tinsurEarea ;
	/** 属性剔除面积/剔除面积 */
	@Column(name = "delArea")
	private Double delArea ;
	/** 属性整体调整原因/整体调整原因 */
	@Column(name = "adjustReason")
	private String adjustReason ;

	// 针对草莓种植险种新增字段
	/** 行业类别 */
	@Column(name = "industryCategory")
	private String industryCategory;
	/** 贷款合同编号 */
	@Column(name = "loanContractNo")
	private String loanContractNo;
	/** 贷款银行代码 */
	@Column(name = "loanBankAccount")
	private String loanBankAccount;
	/** 贷款金额 */
	@Column(name = "loadAmount")
	private Double loadAmount;
	/** 担保人 */
	@Column(name = "guarantor")
	private String guarantor;
	/** 贷款期限 */
	@Column(name = "loanPeriod")
	private Date loanPeriod;
	/** 贷款用途 */
	@Column(name = "loanUse")
	private String loanUse;

	public String getInsureListCode() {
		return insureListCode;
	}

	public void setInsureListCode(String insureListCode) {
		this.insureListCode = insureListCode;
	}

	public Integer getSerialNo() {
		return serialNo;
	}

	public void setSerialNo(Integer serialNo) {
		this.serialNo = serialNo;
	}

	public String getfCode() {
		return fCode;
	}

	public void setfCode(String fCode) {
		this.fCode = fCode;
	}

	public String getfName() {
		return fName;
	}

	public void setfName(String fName) {
		this.fName = fName;
	}

	public String getfIdType() {
		return fIdType;
	}

	public void setfIdType(String fIdType) {
		this.fIdType = fIdType;
	}

	public String getfIdCard() {
		return fIdCard;
	}

	public void setfIdCard(String fIdCard) {
		this.fIdCard = fIdCard;
	}

	public String getTeamName() {
		return teamName;
	}

	public void setTeamName(String teamName) {
		this.teamName = teamName;
	}

	public String getfTel() {
		return fTel;
	}

	public void setfTel(String fTel) {
		this.fTel = fTel;
	}

	public String getfPhone() {
		return fPhone;
	}

	public void setfPhone(String fPhone) {
		this.fPhone = fPhone;
	}

	public String getfAddress() {
		return fAddress;
	}

	public void setfAddress(String fAddress) {
		this.fAddress = fAddress;
	}

	public String getfWechatAc() {
		return fWechatAc;
	}

	public void setfWechatAc(String fWechatAc) {
		this.fWechatAc = fWechatAc;
	}

	public String getfAlipayAc() {
		return fAlipayAc;
	}

	public void setfAlipayAc(String fAlipayAc) {
		this.fAlipayAc = fAlipayAc;
	}

	public String getBankTypeCode() {
		return bankTypeCode;
	}

	public void setBankTypeCode(String bankTypeCode) {
		this.bankTypeCode = bankTypeCode;
	}

	public String getBankTypeName() {
		return bankTypeName;
	}

	public void setBankTypeName(String bankTypeName) {
		this.bankTypeName = bankTypeName;
	}

	public String getBrovinceCode() {
		return brovinceCode;
	}

	public void setBrovinceCode(String brovinceCode) {
		this.brovinceCode = brovinceCode;
	}

	public String getBrovinceName() {
		return brovinceName;
	}

	public void setBrovinceName(String brovinceName) {
		this.brovinceName = brovinceName;
	}

	public String getBcityCode() {
		return bcityCode;
	}

	public void setBcityCode(String bcityCode) {
		this.bcityCode = bcityCode;
	}

	public String getBcityName() {
		return bcityName;
	}

	public void setBcityName(String bcityName) {
		this.bcityName = bcityName;
	}

	public String getBankCode() {
		return bankCode;
	}

	public void setBankCode(String bankCode) {
		this.bankCode = bankCode;
	}

	public String getBankName() {
		return bankName;
	}

	public void setBankName(String bankName) {
		this.bankName = bankName;
	}

	public String getBankNumber() {
		return bankNumber;
	}

	public void setBankNumber(String bankNumber) {
		this.bankNumber = bankNumber;
	}

	public String getAccountName() {
		return accountName;
	}

	public void setAccountName(String accountName) {
		this.accountName = accountName;
	}

	public String getAccountNo() {
		return accountNo;
	}

	public void setAccountNo(String accountNo) {
		this.accountNo = accountNo;
	}

	public String getLandCard() {
		return landCard;
	}

	public void setLandCard(String landCard) {
		this.landCard = landCard;
	}

	public Double getLandArea() {
		return landArea;
	}

	public void setLandArea(Double landArea) {
		this.landArea = landArea;
	}

	public Double getRealArea() {
		return realArea;
	}

	public void setRealArea(Double realArea) {
		this.realArea = realArea;
	}

	public Double getInsureArea() {
		return insureArea;
	}

	public void setInsureArea(Double insureArea) {
		this.insureArea = insureArea;
	}

	public Double getTinsurEarea() {
		return tinsurEarea;
	}

	public void setTinsurEarea(Double tinsurEarea) {
		this.tinsurEarea = tinsurEarea;
	}

	public Double getDelArea() {
		return delArea;
	}

	public void setDelArea(Double delArea) {
		this.delArea = delArea;
	}

	public String getAdjustReason() {
		return adjustReason;
	}

	public void setAdjustReason(String adjustReason) {
		this.adjustReason = adjustReason;
	}

	public String getIndustryCategory() {
		return industryCategory;
	}

	public void setIndustryCategory(String industryCategory) {
		this.industryCategory = industryCategory;
	}

	public String getLoanContractNo() {
		return loanContractNo;
	}

	public void setLoanContractNo(String loanContractNo) {
		this.loanContractNo = loanContractNo;
	}

	public String getLoanBankAccount() {
		return loanBankAccount;
	}

	public void setLoanBankAccount(String loanBankAccount) {
		this.loanBankAccount = loanBankAccount;
	}

	public Double getLoadAmount() {
		return loadAmount;
	}

	public void setLoadAmount(Double loadAmount) {
		this.loadAmount = loadAmount;
	}

	public String getGuarantor() {
		return guarantor;
	}

	public void setGuarantor(String guarantor) {
		this.guarantor = guarantor;
	}

	public Date getLoanPeriod() {
		return loanPeriod;
	}

	public void setLoanPeriod(Date loanPeriod) {
		this.loanPeriod = loanPeriod;
	}

	public String getLoanUse() {
		return loanUse;
	}

	public void setLoanUse(String loanUse) {
		this.loanUse = loanUse;
	}
}