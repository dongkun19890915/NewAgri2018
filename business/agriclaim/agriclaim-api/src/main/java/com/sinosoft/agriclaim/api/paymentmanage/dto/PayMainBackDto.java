package com.sinosoft.agriclaim.api.paymentmanage.dto;

import com.sinosoft.framework.dto.BaseRequest;

import java.io.Serializable;

/**
 * （支付录入整单录单页面数据dto）
 * @author: 王志文
 * @date: 2018/1/2 10:00
 */
public class PayMainBackDto extends BaseRequest implements Serializable {
    private static final long serialVersionUID = 1L;
    /** 支付编号 */
    private String paymentNo;
    /** 领款人类型代码 */
    private String receiverType;
    /** 领款人类型名称 */
    private String receiverTypeName;
    /** 领款人证件类型 */
    private String identifyType;
    /** 领款人证件号 */
    private String identifyNumber;
    /** 紧急程度 */
    private String urgentType;
    /** 省份名称 */
    private String provinceName;
    /** 城市名称 */
    private String cityName;
    /** 账号属性 */
    private String accountFlag;
    /** 开户银行大类 */
    private String bankType;
    /** 开户银行名称 */
    private String bankName;
    /** 银行账号 */
    private String bankAccount;
    /** 账号类型01-银行卡 02-存折 03-对公账号 */
    private String accountType;
    /** 领款人手机号 */
    private String mobilePhone;
    /** 家庭电话 */
    private String familyPhone;
    /** 办公电话 */
    private String officePhone;
    /** 详细地址 */
    private String address;
    /** qq号码 */
    private String qqNumber;
    /** 电子邮箱 */
    private String email;
    /** 单位联系人 */
    private String unitLink;
    /** 邮政编码 */
    private String postCode;
    /** 支付方式 */
    private String payType;
    /** 用途说明 */
    private String description;
    /** 支付方式 1第三方支付 2传统方式支付 */
    private String payWay;

    public String getPaymentNo() {
        return paymentNo;
    }

    public void setPaymentNo(String paymentNo) {
        this.paymentNo = paymentNo;
    }

    public String getReceiverType() {
        return receiverType;
    }

    public void setReceiverType(String receiverType) {
        this.receiverType = receiverType;
    }

    public String getReceiverTypeName() {
        return receiverTypeName;
    }

    public void setReceiverTypeName(String receiverTypeName) {
        this.receiverTypeName = receiverTypeName;
    }

    public String getIdentifyType() {
        return identifyType;
    }

    public void setIdentifyType(String identifyType) {
        this.identifyType = identifyType;
    }

    public String getIdentifyNumber() {
        return identifyNumber;
    }

    public void setIdentifyNumber(String identifyNumber) {
        this.identifyNumber = identifyNumber;
    }

    public String getUrgentType() {
        return urgentType;
    }

    public void setUrgentType(String urgentType) {
        this.urgentType = urgentType;
    }

    public String getProvinceName() {
        return provinceName;
    }

    public void setProvinceName(String provinceName) {
        this.provinceName = provinceName;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public String getAccountFlag() {
        return accountFlag;
    }

    public void setAccountFlag(String accountFlag) {
        this.accountFlag = accountFlag;
    }

    public String getBankType() {
        return bankType;
    }

    public void setBankType(String bankType) {
        this.bankType = bankType;
    }

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    public String getBankAccount() {
        return bankAccount;
    }

    public void setBankAccount(String bankAccount) {
        this.bankAccount = bankAccount;
    }

    public String getAccountType() {
        return accountType;
    }

    public void setAccountType(String accountType) {
        this.accountType = accountType;
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

    public String getPayType() {
        return payType;
    }

    public void setPayType(String payType) {
        this.payType = payType;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPayWay() {
        return payWay;
    }

    public void setPayWay(String payWay) {
        this.payWay = payWay;
    }
}
