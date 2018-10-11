package com.sinosoft.agriprpall.core.policymanage.service;

import com.sinosoft.agriprpall.api.endorsemanage.dto.PrpCPfeildDto;
import com.sinosoft.agriprpall.api.endorsemanage.dto.PrpPfeildDto;
import com.sinosoft.agriprpall.api.policymanage.dto.PrpCfeildDto;

/**
 * PrpCfeild表服务接口
 * @Author: 王保良
 * @Date: 9:00 2017/11/28
 */
public interface PrpCfeildService {
    /**
     * P表记录转为C表记录
     * @author: 王保良
     * @date: 2017/11/18
     * @param prpPfeildDto
     * @return PrpCfeildDto
     * @throws Exception
     */
    public PrpCfeildDto PEvaluateC(PrpPfeildDto prpPfeildDto) throws Exception;

    /**
     * CP表记录转为C表记录
     * @author: 王保良
     * @date: 2017/11/18
     * @param prpCPfeildDto,proposalNo
     * @return PrpCfeildDto
     * @throws Exception
     */
    public PrpCfeildDto generatePrpCfeild(PrpCPfeildDto prpCPfeildDto,String proposalNo) throws Exception;
}
