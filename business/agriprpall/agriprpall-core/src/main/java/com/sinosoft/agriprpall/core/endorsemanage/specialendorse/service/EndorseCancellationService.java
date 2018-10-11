package com.sinosoft.agriprpall.core.endorsemanage.specialendorse.service;

import com.sinosoft.agriprpall.api.endorsemanage.dto.BLEndorseDto;

public interface EndorseCancellationService {

    public void cancellation(BLEndorseDto blEndorse, String endorseNo) throws Exception;
}
