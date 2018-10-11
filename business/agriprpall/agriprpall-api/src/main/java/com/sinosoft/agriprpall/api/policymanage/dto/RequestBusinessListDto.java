package com.sinosoft.agriprpall.api.policymanage.dto;

import com.sinosoft.framework.dto.BasePageableRequest;

public class RequestBusinessListDto extends BasePageableRequest {
    /** 险种大类*/
    private  String classCode;
    /** 清单类型*/
    private  String listType;
    /** 操作时间起期*/
    private  String startDate;
    /** 操作时间止期*/
    private  String endDate;
    /**机构代码*/
    private String comCode;

    public String getClassCode() {
        return classCode;
    }

    public void setClassCode(String classCode) {
        this.classCode = classCode;
    }

    public String getListType() {
        return listType;
    }

    public void setListType(String listType) {
        this.listType = listType;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public String getComCode() {
        return comCode;
    }

    public void setComCode(String comCode) {
        this.comCode = comCode;
    }
}
