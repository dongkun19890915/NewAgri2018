package com.sinosoft.agriclaim.core.workflowmanage.entity;

import com.sinosoft.framework.core.dao.BaseEntityImpl;
import javax.persistence.*;
import java.util.Date;

/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-11-08 05:47:03.090 
 * 流程主表实体操作对象
 */
@Entity
@Table(name = "SwfFlowMain")
@IdClass(SwfFlowMainKey.class)
public class SwfFlowMain extends BaseEntityImpl{

	private static final long serialVersionUID = 1L;
	/** 属性流程编号/流程编号 */
	@Id
	@Column(name = "flowId")
	private String flowId ;	

	/** 属性流程名称/流程名称 */
	@Column(name = "flowName")
	private String flowName ;
	/** 属性该流程的状态 0 关闭，1未关闭/该流程的状态 0 关闭，1未关闭 */
	@Column(name = "flowStatus")
	private String flowStatus ;
	/** 属性保单号码/保单号码 */
	@Column(name = "policyNo")
	private String policyNo ;
	/** 属性创建该流程的时间/创建该流程的时间 */
	@Column(name = "creatDate")
	private java.util.Date creatDate ;
	/** 属性关闭该流程的时间/关闭该流程的时间 */
	@Column(name = "closeDate")
	private java.util.Date closeDate ;
	/** 属性从哪个模板继承来的/从哪个模板继承来的 */
	@Column(name = "modelNo")
	private java.lang.Integer modelNo ;
	/** 属性标志/标志 */
	@Column(name = "flag")
	private String flag ;
	/** 属性转储标志 /0 swfLog 1 转储表/转储标志 /0 swfLog 1 转储表 */
	@Column(name = "storeFlag")
	private String storeFlag ;
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
	 * 属性流程名称/流程名称的getter方法
	 */
	public String getFlowName() {
		return flowName;
	}
	/**
	 * 属性流程名称/流程名称的setter方法
	 */
	public void setFlowName(String flowName) {
		this.flowName = flowName;
	} 	
	/**
	 * 属性该流程的状态 0 关闭，1未关闭/该流程的状态 0 关闭，1未关闭的getter方法
	 */
	public String getFlowStatus() {
		return flowStatus;
	}
	/**
	 * 属性该流程的状态 0 关闭，1未关闭/该流程的状态 0 关闭，1未关闭的setter方法
	 */
	public void setFlowStatus(String flowStatus) {
		this.flowStatus = flowStatus;
	} 	
	/**
	 * 属性保单号码/保单号码的getter方法
	 */
	public String getPolicyNo() {
		return policyNo;
	}
	/**
	 * 属性保单号码/保单号码的setter方法
	 */
	public void setPolicyNo(String policyNo) {
		this.policyNo = policyNo;
	} 	
	/**
	 * 属性创建该流程的时间/创建该流程的时间的getter方法
	 */
	public java.util.Date getCreatDate() {
		return creatDate;
	}
	/**
	 * 属性创建该流程的时间/创建该流程的时间的setter方法
	 */
	public void setCreatDate(java.util.Date creatDate) {
		this.creatDate = creatDate;
	} 	
	/**
	 * 属性关闭该流程的时间/关闭该流程的时间的getter方法
	 */
	public java.util.Date getCloseDate() {
		return closeDate;
	}
	/**
	 * 属性关闭该流程的时间/关闭该流程的时间的setter方法
	 */
	public void setCloseDate(java.util.Date closeDate) {
		this.closeDate = closeDate;
	} 	
	/**
	 * 属性从哪个模板继承来的/从哪个模板继承来的的getter方法
	 */
	public java.lang.Integer getModelNo() {
		return modelNo;
	}
	/**
	 * 属性从哪个模板继承来的/从哪个模板继承来的的setter方法
	 */
	public void setModelNo(java.lang.Integer modelNo) {
		this.modelNo = modelNo;
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
	 * 属性转储标志 /0 swfLog 1 转储表/转储标志 /0 swfLog 1 转储表的getter方法
	 */
	public String getStoreFlag() {
		return storeFlag;
	}
	/**
	 * 属性转储标志 /0 swfLog 1 转储表/转储标志 /0 swfLog 1 转储表的setter方法
	 */
	public void setStoreFlag(String storeFlag) {
		this.storeFlag = storeFlag;
	} 	
}