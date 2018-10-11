package com.sinosoft.agriclaim.api.registmanage;

import com.sinosoft.agriclaim.api.AgriClaimConstant;
import com.sinosoft.agriclaim.api.registmanage.dto.PrpLRegistDto;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-11-08 05:45:22.527 
 * @description 报案信息表Api接口
 */
@FeignClient(name = AgriClaimConstant.AGRI_CLAIM_SERVICE_NAME, path = PrpLRegistApi.PATH)
public interface PrpLRegistApi {

    public static final String PATH = "prpLRegist";

    /**
     *@description 新增
     *@param
     */
    @RequestMapping(value = "save",method = {RequestMethod.POST})
    void save(PrpLRegistDto prpLRegistDto);

    /**
     *@description 删除
     *@param
     */
    @RequestMapping(value = "remove",method = {RequestMethod.POST})
    void remove(String registNo);
    /**
     *@description 修改
     *@param
     */
    @RequestMapping(value = "modify",method = {RequestMethod.POST})
    void modify(PrpLRegistDto prpLRegistDto);
    /**
     *@description 按主键查询实体
     *@param 
     */
    @RequestMapping(value = "queryByPK",method = {RequestMethod.POST})
    PrpLRegistDto queryByPK(String registNo);
}