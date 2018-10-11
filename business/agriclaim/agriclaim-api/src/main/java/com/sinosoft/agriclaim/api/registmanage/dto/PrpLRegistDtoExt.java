package com.sinosoft.agriclaim.api.registmanage.dto;

import java.util.Date;
import java.util.List;

/**
 * @description: 类功能简述：报案登记表扩展类
 * @author 安齐崇
 * @date 2017年11月28日下午7:07:45
 *
 */
public class PrpLRegistDtoExt extends PrpLRegistDto {

	private static final long serialVersionUID = 1L;
	/************* 出险信息展示扩展字段 ****************/
	/** 赔付金额 */
	private double sumPaidShow = 0.0d;
	/** 属性赔案号码 */
	private String claimNo = "";
	/** 属性保险损失金额(同保单币别) */
	private double sumClaim = 0.0d;
	/* 序列号 */
	private int serialNo;
	private List registList;
	/* 出险摘要 */
	private String context;
	private List<String> damageMessage;
	private String strDamageStartDate;
	/*****************************/
	private String estiCurrencyName;
	private Date signDate;
	private double sumAmount;
	private String comName;
	private String certiType;
	private String certiNo;
	/* 条款名称 */
	private String clauseName;
	private String handleUnitName;
	/* 报案登记中设置默认报案现场，0，非，1是 */
	/* 报案操作的状态1为 新案件登记 (未处理任务) */
	private String status;
	/* 复选框选择标志，复选框出险信息类型 */
	private String strDamageMessage;
	private Date startDate;
	private Integer startHour;
	private Date endDate;
	private Integer endHour;
	private String llflag;
	private String acceptFlag;
	private String repeatInsureFlag;

	public Integer getStartHour() {
		return startHour;
	}

	public void setStartHour(Integer startHour) {
		this.startHour = startHour;
	}

	public Integer getEndHour() {
		return endHour;
	}

	public void setEndHour(Integer endHour) {
		this.endHour = endHour;
	}

	public String getRepeatInsureFlag() {
		return repeatInsureFlag;
	}

	public void setRepeatInsureFlag(String repeatInsureFlag) {
		this.repeatInsureFlag = repeatInsureFlag;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public String getAcceptFlag() {
		return acceptFlag;
	}

	public void setAcceptFlag(String acceptFlag) {
		this.acceptFlag = acceptFlag;
	}

	public String getLlflag() {
		return llflag;
	}

	public void setLlflag(String llflag) {
		this.llflag = llflag;
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

	public String getStrDamageMessage() {
		return strDamageMessage;
	}

	public void setStrDamageMessage(String strDamageMessage) {
		this.strDamageMessage = strDamageMessage;
	}

	public List<String> getDamageMessage() {
		return damageMessage;
	}

	public void setDamageMessage(List<String> damageMessage) {
		this.damageMessage = damageMessage;
	}

	public double getSumPaidShow() {
		return sumPaidShow;
	}

	public void setSumPaidShow(double sumPaidShow) {
		this.sumPaidShow = sumPaidShow;
	}

	public String getClaimNo() {
		return claimNo;
	}

	public void setClaimNo(String claimNo) {
		this.claimNo = claimNo;
	}

	public double getSumClaim() {
		return sumClaim;
	}

	public void setSumClaim(double sumClaim) {
		this.sumClaim = sumClaim;
	}

	public int getSerialNo() {
		return serialNo;
	}

	public void setSerialNo(int serialNo) {
		this.serialNo = serialNo;
	}

	public List getRegistList() {
		return registList;
	}

	public void setRegistList(List registList) {
		this.registList = registList;
	}

	public String getContext() {
		return context;
	}

	public void setContext(String context) {
		this.context = context;
	}

	public String getStrDamageStartDate() {
		return strDamageStartDate;
	}

	public void setStrDamageStartDate(String strDamageStartDate) {
		this.strDamageStartDate = strDamageStartDate;
	}

	public String getEstiCurrencyName() {
		return estiCurrencyName;
	}

	public void setEstiCurrencyName(String estiCurrencyName) {
		this.estiCurrencyName = estiCurrencyName;
	}

	public Date getSignDate() {
		return signDate;
	}

	public void setSignDate(Date signDate) {
		this.signDate = signDate;
	}

	public double getSumAmount() {
		return sumAmount;
	}

	public void setSumAmount(double sumAmount) {
		this.sumAmount = sumAmount;
	}

	public String getComName() {
		return comName;
	}

	public void setComName(String comName) {
		this.comName = comName;
	}

	public String getCertiType() {
		return certiType;
	}

	public void setCertiType(String certiType) {
		this.certiType = certiType;
	}

	public String getCertiNo() {
		return certiNo;
	}

	public void setCertiNo(String certiNo) {
		this.certiNo = certiNo;
	}

	public String getClauseName() {
		return clauseName;
	}

	public void setClauseName(String clauseName) {
		this.clauseName = clauseName;
	}

	public String getHandleUnitName() {
		return handleUnitName;
	}

	public void setHandleUnitName(String handleUnitName) {
		this.handleUnitName = handleUnitName;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

}
