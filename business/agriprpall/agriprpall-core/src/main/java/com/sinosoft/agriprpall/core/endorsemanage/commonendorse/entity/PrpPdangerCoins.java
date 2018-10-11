package com.sinosoft.agriprpall.core.endorsemanage.commonendorse.entity;

import com.sinosoft.framework.core.dao.BaseEntityImpl;

import javax.persistence.*;

/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-11-04 10:07:09.217 
 * 共保危险单位表实体操作对象
 */
@Entity
@Table(name = "PrpPdangerCoins")
@IdClass(PrpPdangerCoinsKey.class)
public class PrpPdangerCoins extends BaseEntityImpl{

	private static final long serialVersionUID = 1L;
	/** 属性批单号/批单号 */
	@Id
	@Column(name = "endorseNo")
	private String endorseNo ;/** 属性dangerNo/dangerNo */
	@Id
	@Column(name = "dangerNo")
	private Integer dangerNo ;/** 属性序号/序号 */
	@Id
	@Column(name = "serialNo")
	private Integer serialNo ;



	/** 属性mainProposalNo/mainProposalNo */
	@Column(name = "mainProposalNo")
	private String mainProposalNo ;
	/** 属性coinsCode/coinsCode */
	@Column(name = "coinsCode")
	private String coinsCode ;
	/** 属性coinsName/coinsName */
	@Column(name = "coinsName")
	private String coinsName ;
	/** 属性coinsType/coinsType */
	@Column(name = "coinsType")
	private String coinsType ;
	/** 属性coinsRate/coinsRate */
	@Column(name = "coinsRate")
	private Double coinsRate ;
	/** 属性chiefFlag/chiefFlag */
	@Column(name = "chiefFlag")
	private String chiefFlag ;
	/** 属性proportionFlag/proportionFlag */
	@Column(name = "proportionFlag")
	private String proportionFlag ;
	/** 属性currency/currency */
	@Column(name = "currency")
	private String currency ;
	/** 属性coinsAmount/coinsAmount */
	@Column(name = "coinsAmount")
	private Double coinsAmount ;
	/** 属性coinsPremium/coinsPremium */
	@Column(name = "coinsPremium")
	private Double coinsPremium ;
	/** 属性disFee/disFee */
	@Column(name = "disFee")
	private Double disFee ;
	/** 属性chgCoinsAmount/chgCoinsAmount */
	@Column(name = "chgCoinsAmount")
	private Double chgCoinsAmount ;
	/** 属性chgCoinsPremium/chgCoinsPremium */
	@Column(name = "chgCoinsPremium")
	private Double chgCoinsPremium ;
	/** 属性middleCostFee/middleCostFee */
	@Column(name = "middleCostFee")
	private Double middleCostFee ;
	/** 属性chgMiddleCostFee/chgMiddleCostFee */
	@Column(name = "chgMiddleCostFee")
	private Double chgMiddleCostFee ;
	/** 属性标志字段/标志字段 */
	@Column(name = "flag")
	private String flag ;
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
	 * 属性dangerNo/dangerNo的getter方法
	 */
	public Integer getDangerNo() {
		return dangerNo;
	}
	/**
	 * 属性dangerNo/dangerNo的setter方法
	 */
	public void setDangerNo(Integer dangerNo) {
		this.dangerNo = dangerNo;
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
	 * 属性mainProposalNo/mainProposalNo的getter方法
	 */
	public String getMainProposalNo() {
		return mainProposalNo;
	}
	/**
	 * 属性mainProposalNo/mainProposalNo的setter方法
	 */
	public void setMainProposalNo(String mainProposalNo) {
		this.mainProposalNo = mainProposalNo;
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
	 * 属性coinsType/coinsType的getter方法
	 */
	public String getCoinsType() {
		return coinsType;
	}
	/**
	 * 属性coinsType/coinsType的setter方法
	 */
	public void setCoinsType(String coinsType) {
		this.coinsType = coinsType;
	} 	
	/**
	 * 属性coinsRate/coinsRate的getter方法
	 */
	public Double getCoinsRate() {
		return coinsRate;
	}
	/**
	 * 属性coinsRate/coinsRate的setter方法
	 */
	public void setCoinsRate(Double coinsRate) {
		this.coinsRate = coinsRate;
	} 	
	/**
	 * 属性chiefFlag/chiefFlag的getter方法
	 */
	public String getChiefFlag() {
		return chiefFlag;
	}
	/**
	 * 属性chiefFlag/chiefFlag的setter方法
	 */
	public void setChiefFlag(String chiefFlag) {
		this.chiefFlag = chiefFlag;
	} 	
	/**
	 * 属性proportionFlag/proportionFlag的getter方法
	 */
	public String getProportionFlag() {
		return proportionFlag;
	}
	/**
	 * 属性proportionFlag/proportionFlag的setter方法
	 */
	public void setProportionFlag(String proportionFlag) {
		this.proportionFlag = proportionFlag;
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
	 * 属性disFee/disFee的getter方法
	 */
	public Double getDisFee() {
		return disFee;
	}
	/**
	 * 属性disFee/disFee的setter方法
	 */
	public void setDisFee(Double disFee) {
		this.disFee = disFee;
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
}