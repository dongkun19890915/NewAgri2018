package com.sinosoft.agriprpall.api.proposalmanage.dto;

import com.sinosoft.framework.dto.BaseRequest;

import java.io.Serializable;
import java.util.Date;

/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-10-18 13:10:01.639 
 * 缴费计划Api操作对象
 */
public class QueryProposalPrpTplanDto extends BaseRequest implements Serializable{
	private static final long serialVersionUID = 1L;
	/** 属性缴费原因/缴费原因 */
	private String payReason;
	/** 属性缴费起期/缴费起期 */
	private java.util.Date planStartDate ;
	/** 属性缴费止期/缴费止期 */
	private java.util.Date planDate ;
	/** 属性币别/币别 */
	private String currency ;		
	/** 属性应缴金额/应缴金额 */
	private Double planFee ;
	/** 属性实缴金额/实缴金额 */
	private Double payreFee ;

	private Integer payNo ;

	private String payReasonName ;

	public Integer getPayNo() {
		return payNo;
	}

	public void setPayNo(Integer payNo) {
		this.payNo = payNo;
	}

	public String getPayReasonName() {
		return payReasonName;
	}

	public void setPayReasonName(String payReasonName) {
		this.payReasonName = payReasonName;
	}

	/**
	 * 属性缴费原因/缴费原因的getter方法
	 */
	public String getPayReason() {
		return payReason;
	}
	/**
	 * 属性缴费原因/缴费原因的setter方法
	 */
	public void setPayReason(String payReason) {
		this.payReason = payReason;
	}

	public Date getPlanStartDate() {
		return planStartDate;
	}

	public void setPlanStartDate(Date planStartDate) {
		this.planStartDate = planStartDate;
	}

	/**
	 * 属性缴费止期/缴费止期的getter方法
	 */
	public java.util.Date getPlanDate() {
		return planDate;
	}
	/**
	 * 属性缴费止期/缴费止期的setter方法
	 */
	public void setPlanDate(java.util.Date planDate) {
		this.planDate = planDate;
	}	
	/**
	 * 属性币别/币别的getter方法
	 */
	public String getCurrency() {
		return currency;
	}
	/**
	 * 属性币别/币别的setter方法
	 */
	public void setCurrency(String currency) {
		this.currency = currency;
	}	
	/**
	 * 属性应缴金额/应缴金额的getter方法
	 */
	public Double getPlanFee() {
		return planFee;
	}
	/**
	 * 属性应缴金额/应缴金额的setter方法
	 */
	public void setPlanFee(Double planFee) {
		this.planFee = planFee;
	}	
	/**
	 * 属性实缴金额/实缴金额的getter方法
	 */
	public Double getPayreFee() {
		return payreFee;
	}
	/**
	 * 属性实缴金额/实缴金额的setter方法
	 */
	public void setPayreFee(Double payreFee) {
		this.payreFee = payreFee;
	}	

}
