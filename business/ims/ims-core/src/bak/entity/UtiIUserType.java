package com.sinosoft.ims.core.kernel.entity;

import com.sinosoft.framework.core.dao.BaseEntity;

import javax.persistence.*;

/**
 * @author codegen@研发中心
 * @mail hongzhongkai
 * @time  2016-09-23 17:19:21.110 
 * 用户分类与用户关系表-UtiIUserType   基础数据对象
 */
@Entity
@Table(name = "UtiIUserType")
@IdClass(UtiIUserTypeKey.class)
public class UtiIUserType implements BaseEntity, java.io.Serializable {
	private static final long serialVersionUID = 1L;


	/** 属性用户名称/ */
	private String userName ;
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
	/** 属性用户分类/ */
	@Id
	@Column(name = "usertype")
	private String userType ;
	/** 属性用户代码/ */
	@Id
	@Column(name = "userCode")
	private String userCode ;
	/**
	 * 属性用户分类/的getter方法
	 */
	public String getUserType() {
		return userType;
	}
	/**
	 * 属性用户分类/的setter方法
	 */
	public void setUserType(String userType) {
		this.userType = userType;
	}
	/**
	 * 属性用户代码/的getter方法
	 */
	public String getUserCode() {
		return userCode;
	}
	/**
	 * 属性用户代码/的setter方法
	 */
	public void setUserCode(String userCode) {
		this.userCode = userCode;
	}
	/**
	 * 类UtiIUserType的默认构造方法
	 */
	public UtiIUserType() {
	}


	/**
	 * 属性用户名称/的getter方法
	 */
	public String getUserName() {
		return userName;
	}
	/**
	 * 属性用户名称/的setter方法
	 */
	public void setUserName(String userName) {
		this.userName = userName;
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