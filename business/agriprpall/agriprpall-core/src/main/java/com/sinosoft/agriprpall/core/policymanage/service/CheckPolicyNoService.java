package com.sinosoft.agriprpall.core.policymanage.service;

import com.sinosoft.agriprpall.api.policymanage.dto.CheckPolicyNoDto;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.Map;

/**
        * * 检查保单号是否存在
        * @Author: 田慧
        * @Date: 2017/12/1 11:54
  */
public interface CheckPolicyNoService {
    /**
     *  检查保单号是否存在
     * @author: 田慧
     * @date: 2017/12/1 14:26
     * @param checkPolicyNoDto 自己定义的Dto 包括policyNo保单号、riskCode险种代码
     * @return map key是message，值分别为两种情况，一种是保单号系统中已存在，不可使用!请重输!，另一种是
     *         保单号已被投保单占用，不可使用!请重输!
     * @throws Exception
     */
    public Map<String, String> checkPolicyNo( CheckPolicyNoDto checkPolicyNoDto) throws Exception;
}
