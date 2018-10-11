package com.sinosoft.agriprpall.api.endorsemanage;

import java.util.Map;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sinosoft.agriprpall.api.AgriPrpallConstant;
import com.sinosoft.agriprpall.api.endorsemanage.dto.CheckEndorseConditionDto;
import com.sinosoft.framework.dto.ResponseDto;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@FeignClient(name = AgriPrpallConstant.AGRI_PRPALL_SERVICE_NAME,path=CheckEndoreseNextApi.PATH)
public interface CheckEndoreseNextApi {
    public static final String PATH="checkEndorse";
    /**
    *  允许批改校验
    * @param checkEndorseConditionDto 允许批改校验的条件dto
    * @return String
    * @throws Exception
    * @author 李冬松
    * @date 14:50 2017/12/13
    */
    @RequestMapping(value = "checkNext",method ={RequestMethod.POST} )
    public @ResponseBody Map<String,String> checkNext(@RequestBody CheckEndorseConditionDto checkEndorseConditionDto)throws Exception;

}
