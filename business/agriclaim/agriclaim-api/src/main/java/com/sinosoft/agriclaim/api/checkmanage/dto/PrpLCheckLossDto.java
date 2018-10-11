package com.sinosoft.agriclaim.api.checkmanage.dto;

import java.io.Serializable;

import com.sinosoft.framework.dto.BaseRequest;
/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-11-08 05:38:49.324 
 * 查勘事故估损金额表Api操作对象
 */
public class PrpLCheckLossDto extends BaseRequest implements Serializable{
	private static final long serialVersionUID = 1L;
	/** 属性出险登记号/出险登记号 */
	private String registNo ;		
	/** 属性立案号码/立案号码 */
	private String claimNo ;		
	/** 属性险种代码/险种代码 */
	private String riskCode ;		
	/** 属性保单号码/保单号码 */
	private String policyNo ;		
	/** 属性序号/序号 */
	private java.lang.Integer serialNo ;		
	/** 属性关联理赔车辆序号/关联理赔车辆序号 */
	private java.lang.Integer referserialNo ;		
	/** 属性险别编码/险别编码 */
	private String kindCode ;		
	/** 属性金额类型/金额类型 */
	private String lossFeeType ;		
	/** 属性损失金额/损失金额 */
	private java.lang.Double lossFee ;		
	/** 属性标志位/标志位 */
	private String flag ;		
	/** 属性修改人/修改人 */
	private String updateBy ;		
	/** 属性修改时间/修改时间 */
	private java.util.Date updateDate ;		
	/**
	 * 属性出险登记号/出险登记号的getter方法
	 */
	public String getRegistNo() {
		return registNo;
	}
	/**
	 * 属性出险登记号/出险登记号的setter方法
	 */
	public void setRegistNo(String registNo) {
		this.registNo = registNo;
	}	
	/**
	 * 属性立案号码/立案号码的getter方法
	 */
	public String getClaimNo() {
		return claimNo;
	}
	/**
	 * 属性立案号码/立案号码的setter方法
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
	 * 属性关联理赔车辆序号/关联理赔车辆序号的getter方法
	 */
	public java.lang.Integer getReferserialNo() {
		return referserialNo;
	}
	/**
	 * 属性关联理赔车辆序号/关联理赔车辆序号的setter方法
	 */
	public void setReferserialNo(java.lang.Integer referserialNo) {
		this.referserialNo = referserialNo;
	}	
	/**
	 * 属性险别编码/险别编码的getter方法
	 */
	public String getKindCode() {
		return kindCode;
	}
	/**
	 * 属性险别编码/险别编码的setter方法
	 */
	public void setKindCode(String kindCode) {
		this.kindCode = kindCode;
	}	
	/**
	 * 属性金额类型/金额类型的getter方法
	 */
	public String getLossFeeType() {
		return lossFeeType;
	}
	/**
	 * 属性金额类型/金额类型的setter方法
	 */
	public void setLossFeeType(String lossFeeType) {
		this.lossFeeType = lossFeeType;
	}	
	/**
	 * 属性损失金额/损失金额的getter方法
	 */
	public java.lang.Double getLossFee() {
		return lossFee;
	}
	/**
	 * 属性损失金额/损失金额的setter方法
	 */
	public void setLossFee(java.lang.Double lossFee) {
		this.lossFee = lossFee;
	}	
	/**
	 * 属性标志位/标志位的getter方法
	 */
	public String getFlag() {
		return flag;
	}
	/**
	 * 属性标志位/标志位的setter方法
	 */
	public void setFlag(String flag) {
		this.flag = flag;
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
