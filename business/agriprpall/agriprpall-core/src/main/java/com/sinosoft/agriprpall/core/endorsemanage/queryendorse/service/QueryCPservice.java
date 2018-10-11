package com.sinosoft.agriprpall.core.endorsemanage.queryendorse.service;

import com.sinosoft.agriprpall.api.endorsemanage.dto.CPpolicyDto;

/**
 * @description 根据保单号查询CP表
 * @throws Exception
 * @author 王保良
 * @date 2017年10月27日
 */
public interface QueryCPservice {
    /**
     * @description 根据保单号查询Cp表的大对象
     * @param  policyNo
     * @return BlEndorseDto(保单大对象)
     * @throws Exception
     * @author 王保良
     * @date 2017年10月27日
     */
    public CPpolicyDto queryCPolicyInfo(String policyNo) throws Exception;
}
