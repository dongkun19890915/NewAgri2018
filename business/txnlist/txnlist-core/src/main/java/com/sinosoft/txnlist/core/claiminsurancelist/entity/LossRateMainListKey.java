package com.sinosoft.txnlist.core.claiminsurancelist.entity;

import com.sinosoft.framework.core.dao.BasePKImpl;
import javax.persistence.*;

/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2018-01-17 06:38:35.329 
 * 定损清单主表主键操作对象
 */
public class LossRateMainListKey extends BasePKImpl{
	private static final long serialVersionUID = 1L;
	public LossRateMainListKey(){}
	public LossRateMainListKey(String lossListCode,java.lang.Integer serialNo){
		this.lossListCode = lossListCode;
		this.serialNo = serialNo;
	}
	/** 属性理赔损失清单编号/理赔损失清单编号 */
	@Column(name = "lossListCode")
	private String lossListCode ;
	/** 属性序列号/序列号 */
	@Column(name = "serialNo")
	private java.lang.Integer serialNo ;
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
}