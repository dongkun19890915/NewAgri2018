package com.sinosoft.agriprpall.api.endorsemanage.dto;

import com.sinosoft.framework.dto.BaseRequest;

import java.io.Serializable;
import java.util.Date;

public class PrpPfeeCopyDto extends BaseRequest implements Serializable{
    private static final long serialVersionUID = 1L;
    /** 属性批单号/批单号 */
    private String endorseNo ;
    /** 属性保单号/保单号 */
    private String policyNo ;
    /** 属性险种代码/险种代码 */
    private String riskCode ;
    /** 属性币别信息/币别信息 */
    private String currency ;
    /** 属性amount/amount */
    private Double amount ;
    /** 属性premium/premium */
    private Double premium ;
    /** 属性currency1/currency1 */
    private String currency1 ;
    /** 属性exchangeRate1/exchangeRate1 */
    private Double exchangeRate1 ;
    /** 属性amount1/amount1 */
    private Double amount1 ;
    /** 属性premium1/premium1 */
    private Double premium1 ;
    /** 属性currency2/currency2 */
    private String currency2 ;
    /** 属性exchangeRate2/exchangeRate2 */
    private Double exchangeRate2 ;
    /** 属性amount2/amount2 */
    private Double amount2 ;
    /** 属性premium2/premium2 */
    private Double premium2 ;
    /** 属性chgAmount/chgAmount */
    private Double chgAmount ;
    /** 属性chgPremium/chgPremium */
    private Double chgPremium ;
    /** 属性chgAmount1/chgAmount1 */
    private Double chgAmount1 ;
    /** 属性chgPremium1/chgPremium1 */
    private Double chgPremium1 ;
    /** 属性chgAmount2/chgAmount2 */
    private Double chgAmount2 ;
    /** 属性chgPremium2/chgPremium2 */
    private Double chgPremium2 ;
    /** 属性标志字段/标志字段 */
    private String flag ;
    /** 属性修改人/修改人 */
    private String update_By ;
    /** 属性修改时间/修改时间 */
    private Date update_Date ;
    /** 属性折合支付币别总不含税保费/折合支付币别总不含税保费 */
    private Double noTaxPremium ;
    /** 属性折合支付币别总不含税保费变化量/折合支付币别总不含税保费变化量 */
    private Double chgTaxPremium ;
    /** 属性折合支付币别总税额1/折合支付币别总税额1 */
    private Double taxFee ;
    /** 属性折合支付币别总税额变化量1/折合支付币别总税额变化量1 */
    private Double chgTaxFee ;
    /** 属性折合支付币别总不含税保费1/折合支付币别总不含税保费1 */
    private Double noTaxPremium1 ;
    /** 属性折合支付币别总不含税保费变化量1/折合支付币别总不含税保费变化量1 */
    private Double chgTaxPremium1 ;
    /** 属性折合支付币别总税额2/折合支付币别总税额2 */
    private Double taxFee1 ;
    /** 属性折合支付币别总税额变化量3/折合支付币别总税额变化量3 */
    private Double chgTaxFee1 ;
    /** 属性折合支付币别总不含税保费3/折合支付币别总不含税保费3 */
    private Double noTaxPremium2 ;
    /** 属性折合支付币别总不含税保费变化量3/折合支付币别总不含税保费变化量3 */
    private Double chgTaxPremium2 ;
    /** 属性折合支付币别总税额/折合支付币别总税额 */
    private Double taxFee2 ;
    /** 属性折合支付币别总税额变化量/折合支付币别总税额变化量 */
    private Double chgTaxFee2 ;

    private String feeCurrencyName;

    private String feeCurrencyName1;

    private String feeCurrencyName2;

    private String currency2Name;

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

    public String getRiskCode() {
        return riskCode;
    }

