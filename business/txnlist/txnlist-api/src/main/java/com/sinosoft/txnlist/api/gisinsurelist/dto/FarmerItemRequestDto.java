package com.sinosoft.txnlist.api.gisinsurelist.dto;

import java.util.List;

/**
 * description:
 *
 * @outhor wq
 * @create 2018-01-30 16:09
 */
public class FarmerItemRequestDto extends GisFarmerItemDto{
    private List<GisHerdFieldListDto> herdFieldList;
    private List<GisManFieldListDto> manFieldList;


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
