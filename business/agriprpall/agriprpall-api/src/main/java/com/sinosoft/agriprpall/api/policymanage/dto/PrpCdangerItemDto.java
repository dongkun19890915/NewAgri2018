package com.sinosoft.agriprpall.api.policymanage.dto;

import java.io.Serializable;

import com.sinosoft.framework.dto.BaseRequest;
/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-11-04 09:53:57.649 
 * 投保单危险单位划分表Api操作对象
 */
public class PrpCdangerItemDto extends BaseRequest implements Serializable{
	private static final long serialVersionUID = 1L;
	/** 属性保单号/保单号 */
	private String policyNo ;		
	/** 属性险种代码/险种代码 */
	private String riskCode ;		
	/** 属性危险单位序号/危险单位序号 */
	private java.lang.Integer dangerNo ;		
	/** 属性序号(自动生成)/序号(自动生成) */
	private java.lang.Integer serialNo ;		
	/** 属性险别归类标志--** 0：正常--** 1：利损险--** 2：地震险--** 3：战争险/险别归类标志--** 0：正常--** 1：利损险--** 2：地震险--** 3：战争险 */
	private String kindFlag ;		
	/** 属性险别代码/险别代码 */
	private String kindCode ;		
	/** 属性险别归类名称/险别归类名称 */
	private String kindName ;		
	/** 属性标的项目/标的项目 */
	private String itemCode ;		
	/** 属性标的项目明细名称/标的项目明细名称 */
	private String itemDetailName ;		
	/** 属性邮编/邮编 */
	private String postCode ;		
	/** 属性危险单位地址信息/危险单位地址信息 */
	private String addressName ;		
	/** 属性币别/币别 */
	private String currency ;		
	/** 属性保额/保额 */
	private java.lang.Double amount ;		
	/** 属性保费/保费 */
	private java.lang.Double premium ;		
	/** 属性是否计算保额标志(Y/N/是否计算保额标志(Y/N */
	private String calculateFlag ;		
	/** 属性标志字段/标志字段 */
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
	 * 属性序号(自动生成)/序号(自动生成)的getter方法
	 */
	public java.lang.Integer getSerialNo() {
		return serialNo;
	}
	/**
	 * 属性序号(自动生成)/序号(自动生成)的setter方法
	 */
	public void setSerialNo(java.lang.Integer serialNo) {
		this.serialNo = serialNo;
	}	
	/**
	 * 属性险别归类标志--** 0：正常--** 1：利损险--** 2：地震险--** 3：战争险/险别归类标志--** 0：正常--** 1：利损险--** 2：地震险--** 3：战争险的getter方法
	 */
	public String getKindFlag() {
		return kindFlag;
	}
	/**
	 * 属性险别归类标志--** 0：正常--** 1：利损险--** 2：地震险--** 3：战争险/险别归类标志--** 0：正常--** 1：利损险--** 2：地震险--** 3：战争险的setter方法
	 */
	public void setKindFlag(String kindFlag) {
		this.kindFlag = kindFlag;
	}	
	/**
	 * 属性险别代码/险别代码的getter方法
	 */
	public String getKindCode() {
		return kindCode;
	}
	/**
	 * 属性险别代码/险别代码的setter方法
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
	 * 属性标的项目/标的项目的getter方法
	 */
	public String getItemCode() {
		return itemCode;
	}
	/**
	 * 属性标的项目/标的项目的setter方法
	 */
	public void setItemCode(String itemCode) {
		this.itemCode = itemCode;
	}	
	/**
	 * 属性标的项目明细名称/标的项目明细名称的getter方法
	 */
	public String getItemDetailName() {
		return itemDetailName;
	}
	/**
	 * 属性标的项目明细名称/标的项目明细名称的setter方法
	 */
	public void setItemDetailName(String itemDetailName) {
		this.itemDetailName = itemDetailName;
	}	
	/**
	 * 属性邮编/邮编的getter方法
	 */
	public String getPostCode() {
		return postCode;
	}
	/**
	 * 属性邮编/邮编的setter方法
	 */
	public void setPostCode(String postCode) {
		this.postCode = postCode;
	}	
	/**
	 * 属性危险单位地址信息/危险单位地址信息的getter方法
	 */
	public String getAddressName() {
		return addressName;
	}
	/**
	 * 属性危险单位地址信息/危险单位地址信息的setter方法
	 */
	public void setAddressName(String addressName) {
		this.addressName = addressName;
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
	 * 属性是否计算保额标志(Y/N/是否计算保额标志(Y/N的getter方法
	 */
	public String getCalculateFlag() {
		return calculateFlag;
	}
	/**
	 * 属性是否计算保额标志(Y/N/是否计算保额标志(Y/N的setter方法
	 */
	public void setCalculateFlag(String calculateFlag) {
		this.calculateFlag = calculateFlag;
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
