package com.sinosoft.agriclaim.core.registmanage.entity;

import com.sinosoft.framework.core.dao.BaseEntityImpl;
import javax.persistence.*;
import java.util.Date;

/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-11-08 05:45:22.527 
 * 报案信息补充说明实体操作对象
 */
@Entity
@Table(name = "PrpLRegistExt")
@IdClass(PrpLRegistExtKey.class)
public class PrpLRegistExt extends BaseEntityImpl{

	private static final long serialVersionUID = 1L;
	/** 属性报案号码/报案号码 */
	@Id
	@Column(name = "registNo")
	private String registNo ;/** 属性序号/序号 */
	@Id
	@Column(name = "serialNo")
	private java.lang.Integer serialNo ;/** 属性处理节点/处理节点 */
	@Id
	@Column(name = "nodeType")
	private String nodeType ;	

	/** 属性险种代码/险种代码 */
	@Column(name = "riskCode")
	private String riskCode ;

	/** 属性时间/时间 */
	@Column(name = "inputDate")
	private java.util.Date inputDate ;
	/** 属性小时/小时 */
	@Column(name = "inputHour")
	private String inputHour ;
	/** 属性操作员代码/操作员代码 */
	@Column(name = "operatorCode")
	private String operatorCode ;
	/** 属性内容/内容 */
	@Column(name = "context")
	private String context ;
	/** 属性业务归属机构代码/业务归属机构代码 */
	@Column(name = "comCode")
	private String comCode ;

