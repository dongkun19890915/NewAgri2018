package com.sinosoft.dms.core.dict.entity;

import com.sinosoft.framework.core.dao.BasePKImpl;
import io.swagger.models.auth.In;

import javax.persistence.*;

/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-11-05 01:01:20.710 
 * PrpCountryCode主键操作对象
 */
public class PrpCountryCodeKey extends BasePKImpl{
	private static final long serialVersionUID = 1L;
	public PrpCountryCodeKey(){}
	public PrpCountryCodeKey(Integer id){
		this.id = id;
	}
	/** 属性id/id */
	@Column(name = "id")
	private Integer id ;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
}