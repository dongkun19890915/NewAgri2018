package com.sinosoft.agriprpall.api.endorsemanage;

import com.sinosoft.agriprpall.api.AgriPrpallConstant;
import com.sinosoft.agriprpall.api.endorsemanage.dto.PolicyEndorseDto;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * 普通批改数据保存接口类
 * @Author: 李冬松
 * @Date: 9:00 2017/11/17
 */
@FeignClient(name = AgriPrpallConstant.AGRI_PRPALL_SERVICE_NAME,path = GenerateBLEndorseApi.PATH)
public interface GenerateBLEndorseApi {
    public static final String PATH="commonEndorse";
    /**
    * 普通批改数据更新
    * @param policyEndorseDto 保单批单大对象
    * @return void
    * @throws Exception
    * @author 李冬松
    * @date 10:27 2017/12/7
    */
    @RequestMapping(value = "dealEndorseInfo",method = {RequestMethod.POST})
    public @ResponseBody PolicyEndorseDto dealEndorseInfo(@RequestBody PolicyEndorseDto policyEndorseDto)throws Exception;

    /**
     * 普通批改数据保存
     * @param policyEndorseDto 保单批单大对象
     * @return void
     * @throws Exception
     * @author 李冬松
     * @date 10:27 2017/12/7
     */
    @RequestMapping(value = "saveEndorseInfo",method = {RequestMethod.POST})
    public @ResponseBody Map<String, String> saveEndorseInfo(@RequestBody PolicyEndorseDto policyEndorseDto)throws Exception;


    /**
     * 普通批改数据保存
     * @param policyEndorseDtoList 保单批单大对象集合
     * @return void
     * @throws Exception
     * @author 王心洋
     * @date 2017/12/19
     */
    @RequestMapping(value = "saveEndorseList",method = {RequestMethod.POST})
    public @ResponseBody Map<String, Object> saveEndorseList(@RequestBody List<PolicyEndorseDto> policyEndorseDtoList)throws Exception;

}
