package com.sinosoft.dms.core.billno.entity;

import com.sinosoft.framework.core.dao.BasePKImpl;
import javax.persistence.*;

/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-11-05 01:02:29.563 
 * 影像表主键操作对象
 */
public class PrpmaterialKey extends BasePKImpl{
	private static final long serialVersionUID = 1L;
	public PrpmaterialKey(){}
	public PrpmaterialKey(String businessNo,Integer serialNo){
		this.businessNo = businessNo;
		this.serialNo = serialNo;
	}
	/** 属性业务号/业务号 */
	@Column(name = "businessNo")
	private String businessNo ;
	/** 属性序号/序号 */
	@Column(name = "serialNo")
	private Integer serialNo ;
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