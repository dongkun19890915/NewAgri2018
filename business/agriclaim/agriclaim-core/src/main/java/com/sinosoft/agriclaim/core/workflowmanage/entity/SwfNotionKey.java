package com.sinosoft.agriclaim.core.workflowmanage.entity;

import com.sinosoft.framework.core.dao.BasePKImpl;
import javax.persistence.*;

/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-11-08 05:47:03.090 
 * 处理意见表主键操作对象
 */
public class SwfNotionKey extends BasePKImpl{
	private static final long serialVersionUID = 1L;
	public SwfNotionKey(){}
	public SwfNotionKey(String flowId,java.lang.Integer logNo,java.lang.Integer lineNo){
		this.flowId = flowId;
		this.logNo = logNo;
		this.lineNo = lineNo;
	}
	/** 属性工作流ID /工作流ID  */
	@Column(name = "flowId")
	private String flowId ;
	/** 属性日志序号/日志序号 */
	@Column(name = "logNo")
	private java.lang.Integer logNo ;
	/** 属性行号/行号 */
	@Column(name = "lineNo")
	private java.lang.Integer lineNo ;
	/**
	 * 属性工作流ID /工作流ID 的getter方法
	 */
	public String getFlowId() {
    		return flowId;
	}
	/**
	 * 属性工作流ID /工作流ID 的setter方法
	 */
	public void setFlowId(String flowId) {
		this.flowId = flowId;
	} 
	/**
	 * 属性日志序号/日志序号的getter方法
	 */
	public java.lang.Integer getLogNo() {
    		return logNo;
	}
	/**
	 * 属性日志序号/日志序号的setter方法
	 */
	public void setLogNo(java.lang.Integer logNo) {
		this.logNo = logNo;
	} 
	/**
	 * 属性行号/行号的getter方法
	 */
	public java.lang.Integer getLineNo() {
    		return lineNo;
	}
	/**
	 * 属性行号/行号的setter方法
	 */
	public void setLineNo(java.lang.Integer lineNo) {
		this.lineNo = lineNo;
	} 
}