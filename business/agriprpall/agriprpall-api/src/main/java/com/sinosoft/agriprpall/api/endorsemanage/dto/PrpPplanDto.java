package com.sinosoft.agriprpall.api.endorsemanage.dto;

import com.sinosoft.framework.dto.BaseRequest;

import java.io.Serializable;
/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-10-24 09:50:49.498 
 * 收费计划表Api操作对象
 */
public class PrpPplanDto extends BaseRequest implements Serializable{
	private static final long serialVersionUID = 1L;
	/** 属性本次批单号码/本次批单号码 */
	private String endorseNo ;		
	/** 属性--** 保单号码/--** 保单号码 */
	private String policyNo ;		
	/** 属性--** 批单号码/--** 批单号码 */
	private String endorseNo1 ;		
	/** 属性--** 交费次数序号/--** 交费次数序号 */
	private Integer serialNo ;
	/** 属性--** 交费期次/--** 交费期次 */
	private Integer payNo ;
	/** 属性--** 交费原因（同收付费系统定义）--** R10：签单收保费--** R11：签单收储金--** R20：分期收保费--** R30：加保保费--** R31：加保储金--** R50：预收保费--** R90：储金转保费--** R91：收回手续费/--** 交费原因（同收付费系统定义）--** R10：签单收保费--** R11：签单收储金--** R20：分期收保费--** R30：加保保费--** R31：加保储金--** R50：预收保费--** R90：储金转保费--** R91：收回手续费 */
	private String payReason ;		
	/** 属性--** 计划交费截止日期/--** 计划交费截止日期 */
	private java.util.Date planDate ;		
	/** 属性--** 币别 ▲/--** 币别 ▲ */
	private String currency ;		
	/** 属性--** 应交费金额/--** 应交费金额 */
	private Double planFee ;
	/** 属性--** 拖欠金额/--** 拖欠金额 */
	private Double delinquentFee ;
	/** 属性--** 标志字段/--** 标志字段 */
	private String flag ;		
	/** 属性planStartDate/planStartDate */
	private java.util.Date planStartDate ;		
	/** 属性planRate/planRate */
	private Double planRate ;
	/** 属性签单币种/签单币种 */
	private String currency2 ;		
	/** 属性签单币种与本位币种的兑换率/签单币种与本位币种的兑换率 */
	private Double exchangeRateCNY ;
	/** 属性签单币种下的费用/签单币种下的费用 */
	private Double planFee2 ;
	/** 属性总不含税保费/总不含税保费 */
	private Double noTaxPremium ;
	/** 属性总税额/总税额 */
	private Double taxFee ;

	private String planCurrencyName;

	public String getPlanCurrencyName() {
		return planCurrencyName;
	}

	public void setPlanCurrencyName(String planCurrencyName) {
		this.planCurrencyName = planCurrencyName;
	}

