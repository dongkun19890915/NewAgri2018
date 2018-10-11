package com.sinosoft.ims.core.auth.entity;

import com.sinosoft.framework.core.dao.BasePKImpl;
import javax.persistence.*;

/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-11-13 07:56:24.672 
 * 常用菜单图标信息表主键操作对象
 */
public class UtiUserMenuImageKey extends BasePKImpl{
	private static final long serialVersionUID = 1L;
	public UtiUserMenuImageKey(){}
	public UtiUserMenuImageKey(String imageId){
		this.imageId = imageId;
	}
	/** 属性图标编号/图标编号 */
	@Column(name = "imageId")
	private String imageId ;
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
}