package com.sinosoft.agriprpall.core.proposalmanage.entity;

import com.sinosoft.framework.core.dao.BaseEntityImpl;
import javax.persistence.*;
import java.util.Date;

/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-10-24 01:57:51.087 
 * 贷款保险保单信息表实体操作对象
 */
@Entity
@Table(name = "PrpTmainLoan")
@IdClass(PrpTmainLoanKey.class)
public class PrpTmainLoan extends BaseEntityImpl{

	private static final long serialVersionUID = 1L;
	/** 属性投保单号码/投保单号码 */
	@Id
	@Column(name = "proposalNo")
	private String proposalNo ;	

	/** 属性险种代码 /险种代码  */
	@Column(name = "riskCode")
	private String riskCode ;
	/** 属性风险种类/风险种类 */
	@Column(name = "riskKind")
	private String riskKind ;
	/** 属性担保方式（抵押/质押/保证）/担保方式（抵押/质押/保证） */
	@Column(name = "guaranteeType")
	private String guaranteeType ;
	/** 属性抵押/质押物品名称/抵押/质押物品名称 */
	@Column(name = "guaranteeName")
	private String guaranteeName ;
	/** 属性抵押合同/确认书号/抵押合同/确认书号 mortgage 抵押 */
	@Column(name = "mortgageNo")
	private String mortgageNo ;
	/** 属性担保人代码/担保人代码 */
	@Column(name = "warrantorCode")
	private String warrantorCode ;
	/** 属性担保人名称/担保人名称 */
	@Column(name = "warrantorName")
	private String warrantorName ;
	/** 属性贷款相关号１：贷款申请表号/贷款相关号１：贷款申请表号 */
	@Column(name = "loanNo1")
	private String loanNo1 ;
	/** 属性贷款相关号2：贷款审批表号/贷款相关号2：贷款审批表号 */
	@Column(name = "loanNo2")
	private String loanNo2 ;
	/** 属性期房标志(Y/N)/期房标志(Y/N) installment 分期付款*/
	@Column(name = "installmentFlag")
	private String installmentFlag ;
	/** 属性期房交付日期/期房交付日期 */
	@Column(name = "deliverDate")
	private Date deliverDate ;
	/** 属性贷款合同号/贷款合同号 */
	@Column(name = "loanContractNo")
	private String loanContractNo ;
	/** 属性保额确定方式编码/保额确定方式编码 */
	@Column(name = "loanWay")
	private String loanWay ;
	/** 属性贷款性质代码/贷款性质代码 */
	@Column(name = "loanNature")
	private String loanNature ;
	/** 属性贷款银行代码 /贷款银行代码  */
	@Column(name = "loanBankCode")
	private String loanBankCode ;
	/** 属性贷款银行名称/贷款银行名称 */
	@Column(name = "loanBankName")
	private String loanBankName ;
	/** 属性贷款用途/贷款用途 */
	@Column(name = "loanUsage")
	private String loanUsage ;
	/** 属性贷款期限开始日期/贷款期限开始日期 */
	@Column(name = "loanStartDate")
	private Date loanStartDate ;
	/** 属性贷款期限终止日期/贷款期限终止日期 */
	@Column(name = "loanEndDate")
	private Date loanEndDate ;
	/** 属性贷款年限/贷款年限 */
	@Column(name = "loanYear")
	private Integer loanYear ;
	/** 属性初装金额/初装金额 */
	@Column(name = "planAmount")
	private Double planAmount ;
	/** 属性首付比例（%）/首付比例（%） */
	@Column(name = "firstRate")
	private Double firstRate ;
	/** 属性首期付款金额/首期付款金额 */
	@Column(name = "firstPaid")
	private Double firstPaid ;
	/** 属性贷款币别 /贷款币别  */
	@Column(name = "currency")
	private String currency ;
	/** 属性贷款金额/贷款金额 */
	@Column(name = "loanAmount")
	private Double loanAmount ;
	/** 属性贷款利率/本息/贷款利率/本息 */
	@Column(name = "loanRate")
	private Double loanRate ;
	/** 属性还款方式:按月、按季 /还款方式:按月、按季  */
	@Column(name = "repaidType")
	private String repaidType ;
	/** 属性约定付款期数/约定付款期数 */
	@Column(name = "paidTimes")
	private Integer paidTimes ;
	/** 属性每期还款金额/每期还款金额 */
	@Column(name = "perRepaidAmount")
	private Double perRepaidAmount ;
	/** 属性备注/备注 */
	@Column(name = "remark")
	private String remark ;
	/** 属性标志字段/标志字段 */
	@Column(name = "flag")
	private String flag ;
	/** 属性质押人地址/质押人地址 */
	@Column(name = "warrantorAddress")
	private String warrantorAddress ;
	/** 属性质押物仓储地点/质押物仓储地点 */
	@Column(name = "loanAddress")
	private String loanAddress ;
	/** 属性贷款期间利息/贷款期间利息 */
	@Column(name = "loanInterest")
	private Double loanInterest ;
	/** 属性初始债权人名称/初始债权人名称 */
	@Column(name = "initialCreditorName")
	private String initialCreditorName ;
	/** 属性联系地址/联系地址 */
	@Column(name = "contactAddress")
	private String contactAddress ;
	/** 属性联系人/联系人 */
	@Column(name = "linkMan")
	private String linkMan ;
	/** 属性联系电话/联系电话 */
	@Column(name = "contactNumber")
	private String contactNumber ;
	/** 属性应收账款流转金额/应收账款流转金额 */
	@Column(name = "accReceiveAmount")
	private String accReceiveAmount ;
	/** 属性回购日期/回购日期  repurchage 重新购买 */
	@Column(name = "repurchaseDate")
	private Date repurchaseDate ;
	/** 属性保证金比例及额度/保证金比例及额度 */
	@Column(name = "bondAmount")
	private String bondAmount ;
	/** 属性有效资产低（质）押/有效资产低（质）押 */
	@Column(name = "effectiveProperty")
	private String effectiveProperty ;
	/**
	 * 属性投保单号码/投保单号码的getter方法
	 */
	public String getProposalNo() {
		return proposalNo;
	}
	/**
	 * 属性投保单号码/投保单号码的setter方法
	 */
	public void setProposalNo(String proposalNo) {
		this.proposalNo = proposalNo;
	} 	
	/**
	 * 属性险种代码 /险种代码 的getter方法
	 */
	public String getRiskCode() {
		return riskCode;
	}
	/**
	 * 属性险种代码 /险种代码 的setter方法
	 */
	public void setRiskCode(String riskCode) {
		this.riskCode = riskCode;
	} 	
	/**
	 * 属性风险种类/风险种类的getter方法
	 */
	public String getRiskKind() {
		return riskKind;
	}
	/**
	 * 属性风险种类/风险种类的setter方法
	 */
	public void setRiskKind(String riskKind) {
		this.riskKind = riskKind;
	} 	
	/**
	 * 属性担保方式（抵押/质押/保证）/担保方式（抵押/质押/保证）的getter方法
	 */
	public String getGuaranteeType() {
		return guaranteeType;
	}
	/**
	 * 属性担保方式（抵押/质押/保证）/担保方式（抵押/质押/保证）的setter方法
	 */
	public void setGuaranteeType(String guaranteeType) {
		this.guaranteeType = guaranteeType;
	} 	
	/**
	 * 属性抵押/质押物品名称/抵押/质押物品名称的getter方法
	 */
	public String getGuaranteeName() {
		return guaranteeName;
	}
	/**
	 * 属性抵押/质押物品名称/抵押/质押物品名称的setter方法
	 */
	public void setGuaranteeName(String guaranteeName) {
		this.guaranteeName = guaranteeName;
	} 	
	/**
	 * 属性抵押合同/确认书号/抵押合同/确认书号的getter方法
	 */
	public String getMortgageNo() {
		return mortgageNo;
	}
	/**
	 * 属性抵押合同/确认书号/抵押合同/确认书号的setter方法
	 */
	public void setMortgageNo(String mortgageNo) {
		this.mortgageNo = mortgageNo;
	} 	
	/**
	 * 属性担保人代码/担保人代码的getter方法
	 */
	public String getWarrantorCode() {
		return warrantorCode;
	}
	/**
	 * 属性担保人代码/担保人代码的setter方法
	 */
	public void setWarrantorCode(String warrantorCode) {
		this.warrantorCode = warrantorCode;
	} 	
	/**
	 * 属性担保人名称/担保人名称的getter方法
	 */
	public String getWarrantorName() {
		return warrantorName;
	}
	/**
	 * 属性担保人名称/担保人名称的setter方法
	 */
	public void setWarrantorName(String warrantorName) {
		this.warrantorName = warrantorName;
	} 	

