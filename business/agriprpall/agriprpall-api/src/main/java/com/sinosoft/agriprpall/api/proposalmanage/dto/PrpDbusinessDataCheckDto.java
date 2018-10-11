package com.sinosoft.agriprpall.api.proposalmanage.dto;

import com.sinosoft.framework.dto.BaseRequest;

import java.io.Serializable;

/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-10-31 01:52:20.999 
 * 业务数据检查表Api操作对象
 */
public class PrpDbusinessDataCheckDto extends BaseRequest implements Serializable{
	private static final long serialVersionUID = 1L;
	/** 属性检查日期/检查日期 */
	private java.util.Date checkDate ;		
	/** 属性标题/标题 */
	private String title ;		
	/** 属性备注/备注 */
	private String remark ;		
	/** 属性错误信息/错误信息 */
	private String stackTrace ;		
	/** 属性序号/序号 */
	private String id;
	/**
	 * 属性检查日期/检查日期的getter方法
	 */
	public java.util.Date getCheckDate() {
		return checkDate;
	}
	/**
	 * 属性检查日期/检查日期的setter方法
	 */
	public void setCheckDate(java.util.Date checkDate) {
		this.checkDate = checkDate;
	}	
	/**
	 * 属性标题/标题的getter方法
	 */
	public String getTitle() {
		return title;
	}
	/**
	 * 属性标题/标题的setter方法
	 */
	public void setTitle(String title) {
		this.title = title;
	}	
	/**
	 * 属性备注/备注的getter方法
	 */
	public String getRemark() {
		return remark;
	}
	/**
	 * 属性备注/备注的setter方法
	 */
	public void setRemark(String remark) {
		this.remark = remark;
	}	
	/**
	 * 属性错误信息/错误信息的getter方法
	 */
	public String getStackTrace() {
		return stackTrace;
	}
	/**
	 * 属性错误信息/错误信息的setter方法
	 */
	public void setStackTrace(String stackTrace) {
		this.stackTrace = stackTrace;
	}	
	/**
	 * 属性序号/序号的getter方法
	 */
	public String getId() {
		return id;
	}
	/**
	 * 属性序号/序号的setter方法
	 */
	public void setId(String id) {
		this.id = id;
	}	
}
