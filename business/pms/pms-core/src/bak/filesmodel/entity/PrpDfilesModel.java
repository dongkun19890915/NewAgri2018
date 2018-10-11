package com.sinosoft.pms.core.filesmodel.entity;

import com.sinosoft.framework.core.dao.BaseEntity;
import com.sinosoft.framework.core.dao.BaseEntityImpl;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @author codegen@研发中心
 * @mail handongwei@sinosoft.com.cn
 * @time  2016-09-19 10:53:22.125 
 * PrpDexcelModel   基础数据对象
 */
@Entity
@Table(name = "prpdfilesmodel")
@IdClass(PrpDfilesModelKey.class)
public class PrpDfilesModel implements BaseEntity,Serializable {
	private static final long serialVersionUID = 1L;

	/** 属性RiskCode/产品 */
	@Id
	@Column(name = "riskCode")
	private String riskCode ;
	/** 属性ModelType/模板类型 */
	@Id
	@Column(name = "modelType")
	private String modelType ;

	/** 属性ModelName/模板文件名 */
	private String modelName ;
	/** 属性ModelUrl/下载地址 */
	private String modelUrl ;
	/** 属性CreateTime/审计字段：创建时间 */
	private java.util.Date createTime ;
	/** 属性CreateBy/审计字段：创建人 */
	private String createBy ;
	/** 属性UploadTime/审计字段：更新时间 */
	private java.util.Date uploadTime ;
	/** 属性UpdateBy/审计字段：更新人 */
	private String updateBy ;
	/** 属性Flag/备注 */
	private String flag ;
	/**
	 * 类PrpDexcelModel的默认构造方法
	 */
	public PrpDfilesModel() {
	}


	/**
	 * 属性ModelName/模板文件名的getter方法
	 */
	public String getModelName() {
		return modelName;
	}
	/**
	 * 属性ModelName/模板文件名的setter方法
	 */
	public void setModelName(String modelName) {
		this.modelName = modelName;
	} 
	/**
	 * 属性ModelUrl/下载地址的getter方法
	 */
	public String getModelUrl() {
		return modelUrl;
	}
	/**
	 * 属性ModelUrl/下载地址的setter方法
	 */
	public void setModelUrl(String modelUrl) {
		this.modelUrl = modelUrl;
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
	 * 属性UploadTime/审计字段：更新时间的getter方法
	 */
	public java.util.Date getUploadTime() {
		return uploadTime;
	}
	/**
	 * 属性UploadTime/审计字段：更新时间的setter方法
	 */
	public void setUploadTime(java.util.Date uploadTime) {
		this.uploadTime = uploadTime;
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
	 * 属性Flag/备注的getter方法
	 */
	public String getFlag() {
		return flag;
	}
	/**
	 * 属性Flag/备注的setter方法
	 */
	public void setFlag(String flag) {
		this.flag = flag;
	}

	/*
    * 属性riskCode的getter方法
    */
	public String getRiskCode() {
		return riskCode;
	}

	/*
    * 属性riskCode的setter方法
    */
	public void setRiskCode(String riskCode) {
		this.riskCode = riskCode;
	}

	/*
    * 属性modelType的getter方法
    */
	public String getModelType() {
		return modelType;
	}

	/*
    * 属性modelType的setter方法
    */
	public void setModelType(String modelType) {
		this.modelType = modelType;
	}
}