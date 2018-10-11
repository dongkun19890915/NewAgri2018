package com.sinosoft.agriclaim.core.workflowmanage.service;


import com.sinosoft.agriclaim.api.workflowmanage.dto.SwfPathLogDto;
import com.sinosoft.framework.dto.PageInfo;

import java.util.List;

/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-11-08 05:47:03.090 
 * @description 工作流路径日志表Core接口
 */
public interface SwfPathLogService {

    /**
     *@description 新增
     *@param
     */
    void save(SwfPathLogDto swfPathLogDto);

    /**
     *@description 删除
     *@param
     */
    void remove(String flowId,java.lang.Integer pathNo);
    /**
     *@description 修改
     *@param
     */
    void modify(SwfPathLogDto swfPathLogDto);
    /**
     *@description 按主键查询实体
     *@param 
     */
    SwfPathLogDto queryByPK(String flowId,java.lang.Integer pathNo);
}