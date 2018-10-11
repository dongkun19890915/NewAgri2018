package com.sinosoft.txnlist.core.plantinginsurancelist.entity;

import com.sinosoft.framework.core.dao.BasePKImpl;

import javax.persistence.Column;

public class NyxEffectiveAmountKey extends BasePKImpl {
    private static final long serialVersionUID = 1L;

    public NyxEffectiveAmountKey(){}
    public NyxEffectiveAmountKey(String businessNo,String riskCode,String kindCode,String itemCode,String fCode,Integer flag){
        this.businessNo=businessNo;
        this.riskCode=riskCode;
        this.kindCode=kindCode;
        this.itemCode=itemCode;
        this.fCode=fCode;
        this.flag=flag;
    }

    /*业务号*/
    @Column(name = "businessNo")
    private String businessNo;

    /*险种代码*/
    @Column(name = "riskCode")
    private String riskCode;

    /*险别代码*/
    @Column(name = "kindCode")
    private String kindCode;

    /*标的代码*/
    @Column(name = "itemCode")
    private String itemCode;

    /*农户代码*/
    @Column(name = "fCode")
    private String fCode;

    @Column(name = "flag")
    private Integer flag;

    public Integer getFlag() {
        return flag;
    }

    public void setFlag(Integer flag) {
        this.flag = flag;
    }

    public String getBusinessNo() {
        return businessNo;
    }

    public void setBusinessNo(String businessNo) {
        this.businessNo = businessNo;
    }

    public String getRiskCode() {
        return riskCode;
    }

    public void setRiskCode(String riskCode) {
        this.riskCode = riskCode;
    }

    public String getKindCode() {
        return kindCode;
    }

    public void setKindCode(String kindCode) {
        this.kindCode = kindCode;
    }

    public String getItemCode() {
        return itemCode;
    }

    public void setItemCode(String itemCode) {
        this.itemCode = itemCode;
    }

    public String getfCode() {
        return fCode;
    }

    public void setfCode(String fCode) {
        this.fCode = fCode;
    }

}
