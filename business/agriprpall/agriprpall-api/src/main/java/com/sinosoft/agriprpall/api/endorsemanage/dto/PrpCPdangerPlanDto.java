package com.sinosoft.agriprpall.api.endorsemanage.dto;

import java.io.Serializable;

import com.sinosoft.framework.dto.BaseRequest;
/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-11-04 10:07:09.217 
 * PrpCPdangerPlanApi操作对象
 */
public class PrpCPdangerPlanDto extends BaseRequest implements Serializable{
	private static final long serialVersionUID = 1L;
	/** 属性endorseNo/endorseNo */
	private String endorseNo ;		
	/** 属性危险单位序号/危险单位序号 */
	private Integer dangerNo ;
	/** 属性交费次序号/交费次序号 */
	private Integer serialNo ;
	/** 属性交费期次/交费期次 */
	private Integer payNo ;
	/** 属性计划交费起始日期/计划交费起始日期 */
	private java.util.Date planDate ;		
	/** 属性币别/币别 */
	private String currency ;		
	/** 属性应交费金额/应交费金额 */
	private Double planFee ;
	/** 属性chgPlanFee/chgPlanFee */
	private Double chgPlanFee ;
	/** 属性标志字段/标志字段 */
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
