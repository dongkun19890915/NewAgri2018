package com.sinosoft.agriprpall.core.policymanage.entity;

import com.sinosoft.framework.core.dao.BaseEntityImpl;
import javax.persistence.*;
import java.util.Date;

/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-11-05 01:01:20.710 
 * PrpCcoinsDetailOrigin实体操作对象
 */
@Entity
@Table(name = "PrpCcoinsDetailOrigin")
@IdClass(PrpCcoinsDetailOriginKey.class)
public class PrpCcoinsDetailOrigin extends BaseEntityImpl{

	private static final long serialVersionUID = 1L;
	/** 属性保单号/保单号 */
	@Id
	@Column(name = "policyNo")
	private String policyNo ;/** 属性序列号/序列号 */
	@Id
	@Column(name = "serialNo")
	private java.lang.Integer serialNo ;/** 属性币别/币别 */
	@Id
	@Column(name = "currency")
	private String currency ;	


	/** 属性共保人机构代码/共保人机构代码 */
	@Column(name = "coinsCode")
	private String coinsCode ;
	/** 属性共保人名称/共保人名称 */
	@Column(name = "coinsName")
	private String coinsName ;

	/** 属性共保保额/共保保额 */
	@Column(name = "coinsAmount")
	private java.lang.Double coinsAmount ;
	/** 属性共保保费/共保保费 */
	@Column(name = "coinsPremium")
	private java.lang.Double coinsPremium ;
	/** 属性agentFee/agentFee */
	@Column(name = "agentFee")
	private java.lang.Double agentFee ;
	/** 属性operateFee/operateFee */
	@Column(name = "operateFee")
	private java.lang.Double operateFee ;
	/** 属性middlecostfee/middlecostfee */
	@Column(name = "middleCostFee")
	private java.lang.Double middleCostFee ;
	/** 属性备注/备注 */
	@Column(name = "flag")
	private String flag ;
	/** 属性exChangerAtecny/exChangerAtecny */
	@Column(name = "exchangerAteCNY")
	private java.lang.Double exchangerAteCNY ;
	/** 属性currency3/currency3 */
	@Column(name = "currency2")
	private String currency2 ;
	/** 属性planFee3/planFee3 */
	@Column(name = "planFee2")
	private java.lang.Double planFee2 ;
	/** 属性proportionFee/proportionFee */
	@Column(name = "proportionFee")
	private java.lang.Double proportionFee ;
	/** 属性operateFee3/operateFee3 */
	@Column(name = "operateFee2")
	private java.lang.Double operateFee2 ;
	/** 属性amount3/amount3 */
	@Column(name = "amount2")
	private java.lang.Double amount2 ;
	/** 属性agentFee3/agentFee3 */
	@Column(name = "agentFee2")
	private java.lang.Double agentFee2 ;
	/** 属性proposalNo/proposalNo */
	@Column(name = "proposalNo")
	private String proposalNo ;
	/** 属性共保总不含税保费/共保总不含税保费 */
	@Column(name = "coinsNoTaxPremium")
	private java.lang.Double coinsNoTaxPremium ;
	/** 属性共保总税额/共保总税额 */
	@Column(name = "coinsTaxFee")
	private java.lang.Double coinsTaxFee ;
	/** 属性共保不含税出单费/共保不含税出单费 */
	@Column(name = "operateNoTaxPremium")
	private java.lang.Double operateNoTaxPremium ;
	/** 属性共保出单费税率/共保出单费税率 */
	@Column(name = "operateTaxRate")
	private java.lang.Double operateTaxRate ;
	/** 属性共保不含税出单费税额/共保不含税出单费税额 */
	@Column(name = "operateTaxFee")
	private java.lang.Double operateTaxFee ;
	/** 属性共保不含税手续费/共保不含税手续费 */
	@Column(name = "agentNoTaxPremium")
	private java.lang.Double agentNoTaxPremium ;
	/** 属性共保不含税手续费税额/共保不含税手续费税额 */
	@Column(name = "agentTaxFee")
	private java.lang.Double agentTaxFee ;
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
	 * 属性序列号/序列号的getter方法
	 */
	public java.lang.Integer getSerialNo() {
		return serialNo;
	}
	/**
	 * 属性序列号/序列号的setter方法
	 */
	public void setSerialNo(java.lang.Integer serialNo) {
		this.serialNo = serialNo;
	} 	
	/**
	 * 属性共保人机构代码/共保人机构代码的getter方法
	 */
	public String getCoinsCode() {
		return coinsCode;
	}
	/**
	 * 属性共保人机构代码/共保人机构代码的setter方法
	 */
	public void setCoinsCode(String coinsCode) {
		this.coinsCode = coinsCode;
	} 	
	/**
	 * 属性共保人名称/共保人名称的getter方法
	 */
	public String getCoinsName() {
		return coinsName;
	}
	/**
	 * 属性共保人名称/共保人名称的setter方法
	 */
	public void setCoinsName(String coinsName) {
		this.coinsName = coinsName;
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
	 * 属性共保保额/共保保额的getter方法
	 */
	public java.lang.Double getCoinsAmount() {
		return coinsAmount;
	}
	/**
	 * 属性共保保额/共保保额的setter方法
	 */
	public void setCoinsAmount(java.lang.Double coinsAmount) {
		this.coinsAmount = coinsAmount;
	} 	
	/**
	 * 属性共保保费/共保保费的getter方法
	 */
	public java.lang.Double getCoinsPremium() {
		return coinsPremium;
	}
	/**
	 * 属性共保保费/共保保费的setter方法
	 */
	public void setCoinsPremium(java.lang.Double coinsPremium) {
		this.coinsPremium = coinsPremium;
	} 	
	/**
	 * 属性agentFee/agentFee的getter方法
	 */
	public java.lang.Double getAgentFee() {
		return agentFee;
	}
	/**
	 * 属性agentFee/agentFee的setter方法
	 */
	public void setAgentFee(java.lang.Double agentFee) {
		this.agentFee = agentFee;
	} 	
	/**
	 * 属性operateFee/operateFee的getter方法
	 */
	public java.lang.Double getOperateFee() {
		return operateFee;
	}
	/**
	 * 属性operateFee/operateFee的setter方法
	 */
	public void setOperateFee(java.lang.Double operateFee) {
		this.operateFee = operateFee;
	} 	
	/**
	 * 属性middlecostfee/middlecostfee的getter方法
	 */
	public java.lang.Double getMiddleCostFee() {
		return middleCostFee;
	}
	/**
	 * 属性middlecostfee/middlecostfee的setter方法
	 */
	public void setMiddleCostFee(java.lang.Double middleCostFee) {
		this.middleCostFee = middleCostFee;
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
	 * 属性exChangerAtecny/exChangerAtecny的getter方法
	 */
	public java.lang.Double getExchangerAteCNY() {
		return exchangerAteCNY;
	}
	/**
	 * 属性exChangerAtecny/exChangerAtecny的setter方法
	 */
	public void setExchangerAteCNY(java.lang.Double exchangerAteCNY) {
		this.exchangerAteCNY = exchangerAteCNY;
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
	public java.lang.Double getPlanFee2() {
		return planFee2;
	}
	/**
	 * 属性planFee3/planFee3的setter方法
	 */
	public void setPlanFee2(java.lang.Double planFee2) {
		this.planFee2 = planFee2;
	} 	
	/**
	 * 属性proportionFee/proportionFee的getter方法
	 */
	public java.lang.Double getProportionFee() {
		return proportionFee;
	}
	/**
	 * 属性proportionFee/proportionFee的setter方法
	 */
	public void setProportionFee(java.lang.Double proportionFee) {
		this.proportionFee = proportionFee;
	} 	
	/**
	 * 属性operateFee3/operateFee3的getter方法
	 */
	public java.lang.Double getOperateFee2() {
		return operateFee2;
	}
	/**
	 * 属性operateFee3/operateFee3的setter方法
	 */
	public void setOperateFee2(java.lang.Double operateFee2) {
		this.operateFee2 = operateFee2;
	} 	
	/**
	 * 属性amount3/amount3的getter方法
	 */
	public java.lang.Double getAmount2() {
		return amount2;
	}
	/**
	 * 属性amount3/amount3的setter方法
	 */
	public void setAmount2(java.lang.Double amount2) {
		this.amount2 = amount2;
	} 	
	/**
	 * 属性agentFee3/agentFee3的getter方法
	 */
	public java.lang.Double getAgentFee2() {
		return agentFee2;
	}
	/**
	 * 属性agentFee3/agentFee3的setter方法
	 */
	public void setAgentFee2(java.lang.Double agentFee2) {
		this.agentFee2 = agentFee2;
	} 	
	/**
	 * 属性proposalNo/proposalNo的getter方法
	 */
	public String getProposalNo() {
		return proposalNo;
	}
	/**
	 * 属性proposalNo/proposalNo的setter方法
	 */
	public void setProposalNo(String proposalNo) {
		this.proposalNo = proposalNo;
	} 	
	/**
	 * 属性共保总不含税保费/共保总不含税保费的getter方法
	 */
	public java.lang.Double getCoinsNoTaxPremium() {
		return coinsNoTaxPremium;
	}
	/**
	 * 属性共保总不含税保费/共保总不含税保费的setter方法
	 */
	public void setCoinsNoTaxPremium(java.lang.Double coinsNoTaxPremium) {
		this.coinsNoTaxPremium = coinsNoTaxPremium;
	} 	
	/**
	 * 属性共保总税额/共保总税额的getter方法
	 */
	public java.lang.Double getCoinsTaxFee() {
		return coinsTaxFee;
	}
	/**
	 * 属性共保总税额/共保总税额的setter方法
	 */
	public void setCoinsTaxFee(java.lang.Double coinsTaxFee) {
		this.coinsTaxFee = coinsTaxFee;
	} 	
	/**
	 * 属性共保不含税出单费/共保不含税出单费的getter方法
	 */
	public java.lang.Double getOperateNoTaxPremium() {
		return operateNoTaxPremium;
	}
	/**
	 * 属性共保不含税出单费/共保不含税出单费的setter方法
	 */
	public void setOperateNoTaxPremium(java.lang.Double operateNoTaxPremium) {
		this.operateNoTaxPremium = operateNoTaxPremium;
	} 	
	/**
	 * 属性共保出单费税率/共保出单费税率的getter方法
	 */
	public java.lang.Double getOperateTaxRate() {
		return operateTaxRate;
	}
	/**
	 * 属性共保出单费税率/共保出单费税率的setter方法
	 */
	public void setOperateTaxRate(java.lang.Double operateTaxRate) {
		this.operateTaxRate = operateTaxRate;
	} 	
	/**
	 * 属性共保不含税出单费税额/共保不含税出单费税额的getter方法
	 */
	public java.lang.Double getOperateTaxFee() {
		return operateTaxFee;
	}
	/**
	 * 属性共保不含税出单费税额/共保不含税出单费税额的setter方法
	 */
	public void setOperateTaxFee(java.lang.Double operateTaxFee) {
		this.operateTaxFee = operateTaxFee;
	} 	
	/**
	 * 属性共保不含税手续费/共保不含税手续费的getter方法
	 */
	public java.lang.Double getAgentNoTaxPremium() {
		return agentNoTaxPremium;
	}
	/**
	 * 属性共保不含税手续费/共保不含税手续费的setter方法
	 */
	public void setAgentNoTaxPremium(java.lang.Double agentNoTaxPremium) {
		this.agentNoTaxPremium = agentNoTaxPremium;
	} 	
	/**
	 * 属性共保不含税手续费税额/共保不含税手续费税额的getter方法
	 */
	public java.lang.Double getAgentTaxFee() {
		return agentTaxFee;
	}
	/**
	 * 属性共保不含税手续费税额/共保不含税手续费税额的setter方法
	 */
	public void setAgentTaxFee(java.lang.Double agentTaxFee) {
		this.agentTaxFee = agentTaxFee;
	} 	
}