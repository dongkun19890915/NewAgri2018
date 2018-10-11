package com.sinosoft.agriprpall.api.policymanage.dto;

import java.util.List;

public class ResponsePaymentNoticeDto {
    /*客户姓名 */
    private String insuredName;
    /*缴费通知单编号 */
    private String policyFeeNo;
    /*机构中文名 */
    private String comCName;
    /*缴费内容 */
    private List<PaymentContentDto> paymentContentlist;

    public String getInsuredName() {
        return insuredName;
    }

    public void setInsuredName(String insuredName) {
        this.insuredName = insuredName;
    }

    public List<PaymentContentDto> getPaymentContentlist() {
        return paymentContentlist;
    }

    public void setPaymentContentlist(List<PaymentContentDto> paymentContentlist) {
        this.paymentContentlist = paymentContentlist;
    }

    public String getPolicyFeeNo() {
        return policyFeeNo;
    }

    public void setPolicyFeeNo(String policyFeeNo) {
        this.policyFeeNo = policyFeeNo;
    }

    public String getComCName() {
        return comCName;
    }

    public void setComCName(String comCName) {
        this.comCName = comCName;
    }
}
