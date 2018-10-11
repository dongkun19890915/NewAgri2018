package com.sinosoft.txnlist.core.insuremainlist.entity;

import com.sinosoft.framework.core.dao.BasePKImpl;
import javax.persistence.*;

/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-10-17 07:14:54.112 
 * 清单主表主键操作对象
 */
public class InsureMainListKey extends BasePKImpl{
	private static final long serialVersionUID = 1L;
	public InsureMainListKey(){}

	/**
	 *
	 * @param inusreListCode
	 */
	public InsureMainListKey(String inusreListCode){
		this.inusreListCode = inusreListCode;
	}
	/** 属性投保清单编号（key）/投保清单编号（key） */
	@Column(name = "inusreListCode")
	private String inusreListCode ;
	/**
	 * 属性投保清单编号（key）/投保清单编号（key）的getter方法
	 */
	public String getInusreListCode() {
    		return inusreListCode;
	}
	/**
	 * 属性投保清单编号（key）/投保清单编号（key）的setter方法
	 */
	public void setInusreListCode(String inusreListCode) {
		this.inusreListCode = inusreListCode;
	} 
}