package com.sinosoft.agriprpall.api.endorsemanage.dto;

import java.io.Serializable;

import com.sinosoft.framework.dto.BaseRequest;
/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-11-06 07:43:02.892 
 * 收费计划表Api操作对象
 */
public class PrpPplanCoinsDto extends BaseRequest implements Serializable{
	private static final long serialVersionUID = 1L;
	/** 属性批单号码/批单号码 */
	private String endorseNo ;		
	/** 属性保单号码/保单号码 */
	private String policyNo ;		
	/** 属性批单号码1/批单号码1 */
	private String endorseNo1 ;		
	/** 属性序号/序号 */
	private java.lang.Integer serialNo ;		
	/** 属性coinsCode/coinsCode */
	private String coinsCode ;		
	/** 属性缴费期次/缴费期次 */
	private java.lang.Integer payNo ;		
	/** 属性缴费原因/缴费原因 */
	private String payReason ;		
	/** 属性缴费计划截止原因/缴费计划截止原因 */
	private java.util.Date planDate ;		
	/** 属性币别/币别 */
	private String currency ;		
	/** 属性应缴费金额/应缴费金额 */
	private java.lang.Double planFee ;		
	/** 属性拖欠金额/拖欠金额 */
	private java.lang.Double delinquentFee ;		
	/** 属性标志字段/标志字段 */
	private String flag ;		
	/** 属性planStartDate/planStartDate */
	private java.util.Date planStartDate ;		
	/** 属性planRate/planRate */
	private java.lang.Double planRate ;		
	/** 属性不含税保费/不含税保费 */
	private java.lang.Double noTaxPremium ;		
	/** 属性税额/税额 */
	private java.lang.Double taxFee ;		
	/**
	 * 属性批单号码/批单号码的getter方法
	 */
	public String getEndorseNo() {
		return endorseNo;
	}
	/**
	 * 属性批单号码/批单号码的setter方法
	 */
	public void setEndorseNo(String endorseNo) {
		this.endorseNo = endorseNo;
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
	 * 属性批单号码1/批单号码1的getter方法
	 */
	public String getEndorseNo1() {
		return endorseNo1;
	}
	/**
	 * 属性批单号码1/批单号码1的setter方法
	 */
	public void setEndorseNo1(String endorseNo1) {
		this.endorseNo1 = endorseNo1;
	}	
	/**
	 * 属性序号/序号的getter方法
	 */
	public java.lang.Integer getSerialNo() {
		return serialNo;
	}
	/**
	 * 属性序号/序号的setter方法
	 */
	public void setSerialNo(java.lang.Integer serialNo) {
		this.serialNo = serialNo;
	}	
	/**
	 * 属性coinsCode/coinsCode的getter方法
	 */
	public String getCoinsCode() {
		return coinsCode;
	}
	/**
	 * 属性coinsCode/coinsCode的setter方法
	 */
	public void setCoinsCode(String coinsCode) {
		this.coinsCode = coinsCode;
	}	
	/**
	 * 属性缴费期次/缴费期次的getter方法
	 */
	public java.lang.Integer getPayNo() {
		return payNo;
	}
	/**
	 * 属性缴费期次/缴费期次的setter方法
	 */
	public void setPayNo(java.lang.Integer payNo) {
		this.payNo = payNo;
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
	/**
	 * 属性缴费计划截止原因/缴费计划截止原因的getter方法
	 */
	public java.util.Date getPlanDate() {
		return planDate;
	}
	/**
	 * 属性缴费计划截止原因/缴费计划截止原因的setter方法
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
	 * 属性应缴费金额/应缴费金额的getter方法
	 */
	public java.lang.Double getPlanFee() {
		return planFee;
	}
	/**
	 * 属性应缴费金额/应缴费金额的setter方法
	 */
	public void setPlanFee(java.lang.Double planFee) {
		this.planFee = planFee;
	}	
	/**
	 * 属性拖欠金额/拖欠金额的getter方法
	 */
	public java.lang.Double getDelinquentFee() {
		return delinquentFee;
	}
	/**
	 * 属性拖欠金额/拖欠金额的setter方法
	 */
	public void setDelinquentFee(java.lang.Double delinquentFee) {
		this.delinquentFee = delinquentFee;
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
	 * 属性planStartDate/planStartDate的getter方法
	 */
	public java.util.Date getPlanStartDate() {
		return planStartDate;
	}
	/**
	 * 属性planStartDate/planStartDate的setter方法
	 */
	public void setPlanStartDate(java.util.Date planStartDate) {
		this.planStartDate = planStartDate;
	}	
	/**
	 * 属性planRate/planRate的getter方法
	 */
	public java.lang.Double getPlanRate() {
		return planRate;
	}
	/**
	 * 属性planRate/planRate的setter方法
	 */
	public void setPlanRate(java.lang.Double planRate) {
		this.planRate = planRate;
	}	
	/**
	 * 属性不含税保费/不含税保费的getter方法
	 */
	public java.lang.Double getNoTaxPremium() {
		return noTaxPremium;
	}
	/**
	 * 属性不含税保费/不含税保费的setter方法
	 */
	public void setNoTaxPremium(java.lang.Double noTaxPremium) {
		this.noTaxPremium = noTaxPremium;
	}	
	/**
	 * 属性税额/税额的getter方法
	 */
	public java.lang.Double getTaxFee() {
		return taxFee;
	}
	/**
	 * 属性税额/税额的setter方法
	 */
	public void setTaxFee(java.lang.Double taxFee) {
		this.taxFee = taxFee;
	}	
}
