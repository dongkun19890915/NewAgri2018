package com.sinosoft.dms.core.dict.entity;

import com.sinosoft.framework.core.dao.BasePKImpl;

import javax.persistence.Column;

/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-11-05 01:02:29.563 
 * PrpGroup主键操作对象
 */
public class PrpGroupKey extends BasePKImpl{
	private static final long serialVersionUID = 1L;
	public PrpGroupKey(){}
	public PrpGroupKey(String groupNo,String subGroupNo){
		this.groupNo = groupNo;
		this.subGroupNo = subGroupNo;
	}
	/** 属性groupno/groupno */
	@Column(name = "groupNo")
	private String groupNo ;
	/** 属性subgroupno/subgroupno */
	@Column(name = "subGroupNo")
	private String subGroupNo ;
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
}