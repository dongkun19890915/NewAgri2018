package com.sinosoft.agriprpall.core.policymanage.entity;

import com.sinosoft.framework.core.dao.BasePKImpl;
import javax.persistence.*;

/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-10-24 07:46:04.010 
 * 保单隶属表主键操作对象
 */
public class PrpCmainSubKey extends BasePKImpl{
	private static final long serialVersionUID = 1L;
	public PrpCmainSubKey(){}
	public PrpCmainSubKey(String policyNo,String mainPolicyNo){
		this.policyNo = policyNo;
		this.mainPolicyNo = mainPolicyNo;
	}
	/** 属性保单号码/保单号码 */
	@Column(name = "policyNo")
	private String policyNo ;
	/** 属性主保单号码/主保单号码 */
	@Column(name = "mainPolicyNo")
	private String mainPolicyNo ;
	/**
	 * 属性保单号码/保单号码的getter方法
	 */
	public String getPolicyNo() {
    		return policyNo;
	}
	/**
	 * 属性保单号码/保单号码的setter方法
	 */
	public void setPolicyNo(String policyNo) {
		this.policyNo = policyNo;
	} 
	/**
	 * 属性主保单号码/主保单号码的getter方法
	 */
	public String getMainPolicyNo() {
    		return mainPolicyNo;
	}
	/**
	 * 属性主保单号码/主保单号码的setter方法
	 */
	public void setMainPolicyNo(String mainPolicyNo) {
		this.mainPolicyNo = mainPolicyNo;
	} 
}