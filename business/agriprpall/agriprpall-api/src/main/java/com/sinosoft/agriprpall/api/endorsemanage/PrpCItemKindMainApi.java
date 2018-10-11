package com.sinosoft.agriprpall.api.endorsemanage;

import com.sinosoft.agriprpall.api.AgriPrpallConstant;
import com.sinosoft.framework.dto.ResponseDto;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@FeignClient(name = AgriPrpallConstant.AGRI_PRPALL_SERVICE_NAME,path = PrpCItemKindMainApi.PATH)
public interface PrpCItemKindMainApi {
    public static final String PATH="endorse";
    @RequestMapping(value = "findMainInfoByCondition",method = RequestMethod.GET)
    public @ResponseBody
    ResponseDto findMainInfoByCondition(@RequestParam(value = "policyNo") String policyNo)throws Exception;
}
