package com.sinosoft.agriclaim.core.schedulemanage.service;


import com.sinosoft.agriclaim.api.schedulemanage.dto.PrpLScheduleMainDto;
import com.sinosoft.framework.dto.PageInfo;

import java.util.List;

/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-11-08 05:45:58.930 
 * @description 调度任务主表Core接口
 */
public interface PrpLScheduleMainService {

    /**
     *@description 新增
     *@param
     */
    void save(PrpLScheduleMainDto prpLScheduleMainDto);

    /**
     *@description 删除
     *@param
     */
    void remove(java.lang.Double scheduleId,String registNo,java.lang.Double serialNo);
    /**
     *@description 修改
     *@param
     */
    void modify(PrpLScheduleMainDto prpLScheduleMainDto);
    /**
     *@description 按主键查询实体
     *@param 
     */
    PrpLScheduleMainDto queryByPK(java.lang.Double scheduleId,String registNo,java.lang.Double serialNo);
}