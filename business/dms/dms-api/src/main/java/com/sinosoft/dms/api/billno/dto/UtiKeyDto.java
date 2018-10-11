package com.sinosoft.dms.api.billno.dto;

import com.sinosoft.framework.dto.BaseRequest;

import java.io.Serializable;

/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-10-10 12:51:20.949 
 * UtiKeyApi操作对象
 */
public class UtiKeyDto extends BaseRequest implements Serializable{
	private static final long serialVersionUID = 1L;
	/** 属性tableName/tableName */
	private String tableName ;		
	/** 属性fieldName/fieldName */
	private String fieldName ;		
	/** 属性fieldMeaning/fieldMeaning */
	private String fieldMeaning ;		
	/** 属性collength/collength */
	private Integer collength ;
	/** 属性headId/headId */
	private String headId ;		
	/** 属性flag/flag */
	private String flag ;		
	/** 属性createDBy/createDBy */
	private String createDBy ;		
	/** 属性createDTime/createDTime */
	private java.util.Date createDTime ;		
	/** 属性updateDBy/updateDBy */
	private String updateDBy ;		
	/** 属性updateDTime/updateDTime */
	private java.util.Date updateDTime ;		
	/**
	 * 属性tableName/tableName的getter方法
	 */
	public String getTableName() {
		return tableName;
	}
	/**
	 * 属性tableName/tableName的setter方法
	 */
	public void setTableName(String tableName) {
		this.tableName = tableName;
	}	
	/**
	 * 属性fieldName/fieldName的getter方法
	 */
	public String getFieldName() {
		return fieldName;
	}
	/**
	 * 属性fieldName/fieldName的setter方法
	 */
	public void setFieldName(String fieldName) {
		this.fieldName = fieldName;
	}	
	/**
	 * 属性fieldMeaning/fieldMeaning的getter方法
	 */
	public String getFieldMeaning() {
		return fieldMeaning;
	}
	/**
	 * 属性fieldMeaning/fieldMeaning的setter方法
	 */
	public void setFieldMeaning(String fieldMeaning) {
		this.fieldMeaning = fieldMeaning;
	}	
	/**
	 * 属性collength/collength的getter方法
	 */
	public Integer getCollength() {
		return collength;
	}
	/**
	 * 属性collength/collength的setter方法
	 */
	public void setCollength(Integer collength) {
		this.collength = collength;
	}	
	/**
	 * 属性headId/headId的getter方法
	 */
	public String getHeadId() {
		return headId;
	}
	/**
	 * 属性headId/headId的setter方法
	 */
	public void setHeadId(String headId) {
		this.headId = headId;
	}	
	/**
	 * 属性flag/flag的getter方法
	 */
	public String getFlag() {
		return flag;
	}
	/**
	 * 属性flag/flag的setter方法
	 */
	public void setFlag(String flag) {
		this.flag = flag;
	}	
	/**
	 * 属性createDBy/createDBy的getter方法
	 */
	public String getCreateDBy() {
		return createDBy;
	}
	/**
	 * 属性createDBy/createDBy的setter方法
	 */
	public void setCreateDBy(String createDBy) {
		this.createDBy = createDBy;
	}	
	/**
	 * 属性createDTime/createDTime的getter方法
	 */
	public java.util.Date getCreateDTime() {
		return createDTime;
	}
	/**
	 * 属性createDTime/createDTime的setter方法
	 */
	public void setCreateDTime(java.util.Date createDTime) {
		this.createDTime = createDTime;
	}	
	/**
	 * 属性updateDBy/updateDBy的getter方法
	 */
	public String getUpdateDBy() {
		return updateDBy;
	}
	/**
	 * 属性updateDBy/updateDBy的setter方法
	 */
	public void setUpdateDBy(String updateDBy) {
		this.updateDBy = updateDBy;
	}	
	/**
	 * 属性updateDTime/updateDTime的getter方法
	 */
	public java.util.Date getUpdateDTime() {
		return updateDTime;
	}
	/**
	 * 属性updateDTime/updateDTime的setter方法
	 */
	public void setUpdateDTime(java.util.Date updateDTime) {
		this.updateDTime = updateDTime;
	}	
}
