package com.sinosoft.notice.api.common.dto;

import com.sinosoft.framework.dto.BasePageableRequest;

import java.io.Serializable;

/**
 * 短信发送列表信息查询条件类
 * @author: 何伟东
 * @date: 2017/12/12 11:09
 */
public class SmsConditionDto extends BasePageableRequest implements Serializable {

    /** 保单号 */
    private String policyNo;
    /** 手机号 */
    private String phoneNo;
    /** 投保人名称 */
    private String appName;
    /** 投保人代码 */
    private String appCode;
    /** 被保险人名称 */
    private String insuredName;
    /** 被保险人代码 */
    private String insuredCode;
    /** 机构代码 */
    private String makeCom;
    /** 起保日期起期 */
    private String startDateStart;
    /** 起保日期止期 */
    private String startDateEnd;
    /** 终保日期起期 */
    private String endDateStart;
    /** 终保日期止期 */
    private String endDateEnd;

    public String getPolicyNo() {
        return policyNo;
    }

    public void setPolicyNo(String policyNo) {
        this.policyNo = policyNo;
    }

    public String getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
    }

    public String getAppName() {
        return appName;
    }

    public void setAppName(String appName) {
        this.appName = appName;
    }

    public String getAppCode() {
        return appCode;
    }

    public void setAppCode(String appCode) {
        this.appCode = appCode;
    }

    public String getInsuredName() {
        return insuredName;
    }

    public void setInsuredName(String insuredName) {
        this.insuredName = insuredName;
    }

    public String getInsuredCode() {
        return insuredCode;
    }

    public void setInsuredCode(String insuredCode) {
        this.insuredCode = insuredCode;
    }

    public String getMakeCom() {
        return makeCom;
    }

    public void setMakeCom(String makeCom) {
        this.makeCom = makeCom;
    }

    public String getStartDateStart() {
        return startDateStart;
    }

    public void setStartDateStart(String startDateStart) {
        this.startDateStart = startDateStart;
    }

    public String getStartDateEnd() {
        return startDateEnd;
    }

    public void setStartDateEnd(String startDateEnd) {
        this.startDateEnd = startDateEnd;
    }

    public String getEndDateStart() {
        return endDateStart;
    }

    public void setEndDateStart(String endDateStart) {
        this.endDateStart = endDateStart;
    }

    public String getEndDateEnd() {
        return endDateEnd;
    }

    public void setEndDateEnd(String endDateEnd) {
        this.endDateEnd = endDateEnd;
    }
}
