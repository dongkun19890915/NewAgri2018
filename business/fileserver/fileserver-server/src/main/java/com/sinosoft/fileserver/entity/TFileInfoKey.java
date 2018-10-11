package com.sinosoft.fileserver.entity;

/**
 * @author codegen@研发中心
 * @mail zhoujianlong@sinosoft.com.cn
 * @time  2016-11-25 15:25:25.477 
 * TFileInfo 主键操作类
 */
public class TFileInfoKey implements java.io.Serializable {
	private static final long serialVersionUID = 1L;
	/** 属性文件id/文件id */
	private String fileId ;
	/** 属性存储代码/存储代码 */
	private String storageConfig ;
	/**
	 * 属性文件id/文件id的getter方法
	 */
	public String getFileId() {
    		return fileId;
	}
	/**
	 * 属性文件id/文件id的setter方法
	 */
	public void setFileId(String fileId) {
		this.fileId = fileId;
	} 
	/**
	 * 属性存储代码/存储代码的getter方法
	 */
	public String getStorageConfig() {
    		return storageConfig;
	}
	/**
	 * 属性存储代码/存储代码的setter方法
	 */
	public void setStorageConfig(String storageConfig) {
		this.storageConfig = storageConfig;
	} 
}