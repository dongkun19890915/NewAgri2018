package com.sinosoft.ims.core.auth.entity;

import com.sinosoft.framework.core.dao.BasePKImpl;

/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-09-15 09:35:32.173 
 * 菜单表主键操作对象
 */
public class UtiMenuKey extends BasePKImpl{
	private static final long serialVersionUID = 1L;
	public UtiMenuKey(){}
	public UtiMenuKey(String menuId){
		this.menuId = menuId;
	}
	/** 属性菜单ID/菜单ID */
	private String menuId ;
	/**
	 * 属性菜单ID/菜单ID的getter方法
	 */
	public String getMenuId() {
    		return menuId;
	}
	/**
	 * 属性菜单ID/菜单ID的setter方法
	 */
	public void setMenuId(String menuId) {
		this.menuId = menuId;
	} 
}