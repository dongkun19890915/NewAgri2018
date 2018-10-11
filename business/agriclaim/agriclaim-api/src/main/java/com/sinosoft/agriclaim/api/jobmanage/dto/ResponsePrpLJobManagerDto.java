package com.sinosoft.agriclaim.api.jobmanage.dto;

import com.sinosoft.framework.dto.BaseRequest;

import java.io.Serializable;
/**
 *（班表封装响应数据）
 * @Author: 孙朋飞
 * @Date: 2017/12/14 10:16
 */
public class ResponsePrpLJobManagerDto extends BaseRequest implements Serializable {
    /** 班次名称 */
    private String dateType ;
    /** 作业区域 */
    private String areaName;
    /** 联系电话 */
    private String tel;
    /** 查勘数 */
    private String checkCount;
    /** 工作角色*/
    private String jobRole;
    /** 日期*/
    private String time;
    /** 查勘人员*/
    private String handlerName;
    /** 查勘人员代码*/
    private String handlerCode;
    public String getDateType() {
        return dateType;
    }

    public void setDateType(String dateType) {
        this.dateType = dateType;
    }

    public String getAreaName() {
        return areaName;
    }

    public void setAreaName(String areaName) {
        this.areaName = areaName;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getCheckCount() {
        return checkCount;
    }

    public void setCheckCount(String checkCount) {
        this.checkCount = checkCount;
    }

    public String getJobRole() {
        return jobRole;
    }

    public void setJobRole(String jobRole) {
        this.jobRole = jobRole;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getHandlerName() {
        return handlerName;
    }

    public void setHandlerName(String handlerName) {
        this.handlerName = handlerName;
    }

    public String getHandlerCode() {
        return handlerCode;
    }

    public void setHandlerCode(String handlerCode) {
        this.handlerCode = handlerCode;
    }
}
