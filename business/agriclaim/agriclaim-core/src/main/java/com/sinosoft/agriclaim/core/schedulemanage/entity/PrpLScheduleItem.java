package com.sinosoft.agriclaim.core.schedulemanage.entity;

import com.sinosoft.framework.core.dao.BaseEntityImpl;
import javax.persistence.*;
import java.util.Date;

/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-11-08 05:45:58.930 
 * 调度任务标的表实体操作对象
 */
@Entity
@Table(name = "PrpLScheduleItem")
@IdClass(PrpLScheduleItemKey.class)
public class PrpLScheduleItem extends BaseEntityImpl{

	private static final long serialVersionUID = 1L;
	/** 属性调度ID/调度ID */
	@Id
	@Column(name = "scheduleId")
	private java.lang.Integer scheduleId ;/** 属性报案号码/报案号码 */
	@Id
	@Column(name = "registNo")
	private String registNo ;/** 属性标的序号/标的序号 */
	@Id
	@Column(name = "itemNo")
	private java.lang.Integer itemNo ;	



	/** 属性是否为本保单车辆/是否为本保单车辆 */
	@Column(name = "insureCarFlag")
	private String insureCarFlag ;
	/** 属性理赔处理机构/理赔处理机构 */
	@Column(name = "claimComCode")
	private String claimComCode ;
	/** 属性是否选择发送/是否选择发送 */
	@Column(name = "selectSend")
	private String selectSend ;
	/** 属性查勘次数/查勘次数 */
	@Column(name = "surveyTimes")
	private java.lang.Integer surveyTimes ;
	/** 属性查勘地点类型/查勘地点类型 */
	@Column(name = "surveyType")
	private String surveyType ;
	/** 属性查勘地址/查勘地址 */
	@Column(name = "checkSite")
	private String checkSite ;
	/** 属性出险车牌号码/出险车牌号码 */
	@Column(name = "licenseNo")
	private String licenseNo ;
	/** 属性调度对象代码/调度对象代码 */
	@Column(name = "scheduleObjectId")
	private String scheduleObjectId ;
	/** 属性调度对象名称/调度对象名称 */
	@Column(name = "scheduleObjectName")
	private String scheduleObjectName ;
	/** 属性计算机输单日期/计算机输单日期 */
	@Column(name = "inputDate")
	private java.util.Date inputDate ;
	/** 属性调度信息/调度信息 */
	@Column(name = "resultInfo")
	private String resultInfo ;
	/** 属性预约查勘/预约查勘 */
	@Column(name = "bookFlag")
	private String bookFlag ;
	/** 属性调度类型/调度类型 */
	@Column(name = "scheduleType")
	private String scheduleType ;
	/** 属性状态标志/状态标志 */
	@Column(name = "flag")
	private String flag ;
	/** 属性下一个节点人的代码/下一个节点人的代码 */
	@Column(name = "nextHandlerCode")
	private String nextHandlerCode ;
	/** 属性下一个节点人的名称/下一个节点人的名称 */
	@Column(name = "nextHandlerName")
	private String nextHandlerName ;
	/** 属性下一个节点的类型/下一个节点的类型 */
	@Column(name = "nextNodeNo")
	private String nextNodeNo ;
	/** 属性调度操作员代码/调度操作员代码 */
	@Column(name = "operatorCode")
	private String operatorCode ;
	/** 属性修理厂联系电话/修理厂联系电话 */
	@Column(name = "factoryPhone")
	private String factoryPhone ;
	/** 属性修理厂报损总金额/修理厂报损总金额 */
	@Column(name = "factorYestimateLoss")
	private java.lang.Double factorYestimateLoss ;
	/** 属性紧急程度/紧急程度 */
	@Column(name = "exigencegree")
	private String exigencegree ;
	/** 属性推荐修理厂名称/推荐修理厂名称 */
	@Column(name = "commendRepairFactoryName")
	private String commendRepairFactoryName ;
	/** 属性推荐修理厂编码/推荐修理厂编码 */
	@Column(name = "commendRepairFactoryCode")
	private String commendRepairFactoryCode ;
	/** 属性进度状态/进度状态 */
	@Column(name = "scheduleStatus")
	private String scheduleStatus ;
	/** 属性委员会项目标志/委员会项目标志 */
	@Column(name = "commiItemFlag")
	private String commiItemFlag ;
	/** 属性派工类型/派工类型 */
	@Column(name = "scheduleWay")
	private String scheduleWay ;
	/** 属性调度时间/调度时间 */
	@Column(name = "scheduleDate")
	private String scheduleDate ;
	/** 属性调度任务来源/调度任务来源 */
	@Column(name = "trackType")
	private String trackType ;
	/** 属性任务编码/任务编码 */
	@Column(name = "taskId")
	private String taskId ;
	/** 属性任务状态/任务状态 */
	@Column(name = "taskType")
	private String taskType ;
	/** 属性派工区域/派工区域 */
	@Column(name = "dispatchArea")
	private String dispatchArea ;
	/** 属性派工区域名称/派工区域名称 */
	@Column(name = "dispatchAreaName")
	private String dispatchAreaName ;
	/** 属性公估机构代查勘权限/公估机构代查勘权限 */
	@Column(name = "amountPower")
	private java.lang.Double amountPower ;




