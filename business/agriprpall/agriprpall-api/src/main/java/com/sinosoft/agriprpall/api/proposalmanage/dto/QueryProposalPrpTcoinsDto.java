package com.sinosoft.agriprpall.api.proposalmanage.dto;

import com.sinosoft.framework.dto.BaseRequest;

import java.io.Serializable;

/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-10-18 13:10:01.639 
 * 共保信息Api操作对象
 */
public class QueryProposalPrpTcoinsDto extends BaseRequest implements Serializable{
	private static final long serialVersionUID = 1L;
	/** 属性序号/序号 */
	private String serialNo ;		
	/** 属性主保单号码选项/主保单号码选项 */
	private String mainProposalNo ;		
	/** 属性共保身份/共保身份 */
	private String coinsType ;		
	/** 属性是否首席/是否首席 */
	private String chiefFlag ;		
	/** 属性共保人机构代码/共保人机构代码 */
	private String coinsCode ;		
	/** 属性共保人名称/共保人名称 */
	private String coinsName ;		
	/** 属性共保份额/共保份额 */
	private Double coinsRate ;
	/** 属性共保保额/共保保额 */
	private Double coinsAmount ;
	/** 属性共保保费/共保保费 */
	private Double coinsPremium ;
	/**
	 * 属性序号/序号的getter方法
	 */
	public String getSerialNo() {
		return serialNo;
	}
	/**
	 * 属性序号/序号的setter方法
	 */
	public void setSerialNo(String serialNo) {
		this.serialNo = serialNo;
	}	
	/**
	 * 属性主保单号码选项/主保单号码选项的getter方法
	 */
	public String getMainProposalNo() {
		return mainProposalNo;
	}
	/**
	 * 属性主保单号码选项/主保单号码选项的setter方法
	 */
	public void setMainProposalNo(String mainProposalNo) {
		this.mainProposalNo = mainProposalNo;
	}	
	/**
	 * 属性共保身份/共保身份的getter方法
	 */
	public String getCoinsType() {
		return coinsType;
	}
	/**
	 * 属性共保身份/共保身份的setter方法
	 */
	public void setCoinsType(String coinsType) {
		this.coinsType = coinsType;
	}	
	/**
	 * 属性是否首席/是否首席的getter方法
	 */
	public String getChiefFlag() {
		return chiefFlag;
	}
	/**
	 * 属性是否首席/是否首席的setter方法
	 */
	public void setChiefFlag(String chiefFlag) {
		this.chiefFlag = chiefFlag;
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
	 * 属性共保份额/共保份额的getter方法
	 */
	public Double getCoinsRate() {
		return coinsRate;
	}
	/**
	 * 属性共保份额/共保份额的setter方法
	 */
	public void setCoinsRate(Double coinsRate) {
		this.coinsRate = coinsRate;
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
}
