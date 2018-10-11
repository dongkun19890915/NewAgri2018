package com.sinosoft.ims.core.kernel.entity;

import com.sinosoft.framework.core.dao.BaseEntity;

import javax.persistence.*;

/**
 * @author codegen@研发中心
 * @mail hongzhongkai
 * @time  2016-09-23 17:19:21.110 
 * 岗位功能表-Saa_GradeTask   基础数据对象
 */
@Entity
@Table(name = "Saa_GradeTask")
@IdClass(SaaGradeTaskKey.class)
public class SaaGradeTask implements BaseEntity, java.io.Serializable {
	private static final long serialVersionUID = 1L;

	/** 属性岗位ID/ */
	private String gradeID ;
	/** 属性功能代码/ */
	private String taskID ;
	/** 属性内网权限/ */
	private String intranetValue ;
	/** 属性外网权限/ */
	private String internetValue ;
	/** 属性失效日期/ */
	private java.util.Date invalidDate ;
	/** 属性有效标志/ */
	private String validStatus ;
	/** 属性标志字段/ */
	private String flag ;
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
	@Column(name = "id")
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
	} /**
	 * 类SaaGradeTask的默认构造方法
	 */
	public SaaGradeTask() {
	}

	/**
	 * 属性岗位ID/的getter方法
	 */
	public String getGradeID() {
		return gradeID;
	}
	/**
	 * 属性岗位ID/的setter方法
	 */
	public void setGradeID(String gradeID) {
		this.gradeID = gradeID;
	} 
	/**
	 * 属性功能代码/的getter方法
	 */
	public String getTaskID() {
		return taskID;
	}
	/**
	 * 属性功能代码/的setter方法
	 */
	public void setTaskID(String taskID) {
		this.taskID = taskID;
	} 
	/**
	 * 属性内网权限/的getter方法
	 */
	public String getIntranetValue() {
		return intranetValue;
	}
	/**
	 * 属性内网权限/的setter方法
	 */
	public void setIntranetValue(String intranetValue) {
		this.intranetValue = intranetValue;
	} 
	/**
	 * 属性外网权限/的getter方法
	 */
	public String getInternetValue() {
		return internetValue;
	}
	/**
	 * 属性外网权限/的setter方法
	 */
	public void setInternetValue(String internetValue) {
		this.internetValue = internetValue;
	} 
	/**
	 * 属性失效日期/的getter方法
	 */
	public java.util.Date getInvalidDate() {
		return invalidDate;
	}
	/**
	 * 属性失效日期/的setter方法
	 */
	public void setInvalidDate(java.util.Date invalidDate) {
		this.invalidDate = invalidDate;
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
	 * 属性标志字段/的getter方法
	 */
	public String getFlag() {
		return flag;
	}
	/**
	 * 属性标志字段/的setter方法
	 */
	public void setFlag(String flag) {
		this.flag = flag;
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