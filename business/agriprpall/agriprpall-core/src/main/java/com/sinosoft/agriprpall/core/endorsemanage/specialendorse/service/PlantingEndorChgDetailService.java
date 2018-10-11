package com.sinosoft.agriprpall.core.endorsemanage.specialendorse.service;

import com.sinosoft.txnlist.api.plantinginsurancelist.dto.PlantingEndorChgDetailDto;
import com.sinosoft.txnlist.api.plantinginsurancelist.dto.PlantingPolicyListDto;

public interface PlantingEndorChgDetailService {
    public void setPlantingEndorChgDetail(PlantingEndorChgDetailDto plantingEndorChgDetail, PlantingPolicyListDto plantingPolicyListOldSchema, PlantingPolicyListDto plantingPolicyListNewSchema) throws Exception;
}
