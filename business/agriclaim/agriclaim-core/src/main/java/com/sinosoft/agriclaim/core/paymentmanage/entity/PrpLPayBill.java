package com.sinosoft.agriclaim.core.paymentmanage.entity;

import com.sinosoft.framework.core.dao.BaseEntityImpl;
import javax.persistence.*;
import java.util.Date;

/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-12-14 09:04:11.816 
 * 支付信息对应清单主键表实体操作对象
 */
@Entity
@Table(name = "PrpLPayBill")
@IdClass(PrpLPayBillKey.class)
public class PrpLPayBill extends BaseEntityImpl{

	private static final long serialVersionUID = 1L;
	/** 属性支付号/支付号 */
	@Id
	@Column(name = "paymentNo")
	private String paymentNo ;
	/** 属性报案号/报案号 */
	@Id
	@Column(name = "registNo")
	private String registNo ;
	/** 属性计算书号/计算书号 */
	@Id
	@Column(name = "compensateNo")
	private String compensateNo ;
	/** 属性序号/序号 */
	@Id
	@Column(name = "serialNo")
	private Integer serialNo ;
	/** 属性清单号/清单号 */
	@Column(name = "billNo")
	private String billNo ;




	/** 属性支付金额/支付金额 */
	@Column(name = "payAmount")
	private Double payAmount ;
	/** 属性业务号/业务号 */
	@Column(name = "businessNo")
	private String businessNo ;
	/**
	 * 属性清单号/清单号的getter方法
	 */
	public String getBillNo() {
		return billNo;
	}
	/**
	 * 属性清单号/清单号的setter方法
	 */
	public void setBillNo(String billNo) {
		this.billNo = billNo;
	} 	
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
	/**
	 * 属性支付金额/支付金额的getter方法
	 */
	public Double getPayAmount() {
		return payAmount;
	}
	/**
	 * 属性支付金额/支付金额的setter方法
	 */
	public void setPayAmount(Double payAmount) {
		this.payAmount = payAmount;
	} 	
	/**
	 * 属性业务号/业务号的getter方法
	 */
	public String getBusinessNo() {
		return businessNo;
	}
	/**
	 * 属性业务号/业务号的setter方法
	 */
	public void setBusinessNo(String businessNo) {
		this.businessNo = businessNo;
	} 	
}