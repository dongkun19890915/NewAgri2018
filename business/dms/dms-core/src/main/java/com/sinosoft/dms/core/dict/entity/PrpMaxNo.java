package com.sinosoft.dms.core.dict.entity;

import com.sinosoft.framework.core.dao.BaseEntityImpl;
import javax.persistence.*;
import java.util.Date;

/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-11-05 01:02:29.563 
 * PrpMaxNo实体操作对象
 */
@Entity
@Table(name = "PrpMaxNo")
@IdClass(PrpMaxNoKey.class)
public class PrpMaxNo extends BaseEntityImpl{

	private static final long serialVersionUID = 1L;
	/** 属性groupno/groupno */
	@Id
	@Column(name = "groupNo")
	private String groupNo ;/** 属性tablename/tablename */
	@Id
	@Column(name = "tableName")
	private String tableName ;/** 属性maxno/maxno */
	@Id
	@Column(name = "maxNo")
	private String maxNo ;	



	/** 属性flag/flag */
	@Column(name = "flag")
	private String flag ;
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
	/**
	 * 属性flag/flag的getter方法
	 */
	public String getFlag() {
		return flag;
	}
	/**
	 * 属性flag/flag的setter方法
	 */
	public void setFlag(String flag) {
		this.flag = flag;
	} 	
}