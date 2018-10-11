package com.sinosoft.agriprpall.api.policymanage;

import com.sinosoft.agriprpall.api.AgriPrpallConstant;
import com.sinosoft.agriprpall.api.policymanage.dto.CheckPolicyNoDto;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Map;

/**
 * * 检查保单号是否存在
 * @Author: 田慧
 * @Date: 2017/12/1 11:54
 */
@FeignClient(name = AgriPrpallConstant.AGRI_PRPALL_SERVICE_NAME, path = CheckPolicyNoApi.PATH)
public interface CheckPolicyNoApi {
    public static final String PATH = "checkPolicyNo";
    /**
     *  检查保单号是否存在
     * @author: 田慧
     * @date: 2017/12/1 14:26
     * @param checkPolicyNoDto 自己定义的Dto 包括policyNo保单号、riskCode险种代码
     * @return  map key是message，值分别为两种情况，一种是保单号系统中已存在，不可使用!请重输!，另一种是
     *         保单号已被投保单占用，不可使用!请重输!
     * @throws Exception
     */
    @RequestMapping(value = "checkPolicyNo",method = {RequestMethod.POST})
    public Map<String, String> checkPolicyNo(@RequestBody CheckPolicyNoDto checkPolicyNoDto) throws Exception;
}
