package com.sinosoft.agriclaim.core.workflowmanage.service;


import com.sinosoft.agriclaim.api.workflowmanage.dto.SwfLogStoreDto;
import com.sinosoft.framework.dto.PageInfo;

import java.util.List;

/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-11-08 05:47:03.090 
 * @description 工作流日志表1Core接口
 */
public interface SwfLogStoreService {

    /**
     *@description 新增
     *@param
     */
    void save(SwfLogStoreDto swfLogStoreDto);

    /**
     *@description 删除
     *@param
     */
    void remove(String flowId,java.lang.Integer logNo);
    /**
     *@description 修改
     *@param
     */
    void modify(SwfLogStoreDto swfLogStoreDto);
    /**
     *@description 按主键查询实体
     *@param 
     */
    SwfLogStoreDto queryByPK(String flowId,java.lang.Integer logNo);
}