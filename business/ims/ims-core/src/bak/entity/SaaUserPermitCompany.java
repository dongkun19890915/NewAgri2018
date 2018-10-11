package com.sinosoft.ims.core.kernel.entity;

import com.sinosoft.framework.core.dao.BaseEntity;

import javax.persistence.*;

/**
 * @author codegen@研发中心
 * @mail hongzhongkai
 * @time  2016-09-23 17:19:21.110 
 * 业务权限允许机构表-Saa_UserPermitCompany   基础数据对象
 */
@Entity
@Table(name = "Saa_UserPermitCompany")
@IdClass(SaaUserPermitCompanyKey.class)
public class SaaUserPermitCompany implements BaseEntity, java.io.Serializable {
	private static final long serialVersionUID = 1L;

	/** 属性数据权限Id/ */
	private String powerId ;
	/** 属性允许机构代码/ */
	private String comCode ;
	/** 属性是否包含下属机构/ */
	private String includeSubCom ;
	/** 属性标志字段/ */
	private String flag ;
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
	 * 类UserPermitCompany的默认构造方法
	 */
	public SaaUserPermitCompany() {
	}

	/**
	 * 属性数据权限Id/的getter方法
	 */
	public String getPowerId() {
		return powerId;
	}
	/**
	 * 属性数据权限Id/的setter方法
	 */
	public void setPowerId(String powerId) {
		this.powerId = powerId;
	} 
	/**
	 * 属性允许机构代码/的getter方法
	 */
	public String getComCode() {
		return comCode;
	}
	/**
	 * 属性允许机构代码/的setter方法
	 */
	public void setComCode(String comCode) {
		this.comCode = comCode;
	} 
	/**
	 * 属性是否包含下属机构/的getter方法
	 */
	public String getIncludeSubCom() {
		return includeSubCom;
	}
	/**
	 * 属性是否包含下属机构/的setter方法
	 */
	public void setIncludeSubCom(String includeSubCom) {
		this.includeSubCom = includeSubCom;
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