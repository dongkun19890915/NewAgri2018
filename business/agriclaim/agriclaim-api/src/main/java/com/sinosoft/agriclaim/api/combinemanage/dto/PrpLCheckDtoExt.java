package com.sinosoft.agriclaim.api.combinemanage.dto;

import java.util.Date;

import com.sinosoft.agriclaim.api.checkmanage.dto.PrpLCheckDto;

/**
 * @description: 类功能简述：扩展类
 * @author 安齐崇
 * @date 2017年11月16日下午3:03:55
 */
public class PrpLCheckDtoExt  {


	private static final long serialVersionUID = 1L;
	private String estiCurrency; //估损币别
	private String clauseType;//条款类别
	private String status;//操作状态，取自报案表
	private Date damageEndDate;
	private String insuredName;
	private double lossesNumber; //赔付数量，查勘登记前从报案登记表获取
	private String lossesUnitCode; //赔付数量对应的单位信息
	private double registEstimateLoss; //报损金额，报案表获取
	private String registEstiCurrency;//报损币别
	private String context;//查勘报告文本信息
	private String  damageStartMinute;
	private String  damageEndHour;
	private String  riskName;

	 
	public String getRiskName() {
		return riskName;
	}
	public void setRiskName(String riskName) {
		this.riskName = riskName;
	}
	public String getDamageStartMinute() {
		return damageStartMinute;
	}
	public void setDamageStartMinute(String damageStartMinute) {
		this.damageStartMinute = damageStartMinute;
	}
	public String getDamageEndHour() {
		return damageEndHour;
	}
	public void setDamageEndHour(String damageEndHour) {
		this.damageEndHour = damageEndHour;
	}
	private PrpLCheckDto prpLCheckDto;
	
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
	public PrpLCheckDto getPrpLCheckDto() {
		return prpLCheckDto;
	}
	public void setPrpLCheckDto(PrpLCheckDto prpLCheckDto) {
		this.prpLCheckDto = prpLCheckDto;
	}
	
	
	
}
