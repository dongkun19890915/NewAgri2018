package com.sinosoft.ims.api.auth;

import com.sinosoft.framework.dto.PageInfo;
import com.sinosoft.ims.IMSConstant;
import com.sinosoft.ims.api.auth.dto.UtiSolvencyDto;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-11-05 01:10:45.148 
 * @description UtiSolvencyApi接口
 */
@FeignClient(name = IMSConstant.IMS_SERVICE_NAME, path = UtiSolvencyApi.PATH)
public interface UtiSolvencyApi {

    public static final String PATH = "utiSolvency";

    /**
     *@description 新增
     *@param
     */
    @RequestMapping(value = "save",method = {RequestMethod.POST})
    void save(UtiSolvencyDto utiSolvencyDto);

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
    void modify(UtiSolvencyDto utiSolvencyDto);
    /**
     *@description 按主键查询实体
     *@param 
     */
    @RequestMapping(value = "queryByPK",method = {RequestMethod.POST})
    UtiSolvencyDto queryByPK(java.util.Date id);
}