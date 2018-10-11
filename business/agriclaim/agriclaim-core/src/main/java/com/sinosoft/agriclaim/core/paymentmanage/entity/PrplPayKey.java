package com.sinosoft.agriclaim.core.paymentmanage.entity;

import com.sinosoft.framework.core.dao.BasePKImpl;
import javax.persistence.*;

/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-11-08 05:43:17.258 
 * 支付信息子表主键操作对象
 */
public class PrplPayKey extends BasePKImpl{
	private static final long serialVersionUID = 1L;
	public PrplPayKey(){}
	public PrplPayKey(String serialNo,String serialNo2){
		this.serialNo = serialNo;
		this.serialNo2 = serialNo2;
	}
	/** 属性序号/序号 */
	@Column(name = "serialNo")
	private String serialNo ;
	/** 属性新增序号列，联合主键/新增序号列，联合主键 */
	@Column(name = "serialNo2")
	private String serialNo2 ;
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
	 * 属性新增序号列，联合主键/新增序号列，联合主键的getter方法
	 */
	public String getSerialNo2() {
    		return serialNo2;
	}
	/**
	 * 属性新增序号列，联合主键/新增序号列，联合主键的setter方法
	 */
	public void setSerialNo2(String serialNo2) {
		this.serialNo2 = serialNo2;
	} 
}