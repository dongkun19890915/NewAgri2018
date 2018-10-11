package com.sinosoft.txnlist.api.plantinginsurancelist.dto;

import com.sinosoft.framework.dto.BaseRequest;
import com.sinosoft.txnlist.api.gisinsurelist.dto.GisFarmerItemDto;
import com.sinosoft.txnlist.api.gisinsurelist.dto.GisHerdFieldListDto;

import java.io.Serializable;
import java.util.List;

/** 农户信息与耳标号信息Dto
* @Author: 田健
* @Date: 2018/3/1 10:34
*/
public class FarmerItemAndHerdFieldListDto extends BaseRequest implements Serializable {
    //农户信息集合
    private List<GisFarmerItemDto> gisFarmerItemDtoList;
    private FarmerItemAndHerdFieldListTempDto farmerItemAndHerdFieldListTempDto;

    public List<GisFarmerItemDto> getGisFarmerItemDtoList() {
        return gisFarmerItemDtoList;
    }

    public void setGisFarmerItemDtoList(List<GisFarmerItemDto> gisFarmerItemDtoList) {
        this.gisFarmerItemDtoList = gisFarmerItemDtoList;
    }

    public FarmerItemAndHerdFieldListTempDto getFarmerItemAndHerdFieldListTempDto() {
        return farmerItemAndHerdFieldListTempDto;
    }

    public void setFarmerItemAndHerdFieldListTempDto(FarmerItemAndHerdFieldListTempDto farmerItemAndHerdFieldListTempDto) {
        this.farmerItemAndHerdFieldListTempDto = farmerItemAndHerdFieldListTempDto;
    }
}
