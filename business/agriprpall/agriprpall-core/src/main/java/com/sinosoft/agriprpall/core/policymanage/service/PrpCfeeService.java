package com.sinosoft.agriprpall.core.policymanage.service;

import com.sinosoft.agriprpall.api.endorsemanage.dto.PrpCPfeeDto;
import com.sinosoft.agriprpall.api.endorsemanage.dto.PrpPfeeDto;
import com.sinosoft.agriprpall.api.policymanage.dto.PrpCfeeDto;

/**
 * PrpCfee表服务接口
 * @Author: 王保良
 * @Date: 9:00 2017/11/28
 */
public interface PrpCfeeService {
    /**
     * P表记录转为C表记录
     * @author: 王保良
     * @date: 2017/11/18
     * @param prpPfeeDto
     * @return PrpCfeeDto
     * @throws Exception
     */
    public PrpCfeeDto PEvaluateC(PrpPfeeDto prpPfeeDto) throws Exception;

    /**
     * CP表记录转为C表记录
     * @author: 王保良
     * @date: 2017/11/18
     * @param prpCPfeeDto
     * @return PrpCfeeDto
     * @throws Exception
     */
    public PrpCfeeDto generatePrpCfee(PrpCPfeeDto prpCPfeeDto) throws Exception;
}
