package com.sinosoft.agriclaim.api.paymentmanage.dto;

import com.sinosoft.framework.dto.BaseRequest;

import java.io.Serializable;

/**
 * （整单合并支付数据存放dto）
 * @author: 王志文
 * @date: 2017/12/29 9:59
 */
public class PaymentMessageDto extends BaseRequest implements Serializable {
    private static final long serialVersionUID = 1L;
    /** 报案号 */
    private String registNo;
    /** 保单号 */
    private String policyNo;
    /** 计算书号 */
    private String compensateNo;
    /** 被保险人 */
    private String insuredName;
    /** 赔款类型 */
    private String paymentType;
    /** 总支付金额 */
    private String payTotalAmount;
    /** 已支付金额 */
    private String havePayAmount;
    /** 支付金额 */
    private String payAmount;

    /** 支付编号**/
    private String paymentNo ;

    /** 支付序号 用于区分整单支付合并支付**/
    private String serialNo2 ;

    public String getSerialNo2() {
        return serialNo2;
    }

    public void setSerialNo2(String serialNo2) {
        this.serialNo2 = serialNo2;
    }

    public String getPaymentNo() {
        return paymentNo;
    }

    public void setPaymentNo(String paymentNo) {
        this.paymentNo = paymentNo;
    }

    public String getHavePayAmount() {
        return havePayAmount;
    }

    public void setHavePayAmount(String havePayAmount) {
        this.havePayAmount = havePayAmount;
    }

    public String getPolicyNo() {
        return policyNo;
    }

    public void setPolicyNo(String policyNo) {
        this.policyNo = policyNo;
    }

    public String getRegistNo() {
        return registNo;
    }

    public void setRegistNo(String registNo) {
        this.registNo = registNo;
    }

    public String getCompensateNo() {
        return compensateNo;
    }

    public void setCompensateNo(String compensateNo) {
        this.compensateNo = compensateNo;
    }

    public String getInsuredName() {
        return insuredName;
    }

    public void setInsuredName(String insuredName) {
        this.insuredName = insuredName;
    }

    public String getPaymentType() {
        return paymentType;
    }

    public void setPaymentType(String paymentType) {
        this.paymentType = paymentType;
    }

    public String getPayTotalAmount() {
        return payTotalAmount;
    }

    public void setPayTotalAmount(String payTotalAmount) {
        this.payTotalAmount = payTotalAmount;
    }

    public String getPayAmount() {
        return payAmount;
    }

    public void setPayAmount(String payAmount) {
        this.payAmount = payAmount;
    }
}
