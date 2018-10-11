package com.sinosoft.agriprpall.api.client.dto;

public class ResponseUpdatePassWordDto {
    /**
     * �ͻ�����
     */
    private String userCode;
    /**
     * �ͻ�����
     */
    private String userName;
    /**
     * ԭ����
     */
    private String oldPassword;
    /**
     * ������
     */
    private String newPassword;

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

    public String getOldPassword() {
        return oldPassword;
    }

    public void setOldPassword(String oldPassword) {
        this.oldPassword = oldPassword;
    }

    public String getNewPassword() {
        return newPassword;
    }

    public void setNewPassword(String newPassword) {
        this.newPassword = newPassword;
    }

}
