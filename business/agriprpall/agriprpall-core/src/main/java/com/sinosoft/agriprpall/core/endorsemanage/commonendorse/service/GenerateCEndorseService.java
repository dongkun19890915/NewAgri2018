package com.sinosoft.agriprpall.core.endorsemanage.commonendorse.service;

import com.sinosoft.agriprpall.api.endorsemanage.dto.BLEndorseDto;
import com.sinosoft.agriprpall.api.policymanage.dto.ResponseQueryPolicyInfoDto;

public interface GenerateCEndorseService {
    /**
     * @description: 生成批单的缴费计划(不涉及政府补贴)
     * @description：该方法目前只在BLEndorse.webAfterCal中调用，原传参为prpPfeeSchema、strValidDate，
     * @description：因为币别调整，缴费计划中只能有一种币别（支付保费币别），一次批改目前只产生一条数据。
     * @author: 李东东
     * @date: 2017/11/1 16:49
     * @param blPolicyDtoNew
     * @param blEndorseDto
     * @throws Exception
     */
    public void append(ResponseQueryPolicyInfoDto blPolicyDtoNew, BLEndorseDto blEndorseDto) throws Exception;
    /**
     * @description: 生成批单的缴费计划(不涉及政府补贴)
     * @description：该方法目前只在BLEndorse.webAfterCal中调用，原传参为prpPfeeSchema、strValidDate，
     * @description：因为币别调整，缴费计划中只能有一种币别（支付保费币别），一次批改目前只产生一条数据。
     * @author: 李东东
     * @date: 2017/11/1 16:49
     * @param blPolicyDtoNew
     * @param blEndorseDto
     * @throws Exception
     */
    public void appendAgriPlan(ResponseQueryPolicyInfoDto blPolicyDtoOld, ResponseQueryPolicyInfoDto blPolicyDtoNew, BLEndorseDto blEndorseDto) throws Exception;
}
