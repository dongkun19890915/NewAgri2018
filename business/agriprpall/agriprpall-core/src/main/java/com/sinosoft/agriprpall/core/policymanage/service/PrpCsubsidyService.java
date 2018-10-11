package com.sinosoft.agriprpall.core.policymanage.service;

import com.sinosoft.agriprpall.api.endorsemanage.dto.PrpCPsubsidyDto;
import com.sinosoft.agriprpall.api.endorsemanage.dto.PrpPsubsidyDto;
import com.sinosoft.agriprpall.api.policymanage.dto.PrpCsubsidyDto;

/**
 * PrpCsubsidy表服务
 * @Author: 王保良
 * @Date: 9:00 2017/11/28
 */
public interface PrpCsubsidyService {
    /**
     * P表记录转为C表记录
     * @author: 王保良
     * @date: 2017/11/18
     * @param prpPsubsidyDto
     * @return PrpCsubsidyDto
     * @throws Exception
     */
    public PrpCsubsidyDto PEvaluateC(PrpPsubsidyDto prpPsubsidyDto) throws Exception;

    /**
     * CP表记录转为C表记录
     * @author: 王保良
     * @date: 2017/11/18
     * @param prpCPsubsidyDto
     * @return PrpCsubsidyDto
     * @throws Exception
     */
    public PrpCsubsidyDto generatePrpCsubsidy(PrpCPsubsidyDto prpCPsubsidyDto)throws Exception;
}
