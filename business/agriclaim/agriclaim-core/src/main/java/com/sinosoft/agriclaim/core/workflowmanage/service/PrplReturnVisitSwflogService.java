package com.sinosoft.agriclaim.core.workflowmanage.service;


import com.sinosoft.agriclaim.api.workflowmanage.dto.PrplReturnVisitSwflogDto;
import com.sinosoft.framework.dto.PageInfo;

import java.util.List;

/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-11-10 02:50:26.122 
 * @description 回访工作流表Core接口
 */
public interface PrplReturnVisitSwflogService {

    /**
     *@description 新增
     *@param
     */
    void save(PrplReturnVisitSwflogDto prplReturnVisitSwflogDto);

    /**
     *@description 删除
     *@param
     */
    void remove(String businessNo,String nodeType);
    /**
     *@description 修改
     *@param
     */
    void modify(PrplReturnVisitSwflogDto prplReturnVisitSwflogDto);
    /**
     *@description 按主键查询实体
     *@param 
     */
    PrplReturnVisitSwflogDto queryByPK(String businessNo,String nodeType);
}