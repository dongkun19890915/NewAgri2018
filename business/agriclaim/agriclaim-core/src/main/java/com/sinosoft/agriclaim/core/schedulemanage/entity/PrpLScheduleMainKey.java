package com.sinosoft.agriclaim.core.schedulemanage.entity;

import com.sinosoft.framework.core.dao.BasePKImpl;
import javax.persistence.*;

/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-11-08 05:45:58.930 
 * 调度任务主表主键操作对象
 */
public class PrpLScheduleMainKey extends BasePKImpl{
	private static final long serialVersionUID = 1L;
	public PrpLScheduleMainKey(){}
	public PrpLScheduleMainKey(java.lang.Double scheduleId,String registNo,java.lang.Double serialNo){
		this.scheduleId = scheduleId;
		this.registNo = registNo;
		this.serialNo = serialNo;
	}
	/** 属性调度id/调度id */
	@Column(name = "scheduleId")
	private java.lang.Double scheduleId ;
	/** 属性报案号码/报案号码 */
	@Column(name = "registNo")
	private String registNo ;
	/** 属性标的序号/标的序号 */
	@Column(name = "serialNo")
	private java.lang.Double serialNo ;
	/**
	 * 属性调度id/调度id的getter方法
	 */
	public java.lang.Double getScheduleId() {
    		return scheduleId;
	}
	/**
	 * 属性调度id/调度id的setter方法
	 */
	public void setScheduleId(java.lang.Double scheduleId) {
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
	public java.lang.Double getSerialNo() {
    		return serialNo;
	}
	/**
	 * 属性标的序号/标的序号的setter方法
	 */
	public void setSerialNo(java.lang.Double serialNo) {
		this.serialNo = serialNo;
	} 
}