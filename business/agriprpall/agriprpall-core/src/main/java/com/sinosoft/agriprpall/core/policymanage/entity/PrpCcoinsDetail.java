package com.sinosoft.agriprpall.core.policymanage.entity;

import com.sinosoft.agriprpall.core.proposalmanage.entity.PrpTcoinsDetail;
import com.sinosoft.framework.core.dao.BaseEntityImpl;
import javax.persistence.*;
import java.util.Date;

/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-10-24 07:46:04.010 
 * 共保信息明细表实体操作对象
 */
@Entity
@Table(name = "PrpCcoinsDetail")
@IdClass(PrpCcoinsDetailKey.class)
public class PrpCcoinsDetail extends BaseEntityImpl{

	private static final long serialVersionUID = 1L;
	/** 属性保单号/保单号 */
	@Id
	@Column(name = "policyNo")
	private String policyNo ;/** 属性序列号/序列号 */
	@Id
	@Column(name = "serialNo")
	private Integer serialNo ;/** 属性币别/币别 */
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
	private Double coinsAmount ;
	/** 属性共保保费/共保保费 */
	@Column(name = "coinsPremium")
	private Double coinsPremium ;
	/** 属性agentFee/agentFee */
	@Column(name = "agentFee")
	private Double agentFee ;
	/** 属性operateFee/operateFee */
	@Column(name = "operateFee")
	private Double operateFee ;
	/** 属性备注/备注 */
	@Column(name = "flag")
	private String flag ;
	/** 属性middleCostFee/middleCostFee */
	@Column(name = "middleCostFee")
	private Double middleCostFee ;
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
	/** 属性共保总税额/共保总税额 */
	@Column(name = "coinsTaxFee")
	private Double coinsTaxFee ;
	/** 属性共保不含税出单费/共保不含税出单费 */
	@Column(name = "operateNoTaxPremium")
	private Double operateNoTaxPremium ;
	/** 属性共保出单费税率/共保出单费税率 */
	@Column(name = "operateTaxRate")
	private Double operateTaxRate ;
	/** 属性共保不含税出单费税额/共保不含税出单费税额 */
	@Column(name = "operateTaxFee")
	private Double operateTaxFee ;
	/** 属性共保不含税手续费/共保不含税手续费 */
	@Column(name = "agentNoTaxPremium")
	private Double agentNoTaxPremium ;
	/** 属性共保不含税手续费税额/共保不含税手续费税额 */
	@Column(name = "agentTaxFee")
	private Double agentTaxFee ;
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
	public Integer getSerialNo() {
		return serialNo;
	}
	/**
	 * 属性序列号/序列号的setter方法
	 */
	public void setSerialNo(Integer serialNo) {
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
	public Double getCoinsAmount() {
		return coinsAmount;
	}
	/**
	 * 属性共保保额/共保保额的setter方法
	 */
	public void setCoinsAmount(Double coinsAmount) {
		this.coinsAmount = coinsAmount;
	} 	
	/**
	 * 属性共保保费/共保保费的getter方法
	 */
	public Double getCoinsPremium() {
		return coinsPremium;
	}
	/**
	 * 属性共保保费/共保保费的setter方法
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
	 * PrpTcoinsDetailToPrpCcoinsDetail
	 */
	public void setPrpTcoinsDetailToPrpCcoinsDetail(PrpTcoinsDetail prpTcoinsDetail){
		this.serialNo =prpTcoinsDetail.getSerialNo();
		this.coinsCode =prpTcoinsDetail.getCoinsCode();
		this.coinsName =prpTcoinsDetail.getCoinsName();
		this.currency =prpTcoinsDetail.getCurrency();
		this.coinsAmount =prpTcoinsDetail.getCoinsAmount();
		this.coinsPremium =prpTcoinsDetail.getCoinsPremium();
		this.agentFee =prpTcoinsDetail.getAgentFee();
		this.operateFee =prpTcoinsDetail.getOperateFee();
		this.flag =prpTcoinsDetail.getFlag();
		this.middleCostFee =prpTcoinsDetail.getMiddleCostFee();
		this.currency2 =prpTcoinsDetail.getCurrency2();
		this.exchangeRateCNY =prpTcoinsDetail.getExchangeRateCNY();
		this.planFee2 =prpTcoinsDetail.getPlanFee2();
		this.proportionFee =prpTcoinsDetail.getProportionFee();
		this.coinsNoTaxPremium =prpTcoinsDetail.getCoinsNoTaxPremium();
		this.coinsTaxFee =prpTcoinsDetail.getCoinsTaxFee();
		this.operateNoTaxPremium =prpTcoinsDetail.getOperateNoTaxPremium();
		this.operateTaxRate =prpTcoinsDetail.getOperateTaxRate();
		this.operateTaxFee =prpTcoinsDetail.getOperateTaxFee();
		this.agentNoTaxPremium =prpTcoinsDetail.getAgentNoTaxPremium();
		this.agentTaxFee =prpTcoinsDetail.getAgentTaxFee();
	}
}