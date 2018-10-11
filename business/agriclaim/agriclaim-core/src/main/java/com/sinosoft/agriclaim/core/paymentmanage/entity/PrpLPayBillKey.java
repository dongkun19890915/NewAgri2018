package com.sinosoft.agriclaim.core.paymentmanage.entity;

import com.sinosoft.framework.core.dao.BasePKImpl;
import javax.persistence.*;

/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-12-14 09:04:11.816 
 * 支付信息对应清单主键表主键操作对象
 */
public class PrpLPayBillKey extends BasePKImpl{
	private static final long serialVersionUID = 1L;
	public PrpLPayBillKey(){}
	public PrpLPayBillKey(String paymentNo,String registNo,String compensateNo,Integer serialNo){
		this.paymentNo = paymentNo;
		this.registNo = registNo;
		this.compensateNo = compensateNo;
		this.serialNo = serialNo;
	}
	/** 属性支付号/支付号 */
	@Column(name = "paymentNo")
	private String paymentNo ;
	/** 属性报案号/报案号 */
	@Column(name = "registNo")
	private String registNo ;
	/** 属性计算书号/计算书号 */
	@Column(name = "compensateNo")
	private String compensateNo ;
	/** 属性序号/序号 */
	@Column(name = "serialNo")
	private Integer serialNo ;
	/**
	 * 属性支付号/支付号的getter方法
	 */
	public String getPaymentNo() {
    		return paymentNo;
	}
	/**
	 * 属性支付号/支付号的setter方法
	 */
	public void setPaymentNo(String paymentNo) {
		this.paymentNo = paymentNo;
	} 
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
	/**
	 * 属性计算书号/计算书号的getter方法
	 */
	public String getCompensateNo() {
    		return compensateNo;
	}
	/**
	 * 属性计算书号/计算书号的setter方法
	 */
	public void setCompensateNo(String compensateNo) {
		this.compensateNo = compensateNo;
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
}