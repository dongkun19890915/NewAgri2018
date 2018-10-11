package com.sinosoft.agriprpall.core.endorsemanage.commonendorse.entity;

import com.sinosoft.framework.core.dao.BaseEntityImpl;

import javax.persistence.*;

/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-11-06 06:23:40.452 
 * 批文数据字典表实体操作对象
 */
@Entity
@Table(name = "PrpXpCol")
@IdClass(PrpXpColKey.class)
public class PrpXpCol extends BaseEntityImpl{

	private static final long serialVersionUID = 1L;
	/** 属性险种代码/险种代码 */
	@Id
	@Column(name = "riskCode")
	private String riskCode ;/** 属性数据表名/数据表名 */
	@Id
	@Column(name = "tableName")
	private String tableName ;/** 属性字段顺序/字段顺序 */
	@Id
	@Column(name = "colSeq")
	private Integer colSeq ;/** 属性显示顺序/显示顺序 */
	@Id
	@Column(name = "dispSeq")
	private Integer dispSeq ;



	/** 属性字段名/字段名 */
	@Column(name = "colName")
	private String colName ;

	/** 属性字段中文说明/字段中文说明 */
	@Column(name = "colCName")
	private String colCName ;
	/** 属性字段英文说明/字段英文说明 */
	@Column(name = "colEName")
	private String colEName ;
	/** 属性标志字段/标志字段 */
	@Column(name = "flag")
	private String flag ;
	/**
	 * 属性险种代码/险种代码的getter方法
	 */
	public String getRiskCode() {
		return riskCode;
	}
	/**
	 * 属性险种代码/险种代码的setter方法
	 */
	public void setRiskCode(String riskCode) {
		this.riskCode = riskCode;
	}
	/**
	 * 属性数据表名/数据表名的getter方法
	 */
	public String getTableName() {
		return tableName;
	}
	/**
	 * 属性数据表名/数据表名的setter方法
	 */
	public void setTableName(String tableName) {
		this.tableName = tableName;
	}
	/**
	 * 属性字段顺序/字段顺序的getter方法
	 */
	public Integer getColSeq() {
		return colSeq;
	}
	/**
	 * 属性字段顺序/字段顺序的setter方法
	 */
	public void setColSeq(Integer colSeq) {
		this.colSeq = colSeq;
	}
	/**
	 * 属性字段名/字段名的getter方法
	 */
	public String getColName() {
		return colName;
	}
	/**
	 * 属性字段名/字段名的setter方法
	 */
	public void setColName(String colName) {
		this.colName = colName;
	}
	/**
	 * 属性显示顺序/显示顺序的getter方法
	 */
	public Integer getDispSeq() {
		return dispSeq;
	}
	/**
	 * 属性显示顺序/显示顺序的setter方法
	 */
	public void setDispSeq(Integer dispSeq) {
		this.dispSeq = dispSeq;
	} 	
	/**
	 * 属性字段中文说明/字段中文说明的getter方法
	 */
	public String getColCName() {
		return colCName;
	}
	/**
	 * 属性字段中文说明/字段中文说明的setter方法
	 */
	public void setColCName(String colCName) {
		this.colCName = colCName;
	} 	
	/**
	 * 属性字段英文说明/字段英文说明的getter方法
	 */
	public String getColEName() {
		return colEName;
	}
	/**
	 * 属性字段英文说明/字段英文说明的setter方法
	 */
	public void setColEName(String colEName) {
		this.colEName = colEName;
	} 	
	/**
	 * 属性标志字段/标志字段的getter方法
	 */
	public String getFlag() {
		return flag;
	}
	/**
	 * 属性标志字段/标志字段的setter方法
	 */
	public void setFlag(String flag) {
		this.flag = flag;
	} 	
}