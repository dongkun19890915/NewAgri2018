package com.sinosoft.pms.core.kernel.entity;

import com.sinosoft.framework.core.dao.BasePKImpl;

/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-09-15 09:19:57.041 
 * 产品临时代码表主键操作对象
 */
public class PrpDriskNoKey extends BasePKImpl{
	private static final long serialVersionUID = 1L;
	public PrpDriskNoKey(){}
	public PrpDriskNoKey(String id){
		this.id = id;
	}
	/** 属性流水号ID/流水号ID */
	private String id ;
	/**
	 * 属性流水号ID/流水号ID的getter方法
	 */
	public String getId() {
    		return id;
	}
	/**
	 * 属性流水号ID/流水号ID的setter方法
	 */
	public void setId(String id) {
		this.id = id;
	} 
}