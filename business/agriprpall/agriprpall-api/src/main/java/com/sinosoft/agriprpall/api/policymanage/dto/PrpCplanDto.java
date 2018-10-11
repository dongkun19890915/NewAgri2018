package com.sinosoft.agriprpall.api.policymanage.dto;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.sinosoft.framework.dto.BaseRequest;

import java.io.Serializable;
/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-10-24 07:46:04.010 
 * 收费计划表Api操作对象
 */
public class PrpCplanDto extends BaseRequest implements Serializable{
	private static final long serialVersionUID = 1L;
	/** 属性保单号码 /保单号码  */
	private String policyNo ;		
	/** 属性批单号码/批单号码 */
	private String endorseNo ;		
	/** 属性交费次数序号/交费次数序号 */
	private Integer serialNo ;
	/** 属性交费期次/交费期次 */
	private Integer payNo ;
	/** 属性交费原因（同收付费系统定义） /交费原因（同收付费系统定义）  */
	private String payReason ;		
	/** 属性计划交费截止日期/计划交费截止日期 */
	@JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
	private java.util.Date planDate ;		
	/** 属性币别 /币别  */
	private String currency ;		
	/** 属性应交费金额/应交费金额 */
	@JSONField(format = "#.00")
	private Double planFee ;
	/** 属性拖欠金额/拖欠金额 */
	@JSONField(format = "#.00")
	private Double delinquentFee ;
	/** 属性标志字段/标志字段 */
	private String flag ="";
	/** 属性planStartDate/planStartDate */
	@JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
	private java.util.Date planStartDate ;		
	/** 属性planRate/planRate */
	private Double planRate ;
	/** 属性currency2/currency2 */
	private String currency2 ;		
	/** 属性planfee2/planFee2 */
	private Double planFee2 ;
	/** 属性exchangeRateCny/exchangeRateCny */
	private Double exchangeRateCNY ;
	/** 属性修改人/修改人 */
	private String update_By ;
	/** 属性修改时间/修改时间 */
	@JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
	private java.util.Date update_Date ;
	/** 属性总不含税保费/总不含税保费 */
	private Double noTaxPremium ;
	/** 属性总税额/总税额 */
	private Double taxFee ;
	/**添加币别名称转换 add by 王心洋 20171031*/
	private String planCurrencyName;

	private String payReasonName;

	private Double payRefFee;

	public Double getPayRefFee() {
		return payRefFee;
	}

	public void setPayRefFee(Double payRefFee) {
		this.payRefFee = payRefFee;
	}

	public String getPayReasonName() {
		return payReasonName;
	}

	public void setPayReasonName(String payReasonName) {
		this.payReasonName = payReasonName;
	}

	public String getPlanCurrencyName() {
		return planCurrencyName;
	}

	public void setPlanCurrencyName(String planCurrencyName) {
		this.planCurrencyName = planCurrencyName;
	}

	/**
	 * 属性保单号码 /保单号码 的getter方法
	 */
	public String getPolicyNo() {
		return policyNo;
	}
	/**
	 * 属性保单号码 /保单号码 的setter方法
	 */
	public void setPolicyNo(String policyNo) {
		this.policyNo = policyNo;
	}	
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
	 * 属性交费次数序号/交费次数序号的getter方法
	 */
	public Integer getSerialNo() {
		return serialNo;
	}
	/**
	 * 属性交费次数序号/交费次数序号的setter方法
	 */
	public void setSerialNo(Integer serialNo) {
		this.serialNo = serialNo;
	}	
	/**
	 * 属性交费期次/交费期次的getter方法
	 */
	public Integer getPayNo() {
		return payNo;
	}
	/**
	 * 属性交费期次/交费期次的setter方法
	 */
	public void setPayNo(Integer payNo) {
		this.payNo = payNo;
	}	
	/**
	 * 属性交费原因（同收付费系统定义） /交费原因（同收付费系统定义） 的getter方法
	 */
	public String getPayReason() {
		return payReason;
	}
	/**
	 * 属性交费原因（同收付费系统定义） /交费原因（同收付费系统定义） 的setter方法
	 */
	public void setPayReason(String payReason) {
		this.payReason = payReason;
	}	
	/**
	 * 属性计划交费截止日期/计划交费截止日期的getter方法
	 */
	public java.util.Date getPlanDate() {
		return planDate;
	}
	/**
	 * 属性计划交费截止日期/计划交费截止日期的setter方法
	 */
	public void setPlanDate(java.util.Date planDate) {
		this.planDate = planDate;
	}	
	/**
	 * 属性币别 /币别 的getter方法
	 */
	public String getCurrency() {
		return currency;
	}
	/**
	 * 属性币别 /币别 的setter方法
	 */
	public void setCurrency(String currency) {
		this.currency = currency;
	}	
	/**
	 * 属性应交费金额/应交费金额的getter方法
	 */
	public Double getPlanFee() {
		return planFee;
	}
	/**
	 * 属性应交费金额/应交费金额的setter方法
	 */
	public void setPlanFee(Double planFee) {
		this.planFee = planFee;
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
	public Double getPlanRate() {
		return planRate;
	}
	/**
	 * 属性planRate/planRate的setter方法
	 */
	public void setPlanRate(Double planRate) {
		this.planRate = planRate;
	}	
	/**
	 * 属性currency2/currency2的getter方法
	 */
	public String getCurrency2() {
		return currency2;
	}
	/**
	 * 属性currency2/currency2的setter方法
	 */
	public void setCurrency2(String currency2) {
		this.currency2 = currency2;
	}	
	/**
	 * 属性planfee2/planfee2的getter方法
	 */
	public Double getPlanfee2() {
		return planFee2;
	}
	/**
	 * 属性planfee2/planfee2的setter方法
	 */
	public void setPlanfee2(Double planFee2) {
		this.planFee2 = planFee2;
	}	

	/**
	 * 属性修改人/修改人的getter方法
	 */
	public String getUpdate_By() {
		return update_By;
	}
	/**
	 * 属性修改人/修改人的setter方法
	 */
	public void setUpdate_By(String update_By) {
		this.update_By = update_By;
	}	
	/**
	 * 属性修改时间/修改时间的getter方法
	 */
	public java.util.Date getUpdate_Date() {
		return update_Date;
	}
	/**
	 * 属性修改时间/修改时间的setter方法
	 */
	public void setUpdate_Date(java.util.Date update_Date) {
		this.update_Date = update_Date;
	}

	public Double getDelinquentFee() {
		return delinquentFee;
	}

	public void setDelinquentFee(Double delinquentFee) {
		this.delinquentFee = delinquentFee;
	}

	public Double getPlanFee2() {
		return planFee2;
	}

	public void setPlanFee2(Double planFee2) {
		this.planFee2 = planFee2;
	}

	public Double getExchangeRateCNY() {
		return exchangeRateCNY;
	}

	public void setExchangeRateCNY(Double exchangeRateCNY) {
		this.exchangeRateCNY = exchangeRateCNY;
	}

	public Double getNoTaxPremium() {
		return noTaxPremium;
	}

	public void setNoTaxPremium(Double noTaxPremium) {
		this.noTaxPremium = noTaxPremium;
	}

	/**
	 * 属性总税额/总税额的getter方法
	 */
	public Double getTaxFee() {
		return taxFee;
	}
	/**
	 * 属性总税额/总税额的setter方法
	 */
	public void setTaxFee(Double taxFee) {
		this.taxFee = taxFee;
	}
}
