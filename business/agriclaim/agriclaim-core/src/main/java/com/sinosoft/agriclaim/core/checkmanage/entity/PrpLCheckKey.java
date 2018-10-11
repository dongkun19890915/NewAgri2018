package com.sinosoft.agriclaim.core.checkmanage.entity;

import com.sinosoft.framework.core.dao.BasePKImpl;
import javax.persistence.*;

/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-11-08 05:38:49.324 
 * 查勘/代查勘信息表主键操作对象
 */
public class PrpLCheckKey extends BasePKImpl{
	private static final long serialVersionUID = 1L;
	public PrpLCheckKey(){}
	public PrpLCheckKey(String registNo,java.lang.Integer referSerialNo){
		this.registNo = registNo;
		this.referSerialNo = referSerialNo;
	}
	/** 属性报案号码/报案号码 */
	@Column(name = "registNo")
	private String registNo ;
	/** 属性关联理赔车辆序号/关联理赔车辆序号 */
	@Column(name = "referSerialNo")
	private java.lang.Integer referSerialNo ;
	/**
	 * 属性报案号码/报案号码的getter方法
	 */
	public String getRegistNo() {
    		return registNo;
	}
	/**
	 * 属性报案号码/报案号码的setter方法
	 */
	public void setRegistNo(String registNo) {
		this.registNo = registNo;
	} 
	/**
	 * 属性关联理赔车辆序号/关联理赔车辆序号的getter方法
	 */
	public java.lang.Integer getReferSerialNo() {
    		return referSerialNo;
	}
	/**
	 * 属性关联理赔车辆序号/关联理赔车辆序号的setter方法
	 */
	public void setReferSerialNo(java.lang.Integer referSerialNo) {
		this.referSerialNo = referSerialNo;
	} 
}