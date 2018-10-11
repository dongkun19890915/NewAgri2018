package com.sinosoft.agriclaim.core.schedulemanage.entity;

import com.sinosoft.framework.core.dao.BasePKImpl;
import javax.persistence.*;

/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-11-08 05:45:58.930 
 * 调度任务标的表主键操作对象
 */
public class PrpLScheduleItemKey extends BasePKImpl{
	private static final long serialVersionUID = 1L;
	public PrpLScheduleItemKey(){}
	public PrpLScheduleItemKey(java.lang.Integer scheduleId,String registNo,java.lang.Integer itemNo){
		this.scheduleId = scheduleId;
		this.registNo = registNo;
		this.itemNo = itemNo;
	}
	/** 属性调度ID/调度ID */
	@Column(name = "scheduleId")
	private java.lang.Integer scheduleId ;
	/** 属性报案号码/报案号码 */
	@Column(name = "registNo")
	private String registNo ;
	/** 属性标的序号/标的序号 */
	@Column(name = "itemNo")
	private java.lang.Integer itemNo ;
	/**
	 * 属性调度ID/调度ID的getter方法
	 */
	public java.lang.Integer getScheduleId() {
    		return scheduleId;
	}
	/**
	 * 属性调度ID/调度ID的setter方法
	 */
	public void setScheduleId(java.lang.Integer scheduleId) {
		this.scheduleId = scheduleId;
	} 
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
	 * 属性标的序号/标的序号的getter方法
	 */
	public java.lang.Integer getItemNo() {
    		return itemNo;
	}
	/**
	 * 属性标的序号/标的序号的setter方法
	 */
	public void setItemNo(java.lang.Integer itemNo) {
		this.itemNo = itemNo;
	} 
}