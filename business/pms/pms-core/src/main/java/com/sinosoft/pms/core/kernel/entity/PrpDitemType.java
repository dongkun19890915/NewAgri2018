package com.sinosoft.pms.core.kernel.entity;

import com.sinosoft.framework.core.dao.BaseEntityImpl;
import javax.persistence.*;
import java.util.Date;

/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-09-15 09:19:57.041 
 * 标的分类表实体操作对象
 */
@Entity
@Table(name = "PrpDitemType")
@IdClass(PrpDitemTypeKey.class)
public class PrpDitemType extends BaseEntityImpl{

	private static final long serialVersionUID = 1L;
	/** 属性标的代码/标的代码 */
        @Id
        @Column(name = "itemCode")
	private String itemCode ;/** 属性标的分类标准/标的分类标准 */
        @Id
        @Column(name = "itemTypeBase")
	private String itemTypeBase ;/** 属性标的分类代码/标的分类代码 */
        @Id
        @Column(name = "itemTypeCode")
	private String itemTypeCode ;	

	/** 属性标的名称/标的名称 */
	private String itemName ;


	/** 属性标的分类名称/标的分类名称 */
	private String itemTypeName ;
	/** 属性最小保额/最小保额 */
	private java.lang.Double minAmount ;
	/** 属性最大保额/最大保额 */
	private java.lang.Double maxAmount ;
	/** 属性标志/标志 */
	private String flag ;
	/** 属性备注/备注 */
	private String remark ;




	/**
	 * 属性标的代码/标的代码的getter方法
	 */
	public String getItemCode() {
		return itemCode;
	}
	/**
	 * 属性标的代码/标的代码的setter方法
	 */
	public void setItemCode(String itemCode) {
		this.itemCode = itemCode;
	} 	
	/**
	 * 属性标的名称/标的名称的getter方法
	 */
	public String getItemName() {
		return itemName;
	}
	/**
	 * 属性标的名称/标的名称的setter方法
	 */
	public void setItemName(String itemName) {
		this.itemName = itemName;
	} 	
	/**
	 * 属性标的分类标准/标的分类标准的getter方法
	 */
	public String getItemTypeBase() {
		return itemTypeBase;
	}
	/**
	 * 属性标的分类标准/标的分类标准的setter方法
	 */
	public void setItemTypeBase(String itemTypeBase) {
		this.itemTypeBase = itemTypeBase;
	} 	
	/**
	 * 属性标的分类代码/标的分类代码的getter方法
	 */
	public String getItemTypeCode() {
		return itemTypeCode;
	}
	/**
	 * 属性标的分类代码/标的分类代码的setter方法
	 */
	public void setItemTypeCode(String itemTypeCode) {
		this.itemTypeCode = itemTypeCode;
	} 	
	/**
	 * 属性标的分类名称/标的分类名称的getter方法
	 */
	public String getItemTypeName() {
		return itemTypeName;
	}
	/**
	 * 属性标的分类名称/标的分类名称的setter方法
	 */
	public void setItemTypeName(String itemTypeName) {
		this.itemTypeName = itemTypeName;
	} 	
	/**
	 * 属性最小保额/最小保额的getter方法
	 */
	public java.lang.Double getMinAmount() {
		return minAmount;
	}
	/**
	 * 属性最小保额/最小保额的setter方法
	 */
	public void setMinAmount(java.lang.Double minAmount) {
		this.minAmount = minAmount;
	} 	
	/**
	 * 属性最大保额/最大保额的getter方法
	 */
	public java.lang.Double getMaxAmount() {
		return maxAmount;
	}
	/**
	 * 属性最大保额/最大保额的setter方法
	 */
	public void setMaxAmount(java.lang.Double maxAmount) {
		this.maxAmount = maxAmount;
	} 	
	/**
	 * 属性标志/标志的getter方法
	 */
	public String getFlag() {
		return flag;
	}
	/**
	 * 属性标志/标志的setter方法
	 */
	public void setFlag(String flag) {
		this.flag = flag;
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
		
		
		
		
}