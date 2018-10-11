package com.sinosoft.ims.core.auth.entity;

import com.sinosoft.framework.core.dao.BaseEntityImpl;

import javax.persistence.*;

/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-11-13 07:55:48.156 
 * 常用菜单信息表实体操作对象
 */
@Entity
@Table(name = "UtiUserMenu")
@IdClass(UtiUserMenuKey.class)
public class UtiUserMenu extends BaseEntityImpl{

	private static final long serialVersionUID = 1L;
	/** 属性用户代码/用户代码 */
	@Id
	@Column(name = "userCode")
	private String userCode ;/** 属性菜单编号/菜单编号 */
	@Id
	@Column(name = "menuId")
	private Integer menuId ;
    @Id
    @Column(name = "comCode")
    private String comCode;

	/** 属性系统代码/系统代码 */
	@Column(name = "systemCode")
	private String systemCode ;
	/** 属性菜单名称/菜单名称 */
	@Column(name = "menuCName")
	private String menuCName ;
	/** 属性菜单链接/菜单链接 */
	@Column(name = "url")
	private String url ;
	/** 属性菜单图标地址/菜单图标地址 */
	@Column(name = "iconExpand")
	private String iconExpand ;
	/** 属性有效标识/有效标识 */
	@Column(name = "validStatus")
	private String validStatus ;
	/** 属性系统标识/系统标识 */
	@Column(name = "sysFlag")
	private String sysFlag ;

    public String getComCode() {
        return comCode;
    }

    public void setComCode(String comCode) {
        this.comCode = comCode;
    }

	public String getSysFlag() {
		return sysFlag;
	}

	public void setSysFlag(String sysFlag) {
		this.sysFlag = sysFlag;
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
	 * 属性系统代码/系统代码的getter方法
	 */
	public String getSystemCode() {
		return systemCode;
	}
	/**
	 * 属性系统代码/系统代码的setter方法
	 */
	public void setSystemCode(String systemCode) {
		this.systemCode = systemCode;
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
	/**
	 * 属性菜单名称/菜单名称的getter方法
	 */
	public String getMenuCName() {
		return menuCName;
	}
	/**
	 * 属性菜单名称/菜单名称的setter方法
	 */
	public void setMenuCName(String menuCName) {
		this.menuCName = menuCName;
	} 	
	/**
	 * 属性菜单链接/菜单链接的getter方法
	 */
	public String getUrl() {
		return url;
	}
	/**
	 * 属性菜单链接/菜单链接的setter方法
	 */
	public void setUrl(String url) {
		this.url = url;
	} 	
	/**
	 * 属性菜单图标地址/菜单图标地址的getter方法
	 */
	public String getIconExpand() {
		return iconExpand;
	}
	/**
	 * 属性菜单图标地址/菜单图标地址的setter方法
	 */
	public void setIconExpand(String iconExpand) {
		this.iconExpand = iconExpand;
	} 	
	/**
	 * 属性有效标识/有效标识的getter方法
	 */
	public String getValidStatus() {
		return validStatus;
	}
	/**
	 * 属性有效标识/有效标识的setter方法
	 */
	public void setValidStatus(String validStatus) {
		this.validStatus = validStatus;
	} 	
		
		
		
		
}