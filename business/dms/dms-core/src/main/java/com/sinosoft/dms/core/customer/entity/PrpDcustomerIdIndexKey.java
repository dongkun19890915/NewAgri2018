package com.sinosoft.dms.core.customer.entity;

import com.sinosoft.framework.core.dao.BasePKImpl;
import javax.persistence.*;

/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-11-05 01:01:56.447 
 * PrpDcustomerIdIndex主键操作对象
 */
public class PrpDcustomerIdIndexKey extends BasePKImpl{
	private static final long serialVersionUID = 1L;
	public PrpDcustomerIdIndexKey(){}
	public PrpDcustomerIdIndexKey(String customerId){
		this.customerId = customerId;
	}
	/** 属性ID/ID */
	@Id
	@Column(name = "customerId")
	private String customerId ;

	public String getCustomerId() {
		return customerId;
	}

	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}
}
