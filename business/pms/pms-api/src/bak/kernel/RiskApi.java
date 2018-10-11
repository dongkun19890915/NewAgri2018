package com.sinosoft.pms.api.kernel;

import com.sinosoft.framework.dto.ResponseDto;
import com.sinosoft.pms.PMSConstant;
import com.sinosoft.pms.api.kernel.dto.PrpDRiskDto;
import com.sinosoft.pms.api.kernel.dto.RiskQueryConditionDto;
import com.sinosoft.pms.api.salerate.SaleRateApi;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@FeignClient(name = PMSConstant.PMS_SERVICE_NAME, path = RiskApi.PATH)
public interface RiskApi {
    public static final String PATH = "risk";

    @RequestMapping(value = "/getRiskList", method = RequestMethod.POST)
    @ResponseBody
    public ResponseDto getRiskList(@RequestBody RiskQueryConditionDto riskQueryConditionDto) throws Exception;

    /**
     * @description 根据险种代码获取险种相关信息
     * @param conditionDto
     * @return PrpDRiskDto
     * @author yinqingzhu
     * @date 2016年10月13日上午9:19:41
     */
    @RequestMapping(value = "/getRisk", method = RequestMethod.POST)
    @ResponseBody
    public PrpDRiskDto getRisk(RiskQueryConditionDto conditionDto);
}
