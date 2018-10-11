package com.sinosoft.agriprpall.api.policymanage;

import com.sinosoft.agriprpall.api.AgriPrpallConstant;
import com.sinosoft.agriprpall.api.policymanage.dto.PolicyOriginDto;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 原始保单大对象
 * @author: 钱浩
 * @date: 2017/11/23 下午 17:26
 */
@FeignClient(name= AgriPrpallConstant.AGRI_PRPALL_SERVICE_NAME,path = PolicyOriginApi.PATH)
public interface PolicyOriginApi {
    public static final String PATH ="policyOrigin";

    /**
     * 原始保单查询
     * @author: 钱浩
     * @date: 2017/11/23 下午 19:55
     * @param policyNo 保单号
     * @return PolicyOriginDto 原始保单对象
     * @throws Exception
     */
    @RequestMapping(value = "findByPolicyOrigin",method = {RequestMethod.POST})
    public @ResponseBody PolicyOriginDto queryByPolicyOrigin(@RequestParam("policyNo") String policyNo)throws Exception;

}
