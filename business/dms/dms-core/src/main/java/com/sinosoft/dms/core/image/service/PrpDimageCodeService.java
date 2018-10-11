package com.sinosoft.dms.core.image.service;

import com.sinosoft.dms.api.image.dto.PrpDimageCodeDto;

public interface PrpDimageCodeService {

    PrpDimageCodeDto queryByPK(String riskCode, String comCode);
}
