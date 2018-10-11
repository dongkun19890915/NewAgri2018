package com.sinosoft.txnlist.api.gisinsurelist.dto;

import com.sinosoft.framework.dto.BaseRequest;

import java.io.Serializable;
import java.util.List;

/**
 * 交易清单金禾中间表Dto
 *
 * @Author: 何伟东
 * @Date: 2018/1/15 16:25
 */
public class GisInsureListDto extends BaseRequest implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * 投保预确认数据主表
     */
    private GisInsureMainListDto gisInsureMainListDto;

    /**
     * 投保预确认农户清单表
     */
    private List<? extends GisFarmerListDto> gisFarmerListDtos;
    /**
     * 投保预确认农户田块清单表
     */
    private List<GisFieldListDto> gisFieldListDtos;

    /**
     * 预投保清单标的表
     */
    private List<GisItemListDto> gisItemListDtos;

    /**
     * 预投保清单农户标的表
     */
    private List<? extends GisFarmerItemDto> gisFarmerItemDtos;

    /**
     * 预投保清单农户标的清单明细表（物）
     */
    private List<GisHerdFieldListDto> gisHerdFieldListDtos;

    /**
     * 预投保清单农户标的清单明细表（人）
     */
    private List<GisManFieldListDto> gisManFieldListDtos;

    public GisInsureMainListDto getGisInsureMainListDto() {
        return gisInsureMainListDto;
    }

    public void setGisInsureMainListDto(GisInsureMainListDto gisInsureMainListDto) {
        this.gisInsureMainListDto = gisInsureMainListDto;
    }

    public List<? extends GisFarmerListDto> getGisFarmerListDtos() {
        return gisFarmerListDtos;
    }

    public void setGisFarmerListDtos(List<? extends GisFarmerListDto> gisFarmerListDtos) {
        this.gisFarmerListDtos = gisFarmerListDtos;
    }

    public List<GisFieldListDto> getGisFieldListDtos() {
        return gisFieldListDtos;
    }

    public void setGisFieldListDtos(List<GisFieldListDto> gisFieldListDtos) {
        this.gisFieldListDtos = gisFieldListDtos;
    }

    public List<GisItemListDto> getGisItemListDtos() {
        return gisItemListDtos;
    }

    public void setGisItemListDtos(List<GisItemListDto> gisItemListDtos) {
        this.gisItemListDtos = gisItemListDtos;
    }

    public List<? extends GisFarmerItemDto> getGisFarmerItemDtos() {
        return gisFarmerItemDtos;
    }

    public void setGisFarmerItemDtos(List<? extends GisFarmerItemDto> gisFarmerItemDtos) {
        this.gisFarmerItemDtos = gisFarmerItemDtos;
    }

    public List<GisHerdFieldListDto> getGisHerdFieldListDtos() {
        return gisHerdFieldListDtos;
    }

    public void setGisHerdFieldListDtos(List<GisHerdFieldListDto> gisHerdFieldListDtos) {
        this.gisHerdFieldListDtos = gisHerdFieldListDtos;
    }

    public List<GisManFieldListDto> getGisManFieldListDtos() {
        return gisManFieldListDtos;
    }

    public void setGisManFieldListDtos(List<GisManFieldListDto> gisManFieldListDtos) {
        this.gisManFieldListDtos = gisManFieldListDtos;
    }
}
