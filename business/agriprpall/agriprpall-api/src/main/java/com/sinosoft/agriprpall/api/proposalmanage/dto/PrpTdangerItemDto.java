package com.sinosoft.agriprpall.api.proposalmanage.dto;

import java.io.Serializable;

import com.sinosoft.framework.dto.BaseRequest;
/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-11-04 09:41:15.792 
 * 投保单危险单位划分表Api操作对象
 */
public class PrpTdangerItemDto extends BaseRequest implements Serializable{
	private static final long serialVersionUID = 1L;
	/** 属性投保单号/投保单号 */
	private String proposalNo ;		
	/** 属性险种代码/险种代码 */
	private String riskCode ;		
	/** 属性危险单位序号/危险单位序号 */
	private java.lang.Integer dangerNo ;		
	/** 属性序号/序号 */
	private java.lang.Integer serialNo ;		
	/** 属性险别归类标志/险别归类标志 */
	private String kindFlag ;		
	/** 属性kindCode/kindCode */
	private String kindCode ;		
	/** 属性险别归类名称/险别归类名称 */
	private String kindName ;		
	/** 属性itemCode/itemCode */
	private String itemCode ;		
	/** 属性itemDetailName/itemDetailName */
	private String itemDetailName ;		
	/** 属性postCode/postCode */
	private String postCode ;		
	/** 属性addressName/addressName */
	private String addressName ;		
	/** 属性currency/currency */
	private String currency ;		
	/** 属性amount/amount */
	private java.lang.Double amount ;		
	/** 属性premium/premium */
	private java.lang.Double premium ;		
	/** 属性calculateFlag/calculateFlag */
	private String calculateFlag ;		
	/** 属性flag/flag */
	private String flag ;		
	/** 属性险别占比/险别占比 */
	private java.lang.Double dangerKindShare ;		
	/** 属性不含税保费/不含税保费 */
	private java.lang.Double noTaxPremium ;		
	/** 属性应/免税标识，1-应税，2-免税/应/免税标识，1-应税，2-免税 */
	private String taxFlag ;		
	/** 属性税率/税率 */
	private java.lang.Double vatTaxRate ;		
	/** 属性税额/税额 */
	private java.lang.Double taxFee ;		
	/**
	 * 属性投保单号/投保单号的getter方法
	 */
	public String getProposalNo() {
		return proposalNo;
	}
	/**
	 * 属性投保单号/投保单号的setter方法
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
	 * 属性危险单位序号/危险单位序号的getter方法
	 */
	public java.lang.Integer getDangerNo() {
		return dangerNo;
	}
	/**
	 * 属性危险单位序号/危险单位序号的setter方法
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
	/**
	 * 属性险别归类标志/险别归类标志的getter方法
	 */
	public String getKindFlag() {
		return kindFlag;
	}
	/**
	 * 属性险别归类标志/险别归类标志的setter方法
	 */
	public void setKindFlag(String kindFlag) {
		this.kindFlag = kindFlag;
	}	
	/**
	 * 属性kindCode/kindCode的getter方法
	 */
	public String getKindCode() {
		return kindCode;
	}
	/**
	 * 属性kindCode/kindCode的setter方法
	 */
	public void setKindCode(String kindCode) {
		this.kindCode = kindCode;
	}	
	/**
	 * 属性险别归类名称/险别归类名称的getter方法
	 */
	public String getKindName() {
		return kindName;
	}
	/**
	 * 属性险别归类名称/险别归类名称的setter方法
	 */
	public void setKindName(String kindName) {
		this.kindName = kindName;
	}	
	/**
	 * 属性itemCode/itemCode的getter方法
	 */
	public String getItemCode() {
		return itemCode;
	}
	/**
	 * 属性itemCode/itemCode的setter方法
	 */
	public void setItemCode(String itemCode) {
		this.itemCode = itemCode;
	}	
	/**
	 * 属性itemDetailName/itemDetailName的getter方法
	 */
	public String getItemDetailName() {
		return itemDetailName;
	}
	/**
	 * 属性itemDetailName/itemDetailName的setter方法
	 */
	public void setItemDetailName(String itemDetailName) {
		this.itemDetailName = itemDetailName;
	}	
	/**
	 * 属性postCode/postCode的getter方法
	 */
	public String getPostCode() {
		return postCode;
	}
	/**
	 * 属性postCode/postCode的setter方法
	 */
	public void setPostCode(String postCode) {
		this.postCode = postCode;
	}	
	/**
	 * 属性addressName/addressName的getter方法
	 */
	public String getAddressName() {
		return addressName;
	}
	/**
	 * 属性addressName/addressName的setter方法
	 */
	public void setAddressName(String addressName) {
		this.addressName = addressName;
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
	 * 属性amount/amount的getter方法
	 */
	public java.lang.Double getAmount() {
		return amount;
	}
	/**
	 * 属性amount/amount的setter方法
	 */
	public void setAmount(java.lang.Double amount) {
		this.amount = amount;
	}	
	/**
	 * 属性premium/premium的getter方法
	 */
	public java.lang.Double getPremium() {
		return premium;
	}
	/**
	 * 属性premium/premium的setter方法
	 */
	public void setPremium(java.lang.Double premium) {
		this.premium = premium;
	}	
	/**
	 * 属性calculateFlag/calculateFlag的getter方法
	 */
	public String getCalculateFlag() {
		return calculateFlag;
	}
	/**
	 * 属性calculateFlag/calculateFlag的setter方法
	 */
	public void setCalculateFlag(String calculateFlag) {
		this.calculateFlag = calculateFlag;
	}	
	/**
	 * 属性flag/flag的getter方法
	 */
	public String getFlag() {
		return flag;
	}
	/**
	 * 属性flag/flag的setter方法
	 */
	public void setFlag(String flag) {
		this.flag = flag;
	}	
	/**
	 * 属性险别占比/险别占比的getter方法
	 */
	public java.lang.Double getDangerKindShare() {
		return dangerKindShare;
	}
	/**
	 * 属性险别占比/险别占比的setter方法
	 */
	public void setDangerKindShare(java.lang.Double dangerKindShare) {
		this.dangerKindShare = dangerKindShare;
	}	
	/**
	 * 属性不含税保费/不含税保费的getter方法
	 */
	public java.lang.Double getNoTaxPremium() {
		return noTaxPremium;
	}
	/**
	 * 属性不含税保费/不含税保费的setter方法
	 */
	public void setNoTaxPremium(java.lang.Double noTaxPremium) {
		this.noTaxPremium = noTaxPremium;
	}	
	/**
	 * 属性应/免税标识，1-应税，2-免税/应/免税标识，1-应税，2-免税的getter方法
	 */
	public String getTaxFlag() {
		return taxFlag;
	}
	/**
	 * 属性应/免税标识，1-应税，2-免税/应/免税标识，1-应税，2-免税的setter方法
	 */
	public void setTaxFlag(String taxFlag) {
		this.taxFlag = taxFlag;
	}	
	/**
	 * 属性税率/税率的getter方法
	 */
	public java.lang.Double getVatTaxRate() {
		return vatTaxRate;
	}
	/**
	 * 属性税率/税率的setter方法
	 */
	public void setVatTaxRate(java.lang.Double vatTaxRate) {
		this.vatTaxRate = vatTaxRate;
	}	
	/**
	 * 属性税额/税额的getter方法
	 */
	public java.lang.Double getTaxFee() {
		return taxFee;
	}
	/**
	 * 属性税额/税额的setter方法
	 */
	public void setTaxFee(java.lang.Double taxFee) {
		this.taxFee = taxFee;
	}	
}
