package com.sinosoft.dms.api.dict.dto;

import java.io.Serializable;

import com.sinosoft.framework.dto.BaseRequest;
/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-11-05 01:02:29.563 
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

	public String getTableName() {
		return tableName;
	}

	public void setTableName(String tableName) {
		this.tableName = tableName;
	}

	/** 属性colLength/colLength */
	private java.lang.Integer collEngth ;		
	/** 属性headId/headId */
	private String headId ;
	/** 属性flag/flag */
	private String flag ;
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
	 * 属性colLength/colLength的getter方法
	 */
	public java.lang.Integer getCollEngth() {
		return collEngth;
	}
	/**
	 * 属性colLength/colLength的setter方法
	 */
	public void setCollEngth(java.lang.Integer collEngth) {
		this.collEngth = collEngth;
	}

	public String getHeadId() {
		return headId;
	}

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
}
