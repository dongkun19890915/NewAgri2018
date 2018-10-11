package com.sinosoft.ims.api.kernel.dto;

import com.sinosoft.framework.dto.BaseDto;

public class MenuQueryConditionDto extends BaseDto implements java.io.Serializable{
	private static final long serialVersionUID = 1L;
	
	private String userCode;
	/** 上级菜单ID 为0时表示顶级菜单 */
	private String upperId;
	/** 机构代码  */
	private String comCode;
	/** 岗位id */
	private String gradeId;
	/** 系统代码 */
	private String systemCode;
	/**  菜单类型  */
	private String menuStyle;
	/**  语言  */
	private String language;
	/**  权限值 1-内网权限 2-外网权限  */
	private String powerType;

	
	public String getUpperId() {
		return upperId;
	}
	public void setUpperId(String upperId) {
		this.upperId = upperId;
	}
	public String getComCode() {
		return comCode;
	}
	public void setComCode(String comCode) {
		this.comCode = comCode;
	}
	public String getSystemCode() {
		return systemCode;
	}
	public void setSystemCode(String systemCode) {
		this.systemCode = systemCode;
	}
	public String getMenuStyle() {
		return menuStyle;
	}
	public void setMenuStyle(String menuStyle) {
		this.menuStyle = menuStyle;
	}
	public String getLanguage() {
		return language;
	}
	public void setLanguage(String language) {
		this.language = language;
	}
	public String getPowerType() {
		return powerType;
	}
	public void setPowerType(String powerType) {
		this.powerType = powerType;
	}
	public String getGradeCode() {
		return gradeId;
	}
	public void setGradeCode(String gradeCode) {
		this.gradeId = gradeCode;
	}
    public String getUserCode()
    {
        return userCode;
    }
    public void setUserCode(String userCode)
    {
        this.userCode = userCode;
    }
    public String getGradeId()
    {
        return gradeId;
    }
    public void setGradeId(String gradeId)
    {
        this.gradeId = gradeId;
    }

}
