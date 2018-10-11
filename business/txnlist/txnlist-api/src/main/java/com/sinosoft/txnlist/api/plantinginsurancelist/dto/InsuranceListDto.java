package com.sinosoft.txnlist.api.plantinginsurancelist.dto;

import com.sinosoft.txnlist.api.gisinsurelist.dto.GisInsureMainListDto;

import java.util.List;

/**
 * @author 汪强
 * @mail admin@sinosoft.com.cn
 * @time 2017-10-23 12:58:53.230
 * @description basicInfosApi接口
 */
public class InsuranceListDto {
    //金禾清单主信息
    private GisInsureMainListDto gisInsureMainListDto;
    //金禾农户信息
    private List<GisNyxInsuranceListDto> gisNyxInsuranceListDto;
    //金禾田块信息
    private List<GisFeildDto> gisFeildDtoList;
    //金禾养殖险耳标号表
    private List<GisHerdFieldDto> gisHerdFieldDtoList;

    public GisInsureMainListDto getGisInsureMainListDto() {
        return gisInsureMainListDto;
    }

    public void setGisInsureMainListDto(GisInsureMainListDto gisInsureMainListDto) {
        this.gisInsureMainListDto = gisInsureMainListDto;
    }

    public List<GisNyxInsuranceListDto> getGisNyxInsuranceListDto() {
        return gisNyxInsuranceListDto;
    }

    public void setGisNyxInsuranceListDto(List<GisNyxInsuranceListDto> gisNyxInsuranceListDto) {
        this.gisNyxInsuranceListDto = gisNyxInsuranceListDto;
    }

    public List<GisFeildDto> getGisFeildDtoList() {
        return gisFeildDtoList;
    }

    public void setGisFeildDtoList(List<GisFeildDto> gisFeildDtoList) {
        this.gisFeildDtoList = gisFeildDtoList;
    }

    public List<GisHerdFieldDto> getGisHerdFieldDtoList() {
        return gisHerdFieldDtoList;
    }

    public void setGisHerdFieldDtoList(List<GisHerdFieldDto> gisHerdFieldDtoList) {
        this.gisHerdFieldDtoList = gisHerdFieldDtoList;
    }
}
