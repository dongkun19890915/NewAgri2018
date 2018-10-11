package com.sinosoft.agriprpall.api.undwrtsubmit.dto;

import java.io.Serializable;
import java.util.Date;

import com.sinosoft.framework.dto.BaseRequest;
/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-10-16 04:00:52.059 
 * 工作流主表Api操作对象
 */
public class WfFlowMainDto extends BaseRequest implements Serializable{
	private static final long serialVersionUID = 1L;
	/** 属性流程编号/流程编号 */
	private String flowId ;		
	/** 属性流程名称/流程名称 */
	private String flowName ;		
	/** 属性该流程的状态/该流程的状态 */
	private String flowStatus ;		
	/** 属性创建该流程的时间/创建该流程的时间 */
	private String creatDate ;		
	/** 属性关闭该流程的时间/关闭该流程的时间 */
	private String closeDate ;		
	/** 属性从哪个模板继承来的/从哪个模板继承来的 */
	private Integer modelNo ;
	/** 属性标志/标志 */
	private String flag ;
	/** 属性createDBy/createDBy */
	private String createDBy ;
	/** 属性createDTime/createDTime */
	private java.util.Date createDTime ;
	/** 属性updateDBy/updateDBy */
	private String updateDBy ;
	/** 属性updateDTime/updateDTime */
	private java.util.Date updateDTime ;

	public String getCreateDBy() {
		return createDBy;
	}

	public void setCreateDBy(String createDBy) {
		this.createDBy = createDBy;
	}

	public Date getCreateDTime() {
		return createDTime;
	}

	public void setCreateDTime(Date createDTime) {
		this.createDTime = createDTime;
	}

	public String getUpdateDBy() {
		return updateDBy;
	}

	public void setUpdateDBy(String updateDBy) {
		this.updateDBy = updateDBy;
	}

	public Date getUpdateDTime() {
		return updateDTime;
	}

	public void setUpdateDTime(Date updateDTime) {
		this.updateDTime = updateDTime;
	}

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
	 * 属性该流程的状态/该流程的状态的getter方法
	 */
	public String getFlowStatus() {
		return flowStatus;
	}
	/**
	 * 属性该流程的状态/该流程的状态的setter方法
	 */
	public void setFlowStatus(String flowStatus) {
		this.flowStatus = flowStatus;
	}	
	/**
	 * 属性创建该流程的时间/创建该流程的时间的getter方法
	 */
	public String getCreatDate() {
		return creatDate;
	}
	/**
	 * 属性创建该流程的时间/创建该流程的时间的setter方法
	 */
	public void setCreatDate(String creatDate) {
		this.creatDate = creatDate;
	}	
	/**
	 * 属性关闭该流程的时间/关闭该流程的时间的getter方法
	 */
	public String getCloseDate() {
		return closeDate;
	}
	/**
	 * 属性关闭该流程的时间/关闭该流程的时间的setter方法
	 */
	public void setCloseDate(String closeDate) {
		this.closeDate = closeDate;
	}	
	/**
	 * 属性从哪个模板继承来的/从哪个模板继承来的的getter方法
	 */
	public Integer getModelNo() {
		return modelNo;
	}
	/**
	 * 属性从哪个模板继承来的/从哪个模板继承来的的setter方法
	 */
	public void setModelNo(Integer modelNo) {
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
}
