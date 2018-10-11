package com.sinosoft.agriprpall.api.endorsemanage;

import com.sinosoft.agriprpall.api.AgriPrpallConstant;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(name = AgriPrpallConstant.AGRI_PRPALL_SERVICE_NAME,path = GeneratePEndorseApi.PATH)
public interface GeneratePEndorseApi {
    public static final String PATH="saveEndorse";
    //@RequestMapping(value = "generatePEndorse",method = {RequestMethod.POST})

}
