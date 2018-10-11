package com.sinosoft.dms.core.dict.entity;

import com.sinosoft.framework.core.dao.BasePKImpl;
import javax.persistence.*;

/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-11-05 01:02:29.563 
 * UtiProductAttr主键操作对象
 */
public class UtiProductAttrKey extends BasePKImpl{
	private static final long serialVersionUID = 1L;
	public UtiProductAttrKey(){}
	public UtiProductAttrKey(String attrCode){
		this.attrCode = attrCode;
	}
	/** 属性attrCode/attrCode */
	@Column(name = "attrCode")
	private String attrCode ;
	/**
	 * 属性attrCode/attrCode的getter方法
	 */
	public String getAttrCode() {
    		return attrCode;
	}
	/**
	 * 属性attrCode/attrCode的setter方法
	 */
	public void setAttrCode(String attrCode) {
		this.attrCode = attrCode;
	} 
}