    public void setRiskCode(String riskCode) {
        this.riskCode = riskCode;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public Double getPremium() {
        return premium;
    }

    public void setPremium(Double premium) {
        this.premium = premium;
    }

    public String getCurrency1() {
        return currency1;
    }

    public void setCurrency1(String currency1) {
        this.currency1 = currency1;
    }

    public Double getExchangeRate1() {
        return exchangeRate1;
    }

    public void setExchangeRate1(Double exchangeRate1) {
        this.exchangeRate1 = exchangeRate1;
    }

    public Double getAmount1() {
        return amount1;
    }

    public void setAmount1(Double amount1) {
        this.amount1 = amount1;
    }

    public Double getPremium1() {
        return premium1;
    }

    public void setPremium1(Double premium1) {
        this.premium1 = premium1;
    }

    public String getCurrency2() {
        return currency2;
    }

    public void setCurrency2(String currency2) {
        this.currency2 = currency2;
    }

    public Double getExchangeRate2() {
        return exchangeRate2;
    }

    public void setExchangeRate2(Double exchangeRate2) {
        this.exchangeRate2 = exchangeRate2;
    }

    public Double getAmount2() {
        return amount2;
    }

    public void setAmount2(Double amount2) {
        this.amount2 = amount2;
    }

    public Double getPremium2() {
        return premium2;
    }

    public void setPremium2(Double premium2) {
        this.premium2 = premium2;
    }

    public Double getChgAmount() {
        return chgAmount;
    }

    public void setChgAmount(Double chgAmount) {
        this.chgAmount = chgAmount;
    }

    public Double getChgPremium() {
        return chgPremium;
    }

    public void setChgPremium(Double chgPremium) {
        this.chgPremium = chgPremium;
    }

    public Double getChgAmount1() {
        return chgAmount1;
    }

    public void setChgAmount1(Double chgAmount1) {
        this.chgAmount1 = chgAmount1;
    }

    public Double getChgPremium1() {
        return chgPremium1;
    }

    public void setChgPremium1(Double chgPremium1) {
        this.chgPremium1 = chgPremium1;
    }

    public Double getChgAmount2() {
        return chgAmount2;
    }

    public void setChgAmount2(Double chgAmount2) {
        this.chgAmount2 = chgAmount2;
    }

    public Double getChgPremium2() {
        return chgPremium2;
    }

    public void setChgPremium2(Double chgPremium2) {
        this.chgPremium2 = chgPremium2;
    }

    public String getFlag() {
        return flag;
    }

    public void setFlag(String flag) {
        this.flag = flag;
    }

    public String getUpdate_By() {
        return update_By;
    }

    public void setUpdate_By(String update_By) {
        this.update_By = update_By;
    }

    public Date getUpdate_Date() {
        return update_Date;
    }

    public void setUpdate_Date(Date update_Date) {
        this.update_Date = update_Date;
    }

    public Double getNoTaxPremium() {
        return noTaxPremium;
    }

    public void setNoTaxPremium(Double noTaxPremium) {
        this.noTaxPremium = noTaxPremium;
    }

    public Double getChgTaxPremium() {
        return chgTaxPremium;
    }

    public void setChgTaxPremium(Double chgTaxPremium) {
        this.chgTaxPremium = chgTaxPremium;
    }

    public Double getTaxFee() {
        return taxFee;
    }

    public void setTaxFee(Double taxFee) {
        this.taxFee = taxFee;
    }

    public Double getChgTaxFee() {
        return chgTaxFee;
    }

    public void setChgTaxFee(Double chgTaxFee) {
        this.chgTaxFee = chgTaxFee;
    }

    public Double getNoTaxPremium1() {
        return noTaxPremium1;
    }

    public void setNoTaxPremium1(Double noTaxPremium1) {
        this.noTaxPremium1 = noTaxPremium1;
    }

    public Double getChgTaxPremium1() {
        return chgTaxPremium1;
    }

    public void setChgTaxPremium1(Double chgTaxPremium1) {
        this.chgTaxPremium1 = chgTaxPremium1;
    }

    public Double getTaxFee1() {
        return taxFee1;
    }

    public void setTaxFee1(Double taxFee1) {
        this.taxFee1 = taxFee1;
    }

    public Double getChgTaxFee1() {
        return chgTaxFee1;
    }

    public void setChgTaxFee1(Double chgTaxFee1) {
        this.chgTaxFee1 = chgTaxFee1;
    }

    public Double getNoTaxPremium2() {
        return noTaxPremium2;
    }

    public void setNoTaxPremium2(Double noTaxPremium2) {
        this.noTaxPremium2 = noTaxPremium2;
    }

    public Double getChgTaxPremium2() {
        return chgTaxPremium2;
    }

    public void setChgTaxPremium2(Double chgTaxPremium2) {
        this.chgTaxPremium2 = chgTaxPremium2;
    }

    public Double getTaxFee2() {
        return taxFee2;
    }

    public void setTaxFee2(Double taxFee2) {
        this.taxFee2 = taxFee2;
    }

    public Double getChgTaxFee2() {
        return chgTaxFee2;
    }

    public void setChgTaxFee2(Double chgTaxFee2) {
        this.chgTaxFee2 = chgTaxFee2;
    }

    public String getFeeCurrencyName() {
        return feeCurrencyName;
    }

    public void setFeeCurrencyName(String feeCurrencyName) {
        this.feeCurrencyName = feeCurrencyName;
    }

    public String getFeeCurrencyName1() {
        return feeCurrencyName1;
    }

    public void setFeeCurrencyName1(String feeCurrencyName1) {
        this.feeCurrencyName1 = feeCurrencyName1;
    }

    public String getFeeCurrencyName2() {
        return feeCurrencyName2;
    }

    public void setFeeCurrencyName2(String feeCurrencyName2) {
        this.feeCurrencyName2 = feeCurrencyName2;
    }

    public String getCurrency2Name() {
        return currency2Name;
    }

    public void setCurrency2Name(String currency2Name) {
        this.currency2Name = currency2Name;
    }
}
