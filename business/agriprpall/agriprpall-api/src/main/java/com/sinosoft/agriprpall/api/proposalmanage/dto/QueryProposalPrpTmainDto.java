package com.sinosoft.agriprpall.api.proposalmanage.dto;

import com.sinosoft.framework.dto.BaseRequest;

import java.io.Serializable;

/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-10-18 13:10:01.639 
 * 投保单基本信息Api操作对象
 */
public class QueryProposalPrpTmainDto extends BaseRequest implements Serializable{
	private static final long serialVersionUID = 1L;
	private String modelCode;
	private String classCode;
	private String versionNo;
	private String proposalNo;
	private String riskCodeName;
	private String riskCode;
	private String comCode;
	private String policyType;
	private String statQuantity;
	private String sumInsured;
	private String payTimes;
	private String groupNo;
	private String startHour;
	private String endHour;
	private String coinsFlag;
	private String sumAmount;
	private String sumPremium;
	/** 属性归属机构名称/归属机构名称 */
	private String comName ;		
	/** 属性归属业务员代码/归属业务员代码 */
	private String handler1Code ;		
	/** 属性归属业务员名称/归属业务员名称 */
	private String handler1Name;
	/** 属性归属区域：省/归属区域：省 */
	private String businessProvinceName ;
	/** 属性归属区域：地市/归属区域：地市 */
	private String businessCityName;
	/** 属性归属区域：区县/归属区域：区县 */
	private String businessCountyName ;
	/** 属性归属区域：乡镇/归属区域：乡镇 */
	private String businessTownName ;
	/** 属性归属区域：乡镇/归属区域：村 */
	private String businessAreaName;
	/** 属性缴费方式/缴费方式 */
	private String autoTransRenewFlag;
	/** 属性业务来源/业务来源 */
	private String businessNature ;		
	/** 属性业务大类/业务大类 */
	private String businessCategory ;		
	/** 属性政策/商业标识/政策/商业标识 */
	private String businessType1 ;		
	/** 属性是否验标/是否验标 */
	private String inceptionFlag ;
	/** 属性是否承保公示/是否承保公示 */
	private String notificationFlag ;		
	/** 属性是否通过第三方识别1 是2 否/是否通过第三方识别1 是2 否 */
	private String thirdKnow ;		
	/** 属性保险起期/保险起期 */
	private java.util.Date startDate ;
	/** 属性保险止期/保险止期 */
	private java.util.Date endDate ;
	/** 属性投保日期/投保日期 */
	private java.util.Date operateDate ;
	/** 属性制单日期/制单日期 */
	private java.util.Date signDate ;
	/** 属性保单号/保单号 */
	private String policyNo ;		
	/** 属性操作员代码/操作员代码 */
	private String operatorCode ;		
	/** 属性操作员名称/操作员名称 */
	private String operatorName ;		
	/** 属性操作日期/操作日期 */
	private java.util.Date inputDate ;
	/** 属性最近修改人代码/最近修改人代码 */
	private String updaterCode ;		
	/** 属性最近修改人名称/最近修改人名称 */
	private String updaterName ;		
	/** 属性最近修改日期/最近修改日期 */
	private java.util.Date updateDate ;
	private String eccFlag;

	private String povertyFlag;
	public String getRiskCode() {
		return riskCode;
	}

	public void setRiskCode(String riskCode) {
		this.riskCode = riskCode;
	}

	public String getClassCode() {
		return classCode;
	}

	public void setClassCode(String classCode) {
		this.classCode = classCode;
	}

	public String getProposalNo() {
		return proposalNo;
	}

	public void setProposalNo(String proposalNo) {
		this.proposalNo = proposalNo;
	}
	/**
	 * 属性归属机构名称/归属机构名称的getter方法
	 */
	public String getComName() {
		return comName;
	}
	/**
	 *ri 属性归属机构名称/归属机构名称的setter方法
	 */
	public void setComName(String comName) {
		this.comName = comName;
	}	
	/**
	 * 属性归属业务员代码/归属业务员代码的getter方法
	 */
	public String getHandler1Code() {
		return handler1Code;
	}
	/**
	 * 属性归属业务员代码/归属业务员代码的setter方法
	 */
	public void setHandler1Code(String handler1Code) {
		this.handler1Code = handler1Code;
	}	
	/**
	 * 属性归属业务员名称/归属业务员名称的getter方法
	 */
	public String getHandler1Name() {
		return handler1Name;
	}
	/**
	 * 属性归属业务员名称/归属业务员名称的setter方法
	 */
	public void setHandler1Name(String handler1Name) {
		this.handler1Name = handler1Name;
	}

