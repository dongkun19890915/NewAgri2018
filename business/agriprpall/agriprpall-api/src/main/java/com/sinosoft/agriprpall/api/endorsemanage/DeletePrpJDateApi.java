package com.sinosoft.agriprpall.api.endorsemanage;

import com.sinosoft.agriprpall.api.AgriPrpallConstant;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Map;

/**
 * 根据保单号删除
 * @author 王保良
 * @date 2017年11月10日
 */
@FeignClient(name = AgriPrpallConstant.AGRI_PRPALL_SERVICE_NAME,path =DeletePrpJDateApi.PATH )
public interface DeletePrpJDateApi {
    public static final String PATH="endorsemanage";

    @RequestMapping(value = "deletePrpJDate",method = RequestMethod.POST)
    public void deletePrpJDate(@RequestBody Map<String,String> map)throws Exception;
}
