package com.sinosoft.ims.core.kernel.entity;

import com.sinosoft.framework.core.dao.BaseEntity;

import javax.persistence.*;

/**
 * @author codegen@研发中心
 * @mail hongzhongkai
 * @time  2016-09-23 17:19:21.110 
 * 任务表-Saa_Task   基础数据对象
 */
@Entity
@Table(name = "Saa_Task")
@IdClass(SaaTaskKey.class)
public class SaaTask implements BaseEntity, java.io.Serializable {
	private static final long serialVersionUID = 1L;

	/** 属性服务代码/ */
	private String svrCode ;
	/** 属性功能代码/ */
	private String taskCode ;
	/** 属性上级功能代码/ */
	private String parentCode ;
	/** 属性功能中文名称/ */
	private String taskCName ;
	/** 属性功能繁体名称/ */
	private String taskTName ;
	/** 属性功能英文名称/ */
	private String taskEName ;
	/** 属性有效标志/ */
	private String validStatus ;
	/** 属性信息创建日期/ */
	private java.util.Date createDate ;
	/** 属性信息创建人员/ */
	private String creatorCode ;
	/** 属性最新更新操作日期/ */
	private java.util.Date updateDate ;
	/** 属性最新更新操作人员/ */
	private String updaterCode ;
	/** 属性ID/ */
	@Id
	@Column(name = "Id")
	private String iD ;
	/**
	 * 属性ID/的getter方法
	 */
	public String getID() {
		return iD;
	}
	/**
	 * 属性ID/的setter方法
	 */
	public void setID(String iD) {
		this.iD = iD;
	}
	/**
	 * 类SaaTask的默认构造方法
	 */
	public SaaTask() {
	}

	/**
	 * 属性服务代码/的getter方法
	 */
	public String getSvrCode() {
		return svrCode;
	}
	/**
	 * 属性服务代码/的setter方法
	 */
	public void setSvrCode(String svrCode) {
		this.svrCode = svrCode;
	} 
	/**
	 * 属性功能代码/的getter方法
	 */
	public String getTaskCode() {
		return taskCode;
	}
	/**
	 * 属性功能代码/的setter方法
	 */
	public void setTaskCode(String taskCode) {
		this.taskCode = taskCode;
	} 
	/**
	 * 属性上级功能代码/的getter方法
	 */
	public String getParentCode() {
		return parentCode;
	}
	/**
	 * 属性上级功能代码/的setter方法
	 */
	public void setParentCode(String parentCode) {
		this.parentCode = parentCode;
	} 
	/**
	 * 属性功能中文名称/的getter方法
	 */
	public String getTaskCName() {
		return taskCName;
	}
	/**
	 * 属性功能中文名称/的setter方法
	 */
	public void setTaskCName(String taskCName) {
		this.taskCName = taskCName;
	} 
	/**
	 * 属性功能繁体名称/的getter方法
	 */
	public String getTaskTName() {
		return taskTName;
	}
	/**
	 * 属性功能繁体名称/的setter方法
	 */
	public void setTaskTName(String taskTName) {
		this.taskTName = taskTName;
	} 
	/**
	 * 属性功能英文名称/的getter方法
	 */
	public String getTaskEName() {
		return taskEName;
	}
	/**
	 * 属性功能英文名称/的setter方法
	 */
	public void setTaskEName(String taskEName) {
		this.taskEName = taskEName;
	} 
	/**
	 * 属性有效标志/的getter方法
	 */
	public String getValidStatus() {
		return validStatus;
	}
	/**
	 * 属性有效标志/的setter方法
	 */
	public void setValidStatus(String validStatus) {
		this.validStatus = validStatus;
	} 
	/**
	 * 属性信息创建日期/的getter方法
	 */
	public java.util.Date getCreateDate() {
		return createDate;
	}
	/**
	 * 属性信息创建日期/的setter方法
	 */
	public void setCreateDate(java.util.Date createDate) {
		this.createDate = createDate;
	} 
	/**
	 * 属性信息创建人员/的getter方法
	 */
	public String getCreatorCode() {
		return creatorCode;
	}
	/**
	 * 属性信息创建人员/的setter方法
	 */
	public void setCreatorCode(String creatorCode) {
		this.creatorCode = creatorCode;
	} 
	/**
	 * 属性最新更新操作日期/的getter方法
	 */
	public java.util.Date getUpdateDate() {
		return updateDate;
	}
	/**
	 * 属性最新更新操作日期/的setter方法
	 */
	public void setUpdateDate(java.util.Date updateDate) {
		this.updateDate = updateDate;
	} 
	/**
	 * 属性最新更新操作人员/的getter方法
	 */
	public String getUpdaterCode() {
		return updaterCode;
	}
	/**
	 * 属性最新更新操作人员/的setter方法
	 */
	public void setUpdaterCode(String updaterCode) {
		this.updaterCode = updaterCode;
	} 
}