	public String getBusinessProvinceName() {
		return businessProvinceName;
	}

	public void setBusinessProvinceName(String businessProvinceName) {
		this.businessProvinceName = businessProvinceName;
	}

	public String getBusinessTownName() {
		return businessTownName;
	}

	public void setBusinessTownName(String businessTownName) {
		this.businessTownName = businessTownName;
	}

	public String getBusinessCountyName() {
		return businessCountyName;
	}

	public void setBusinessCountyName(String businessCountyName) {
		this.businessCountyName = businessCountyName;
	}

	public String getVersionNo() {
		return versionNo;
	}

	public void setVersionNo(String versionNo) {
		this.versionNo = versionNo;
	}

	/**
	 * 属性归属区域：乡镇/归属区域：乡镇的getter方法
	 */
	public String getBusinessAreaName() {
		return businessAreaName;
	}
	/**
	 * 属性归属区域：乡镇/归属区域：乡镇的setter方法
	 */
	public void setBusinessAreaName(String businessAreaName) {
		this.businessAreaName = businessAreaName;
	}

	public String getAutoTransRenewFlag() {
		return autoTransRenewFlag;
	}

	public void setAutoTransRenewFlag(String autoTransRenewFlag) {
		this.autoTransRenewFlag = autoTransRenewFlag;
	}

	/**
	 * 属性业务来源/业务来源的getter方法
	 */
	public String getBusinessNature() {
		return businessNature;
	}
	/**
	 * 属性业务来源/业务来源的setter方法
	 */
	public void setBusinessNature(String businessNature) {
		this.businessNature = businessNature;
	}	
	/**
	 * 属性业务大类/业务大类的getter方法
	 */
	public String getBusinessCategory() {
		return businessCategory;
	}
	/**
	 * 属性业务大类/业务大类的setter方法
	 */
	public void setBusinessCategory(String businessCategory) {
		this.businessCategory = businessCategory;
	}	
	/**
	 * 属性政策/商业标识/政策/商业标识的getter方法
	 */
	public String getBusinessType1() {
		return businessType1;
	}
	/**
	 * 属性政策/商业标识/政策/商业标识的setter方法
	 */
	public void setBusinessType1(String businessType1) {
		this.businessType1 = businessType1;
	}

	public String getInceptionFlag() {
		return inceptionFlag;
	}

	public void setInceptionFlag(String inceptionFlag) {
		this.inceptionFlag = inceptionFlag;
	}

