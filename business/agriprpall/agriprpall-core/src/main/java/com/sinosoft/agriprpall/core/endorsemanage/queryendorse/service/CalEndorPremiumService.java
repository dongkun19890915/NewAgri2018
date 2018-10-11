package com.sinosoft.agriprpall.core.endorsemanage.queryendorse.service;

import com.sinosoft.agriprpall.api.endorsemanage.dto.BLEndorseDto;
import com.sinosoft.agriprpall.api.endorsemanage.dto.PolicyEndorseDto;
import com.sinosoft.agriprpall.api.policymanage.dto.PrpCfeeDto;
import com.sinosoft.agriprpall.api.policymanage.dto.PrpCitemKindDto;
import com.sinosoft.agriprpall.api.policymanage.dto.ResponseQueryPolicyInfoDto;

import java.util.Date;
import java.util.List;

public interface CalEndorPremiumService {
    public void CalEndor93PremByNext(PolicyEndorseDto policyEndorseDto,Date validDate) throws Exception;
    public PolicyEndorseDto calPrpCfee(PolicyEndorseDto policyEndorseDto)throws Exception;
}
