package com.sinosoft.agriclaim.core.individuation.entity;

import com.sinosoft.framework.core.dao.BasePKImpl;

import javax.persistence.Column;

/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-11-22 08:23:52.676 
 * 支付信息轨迹表主键操作对象
 */
public class PrpLsumpayLogKey extends BasePKImpl{
	private static final long serialVersionUID = 1L;
	public PrpLsumpayLogKey(){}
	public PrpLsumpayLogKey(String claimNo,String serialNo,String logNo){
		this.claimNo = claimNo;
		this.serialNo = serialNo;
		this.logNo = logNo;
	}
	/** 属性立案号/立案号 */
	@Column(name = "claimNo")
	private String claimNo ;
	/** 属性序号/序号 */
	@Column(name = "serialNo")
	private String serialNo ;
	/** 属性轨迹序号/轨迹序号 */
	@Column(name = "logNo")
	private String logNo ;
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
	 * 属性轨迹序号/轨迹序号的getter方法
	 */
	public String getLogNo() {
    		return logNo;
	}
	/**
	 * 属性轨迹序号/轨迹序号的setter方法
	 */
	public void setLogNo(String logNo) {
		this.logNo = logNo;
	} 
}