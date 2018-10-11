package com.sinosoft.agriprpall.core.endorsemanage.commonendorse.entity;

import com.sinosoft.framework.core.dao.BaseEntityImpl;
import javax.persistence.*;
import java.util.Date;

/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-11-27 08:22:16.508 
 * PrpPdangerPlan实体操作对象
 */
@Entity
@Table(name = "PrpPdangerPlan")
@IdClass(PrpPdangerPlanKey.class)
public class PrpPdangerPlan extends BaseEntityImpl{

	private static final long serialVersionUID = 1L;
	/** 属性endorseNo/endorseNo */
	@Id
	@Column(name = "endorseNo")
	private String endorseNo ;/** 属性dangerNo/dangerNo */
	@Id
	@Column(name = "dangerNo")
	private Integer dangerNo ;/** 属性serialNo/serialNo */
	@Id
	@Column(name = "serialNo")
	private Integer serialNo ;



	/** 属性payNo/payNo */
	@Column(name = "payNo")
	private Integer payNo ;
	/** 属性planDate/planDate */
	@Column(name = "planDate")
	private Date planDate ;
	/** 属性currency/currency */
	@Column(name = "currency")
	private String currency ;
	/** 属性planFee/planFee */
	@Column(name = "planFee")
	private Double planFee ;
	/** 属性chgPlanFee/chgPlanFee */
	@Column(name = "chgPlanFee")
	private Double chgPlanFee ;
	/** 属性flag/flag */
	@Column(name = "flag")
	private String flag ;
	/**
	 * 属性endorseNo/endorseNo的getter方法
	 */
	public String getEndorseNo() {
		return endorseNo;
	}
	/**
	 * 属性endorseNo/endorseNo的setter方法
	 */
	public void setEndorseNo(String endorseNo) {
		this.endorseNo = endorseNo;
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
	public Date getPlanDate() {
		return planDate;
	}
	/**
	 * 属性planDate/planDate的setter方法
	 */
	public void setPlanDate(Date planDate) {
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
	 * 属性chgPlanFee/chgPlanFee的getter方法
	 */
	public Double getChgPlanFee() {
		return chgPlanFee;
	}
	/**
	 * 属性chgPlanFee/chgPlanFee的setter方法
	 */
	public void setChgPlanFee(Double chgPlanFee) {
		this.chgPlanFee = chgPlanFee;
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