	/**
	 * 属性本次批单号码/本次批单号码的getter方法
	 */
	public String getEndorseNo() {
		return endorseNo;
	}
	/**
	 * 属性本次批单号码/本次批单号码的setter方法
	 */
	public void setEndorseNo(String endorseNo) {
		this.endorseNo = endorseNo;
	}	
	/**
	 * 属性--** 保单号码/--** 保单号码的getter方法
	 */
	public String getPolicyNo() {
		return policyNo;
	}
	/**
	 * 属性--** 保单号码/--** 保单号码的setter方法
	 */
	public void setPolicyNo(String policyNo) {
		this.policyNo = policyNo;
	}	
	/**
	 * 属性--** 批单号码/--** 批单号码的getter方法
	 */
	public String getEndorseNo1() {
		return endorseNo1;
	}
	/**
	 * 属性--** 批单号码/--** 批单号码的setter方法
	 */
	public void setEndorseNo1(String endorseNo1) {
		this.endorseNo1 = endorseNo1;
	}	
	/**
	 * 属性--** 交费次数序号/--** 交费次数序号的getter方法
	 */
	public Integer getSerialNo() {
		return serialNo;
	}
	/**
	 * 属性--** 交费次数序号/--** 交费次数序号的setter方法
	 */
	public void setSerialNo(Integer serialNo) {
		this.serialNo = serialNo;
	}	
	/**
	 * 属性--** 交费期次/--** 交费期次的getter方法
	 */
	public Integer getPayNo() {
		return payNo;
	}
	/**
	 * 属性--** 交费期次/--** 交费期次的setter方法
	 */
	public void setPayNo(Integer payNo) {
		this.payNo = payNo;
	}	
	/**
	 * 属性--** 交费原因（同收付费系统定义）--** R10：签单收保费--** R11：签单收储金--** R20：分期收保费--** R30：加保保费--** R31：加保储金--** R50：预收保费--** R90：储金转保费--** R91：收回手续费/--** 交费原因（同收付费系统定义）--** R10：签单收保费--** R11：签单收储金--** R20：分期收保费--** R30：加保保费--** R31：加保储金--** R50：预收保费--** R90：储金转保费--** R91：收回手续费的getter方法
	 */
	public String getPayReason() {
		return payReason;
	}
	/**
	 * 属性--** 交费原因（同收付费系统定义）--** R10：签单收保费--** R11：签单收储金--** R20：分期收保费--** R30：加保保费--** R31：加保储金--** R50：预收保费--** R90：储金转保费--** R91：收回手续费/--** 交费原因（同收付费系统定义）--** R10：签单收保费--** R11：签单收储金--** R20：分期收保费--** R30：加保保费--** R31：加保储金--** R50：预收保费--** R90：储金转保费--** R91：收回手续费的setter方法
	 */
	public void setPayReason(String payReason) {
		this.payReason = payReason;
	}	
	/**
	 * 属性--** 计划交费截止日期/--** 计划交费截止日期的getter方法
	 */
	public java.util.Date getPlanDate() {
		return planDate;
	}
	/**
	 * 属性--** 计划交费截止日期/--** 计划交费截止日期的setter方法
	 */
	public void setPlanDate(java.util.Date planDate) {
		this.planDate = planDate;
	}	
	/**
	 * 属性--** 币别 ▲/--** 币别 ▲的getter方法
	 */
	public String getCurrency() {
		return currency;
	}
	/**
	 * 属性--** 币别 ▲/--** 币别 ▲的setter方法
	 */
	public void setCurrency(String currency) {
		this.currency = currency;
	}	
	/**
	 * 属性--** 应交费金额/--** 应交费金额的getter方法
	 */
	public Double getPlanFee() {
		return planFee;
	}
	/**
	 * 属性--** 应交费金额/--** 应交费金额的setter方法
	 */
	public void setPlanFee(Double planFee) {
		this.planFee = planFee;
	}	
	/**
	 * 属性--** 拖欠金额/--** 拖欠金额的getter方法
	 */
	public Double getDelinquentFee() {
		return delinquentFee;
	}
	/**
	 * 属性--** 拖欠金额/--** 拖欠金额的setter方法
	 */
	public void setDelinquentFee(Double delinquentFee) {
		this.delinquentFee = delinquentFee;
	}	
	/**
	 * 属性--** 标志字段/--** 标志字段的getter方法
	 */
	public String getFlag() {
		return flag;
	}
	/**
	 * 属性--** 标志字段/--** 标志字段的setter方法
	 */
	public void setFlag(String flag) {
		this.flag = flag;
	}	
	/**
	 * 属性planStartDate/planStartDate的getter方法
	 */
	public java.util.Date getPlanStartDate() {
		return planStartDate;
	}
	/**
	 * 属性planStartDate/planStartDate的setter方法
	 */
	public void setPlanStartDate(java.util.Date planStartDate) {
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
	 * 属性签单币种/签单币种的getter方法
	 */
	public String getCurrency2() {
		return currency2;
	}
	/**
	 * 属性签单币种/签单币种的setter方法
	 */
	public void setCurrency2(String currency2) {
		this.currency2 = currency2;
	}

	public Double getExchangeRateCNY() {
		return exchangeRateCNY;
	}

	public void setExchangeRateCNY(Double exchangeRateCNY) {
		this.exchangeRateCNY = exchangeRateCNY;
	}

	/**
	 * 属性签单币种下的费用/签单币种下的费用的getter方法
	 */
	public Double getPlanFee2() {
		return planFee2;
	}
	/**
	 * 属性签单币种下的费用/签单币种下的费用的setter方法
	 */
	public void setPlanFee2(Double planFee2) {
		this.planFee2 = planFee2;
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
