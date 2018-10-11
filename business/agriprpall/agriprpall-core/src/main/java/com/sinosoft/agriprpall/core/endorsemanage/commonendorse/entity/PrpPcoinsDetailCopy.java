package com.sinosoft.agriprpall.core.endorsemanage.commonendorse.entity;

import com.sinosoft.framework.core.dao.BaseEntityImpl;
import javax.persistence.*;

/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-10-28 07:51:01.225 
 * 共保细节表实体操作对象
 */
@Entity
@Table(name = "PrpPcoinsDetailCopy")
@IdClass(PrpPcoinsDetailCopyKey.class)
public class PrpPcoinsDetailCopy extends BaseEntityImpl{

	private static final long serialVersionUID = 1L;
	/** 属性批单号/批单号 */
	@Id
	@Column(name = "endorseNo")
	private String endorseNo ;/** 属性序号/序号 */
	@Id
	@Column(name = "serialNo")
	private Integer serialNo ;/** 属性币别信息/币别信息 */
	@Id
	@Column(name = "currency")
	private String currency ;	

	/** 属性保单号/保单号 */
	@Column(name = "policyNo")
	private String policyNo ;

	/** 属性coinsCode/coinsCode */
	@Column(name = "coinsCode")
	private String coinsCode ;
	/** 属性coinsName/coinsName */
	@Column(name = "coinsName")
	private String coinsName ;

