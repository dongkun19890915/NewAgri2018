package com.sinosoft.ims.core.auth.entity;

import com.sinosoft.framework.core.dao.BasePKImpl;
import javax.persistence.*;

/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-11-05 01:10:45.148 
 * UtiGroup主键操作对象
 */
public class UtiGroupKey extends BasePKImpl{
	private static final long serialVersionUID = 1L;
	public UtiGroupKey(){}
	public UtiGroupKey(String groupCode){
		this.groupCode = groupCode;
	}
	/** 属性groupCode/groupCode */
	@Column(name = "groupCode")
	private String groupCode ;
	/**
	 * 属性groupCode/groupCode的getter方法
	 */
	public String getGroupCode() {
    		return groupCode;
	}
	/**
	 * 属性groupCode/groupCode的setter方法
	 */
	public void setGroupCode(String groupCode) {
		this.groupCode = groupCode;
	} 
}