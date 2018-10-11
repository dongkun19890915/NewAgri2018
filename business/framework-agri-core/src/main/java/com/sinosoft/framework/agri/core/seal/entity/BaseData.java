package com.sinosoft.framework.agri.core.seal.entity;

import com.thoughtworks.xstream.annotations.XStreamAlias;

/**
 * description:
 *
 * @outhor wq
 * @create 2018-01-25 16:03
 */
public class BaseData {
    //应用系统ID 应用系统ID，用于此次业务由那个系统发起
    @XStreamAlias("SYS_ID")
    private String sysId;

    //用户名 电子印章系统存在的用户
    @XStreamAlias("USER_ID")
    private String userId;

    //用户密码 电子印章系统存在的用户密码
    @XStreamAlias("USER_PSD")
    private String userPsd;

    public String getSysId() {
        return sysId;
    }

    public BaseData() {
    }

    public BaseData(String sysId, String userId, String userPsd) {
        this.sysId = sysId;
        this.userId = userId;
        this.userPsd = userPsd;
    }

    public void setSysId(String sysId) {
        this.sysId = sysId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserPsd() {
        return userPsd;
    }

    public void setUserPsd(String userPsd) {
        this.userPsd = userPsd;
    }
}
