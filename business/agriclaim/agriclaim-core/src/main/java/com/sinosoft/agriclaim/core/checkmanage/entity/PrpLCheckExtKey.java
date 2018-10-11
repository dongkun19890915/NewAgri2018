package com.sinosoft.agriclaim.core.checkmanage.entity;

import com.sinosoft.framework.core.dao.BasePKImpl;
import javax.persistence.*;

/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-11-08 05:38:49.324 
 * 查勘/代查勘扩展表主键操作对象
 */
public class PrpLCheckExtKey extends BasePKImpl{
	private static final long serialVersionUID = 1L;
	public PrpLCheckExtKey(){}
	public PrpLCheckExtKey(String registNo,java.lang.Integer serialNo,String columnName,java.lang.Integer referSerialNo){
		this.registNo = registNo;
		this.serialNo = serialNo;
		this.columnName = columnName;
		this.referSerialNo = referSerialNo;
	}
	/** 属性报案号码/报案号码 */
	@Column(name = "registNo")
	private String registNo ;
	/** 属性序号/序号 */
	@Column(name = "serialNo")
	private java.lang.Integer serialNo ;
	/** 属性查勘项目代码/查勘项目代码 */
	@Column(name = "columnName")
	private String columnName ;
	/** 属性关联理赔车辆序号/关联理赔车辆序号 */
	@Column(name = "referSerialNo")
	private java.lang.Integer referSerialNo ;
	/**
	 * 属性报案号码/报案号码的getter方法
	 */
	public String getRegistNo() {
    		return registNo;
	}
	/**
	 * 属性报案号码/报案号码的setter方法
	 */
	public void setRegistNo(String registNo) {
		this.registNo = registNo;
	} 
	/**
	 * 属性序号/序号的getter方法
	 */
	public java.lang.Integer getSerialNo() {
    		return serialNo;
	}
	/**
	 * 属性序号/序号的setter方法
	 */
	public void setSerialNo(java.lang.Integer serialNo) {
		this.serialNo = serialNo;
	} 
	/**
	 * 属性查勘项目代码/查勘项目代码的getter方法
	 */
	public String getColumnName() {
    		return columnName;
	}
	/**
	 * 属性查勘项目代码/查勘项目代码的setter方法
	 */
	public void setColumnName(String columnName) {
		this.columnName = columnName;
	} 
	/**
	 * 属性关联理赔车辆序号/关联理赔车辆序号的getter方法
	 */
	public java.lang.Integer getReferSerialNo() {
    		return referSerialNo;
	}
	/**
	 * 属性关联理赔车辆序号/关联理赔车辆序号的setter方法
	 */
	public void setReferSerialNo(java.lang.Integer referSerialNo) {
		this.referSerialNo = referSerialNo;
	} 
}