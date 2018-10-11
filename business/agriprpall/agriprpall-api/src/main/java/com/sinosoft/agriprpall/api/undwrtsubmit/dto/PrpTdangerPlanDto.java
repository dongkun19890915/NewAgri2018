package com.sinosoft.agriprpall.api.undwrtsubmit.dto;

import java.io.Serializable;

import com.sinosoft.framework.dto.BaseRequest;
/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-10-18 03:18:29.180 
 * PrpTdangerPlanApi操作对象
 */
public class PrpTdangerPlanDto extends BaseRequest implements Serializable{
	private static final long serialVersionUID = 1L;
	/** 属性proposalNo/proposalNo */
	private String proposalNo ;		
	/** 属性dangerNo/dangerNo */
	private Integer dangerNo ;
	/** 属性serialNo/serialNo */
	private Integer serialNo ;
	/** 属性payNo/payNo */
	private Integer payNo ;
	/** 属性planDate/planDate */
	private java.util.Date planDate ;		
	/** 属性currency/currency */
	private String currency ;		
	/** 属性planFee/planFee */
	private Double planFee ;
	/** 属性flag/flag */
	private String flag ;		
	/**
	 * 属性proposalNo/proposalNo的getter方法
	 */
	public String getProposalNo() {
		return proposalNo;
	}
	/**
	 * 属性proposalNo/proposalNo的setter方法
	 */
	public void setProposalNo(String proposalNo) {
		this.proposalNo = proposalNo;
	}	
	/**
	 * 属性dangerNo/dangerNo的getter方法
	 */
	public Integer getDangerNo() {
		return dangerNo;
	}
	/**
	 * 属性dangerNo/dangerNo的setter方法
	 */
	public void setDangerNo(Integer dangerNo) {
		this.dangerNo = dangerNo;
	}	
	/**
	 * 属性serialNo/serialNo的getter方法
	 */
	public Integer getSerialNo() {
		return serialNo;
	}
	/**
	 * 属性serialNo/serialNo的setter方法
	 */
	public void setSerialNo(Integer serialNo) {
		this.serialNo = serialNo;
	}	
	/**
	 * 属性payNo/payNo的getter方法
	 */
	public Integer getPayNo() {
		return payNo;
	}
	/**
	 * 属性payNo/payNo的setter方法
	 */
	public void setPayNo(Integer payNo) {
		this.payNo = payNo;
	}	
	/**
	 * 属性planDate/planDate的getter方法
	 */
	public java.util.Date getPlanDate() {
		return planDate;
	}
	/**
	 * 属性planDate/planDate的setter方法
	 */
	public void setPlanDate(java.util.Date planDate) {
		this.planDate = planDate;
	}	
	/**
	 * 属性currency/currency的getter方法
	 */
	public String getCurrency() {
		return currency;
	}
	/**
	 * 属性currency/currency的setter方法
	 */
	public void setCurrency(String currency) {
		this.currency = currency;
	}	
	/**
	 * 属性planFee/planFee的getter方法
	 */
	public Double getPlanFee() {
		return planFee;
	}
	/**
	 * 属性planFee/planFee的setter方法
	 */
	public void setPlanFee(Double planFee) {
		this.planFee = planFee;
	}	
	/**
	 * 属性flag/flag的getter方法
	 */
	public String getFlag() {
		return flag;
	}
	/**
	 * 属性flag/flag的setter方法
	 */
	public void setFlag(String flag) {
		this.flag = flag;
	}	
}
