package com.sinosoft.framework.agri.core.gycore.dto;

import java.util.List;

/**
 * description:
 *
 * @outhor wq
 * @create 2018-03-26 15:43
 */
public class FarmerItem {
    private String itemCode;
    private String insureCount;
    private List<GisHerdFieldListDto> herdFieldList;
    private List<GisManFieldListDto> manFieldList;

    public String getItemCode() {
        return itemCode;
    }

    public void setItemCode(String itemCode) {
        this.itemCode = itemCode;
    }

    public String getInsureCount() {
        return insureCount;
    }

    public void setInsureCount(String insureCount) {
        this.insureCount = insureCount;
    }

    public List<GisHerdFieldListDto> getHerdFieldList() {
        return herdFieldList;
    }

    public void setHerdFieldList(List<GisHerdFieldListDto> herdFieldList) {
        this.herdFieldList = herdFieldList;
    }

    public List<GisManFieldListDto> getManFieldList() {
        return manFieldList;
    }

    public void setManFieldList(List<GisManFieldListDto> manFieldList) {
        this.manFieldList = manFieldList;
    }
}
