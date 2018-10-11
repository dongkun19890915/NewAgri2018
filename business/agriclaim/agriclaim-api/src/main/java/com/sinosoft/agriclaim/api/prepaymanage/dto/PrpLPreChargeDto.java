package com.sinosoft.agriclaim.api.prepaymanage.dto;

import java.io.Serializable;

import com.sinosoft.framework.dto.BaseRequest;
/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-11-08 05:44:02.119 
 * 预赔费用信息表Api操作对象
 */
public class PrpLPreChargeDto extends BaseRequest implements Serializable{
	private static final long serialVersionUID = 1L;
//	/** 属性id主键/id主键 */
//	private java.lang.Integer id ;
	/** 属性预赔登记号/预赔登记号 */
	private String precompensateNo ;		
	/** 属性序号/序号 */
	private java.lang.Integer serialNo ;		
	/** 属性立案号/立案号 */
	private String claimNo ;		
	/** 属性险种代码/险种代码 */
	private String riskCode ;		
	/** 属性保单号/保单号 */
	private String policyNo ;		
	/** 属性险别代码/险别代码 */
	private String kindCode ;		
	/** 属性费用类别代码/费用类别代码 */
	private String chargeCode ;		
	/** 属性费用名称/费用名称 */
	private String chargeName ;		
	/** 属性币别/币别 */
	private String currency ;		
	/** 属性预赔金额/预赔金额 */
	private java.lang.Double sumprePaid ;		
	/** 属性修改人/修改人 */
	private String updateBy ;		
	/** 属性修改时间/修改时间 */
	private java.util.Date updateDate ;		
//	/**
//	 * 属性id主键/id主键的getter方法
//	 */
//	public java.lang.Integer getId() {
//		return id;
//	}
//	/**
//	 * 属性id主键/id主键的setter方法
//	 */
//	public void setId(java.lang.Integer id) {
//		this.id = id;
//	}
	/**
	 * 属性预赔登记号/预赔登记号的getter方法
	 */
	public String getPrecompensateNo() {
		return precompensateNo;
	}
	/**
	 * 属性预赔登记号/预赔登记号的setter方法
	 */
	public void setPrecompensateNo(String precompensateNo) {
		this.precompensateNo = precompensateNo;
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
	 * 属性险别代码/险别代码的getter方法
	 */
	public String getKindCode() {
		return kindCode;
	}
	/**
	 * 属性险别代码/险别代码的setter方法
	 */
	public void setKindCode(String kindCode) {
		this.kindCode = kindCode;
	}	
	/**
	 * 属性费用类别代码/费用类别代码的getter方法
	 */
	public String getChargeCode() {
		return chargeCode;
	}
	/**
	 * 属性费用类别代码/费用类别代码的setter方法
	 */
	public void setChargeCode(String chargeCode) {
		this.chargeCode = chargeCode;
	}	
	/**
	 * 属性费用名称/费用名称的getter方法
	 */
	public String getChargeName() {
		return chargeName;
	}
	/**
	 * 属性费用名称/费用名称的setter方法
	 */
	public void setChargeName(String chargeName) {
		this.chargeName = chargeName;
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
	 * 属性预赔金额/预赔金额的getter方法
	 */
	public java.lang.Double getSumprePaid() {
		return sumprePaid;
	}
	/**
	 * 属性预赔金额/预赔金额的setter方法
	 */
	public void setSumprePaid(java.lang.Double sumprePaid) {
		this.sumprePaid = sumprePaid;
	}	
	/**
	 * 属性修改人/修改人的getter方法
	 */
	public String getUpdateBy() {
		return updateBy;
	}
	/**
	 * 属性修改人/修改人的setter方法
	 */
	public void setUpdateBy(String updateBy) {
		this.updateBy = updateBy;
	}	
	/**
	 * 属性修改时间/修改时间的getter方法
	 */
	public java.util.Date getUpdateDate() {
		return updateDate;
	}
	/**
	 * 属性修改时间/修改时间的setter方法
	 */
	public void setUpdateDate(java.util.Date updateDate) {
		this.updateDate = updateDate;
	}	
}
