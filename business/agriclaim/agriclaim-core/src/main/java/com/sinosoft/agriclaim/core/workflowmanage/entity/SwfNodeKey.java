package com.sinosoft.agriclaim.core.workflowmanage.entity;

import com.sinosoft.framework.core.dao.BasePKImpl;
import javax.persistence.*;

/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-11-08 05:47:03.090 
 * 工作流节点定义表主键操作对象
 */
public class SwfNodeKey extends BasePKImpl{
	private static final long serialVersionUID = 1L;
	public SwfNodeKey(){}
	public SwfNodeKey(java.lang.Integer modelNo,java.lang.Integer nodeNo){
		this.modelNo = modelNo;
		this.nodeNo = nodeNo;
	}
	/** 属性模板编号/模板编号 */
	@Column(name = "modelNo")
	private java.lang.Integer modelNo ;
	/** 属性节点编号/节点编号 */
	@Column(name = "nodeNo")
	private java.lang.Integer nodeNo ;
	/**
	 * 属性模板编号/模板编号的getter方法
	 */
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
	 * 属性节点编号/节点编号的getter方法
	 */
	public java.lang.Integer getNodeNo() {
    		return nodeNo;
	}
	/**
	 * 属性节点编号/节点编号的setter方法
	 */
	public void setNodeNo(java.lang.Integer nodeNo) {
		this.nodeNo = nodeNo;
	} 
}