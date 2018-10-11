package com.sinosoft.agriprpall.api.endorsemanage.dto;

import java.io.Serializable;
import java.util.Date;

import com.sinosoft.framework.dto.BaseRequest;
/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-10-24 03:06:48.016 
 * 农业附加险信息表Api操作对象
 */
public class PrpCPitemKindAgriDto extends BaseRequest implements Serializable{
	private static final long serialVersionUID = 1L;
	/** 属性policyNo/policyNo */
	private String policyNo ;		
	/** 属性riskCode/riskCode */
	private String riskCode ;		
	/** 属性itemKindNo/itemKindNo */
	private Integer itemKindNo ;
	/** 属性kindCode/kindCode */
	private String kindCode ;		
	/** 属性unitOutput/unitOutput */
	private Double unitOutput ;
	/** 属性unitCost/unitCost */
	private Double unitCost ;
	/** 属性proportion/proportion */
	private Double proportion ;
	/** 属性depreciationRate/depreciationRate */
	private Double depreciationRate ;
	/** 属性unitAmount/unitAmount */
	private Double unitAmount ;
	/** 属性grossQuantity/grossQuantity */
	private Double grossQuantity ;
	/** 属性discountType/discountType */
	private String discountType ;		
	/** 属性flag/flag */
	private String flag ;		
	/** 属性借用存储张种规格/借用存储张种规格 */
	private String remark ;		
	/** 属性茬次/茬次 */
	private Integer times ;
	/** 属性当前茬次起始日期/当前茬次起始日期 */
	private java.util.Date stratDate ;
	/** 属性当前茬次终止日期/当前茬次终止日期 */
	private java.util.Date endDate ;		
	/** 属性保险金额分布比例/保险金额分布比例 */
	private Double distributingRate ;
	/** 属性投保面积/投保面积 */
	private Double insureArea ;
	/** 属性茬次保额/茬次保额 */
	private Double timesAmount ;
	/**
	 * 属性policyNo/policyNo的getter方法
	 */
	public String getPolicyNo() {
		return policyNo;
	}
	/**
	 * 属性policyNo/policyNo的setter方法
	 */
	public void setPolicyNo(String policyNo) {
		this.policyNo = policyNo;
	}	
	/**
	 * 属性riskCode/riskCode的getter方法
	 */
	public String getRiskCode() {
		return riskCode;
	}
	/**
	 * 属性riskCode/riskCode的setter方法
	 */
	public void setRiskCode(String riskCode) {
		this.riskCode = riskCode;
	}	
	/**
	 * 属性itemKindNo/itemKindNo的getter方法
	 */
	public Integer getItemKindNo() {
		return itemKindNo;
	}
	/**
	 * 属性itemKindNo/itemKindNo的setter方法
	 */
	public void setItemKindNo(Integer itemKindNo) {
		this.itemKindNo = itemKindNo;
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
	 * 属性unitOutput/unitOutput的getter方法
	 */
	public Double getUnitOutput() {
		return unitOutput;
	}
	/**
	 * 属性unitOutput/unitOutput的setter方法
	 */
	public void setUnitOutput(Double unitOutput) {
		this.unitOutput = unitOutput;
	}	
	/**
	 * 属性unitCost/unitCost的getter方法
	 */
	public Double getUnitCost() {
		return unitCost;
	}
	/**
	 * 属性unitCost/unitCost的setter方法
	 */
	public void setUnitCost(Double unitCost) {
		this.unitCost = unitCost;
	}	
	/**
	 * 属性proportion/proportion的getter方法
	 */
	public Double getProportion() {
		return proportion;
	}
	/**
	 * 属性proportion/proportion的setter方法
	 */
	public void setProportion(Double proportion) {
		this.proportion = proportion;
	}	
	/**
	 * 属性depreciationRate/depreciationRate的getter方法
	 */
	public Double getDepreciationRate() {
		return depreciationRate;
	}
	/**
	 * 属性depreciationRate/depreciationRate的setter方法
	 */
	public void setDepreciationRate(Double depreciationRate) {
		this.depreciationRate = depreciationRate;
	}	
	/**
	 * 属性unitAmount/unitAmount的getter方法
	 */
	public Double getUnitAmount() {
		return unitAmount;
	}
	/**
	 * 属性unitAmount/unitAmount的setter方法
	 */
	public void setUnitAmount(Double unitAmount) {
		this.unitAmount = unitAmount;
	}	
	/**
	 * 属性grossQuantity/grossQuantity的getter方法
	 */
	public Double getGrossQuantity() {
		return grossQuantity;
	}
	/**
	 * 属性grossQuantity/grossQuantity的setter方法
	 */
	public void setGrossQuantity(Double grossQuantity) {
		this.grossQuantity = grossQuantity;
	}	
	/**
	 * 属性discountType/discountType的getter方法
	 */
	public String getDiscountType() {
		return discountType;
	}
	/**
	 * 属性discountType/discountType的setter方法
	 */
	public void setDiscountType(String discountType) {
		this.discountType = discountType;
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
	 * 属性借用存储张种规格/借用存储张种规格的getter方法
	 */
	public String getRemark() {
		return remark;
	}
	/**
	 * 属性借用存储张种规格/借用存储张种规格的setter方法
	 */
	public void setRemark(String remark) {
		this.remark = remark;
	}	
	/**
	 * 属性茬次/茬次的getter方法
	 */
	public Integer getTimes() {
		return times;
	}
	/**
	 * 属性茬次/茬次的setter方法
	 */
	public void setTimes(Integer times) {
		this.times = times;
	}

	public Date getStratDate() {
		return stratDate;
	}

	public void setStratDate(Date stratDate) {
		this.stratDate = stratDate;
	}

	/**
	 * 属性当前茬次终止日期/当前茬次终止日期的getter方法
	 */
	public java.util.Date getEndDate() {
		return endDate;
	}
	/**
	 * 属性当前茬次终止日期/当前茬次终止日期的setter方法
	 */
	public void setEndDate(java.util.Date endDate) {
		this.endDate = endDate;
	}	
	/**
	 * 属性保险金额分布比例/保险金额分布比例的getter方法
	 */
	public Double getDistributingRate() {
		return distributingRate;
	}
	/**
	 * 属性保险金额分布比例/保险金额分布比例的setter方法
	 */
	public void setDistributingRate(Double distributingRate) {
		this.distributingRate = distributingRate;
	}	
	/**
	 * 属性投保面积/投保面积的getter方法
	 */
	public Double getInsureArea() {
		return insureArea;
	}
	/**
	 * 属性投保面积/投保面积的setter方法
	 */
	public void setInsureArea(Double insureArea) {
		this.insureArea = insureArea;
	}	
	/**
	 * 属性茬次保额/茬次保额的getter方法
	 */
	public Double getTimesAmount() {
		return timesAmount;
	}
	/**
	 * 属性茬次保额/茬次保额的setter方法
	 */
	public void setTimesAmount(Double timesAmount) {
		this.timesAmount = timesAmount;
	}	
}
