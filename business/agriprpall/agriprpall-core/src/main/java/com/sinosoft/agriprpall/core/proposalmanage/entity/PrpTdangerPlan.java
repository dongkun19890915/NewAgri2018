package com.sinosoft.agriprpall.core.proposalmanage.entity;

import com.sinosoft.framework.core.dao.BaseEntityImpl;
import javax.persistence.*;
import java.util.Date;

/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-11-04 09:41:15.792 
 * PrpTdangerPlan实体操作对象
 */
@Entity
@Table(name = "PrpTdangerPlan")
@IdClass(PrpTdangerPlanKey.class)
public class PrpTdangerPlan extends BaseEntityImpl{

	private static final long serialVersionUID = 1L;
	/** 属性保单号码/保单号码 */
	@Id
	@Column(name = "proposalNo")
	private String proposalNo ;/** 属性危险单位序号/危险单位序号 */
	@Id
	@Column(name = "dangerNo")
	private java.lang.Integer dangerNo ;/** 属性交费次序号/交费次序号 */
	@Id
	@Column(name = "serialNo")
	private java.lang.Integer serialNo ;	



	/** 属性交费期次/交费期次 */
	@Column(name = "payNo")
	private java.lang.Integer payNo ;
	/** 属性计划交费起始日期/计划交费起始日期 */
	@Column(name = "planDate")
	private java.util.Date planDate ;
	/** 属性币别/币别 */
	@Column(name = "currency")
	private String currency ;
	/** 属性应交费金额/应交费金额 */
	@Column(name = "planFee")
	private java.lang.Double planFee ;
	/** 属性标志字段/标志字段 */
	@Column(name = "flag")
	private String flag ;
	/**
	 * 属性保单号码/保单号码的getter方法
	 */
	public String getProposalNo() {
		return proposalNo;
	}
	/**
	 * 属性保单号码/保单号码的setter方法
	 */
	public void setProposalNo(String proposalNo) {
		this.proposalNo = proposalNo;
	} 	
	/**
	 * 属性危险单位序号/危险单位序号的getter方法
	 */
	public java.lang.Integer getDangerNo() {
		return dangerNo;
	}
	/**
	 * 属性危险单位序号/危险单位序号的setter方法
	 */
	public void setDangerNo(java.lang.Integer dangerNo) {
		this.dangerNo = dangerNo;
	} 	
	/**
	 * 属性交费次序号/交费次序号的getter方法
	 */
	public java.lang.Integer getSerialNo() {
		return serialNo;
	}
	/**
	 * 属性交费次序号/交费次序号的setter方法
	 */
	public void setSerialNo(java.lang.Integer serialNo) {
		this.serialNo = serialNo;
	} 	
	/**
	 * 属性交费期次/交费期次的getter方法
	 */
	public java.lang.Integer getPayNo() {
		return payNo;
	}
	/**
	 * 属性交费期次/交费期次的setter方法
	 */
	public void setPayNo(java.lang.Integer payNo) {
		this.payNo = payNo;
	} 	
	/**
	 * 属性计划交费起始日期/计划交费起始日期的getter方法
	 */
	public java.util.Date getPlanDate() {
		return planDate;
	}
	/**
	 * 属性计划交费起始日期/计划交费起始日期的setter方法
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
	 * 属性应交费金额/应交费金额的getter方法
	 */
	public java.lang.Double getPlanFee() {
		return planFee;
	}
	/**
	 * 属性应交费金额/应交费金额的setter方法
	 */
	public void setPlanFee(java.lang.Double planFee) {
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
}