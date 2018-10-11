package com.sinosoft.ims.core.auth.entity;

import com.sinosoft.framework.core.dao.BaseEntityImpl;
import javax.persistence.*;
import java.util.Date;

/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-11-13 07:56:24.672 
 * 常用菜单图标信息表实体操作对象
 */
@Entity
@Table(name = "UtiUserMenuImage")
@IdClass(UtiUserMenuImageKey.class)
public class UtiUserMenuImage extends BaseEntityImpl{

	private static final long serialVersionUID = 1L;
	/** 属性图标编号/图标编号 */
	@Id
	@Column(name = "imageId")
	private String imageId ;	

	/** 属性图标名称/图标名称 */
	@Column(name = "imageCName")
	private String imageCName ;
	/** 属性图标地址/图标地址 */
	@Column(name = "iconExpand")
	private String iconExpand ;
	/** 属性有效标识/有效标识 */
	@Column(name = "validStatus")
	private String validStatus ;
	/** 属性系统标识/系统标识 */
	@Column(name = "sysFlag")
	private String sysFlag ;


	public String getSysFlag() {
		return sysFlag;
	}

	public void setSysFlag(String sysFlag) {
		this.sysFlag = sysFlag;
	}
	/**
	 * 属性图标编号/图标编号的getter方法
	 */
	public String getImageId() {
		return imageId;
	}
	/**
	 * 属性图标编号/图标编号的setter方法
	 */
	public void setImageId(String imageId) {
		this.imageId = imageId;
	} 	
	/**
	 * 属性图标名称/图标名称的getter方法
	 */
	public String getImageCName() {
		return imageCName;
	}
	/**
	 * 属性图标名称/图标名称的setter方法
	 */
	public void setImageCName(String imageCName) {
		this.imageCName = imageCName;
	} 	
	/**
	 * 属性图标地址/图标地址的getter方法
	 */
	public String getIconExpand() {
		return iconExpand;
	}
	/**
	 * 属性图标地址/图标地址的setter方法
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