package com.sinosoft.dms.api.model;

import com.sinosoft.dms.api.DMSConstant;
import com.sinosoft.dms.api.model.dto.PrpModelFeeSubDto;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Map;

@FeignClient(name = DMSConstant.DMS_SERVICE_NAME,path = PrpModelFeeSubApi.PATH)
public interface PrpModelFeeSubApi {
    public static final String PATH="prpmodelfeesub";


    /**
     *@description 新增
     *@param
     */
    @RequestMapping(value = "save",method = {RequestMethod.POST})
    void save(@RequestBody PrpModelFeeSubDto prpModelFeeSubDto)throws Exception;

    /**
     *@description 删除
     *@param
     */
    @RequestMapping(value = "remove",method = {RequestMethod.POST})
    void remove(@RequestBody Map<String,String> map)throws Exception;
    /**
     *@description 修改
     *@param
     */
    @RequestMapping(value = "modify",method = {RequestMethod.POST})
    void modify(@RequestBody PrpModelFeeSubDto prpModelFeeSubDto)throws Exception;
    /**
     *@description 按主键查询实体
     *@param
     */
    @RequestMapping(value = "queryByPK",method = {RequestMethod.POST})
    PrpModelFeeSubDto queryByPK(@RequestBody Map<String,String> map)throws Exception;
}
