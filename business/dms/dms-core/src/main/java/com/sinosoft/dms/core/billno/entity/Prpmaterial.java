package com.sinosoft.dms.core.billno.entity;

import com.sinosoft.framework.core.dao.BaseEntityImpl;
import javax.persistence.*;
import java.util.Date;

/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-11-05 01:02:29.563 
 * 影像表实体操作对象
 */
@Entity
@Table(name = "prpmaterial")
@IdClass(PrpmaterialKey.class)
public class Prpmaterial extends BaseEntityImpl{

	private static final long serialVersionUID = 1L;
	/** 属性业务号/业务号 */
	@Id
	@Column(name = "businessNo")
	private String businessNo ;/** 属性序号/序号 */
	@Id
	@Column(name = "serialNo")
	private Integer serialNo ;


	/** 属性保单号/保单号 */
	@Column(name = "policyNo")
	private String policyNo ;
	/** 属性单证类型/单证类型 */
	@Column(name = "typeCode")
	private String typeCode ;
	/** 属性单证名称/单证名称 */
	@Column(name = "picName")
	private String picName ;
	/** 属性系统文件名/系统文件名 */
	@Column(name = "sysFileName")
	private String sysFileName ;
	/** 属性影像资料名称/影像资料名称 */
	@Column(name = "fileName")
	private String fileName ;
	/** 属性文件保存绝对路径/文件保存绝对路径 */
	@Column(name = "filePath")
	private String filePath ;
	/** 属性文件类型/文件类型 */
	@Column(name = "fileType")
	private String fileType ;
	/** 属性影像资料描述/影像资料描述 */
	@Column(name = "description")
	private String description ;
	/** 属性上传操作员代码/上传操作员代码 */
	@Column(name = "operatorCode")
	private String operatorCode ;
	/** 属性上传操作员姓名/上传操作员姓名 */
	@Column(name = "operatorName")
	private String operatorName ;
	/** 属性上传时间/上传时间 */
	@Column(name = "operateTime")
	private String operateTime ;
	/** 属性删除标志位 1正常 0已删除/删除标志位 1正常 0已删除 */
	@Column(name = "flag")
	private String flag ;
	/** 属性影像资料大小/影像资料大小 */
	@Column(name = "fileSize")
	private Integer fileSize ;
	/** 属性删除时间/删除时间 */
	@Column(name = "deleteDate")
	private String deleteDate ;
	/** 属性删除操作员代码/删除操作员代码 */
	@Column(name = "deleteUserCode")
	private String deleteUserCode ;
	/** 属性删除操作员姓名/删除操作员姓名 */
	@Column(name = "deleteUserName")
	private String deleteUserName ;
	/**
	 * 属性业务号/业务号的getter方法
	 */
	public String getBusinessNo() {
		return businessNo;
	}
	/**
	 * 属性业务号/业务号的setter方法
	 */
	public void setBusinessNo(String businessNo) {
		this.businessNo = businessNo;
	} 	
	/**
	 * 属性序号/序号的getter方法
	 */
	public Integer getSerialNo() {
		return serialNo;
	}
	/**
	 * 属性序号/序号的setter方法
	 */
	public void setSerialNo(Integer serialNo) {
		this.serialNo = serialNo;
	} 	
	/**
	 * 属性保单号/保单号的getter方法
	 */
	public String getPolicyNo() {
		return policyNo;
	}
	/**
	 * 属性保单号/保单号的setter方法
	 */
	public void setPolicyNo(String policyNo) {
		this.policyNo = policyNo;
	} 	
	/**
	 * 属性单证类型/单证类型的getter方法
	 */
	public String getTypeCode() {
		return typeCode;
	}
	/**
	 * 属性单证类型/单证类型的setter方法
	 */
	public void setTypeCode(String typeCode) {
		this.typeCode = typeCode;
	} 	
	/**
	 * 属性单证名称/单证名称的getter方法
	 */
	public String getPicName() {
		return picName;
	}
	/**
	 * 属性单证名称/单证名称的setter方法
	 */
	public void setPicName(String picName) {
		this.picName = picName;
	} 	
	/**
	 * 属性系统文件名/系统文件名的getter方法
	 */
	public String getSysFileName() {
		return sysFileName;
	}
	/**
	 * 属性系统文件名/系统文件名的setter方法
	 */
	public void setSysFileName(String sysFileName) {
		this.sysFileName = sysFileName;
	} 	
	/**
	 * 属性影像资料名称/影像资料名称的getter方法
	 */
	public String getFileName() {
		return fileName;
	}
	/**
	 * 属性影像资料名称/影像资料名称的setter方法
	 */
	public void setFileName(String fileName) {
		this.fileName = fileName;
	} 	
	/**
	 * 属性文件保存绝对路径/文件保存绝对路径的getter方法
	 */
	public String getFilePath() {
		return filePath;
	}
	/**
	 * 属性文件保存绝对路径/文件保存绝对路径的setter方法
	 */
	public void setFilePath(String filePath) {
		this.filePath = filePath;
	} 	
	/**
	 * 属性文件类型/文件类型的getter方法
	 */
	public String getFileType() {
		return fileType;
	}
	/**
	 * 属性文件类型/文件类型的setter方法
	 */
	public void setFileType(String fileType) {
		this.fileType = fileType;
	} 	
	/**
	 * 属性影像资料描述/影像资料描述的getter方法
	 */
	public String getDescription() {
		return description;
	}
	/**
	 * 属性影像资料描述/影像资料描述的setter方法
	 */
	public void setDescription(String description) {
		this.description = description;
	} 	
	/**
	 * 属性上传操作员代码/上传操作员代码的getter方法
	 */
	public String getOperatorCode() {
		return operatorCode;
	}
	/**
	 * 属性上传操作员代码/上传操作员代码的setter方法
	 */
	public void setOperatorCode(String operatorCode) {
		this.operatorCode = operatorCode;
	} 	
	/**
	 * 属性上传操作员姓名/上传操作员姓名的getter方法
	 */
	public String getOperatorName() {
		return operatorName;
	}
	/**
	 * 属性上传操作员姓名/上传操作员姓名的setter方法
	 */
	public void setOperatorName(String operatorName) {
		this.operatorName = operatorName;
	} 	
	/**
	 * 属性上传时间/上传时间的getter方法
	 */
	public String getOperateTime() {
		return operateTime;
	}
	/**
	 * 属性上传时间/上传时间的setter方法
	 */
	public void setOperateTime(String operateTime) {
		this.operateTime = operateTime;
	} 	
	/**
	 * 属性删除标志位 1正常 0已删除/删除标志位 1正常 0已删除的getter方法
	 */
	public String getFlag() {
		return flag;
	}
	/**
	 * 属性删除标志位 1正常 0已删除/删除标志位 1正常 0已删除的setter方法
	 */
	public void setFlag(String flag) {
		this.flag = flag;
	} 	
	/**
	 * 属性影像资料大小/影像资料大小的getter方法
	 */
	public Integer getFileSize() {
		return fileSize;
	}
	/**
	 * 属性影像资料大小/影像资料大小的setter方法
	 */
	public void setFileSize(Integer fileSize) {
		this.fileSize = fileSize;
	} 	
	/**
	 * 属性删除时间/删除时间的getter方法
	 */
	public String getDeleteDate() {
		return deleteDate;
	}
	/**
	 * 属性删除时间/删除时间的setter方法
	 */
	public void setDeleteDate(String deleteDate) {
		this.deleteDate = deleteDate;
	} 	
	/**
	 * 属性删除操作员代码/删除操作员代码的getter方法
	 */
	public String getDeleteUserCode() {
		return deleteUserCode;
	}
	/**
	 * 属性删除操作员代码/删除操作员代码的setter方法
	 */
	public void setDeleteUserCode(String deleteUserCode) {
		this.deleteUserCode = deleteUserCode;
	} 	
	/**
	 * 属性删除操作员姓名/删除操作员姓名的getter方法
	 */
	public String getDeleteUserName() {
		return deleteUserName;
	}
	/**
	 * 属性删除操作员姓名/删除操作员姓名的setter方法
	 */
	public void setDeleteUserName(String deleteUserName) {
		this.deleteUserName = deleteUserName;
	} 	
}