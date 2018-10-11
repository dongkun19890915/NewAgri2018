package com.sinosoft.demo.core.printpdf.dto;

import java.io.Serializable;

public class PrpDuserDto implements Serializable {
    private String userCode;
    private String userName;
    private String sex;
    private String age;

    /**
     *
     * @param userCode
     * @param userName
     * @param sex
     * @param age
     */
    public PrpDuserDto(String userCode, String userName, String sex, String age) {
        this.userCode = userCode;
        this.userName = userName;
        this.sex = sex;
        this.age = age;
    }

    public PrpDuserDto() {
    }

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

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }
}
