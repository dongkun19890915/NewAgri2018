package com.sinosoft.agriprpall.core.endorsemanage.commonendorse.entity;

import com.sinosoft.framework.core.dao.BasePKImpl;

import javax.persistence.Column;

/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-11-06 07:49:16.504 
 * 大户田块信息表主键操作对象
 */
public class PrpCPfeildKey extends BasePKImpl{
	private static final long serialVersionUID = 1L;
	public PrpCPfeildKey(){}
	public PrpCPfeildKey(String policyNo,String feildNo){
		this.policyNo = policyNo;
		this.feildNo = feildNo;
	}
	/** 属性保单号/保单号 */
	@Column(name = "policyNo")
	private String policyNo ;
	/** 属性田块编码/田块编码 */
	@Column(name = "feildNo")
	private String feildNo ;
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
	 * 属性田块编码/田块编码的getter方法
	 */
	public String getFeildNo() {
    		return feildNo;
	}
	/**
	 * 属性田块编码/田块编码的setter方法
	 */
	public void setFeildNo(String feildNo) {
		this.feildNo = feildNo;
	} 
}