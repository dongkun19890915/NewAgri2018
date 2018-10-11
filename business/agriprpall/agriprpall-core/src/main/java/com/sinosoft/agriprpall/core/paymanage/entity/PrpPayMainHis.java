package com.sinosoft.agriprpall.core.paymanage.entity;

import com.sinosoft.framework.core.dao.BaseEntityImpl;

import javax.persistence.*;

/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time 2017-12-20 08:18:36.753
 * 承保支付信息轨迹表实体操作对象
 */
@Entity
@Table(name = "PrpPayMainHis")
@IdClass(PrpPayMainHisKey.class)
public class PrpPayMainHis extends BaseEntityImpl {

    private static final long serialVersionUID = 1L;
    /**
     * 属性支付号/支付号
     */
    @Id
    @Column(name = "payNo")
    private String payNo;
    /**
     * 属性农户代码/农户代码
     */
    @Id
    @Column(name = "fCode")
    private String fCode;
    /**
     * 属性序号/序号
     */
    @Id
    @Column(name = "serialNo")
    private Integer serialNo;


    /**
     * 属性农户姓名/农户姓名
     */
    @Column(name = "fName")
    private String fName;

    /**
     * 属性领款人类型/领款人类型
     */
    @Column(name = "receiverType")
    private String receiverType;
    /**
     * 属性领款人姓名/领款人姓名
     */
    @Column(name = "receiverName")
    private String receiverName;
    /**
     * 属性证件类型/证件类型
     */
    @Column(name = "certifyType")
    private String certifyType;
    /**
     * 属性证件号码/证件号码
     */
    @Column(name = "certifyNo")
    private String certifyNo;
    /**
     * 属性紧急程度/紧急程度
     */
    @Column(name = "ugentType")
    private String ugentType;
    /**
     * 属性省份名称/省份名称
     */
    @Column(name = "bankProv")
    private String bankProv;
    /**
     * 属性城市名称/城市名称
     */
    @Column(name = "bankCity")
    private String bankCity;
    /**
     * 属性账号属性/账号属性
     */
    @Column(name = "accountType")
    private String accountType;
    /**
     * 属性银行大类/银行大类
     */
    @Column(name = "bankType")
    private String bankType;
    /**
     * 属性开户银行/开户银行
     */
    @Column(name = "bank")
    private String bank;
    /**
     * 属性银行账号/银行账号
     */
    @Column(name = "bankAccount")
    private String bankAccount;
    /**
     * 属性账号类型/账号类型
     */
    @Column(name = "accountFlag")
    private String accountFlag;
    /**
     * 属性手机号码/手机号码
     */
    @Column(name = "mobilePhone")
    private String mobilePhone;
    /**
     * 属性家庭电话/家庭电话
     */
    @Column(name = "familyPhone")
    private String familyPhone;
    /**
     * 属性办公电话/办公电话
     */
    @Column(name = "officePhone")
    private String officePhone;
    /**
     * 属性详细地址/详细地址
     */
    @Column(name = "address")
    private String address;
    /**
     * 属性QQ号码/QQ号码
     */
    @Column(name = "qqNumber")
    private String qqNumber;
    /**
     * 属性电子邮件/电子邮件
     */
    @Column(name = "email")
    private String email;
    /**
     * 属性单位联系人/单位联系人
     */
    @Column(name = "unitLink")
    private String unitLink;
    /**
     * 属性邮政编码/邮政编码
     */
    @Column(name = "postCode")
    private String postCode;
    /**
     * 属性用途说明/用途说明
     */
    @Column(name = "payPurpose")
    private String payPurpose;
    /**
     * 支付行号
     */
    @Column(name = "routeNum")
    private String routeNum;

    public String getPayNo() {
        return payNo;
    }

    public void setPayNo(String payNo) {
        this.payNo = payNo;
    }

    public String getfCode() {
        return fCode;
    }

    public void setfCode(String fCode) {
        this.fCode = fCode;
    }

    public Integer getSerialNo() {
        return serialNo;
    }

    public void setSerialNo(Integer serialNo) {
        this.serialNo = serialNo;
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

    public String getUgentType() {
        return ugentType;
    }

    public void setUgentType(String ugentType) {
        this.ugentType = ugentType;
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

    public String getBankAccount() {
        return bankAccount;
    }

    public void setBankAccount(String bankAccount) {
        this.bankAccount = bankAccount;
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
}