package com.sinosoft.agriprpall.core.policymanage.entity;

import com.sinosoft.framework.core.dao.BaseEntityImpl;
import javax.persistence.*;
import java.util.Date;

/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-11-05 01:01:20.710 
 * 原始保单保额保费实体操作对象
 */
@Entity
@Table(name = "PrpCfeeOrigin")
@IdClass(PrpCfeeOriginKey.class)
public class PrpCfeeOrigin extends BaseEntityImpl{

	private static final long serialVersionUID = 1L;
	/** 属性保单号/保单号 */
	@Id
	@Column(name = "policyNo")
	private String policyNo ;/** 属性currency/currency */
	@Id
	@Column(name = "currency")
	private String currency ;	

	/** 属性险种/险种 */
	@Column(name = "riskCode")
	private String riskCode ;

	/** 属性保额/保额 */
	@Column(name = "amount")
	private java.lang.Double amount ;
	/** 属性保费/保费 */
	@Column(name = "premium")
	private java.lang.Double premium ;
	/** 属性备注/备注 */
	@Column(name = "flag")
	private String flag ;
	/** 属性币别/币别 */
	@Column(name = "currency1")
	private String currency1 ;
	/** 属性exChangeRate2/exChangeRate2 */
	@Column(name = "exchangeRate1")
	private java.lang.Double exchangeRate1 ;
	/** 属性amount2/amount2 */
	@Column(name = "amount1")
	private java.lang.Double amount1 ;
	/** 属性premium2/premium2 */
	@Column(name = "premium1")
	private java.lang.Double premium1 ;
	/** 属性currency3/currency3 */
	@Column(name = "currency2")
	private String currency2 ;
	/** 属性exChangeRate3/exChangeRate3 */
	@Column(name = "exchangeRate2")
	private java.lang.Double exchangeRate2 ;
	/** 属性批改前折合打印币别总保额/批改前折合打印币别总保额 */
	@Column(name = "amount2")
	private java.lang.Double amount2 ;
	/** 属性批改前折合打印币别总保费/批改前折合打印币别总保费 */
	@Column(name = "premium2")
	private java.lang.Double premium2 ;
	/** 属性修改人/修改人 */
	@Column(name = "update_By")
	private String updateBy ;
	/** 属性修改时间/修改时间 */
	@Column(name = "update_Date")
	private java.util.Date updateDate ;
	/** 属性原币总不含税保费/原币总不含税保费 */
	@Column(name = "noTaxPremium")
	private java.lang.Double noTaxPremium ;
	/** 属性原币总税额/原币总税额 */
	@Column(name = "taxFee")
	private java.lang.Double taxFee ;
	/** 属性折合支付币别总不含税保费/折合支付币别总不含税保费 */
	@Column(name = "noTaxPremium1")
	private java.lang.Double noTaxPremium1 ;
	/** 属性折合支付币别总税额/折合支付币别总税额 */
	@Column(name = "taxFee1")
	private java.lang.Double taxFee1 ;
	/** 属性汇总币别总不含税保费/汇总币别总不含税保费 */
	@Column(name = "noTaxPremium2")
	private java.lang.Double noTaxPremium2 ;
	/** 属性汇总币别总税额/汇总币别总税额 */
	@Column(name = "taxFee2")
	private java.lang.Double taxFee2 ;
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
	public java.lang.Double getAmount() {
		return amount;
	}
	/**
	 * 属性保额/保额的setter方法
	 */
	public void setAmount(java.lang.Double amount) {
		this.amount = amount;
	} 	
	/**
	 * 属性保费/保费的getter方法
	 */
	public java.lang.Double getPremium() {
		return premium;
	}
	/**
	 * 属性保费/保费的setter方法
	 */
	public void setPremium(java.lang.Double premium) {
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
	 * 属性exChangeRate2/exChangeRate2的getter方法
	 */
	public java.lang.Double getExchangeRate1() {
		return exchangeRate1;
	}
	/**
	 * 属性exChangeRate2/exChangeRate2的setter方法
	 */
	public void setExchangeRate1(java.lang.Double exchangeRate1) {
		this.exchangeRate1 = exchangeRate1;
	} 	
	/**
	 * 属性amount2/amount2的getter方法
	 */
	public java.lang.Double getAmount1() {
		return amount1;
	}
	/**
	 * 属性amount2/amount2的setter方法
	 */
	public void setAmount1(java.lang.Double amount1) {
		this.amount1 = amount1;
	} 	
	/**
	 * 属性premium2/premium2的getter方法
	 */
	public java.lang.Double getPremium1() {
		return premium1;
	}
	/**
	 * 属性premium2/premium2的setter方法
	 */
	public void setPremium1(java.lang.Double premium1) {
		this.premium1 = premium1;
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
	 * 属性exChangeRate3/exChangeRate3的getter方法
	 */
	public java.lang.Double getExchangeRate2() {
		return exchangeRate2;
	}
	/**
	 * 属性exChangeRate3/exChangeRate3的setter方法
	 */
	public void setExchangeRate2(java.lang.Double exchangeRate2) {
		this.exchangeRate2 = exchangeRate2;
	} 	
	/**
	 * 属性批改前折合打印币别总保额/批改前折合打印币别总保额的getter方法
	 */
	public java.lang.Double getAmount2() {
		return amount2;
	}
	/**
	 * 属性批改前折合打印币别总保额/批改前折合打印币别总保额的setter方法
	 */
	public void setAmount2(java.lang.Double amount2) {
		this.amount2 = amount2;
	} 	
	/**
	 * 属性批改前折合打印币别总保费/批改前折合打印币别总保费的getter方法
	 */
	public java.lang.Double getPremium2() {
		return premium2;
	}
	/**
	 * 属性批改前折合打印币别总保费/批改前折合打印币别总保费的setter方法
	 */
	public void setPremium2(java.lang.Double premium2) {
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
	public java.lang.Double getNoTaxPremium() {
		return noTaxPremium;
	}
	/**
	 * 属性原币总不含税保费/原币总不含税保费的setter方法
	 */
	public void setNoTaxPremium(java.lang.Double noTaxPremium) {
		this.noTaxPremium = noTaxPremium;
	} 	
	/**
	 * 属性原币总税额/原币总税额的getter方法
	 */
	public java.lang.Double getTaxFee() {
		return taxFee;
	}
	/**
	 * 属性原币总税额/原币总税额的setter方法
	 */
	public void setTaxFee(java.lang.Double taxFee) {
		this.taxFee = taxFee;
	} 	
	/**
	 * 属性折合支付币别总不含税保费/折合支付币别总不含税保费的getter方法
	 */
	public java.lang.Double getNoTaxPremium1() {
		return noTaxPremium1;
	}
	/**
	 * 属性折合支付币别总不含税保费/折合支付币别总不含税保费的setter方法
	 */
	public void setNoTaxPremium1(java.lang.Double noTaxPremium1) {
		this.noTaxPremium1 = noTaxPremium1;
	} 	
	/**
	 * 属性折合支付币别总税额/折合支付币别总税额的getter方法
	 */
	public java.lang.Double getTaxFee1() {
		return taxFee1;
	}
	/**
	 * 属性折合支付币别总税额/折合支付币别总税额的setter方法
	 */
	public void setTaxFee1(java.lang.Double taxFee1) {
		this.taxFee1 = taxFee1;
	} 	
	/**
	 * 属性汇总币别总不含税保费/汇总币别总不含税保费的getter方法
	 */
	public java.lang.Double getNoTaxPremium2() {
		return noTaxPremium2;
	}
	/**
	 * 属性汇总币别总不含税保费/汇总币别总不含税保费的setter方法
	 */
	public void setNoTaxPremium2(java.lang.Double noTaxPremium2) {
		this.noTaxPremium2 = noTaxPremium2;
	} 	
	/**
	 * 属性汇总币别总税额/汇总币别总税额的getter方法
	 */
	public java.lang.Double getTaxFee2() {
		return taxFee2;
	}
	/**
	 * 属性汇总币别总税额/汇总币别总税额的setter方法
	 */
	public void setTaxFee2(java.lang.Double taxFee2) {
		this.taxFee2 = taxFee2;
	} 	
}