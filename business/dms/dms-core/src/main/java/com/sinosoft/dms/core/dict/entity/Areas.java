package com.sinosoft.dms.core.dict.entity;

import com.sinosoft.framework.core.dao.BaseEntityImpl;

import javax.persistence.*;
import java.util.Date;

/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-10-10 06:45:04.724 
 * 行政区域表实体操作对象
 */
@Entity
@Table(name = "Areas")
@IdClass(AreasKey.class)
public class Areas extends BaseEntityImpl{

	private static final long serialVersionUID = 1L;
	/** 属性行政区域代码/行政区域代码 */
	@Id
	@Column(name = "areaCode")
	private String areaCode ;	

	/** 属性行政区域名称/行政区域名称 */
	@Column(name = "area_Name")
	private String areaName ;
	/** 属性上级行政区域代码/上级行政区域代码 */
	@Column(name = "super_Code")
	private String superCode ;
	/** 属性上级行政区域名称/上级行政区域名称 */
	@Column(name = "super_Name")
	private String superName ;
	/** 属性备注/备注 */
	@Column(name = "reMark")
	private String reMark ;
	/** 属性并发控制/并发控制 */
	@Column(name = "version")
	private Integer version ;
	/**
	 * 属性创建人/创建人
	 */
	private String createdBy;
	/**
	 * 属性创建时间/创建时间
	 */
	private Date createdTime;
	/**
	 * 属性更新人/更新人
	 */
	private String updatedBy;
	/**
	 * 属性更新时间/更新时间
	 */
	private Date updatedTime;

	@Override
	public String getCreatedBy() {
		return createdBy;
	}

	@Override
	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	@Override
	public Date getCreatedTime() {
		return createdTime;
	}

	@Override
	public void setCreatedTime(Date createdTime) {
		this.createdTime = createdTime;
	}

	@Override
	public String getUpdatedBy() {
		return updatedBy;
	}

	@Override
	public void setUpdatedBy(String updatedBy) {
		this.updatedBy = updatedBy;
	}

	@Override
	public Date getUpdatedTime() {
		return updatedTime;
	}

	@Override
	public void setUpdatedTime(Date updatedTime) {
		this.updatedTime = updatedTime;
	}

	/**
	 * 属性行政区域代码/行政区域代码的getter方法
	 */
	public String getAreaCode() {
		return areaCode;
	}

	/**
	 * 属性行政区域代码/行政区域代码的setter方法
	 */
	public void setAreaCode(String areaCode) {
		this.areaCode = areaCode;
	}
	/**
	 * 属性行政区域名称/行政区域名称的getter方法
	 */
	public String getAreaName() {
		return areaName;
	}
	/**
	 * 属性行政区域名称/行政区域名称的setter方法
	 */
	public void setAreaName(String areaName) {
		this.areaName = areaName;
	}
	/**
	 * 属性上级行政区域代码/上级行政区域代码的getter方法
	 */
	public String getSuperCode() {
		return superCode;
	}
	/**
	 * 属性上级行政区域代码/上级行政区域代码的setter方法
	 */
	public void setSuperCode(String superCode) {
		this.superCode = superCode;
	}
	/**
	 * 属性上级行政区域名称/上级行政区域名称的getter方法
	 */
	public String getSuperName() {
		return superName;
	}
	/**
	 * 属性上级行政区域名称/上级行政区域名称的setter方法
	 */
	public void setSuperName(String superName) {
		this.superName = superName;
	}
	/**
	 * 属性备注/备注的getter方法
	 */
	public String getReMark() {
		return reMark;
	}
	/**
	 * 属性备注/备注的setter方法
	 */
	public void setReMark(String reMark) {
		this.reMark = reMark;
	}
	/**
	 * 属性并发控制/并发控制的getter方法
	 */
	public Integer getVersion() {
		return version;
	}
	/**
	 * 属性并发控制/并发控制的setter方法
	 */
	public void setVersion(Integer version) {
		this.version = version;
	}

}