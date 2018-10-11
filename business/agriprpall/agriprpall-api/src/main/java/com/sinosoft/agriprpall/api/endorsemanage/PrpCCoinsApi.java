package com.sinosoft.agriprpall.api.endorsemanage;

import com.sinosoft.agriprpall.api.AgriPrpallConstant;
import com.sinosoft.framework.dto.ResponseDto;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;


/**
 * @author codegen@研发中心
 * @mail codegen@sinosoft.com.cn
 * @time  2017-10-21 08:59:58.361 
 * @description 共保信息表Api接口
 */
@FeignClient(name = AgriPrpallConstant.AGRI_PRPALL_SERVICE_NAME, path = PrpCCoinsApi.PATH)
public interface PrpCCoinsApi {

    public static final String PATH = "endorse";
    @RequestMapping(value = "findCoinsInfoByCondition",method = RequestMethod.GET)
    public @ResponseBody
    ResponseDto findCoinsInfoByCondition(@RequestParam(value = "policyNo") String policyNo)throws Exception;

}