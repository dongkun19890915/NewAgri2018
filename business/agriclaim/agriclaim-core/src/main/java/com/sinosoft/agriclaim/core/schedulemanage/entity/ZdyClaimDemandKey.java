package com.sinosoft.agriclaim.core.schedulemanage.entity;

import com.sinosoft.framework.core.dao.BasePKImpl;
import javax.persistence.*;

/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-11-10 02:49:33.975 
 * 驻点员App案件推送日志表主键操作对象
 */
public class ZdyClaimDemandKey extends BasePKImpl{
	private static final long serialVersionUID = 1L;
	public ZdyClaimDemandKey(){}
	public ZdyClaimDemandKey(String id){
		this.id = id;
	}
	/** 属性序号/序号 */
	@Column(name = "id")
	private String id ;
	/**
	 * 属性序号/序号的getter方法
	 */
	public String getId() {
    		return id;
	}
	/**
	 * 属性序号/序号的setter方法
	 */
	public void setId(String id) {
		this.id = id;
	} 
}