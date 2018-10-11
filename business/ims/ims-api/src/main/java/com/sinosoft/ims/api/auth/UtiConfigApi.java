package com.sinosoft.ims.api.auth;

import com.sinosoft.ims.IMSConstant;
import com.sinosoft.ims.api.auth.dto.UtiConfigDto;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-11-05 01:10:12.703 
 * @description UtiConfigApi接口
 */
@FeignClient(name = IMSConstant.IMS_SERVICE_NAME, path = UtiConfigApi.PATH)
public interface UtiConfigApi {

    public static final String PATH = "utiConfig";

    /**
     *@description 新增
     *@param
     */
    @RequestMapping(value = "save",method = {RequestMethod.POST})
    void save(UtiConfigDto utiConfigDto);

    /**
     *@description 删除
     *@param
     */
    @RequestMapping(value = "remove",method = {RequestMethod.POST})
    void remove(String configCode);
    /**
     *@description 修改
     *@param
     */
    @RequestMapping(value = "modify",method = {RequestMethod.POST})
    void modify(UtiConfigDto utiConfigDto);
    /**
     *@description 按主键查询实体
     *@param 
     */
    @RequestMapping(value = "queryByPK",method = {RequestMethod.POST})
    UtiConfigDto queryByPK(String configCode);
}