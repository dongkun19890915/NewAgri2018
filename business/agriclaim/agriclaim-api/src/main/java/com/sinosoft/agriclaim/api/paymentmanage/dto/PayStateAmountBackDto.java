package com.sinosoft.agriclaim.api.paymentmanage.dto;

import com.sinosoft.framework.dto.BaseRequest;

import java.io.Serializable;

/***（状态金额总计查询返参dto）
* @Author: 王志文
* @Date: 2018/1/5 9:24
*/
public class PayStateAmountBackDto  extends BaseRequest implements Serializable {
    private static final long serialVersionUID = 1L;
    /** 支付状态 */
    private String paymentState;
    /** 金额 */
    private double payAmount;

    public String getPaymentState() {
        return paymentState;
    }

    public void setPaymentState(String paymentState) {
        this.paymentState = paymentState;
    }

    public double getPayAmount() {
        return payAmount;
    }

    public void setPayAmount(double payAmount) {
        this.payAmount = payAmount;
    }
}
