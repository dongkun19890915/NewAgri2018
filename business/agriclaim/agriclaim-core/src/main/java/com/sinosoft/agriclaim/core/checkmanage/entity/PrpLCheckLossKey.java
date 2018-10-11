package com.sinosoft.agriclaim.core.checkmanage.entity;

import com.sinosoft.framework.core.dao.BasePKImpl;
import javax.persistence.*;

/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-11-08 05:38:49.324 
 * 查勘事故估损金额表主键操作对象
 */
public class PrpLCheckLossKey extends BasePKImpl{
	private static final long serialVersionUID = 1L;
	public PrpLCheckLossKey(){}
	public PrpLCheckLossKey(String registNo,java.lang.Integer serialNo){
		this.registNo = registNo;
		this.serialNo = serialNo;
	}
	/** 属性出险登记号/出险登记号 */
	@Column(name = "registNo")
	private String registNo ;
	/** 属性序号/序号 */
	@Column(name = "serialNo")
	private java.lang.Integer serialNo ;
	/**
	 * 属性出险登记号/出险登记号的getter方法
	 */
	public String getRegistNo() {
    		return registNo;
	}
	/**
	 * 属性出险登记号/出险登记号的setter方法
	 */
	public void setRegistNo(String registNo) {
		this.registNo = registNo;
	} 
	/**
	 * 属性序号/序号的getter方法
	 */
	public java.lang.Integer getSerialNo() {
    		return serialNo;
	}
	/**
	 * 属性序号/序号的setter方法
	 */
	public void setSerialNo(java.lang.Integer serialNo) {
		this.serialNo = serialNo;
	} 
}