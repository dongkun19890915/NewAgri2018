package com.sinosoft.dms.api.model;

import com.sinosoft.dms.api.DMSConstant;
import com.sinosoft.dms.api.model.dto.PrpModelAddressSubDto;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Map;

/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-11-13 11:42:08.278 
 * @description 模板保险地址表Api接口
 */
@FeignClient(name = DMSConstant.DMS_SERVICE_NAME, path = PrpModelAddressSubApi.PATH)
public interface PrpModelAddressSubApi {

    public static final String PATH = "prpModelAddressSub";

    /**
     *@description 新增
     *@param
     */
    @RequestMapping(value = "save",method = {RequestMethod.POST})
    void save(@RequestBody PrpModelAddressSubDto prpModelAddressSubDto);

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
    void modify(@RequestBody PrpModelAddressSubDto prpModelAddressSubDto);
    /**
     *@description 按主键查询实体
     *@param 
     */
    @RequestMapping(value = "queryByPK",method = {RequestMethod.POST})
    PrpModelAddressSubDto queryByPK(@RequestBody Map<String,Object> map);
}