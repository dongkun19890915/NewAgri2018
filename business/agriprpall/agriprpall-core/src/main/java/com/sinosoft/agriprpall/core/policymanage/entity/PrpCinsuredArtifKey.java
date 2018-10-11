package com.sinosoft.agriprpall.core.policymanage.entity;

import com.sinosoft.framework.core.dao.BasePKImpl;
import javax.persistence.*;

/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-11-04 09:53:57.649 
 * PrpCinsuredArtif主键操作对象
 */
public class PrpCinsuredArtifKey extends BasePKImpl{
	private static final long serialVersionUID = 1L;
	public PrpCinsuredArtifKey(){}
	public PrpCinsuredArtifKey(String policyNo,java.lang.Integer serialNo){
		this.policyNo = policyNo;
		this.serialNo = serialNo;
	}
	/** 属性policyNo/policyNo */
	@Column(name = "policyNo")
	private String policyNo ;
	/** 属性serialNo/serialNo */
	@Column(name = "serialNo")
	private java.lang.Integer serialNo ;
	/**
	 * 属性policyNo/policyNo的getter方法
	 */
	public String getPolicyNo() {
    		return policyNo;
	}
	/**
	 * 属性policyNo/policyNo的setter方法
	 */
	public void setPolicyNo(String policyNo) {
		this.policyNo = policyNo;
	} 
	/**
	 * 属性serialNo/serialNo的getter方法
	 */
	public java.lang.Integer getSerialNo() {
    		return serialNo;
	}
	/**
	 * 属性serialNo/serialNo的setter方法
	 */
	public void setSerialNo(java.lang.Integer serialNo) {
		this.serialNo = serialNo;
	} 
}