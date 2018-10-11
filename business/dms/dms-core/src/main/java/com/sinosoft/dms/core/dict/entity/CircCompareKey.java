package com.sinosoft.dms.core.dict.entity;

import com.sinosoft.framework.core.dao.BasePKImpl;
import javax.persistence.*;

/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-11-05 01:01:20.710 
 * 批改类型主键操作对象
 */
public class CircCompareKey extends BasePKImpl{
	private static final long serialVersionUID = 1L;
	public CircCompareKey(){}
	public CircCompareKey(String codeType,String businessCode,String circCode){
		this.codeType = codeType;
		this.businessCode = businessCode;
		this.circCode = circCode;
	}
	/** 属性批改类型代码/批改类型代码 */
	@Column(name = "codeType")
	private String codeType ;
	/** 属性业务操作代码/业务操作代码 */
	@Column(name = "businessCode")
	private String businessCode ;
	/** 属性circCode/circCode */
	@Column(name = "circCode")
	private String circCode ;
	/**
	 * 属性批改类型代码/批改类型代码的getter方法
	 */
	public String getCodeType() {
    		return codeType;
	}
	/**
	 * 属性批改类型代码/批改类型代码的setter方法
	 */
	public void setCodeType(String codeType) {
		this.codeType = codeType;
	} 
	/**
	 * 属性业务操作代码/业务操作代码的getter方法
	 */
	public String getBusinessCode() {
    		return businessCode;
	}
	/**
	 * 属性业务操作代码/业务操作代码的setter方法
	 */
	public void setBusinessCode(String businessCode) {
		this.businessCode = businessCode;
	} 
	/**
	 * 属性circCode/circCode的getter方法
	 */
	public String getCircCode() {
    		return circCode;
	}
	/**
	 * 属性circCode/circCode的setter方法
	 */
	public void setCircCode(String circCode) {
		this.circCode = circCode;
	} 
}