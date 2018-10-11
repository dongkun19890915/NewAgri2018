package com.sinosoft.dms.core.dict.entity;

import com.sinosoft.framework.core.dao.BaseEntityImpl;
import javax.persistence.*;
import java.util.Date;

/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-11-05 01:01:20.710 
 * PrpCountryCode实体操作对象
 */
@Entity
@Table(name = "PrpCountryCode")
@IdClass(PrpCountryCodeKey.class)
public class PrpCountryCode extends BaseEntityImpl{
	private static final long serialVersionUID = 1L;
	/** 属性id/id */
	@Id
	@Column(name = "id")
	private Integer id ;
	/** 属性codetype/codetype */
	@Column(name = "codeType")
	private String codeType ;
	/** 属性codecode/codecode */
	@Column(name = "codeCode")
	private String codeCode ;
	/** 属性codecname/codecname */
	@Column(name = "codeCName")
	private String codeCName ;
	/** 属性上级代码/上级代码 */
	@Column(name = "upCode")
	private String upCode ;
	/** 属性update_date/update_date */
	@Column(name = "update_Date")
	private java.util.Date update_Date ;



	/**
	 * 属性codetype/codetype的getter方法
	 */
	public String getCodeType() {
		return codeType;
	}
	/**
	 * 属性codetype/codetype的setter方法
	 */
	public void setCodeType(String codeType) {
		this.codeType = codeType;
	} 	
	/**
	 * 属性codecode/codecode的getter方法
	 */
	public String getCodeCode() {
		return codeCode;
	}
	/**
	 * 属性codecode/codecode的setter方法
	 */
	public void setCodeCode(String codeCode) {
		this.codeCode = codeCode;
	} 	
	/**
	 * 属性codecname/codecname的getter方法
	 */
	public String getCodeCName() {
		return codeCName;
	}
	/**
	 * 属性codecname/codecname的setter方法
	 */
	public void setCodeCName(String codeCName) {
		this.codeCName = codeCName;
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

	public Date getUpdate_Date() {
		return update_Date;
	}

	public void setUpdate_Date(Date update_Date) {
		this.update_Date = update_Date;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
}