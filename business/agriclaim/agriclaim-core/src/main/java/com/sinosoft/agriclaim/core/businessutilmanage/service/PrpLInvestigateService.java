package com.sinosoft.agriclaim.core.businessutilmanage.service;


import com.sinosoft.agriclaim.api.businessutilmanage.dto.PrpLInvestigateDto;

import java.util.Map;


/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-11-08 05:35:28.283 
 * @description 案情调查信息表Core接口
 */
public interface PrpLInvestigateService {

    /**
     *@description 新增
     *@param
     */
    void save(PrpLInvestigateDto prpLInvestigateDto);

    /**
     *@description 删除
     *@param
     */
    void remove(String registNo,java.lang.Double serialNo,String objectType);
    /**
     *@description 修改
     *@param
     */
    void modify(PrpLInvestigateDto prpLInvestigateDto);
    /**
     *@description 按主键查询实体
     *@param 
     */
    PrpLInvestigateDto queryByPK(String registNo,java.lang.Double serialNo,String objectType);
    /**
     * 调查流程节点
     * @author: 孙朋飞
     * @date: 2018/2/22 10:43
     * @param nodeStatus 节点状态
     * @param registNo 报案号
     * @param handlerCode 处理人代码
     * @param handlerName 处理人名称
     * @param userComCode 用户机构代码
     * @param userComCname 用户机构名称
     * @return 报案号
     * @throws Exception
     */
    public Map<String,String> saveInvestigation(String registNo, String flowId, String handlerCode, String handlerName, String userComCode, String userComCname) throws Exception;
    /**
     * 发起调查
     * @author: 孙朋飞
     * @date: 2018/3/30 17:14
     * @param registNo 报案号
     * @param policyNo 保单号
     * @param nextHandlerCode 被调度人代码
     * @param nextHandlerName 被调度人姓名
     * @return 发起调查成功
     * @throws Exception
     */
    public Map<String,String> submitInvestigation(String registNo,String policyNo,String nextHandlerCode,String nextHandlerName) throws Exception;
}