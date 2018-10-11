package com.sinosoft.agriclaim.core.workflowmanage.entity;

import com.sinosoft.framework.core.dao.BaseEntityImpl;
import javax.persistence.*;
import java.util.Date;

/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-11-08 05:47:03.090 
 * 工作流路径日志表实体操作对象
 */
@Entity
@Table(name = "SwfPathLog")
@IdClass(SwfPathLogKey.class)
public class SwfPathLog extends BaseEntityImpl{

	private static final long serialVersionUID = 1L;
	/** 属性流程编号/流程编号 */
	@Id
	@Column(name = "flowId")
	private String flowId ;/** 属性流程边号/流程边号 */
	@Id
	@Column(name = "pathNo")
	private java.lang.Integer pathNo ;	


	/** 属性模板号/模板号 */
	@Column(name = "modelNo")
	private java.lang.Integer modelNo ;
	/** 属性路径名称/路径名称 */
	@Column(name = "pathName")
	private String pathName ;
	/** 属性起始节点/起始节点 */
	@Column(name = "startNodeNo")
	private java.lang.Integer startNodeNo ;
	/** 属性起始节点名称/起始节点名称 */
	@Column(name = "startNodeName")
	private String startNodeName ;
	/** 属性终止节点/终止节点 */
	@Column(name = "endNodeNo")
	private java.lang.Integer endNodeNo ;
	/** 属性终止节点名称/终止节点名称 */
	@Column(name = "endNodeName")
	private String endNodeName ;
	/** 属性流入时间/流入时间 */
	@Column(name = "flowInTime")
	private java.util.Date flowInTime ;
	/** 属性标志位/标志位 */
	@Column(name = "flag")
	private String flag ;
	/**
	 * 属性流程编号/流程编号的getter方法
	 */
	public String getFlowId() {
		return flowId;
	}
	/**
	 * 属性流程编号/流程编号的setter方法
	 */
	public void setFlowId(String flowId) {
		this.flowId = flowId;
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
	 * 属性模板号/模板号的getter方法
	 */
	public java.lang.Integer getModelNo() {
		return modelNo;
	}
	/**
	 * 属性模板号/模板号的setter方法
	 */
	public void setModelNo(java.lang.Integer modelNo) {
		this.modelNo = modelNo;
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
	 * 属性流入时间/流入时间的getter方法
	 */
	public java.util.Date getFlowInTime() {
		return flowInTime;
	}
	/**
	 * 属性流入时间/流入时间的setter方法
	 */
	public void setFlowInTime(java.util.Date flowInTime) {
		this.flowInTime = flowInTime;
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