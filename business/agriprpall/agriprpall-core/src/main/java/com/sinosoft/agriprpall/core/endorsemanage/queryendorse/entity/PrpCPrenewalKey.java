package com.sinosoft.agriprpall.core.endorsemanage.queryendorse.entity;

import com.sinosoft.framework.core.dao.BasePKImpl;
import javax.persistence.*;

/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-11-27 08:22:16.508 
 * PrpCPrenewal主键操作对象
 */
public class PrpCPrenewalKey extends BasePKImpl{
	private static final long serialVersionUID = 1L;
	public PrpCPrenewalKey(){}
	public PrpCPrenewalKey(String policyNo){
		this.policyNo = policyNo;
	}
	/** 属性保单号/保单号 */
	@Column(name = "policyNo")
	private String policyNo ;
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
}