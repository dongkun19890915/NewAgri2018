package com.sinosoft.agriclaim.api.common.dto;

import com.sinosoft.framework.dto.BaseRequest;

import java.io.Serializable;

public class LoginUserDto  extends BaseRequest implements Serializable{
    /**登录人员代码 */
    private String loginUserCode;
    /**登录人员代码 */
    private String loginUserName;
    /**登录人员代码 */
    private String loginComCode;
    /**登录人员代码 */
    private String loginComName;

    public String getLoginUserCode() {
        return loginUserCode;
    }

    public void setLoginUserCode(String loginUserCode) {
        this.loginUserCode = loginUserCode;
    }

    public String getLoginUserName() {
        return loginUserName;
    }

    public void setLoginUserName(String loginUserName) {
        this.loginUserName = loginUserName;
    }

    public String getLoginComCode() {
        return loginComCode;
    }

    public void setLoginComCode(String loginComCode) {
        this.loginComCode = loginComCode;
    }

    public String getLoginComName() {
        return loginComName;
    }

    public void setLoginComName(String loginComName) {
        this.loginComName = loginComName;
    }
}
