package com.sinosoft.dms.core.dict.entity;

import com.sinosoft.framework.core.dao.BasePKImpl;

/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-08-22 03:00:01.505 
 * 通用代码表主键操作对象
 */
public class PrpDnewCodeKey extends BasePKImpl{
	private static final long serialVersionUID = 1L;
	public PrpDnewCodeKey(){}
	public PrpDnewCodeKey(String codeType,String codeCode){
		this.codeType = codeType;
		this.codeCode = codeCode;
	}
	/** 属性代码类型/代码类型 */
	private String codeType ;
	/** 属性业务代码/业务代码 */
	private String codeCode ;
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
	 * 属性业务代码/业务代码的getter方法
	 */
	public String getCodeCode() {
    		return codeCode;
	}
	/**
	 * 属性业务代码/业务代码的setter方法
	 */
	public void setCodeCode(String codeCode) {
		this.codeCode = codeCode;
	} 
}