package com.sinosoft.agriclaim.core.jobmanage.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name = "PrpManagerInfo")
public class PrpManagerInfo {
    @Id
    private String n;
    private String time;
    private String dateType;
    private String handlerName;
    private String tel;
    private String jobRole;

    public String getN() {
        return n;
    }

    public void setN(String n) {
        this.n = n;
    }

    public String getTime() {
        return time;
    }
    public void setTime(String time) {
        this.time = time;
    }

    public String getDateType() {
        return dateType;
    }

    public void setDateType(String dateType) {
        this.dateType = dateType;
    }

    public String getHandlerName() {
        return handlerName;
    }

    public void setHandlerName(String handlerName) {
        this.handlerName = handlerName;
    }


    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }
    public String getJobRole() {
        return jobRole;
    }

    public void setJobRole(String jobRole) {
        this.jobRole = jobRole;
    }


}




