package com.sinosoft.dms.core.dict.entity;

import com.sinosoft.framework.core.dao.BaseEntityImpl;

import javax.persistence.*;

/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-11-05 01:02:29.563 
 * PrpGroup实体操作对象
 */
@Entity
@Table(name = "PrpGroup")
@IdClass(PrpGroupKey.class)
public class PrpGroup extends BaseEntityImpl{

	private static final long serialVersionUID = 1L;
	/** 属性groupno/groupno */
	@Id
	@Column(name = "groupNo")
	private String groupNo ;/** 属性subgroupno/subgroupno */
	@Id
	@Column(name = "subGroupNo")
	private String subGroupNo ;	


	/** 属性flag/flag */
	@Column(name = "flag")
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