package com.sinosoft.dms.core.dict.entity;

import com.sinosoft.framework.core.dao.BasePKImpl;

/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-08-22 03:00:01.505 
 * 通用代码类表主键操作对象
 */
public class PrpDnewTypeKey extends BasePKImpl{
	private static final long serialVersionUID = 1L;
	public PrpDnewTypeKey(){}
	public PrpDnewTypeKey(String codeType){
		this.codeType = codeType;
	}
	/** 属性代码类型/代码类型 */
	private String codeType ;
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
}