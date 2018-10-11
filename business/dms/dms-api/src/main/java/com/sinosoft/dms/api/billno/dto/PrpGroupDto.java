package com.sinosoft.dms.api.billno.dto;

import com.sinosoft.framework.dto.BaseRequest;

import java.io.Serializable;

/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-10-10 12:51:20.949 
 * PrpGroupApi操作对象
 */
public class PrpGroupDto extends BaseRequest implements Serializable{
	private static final long serialVersionUID = 1L;
	/** 属性groupNo/groupNo */
	private String groupNo ;
	/** 属性subGroupNo/subGroupNo */
	private String subGroupNo ;		
	/** 属性flag/flag */
	private String flag ;		
	/** 属性createDBy/createDBy */
	private String createDBy ;		
	/** 属性createDTime/createDTime */
	private java.util.Date createDTime ;		
	/** 属性updateDBy/updateDBy */
	private String updateDBy ;		
	/** 属性updateDTime/updateDTime */
	private java.util.Date updateDTime ;		
	/**
	 * 属性groupNo/groupNo的getter方法
	 */
	public String getGroupNo() {
		return groupNo;
	}
	/**
	 * 属性groupNo/groupNo的setter方法
	 */
	public void setGroupNo(String groupNo) {
		this.groupNo = groupNo;
	}	
	/**
	 * 属性subGroupNo/subGroupNo的getter方法
	 */
	public String getSubGroupNo() {
		return subGroupNo;
	}
	/**
	 * 属性subGroupNo/subGroupNo的setter方法
	 */
	public void setSubGroupNo(String subGroupNo) {
		this.subGroupNo = subGroupNo;
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
	/**
	 * 属性createDBy/createDBy的getter方法
	 */
	public String getCreateDBy() {
		return createDBy;
	}
	/**
	 * 属性createDBy/createDBy的setter方法
	 */
	public void setCreateDBy(String createDBy) {
		this.createDBy = createDBy;
	}	
	/**
	 * 属性createDTime/createDTime的getter方法
	 */
	public java.util.Date getCreateDTime() {
		return createDTime;
	}
	/**
	 * 属性createDTime/createDTime的setter方法
	 */
	public void setCreateDTime(java.util.Date createDTime) {
		this.createDTime = createDTime;
	}	
	/**
	 * 属性updateDBy/updateDBy的getter方法
	 */
	public String getUpdateDBy() {
		return updateDBy;
	}
	/**
	 * 属性updateDBy/updateDBy的setter方法
	 */
	public void setUpdateDBy(String updateDBy) {
		this.updateDBy = updateDBy;
	}	
	/**
	 * 属性updateDTime/updateDTime的getter方法
	 */
	public java.util.Date getUpdateDTime() {
		return updateDTime;
	}
	/**
	 * 属性updateDTime/updateDTime的setter方法
	 */
	public void setUpdateDTime(java.util.Date updateDTime) {
		this.updateDTime = updateDTime;
	}	
}
