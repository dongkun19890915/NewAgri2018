package com.sinosoft.agriprpall.core.policymanage.service;


import com.sinosoft.agriprpall.api.policymanage.dto.PrpCitemKindDto;

import java.util.List;

public interface PrpCItemKindSubService {
    public List<PrpCitemKindDto> findPrpCItemKindSubInfo(String policyNo)throws Exception;
}
