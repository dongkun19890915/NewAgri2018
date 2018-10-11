package com.sinosoft.dms.api.model;

import com.sinosoft.dms.api.DMSConstant;
import com.sinosoft.dms.api.model.dto.PrpModelPlanSubDto;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Map;

@FeignClient(name = DMSConstant.DMS_SERVICE_NAME,path = PrpModelPlanSubApi.PATH)
public interface PrpModelPlanSubApi {
    public static final String PATH="prpmodelplansub";

    /**
     *@description 新增
     *@param
     */
    @RequestMapping(value = "save",method = {RequestMethod.POST})
    void save(@RequestBody PrpModelPlanSubDto prpModelPlanSubDto);

    /**
     *@description 删除
     *@param
     */
    @RequestMapping(value = "remove",method = {RequestMethod.POST})
    void remove(@RequestBody Map<String,Object> map);
    /**
     *@description 修改
     *@param
     */
    @RequestMapping(value = "modify",method = {RequestMethod.POST})
    void modify(@RequestBody PrpModelPlanSubDto prpModelPlanSubDto);
    /**
     *@description 按主键查询实体
     *@param
     */
    @RequestMapping(value = "queryByPK",method = {RequestMethod.POST})
    PrpModelPlanSubDto queryByPK(@RequestBody Map<String,Object> map);
}
