package com.sinosoft.dms.api.dict.dto;

import java.io.Serializable;
import java.util.Date;

import com.sinosoft.framework.dto.BaseRequest;
/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-11-05 01:01:20.710 
 * PrpCountryCodeApi操作对象
 */
public class PrpCountryCodeDto extends BaseRequest implements Serializable{
	private static final long serialVersionUID = 1L;
	/** 属性codetype/codetype */
	private String codeType ;		
	/** 属性codecode/codecode */
	private String codeCode ;		
	/** 属性codecname/codecname */
	private String codeCName ;		
	/** 属性上级代码/上级代码 */
	private String upCode ;		
	/** 属性update_date/update_date */
	private java.util.Date update_Date ;
	/** 属性id/id */
	private Integer id ;

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
