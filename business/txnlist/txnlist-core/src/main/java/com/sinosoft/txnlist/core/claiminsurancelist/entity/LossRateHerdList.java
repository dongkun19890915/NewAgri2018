package com.sinosoft.txnlist.core.claiminsurancelist.entity;

import com.sinosoft.framework.core.dao.BaseEntityImpl;
import javax.persistence.*;
import java.util.Date;

/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2018-01-17 06:38:35.329 
 * 定损清单农户标的明细表-物实体操作对象
 */
@Entity
@Table(name = "LossRateHerdList")
@IdClass(LossRateHerdListKey.class)
public class LossRateHerdList extends BaseEntityImpl{

	private static final long serialVersionUID = 1L;
	/** 属性清单编号/清单编号 */
	@Id
	@Column(name = "lossListCode")
	private String lossListCode ;/** 属性序列号/序列号 */
	@Id
	@Column(name = "serialNo")
	private java.lang.Integer serialNo ;/** 属性农户代码/农户代码 */
	@Id
	@Column(name = "fCode")
	private String fCode ;/** 属性标的代码/标的代码 */
	@Id
	@Column(name = "itemCode")
	private String itemCode ;/** 属性损失序列号/损失序列号 */
	@Id
	@Column(name = "lossSerialNo")
	private java.lang.Integer lossSerialNo ;/** 属性耳标号/耳标号 */
	@Id
	@Column(name = "earLabel")
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