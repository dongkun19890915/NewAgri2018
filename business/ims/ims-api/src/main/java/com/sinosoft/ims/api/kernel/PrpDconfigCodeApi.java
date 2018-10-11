package com.sinosoft.ims.api.kernel;

import com.sinosoft.ims.IMSConstant;
import com.sinosoft.ims.api.kernel.dto.PrpDconfigCodeDto;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-11-05 01:10:12.703 
 * @description 开关配置表Api接口
 */
@FeignClient(name = IMSConstant.IMS_SERVICE_NAME, path = PrpDconfigCodeApi.PATH)
public interface PrpDconfigCodeApi {

    public static final String PATH = "prpDconfigCode";

    /**
     *@description 新增
     *@param
     */
    @RequestMapping(value = "save",method = {RequestMethod.POST})
    void save(PrpDconfigCodeDto prpDconfigCodeDto);

    /**
     *@description 删除
     *@param
     */
    @RequestMapping(value = "remove",method = {RequestMethod.POST})
    void remove(java.util.Date id);
    /**
     *@description 修改
     *@param
     */
    @RequestMapping(value = "modify",method = {RequestMethod.POST})
    void modify(PrpDconfigCodeDto prpDconfigCodeDto);
    /**
     *@description 按主键查询实体
     *@param 
     */
    @RequestMapping(value = "queryByPK",method = {RequestMethod.POST})
    PrpDconfigCodeDto queryByPK(java.util.Date id);
}