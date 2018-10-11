package com.sinosoft.txnlist.api.claiminsurancelist.dto;

import java.io.Serializable;

import com.sinosoft.framework.dto.BaseRequest;
/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2018-01-17 06:38:35.329 
 * 定损清单标的表Api操作对象
 */
public class LossRateItemListDto extends BaseRequest implements Serializable{
	private static final long serialVersionUID = 1L;
	/** 属性理赔损失清单编号/理赔损失清单编号 */
	private String lossListCode ;		
	/** 属性序列号/序列号 */
	private java.lang.Integer serialNo ;		
	/** 属性农户代码/农户代码 */
	private String fCode ;		
	/** 属性农户姓名/农户姓名 */
	private String fName ;		
	/** 属性证件类型/证件类型 */
	private String fIdType ;		
	/** 属性证件号码/证件号码 */
	private String fIdCard ;		
	/** 属性标的代码/标的代码 */
	private String itemCode ;		
	/** 属性标的类型/标的类型 */
	private String itemType ;		
	/** 属性标的名称/标的名称 */
	private String itemName ;		
	/**
	 * 属性理赔损失清单编号/理赔损失清单编号的getter方法
	 */
	public String getLossListCode() {
		return lossListCode;
	}
	/**
	 * 属性理赔损失清单编号/理赔损失清单编号的setter方法
	 */
	public void setLossListCode(String lossListCode) {
		this.lossListCode = lossListCode;
	}	
	/**
	 * 属性序列号/序列号的getter方法
	 */
	public java.lang.Integer getSerialNo() {
		return serialNo;
	}
	/**
	 * 属性序列号/序列号的setter方法
	 */
	public void setSerialNo(java.lang.Integer serialNo) {
		this.serialNo = serialNo;
	}	
	/**
	 * 属性农户代码/农户代码的getter方法
	 */
	public String getfCode() {
		return fCode;
	}
	/**
	 * 属性农户代码/农户代码的setter方法
	 */
	public void setfCode(String fCode) {
		this.fCode = fCode;
	}	
	/**
	 * 属性农户姓名/农户姓名的getter方法
	 */
	public String getfName() {
		return fName;
	}
	/**
	 * 属性农户姓名/农户姓名的setter方法
	 */
	public void setfName(String fName) {
		this.fName = fName;
	}	
	/**
	 * 属性证件类型/证件类型的getter方法
	 */
	public String getfIdType() {
		return fIdType;
	}
	/**
	 * 属性证件类型/证件类型的setter方法
	 */
	public void setfIdType(String fIdType) {
		this.fIdType = fIdType;
	}	
	/**
	 * 属性证件号码/证件号码的getter方法
	 */
	public String getfIdCard() {
		return fIdCard;
	}
	/**
	 * 属性证件号码/证件号码的setter方法
	 */
	public void setfIdCard(String fIdCard) {
		this.fIdCard = fIdCard;
	}	
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
	 * 属性标的类型/标的类型的getter方法
	 */
	public String getItemType() {
		return itemType;
	}
	/**
	 * 属性标的类型/标的类型的setter方法
	 */
	public void setItemType(String itemType) {
		this.itemType = itemType;
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
}
