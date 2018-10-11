package com.sinosoft.agriprpall.api.policymanage.dto;

import java.io.Serializable;
import java.util.Date;

import com.sinosoft.framework.dto.BaseRequest;
/**
 * @author codegen@研发中心
 * @mail codegen@sinosoft.com.cn
 * @time  2017-10-22 07:54:48.524 
 * 保单标的子险信息表Api操作对象
 */
public class ResponseItemKindDto extends BaseRequest implements Serializable{
	private static final long serialVersionUID = 1L;
	/** 属性数量单位/数量单位 */
	private String unit ;
	/** 属性保险金额/保险金额 */
	private String amount;
	/** 属性费率/费率 */
	private String rate ;
	/** 属性保费/保费 */
	private String premium ;
	/** 属性免赔率/免赔率 */
	private String deductibleRate ;
	/** 属性种养总量/种养总量 */
	private String grossQuantity ;
	/** 属性单位生产成本/单位生产成本 */
	private String unitCost ;
	/** 属性单位产量/密度/单位产量/密度 */
	private String unitOutPut ;
	/** 标的项目名称 */
	private String itemDetailName ;
	/** 单位保险金额 */
	private String unitAmount;
	/** 约定单价 */
	private String timesAmount;
	/** 签单日期 */
	private String operateDate;

	private String dataFlag;
	private String oneFlag;
	private String twoFlag;
	private String threeFlag;

	public String getThreeFlag() {
		return threeFlag;
	}

	public void setThreeFlag(String threeFlag) {
		this.threeFlag = threeFlag;
	}

	public String getOperateDate() {
		return operateDate;
	}

	public void setOperateDate(String operateDate) {
		this.operateDate = operateDate;
	}

	public String getDataFlag() {
		return dataFlag;
	}

	public void setDataFlag(String dataFlag) {
		this.dataFlag = dataFlag;
	}

	public String getOneFlag() {
		return oneFlag;
	}

	public void setOneFlag(String oneFlag) {
		this.oneFlag = oneFlag;
	}

	public String getTwoFlag() {
		return twoFlag;
	}

	public void setTwoFlag(String twoFlag) {
		this.twoFlag = twoFlag;
	}

	public String getUnit() {
		return unit;
	}

	public void setUnit(String unit) {
		this.unit = unit;
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

	public String getDeductibleRate() {
		return deductibleRate;
	}

	public void setDeductibleRate(String deductibleRate) {
		this.deductibleRate = deductibleRate;
	}

	public String getGrossQuantity() {
		return grossQuantity;
	}

	public void setGrossQuantity(String grossQuantity) {
		this.grossQuantity = grossQuantity;
	}

	public String getUnitCost() {
		return unitCost;
	}

	public void setUnitCost(String unitCost) {
		this.unitCost = unitCost;
	}

	public String getUnitOutPut() {
		return unitOutPut;
	}

	public void setUnitOutPut(String unitOutPut) {
		this.unitOutPut = unitOutPut;
	}

	public String getItemDetailName() {
		return itemDetailName;
	}

	public void setItemDetailName(String itemDetailName) {
		this.itemDetailName = itemDetailName;
	}

	public String getUnitAmount() {
		return unitAmount;
	}

	public void setUnitAmount(String unitAmount) {
		this.unitAmount = unitAmount;
	}

	public String getTimesAmount() {
		return timesAmount;
	}

	public void setTimesAmount(String timesAmount) {
		this.timesAmount = timesAmount;
	}
}
