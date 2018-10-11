package com.sinosoft.agriclaim.core.schedulemanage.service;


import com.sinosoft.agriclaim.api.schedulemanage.dto.PrpLScheduleMainWfDto;
import com.sinosoft.framework.dto.PageInfo;

import java.util.List;

/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-11-08 05:45:58.930 
 * @description 调度任务/查勘任务主表Core接口
 */
public interface PrpLScheduleMainWfService {

    /**
     *@description 新增
     *@param
     */
    void save(PrpLScheduleMainWfDto prpLScheduleMainWfDto);

    /**
     *@description 删除
     *@param
     */
    void remove(java.lang.Integer scheduleId,String registNo);
    /**
     *@description 修改
     *@param
     */
    void modify(PrpLScheduleMainWfDto prpLScheduleMainWfDto);
    /**
     *@description 按主键查询实体
     *@param 
     */
    PrpLScheduleMainWfDto queryByPK(java.lang.Integer scheduleId,String registNo);
}