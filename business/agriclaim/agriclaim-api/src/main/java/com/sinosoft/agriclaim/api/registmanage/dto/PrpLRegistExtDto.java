package com.sinosoft.agriclaim.api.registmanage.dto;

import com.sinosoft.framework.dto.BaseRequest;

import java.io.Serializable;
import java.util.List;
/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-11-08 05:45:22.527 
 * 报案信息补充说明Api操作对象
 */
public class PrpLRegistExtDto extends BaseRequest implements Serializable{
	private static final long serialVersionUID = 1L;
	/** 属性报案号码/报案号码 */
	private String registNo ;		
	/** 属性险种代码/险种代码 */
	private String riskCode ;		
	/** 属性序号/序号 */
	private Integer serialNo ;
	/** 属性时间/时间 */
	private String inputDate ;		
	/** 属性小时/小时 */
	private String inputHour ;		
	/** 属性操作员代码/操作员代码 */
	private String operatorCode ;		
	/** 属性内容/内容 */
	private String context ;		
	/** 属性业务归属机构代码/业务归属机构代码 */
	private String comCode ;		
	/** 属性处理节点/处理节点 */
	private String nodeType ;		
	/** 属性处理意见代码/处理意见代码 */
	private String notionCode ;		
	/** 属性处理意见名字/处理意见名字 */
	private String notionName ;		
	/** 属性联系电话/联系电话 */
	private String linkPhone ;		
	/** 属性查看状态/查看状态 */
	private String checkStatus ;		
	/** 属性花费时间/花费时间 */
	private String costTime ;		
	/** 属性任务号/任务号 */
	private String taskId ;		
	/** 属性任务序号/任务序号 */
	private Integer checkserialNo ;
	/** 属性标识/标识 */
	private String flag ;		
	/** 属性任务状态/任务状态 */
	private String taskType ;		
	/** 属性退回标志/退回标志 */
	private String turnFlag ;		
	/** 属性受理人代码/受理人代码 */
	private String receiveUserCode ;		
	/** 属性试算结果/试算结果 */
	private String compext ;		
	/** 属性险别赔偿金额/险别赔偿金额 */
	private String kindSum ;		
	/** 属性报案附加信息对象集合 */
	private List<PrpLRegistExtDto> prpLRegistExtDtoList;
	/** 属性操作员名称/操作员名称 */
	private String operatorName;
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
	public Integer getSerialNo() {
		return serialNo;
	}
	/**
	 * 属性序号/序号的setter方法
	 */
	public void setSerialNo(Integer serialNo) {
		this.serialNo = serialNo;
	}	
	/**
	 * 属性时间/时间的getter方法
	 */
	public String getInputDate() {
		return inputDate;
	}
	/**
	 * 属性时间/时间的setter方法
	 */
	public void setInputDate(String inputDate) {
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
	public Integer getCheckserialNo() {
		return checkserialNo;
	}
	/**
	 * 属性任务序号/任务序号的setter方法
	 */
	public void setCheckserialNo(Integer checkserialNo) {
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
	public List<PrpLRegistExtDto> getPrpLRegistExtDtoList() {
		return prpLRegistExtDtoList;
	}
	public void setPrpLRegistExtDtoList(List<PrpLRegistExtDto> prpLRegistExtDtoList) {
		this.prpLRegistExtDtoList = prpLRegistExtDtoList;
	}
    public String getOperatorName() {
        return operatorName;
    }
    public void setOperatorName(String operatorName) {
        this.operatorName = operatorName;
    }	
	
}
