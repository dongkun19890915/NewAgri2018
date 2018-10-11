package com.sinosoft.agriclaim.core.compensatemanage.entity;

import com.sinosoft.framework.core.dao.BasePKImpl;
import javax.persistence.*;

/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-11-22 07:48:26.564 
 * 账户信息表主键操作对象
 */
public class PrpLsumpayKey extends BasePKImpl{
	private static final long serialVersionUID = 1L;
	public PrpLsumpayKey(){}
	public PrpLsumpayKey(String serialNo,String claimNo){
		this.serialNo = serialNo;
		this.claimNo = claimNo;
	}
	/** 属性序号/序号 */
	@Column(name = "serialNo")
	private String serialNo ;
	/** 属性立案号/立案号 */
	@Column(name = "claimNo")
	private String claimNo ;
	/**
	 * 属性序号/序号的getter方法
	 */
	public String getSerialNo() {
    		return serialNo;
	}
	/**
	 * 属性序号/序号的setter方法
	 */
	public void setSerialNo(String serialNo) {
		this.serialNo = serialNo;
	} 
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