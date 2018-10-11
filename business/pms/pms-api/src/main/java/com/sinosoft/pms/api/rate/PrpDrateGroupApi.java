package com.sinosoft.pms.api.rate;

import com.sinosoft.pms.api.PMSConstant;
import com.sinosoft.pms.api.rate.dto.PrpDrateGroupDto;
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
 * @description 费率分组表Api接口
 */
@FeignClient(name = PMSConstant.PMS_SERVICE_NAME, path = PrpDrateGroupApi.PATH)
public interface PrpDrateGroupApi {

    String PATH = "prpDrateGroup";

    /**
     * 条件查询
     *
     * @param prpDrateGroupDto
     * @return
     */
    @RequestMapping(value = "queryList", method = {RequestMethod.POST})
    @ResponseBody
    List<PrpDrateGroupDto> queryList(@RequestBody PrpDrateGroupDto prpDrateGroupDto);
}