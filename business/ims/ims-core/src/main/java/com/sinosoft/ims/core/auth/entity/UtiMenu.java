package com.sinosoft.ims.core.auth.entity;

import com.sinosoft.framework.core.dao.BaseEntityImpl;
import javax.persistence.*;
import java.util.Date;

/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-11-05 01:10:45.148 
 * UtiMenu实体操作对象
 */
@Entity
@Table(name = "UtiMenu")
@IdClass(UtiMenuKey.class)
public class UtiMenu extends BaseEntityImpl{

	private static final long serialVersionUID = 1L;
	/** 属性menuId/menuId */
	@Id
	@Column(name = "menuId")
	private String menuId ;	

	/** 属性upperMenuId/upperMenuId */
	@Column(name = "upperMenuId")
	private String upperMenuId ;
	/** 属性menuLevel/menuLevel */
	@Column(name = "menuLevel")
	private java.lang.Integer menuLevel ;
	/** 属性systemCode/systemCode */
	@Column(name = "systemCode")
	private String systemCode ;
	/** 属性menuCname/menuCname */
	@Column(name = "menuCName")
	private String menuCName ;
	/** 属性menuEname/menuEname */
	@Column(name = "menuEName")
	private String menuEName ;
	/** 属性url/url */
	@Column(name = "url")
	private String url ;
	/** 属性target/target */
	@Column(name = "target")
	private String target ;
	/** 属性displayNo/displayNo */
	@Column(name = "displayNo")
	private java.lang.Integer displayNo ;
	/** 属性image/image */
	@Column(name = "image")
	private String image ;
	/** 属性imageExpand/imageExpand */
	@Column(name = "imageExpand")
	private String imageExpand ;
	/** 属性imageCollapse/imageCollapse */
	@Column(name = "imageCollapse")
	private String imageCollapse ;
	/** 属性iconExpand/iconExpand */
	@Column(name = "iconExpand")
	private String iconExpand ;
	/** 属性iconCollapse/iconCollapse */
	@Column(name = "iconCollapse")
	private String iconCollapse ;
	/** 属性validStatus/validStatus */
	@Column(name = "validStatus")
	private String validStatus ;
	/** 属性remark/remark */
	@Column(name = "remark")
	private String remark ;
	/** 属性flag/flag */
	@Column(name = "flag")
	private String flag ;
	/** 属性taskCode/taskCode */
	@Column(name = "taskCode")
	private String taskCode ;
	/** 属性permitRiskClass/permitRiskClass */
	@Column(name = "permitRiskClass")
	private String permitRiskClass ;
	/** 属性exceptRiskCode/exceptRiskCode */
	@Column(name = "exceptRiskCode")
	private String exceptRiskCode ;
	/** 属性exceptRiskClass/exceptRiskClass */
	@Column(name = "exceptRiskClass")
	private String exceptRiskClass ;
	/** 属性permitRiskCode/permitRiskCode */
	@Column(name = "permitRiskCode")
	private String permitRiskCode ;
	/** 属性checkClass/checkClass */
	@Column(name = "checkClass")
	private String checkClass ;
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
	/**
	 * 属性upperMenuId/upperMenuId的getter方法
	 */
	public String getUpperMenuId() {
		return upperMenuId;
	}
	/**
	 * 属性upperMenuId/upperMenuId的setter方法
	 */
	public void setUpperMenuId(String upperMenuId) {
		this.upperMenuId = upperMenuId;
	} 	
	/**
	 * 属性menuLevel/menuLevel的getter方法
	 */
	public java.lang.Integer getMenuLevel() {
		return menuLevel;
	}
	/**
	 * 属性menuLevel/menuLevel的setter方法
	 */
	public void setMenuLevel(java.lang.Integer menuLevel) {
		this.menuLevel = menuLevel;
	} 	
	/**
	 * 属性systemCode/systemCode的getter方法
	 */
	public String getSystemCode() {
		return systemCode;
	}
	/**
	 * 属性systemCode/systemCode的setter方法
	 */
	public void setSystemCode(String systemCode) {
		this.systemCode = systemCode;
	} 	
	/**
	 * 属性menuCname/menuCname的getter方法
	 */
	public String getMenuCName() {
		return menuCName;
	}
	/**
	 * 属性menuCname/menuCname的setter方法
	 */
	public void setMenuCName(String menuCName) {
		this.menuCName = menuCName;
	} 	
	/**
	 * 属性menuEname/menuEname的getter方法
	 */
	public String getMenuEName() {
		return menuEName;
	}
	/**
	 * 属性menuEname/menuEname的setter方法
	 */
	public void setMenuEName(String menuEName) {
		this.menuEName = menuEName;
	} 	
	/**
	 * 属性url/url的getter方法
	 */
	public String getUrl() {
		return url;
	}
	/**
	 * 属性url/url的setter方法
	 */
	public void setUrl(String url) {
		this.url = url;
	} 	
	/**
	 * 属性target/target的getter方法
	 */
	public String getTarget() {
		return target;
	}
	/**
	 * 属性target/target的setter方法
	 */
	public void setTarget(String target) {
		this.target = target;
	} 	
	/**
	 * 属性displayNo/displayNo的getter方法
	 */
	public java.lang.Integer getDisplayNo() {
		return displayNo;
	}
	/**
	 * 属性displayNo/displayNo的setter方法
	 */
	public void setDisplayNo(java.lang.Integer displayNo) {
		this.displayNo = displayNo;
	} 	
	/**
	 * 属性image/image的getter方法
	 */
	public String getImage() {
		return image;
	}
	/**
	 * 属性image/image的setter方法
	 */
	public void setImage(String image) {
		this.image = image;
	} 	
	/**
	 * 属性imageExpand/imageExpand的getter方法
	 */
	public String getImageExpand() {
		return imageExpand;
	}
	/**
	 * 属性imageExpand/imageExpand的setter方法
	 */
	public void setImageExpand(String imageExpand) {
		this.imageExpand = imageExpand;
	} 	
	/**
	 * 属性imageCollapse/imageCollapse的getter方法
	 */
	public String getImageCollapse() {
		return imageCollapse;
	}
	/**
	 * 属性imageCollapse/imageCollapse的setter方法
	 */
	public void setImageCollapse(String imageCollapse) {
		this.imageCollapse = imageCollapse;
	} 	
	/**
	 * 属性iconExpand/iconExpand的getter方法
	 */
	public String getIconExpand() {
		return iconExpand;
	}
	/**
	 * 属性iconExpand/iconExpand的setter方法
	 */
	public void setIconExpand(String iconExpand) {
		this.iconExpand = iconExpand;
	} 	
	/**
	 * 属性iconCollapse/iconCollapse的getter方法
	 */
	public String getIconCollapse() {
		return iconCollapse;
	}
	/**
	 * 属性iconCollapse/iconCollapse的setter方法
	 */
	public void setIconCollapse(String iconCollapse) {
		this.iconCollapse = iconCollapse;
	} 	
	/**
	 * 属性validStatus/validStatus的getter方法
	 */
	public String getValidStatus() {
		return validStatus;
	}
	/**
	 * 属性validStatus/validStatus的setter方法
	 */
	public void setValidStatus(String validStatus) {
		this.validStatus = validStatus;
	} 	
	/**
	 * 属性remark/remark的getter方法
	 */
	public String getRemark() {
		return remark;
	}
	/**
	 * 属性remark/remark的setter方法
	 */
	public void setRemark(String remark) {
		this.remark = remark;
	} 	
	/**
	 * 属性flag/flag的getter方法
	 */
	public String getFlag() {
		return flag;
	}
	/**
	 * 属性flag/flag的setter方法
	 */
	public void setFlag(String flag) {
		this.flag = flag;
	} 	
	/**
	 * 属性taskCode/taskCode的getter方法
	 */
	public String getTaskCode() {
		return taskCode;
	}
	/**
	 * 属性taskCode/taskCode的setter方法
	 */
	public void setTaskCode(String taskCode) {
		this.taskCode = taskCode;
	} 	
	/**
	 * 属性permitRiskClass/permitRiskClass的getter方法
	 */
	public String getPermitRiskClass() {
		return permitRiskClass;
	}
	/**
	 * 属性permitRiskClass/permitRiskClass的setter方法
	 */
	public void setPermitRiskClass(String permitRiskClass) {
		this.permitRiskClass = permitRiskClass;
	} 	
	/**
	 * 属性exceptRiskCode/exceptRiskCode的getter方法
	 */
	public String getExceptRiskCode() {
		return exceptRiskCode;
	}
	/**
	 * 属性exceptRiskCode/exceptRiskCode的setter方法
	 */
	public void setExceptRiskCode(String exceptRiskCode) {
		this.exceptRiskCode = exceptRiskCode;
	} 	
	/**
	 * 属性exceptRiskClass/exceptRiskClass的getter方法
	 */
	public String getExceptRiskClass() {
		return exceptRiskClass;
	}
	/**
	 * 属性exceptRiskClass/exceptRiskClass的setter方法
	 */
	public void setExceptRiskClass(String exceptRiskClass) {
		this.exceptRiskClass = exceptRiskClass;
	} 	
	/**
	 * 属性permitRiskCode/permitRiskCode的getter方法
	 */
	public String getPermitRiskCode() {
		return permitRiskCode;
	}
	/**
	 * 属性permitRiskCode/permitRiskCode的setter方法
	 */
	public void setPermitRiskCode(String permitRiskCode) {
		this.permitRiskCode = permitRiskCode;
	} 	
	/**
	 * 属性checkClass/checkClass的getter方法
	 */
	public String getCheckClass() {
		return checkClass;
	}
	/**
	 * 属性checkClass/checkClass的setter方法
	 */
	public void setCheckClass(String checkClass) {
		this.checkClass = checkClass;
	} 	
}