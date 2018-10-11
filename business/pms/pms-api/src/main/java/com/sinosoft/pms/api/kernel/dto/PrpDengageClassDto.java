package com.sinosoft.pms.api.kernel.dto;

import java.io.Serializable;

import com.sinosoft.framework.dto.BaseRequest;
/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-09-15 09:19:57.041 
 * 特别约定险类表Api操作对象
 */
public class PrpDengageClassDto extends BaseRequest implements Serializable{
	private static final long serialVersionUID = 1L;
	/** 属性特别约定代码/特别约定代码 */
	private String engageCode ;		
	/** 属性险种分类代码/险种分类代码 */
	private String classCode ;		
	/** 属性生效日期/生效日期 */
	private java.util.Date validDate ;		
	/** 属性失效日期/失效日期 */
	private java.util.Date invalidDate ;		
	/** 属性有效标志/有效标志 */
	private String validInd ;		
	/** 属性备注/备注 */
	private String remark ;		
	/** 属性标志字段/标志字段 */
	private String flag ;		
			
			
			
			
	/**
	 * 属性特别约定代码/特别约定代码的getter方法
	 */
	public String getEngageCode() {
		return engageCode;
	}
	/**
	 * 属性特别约定代码/特别约定代码的setter方法
	 */
	public void setEngageCode(String engageCode) {
		this.engageCode = engageCode;
	}	
	/**
	 * 属性险种分类代码/险种分类代码的getter方法
	 */
	public String getClassCode() {
		return classCode;
	}
	/**
	 * 属性险种分类代码/险种分类代码的setter方法
	 */
	public void setClassCode(String classCode) {
		this.classCode = classCode;
	}	
	/**
	 * 属性生效日期/生效日期的getter方法
	 */
	public java.util.Date getValidDate() {
		return validDate;
	}
	/**
	 * 属性生效日期/生效日期的setter方法
	 */
	public void setValidDate(java.util.Date validDate) {
		this.validDate = validDate;
	}	
	/**
	 * 属性失效日期/失效日期的getter方法
	 */
	public java.util.Date getInvalidDate() {
		return invalidDate;
	}
	/**
	 * 属性失效日期/失效日期的setter方法
	 */
	public void setInvalidDate(java.util.Date invalidDate) {
		this.invalidDate = invalidDate;
	}	
	/**
	 * 属性有效标志/有效标志的getter方法
	 */
	public String getValidInd() {
		return validInd;
	}
	/**
	 * 属性有效标志/有效标志的setter方法
	 */
	public void setValidInd(String validInd) {
		this.validInd = validInd;
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
