package com.sinosoft.agriclaim.api.jobmanage.dto;

import com.sinosoft.framework.dto.BasePageableRequest;

import java.io.Serializable;
public class QueryPrpLJobManagerDto  extends BasePageableRequest implements Serializable {
    private  String month ;
    private  String handleDept;
    private  String classCode;
    private  String handlerCode;
    private  String handlerName ;
    private  String time1;
    private  String time2;

    public String getTime1() {
        return time1;
    }

    public void setTime1(String time1) {
        this.time1 = time1;
    }

    public String getTime2() {
        return time2;
    }

    public void setTime2(String time2) {
        this.time2 = time2;
    }

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    public String getHandleDept() {
        return handleDept;
    }

    public void setHandleDept(String handleDept) {
        this.handleDept = handleDept;
    }

    public String getClassCode() {
        return classCode;
    }

    public void setClassCode(String classCode) {
        this.classCode = classCode;
    }
    public String getHandlerCode() {
        return handlerCode;
    }

    public void setHandlerCode(String handlerCode) {
        this.handlerCode = handlerCode;
    }

    public String getHandlerName() {
        return handlerName;
    }

    public void setHandlerName(String handlerName) {
        this.handlerName = handlerName;
    }


}

