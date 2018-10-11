package com.sinosoft.txnlist.api.gisinsurelist.dto;

import com.sinosoft.framework.dto.BaseRequest;

import java.io.Serializable;
import java.util.Date;

/**
 * 投保预确认农户清单表Dto
 *
 * @Author: 何伟东
 * @Date: 2018/1/15 16:20
 */
public class GisFarmerListDto extends BaseRequest implements Serializable {
    private static final long serialVersionUID = 1L;
    /**
     * 属性清单编号/清单编号
     */
    private String inusreListCode;
    /**
     * 属性序列号/序列号
     */
    private Integer serialNo;
    /**
     * 属性农户代码/农户代码
     */
    private String fCode;
    /**
     * 属性农户姓名/农户姓名
     */
    private String fName;
    /**
     * 属性证件类型/证件类型
     */
    private String fIdType;
    /**
     * 属性证件号码/证件号码
     */
    private String fIdCard;
    /**
     * 属性组别/组别
     */
    private String teamName;
    /**
     * 属性联系电话号码/联系电话号码
     */
    private String fTel;
    /**
     * 属性联系手机号码/联系手机号码
     */
    private String fPhone;
    /**
     * 属性联系地址/联系地址
     */
    private String fAddress;
    /**
     * 属性微信号/微信号
     */
    private String fWechatAc;
    /**
     * 属性支付宝号/支付宝号
     */
    private String fAlipayAc;
    /**
     * 属性开户银行大类代码/开户银行大类代码
     */
    private String bankTypeCode;
    /**
     * 属性开户银行大类名称/开户银行大类名称
     */
    private String bankTypeName;
    /**
     * 属性开户银行所在省代码/开户银行所在省代码
     */
    private String brovinceCode;
    /**
     * 属性开户银行所在省名称/开户银行所在省名称
     */
    private String brovinceName;
    /**
     * 属性开户银行所在市代码/开户银行所在市代码
     */
    private String bcityCode;
    /**
     * 属性开户银行所在市名称/开户银行所在市名称
     */
    private String bcityName;
    /**
     * 属性开户银行代码/开户银行代码
     */
    private String bankCode;
    /**
     * 属性开户银行名称/开户银行名称
     */
    private String bankName;
    /**
     * 属性开户银行联行号/开户银行联行号
     */
    private String bankNumber;
    /**
     * 属性开户户名/开户户名
     */
    private String accountName;
    /**
     * 属性开户账号/开户账号
     */
    private String accountNo;
    /**
     * 属性土地确权证号码/土地确权证号码
     */
    private String landCard;
    /**
     * 属性土地确权总面积/土地确权总面积
     */
    private Double landArea;
    /**
     * 属性土地实际总面积/土地实际总面积
     */
    private Double realArea;
    /**
     * 属性投保总面积/投标总数量/投保总面积/投标总数量
     */
    private Double insureArea;
    /**
     * 属性实际投保总面积/实际投保总面积
     */
    private Double tinsurEarea;
    /**
     * 属性剔除面积/剔除面积
     */
    private Double delArea;
    /**
     * 属性整体调整原因/整体调整原因
     */
    private String adjustReason;

    // 针对草莓种植险种新增字段
    /**
     * 行业类别
     */
    private String industryCategory;
    /**
     * 贷款合同编号
     */
    private String loanContractNo;
    /**
     * 贷款银行代码
     */
    private String loanBankAccount;
    /**
     * 贷款金额
     */
    private String loadAmount;
    /**
     * 担保人
     */
    private String guarantor;
    /**
     * 贷款期限，请不要把这个 String 修改成 Date !!!!
     */
    private String loanPeriod;
    /**
     * 贷款用途
     */
    private String loanUse;

    public String getInusreListCode() {
        return inusreListCode;
    }

    public void setInusreListCode(String inusreListCode) {
        this.inusreListCode = inusreListCode;
    }

    public Integer getSerialNo() {
        return serialNo;
    }

