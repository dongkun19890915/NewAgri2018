package com.sinosoft.txnlist.api.plantinginsurancelist.dto;

import com.sinosoft.framework.dto.BaseRequest;
import com.sinosoft.txnlist.api.gisinsurelist.dto.*;
import com.sinosoft.txnlist.api.insuremainlist.dto.InsureMainListDto;

import java.io.Serializable;
import java.util.List;

/**
 * 保存投保单预确认DTO
 *
 * @author: 潘峰
 * @date: 2017/11/7 上午9:55
 */
public class InsurePreliminaryConfirmDto extends BaseRequest implements Serializable {

    private static final long serialVersionUID = 1L;
    /** 金禾：清单主表 */
    private GisInsureMainListDto gisInsureMainListDto;
    /** 金禾：种植险农户清单表 */
    private List<GisNyxInsuranceListDto> gisNyxInsuranceListDtos;
    /** 金禾：田块信息表 */
    private List<GisFeildDto> gisFeildDtos;
    /** 金禾：耳标号信息表 */
    private List<GisHerdFieldDto> gisHerdFieldDtos;

    //---------
    private List<GisFarmerListDto> gisFarmerListDtos;
    private List<GisFieldListDto> gisFieldListDtos;
    private List<GisHerdFieldListDto> gisHerdFieldListDtos;
    private List<GisFarmerItemDto> gisFarmerItemDtoList;

    public List<GisFarmerItemDto> getGisFarmerItemDtoList() {
        return gisFarmerItemDtoList;
    }

    public void setGisFarmerItemDtoList(List<GisFarmerItemDto> gisFarmerItemDtoList) {
        this.gisFarmerItemDtoList = gisFarmerItemDtoList;
    }
    private List<GisManFieldListDto> gisManFieldListDtoList;


    public List<GisManFieldListDto> getGisManFieldListDtoList() {
        return gisManFieldListDtoList;
    }

    public void setGisManFieldListDtoList(List<GisManFieldListDto> gisManFieldListDtoList) {
        this.gisManFieldListDtoList = gisManFieldListDtoList;
    }

    public List<GisFieldListDto> getGisFieldListDtos() {
        return gisFieldListDtos;
    }

    public void setGisFieldListDtos(List<GisFieldListDto> gisFieldListDtos) {
        this.gisFieldListDtos = gisFieldListDtos;
    }

    public List<GisHerdFieldListDto> getGisHerdFieldListDtos() {
        return gisHerdFieldListDtos;
    }

    public void setGisHerdFieldListDtos(List<GisHerdFieldListDto> gisHerdFieldListDtos) {
        this.gisHerdFieldListDtos = gisHerdFieldListDtos;
    }

    public List<GisFarmerListDto> getGisFarmerListDtos() {
        return gisFarmerListDtos;
    }

    public void setGisFarmerListDtos(List<GisFarmerListDto> gisFarmerListDtos) {
        this.gisFarmerListDtos = gisFarmerListDtos;
    }

    /** 清单主表 */
    private InsureMainListDto insureMainListDto;
    /** 种植险：投保清单表(农险一期) */
    private List<PlantingInsuranceListDto> plantingInsuranceListDtos;
    /** 养殖险：投保清单表(农险一期) */
    private List<HerdInsuranceListDto> herdInsuranceListDtos;
    /** 农业险：投保清单表(农险二期) */
    private List<NyxInsuranceListDto> nyxInsuranceListDtos;

    public GisInsureMainListDto getGisInsureMainListDto() {
        return gisInsureMainListDto;
    }

    public void setGisInsureMainListDto(GisInsureMainListDto gisInsureMainListDto) {
        this.gisInsureMainListDto = gisInsureMainListDto;
    }

    public List<GisNyxInsuranceListDto> getGisNyxInsuranceListDtos() {
        return gisNyxInsuranceListDtos;
    }

    public void setGisNyxInsuranceListDtos(List<GisNyxInsuranceListDto> gisNyxInsuranceListDtos) {
        this.gisNyxInsuranceListDtos = gisNyxInsuranceListDtos;
    }

    public List<GisFeildDto> getGisFeildDtos() {
        return gisFeildDtos;
    }

    public void setGisFeildDtos(List<GisFeildDto> gisFeildDtos) {
        this.gisFeildDtos = gisFeildDtos;
    }

    public List<GisHerdFieldDto> getGisHerdFieldDtos() {
        return gisHerdFieldDtos;
    }

    public void setGisHerdFieldDtos(List<GisHerdFieldDto> gisHerdFieldDtos) {
        this.gisHerdFieldDtos = gisHerdFieldDtos;
    }

    public InsureMainListDto getInsureMainListDto() {
        return insureMainListDto;
    }

    public void setInsureMainListDto(InsureMainListDto insureMainListDto) {
        this.insureMainListDto = insureMainListDto;
    }

    public List<PlantingInsuranceListDto> getPlantingInsuranceListDtos() {
        return plantingInsuranceListDtos;
    }

    public void setPlantingInsuranceListDtos(List<PlantingInsuranceListDto> plantingInsuranceListDtos) {
        this.plantingInsuranceListDtos = plantingInsuranceListDtos;
    }

    public List<HerdInsuranceListDto> getHerdInsuranceListDtos() {
        return herdInsuranceListDtos;
    }

    public void setHerdInsuranceListDtos(List<HerdInsuranceListDto> herdInsuranceListDtos) {
        this.herdInsuranceListDtos = herdInsuranceListDtos;
    }

    public List<NyxInsuranceListDto> getNyxInsuranceListDtos() {
        return nyxInsuranceListDtos;
    }

    public void setNyxInsuranceListDtos(List<NyxInsuranceListDto> nyxInsuranceListDtos) {
        this.nyxInsuranceListDtos = nyxInsuranceListDtos;
    }
}
