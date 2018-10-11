package com.sinosoft.agriprpall.core.endorsemanage.commonendorse.service;

import com.sinosoft.agriprpall.api.endorsemanage.dto.PolicyEndorseDto;
/**
 * 普通批改main表处理service接口类
 * @Author: 李冬松
 * @Date: 9:00 2017/11/17
 */
public interface GeneratePrpMainService {
    /**
     * 普通批改Cmain表处理
     * @param policyEndorseDto 保单批单大对象
     * @return void
     * @throws Exception
     * @author 李冬松
     * @date 10:27 2017/12/7
     */
    public void updatePrpCmainNew(PolicyEndorseDto policyEndorseDto) throws Exception;
    /**
     * 普通批改Pmain表处理
     * @param policyEndorseDto 保单批单大对象
     * @return void
     * @throws Exception
     * @author 李冬松
     * @date 10:27 2017/12/7
     */
    public void updatePrpPmainDto(PolicyEndorseDto policyEndorseDto)throws Exception;
}
