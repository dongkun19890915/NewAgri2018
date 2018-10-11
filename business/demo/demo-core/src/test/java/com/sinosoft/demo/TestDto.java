package com.sinosoft.demo;

public class TestDto {
    private String username;
    private String usercode;
    private int age;

    public TestDto(String username, String usercode, int age) {
        this.username = username;
        this.usercode = usercode;
        this.age = age;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUsercode() {
        return usercode;
    }

    public void setUsercode(String usercode) {
        this.usercode = usercode;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
