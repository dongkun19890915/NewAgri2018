package com.sinosoft.agriprpall.api.endorsemanage;

import com.sinosoft.agriprpall.api.AgriPrpallConstant;
import com.sinosoft.agriprpall.api.endorsemanage.dto.EndorseFindDto;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@FeignClient(name = AgriPrpallConstant.AGRI_PRPALL_SERVICE_NAME,path = EndorseFindApi.PATH)
public interface EndorseFindApi {

    public static final String PATH="endorseFind";
    @RequestMapping(value = "findPolicyInfoByCondition",method = RequestMethod.GET)
    public @ResponseBody EndorseFindDto findPolicyInfoByCondition(@RequestParam(value = "policyNo") String policyNo)throws Exception;
}
