package com.sinosoft.agriprpall.api.common;


import com.sinosoft.agriprpall.api.AgriPrpallConstant;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.*;

/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-10-16 04:00:52.059 
 * @description 平台交互Api接口
 */
@FeignClient(name = AgriPrpallConstant.AGRI_PRPALL_SERVICE_NAME, path = GetRuleInUtiPlatConfigRuleApi.PATH)
public interface GetRuleInUtiPlatConfigRuleApi {

    public static final String PATH = "getruleinutiplatconfigrule";

    @RequestMapping(value = "queryfindOne",method = {RequestMethod.POST})
    public String queryfindOne(@RequestParam("systemCode") String systemCode,@RequestParam("paramCode") String paramCode,@RequestParam("serialNo") String serialNo)throws  Exception;
    @RequestMapping(value = "getProperty",method = {RequestMethod.POST})
    public String getProperty(@RequestParam("paramCode") String paramCode) throws Exception;
}