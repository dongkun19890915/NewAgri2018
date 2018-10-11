package com.sinosoft.agriclaim.core.claimmanage.entity;

import com.sinosoft.framework.core.dao.BaseEntityImpl;
import javax.persistence.*;
import java.util.Date;

/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-11-08 05:39:53.061 
 * 估损金额表实体操作对象
 */
@Entity
@Table(name = "PrpLClaimFee")
@IdClass(PrpLClaimFeeKey.class)
public class PrpLClaimFee extends BaseEntityImpl{

	private static final long serialVersionUID = 1L;
	/** 属性立案号号/立案号号 */
	@Id
	@Column(name = "claimNo")
	private String claimNo ;/** 属性币别代码/币别代码 */
	@Id
	@Column(name = "currency")
	private String currency ;	

	/** 属性险种代码/险种代码 */
	@Column(name = "riskCode")
	private String riskCode ;

	/** 属性索赔金额/索赔金额 */
	@Column(name = "sumClaim")
	private java.lang.Double sumClaim ;
	/** 属性标志字段/标志字段 */
	@Column(name = "flag")
	private String flag ;
	/**
	 * 属性立案号号/立案号号的getter方法
	 */
	public String getClaimNo() {
		return claimNo;
	}
	/**
	 * 属性立案号号/立案号号的setter方法
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
	 * 属性币别代码/币别代码的getter方法
	 */
	public String getCurrency() {
		return currency;
	}
	/**
	 * 属性币别代码/币别代码的setter方法
	 */
	public void setCurrency(String currency) {
		this.currency = currency;
	} 	
	/**
	 * 属性索赔金额/索赔金额的getter方法
	 */
	public java.lang.Double getSumClaim() {
		return sumClaim;
	}
	/**
	 * 属性索赔金额/索赔金额的setter方法
	 */
	public void setSumClaim(java.lang.Double sumClaim) {
		this.sumClaim = sumClaim;
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
}