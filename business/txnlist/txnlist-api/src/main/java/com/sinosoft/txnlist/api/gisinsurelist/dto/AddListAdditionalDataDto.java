package com.sinosoft.txnlist.api.gisinsurelist.dto;

import com.sinosoft.framework.dto.BaseRequest;

import java.io.Serializable;
import java.util.List;

public class AddListAdditionalDataDto implements Serializable {
    /**
     * 属性标的代码/标的代码
     */
    private String itemCode;

    /**
     * 属性投保数量/投保数量
     */
    private Double insureCount;

    /**
     * 连带被保险人清单
     */
    private List<GisManFieldListDto> manFieldList;

    /**
     * 耳标号清单
     */
    private List<GisHerdFieldListDto> herdFieldList;


    public String getItemCode() {
        return itemCode;
    }

    public void setItemCode(String itemCode) {
        this.itemCode = itemCode;
    }

    public Double getInsureCount() {
        return insureCount;
    }

    public void setInsureCount(Double insureCount) {
        this.insureCount = insureCount;
    }

    public List<GisManFieldListDto> getManFieldList() {
        return manFieldList;
    }

    public void setManFieldList(List<GisManFieldListDto> manFieldList) {
        this.manFieldList = manFieldList;
    }

    public List<GisHerdFieldListDto> getHerdFieldList() {
        return herdFieldList;
    }

    public void setHerdFieldList(List<GisHerdFieldListDto> herdFieldList) {
        this.herdFieldList = herdFieldList;
    }
}
