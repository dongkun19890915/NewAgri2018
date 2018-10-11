package com.sinosoft.agriprpall.web.policymanage;

import com.sinosoft.agriprpall.api.policymanage.PolicyOriginApi;
import com.sinosoft.agriprpall.api.policymanage.dto.PolicyOriginDto;
import com.sinosoft.agriprpall.core.policymanage.service.PolicyOriginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * 原始保单大对象
 * @author: 钱浩
 * @date: 2017/11/23 下午 17:26
 */
@RestController
@RequestMapping(value = PolicyOriginController.PATH)
public class PolicyOriginController implements PolicyOriginApi {
    @Autowired
    private PolicyOriginService policyOriginService;

    /**
     * 原始保单查询
     * @author: 钱浩
     * @date: 2017/11/23 下午 19:55
     * @param policyNo 保单号
     * @return PolicyOriginDto 原始保单对象
     * @throws Exception
     */
    @Override
    public @ResponseBody PolicyOriginDto queryByPolicyOrigin(@RequestParam("policyNo") String policyNo) throws Exception {
        return policyOriginService.queryByPolicyOrigin(policyNo);
    }
}
