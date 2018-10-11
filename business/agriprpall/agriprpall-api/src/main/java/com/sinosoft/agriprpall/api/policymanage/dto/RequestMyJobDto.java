package com.sinosoft.agriprpall.api.policymanage.dto;

import com.sinosoft.framework.dto.BaseRequest;

import java.io.Serializable;

public class RequestMyJobDto extends BaseRequest implements Serializable {
    private static final long serialVersionUID = 1L;
    /*页码*/
    private  Integer pageNo;
    /*条数*/
    private Integer pageSize;
    /*用户代码*/
    private  String userCode;
    /*业务号*/
    private String businessNo;
    /*标识符，1-待处理暂存单，2-待处理投保单，3-待处理保单，4-*/
    private String queryFlag;
    /*操作状态*/
    private String status;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Integer getPageNo() {
        return pageNo;
    }

    public void setPageNo(Integer pageNo) {
        this.pageNo = pageNo;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public String getUserCode() {
        return userCode;
    }

    public void setUserCode(String userCode) {
        this.userCode = userCode;
    }

    public String getBusinessNo() {
        return businessNo;
    }

    public void setBusinessNo(String businessNo) {
        this.businessNo = businessNo;
    }

    public String getQueryFlag() {
        return queryFlag;
    }

    public void setQueryFlag(String queryFlag) {
        this.queryFlag = queryFlag;
    }
}
