package com.sinosoft.ims.api.auth.dto;

import java.io.Serializable;

/**
 * 子级机构信息
 *
 * @author: 何伟东
 * @date: 2018/1/6 14:32
 */
public class SubComDto implements Serializable {
    /**
     * 机构代码
     */
    private String comCode;
    /**
     * 机构中文名称
     */
    private String comCName;
    /**
     * 机构英文名称
     */
    private String comEName;
    /**
     * 机构级别1：总公司2：省公司3：地市4：区县5：科室6：网点
     */
    private String comLevel;
    /**
     * 上级机构代码
     */
    private String upperComCode;

    /**
     * 用户是否有该机构操作权限 0不可操作 1可操作
     */
    private String isOperate = "0";

    public String getComCode() {
        return comCode;
    }

    public void setComCode(String comCode) {
        this.comCode = comCode;
    }

    public String getComCName() {
        return comCName;
    }

    public void setComCName(String comCName) {
        this.comCName = comCName;
    }

    public String getComEName() {
        return comEName;
    }

    public void setComEName(String comEName) {
        this.comEName = comEName;
    }

    public String getComLevel() {
        return comLevel;
    }

    public void setComLevel(String comLevel) {
        this.comLevel = comLevel;
    }

    public String getUpperComCode() {
        return upperComCode;
    }

    public void setUpperComCode(String upperComCode) {
        this.upperComCode = upperComCode;
    }

    public String getIsOperate() {
        return isOperate;
    }

    public void setIsOperate(String isOperate) {
        this.isOperate = isOperate;
    }
}
