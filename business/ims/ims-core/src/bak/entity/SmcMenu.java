package com.sinosoft.ims.core.kernel.entity;

import com.sinosoft.framework.core.dao.BaseEntity;

import javax.persistence.*;

/**
 * @author codegen@研发中心
 * @mail hongzhongkai
 * @time  2016-09-23 17:19:21.110 
 * 菜单表-Smc_Menu   基础数据对象
 */
@Table(name = "SMC_MENU")
@IdClass(SmcMenuKey.class)
@Entity
public class SmcMenu implements BaseEntity, java.io.Serializable {
	private static final long serialVersionUID = 1L;

	/** 属性上级菜单ID/ */
	private String upperId ;
	/** 属性菜单级别/ */
	private Double menuLevel ;
	/** 属性系统代码/ */
	private String systemCode ;
	/** 属性菜单中文名称/ */
	private String menuCName ;
	/** 属性菜单繁体名称/ */
	private String menuTName ;
	/** 属性菜单英文名称/ */
	private String menuEName ;
	/** 属性执行URL/ */
	private String actionURL ;
	/** 属性目标/ */
	private String target ;
	/** 属性显示序号/ */
	private Double displayNo ;
	/** 属性图片路径/ */
	private String image ;
	/** 属性图片路径扩展/ */
	private String imageExpand ;
	/** 属性图片路径其它/ */
	private String imageCollapse ;
	/** 属性符号路径扩展/ */
	private String iconExpand ;
	/** 属性符号路径其它/ */
	private String iconCollapse ;
	/** 属性任务代码/ */
	private String taskCode ;
	/** 属性允许险类/ */
	private String permitRiskClass ;
	/** 属性允许险类除外险种/ */
	private String exceptRiskCode ;
	/** 属性禁止险类/ */
	private String exceptRiskClass ;
	/** 属性禁止险类除外险种/ */
	private String permitRiskCode ;
	/** 属性检查类名称/ */
	private String checkClass ;
	/** 属性有效标志/ */
	private String validInd ;
	/** 属性备注/ */
	private String remark ;
	/** 属性标志字段/ */
	private String flag ;
	/** 属性信息创建日期/ */
	private java.util.Date createTime ;
	/** 属性信息创建人员/ */
	private String creatorCode ;
	/** 属性最新更新操作日期/ */
	private java.util.Date updateTime ;
	/** 属性最新更新操作人员/ */
	private String updaterCode ;
	/** 属性ID/ */
	@Id
	@Column(name = "Id")
	private String iD ;
	/**
	 * 属性ID/的getter方法
	 */
	public String getID() {
		return iD;
	}
	/**
	 * 属性ID/的setter方法
	 */
	public void setID(String iD) {
		this.iD = iD;
	}
	/**
	 * 类SmcMenu的默认构造方法
	 */
	public SmcMenu() {
	}

