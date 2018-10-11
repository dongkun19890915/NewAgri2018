package com.sinosoft.agriclaim.core.workflowmanage.service;


import com.sinosoft.agriclaim.api.workflowmanage.dto.WorkFlowRecDto;
import com.sinosoft.framework.dto.PageInfo;

import java.util.List;

/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-11-08 05:47:03.090 
 * @description 流程监控表Core接口
 */
public interface WorkFlowRecService {

    /**
     *@description 新增
     *@param
     */
    void save(WorkFlowRecDto workFlowRecDto);

    /**
     *@description 删除
     *@param
     */
    void remove(String nodeCode,String businessNo,java.lang.Integer serialNo);
    /**
     *@description 修改
     *@param
     */
    void modify(WorkFlowRecDto workFlowRecDto);
    /**
     *@description 按主键查询实体
     *@param 
     */
    WorkFlowRecDto queryByPK(String nodeCode,String businessNo,java.lang.Integer serialNo);
}