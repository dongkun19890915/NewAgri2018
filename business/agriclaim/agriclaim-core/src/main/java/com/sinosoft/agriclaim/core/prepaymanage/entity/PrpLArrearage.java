package com.sinosoft.agriclaim.core.prepaymanage.entity;

import com.sinosoft.framework.core.dao.BaseEntityImpl;
import javax.persistence.*;
import java.util.Date;

/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-11-08 05:44:02.119 
 * 逾款欠款清单表实体操作对象
 */
@Entity
@Table(name = "PrpLArrearage")
@IdClass(PrpLArrearageKey.class)
public class PrpLArrearage extends BaseEntityImpl{

	private static final long serialVersionUID = 1L;
	/** 属性保单号/保单号 */
	@Id
	@Column(name = "policyNo")
	private String policyNo ;/** 属性本期应还款截止日期/本期应还款截止日期 */
	@Id
	@Column(name = "arrearageEndDate")
	private java.util.Date arrearageEndDate ;	
	/** 属性险种/险种 */
	@Column(name = "riskCode")
	private String riskCode ;

	/** 属性汽车经销商/汽车经销商 */
	@Column(name = "autoMobileDealer")
	private String autoMobileDealer ;
	/** 属性贷款金额/贷款金额 */
	@Column(name = "sumLoan")
	private java.lang.Double sumLoan ;
	/** 属性借款时间/借款时间 */
	@Column(name = "loanStartDate")
	private java.util.Date loanStartDate ;
	/** 属性借款期限/借款期限 */
	@Column(name = "loanTerm")
	private String loanTerm ;
	/** 属性已还款期数/已还款期数 */
	@Column(name = "sumRepaidTimes")
	private java.lang.Double sumRepaidTimes ;
	/** 属性已还款金额/已还款金额 */
	@Column(name = "sumRepaid")
	private java.lang.Double sumRepaid ;
	/** 属性贷款余额/贷款余额 */
	@Column(name = "sumNoRepaid")
	private java.lang.Double sumNoRepaid ;
	/** 属性欠款本金/欠款本金 */
	@Column(name = "arrearageCorpus")
	private java.lang.Double arrearageCorpus ;
	/** 属性逾期时间/逾期时间 */
	@Column(name = "arrearageDate")
	private java.util.Date arrearageDate ;
	/** 属性最近一次还款日期/最近一次还款日期 */
	@Column(name = "lastRepaidDate")
	private java.util.Date lastRepaidDate ;

