package com.sinosoft.dms.api.dict.dto;

import com.sinosoft.dms.api.model.dto.PrpMmodelMainDto;

import java.util.List;

public class PrpModelMainListDto {
    private List<PrpMmodelMainDto> prpMmodelMainDtoList;

    public List<PrpMmodelMainDto> getPrpMmodelMainDtoList() {
        return prpMmodelMainDtoList;
    }

    public void setPrpMmodelMainDtoList(List<PrpMmodelMainDto> prpMmodelMainDtoList) {
        this.prpMmodelMainDtoList = prpMmodelMainDtoList;
    }
}
