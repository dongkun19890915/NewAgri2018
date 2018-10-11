package com.sinosoft.agriclaim.core.cetainmanage.entity;

import com.sinosoft.framework.core.dao.BasePKImpl;
import javax.persistence.*;

/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-11-08 05:36:28.690 
 * 确定损失表（无表名）主键操作对象
 */
public class PrpLCetainLossKey extends BasePKImpl{
	private static final long serialVersionUID = 1L;
	public PrpLCetainLossKey(){}
	public PrpLCetainLossKey(java.lang.Double id){
		this.id = id;
	}
	/** 属性主键/主键 */
	@Column(name = "id")
	private java.lang.Double id ;
	/**
	 * 属性主键/主键的getter方法
	 */
	public java.lang.Double getId() {
    		return id;
	}
	/**
	 * 属性主键/主键的setter方法
	 */
	public void setId(java.lang.Double id) {
		this.id = id;
	} 
}