	/**
	 * 属性期房交付日期/期房交付日期的getter方法
	 */
	public Date getDeliverDate() {
		return deliverDate;
	}
	/**
	 * 属性期房交付日期/期房交付日期的setter方法
	 */
	public void setDeliverDate(Date deliverDate) {
		this.deliverDate = deliverDate;
	} 	
	/**
	 * 属性贷款合同号/贷款合同号的getter方法
	 */
	public String getLoanContractNo() {
		return loanContractNo;
	}
	/**
	 * 属性贷款合同号/贷款合同号的setter方法
	 */
	public void setLoanContractNo(String loanContractNo) {
		this.loanContractNo = loanContractNo;
	} 	
	/**
	 * 属性保额确定方式编码/保额确定方式编码的getter方法
	 */
	public String getLoanWay() {
		return loanWay;
	}
	/**
	 * 属性保额确定方式编码/保额确定方式编码的setter方法
	 */
	public void setLoanWay(String loanWay) {
		this.loanWay = loanWay;
	} 	
	/**
	 * 属性贷款性质代码/贷款性质代码的getter方法
	 */
	public String getLoanNature() {
		return loanNature;
	}
	/**
	 * 属性贷款性质代码/贷款性质代码的setter方法
	 */
	public void setLoanNature(String loanNature) {
		this.loanNature = loanNature;
	} 	
	/**
	 * 属性贷款银行代码 /贷款银行代码 的getter方法
	 */
	public String getLoanBankCode() {
		return loanBankCode;
	}
	/**
	 * 属性贷款银行代码 /贷款银行代码 的setter方法
	 */
	public void setLoanBankCode(String loanBankCode) {
		this.loanBankCode = loanBankCode;
	} 	
	/**
	 * 属性贷款银行名称/贷款银行名称的getter方法
	 */
	public String getLoanBankName() {
		return loanBankName;
	}
	/**
	 * 属性贷款银行名称/贷款银行名称的setter方法
	 */
	public void setLoanBankName(String loanBankName) {
		this.loanBankName = loanBankName;
	} 	

