package com.sinosoft.agriclaim.api.businessutilmanage;

import com.sinosoft.agriclaim.api.AgriClaimConstant;
import com.sinosoft.agriclaim.api.businessutilmanage.dto.PrpLConfigurationDto;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-11-08 05:35:28.283
 * @description 理赔冲减保额表Api接口
 */
@FeignClient(name = AgriClaimConstant.AGRI_CLAIM_SERVICE_NAME, path = PrpLConfigurationApi.PATH)
public interface PrpLConfigurationApi  {

    public static final String PATH = "prpLConfiguration";


    @RequestMapping(value = "queryPrpLConfigurationDtoListByCondition",method = {RequestMethod.POST})
    @ResponseBody
    List<PrpLConfigurationDto> queryPrpLConfigurationDtoListByCondition(@RequestBody PrpLConfigurationDto prpLConfigurationDto)throws Exception;
}
