package com.sinosoft.agriclaim.core.recasemanage.entity;

import com.sinosoft.framework.core.dao.BasePKImpl;
import javax.persistence.*;

/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-11-08 05:44:45.570 
 * 重开赔案表主键操作对象
 */
public class PrpLRecaseKey extends BasePKImpl{
	private static final long serialVersionUID = 1L;
	public PrpLRecaseKey(){}
	public PrpLRecaseKey(String claimNo,java.lang.Integer serialNo){
		this.claimNo = claimNo;
		this.serialNo = serialNo;
	}
	/** 属性立案号/立案号 */
	@Column(name = "claimNo")
	private String claimNo ;
	/** 属性重开赔案次数/重开赔案次数 */
	@Column(name = "serialNo")
	private java.lang.Integer serialNo ;
	/**
	 * 属性立案号/立案号的getter方法
	 */
	public String getClaimNo() {
    		return claimNo;
	}
	/**
	 * 属性立案号/立案号的setter方法
	 */
	public void setClaimNo(String claimNo) {
		this.claimNo = claimNo;
	} 
	/**
	 * 属性重开赔案次数/重开赔案次数的getter方法
	 */
	public java.lang.Integer getSerialNo() {
    		return serialNo;
	}
	/**
	 * 属性重开赔案次数/重开赔案次数的setter方法
	 */
	public void setSerialNo(java.lang.Integer serialNo) {
		this.serialNo = serialNo;
	} 
}