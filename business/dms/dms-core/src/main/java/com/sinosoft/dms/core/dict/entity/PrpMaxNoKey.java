package com.sinosoft.dms.core.dict.entity;

import com.sinosoft.framework.core.dao.BasePKImpl;
import javax.persistence.*;

/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-11-05 01:02:29.563 
 * PrpMaxNo主键操作对象
 */
public class PrpMaxNoKey extends BasePKImpl{
	private static final long serialVersionUID = 1L;
	public PrpMaxNoKey(){}
	public PrpMaxNoKey(String groupNo,String tableName,String maxNo){
		this.groupNo = groupNo;
		this.tableName = tableName;
		this.maxNo = maxNo;
	}
	/** 属性groupno/groupno */
	@Column(name = "groupNo")
	private String groupNo ;
	/** 属性tablename/tablename */
	@Column(name = "tableName")
	private String tableName ;
	/** 属性maxno/maxno */
	@Column(name = "maxNo")
	private String maxNo ;
	/**
	 * 属性groupno/groupno的getter方法
	 */
	public String getGroupNo() {
    		return groupNo;
	}
	/**
	 * 属性groupno/groupno的setter方法
	 */
	public void setGroupNo(String groupNo) {
		this.groupNo = groupNo;
	} 
	/**
	 * 属性tablename/tablename的getter方法
	 */
	public String getTableName() {
    		return tableName;
	}
	/**
	 * 属性tablename/tablename的setter方法
	 */
	public void setTableName(String tableName) {
		this.tableName = tableName;
	} 
	/**
	 * 属性maxno/maxno的getter方法
	 */
	public String getMaxNo() {
    		return maxNo;
	}
	/**
	 * 属性maxno/maxno的setter方法
	 */
	public void setMaxNo(String maxNo) {
		this.maxNo = maxNo;
	} 
}