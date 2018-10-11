package com.sinosoft.agriclaim.core.claimmanage.entity;

import com.sinosoft.framework.core.dao.BasePKImpl;
import javax.persistence.*;

/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-11-08 05:39:53.061 
 * 立案保单清单表主键操作对象
 */
public class PrpLClaimPolicyKey extends BasePKImpl{
	private static final long serialVersionUID = 1L;
	public PrpLClaimPolicyKey(){}
	public PrpLClaimPolicyKey(String claimNo){
		this.claimNo = claimNo;
	}
	/** 属性立案号/立案号 */
	@Column(name = "claimNo")
	private String claimNo ;
	/**
	 * 属性立案号/立案号的getter方法
	 */
	public String getClaimNo() {
    		return claimNo;
	}
	/**
	 * 属性立案号/立案号的setter方法
	 */
	public void setClaimNo(String claimNo) {
		this.claimNo = claimNo;
	} 
}