package com.sinosoft.agriclaim.core.workflowmanage.service;


import com.sinosoft.agriclaim.api.workflowmanage.dto.PrpLAutoClaimListDto;
import com.sinosoft.agriclaim.api.workflowmanage.dto.SwfLogDto;
import com.sinosoft.framework.dto.PageInfo;

import java.util.List;

/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2018-01-23 10:17:47.442 
 * @description 自动理赔清单数据表Core接口
 */
public interface PrpLAutoClaimListService {

    /**
     *@description 新增
     *@param
     */
    void save(PrpLAutoClaimListDto prpLAutoClaimListDto);

    /**
     *@description 删除
     *@param
     */
    void remove(String registNo);
    /**
     *@description 修改
     *@param
     */
    void modify(PrpLAutoClaimListDto prpLAutoClaimListDto);
    /**
     *@description 按主键查询实体
     *@param 
     */
    PrpLAutoClaimListDto queryByPK(String registNo);

    /**
     * 自动理算接口
     * @param swfLogDtoList 待处理自动理算任务案件集合
     * @author 王心洋
     * @time 2018-01-30
     */
    public void autoClaimList(List<SwfLogDto> swfLogDtoList) throws Exception;
}