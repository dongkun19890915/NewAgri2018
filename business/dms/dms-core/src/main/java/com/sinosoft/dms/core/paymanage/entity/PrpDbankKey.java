package com.sinosoft.dms.core.paymanage.entity;

import com.sinosoft.framework.core.dao.BasePKImpl;
import javax.persistence.*;

/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2018-02-13 03:08:45.046 
 * 银行定义表主键操作对象
 */
public class PrpDbankKey extends BasePKImpl{
	private static final long serialVersionUID = 1L;
	public PrpDbankKey(){}
	public PrpDbankKey(String bankCode){
		this.bankCode = bankCode;
	}
	/** 属性银行代码（银行提供）/银行代码（银行提供） */
	@Column(name = "bankCode")
	private String bankCode ;
	/**
	 * 属性银行代码（银行提供）/银行代码（银行提供）的getter方法
	 */
	public String getBankCode() {
    		return bankCode;
	}
	/**
	 * 属性银行代码（银行提供）/银行代码（银行提供）的setter方法
	 */
	public void setBankCode(String bankCode) {
		this.bankCode = bankCode;
	} 
}