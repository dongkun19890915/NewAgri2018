package com.sinosoft.agriprpall.api.undwrtsubmit.dto;

import java.io.Serializable;

import com.sinosoft.framework.dto.BaseRequest;
/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-10-18 03:18:29.180 
 * 投保单危险单位划分表Api操作对象
 */
public class PrpTdangerItemDto extends BaseRequest implements Serializable{
	private static final long serialVersionUID = 1L;
	/** 属性投保单号码/投保单号码 */
	private String proposalNo ;		
	/** 属性险种代码/险种代码 */
	private String riskCode ;		
	/** 属性危险单位序号 /危险单位序号  */
	private Integer dangerNo ;
	/** 属性serialNo/serialNo */
	private Integer serialNo ;
	/** 属性险别归类标志/险别归类标志 */
	private String kindFlag ;		
	/** 属性kindCode/kindCode */
	private String kindCode ;		
	/** 属性--** 险别归类名称/--** 险别归类名称 */
	private String kindName ;		
	/** 属性itemCode/itemCode */
	private String itemCode ;		
	/** 属性itemdetailName/itemdetailName */
	private String itemdetailName ;		
	/** 属性postCode/postCode */
	private String postCode ;		
	/** 属性addressName/addressName */
	private String addressName ;		
	/** 属性currency/currency */
	private String currency ;		
	/** 属性amount/amount */
	private Double amount ;
	/** 属性premium/premium */
	private Double premium ;
	/** 属性calculateFlag/calculateFlag */
	private String calculateFlag ;		
	/** 属性flag/flag */
	private String flag ;		
	/** 属性险别占比/险别占比 */
	private Double dangerKindShare ;
	/** 属性不含税保费/不含税保费 */
	private Double noTaxPremium ;
	/** 属性应/免税标识/应/免税标识 */
	private String taxFlag ;		
	/** 属性税率/税率 */
	private Double vattaxRate ;
	/** 属性税额/税额 */
	private Double taxFee ;
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
	 * 属性危险单位序号 /危险单位序号 的getter方法
	 */
	public Integer getDangerNo() {
		return dangerNo;
	}
	/**
	 * 属性危险单位序号 /危险单位序号 的setter方法
	 */
	public void setDangerNo(Integer dangerNo) {
		this.dangerNo = dangerNo;
	}	
	/**
	 * 属性serialNo/serialNo的getter方法
	 */
	public Integer getSerialNo() {
		return serialNo;
	}
	/**
	 * 属性serialNo/serialNo的setter方法
	 */
	public void setSerialNo(Integer serialNo) {
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
	 * 属性--** 险别归类名称/--** 险别归类名称的getter方法
	 */
	public String getKindName() {
		return kindName;
	}
	/**
	 * 属性--** 险别归类名称/--** 险别归类名称的setter方法
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
	 * 属性itemdetailName/itemdetailName的getter方法
	 */
	public String getItemdetailName() {
		return itemdetailName;
	}
	/**
	 * 属性itemdetailName/itemdetailName的setter方法
	 */
	public void setItemdetailName(String itemdetailName) {
		this.itemdetailName = itemdetailName;
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
	public Double getAmount() {
		return amount;
	}
	/**
	 * 属性amount/amount的setter方法
	 */
	public void setAmount(Double amount) {
		this.amount = amount;
	}	
	/**
	 * 属性premium/premium的getter方法
	 */
	public Double getPremium() {
		return premium;
	}
	/**
	 * 属性premium/premium的setter方法
	 */
	public void setPremium(Double premium) {
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
	public Double getDangerKindShare() {
		return dangerKindShare;
	}
	/**
	 * 属性险别占比/险别占比的setter方法
	 */
	public void setDangerKindShare(Double dangerKindShare) {
		this.dangerKindShare = dangerKindShare;
	}	
	/**
	 * 属性不含税保费/不含税保费的getter方法
	 */
	public Double getNoTaxPremium() {
		return noTaxPremium;
	}
	/**
	 * 属性不含税保费/不含税保费的setter方法
	 */
	public void setNoTaxPremium(Double noTaxPremium) {
		this.noTaxPremium = noTaxPremium;
	}	
	/**
	 * 属性应/免税标识/应/免税标识的getter方法
	 */
	public String getTaxFlag() {
		return taxFlag;
	}
	/**
	 * 属性应/免税标识/应/免税标识的setter方法
	 */
	public void setTaxFlag(String taxFlag) {
		this.taxFlag = taxFlag;
	}	
	/**
	 * 属性税率/税率的getter方法
	 */
	public Double getVattaxRate() {
		return vattaxRate;
	}
	/**
	 * 属性税率/税率的setter方法
	 */
	public void setVattaxRate(Double vattaxRate) {
		this.vattaxRate = vattaxRate;
	}	
	/**
	 * 属性税额/税额的getter方法
	 */
	public Double getTaxFee() {
		return taxFee;
	}
	/**
	 * 属性税额/税额的setter方法
	 */
	public void setTaxFee(Double taxFee) {
		this.taxFee = taxFee;
	}	
}
