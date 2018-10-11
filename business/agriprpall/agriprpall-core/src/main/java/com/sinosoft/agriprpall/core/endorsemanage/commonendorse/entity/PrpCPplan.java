package com.sinosoft.agriprpall.core.endorsemanage.commonendorse.entity;

import com.sinosoft.framework.core.dao.BaseEntityImpl;

import javax.persistence.*;
import java.util.Date;

/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-10-24 03:06:48.016 
 * 收费计划表实体操作对象
 */
@Entity
@Table(name = "PrpCPplan")
@IdClass(PrpCPplanKey.class)
public class PrpCPplan extends BaseEntityImpl{

	private static final long serialVersionUID = 1L;
	/** 属性保单号码/保单号码 */
	@Id
	@Column(name = "policyNo")
	private String policyNo ;/** 属性交费次数序号/交费次数序号 */
	@Id
	@Column(name = "serialNo")
	private Integer serialNo ;

	/** 属性批单号码/批单号码 */
	@Column(name = "endorseNo")
	private String endorseNo ;

	/** 属性交费期次/交费期次 */
	@Column(name = "payNo")
	private Integer payNo ;
	/** 属性交费原因（同收付费系统定义）--** R10：签单收保费--** R11：签单收储金--** R20：分期收保费--** R30：加保保费--** R31：加保储金--** R50：预收保费--** R90：储金转保费--** R91：收回手续费/交费原因（同收付费系统定义）--** R10：签单收保费--** R11：签单收储金--** R20：分期收保费--** R30：加保保费--** R31：加保储金--** R50：预收保费--** R90：储金转保费--** R91：收回手续费 */
	@Column(name = "payReason")
	private String payReason ;
	/** 属性计划交费截止日期/计划交费截止日期 */
	@Column(name = "planDate")
	private Date planDate ;
	/** 属性币别 /币别  */
	@Column(name = "currency")
	private String currency ;
	/** 属性应交费金额/应交费金额 */
	@Column(name = "planFee")
	private Double planFee ;
	/** 属性拖欠金额/拖欠金额 */
	@Column(name = "delinquentFee")
	private Double delinquentFee ;
	/** 属性拖欠金额1/拖欠金额1 */
	@Column(name = "flag")
	private String flag ;
	/** 属性planStartDate/planStartDate */
	@Column(name = "planStartDate")
	private Date planStartDate ;
	/** 属性planRate/planRate */
	@Column(name = "planRate")
	private Double planRate ;
	/** 属性currency3/currency3 */
	@Column(name = "currency2")
	private String currency2 ;
	/** 属性planFee3/planFee3 */
	@Column(name = "planFee2")
	private Double planFee2 ;
	/** 属性exchangeRateCny/exchangeRateCny */
	@Column(name = "exchangeRateCny")
	private Double exchangeRateCny ;
	/** 属性总不含税保费/总不含税保费 */
	@Column(name = "noTaxPremium")
	private Double noTaxPremium ;
	/** 属性总税额/总税额 */
	@Column(name = "taxFee")
	private Double taxFee ;




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
	 * 属性交费原因（同收付费系统定义）--** R10：签单收保费--** R11：签单收储金--** R20：分期收保费--** R30：加保保费--** R31：加保储金--** R50：预收保费--** R90：储金转保费--** R91：收回手续费/交费原因（同收付费系统定义）--** R10：签单收保费--** R11：签单收储金--** R20：分期收保费--** R30：加保保费--** R31：加保储金--** R50：预收保费--** R90：储金转保费--** R91：收回手续费的getter方法
	 */
	public String getPayReason() {
		return payReason;
	}
	/**
	 * 属性交费原因（同收付费系统定义）--** R10：签单收保费--** R11：签单收储金--** R20：分期收保费--** R30：加保保费--** R31：加保储金--** R50：预收保费--** R90：储金转保费--** R91：收回手续费/交费原因（同收付费系统定义）--** R10：签单收保费--** R11：签单收储金--** R20：分期收保费--** R30：加保保费--** R31：加保储金--** R50：预收保费--** R90：储金转保费--** R91：收回手续费的setter方法
	 */
	public void setPayReason(String payReason) {
		this.payReason = payReason;
	} 	
	/**
	 * 属性计划交费截止日期/计划交费截止日期的getter方法
	 */
	public Date getPlanDate() {
		return planDate;
	}
	/**
	 * 属性计划交费截止日期/计划交费截止日期的setter方法
	 */
	public void setPlanDate(Date planDate) {
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
	 * 属性拖欠金额/拖欠金额的getter方法
	 */
	public Double getDelinquentFee() {
		return delinquentFee;
	}
	/**
	 * 属性拖欠金额/拖欠金额的setter方法
	 */
	public void setDelinquentFee(Double delinquentFee) {
		this.delinquentFee = delinquentFee;
	} 	
	/**
	 * 属性拖欠金额1/拖欠金额1的getter方法
	 */
	public String getFlag() {
		return flag;
	}
	/**
	 * 属性拖欠金额1/拖欠金额1的setter方法
	 */
	public void setFlag(String flag) {
		this.flag = flag;
	} 	
	/**
	 * 属性planStartDate/planStartDate的getter方法
	 */
	public Date getPlanStartDate() {
		return planStartDate;
	}
	/**
	 * 属性planStartDate/planStartDate的setter方法
	 */
	public void setPlanStartDate(Date planStartDate) {
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
	 * 属性currency3/currency3的getter方法
	 */
	public String getCurrency2() {
		return currency2;
	}
	/**
	 * 属性currency3/currency3的setter方法
	 */
	public void setCurrency2(String currency2) {
		this.currency2 = currency2;
	} 	
	/**
	 * 属性planFee3/planFee3的getter方法
	 */
	public Double getPlanFee2() {
		return planFee2;
	}
	/**
	 * 属性planFee3/planFee3的setter方法
	 */
	public void setPlanFee2(Double planFee2) {
		this.planFee2 = planFee2;
	} 	
	/**
	 * 属性exchangeRateCny/exchangeRateCny的getter方法
	 */
	public Double getExchangeRateCny() {
		return exchangeRateCny;
	}
	/**
	 * 属性exchangeRateCny/exchangeRateCny的setter方法
	 */
	public void setExchangeRateCny(Double exchangeRateCny) {
		this.exchangeRateCny = exchangeRateCny;
	} 	
	/**
	 * 属性总不含税保费/总不含税保费的getter方法
	 */
	public Double getNoTaxPremium() {
		return noTaxPremium;
	}
	/**
	 * 属性总不含税保费/总不含税保费的setter方法
	 */
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