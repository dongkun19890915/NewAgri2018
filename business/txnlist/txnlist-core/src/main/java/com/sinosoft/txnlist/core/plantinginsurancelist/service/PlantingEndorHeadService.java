package com.sinosoft.txnlist.core.plantinginsurancelist.service;

import com.sinosoft.txnlist.api.plantinginsurancelist.dto.PlantingEndorHeadDto;

import java.util.List;

public interface PlantingEndorHeadService {

    public void removePlantingEndorHead(String endorseNo)throws Exception;

    public void savePlantingEndorHead(PlantingEndorHeadDto plantingEndorHeadDto)throws Exception;
    /**
     *@description 按主键查询实体
     *@param
     */
    public PlantingEndorHeadDto queryByPK(String endorseNo)throws Exception;
}
