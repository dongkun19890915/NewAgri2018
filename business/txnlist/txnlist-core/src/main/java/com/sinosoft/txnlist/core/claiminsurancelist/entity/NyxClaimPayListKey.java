package com.sinosoft.txnlist.core.claiminsurancelist.entity;

import com.sinosoft.framework.core.dao.BasePKImpl;
import javax.persistence.*;

/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2018-01-02 07:30:32.914 
 * 理赔支付清单表主键操作对象
 */
public class NyxClaimPayListKey extends BasePKImpl{
	private static final long serialVersionUID = 1L;
	public NyxClaimPayListKey(){}
	public NyxClaimPayListKey(String listNo,String serialNo){
		this.listNo = listNo;
		this.serialNo = serialNo;
	}
	/** 属性理赔支付清单号/理赔支付清单号 */
	@Column(name = "listNo")
	private String listNo ;
	/** 属性序号/序号 */
	@Column(name = "serialNo")
	private String serialNo ;
	/**
	 * 属性理赔支付清单号/理赔支付清单号的getter方法
	 */
	public String getListNo() {
    		return listNo;
	}
	/**
	 * 属性理赔支付清单号/理赔支付清单号的setter方法
	 */
	public void setListNo(String listNo) {
		this.listNo = listNo;
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
}