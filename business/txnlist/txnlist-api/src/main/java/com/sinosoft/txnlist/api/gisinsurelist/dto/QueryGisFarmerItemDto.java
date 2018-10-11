package com.sinosoft.txnlist.api.gisinsurelist.dto;

import com.sinosoft.framework.dto.BasePageableRequest;

import java.io.Serializable;
import java.util.List;

public class QueryGisFarmerItemDto extends BasePageableRequest implements Serializable {

    private static final long serialVersionUID = 1L;
    /*清单号*/
    private String insureListCode;
    /*序列号*/
    private String serialNo;
    /*标的清单号集合*/
    private List<String> itemListCodes;
    /*标的*/
    private List<String> kindCodeList;

    public List<String> getKindCodeList() {
        return kindCodeList;
    }

    public void setKindCodeList(List<String> kindCodeList) {
        this.kindCodeList = kindCodeList;
    }

    public String getSerialNo() {
        return serialNo;
    }

    public void setSerialNo(String serialNo) {
        this.serialNo = serialNo;
    }

    public List<String> getItemListCodes() {
        return itemListCodes;
    }

    public void setItemListCodes(List<String> itemListCodes) {
        this.itemListCodes = itemListCodes;
    }

    public String getInsureListCode() {
        return insureListCode;
    }

    public void setInsureListCode(String insureListCode) {
        this.insureListCode = insureListCode;
    }
}
