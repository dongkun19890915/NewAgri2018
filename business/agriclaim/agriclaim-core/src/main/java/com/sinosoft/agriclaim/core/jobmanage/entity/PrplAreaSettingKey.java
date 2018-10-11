package com.sinosoft.agriclaim.core.jobmanage.entity;

import com.sinosoft.framework.core.dao.BasePKImpl;
import javax.persistence.*;

/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-11-08 05:42:38.981
 * 区域设置表主键操作对象
 */
public class PrplAreaSettingKey extends BasePKImpl{
	private static final long serialVersionUID = 1L;
	public PrplAreaSettingKey(){}
	public PrplAreaSettingKey(Long id){
		this.id = id;
	}
	/** 属性主键/主键 */
	private Long id ;
	/**
	 * 属性主键/主键的getter方法
	 */
	public Long getId() {
		return id;
	}
	/**
	 * 属性主键/主键的setter方法
	 */
	public void setId(Long id) {
		this.id = id;
	}
}