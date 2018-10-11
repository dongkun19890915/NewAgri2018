package com.sinosoft.agriclaim.core.workflowmanage.entity;

import com.sinosoft.framework.core.dao.BasePKImpl;
import javax.persistence.*;

/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-11-08 05:47:03.090 
 * 工作流条件描述表主键操作对象
 */
public class SwfConditionKey extends BasePKImpl{
	private static final long serialVersionUID = 1L;
	public SwfConditionKey(){}
	public SwfConditionKey(java.lang.Integer modelNo,java.lang.Integer pathNo,java.lang.Integer conditionNo,java.lang.Integer serialNo){
		this.modelNo = modelNo;
		this.pathNo = pathNo;
		this.conditionNo = conditionNo;
		this.serialNo = serialNo;
	}
	/** 属性模版号/模版号 */
	@Column(name = "modelNo")
	private java.lang.Integer modelNo ;
	/** 属性路径号/路径号 */
	@Column(name = "pathNo")
	private java.lang.Integer pathNo ;
	/** 属性条件编号/条件编号 */
	@Column(name = "conditionNo")
	private java.lang.Integer conditionNo ;
	/** 属性序号/序号 */
	@Column(name = "serialNo")
	private java.lang.Integer serialNo ;
	/**
	 * 属性模版号/模版号的getter方法
	 */
	public java.lang.Integer getModelNo() {
    		return modelNo;
	}
	/**
	 * 属性模版号/模版号的setter方法
	 */
	public void setModelNo(java.lang.Integer modelNo) {
		this.modelNo = modelNo;
	} 
	/**
	 * 属性路径号/路径号的getter方法
	 */
	public java.lang.Integer getPathNo() {
    		return pathNo;
	}
	/**
	 * 属性路径号/路径号的setter方法
	 */
	public void setPathNo(java.lang.Integer pathNo) {
		this.pathNo = pathNo;
	} 
	/**
	 * 属性条件编号/条件编号的getter方法
	 */
	public java.lang.Integer getConditionNo() {
    		return conditionNo;
	}
	/**
	 * 属性条件编号/条件编号的setter方法
	 */
	public void setConditionNo(java.lang.Integer conditionNo) {
		this.conditionNo = conditionNo;
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