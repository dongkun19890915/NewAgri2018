package com.sinosoft.agriprpall.core.proposalmanage.entity;

import com.sinosoft.framework.core.dao.BaseEntityImpl;

import javax.persistence.*;

/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-10-18 03:10:49.566 
 * 保单保额保费表实体操作对象
 */
@Entity
@Table(name = "PrpTfee")
@IdClass(PrpTfeeKey.class)
public class PrpTfee extends BaseEntityImpl{

	private static final long serialVersionUID = 1L;
	/** 属性投保单号码/投保单号码 */
	@Id
	@Column(name = "proposalNo")
	private String proposalNo ;/** 属性原币别代码/原币别代码 */
	@Id
	@Column(name = "currency")
	private String currency ;	

	/** 属性险种代码/险种代码 */
	@Column(name = "riskCode")
	private String riskCode ;

	/** 属性原总保额/原总保额 */
	@Column(name = "amount")
	private Double amount ;
	/** 属性原总保费/原总保费 */
	@Column(name = "premium")
	private Double premium ;
	/** 属性标志字段/标志字段 */
	@Column(name = "flag")
	private String flag ;
	/** 属性支付币别代码/支付币别代码 */
	@Column(name = "currency1")
	private String currency1 ;
	/** 属性支付汇率/支付汇率 */
	@Column(name = "exchangeRate1")
	private Double exchangeRate1 ;
	/** 属性支付总保额/支付总保额 */
	@Column(name = "amount1")
	private Double amount1 ;
	/** 属性支付总保费/支付总保费 */
	@Column(name = "premium1")
	private Double premium1 ;
	/** 属性汇总别代码/汇总别代码 */
	@Column(name = "currency2")
	private String currency2 ;
	/** 属性汇总汇率/汇总汇率 */
	@Column(name = "exchangeRate2")
	private Double exchangeRate2 ;
	/** 属性汇总总保额/汇总总保额 */
	@Column(name = "amount2")
	private Double amount2 ;
	/** 属性汇总总保费/汇总总保费 */
	@Column(name = "premium2")
	private Double premium2 ;
	/** 属性原币总不含税保费/原币总不含税保费 */
	@Column(name = "noTaxPremium")
	private Double noTaxPremium ;
	/** 属性原币总税额/原币总税额 */
	@Column(name = "taxFee")
	private Double taxFee ;
	/** 属性折合支付币别总不含税保费/折合支付币别总不含税保费 */
	@Column(name = "noTaxPremium1")
	private Double noTaxPremium1 ;
	/** 属性折合支付币别总税额/折合支付币别总税额 */
	@Column(name = "taxFee1")
	private Double taxFee1 ;
	/** 属性汇总币别总不含税保费/汇总币别总不含税保费 */
	@Column(name = "noTaxPremium2")
	private Double noTaxPremium2 ;
	/** 属性汇总币别总税额/汇总币别总税额 */
	@Column(name = "taxFee2")
	private Double taxFee2 ;
	/**
	 * 属性投保单号码/投保单号码的getter方法
	 */
	public String getProposalNo() {
		return proposalNo;
	}
	/**
	 * 属性投保单号码/投保单号码的setter方法
	 */
	public void setProposalNo(String proposalNo) {
		this.proposalNo = proposalNo;
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
	 * 属性原币别代码/原币别代码的getter方法
	 */
	public String getCurrency() {
		return currency;
	}
	/**
	 * 属性原币别代码/原币别代码的setter方法
	 */
	public void setCurrency(String currency) {
		this.currency = currency;
	} 	
	/**
	 * 属性原总保额/原总保额的getter方法
	 */
	public Double getAmount() {
		return amount;
	}
	/**
	 * 属性原总保额/原总保额的setter方法
	 */
	public void setAmount(Double amount) {
		this.amount = amount;
	} 	
	/**
	 * 属性原总保费/原总保费的getter方法
	 */
	public Double getPremium() {
		return premium;
	}
	/**
	 * 属性原总保费/原总保费的setter方法
	 */
	public void setPremium(Double premium) {
		this.premium = premium;
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
	/**
	 * 属性支付币别代码/支付币别代码的getter方法
	 */
	public String getCurrency1() {
		return currency1;
	}
	/**
	 * 属性支付币别代码/支付币别代码的setter方法
	 */
	public void setCurrency1(String currency1) {
		this.currency1 = currency1;
	} 	
	/**
	 * 属性支付汇率/支付汇率的getter方法
	 */
	public Double getExchangeRate1() {
		return exchangeRate1;
	}
	/**
	 * 属性支付汇率/支付汇率的setter方法
	 */
	public void setExchangeRate1(Double exchangeRate1) {
		this.exchangeRate1 = exchangeRate1;
	} 	
	/**
	 * 属性支付总保额/支付总保额的getter方法
	 */
	public Double getAmount1() {
		return amount1;
	}
	/**
	 * 属性支付总保额/支付总保额的setter方法
	 */
	public void setAmount1(Double amount1) {
		this.amount1 = amount1;
	} 	
	/**
	 * 属性支付总保费/支付总保费的getter方法
	 */
	public Double getPremium1() {
		return premium1;
	}
	/**
	 * 属性支付总保费/支付总保费的setter方法
	 */
	public void setPremium1(Double premium1) {
		this.premium1 = premium1;
	} 	
	/**
	 * 属性汇总别代码/汇总别代码的getter方法
	 */
	public String getCurrency2() {
		return currency2;
	}
	/**
	 * 属性汇总别代码/汇总别代码的setter方法
	 */
	public void setCurrency2(String currency2) {
		this.currency2 = currency2;
	} 	
	/**
	 * 属性汇总汇率/汇总汇率的getter方法
	 */
	public Double getExchangeRate2() {
		return exchangeRate2;
	}
	/**
	 * 属性汇总汇率/汇总汇率的setter方法
	 */
	public void setExchangeRate2(Double exchangeRate2) {
		this.exchangeRate2 = exchangeRate2;
	} 	
	/**
	 * 属性汇总总保额/汇总总保额的getter方法
	 */
	public Double getAmount2() {
		return amount2;
	}
	/**
	 * 属性汇总总保额/汇总总保额的setter方法
	 */
	public void setAmount2(Double amount2) {
		this.amount2 = amount2;
	} 	
	/**
	 * 属性汇总总保费/汇总总保费的getter方法
	 */
	public Double getPremium2() {
		return premium2;
	}
	/**
	 * 属性汇总总保费/汇总总保费的setter方法
	 */
	public void setPremium2(Double premium2) {
		this.premium2 = premium2;
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