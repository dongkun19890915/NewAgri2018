package com.sinosoft.agriprpall.core.policymanage.entity;

import com.sinosoft.framework.core.dao.BasePKImpl;
import javax.persistence.*;

/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-10-25 00:11:08.712 
 * 保单信息主表主键操作对象
 */
public class PrpCmainKey extends BasePKImpl{
	private static final long serialVersionUID = 1L;
	public PrpCmainKey(){}
	public PrpCmainKey(String policyNo){
		this.policyNo = policyNo;
	}
	/** 属性保单号码/保单号码 */
	@Column(name = "policyNo")
	private String policyNo ;
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
}