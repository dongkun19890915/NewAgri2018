package com.sinosoft.agriprpall.core.policymanage.service;

import com.sinosoft.agriprpall.api.endorsemanage.dto.BLEndorseDto;
import com.sinosoft.agriprpall.api.endorsemanage.dto.CPpolicyDto;
import com.sinosoft.agriprpall.api.policymanage.dto.ResponseQueryPolicyInfoDto;

/**
 * CP数据更新C表服务
 * @Author: 王保良
 * @Date: 2017/11/4 14:55
 */
public interface EvaluateFromCpToCService {
    /**
     * CP数据更新C表服务
     * @author: 王保良
     * @date: 2017/11/30 14:50
     * @param blPolicyDto 保单大对象
     * @param cPpolicyDto cp表大对象
     * @return void
     * @throws Exception
     */
    public void evaluateFromCpToC(ResponseQueryPolicyInfoDto blPolicyDto, CPpolicyDto cPpolicyDto, BLEndorseDto blEndorseDto)throws Exception;
}
