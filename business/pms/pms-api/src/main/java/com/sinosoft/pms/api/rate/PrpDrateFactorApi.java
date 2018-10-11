package com.sinosoft.pms.api.rate;

import com.sinosoft.pms.api.PMSConstant;
import com.sinosoft.pms.api.rate.dto.PrpDrateFactorDto;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time 2017-08-17 01:44:36.465
 * @description 费率因子表Api接口
 */
@FeignClient(name = PMSConstant.PMS_SERVICE_NAME, path = PrpDrateFactorApi.PATH)
public interface PrpDrateFactorApi {

    String PATH = "prpDrateFactor";

    /**
     * 条件查询
     *
     * @param rateFactorCondition
     * @return
     */
    @RequestMapping(value = "queryList", method = {RequestMethod.POST})
    @ResponseBody
    List<PrpDrateFactorDto> queryList(@RequestBody PrpDrateFactorDto rateFactorCondition);
}