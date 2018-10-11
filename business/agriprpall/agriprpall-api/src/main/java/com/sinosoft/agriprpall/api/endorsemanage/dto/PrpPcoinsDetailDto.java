package com.sinosoft.agriprpall.api.endorsemanage.dto;

import java.io.Serializable;

import com.sinosoft.framework.dto.BaseRequest;
/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-10-28 07:51:01.225 
 * 共保细节表Api操作对象
 */
public class PrpPcoinsDetailDto extends BaseRequest implements Serializable{
	private static final long serialVersionUID = 1L;
	/** 属性批单号/批单号 */
	private String endorseNo ;		
	/** 属性保单号/保单号 */
	private String policyNo ;		
	/** 属性序号/序号 */
	private java.lang.Integer serialNo ;		
	/** 属性coinsCode/coinsCode */
	private String coinsCode ;		
	/** 属性coinsName/coinsName */
	private String coinsName ;		
	/** 属性币别信息/币别信息 */
	private String currency ;		
	/** 属性coinsAmount/coinsAmount */
	private java.lang.Double coinsAmount ;		
	/** 属性coinsPremium/coinsPremium */
	private java.lang.Double coinsPremium ;		
	/** 属性agentFee/agentFee */
	private java.lang.Double agentFee ;		
	/** 属性operateFee/operateFee */
	private java.lang.Double operateFee ;		
	/** 属性chgCoinsAmount/chgCoinsAmount */
	private java.lang.Double chgCoinsAmount ;		
	/** 属性chgCoinsPremium/chgCoinsPremium */
	private java.lang.Double chgCoinsPremium ;		
	/** 属性chgAgentFee/chgAgentFee */
	private java.lang.Double chgAgentFee ;		
	/** 属性chgOperateFee/chgOperateFee */
	private java.lang.Double chgOperateFee ;		
	/** 属性middleCostFee/middleCostFee */
	private java.lang.Double middleCostFee ;		
	/** 属性chgMiddleCostFee/chgMiddleCostFee */
	private java.lang.Double chgMiddleCostFee ;		
	/** 属性标志字段/标志字段 */
	private String flag ;		
	/** 属性currency2/currency2 */
	private String currency2 ;		
	/** 属性exchangeRateCny/exchangeRateCny */
	private java.lang.Double exchangeRateCNY ;
	/** 属性planFee2/planFee2 */
	private java.lang.Double planFee2 ;		
	/** 属性proportionFee/proportionFee */
	private java.lang.Double proportionFee ;		
	/** 属性共保总不含税保费/共保总不含税保费 */
	private java.lang.Double coinsNoTaxPremium ;		
	/** 属性共保总不含税保费变化量/共保总不含税保费变化量 */
	private java.lang.Double chgCoinsNoTaxPremium ;		
	/** 属性共保总税额/共保总税额 */
	private java.lang.Double coinsTaxFee ;		
	/** 属性共保总税额变化量/共保总税额变化量 */
	private java.lang.Double chgCoinsTaxFee ;		
	/** 属性共保不含税出单费/共保不含税出单费 */
	private java.lang.Double operateNoTaxPremium ;		
	/** 属性共保不含税出单费变化量/共保不含税出单费变化量 */
	private java.lang.Double chgOperateNoTaxPremium ;		
	/** 属性共保出单费税率/共保出单费税率 */
	private java.lang.Double operateTaxRate ;		
	/** 属性共保不含税出单费税额/共保不含税出单费税额 */
	private java.lang.Double operateTaxFee ;		
	/** 属性共保不含税出单费变化量1/共保不含税出单费变化量1 */
	private java.lang.Double chgOperateTaxFee ;		
	/** 属性共保不含税手续费/共保不含税手续费 */
	private java.lang.Double agentNoTaxPremium ;		
	/** 属性共保不含税手续费变化量/共保不含税手续费变化量 */
	private java.lang.Double chgAgentNoTaxPremium ;		
	/** 属性共保不含税手续费税额/共保不含税手续费税额 */
	private java.lang.Double agentTaxFee ;		
	/** 属性共保不含税手续费税额1/共保不含税手续费税额1 */
	private java.lang.Double chgAgentTaxFee ;		
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
	public java.lang.Integer getSerialNo() {
		return serialNo;
	}
	/**
	 * 属性序号/序号的setter方法
	 */
	public void setSerialNo(java.lang.Integer serialNo) {
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
	public java.lang.Double getCoinsAmount() {
		return coinsAmount;
	}
	/**
	 * 属性coinsAmount/coinsAmount的setter方法
	 */
	public void setCoinsAmount(java.lang.Double coinsAmount) {
		this.coinsAmount = coinsAmount;
	}	
	/**
	 * 属性coinsPremium/coinsPremium的getter方法
	 */
	public java.lang.Double getCoinsPremium() {
		return coinsPremium;
	}
	/**
	 * 属性coinsPremium/coinsPremium的setter方法
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
	 * 属性chgCoinsAmount/chgCoinsAmount的getter方法
	 */
	public java.lang.Double getChgCoinsAmount() {
		return chgCoinsAmount;
	}
	/**
	 * 属性chgCoinsAmount/chgCoinsAmount的setter方法
	 */
	public void setChgCoinsAmount(java.lang.Double chgCoinsAmount) {
		this.chgCoinsAmount = chgCoinsAmount;
	}	
	/**
	 * 属性chgCoinsPremium/chgCoinsPremium的getter方法
	 */
	public java.lang.Double getChgCoinsPremium() {
		return chgCoinsPremium;
	}
	/**
	 * 属性chgCoinsPremium/chgCoinsPremium的setter方法
	 */
	public void setChgCoinsPremium(java.lang.Double chgCoinsPremium) {
		this.chgCoinsPremium = chgCoinsPremium;
	}	
	/**
	 * 属性chgAgentFee/chgAgentFee的getter方法
	 */
	public java.lang.Double getChgAgentFee() {
		return chgAgentFee;
	}
	/**
	 * 属性chgAgentFee/chgAgentFee的setter方法
	 */
	public void setChgAgentFee(java.lang.Double chgAgentFee) {
		this.chgAgentFee = chgAgentFee;
	}	
	/**
	 * 属性chgOperateFee/chgOperateFee的getter方法
	 */
	public java.lang.Double getChgOperateFee() {
		return chgOperateFee;
	}
	/**
	 * 属性chgOperateFee/chgOperateFee的setter方法
	 */
	public void setChgOperateFee(java.lang.Double chgOperateFee) {
		this.chgOperateFee = chgOperateFee;
	}	
	/**
	 * 属性middleCostFee/middleCostFee的getter方法
	 */
	public java.lang.Double getMiddleCostFee() {
		return middleCostFee;
	}
	/**
	 * 属性middleCostFee/middleCostFee的setter方法
	 */
	public void setMiddleCostFee(java.lang.Double middleCostFee) {
		this.middleCostFee = middleCostFee;
	}	
	/**
	 * 属性chgMiddleCostFee/chgMiddleCostFee的getter方法
	 */
	public java.lang.Double getChgMiddleCostFee() {
		return chgMiddleCostFee;
	}
	/**
	 * 属性chgMiddleCostFee/chgMiddleCostFee的setter方法
	 */
	public void setChgMiddleCostFee(java.lang.Double chgMiddleCostFee) {
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
	public java.lang.Double getPlanFee2() {
		return planFee2;
	}
	/**
	 * 属性planFee2/planFee2的setter方法
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
	 * 属性共保总不含税保费变化量/共保总不含税保费变化量的getter方法
	 */
	public java.lang.Double getChgCoinsNoTaxPremium() {
		return chgCoinsNoTaxPremium;
	}
	/**
	 * 属性共保总不含税保费变化量/共保总不含税保费变化量的setter方法
	 */
	public void setChgCoinsNoTaxPremium(java.lang.Double chgCoinsNoTaxPremium) {
		this.chgCoinsNoTaxPremium = chgCoinsNoTaxPremium;
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
	 * 属性共保总税额变化量/共保总税额变化量的getter方法
	 */
	public java.lang.Double getChgCoinsTaxFee() {
		return chgCoinsTaxFee;
	}
	/**
	 * 属性共保总税额变化量/共保总税额变化量的setter方法
	 */
	public void setChgCoinsTaxFee(java.lang.Double chgCoinsTaxFee) {
		this.chgCoinsTaxFee = chgCoinsTaxFee;
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
	 * 属性共保不含税出单费变化量/共保不含税出单费变化量的getter方法
	 */
	public java.lang.Double getChgOperateNoTaxPremium() {
		return chgOperateNoTaxPremium;
	}
	/**
	 * 属性共保不含税出单费变化量/共保不含税出单费变化量的setter方法
	 */
	public void setChgOperateNoTaxPremium(java.lang.Double chgOperateNoTaxPremium) {
		this.chgOperateNoTaxPremium = chgOperateNoTaxPremium;
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
	 * 属性共保不含税出单费变化量1/共保不含税出单费变化量1的getter方法
	 */
	public java.lang.Double getChgOperateTaxFee() {
		return chgOperateTaxFee;
	}
	/**
	 * 属性共保不含税出单费变化量1/共保不含税出单费变化量1的setter方法
	 */
	public void setChgOperateTaxFee(java.lang.Double chgOperateTaxFee) {
		this.chgOperateTaxFee = chgOperateTaxFee;
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
	 * 属性共保不含税手续费变化量/共保不含税手续费变化量的getter方法
	 */
	public java.lang.Double getChgAgentNoTaxPremium() {
		return chgAgentNoTaxPremium;
	}
	/**
	 * 属性共保不含税手续费变化量/共保不含税手续费变化量的setter方法
	 */
	public void setChgAgentNoTaxPremium(java.lang.Double chgAgentNoTaxPremium) {
		this.chgAgentNoTaxPremium = chgAgentNoTaxPremium;
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
	/**
	 * 属性共保不含税手续费税额1/共保不含税手续费税额1的getter方法
	 */
	public java.lang.Double getChgAgentTaxFee() {
		return chgAgentTaxFee;
	}
	/**
	 * 属性共保不含税手续费税额1/共保不含税手续费税额1的setter方法
	 */
	public void setChgAgentTaxFee(java.lang.Double chgAgentTaxFee) {
		this.chgAgentTaxFee = chgAgentTaxFee;
	}	
}
