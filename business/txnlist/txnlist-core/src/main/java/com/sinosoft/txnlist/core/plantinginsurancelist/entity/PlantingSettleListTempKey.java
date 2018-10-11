package com.sinosoft.txnlist.core.plantinginsurancelist.entity;

import com.sinosoft.framework.core.dao.BasePKImpl;
import javax.persistence.*;

/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-11-18 08:36:26.740 
 * plantingsettlelisttemp主键操作对象
 */
public class PlantingSettleListTempKey extends BasePKImpl{
	private static final long serialVersionUID = 1L;
	public PlantingSettleListTempKey(){}
	public PlantingSettleListTempKey(String registCode,String stringTimeStamp,java.lang.Integer indexOfSettle){
		this.registCode = registCode;
		this.stringTimeStamp = stringTimeStamp;
		this.indexOfSettle = indexOfSettle;
	}
	/** 属性报案号（KEY）/报案号（KEY） */
	@Column(name = "registCode")
	private String registCode ;
	/** 属性时间戳（KEY）/时间戳（KEY） */
	@Column(name = "stringTimeStamp")
	private String stringTimeStamp ;
	/** 属性序列号（KEY）/序列号（KEY） */
	@Column(name = "indexOfSettle")
	private java.lang.Integer indexOfSettle ;
	/**
	 * 属性报案号（KEY）/报案号（KEY）的getter方法
	 */
	public String getRegistCode() {
    		return registCode;
	}
	/**
	 * 属性报案号（KEY）/报案号（KEY）的setter方法
	 */
	public void setRegistCode(String registCode) {
		this.registCode = registCode;
	} 
	/**
	 * 属性时间戳（KEY）/时间戳（KEY）的getter方法
	 */
	public String getStringTimeStamp() {
    		return stringTimeStamp;
	}
	/**
	 * 属性时间戳（KEY）/时间戳（KEY）的setter方法
	 */
	public void setStringTimeStamp(String stringTimeStamp) {
		this.stringTimeStamp = stringTimeStamp;
	} 
	/**
	 * 属性序列号（KEY）/序列号（KEY）的getter方法
	 */
	public java.lang.Integer getIndexOfSettle() {
    		return indexOfSettle;
	}
	/**
	 * 属性序列号（KEY）/序列号（KEY）的setter方法
	 */
	public void setIndexOfSettle(java.lang.Integer indexOfSettle) {
		this.indexOfSettle = indexOfSettle;
	} 
}