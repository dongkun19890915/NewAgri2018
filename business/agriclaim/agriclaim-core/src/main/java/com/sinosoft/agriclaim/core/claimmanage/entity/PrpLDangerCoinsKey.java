package com.sinosoft.agriclaim.core.claimmanage.entity;

import com.sinosoft.framework.core.dao.BasePKImpl;

import javax.persistence.Column;

/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2018-04-11 07:01:52.256 
 * 危险单位标的表主键操作对象
 */
public class PrpLDangerCoinsKey extends BasePKImpl{
	private static final long serialVersionUID = 1L;
	public PrpLDangerCoinsKey(){}
	public PrpLDangerCoinsKey(String certiNo, Integer dangerNo, Integer serialNo, Integer claimAddTimes){
		this.certiNo = certiNo;
		this.dangerNo = dangerNo;
		this.serialNo = serialNo;
		this.claimAddTimes = claimAddTimes;
	}
	/** 属性业务号/业务号 */
	@Column(name = "certiNo")
	private String certiNo ;
	/** 属性dangerNo/dangerNo */
	@Column(name = "dangerNo")
	private Integer dangerNo ;
	/** 属性序号/序号 */
	@Column(name = "serialNo")
	private Integer serialNo ;
	/** 属性估损增加次数/估损增加次数 */
	@Column(name = "claimAddTimes")
	private Integer claimAddTimes ;
	/**
	 * 属性业务号/业务号的getter方法
	 */
	public String getCertiNo() {
    		return certiNo;
	}
	/**
	 * 属性业务号/业务号的setter方法
	 */
	public void setCertiNo(String certiNo) {
		this.certiNo = certiNo;
	} 
	/**
	 * 属性dangerNo/dangerNo的getter方法
	 */
	public Integer getDangerNo() {
    		return dangerNo;
	}
	/**
	 * 属性dangerNo/dangerNo的setter方法
	 */
	public void setDangerNo(Integer dangerNo) {
		this.dangerNo = dangerNo;
	} 
	/**
	 * 属性序号/序号的getter方法
	 */
	public Integer getSerialNo() {
    		return serialNo;
	}
	/**
	 * 属性序号/序号的setter方法
	 */
	public void setSerialNo(Integer serialNo) {
		this.serialNo = serialNo;
	} 
	/**
	 * 属性估损增加次数/估损增加次数的getter方法
	 */
	public Integer getClaimAddTimes() {
    		return claimAddTimes;
	}
	/**
	 * 属性估损增加次数/估损增加次数的setter方法
	 */
	public void setClaimAddTimes(Integer claimAddTimes) {
		this.claimAddTimes = claimAddTimes;
	} 
}