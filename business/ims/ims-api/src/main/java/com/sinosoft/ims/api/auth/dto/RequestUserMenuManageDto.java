package com.sinosoft.ims.api.auth.dto;

import com.sinosoft.framework.dto.BasePageableRequest;

import java.io.Serializable;

public class RequestUserMenuManageDto  extends BasePageableRequest implements Serializable {

    private static final long serialVersionUID = 1L;

    private String userCode;

    private Integer menuId;
    private String menuCName;
    private String comCode;

    public String getComCode() {
        return comCode;
    }

    public void setComCode(String comCode) {
        this.comCode = comCode;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public String getMenuCName() {
        return menuCName;
    }

    public void setMenuCName(String menuCName) {
        this.menuCName = menuCName;
    }

    public String getUserCode() {
        return userCode;
    }

    public void setUserCode(String systemCode) {
        this.userCode = systemCode;
    }

    public Integer getMenuId() {
        return menuId;
    }

    public void setMenuId(Integer menuId) {
        this.menuId = menuId;
    }
}
