package com.sinosoft.agriclaim.core.endcasemanage.entity;

import com.sinosoft.framework.core.dao.BasePKImpl;
import javax.persistence.*;

/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-11-08 05:42:04.174 
 * 结案基本信息表主键操作对象
 */
public class PrpLEndCaseListKey extends BasePKImpl{
	private static final long serialVersionUID = 1L;
	public PrpLEndCaseListKey(){}
	public PrpLEndCaseListKey(java.lang.Integer id){
		this.id = id;
	}
	/** 属性id主键/id主键 */
	@Column(name = "id")
	private java.lang.Integer id ;
	/**
	 * 属性id主键/id主键的getter方法
	 */
	public java.lang.Integer getId() {
    		return id;
	}
	/**
	 * 属性id主键/id主键的setter方法
	 */
	public void setId(java.lang.Integer id) {
		this.id = id;
	} 
}