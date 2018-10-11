package com.sinosoft.agriclaim.core.prepaymanage.entity;

import com.sinosoft.framework.core.dao.BasePKImpl;
import javax.persistence.*;

/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-11-08 05:44:02.119 
 * 代理赔保单信息表主键操作对象
 */
public class PrpLClaimagentKey extends BasePKImpl{
	private static final long serialVersionUID = 1L;
	public PrpLClaimagentKey(){}
	public PrpLClaimagentKey(String claimNo){
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