package com.sinosoft.dms.core.dict.entity;

import com.sinosoft.framework.core.dao.BaseEntityImpl;
import javax.persistence.*;
import java.util.Date;

/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-11-05 01:02:29.563 
 * UtiKey实体操作对象
 */
@Entity
@Table(name = "UtiKey")
@IdClass(UtiKeyKey.class)
public class UtiKey extends BaseEntityImpl{

	private static final long serialVersionUID = 1L;
	/** 属性tableName/tableName */
	@Id
	@Column(name = "tableName")
	private String tableName ;

	/** 属性fieldName/fieldName */
	@Column(name = "fieldName")
	private String fieldName ;
	/** 属性fieldMeaning/fieldMeaning */
	@Column(name = "fieldMeaning")
	private String fieldMeaning ;
	/** 属性colLength/colLength */
	@Column(name = "collEngth")
	private java.lang.Integer collEngth ;
	/** 属性headId/headId */
	@Column(name = "headId")
	private String headId ;
	/** 属性flag/flag */
	@Column(name = "flag")
	private String flag ;

	public String getTableName() {
		return tableName;
	}

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