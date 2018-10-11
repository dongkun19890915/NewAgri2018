package com.sinosoft.agriclaim.core.businessutilmanage.entity;

import com.sinosoft.framework.core.dao.BasePKImpl;
import javax.persistence.*;

/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-11-08 05:35:28.283 
 * 共保费用信息表（无表名）主键操作对象
 */
public class PrpLCfeecoinsKey extends BasePKImpl{
	private static final long serialVersionUID = 1L;
	public PrpLCfeecoinsKey(){}
	public PrpLCfeecoinsKey(String businessNo,java.lang.Double serialNo){
		this.businessNo = businessNo;
		this.serialNo = serialNo;
	}
	/** 属性业务号/业务号 */
	@Column(name = "businessNo")
	private String businessNo ;
	/** 属性序号/序号 */
	@Column(name = "serialNo")
	private java.lang.Double serialNo ;
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
	/**
	 * 属性序号/序号的getter方法
	 */
	public java.lang.Double getSerialNo() {
    		return serialNo;
	}
	/**
	 * 属性序号/序号的setter方法
	 */
	public void setSerialNo(java.lang.Double serialNo) {
		this.serialNo = serialNo;
	} 
}