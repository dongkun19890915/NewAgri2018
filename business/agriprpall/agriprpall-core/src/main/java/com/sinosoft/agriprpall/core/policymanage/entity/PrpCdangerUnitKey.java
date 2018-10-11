package com.sinosoft.agriprpall.core.policymanage.entity;

import com.sinosoft.framework.core.dao.BasePKImpl;
import javax.persistence.*;

/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-11-04 09:53:57.649 
 * 保单的危险单位划分表主键操作对象
 */
public class PrpCdangerUnitKey extends BasePKImpl{
	private static final long serialVersionUID = 1L;
	public PrpCdangerUnitKey(){}
	public PrpCdangerUnitKey(String policyNo,java.lang.Integer dangerNo){
		this.policyNo = policyNo;
		this.dangerNo = dangerNo;
	}
	/** 属性保单号码 /保单号码  */
	@Column(name = "policyNo")
	private String policyNo ;
	/** 属性危险单位序号 /危险单位序号  */
	@Column(name = "dangerNo")
	private java.lang.Integer dangerNo ;
	/**
	 * 属性保单号码 /保单号码 的getter方法
	 */
	public String getPolicyNo() {
    		return policyNo;
	}
	/**
	 * 属性保单号码 /保单号码 的setter方法
	 */
	public void setPolicyNo(String policyNo) {
		this.policyNo = policyNo;
	} 
	/**
	 * 属性危险单位序号 /危险单位序号 的getter方法
	 */
	public java.lang.Integer getDangerNo() {
    		return dangerNo;
	}
	/**
	 * 属性危险单位序号 /危险单位序号 的setter方法
	 */
	public void setDangerNo(java.lang.Integer dangerNo) {
		this.dangerNo = dangerNo;
	} 
}