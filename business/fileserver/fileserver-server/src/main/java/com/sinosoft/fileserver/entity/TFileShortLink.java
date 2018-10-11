package com.sinosoft.fileserver.entity;

/**
 * @author codegen@研发中心
 * @mail weiyang@sinosoft.com.cn
 * @time  2016-10-06 18:53:43.125 
 * TFileShortLink-文件短链接表   基础数据对象
 */
public class TFileShortLink extends TFileShortLinkKey implements java.io.Serializable {
	private static final long serialVersionUID = 1L;

	/** 属性InvalidTime/失效时间 */
	private java.util.Date invalidTime ;
	/** 属性FileId/文件id */
	private String fileId ;
	/** 属性CreateTime/审计字段：创建时间 */
	private java.util.Date createTime ;
	/** 属性CreateBy/审计字段：创建人 */
	private String createBy ;
	/** 属性UpdateTime/审计字段：更新时间 */
	private java.util.Date updateTime ;
	/** 属性UpdateBy/审计字段：更新人 */
	private String updateBy ;
	/** 属性IsDeleted/是否删除 */
	private String isDeleted ;
	/**
	 * 类TFileShortLink的默认构造方法
	 */
	public TFileShortLink() {
	}

	/**
	 * 属性InvalidTime/失效时间的getter方法
	 */
	public java.util.Date getInvalidTime() {
		return invalidTime;
	}
	/**
	 * 属性InvalidTime/失效时间的setter方法
	 */
	public void setInvalidTime(java.util.Date invalidTime) {
		this.invalidTime = invalidTime;
	} 
	/**
	 * 属性FileId/文件id的getter方法
	 */
	public String getFileId() {
		return fileId;
	}
	/**
	 * 属性FileId/文件id的setter方法
	 */
	public void setFileId(String fileId) {
		this.fileId = fileId;
	} 
	/**
	 * 属性CreateTime/审计字段：创建时间的getter方法
	 */
	public java.util.Date getCreateTime() {
		return createTime;
	}
	/**
	 * 属性CreateTime/审计字段：创建时间的setter方法
	 */
	public void setCreateTime(java.util.Date createTime) {
		this.createTime = createTime;
	} 
	/**
	 * 属性CreateBy/审计字段：创建人的getter方法
	 */
	public String getCreateBy() {
		return createBy;
	}
	/**
	 * 属性CreateBy/审计字段：创建人的setter方法
	 */
	public void setCreateBy(String createBy) {
		this.createBy = createBy;
	} 
	/**
	 * 属性UpdateTime/审计字段：更新时间的getter方法
	 */
	public java.util.Date getUpdateTime() {
		return updateTime;
	}
	/**
	 * 属性UpdateTime/审计字段：更新时间的setter方法
	 */
	public void setUpdateTime(java.util.Date updateTime) {
		this.updateTime = updateTime;
	} 
	/**
	 * 属性UpdateBy/审计字段：更新人的getter方法
	 */
	public String getUpdateBy() {
		return updateBy;
	}
	/**
	 * 属性UpdateBy/审计字段：更新人的setter方法
	 */
	public void setUpdateBy(String updateBy) {
		this.updateBy = updateBy;
	} 
	/**
	 * 属性IsDeleted/是否删除的getter方法
	 */
	public String getIsDeleted() {
		return isDeleted;
	}
	/**
	 * 属性IsDeleted/是否删除的setter方法
	 */
	public void setIsDeleted(String isDeleted) {
		this.isDeleted = isDeleted;
	} 
}