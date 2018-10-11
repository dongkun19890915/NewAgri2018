package com.sinosoft.txnlist.api.gisinsurelist.dto;

import com.sinosoft.framework.dto.BaseRequest;

import java.io.Serializable;
import java.util.List;

public class RequestInsuranceInfoDto extends BaseRequest implements Serializable{
    private static final long serialVersionUID = 1L;
    /*标的清单号*/
    private List<String> itemListCodeList;
    /*序列号*/
    private Integer serialNo;
    /*清单号*/
    private String insureListCode;
    /*金禾清单号清单号*/
    private String gisInsureListCode;
    /* 标的代码*/
    private List<String> itemCodeList;
    /* 险别代码*/
    private List<String> kindCodeList;
    /** 险种*/
    private String riskCode;

    public List<String> getItemListCodeList() {
        return itemListCodeList;
    }

    public void setItemListCodeList(List<String> itemListCodeList) {
        this.itemListCodeList = itemListCodeList;
    }

    public Integer getSerialNo() {
        return serialNo;
    }

    public void setSerialNo(Integer serialNo) {
        this.serialNo = serialNo;
    }

    public String getInsureListCode() {
        return insureListCode;
    }

    public void setInsureListCode(String insureListCode) {        this.insureListCode = insureListCode;    }

    public String getGisInsureListCode() {        return gisInsureListCode;    }

    public void setGisInsureListCode(String gisInsureListCode) {        this.gisInsureListCode = gisInsureListCode;    }

    public List<String> getItemCodeList() {        return itemCodeList;    }

    public void setItemCodeList(List<String> itemCodeList) {        this.itemCodeList = itemCodeList;    }

    public List<String> getKindCodeList() {        return kindCodeList;    }

    public void setKindCodeList(List<String> kindCodeList) {        this.kindCodeList = kindCodeList;    }

    public String getRiskCode() {        return riskCode;    }

    public void setRiskCode(String riskCode) {        this.riskCode = riskCode;    }
}
