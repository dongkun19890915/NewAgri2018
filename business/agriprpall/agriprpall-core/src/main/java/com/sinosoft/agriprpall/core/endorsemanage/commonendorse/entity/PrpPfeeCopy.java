package com.sinosoft.agriprpall.core.endorsemanage.commonendorse.entity;

import com.sinosoft.framework.core.dao.BaseEntityImpl;

import javax.persistence.*;
import java.util.Date;

/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-10-24 09:50:49.498 
 * 保单保额保费表 实体操作对象
 */
@Entity
@Table(name = "PrpPfeeCopy")
@IdClass(PrpPfeeCopyKey.class)
public class PrpPfeeCopy extends BaseEntityImpl{

	private static final long serialVersionUID = 1L;
	/** 属性批单号/批单号 */
	@Id
	@Column(name = "endorseNo")
	private String endorseNo ;/** 属性币别信息/币别信息 */
	@Id
	@Column(name = "currency")
	private String currency ;

	/** 属性保单号/保单号 */
	@Column(name = "policyNo")
	private String policyNo ;
	/** 属性险种代码/险种代码 */
	@Column(name = "riskCode")
	private String riskCode ;

	/** 属性amount/amount */
	@Column(name = "amount")
	private Double amount ;
	/** 属性premium/premium */
	@Column(name = "premium")
	private Double premium ;
	/** 属性currency1/currency1 */
	@Column(name = "currency1")
	private String currency1 ;
	/** 属性exchangeRate1/exchangeRate1 */
	@Column(name = "exchangeRate1")
	private Double exchangeRate1 ;
	/** 属性amount1/amount1 */
	@Column(name = "amount1")
	private Double amount1 ;
	/** 属性premium1/premium1 */
	@Column(name = "premium1")
	private Double premium1 ;
	/** 属性currency2/currency2 */
	@Column(name = "currency2")
	private String currency2 ;
	/** 属性exchangeRate2/exchangeRate2 */
	@Column(name = "exchangeRate2")
	private Double exchangeRate2 ;
	/** 属性amount2/amount2 */
	@Column(name = "amount2")
	private Double amount2 ;
	/** 属性premium2/premium2 */
	@Column(name = "premium2")
	private Double premium2 ;
	/** 属性chgAmount/chgAmount */
	@Column(name = "chgAmount")
	private Double chgAmount ;
	/** 属性chgPremium/chgPremium */
	@Column(name = "chgPremium")
	private Double chgPremium ;
	/** 属性chgAmount1/chgAmount1 */
	@Column(name = "chgAmount1")
	private Double chgAmount1 ;
	/** 属性chgPremium1/chgPremium1 */
	@Column(name = "chgPremium1")
	private Double chgPremium1 ;
	/** 属性chgAmount2/chgAmount2 */
	@Column(name = "chgAmount2")
	private Double chgAmount2 ;
	/** 属性chgPremium2/chgPremium2 */
	@Column(name = "chgPremium2")
	private Double chgPremium2 ;
	/** 属性标志字段/标志字段 */
	@Column(name = "flag")
	private String flag ;
	/** 属性修改人/修改人 */
	@Column(name = "update_By")
	private String update_By ;
	/** 属性修改时间/修改时间 */
	@Column(name = "update_Date")
	private Date update_Date ;
	/** 属性折合支付币别总不含税保费/折合支付币别总不含税保费 */
	@Column(name = "noTaxPremium")
	private Double noTaxPremium ;
	/** 属性折合支付币别总不含税保费变化量/折合支付币别总不含税保费变化量 */
	@Column(name = "chgTaxPremium")
	private Double chgTaxPremium ;
	/** 属性折合支付币别总税额1/折合支付币别总税额1 */
	@Column(name = "taxFee")
	private Double taxFee ;
	/** 属性折合支付币别总税额变化量1/折合支付币别总税额变化量1 */
	@Column(name = "chgTaxFee")
	private Double chgTaxFee ;
	/** 属性折合支付币别总不含税保费1/折合支付币别总不含税保费1 */
	@Column(name = "noTaxPremium1")
	private Double noTaxPremium1 ;
	/** 属性折合支付币别总不含税保费变化量1/折合支付币别总不含税保费变化量1 */
	@Column(name = "chgTaxPremium1")
	private Double chgTaxPremium1 ;
	/** 属性折合支付币别总税额2/折合支付币别总税额2 */
	@Column(name = "taxFee1")
	private Double taxFee1 ;
	/** 属性折合支付币别总税额变化量3/折合支付币别总税额变化量3 */
	@Column(name = "chgTaxFee1")
	private Double chgTaxFee1 ;
	/** 属性折合支付币别总不含税保费3/折合支付币别总不含税保费3 */
	@Column(name = "noTaxPremium2")
	private Double noTaxPremium2 ;
	/** 属性折合支付币别总不含税保费变化量3/折合支付币别总不含税保费变化量3 */
	@Column(name = "chgTaxPremium2")
	private Double chgTaxPremium2 ;
	/** 属性折合支付币别总税额/折合支付币别总税额 */
	@Column(name = "taxFee2")
	private Double taxFee2 ;
	/** 属性折合支付币别总税额变化量/折合支付币别总税额变化量 */
	@Column(name = "chgTaxFee2")
	private Double chgTaxFee2 ;
	/**
	 * 属性批单号/批单号的getter方法
	 */
	public String getEndorseNo() {
		return endorseNo;
	}
	/**
	 * 属性批单号/批单号的setter方法
	 */
	public void setEndorseNo(String endorseNo) {
		this.endorseNo = endorseNo;
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
	 * 属性币别信息/币别信息的getter方法
	 */
	public String getCurrency() {
		return currency;
	}
	/**
	 * 属性币别信息/币别信息的setter方法
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
	 * 属性chgAmount/chgAmount的getter方法
	 */
	public Double getChgAmount() {
		return chgAmount;
	}
	/**
	 * 属性chgAmount/chgAmount的setter方法
	 */
	public void setChgAmount(Double chgAmount) {
		this.chgAmount = chgAmount;
	}
	/**
	 * 属性chgPremium/chgPremium的getter方法
	 */
	public Double getChgPremium() {
		return chgPremium;
	}
	/**
	 * 属性chgPremium/chgPremium的setter方法
	 */
	public void setChgPremium(Double chgPremium) {
		this.chgPremium = chgPremium;
	}
	/**
	 * 属性chgAmount1/chgAmount1的getter方法
	 */
	public Double getChgAmount1() {
		return chgAmount1;
	}
	/**
	 * 属性chgAmount1/chgAmount1的setter方法
	 */
	public void setChgAmount1(Double chgAmount1) {
		this.chgAmount1 = chgAmount1;
	}
	/**
	 * 属性chgPremium1/chgPremium1的getter方法
	 */
	public Double getChgPremium1() {
		return chgPremium1;
	}
	/**
	 * 属性chgPremium1/chgPremium1的setter方法
	 */
	public void setChgPremium1(Double chgPremium1) {
		this.chgPremium1 = chgPremium1;
	}
	/**
	 * 属性chgAmount2/chgAmount2的getter方法
	 */
	public Double getChgAmount2() {
		return chgAmount2;
	}
	/**
	 * 属性chgAmount2/chgAmount2的setter方法
	 */
	public void setChgAmount2(Double chgAmount2) {
		this.chgAmount2 = chgAmount2;
	}
	/**
	 * 属性chgPremium2/chgPremium2的getter方法
	 */
	public Double getChgPremium2() {
		return chgPremium2;
	}
	/**
	 * 属性chgPremium2/chgPremium2的setter方法
	 */
	public void setChgPremium2(Double chgPremium2) {
		this.chgPremium2 = chgPremium2;
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

	public String getUpdate_By() {
		return update_By;
	}

	public void setUpdate_By(String update_By) {
		this.update_By = update_By;
	}

	public Date getUpdate_Date() {
		return update_Date;
	}

	public void setUpdate_Date(Date update_Date) {
		this.update_Date = update_Date;
	}

	/**
	 * 属性折合支付币别总不含税保费/折合支付币别总不含税保费的getter方法
	 */
	public Double getNoTaxPremium() {
		return noTaxPremium;
	}
	/**
	 * 属性折合支付币别总不含税保费/折合支付币别总不含税保费的setter方法
	 */
	public void setNoTaxPremium(Double noTaxPremium) {
		this.noTaxPremium = noTaxPremium;
	}
	/**
	 * 属性折合支付币别总不含税保费变化量/折合支付币别总不含税保费变化量的getter方法
	 */
	public Double getChgTaxPremium() {
		return chgTaxPremium;
	}
	/**
	 * 属性折合支付币别总不含税保费变化量/折合支付币别总不含税保费变化量的setter方法
	 */
	public void setChgTaxPremium(Double chgTaxPremium) {
		this.chgTaxPremium = chgTaxPremium;
	}
	/**
	 * 属性折合支付币别总税额1/折合支付币别总税额1的getter方法
	 */
	public Double getTaxFee() {
		return taxFee;
	}
	/**
	 * 属性折合支付币别总税额1/折合支付币别总税额1的setter方法
	 */
	public void setTaxFee(Double taxFee) {
		this.taxFee = taxFee;
	}
	/**
	 * 属性折合支付币别总税额变化量1/折合支付币别总税额变化量1的getter方法
	 */
	public Double getChgTaxFee() {
		return chgTaxFee;
	}
	/**
	 * 属性折合支付币别总税额变化量1/折合支付币别总税额变化量1的setter方法
	 */
	public void setChgTaxFee(Double chgTaxFee) {
		this.chgTaxFee = chgTaxFee;
	}
	/**
	 * 属性折合支付币别总不含税保费1/折合支付币别总不含税保费1的getter方法
	 */
	public Double getNoTaxPremium1() {
		return noTaxPremium1;
	}
	/**
	 * 属性折合支付币别总不含税保费1/折合支付币别总不含税保费1的setter方法
	 */
	public void setNoTaxPremium1(Double noTaxPremium1) {
		this.noTaxPremium1 = noTaxPremium1;
	}
	/**
	 * 属性折合支付币别总不含税保费变化量1/折合支付币别总不含税保费变化量1的getter方法
	 */
	public Double getChgTaxPremium1() {
		return chgTaxPremium1;
	}
	/**
	 * 属性折合支付币别总不含税保费变化量1/折合支付币别总不含税保费变化量1的setter方法
	 */
	public void setChgTaxPremium1(Double chgTaxPremium1) {
		this.chgTaxPremium1 = chgTaxPremium1;
	}
	/**
	 * 属性折合支付币别总税额2/折合支付币别总税额2的getter方法
	 */
	public Double getTaxFee1() {
		return taxFee1;
	}
	/**
	 * 属性折合支付币别总税额2/折合支付币别总税额2的setter方法
	 */
	public void setTaxFee1(Double taxFee1) {
		this.taxFee1 = taxFee1;
	}
	/**
	 * 属性折合支付币别总税额变化量3/折合支付币别总税额变化量3的getter方法
	 */
	public Double getChgTaxFee1() {
		return chgTaxFee1;
	}
	/**
	 * 属性折合支付币别总税额变化量3/折合支付币别总税额变化量3的setter方法
	 */
	public void setChgTaxFee1(Double chgTaxFee1) {
		this.chgTaxFee1 = chgTaxFee1;
	}
	/**
	 * 属性折合支付币别总不含税保费3/折合支付币别总不含税保费3的getter方法
	 */
	public Double getNoTaxPremium2() {
		return noTaxPremium2;
	}
	/**
	 * 属性折合支付币别总不含税保费3/折合支付币别总不含税保费3的setter方法
	 */
	public void setNoTaxPremium2(Double noTaxPremium2) {
		this.noTaxPremium2 = noTaxPremium2;
	}
	/**
	 * 属性折合支付币别总不含税保费变化量3/折合支付币别总不含税保费变化量3的getter方法
	 */
	public Double getChgTaxPremium2() {
		return chgTaxPremium2;
	}
	/**
	 * 属性折合支付币别总不含税保费变化量3/折合支付币别总不含税保费变化量3的setter方法
	 */
	public void setChgTaxPremium2(Double chgTaxPremium2) {
		this.chgTaxPremium2 = chgTaxPremium2;
	}
	/**
	 * 属性折合支付币别总税额/折合支付币别总税额的getter方法
	 */
	public Double getTaxFee2() {
		return taxFee2;
	}
	/**
	 * 属性折合支付币别总税额/折合支付币别总税额的setter方法
	 */
	public void setTaxFee2(Double taxFee2) {
		this.taxFee2 = taxFee2;
	}
	/**
	 * 属性折合支付币别总税额变化量/折合支付币别总税额变化量的getter方法
	 */
	public Double getChgTaxFee2() {
		return chgTaxFee2;
	}
	/**
	 * 属性折合支付币别总税额变化量/折合支付币别总税额变化量的setter方法
	 */
	public void setChgTaxFee2(Double chgTaxFee2) {
		this.chgTaxFee2 = chgTaxFee2;
	} 	
}