package com.sinosoft.agriprpall.api.proposalmanage.dto;

import com.sinosoft.framework.dto.BaseRequest;

import java.io.Serializable;

/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-10-18 13:10:01.639 
 * 险别信息Api操作对象
 */
public class QueryProposalPrpTitemKindDto extends BaseRequest implements Serializable{
	private static final long serialVersionUID = 1L;

	private String amount;
	private String rate;
	private String premium;
	private String model;
	private String replyNo;
	private String itemKindNo;
	private Double agriUnitCostMain;
	private Double agriGrossQuantityMain;
	private Double agriTimesAmount;


	/** 属性标的序号/标的序号 */
	private Integer itemNo ;
	/** 属性险别/险别 */
	private String kindCode ;		
	/** 属性险别名称/险别名称 */
	private String kindName ;		
	/** 属性标的类别代码/标的类别代码 */
	private String itemCode ;		
	/** 属性标的项目/标的项目 */
	private String itemDetailName ;
	/** 属性地址序号/地址序号 */
	private Integer addressNo ;
	/** 属性币别/币别 */
	private String currency ;		
	/** 属性短期费率方式/短期费率方式 */
	private String shortRateFlag;
	/** 属性短期费率/短期费率 */
	private Double shortRate ;
	/** 属性每次事故免赔率/每次事故免赔率 */
	private Double deductibleRate ;
	/** 属性起赔点/起赔点 */
	private Double triggerPoint ;
	/** 属性全损损失率/全损损失率 */
	private Double totalLossRatio ;
	/** 属性单位保险产量/单位保险产量 */
	private Double unitOutPut ;
	/** 属性单位保险金额/单位保险金额 */
	private Double unitAmount ;
	/** 属性投保面积/投保面积 */
	private Double insureArea ;
	/** 属性约定单价/约定单价 */
	private Double unitCost ;
	/**
	 * 属性标的序号/标的序号的getter方法
	 */
	public Integer getItemNo() {
		return itemNo;
	}
	/**
	 * 属性标的序号/标的序号的setter方法
	 */
	public void setItemNo(Integer itemNo) {
		this.itemNo = itemNo;
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
	 * 属性险别名称/险别名称的getter方法
	 */
	public String getKindName() {
		return kindName;
	}
	/**
	 * 属性险别名称/险别名称的setter方法
	 */
	public void setKindName(String kindName) {
		this.kindName = kindName;
	}	
	/**
	 * 属性标的类别代码/标的类别代码的getter方法
	 */
	public String getItemCode() {
		return itemCode;
	}
	/**
	 * 属性标的类别代码/标的类别代码的setter方法
	 */
	public void setItemCode(String itemCode) {
		this.itemCode = itemCode;
	}

	public String getAmount() {
		return amount;
	}

	public void setAmount(String amount) {
		this.amount = amount;
	}

	public String getRate() {
		return rate;
	}

	public void setRate(String rate) {
		this.rate = rate;
	}

	public String getPremium() {
		return premium;
	}

	public void setPremium(String premium) {
		this.premium = premium;
	}

	public String getItemDetailName() {
		return itemDetailName;
	}

	public void setItemDetailName(String itemDetailName) {
		this.itemDetailName = itemDetailName;
	}

	/**
	 * 属性地址序号/地址序号的getter方法
	 */
	public Integer getAddressNo() {
		return addressNo;
	}
	/**
	 * 属性地址序号/地址序号的setter方法
	 */
	public void setAddressNo(Integer addressNo) {
		this.addressNo = addressNo;
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
	 * 属性短期费率方式/短期费率方式的getter方法
	 */
	public String getShortRateFlag() {
		return shortRateFlag;
	}
	/**
	 * 属性短期费率方式/短期费率方式的setter方法
	 */
	public void setShortRateFlag(String shortRateFlag) {
		this.shortRateFlag = shortRateFlag;
	}	
	/**
	 * 属性短期费率/短期费率的getter方法
	 */
	public Double getShortRate() {
		return shortRate;
	}
	/**
	 * 属性短期费率/短期费率的setter方法
	 */
	public void setShortRate(Double shortRate) {
		this.shortRate = shortRate;
	}	
	/**
	 * 属性每次事故免赔率/每次事故免赔率的getter方法
	 */
	public Double getDeductibleRate() {
		return deductibleRate;
	}
	/**
	 * 属性每次事故免赔率/每次事故免赔率的setter方法
	 */
	public void setDeductibleRate(Double deductibleRate) {
		this.deductibleRate = deductibleRate;
	}	
	/**
	 * 属性起赔点/起赔点的getter方法
	 */
	public Double getTriggerPoint() {
		return triggerPoint;
	}
	/**
	 * 属性起赔点/起赔点的setter方法
	 */
	public void setTriggerPoint(Double triggerPoint) {
		this.triggerPoint = triggerPoint;
	}

	public Double getTotalLossRatio() {
		return totalLossRatio;
	}

	public void setTotalLossRatio(Double totalLossRatio) {
		this.totalLossRatio = totalLossRatio;
	}

	/**
	 * 属性单位保险产量/单位保险产量的getter方法
	 */
	public Double getUnitOutPut() {
		return unitOutPut;
	}
	/**
	 * 属性单位保险产量/单位保险产量的setter方法
	 */
	public void setUnitOutPut(Double unitOutPut) {
		this.unitOutPut = unitOutPut;
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
	 * 属性约定单价/约定单价的getter方法
	 */
	public Double getUnitCost() {
		return unitCost;
	}
	/**
	 * 属性约定单价/约定单价的setter方法
	 */
	public void setUnitCost(Double unitCost) {
		this.unitCost = unitCost;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getReplyNo() {
		return replyNo;
	}

	public void setReplyNo(String replyNo) {
		this.replyNo = replyNo;
	}

	public String getItemKindNo() {
		return itemKindNo;
	}

	public void setItemKindNo(String itemKindNo) {
		this.itemKindNo = itemKindNo;
	}

	public Double getAgriUnitCostMain() {
		return agriUnitCostMain;
	}

	public void setAgriUnitCostMain(Double agriUnitCostMain) {
		this.agriUnitCostMain = agriUnitCostMain;
	}

	public Double getAgriGrossQuantityMain() {
		return agriGrossQuantityMain;
	}

	public void setAgriGrossQuantityMain(Double agriGrossQuantityMain) {
		this.agriGrossQuantityMain = agriGrossQuantityMain;
	}

	public Double getAgriTimesAmount() {
		return agriTimesAmount;
	}

	public void setAgriTimesAmount(Double agriTimesAmount) {
		this.agriTimesAmount = agriTimesAmount;
	}
}
