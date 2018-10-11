package com.sinosoft.agriclaim.core.workflowmanage.entity;

import com.sinosoft.framework.core.dao.BasePKImpl;
import javax.persistence.*;

/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-11-08 05:47:03.090 
 * 工作流路径日志表主键操作对象
 */
public class SwfPathLogKey extends BasePKImpl{
	private static final long serialVersionUID = 1L;
	public SwfPathLogKey(){}
	public SwfPathLogKey(String flowId,java.lang.Integer pathNo){
		this.flowId = flowId;
		this.pathNo = pathNo;
	}
	/** 属性流程编号/流程编号 */
	@Column(name = "flowId")
	private String flowId ;
	/** 属性流程边号/流程边号 */
	@Column(name = "pathNo")
	private java.lang.Integer pathNo ;
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
}