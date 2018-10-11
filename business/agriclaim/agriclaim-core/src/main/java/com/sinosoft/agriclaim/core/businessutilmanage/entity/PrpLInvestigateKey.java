package com.sinosoft.agriclaim.core.businessutilmanage.entity;

import com.sinosoft.framework.core.dao.BasePKImpl;
import javax.persistence.*;

/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-11-08 05:35:28.283 
 * 案情调查信息表主键操作对象
 */
public class PrpLInvestigateKey extends BasePKImpl{
	private static final long serialVersionUID = 1L;
	public PrpLInvestigateKey(){}
	public PrpLInvestigateKey(String registNo,java.lang.Double serialNo,String objectType){
		this.registNo = registNo;
		this.serialNo = serialNo;
		this.objectType = objectType;
	}
	/** 属性报案号/报案号 */
	@Column(name = "registNo")
	private String registNo ;
	/** 属性序号/序号 */
	@Column(name = "serialNo")
	private java.lang.Double serialNo ;
	/** 属性调查对象类型 1.被保人 2.购车人 3.贷款车辆 4.担保人 5.售车商 6.其他方 7.调查结论/调查对象类型 1.被保人 2.购车人 3.贷款车辆 4.担保人 5.售车商 6.其他方 7.调查结论 */
	@Column(name = "objectType")
	private String objectType ;
	/**
	 * 属性报案号/报案号的getter方法
	 */
	public String getRegistNo() {
    		return registNo;
	}
	/**
	 * 属性报案号/报案号的setter方法
	 */
	public void setRegistNo(String registNo) {
		this.registNo = registNo;
	} 
	/**
	 * 属性序号/序号的getter方法
	 */
	public java.lang.Double getSerialNo() {
    		return serialNo;
	}
	/**
	 * 属性序号/序号的setter方法
	 */
	public void setSerialNo(java.lang.Double serialNo) {
		this.serialNo = serialNo;
	} 
	/**
	 * 属性调查对象类型 1.被保人 2.购车人 3.贷款车辆 4.担保人 5.售车商 6.其他方 7.调查结论/调查对象类型 1.被保人 2.购车人 3.贷款车辆 4.担保人 5.售车商 6.其他方 7.调查结论的getter方法
	 */
	public String getObjectType() {
    		return objectType;
	}
	/**
	 * 属性调查对象类型 1.被保人 2.购车人 3.贷款车辆 4.担保人 5.售车商 6.其他方 7.调查结论/调查对象类型 1.被保人 2.购车人 3.贷款车辆 4.担保人 5.售车商 6.其他方 7.调查结论的setter方法
	 */
	public void setObjectType(String objectType) {
		this.objectType = objectType;
	} 
}