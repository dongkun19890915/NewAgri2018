package com.sinosoft.agriclaim.core.workflowmanage.entity;

import com.sinosoft.framework.core.dao.BasePKImpl;
import javax.persistence.*;

/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2018-01-23 10:17:47.442 
 * 自动理赔清单数据表主键操作对象
 */
public class PrpLAutoClaimListKey extends BasePKImpl{
	private static final long serialVersionUID = 1L;
	public PrpLAutoClaimListKey(){}
	public PrpLAutoClaimListKey(String registNo){
		this.registNo = registNo;
	}
	/** 属性报案号/报案号 */
	@Column(name = "registNo")
	private String registNo ;
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
}