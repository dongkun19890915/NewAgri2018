package com.sinosoft.agriclaim.core.workflowmanage.entity;

import com.sinosoft.framework.core.dao.BasePKImpl;
import javax.persistence.*;

/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-11-08 05:47:03.090 
 * 流程监控表主键操作对象
 */
public class WorkFlowRecKey extends BasePKImpl{
	private static final long serialVersionUID = 1L;
	public WorkFlowRecKey(){}
	public WorkFlowRecKey(String nodeCode,String businessNo,java.lang.Integer serialNo){
		this.nodeCode = nodeCode;
		this.businessNo = businessNo;
		this.serialNo = serialNo;
	}
	/** 属性节点编码/节点编码 */
	@Column(name = "nodeCode")
	private String nodeCode ;
	/** 属性业务号/业务号 */
	@Column(name = "businessNo")
	private String businessNo ;
	/** 属性序号/序号 */
	@Column(name = "serialNo")
	private java.lang.Integer serialNo ;
	/**
	 * 属性节点编码/节点编码的getter方法
	 */
	public String getNodeCode() {
    		return nodeCode;
	}
	/**
	 * 属性节点编码/节点编码的setter方法
	 */
	public void setNodeCode(String nodeCode) {
		this.nodeCode = nodeCode;
	} 
	/**
	 * 属性业务号/业务号的getter方法
	 */
	public String getBusinessNo() {
    		return businessNo;
	}
	/**
	 * 属性业务号/业务号的setter方法
	 */
	public void setBusinessNo(String businessNo) {
		this.businessNo = businessNo;
	} 
	/**
	 * 属性序号/序号的getter方法
	 */
	public java.lang.Integer getSerialNo() {
    		return serialNo;
	}
	/**
	 * 属性序号/序号的setter方法
	 */
	public void setSerialNo(java.lang.Integer serialNo) {
		this.serialNo = serialNo;
	} 
}