	/**
	 * 属性贷款期限开始日期/贷款期限开始日期的getter方法
	 */
	public Date getLoanStartDate() {
		return loanStartDate;
	}
	/**
	 * 属性贷款期限开始日期/贷款期限开始日期的setter方法
	 */
	public void setLoanStartDate(Date loanStartDate) {
		this.loanStartDate = loanStartDate;
	} 	
	/**
	 * 属性贷款期限终止日期/贷款期限终止日期的getter方法
	 */
	public Date getLoanEndDate() {
		return loanEndDate;
	}
	/**
	 * 属性贷款期限终止日期/贷款期限终止日期的setter方法
	 */
	public void setLoanEndDate(Date loanEndDate) {
		this.loanEndDate = loanEndDate;
	} 	
	/**
	 * 属性贷款年限/贷款年限的getter方法
	 */
	public Integer getLoanYear() {
		return loanYear;
	}
	/**
	 * 属性贷款年限/贷款年限的setter方法
	 */
	public void setLoanYear(Integer loanYear) {
		this.loanYear = loanYear;
	} 	
	/**
	 * 属性初装金额/初装金额的getter方法
	 */
	public Double getPlanAmount() {
		return planAmount;
	}
	/**
	 * 属性初装金额/初装金额的setter方法
	 */
	public void setPlanAmount(Double planAmount) {
		this.planAmount = planAmount;
	} 	
	/**
	 * 属性首付比例（%）/首付比例（%）的getter方法
	 */
	public Double getFirstRate() {
		return firstRate;
	}
	/**
	 * 属性首付比例（%）/首付比例（%）的setter方法
	 */
	public void setFirstRate(Double firstRate) {
		this.firstRate = firstRate;
	} 	
	/**
	 * 属性首期付款金额/首期付款金额的getter方法
	 */
	public Double getFirstPaid() {
		return firstPaid;
	}
	/**
	 * 属性首期付款金额/首期付款金额的setter方法
	 */
	public void setFirstPaid(Double firstPaid) {
		this.firstPaid = firstPaid;
	} 	
	/**
	 * 属性贷款币别 /贷款币别 的getter方法
	 */
	public String getCurrency() {
		return currency;
	}
	/**
	 * 属性贷款币别 /贷款币别 的setter方法
	 */
	public void setCurrency(String currency) {
		this.currency = currency;
	} 	
	/**
	 * 属性贷款金额/贷款金额的getter方法
	 */
	public Double getLoanAmount() {
		return loanAmount;
	}
	/**
	 * 属性贷款金额/贷款金额的setter方法
	 */
	public void setLoanAmount(Double loanAmount) {
		this.loanAmount = loanAmount;
	} 	
	/**
	 * 属性贷款利率/本息/贷款利率/本息的getter方法
	 */
	public Double getLoanRate() {
		return loanRate;
	}
	/**
	 * 属性贷款利率/本息/贷款利率/本息的setter方法
	 */
	public void setLoanRate(Double loanRate) {
		this.loanRate = loanRate;
	} 	
	/**
	 * 属性还款方式:按月、按季 /还款方式:按月、按季 的getter方法
	 */
	public String getRepaidType() {
		return repaidType;
	}
	/**
	 * 属性还款方式:按月、按季 /还款方式:按月、按季 的setter方法
	 */
	public void setRepaidType(String repaidType) {
		this.repaidType = repaidType;
	} 	
	/**
	 * 属性约定付款期数/约定付款期数的getter方法
	 */
	public Integer getPaidTimes() {
		return paidTimes;
	}
	/**
	 * 属性约定付款期数/约定付款期数的setter方法
	 */
	public void setPaidTimes(Integer paidTimes) {
		this.paidTimes = paidTimes;
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
	/**
	 * 属性标志字段/标志字段的getter方法
	 */
	public String getFlag() {
		return flag;
	}
	/**
	 * 属性标志字段/标志字段的setter方法
	 */
	public void setFlag(String flag) {
		this.flag = flag;
	} 	
	/**
	 * 属性质押人地址/质押人地址的getter方法
	 */
	public String getWarrantorAddress() {
		return warrantorAddress;
	}
	/**
	 * 属性质押人地址/质押人地址的setter方法
	 */
	public void setWarrantorAddress(String warrantorAddress) {
		this.warrantorAddress = warrantorAddress;
	} 	
	/**
	 * 属性质押物仓储地点/质押物仓储地点的getter方法
	 */
	public String getLoanAddress() {
		return loanAddress;
	}
	/**
	 * 属性质押物仓储地点/质押物仓储地点的setter方法
	 */
	public void setLoanAddress(String loanAddress) {
		this.loanAddress = loanAddress;
	} 	
	/**
	 * 属性贷款期间利息/贷款期间利息的getter方法
	 */
	public Double getLoanInterest() {
		return loanInterest;
	}
	/**
	 * 属性贷款期间利息/贷款期间利息的setter方法
	 */
	public void setLoanInterest(Double loanInterest) {
		this.loanInterest = loanInterest;
	} 	
	/**
	 * 属性初始债权人名称/初始债权人名称的getter方法
	 */
	public String getInitialCreditorName() {
		return initialCreditorName;
	}
	/**
	 * 属性初始债权人名称/初始债权人名称的setter方法
	 */
	public void setInitialCreditorName(String initialCreditorName) {
		this.initialCreditorName = initialCreditorName;
	} 	
	/**
	 * 属性联系地址/联系地址的getter方法
	 */
	public String getContactAddress() {
		return contactAddress;
	}
	/**
	 * 属性联系地址/联系地址的setter方法
	 */
	public void setContactAddress(String contactAddress) {
		this.contactAddress = contactAddress;
	} 	
	/**
	 * 属性联系人/联系人的getter方法
	 */
	public String getLinkMan() {
		return linkMan;
	}
	/**
	 * 属性联系人/联系人的setter方法
	 */
	public void setLinkMan(String linkMan) {
		this.linkMan = linkMan;
	} 	
	/**
	 * 属性联系电话/联系电话的getter方法
	 */
	public String getContactNumber() {
		return contactNumber;
	}
	/**
	 * 属性联系电话/联系电话的setter方法
	 */
	public void setContactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
	}

