package com.sinosoft.ims.api.auth.dto;

import java.io.Serializable;

import com.sinosoft.framework.dto.BaseRequest;
/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-11-28 10:00:26.880 
 * 权限表Api操作对象
 */
public class PrpDpowerTableDto extends BaseRequest implements Serializable{
	private static final long serialVersionUID = 1L;
	/** 属性表名/表名 */
	private String tableName ;		
	/** 属性字段名/字段名 */
	private String tableColumn ;		
	/** 属性备用字段/备用字段 */
	private String flag ;		
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
	/**
	 * 属性备用字段/备用字段的getter方法
	 */
	public String getFlag() {
		return flag;
	}
	/**
	 * 属性备用字段/备用字段的setter方法
	 */
	public void setFlag(String flag) {
		this.flag = flag;
	}	
}
