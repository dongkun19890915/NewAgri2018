package com.sinosoft.ims.core.auth.entity;

import com.sinosoft.framework.core.dao.BasePKImpl;

import javax.persistence.Column;
import javax.persistence.Id;

/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-11-13 07:55:48.156 
 * 常用菜单信息表主键操作对象
 */
public class UtiUserMenuKey extends BasePKImpl{
	private static final long serialVersionUID = 1L;
	public UtiUserMenuKey(){}

	public UtiUserMenuKey(String userCode, Integer menuId, String comCode) {
		this.userCode = userCode;
		this.menuId = menuId;
		this.comCode = comCode;
	}
	/** 属性用户代码/用户代码 */
	@Column(name = "userCode")
	private String userCode ;
	/** 属性菜单编号/菜单编号 */
	@Column(name = "menuId")
	private Integer menuId ;
	@Id
	@Column(name = "comCode")
	private String comCode;

	public String getComCode() {
		return comCode;
	}

	public void setComCode(String comCode) {
		this.comCode = comCode;
	}

	/**
	 * 属性用户代码/用户代码的getter方法
	 */
	public String getUserCode() {
    		return userCode;
	}
	/**
	 * 属性用户代码/用户代码的setter方法
	 */
	public void setUserCode(String userCode) {
		this.userCode = userCode;
	} 
	/**
	 * 属性菜单编号/菜单编号的getter方法
	 */
	public Integer getMenuId() {
    		return menuId;
	}
	/**
	 * 属性菜单编号/菜单编号的setter方法
	 */
	public void setMenuId(Integer menuId) {
		this.menuId = menuId;
	} 
}