package com.sinosoft.agriprpall.api.paymanage.dto;

import com.sinosoft.framework.agri.core.excel.annotation.ExportConfig;
import com.sinosoft.framework.dto.BaseRequest;

import java.io.Serializable;

/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time 2017-12-20 08:18:36.753
 * 承保主支付信息表Api操作对象
 */
public class PrpPayMainDto extends BaseRequest implements Serializable, Cloneable {
    private static final long serialVersionUID = 1L;

    /**
     * 序号
     */
    @ExportConfig(value = "序号",width = 50)
    private int serialNo;
    /**
     * 批单号码
     */
    @ExportConfig(value = "批单号码",width = 220)
    private String endorseNo;
    /**
     * 保单号码
     */
    @ExportConfig(value = "保单号码",width = 200)
    private String policyNo;
    /**
     * 农户代码
     */
    @ExportConfig(value = "农户代码",width = 170)
    private String fCode;
    /**
     * 农户名称
     */
    @ExportConfig(value = "农户名称",width = 120)
    private String fName;
    /**
     * 领款人类型
     */
    @ExportConfig(value = "领款人类型",width = 120)
    private String receiverType;
    /**
     * 领款人名称（银行账户户名）
     */
    @ExportConfig(value = "领款人名称（银行账户户名）",width = 240)
    private String receiverName;
    /**
     * 领款人证件类型
     */
    @ExportConfig(value = "领款人证件类型",width = 140)
    private String certifyType;
    /**
     * 领款人证件号
     */
    @ExportConfig(value = "领款人证件号",width = 170)
    private String certifyNo;
    /**
     * 开户银行大类名称
     */
    @ExportConfig(value = "开户银行大类名称",width = 150)
    private String bankType;
    /**
     * 开户银行所在省份名称
     */
    @ExportConfig(value = "开户银行所在省份名称",width = 170)
    private String bankProv;
    /**
     * 开户银行所在城市名称
     */
    @ExportConfig(value = "开户银行所在城市名称",width = 170)
    private String bankCity;
    /**
     * 开户银行名称
     */
    @ExportConfig(value = "开户银行名称",width = 150)
    private String bank;
    /**
     * 银行账号
     */
    @ExportConfig(value = "银行账号",width = 160)
    private String bankAccount;
    /**
     * 账号属性
     */
    @ExportConfig(value = "账号属性")
    private String accountType;
    /**
     * 账号类型
     */
    @ExportConfig(value = "账号类型")
    private String accountFlag;
    /**
     * 领款人手机号码
     */
    @ExportConfig(value = "领款人手机号码",width = 120)
    private String mobilePhone;
    /**
     * 退款金额（元）
     */
    @ExportConfig(value = "退款金额（元）",width = 120)
    private Double chgPremium;
    /**
     * 紧急程度
     */
    private String ugentType;
    /**
     * 家庭电话
     */
    private String familyPhone;
    /**
     * 办公电话
     */
    private String officePhone;
    /**
     * 详细地址
     */
    private String address;
    /**
     * QQ号码
     */
    private String qqNumber;
    /**
     * 电子邮件
     */
    private String email;
    /**
     * 单位联系人
     */
    private String unitLink;
    /**
     * 邮政编码
     */
    private String postCode;
    /**
     * 用途说明
     */
    private String payPurpose;

    /**
     * 支付行号
     */
    private String routeNum;

    /**
     * 属性支付方式 1第三方支付 2传统方式支付/支付方式 1第三方支付 2传统方式支付
     */
    private String payType;

    /**
     * 属性选传统支付的原因/选传统支付的原因
     */
    private String payReason;

    public int getSerialNo() {
        return serialNo;
    }

    public void setSerialNo(int serialNo) {
        this.serialNo = serialNo;
    }

    public String getEndorseNo() {
        return endorseNo;
    }

    public void setEndorseNo(String endorseNo) {
        this.endorseNo = endorseNo;
    }

    public String getPolicyNo() {
        return policyNo;
    }

    public void setPolicyNo(String policyNo) {
        this.policyNo = policyNo;
    }

    public String getfCode() {
        return fCode;
    }

    public void setfCode(String fCode) {
        this.fCode = fCode;
    }

    public String getfName() {
        return fName;
    }

    public void setfName(String fName) {
        this.fName = fName;
    }

    public String getReceiverType() {
        return receiverType;
    }

    public void setReceiverType(String receiverType) {
        this.receiverType = receiverType;
    }

    public String getReceiverName() {
        return receiverName;
    }

    public void setReceiverName(String receiverName) {
        this.receiverName = receiverName;
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

    public String getBankType() {
        return bankType;
    }

    public void setBankType(String bankType) {
        this.bankType = bankType;
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

    public String getBank() {
        return bank;
    }

    public void setBank(String bank) {
        this.bank = bank;
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

    public String getAccountFlag() {
        return accountFlag;
    }

    public void setAccountFlag(String accountFlag) {
        this.accountFlag = accountFlag;
    }

    public String getMobilePhone() {
        return mobilePhone;
    }

    public void setMobilePhone(String mobilePhone) {
        this.mobilePhone = mobilePhone;
    }

    public Double getChgPremium() {
        return chgPremium;
    }

    public void setChgPremium(Double chgPremium) {
        this.chgPremium = chgPremium == null ? 0.00:Math.abs(chgPremium);
    }

    public String getUgentType() {
        return ugentType;
    }

    public void setUgentType(String ugentType) {
        this.ugentType = ugentType;
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

    public String getPayPurpose() {
        return payPurpose;
    }

    public void setPayPurpose(String payPurpose) {
        this.payPurpose = payPurpose;
    }

    public String getRouteNum() {
        return routeNum;
    }

    public void setRouteNum(String routeNum) {
        this.routeNum = routeNum;
    }

    public String getPayType() {
        return payType;
    }

    public void setPayType(String payType) {
        this.payType = payType;
    }

    public String getPayReason() {
        return payReason;
    }

    public void setPayReason(String payReason) {
        this.payReason = payReason;
    }
}
