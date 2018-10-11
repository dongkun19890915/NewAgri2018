package com.sinosoft.agriprpall.api.policymanage.dto;

import java.io.Serializable;

import com.sinosoft.framework.dto.BaseRequest;
/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-10-30 08:02:24.074 
 * 原始保单保额保费表Api操作对象
 */
public class PrpCfeeOriginDto extends BaseRequest implements Serializable{
	private static final long serialVersionUID = 1L;
	/** 属性保单号/保单号 */
	private String policyNo ;		
	/** 属性险种代码/险种代码 */
	private String riskCode ;		
	/** 属性币别/币别 */
	private String currency ;		
	/** 属性amount/amount */
	private Double amount ;
	/** 属性premium/premium */
	private Double premium ;
	/** 属性flag/flag */
	private String flag ;		
	/** 属性currency1/currency1 */
	private String currency1 ;		
	/** 属性exchangeRate1/exchangeRate1 */
	private Double exchangeRate1 ;
	/** 属性amount1/amount1 */
	private Double amount1 ;
	/** 属性premium1/premium1 */
	private Double premium1 ;
	/** 属性currency2/currency2 */
	private String currency2 ;		
	/** 属性exchangeRate2/exchangeRate2 */
	private Double exchangeRate2 ;
	/** 属性amount2/amount2 */
	private Double amount2 ;
	/** 属性premium2/premium2 */
	private Double premium2 ;
	/** 属性修改人/修改人 */
	private String updateBy ;		
	/** 属性修改时间/修改时间 */
	private java.util.Date updateDate ;		
	/** 属性原币总不含税保费/原币总不含税保费 */
	private Double noTaxPremium ;
	/** 属性原币总税额/原币总税额 */
	private Double taxFee ;
	/** 属性折合支付币别总不含税保费/折合支付币别总不含税保费 */
	private Double noTaxPremium1 ;
	/** 属性折合支付币别总税额/折合支付币别总税额 */
	private Double taxFee1 ;
	/** 属性汇总币别总不含税保费/汇总币别总不含税保费 */
	private Double noTaxPremium2 ;
	/** 属性汇总币别总税额/汇总币别总税额 */
	private Double taxFee2 ;
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
	 * 属性amount/amount的getter方法
	 */
	public Double getAmount() {
		return amount;
	}
	/**
	 * 属性amount/amount的setter方法
	 */
	public void setAmount(Double amount) {
		this.amount = amount;
	}	
	/**
	 * 属性premium/premium的getter方法
	 */
	public Double getPremium() {
		return premium;
	}
	/**
	 * 属性premium/premium的setter方法
	 */
	public void setPremium(Double premium) {
		this.premium = premium;
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
	/**
	 * 属性currency1/currency1的getter方法
	 */
	public String getCurrency1() {
		return currency1;
	}
	/**
	 * 属性currency1/currency1的setter方法
	 */
	public void setCurrency1(String currency1) {
		this.currency1 = currency1;
	}	
	/**
	 * 属性exchangeRate1/exchangeRate1的getter方法
	 */
	public Double getExchangeRate1() {
		return exchangeRate1;
	}
	/**
	 * 属性exchangeRate1/exchangeRate1的setter方法
	 */
	public void setExchangeRate1(Double exchangeRate1) {
		this.exchangeRate1 = exchangeRate1;
	}	
	/**
	 * 属性amount1/amount1的getter方法
	 */
	public Double getAmount1() {
		return amount1;
	}
	/**
	 * 属性amount1/amount1的setter方法
	 */
	public void setAmount1(Double amount1) {
		this.amount1 = amount1;
	}	
	/**
	 * 属性premium1/premium1的getter方法
	 */
	public Double getPremium1() {
		return premium1;
	}
	/**
	 * 属性premium1/premium1的setter方法
	 */
	public void setPremium1(Double premium1) {
		this.premium1 = premium1;
	}	
	/**
	 * 属性currency2/currency2的getter方法
	 */
	public String getCurrency2() {
		return currency2;
	}
	/**
	 * 属性currency2/currency2的setter方法
	 */
	public void setCurrency2(String currency2) {
		this.currency2 = currency2;
	}	
	/**
	 * 属性exchangeRate2/exchangeRate2的getter方法
	 */
	public Double getExchangeRate2() {
		return exchangeRate2;
	}
	/**
	 * 属性exchangeRate2/exchangeRate2的setter方法
	 */
	public void setExchangeRate2(Double exchangeRate2) {
		this.exchangeRate2 = exchangeRate2;
	}	
	/**
	 * 属性amount2/amount2的getter方法
	 */
	public Double getAmount2() {
		return amount2;
	}
	/**
	 * 属性amount2/amount2的setter方法
	 */
	public void setAmount2(Double amount2) {
		this.amount2 = amount2;
	}	
	/**
	 * 属性premium2/premium2的getter方法
	 */
	public Double getPremium2() {
		return premium2;
	}
	/**
	 * 属性premium2/premium2的setter方法
	 */
	public void setPremium2(Double premium2) {
		this.premium2 = premium2;
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
	/**
	 * 属性原币总不含税保费/原币总不含税保费的getter方法
	 */
	public Double getNoTaxPremium() {
		return noTaxPremium;
	}
	/**
	 * 属性原币总不含税保费/原币总不含税保费的setter方法
	 */
	public void setNoTaxPremium(Double noTaxPremium) {
		this.noTaxPremium = noTaxPremium;
	}	
	/**
	 * 属性原币总税额/原币总税额的getter方法
	 */
	public Double getTaxFee() {
		return taxFee;
	}
	/**
	 * 属性原币总税额/原币总税额的setter方法
	 */
	public void setTaxFee(Double taxFee) {
		this.taxFee = taxFee;
	}	
	/**
	 * 属性折合支付币别总不含税保费/折合支付币别总不含税保费的getter方法
	 */
	public Double getNoTaxPremium1() {
		return noTaxPremium1;
	}
	/**
	 * 属性折合支付币别总不含税保费/折合支付币别总不含税保费的setter方法
	 */
	public void setNoTaxPremium1(Double noTaxPremium1) {
		this.noTaxPremium1 = noTaxPremium1;
	}	
	/**
	 * 属性折合支付币别总税额/折合支付币别总税额的getter方法
	 */
	public Double getTaxFee1() {
		return taxFee1;
	}
	/**
	 * 属性折合支付币别总税额/折合支付币别总税额的setter方法
	 */
	public void setTaxFee1(Double taxFee1) {
		this.taxFee1 = taxFee1;
	}	
	/**
	 * 属性汇总币别总不含税保费/汇总币别总不含税保费的getter方法
	 */
	public Double getNoTaxPremium2() {
		return noTaxPremium2;
	}
	/**
	 * 属性汇总币别总不含税保费/汇总币别总不含税保费的setter方法
	 */
	public void setNoTaxPremium2(Double noTaxPremium2) {
		this.noTaxPremium2 = noTaxPremium2;
	}	
	/**
	 * 属性汇总币别总税额/汇总币别总税额的getter方法
	 */
	public Double getTaxFee2() {
		return taxFee2;
	}
	/**
	 * 属性汇总币别总税额/汇总币别总税额的setter方法
	 */
	public void setTaxFee2(Double taxFee2) {
		this.taxFee2 = taxFee2;
	}	
}
