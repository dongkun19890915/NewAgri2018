package com.sinosoft.agriclaim.core.compensatemanage.entity;

import com.sinosoft.framework.core.dao.BaseEntityImpl;
import javax.persistence.*;
import java.util.Date;

/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-11-08 05:40:44.225 
 * 赔款计算金额表实体操作对象
 */
@Entity
@Table(name = "PrpLCFee")
@IdClass(PrpLCFeeKey.class)
public class PrpLCFee extends BaseEntityImpl{

	private static final long serialVersionUID = 1L;
	/** 属性赔款计算书号/赔款计算书号 */
	@Id
	@Column(name = "compensateNo")
	private String compensateNo ;/** 属性保单号/保单号 */
	@Id
	@Column(name = "policyNo")
	private String policyNo ;/** 属性币别代码/币别代码 */
	@Id
	@Column(name = "currency")
	private String currency ;	

	/** 属性险种代码/险种代码 */
	@Column(name = "riskCode")
	private String riskCode ;


	/** 属性赔付金额/赔付金额 */
	@Column(name = "sumPaid")
	private java.lang.Double sumPaid ;
	/** 属性标志字段/标志字段 */
	@Column(name = "flag")
	private String flag ;
	/**
	 * 属性赔款计算书号/赔款计算书号的getter方法
	 */
	public String getCompensateNo() {
		return compensateNo;
	}
	/**
	 * 属性赔款计算书号/赔款计算书号的setter方法
	 */
	public void setCompensateNo(String compensateNo) {
		this.compensateNo = compensateNo;
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
	 * 属性赔付金额/赔付金额的getter方法
	 */
	public java.lang.Double getSumPaid() {
		return sumPaid;
	}
	/**
	 * 属性赔付金额/赔付金额的setter方法
	 */
	public void setSumPaid(java.lang.Double sumPaid) {
		this.sumPaid = sumPaid;
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