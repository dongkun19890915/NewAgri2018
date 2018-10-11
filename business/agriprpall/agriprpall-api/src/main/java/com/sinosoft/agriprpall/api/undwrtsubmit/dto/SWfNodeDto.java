package com.sinosoft.agriprpall.api.undwrtsubmit.dto;

import java.io.Serializable;
import java.util.Date;

import com.sinosoft.framework.dto.BaseRequest;
/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-10-17 01:16:19.335 
 * 工作流节点定义表Api操作对象
 */
public class SWfNodeDto extends BaseRequest implements Serializable{
	private static final long serialVersionUID = 1L;
	/** 属性模板编号/模板编号 */
	private Integer modelNo ;
	/** 属性模板名称/模板名称 */
	private String modelName ;		
	/** 属性节点编号/节点编号 */
	private Integer nodeNo ;
	/** 属性节点名称/节点名称 */
	private String nodeName ;		
	/** 属性节点类型/节点类型 */
	private String nodeType ;		
	/** 属性处理时限/处理时限 */
	private Integer timeLimit ;
	/** 属性结束标志/结束标志 */
	private String endFlag ;		
	/** 属性处理要求/处理要求 */
	private String criteriOn ;		
	/** 属性任务编号/任务编号 */
	private Integer taskNo ;
	/** 属性任务类型/任务类型 */
	private String taskType ;		
	/** 属性办理部门/办理部门 */
	private String unitCode ;		
	/** 属性部门名称/部门名称 */
	private String unitName ;		
	/** 属性办理人员编码/办理人员编码 */
	private String handlerCode ;		
	/** 属性办理人员名称/办理人员名称 */
	private String handlerName ;		
	/** 属性节点X坐标/节点X坐标 */
	private Integer posx ;
	/** 属性节点Y坐标/节点Y坐标 */
	private Integer posy ;
	/** 属性备用标志/备用标志 */
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
	 * 属性模板编号/模板编号的getter方法
	 */
	public Integer getModelNo() {
		return modelNo;
	}
	/**
	 * 属性模板编号/模板编号的setter方法
	 */
	public void setModelNo(Integer modelNo) {
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
	 * 属性节点编号/节点编号的getter方法
	 */
	public Integer getNodeNo() {
		return nodeNo;
	}
	/**
	 * 属性节点编号/节点编号的setter方法
	 */
	public void setNodeNo(Integer nodeNo) {
		this.nodeNo = nodeNo;
	}	
	/**
	 * 属性节点名称/节点名称的getter方法
	 */
	public String getNodeName() {
		return nodeName;
	}
	/**
	 * 属性节点名称/节点名称的setter方法
	 */
	public void setNodeName(String nodeName) {
		this.nodeName = nodeName;
	}	
	/**
	 * 属性节点类型/节点类型的getter方法
	 */
	public String getNodeType() {
		return nodeType;
	}
	/**
	 * 属性节点类型/节点类型的setter方法
	 */
	public void setNodeType(String nodeType) {
		this.nodeType = nodeType;
	}	
	/**
	 * 属性处理时限/处理时限的getter方法
	 */
	public Integer getTimeLimit() {
		return timeLimit;
	}
	/**
	 * 属性处理时限/处理时限的setter方法
	 */
	public void setTimeLimit(Integer timeLimit) {
		this.timeLimit = timeLimit;
	}	
	/**
	 * 属性结束标志/结束标志的getter方法
	 */
	public String getEndFlag() {
		return endFlag;
	}
	/**
	 * 属性结束标志/结束标志的setter方法
	 */
	public void setEndFlag(String endFlag) {
		this.endFlag = endFlag;
	}	
	/**
	 * 属性处理要求/处理要求的getter方法
	 */
	public String getCriteriOn() {
		return criteriOn;
	}
	/**
	 * 属性处理要求/处理要求的setter方法
	 */
	public void setCriteriOn(String criteriOn) {
		this.criteriOn = criteriOn;
	}	
	/**
	 * 属性任务编号/任务编号的getter方法
	 */
	public Integer getTaskNo() {
		return taskNo;
	}
	/**
	 * 属性任务编号/任务编号的setter方法
	 */
	public void setTaskNo(Integer taskNo) {
		this.taskNo = taskNo;
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
	 * 属性办理部门/办理部门的getter方法
	 */
	public String getUnitCode() {
		return unitCode;
	}
	/**
	 * 属性办理部门/办理部门的setter方法
	 */
	public void setUnitCode(String unitCode) {
		this.unitCode = unitCode;
	}	
	/**
	 * 属性部门名称/部门名称的getter方法
	 */
	public String getUnitName() {
		return unitName;
	}
	/**
	 * 属性部门名称/部门名称的setter方法
	 */
	public void setUnitName(String unitName) {
		this.unitName = unitName;
	}	
	/**
	 * 属性办理人员编码/办理人员编码的getter方法
	 */
	public String getHandlerCode() {
		return handlerCode;
	}
	/**
	 * 属性办理人员编码/办理人员编码的setter方法
	 */
	public void setHandlerCode(String handlerCode) {
		this.handlerCode = handlerCode;
	}	
	/**
	 * 属性办理人员名称/办理人员名称的getter方法
	 */
	public String getHandlerName() {
		return handlerName;
	}
	/**
	 * 属性办理人员名称/办理人员名称的setter方法
	 */
	public void setHandlerName(String handlerName) {
		this.handlerName = handlerName;
	}	
	/**
	 * 属性节点X坐标/节点X坐标的getter方法
	 */
	public Integer getPosx() {
		return posx;
	}
	/**
	 * 属性节点X坐标/节点X坐标的setter方法
	 */
	public void setPosx(Integer posx) {
		this.posx = posx;
	}	
	/**
	 * 属性节点Y坐标/节点Y坐标的getter方法
	 */
	public Integer getPosy() {
		return posy;
	}
	/**
	 * 属性节点Y坐标/节点Y坐标的setter方法
	 */
	public void setPosy(Integer posy) {
		this.posy = posy;
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
		
		
		
		
}
