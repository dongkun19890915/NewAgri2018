package com.sinosoft.agriclaim.core.schedulemanage.entity;

import com.sinosoft.framework.core.dao.BaseEntityImpl;
import javax.persistence.*;
import java.util.Date;

/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-11-08 05:45:58.930 
 * 调度任务/查勘任务主表实体操作对象
 */
@Entity
@Table(name = "PrpLScheduleMainWf")
@IdClass(PrpLScheduleMainWfKey.class)
public class PrpLScheduleMainWf extends BaseEntityImpl{

	private static final long serialVersionUID = 1L;
	/** 属性调度ID/调度ID */
	@Id
	@Column(name = "scheduleId")
	private java.lang.Integer scheduleId ;/** 属性报案号码/报案号码 */
	@Id
	@Column(name = "registNo")
	private String registNo ;	


	/** 属性已查勘次数/已查勘次数 */
	@Column(name = "surveyNo")
	private java.lang.Integer surveyNo ;
	/** 属性理赔处理机构/理赔处理机构 */
	@Column(name = "claimcomCode")
	private String claimcomCode ;
	/** 属性险种代码/险种代码 */
	@Column(name = "riskCode")
	private String riskCode ;
	/** 属性保单号/保单号 */
	@Column(name = "policyNo")
	private String policyNo ;
	/** 属性调度操作员代码/调度操作员代码 */
	@Column(name = "operatorCode")
	private String operatorCode ;
	/** 属性计算机输单日期/计算机输单日期 */
	@Column(name = "inputDate")
	private java.util.Date inputDate ;
	/** 属性小时/小时 */
	@Column(name = "inputHour")
	private java.lang.Integer inputHour ;
	/** 属性调度区域/调度区域 */
	@Column(name = "scheduleArea")
	private java.lang.Integer scheduleArea ;
	/** 属性允许多级调度/允许多级调度 */
	@Column(name = "scheduleMoreFlag")
	private String scheduleMoreFlag ;
	/** 属性调度处理情况/调度处理情况 */
	@Column(name = "scheduleFlag")
	private String scheduleFlag ;
	/** 属性调度对象编码/调度对象编码 */
	@Column(name = "scheduleObjectId")
	private String scheduleObjectId ;
	/** 属性调度对象名称/调度对象名称 */
	@Column(name = "scheduleObjectName")
	private String scheduleObjectName ;
	/** 属性调度类型/调度类型 */
	@Column(name = "scheduleType")
	private String scheduleType ;
	/** 属性处理日期/处理日期 */
	@Column(name = "checkInputDate")
	private java.util.Date checkInputDate ;
	/** 属性查勘录入操作员代码/查勘录入操作员代码 */
	@Column(name = "checkOperatorCode")
	private String checkOperatorCode ;
	/** 属性查勘状态/查勘状态 */
	@Column(name = "checkFlag")
	private String checkFlag ;
	/** 属性处理信息/处理信息 */
	@Column(name = "checkInfo")
	private String checkInfo ;
	/** 属性备用状态/备用状态 */
	@Column(name = "flag")
	private String flag ;
	/** 属性查勘地址/查勘地址 */
	@Column(name = "checkSite")
	private String checkSite ;
	/** 属性下一个节点人的代码/下一个节点人的代码 */
	@Column(name = "nextHandlerCode")
	private String nextHandlerCode ;
	/** 属性下一个节点人的名称/下一个节点人的名称 */
	@Column(name = "nextHandlerName")
	private String nextHandlerName ;
	/** 属性下一个节点的类型/下一个节点的类型 */
	@Column(name = "nextNodeNo")
	private String nextNodeNo ;
	/** 属性输入分钟/输入分钟 */
	@Column(name = "inputMinute")
	private java.lang.Integer inputMinute ;
	/** 属性派工现状/派工现状 */
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
	/** 属性派工区域/派工区域 */
	@Column(name = "dispatchArea")
	private String dispatchArea ;
	/** 属性派工区域名称/派工区域名称 */
	@Column(name = "dispatchAreaName")
	private String dispatchAreaName ;
	/** 属性调度任务来源/调度任务来源 */
	@Column(name = "trackType")
	private String trackType ;
	/** 属性任务编码/任务编码 */
	@Column(name = "taskId")
	private String taskId ;
	/** 属性任务类型/任务类型 */
	@Column(name = "taskType")
	private String taskType ;
	/** 属性处理人所属部门/处理人所属部门 */
	@Column(name = "handlerDept")
	private String handlerDept ;
	/** 属性处理人编码/处理人编码 */
	@Column(name = "handlerCode")
	private String handlerCode ;




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
	 * 属性已查勘次数/已查勘次数的getter方法
	 */
	public java.lang.Integer getSurveyNo() {
		return surveyNo;
	}
	/**
	 * 属性已查勘次数/已查勘次数的setter方法
	 */
	public void setSurveyNo(java.lang.Integer surveyNo) {
		this.surveyNo = surveyNo;
	} 	
	/**
	 * 属性理赔处理机构/理赔处理机构的getter方法
	 */
	public String getClaimcomCode() {
		return claimcomCode;
	}
	/**
	 * 属性理赔处理机构/理赔处理机构的setter方法
	 */
	public void setClaimcomCode(String claimcomCode) {
		this.claimcomCode = claimcomCode;
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
	 * 属性小时/小时的getter方法
	 */
	public java.lang.Integer getInputHour() {
		return inputHour;
	}
	/**
	 * 属性小时/小时的setter方法
	 */
	public void setInputHour(java.lang.Integer inputHour) {
		this.inputHour = inputHour;
	} 	
	/**
	 * 属性调度区域/调度区域的getter方法
	 */
	public java.lang.Integer getScheduleArea() {
		return scheduleArea;
	}
	/**
	 * 属性调度区域/调度区域的setter方法
	 */
	public void setScheduleArea(java.lang.Integer scheduleArea) {
		this.scheduleArea = scheduleArea;
	} 	
	/**
	 * 属性允许多级调度/允许多级调度的getter方法
	 */
	public String getScheduleMoreFlag() {
		return scheduleMoreFlag;
	}
	/**
	 * 属性允许多级调度/允许多级调度的setter方法
	 */
	public void setScheduleMoreFlag(String scheduleMoreFlag) {
		this.scheduleMoreFlag = scheduleMoreFlag;
	} 	
	/**
	 * 属性调度处理情况/调度处理情况的getter方法
	 */
	public String getScheduleFlag() {
		return scheduleFlag;
	}
	/**
	 * 属性调度处理情况/调度处理情况的setter方法
	 */
	public void setScheduleFlag(String scheduleFlag) {
		this.scheduleFlag = scheduleFlag;
	} 	
	/**
	 * 属性调度对象编码/调度对象编码的getter方法
	 */
	public String getScheduleObjectId() {
		return scheduleObjectId;
	}
	/**
	 * 属性调度对象编码/调度对象编码的setter方法
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
	 * 属性处理日期/处理日期的getter方法
	 */
	public java.util.Date getCheckInputDate() {
		return checkInputDate;
	}
	/**
	 * 属性处理日期/处理日期的setter方法
	 */
	public void setCheckInputDate(java.util.Date checkInputDate) {
		this.checkInputDate = checkInputDate;
	} 	
	/**
	 * 属性查勘录入操作员代码/查勘录入操作员代码的getter方法
	 */
	public String getCheckOperatorCode() {
		return checkOperatorCode;
	}
	/**
	 * 属性查勘录入操作员代码/查勘录入操作员代码的setter方法
	 */
	public void setCheckOperatorCode(String checkOperatorCode) {
		this.checkOperatorCode = checkOperatorCode;
	} 	
	/**
	 * 属性查勘状态/查勘状态的getter方法
	 */
	public String getCheckFlag() {
		return checkFlag;
	}
	/**
	 * 属性查勘状态/查勘状态的setter方法
	 */
	public void setCheckFlag(String checkFlag) {
		this.checkFlag = checkFlag;
	} 	
	/**
	 * 属性处理信息/处理信息的getter方法
	 */
	public String getCheckInfo() {
		return checkInfo;
	}
	/**
	 * 属性处理信息/处理信息的setter方法
	 */
	public void setCheckInfo(String checkInfo) {
		this.checkInfo = checkInfo;
	} 	
	/**
	 * 属性备用状态/备用状态的getter方法
	 */
	public String getFlag() {
		return flag;
	}
	/**
	 * 属性备用状态/备用状态的setter方法
	 */
	public void setFlag(String flag) {
		this.flag = flag;
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
	 * 属性输入分钟/输入分钟的getter方法
	 */
	public java.lang.Integer getInputMinute() {
		return inputMinute;
	}
	/**
	 * 属性输入分钟/输入分钟的setter方法
	 */
	public void setInputMinute(java.lang.Integer inputMinute) {
		this.inputMinute = inputMinute;
	} 	
	/**
	 * 属性派工现状/派工现状的getter方法
	 */
	public String getScheduleStatus() {
		return scheduleStatus;
	}
	/**
	 * 属性派工现状/派工现状的setter方法
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
	 * 属性任务类型/任务类型的getter方法
	 */
	public String getTaskType() {
		return taskType;
	}
	/**
	 * 属性任务类型/任务类型的setter方法
	 */
	public void setTaskType(String taskType) {
		this.taskType = taskType;
	} 	
	/**
	 * 属性处理人所属部门/处理人所属部门的getter方法
	 */
	public String getHandlerDept() {
		return handlerDept;
	}
	/**
	 * 属性处理人所属部门/处理人所属部门的setter方法
	 */
	public void setHandlerDept(String handlerDept) {
		this.handlerDept = handlerDept;
	} 	
	/**
	 * 属性处理人编码/处理人编码的getter方法
	 */
	public String getHandlerCode() {
		return handlerCode;
	}
	/**
	 * 属性处理人编码/处理人编码的setter方法
	 */
	public void setHandlerCode(String handlerCode) {
		this.handlerCode = handlerCode;
	} 	
		
		
		
		
}