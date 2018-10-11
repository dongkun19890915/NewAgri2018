package com.sinosoft.ims.core.kernel.entity;

import com.sinosoft.framework.core.dao.BaseEntity;

import javax.persistence.*;

/**
 * @author codegen@研发中心
 * @mail hongzhongkai
 * @time  2016-09-23 17:19:21.110 
 * 岗位模板表-Saa_GradeTempl   基础数据对象
 */
@Entity
@Table(name = "Saa_GradeTempl")
@IdClass(SaaGradeTemplKey.class)
public class SaaGradeTempl implements BaseEntity, java.io.Serializable {
	private static final long serialVersionUID = 1L;

	/** 属性岗位模板简体中文名称/ */
	private String gradeTemplCName ;
	/** 属性岗位模板繁体中文名称/ */
	private String gradeTemplTName ;
	/** 属性岗位模板英文名称/ */
	private String gradeTemplEName ;
	/** 属性继承模版ID/ */
	private String extendTemplID ;
	/** 属性二代岗位模板代码/ */
	private String oldTemplCode ;
	/** 属性所属机构/ */
	private String comCode ;
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
	 * 类SaaGradeTempl的默认构造方法
	 */
	public SaaGradeTempl() {
	}

	/**
	 * 属性岗位模板简体中文名称/的getter方法
	 */
	public String getGradeTemplCName() {
		return gradeTemplCName;
	}
	/**
	 * 属性岗位模板简体中文名称/的setter方法
	 */
	public void setGradeTemplCName(String gradeTemplCName) {
		this.gradeTemplCName = gradeTemplCName;
	} 
	/**
	 * 属性岗位模板繁体中文名称/的getter方法
	 */
	public String getGradeTemplTName() {
		return gradeTemplTName;
	}
	/**
	 * 属性岗位模板繁体中文名称/的setter方法
	 */
	public void setGradeTemplTName(String gradeTemplTName) {
		this.gradeTemplTName = gradeTemplTName;
	} 
	/**
	 * 属性岗位模板英文名称/的getter方法
	 */
	public String getGradeTemplEName() {
		return gradeTemplEName;
	}
	/**
	 * 属性岗位模板英文名称/的setter方法
	 */
	public void setGradeTemplEName(String gradeTemplEName) {
		this.gradeTemplEName = gradeTemplEName;
	} 
	/**
	 * 属性继承模版ID/的getter方法
	 */
	public String getExtendTemplID() {
		return extendTemplID;
	}
	/**
	 * 属性继承模版ID/的setter方法
	 */
	public void setExtendTemplID(String extendTemplID) {
		this.extendTemplID = extendTemplID;
	} 
	/**
	 * 属性二代岗位模板代码/的getter方法
	 */
	public String getOldTemplCode() {
		return oldTemplCode;
	}
	/**
	 * 属性二代岗位模板代码/的setter方法
	 */
	public void setOldTemplCode(String oldTemplCode) {
		this.oldTemplCode = oldTemplCode;
	} 
	/**
	 * 属性所属机构/的getter方法
	 */
	public String getComCode() {
		return comCode;
	}
	/**
	 * 属性所属机构/的setter方法
	 */
	public void setComCode(String comCode) {
		this.comCode = comCode;
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