	/**
	 * 属性调度ID/调度ID的getter方法
	 */
	public java.lang.Integer getScheduleId() {
		return scheduleId;
	}
	/**
	 * 属性调度ID/调度ID的setter方法
	 */
	public void setScheduleId(java.lang.Integer scheduleId) {
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
	public java.lang.Integer getItemNo() {
		return itemNo;
	}
	/**
	 * 属性标的序号/标的序号的setter方法
	 */
	public void setItemNo(java.lang.Integer itemNo) {
		this.itemNo = itemNo;
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
	public String getSelectSend() {
		return selectSend;
	}
	/**
	 * 属性是否选择发送/是否选择发送的setter方法
	 */
	public void setSelectSend(String selectSend) {
		this.selectSend = selectSend;
	} 	
	/**
	 * 属性查勘次数/查勘次数的getter方法
	 */
	public java.lang.Integer getSurveyTimes() {
		return surveyTimes;
	}
	/**
	 * 属性查勘次数/查勘次数的setter方法
	 */
	public void setSurveyTimes(java.lang.Integer surveyTimes) {
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
	 * 属性查勘地址/查勘地址的getter方法
	 */
	public String getCheckSite() {
		return checkSite;
	}
	/**
	 * 属性查勘地址/查勘地址的setter方法
	 */
	public void setCheckSite(String checkSite) {
		this.checkSite = checkSite;
	} 	
	/**
	 * 属性出险车牌号码/出险车牌号码的getter方法
	 */
	public String getLicenseNo() {
		return licenseNo;
	}
	/**
	 * 属性出险车牌号码/出险车牌号码的setter方法
	 */
	public void setLicenseNo(String licenseNo) {
		this.licenseNo = licenseNo;
	} 	
	/**
	 * 属性调度对象代码/调度对象代码的getter方法
	 */
	public String getScheduleObjectId() {
		return scheduleObjectId;
	}
	/**
	 * 属性调度对象代码/调度对象代码的setter方法
	 */
	public void setScheduleObjectId(String scheduleObjectId) {
		this.scheduleObjectId = scheduleObjectId;
	} 	
	/**
	 * 属性调度对象名称/调度对象名称的getter方法
	 */
	public String getScheduleObjectName() {
		return scheduleObjectName;
	}
	/**
	 * 属性调度对象名称/调度对象名称的setter方法
	 */
	public void setScheduleObjectName(String scheduleObjectName) {
		this.scheduleObjectName = scheduleObjectName;
	} 	
	/**
	 * 属性计算机输单日期/计算机输单日期的getter方法
	 */
	public java.util.Date getInputDate() {
		return inputDate;
	}
	/**
	 * 属性计算机输单日期/计算机输单日期的setter方法
	 */
	public void setInputDate(java.util.Date inputDate) {
		this.inputDate = inputDate;
	} 	
	/**
	 * 属性调度信息/调度信息的getter方法
	 */
	public String getResultInfo() {
		return resultInfo;
	}
	/**
	 * 属性调度信息/调度信息的setter方法
	 */
	public void setResultInfo(String resultInfo) {
		this.resultInfo = resultInfo;
	} 	
	/**
	 * 属性预约查勘/预约查勘的getter方法
	 */
	public String getBookFlag() {
		return bookFlag;
	}
	/**
	 * 属性预约查勘/预约查勘的setter方法
	 */
	public void setBookFlag(String bookFlag) {
		this.bookFlag = bookFlag;
	} 	
	/**
	 * 属性调度类型/调度类型的getter方法
	 */
	public String getScheduleType() {
		return scheduleType;
	}
	/**
	 * 属性调度类型/调度类型的setter方法
	 */
	public void setScheduleType(String scheduleType) {
		this.scheduleType = scheduleType;
	} 	
	/**
	 * 属性状态标志/状态标志的getter方法
	 */
	public String getFlag() {
		return flag;
	}
	/**
	 * 属性状态标志/状态标志的setter方法
	 */
	public void setFlag(String flag) {
		this.flag = flag;
	} 	
	/**
	 * 属性下一个节点人的代码/下一个节点人的代码的getter方法
	 */
	public String getNextHandlerCode() {
		return nextHandlerCode;
	}
	/**
	 * 属性下一个节点人的代码/下一个节点人的代码的setter方法
	 */
	public void setNextHandlerCode(String nextHandlerCode) {
		this.nextHandlerCode = nextHandlerCode;
	} 	
	/**
	 * 属性下一个节点人的名称/下一个节点人的名称的getter方法
	 */
	public String getNextHandlerName() {
		return nextHandlerName;
	}
	/**
	 * 属性下一个节点人的名称/下一个节点人的名称的setter方法
	 */
	public void setNextHandlerName(String nextHandlerName) {
		this.nextHandlerName = nextHandlerName;
	} 	
	/**
	 * 属性下一个节点的类型/下一个节点的类型的getter方法
	 */
	public String getNextNodeNo() {
		return nextNodeNo;
	}
	/**
	 * 属性下一个节点的类型/下一个节点的类型的setter方法
	 */
	public void setNextNodeNo(String nextNodeNo) {
		this.nextNodeNo = nextNodeNo;
	} 	
	/**
	 * 属性调度操作员代码/调度操作员代码的getter方法
	 */
	public String getOperatorCode() {
		return operatorCode;
	}
	/**
	 * 属性调度操作员代码/调度操作员代码的setter方法
	 */
	public void setOperatorCode(String operatorCode) {
		this.operatorCode = operatorCode;
	} 	
	/**
	 * 属性修理厂联系电话/修理厂联系电话的getter方法
	 */
	public String getFactoryPhone() {
		return factoryPhone;
	}
	/**
	 * 属性修理厂联系电话/修理厂联系电话的setter方法
	 */
	public void setFactoryPhone(String factoryPhone) {
		this.factoryPhone = factoryPhone;
	} 	
	/**
	 * 属性修理厂报损总金额/修理厂报损总金额的getter方法
	 */
	public java.lang.Double getFactorYestimateLoss() {
		return factorYestimateLoss;
	}
	/**
	 * 属性修理厂报损总金额/修理厂报损总金额的setter方法
	 */
	public void setFactorYestimateLoss(java.lang.Double factorYestimateLoss) {
		this.factorYestimateLoss = factorYestimateLoss;
	} 	
	/**
	 * 属性紧急程度/紧急程度的getter方法
	 */
	public String getExigencegree() {
		return exigencegree;
	}
	/**
	 * 属性紧急程度/紧急程度的setter方法
	 */
	public void setExigencegree(String exigencegree) {
		this.exigencegree = exigencegree;
	} 	
	/**
	 * 属性推荐修理厂名称/推荐修理厂名称的getter方法
	 */
	public String getCommendRepairFactoryName() {
		return commendRepairFactoryName;
	}
	/**
	 * 属性推荐修理厂名称/推荐修理厂名称的setter方法
	 */
	public void setCommendRepairFactoryName(String commendRepairFactoryName) {
		this.commendRepairFactoryName = commendRepairFactoryName;
	} 	
	/**
	 * 属性推荐修理厂编码/推荐修理厂编码的getter方法
	 */
	public String getCommendRepairFactoryCode() {
		return commendRepairFactoryCode;
	}
	/**
	 * 属性推荐修理厂编码/推荐修理厂编码的setter方法
	 */
	public void setCommendRepairFactoryCode(String commendRepairFactoryCode) {
		this.commendRepairFactoryCode = commendRepairFactoryCode;
	} 	
	/**
	 * 属性进度状态/进度状态的getter方法
	 */
	public String getScheduleStatus() {
		return scheduleStatus;
	}
	/**
	 * 属性进度状态/进度状态的setter方法
	 */
	public void setScheduleStatus(String scheduleStatus) {
		this.scheduleStatus = scheduleStatus;
	} 	
	/**
	 * 属性委员会项目标志/委员会项目标志的getter方法
	 */
	public String getCommiItemFlag() {
		return commiItemFlag;
	}
	/**
	 * 属性委员会项目标志/委员会项目标志的setter方法
	 */
	public void setCommiItemFlag(String commiItemFlag) {
		this.commiItemFlag = commiItemFlag;
	} 	
	/**
	 * 属性派工类型/派工类型的getter方法
	 */
	public String getScheduleWay() {
		return scheduleWay;
	}
	/**
	 * 属性派工类型/派工类型的setter方法
	 */
	public void setScheduleWay(String scheduleWay) {
		this.scheduleWay = scheduleWay;
	} 	
	/**
	 * 属性调度时间/调度时间的getter方法
	 */
	public String getScheduleDate() {
		return scheduleDate;
	}
	/**
	 * 属性调度时间/调度时间的setter方法
	 */
	public void setScheduleDate(String scheduleDate) {
		this.scheduleDate = scheduleDate;
	} 	
	/**
	 * 属性调度任务来源/调度任务来源的getter方法
	 */
	public String getTrackType() {
		return trackType;
	}
	/**
	 * 属性调度任务来源/调度任务来源的setter方法
	 */
	public void setTrackType(String trackType) {
		this.trackType = trackType;
	} 	
	/**
	 * 属性任务编码/任务编码的getter方法
	 */
	public String getTaskId() {
		return taskId;
	}
	/**
	 * 属性任务编码/任务编码的setter方法
	 */
	public void setTaskId(String taskId) {
		this.taskId = taskId;
	} 	
	/**
	 * 属性任务状态/任务状态的getter方法
	 */
	public String getTaskType() {
		return taskType;
	}
	/**
	 * 属性任务状态/任务状态的setter方法
	 */
	public void setTaskType(String taskType) {
		this.taskType = taskType;
	} 	
	/**
	 * 属性派工区域/派工区域的getter方法
	 */
	public String getDispatchArea() {
		return dispatchArea;
	}
	/**
	 * 属性派工区域/派工区域的setter方法
	 */
	public void setDispatchArea(String dispatchArea) {
		this.dispatchArea = dispatchArea;
	} 	
	/**
	 * 属性派工区域名称/派工区域名称的getter方法
	 */
	public String getDispatchAreaName() {
		return dispatchAreaName;
	}
	/**
	 * 属性派工区域名称/派工区域名称的setter方法
	 */
	public void setDispatchAreaName(String dispatchAreaName) {
		this.dispatchAreaName = dispatchAreaName;
	} 	
	/**
	 * 属性公估机构代查勘权限/公估机构代查勘权限的getter方法
	 */
	public java.lang.Double getAmountPower() {
		return amountPower;
	}
	/**
	 * 属性公估机构代查勘权限/公估机构代查勘权限的setter方法
	 */
	public void setAmountPower(java.lang.Double amountPower) {
		this.amountPower = amountPower;
	} 	
		
		
		
		
}