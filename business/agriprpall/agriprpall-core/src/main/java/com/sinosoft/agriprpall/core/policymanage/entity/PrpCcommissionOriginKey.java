package com.sinosoft.agriprpall.core.policymanage.entity;

import com.sinosoft.framework.core.dao.BasePKImpl;
import javax.persistence.*;

/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-11-05 01:01:20.710 
 * PrpCcommissionOrigin主键操作对象
 */
public class PrpCcommissionOriginKey extends BasePKImpl{
	private static final long serialVersionUID = 1L;
	public PrpCcommissionOriginKey(){}
	public PrpCcommissionOriginKey(String policyNo,String riskCode){
		this.policyNo = policyNo;
		this.riskCode = riskCode;
	}
	/** 属性保单号/保单号 */
	@Column(name = "policyNo")
	private String policyNo ;
	/** 属性险种/险种 */
	@Column(name = "riskCode")
	private String riskCode ;
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
	 * 属性险种/险种的getter方法
	 */
	public String getRiskCode() {
    		return riskCode;
	}
	/**
	 * 属性险种/险种的setter方法
	 */
	public void setRiskCode(String riskCode) {
		this.riskCode = riskCode;
	} 
}