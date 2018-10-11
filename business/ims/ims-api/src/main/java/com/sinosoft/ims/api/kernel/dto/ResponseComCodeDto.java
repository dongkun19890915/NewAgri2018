package com.sinosoft.ims.api.kernel.dto;

import com.sinosoft.framework.dto.BaseRequest;

import java.io.Serializable;

/**
 * 登录查询列表查询返回Dto
 * @author 李冬松
 * @date 2018-1-23 14:48
 */
public class ResponseComCodeDto implements Serializable{
    private static final long serialVersionUID = 1L;
    /*机构代码*/
    private String comCode;
    /*用户代码*/
    private String userCode;
    /*机构等级*/
    private String comLevel;
    /*机构中文名*/
    private String comCName;

    public ResponseComCodeDto() {
    }

    public ResponseComCodeDto(String comCode, String userCode, String comLevel, String comCName) {
        this.comCode = comCode;
        this.userCode = userCode;
        this.comLevel = comLevel;
        this.comCName = comCName;
    }

    public String getComCName() {
        return comCName;
    }

    public void setComCName(String comCName) {
        this.comCName = comCName;
    }

    public String getComCode() {
        return comCode;
    }

    public void setComCode(String comCode) {
        this.comCode = comCode;
    }

    public String getUserCode() {
        return userCode;
    }

    public void setUserCode(String userCode) {
        this.userCode = userCode;
    }

    public String getComLevel() {
        return comLevel;
    }

    public void setComLevel(String comLevel) {
        this.comLevel = comLevel;
    }
}
