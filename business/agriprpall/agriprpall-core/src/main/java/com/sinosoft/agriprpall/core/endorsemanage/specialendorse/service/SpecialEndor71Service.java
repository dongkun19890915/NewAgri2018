package com.sinosoft.agriprpall.core.endorsemanage.specialendorse.service;

import com.sinosoft.agriprpall.api.endorsemanage.dto.EndorsePolicyDto;
import com.sinosoft.agriprpall.api.endorsemanage.dto.PolicyEndorseDto;
import com.sinosoft.agriprpall.api.policymanage.dto.PrpCsubsidyDto;

import java.util.List;

public interface SpecialEndor71Service {
    public PolicyEndorseDto specialEndorse71(PolicyEndorseDto policyEndorseDto, List<PrpCsubsidyDto> prpCsubsidyDtos) throws Exception;
}
