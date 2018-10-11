package com.sinosoft.ims.api.auth.dto;

import java.io.Serializable;
import java.util.List;

import com.sinosoft.framework.dto.BaseRequest;
/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-08-22 03:00:27.902 
 * 菜单表Api操作对象
 */
public class MenuQueryResponseDto extends BaseRequest implements Serializable{
	private static final long serialVersionUID = 1L;
	/** 属性菜单ID/菜单ID */
	private String menuId ;
	/** 属性上级菜单ID/上级菜单ID */
	private String upperMenuId ;
	/** 属性菜单层级/菜单层级 */
	private Integer menuLevel ;
	/** 属性系统代码/系统代码 */
	private String systemCode ;
	/** 属性菜单中文名称/菜单中文名称 */
	private String menuCName ;
	/** 属性菜单英文名称/菜单英文名称 */
	private String menuEName ;
	/** 属性执行URL/执行URL */
	private String url ;
	/** 属性目标/目标 */
	private String target ;
	/** 属性显示序号/显示序号 */
	private Integer displayNo ;
	/** 属性菜单标题图片名/菜单标题图片名 */
	private String image ;
	/** 属性展开菜单的图片名/展开菜单的图片名 */
	private String imageExpand ;
	/** 属性合上菜单的图片名/合上菜单的图片名 */
	private String imageCollapse ;
	/** 属性展开菜单的图标/展开菜单的图标 */
	private String iconExpand ;
	/** 属性合上菜单的图标/合上菜单的图标 */
	private String iconCollapse ;
	/** 属性效力状态/效力状态 */
	private String validStatus ;
	/** 属性备注/备注 */
	private String remark ;
	/** 属性标志字段/标志字段 */
	private String flag ;
	/** 属性任务代码/任务代码 */
	private String taskCode ;
	/** 属性允许险类/允许险类 */
	private String permitRiskClass ;
	/** 属性允许险类除外险种/允许险类除外险种 */
	private String exceptRiskCode ;
	/** 属性禁止险类/禁止险类 */
	private String exceptRiskClass ;
	/** 属性禁止险类除外险种/禁止险类除外险种 */
	private String permitRiskCode ;
	/** 属性检查类名称/检查类名称 */
	private String checkClass ;
	/** 属性是否允许外网登录/是否允许外网登录 */
	private String telnetConfigFlag ;
	/** 属性创建人/创建人 */
	private String createdBy ;
	/** 属性创建时间/创建时间 */
	private java.util.Date createdTime ;
	/** 属性更新人/更新人 */
	private String updatedBy ;
	/** 属性更新时间/更新时间 */
	private java.util.Date updatedTime ;
	/** 子菜单 */
	private List<MenuQueryResponseDto> childMenuList ;
	
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
	/**
	 * 属性上级菜单ID/上级菜单ID的getter方法
	 */
	public String getUpperMenuId() {
		return upperMenuId;
	}
	/**
	 * 属性上级菜单ID/上级菜单ID的setter方法
	 */
	public void setUpperMenuId(String upperMenuId) {
		this.upperMenuId = upperMenuId;
	}
	/**
	 * 属性菜单层级/菜单层级的getter方法
	 */
	public Integer getMenuLevel() {
		return menuLevel;
	}
	/**
	 * 属性菜单层级/菜单层级的setter方法
	 */
	public void setMenuLevel(Integer menuLevel) {
		this.menuLevel = menuLevel;
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
	 * 属性菜单中文名称/菜单中文名称的getter方法
	 */
	public String getMenuCName() {
		return menuCName;
	}
	/**
	 * 属性菜单中文名称/菜单中文名称的setter方法
	 */
	public void setMenuCName(String menuCName) {
		this.menuCName = menuCName;
	}
	/**
	 * 属性菜单英文名称/菜单英文名称的getter方法
	 */
	public String getMenuEName() {
		return menuEName;
	}
	/**
	 * 属性菜单英文名称/菜单英文名称的setter方法
	 */
	public void setMenuEName(String menuEName) {
		this.menuEName = menuEName;
	}
	/**
	 * 属性执行URL/执行URL的getter方法
	 */
	public String getUrl() {
		return url;
	}
	/**
	 * 属性执行URL/执行URL的setter方法
	 */
	public void setUrl(String url) {
		this.url = url;
	}
	/**
	 * 属性目标/目标的getter方法
	 */
	public String getTarget() {
		return target;
	}
	/**
	 * 属性目标/目标的setter方法
	 */
	public void setTarget(String target) {
		this.target = target;
	}
	/**
	 * 属性显示序号/显示序号的getter方法
	 */
	public Integer getDisplayNo() {
		return displayNo;
	}
	/**
	 * 属性显示序号/显示序号的setter方法
	 */
	public void setDisplayNo(Integer displayNo) {
		this.displayNo = displayNo;
	}
	/**
	 * 属性菜单标题图片名/菜单标题图片名的getter方法
	 */
	public String getImage() {
		return image;
	}
	/**
	 * 属性菜单标题图片名/菜单标题图片名的setter方法
	 */
	public void setImage(String image) {
		this.image = image;
	}
	/**
	 * 属性展开菜单的图片名/展开菜单的图片名的getter方法
	 */
	public String getImageExpand() {
		return imageExpand;
	}
	/**
	 * 属性展开菜单的图片名/展开菜单的图片名的setter方法
	 */
	public void setImageExpand(String imageExpand) {
		this.imageExpand = imageExpand;
	}
	/**
	 * 属性合上菜单的图片名/合上菜单的图片名的getter方法
	 */
	public String getImageCollapse() {
		return imageCollapse;
	}
	/**
	 * 属性合上菜单的图片名/合上菜单的图片名的setter方法
	 */
	public void setImageCollapse(String imageCollapse) {
		this.imageCollapse = imageCollapse;
	}
	/**
	 * 属性展开菜单的图标/展开菜单的图标的getter方法
	 */
	public String getIconExpand() {
		return iconExpand;
	}
	/**
	 * 属性展开菜单的图标/展开菜单的图标的setter方法
	 */
	public void setIconExpand(String iconExpand) {
		this.iconExpand = iconExpand;
	}
	/**
	 * 属性合上菜单的图标/合上菜单的图标的getter方法
	 */
	public String getIconCollapse() {
		return iconCollapse;
	}
	/**
	 * 属性合上菜单的图标/合上菜单的图标的setter方法
	 */
	public void setIconCollapse(String iconCollapse) {
		this.iconCollapse = iconCollapse;
	}
	/**
	 * 属性效力状态/效力状态的getter方法
	 */
	public String getValidStatus() {
		return validStatus;
	}
	/**
	 * 属性效力状态/效力状态的setter方法
	 */
	public void setValidStatus(String validStatus) {
		this.validStatus = validStatus;
	}
	/**
	 * 属性备注/备注的getter方法
	 */
	public String getRemark() {
		return remark;
	}
	/**
	 * 属性备注/备注的setter方法
	 */
	public void setRemark(String remark) {
		this.remark = remark;
	}
	/**
	 * 属性标志字段/标志字段的getter方法
	 */
	public String getFlag() {
		return flag;
	}
	/**
	 * 属性标志字段/标志字段的setter方法
	 */
	public void setFlag(String flag) {
		this.flag = flag;
	}
	/**
	 * 属性任务代码/任务代码的getter方法
	 */
	public String getTaskCode() {
		return taskCode;
	}
	/**
	 * 属性任务代码/任务代码的setter方法
	 */
	public void setTaskCode(String taskCode) {
		this.taskCode = taskCode;
	}
	/**
	 * 属性允许险类/允许险类的getter方法
	 */
	public String getPermitRiskClass() {
		return permitRiskClass;
	}
	/**
	 * 属性允许险类/允许险类的setter方法
	 */
	public void setPermitRiskClass(String permitRiskClass) {
		this.permitRiskClass = permitRiskClass;
	}
	/**
	 * 属性允许险类除外险种/允许险类除外险种的getter方法
	 */
	public String getExceptRiskCode() {
		return exceptRiskCode;
	}
	/**
	 * 属性允许险类除外险种/允许险类除外险种的setter方法
	 */
	public void setExceptRiskCode(String exceptRiskCode) {
		this.exceptRiskCode = exceptRiskCode;
	}
	/**
	 * 属性禁止险类/禁止险类的getter方法
	 */
	public String getExceptRiskClass() {
		return exceptRiskClass;
	}
	/**
	 * 属性禁止险类/禁止险类的setter方法
	 */
	public void setExceptRiskClass(String exceptRiskClass) {
		this.exceptRiskClass = exceptRiskClass;
	}
	/**
	 * 属性禁止险类除外险种/禁止险类除外险种的getter方法
	 */
	public String getPermitRiskCode() {
		return permitRiskCode;
	}
	/**
	 * 属性禁止险类除外险种/禁止险类除外险种的setter方法
	 */
	public void setPermitRiskCode(String permitRiskCode) {
		this.permitRiskCode = permitRiskCode;
	}
	/**
	 * 属性检查类名称/检查类名称的getter方法
	 */
	public String getCheckClass() {
		return checkClass;
	}
	/**
	 * 属性检查类名称/检查类名称的setter方法
	 */
	public void setCheckClass(String checkClass) {
		this.checkClass = checkClass;
	}
	/**
	 * 属性是否允许外网登录/是否允许外网登录的getter方法
	 */
	public String getTelnetConfigFlag() {
		return telnetConfigFlag;
	}
	/**
	 * 属性是否允许外网登录/是否允许外网登录的setter方法
	 */
	public void setTelnetConfigFlag(String telnetConfigFlag) {
		this.telnetConfigFlag = telnetConfigFlag;
	}
	/**
	 * 属性创建人/创建人的getter方法
	 */
	public String getCreatedBy() {
		return createdBy;
	}
	/**
	 * 属性创建人/创建人的setter方法
	 */
	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}
	/**
	 * 属性创建时间/创建时间的getter方法
	 */
	public java.util.Date getCreatedTime() {
		return createdTime;
	}
	/**
	 * 属性创建时间/创建时间的setter方法
	 */
	public void setCreatedTime(java.util.Date createdTime) {
		this.createdTime = createdTime;
	}
	/**
	 * 属性更新人/更新人的getter方法
	 */
	public String getUpdatedBy() {
		return updatedBy;
	}
	/**
	 * 属性更新人/更新人的setter方法
	 */
	public void setUpdatedBy(String updatedBy) {
		this.updatedBy = updatedBy;
	}
	/**
	 * 属性更新时间/更新时间的getter方法
	 */
	public java.util.Date getUpdatedTime() {
		return updatedTime;
	}
	/**
	 * 属性更新时间/更新时间的setter方法
	 */
	public void setUpdatedTime(java.util.Date updatedTime) {
		this.updatedTime = updatedTime;
	}
	public List<MenuQueryResponseDto> getChildMenuList() {
		return childMenuList;
	}
	public void setChildMenuList(List<MenuQueryResponseDto> childMenuList) {
		this.childMenuList = childMenuList;
	}
}
