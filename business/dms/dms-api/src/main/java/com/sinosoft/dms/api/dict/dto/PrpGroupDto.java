package com.sinosoft.dms.api.dict.dto;

import java.io.Serializable;

import com.sinosoft.framework.dto.BaseRequest;
/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-11-05 01:02:29.563 
 * PrpGroupApi操作对象
 */
public class PrpGroupDto extends BaseRequest implements Serializable{
	private static final long serialVersionUID = 1L;
	/** 属性groupno/groupno */
	private String groupNo ;		
	/** 属性subgroupno/subgroupno */
	private String subGroupNo ;		
	/** 属性flag/flag */
	private String flag ;		
	/**
	 * 属性groupno/groupno的getter方法
	 */
	public String getGroupNo() {
		return groupNo;
	}
	/**
	 * 属性groupno/groupno的setter方法
	 */
	public void setGroupNo(String groupNo) {
		this.groupNo = groupNo;
	}	
	/**
	 * 属性subgroupno/subgroupno的getter方法
	 */
	public String getSubGroupNo() {
		return subGroupNo;
	}
	/**
	 * 属性subgroupno/subgroupno的setter方法
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
}
