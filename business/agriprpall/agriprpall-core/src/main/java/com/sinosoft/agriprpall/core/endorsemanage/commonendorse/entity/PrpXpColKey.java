package com.sinosoft.agriprpall.core.endorsemanage.commonendorse.entity;

import com.sinosoft.framework.core.dao.BasePKImpl;

import javax.persistence.Column;

/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-11-06 06:23:40.452 
 * 批文数据字典表主键操作对象
 */
public class PrpXpColKey extends BasePKImpl{
	private static final long serialVersionUID = 1L;
	public PrpXpColKey(){}
	public PrpXpColKey(String riskCode,String tableName,Integer colSeq,Integer dispSeq){
		this.riskCode = riskCode;
		this.tableName = tableName;
		this.colSeq = colSeq;
		this.dispSeq = dispSeq;
	}
	/** 属性险种代码/险种代码 */
	@Column(name = "riskCode")
	private String riskCode ;
	/** 属性数据表名/数据表名 */
	@Column(name = "tableName")
	private String tableName ;
	/** 属性字段顺序/字段顺序 */
	@Column(name = "colSeq")
	private Integer colSeq ;
	/** 属性显示顺序/显示顺序 */
	@Column(name = "dispSeq")
	private Integer dispSeq ;
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
}