	/** 属性逾期欠款期数/逾期欠款期数 */
	@Column(name = "arrearageTimes")
	private java.lang.Double arrearageTimes ;
	/** 属性逾期欠款金额/逾期欠款金额 */
	@Column(name = "sumArrearage")
	private java.lang.Double sumArrearage ;
	/** 属性逾期欠款原因/逾期欠款原因 */
	@Column(name = "arrearageReason")
	private String arrearageReason ;
	/** 属性抵押物/质押物/抵押物/质押物 */
	@Column(name = "guaranteeName")
	private String guaranteeName ;
	/** 属性保证人/保证人 */
	@Column(name = "cautioner")
	private String cautioner ;
	/** 属性保证金/保证金 */
	@Column(name = "cautionMoney")
	private java.lang.Double cautionMoney ;
	/** 属性催收措施/催收措施 */
	@Column(name = "dunstep")
	private String dunstep ;
	/** 属性报告单位意见/报告单位意见 */
	@Column(name = "reportunitProposal")
	private String reportunitProposal ;
	/** 属性经办人/经办人 */
	@Column(name = "handlerCode")
	private String handlerCode ;
	/** 属性经理/经理 */
	@Column(name = "manager")
	private String manager ;
	/** 属性登录时间/登录时间 */
	@Column(name = "inputDate")
	private java.util.Date inputDate ;
	/** 属性标志/标志 */
	@Column(name = "flag")
	private String flag ;
	/**
	 * 属性险种/险种的getter方法
	 */
	public String getRiskCode() {
		return riskCode;
	}
	/**
	 * 属性险种/险种的setter方法
	 */
	public void setRiskCode(String riskCode) {
		this.riskCode = riskCode;
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
	 * 属性汽车经销商/汽车经销商的getter方法
	 */
	public String getAutoMobileDealer() {
		return autoMobileDealer;
	}
	/**
	 * 属性汽车经销商/汽车经销商的setter方法
	 */
	public void setAutoMobileDealer(String autoMobileDealer) {
		this.autoMobileDealer = autoMobileDealer;
	} 	
	/**
	 * 属性贷款金额/贷款金额的getter方法
	 */
	public java.lang.Double getSumLoan() {
		return sumLoan;
	}
	/**
	 * 属性贷款金额/贷款金额的setter方法
	 */
	public void setSumLoan(java.lang.Double sumLoan) {
		this.sumLoan = sumLoan;
	} 	
	/**
	 * 属性借款时间/借款时间的getter方法
	 */
	public java.util.Date getLoanStartDate() {
		return loanStartDate;
	}
	/**
	 * 属性借款时间/借款时间的setter方法
	 */
	public void setLoanStartDate(java.util.Date loanStartDate) {
		this.loanStartDate = loanStartDate;
	} 	
	/**
	 * 属性借款期限/借款期限的getter方法
	 */
	public String getLoanTerm() {
		return loanTerm;
	}
	/**
	 * 属性借款期限/借款期限的setter方法
	 */
	public void setLoanTerm(String loanTerm) {
		this.loanTerm = loanTerm;
	} 	
	/**
	 * 属性已还款期数/已还款期数的getter方法
	 */
	public java.lang.Double getSumRepaidTimes() {
		return sumRepaidTimes;
	}
	/**
	 * 属性已还款期数/已还款期数的setter方法
	 */
	public void setSumRepaidTimes(java.lang.Double sumRepaidTimes) {
		this.sumRepaidTimes = sumRepaidTimes;
	} 	
	/**
	 * 属性已还款金额/已还款金额的getter方法
	 */
	public java.lang.Double getSumRepaid() {
		return sumRepaid;
	}
	/**
	 * 属性已还款金额/已还款金额的setter方法
	 */
	public void setSumRepaid(java.lang.Double sumRepaid) {
		this.sumRepaid = sumRepaid;
	} 	
	/**
	 * 属性贷款余额/贷款余额的getter方法
	 */
	public java.lang.Double getSumNoRepaid() {
		return sumNoRepaid;
	}
	/**
	 * 属性贷款余额/贷款余额的setter方法
	 */
	public void setSumNoRepaid(java.lang.Double sumNoRepaid) {
		this.sumNoRepaid = sumNoRepaid;
	} 	
	/**
	 * 属性欠款本金/欠款本金的getter方法
	 */
	public java.lang.Double getArrearageCorpus() {
		return arrearageCorpus;
	}
	/**
	 * 属性欠款本金/欠款本金的setter方法
	 */
	public void setArrearageCorpus(java.lang.Double arrearageCorpus) {
		this.arrearageCorpus = arrearageCorpus;
	} 	
	/**
	 * 属性逾期时间/逾期时间的getter方法
	 */
	public java.util.Date getArrearageDate() {
		return arrearageDate;
	}
	/**
	 * 属性逾期时间/逾期时间的setter方法
	 */
	public void setArrearageDate(java.util.Date arrearageDate) {
		this.arrearageDate = arrearageDate;
	} 	
	/**
	 * 属性最近一次还款日期/最近一次还款日期的getter方法
	 */
	public java.util.Date getLastRepaidDate() {
		return lastRepaidDate;
	}
	/**
	 * 属性最近一次还款日期/最近一次还款日期的setter方法
	 */
	public void setLastRepaidDate(java.util.Date lastRepaidDate) {
		this.lastRepaidDate = lastRepaidDate;
	} 	
	/**
	 * 属性本期应还款截止日期/本期应还款截止日期的getter方法
	 */
	public java.util.Date getArrearageEndDate() {
		return arrearageEndDate;
	}
	/**
	 * 属性本期应还款截止日期/本期应还款截止日期的setter方法
	 */
	public void setArrearageEndDate(java.util.Date arrearageEndDate) {
		this.arrearageEndDate = arrearageEndDate;
	} 	
	/**
	 * 属性逾期欠款期数/逾期欠款期数的getter方法
	 */
	public java.lang.Double getArrearageTimes() {
		return arrearageTimes;
	}
	/**
	 * 属性逾期欠款期数/逾期欠款期数的setter方法
	 */
	public void setArrearageTimes(java.lang.Double arrearageTimes) {
		this.arrearageTimes = arrearageTimes;
	} 	
	/**
	 * 属性逾期欠款金额/逾期欠款金额的getter方法
	 */
	public java.lang.Double getSumArrearage() {
		return sumArrearage;
	}
	/**
	 * 属性逾期欠款金额/逾期欠款金额的setter方法
	 */
	public void setSumArrearage(java.lang.Double sumArrearage) {
		this.sumArrearage = sumArrearage;
	} 	
	/**
	 * 属性逾期欠款原因/逾期欠款原因的getter方法
	 */
	public String getArrearageReason() {
		return arrearageReason;
	}
	/**
	 * 属性逾期欠款原因/逾期欠款原因的setter方法
	 */
	public void setArrearageReason(String arrearageReason) {
		this.arrearageReason = arrearageReason;
	} 	
	/**
	 * 属性抵押物/质押物/抵押物/质押物的getter方法
	 */
	public String getGuaranteeName() {
		return guaranteeName;
	}
	/**
	 * 属性抵押物/质押物/抵押物/质押物的setter方法
	 */
	public void setGuaranteeName(String guaranteeName) {
		this.guaranteeName = guaranteeName;
	} 	
	/**
	 * 属性保证人/保证人的getter方法
	 */
	public String getCautioner() {
		return cautioner;
	}
	/**
	 * 属性保证人/保证人的setter方法
	 */
	public void setCautioner(String cautioner) {
		this.cautioner = cautioner;
	} 	
	/**
	 * 属性保证金/保证金的getter方法
	 */
	public java.lang.Double getCautionMoney() {
		return cautionMoney;
	}
	/**
	 * 属性保证金/保证金的setter方法
	 */
	public void setCautionMoney(java.lang.Double cautionMoney) {
		this.cautionMoney = cautionMoney;
	} 	
	/**
	 * 属性催收措施/催收措施的getter方法
	 */
	public String getDunstep() {
		return dunstep;
	}
	/**
	 * 属性催收措施/催收措施的setter方法
	 */
	public void setDunstep(String dunstep) {
		this.dunstep = dunstep;
	} 	
	/**
	 * 属性报告单位意见/报告单位意见的getter方法
	 */
	public String getReportunitProposal() {
		return reportunitProposal;
	}
	/**
	 * 属性报告单位意见/报告单位意见的setter方法
	 */
	public void setReportunitProposal(String reportunitProposal) {
		this.reportunitProposal = reportunitProposal;
	} 	
	/**
	 * 属性经办人/经办人的getter方法
	 */
	public String getHandlerCode() {
		return handlerCode;
	}
	/**
	 * 属性经办人/经办人的setter方法
	 */
	public void setHandlerCode(String handlerCode) {
		this.handlerCode = handlerCode;
	} 	
	/**
	 * 属性经理/经理的getter方法
	 */
	public String getManager() {
		return manager;
	}
	/**
	 * 属性经理/经理的setter方法
	 */
	public void setManager(String manager) {
		this.manager = manager;
	} 	
	/**
	 * 属性登录时间/登录时间的getter方法
	 */
	public java.util.Date getInputDate() {
		return inputDate;
	}
	/**
	 * 属性登录时间/登录时间的setter方法
	 */
	public void setInputDate(java.util.Date inputDate) {
		this.inputDate = inputDate;
	} 	
	/**
	 * 属性标志/标志的getter方法
	 */
	public String getFlag() {
		return flag;
	}
	/**
	 * 属性标志/标志的setter方法
	 */
	public void setFlag(String flag) {
		this.flag = flag;
	} 	
}