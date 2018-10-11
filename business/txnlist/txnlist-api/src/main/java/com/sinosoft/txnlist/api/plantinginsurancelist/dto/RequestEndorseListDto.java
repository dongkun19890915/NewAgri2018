package com.sinosoft.txnlist.api.plantinginsurancelist.dto;

import java.util.ArrayList;
import java.util.List;

/**
*批改清单持久化接口
* @Author: 陈道洋
* @Date: 2017/11/14 14:32
*/
public class RequestEndorseListDto {
    /**农险一期种植险：批改清单主表*/
    private PlantingEndorHeadDto plantingEndorHeadDto;
    /**农险一期种植险：批改清单明细表*/
    private List<PlantingEndorChgDetailDto> plantingEndorChgDetailDtoList;
    /**农险一期种植险：批改清单最新数据表*/
    private List<PlantingCpEndorChgDetailDto> plantingCpEndorChgDetailDtoList;

    /**农险一期养殖险：批改清单主表*/
    private HerdEndorHeadDto herdEndorHeadDto;
    /**农险一期养殖险：批改清单明细表*/
    private List<HerdEndorChgDetailDto> herdEndorChgDetailDtoList;
    /**农险一期养殖险：批改清单最新数据表*/
    private List<HerdcEndorChgDetailDto> herdcEndorChgDetailDtoList;

    /**农险二期农业险：批改清单主表*/
    private NyxEndorHeadDto nyxEndorHeadDto;
    /**农险二期农业险：批改清单明细表*/
    private List<NyxEndorChgDetailDto> nyxEndorChgDetailDtoList;
    /**农险二期农业险：批改清单最新数据表*/
    private List<NyxCpEndorChgDetailDto> nyxCpEndorChgDetailDtoList;

    /** 批单号码(查询农户总数的入参) */
    private String endorseNo;
    /** 农户代码(查询农户总数的入参) */
    private List<String> fCodes;

    public PlantingEndorHeadDto getPlantingEndorHeadDto() {
        return plantingEndorHeadDto;
    }

    public void setPlantingEndorHeadDto(PlantingEndorHeadDto plantingEndorHeadDto) {
        this.plantingEndorHeadDto = plantingEndorHeadDto;
    }

    public List<PlantingEndorChgDetailDto> getPlantingEndorChgDetailDtoList() {
        return plantingEndorChgDetailDtoList;
    }

    public void setPlantingEndorChgDetailDtoList(List<PlantingEndorChgDetailDto> plantingEndorChgDetailDtoList) {
        this.plantingEndorChgDetailDtoList = plantingEndorChgDetailDtoList;
    }

    public List<PlantingCpEndorChgDetailDto> getPlantingCpEndorChgDetailDtoList() {
        return plantingCpEndorChgDetailDtoList;
    }

    public void setPlantingCpEndorChgDetailDtoList(List<PlantingCpEndorChgDetailDto> plantingCpEndorChgDetailDtoList) {
        this.plantingCpEndorChgDetailDtoList = plantingCpEndorChgDetailDtoList;
    }

    public HerdEndorHeadDto getHerdEndorHeadDto() {
        return herdEndorHeadDto;
    }

    public void setHerdEndorHeadDto(HerdEndorHeadDto herdEndorHeadDto) {
        this.herdEndorHeadDto = herdEndorHeadDto;
    }

    public List<HerdEndorChgDetailDto> getHerdEndorChgDetailDtoList() {
        return herdEndorChgDetailDtoList;
    }

    public void setHerdEndorChgDetailDtoList(List<HerdEndorChgDetailDto> herdEndorChgDetailDtoList) {
        this.herdEndorChgDetailDtoList = herdEndorChgDetailDtoList;
    }

    public List<HerdcEndorChgDetailDto> getHerdcEndorChgDetailDtoList() {
        return herdcEndorChgDetailDtoList;
    }

    public void setHerdcEndorChgDetailDtoList(List<HerdcEndorChgDetailDto> herdcEndorChgDetailDtoList) {
        this.herdcEndorChgDetailDtoList = herdcEndorChgDetailDtoList;
    }

    public NyxEndorHeadDto getNyxEndorHeadDto() {
        return nyxEndorHeadDto;
    }

    public void setNyxEndorHeadDto(NyxEndorHeadDto nyxEndorHeadDto) {
        this.nyxEndorHeadDto = nyxEndorHeadDto;
    }

    public List<NyxEndorChgDetailDto> getNyxEndorChgDetailDtoList() {
        return nyxEndorChgDetailDtoList;
    }

    public void setNyxEndorChgDetailDtoList(List<NyxEndorChgDetailDto> nyxEndorChgDetailDtoList) {
        this.nyxEndorChgDetailDtoList = nyxEndorChgDetailDtoList;
    }

    public List<NyxCpEndorChgDetailDto> getNyxCpEndorChgDetailDtoList() {
        return nyxCpEndorChgDetailDtoList;
    }

    public void setNyxCpEndorChgDetailDtoList(List<NyxCpEndorChgDetailDto> nyxCpEndorChgDetailDtoList) {
        this.nyxCpEndorChgDetailDtoList = nyxCpEndorChgDetailDtoList;
    }

    public String getEndorseNo() {
        return endorseNo;
    }

    public void setEndorseNo(String endorseNo) {
        this.endorseNo = endorseNo;
    }

    public List<String> getfCodes() {
        return fCodes;
    }

    public void setfCodes(List<String> fCodes) {
        this.fCodes = fCodes;
    }
}
