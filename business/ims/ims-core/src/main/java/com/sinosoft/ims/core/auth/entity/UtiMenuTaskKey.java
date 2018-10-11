package com.sinosoft.ims.core.auth.entity;

import com.sinosoft.framework.core.dao.BasePKImpl;
import javax.persistence.*;

/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-11-05 01:10:45.148 
 * UtiMenuTask主键操作对象
 */
public class UtiMenuTaskKey extends BasePKImpl{
	private static final long serialVersionUID = 1L;
	public UtiMenuTaskKey(){}
	public UtiMenuTaskKey(String menuId){
		this.menuId = menuId;
	}
	/** 属性menuId/menuId */
	@Column(name = "menuId")
	private String menuId ;
	/**
	 * 属性menuId/menuId的getter方法
	 */
	public String getMenuId() {
    		return menuId;
	}
	/**
	 * 属性menuId/menuId的setter方法
	 */
	public void setMenuId(String menuId) {
		this.menuId = menuId;
	} 
}