package com.sinosoft.agriprpall.api.policymanage.dto;

import com.sinosoft.framework.dto.BaseRequest;

import java.io.Serializable;
/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-11-04 09:53:57.649 
 * 共保危险单位表Api操作对象
 */
public class PrpCdangerCoinsDto extends BaseRequest implements Serializable{
	private static final long serialVersionUID = 1L;
	/** 属性保单号/保单号 */
	private String policyNo ;		
	/** 属性dangerNo/dangerNo */
	private java.lang.Integer dangerNo ;		
	/** 属性序号/序号 */
	private java.lang.Integer serialNo ;		
	/** 属性mainProposalNo/mainProposalNo */
    private String mainPolicyNo;
    /** 属性coinsCode/coinsCode */
	private String coinsCode ;		
	/** 属性coinsName/coinsName */
	private String coinsName ;		
	/** 属性coinsType/coinsType */
	private String coinsType ;		
	/** 属性coinsRate/coinsRate */
	private java.lang.Double coinsRate ;		
	/** 属性chiefFlag/chiefFlag */
	private String chiefFlag ;		
	/** 属性proportionFlag/proportionFlag */
	private String proportionFlag ;		
	/** 属性currency/currency */
	private String currency ;		
	/** 属性coinsAmount/coinsAmount */
	private java.lang.Double coinsAmount ;		
	/** 属性coinsPremium/coinsPremium */
	private java.lang.Double coinsPremium ;		
	/** 属性middleCostFee/middleCostFee */
	private java.lang.Double middleCostFee ;		
	/** 属性标志字段/标志字段 */
	private String flag ;		
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
	 * 属性dangerNo/dangerNo的getter方法
	 */
	public java.lang.Integer getDangerNo() {
		return dangerNo;
	}
	/**
	 * 属性dangerNo/dangerNo的setter方法
	 */
	public void setDangerNo(java.lang.Integer dangerNo) {
		this.dangerNo = dangerNo;
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

    public String getMainPolicyNo() {
        return mainPolicyNo;
    }

    public void setMainPolicyNo(String mainPolicyNo) {
        this.mainPolicyNo = mainPolicyNo;
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
	public java.lang.Double getCoinsRate() {
		return coinsRate;
	}
	/**
	 * 属性coinsRate/coinsRate的setter方法
	 */
	public void setCoinsRate(java.lang.Double coinsRate) {
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
