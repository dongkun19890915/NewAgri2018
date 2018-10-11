package com.sinosoft.demo.core.rabbit.dto;

import java.io.Serializable;
/**
* @Description: RabbitMQ消息队列传输使用对象  一定要序列化
* @Author: 周家伟
* @Date: 2017/10/26 8:56
*/
public class UserDto implements Serializable {
    private String userCode;
    private String userName;

    public String getUserCode() {
        return userCode;
    }

    public void setUserCode(String userCode) {
        this.userCode = userCode;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    @Override
    public String toString() {
        return "UserDto{" +
                "userCode='" + userCode + '\'' +
                ", userName='" + userName + '\'' +
                '}';
    }
}
