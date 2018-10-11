package com.sinosoft.dms.core.dict.entity;

import com.sinosoft.framework.core.dao.BasePKImpl;
import javax.persistence.*;

/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-10-28 10:26:37.210 
 * prpTownCode主键操作对象
 */
public class PrpTownCodeKey extends BasePKImpl{
	private static final long serialVersionUID = 1L;
	public PrpTownCodeKey(){}
	public PrpTownCodeKey(String codeCode){
		this.codeCode = codeCode;
	}
	/** 属性代码/代码 */
	@Column(name = "codeCode")
	private String codeCode ;
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
}