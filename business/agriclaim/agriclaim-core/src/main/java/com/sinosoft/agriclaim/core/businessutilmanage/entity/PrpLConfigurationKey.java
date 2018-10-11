package com.sinosoft.agriclaim.core.businessutilmanage.entity;

import com.sinosoft.framework.core.dao.BasePKImpl;
import javax.persistence.*;

/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-12-25 10:18:44.285 
 * 条款公式配置表 主键操作对象
 */
public class PrpLConfigurationKey extends BasePKImpl{
	private static final long serialVersionUID = 1L;
	public PrpLConfigurationKey(){}
	public PrpLConfigurationKey(String id){
		this.id = id;
	}
	/** 属性序号，唯一标识/序号，唯一标识 */
	@Column(name = "id")
	private String id ;
	/**
	 * 属性序号，唯一标识/序号，唯一标识的getter方法
	 */
	public String getId() {
    		return id;
	}
	/**
	 * 属性序号，唯一标识/序号，唯一标识的setter方法
	 */
	public void setId(String id) {
		this.id = id;
	} 
}