package com.sinosoft.framework.agri.core.dto;

/**
 * 报文头信息对应Dto
 */
public class HeadDto {
    private String userCode;
    private String passWord;
    /**  返回状态  0000成功 9999失败*/
    private String returnStatusCode;
    /**  返回信息*/
    private String returnMessage;

    public HeadDto() {
        returnStatusCode="0000";
        returnMessage="交互成功";
    }
    public HeadDto(String userCode, String passWord) {
        this.userCode = userCode;
        this.passWord = passWord;
    }

    public String getUserCode() {
        return userCode;
    }

    public void setUserCode(String userCode) {
        this.userCode = userCode;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    public String getReturnStatusCode() {
        return returnStatusCode;
    }

    public void setReturnStatusCode(String returnStatusCode) {
        this.returnStatusCode = returnStatusCode;
    }

    public String getReturnMessage() {
        return returnMessage;
    }

    public void setReturnMessage(String returnMessage) {
        this.returnMessage = returnMessage;
    }
}
