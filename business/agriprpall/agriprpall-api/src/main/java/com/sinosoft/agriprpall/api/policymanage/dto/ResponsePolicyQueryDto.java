package com.sinosoft.agriprpall.api.policymanage.dto;


import com.sinosoft.framework.dto.BaseRequest;

import java.io.Serializable;

/**
 * @Description: 投保单查询列表信息requestDtoApi操作对象
 * @Author: 潘峰
 * @Date: 2017/10/18 16:19
 */
public class ResponsePolicyQueryDto extends BaseRequest implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * 属性保单代码
     */
    private String policyNo;
    /**
     * 属性被保险人名称
     */
    private String insuredName;
    /**
     * 属性投保人名称
     */
    private String appliName;
    /**
     * 属性保险起期
     */
    private String startDate;
    /**
     * 属性终保日期
     */
    private String endDate;
    /**
     * 属性操作员名称
     */
    private String operatorName;
    /**
     * 属性制单日期
     */
    private String operateDate;
    /**
     * 属性投保状态
     */
    private String underWriteFlag;

    public String getPolicyNo() {
        return policyNo;
    }

    public void setPolicyNo(String policyNo) {
        this.policyNo = policyNo;
    }

    public String getInsuredName() {
        return insuredName;
    }

    public void setInsuredName(String insuredName) {
        this.insuredName = insuredName;
    }

    public String getAppliName() {
        return appliName;
    }

    public void setAppliName(String appliName) {
        this.appliName = appliName;
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

    public String getOperatorName() {
        return operatorName;
    }

    public void setOperatorName(String operatorName) {
        this.operatorName = operatorName;
    }

    public String getOperateDate() {
        return operateDate;
    }

    public void setOperateDate(String operateDate) {
        this.operateDate = operateDate;
    }

    public String getUnderWriteFlag() {
        return underWriteFlag;
    }

    public void setUnderWriteFlag(String underWriteFlag) {
        this.underWriteFlag = underWriteFlag;
    }
}
