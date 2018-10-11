package com.sinosoft.agriprpall.api.endorsemanage;

import com.sinosoft.agriprpall.api.AgriPrpallConstant;
import com.sinosoft.agriprpall.api.endorsemanage.dto.PolicyEndorseDto;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = AgriPrpallConstant.AGRI_PRPALL_SERVICE_NAME,path = GeneratePrpMainApi.PATH)
public interface GeneratePrpMainApi {
    public static final String PATH="generatePrpMain";
    @RequestMapping(value = "dealPrpMain",method = {RequestMethod.POST})
    public void dealPrpMain(@RequestParam PolicyEndorseDto policyEndorseDto)throws Exception;
    @RequestMapping(value = "updatePrpPmainDto",method = {RequestMethod.POST})
    public void updatePrpPmainDto(@RequestParam PolicyEndorseDto policyEndorseDto)throws Exception;
}
