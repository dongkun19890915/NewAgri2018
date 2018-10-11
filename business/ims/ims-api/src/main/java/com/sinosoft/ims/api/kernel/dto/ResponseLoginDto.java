package com.sinosoft.ims.api.kernel.dto;

import com.sinosoft.framework.dto.BaseRequest;
import com.sinosoft.ims.api.auth.dto.MenuTreeDto;

import java.io.Serializable;
import java.util.List;

public class ResponseLoginDto extends BaseRequest implements Serializable{
    private static final long serialVersionUID = 1L;
    //用户代码
    private String userCode;
    //用户登录机构信息(机构信息列表第一个值)
    private String loginComCode;
    //机构信息
    private List<PrpDcompanyDto> userComInfo;
    //菜单信息
    private List<MenuTreeDto> userMenuInfo;

    public String getUserCode() {
        return userCode;
    }

    public void setUserCode(String userCode) {
        this.userCode = userCode;
    }

    public String getLoginComCode() {
        return loginComCode;
    }

    public void setLoginComCode(String loginComCode) {
        this.loginComCode = loginComCode;
    }

    public List<PrpDcompanyDto> getUserComInfo() {
        return userComInfo;
    }

    public void setUserComInfo(List<PrpDcompanyDto> userComInfo) {
        this.userComInfo = userComInfo;
    }

    public List<MenuTreeDto> getUserMenuInfo() {
        return userMenuInfo;
    }

    public void setUserMenuInfo(List<MenuTreeDto> userMenuInfo) {
        this.userMenuInfo = userMenuInfo;
    }
}
