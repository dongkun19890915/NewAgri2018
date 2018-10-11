package com.sinosoft.dms.api.dict;

import com.sinosoft.dms.api.DMSConstant;
import com.sinosoft.dms.api.dict.dto.FrontEndDto;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author qh
 * @description （prpdnewcode的码表的接口服务）
 * @date 2017年8月29日
 */
@FeignClient(name = DMSConstant.DMS_SERVICE_NAME, path = FrontEndApi.PATH)
public interface FrontEndApi {

    public static final String PATH = "frontEnd";


    @RequestMapping(value = "queryFrontEnd", method = {RequestMethod.POST})
    public @ResponseBody
    FrontEndDto queryFrontEnd() throws Exception;


}