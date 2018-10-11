package com.sinosoft.agriclaim.core.workflowmanage.entity;

import com.sinosoft.framework.core.dao.BasePKImpl;
import javax.persistence.*;

/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-11-08 05:47:03.090 
 * 工作流路径定义表主键操作对象
 */
public class SwfPathKey extends BasePKImpl{
	private static final long serialVersionUID = 1L;
	public SwfPathKey(){}
	public SwfPathKey(java.lang.Integer modelNo,java.lang.Integer pathNo){
		this.modelNo = modelNo;
		this.pathNo = pathNo;
	}
	/** 属性模板编号/模板编号 */
	@Column(name = "modelNo")
	private java.lang.Integer modelNo ;
	/** 属性流程边号/流程边号 */
	@Column(name = "pathNo")
	private java.lang.Integer pathNo ;
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