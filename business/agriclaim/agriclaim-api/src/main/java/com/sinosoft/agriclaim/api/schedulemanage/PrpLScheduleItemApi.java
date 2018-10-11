package com.sinosoft.agriclaim.api.schedulemanage;

import com.sinosoft.agriclaim.api.AgriClaimConstant;
import com.sinosoft.agriclaim.api.schedulemanage.dto.PrpLScheduleItemDto;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-11-08 05:45:58.930 
 * @description 调度任务标的表Api接口
 */
@FeignClient(name = AgriClaimConstant.AGRI_CLAIM_SERVICE_NAME, path = PrpLScheduleItemApi.PATH)
public interface PrpLScheduleItemApi {

    public static final String PATH = "prpLScheduleItem";

    /**
     *@description 新增
     *@param
     */
    @RequestMapping(value = "save",method = {RequestMethod.POST})
    void save(PrpLScheduleItemDto prpLScheduleItemDto);

    /**
     *@description 删除
     *@param
     */
    @RequestMapping(value = "remove",method = {RequestMethod.POST})
    void remove(java.lang.Integer scheduleId,String registNo,java.lang.Integer itemNo);
    /**
     *@description 修改
     *@param
     */
    @RequestMapping(value = "modify",method = {RequestMethod.POST})
    void modify(PrpLScheduleItemDto prpLScheduleItemDto);
    /**
     *@description 按主键查询实体
     *@param 
     */
    @RequestMapping(value = "queryByPK",method = {RequestMethod.POST})
    PrpLScheduleItemDto queryByPK(java.lang.Integer scheduleId,String registNo,java.lang.Integer itemNo);
}