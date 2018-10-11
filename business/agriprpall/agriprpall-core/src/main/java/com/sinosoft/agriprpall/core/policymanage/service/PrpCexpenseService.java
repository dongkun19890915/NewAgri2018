package com.sinosoft.agriprpall.core.policymanage.service;

import com.sinosoft.agriprpall.api.endorsemanage.dto.PrpCPexpenseDto;
import com.sinosoft.agriprpall.api.endorsemanage.dto.PrpPexpenseDto;
import com.sinosoft.agriprpall.api.policymanage.dto.PrpCexpenseDto;

/**
 * PrpCexpense表服务接口
 * @Author: 王保良
 * @Date: 9:00 2017/11/28
 */
public interface PrpCexpenseService {
    /**
     * P表记录转为C表记录
     * @author: 王保良
     * @date: 2017/11/18
     * @param prpPexpenseDto
     * @return PrpCexpenseDto
     * @throws Exception
     */
    public PrpCexpenseDto PEvaluateC(PrpPexpenseDto prpPexpenseDto)throws Exception;

    /**
     * CP表记录转为C表记录
     * @author: 王保良
     * @date: 2017/11/18
     * @param prpCPexpenseDto
     * @return PrpCexpenseDto
     * @throws Exception
     */
    public PrpCexpenseDto generatePrpCexpense(PrpCPexpenseDto prpCPexpenseDto)throws Exception;
}
