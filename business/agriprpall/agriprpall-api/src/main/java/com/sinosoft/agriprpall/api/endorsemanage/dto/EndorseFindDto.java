package com.sinosoft.agriprpall.api.endorsemanage.dto;

import com.sinosoft.framework.dto.BaseRequest;

import java.io.Serializable;
import java.util.Date;

public class EndorseFindDto extends BaseRequest implements Serializable {
    private String comName;
    private String businessProvince;
    private String businessTown;
    private String businessCounty;
    private String businessAreaName;
    private String businessNature;
    private String businessType1;
    private String notificationflag;
    private String thirdKnow;
    private Date startdate;
    private Date enddate;
    private String proposalno;
    private String handler1Code;
    private String handler1Name;
    private String updaterCode;
    private String inceptionFlag;
    private String businessType;
    private String autotransrenewflag;
    private String policyNo;
    private String operatorCode;
    private String operatorName;
    private String updaterName;
    private Date updateDate;
    private Date operatedate;

    public String getComName() {
        return comName;
    }

    public void setComName(String comName) {
        this.comName = comName;
    }

    public String getBusinessProvince() {
        return businessProvince;
    }

    public void setBusinessProvince(String businessProvince) {
        this.businessProvince = businessProvince;
    }

    public String getBusinessTown() {
        return businessTown;
    }

    public void setBusinessTown(String businessTown) {
        this.businessTown = businessTown;
    }

    public String getBusinessCounty() {
        return businessCounty;
    }

    public void setBusinessCounty(String businessCounty) {
        this.businessCounty = businessCounty;
    }

    public String getBusinessAreaName() {
        return businessAreaName;
    }

    public void setBusinessAreaName(String businessAreaName) {
        this.businessAreaName = businessAreaName;
    }

    public String getBusinessNature() {
        return businessNature;
    }

    public void setBusinessNature(String businessNature) {
        this.businessNature = businessNature;
    }

    public String getBusinessType1() {
        return businessType1;
    }

    public void setBusinessType1(String businessType1) {
        this.businessType1 = businessType1;
    }

    public String getNotificationflag() {
        return notificationflag;
    }

    public void setNotificationflag(String notificationflag) {
        this.notificationflag = notificationflag;
    }

    public String getThirdKnow() {
        return thirdKnow;
    }

    public void setThirdKnow(String thirdKnow) {
        this.thirdKnow = thirdKnow;
    }

    public Date getStartdate() {
        return startdate;
    }

    public void setStartdate(Date startdate) {
        this.startdate = startdate;
    }

    public Date getEnddate() {
        return enddate;
    }

    public void setEnddate(Date enddate) {
        this.enddate = enddate;
    }

    public String getProposalno() {
        return proposalno;
    }

    public void setProposalno(String proposalno) {
        this.proposalno = proposalno;
    }

    public String getHandler1Code() {
        return handler1Code;
    }

    public void setHandler1Code(String handler1Code) {
        this.handler1Code = handler1Code;
    }

    public String getHandler1Name() {
        return handler1Name;
    }

    public void setHandler1Name(String handler1Name) {
        this.handler1Name = handler1Name;
    }

    public String getUpdaterCode() {
        return updaterCode;
    }

    public void setUpdaterCode(String updaterCode) {
        this.updaterCode = updaterCode;
    }

    public String getInceptionFlag() {
        return inceptionFlag;
    }

    public void setInceptionFlag(String inceptionFlag) {
        this.inceptionFlag = inceptionFlag;
    }

    public String getBusinessType() {
        return businessType;
    }

    public void setBusinessType(String businessType) {
        this.businessType = businessType;
    }

    public String getAutotransrenewflag() {
        return autotransrenewflag;
    }

    public void setAutotransrenewflag(String autotransrenewflag) {
        this.autotransrenewflag = autotransrenewflag;
    }

    public String getPolicyNo() {
        return policyNo;
    }

    public void setPolicyNo(String policyNo) {
        this.policyNo = policyNo;
    }

    public String getOperatorCode() {
        return operatorCode;
    }

    public void setOperatorCode(String operatorCode) {
        this.operatorCode = operatorCode;
    }

    public String getOperatorName() {
        return operatorName;
    }

    public void setOperatorName(String operatorName) {
        this.operatorName = operatorName;
    }

    public String getUpdaterName() {
        return updaterName;
    }

    public void setUpdaterName(String updaterName) {
        this.updaterName = updaterName;
    }

    public Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

    public Date getOperatedate() {
        return operatedate;
    }

    public void setOperatedate(Date operatedate) {
        this.operatedate = operatedate;
    }
}
