package com.sinosoft.agriclaim.api.claimmanage.dto;

import java.io.Serializable;

import com.sinosoft.framework.dto.BaseRequest;
/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2018-04-11 07:01:52.256 
 * 危险单位标的表Api操作对象
 */
public class PrpLDangerItemDto extends BaseRequest implements Serializable{
	private String policyNo ;
	private String dangerDesc;

	private static final long serialVersionUID = 1L;
	/** 属性业务号/业务号 */
	private String certiNo ;		
	/** 属性险种代码/险种代码 */
	private String riskCode ;		
	/** 属性dangerNo/dangerNo */
	private Integer dangerNo ;
	/** 属性序号/序号 */
	private Integer serialNo ;
	/** 属性kindFlag/kindFlag */
	private String kindFlag ;		
	/** 属性kindCode/kindCode */
	private String kindCode ;		
	/** 属性kindName/kindName */
	private String kindName ;		
	/** 属性postCode/postCode */
	private String postCode ;		
	/** 属性addressName/addressName */
	private String addressName ;		
	/** 属性currency/currency */
	private String currency ;		
	/** 属性sumPaid/sumPaid */
	private Double sumPaid ;
	/** 属性sumFee/sumFee */
	private Double sumFee ;
	/** 属性flag/flag */
	private String flag ;		
	/** 属性险别的危险单位占比/险别的危险单位占比 */
	private Double dangerKindShare ;
	/** 属性标的代码/标的代码 */
	private String itemCode ;		
	/** 属性标的名称/标的名称 */
	private String itemName ;		
	/** 属性估损增加次数/估损增加次数 */
	private Integer claimAddTimes ;

	public String getPolicyNo() {
		return policyNo;
	}

	public void setPolicyNo(String policyNo) {
		this.policyNo = policyNo;
	}

	public String getDangerDesc() {
		return dangerDesc;
	}

	public void setDangerDesc(String dangerDesc) {
		this.dangerDesc = dangerDesc;
	}

	/**
	 * 属性业务号/业务号的getter方法
	 */
	public String getCertiNo() {
		return certiNo;
	}
	/**
	 * 属性业务号/业务号的setter方法
	 */
	public void setCertiNo(String certiNo) {
		this.certiNo = certiNo;
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
	 * 属性kindFlag/kindFlag的getter方法
	 */
	public String getKindFlag() {
		return kindFlag;
	}
	/**
	 * 属性kindFlag/kindFlag的setter方法
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
	 * 属性kindName/kindName的getter方法
	 */
	public String getKindName() {
		return kindName;
	}
	/**
	 * 属性kindName/kindName的setter方法
	 */
	public void setKindName(String kindName) {
		this.kindName = kindName;
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
	 * 属性sumPaid/sumPaid的getter方法
	 */
	public Double getSumPaid() {
		return sumPaid;
	}
	/**
	 * 属性sumPaid/sumPaid的setter方法
	 */
	public void setSumPaid(Double sumPaid) {
		this.sumPaid = sumPaid;
	}	
	/**
	 * 属性sumFee/sumFee的getter方法
	 */
	public Double getSumFee() {
		return sumFee;
	}
	/**
	 * 属性sumFee/sumFee的setter方法
	 */
	public void setSumFee(Double sumFee) {
		this.sumFee = sumFee;
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
	 * 属性险别的危险单位占比/险别的危险单位占比的getter方法
	 */
	public Double getDangerKindShare() {
		return dangerKindShare;
	}
	/**
	 * 属性险别的危险单位占比/险别的危险单位占比的setter方法
	 */
	public void setDangerKindShare(Double dangerKindShare) {
		this.dangerKindShare = dangerKindShare;
	}	
	/**
	 * 属性标的代码/标的代码的getter方法
	 */
	public String getItemCode() {
		return itemCode;
	}
	/**
	 * 属性标的代码/标的代码的setter方法
	 */
	public void setItemCode(String itemCode) {
		this.itemCode = itemCode;
	}	
	/**
	 * 属性标的名称/标的名称的getter方法
	 */
	public String getItemName() {
		return itemName;
	}
	/**
	 * 属性标的名称/标的名称的setter方法
	 */
	public void setItemName(String itemName) {
		this.itemName = itemName;
	}	
	/**
	 * 属性估损增加次数/估损增加次数的getter方法
	 */
	public Integer getClaimAddTimes() {
		return claimAddTimes;
	}
	/**
	 * 属性估损增加次数/估损增加次数的setter方法
	 */
	public void setClaimAddTimes(Integer claimAddTimes) {
		this.claimAddTimes = claimAddTimes;
	}	
}
