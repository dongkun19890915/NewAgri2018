package com.sinosoft.txnlist.api.claiminsurancelist.dto;

import java.io.Serializable;

import com.sinosoft.framework.dto.BaseRequest;
/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2018-01-17 06:38:35.329 
 * 定损清单农户标的清单表Api操作对象
 */
public class LossRateLossListDto extends BaseRequest implements Serializable{
	private static final long serialVersionUID = 1L;
	/** 属性理赔损失清单编号/理赔损失清单编号 */
	private String lossListCode ;		
	/** 属性序列号/序列号 */
	private java.lang.Integer serialNo ;		
	/** 属性农户代码/农户代码 */
	private String fCode ;		
	/** 属性标的代码/标的代码 */
	private String itemCode ;		
	/** 属性损失序列号/损失序列号 */
	private java.lang.Integer lossSerialNo ;		
	/** 属性损失率/损失率 */
	private java.lang.Double lossRate ;		
	/** 属性损失数量/损失数量 */
	private java.lang.Double lossAmount ;		
	/** 属性损失金额/损失金额 */
	private java.lang.Double lossMoney ;
	/** 属性田块代码/田块代码 */
	private String fieldCode ;
	/** 属性贷款合同编号*/
	private String versionNo;
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
	 * 属性损失率/损失率的getter方法
	 */
	public java.lang.Double getLossRate() {
		return lossRate;
	}
	/**
	 * 属性损失率/损失率的setter方法
	 */
	public void setLossRate(java.lang.Double lossRate) {
		this.lossRate = lossRate;
	}	
	/**
	 * 属性损失数量/损失数量的getter方法
	 */
	public java.lang.Double getLossAmount() {
		return lossAmount;
	}
	/**
	 * 属性损失数量/损失数量的setter方法
	 */
	public void setLossAmount(java.lang.Double lossAmount) {
		this.lossAmount = lossAmount;
	}	
	/**
	 * 属性损失金额/损失金额的getter方法
	 */
	public java.lang.Double getLossMoney() {
		return lossMoney;
	}
	/**
	 * 属性损失金额/损失金额的setter方法
	 */
	public void setLossMoney(java.lang.Double lossMoney) {
		this.lossMoney = lossMoney;
	}

	public String getFieldCode() {
		return fieldCode;
	}

	public void setFieldCode(String fieldCode) {
		this.fieldCode = fieldCode;
	}

	public String getVersionNo() {
		return versionNo;
	}

	public void setVersionNo(String versionNo) {
		this.versionNo = versionNo;
	}
}
