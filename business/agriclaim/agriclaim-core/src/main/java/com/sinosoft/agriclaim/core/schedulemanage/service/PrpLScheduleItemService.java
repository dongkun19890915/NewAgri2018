package com.sinosoft.agriclaim.core.schedulemanage.service;


import com.sinosoft.agriclaim.api.schedulemanage.dto.PrpLScheduleItemDto;
import com.sinosoft.framework.dto.PageInfo;

import java.util.List;

/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-11-08 05:45:58.930 
 * @description 调度任务标的表Core接口
 */
public interface PrpLScheduleItemService {

    /**
     *@description 新增
     *@param
     */
    void save(PrpLScheduleItemDto prpLScheduleItemDto);

    /**
     *@description 删除
     *@param
     */
    void remove(java.lang.Integer scheduleId,String registNo,java.lang.Integer itemNo);
    /**
     *@description 修改
     *@param
     */
    void modify(PrpLScheduleItemDto prpLScheduleItemDto);
    /**
     *@description 按主键查询实体
     *@param 
     */
    PrpLScheduleItemDto queryByPK(java.lang.Integer scheduleId,String registNo,java.lang.Integer itemNo);
}