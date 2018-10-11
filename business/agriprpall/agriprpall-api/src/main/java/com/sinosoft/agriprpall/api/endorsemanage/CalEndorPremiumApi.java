package com.sinosoft.agriprpall.api.endorsemanage;

import com.sinosoft.agriprpall.api.AgriPrpallConstant;
import com.sinosoft.agriprpall.api.endorsemanage.dto.PolicyEndorseDto;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

@FeignClient(name = AgriPrpallConstant.AGRI_PRPALL_SERVICE_NAME,path= CalEndorPremiumApi.PATH)
public interface CalEndorPremiumApi {
    public static final String PATH="calEndorPremium";
    @RequestMapping(value = "calFee",method ={RequestMethod.POST} )
    public @ResponseBody
    PolicyEndorseDto calFee(@RequestBody PolicyEndorseDto policyEndorseDto)throws Exception;
}
