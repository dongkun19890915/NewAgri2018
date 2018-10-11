package com.sinosoft.agriprpall.api.policymanage.dto;

import com.sinosoft.framework.dto.BaseRequest;

import java.io.Serializable;

/**
 * @author codegen@研发中心
 * @mail codegen@sinosoft.com.cn
 * @time 2017-10-23 06:09:14.757
 * 保费缴款通知书信息表Api操作对象
 */
public class PrpPolicyFeeNoticeDto extends BaseRequest implements Serializable {
    private static final long serialVersionUID = 1L;
    /**
     * 属性缴费通知书编号/缴费通知书编号
     */
    private String policyFeeNo;
    /**
     * 属性保单号/保单号
     */
    private String policyNo;
    /**
     * 属性批单号/批单号
     */
    private String endorseNo;
    /**
     * 属性打印人代码/打印人代码
     */
    private String operatorCode;
    /**
     * 属性打印时间/打印时间
     */
    private java.util.Date operaDate;

    /**
     * 属性缴费通知书编号/缴费通知书编号的getter方法
     */
    public String getPolicyFeeNo() {
        return policyFeeNo;
    }

    /**
     * 属性缴费通知书编号/缴费通知书编号的setter方法
     */
    public void setPolicyFeeNo(String policyFeeNo) {
        this.policyFeeNo = policyFeeNo;
    }

    /**
     * 属性保单号/保单号的getter方法
     */
    public String getPolicyNo() {
        return policyNo;
    }

    /**
     * 属性保单号/保单号的setter方法
     */
    public void setPolicyNo(String policyNo) {
        this.policyNo = policyNo;
    }

    /**
     * 属性批单号/批单号的getter方法
     */
    public String getEndorseNo() {
        return endorseNo;
    }

    /**
     * 属性批单号/批单号的setter方法
     */
    public void setEndorseNo(String endorseNo) {
        this.endorseNo = endorseNo;
    }

    /**
     * 属性打印人代码/打印人代码的getter方法
     */
    public String getOperatorCode() {
        return operatorCode;
    }

    /**
     * 属性打印人代码/打印人代码的setter方法
     */
    public void setOperatorCode(String operatorCode) {
        this.operatorCode = operatorCode;
    }

    /**
     * 属性打印时间/打印时间的getter方法
     */
    public java.util.Date getOperaDate() {
        return operaDate;
    }

    /**
     * 属性打印时间/打印时间的setter方法
     */
    public void setOperaDate(java.util.Date operaDate) {
        this.operaDate = operaDate;
    }
}
