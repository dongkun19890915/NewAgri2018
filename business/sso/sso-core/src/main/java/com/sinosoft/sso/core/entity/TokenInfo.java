package com.sinosoft.sso.core.entity;

import java.io.Serializable;
import java.util.Date;

import com.sinosoft.sso.api.dto.UserInfo;

/**
 * @description token保存实体对象
 * @author ZhagnJiansen
 * @date 2016年9月30日下午5:04:22
 */
public class TokenInfo implements Serializable{

    private static final long serialVersionUID = 1L;

    /** token字符串*/
	private String token;
	
	/** token对应的用户信息*/
	private UserInfo userInfo;
	
	/** token创建时间*/
	private Date createTime;
	
	/** token过期时间*/
	private long expiration = -1;

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public UserInfo getUserInfo() {
		return userInfo;
	}

	public void setUserInfo(UserInfo userInfo) {
		this.userInfo = userInfo;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public long getExpiration() {
		return expiration;
	}

	public void setExpiration(long expiration) {
		this.expiration = expiration;
	}

}
