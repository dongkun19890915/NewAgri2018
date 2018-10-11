package com.sinosoft.agriclaim.core.workflowmanage.entity;

import com.sinosoft.framework.core.dao.BaseEntityImpl;
import javax.persistence.*;
import java.util.Date;

/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-11-08 05:47:03.090 
 * 处理意见表实体操作对象
 */
@Entity
@Table(name = "SwfNotion")
@IdClass(SwfNotionKey.class)
public class SwfNotion extends BaseEntityImpl{

	private static final long serialVersionUID = 1L;
	/** 属性工作流ID /工作流ID  */
	@Id
	@Column(name = "flowId")
	private String flowId ;/** 属性日志序号/日志序号 */
	@Id
	@Column(name = "logNo")
	private java.lang.Integer logNo ;/** 属性行号/行号 */
	@Id
	@Column(name = "lineNo")
	private java.lang.Integer lineNo ;	



	/** 属性处理意见/处理意见 */
	@Column(name = "handleText")
	private String handleText ;
	/** 属性备用标志/备用标志 */
	@Column(name = "flag")
	private String flag ;
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
	/**
	 * 属性处理意见/处理意见的getter方法
	 */
	public String getHandleText() {
		return handleText;
	}
	/**
	 * 属性处理意见/处理意见的setter方法
	 */
	public void setHandleText(String handleText) {
		this.handleText = handleText;
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