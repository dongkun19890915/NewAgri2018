package com.sinosoft.agriprpall.core.endorsemanage.commonendorse.entity;
import com.sinosoft.framework.core.dao.BaseEntityImpl;

import javax.persistence.*;
import java.util.Date;

/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-11-04 10:07:09.217 
 * PrpCPdangerPlan实体操作对象
 */
@Entity
@Table(name = "PrpCPdangerPlan")
@IdClass(PrpCPdangerPlanKey.class)
public class PrpCPdangerPlan extends BaseEntityImpl{

	private static final long serialVersionUID = 1L;
	/** 属性endorseNo/endorseNo */
	@Id
	@Column(name = "endorseNo")
	private String endorseNo ;/** 属性危险单位序号/危险单位序号 */
	@Id
	@Column(name = "dangerNo")
	private Integer dangerNo ;/** 属性交费次序号/交费次序号 */
	@Id
	@Column(name = "serialNo")
	private Integer serialNo ;



	/** 属性交费期次/交费期次 */
	@Column(name = "payNo")
	private Integer payNo ;
	/** 属性计划交费起始日期/计划交费起始日期 */
	@Column(name = "planDate")
	private Date planDate ;
	/** 属性币别/币别 */
	@Column(name = "currency")
	private String currency ;
	/** 属性应交费金额/应交费金额 */
	@Column(name = "planFee")
	private Double planFee ;
	/** 属性chgPlanFee/chgPlanFee */
	@Column(name = "chgPlanFee")
	private Double chgPlanFee ;
	/** 属性标志字段/标志字段 */
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
	 * 属性危险单位序号/危险单位序号的getter方法
	 */
	public Integer getDangerNo() {
		return dangerNo;
	}
	/**
	 * 属性危险单位序号/危险单位序号的setter方法
	 */
	public void setDangerNo(Integer dangerNo) {
		this.dangerNo = dangerNo;
	} 	
	/**
	 * 属性交费次序号/交费次序号的getter方法
	 */
	public Integer getSerialNo() {
		return serialNo;
	}
	/**
	 * 属性交费次序号/交费次序号的setter方法
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
	 * 属性计划交费起始日期/计划交费起始日期的getter方法
	 */
	public Date getPlanDate() {
		return planDate;
	}
	/**
	 * 属性计划交费起始日期/计划交费起始日期的setter方法
	 */
	public void setPlanDate(Date planDate) {
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