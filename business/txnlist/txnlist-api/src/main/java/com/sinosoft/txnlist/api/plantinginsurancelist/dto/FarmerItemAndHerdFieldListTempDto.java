package com.sinosoft.txnlist.api.plantinginsurancelist.dto;

import com.sinosoft.framework.dto.BaseRequest;
import com.sinosoft.txnlist.api.gisinsurelist.dto.GisHerdFieldListDto;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

public class FarmerItemAndHerdFieldListTempDto extends BaseRequest implements Serializable {

    private Map<String,List<GisHerdFieldListDto>> map;

    public Map<String, List<GisHerdFieldListDto>> getMap() {
        return map;
    }

    public void setMap(Map<String, List<GisHerdFieldListDto>> map) {
        this.map = map;
    }
}
