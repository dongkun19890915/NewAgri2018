package com.sinosoft.dms.core.dict.entity;

import com.sinosoft.framework.core.dao.BasePKImpl;
import javax.persistence.*;

/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-11-05 01:01:20.710 
 * 通用代码表主键操作对象
 */
public class PrpDcodeKey extends BasePKImpl{
	private static final long serialVersionUID = 1L;
	public PrpDcodeKey(){}
	public PrpDcodeKey(String codeType,String codeCode){
		this.codeType = codeType;
		this.codeCode = codeCode;
	}
	/** 属性代码类型(见PrpDtype表)/代码类型(见PrpDtype表) */
	@Column(name = "codeType")
	private String codeType ;
	/** 属性业务代码/业务代码 */
	@Column(name = "codeCode")
	private String codeCode ;
	/**
	 * 属性代码类型(见PrpDtype表)/代码类型(见PrpDtype表)的getter方法
	 */
	public String getCodeType() {
    		return codeType;
	}
	/**
	 * 属性代码类型(见PrpDtype表)/代码类型(见PrpDtype表)的setter方法
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