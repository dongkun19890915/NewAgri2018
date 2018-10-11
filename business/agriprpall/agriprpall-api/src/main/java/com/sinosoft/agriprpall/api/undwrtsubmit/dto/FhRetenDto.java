package com.sinosoft.agriprpall.api.undwrtsubmit.dto;

import java.io.Serializable;

import com.sinosoft.framework.dto.BaseRequest;
/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-10-18 07:50:17.079 
 * 自留额计划表Api操作对象
 */
public class FhRetenDto extends BaseRequest implements Serializable{
	private static final long serialVersionUID = 1L;
	/** 属性业务年度/业务年度 */
	private String uwyear ;		
	/** 属性险种/险种 */
	private String riskCode ;		
	/** 属性风险等级/风险等级 */
	private String riskLevel ;		
	/** 属性风险等级描述/风险等级描述 */
	private String riskLevelDesc ;		
	/** 属性风险类别/风险类别 */
	private String riskClass ;		
	/** 属性风险类别描述/风险类别描述 */
	private String riskClassDesc ;		
	/** 属性评分级别/评分级别 */
	private String grade ;		
	/** 属性币种/币种 */
	private String currency ;		
	/** 属性自留额/自留额 */
	private Double retentionValue ;
	/** 属性起始日期/起始日期 */
	private java.util.Date startDate ;		
	/** 属性终止日期/终止日期 */
	private java.util.Date endDate ;		
	/** 属性备注/备注 */
	private String remarks ;		
	/** 属性自留标识/自留标识 */
	private String retenFlag ;		
	/** 属性标识 /标识  */
	private String flag ;		
	/** 属性retentionrate/retentionrate */
	private Double retentionrate ;
	/** 属性business/business */
	private String business ;		
	/** 属性businessDesc/businessDesc */
	private String businessDesc ;		
	/** 属性limitretentionValue/limitretentionValue */
	private Double limitretentionValue ;
	/** 属性businessType/businessType */
	private String businessType ;		
	/**
	 * 属性业务年度/业务年度的getter方法
	 */
	public String getUwyear() {
		return uwyear;
	}
	/**
	 * 属性业务年度/业务年度的setter方法
	 */
	public void setUwyear(String uwyear) {
		this.uwyear = uwyear;
	}	
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
	 * 属性风险等级/风险等级的getter方法
	 */
	public String getRiskLevel() {
		return riskLevel;
	}
	/**
	 * 属性风险等级/风险等级的setter方法
	 */
	public void setRiskLevel(String riskLevel) {
		this.riskLevel = riskLevel;
	}	
	/**
	 * 属性风险等级描述/风险等级描述的getter方法
	 */
	public String getRiskLevelDesc() {
		return riskLevelDesc;
	}
	/**
	 * 属性风险等级描述/风险等级描述的setter方法
	 */
	public void setRiskLevelDesc(String riskLevelDesc) {
		this.riskLevelDesc = riskLevelDesc;
	}	
	/**
	 * 属性风险类别/风险类别的getter方法
	 */
	public String getRiskClass() {
		return riskClass;
	}
	/**
	 * 属性风险类别/风险类别的setter方法
	 */
	public void setRiskClass(String riskClass) {
		this.riskClass = riskClass;
	}	
	/**
	 * 属性风险类别描述/风险类别描述的getter方法
	 */
	public String getRiskClassDesc() {
		return riskClassDesc;
	}
	/**
	 * 属性风险类别描述/风险类别描述的setter方法
	 */
	public void setRiskClassDesc(String riskClassDesc) {
		this.riskClassDesc = riskClassDesc;
	}	
	/**
	 * 属性评分级别/评分级别的getter方法
	 */
	public String getGrade() {
		return grade;
	}
	/**
	 * 属性评分级别/评分级别的setter方法
	 */
	public void setGrade(String grade) {
		this.grade = grade;
	}	
	/**
	 * 属性币种/币种的getter方法
	 */
	public String getCurrency() {
		return currency;
	}
	/**
	 * 属性币种/币种的setter方法
	 */
	public void setCurrency(String currency) {
		this.currency = currency;
	}	
	/**
	 * 属性自留额/自留额的getter方法
	 */
	public Double getRetentionValue() {
		return retentionValue;
	}
	/**
	 * 属性自留额/自留额的setter方法
	 */
	public void setRetentionValue(Double retentionValue) {
		this.retentionValue = retentionValue;
	}	
	/**
	 * 属性起始日期/起始日期的getter方法
	 */
	public java.util.Date getStartDate() {
		return startDate;
	}
	/**
	 * 属性起始日期/起始日期的setter方法
	 */
	public void setStartDate(java.util.Date startDate) {
		this.startDate = startDate;
	}	
	/**
	 * 属性终止日期/终止日期的getter方法
	 */
	public java.util.Date getEndDate() {
		return endDate;
	}
	/**
	 * 属性终止日期/终止日期的setter方法
	 */
	public void setEndDate(java.util.Date endDate) {
		this.endDate = endDate;
	}	
	/**
	 * 属性备注/备注的getter方法
	 */
	public String getRemarks() {
		return remarks;
	}
	/**
	 * 属性备注/备注的setter方法
	 */
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}	
	/**
	 * 属性自留标识/自留标识的getter方法
	 */
	public String getRetenFlag() {
		return retenFlag;
	}
	/**
	 * 属性自留标识/自留标识的setter方法
	 */
	public void setRetenFlag(String retenFlag) {
		this.retenFlag = retenFlag;
	}	
	/**
	 * 属性标识 /标识 的getter方法
	 */
	public String getFlag() {
		return flag;
	}
	/**
	 * 属性标识 /标识 的setter方法
	 */
	public void setFlag(String flag) {
		this.flag = flag;
	}	
	/**
	 * 属性retentionrate/retentionrate的getter方法
	 */
	public Double getRetentionrate() {
		return retentionrate;
	}
	/**
	 * 属性retentionrate/retentionrate的setter方法
	 */
	public void setRetentionrate(Double retentionrate) {
		this.retentionrate = retentionrate;
	}	
	/**
	 * 属性business/business的getter方法
	 */
	public String getBusiness() {
		return business;
	}
	/**
	 * 属性business/business的setter方法
	 */
	public void setBusiness(String business) {
		this.business = business;
	}	
	/**
	 * 属性businessDesc/businessDesc的getter方法
	 */
	public String getBusinessDesc() {
		return businessDesc;
	}
	/**
	 * 属性businessDesc/businessDesc的setter方法
	 */
	public void setBusinessDesc(String businessDesc) {
		this.businessDesc = businessDesc;
	}	
	/**
	 * 属性limitretentionValue/limitretentionValue的getter方法
	 */
	public Double getLimitretentionValue() {
		return limitretentionValue;
	}
	/**
	 * 属性limitretentionValue/limitretentionValue的setter方法
	 */
	public void setLimitretentionValue(Double limitretentionValue) {
		this.limitretentionValue = limitretentionValue;
	}	
	/**
	 * 属性businessType/businessType的getter方法
	 */
	public String getBusinessType() {
		return businessType;
	}
	/**
	 * 属性businessType/businessType的setter方法
	 */
	public void setBusinessType(String businessType) {
		this.businessType = businessType;
	}	
}
