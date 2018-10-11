package com.sinosoft.dms.api.dict;

import com.sinosoft.dms.api.DMSConstant;
import com.sinosoft.dms.api.dict.dto.UtiKeyDto;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-11-05 01:02:29.563 
 * @description UtiKeyApi接口
 */
@FeignClient(name = DMSConstant.DMS_SERVICE_NAME, path = UtiKeyApi.PATH)
public interface UtiKeyApi {

    public static final String PATH = "utiKey";

    /**
     *@description 新增
     *@param
     */
    @RequestMapping(value = "save",method = {RequestMethod.POST})
    void save(UtiKeyDto utiKeyDto);

    /**
     *@description 删除
     *@param
     */
    @RequestMapping(value = "remove",method = {RequestMethod.POST})
    void remove(String tablEName);
    /**
     *@description 修改
     *@param
     */
    @RequestMapping(value = "modify",method = {RequestMethod.POST})
    void modify(UtiKeyDto utiKeyDto);
    /**
     *@description 按主键查询实体
     *@param 
     */
    @RequestMapping(value = "queryByPK",method = {RequestMethod.POST})
    UtiKeyDto queryByPK(String tablEName);
}