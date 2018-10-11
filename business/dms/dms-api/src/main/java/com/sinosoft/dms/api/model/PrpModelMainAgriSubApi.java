package com.sinosoft.dms.api.model;

import com.sinosoft.dms.api.DMSConstant;
import com.sinosoft.dms.api.model.dto.PrpModelMainAgriSubDto;
import com.sinosoft.framework.dto.PageInfo;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-11-13 11:42:08.278 
 * @description 模板农业险保单信息Api接口
 */
@FeignClient(name = DMSConstant.DMS_SERVICE_NAME, path = PrpModelMainAgriSubApi.PATH)
public interface PrpModelMainAgriSubApi {

    public static final String PATH = "prpModelMainAgriSub";

    /**
     *@description 新增
     *@param
     */
    @RequestMapping(value = "save",method = {RequestMethod.POST})
    void save(PrpModelMainAgriSubDto prpModelMainAgriSubDto);

    /**
     *@description 删除
     *@param
     */
    @RequestMapping(value = "remove",method = {RequestMethod.POST})
    void remove(String modelCode);
    /**
     *@description 修改
     *@param
     */
    @RequestMapping(value = "modify",method = {RequestMethod.POST})
    void modify(PrpModelMainAgriSubDto prpModelMainAgriSubDto);
    /**
     *@description 按主键查询实体
     *@param 
     */
    @RequestMapping(value = "queryByPK",method = {RequestMethod.POST})
    PrpModelMainAgriSubDto queryByPK(String modelCode);
}