	/** 属性处理意见代码/处理意见代码 */
	@Column(name = "notionCode")
	private String notionCode ;
	/** 属性处理意见名字/处理意见名字 */
	@Column(name = "notionName")
	private String notionName ;
	/** 属性联系电话/联系电话 */
	@Column(name = "linkPhone")
	private String linkPhone ;
	/** 属性查看状态/查看状态 */
	@Column(name = "checkStatus")
	private String checkStatus ;
	/** 属性花费时间/花费时间 */
	@Column(name = "costTime")
	private String costTime ;
	/** 属性任务号/任务号 */
	@Column(name = "taskId")
	private String taskId ;
	/** 属性任务序号/任务序号 */
	@Column(name = "checkserialNo")
	private java.lang.Integer checkserialNo ;
	/** 属性标识/标识 */
	@Column(name = "flag")
	private String flag ;
	/** 属性任务状态/任务状态 */
	@Column(name = "taskType")
	private String taskType ;
	/** 属性退回标志/退回标志 */
	@Column(name = "turnFlag")
	private String turnFlag ;
	/** 属性受理人代码/受理人代码 */
	@Column(name = "receiveUserCode")
	private String receiveUserCode ;
	/** 属性试算结果/试算结果 */
	@Column(name = "compext")
	private String compext ;
	/** 属性险别赔偿金额/险别赔偿金额 */
	@Column(name = "kindSum")
	private String kindSum ;
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
	 * 属性序号/序号的getter方法
	 */
	public java.lang.Integer getSerialNo() {
		return serialNo;
	}
	/**
	 * 属性序号/序号的setter方法
	 */
	public void setSerialNo(java.lang.Integer serialNo) {
		this.serialNo = serialNo;
	} 	
	/**
	 * 属性时间/时间的getter方法
	 */
	public java.util.Date getInputDate() {
		return inputDate;
	}
	/**
	 * 属性时间/时间的setter方法
	 */
	public void setInputDate(java.util.Date inputDate) {
		this.inputDate = inputDate;
	} 	
	/**
	 * 属性小时/小时的getter方法
	 */
	public String getInputHour() {
		return inputHour;
	}
	/**
	 * 属性小时/小时的setter方法
	 */
	public void setInputHour(String inputHour) {
		this.inputHour = inputHour;
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
	 * 属性内容/内容的getter方法
	 */
	public String getContext() {
		return context;
	}
	/**
	 * 属性内容/内容的setter方法
	 */
	public void setContext(String context) {
		this.context = context;
	} 	
	/**
	 * 属性业务归属机构代码/业务归属机构代码的getter方法
	 */
	public String getComCode() {
		return comCode;
	}
	/**
	 * 属性业务归属机构代码/业务归属机构代码的setter方法
	 */
	public void setComCode(String comCode) {
		this.comCode = comCode;
	} 	
	/**
	 * 属性处理节点/处理节点的getter方法
	 */
	public String getNodeType() {
		return nodeType;
	}
	/**
	 * 属性处理节点/处理节点的setter方法
	 */
	public void setNodeType(String nodeType) {
		this.nodeType = nodeType;
	} 	
	/**
	 * 属性处理意见代码/处理意见代码的getter方法
	 */
	public String getNotionCode() {
		return notionCode;
	}
	/**
	 * 属性处理意见代码/处理意见代码的setter方法
	 */
	public void setNotionCode(String notionCode) {
		this.notionCode = notionCode;
	} 	
	/**
	 * 属性处理意见名字/处理意见名字的getter方法
	 */
	public String getNotionName() {
		return notionName;
	}
	/**
	 * 属性处理意见名字/处理意见名字的setter方法
	 */
	public void setNotionName(String notionName) {
		this.notionName = notionName;
	} 	
	/**
	 * 属性联系电话/联系电话的getter方法
	 */
	public String getLinkPhone() {
		return linkPhone;
	}
	/**
	 * 属性联系电话/联系电话的setter方法
	 */
	public void setLinkPhone(String linkPhone) {
		this.linkPhone = linkPhone;
	} 	
	/**
	 * 属性查看状态/查看状态的getter方法
	 */
	public String getCheckStatus() {
		return checkStatus;
	}
	/**
	 * 属性查看状态/查看状态的setter方法
	 */
	public void setCheckStatus(String checkStatus) {
		this.checkStatus = checkStatus;
	} 	
	/**
	 * 属性花费时间/花费时间的getter方法
	 */
	public String getCostTime() {
		return costTime;
	}
	/**
	 * 属性花费时间/花费时间的setter方法
	 */
	public void setCostTime(String costTime) {
		this.costTime = costTime;
	} 	
	/**
	 * 属性任务号/任务号的getter方法
	 */
	public String getTaskId() {
		return taskId;
	}
	/**
	 * 属性任务号/任务号的setter方法
	 */
	public void setTaskId(String taskId) {
		this.taskId = taskId;
	} 	
	/**
	 * 属性任务序号/任务序号的getter方法
	 */
	public java.lang.Integer getCheckserialNo() {
		return checkserialNo;
	}
	/**
	 * 属性任务序号/任务序号的setter方法
	 */
	public void setCheckserialNo(java.lang.Integer checkserialNo) {
		this.checkserialNo = checkserialNo;
	} 	
	/**
	 * 属性标识/标识的getter方法
	 */
	public String getFlag() {
		return flag;
	}
	/**
	 * 属性标识/标识的setter方法
	 */
	public void setFlag(String flag) {
		this.flag = flag;
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
	 * 属性退回标志/退回标志的getter方法
	 */
	public String getTurnFlag() {
		return turnFlag;
	}
	/**
	 * 属性退回标志/退回标志的setter方法
	 */
	public void setTurnFlag(String turnFlag) {
		this.turnFlag = turnFlag;
	} 	
	/**
	 * 属性受理人代码/受理人代码的getter方法
	 */
	public String getReceiveUserCode() {
		return receiveUserCode;
	}
	/**
	 * 属性受理人代码/受理人代码的setter方法
	 */
	public void setReceiveUserCode(String receiveUserCode) {
		this.receiveUserCode = receiveUserCode;
	} 	
	/**
	 * 属性试算结果/试算结果的getter方法
	 */
	public String getCompext() {
		return compext;
	}
	/**
	 * 属性试算结果/试算结果的setter方法
	 */
	public void setCompext(String compext) {
		this.compext = compext;
	} 	
	/**
	 * 属性险别赔偿金额/险别赔偿金额的getter方法
	 */
	public String getKindSum() {
		return kindSum;
	}
	/**
	 * 属性险别赔偿金额/险别赔偿金额的setter方法
	 */
	public void setKindSum(String kindSum) {
		this.kindSum = kindSum;
	} 	
}