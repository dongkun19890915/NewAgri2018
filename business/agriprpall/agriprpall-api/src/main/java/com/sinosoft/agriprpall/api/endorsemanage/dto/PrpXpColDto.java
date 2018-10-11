package com.sinosoft.agriprpall.api.endorsemanage.dto;

import java.io.Serializable;

import com.sinosoft.framework.dto.BaseRequest;
/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-11-06 06:23:40.452 
 * 批文数据字典表Api操作对象
 */
public class PrpXpColDto extends BaseRequest implements Serializable{
	private static final long serialVersionUID = 1L;
	/** 属性险种代码/险种代码 */
	private String riskCode ;		
	/** 属性数据表名/数据表名 */
	private String tableName ;		
	/** 属性字段顺序/字段顺序 */
	private Integer colSeq ;
	/** 属性字段名/字段名 */
	private String colName ;		
	/** 属性显示顺序/显示顺序 */
	private Integer dispSeq ;
	/** 属性字段中文说明/字段中文说明 */
	private String colCName ;		
	/** 属性字段英文说明/字段英文说明 */
	private String colEName ;		
	/** 属性标志字段/标志字段 */
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
