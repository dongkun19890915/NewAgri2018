package com.sinosoft.agriprpall.core.policymanage.service;

import com.sinosoft.agriprpall.api.endorsemanage.dto.PrpCPplanCoinsDto;
import com.sinosoft.agriprpall.api.endorsemanage.dto.PrpPplanCoinsDto;
import com.sinosoft.agriprpall.api.policymanage.dto.PrpCplanCoinsDto;

/**
 * PrpCplanCoins表服务
 * @Author: 王保良
 * @Date: 9:00 2017/11/28
 */
public interface PrpCplanCoinsService {
    /**
     * P表记录转为C表记录
     * @author: 王保良
     * @date: 2017/11/18
     * @param prpPplanCoinsDto
     * @return PrpCplanCoinsDto
     * @throws Exception
     */
    public PrpCplanCoinsDto PEvaluateC(PrpPplanCoinsDto prpPplanCoinsDto) throws Exception;

    /**
     * CP表记录转为C表记录
     * @author: 王保良
     * @date: 2017/11/18
     * @param prpCPplanCoinsDto
     * @return PrpCplanCoinsDto
     * @throws Exception
     */
    public PrpCplanCoinsDto generatePrpCplanCoins(PrpCPplanCoinsDto prpCPplanCoinsDto) throws Exception;
}
