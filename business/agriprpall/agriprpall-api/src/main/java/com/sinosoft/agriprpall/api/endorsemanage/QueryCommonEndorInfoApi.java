package com.sinosoft.agriprpall.api.endorsemanage;

import com.sinosoft.agriprpall.api.AgriPrpallConstant;
import com.sinosoft.agriprpall.api.endorsemanage.dto.PolicyEndorseDto;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

@FeignClient(name = AgriPrpallConstant.AGRI_PRPALL_SERVICE_NAME,path = QueryCommonEndorInfoApi.PATH )
public interface QueryCommonEndorInfoApi {
    public static final String PATH="endorse";
    /**
     *  普通批改保费计算
     * @param map 保单号
     * @return com.sinosoft.agriprpall.api.endorsemanage.dto.PolicyEndorseDto 批单保单大对象
     * @throws Exception
     * @author 李冬松
     * @date 16:39 2017/12/22
     */
    @RequestMapping(value = "queryCommonEndorInfo",method = {RequestMethod.POST})
    public @ResponseBody
    PolicyEndorseDto queryCommonEndorInfo(@RequestBody Map<String ,String > map)throws Exception;
}