	/** 属性coinsAmount/coinsAmount */
	@Column(name = "coinsAmount")
	private Double coinsAmount ;
	/** 属性coinsPremium/coinsPremium */
	@Column(name = "coinsPremium")
	private Double coinsPremium ;
	/** 属性agentFee/agentFee */
	@Column(name = "agentFee")
	private Double agentFee ;
	/** 属性operateFee/operateFee */
	@Column(name = "operateFee")
	private Double operateFee ;
	/** 属性chgCoinsAmount/chgCoinsAmount */
	@Column(name = "chgCoinsAmount")
	private Double chgCoinsAmount ;
	/** 属性chgCoinsPremium/chgCoinsPremium */
	@Column(name = "chgCoinsPremium")
	private Double chgCoinsPremium ;
	/** 属性chgAgentFee/chgAgentFee */
	@Column(name = "chgAgentFee")
	private Double chgAgentFee ;
	/** 属性chgOperateFee/chgOperateFee */
	@Column(name = "chgOperateFee")
	private Double chgOperateFee ;
	/** 属性middleCostFee/middleCostFee */
	@Column(name = "middleCostFee")
	private Double middleCostFee ;
	/** 属性chgMiddleCostFee/chgMiddleCostFee */
	@Column(name = "chgMiddleCostFee")
	private Double chgMiddleCostFee ;
	/** 属性标志字段/标志字段 */
	@Column(name = "flag")
	private String flag ;
	/** 属性currency2/currency2 */
	@Column(name = "currency2")
	private String currency2 ;
	/** 属性exchangeRateCny/exchangeRateCny */
	@Column(name = "exchangeRateCNY")
	private Double exchangeRateCNY ;
	/** 属性planFee2/planFee2 */
	@Column(name = "planFee2")
	private Double planFee2 ;
	/** 属性proportionFee/proportionFee */
	@Column(name = "proportionFee")
	private Double proportionFee ;
	/** 属性共保总不含税保费/共保总不含税保费 */
	@Column(name = "coinsNoTaxPremium")
	private Double coinsNoTaxPremium ;
	/** 属性共保总不含税保费变化量/共保总不含税保费变化量 */
	@Column(name = "chgCoinsNoTaxPremium")
	private Double chgCoinsNoTaxPremium ;
	/** 属性共保总税额/共保总税额 */
	@Column(name = "coinsTaxFee")
	private Double coinsTaxFee ;
	/** 属性共保总税额变化量/共保总税额变化量 */
	@Column(name = "chgCoinsTaxFee")
	private Double chgCoinsTaxFee ;
	/** 属性共保不含税出单费/共保不含税出单费 */
	@Column(name = "operateNoTaxPremium")
	private Double operateNoTaxPremium ;
	/** 属性共保不含税出单费变化量/共保不含税出单费变化量 */
	@Column(name = "chgOperateNoTaxPremium")
	private Double chgOperateNoTaxPremium ;
	/** 属性共保出单费税率/共保出单费税率 */
	@Column(name = "operateTaxRate")
	private Double operateTaxRate ;
	/** 属性共保不含税出单费税额/共保不含税出单费税额 */
	@Column(name = "operateTaxFee")
	private Double operateTaxFee ;
	/** 属性共保不含税出单费变化量1/共保不含税出单费变化量1 */
	@Column(name = "chgOperateTaxFee")
	private Double chgOperateTaxFee ;
	/** 属性共保不含税手续费/共保不含税手续费 */
	@Column(name = "agentNoTaxPremium")
	private Double agentNoTaxPremium ;
	/** 属性共保不含税手续费变化量/共保不含税手续费变化量 */
	@Column(name = "chgAgentNoTaxPremium")
	private Double chgAgentNoTaxPremium ;
	/** 属性共保不含税手续费税额/共保不含税手续费税额 */
	@Column(name = "agentTaxFee")
	private Double agentTaxFee ;
	/** 属性共保不含税手续费税额1/共保不含税手续费税额1 */
	@Column(name = "chgAgentTaxFee")
	private Double chgAgentTaxFee ;
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
	 * 属性序号/序号的getter方法
	 */
	public Integer getSerialNo() {
		return serialNo;
	}
	/**
	 * 属性序号/序号的setter方法
	 */
	public void setSerialNo(Integer serialNo) {
		this.serialNo = serialNo;
	} 	
	/**
	 * 属性coinsCode/coinsCode的getter方法
	 */
	public String getCoinsCode() {
		return coinsCode;
	}
	/**
	 * 属性coinsCode/coinsCode的setter方法
	 */
	public void setCoinsCode(String coinsCode) {
		this.coinsCode = coinsCode;
	} 	
	/**
	 * 属性coinsName/coinsName的getter方法
	 */
	public String getCoinsName() {
		return coinsName;
	}
	/**
	 * 属性coinsName/coinsName的setter方法
	 */
	public void setCoinsName(String coinsName) {
		this.coinsName = coinsName;
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
	 * 属性coinsAmount/coinsAmount的getter方法
	 */
	public Double getCoinsAmount() {
		return coinsAmount;
	}
	/**
	 * 属性coinsAmount/coinsAmount的setter方法
	 */
	public void setCoinsAmount(Double coinsAmount) {
		this.coinsAmount = coinsAmount;
	} 	
	/**
	 * 属性coinsPremium/coinsPremium的getter方法
	 */
	public Double getCoinsPremium() {
		return coinsPremium;
	}
	/**
	 * 属性coinsPremium/coinsPremium的setter方法
	 */
	public void setCoinsPremium(Double coinsPremium) {
		this.coinsPremium = coinsPremium;
	} 	
	/**
	 * 属性agentFee/agentFee的getter方法
	 */
	public Double getAgentFee() {
		return agentFee;
	}
	/**
	 * 属性agentFee/agentFee的setter方法
	 */
	public void setAgentFee(Double agentFee) {
		this.agentFee = agentFee;
	} 	
	/**
	 * 属性operateFee/operateFee的getter方法
	 */
	public Double getOperateFee() {
		return operateFee;
	}
	/**
	 * 属性operateFee/operateFee的setter方法
	 */
	public void setOperateFee(Double operateFee) {
		this.operateFee = operateFee;
	} 	
	/**
	 * 属性chgCoinsAmount/chgCoinsAmount的getter方法
	 */
	public Double getChgCoinsAmount() {
		return chgCoinsAmount;
	}
	/**
	 * 属性chgCoinsAmount/chgCoinsAmount的setter方法
	 */
	public void setChgCoinsAmount(Double chgCoinsAmount) {
		this.chgCoinsAmount = chgCoinsAmount;
	} 	
	/**
	 * 属性chgCoinsPremium/chgCoinsPremium的getter方法
	 */
	public Double getChgCoinsPremium() {
		return chgCoinsPremium;
	}
	/**
	 * 属性chgCoinsPremium/chgCoinsPremium的setter方法
	 */
	public void setChgCoinsPremium(Double chgCoinsPremium) {
		this.chgCoinsPremium = chgCoinsPremium;
	} 	
	/**
	 * 属性chgAgentFee/chgAgentFee的getter方法
	 */
	public Double getChgAgentFee() {
		return chgAgentFee;
	}
	/**
	 * 属性chgAgentFee/chgAgentFee的setter方法
	 */
	public void setChgAgentFee(Double chgAgentFee) {
		this.chgAgentFee = chgAgentFee;
	} 	
	/**
	 * 属性chgOperateFee/chgOperateFee的getter方法
	 */
	public Double getChgOperateFee() {
		return chgOperateFee;
	}
	/**
	 * 属性chgOperateFee/chgOperateFee的setter方法
	 */
	public void setChgOperateFee(Double chgOperateFee) {
		this.chgOperateFee = chgOperateFee;
	} 	
	/**
	 * 属性middleCostFee/middleCostFee的getter方法
	 */
	public Double getMiddleCostFee() {
		return middleCostFee;
	}
	/**
	 * 属性middleCostFee/middleCostFee的setter方法
	 */
	public void setMiddleCostFee(Double middleCostFee) {
		this.middleCostFee = middleCostFee;
	} 	
	/**
	 * 属性chgMiddleCostFee/chgMiddleCostFee的getter方法
	 */
	public Double getChgMiddleCostFee() {
		return chgMiddleCostFee;
	}
	/**
	 * 属性chgMiddleCostFee/chgMiddleCostFee的setter方法
	 */
	public void setChgMiddleCostFee(Double chgMiddleCostFee) {
		this.chgMiddleCostFee = chgMiddleCostFee;
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

	public Double getExchangeRateCNY() {
		return exchangeRateCNY;
	}

	public void setExchangeRateCNY(Double exchangeRateCNY) {
		this.exchangeRateCNY = exchangeRateCNY;
	}

	/**
	 * 属性planFee2/planFee2的getter方法
	 */
	public Double getPlanFee2() {
		return planFee2;
	}
	/**
	 * 属性planFee2/planFee2的setter方法
	 */
	public void setPlanFee2(Double planFee2) {
		this.planFee2 = planFee2;
	} 	
	/**
	 * 属性proportionFee/proportionFee的getter方法
	 */
	public Double getProportionFee() {
		return proportionFee;
	}
	/**
	 * 属性proportionFee/proportionFee的setter方法
	 */
	public void setProportionFee(Double proportionFee) {
		this.proportionFee = proportionFee;
	} 	
	/**
	 * 属性共保总不含税保费/共保总不含税保费的getter方法
	 */
	public Double getCoinsNoTaxPremium() {
		return coinsNoTaxPremium;
	}
	/**
	 * 属性共保总不含税保费/共保总不含税保费的setter方法
	 */
	public void setCoinsNoTaxPremium(Double coinsNoTaxPremium) {
		this.coinsNoTaxPremium = coinsNoTaxPremium;
	} 	
	/**
	 * 属性共保总不含税保费变化量/共保总不含税保费变化量的getter方法
	 */
	public Double getChgCoinsNoTaxPremium() {
		return chgCoinsNoTaxPremium;
	}
	/**
	 * 属性共保总不含税保费变化量/共保总不含税保费变化量的setter方法
	 */
	public void setChgCoinsNoTaxPremium(Double chgCoinsNoTaxPremium) {
		this.chgCoinsNoTaxPremium = chgCoinsNoTaxPremium;
	} 	
	/**
	 * 属性共保总税额/共保总税额的getter方法
	 */
	public Double getCoinsTaxFee() {
		return coinsTaxFee;
	}
	/**
	 * 属性共保总税额/共保总税额的setter方法
	 */
	public void setCoinsTaxFee(Double coinsTaxFee) {
		this.coinsTaxFee = coinsTaxFee;
	} 	
	/**
	 * 属性共保总税额变化量/共保总税额变化量的getter方法
	 */
	public Double getChgCoinsTaxFee() {
		return chgCoinsTaxFee;
	}
	/**
	 * 属性共保总税额变化量/共保总税额变化量的setter方法
	 */
	public void setChgCoinsTaxFee(Double chgCoinsTaxFee) {
		this.chgCoinsTaxFee = chgCoinsTaxFee;
	} 	
	/**
	 * 属性共保不含税出单费/共保不含税出单费的getter方法
	 */
	public Double getOperateNoTaxPremium() {
		return operateNoTaxPremium;
	}
	/**
	 * 属性共保不含税出单费/共保不含税出单费的setter方法
	 */
	public void setOperateNoTaxPremium(Double operateNoTaxPremium) {
		this.operateNoTaxPremium = operateNoTaxPremium;
	} 	
	/**
	 * 属性共保不含税出单费变化量/共保不含税出单费变化量的getter方法
	 */
	public Double getChgOperateNoTaxPremium() {
		return chgOperateNoTaxPremium;
	}
	/**
	 * 属性共保不含税出单费变化量/共保不含税出单费变化量的setter方法
	 */
	public void setChgOperateNoTaxPremium(Double chgOperateNoTaxPremium) {
		this.chgOperateNoTaxPremium = chgOperateNoTaxPremium;
	} 	
	/**
	 * 属性共保出单费税率/共保出单费税率的getter方法
	 */
	public Double getOperateTaxRate() {
		return operateTaxRate;
	}
	/**
	 * 属性共保出单费税率/共保出单费税率的setter方法
	 */
	public void setOperateTaxRate(Double operateTaxRate) {
		this.operateTaxRate = operateTaxRate;
	} 	
	/**
	 * 属性共保不含税出单费税额/共保不含税出单费税额的getter方法
	 */
	public Double getOperateTaxFee() {
		return operateTaxFee;
	}
	/**
	 * 属性共保不含税出单费税额/共保不含税出单费税额的setter方法
	 */
	public void setOperateTaxFee(Double operateTaxFee) {
		this.operateTaxFee = operateTaxFee;
	} 	
	/**
	 * 属性共保不含税出单费变化量1/共保不含税出单费变化量1的getter方法
	 */
	public Double getChgOperateTaxFee() {
		return chgOperateTaxFee;
	}
	/**
	 * 属性共保不含税出单费变化量1/共保不含税出单费变化量1的setter方法
	 */
	public void setChgOperateTaxFee(Double chgOperateTaxFee) {
		this.chgOperateTaxFee = chgOperateTaxFee;
	} 	
	/**
	 * 属性共保不含税手续费/共保不含税手续费的getter方法
	 */
	public Double getAgentNoTaxPremium() {
		return agentNoTaxPremium;
	}
	/**
	 * 属性共保不含税手续费/共保不含税手续费的setter方法
	 */
	public void setAgentNoTaxPremium(Double agentNoTaxPremium) {
		this.agentNoTaxPremium = agentNoTaxPremium;
	} 	
	/**
	 * 属性共保不含税手续费变化量/共保不含税手续费变化量的getter方法
	 */
	public Double getChgAgentNoTaxPremium() {
		return chgAgentNoTaxPremium;
	}
	/**
	 * 属性共保不含税手续费变化量/共保不含税手续费变化量的setter方法
	 */
	public void setChgAgentNoTaxPremium(Double chgAgentNoTaxPremium) {
		this.chgAgentNoTaxPremium = chgAgentNoTaxPremium;
	} 	
	/**
	 * 属性共保不含税手续费税额/共保不含税手续费税额的getter方法
	 */
	public Double getAgentTaxFee() {
		return agentTaxFee;
	}
	/**
	 * 属性共保不含税手续费税额/共保不含税手续费税额的setter方法
	 */
	public void setAgentTaxFee(Double agentTaxFee) {
		this.agentTaxFee = agentTaxFee;
	} 	
	/**
	 * 属性共保不含税手续费税额1/共保不含税手续费税额1的getter方法
	 */
	public Double getChgAgentTaxFee() {
		return chgAgentTaxFee;
	}
	/**
	 * 属性共保不含税手续费税额1/共保不含税手续费税额1的setter方法
	 */
	public void setChgAgentTaxFee(Double chgAgentTaxFee) {
		this.chgAgentTaxFee = chgAgentTaxFee;
	} 	
}