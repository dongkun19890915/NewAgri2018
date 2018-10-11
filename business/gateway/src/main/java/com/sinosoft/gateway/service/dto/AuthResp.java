package com.sinosoft.gateway.service.dto;

/**
 * Created by Jason on 2017/8/17.
 */

import com.sinosoft.sso.api.dto.UserInfo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class AuthResp implements Serializable {
    private static final long serialVersionUID = 1L;
    private String retCode;
    private String retMsg;
    private UserInfo userInfo;
    private String token;
    private String redirectUrl;
    private List<String> redirectURLs = new ArrayList();

    public AuthResp() {
    }

    public String getRetCode() {
        return this.retCode;
    }

    public void setRetCode(String retCode) {
        this.retCode = retCode;
    }

    public String getRetMsg() {
        return this.retMsg;
    }

    public void setRetMsg(String retMsg) {
        this.retMsg = retMsg;
    }

    public UserInfo getUserInfo() {
        return this.userInfo;
    }

    public void setUserInfo(UserInfo userInfo) {
        this.userInfo = userInfo;
    }

    public String getToken() {
        return this.token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public List<String> getRedirectURLs() {
        return this.redirectURLs;
    }

    public void setRedirectURLs(List<String> redirectURLs) {
        this.redirectURLs = redirectURLs;
    }

    public String getRedirectUrl() {
        return this.redirectUrl;
    }

    public void setRedirectUrl(String redirectUrl) {
        this.redirectUrl = redirectUrl;
    }
}
