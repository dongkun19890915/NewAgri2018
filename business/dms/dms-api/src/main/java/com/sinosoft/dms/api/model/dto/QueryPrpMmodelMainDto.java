package com.sinosoft.dms.api.model.dto;

import java.util.Date;
import java.util.List;

public class QueryPrpMmodelMainDto {
    /** 属性有效起期/有效起期 */
    private java.util.Date startDate ;
    /** 属性有效止期/有效止期 */
    private java.util.Date endDate ;
    /** 属性模板代码/模板代码 */
    private String modelCode ;
    /** 属性模板名称/模板名称 */
    private String modelName ;
    /**创建人名称*/
    private String userName;
    /** 属性创建日期/创建日期 */
    private java.util.Date createDate ;
    /** 属性模板状态/模板状态 */
    private String validStatus ;
    //有效标志字段
    private String validStatus1;
    private String flag;

    public String getFlag() {
        return flag;
    }

    public void setFlag(String flag) {
        this.flag = flag;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getModelCode() {
        return modelCode;
    }

    public void setModelCode(String modelCode) {
        this.modelCode = modelCode;
    }

    public String getModelName() {
        return modelName;
    }

    public void setModelName(String modelName) {
        this.modelName = modelName;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public String getValidStatus() {
        return validStatus;
    }

    public void setValidStatus(String validStatus) {
        this.validStatus = validStatus;
    }

    public String getValidStatus1() {
        return validStatus1;
    }

    public void setValidStatus1(String validStatus1) {
        this.validStatus1 = validStatus1;
    }
}
