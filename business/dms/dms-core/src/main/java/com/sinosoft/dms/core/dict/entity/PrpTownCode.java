package com.sinosoft.dms.core.dict.entity;

import com.sinosoft.framework.core.dao.BaseEntityImpl;
import javax.persistence.*;

/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-10-28 10:26:37.210 
 * prpTownCode实体操作对象
 */
@Entity
@Table(name = "prpTownCode")
@IdClass(PrpTownCodeKey.class)
public class PrpTownCode extends BaseEntityImpl{

	private static final long serialVersionUID = 1L;
	/** 属性代码/代码 */
	@Id
	@Column(name = "codeCode")
	private String codeCode ;	
	/** 属性代码类型/代码类型 */
	@Column(name = "codeType")
	private String codeType ;

	/** 属性名称/名称 */
	@Column(name = "codeCname")
	private String codeCname ;
	/** 属性上级代码/上级代码 */
	@Column(name = "upCode")
	private String upCode ;
	/** 属性更新时间/更新时间 */
	@Column(name = "update_Date")
	private java.util.Date updateDate ;
	/**
	 * 属性代码类型/代码类型的getter方法
	 */
	public String getCodeType() {
		return codeType;
	}
	/**
	 * 属性代码类型/代码类型的setter方法
	 */
	public void setCodeType(String codeType) {
		this.codeType = codeType;
	} 	
	/**
	 * 属性代码/代码的getter方法
	 */
	public String getCodeCode() {
		return codeCode;
	}
	/**
	 * 属性代码/代码的setter方法
	 */
	public void setCodeCode(String codeCode) {
		this.codeCode = codeCode;
	} 	
	/**
	 * 属性名称/名称的getter方法
	 */
	public String getCodeCname() {
		return codeCname;
	}
	/**
	 * 属性名称/名称的setter方法
	 */
	public void setCodeCname(String codeCname) {
		this.codeCname = codeCname;
	} 	
	/**
	 * 属性上级代码/上级代码的getter方法
	 */
	public String getUpCode() {
		return upCode;
	}
	/**
	 * 属性上级代码/上级代码的setter方法
	 */
	public void setUpCode(String upCode) {
		this.upCode = upCode;
	} 	
	/**
	 * 属性更新时间/更新时间的getter方法
	 */
	public java.util.Date getUpdateDate() {
		return updateDate;
	}
	/**
	 * 属性更新时间/更新时间的setter方法
	 */
	public void setUpdateDate(java.util.Date updateDate) {
		this.updateDate = updateDate;
	} 	
}