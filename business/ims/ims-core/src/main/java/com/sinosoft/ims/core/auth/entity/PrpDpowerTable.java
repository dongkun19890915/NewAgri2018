package com.sinosoft.ims.core.auth.entity;

import com.sinosoft.framework.core.dao.BaseEntityImpl;
import javax.persistence.*;
import java.util.Date;

/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-11-28 10:00:26.880 
 * 权限表实体操作对象
 */
@Entity
@Table(name = "prpDpowerTable")
@IdClass(PrpDpowerTableKey.class)
public class PrpDpowerTable extends BaseEntityImpl{

	private static final long serialVersionUID = 1L;
	/** 属性表名/表名 */
	@Id
	@Column(name = "tableName")
	private String tableName ;/** 属性字段名/字段名 */
	@Id
	@Column(name = "tableColumn")
	private String tableColumn ;	


	/** 属性备用字段/备用字段 */
	@Column(name = "flag")
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