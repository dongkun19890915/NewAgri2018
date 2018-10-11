package com.sinosoft.agriclaim.api.compensatemanage.dto;

import com.sinosoft.framework.datatype.DateTime;

import java.util.Date;
/**
 * 
 * @description: 类功能简述：理算主表信息扩展类
 * @author 安齐崇
 * @date 2017年12月1日下午5:17:06
 *
 */
public class PrpLCompensateDtoExt extends PrpLCompensateDto {

	private static final long serialVersionUID = 1L;
	/*受损标的*/
	private String lossName;
	private String lossCode;
	/*币别中文名*/
	private String currencyName;
	/*出险原因编码*/
	private String damageCode;
	/*出险原因名称*/
	private String damageName;
	/*出险地点*/
	private String damageAddress;
	/*总保险金额*/
	private double sumAmount;
	/*被保人姓名*/
    private String insuredName;
    /*被保人信息-页面展示*/
    private String insuredNameShow;
    /*出险时间*/
    private String damageDate;
	public String getDamageDate() {
		return damageDate;
	}
	public void setDamageDate(String damageDate) {
		this.damageDate = damageDate;
	}
	/*出险小时*/
    private String damageStartHour;
    /*总查勘费*/
    private double sumCheckFee;
    /*经办人名称*/
    private String handlerName;
    /*预赔付金额*/
    private double sumPrePaid;
    /*预赔款费用总额*/
    private double sumPreChargeAmount;
    /*被保人风险等级*/
    private String insuredRiskLevel;
    /*投保人风险等级*/
    private String  appliRiskLevel;
    /*投保人姓名*/
    private String appliName;
    /*投保人编码*/
    private String appliCode;
    /*保险起期*/
    private Date startDate;
    /*保险止期*/
    private Date endDate;
    /*操作员编码和名称*/
    private String handleCodeAndName;
    /*保险期间*/
    private String insuredPeriod;
    /*币别名称和编码*/
    private String currencyCodeAndName;
    /*我方赔付金额*/
    private java.lang.Double coinsSelfSumPaid ;	
    /*我方垫付金额*/
    private java.lang.Double coinsOtherPaid ;
	public java.lang.Double getCoinsSelfSumPaid() {
		return coinsSelfSumPaid;
	}
	public void setCoinsSelfSumPaid(java.lang.Double coinsSelfSumPaid) {
		this.coinsSelfSumPaid = coinsSelfSumPaid;
	}
	public java.lang.Double getCoinsOtherPaid() {
		return coinsOtherPaid;
	}
	public void setCoinsOtherPaid(java.lang.Double coinsOtherPaid) {
		this.coinsOtherPaid = coinsOtherPaid;
	}
	public String getCurrencyCodeAndName() {
		return currencyCodeAndName;
	}
	public void setCurrencyCodeAndName() {
		this.currencyCodeAndName = this.getCurrency()+"-"+currencyName;
	}
	public String getInsuredPeriod() {
		return this.insuredPeriod;
	}
	public void setInsuredPeriod() {
		this.insuredPeriod = new DateTime(startDate, DateTime.YEAR_TO_DAY).toString()+" "+"至"+" " +new DateTime(endDate, DateTime.YEAR_TO_DAY).toString();
	}
	public String getHandleCodeAndName() {
		return this.handleCodeAndName;
	}
	public void setHandleCodeAndName() {
		this.handleCodeAndName = this.getHandlerCode()+"  "+this.getHandlerName();
	}
	public Date getStartDate() {
		return startDate;
	}
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	public Date getEndDate() {
		return endDate;
	}
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
	public String getAppliName() {
		return appliName;
	}
	public void setAppliName(String appliName) {
		this.appliName = appliName;
	}
	public String getAppliCode() {
		return appliCode;
	}
	public void setAppliCode(String appliCode) {
		this.appliCode = appliCode;
	}
	public String getCurrencyName() {
		return currencyName;
	}
	public void setCurrencyName(String currencyName) {
		this.currencyName = currencyName;
	}
	public String getInsuredRiskLevel() {
		return insuredRiskLevel;
	}
	public void setInsuredRiskLevel(String insuredRiskLevel) {
		this.insuredRiskLevel = insuredRiskLevel;
	}
	public String getAppliRiskLevel() {
		return appliRiskLevel;
	}
	public void setAppliRiskLevel(String appliRiskLevel) {
		this.appliRiskLevel = appliRiskLevel;
	}
	public double getSumPrePaid() {
		return sumPrePaid;
	}
	public void setSumPrePaid(double sumPrePaid) {
		this.sumPrePaid = sumPrePaid;
	}
	public double getSumPreChargeAmount() {
		return sumPreChargeAmount;
	}
	public void setSumPreChargeAmount(double sumPreChargeAmount) {
		this.sumPreChargeAmount = sumPreChargeAmount;
	}
	public String getHandlerName() {
		return handlerName;
	}
	public void setHandlerName(String handlerName) {
		this.handlerName = handlerName;
	}
	public double getSumCheckFee() {
		return sumCheckFee;
	}
	public void setSumCheckFee(double sumCheckFee) {
		this.sumCheckFee = sumCheckFee;
	}
	public String getLossName() {
		return lossName;
	}
	public void setLossName(String lossName) {
		this.lossName = lossName;
	}
	public String getDamageCode() {
		return damageCode;
	}
	public void setDamageCode(String damageCode) {
		this.damageCode = damageCode;
	}
	public String getDamageName() {
		return damageName;
	}
	public void setDamageName(String damageName) {
		this.damageName = damageName;
	}
	public String getDamageAddress() {
		return damageAddress;
	}
	public void setDamageAddress(String damageAddress) {
		this.damageAddress = damageAddress;
	}
	public double getSumAmount() {
		return sumAmount;
	}
	public void setSumAmount(double sumAmount) {
		this.sumAmount = sumAmount;
	}
	public String getInsuredName() {
		return insuredName;
	}
	public void setInsuredName(String insuredName) {
		this.insuredName = insuredName;
	}
	public String getInsuredNameShow() {
		return insuredNameShow;
	}
	public void setInsuredNameShow(String insuredNameShow) {
		this.insuredNameShow = insuredNameShow;
	}
	public String getDamageStartHour() {
		return damageStartHour;
	}
	public void setDamageStartHour(String damageStartHour) {
		this.damageStartHour = damageStartHour;
	}

	public String getLossCode() {
		return lossCode;
	}

	public void setLossCode(String lossCode) {
		this.lossCode = lossCode;
	}
}
