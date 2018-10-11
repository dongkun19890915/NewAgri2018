package com.sinosoft.agriprpall.core.endorsemanage.commonendorse.entity;

import com.sinosoft.framework.core.dao.BasePKImpl;

import javax.persistence.Column;

/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-11-06 07:02:50.066 
 * 收费计划表主键操作对象
 */
public class PrpCPplanCoinsKey extends BasePKImpl{
	private static final long serialVersionUID = 1L;
	public PrpCPplanCoinsKey(){}
	public PrpCPplanCoinsKey(String policyNo,Integer serialNo,String payReason,String coinsCode){
		this.policyNo = policyNo;
		this.serialNo = serialNo;
		this.payReason = payReason;
		this.coinsCode = coinsCode;
	}
	/** 属性保单号码/保单号码 */
	@Column(name = "policyNo")
	private String policyNo ;
	/** 属性缴费次数序号/缴费次数序号 */
	@Column(name = "serialNo")
	private Integer serialNo ;
	/** 属性缴费原因/缴费原因 */
	@Column(name = "payReason")
	private String payReason ;
	/** 属性coinsCode/coinsCode */
	@Column(name = "coinsCode")
	private String coinsCode ;
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
	/**
	 * 属性缴费次数序号/缴费次数序号的getter方法
	 */
	public Integer getSerialNo() {
    		return serialNo;
	}
	/**
	 * 属性缴费次数序号/缴费次数序号的setter方法
	 */
	public void setSerialNo(Integer serialNo) {
		this.serialNo = serialNo;
	} 
	/**
	 * 属性缴费原因/缴费原因的getter方法
	 */
	public String getPayReason() {
    		return payReason;
	}
	/**
	 * 属性缴费原因/缴费原因的setter方法
	 */
	public void setPayReason(String payReason) {
		this.payReason = payReason;
	} 
	/**
	 * 属性coinsCode/coinsCode的getter方法
	 */
	public String getCoinsCode() {
    		return coinsCode;
	}
	/**
	 * 属性coinsCode/coinsCode的setter方法
	 */
	public void setCoinsCode(String coinsCode) {
		this.coinsCode = coinsCode;
	} 
}