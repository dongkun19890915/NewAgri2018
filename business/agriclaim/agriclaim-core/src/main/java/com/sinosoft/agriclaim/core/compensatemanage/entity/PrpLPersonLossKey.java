package com.sinosoft.agriclaim.core.compensatemanage.entity;

import com.sinosoft.framework.core.dao.BasePKImpl;

import javax.persistence.Column;

/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-11-08 05:40:44.225 
 * 赔付标的信息表主键操作对象
 */
public class PrpLPersonLossKey extends BasePKImpl{
	private static final long serialVersionUID = 1L;
	public PrpLPersonLossKey(){}
	public PrpLPersonLossKey(String compensateNo, Integer serialNo){
		this.compensateNo = compensateNo;
		this.serialNo = serialNo;
	}
	/** 属性赔款计算书号/赔款计算书号 */
	@Column(name = "compensateNo")
	private String compensateNo ;
	/** 属性赔付标的序号/赔付标的序号 */
	@Column(name = "serialNo")
	private Integer serialNo ;
	/**
	 * 属性赔款计算书号/赔款计算书号的getter方法
	 */
	public String getCompensateNo() {
    		return compensateNo;
	}
	/**
	 * 属性赔款计算书号/赔款计算书号的setter方法
	 */
	public void setCompensateNo(String compensateNo) {
		this.compensateNo = compensateNo;
	}
	/**
	 * 属性赔付标的序号/赔付标的序号的getter方法
	 */
	public Integer getSerialNo() {
    		return serialNo;
	}
	/**
	 * 属性赔付标的序号/赔付标的序号的setter方法
	 */
	public void setSerialNo(Integer serialNo) {
		this.serialNo = serialNo;
	} 
}