package com.sinosoft.agriclaim.core.workflowmanage.entity;

import com.sinosoft.framework.core.dao.BasePKImpl;
import javax.persistence.*;

/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-11-08 05:47:03.090 
 * 工作流日志表主键操作对象
 */
public class SwfLogKey extends BasePKImpl{
	private static final long serialVersionUID = 1L;
	public SwfLogKey(){}
	public SwfLogKey(String flowId,java.lang.Integer logNo){
		this.flowId = flowId;
		this.logNo = logNo;
	}
	/** 属性流程编号/流程编号 */
	@Column(name = "flowId")
	private String flowId ;
	/** 属性序号/序号 */
	@Column(name = "logNo")
	private java.lang.Integer logNo ;
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
	 * 属性序号/序号的getter方法
	 */
	public java.lang.Integer getLogNo() {
    		return logNo;
	}
	/**
	 * 属性序号/序号的setter方法
	 */
	public void setLogNo(java.lang.Integer logNo) {
		this.logNo = logNo;
	} 
}