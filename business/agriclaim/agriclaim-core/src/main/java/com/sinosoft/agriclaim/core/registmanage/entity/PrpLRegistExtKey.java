package com.sinosoft.agriclaim.core.registmanage.entity;

import com.sinosoft.framework.core.dao.BasePKImpl;
import javax.persistence.*;

/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-11-08 05:45:22.527 
 * 报案信息补充说明主键操作对象
 */
public class PrpLRegistExtKey extends BasePKImpl{
	private static final long serialVersionUID = 1L;
	public PrpLRegistExtKey(){}
	public PrpLRegistExtKey(String registNo,java.lang.Integer serialNo,String nodeType){
		this.registNo = registNo;
		this.serialNo = serialNo;
		this.nodeType = nodeType;
	}
	/** 属性报案号码/报案号码 */
	@Column(name = "registNo")
	private String registNo ;
	/** 属性序号/序号 */
	@Column(name = "serialNo")
	private java.lang.Integer serialNo ;
	/** 属性处理节点/处理节点 */
	@Column(name = "nodeType")
	private String nodeType ;
	/**
	 * 属性报案号码/报案号码的getter方法
	 */
	public String getRegistNo() {
    		return registNo;
	}
	/**
	 * 属性报案号码/报案号码的setter方法
	 */
	public void setRegistNo(String registNo) {
		this.registNo = registNo;
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
	/**
	 * 属性处理节点/处理节点的getter方法
	 */
	public String getNodeType() {
    		return nodeType;
	}
	/**
	 * 属性处理节点/处理节点的setter方法
	 */
	public void setNodeType(String nodeType) {
		this.nodeType = nodeType;
	} 
}