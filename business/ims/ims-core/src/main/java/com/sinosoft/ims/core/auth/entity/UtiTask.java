package com.sinosoft.ims.core.auth.entity;

import com.sinosoft.framework.core.dao.BaseEntityImpl;
import javax.persistence.*;
import java.util.Date;

/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-08-22 03:00:27.902 
 * 任务定义表实体操作对象
 */
@Entity
@Table(name = "UtiTask")
@IdClass(UtiTaskKey.class)
public class UtiTask extends BaseEntityImpl{

	private static final long serialVersionUID = 1L;
	/** 属性功能代码/功能代码 */
        @Id
        @Column(name = "taskCode")
	private String taskCode ;	

	/** 属性上级功能代码/上级功能代码 */
	private String parentCode ;
	/** 属性功能名称/功能名称 */
	private String taskName ;
	/** 属性备注/备注 */
	private String remark ;
	/** 属性标志字段/标志字段 */
	private String flag ;




	/**
	 * 属性功能代码/功能代码的getter方法
	 */
	public String getTaskCode() {
		return taskCode;
	}
	/**
	 * 属性功能代码/功能代码的setter方法
	 */
	public void setTaskCode(String taskCode) {
		this.taskCode = taskCode;
	} 
	/**
	 * 属性上级功能代码/上级功能代码的getter方法
	 */
	public String getParentCode() {
		return parentCode;
	}
	/**
	 * 属性上级功能代码/上级功能代码的setter方法
	 */
	public void setParentCode(String parentCode) {
		this.parentCode = parentCode;
	} 
	/**
	 * 属性功能名称/功能名称的getter方法
	 */
	public String getTaskName() {
		return taskName;
	}
	/**
	 * 属性功能名称/功能名称的setter方法
	 */
	public void setTaskName(String taskName) {
		this.taskName = taskName;
	} 
	/**
	 * 属性备注/备注的getter方法
	 */
	public String getRemark() {
		return remark;
	}
	/**
	 * 属性备注/备注的setter方法
	 */
	public void setRemark(String remark) {
		this.remark = remark;
	} 
	/**
	 * 属性标志字段/标志字段的getter方法
	 */
	public String getFlag() {
		return flag;
	}
	/**
	 * 属性标志字段/标志字段的setter方法
	 */
	public void setFlag(String flag) {
		this.flag = flag;
	} 
}