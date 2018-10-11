package com.sinosoft.txnlist.core.plantinginsurancelist.service;

import com.sinosoft.txnlist.api.plantinginsurancelist.dto.PlantingCpEndorChgDetailDto;
import com.sinosoft.txnlist.core.plantinginsurancelist.entity.PlantingCpEndorChgDetail;

import java.util.List;

public interface PlantingCpEndorChgDetailService {

    public void removePlantingCpEndorChgDetail(String inusreListCode)throws  Exception;

    public void savePlantingCpEndorChgDetail(List<PlantingCpEndorChgDetailDto> plantingCpEndorChgDetailDtoList)throws  Exception;
    public List<PlantingCpEndorChgDetailDto> query(String inusreListCode)throws Exception;
    public List<PlantingCpEndorChgDetailDto> queryByInsureListCode(String insureListCode)throws Exception;
}
