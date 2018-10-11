package com.sinosoft.agriclaim.api.schedulemanage.dto;

import com.sinosoft.framework.dto.BaseRequest;

import java.io.Serializable;
/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-11-08 05:45:58.930 
 * 调度任务/查勘任务主表Api操作对象
 */
public class PrpLScheduleMainWfDto extends BaseRequest implements Serializable{
	private static final long serialVersionUID = 1L;
	/** 属性调度ID/调度ID */
	private java.lang.Integer scheduleId ;		
	/** 属性报案号码/报案号码 */
	private String registNo ;		
	/** 属性已查勘次数/已查勘次数 */
	private java.lang.Integer surveyNo ;		
	/** 属性理赔处理机构/理赔处理机构 */
	private String claimcomCode ;		
	/** 属性险种代码/险种代码 */
	private String riskCode ;		
	/** 属性保单号/保单号 */
	private String policyNo ;		
	/** 属性调度操作员代码/调度操作员代码 */
	private String operatorCode ;		
	/** 属性计算机输单日期/计算机输单日期 */
	private java.util.Date inputDate ;		
	/** 属性小时/小时 */
	private java.lang.Integer inputHour ;		
	/** 属性调度区域/调度区域 */
	private java.lang.Integer scheduleArea ;		
	/** 属性允许多级调度/允许多级调度 */
	private String scheduleMoreFlag ;		
	/** 属性调度处理情况/调度处理情况 */
	private String scheduleFlag ;		
	/** 属性调度对象编码/调度对象编码 */
	private String scheduleObjectId ;		
	/** 属性调度对象名称/调度对象名称 */
	private String scheduleObjectName ;		
	/** 属性调度类型/调度类型 */
	private String scheduleType ;		
	/** 属性处理日期/处理日期 */
	private java.util.Date checkInputDate ;		
	/** 属性查勘录入操作员代码/查勘录入操作员代码 */
	private String checkOperatorCode ;		
	/** 属性查勘状态/查勘状态 */
	private String checkFlag ;		
	/** 属性处理信息/处理信息 */
	private String checkInfo ;		
	/** 属性备用状态/备用状态 */
	private String flag ;		
	/** 属性查勘地址/查勘地址 */
	private String checkSite ;		
	/** 属性下一个节点人的代码/下一个节点人的代码 */
	private String nextHandlerCode ;
	/** 属性下一个节点人的名称/下一个节点人的名称 */
	private String nextHandlerName ;		
	/** 属性下一个节点的类型/下一个节点的类型 */
	private String nextNodeNo ;		
	/** 属性输入分钟/输入分钟 */
	private java.lang.Integer inputMinute ;		
	/** 属性派工现状/派工现状 */
	private String scheduleStatus ;		
	/** 属性委员会项目标志/委员会项目标志 */
	private String commiItemFlag ;		
	/** 属性派工类型/派工类型 */
	private String scheduleWay ;		
	/** 属性调度时间/调度时间 */
	private String scheduleDate ;		
	/** 属性派工区域/派工区域 */
	private String dispatchArea ;		
	/** 属性派工区域名称/派工区域名称 */
	private String dispatchAreaName ;		
	/** 属性调度任务来源/调度任务来源 */
	private String trackType ;		
	/** 属性任务编码/任务编码 */
	private String taskId ;		
	/** 属性任务类型/任务类型 */
	private String taskType ;		
	/** 属性处理人所属部门/处理人所属部门 */
	private String handlerDept ;		
	/** 属性处理人编码/处理人编码 */
	private String handlerCode ;
	/** 属性联系人 */
	private String linkerName;
	/** 属性联系电话 */
	private String phoneNumber;
	/** 属性双代标志 */
	private String commiFlag;
	/** 属性操作人名称 */
	private String operatorName;
	/** 属性estiMateLoss */
	private double estimateLoss;
	/** 保存类型 */
	private String saveType;
	/** 报案文本 */
	private String registText;
	/** 状态 */
	private String status;
	/** 代理机构代码 */
	private String agentCode;
	/** 代理机构名称 */
	private String agentName;
	/** 立案机构名称 */
	private String claimcomName;
			
			
			
	
	

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
    public String getClaimcomName() {
        return claimcomName;
    }
    public void setClaimcomName(String claimcomName) {
        this.claimcomName = claimcomName;
    }	
    public String getAgentCode() {
        return agentCode;
    }
    public void setAgentCode(String agentCode) {
        this.agentCode = agentCode;
    }
    public String getAgentName() {
        return agentName;
    }
    public void setAgentName(String agentName) {
        this.agentName = agentName;
    }
    public String getStatus() {
        return status;
    }
    public void setStatus(String status) {
        this.status = status;
    }
    public String getRegistText() {
        return registText;
    }
    public void setRegistText(String registText) {
        this.registText = registText;
    }

	public double getEstimateLoss() {
		return estimateLoss;
	}

	public void setEstimateLoss(double estimateLoss) {
		this.estimateLoss = estimateLoss;
	}

	public String getSaveType() {
        return saveType;
    }
    public void setSaveType(String saveType) {
        this.saveType = saveType;
    }
    public String getOperatorName() {
        return operatorName;
    }
    public void setOperatorName(String operatorName) {
        this.operatorName = operatorName;
    }
    public String getCommiFlag() {
        return commiFlag;
    }
    public void setCommiFlag(String commiFlag) {
        this.commiFlag = commiFlag;
    }
    public String getPhoneNumber() {
        return phoneNumber;
    }
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
    public String getLinkerName() {
        return linkerName;
    }
    public void setLinkerName(String linkerName) {
        this.linkerName = linkerName;
    }	
		
		
		
}
