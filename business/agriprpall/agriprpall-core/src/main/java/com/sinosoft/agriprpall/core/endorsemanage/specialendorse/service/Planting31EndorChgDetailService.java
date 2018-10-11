package com.sinosoft.agriprpall.core.endorsemanage.specialendorse.service;

import com.sinosoft.txnlist.api.plantinginsurancelist.dto.Planting31EndorChgDetailDto;
import com.sinosoft.txnlist.api.plantinginsurancelist.dto.Planting31PolicyListDto;

public interface Planting31EndorChgDetailService {
    public void setPlanting31EndorChgDetail(Planting31EndorChgDetailDto planting31EndorChgDetailSchema, Planting31PolicyListDto planting31PolicyListOldSchema, Planting31PolicyListDto planting31PolicyListNewSchema) throws Exception;
}
