package com.sinosoft.txnlist.api.claiminsurancelist.dto;

import java.io.Serializable;

import com.sinosoft.framework.dto.BaseRequest;
/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2018-01-17 06:38:35.329 
 * 定损清单农户标的明细表-物Api操作对象
 */
public class LossRateHerdListDto extends BaseRequest implements Serializable{
	private static final long serialVersionUID = 1L;
	/** 属性清单编号/清单编号 */
	private String lossListCode ;		
	/** 属性序列号/序列号 */
	private java.lang.Integer serialNo ;		
	/** 属性农户代码/农户代码 */
	private String fCode ;		
	/** 属性标的代码/标的代码 */
	private String itemCode ;		
	/** 属性损失序列号/损失序列号 */
	private java.lang.Integer lossSerialNo ;		
	/** 属性耳标号/耳标号 */
	private String earLabel ;		
	/**
	 * 属性清单编号/清单编号的getter方法
	 */
	public String getLossListCode() {
		return lossListCode;
	}
	/**
	 * 属性清单编号/清单编号的setter方法
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
	 * 属性损失序列号/损失序列号的getter方法
	 */
	public java.lang.Integer getLossSerialNo() {
		return lossSerialNo;
	}
	/**
	 * 属性损失序列号/损失序列号的setter方法
	 */
	public void setLossSerialNo(java.lang.Integer lossSerialNo) {
		this.lossSerialNo = lossSerialNo;
	}	
	/**
	 * 属性耳标号/耳标号的getter方法
	 */
	public String getEarLabel() {
		return earLabel;
	}
	/**
	 * 属性耳标号/耳标号的setter方法
	 */
	public void setEarLabel(String earLabel) {
		this.earLabel = earLabel;
	}	
}
