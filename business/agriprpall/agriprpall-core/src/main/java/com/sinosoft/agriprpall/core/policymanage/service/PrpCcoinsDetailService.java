package com.sinosoft.agriprpall.core.policymanage.service;

import com.sinosoft.agriprpall.api.endorsemanage.dto.PrpCPcoinsDetailDto;
import com.sinosoft.agriprpall.api.policymanage.dto.PrpCcoinsDetailDto;

/**
 * PrpCcoinsDetail共保细节表
 * @Author: 王保良
 * @Date: 9:00 2017/11/28
 */
public interface PrpCcoinsDetailService {
    /**
     * CP表记录转为C表记录
     * @author: 王保良
     * @date: 2017/11/18
     * @param prpCPcoinsDetailDto
     * @return PrpCcoinsDetailDto
     * @throws Exception
     */
    public PrpCcoinsDetailDto generatePrpCcoinsDetail(PrpCPcoinsDetailDto prpCPcoinsDetailDto) throws Exception;
}