	/**
	 * 属性上级菜单ID/的getter方法
	 */
	public String getUpperId() {
		return upperId;
	}
	/**
	 * 属性上级菜单ID/的setter方法
	 */
	public void setUpperId(String upperId) {
		this.upperId = upperId;
	} 
	/**
	 * 属性菜单级别/的getter方法
	 */
	public Double getMenuLevel() {
		return menuLevel;
	}
	/**
	 * 属性菜单级别/的setter方法
	 */
	public void setMenuLevel(Double menuLevel) {
		this.menuLevel = menuLevel;
	} 
	/**
	 * 属性系统代码/的getter方法
	 */
	public String getSystemCode() {
		return systemCode;
	}
	/**
	 * 属性系统代码/的setter方法
	 */
	public void setSystemCode(String systemCode) {
		this.systemCode = systemCode;
	} 
	/**
	 * 属性菜单中文名称/的getter方法
	 */
	public String getMenuCName() {
		return menuCName;
	}
	/**
	 * 属性菜单中文名称/的setter方法
	 */
	public void setMenuCName(String menuCName) {
		this.menuCName = menuCName;
	} 
	/**
	 * 属性菜单繁体名称/的getter方法
	 */
	public String getMenuTName() {
		return menuTName;
	}
	/**
	 * 属性菜单繁体名称/的setter方法
	 */
	public void setMenuTName(String menuTName) {
		this.menuTName = menuTName;
	} 
	/**
	 * 属性菜单英文名称/的getter方法
	 */
	public String getMenuEName() {
		return menuEName;
	}
	/**
	 * 属性菜单英文名称/的setter方法
	 */
	public void setMenuEName(String menuEName) {
		this.menuEName = menuEName;
	} 
	/**
	 * 属性执行URL/的getter方法
	 */
	public String getActionURL() {
		return actionURL;
	}
	/**
	 * 属性执行URL/的setter方法
	 */
	public void setActionURL(String actionURL) {
		this.actionURL = actionURL;
	} 
	/**
	 * 属性目标/的getter方法
	 */
	public String getTarget() {
		return target;
	}
	/**
	 * 属性目标/的setter方法
	 */
	public void setTarget(String target) {
		this.target = target;
	} 
	/**
	 * 属性显示序号/的getter方法
	 */
	public Double getDisplayNo() {
		return displayNo;
	}
	/**
	 * 属性显示序号/的setter方法
	 */
	public void setDisplayNo(Double displayNo) {
		this.displayNo = displayNo;
	} 
	/**
	 * 属性图片路径/的getter方法
	 */
	public String getImage() {
		return image;
	}
	/**
	 * 属性图片路径/的setter方法
	 */
	public void setImage(String image) {
		this.image = image;
	} 
	/**
	 * 属性图片路径扩展/的getter方法
	 */
	public String getImageExpand() {
		return imageExpand;
	}
	/**
	 * 属性图片路径扩展/的setter方法
	 */
	public void setImageExpand(String imageExpand) {
		this.imageExpand = imageExpand;
	} 
	/**
	 * 属性图片路径其它/的getter方法
	 */
	public String getImageCollapse() {
		return imageCollapse;
	}
	/**
	 * 属性图片路径其它/的setter方法
	 */
	public void setImageCollapse(String imageCollapse) {
		this.imageCollapse = imageCollapse;
	} 
	/**
	 * 属性符号路径扩展/的getter方法
	 */
	public String getIconExpand() {
		return iconExpand;
	}
	/**
	 * 属性符号路径扩展/的setter方法
	 */
	public void setIconExpand(String iconExpand) {
		this.iconExpand = iconExpand;
	} 
	/**
	 * 属性符号路径其它/的getter方法
	 */
	public String getIconCollapse() {
		return iconCollapse;
	}
	/**
	 * 属性符号路径其它/的setter方法
	 */
	public void setIconCollapse(String iconCollapse) {
		this.iconCollapse = iconCollapse;
	} 
	/**
	 * 属性任务代码/的getter方法
	 */
	public String getTaskCode() {
		return taskCode;
	}
	/**
	 * 属性任务代码/的setter方法
	 */
	public void setTaskCode(String taskCode) {
		this.taskCode = taskCode;
	} 
	/**
	 * 属性允许险类/的getter方法
	 */
	public String getPermitRiskClass() {
		return permitRiskClass;
	}
	/**
	 * 属性允许险类/的setter方法
	 */
	public void setPermitRiskClass(String permitRiskClass) {
		this.permitRiskClass = permitRiskClass;
	} 
	/**
	 * 属性允许险类除外险种/的getter方法
	 */
	public String getExceptRiskCode() {
		return exceptRiskCode;
	}
	/**
	 * 属性允许险类除外险种/的setter方法
	 */
	public void setExceptRiskCode(String exceptRiskCode) {
		this.exceptRiskCode = exceptRiskCode;
	} 
	/**
	 * 属性禁止险类/的getter方法
	 */
	public String getExceptRiskClass() {
		return exceptRiskClass;
	}
	/**
	 * 属性禁止险类/的setter方法
	 */
	public void setExceptRiskClass(String exceptRiskClass) {
		this.exceptRiskClass = exceptRiskClass;
	} 
	/**
	 * 属性禁止险类除外险种/的getter方法
	 */
	public String getPermitRiskCode() {
		return permitRiskCode;
	}
	/**
	 * 属性禁止险类除外险种/的setter方法
	 */
	public void setPermitRiskCode(String permitRiskCode) {
		this.permitRiskCode = permitRiskCode;
	} 
	/**
	 * 属性检查类名称/的getter方法
	 */
	public String getCheckClass() {
		return checkClass;
	}
	/**
	 * 属性检查类名称/的setter方法
	 */
	public void setCheckClass(String checkClass) {
		this.checkClass = checkClass;
	} 
	/**
	 * 属性有效标志/的getter方法
	 */
	public String getValidInd() {
		return validInd;
	}
	/**
	 * 属性有效标志/的setter方法
	 */
	public void setValidInd(String validInd) {
		this.validInd = validInd;
	} 
	/**
	 * 属性备注/的getter方法
	 */
	public String getRemark() {
		return remark;
	}
	/**
	 * 属性备注/的setter方法
	 */
	public void setRemark(String remark) {
		this.remark = remark;
	} 
	/**
	 * 属性标志字段/的getter方法
	 */
	public String getFlag() {
		return flag;
	}
	/**
	 * 属性标志字段/的setter方法
	 */
	public void setFlag(String flag) {
		this.flag = flag;
	} 
	/**
	 * 属性信息创建日期/的getter方法
	 */
	public java.util.Date getCreateTime() {
		return createTime;
	}
	/**
	 * 属性信息创建日期/的setter方法
	 */
	public void setCreateTime(java.util.Date createTime) {
		this.createTime = createTime;
	} 
	/**
	 * 属性信息创建人员/的getter方法
	 */
	public String getCreatorCode() {
		return creatorCode;
	}
	/**
	 * 属性信息创建人员/的setter方法
	 */
	public void setCreatorCode(String creatorCode) {
		this.creatorCode = creatorCode;
	} 
	/**
	 * 属性最新更新操作日期/的getter方法
	 */
	public java.util.Date getUpdateTime() {
		return updateTime;
	}
	/**
	 * 属性最新更新操作日期/的setter方法
	 */
	public void setUpdateTime(java.util.Date updateTime) {
		this.updateTime = updateTime;
	} 
	/**
	 * 属性最新更新操作人员/的getter方法
	 */
	public String getUpdaterCode() {
		return updaterCode;
	}
	/**
	 * 属性最新更新操作人员/的setter方法
	 */
	public void setUpdaterCode(String updaterCode) {
		this.updaterCode = updaterCode;
	}

}