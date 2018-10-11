package com.sinosoft.agriclaim.core.schedulemanage.entity;

import com.sinosoft.framework.core.dao.BaseEntityImpl;
import javax.persistence.*;
import java.util.Date;

/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-11-08 05:45:58.930 
 * 调度任务主表实体操作对象
 */
@Entity
@Table(name = "PrpLScheduleMain")
@IdClass(PrpLScheduleMainKey.class)
public class PrpLScheduleMain extends BaseEntityImpl{

	private static final long serialVersionUID = 1L;
	/** 属性调度id/调度id */
	@Id
	@Column(name = "scheduleId")
	private java.lang.Double scheduleId ;/** 属性报案号码/报案号码 */
	@Id
	@Column(name = "registNo")
	private String registNo ;/** 属性标的序号/标的序号 */
	@Id
	@Column(name = "serialNo")
	private java.lang.Double serialNo ;	



	/** 属性是否为本保单车辆/是否为本保单车辆 */
	@Column(name = "insureCarFlag")
	private String insureCarFlag ;
	/** 属性理赔处理机构/理赔处理机构 */
	@Column(name = "claimComCode")
	private String claimComCode ;
	/** 属性是否选择发送/是否选择发送 */
	@Column(name = "selecttSend")
	private String selecttSend ;
	/** 属性险种代码/险种代码 */
	@Column(name = "riskCode")
	private String riskCode ;
	/** 属性保单号/保单号 */
	@Column(name = "policyNo")
	private String policyNo ;
	/** 属性调度部门代码/调度部门代码 */
	@Column(name = "scheduleDeptCode")
	private String scheduleDeptCode ;
	/** 属性调度部门名称/调度部门名称 */
	@Column(name = "scheduleDeptName")
	private String scheduleDeptName ;
	/** 属性调度操作员代码 /调度操作员代码  */
	@Column(name = "operatorCode")
	private String operatorCode ;
	/** 属性调度操作员名称/调度操作员名称 */
	@Column(name = "operatorName")
	private String operatorName ;
	/** 属性查勘次数/查勘次数 */
	@Column(name = "surveyTimes")
	private java.lang.Double surveyTimes ;
	/** 属性查勘地点类型/查勘地点类型 */
	@Column(name = "surveyType")
	private String surveyType ;
	/** 属性查看地址/查看地址 */
	@Column(name = "surveyAddress")
	private String surveyAddress ;
	/** 属性车牌号/车牌号 */
	@Column(name = "licenseNo")
	private String licenseNo ;
	/** 属性输入日期/输入日期 */
	@Column(name = "inputDate")
	private java.util.Date inputDate ;
	/** 属性输入小时/输入小时 */
	@Column(name = "inputHour")
	private java.lang.Double inputHour ;
	/** 属性结果信息/结果信息 */
	@Column(name = "resultInfo")
	private String resultInfo ;
	/** 属性转让标志/转让标志 */
	@Column(name = "transFlag")
	private String transFlag ;
	/** 属性预定标志/预定标志 */
	@Column(name = "bookFlag")
	private String bookFlag ;
	/** 属性调度标志/调度标志 */
	@Column(name = "scheduleFlag")
	private String scheduleFlag ;
	/** 属性标志位/标志位 */
	@Column(name = "flag")
	private String flag ;
	/**
	 * 属性调度id/调度id的getter方法
	 */
	public java.lang.Double getScheduleId() {
		return scheduleId;
	}
	/**
	 * 属性调度id/调度id的setter方法
	 */
	public void setScheduleId(java.lang.Double scheduleId) {
		this.scheduleId = scheduleId;
	} 	
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
	 * 属性标的序号/标的序号的getter方法
	 */
	public java.lang.Double getSerialNo() {
		return serialNo;
	}
	/**
	 * 属性标的序号/标的序号的setter方法
	 */
	public void setSerialNo(java.lang.Double serialNo) {
		this.serialNo = serialNo;
	} 	
	/**
	 * 属性是否为本保单车辆/是否为本保单车辆的getter方法
	 */
	public String getInsureCarFlag() {
		return insureCarFlag;
	}
	/**
	 * 属性是否为本保单车辆/是否为本保单车辆的setter方法
	 */
	public void setInsureCarFlag(String insureCarFlag) {
		this.insureCarFlag = insureCarFlag;
	} 	
	/**
	 * 属性理赔处理机构/理赔处理机构的getter方法
	 */
	public String getClaimComCode() {
		return claimComCode;
	}
	/**
	 * 属性理赔处理机构/理赔处理机构的setter方法
	 */
	public void setClaimComCode(String claimComCode) {
		this.claimComCode = claimComCode;
	} 	
	/**
	 * 属性是否选择发送/是否选择发送的getter方法
	 */
	public String getSelecttSend() {
		return selecttSend;
	}
	/**
	 * 属性是否选择发送/是否选择发送的setter方法
	 */
	public void setSelecttSend(String selecttSend) {
		this.selecttSend = selecttSend;
	} 	
	/**
	 * 属性险种代码/险种代码的getter方法
	 */
	public String getRiskCode() {
		return riskCode;
	}
	/**
	 * 属性险种代码/险种代码的setter方法
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
	 * 属性调度部门代码/调度部门代码的getter方法
	 */
	public String getScheduleDeptCode() {
		return scheduleDeptCode;
	}
	/**
	 * 属性调度部门代码/调度部门代码的setter方法
	 */
	public void setScheduleDeptCode(String scheduleDeptCode) {
		this.scheduleDeptCode = scheduleDeptCode;
	} 	
	/**
	 * 属性调度部门名称/调度部门名称的getter方法
	 */
	public String getScheduleDeptName() {
		return scheduleDeptName;
	}
	/**
	 * 属性调度部门名称/调度部门名称的setter方法
	 */
	public void setScheduleDeptName(String scheduleDeptName) {
		this.scheduleDeptName = scheduleDeptName;
	} 	
	/**
	 * 属性调度操作员代码 /调度操作员代码 的getter方法
	 */
	public String getOperatorCode() {
		return operatorCode;
	}
	/**
	 * 属性调度操作员代码 /调度操作员代码 的setter方法
	 */
	public void setOperatorCode(String operatorCode) {
		this.operatorCode = operatorCode;
	} 	
	/**
	 * 属性调度操作员名称/调度操作员名称的getter方法
	 */
	public String getOperatorName() {
		return operatorName;
	}
	/**
	 * 属性调度操作员名称/调度操作员名称的setter方法
	 */
	public void setOperatorName(String operatorName) {
		this.operatorName = operatorName;
	} 	
	/**
	 * 属性查勘次数/查勘次数的getter方法
	 */
	public java.lang.Double getSurveyTimes() {
		return surveyTimes;
	}
	/**
	 * 属性查勘次数/查勘次数的setter方法
	 */
	public void setSurveyTimes(java.lang.Double surveyTimes) {
		this.surveyTimes = surveyTimes;
	} 	
	/**
	 * 属性查勘地点类型/查勘地点类型的getter方法
	 */
	public String getSurveyType() {
		return surveyType;
	}
	/**
	 * 属性查勘地点类型/查勘地点类型的setter方法
	 */
	public void setSurveyType(String surveyType) {
		this.surveyType = surveyType;
	} 	
	/**
	 * 属性查看地址/查看地址的getter方法
	 */
	public String getSurveyAddress() {
		return surveyAddress;
	}
	/**
	 * 属性查看地址/查看地址的setter方法
	 */
	public void setSurveyAddress(String surveyAddress) {
		this.surveyAddress = surveyAddress;
	} 	
	/**
	 * 属性车牌号/车牌号的getter方法
	 */
	public String getLicenseNo() {
		return licenseNo;
	}
	/**
	 * 属性车牌号/车牌号的setter方法
	 */
	public void setLicenseNo(String licenseNo) {
		this.licenseNo = licenseNo;
	} 	
	/**
	 * 属性输入日期/输入日期的getter方法
	 */
	public java.util.Date getInputDate() {
		return inputDate;
	}
	/**
	 * 属性输入日期/输入日期的setter方法
	 */
	public void setInputDate(java.util.Date inputDate) {
		this.inputDate = inputDate;
	} 	
	/**
	 * 属性输入小时/输入小时的getter方法
	 */
	public java.lang.Double getInputHour() {
		return inputHour;
	}
	/**
	 * 属性输入小时/输入小时的setter方法
	 */
	public void setInputHour(java.lang.Double inputHour) {
		this.inputHour = inputHour;
	} 	
	/**
	 * 属性结果信息/结果信息的getter方法
	 */
	public String getResultInfo() {
		return resultInfo;
	}
	/**
	 * 属性结果信息/结果信息的setter方法
	 */
	public void setResultInfo(String resultInfo) {
		this.resultInfo = resultInfo;
	} 	
	/**
	 * 属性转让标志/转让标志的getter方法
	 */
	public String getTransFlag() {
		return transFlag;
	}
	/**
	 * 属性转让标志/转让标志的setter方法
	 */
	public void setTransFlag(String transFlag) {
		this.transFlag = transFlag;
	} 	
	/**
	 * 属性预定标志/预定标志的getter方法
	 */
	public String getBookFlag() {
		return bookFlag;
	}
	/**
	 * 属性预定标志/预定标志的setter方法
	 */
	public void setBookFlag(String bookFlag) {
		this.bookFlag = bookFlag;
	} 	
	/**
	 * 属性调度标志/调度标志的getter方法
	 */
	public String getScheduleFlag() {
		return scheduleFlag;
	}
	/**
	 * 属性调度标志/调度标志的setter方法
	 */
	public void setScheduleFlag(String scheduleFlag) {
		this.scheduleFlag = scheduleFlag;
	} 	
	/**
	 * 属性标志位/标志位的getter方法
	 */
	public String getFlag() {
		return flag;
	}
	/**
	 * 属性标志位/标志位的setter方法
	 */
	public void setFlag(String flag) {
		this.flag = flag;
	} 	
}