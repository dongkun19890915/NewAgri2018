package com.sinosoft.agriprpall.core.policymanage.service;

import com.sinosoft.agriprpall.api.policymanage.dto.PrpCrenewalDto;

import java.util.List;

public interface PrpCrenewalService {
    public List<PrpCrenewalDto> queryByPolicyNo(String policyNo) throws Exception;
    public List<PrpCrenewalDto> queryByOldPolicyNo(String policyNo, String oldPolicyNo) throws Exception;
}
