package com.sinosoft.ims.api.kernel.dto;

import java.io.Serializable;

import com.sinosoft.framework.dto.BaseDto;

public class UserPowerDto extends BaseDto implements Serializable
{
    private static final long serialVersionUID = 1L;
    /** 属性ID/ */
    private String iD ;
    /** 属性用户代码/ */
    private String userCode ;
    /** 属性功能ID/ */
    private String taskID ;
    /** 属性权限套数/ */
    private String roamingType ;
    /** 属性机构结构变化标志/ */
    private Double comChangeFlag ;
    /** 属性授权人/ */
    private String authuserCode ;
    /** 属性有效起始时间/ */
    private java.util.Date startTime ;
    /** 属性有效终止时间/ */
    private java.util.Date endTime ;
    /** 属性失效日期/ */
    private java.util.Date invalidDate ;
    /** 属性是否包含所有下属机构/ */
    private String incluSubCom ;
    /** 属性有效标志/ */
    private String validInd ;
    /** 属性标志位/ */
    private String flag ;
    /** 属性信息创建日期/ */
    private java.util.Date createDate ;
    /** 属性信息创建人员/ */
    private String creatorCode ;
    /** 属性最新更新操作日期/ */
    private java.util.Date updateDate ;
    /** 属性最新更新操作人员/ */
    private String updaterCode ;
    /**
     * 类SaaUserPower的默认构造方法
     */
    public UserPowerDto() {
    }
    /**
     * 属性ID/的getter方法
     */
    public String getID() {
        return iD;
    }
    /**
     * 属性ID/的setter方法
     */
    public void setID(String iD) {
        this.iD = iD;
    } 
    /**
     * 属性用户代码/的getter方法
     */
    public String getUserCode() {
        return userCode;
    }
    /**
     * 属性用户代码/的setter方法
     */
    public void setUserCode(String userCode) {
        this.userCode = userCode;
    } 
    /**
     * 属性功能ID/的getter方法
     */
    public String getTaskID() {
        return taskID;
    }
    /**
     * 属性功能ID/的setter方法
     */
    public void setTaskID(String taskID) {
        this.taskID = taskID;
    } 
    /**
     * 属性权限套数/的getter方法
     */
    public String getRoamingType() {
        return roamingType;
    }
    /**
     * 属性权限套数/的setter方法
     */
    public void setRoamingType(String roamingType) {
        this.roamingType = roamingType;
    } 
    /**
     * 属性机构结构变化标志/的getter方法
     */
    public Double getComChangeFlag() {
        return comChangeFlag;
    }
    /**
     * 属性机构结构变化标志/的setter方法
     */
    public void setComChangeFlag(Double comChangeFlag) {
        this.comChangeFlag = comChangeFlag;
    } 
    /**
     * 属性授权人/的getter方法
     */
    public String getAuthuserCode() {
        return authuserCode;
    }
    /**
     * 属性授权人/的setter方法
     */
    public void setAuthuserCode(String authuserCode) {
        this.authuserCode = authuserCode;
    } 
    /**
     * 属性有效起始时间/的getter方法
     */
    public java.util.Date getStartTime() {
        return startTime;
    }
    /**
     * 属性有效起始时间/的setter方法
     */
    public void setStartTime(java.util.Date startTime) {
        this.startTime = startTime;
    } 
    /**
     * 属性有效终止时间/的getter方法
     */
    public java.util.Date getEndTime() {
        return endTime;
    }
    /**
     * 属性有效终止时间/的setter方法
     */
    public void setEndTime(java.util.Date endTime) {
        this.endTime = endTime;
    } 
    /**
     * 属性失效日期/的getter方法
     */
    public java.util.Date getInvalidDate() {
        return invalidDate;
    }
    /**
     * 属性失效日期/的setter方法
     */
    public void setInvalidDate(java.util.Date invalidDate) {
        this.invalidDate = invalidDate;
    } 
    /**
     * 属性是否包含所有下属机构/的getter方法
     */
    public String getIncluSubCom() {
        return incluSubCom;
    }
    /**
     * 属性是否包含所有下属机构/的setter方法
     */
    public void setIncluSubCom(String incluSubCom) {
        this.incluSubCom = incluSubCom;
    } 
    /**
     * 属性有效标志/的getter方法
     */
    public String getValidInd() {
        return validInd;
    }
    /**
     * 属性有效标志/的setter方法
     */
    public void setValidInd(String validInd) {
        this.validInd = validInd;
    } 
    /**
     * 属性标志位/的getter方法
     */
    public String getFlag() {
        return flag;
    }
    /**
     * 属性标志位/的setter方法
     */
    public void setFlag(String flag) {
        this.flag = flag;
    } 
    /**
     * 属性信息创建日期/的getter方法
     */
    public java.util.Date getCreateDate() {
        return createDate;
    }
    /**
     * 属性信息创建日期/的setter方法
     */
    public void setCreateDate(java.util.Date createDate) {
        this.createDate = createDate;
    } 
    /**
     * 属性信息创建人员/的getter方法
     */
    public String getCreatorCode() {
        return creatorCode;
    }
    /**
     * 属性信息创建人员/的setter方法
     */
    public void setCreatorCode(String creatorCode) {
        this.creatorCode = creatorCode;
    } 
    /**
     * 属性最新更新操作日期/的getter方法
     */
    public java.util.Date getUpdateDate() {
        return updateDate;
    }
    /**
     * 属性最新更新操作日期/的setter方法
     */
    public void setUpdateDate(java.util.Date updateDate) {
        this.updateDate = updateDate;
    } 
    /**
     * 属性最新更新操作人员/的getter方法
     */
    public String getUpdaterCode() {
        return updaterCode;
    }
    /**
     * 属性最新更新操作人员/的setter方法
     */
    public void setUpdaterCode(String updaterCode) {
        this.updaterCode = updaterCode;
    } 
}
