package com.sinosoft.agriprpall.core.policymanage.service;

import com.sinosoft.agriprpall.api.policymanage.dto.PolicyOriginDto;
import com.sinosoft.agriprpall.api.policymanage.dto.PrpCmainOriginDto;

/**
 * 原始保单
 * @author: 钱浩
 * @date:
 */
public interface PolicyOriginService {
    /**
     * 原始保单查询
     * @author: 钱浩
     * @date: 2017/11/23 下午 19:55
     * @param policyNo 保单号
     * @return PolicyOriginDto 原始保单对象
     * @throws Exception
     */
    PolicyOriginDto queryByPolicyOrigin(String policyNo)throws Exception;


    public PrpCmainOriginDto queryByPolicyNo(String policyNo)throws Exception;
}
