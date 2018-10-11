package com.sinosoft.agriclaim.core.workflowmanage.service;


import com.sinosoft.agriclaim.api.workflowmanage.dto.ResponseSwfNotionInfoDto;
import com.sinosoft.agriclaim.api.workflowmanage.dto.SwfNotionDto;
import com.sinosoft.framework.dto.PageInfo;

import java.util.List;

/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-11-08 05:47:03.090 
 * @description 处理意见表Core接口
 */
public interface SwfNotionService {

    /**
     *@description 新增
     *@param
     */
    void save(SwfNotionDto swfNotionDto);

    /**
     *@description 删除
     *@param
     */
    void remove(String flowId,java.lang.Integer logNo,java.lang.Integer lineNo);
    /**
     *@description 修改
     *@param
     */
    void modify(SwfNotionDto swfNotionDto);
    /**
     *@description 按主键查询实体
     *@param 
     */
    SwfNotionDto queryByPK(String flowId,java.lang.Integer logNo,java.lang.Integer lineNo);
    /**
     * 根据流程编号和序号查询审核意见
     * @author: 孙朋飞
     * @date: 2018/4/26 19:37
     * @param  businessNo 流程id
     * @return 审核意见的集合
     * @throws Exception
     */
    public List<ResponseSwfNotionInfoDto> querySwfNotionByFlowId(String businessNo) throws Exception;
}