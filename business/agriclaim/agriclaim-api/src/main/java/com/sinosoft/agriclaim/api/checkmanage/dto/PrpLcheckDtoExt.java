package com.sinosoft.agriclaim.api.checkmanage.dto;

import java.util.Date;

/**
 * @description: 类功能简述：扩展类
 * @author 安齐崇
 * @date 2017年11月16日下午3:03:55
 */
public class PrpLcheckDtoExt extends PrpLCheckDto {

	private static final long serialVersionUID = 1L;
	/*估损币别*/
	private String estiCurrency; 
	/*条款类别*/
	private String clauseType;
	/*操作状态，取自报案表*/
	private String status;
	/*出险日期止期*/
	private Date damageEndDate;
	/*被保险人名称*/
	private String insuredName;
	/*赔付数量，查勘登记前从报案登记表获取*/
	private double lossesNumber; 
	/*赔付数量对应的单位信息*/
	private String lossesUnitCode; 
	/*报损金额，报案表获取*/
	private double registEstimateLoss; 
	/*报损币别*/
	private String registEstiCurrency;
	/*查勘报告文本信息*/
	private String context;

	public String getContext() {
		return context;
	}

	public void setContext(String context) {
		this.context = context;
	}

	public String getEstiCurrency() {
		return estiCurrency;
	}

	public void setEstiCurrency(String estiCurrency) {
		this.estiCurrency = estiCurrency;
	}

	public String getClauseType() {
		return clauseType;
	}

	public void setClauseType(String clauseType) {
		this.clauseType = clauseType;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Date getDamageEndDate() {
		return damageEndDate;
	}

	public void setDamageEndDate(Date damageEndDate) {
		this.damageEndDate = damageEndDate;
	}

	public String getInsuredName() {
		return insuredName;
	}

	public void setInsuredName(String insuredName) {
		this.insuredName = insuredName;
	}

	public double getLossesNumber() {
		return lossesNumber;
	}

	public void setLossesNumber(double lossesNumber) {
		this.lossesNumber = lossesNumber;
	}

	public String getLossesUnitCode() {
		return lossesUnitCode;
	}

	public void setLossesUnitCode(String lossesUnitCode) {
		this.lossesUnitCode = lossesUnitCode;
	}

	public double getRegistEstimateLoss() {
		return registEstimateLoss;
	}

	public void setRegistEstimateLoss(double registEstimateLoss) {
		this.registEstimateLoss = registEstimateLoss;
	}

	public String getRegistEstiCurrency() {
		return registEstiCurrency;
	}

	public void setRegistEstiCurrency(String registEstiCurrency) {
		this.registEstiCurrency = registEstiCurrency;
	}

}
