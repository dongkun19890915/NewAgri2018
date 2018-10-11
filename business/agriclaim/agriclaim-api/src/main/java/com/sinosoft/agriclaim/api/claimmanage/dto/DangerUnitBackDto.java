package com.sinosoft.agriclaim.api.claimmanage.dto;

import com.sinosoft.framework.dto.BaseRequest;

import java.io.Serializable;

public class DangerUnitBackDto extends BaseRequest implements Serializable {

    //标的序号
    private Integer itemKind;
    //危险单位号
    private Integer dangerNo;
    //危险单位描述
    private String dangerDesc;
    //地址描述
    private String addressName;
    //币别
    private String currency;
    //估损金额
    private String sumLoss;
    //占比
    private Double dangerKindShare;
    //险别代码
    private String kindCode;
    //险别名称
    private String kindName;
    //标的代码
    private String itemKindCode;
    //标的名称
    private String itemKindName;

    public Integer getItemKind() {
        return itemKind;
    }

    public void setItemKind(Integer itemKind) {
        this.itemKind = itemKind;
    }

    public Integer getDangerNo() {
        return dangerNo;
    }

    public void setDangerNo(Integer dangerNo) {
        this.dangerNo = dangerNo;
    }

    public String getDangerDesc() {
        return dangerDesc;
    }

    public void setDangerDesc(String dangerDesc) {
        this.dangerDesc = dangerDesc;
    }

    public String getAddressName() {
        return addressName;
    }

    public void setAddressName(String addressName) {
        this.addressName = addressName;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getSumLoss() {
        return sumLoss;
    }

    public void setSumLoss(String sumLoss) {
        this.sumLoss = sumLoss;
    }

    public Double getDangerKindShare() {
        return dangerKindShare;
    }

    public void setDangerKindShare(Double dangerKindShare) {
        this.dangerKindShare = dangerKindShare;
    }

    public String getKindCode() {
        return kindCode;
    }

    public void setKindCode(String kindCode) {
        this.kindCode = kindCode;
    }

    public String getKindName() {
        return kindName;
    }

    public void setKindName(String kindName) {
        this.kindName = kindName;
    }

    public String getItemKindCode() {
        return itemKindCode;
    }

    public void setItemKindCode(String itemKindCode) {
        this.itemKindCode = itemKindCode;
    }

    public String getItemKindName() {
        return itemKindName;
    }

    public void setItemKindName(String itemKindName) {
        this.itemKindName = itemKindName;
    }
}
