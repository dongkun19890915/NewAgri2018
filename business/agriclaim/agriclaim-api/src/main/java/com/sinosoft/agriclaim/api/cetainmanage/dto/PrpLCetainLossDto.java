package com.sinosoft.agriclaim.api.cetainmanage.dto;

import java.io.Serializable;

import com.sinosoft.framework.dto.BaseRequest;
/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-11-08 05:36:28.690 
 * 确定损失表（无表名）Api操作对象
 */
public class PrpLCetainLossDto extends BaseRequest implements Serializable{
	private static final long serialVersionUID = 1L;
	/** 属性主键/主键 */
	private java.lang.Double id ;		
	/** 属性立案号/立案号 */
	private String claimNo ;		
	/** 属性险种/险种 */
	private String riskCode ;		
	/** 属性报案号/报案号 */
	private String registNo ;		
	/** 属性标的序号/标的序号 */
	private java.lang.Double itemNo ;		
	/** 属性车牌号码/车牌号码 */
	private String licenseNo ;		
	/** 属性保单号/保单号 */
	private String policyNo ;		
	/** 属性开始时间/开始时间 */
	private java.util.Date startDate ;		
	/** 属性开始小时/开始小时 */
	private String startHour ;		
	/** 属性结束时间/结束时间 */
	private java.util.Date endDate ;		
	/** 属性结束小时/结束小时 */
	private String endHour ;		
	/** 属性币别/币别 */
	private String currency ;		
	/** 属性剔除金额/残值/损余/剔除金额/残值/损余 */
	private java.lang.Double sumRest ;		
	/** 属性管理费/管理费 */
	private java.lang.Double sumManager ;		
	/** 属性总定损金额/总定损金额 */
	private java.lang.Double sumCertainLoss ;		
	/** 属性总核损金额/总核损金额 */
	private java.lang.Double sumVerifyLoss ;		
	/** 属性损失部位及程度概述/损失部位及程度概述 */
	private String lossDesc ;		
	/** 属性赔偿责任代码/标准化代码/赔偿责任代码/标准化代码 */
	private String indemnityDuty ;		
	/** 属性责任比例/责任比例 */
	private java.lang.Double indemnityDutyRate ;		
	/** 属性备注/备注 */
	private String remark ;		
	/** 属性操作员代码/操作员代码 */
	private String operatorCode ;		
	/** 属性复核人代码/复核人代码 */
	private String approverCode ;		
	/** 属性标志字段/标志字段 */
	private String flag ;		
	/**
	 * 属性主键/主键的getter方法
	 */
	public java.lang.Double getId() {
		return id;
	}
	/**
	 * 属性主键/主键的setter方法
	 */
	public void setId(java.lang.Double id) {
		this.id = id;
	}	
	/**
	 * 属性立案号/立案号的getter方法
	 */
	public String getClaimNo() {
		return claimNo;
	}
	/**
	 * 属性立案号/立案号的setter方法
	 */
	public void setClaimNo(String claimNo) {
		this.claimNo = claimNo;
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
	 * 属性报案号/报案号的getter方法
	 */
	public String getRegistNo() {
		return registNo;
	}
	/**
	 * 属性报案号/报案号的setter方法
	 */
	public void setRegistNo(String registNo) {
		this.registNo = registNo;
	}	
	/**
	 * 属性标的序号/标的序号的getter方法
	 */
	public java.lang.Double getItemNo() {
		return itemNo;
	}
	/**
	 * 属性标的序号/标的序号的setter方法
	 */
	public void setItemNo(java.lang.Double itemNo) {
		this.itemNo = itemNo;
	}	
	/**
	 * 属性车牌号码/车牌号码的getter方法
	 */
	public String getLicenseNo() {
		return licenseNo;
	}
	/**
	 * 属性车牌号码/车牌号码的setter方法
	 */
	public void setLicenseNo(String licenseNo) {
		this.licenseNo = licenseNo;
	}	
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
	 * 属性开始时间/开始时间的getter方法
	 */
	public java.util.Date getStartDate() {
		return startDate;
	}
	/**
	 * 属性开始时间/开始时间的setter方法
	 */
	public void setStartDate(java.util.Date startDate) {
		this.startDate = startDate;
	}	
	/**
	 * 属性开始小时/开始小时的getter方法
	 */
	public String getStartHour() {
		return startHour;
	}
	/**
	 * 属性开始小时/开始小时的setter方法
	 */
	public void setStartHour(String startHour) {
		this.startHour = startHour;
	}	
	/**
	 * 属性结束时间/结束时间的getter方法
	 */
	public java.util.Date getEndDate() {
		return endDate;
	}
	/**
	 * 属性结束时间/结束时间的setter方法
	 */
	public void setEndDate(java.util.Date endDate) {
		this.endDate = endDate;
	}	
	/**
	 * 属性结束小时/结束小时的getter方法
	 */
	public String getEndHour() {
		return endHour;
	}
	/**
	 * 属性结束小时/结束小时的setter方法
	 */
	public void setEndHour(String endHour) {
		this.endHour = endHour;
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
	 * 属性剔除金额/残值/损余/剔除金额/残值/损余的getter方法
	 */
	public java.lang.Double getSumRest() {
		return sumRest;
	}
	/**
	 * 属性剔除金额/残值/损余/剔除金额/残值/损余的setter方法
	 */
	public void setSumRest(java.lang.Double sumRest) {
		this.sumRest = sumRest;
	}	
	/**
	 * 属性管理费/管理费的getter方法
	 */
	public java.lang.Double getSumManager() {
		return sumManager;
	}
	/**
	 * 属性管理费/管理费的setter方法
	 */
	public void setSumManager(java.lang.Double sumManager) {
		this.sumManager = sumManager;
	}	
	/**
	 * 属性总定损金额/总定损金额的getter方法
	 */
	public java.lang.Double getSumCertainLoss() {
		return sumCertainLoss;
	}
	/**
	 * 属性总定损金额/总定损金额的setter方法
	 */
	public void setSumCertainLoss(java.lang.Double sumCertainLoss) {
		this.sumCertainLoss = sumCertainLoss;
	}	
	/**
	 * 属性总核损金额/总核损金额的getter方法
	 */
	public java.lang.Double getSumVerifyLoss() {
		return sumVerifyLoss;
	}
	/**
	 * 属性总核损金额/总核损金额的setter方法
	 */
	public void setSumVerifyLoss(java.lang.Double sumVerifyLoss) {
		this.sumVerifyLoss = sumVerifyLoss;
	}	
	/**
	 * 属性损失部位及程度概述/损失部位及程度概述的getter方法
	 */
	public String getLossDesc() {
		return lossDesc;
	}
	/**
	 * 属性损失部位及程度概述/损失部位及程度概述的setter方法
	 */
	public void setLossDesc(String lossDesc) {
		this.lossDesc = lossDesc;
	}	
	/**
	 * 属性赔偿责任代码/标准化代码/赔偿责任代码/标准化代码的getter方法
	 */
	public String getIndemnityDuty() {
		return indemnityDuty;
	}
	/**
	 * 属性赔偿责任代码/标准化代码/赔偿责任代码/标准化代码的setter方法
	 */
	public void setIndemnityDuty(String indemnityDuty) {
		this.indemnityDuty = indemnityDuty;
	}	
	/**
	 * 属性责任比例/责任比例的getter方法
	 */
	public java.lang.Double getIndemnityDutyRate() {
		return indemnityDutyRate;
	}
	/**
	 * 属性责任比例/责任比例的setter方法
	 */
	public void setIndemnityDutyRate(java.lang.Double indemnityDutyRate) {
		this.indemnityDutyRate = indemnityDutyRate;
	}	
	/**
	 * 属性备注/备注的getter方法
	 */
	public String getRemark() {
		return remark;
	}
	/**
	 * 属性备注/备注的setter方法
	 */
	public void setRemark(String remark) {
		this.remark = remark;
	}	
	/**
	 * 属性操作员代码/操作员代码的getter方法
	 */
	public String getOperatorCode() {
		return operatorCode;
	}
	/**
	 * 属性操作员代码/操作员代码的setter方法
	 */
	public void setOperatorCode(String operatorCode) {
		this.operatorCode = operatorCode;
	}	
	/**
	 * 属性复核人代码/复核人代码的getter方法
	 */
	public String getApproverCode() {
		return approverCode;
	}
	/**
	 * 属性复核人代码/复核人代码的setter方法
	 */
	public void setApproverCode(String approverCode) {
		this.approverCode = approverCode;
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
}
