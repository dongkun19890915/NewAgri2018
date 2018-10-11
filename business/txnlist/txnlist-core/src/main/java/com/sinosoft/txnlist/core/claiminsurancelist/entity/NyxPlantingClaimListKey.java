package com.sinosoft.txnlist.core.claiminsurancelist.entity;

import com.sinosoft.framework.core.dao.BasePKImpl;
import javax.persistence.*;

/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-12-26 03:26:32.072 
 * 种植险理赔清单信息表主键操作对象
 */
public class NyxPlantingClaimListKey extends BasePKImpl{
	private static final long serialVersionUID = 1L;
	public NyxPlantingClaimListKey(){}
	public NyxPlantingClaimListKey(String listNo,String serialNo){
		this.listNo = listNo;
		this.serialNo = serialNo;
	}
	/** 属性理赔清单号/理赔清单号 */
	@Column(name = "listNo")
	private String listNo ;
	/** 属性序号/序号 */
	@Column(name = "serialNo")
	private String serialNo ;
	/**
	 * 属性理赔清单号/理赔清单号的getter方法
	 */
	public String getListNo() {
    		return listNo;
	}
	/**
	 * 属性理赔清单号/理赔清单号的setter方法
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