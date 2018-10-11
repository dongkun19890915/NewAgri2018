package com.sinosoft.agriclaim.core.workflowmanage.service;


import com.sinosoft.agriclaim.api.workflowmanage.dto.SwfFlowMainDto;
import com.sinosoft.framework.dto.PageInfo;

import java.util.List;

/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-11-08 05:47:03.090 
 * @description 流程主表Core接口
 */
public interface SwfFlowMainService {

    /**
     *@description 新增
     *@param
     */
    void save(SwfFlowMainDto swfFlowMainDto);

    /**
     *@description 删除
     *@param
     */
    void remove(String flowId);
    /**
     *@description 修改
     *@param
     */
    void modify(SwfFlowMainDto swfFlowMainDto);
    /**
     *@description 按主键查询实体
     *@param 
     */
    SwfFlowMainDto queryByPK(String flowId);
}