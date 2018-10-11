package com.sinosoft.agriprpall.api.paymanage.dto;

import com.sinosoft.framework.dto.BaseRequest;

import java.io.Serializable;

/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time 2018-05-27 08:23:10.186
 * 支付信息表Api操作对象
 */
public class PrpCpayInfoDto extends BaseRequest implements Serializable {
    private static final long serialVersionUID = 1L;
    /**
     * 属性批单号/批单号
     */
    private String endorseNo;
    /**
     * 属性收款人/收款人
     */
    private String receiverFullName;
    /**
     * 属性卡号或账号/卡号或账号
     */
    private String bankAccount;
    /**
     * 属性银行类型/银行类型
     */
    private String bankType;
    /**
     * 属性开户银行/开户银行
     */
    private String bank;
    /**
     * 属性开户行所在省份/开户行所在省份
     */
    private String bankProv;
    /**
     * 属性开户行所在城市/开户行所在城市
     */
    private String bankCity;
    /**
     * 属性账户属性/账户属性
     */
    private String accountType;
    /**
     * 属性账号类型/账号类型
     */
    private String accountFlag;
    /**
     * 属性证件类型/证件类型
     */
    private String certifyType;
    /**
     * 属性证件号码/证件号码
     */
    private String certifyNo;
    /**
     * 属性领款人类型/领款人类型
     */
    private String receiverType;
    /**
     * 属性手机号码/手机号码
     */
    private String mobilePhone;
    /**
     * 属性家庭号码/家庭号码
     */
    private String familyPhone;
    /**
     * 属性办公电话/办公电话
     */
    private String officePhone;
    /**
     * 属性详细地址/详细地址
     */
    private String address;
    /**
     * 属性qq号码/qq号码
     */
    private String qqNumber;
    /**
     * 属性电子邮件/电子邮件
     */
    private String email;
    /**
     * 属性单位联系人/单位联系人
     */
    private String unitLink;
    /**
     * 属性邮政编码/邮政编码
     */
    private String postCode;
    /**
     * 属性紧急程度/紧急程度
     */
    private String urgentType;
    /**
     * 属性支付方式 1第三方支付 2传统方式支付/支付方式 1第三方支付 2传统方式支付
     */
    private String payType;
    /**
     * 属性用途说明/用途说明
     */
    private String payPurpose;
    /**
     * 属性选传统支付的原因/选传统支付的原因
     */
    private String payReason;
    /**
     * 属性扩展字段1/扩展字段1
     */
    private String businessNo1;
    /**
     * 属性扩展字段2/扩展字段2
     */
    private String businessNo2;

    public String getEndorseNo() {
        return endorseNo;
    }

    public void setEndorseNo(String endorseNo) {
        this.endorseNo = endorseNo;
    }

    public String getReceiverFullName() {
        return receiverFullName;
    }

    public void setReceiverFullName(String receiverFullName) {
        this.receiverFullName = receiverFullName;
    }

    public String getBankAccount() {
        return bankAccount;
    }

    public void setBankAccount(String bankAccount) {
        this.bankAccount = bankAccount;
    }

    public String getBankType() {
        return bankType;
    }

    public void setBankType(String bankType) {
        this.bankType = bankType;
    }

    public String getBank() {
        return bank;
    }

    public void setBank(String bank) {
        this.bank = bank;
    }

    public String getBankProv() {
        return bankProv;
    }

    public void setBankProv(String bankProv) {
        this.bankProv = bankProv;
    }

    public String getBankCity() {
        return bankCity;
    }

    public void setBankCity(String bankCity) {
        this.bankCity = bankCity;
    }

    public String getAccountType() {
        return accountType;
    }

    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }

    public String getAccountFlag() {
        return accountFlag;
    }

    public void setAccountFlag(String accountFlag) {
        this.accountFlag = accountFlag;
    }

    public String getCertifyType() {
        return certifyType;
    }

    public void setCertifyType(String certifyType) {
        this.certifyType = certifyType;
    }

    public String getCertifyNo() {
        return certifyNo;
    }

    public void setCertifyNo(String certifyNo) {
        this.certifyNo = certifyNo;
    }

    public String getReceiverType() {
        return receiverType;
    }

    public void setReceiverType(String receiverType) {
        this.receiverType = receiverType;
    }

    public String getMobilePhone() {
        return mobilePhone;
    }

    public void setMobilePhone(String mobilePhone) {
        this.mobilePhone = mobilePhone;
    }

    public String getFamilyPhone() {
        return familyPhone;
    }

    public void setFamilyPhone(String familyPhone) {
        this.familyPhone = familyPhone;
    }

    public String getOfficePhone() {
        return officePhone;
    }

    public void setOfficePhone(String officePhone) {
        this.officePhone = officePhone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getQqNumber() {
        return qqNumber;
    }

    public void setQqNumber(String qqNumber) {
        this.qqNumber = qqNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUnitLink() {
        return unitLink;
    }

    public void setUnitLink(String unitLink) {
        this.unitLink = unitLink;
    }

    public String getPostCode() {
        return postCode;
    }

    public void setPostCode(String postCode) {
        this.postCode = postCode;
    }

    public String getUrgentType() {
        return urgentType;
    }

    public void setUrgentType(String urgentType) {
        this.urgentType = urgentType;
    }

    public String getPayType() {
        return payType;
    }

    public void setPayType(String payType) {
        this.payType = payType;
    }

    public String getPayPurpose() {
        return payPurpose;
    }

    public void setPayPurpose(String payPurpose) {
        this.payPurpose = payPurpose;
    }

    public String getPayReason() {
        return payReason;
    }

    public void setPayReason(String payReason) {
        this.payReason = payReason;
    }

    public String getBusinessNo1() {
        return businessNo1;
    }

    public void setBusinessNo1(String businessNo1) {
        this.businessNo1 = businessNo1;
    }

    public String getBusinessNo2() {
        return businessNo2;
    }

    public void setBusinessNo2(String businessNo2) {
        this.businessNo2 = businessNo2;
    }
}
