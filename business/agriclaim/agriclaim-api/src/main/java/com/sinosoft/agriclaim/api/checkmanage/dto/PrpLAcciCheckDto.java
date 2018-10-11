package com.sinosoft.agriclaim.api.checkmanage.dto;

import java.io.Serializable;

import com.sinosoft.framework.dto.BaseRequest;
/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-11-08 05:38:49.324 
 * 意健险调查主表Api操作对象
 */
public class PrpLAcciCheckDto extends BaseRequest implements Serializable{
	private static final long serialVersionUID = 1L;
	/** 属性报案号码/报案号码 */
	private String registNo ;		
	/** 属性时间/时间 */
	private java.lang.Integer times ;		
	/** 属性查勘序号/查勘序号 */
	private String checkNo ;		
	/** 属性业务类型/业务类型 */
	private String certiType ;		
	/** 属性保单号码/批单号码/保单号码/批单号码 */
	private String certiNo ;		
	/** 属性险类代码/险类代码 */
	private String riskCode ;		
	/** 属性保单号/保单号 */
	private String policyNo ;		
	/** 属性查勘类型/查勘类型 */
	private String checkType ;		
	/** 属性查勘文本/查勘文本 */
	private String checkContext ;		
	/** 属性查勘对象/查勘对象 */
	private String checkObject ;		
	/** 属性暂无/暂无 */
	private String checkObjectDesc ;		
	/** 属性查勘/代查勘性质/查勘/代查勘性质 */
	private String checkNature ;		
	/** 属性查勘/代查勘日期/查勘/代查勘日期 */
	private java.util.Date checkDate ;		
	/** 属性查勘/代查勘地点/查勘/代查勘地点 */
	private String checkHour ;		
	/** 属性查勘/代查勘结束日期/查勘/代查勘结束日期 */
	private java.util.Date checkEndDate ;		
	/** 属性查勘/代查勘结束小时/查勘/代查勘结束小时 */
	private String checkEndHour ;		
	/** 属性检查现场/检查现场 */
	private String checkSite ;		
	/** 属性损害编码/损害编码 */
	private String damageCode ;		
	/** 属性损伤名称/损伤名称 */
	private String damageName ;		
	/** 属性损伤类型编码/损伤类型编码 */
	private String damageTypeCode ;		
	/** 属性损伤类型名称/损伤类型名称 */
	private String damageTypeName ;		
	/** 属性查勘人员代码/查勘人员代码 */
	private String checkerCode ;		
	/** 属性审批人编码/审批人编码 */
	private String approverCode ;		
	/** 属性审批日期/审批日期 */
	private java.util.Date approverDate ;		
	/** 属性审批状态/审批状态 */
	private String approverStatus ;		
	/** 属性备注/备注 */
	private String remark ;		
	/** 属性标志/标志 */
	private String flag ;		
	/** 属性币别/币别 */
	private String currency ;		
	/** 属性查勘费用/查勘费用 */
	private java.lang.Double checkFee ;		
	/** 属性案件类型/案件类型 */
	private String caseType ;		
	/**
	 * 属性报案号码/报案号码的getter方法
	 */
	public String getRegistNo() {
		return registNo;
	}
	/**
	 * 属性报案号码/报案号码的setter方法
	 */
	public void setRegistNo(String registNo) {
		this.registNo = registNo;
	}	
	/**
	 * 属性时间/时间的getter方法
	 */
	public java.lang.Integer getTimes() {
		return times;
	}
	/**
	 * 属性时间/时间的setter方法
	 */
	public void setTimes(java.lang.Integer times) {
		this.times = times;
	}	
	/**
	 * 属性查勘序号/查勘序号的getter方法
	 */
	public String getCheckNo() {
		return checkNo;
	}
	/**
	 * 属性查勘序号/查勘序号的setter方法
	 */
	public void setCheckNo(String checkNo) {
		this.checkNo = checkNo;
	}	
	/**
	 * 属性业务类型/业务类型的getter方法
	 */
	public String getCertiType() {
		return certiType;
	}
	/**
	 * 属性业务类型/业务类型的setter方法
	 */
	public void setCertiType(String certiType) {
		this.certiType = certiType;
	}	
	/**
	 * 属性保单号码/批单号码/保单号码/批单号码的getter方法
	 */
	public String getCertiNo() {
		return certiNo;
	}
	/**
	 * 属性保单号码/批单号码/保单号码/批单号码的setter方法
	 */
	public void setCertiNo(String certiNo) {
		this.certiNo = certiNo;
	}	
	/**
	 * 属性险类代码/险类代码的getter方法
	 */
	public String getRiskCode() {
		return riskCode;
	}
	/**
	 * 属性险类代码/险类代码的setter方法
	 */
	public void setRiskCode(String riskCode) {
		this.riskCode = riskCode;
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
	 * 属性查勘类型/查勘类型的getter方法
	 */
	public String getCheckType() {
		return checkType;
	}
	/**
	 * 属性查勘类型/查勘类型的setter方法
	 */
	public void setCheckType(String checkType) {
		this.checkType = checkType;
	}	
	/**
	 * 属性查勘文本/查勘文本的getter方法
	 */
	public String getCheckContext() {
		return checkContext;
	}
	/**
	 * 属性查勘文本/查勘文本的setter方法
	 */
	public void setCheckContext(String checkContext) {
		this.checkContext = checkContext;
	}	
	/**
	 * 属性查勘对象/查勘对象的getter方法
	 */
	public String getCheckObject() {
		return checkObject;
	}
	/**
	 * 属性查勘对象/查勘对象的setter方法
	 */
	public void setCheckObject(String checkObject) {
		this.checkObject = checkObject;
	}	
	/**
	 * 属性暂无/暂无的getter方法
	 */
	public String getCheckObjectDesc() {
		return checkObjectDesc;
	}
	/**
	 * 属性暂无/暂无的setter方法
	 */
	public void setCheckObjectDesc(String checkObjectDesc) {
		this.checkObjectDesc = checkObjectDesc;
	}	
	/**
	 * 属性查勘/代查勘性质/查勘/代查勘性质的getter方法
	 */
	public String getCheckNature() {
		return checkNature;
	}
	/**
	 * 属性查勘/代查勘性质/查勘/代查勘性质的setter方法
	 */
	public void setCheckNature(String checkNature) {
		this.checkNature = checkNature;
	}	
	/**
	 * 属性查勘/代查勘日期/查勘/代查勘日期的getter方法
	 */
	public java.util.Date getCheckDate() {
		return checkDate;
	}
	/**
	 * 属性查勘/代查勘日期/查勘/代查勘日期的setter方法
	 */
	public void setCheckDate(java.util.Date checkDate) {
		this.checkDate = checkDate;
	}	
	/**
	 * 属性查勘/代查勘地点/查勘/代查勘地点的getter方法
	 */
	public String getCheckHour() {
		return checkHour;
	}
	/**
	 * 属性查勘/代查勘地点/查勘/代查勘地点的setter方法
	 */
	public void setCheckHour(String checkHour) {
		this.checkHour = checkHour;
	}	
	/**
	 * 属性查勘/代查勘结束日期/查勘/代查勘结束日期的getter方法
	 */
	public java.util.Date getCheckEndDate() {
		return checkEndDate;
	}
	/**
	 * 属性查勘/代查勘结束日期/查勘/代查勘结束日期的setter方法
	 */
	public void setCheckEndDate(java.util.Date checkEndDate) {
		this.checkEndDate = checkEndDate;
	}	
	/**
	 * 属性查勘/代查勘结束小时/查勘/代查勘结束小时的getter方法
	 */
	public String getCheckEndHour() {
		return checkEndHour;
	}
	/**
	 * 属性查勘/代查勘结束小时/查勘/代查勘结束小时的setter方法
	 */
	public void setCheckEndHour(String checkEndHour) {
		this.checkEndHour = checkEndHour;
	}	
	/**
	 * 属性检查现场/检查现场的getter方法
	 */
	public String getCheckSite() {
		return checkSite;
	}
	/**
	 * 属性检查现场/检查现场的setter方法
	 */
	public void setCheckSite(String checkSite) {
		this.checkSite = checkSite;
	}	
	/**
	 * 属性损害编码/损害编码的getter方法
	 */
	public String getDamageCode() {
		return damageCode;
	}
	/**
	 * 属性损害编码/损害编码的setter方法
	 */
	public void setDamageCode(String damageCode) {
		this.damageCode = damageCode;
	}	
	/**
	 * 属性损伤名称/损伤名称的getter方法
	 */
	public String getDamageName() {
		return damageName;
	}
	/**
	 * 属性损伤名称/损伤名称的setter方法
	 */
	public void setDamageName(String damageName) {
		this.damageName = damageName;
	}	
	/**
	 * 属性损伤类型编码/损伤类型编码的getter方法
	 */
	public String getDamageTypeCode() {
		return damageTypeCode;
	}
	/**
	 * 属性损伤类型编码/损伤类型编码的setter方法
	 */
	public void setDamageTypeCode(String damageTypeCode) {
		this.damageTypeCode = damageTypeCode;
	}	
	/**
	 * 属性损伤类型名称/损伤类型名称的getter方法
	 */
	public String getDamageTypeName() {
		return damageTypeName;
	}
	/**
	 * 属性损伤类型名称/损伤类型名称的setter方法
	 */
	public void setDamageTypeName(String damageTypeName) {
		this.damageTypeName = damageTypeName;
	}	
	/**
	 * 属性查勘人员代码/查勘人员代码的getter方法
	 */
	public String getCheckerCode() {
		return checkerCode;
	}
	/**
	 * 属性查勘人员代码/查勘人员代码的setter方法
	 */
	public void setCheckerCode(String checkerCode) {
		this.checkerCode = checkerCode;
	}	
	/**
	 * 属性审批人编码/审批人编码的getter方法
	 */
	public String getApproverCode() {
		return approverCode;
	}
	/**
	 * 属性审批人编码/审批人编码的setter方法
	 */
	public void setApproverCode(String approverCode) {
		this.approverCode = approverCode;
	}	
	/**
	 * 属性审批日期/审批日期的getter方法
	 */
	public java.util.Date getApproverDate() {
		return approverDate;
	}
	/**
	 * 属性审批日期/审批日期的setter方法
	 */
	public void setApproverDate(java.util.Date approverDate) {
		this.approverDate = approverDate;
	}	
	/**
	 * 属性审批状态/审批状态的getter方法
	 */
	public String getApproverStatus() {
		return approverStatus;
	}
	/**
	 * 属性审批状态/审批状态的setter方法
	 */
	public void setApproverStatus(String approverStatus) {
		this.approverStatus = approverStatus;
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
	 * 属性标志/标志的getter方法
	 */
	public String getFlag() {
		return flag;
	}
	/**
	 * 属性标志/标志的setter方法
	 */
	public void setFlag(String flag) {
		this.flag = flag;
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
	 * 属性查勘费用/查勘费用的getter方法
	 */
	public java.lang.Double getCheckFee() {
		return checkFee;
	}
	/**
	 * 属性查勘费用/查勘费用的setter方法
	 */
	public void setCheckFee(java.lang.Double checkFee) {
		this.checkFee = checkFee;
	}	
	/**
	 * 属性案件类型/案件类型的getter方法
	 */
	public String getCaseType() {
		return caseType;
	}
	/**
	 * 属性案件类型/案件类型的setter方法
	 */
	public void setCaseType(String caseType) {
		this.caseType = caseType;
	}	
}
