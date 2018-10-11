package com.sinosoft.agriclaim.core.workflowmanage.service;


import com.sinosoft.agriclaim.api.workflowmanage.dto.SwfNodeDto;
import com.sinosoft.framework.dto.PageInfo;

import java.util.List;

/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-11-08 05:47:03.090 
 * @description 工作流节点定义表Core接口
 */
public interface SwfNodeService {

    /**
     *@description 新增
     *@param
     */
    void save(SwfNodeDto swfNodeDto);

    /**
     *@description 删除
     *@param
     */
    void remove(java.lang.Integer modelNo,java.lang.Integer nodeNo);
    /**
     *@description 修改
     *@param
     */
    void modify(SwfNodeDto swfNodeDto);
    /**
     *@description 按主键查询实体
     *@param 
     */
    SwfNodeDto queryByPK(java.lang.Integer modelNo,java.lang.Integer nodeNo);
}