    public void setSerialNo(Integer serialNo) {
        this.serialNo = serialNo;
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

    public String getfIdType() {
        return fIdType;
    }

    public void setfIdType(String fIdType) {
        this.fIdType = fIdType;
    }

    public String getfIdCard() {
        return fIdCard;
    }

    public void setfIdCard(String fIdCard) {
        this.fIdCard = fIdCard;
    }

    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    public String getfTel() {
        return fTel;
    }

    public void setfTel(String fTel) {
        this.fTel = fTel;
    }

    public String getfPhone() {
        return fPhone;
    }

    public void setfPhone(String fPhone) {
        this.fPhone = fPhone;
    }

    public String getfAddress() {
        return fAddress;
    }

    public void setfAddress(String fAddress) {
        this.fAddress = fAddress;
    }

    public String getfWechatAc() {
        return fWechatAc;
    }

    public void setfWechatAc(String fWechatAc) {
        this.fWechatAc = fWechatAc;
    }

    public String getfAlipayAc() {
        return fAlipayAc;
    }

    public void setfAlipayAc(String fAlipayAc) {
        this.fAlipayAc = fAlipayAc;
    }

    public String getBankTypeCode() {
        return bankTypeCode;
    }

    public void setBankTypeCode(String bankTypeCode) {
        this.bankTypeCode = bankTypeCode;
    }

    public String getBankTypeName() {
        return bankTypeName;
    }

    public void setBankTypeName(String bankTypeName) {
        this.bankTypeName = bankTypeName;
    }

    public String getBrovinceCode() {
        return brovinceCode;
    }

    public void setBrovinceCode(String brovinceCode) {
        this.brovinceCode = brovinceCode;
    }

    public String getBrovinceName() {
        return brovinceName;
    }

    public void setBrovinceName(String brovinceName) {
        this.brovinceName = brovinceName;
    }

    public String getBcityCode() {
        return bcityCode;
    }

    public void setBcityCode(String bcityCode) {
        this.bcityCode = bcityCode;
    }

    public String getBcityName() {
        return bcityName;
    }

    public void setBcityName(String bcityName) {
        this.bcityName = bcityName;
    }

    public String getBankCode() {
        return bankCode;
    }

    public void setBankCode(String bankCode) {
        this.bankCode = bankCode;
    }

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    public String getBankNumber() {
        return bankNumber;
    }

    public void setBankNumber(String bankNumber) {
        this.bankNumber = bankNumber;
    }

    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    public String getAccountNo() {
        return accountNo;
    }

    public void setAccountNo(String accountNo) {
        this.accountNo = accountNo;
    }

    public String getLandCard() {
        return landCard;
    }

    public void setLandCard(String landCard) {
        this.landCard = landCard;
    }

    public Double getLandArea() {
        return landArea;
    }

    public void setLandArea(Double landArea) {
        this.landArea = landArea;
    }

    public Double getRealArea() {
        return realArea;
    }

    public void setRealArea(Double realArea) {
        this.realArea = realArea;
    }

    public Double getInsureArea() {
        return insureArea;
    }

    public void setInsureArea(Double insureArea) {
        this.insureArea = insureArea;
    }

    public Double getTinsurEarea() {
        return tinsurEarea;
    }

    public void setTinsurEarea(Double tinsurEarea) {
        this.tinsurEarea = tinsurEarea;
    }

    public Double getDelArea() {
        return delArea;
    }

    public void setDelArea(Double delArea) {
        this.delArea = delArea;
    }

    public String getAdjustReason() {
        return adjustReason;
    }

    public void setAdjustReason(String adjustReason) {
        this.adjustReason = adjustReason;
    }

    public String getIndustryCategory() {
        return industryCategory;
    }

    public void setIndustryCategory(String industryCategory) {
        this.industryCategory = industryCategory;
    }

    public String getLoanContractNo() {
        return loanContractNo;
    }

    public void setLoanContractNo(String loanContractNo) {
        this.loanContractNo = loanContractNo;
    }

    public String getLoanBankAccount() {
        return loanBankAccount;
    }

    public void setLoanBankAccount(String loanBankAccount) {
        this.loanBankAccount = loanBankAccount;
    }

    public String getLoadAmount() {
        return loadAmount;
    }

    public void setLoadAmount(String loadAmount) {
        this.loadAmount = loadAmount;
    }

    public String getGuarantor() {
        return guarantor;
    }

    public void setGuarantor(String guarantor) {
        this.guarantor = guarantor;
    }

    public String getLoanPeriod() {
        return loanPeriod;
    }

    public void setLoanPeriod(String loanPeriod) {
        this.loanPeriod = loanPeriod;
    }

    public String getLoanUse() {
        return loanUse;
    }

    public void setLoanUse(String loanUse) {
        this.loanUse = loanUse;
    }
}
