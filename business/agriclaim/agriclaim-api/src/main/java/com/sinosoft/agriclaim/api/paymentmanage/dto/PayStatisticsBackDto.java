package com.sinosoft.agriclaim.api.paymentmanage.dto;

import com.sinosoft.framework.dto.BaseRequest;

import java.io.Serializable;

/***（支付情况统计更多查询页面返回数据dto）
* @Author: 王志文
* @Date: 2018/1/3 14:26
*/
public class PayStatisticsBackDto extends BaseRequest implements Serializable {
    private static final long serialVersionUID = 1L;
    /** 批次号/清单号 */
    private String billNo;
    /** 支付编号 */
    private String paymentNo;
    /** 领款人姓名 */
    private String receiverName;
    /** 领款人账号 */
    private String receiverAccount;
    /** 金额 */
    private String payAmount;
    /** 状态 */
    private String payType;
    /** 支付说明 */
    private String purpose;

    public String getBillNo() {
        return billNo;
    }

    public void setBillNo(String billNo) {
        this.billNo = billNo;
    }

    public String getPaymentNo() {
        return paymentNo;
    }

    public void setPaymentNo(String paymentNo) {
        this.paymentNo = paymentNo;
    }

    public String getReceiverName() {
        return receiverName;
    }

    public void setReceiverName(String receiverName) {
        this.receiverName = receiverName;
    }

    public String getReceiverAccount() {
        return receiverAccount;
    }

    public void setReceiverAccount(String receiverAccount) {
        this.receiverAccount = receiverAccount;
    }

    public String getPayAmount() {
        return payAmount;
    }

    public void setPayAmount(String payAmount) {
        this.payAmount = payAmount;
    }

    public String getPayType() {
        return payType;
    }

    public void setPayType(String payType) {
        this.payType = payType;
    }

    public String getPurpose() {
        return purpose;
    }

    public void setPurpose(String purpose) {
        this.purpose = purpose;
    }
}
