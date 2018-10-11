package com.sinosoft.txnlist.core.plantinginsurancelist.entity;

import com.sinosoft.framework.core.dao.BasePKImpl;
import javax.persistence.*;

/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-11-18 08:36:26.740 
 * settlemainlist主键操作对象
 */
public class SettleMainListKey extends BasePKImpl{
	private static final long serialVersionUID = 1L;
	public SettleMainListKey(){}
	public SettleMainListKey(String settleListCode){
		this.settleListCode = settleListCode;
	}
	/** 属性理赔清单号（KEY）/理赔清单号（KEY） */
	@Column(name = "settleListCode")
	private String settleListCode ;
	/**
	 * 属性理赔清单号（KEY）/理赔清单号（KEY）的getter方法
	 */
	public String getSettleListCode() {
    		return settleListCode;
	}
	/**
	 * 属性理赔清单号（KEY）/理赔清单号（KEY）的setter方法
	 */
	public void setSettleListCode(String settleListCode) {
		this.settleListCode = settleListCode;
	} 
}