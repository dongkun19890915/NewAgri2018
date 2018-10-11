package com.sinosoft.fileserver.entity;

/**
 * @author codegen@研发中心
 * @mail zhoujianlong@sinosoft.com.cn
 * @time  2016-11-25 15:25:25.477 
 * TFileInfo   基础数据对象
 */
public class TFileInfo extends TFileInfoKey implements java.io.Serializable {
	private static final long serialVersionUID = 1L;


	/** 属性文件名/文件名 */
	private String fileName ;
	/** 属性文件扩展/文件扩展 */
	private String fileExt ;
	/** 属性文件路径/文件路径 */
	private String filePath ;
	/** 属性文件大小/文件大小 */
	private long fileSize ;
	/** 属性创建人/创建人 */
	private String createBy ;
	/** 属性创建时间/创建时间 */
	private java.util.Date createTime ;
	/** 属性修改时间/修改时间 */
	private java.util.Date updateTime ;
	/** 属性修改人/修改人 */
	private String updateBy ;
	/** 属性是否删除/是否删除 */
	private String isDeleted ;
	/** 属性业务类型/业务类型 */
	private String bussType ;
	/** 属性存储介质/存储介质 */
	private String storageMedium ;
	/** 属性系统代码/系统代码 */
	private String systemId ;
	/** 属性MD5值/文件MD5值 */
	private String fileMD5 ;
	/**
	 * 类TFileInfo的默认构造方法
	 */
	public TFileInfo() {
	}


	/**
	 * 属性文件名/文件名的getter方法
	 */
	public String getFileName() {
		return fileName;
	}
	/**
	 * 属性文件名/文件名的setter方法
	 */
	public void setFileName(String fileName) {
		this.fileName = fileName;
	} 
	/**
	 * 属性文件扩展/文件扩展的getter方法
	 */
	public String getFileExt() {
		return fileExt;
	}
	/**
	 * 属性文件扩展/文件扩展的setter方法
	 */
	public void setFileExt(String fileExt) {
		this.fileExt = fileExt;
	} 
	/**
	 * 属性文件路径/文件路径的getter方法
	 */
	public String getFilePath() {
		return filePath;
	}
	/**
	 * 属性文件路径/文件路径的setter方法
	 */
	public void setFilePath(String filePath) {
		this.filePath = filePath;
	} 
	/**
	 * 属性文件大小/文件大小的getter方法
	 */
	public long getFileSize() {
		return fileSize;
	}
	/**
	 * 属性文件大小/文件大小的setter方法
	 */
	public void setFileSize(long l) {
		this.fileSize = l;
	} 
	/**
	 * 属性创建人/创建人的getter方法
	 */
	public String getCreateBy() {
		return createBy;
	}
	/**
	 * 属性创建人/创建人的setter方法
	 */
	public void setCreateBy(String createBy) {
		this.createBy = createBy;
	} 
	/**
	 * 属性创建时间/创建时间的getter方法
	 */
	public java.util.Date getCreateTime() {
		return createTime;
	}
	/**
	 * 属性创建时间/创建时间的setter方法
	 */
	public void setCreateTime(java.util.Date createTime) {
		this.createTime = createTime;
	} 
	/**
	 * 属性修改时间/修改时间的getter方法
	 */
	public java.util.Date getUpdateTime() {
		return updateTime;
	}
	/**
	 * 属性修改时间/修改时间的setter方法
	 */
	public void setUpdateTime(java.util.Date updateTime) {
		this.updateTime = updateTime;
	} 
	/**
	 * 属性修改人/修改人的getter方法
	 */
	public String getUpdateBy() {
		return updateBy;
	}
	/**
	 * 属性修改人/修改人的setter方法
	 */
	public void setUpdateBy(String updateBy) {
		this.updateBy = updateBy;
	} 
	/**
	 * 属性是否删除/是否删除的getter方法
	 */
	public String getIsDeleted() {
		return isDeleted;
	}
	/**
	 * 属性是否删除/是否删除的setter方法
	 */
	public void setIsDeleted(String isDeleted) {
		this.isDeleted = isDeleted;
	} 
	/**
	 * 属性业务类型/业务类型的getter方法
	 */
	public String getBussType() {
		return bussType;
	}
	/**
	 * 属性业务类型/业务类型的setter方法
	 */
	public void setBussType(String bussType) {
		this.bussType = bussType;
	} 
	/**
	 * 属性存储介质/存储介质的getter方法
	 */
	public String getStorageMedium() {
		return storageMedium;
	}
	/**
	 * 属性存储介质/存储介质的setter方法
	 */
	public void setStorageMedium(String storageMedium) {
		this.storageMedium = storageMedium;
	} 
	/**
	 * 属性系统代码/系统代码的getter方法
	 */
	public String getSystemId() {
		return systemId;
	}
	/**
	 * 属性系统代码/系统代码的setter方法
	 */
	public void setSystemId(String systemId) {
		this.systemId = systemId;
	} 
	/**
	 * 属性MD5值/文件MD5值的getter方法
	 */
	public String getFileMD5() {
		return fileMD5;
	}
	/**
	 * 属性MD5值/文件MD5值的setter方法
	 */
	public void setFileMD5(String fileMD5) {
		this.fileMD5 = fileMD5;
	} 
}