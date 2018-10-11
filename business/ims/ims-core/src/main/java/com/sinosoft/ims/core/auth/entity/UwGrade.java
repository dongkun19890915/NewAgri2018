package com.sinosoft.ims.core.auth.entity;

import com.sinosoft.framework.core.dao.BaseEntityImpl;
import javax.persistence.*;
import java.util.Date;

/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-11-05 01:11:08.689 
 * 核保核赔节点权限表实体操作对象
 */
@Entity
@Table(name = "UwGrade")
@IdClass(UwGradeKey.class)
public class UwGrade extends BaseEntityImpl{

	private static final long serialVersionUID = 1L;
	/** 属性人员代码/人员代码 */
	@Id
	@Column(name = "userCode")
	private String userCode ;/** 属性模板号/模板号 */
	@Id
	@Column(name = "modelNo")
	private java.lang.Integer modelNo ;/** 属性节点号/节点号 */
	@Id
	@Column(name = "nodeNo")
	private java.lang.Integer nodeNo ;/** 属性权限组号/权限组号 */
	@Id
	@Column(name = "groupNo")
	private java.lang.Integer groupNo ;	




	/**
	 * 属性人员代码/人员代码的getter方法
	 */
	public String getUserCode() {
		return userCode;
	}
	/**
	 * 属性人员代码/人员代码的setter方法
	 */
	public void setUserCode(String userCode) {
		this.userCode = userCode;
	} 	
	/**
	 * 属性模板号/模板号的getter方法
	 */
	public java.lang.Integer getModelNo() {
		return modelNo;
	}
	/**
	 * 属性模板号/模板号的setter方法
	 */
	public void setModelNo(java.lang.Integer modelNo) {
		this.modelNo = modelNo;
	} 	
	/**
	 * 属性节点号/节点号的getter方法
	 */
	public java.lang.Integer getNodeNo() {
		return nodeNo;
	}
	/**
	 * 属性节点号/节点号的setter方法
	 */
	public void setNodeNo(java.lang.Integer nodeNo) {
		this.nodeNo = nodeNo;
	} 	
	/**
	 * 属性权限组号/权限组号的getter方法
	 */
	public java.lang.Integer getGroupNo() {
		return groupNo;
	}
	/**
	 * 属性权限组号/权限组号的setter方法
	 */
	public void setGroupNo(java.lang.Integer groupNo) {
		this.groupNo = groupNo;
	} 	
}