	/**
	 * 属性是否承保公示/是否承保公示的getter方法
	 */
	public String getNotificationFlag() {
		return notificationFlag;
	}
	/**
	 * 属性是否承保公示/是否承保公示的setter方法
	 */
	public void setNotificationFlag(String notificationFlag) {
		this.notificationFlag = notificationFlag;
	}	
	/**
	 * 属性是否通过第三方识别1 是2 否/是否通过第三方识别1 是2 否的getter方法
	 */
	public String getThirdKnow() {
		return thirdKnow;
	}
	/**
	 * 属性是否通过第三方识别1 是2 否/是否通过第三方识别1 是2 否的setter方法
	 */
	public void setThirdKnow(String thirdKnow) {
		this.thirdKnow = thirdKnow;
	}	
	/**
	 * 属性保险起期/保险起期的getter方法
	 */
	public java.util.Date getStartDate() {
		return startDate;
	}
	/**
	 * 属性保险起期/保险起期的setter方法
	 */
	public void setStartDate(java.util.Date startDate) {
		this.startDate = startDate;
	}	
	/**
	 * 属性保险止期/保险止期的getter方法
	 */
	public java.util.Date getEndDate() {
		return endDate;
	}
	/**
	 * 属性保险止期/保险止期的setter方法
	 */
	public void setEndDate(java.util.Date endDate) {
		this.endDate = endDate;
	}	
	/**
	 * 属性投保日期/投保日期的getter方法
	 */
	public java.util.Date getOperateDate() {
		return operateDate;
	}
	/**
	 * 属性投保日期/投保日期的setter方法
	 */
	public void setOperateDate(java.util.Date operateDate) {
		this.operateDate = operateDate;
	}	
	/**
	 * 属性制单日期/制单日期的getter方法
	 */
	public java.util.Date getSignDate() {
		return signDate;
	}
	/**
	 * 属性制单日期/制单日期的setter方法
	 */
	public void setSignDate(java.util.Date signDate) {
		this.signDate = signDate;
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
	 * 属性操作员名称/操作员名称的getter方法
	 */
	public String getOperatorName() {
		return operatorName;
	}
	/**
	 * 属性操作员名称/操作员名称的setter方法
	 */
	public void setOperatorName(String operatorName) {
		this.operatorName = operatorName;
	}	
	/**
	 * 属性操作日期/操作日期的getter方法
	 */
	public java.util.Date getInputDate() {
		return inputDate;
	}
	/**
	 * 属性操作日期/操作日期的setter方法
	 */
	public void setInputDate(java.util.Date inputDate) {
		this.inputDate = inputDate;
	}	
	/**
	 * 属性最近修改人代码/最近修改人代码的getter方法
	 */
	public String getUpdaterCode() {
		return updaterCode;
	}
	/**
	 * 属性最近修改人代码/最近修改人代码的setter方法
	 */
	public void setUpdaterCode(String updaterCode) {
		this.updaterCode = updaterCode;
	}	
	/**
	 * 属性最近修改人名称/最近修改人名称的getter方法
	 */
	public String getUpdaterName() {
		return updaterName;
	}
	/**
	 * 属性最近修改人名称/最近修改人名称的setter方法
	 */
	public void setUpdaterName(String updaterName) {
		this.updaterName = updaterName;
	}	
	/**
	 * 属性最近修改日期/最近修改日期的getter方法
	 */
	public java.util.Date getUpdateDate() {
		return updateDate;
	}
	/**
	 * 属性最近修改日期/最近修改日期的setter方法
	 */
	public void setUpdateDate(java.util.Date updateDate) {
		this.updateDate = updateDate;
	}

	public String getRiskCodeName() {
		return riskCodeName;
	}

	public void setRiskCodeName(String riskCodeName) {
		this.riskCodeName = riskCodeName;
	}

	public String getModelCode() {
		return modelCode;
	}

	public void setModelCode(String modelCode) {
		this.modelCode = modelCode;
	}

	public String getComCode() {
		return comCode;
	}

	public void setComCode(String comCode) {
		this.comCode = comCode;
	}

	public String getBusinessCityName() {
		return businessCityName;
	}

	public void setBusinessCityName(String businessCityName) {
		this.businessCityName = businessCityName;
	}

	public String getPolicyType() {
		return policyType;
	}

	public void setPolicyType(String policyType) {
		this.policyType = policyType;
	}

	public String getStatQuantity() {
		return statQuantity;
	}

	public void setStatQuantity(String statQuantity) {
		this.statQuantity = statQuantity;
	}

	public String getSumInsured() {
		return sumInsured;
	}

	public void setSumInsured(String sumInsured) {
		this.sumInsured = sumInsured;
	}

	public String getPayTimes() {
		return payTimes;
	}

	public void setPayTimes(String payTimes) {
		this.payTimes = payTimes;
	}

	public String getGroupNo() {
		return groupNo;
	}

	public void setGroupNo(String groupNo) {
		this.groupNo = groupNo;
	}
	public String getStartHour() {
		return startHour;
	}

	public void setStartHour(String startHour) {
		this.startHour = startHour;
	}

	public String getEndHour() {
		return endHour;
	}

	public void setEndHour(String endHour) {
		this.endHour = endHour;
	}

	public String getCoinsFlag() {
		return coinsFlag;
	}

	public void setCoinsFlag(String coinsFlag) {
		this.coinsFlag = coinsFlag;
	}

	public String getSumAmount() {
		return sumAmount;
	}

	public void setSumAmount(String sumAmount) {
		this.sumAmount = sumAmount;
	}

	public String getSumPremium() {
		return sumPremium;
	}

	public void setSumPremium(String sumPremium) {
		this.sumPremium = sumPremium;
	}

	public String getEccFlag() {
		return eccFlag;
	}

	public void setEccFlag(String eccFlag) {
		this.eccFlag = eccFlag;
	}

	public String getPovertyFlag() {
		return povertyFlag;
	}

	public void setPovertyFlag(String povertyFlag) {
		this.povertyFlag = povertyFlag;
	}
}

