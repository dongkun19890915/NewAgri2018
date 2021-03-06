package com.sinosoft.agriclaim.api.workflowmanage.dto;

import java.io.Serializable;

import com.sinosoft.framework.dto.BaseRequest;
/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-11-08 05:47:03.090 
 * 工作流路径定义表Api操作对象
 */
public class SwfPathDto extends BaseRequest implements Serializable{
	private static final long serialVersionUID = 1L;
	/** 属性模板编号/模板编号 */
	private java.lang.Integer modelNo ;		
	/** 属性模板名称/模板名称 */
	private String modelName ;		
	/** 属性起始节点/起始节点 */
	private java.lang.Integer startNodeNo ;		
	/** 属性起始节点名称/起始节点名称 */
	private String startNodeName ;		
	/** 属性终止节点/终止节点 */
	private java.lang.Integer endNodeNo ;		
	/** 属性终止节点名称/终止节点名称 */
	private String endNodeName ;		
	/** 属性流程边号/流程边号 */
	private java.lang.Integer pathNo ;		
	/** 属性路径名称/路径名称 */
	private String pathName ;		
	/** 属性优先级别/优先级别 */
	private java.lang.Integer priority ;		
	/** 属性是否缺省值/是否缺省值 */
	private String defaultFlag ;		
	/** 属性是否存在流转条件/是否存在流转条件 */
	private String conditionStatus ;		
	/** 属性正向流转所调用的业务处理服务名/正向流转所调用的业务处理服务名 */
	private String forwardServices ;		
	/** 属性逆向流转所调用的业务处理服务名/逆向流转所调用的业务处理服务名 */
	private String backwardServices ;		
	/** 属性备用标志/备用标志 */
	private String flag ;		
	/** 属性工作流状态/工作流状态 */
	private String flowStatus ;
	private int nextNodeNo;
	private String[] nextNodeNoList;
	
	
	public String[] getNextNodeNoList() {
		return nextNodeNoList;
	}
	public void setNextNodeNoList(String[] nextNodeNoList) {
		this.nextNodeNoList = nextNodeNoList;
	}
	public int getNextNodeNo() {
		return nextNodeNo;
	}
	public void setNextNodeNo(int nextNodeNo) {
		this.nextNodeNo = nextNodeNo;
	}
	public java.lang.Integer getModelNo() {
		return modelNo;
	}
	/**
	 * 属性模板编号/模板编号的setter方法
	 */
	public void setModelNo(java.lang.Integer modelNo) {
		this.modelNo = modelNo;
	}	
	/**
	 * 属性模板名称/模板名称的getter方法
	 */
	public String getModelName() {
		return modelName;
	}
	/**
	 * 属性模板名称/模板名称的setter方法
	 */
	public void setModelName(String modelName) {
		this.modelName = modelName;
	}	
	/**
	 * 属性起始节点/起始节点的getter方法
	 */
	public java.lang.Integer getStartNodeNo() {
		return startNodeNo;
	}
	/**
	 * 属性起始节点/起始节点的setter方法
	 */
	public void setStartNodeNo(java.lang.Integer startNodeNo) {
		this.startNodeNo = startNodeNo;
	}	
	/**
	 * 属性起始节点名称/起始节点名称的getter方法
	 */
	public String getStartNodeName() {
		return startNodeName;
	}
	/**
	 * 属性起始节点名称/起始节点名称的setter方法
	 */
	public void setStartNodeName(String startNodeName) {
		this.startNodeName = startNodeName;
	}	
	/**
	 * 属性终止节点/终止节点的getter方法
	 */
	public java.lang.Integer getEndNodeNo() {
		return endNodeNo;
	}
	/**
	 * 属性终止节点/终止节点的setter方法
	 */
	public void setEndNodeNo(java.lang.Integer endNodeNo) {
		this.endNodeNo = endNodeNo;
	}	
	/**
	 * 属性终止节点名称/终止节点名称的getter方法
	 */
	public String getEndNodeName() {
		return endNodeName;
	}
	/**
	 * 属性终止节点名称/终止节点名称的setter方法
	 */
	public void setEndNodeName(String endNodeName) {
		this.endNodeName = endNodeName;
	}	
	/**
	 * 属性流程边号/流程边号的getter方法
	 */
	public java.lang.Integer getPathNo() {
		return pathNo;
	}
	/**
	 * 属性流程边号/流程边号的setter方法
	 */
	public void setPathNo(java.lang.Integer pathNo) {
		this.pathNo = pathNo;
	}	
	/**
	 * 属性路径名称/路径名称的getter方法
	 */
	public String getPathName() {
		return pathName;
	}
	/**
	 * 属性路径名称/路径名称的setter方法
	 */
	public void setPathName(String pathName) {
		this.pathName = pathName;
	}	
	/**
	 * 属性优先级别/优先级别的getter方法
	 */
	public java.lang.Integer getPriority() {
		return priority;
	}
	/**
	 * 属性优先级别/优先级别的setter方法
	 */
	public void setPriority(java.lang.Integer priority) {
		this.priority = priority;
	}	
	/**
	 * 属性是否缺省值/是否缺省值的getter方法
	 */
	public String getDefaultFlag() {
		return defaultFlag;
	}
	/**
	 * 属性是否缺省值/是否缺省值的setter方法
	 */
	public void setDefaultFlag(String defaultFlag) {
		this.defaultFlag = defaultFlag;
	}	
	/**
	 * 属性是否存在流转条件/是否存在流转条件的getter方法
	 */
	public String getConditionStatus() {
		return conditionStatus;
	}
	/**
	 * 属性是否存在流转条件/是否存在流转条件的setter方法
	 */
	public void setConditionStatus(String conditionStatus) {
		this.conditionStatus = conditionStatus;
	}	
	/**
	 * 属性正向流转所调用的业务处理服务名/正向流转所调用的业务处理服务名的getter方法
	 */
	public String getForwardServices() {
		return forwardServices;
	}
	/**
	 * 属性正向流转所调用的业务处理服务名/正向流转所调用的业务处理服务名的setter方法
	 */
	public void setForwardServices(String forwardServices) {
		this.forwardServices = forwardServices;
	}	
	/**
	 * 属性逆向流转所调用的业务处理服务名/逆向流转所调用的业务处理服务名的getter方法
	 */
	public String getBackwardServices() {
		return backwardServices;
	}
	/**
	 * 属性逆向流转所调用的业务处理服务名/逆向流转所调用的业务处理服务名的setter方法
	 */
	public void setBackwardServices(String backwardServices) {
		this.backwardServices = backwardServices;
	}	
	/**
	 * 属性备用标志/备用标志的getter方法
	 */
	public String getFlag() {
		return flag;
	}
	/**
	 * 属性备用标志/备用标志的setter方法
	 */
	public void setFlag(String flag) {
		this.flag = flag;
	}	
	/**
	 * 属性节点状态/节点状态的getter方法
	 */
	public String getFlowStatus() {
		return flowStatus;
	}
	/**
	 * 属性节点状态/节点状态的setter方法
	 */
	public void setFlowStatus(String flowStatus) {
		this.flowStatus = flowStatus;
	}	
		
		
		
		
}