	public String getLoanNo1() {
		return loanNo1;
	}

	public void setLoanNo1(String loanNo1) {
		this.loanNo1 = loanNo1;
	}

	public String getLoanNo2() {
		return loanNo2;
	}

	public void setLoanNo2(String loanNo2) {
		this.loanNo2 = loanNo2;
	}

	public String getInstallmentFlag() {
		return installmentFlag;
	}

	public void setInstallmentFlag(String installmentFlag) {
		this.installmentFlag = installmentFlag;
	}

	public String getLoanUsage() {
		return loanUsage;
	}

	public void setLoanUsage(String loanUsage) {
		this.loanUsage = loanUsage;
	}

	public Double getPerRepaidAmount() {
		return perRepaidAmount;
	}

	public void setPerRepaidAmount(Double perRepaidAmount) {
		this.perRepaidAmount = perRepaidAmount;
	}

	public String getAccReceiveAmount() {
		return accReceiveAmount;
	}

	public void setAccReceiveAmount(String accReceiveAmount) {
		this.accReceiveAmount = accReceiveAmount;
	}

	/**
	 * 属性回购日期/回购日期的getter方法
	 */
	public Date getRepurchaseDate() {
		return repurchaseDate;
	}
	/**
	 * 属性回购日期/回购日期的setter方法
	 */
	public void setRepurchaseDate(Date repurchaseDate) {
		this.repurchaseDate = repurchaseDate;
	} 	
	/**
	 * 属性保证金比例及额度/保证金比例及额度的getter方法
	 */
	public String getBondAmount() {
		return bondAmount;
	}
	/**
	 * 属性保证金比例及额度/保证金比例及额度的setter方法
	 */
	public void setBondAmount(String bondAmount) {
		this.bondAmount = bondAmount;
	} 	
	/**
	 * 属性有效资产低（质）押/有效资产低（质）押的getter方法
	 */
	public String getEffectiveProperty() {
		return effectiveProperty;
	}
	/**
	 * 属性有效资产低（质）押/有效资产低（质）押的setter方法
	 */
	public void setEffectiveProperty(String effectiveProperty) {
		this.effectiveProperty = effectiveProperty;
	} 	
}