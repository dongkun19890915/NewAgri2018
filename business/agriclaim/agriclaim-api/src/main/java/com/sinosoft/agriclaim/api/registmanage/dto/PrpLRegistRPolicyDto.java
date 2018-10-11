package com.sinosoft.agriclaim.api.registmanage.dto;

import java.io.Serializable;

import com.sinosoft.framework.dto.BaseRequest;
/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-11-08 05:45:22.527 
 * 赔案保单关联表Api操作对象
 */
public class PrpLRegistRPolicyDto extends BaseRequest implements Serializable{
	private static final long serialVersionUID = 1L;
	/** 属性报案号/报案号 */
	private String registNo ;		
	/** 属性保单号/保单号 */
	private String policyNo ;		
	/** 属性立案号/立案号 */
	private String claimNo ;		
	/** 属性保单类型/保单类型 */
	private String policyType ;		
	/** 属性工作流号码/工作流号码 */
	private String flowId ;		
	/** 属性备注/备注 */
	private String remark ;		
	/** 属性是否有效的标记/是否有效的标记 */
	private String validStatus ;		
	/** 属性标志/标志 */
	private String flag ;		
	/** 属性险种/险种 */
	private String riskCode ;		
	/** 属性报案有效标志/报案有效标志 */
	private String registFlag ;		
	/** 属性注销原因代码/注销原因代码 */
	private String cancelReason ;		
	/** 属性注销原因名称/注销原因名称 */
	private String cancelReasonName ;		
	/** 属性被保险人代码/被保险人代码 */
	private String insuredCode ;		
	/** 属性被保险人名称/被保险人名称 */
	private String insuredName ;		
	/** 属性车牌号/车牌号 */
	private String licensenNo ;		
	/** 属性出险次数/出险次数 */
	private java.lang.Integer dangerTimes ;		
	/** 属性截止日期/截止日期 */
	private String endDate ;		
	/** 属性机构代码/机构代码 */
	private String comCode ;		
	/** 属性车架号/车架号 */
	private String frameNo ;		
	/** 属性起始日期/起始日期 */
	private String startDate ;		
	/** 属性发动机号/发动机号 */
	private String engineNo ;		
	/** 属性报案关联保单有效标志/报案关联保单有效标志 */
	private String registValidStatus ;		
	/** 属性报案关联保单的录入日期/报案关联保单的录入日期 */
	private java.util.Date inputDate ;		
	/** 属性录入人代码/录入人代码 */
	private String operatorCode ;		
	/** 属性录入人归属机构/录入人归属机构 */
	private String registComCode ;		
	/** 属性注销日期/注销日期 */
	private String cancelDate ;		
	/** 属性注销操作人员代码/注销操作人员代码 */
	private String cancelOperaterCode ;		
	/** 属性注销机构代码/注销机构代码 */
	private String cancelComCode ;		
	/** 属性承保公司/承保公司 */
	private String companyCode ;		
	/** 属性承保地区/承保地区 */
	private String comArea ;		
	/** 属性修改人/修改人 */
	private String updateBy ;		
	/** 属性修改时间/修改时间 */
	private java.util.Date updateDate ;		
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
	 * 属性保单类型/保单类型的getter方法
	 */
	public String getPolicyType() {
		return policyType;
	}
	/**
	 * 属性保单类型/保单类型的setter方法
	 */
	public void setPolicyType(String policyType) {
		this.policyType = policyType;
	}	
	/**
	 * 属性工作流号码/工作流号码的getter方法
	 */
	public String getFlowId() {
		return flowId;
	}
	/**
	 * 属性工作流号码/工作流号码的setter方法
	 */
	public void setFlowId(String flowId) {
		this.flowId = flowId;
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
	 * 属性是否有效的标记/是否有效的标记的getter方法
	 */
	public String getValidStatus() {
		return validStatus;
	}
	/**
	 * 属性是否有效的标记/是否有效的标记的setter方法
	 */
	public void setValidStatus(String validStatus) {
		this.validStatus = validStatus;
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
	 * 属性报案有效标志/报案有效标志的getter方法
	 */
	public String getRegistFlag() {
		return registFlag;
	}
	/**
	 * 属性报案有效标志/报案有效标志的setter方法
	 */
	public void setRegistFlag(String registFlag) {
		this.registFlag = registFlag;
	}	
	/**
	 * 属性注销原因代码/注销原因代码的getter方法
	 */
	public String getCancelReason() {
		return cancelReason;
	}
	/**
	 * 属性注销原因代码/注销原因代码的setter方法
	 */
	public void setCancelReason(String cancelReason) {
		this.cancelReason = cancelReason;
	}	
	/**
	 * 属性注销原因名称/注销原因名称的getter方法
	 */
	public String getCancelReasonName() {
		return cancelReasonName;
	}
	/**
	 * 属性注销原因名称/注销原因名称的setter方法
	 */
	public void setCancelReasonName(String cancelReasonName) {
		this.cancelReasonName = cancelReasonName;
	}	
	/**
	 * 属性被保险人代码/被保险人代码的getter方法
	 */
	public String getInsuredCode() {
		return insuredCode;
	}
	/**
	 * 属性被保险人代码/被保险人代码的setter方法
	 */
	public void setInsuredCode(String insuredCode) {
		this.insuredCode = insuredCode;
	}	
	/**
	 * 属性被保险人名称/被保险人名称的getter方法
	 */
	public String getInsuredName() {
		return insuredName;
	}
	/**
	 * 属性被保险人名称/被保险人名称的setter方法
	 */
	public void setInsuredName(String insuredName) {
		this.insuredName = insuredName;
	}	
	/**
	 * 属性车牌号/车牌号的getter方法
	 */
	public String getLicensenNo() {
		return licensenNo;
	}
	/**
	 * 属性车牌号/车牌号的setter方法
	 */
	public void setLicensenNo(String licensenNo) {
		this.licensenNo = licensenNo;
	}	
	/**
	 * 属性出险次数/出险次数的getter方法
	 */
	public java.lang.Integer getDangerTimes() {
		return dangerTimes;
	}
	/**
	 * 属性出险次数/出险次数的setter方法
	 */
	public void setDangerTimes(java.lang.Integer dangerTimes) {
		this.dangerTimes = dangerTimes;
	}	
	/**
	 * 属性截止日期/截止日期的getter方法
	 */
	public String getEndDate() {
		return endDate;
	}
	/**
	 * 属性截止日期/截止日期的setter方法
	 */
	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}	
	/**
	 * 属性机构代码/机构代码的getter方法
	 */
	public String getComCode() {
		return comCode;
	}
	/**
	 * 属性机构代码/机构代码的setter方法
	 */
	public void setComCode(String comCode) {
		this.comCode = comCode;
	}	
	/**
	 * 属性车架号/车架号的getter方法
	 */
	public String getFrameNo() {
		return frameNo;
	}
	/**
	 * 属性车架号/车架号的setter方法
	 */
	public void setFrameNo(String frameNo) {
		this.frameNo = frameNo;
	}	
	/**
	 * 属性起始日期/起始日期的getter方法
	 */
	public String getStartDate() {
		return startDate;
	}
	/**
	 * 属性起始日期/起始日期的setter方法
	 */
	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}	
	/**
	 * 属性发动机号/发动机号的getter方法
	 */
	public String getEngineNo() {
		return engineNo;
	}
	/**
	 * 属性发动机号/发动机号的setter方法
	 */
	public void setEngineNo(String engineNo) {
		this.engineNo = engineNo;
	}	
	/**
	 * 属性报案关联保单有效标志/报案关联保单有效标志的getter方法
	 */
	public String getRegistValidStatus() {
		return registValidStatus;
	}
	/**
	 * 属性报案关联保单有效标志/报案关联保单有效标志的setter方法
	 */
	public void setRegistValidStatus(String registValidStatus) {
		this.registValidStatus = registValidStatus;
	}	
	/**
	 * 属性报案关联保单的录入日期/报案关联保单的录入日期的getter方法
	 */
	public java.util.Date getInputDate() {
		return inputDate;
	}
	/**
	 * 属性报案关联保单的录入日期/报案关联保单的录入日期的setter方法
	 */
	public void setInputDate(java.util.Date inputDate) {
		this.inputDate = inputDate;
	}	
	/**
	 * 属性录入人代码/录入人代码的getter方法
	 */
	public String getOperatorCode() {
		return operatorCode;
	}
	/**
	 * 属性录入人代码/录入人代码的setter方法
	 */
	public void setOperatorCode(String operatorCode) {
		this.operatorCode = operatorCode;
	}	
	/**
	 * 属性录入人归属机构/录入人归属机构的getter方法
	 */
	public String getRegistComCode() {
		return registComCode;
	}
	/**
	 * 属性录入人归属机构/录入人归属机构的setter方法
	 */
	public void setRegistComCode(String registComCode) {
		this.registComCode = registComCode;
	}	
	/**
	 * 属性注销日期/注销日期的getter方法
	 */
	public String getCancelDate() {
		return cancelDate;
	}
	/**
	 * 属性注销日期/注销日期的setter方法
	 */
	public void setCancelDate(String cancelDate) {
		this.cancelDate = cancelDate;
	}	
	/**
	 * 属性注销操作人员代码/注销操作人员代码的getter方法
	 */
	public String getCancelOperaterCode() {
		return cancelOperaterCode;
	}
	/**
	 * 属性注销操作人员代码/注销操作人员代码的setter方法
	 */
	public void setCancelOperaterCode(String cancelOperaterCode) {
		this.cancelOperaterCode = cancelOperaterCode;
	}	
	/**
	 * 属性注销机构代码/注销机构代码的getter方法
	 */
	public String getCancelComCode() {
		return cancelComCode;
	}
	/**
	 * 属性注销机构代码/注销机构代码的setter方法
	 */
	public void setCancelComCode(String cancelComCode) {
		this.cancelComCode = cancelComCode;
	}	
	/**
	 * 属性承保公司/承保公司的getter方法
	 */
	public String getCompanyCode() {
		return companyCode;
	}
	/**
	 * 属性承保公司/承保公司的setter方法
	 */
	public void setCompanyCode(String companyCode) {
		this.companyCode = companyCode;
	}	
	/**
	 * 属性承保地区/承保地区的getter方法
	 */
	public String getComArea() {
		return comArea;
	}
	/**
	 * 属性承保地区/承保地区的setter方法
	 */
	public void setComArea(String comArea) {
		this.comArea = comArea;
	}	
	/**
	 * 属性修改人/修改人的getter方法
	 */
	public String getUpdateBy() {
		return updateBy;
	}
	/**
	 * 属性修改人/修改人的setter方法
	 */
	public void setUpdateBy(String updateBy) {
		this.updateBy = updateBy;
	}	
	/**
	 * 属性修改时间/修改时间的getter方法
	 */
	public java.util.Date getUpdateDate() {
		return updateDate;
	}
	/**
	 * 属性修改时间/修改时间的setter方法
	 */
	public void setUpdateDate(java.util.Date updateDate) {
		this.updateDate = updateDate;
	}	
}
