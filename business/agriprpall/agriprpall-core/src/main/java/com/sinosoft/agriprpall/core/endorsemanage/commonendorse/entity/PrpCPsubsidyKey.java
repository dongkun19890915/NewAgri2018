package com.sinosoft.agriprpall.core.endorsemanage.commonendorse.entity;

import com.sinosoft.framework.core.dao.BasePKImpl;

import javax.persistence.Column;

/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-10-24 03:06:48.016 
 * 政府补贴表主键操作对象
 */
public class PrpCPsubsidyKey extends BasePKImpl{
	private static final long serialVersionUID = 1L;
	public PrpCPsubsidyKey(){}
	public PrpCPsubsidyKey(String policyNo,String subsidyCode,String subsidyType){
		this.policyNo = policyNo;
		this.subsidyCode = subsidyCode;
		this.subsidyType = subsidyType;
	}
	/** 属性保单号/保单号 */
	@Column(name = "policyNo")
	private String policyNo ;
	/** 属性subsidyCode/subsidyCode */
	@Column(name = "subsidyCode")
	private String subsidyCode ;
	/** 属性subsidyType/subsidyType */
	@Column(name = "subsidyType")
	private String subsidyType ;
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
	 * 属性subsidyCode/subsidyCode的getter方法
	 */
	public String getSubsidyCode() {
    		return subsidyCode;
	}
	/**
	 * 属性subsidyCode/subsidyCode的setter方法
	 */
	public void setSubsidyCode(String subsidyCode) {
		this.subsidyCode = subsidyCode;
	} 
	/**
	 * 属性subsidyType/subsidyType的getter方法
	 */
	public String getSubsidyType() {
    		return subsidyType;
	}
	/**
	 * 属性subsidyType/subsidyType的setter方法
	 */
	public void setSubsidyType(String subsidyType) {
		this.subsidyType = subsidyType;
	} 
}