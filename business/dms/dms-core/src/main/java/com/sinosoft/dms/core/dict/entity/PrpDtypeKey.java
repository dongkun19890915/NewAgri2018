package com.sinosoft.dms.core.dict.entity;

import com.sinosoft.framework.core.dao.BasePKImpl;
import javax.persistence.*;

/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-11-05 01:02:29.563 
 * 通用代码类表主键操作对象
 */
public class PrpDtypeKey extends BasePKImpl{
	private static final long serialVersionUID = 1L;
	public PrpDtypeKey(){}
	public PrpDtypeKey(String codeType){
		this.codeType = codeType;
	}
	/** 属性代码类型/代码类型 */
	@Column(name = "codeType")
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