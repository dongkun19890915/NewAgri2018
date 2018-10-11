package com.sinosoft.agriclaim.core.paymentmanage.entity;

import com.sinosoft.framework.core.dao.BasePKImpl;
import javax.persistence.*;

/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2018-01-11 08:55:21.509 
 * 理赔清单数据管理表主键操作对象
 */
public class PrpLClaimBillManagerKey extends BasePKImpl{
	private static final long serialVersionUID = 1L;
	public PrpLClaimBillManagerKey(){}
	public PrpLClaimBillManagerKey(String registNo,String compensateNo,int serialNo){
		this.registNo = registNo;
		this.compensateNo = compensateNo;
		this.serialNo = serialNo;
	}
	/** 属性报案号/报案号 */
	@Column(name = "registNo")
	private String registNo ;
	/** 属性理算书号/理算书号 */
	@Column(name = "compensateNo")
	private String compensateNo ;
	/** 属性序号/序号 */
	@Column(name = "serialNo")
	private int serialNo ;
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
	 * 属性理算书号/理算书号的getter方法
	 */
	public String getCompensateNo() {
    		return compensateNo;
	}
	/**
	 * 属性理算书号/理算书号的setter方法
	 */
	public void setCompensateNo(String compensateNo) {
		this.compensateNo = compensateNo;
	} 
	/**
	 * 属性序号/序号的getter方法
	 */
	public int getSerialNo() {
    		return serialNo;
	}
	/**
	 * 属性序号/序号的setter方法
	 */
	public void setSerialNo(int serialNo) {
		this.serialNo = serialNo;
	} 
}