package com.sinosoft.ims.core.kernel.entity;

import com.sinosoft.framework.core.dao.BaseEntity;

import javax.persistence.*;

/**
 * @author codegen@研发中心
 * @mail hongzhongkai
 * @time  2016-09-23 17:19:21.110 
 * 方法功能对应表-Saa_MethodTask   基础数据对象
 */
@Entity
@Table(name = "Saa_MethodTask")
@IdClass(SaaMethodTaskKey.class)
public class SaaMethodTask implements BaseEntity, java.io.Serializable {
	private static final long serialVersionUID = 1L;

	/** 属性方法代码/ */
	private String methodCode ;
	/** 属性功能ID/ */
	private String taskId ;
	/** 属性服务代码/ */
	private String svrCode ;
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
	 * 类SaaMethodTask的默认构造方法
	 */
	public SaaMethodTask() {
	}

	/**
	 * 属性方法代码/的getter方法
	 */
	public String getMethodCode() {
		return methodCode;
	}
	/**
	 * 属性方法代码/的setter方法
	 */
	public void setMethodCode(String methodCode) {
		this.methodCode = methodCode;
	} 
	/**
	 * 属性功能ID/的getter方法
	 */
	public String getTaskId() {
		return taskId;
	}
	/**
	 * 属性功能ID/的setter方法
	 */
	public void setTaskId(String taskId) {
		this.taskId = taskId;
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