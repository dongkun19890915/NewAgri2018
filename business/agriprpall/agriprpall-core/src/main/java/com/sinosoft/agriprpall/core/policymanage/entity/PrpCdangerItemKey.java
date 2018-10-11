package com.sinosoft.agriprpall.core.policymanage.entity;

import com.sinosoft.framework.core.dao.BasePKImpl;
import javax.persistence.*;

/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-11-04 09:53:57.649 
 * 投保单危险单位划分表主键操作对象
 */
public class PrpCdangerItemKey extends BasePKImpl{
	private static final long serialVersionUID = 1L;
	public PrpCdangerItemKey(){}
	public PrpCdangerItemKey(String policyNo,java.lang.Integer dangerNo,java.lang.Integer serialNo){
		this.policyNo = policyNo;
		this.dangerNo = dangerNo;
		this.serialNo = serialNo;
	}
	/** 属性保单号/保单号 */
	@Column(name = "policyNo")
	private String policyNo ;
	/** 属性危险单位序号/危险单位序号 */
	@Column(name = "dangerNo")
	private java.lang.Integer dangerNo ;
	/** 属性序号(自动生成)/序号(自动生成) */
	@Column(name = "serialNo")
	private java.lang.Integer serialNo ;
	/**
	 * 属性保单号/保单号的getter方法
	 */
	public String getPolicyNo() {
    		return policyNo;
	}
	/**
	 * 属性保单号/保单号的setter方法
	 */
	public void setPolicyNo(String policyNo) {
		this.policyNo = policyNo;
	} 
	/**
	 * 属性危险单位序号/危险单位序号的getter方法
	 */
	public java.lang.Integer getDangerNo() {
    		return dangerNo;
	}
	/**
	 * 属性危险单位序号/危险单位序号的setter方法
	 */
	public void setDangerNo(java.lang.Integer dangerNo) {
		this.dangerNo = dangerNo;
	} 
	/**
	 * 属性序号(自动生成)/序号(自动生成)的getter方法
	 */
	public java.lang.Integer getSerialNo() {
    		return serialNo;
	}
	/**
	 * 属性序号(自动生成)/序号(自动生成)的setter方法
	 */
	public void setSerialNo(java.lang.Integer serialNo) {
		this.serialNo = serialNo;
	} 
}