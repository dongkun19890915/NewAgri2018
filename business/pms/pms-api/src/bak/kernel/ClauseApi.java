package com.sinosoft.pms.api.kernel;

import com.sinosoft.pms.PMSConstant;
import com.sinosoft.pms.api.kernel.dto.ClauseQueryConditionDto;
import com.sinosoft.pms.api.kernel.dto.PrpDClauseDto;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by gaofeng on 2017/7/28.
 */@FeignClient(name = PMSConstant.PMS_SERVICE_NAME, path = ClauseApi.PATH)

public interface ClauseApi {
    public static final String PATH = "clause";

    /**
     * @description 根据条款代码获取条款相关信息
     * @param conditionDto
     * @return PrpDRiskDto
     * @author yinqingzhu
     * @date 2016年10月13日上午9:19:41
     */
    @RequestMapping(value = "/getClause", method = RequestMethod.POST)
    @ResponseBody
    public PrpDClauseDto getClause(ClauseQueryConditionDto conditionDto);
}
