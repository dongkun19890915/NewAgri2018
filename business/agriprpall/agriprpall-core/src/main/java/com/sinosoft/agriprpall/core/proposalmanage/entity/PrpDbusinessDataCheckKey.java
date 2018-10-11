package com.sinosoft.agriprpall.core.proposalmanage.entity;

import com.sinosoft.framework.core.dao.BasePKImpl;

import javax.persistence.Column;

/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-10-31 01:52:20.999 
 * 业务数据检查表主键操作对象
 */
public class PrpDbusinessDataCheckKey extends BasePKImpl{
	private static final long serialVersionUID = 1L;
	public PrpDbusinessDataCheckKey(){}
	public PrpDbusinessDataCheckKey(String id){
		this.id = id;
	}
	/** 属性uuid/uuid */
	@Column(name = "id")
	private String id;
	/**
	 * 属性uuid/uuid的getter方法
	 */
	public String getId() {
    		return id;
	}
	/**
	 * 属性uuid/uuid的setter方法
	 */
	public void setId(String id) {
		this.id = id;
	} 
}