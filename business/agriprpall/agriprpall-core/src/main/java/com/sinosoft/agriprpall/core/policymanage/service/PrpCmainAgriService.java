package com.sinosoft.agriprpall.core.policymanage.service;

import com.sinosoft.agriprpall.api.endorsemanage.dto.PrpCPmainAgriDto;
import com.sinosoft.agriprpall.api.endorsemanage.dto.PrpPmainAgriDto;
import com.sinosoft.agriprpall.api.endorsemanage.dto.PrpPmainDto;
import com.sinosoft.agriprpall.api.policymanage.dto.PrpCmainAgriDto;

/**
 * PrpCmainAgri表服务
 * @Author: 王保良
 * @Date: 9:00 2017/11/28
 */
public interface PrpCmainAgriService {
    /**
     * P表记录转为C表记录
     * @author: 王保良
     * @date: 2017/11/18
     * @param prpPmainAgriDto
     * @return PrpCmainAgriDto
     * @throws Exception
     */
    public PrpCmainAgriDto PEvaluateC(PrpPmainAgriDto prpPmainAgriDto) throws Exception;

    /**
     * CP表记录转为C表记录
     * @author: 王保良
     * @date: 2017/11/18
     * @param prpCPmainAgriDto
     * @return PrpCmainAgriDto
     * @throws Exception
     */
    public PrpCmainAgriDto generatePrpCmainAgri(PrpCPmainAgriDto prpCPmainAgriDto)throws Exception;
}
