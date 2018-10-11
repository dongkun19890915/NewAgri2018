package com.sinosoft.dms.core.dict.entity;

import com.sinosoft.framework.core.dao.BasePKImpl;
import javax.persistence.*;

/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-11-05 01:02:29.563 
 * UtiKey主键操作对象
 */
public class UtiKeyKey extends BasePKImpl{
	private static final long serialVersionUID = 1L;
	public UtiKeyKey(){}
	public UtiKeyKey(String tablEName){
		this.tableName = tablEName;
	}
	/** 属性tableName/tableName */
	@Column(name = "tableName")
	private String tableName ;

	public String getTableName() {
		return tableName;
	}

	public void setTableName(String tableName) {
		this.tableName = tableName;
	}
}