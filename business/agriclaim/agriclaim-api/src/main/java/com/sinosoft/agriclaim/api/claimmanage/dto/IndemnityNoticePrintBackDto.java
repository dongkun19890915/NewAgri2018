package com.sinosoft.agriclaim.api.claimmanage.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.sinosoft.framework.dto.BaseRequest;

import java.io.Serializable;
import java.util.Date;

/***（赔款收据打印数据Dto）
* @Author: 王志文
* @Date: 2017/11/23 19:39
*/
public class IndemnityNoticePrintBackDto extends BaseRequest implements Serializable{
    private static final long serialVersionUID = 1L;
    /** 被保险人 */
    private String insuredName;
    /** 保单号 */
    private String policyNo;
    /** 险种名称 */
    private String riskCName;
    /** 计算书号 */
    private String compensateNo;
    /** 赔案金额 */
    private String sumClaim; //保险损失金额 prplclaim
    /** 赔案金额大写 */
    private String capitalSumClaim;
    /** 收款人开户银行 */
    private String bank;
    /** 收款人账户名称 */
    private String receiverName;
    /** 收款人银行账号 */
    private String account;
    /** 核赔人 */
    private String underWriteName;
    /** 经办人 */
    private String handlerCode;
    /** 打印时间 */
    private String printTime;

    public String getCapitalSumClaim() {
        return capitalSumClaim;
    }

    public void setCapitalSumClaim(String capitalSumClaim) {
        this.capitalSumClaim = capitalSumClaim;
    }

    public String getInsuredName() {
        return insuredName;
    }

    public void setInsuredName(String insuredName) {
        this.insuredName = insuredName;
    }

    public String getPolicyNo() {
        return policyNo;
    }

    public void setPolicyNo(String policyNo) {
        this.policyNo = policyNo;
    }

    public String getRiskCName() {
        return riskCName;
    }

    public void setRiskCName(String riskCName) {
        this.riskCName = riskCName;
    }

    public String getCompensateNo() {
        return compensateNo;
    }

    public void setCompensateNo(String compensateNo) {
        this.compensateNo = compensateNo;
    }

    public String getSumClaim() {
        return sumClaim;
    }

    public void setSumClaim(String sumClaim) {
        this.sumClaim = sumClaim;
    }

    public String getBank() {
        return bank;
    }

    public void setBank(String bank) {
        this.bank = bank;
    }

    public String getReceiverName() {
        return receiverName;
    }

    public void setReceiverName(String receiverName) {
        this.receiverName = receiverName;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getUnderWriteName() {
        return underWriteName;
    }

    public void setUnderWriteName(String underWriteName) {
        this.underWriteName = underWriteName;
    }

    public String getHandlerCode() {
        return handlerCode;
    }

    public void setHandlerCode(String handlerCode) {
        this.handlerCode = handlerCode;
    }

    public String getPrintTime() {
        return printTime;
    }

    public void setPrintTime(String printTime) {
        this.printTime = printTime;
    }
}
