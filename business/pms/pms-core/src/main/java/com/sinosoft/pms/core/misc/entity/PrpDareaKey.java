package com.sinosoft.pms.core.misc.entity;

import com.sinosoft.framework.core.dao.BasePKImpl;

/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-09-15 09:15:28.416 
 * 区域表主键操作对象
 */
public class PrpDareaKey extends BasePKImpl{
	private static final long serialVersionUID = 1L;
	public PrpDareaKey(){}
	public PrpDareaKey(String codeCode,String codeType,String areaCode){
		this.codeCode = codeCode;
		this.codeType = codeType;
		this.areaCode = areaCode;
	}
	/** 属性业务代码/业务代码 */
	private String codeCode ;
	/** 属性区域代码类型/区域代码类型 */
	private String codeType ;
	/** 属性区域代码/区域代码 */
	private String areaCode ;
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
	/**
	 * 属性区域代码类型/区域代码类型的getter方法
	 */
	public String getCodeType() {
    		return codeType;
	}
	/**
	 * 属性区域代码类型/区域代码类型的setter方法
	 */
	public void setCodeType(String codeType) {
		this.codeType = codeType;
	} 
	/**
	 * 属性区域代码/区域代码的getter方法
	 */
	public String getAreaCode() {
    		return areaCode;
	}
	/**
	 * 属性区域代码/区域代码的setter方法
	 */
	public void setAreaCode(String areaCode) {
		this.areaCode = areaCode;
	} 
}