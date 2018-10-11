package com.sinosoft.txnlist.api.gisinsurelist.dto;

import com.sinosoft.framework.dto.BaseRequest;
import com.sinosoft.framework.dto.PageInfo;

import java.io.Serializable;
import java.util.List;

/**投保预确认数据主表与投保预确认农户清单表信息Dto
* @Author: 田健
* @Date: 2018/1/23 17:16
*/
public class ResponseGisMainAndFarmerListDto extends BaseRequest implements Serializable {
    /** 投保预确认数据主表*/
    private GisInsureMainListDto gisInsureMainListDto;
    /** 投保预确认农户清单表*/
    private List<GisFarmerListDto> gisFarmerListDtoList;
    private int count;

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public GisInsureMainListDto getGisInsureMainListDto() {
        return gisInsureMainListDto;
    }

    public void setGisInsureMainListDto(GisInsureMainListDto gisInsureMainListDto) {
        this.gisInsureMainListDto = gisInsureMainListDto;
    }

    public List<GisFarmerListDto> getGisFarmerListDtoList() {
        return gisFarmerListDtoList;
    }

    public void setGisFarmerListDtoList(List<GisFarmerListDto> gisFarmerListDtoList) {
        this.gisFarmerListDtoList = gisFarmerListDtoList;
    }
}
