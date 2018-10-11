package com.sinosoft.agriprpall.core.endorsemanage.specialendorse.service;

import com.sinosoft.agriprpall.api.endorsemanage.dto.BLEndorseDto;
import com.sinosoft.agriprpall.api.endorsemanage.dto.EndorseConditionDto;
import com.sinosoft.agriprpall.api.policymanage.dto.PrpCitemKindDto;
import com.sinosoft.agriprpall.api.policymanage.dto.PrpCsubsidyDto;

import java.util.List;

public interface SpecialNyxCoinsService {
    public void dealNyxCoins(BLEndorseDto blEndorseDto, EndorseConditionDto endorseConditionDto,
                             List<PrpCsubsidyDto> prpCsubsidyDtos, List<PrpCitemKindDto> prpCitemKindDtos)throws Exception;
}
