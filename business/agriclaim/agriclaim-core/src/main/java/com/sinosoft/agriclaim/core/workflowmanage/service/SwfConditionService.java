package com.sinosoft.agriclaim.core.workflowmanage.service;


import com.sinosoft.agriclaim.api.workflowmanage.dto.SwfConditionDto;
import com.sinosoft.framework.dto.PageInfo;

import java.util.List;

/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-11-08 05:47:03.090 
 * @description 工作流条件描述表Core接口
 */
public interface SwfConditionService {

    /**
     *@description 新增
     *@param
     */
    void save(SwfConditionDto swfConditionDto);

    /**
     *@description 删除
     *@param
     */
    void remove(java.lang.Integer modelNo,java.lang.Integer pathNo,java.lang.Integer conditionNo,java.lang.Integer serialNo);
    /**
     *@description 修改
     *@param
     */
    void modify(SwfConditionDto swfConditionDto);
    /**
     *@description 按主键查询实体
     *@param 
     */
    SwfConditionDto queryByPK(java.lang.Integer modelNo,java.lang.Integer pathNo,java.lang.Integer conditionNo,java.lang.Integer serialNo);
}