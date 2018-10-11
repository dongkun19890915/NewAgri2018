package com.sinosoft.agriprpall.api.endorsemanage;

import com.sinosoft.agriprpall.api.AgriPrpallConstant;
import com.sinosoft.agriprpall.api.endorsemanage.dto.PolicyEndorseDto;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(name = AgriPrpallConstant.AGRI_PRPALL_SERVICE_NAME,path = GeneratePrpItemKindApi.PATH)
public interface GeneratePrpItemKindApi {
    public static final String PATH="generatePrpItemKind";
    @RequestMapping(value = "dealPrpItemKind",method = {RequestMethod.POST})
    public void dealPrpItemKind(@RequestBody PolicyEndorseDto policyEndorseDto)throws Exception;
}
