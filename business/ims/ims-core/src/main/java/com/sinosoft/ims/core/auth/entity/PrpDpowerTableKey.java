package com.sinosoft.ims.core.auth.entity;

import com.sinosoft.framework.core.dao.BasePKImpl;
import javax.persistence.*;

/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-11-28 10:00:26.880 
 * 权限表主键操作对象
 */
public class PrpDpowerTableKey extends BasePKImpl{
	private static final long serialVersionUID = 1L;
	public PrpDpowerTableKey(){}
	public PrpDpowerTableKey(String tableName,String tableColumn){
		this.tableName = tableName;
		this.tableColumn = tableColumn;
	}
	/** 属性表名/表名 */
	@Column(name = "tableName")
	private String tableName ;
	/** 属性字段名/字段名 */
	@Column(name = "tableColumn")
	private String tableColumn ;
	/**
	 * 属性表名/表名的getter方法
	 */
	public String getTableName() {
    		return tableName;
	}
	/**
	 * 属性表名/表名的setter方法
	 */
	public void setTableName(String tableName) {
		this.tableName = tableName;
	} 
	/**
	 * 属性字段名/字段名的getter方法
	 */
	public String getTableColumn() {
    		return tableColumn;
	}
	/**
	 * 属性字段名/字段名的setter方法
	 */
	public void setTableColumn(String tableColumn) {
		this.tableColumn = tableColumn;
	} 
}