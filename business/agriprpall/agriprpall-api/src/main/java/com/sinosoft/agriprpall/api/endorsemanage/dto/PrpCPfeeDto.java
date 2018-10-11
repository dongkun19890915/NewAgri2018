package com.sinosoft.agriprpall.api.endorsemanage.dto;

import com.sinosoft.framework.dto.BaseRequest;

import java.io.Serializable;
/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-10-24 03:06:48.016 
 * 保单保额保费表 Api操作对象
 */
public class PrpCPfeeDto extends BaseRequest implements Serializable{
	private static final long serialVersionUID = 1L;
	/** 属性policyNo/policyNo */
	private String policyNo ;		
	/** 属性riskCode/riskCode */
	private String riskCode ;		
	/** 属性currency/currency */
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

	private String feeCurrencyName;
	private String feeCurrencyName1;
	private String feeCurrencyName2;


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

	public String getPolicyNo() {
		return policyNo;
	}

	public void setPolicyNo(String policyNo) {
		this.policyNo = policyNo;
	}

	public String getRiskCode() {
		return riskCode;
	}

	public void setRiskCode(String riskCode) {
		this.riskCode = riskCode;
	}

	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}

	public Double getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}

	public Double getPremium() {
		return premium;
	}

	public void setPremium(Double premium) {
		this.premium = premium;
	}

	public String getFlag() {
		return flag;
	}

	public void setFlag(String flag) {
		this.flag = flag;
	}

	public String getCurrency1() {
		return currency1;
	}

	public void setCurrency1(String currency1) {
		this.currency1 = currency1;
	}

	public Double getExchangeRate1() {
		return exchangeRate1;
	}

	public void setExchangeRate1(Double exchangeRate1) {
		this.exchangeRate1 = exchangeRate1;
	}

	public Double getAmount1() {
		return amount1;
	}

	public void setAmount1(Double amount1) {
		this.amount1 = amount1;
	}

	public Double getPremium1() {
		return premium1;
	}

	public void setPremium1(Double premium1) {
		this.premium1 = premium1;
	}

	public String getCurrency2() {
		return currency2;
	}

	public void setCurrency2(String currency2) {
		this.currency2 = currency2;
	}

	public Double getExchangeRate2() {
		return exchangeRate2;
	}

	public void setExchangeRate2(Double exchangeRate2) {
		this.exchangeRate2 = exchangeRate2;
	}

	public Double getAmount2() {
		return amount2;
	}

	public void setAmount2(Double amount2) {
		this.amount2 = amount2;
	}

	public Double getPremium2() {
		return premium2;
	}

	public void setPremium2(Double premium2) {
		this.premium2 = premium2;
	}

	public Double getNoTaxPremium() {
		return noTaxPremium;
	}

	public void setNoTaxPremium(Double noTaxPremium) {
		this.noTaxPremium = noTaxPremium;
	}

	public Double getTaxFee() {
		return taxFee;
	}

	public void setTaxFee(Double taxFee) {
		this.taxFee = taxFee;
	}

	public Double getNoTaxPremium1() {
		return noTaxPremium1;
	}

	public void setNoTaxPremium1(Double noTaxPremium1) {
		this.noTaxPremium1 = noTaxPremium1;
	}

	public Double getTaxFee1() {
		return taxFee1;
	}

	public void setTaxFee1(Double taxFee1) {
		this.taxFee1 = taxFee1;
	}

	public Double getNoTaxPremium2() {
		return noTaxPremium2;
	}

	public void setNoTaxPremium2(Double noTaxPremium2) {
		this.noTaxPremium2 = noTaxPremium2;
	}

	public Double getTaxFee2() {
		return taxFee2;
	}

	public void setTaxFee2(Double taxFee2) {
		this.taxFee2 = taxFee2;
	}
}
