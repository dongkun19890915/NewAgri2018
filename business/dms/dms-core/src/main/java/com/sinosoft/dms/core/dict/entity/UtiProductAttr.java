package com.sinosoft.dms.core.dict.entity;

import com.sinosoft.framework.core.dao.BaseEntityImpl;
import javax.persistence.*;
import java.util.Date;

/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-11-05 01:02:29.563 
 * UtiProductAttr实体操作对象
 */
@Entity
@Table(name = "UtiProductAttr")
@IdClass(UtiProductAttrKey.class)
public class UtiProductAttr extends BaseEntityImpl{

	private static final long serialVersionUID = 1L;
	/** 属性attrCode/attrCode */
	@Id
	@Column(name = "attrCode")
	private String attrCode ;	

	/** 属性attrName/attrName */
	@Column(name = "attrName")
	private String attrName ;
	/** 属性attrType/attrType */
	@Column(name = "attrType")
	private String attrType ;
	/** 属性referTable/referTable */
	@Column(name = "referTable")
	private String referTable ;
	/** 属性referTableName/referTableName */
	@Column(name = "referTableName")
	private String referTableName ;
	/** 属性referCodeType/referCodeType */
	@Column(name = "referCodeType")
	private String referCodeType ;
	/** 属性referCodeTypeName/referCodeTypeName */
	@Column(name = "referCodeTypeName")
	private String referCodeTypeName ;
	/** 属性validStatus/validStatus */
	@Column(name = "validStatus")
	private String validStatus ;
	/** 属性flag/flag */
	@Column(name = "flag")
	private String flag ;
	/**
	 * 属性attrCode/attrCode的getter方法
	 */
	public String getAttrCode() {
		return attrCode;
	}
	/**
	 * 属性attrCode/attrCode的setter方法
	 */
	public void setAttrCode(String attrCode) {
		this.attrCode = attrCode;
	} 	
	/**
	 * 属性attrName/attrName的getter方法
	 */
	public String getAttrName() {
		return attrName;
	}
	/**
	 * 属性attrName/attrName的setter方法
	 */
	public void setAttrName(String attrName) {
		this.attrName = attrName;
	} 	
	/**
	 * 属性attrType/attrType的getter方法
	 */
	public String getAttrType() {
		return attrType;
	}
	/**
	 * 属性attrType/attrType的setter方法
	 */
	public void setAttrType(String attrType) {
		this.attrType = attrType;
	} 	
	/**
	 * 属性referTable/referTable的getter方法
	 */
	public String getReferTable() {
		return referTable;
	}
	/**
	 * 属性referTable/referTable的setter方法
	 */
	public void setReferTable(String referTable) {
		this.referTable = referTable;
	} 	
	/**
	 * 属性referTableName/referTableName的getter方法
	 */
	public String getReferTableName() {
		return referTableName;
	}
	/**
	 * 属性referTableName/referTableName的setter方法
	 */
	public void setReferTableName(String referTableName) {
		this.referTableName = referTableName;
	} 	
	/**
	 * 属性referCodeType/referCodeType的getter方法
	 */
	public String getReferCodeType() {
		return referCodeType;
	}
	/**
	 * 属性referCodeType/referCodeType的setter方法
	 */
	public void setReferCodeType(String referCodeType) {
		this.referCodeType = referCodeType;
	} 	
	/**
	 * 属性referCodeTypeName/referCodeTypeName的getter方法
	 */
	public String getReferCodeTypeName() {
		return referCodeTypeName;
	}
	/**
	 * 属性referCodeTypeName/referCodeTypeName的setter方法
	 */
	public void setReferCodeTypeName(String referCodeTypeName) {
		this.referCodeTypeName = referCodeTypeName;
	} 	
	/**
	 * 属性validStatus/validStatus的getter方法
	 */
	public String getValidStatus() {
		return validStatus;
	}
	/**
	 * 属性validStatus/validStatus的setter方法
	 */
	public void setValidStatus(String validStatus) {
		this.validStatus = validStatus;
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