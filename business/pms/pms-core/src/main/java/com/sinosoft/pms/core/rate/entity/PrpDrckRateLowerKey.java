package com.sinosoft.pms.core.rate.entity;

import com.sinosoft.framework.core.dao.BasePKImpl;

/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-09-15 09:24:37.739 
 * 产品条款责任费率下限表主键操作对象
 */
public class PrpDrckRateLowerKey extends BasePKImpl{
	private static final long serialVersionUID = 1L;
	public PrpDrckRateLowerKey(){}
	public PrpDrckRateLowerKey(java.lang.Integer rateLowerId){
		this.rateLowerId = rateLowerId;
	}
	/** 属性费率下限代码/费率下限代码 */
	private java.lang.Integer rateLowerId ;
	/**
	 * 属性费率下限代码/费率下限代码的getter方法
	 */
	public java.lang.Integer getRateLowerId() {
    		return rateLowerId;
	}
	/**
	 * 属性费率下限代码/费率下限代码的setter方法
	 */
	public void setRateLowerId(java.lang.Integer rateLowerId) {
		this.rateLowerId = rateLowerId;
	} 
}