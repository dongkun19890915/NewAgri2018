package com.sinosoft.dms.core.dict.entity;

import com.sinosoft.framework.core.dao.BasePKImpl;
import javax.persistence.*;

/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-11-05 01:02:29.563 
 * userInfo主键操作对象
 */
public class UserInfoKey extends BasePKImpl{
	private static final long serialVersionUID = 1L;
	public UserInfoKey(){}
	public UserInfoKey(String id){
		this.id = id;
	}
	/** 属性id/id */
	@Column(name = "id")
	private String id ;
	/**
	 * 属性id/id的getter方法
	 */
	public String getId() {
    		return id;
	}
	/**
	 * 属性id/id的setter方法
	 */
	public void setId(String id) {
		this.id = id;
	} 
}