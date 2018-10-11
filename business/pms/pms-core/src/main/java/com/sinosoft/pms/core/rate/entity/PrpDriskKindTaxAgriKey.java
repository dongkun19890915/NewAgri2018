package com.sinosoft.pms.core.rate.entity;

import com.sinosoft.framework.core.dao.BasePKImpl;

/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-08-29 07:14:25.063 
 * 险种险别增值税基础税率配置表主键操作对象
 */
public class PrpDriskKindTaxAgriKey extends BasePKImpl{
	private static final long serialVersionUID = 1L;
	public PrpDriskKindTaxAgriKey(){}
	public PrpDriskKindTaxAgriKey(Integer UUID){
		this.UUID = UUID;
	}
	/** 属性自增长序列/自增长序列 */
	private Integer UUID ;

	public Integer getUUID() {
		return UUID;
	}

	public void setUUID(Integer UUID) {
		this.UUID = UUID;
	}
}