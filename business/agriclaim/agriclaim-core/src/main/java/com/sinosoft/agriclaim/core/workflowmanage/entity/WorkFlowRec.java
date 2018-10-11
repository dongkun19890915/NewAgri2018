package com.sinosoft.agriclaim.core.workflowmanage.entity;

import com.sinosoft.framework.core.dao.BaseEntityImpl;
import javax.persistence.*;
import java.util.Date;

/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-11-08 05:47:03.090 
 * 流程监控表实体操作对象
 */
@Entity
@Table(name = "WorkFlowRec")
@IdClass(WorkFlowRecKey.class)
public class WorkFlowRec extends BaseEntityImpl{

	private static final long serialVersionUID = 1L;
	/** 属性节点编码/节点编码 */
	@Id
	@Column(name = "nodeCode")
	private String nodeCode ;/** 属性业务号/业务号 */
	@Id
	@Column(name = "businessNo")
	private String businessNo ;/** 属性序号/序号 */
	@Id
	@Column(name = "serialNo")
	private java.lang.Integer serialNo ;	

	/** 属性当前节点名称/当前节点名称 */
	@Column(name = "nodeName")
	private String nodeName ;


	/** 属性业务类型/业务类型 */
	@Column(name = "certiType")
	private String certiType ;
	/** 属性保单号码/批单号码/保单号码/批单号码 */
	@Column(name = "certiNo")
	private String certiNo ;
	/** 属性调度操作员代码/调度操作员代码 */
	@Column(name = "operatorCode")
	private String operatorCode ;
	/** 属性操作人的代码/操作人的代码 */
	@Column(name = "handlerCode")
	private String handlerCode ;
	/** 属性操作状态/操作状态 */
	@Column(name = "operateStatus")
	private String operateStatus ;
	/** 属性提交时间/提交时间 */
	@Column(name = "commitTime")
	private java.util.Date commitTime ;
	/** 属性处理时间/处理时间 */
	@Column(name = "dealTime")
	private java.util.Date dealTime ;
	/** 属性设置时间/设置时间 */
	@Column(name = "settleHour")
	private java.lang.Integer settleHour ;
	/** 属性标志/标志 */
	@Column(name = "flag")
	private String flag ;
	/**
	 * 属性节点编码/节点编码的getter方法
	 */
	public String getNodeCode() {
		return nodeCode;
	}
	/**
	 * 属性节点编码/节点编码的setter方法
	 */
	public void setNodeCode(String nodeCode) {
		this.nodeCode = nodeCode;
	} 	
	/**
	 * 属性当前节点名称/当前节点名称的getter方法
	 */
	public String getNodeName() {
		return nodeName;
	}
	/**
	 * 属性当前节点名称/当前节点名称的setter方法
	 */
	public void setNodeName(String nodeName) {
		this.nodeName = nodeName;
	} 	
	/**
	 * 属性业务号/业务号的getter方法
	 */
	public String getBusinessNo() {
		return businessNo;
	}
	/**
	 * 属性业务号/业务号的setter方法
	 */
	public void setBusinessNo(String businessNo) {
		this.businessNo = businessNo;
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
	 * 属性操作人的代码/操作人的代码的getter方法
	 */
	public String getHandlerCode() {
		return handlerCode;
	}
	/**
	 * 属性操作人的代码/操作人的代码的setter方法
	 */
	public void setHandlerCode(String handlerCode) {
		this.handlerCode = handlerCode;
	} 	
	/**
	 * 属性操作状态/操作状态的getter方法
	 */
	public String getOperateStatus() {
		return operateStatus;
	}
	/**
	 * 属性操作状态/操作状态的setter方法
	 */
	public void setOperateStatus(String operateStatus) {
		this.operateStatus = operateStatus;
	} 	
	/**
	 * 属性提交时间/提交时间的getter方法
	 */
	public java.util.Date getCommitTime() {
		return commitTime;
	}
	/**
	 * 属性提交时间/提交时间的setter方法
	 */
	public void setCommitTime(java.util.Date commitTime) {
		this.commitTime = commitTime;
	} 	
	/**
	 * 属性处理时间/处理时间的getter方法
	 */
	public java.util.Date getDealTime() {
		return dealTime;
	}
	/**
	 * 属性处理时间/处理时间的setter方法
	 */
	public void setDealTime(java.util.Date dealTime) {
		this.dealTime = dealTime;
	} 	
	/**
	 * 属性设置时间/设置时间的getter方法
	 */
	public java.lang.Integer getSettleHour() {
		return settleHour;
	}
	/**
	 * 属性设置时间/设置时间的setter方法
	 */
	public void setSettleHour(java.lang.Integer settleHour) {
		this.settleHour = settleHour;
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
}