package com.sinosoft.agriprpall.api.proposalmanage.dto;

import java.io.Serializable;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.sinosoft.framework.dto.BaseRequest;
/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-10-18 08:03:36.446 
 * 农险标的信息表Api操作对象
 */
public class PrpTitemKindAgriDto extends BaseRequest implements Serializable{
	private static final long serialVersionUID = 1L;
	/** 属性投保单/投保单 */
	private String proposalNo ;		
	/** 属性险种/险种 */
	private String riskCode ;		
	/** 属性标的序号/标的序号 */
	private Integer itemKindNo ;
	/** 属性险别/险别 */
	private String kindCode ;		
	/** 属性单位产量/密度/每亩烟草株数/单位产量/密度/每亩烟草株数 */
	private Double unitOutput ;
	/** 属性约定单价/约定单价 */
	private Double unitCost ;
	/** 属性折扣/投保成数/折扣/投保成数 */
	private Double proportion ;
	/** 属性折旧率/树龄(林木险)/折旧率/树龄(林木险) */
	private Double depreciationRate ;
	/** 属性单位保险金额/单位保险金额 */
	private Double unitAmount ;
	/** 属性种养总量/种养总量 */
	private Double grossQuantity ;
	/** 属性比例类型：1基本险投保 2全额投保 3个人比例 4合作社比例/比例类型：1基本险投保 2全额投保 3个人比例 4合作社比例 */
	private String discountType ;		
	/** 属性对应prp*ItemKind.flag/对应prp*ItemKind.flag */
	private String flag ;		
	/** 属性借用存储张种规格/借用存储张种规格 */
	private String remark ;		
	/** 属性茬次/茬次 */
	private Integer times = 0;
	/** 属性当前茬次起始日期/当前茬次起始日期 */
	@JsonFormat(pattern = "yyyy-MM-dd",timezone = "GMT+8")
	private java.util.Date stratDate ;		
	/** 属性当前茬次终止日期/当前茬次终止日期 */
	@JsonFormat(pattern = "yyyy-MM-dd",timezone = "GMT+8")
	private java.util.Date endDate ;
	/** 属性保险金额分布比例/保险金额分布比例 */
	private Double distributingRate ;
	/** 属性投保面积/每株烟草有效叶片基数(片/株)/投保面积/每株烟草有效叶片基数(片/株) */
	private Double insureArea ;
	/** 属性茬次保额/茬次保额 */
	private Double timesAmount ;
	/**
	 * 属性投保单/投保单的getter方法
	 */
	public String getProposalNo() {
		return proposalNo;
	}
	/**
	 * 属性投保单/投保单的setter方法
	 */
	public void setProposalNo(String proposalNo) {
		this.proposalNo = proposalNo;
	}	
	/**
	 * 属性险种/险种的getter方法
	 */
	public String getRiskCode() {
		return riskCode;
	}
	/**
	 * 属性险种/险种的setter方法
	 */
	public void setRiskCode(String riskCode) {
		this.riskCode = riskCode;
	}	
	/**
	 * 属性标的序号/标的序号的getter方法
	 */
	public Integer getItemKindNo() {
		return itemKindNo;
	}
	/**
	 * 属性标的序号/标的序号的setter方法
	 */
	public void setItemKindNo(Integer itemKindNo) {
		this.itemKindNo = itemKindNo;
	}	
	/**
	 * 属性险别/险别的getter方法
	 */
	public String getKindCode() {
		return kindCode;
	}
	/**
	 * 属性险别/险别的setter方法
	 */
	public void setKindCode(String kindCode) {
		this.kindCode = kindCode;
	}	

	/**
	 * 属性折扣/投保成数/折扣/投保成数的getter方法
	 */
	public Double getProportion() {
		return proportion;
	}
	/**
	 * 属性折扣/投保成数/折扣/投保成数的setter方法
	 */
	public void setProportion(Double proportion) {
		this.proportion = proportion;
	}	
	/**
	 * 属性折旧率/树龄(林木险)/折旧率/树龄(林木险)的getter方法
	 */
	public Double getDepreciationRate() {
		return depreciationRate;
	}
	/**
	 * 属性折旧率/树龄(林木险)/折旧率/树龄(林木险)的setter方法
	 */
	public void setDepreciationRate(Double depreciationRate) {
		this.depreciationRate = depreciationRate;
	}	
	/**
	 * 属性单位保险金额/单位保险金额的getter方法
	 */
	public Double getUnitAmount() {
		return unitAmount;
	}
	/**
	 * 属性单位保险金额/单位保险金额的setter方法
	 */
	public void setUnitAmount(Double unitAmount) {
		this.unitAmount = unitAmount;
	}	
	/**
	 * 属性种养总量/种养总量的getter方法
	 */
	public Double getGrossQuantity() {
		return grossQuantity;
	}
	/**
	 * 属性种养总量/种养总量的setter方法
	 */
	public void setGrossQuantity(Double grossQuantity) {
		this.grossQuantity = grossQuantity;
	}	
	/**
	 * 属性比例类型：1基本险投保 2全额投保 3个人比例 4合作社比例/比例类型：1基本险投保 2全额投保 3个人比例 4合作社比例的getter方法
	 */
	public String getDiscountType() {
		return discountType;
	}
	/**
	 * 属性比例类型：1基本险投保 2全额投保 3个人比例 4合作社比例/比例类型：1基本险投保 2全额投保 3个人比例 4合作社比例的setter方法
	 */
	public void setDiscountType(String discountType) {
		this.discountType = discountType;
	}	
	/**
	 * 属性对应prp*ItemKind.flag/对应prp*ItemKind.flag的getter方法
	 */
	public String getFlag() {
		return flag;
	}
	/**
	 * 属性对应prp*ItemKind.flag/对应prp*ItemKind.flag的setter方法
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
	/**
	 * 属性当前茬次起始日期/当前茬次起始日期的getter方法
	 */
	public java.util.Date getStratDate() {
		return stratDate;
	}
	/**
	 * 属性当前茬次起始日期/当前茬次起始日期的setter方法
	 */
	public void setStratDate(java.util.Date stratDate) {
		this.stratDate = stratDate;
	}

	public Double getUnitOutput() {
		return unitOutput;
	}

	public void setUnitOutput(Double unitOutput) {
		this.unitOutput = unitOutput;
	}

	public Double getUnitCost() {
		return unitCost;
	}

	public void setUnitCost(Double unitCost) {
		this.unitCost = unitCost;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public Double getInsureArea() {
		return insureArea;
	}

	public void setInsureArea(Double insureArea) {
		this.insureArea = insureArea;
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
