package com.sinosoft.ims.core.kernel.service;


import com.sinosoft.ims.api.kernel.dto.AgentReqDto;
import com.sinosoft.ims.api.kernel.dto.PrpDagentDto;

import java.util.List;

/**
 * @Description: 中介机构代码表Core接口
 * @Author: 宋振振
 * @Date: 10:55 2017/10/10
 */
public interface PrpDagentService {
    /**
     *@description 新增
     *@param
     */
    void save(PrpDagentDto prpDagentDto);

    /**
     *@description 删除
     *@param
     */
    void remove(String agentCode);
    /**
     *@description 修改
     *@param
     */
    void modify(PrpDagentDto prpDagentDto);
    /**
     *@description 按主键查询实体
     *@param
     */
    PrpDagentDto queryByPK(String agentCode);
    /**
     * 根据条件查询代理人/经纪人信息
     * @author: 宋振振
     * @date: 2017/10/10 10:55
     * @param  agentReqDto 代理人/经纪人查询请求参数的Dto
     * @return List<PrpDagentDto> 返回代理人/经纪人信息
     * @throws Exception
     */
    public List<PrpDagentDto> queryAgentInfo(AgentReqDto agentReqDto, String validStatus) throws Exception;
}