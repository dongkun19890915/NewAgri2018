package com.sinosoft.agriclaim.api.businessutilmanage;

import com.sinosoft.agriclaim.api.AgriClaimConstant;
import com.sinosoft.agriclaim.api.businessutilmanage.dto.PrpLextDto;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-11-08 05:35:28.283 
 * @description 理赔扩展系统表Api接口
 */
@FeignClient(name = AgriClaimConstant.AGRI_CLAIM_SERVICE_NAME, path = PrpLextApi.PATH)
public interface PrpLextApi {

    public static final String PATH = "prpLext";

    /**
     *@description 新增
     *@param
     */
    @RequestMapping(value = "save",method = {RequestMethod.POST})
    void save(PrpLextDto prpLextDto);

    /**
     *@description 删除
     *@param
     */
    @RequestMapping(value = "remove",method = {RequestMethod.POST})
    void remove(String certiNo,String certiType);
    /**
     *@description 修改
     *@param
     */
    @RequestMapping(value = "modify",method = {RequestMethod.POST})
    void modify(PrpLextDto prpLextDto);
    /**
     *@description 按主键查询实体
     *@param 
     */
    @RequestMapping(value = "queryByPK",method = {RequestMethod.POST})
    PrpLextDto queryByPK(String certiNo,String certiType);
}