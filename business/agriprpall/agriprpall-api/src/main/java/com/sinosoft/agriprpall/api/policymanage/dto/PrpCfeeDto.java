package com.sinosoft.agriprpall.api.policymanage.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.sinosoft.framework.dto.BaseRequest;

import java.io.Serializable;
/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-10-24 07:46:04.010 
 * 保单保额保费表Api操作对象
 */
public class PrpCfeeDto extends BaseRequest implements Serializable{
	private static final long serialVersionUID = 1L;
	/** 属性保单号/保单号 */
	private String policyNo ;		
	/** 属性险种/险种 */
	private String riskCode ;		
	/** 属性currency/currency */
	private String currency ;		
	/** 属性保额/保额 */
	private Double amount ;
	/** 属性保费/保费 */
	private Double premium ;
	/** 属性备注/备注 */
	private String flag ="";
	/** 属性币别/币别 */
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
	/** 属性批改前折合打印币别总保额/批改前折合打印币别总保额 */
	private Double amount2 ;
	/** 属性批改前折合打印币别总保费/批改前折合打印币别总保费 */
	private Double premium2 ;
	/** 属性修改人/修改人 */
	private String update_By ;
	/** 属性修改时间/修改时间 */
	@JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
	private java.util.Date update_Date ;
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

	/**添加币别名称翻译 add by 王心洋 20171031*/
	private String feeCurrencyName;
	private String feeCurrencyName1;
	private String feeCurrencyName2;

	private String currency2Name;

	public String getCurrency2Name() {
		return currency2Name;
	}

	public void setCurrency2Name(String currency2Name) {
		this.currency2Name = currency2Name;
	}

	public String getFeeCurrencyName() {
		return feeCurrencyName;
	}

	public void setFeeCurrencyName(String feeCurrencyName) {
		this.feeCurrencyName = feeCurrencyName;
	}

	public String getFeeCurrencyName1() {
		return feeCurrencyName1;
	}

	public void setFeeCurrencyName1(String feeCurrencyName1) {
		this.feeCurrencyName1 = feeCurrencyName1;
	}

	public String getFeeCurrencyName2() {
		return feeCurrencyName2;
	}

	public void setFeeCurrencyName2(String feeCurrencyName2) {
		this.feeCurrencyName2 = feeCurrencyName2;
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
	 * 属性险种/险种的getter方法
	 */
	public String getRiskCode() {
		return riskCode;
	}
	/**
	 * 属性险种/险种的setter方法
	 */
	public void setRiskCode(String riskCode) {
		this.riskCode = riskCode;
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
	 * 属性保额/保额的getter方法
	 */
	public Double getAmount() {
		return amount;
	}
	/**
	 * 属性保额/保额的setter方法
	 */
	public void setAmount(Double amount) {
		this.amount = amount;
	}	
	/**
	 * 属性保费/保费的getter方法
	 */
	public Double getPremium() {
		return premium;
	}
	/**
	 * 属性保费/保费的setter方法
	 */
	public void setPremium(Double premium) {
		this.premium = premium;
	}	
	/**
	 * 属性备注/备注的getter方法
	 */
	public String getFlag() {
		return flag;
	}
	/**
	 * 属性备注/备注的setter方法
	 */
	public void setFlag(String flag) {
		this.flag = flag;
	}	
	/**
	 * 属性币别/币别的getter方法
	 */
	public String getCurrency1() {
		return currency1;
	}
	/**
	 * 属性币别/币别的setter方法
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
	 * 属性批改前折合打印币别总保额/批改前折合打印币别总保额的getter方法
	 */
	public Double getAmount2() {
		return amount2;
	}
	/**
	 * 属性批改前折合打印币别总保额/批改前折合打印币别总保额的setter方法
	 */
	public void setAmount2(Double amount2) {
		this.amount2 = amount2;
	}	
	/**
	 * 属性批改前折合打印币别总保费/批改前折合打印币别总保费的getter方法
	 */
	public Double getPremium2() {
		return premium2;
	}
	/**
	 * 属性批改前折合打印币别总保费/批改前折合打印币别总保费的setter方法
	 */
	public void setPremium2(Double premium2) {
		this.premium2 = premium2;
	}	
	/**
	 * 属性修改人/修改人的getter方法
	 */
	public String getUpdate_By() {
		return update_By;
	}
	/**
	 * 属性修改人/修改人的setter方法
	 */
	public void setUpdate_By(String update_By) {
		this.update_By = update_By;
	}	
	/**
	 * 属性修改时间/修改时间的getter方法
	 */
	public java.util.Date getUpdate_Date() {
		return update_Date;
	}
	/**
	 * 属性修改时间/修改时间的setter方法
	 */
	public void setUpdate_Date(java.util.Date update_Date) {
		this.update_Date = update_Date;
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
