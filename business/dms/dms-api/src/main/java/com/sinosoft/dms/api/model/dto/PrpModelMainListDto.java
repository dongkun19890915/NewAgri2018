package com.sinosoft.dms.api.model.dto;

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
