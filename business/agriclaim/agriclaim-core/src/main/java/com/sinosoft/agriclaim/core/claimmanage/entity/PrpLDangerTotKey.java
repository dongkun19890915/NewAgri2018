package com.sinosoft.agriclaim.core.claimmanage.entity;

import com.sinosoft.framework.core.dao.BasePKImpl;
import javax.persistence.*;

/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2018-04-11 07:01:52.256 
 * 危险单位详细表主键操作对象
 */
public class PrpLDangerTotKey extends BasePKImpl{
	private static final long serialVersionUID = 1L;
	public PrpLDangerTotKey(){}
	public PrpLDangerTotKey(String certiNo,Integer dangerNo,String sCurrency,Integer claimAddTimes){
		this.certiNo = certiNo;
		this.dangerNo = dangerNo;
		this.sCurrency = sCurrency;
		this.claimAddTimes = claimAddTimes;
	}
	/** 属性业务号/业务号 */
	@Column(name = "certiNo")
	private String certiNo ;
	/** 属性dangerNo/dangerNo */
	@Column(name = "dangerNo")
	private Integer dangerNo ;
	/** 属性sCurrency/sCurrency */
	@Column(name = "sCurrency")
	private String sCurrency ;
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
	 * 属性sCurrency/sCurrency的getter方法
	 */
	public String getSCurrency() {
    		return sCurrency;
	}
	/**
	 * 属性sCurrency/sCurrency的setter方法
	 */
	public void setSCurrency(String sCurrency) {
		this.sCurrency = sCurrency;
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