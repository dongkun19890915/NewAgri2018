package com.sinosoft.dms.api.dict.dto;

import java.io.Serializable;

import com.sinosoft.framework.dto.BaseRequest;
/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-08-22 03:00:50.124 
 * 项目定义表Api操作对象
 */
public class PrpDprojectDto extends BaseRequest implements Serializable{
	private static final long serialVersionUID = 1L;
	/** 属性归属项目代码/归属项目代码 */
	private String projectCode ;
	/** 属性归属项目简体中文名称/归属项目简体中文名称 */
	private String projectCName ;
	/** 属性归属项目繁体中文名称/归属项目繁体中文名称 */
	private String projectTName ;
	/** 属性归属项目英文名称/归属项目英文名称 */
	private String projectEName ;
	/** 属性区域层级代码/区域层级代码 */
	private String comcode ;
	/** 属性生效日期/生效日期 */
	private java.util.Date validDate ;
	/** 属性失效日期/失效日期 */
	private java.util.Date invalidDate ;
	/** 属性审核标志/审核标志 */
	private String auditFlag ;
	/** 属性有效标志/有效标志 */
	private String validInd ;
	/** 属性预留字段1/预留字段1 */
	private String tcol1 ;
	/** 属性预留字段2/预留字段2 */
	private String tcol2 ;
	/** 属性预留字段3/预留字段3 */
	private String tcol3 ;
	/** 属性备注/备注 */
	private String remark ;
	/** 属性标志字段/标志字段 */
	private String flag ;
	/** 属性创建人/创建人 */
	private String createdBy ;
	/** 属性创建时间/创建时间 */
	private java.util.Date createdTime ;
	/** 属性更新人/更新人 */
	private String updatedBy ;
	/** 属性更新时间/更新时间 */
	private java.util.Date updatedTime ;
	/**
	 * 属性归属项目代码/归属项目代码的getter方法
	 */
	public String getProjectCode() {
		return projectCode;
	}
	/**
	 * 属性归属项目代码/归属项目代码的setter方法
	 */
	public void setProjectCode(String projectCode) {
		this.projectCode = projectCode;
	}
	/**
	 * 属性归属项目简体中文名称/归属项目简体中文名称的getter方法
	 */
	public String getProjectCName() {
		return projectCName;
	}
	/**
	 * 属性归属项目简体中文名称/归属项目简体中文名称的setter方法
	 */
	public void setProjectCName(String projectCName) {
		this.projectCName = projectCName;
	}
	/**
	 * 属性归属项目繁体中文名称/归属项目繁体中文名称的getter方法
	 */
	public String getProjectTName() {
		return projectTName;
	}
	/**
	 * 属性归属项目繁体中文名称/归属项目繁体中文名称的setter方法
	 */
	public void setProjectTName(String projectTName) {
		this.projectTName = projectTName;
	}
	/**
	 * 属性归属项目英文名称/归属项目英文名称的getter方法
	 */
	public String getProjectEName() {
		return projectEName;
	}
	/**
	 * 属性归属项目英文名称/归属项目英文名称的setter方法
	 */
	public void setProjectEName(String projectEName) {
		this.projectEName = projectEName;
	}
	/**
	 * 属性区域层级代码/区域层级代码的getter方法
	 */
	public String getComcode() {
		return comcode;
	}
	/**
	 * 属性区域层级代码/区域层级代码的setter方法
	 */
	public void setComcode(String comcode) {
		this.comcode = comcode;
	}
	/**
	 * 属性生效日期/生效日期的getter方法
	 */
	public java.util.Date getValidDate() {
		return validDate;
	}
	/**
	 * 属性生效日期/生效日期的setter方法
	 */
	public void setValidDate(java.util.Date validDate) {
		this.validDate = validDate;
	}
	/**
	 * 属性失效日期/失效日期的getter方法
	 */
	public java.util.Date getInvalidDate() {
		return invalidDate;
	}
	/**
	 * 属性失效日期/失效日期的setter方法
	 */
	public void setInvalidDate(java.util.Date invalidDate) {
		this.invalidDate = invalidDate;
	}
	/**
	 * 属性审核标志/审核标志的getter方法
	 */
	public String getAuditFlag() {
		return auditFlag;
	}
	/**
	 * 属性审核标志/审核标志的setter方法
	 */
	public void setAuditFlag(String auditFlag) {
		this.auditFlag = auditFlag;
	}
	/**
	 * 属性有效标志/有效标志的getter方法
	 */
	public String getValidInd() {
		return validInd;
	}
	/**
	 * 属性有效标志/有效标志的setter方法
	 */
	public void setValidInd(String validInd) {
		this.validInd = validInd;
	}
	/**
	 * 属性预留字段1/预留字段1的getter方法
	 */
	public String getTcol1() {
		return tcol1;
	}
	/**
	 * 属性预留字段1/预留字段1的setter方法
	 */
	public void setTcol1(String tcol1) {
		this.tcol1 = tcol1;
	}
	/**
	 * 属性预留字段2/预留字段2的getter方法
	 */
	public String getTcol2() {
		return tcol2;
	}
	/**
	 * 属性预留字段2/预留字段2的setter方法
	 */
	public void setTcol2(String tcol2) {
		this.tcol2 = tcol2;
	}
	/**
	 * 属性预留字段3/预留字段3的getter方法
	 */
	public String getTcol3() {
		return tcol3;
	}
	/**
	 * 属性预留字段3/预留字段3的setter方法
	 */
	public void setTcol3(String tcol3) {
		this.tcol3 = tcol3;
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
	/**
	 * 属性创建人/创建人的getter方法
	 */
	public String getCreatedBy() {
		return createdBy;
	}
	/**
	 * 属性创建人/创建人的setter方法
	 */
	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}
	/**
	 * 属性创建时间/创建时间的getter方法
	 */
	public java.util.Date getCreatedTime() {
		return createdTime;
	}
	/**
	 * 属性创建时间/创建时间的setter方法
	 */
	public void setCreatedTime(java.util.Date createdTime) {
		this.createdTime = createdTime;
	}
	/**
	 * 属性更新人/更新人的getter方法
	 */
	public String getUpdatedBy() {
		return updatedBy;
	}
	/**
	 * 属性更新人/更新人的setter方法
	 */
	public void setUpdatedBy(String updatedBy) {
		this.updatedBy = updatedBy;
	}
	/**
	 * 属性更新时间/更新时间的getter方法
	 */
	public java.util.Date getUpdatedTime() {
		return updatedTime;
	}
	/**
	 * 属性更新时间/更新时间的setter方法
	 */
	public void setUpdatedTime(java.util.Date updatedTime) {
		this.updatedTime = updatedTime;
	}
}
