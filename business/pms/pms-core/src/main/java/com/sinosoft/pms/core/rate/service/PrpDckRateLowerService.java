package com.sinosoft.pms.core.rate.service;


import com.sinosoft.pms.api.rate.dto.PrpDckRateLowerDto;
import com.sinosoft.framework.dto.PageInfo;

import java.util.List;

/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-08-22 03:00:50.124 
 * @description 条款责任费率下限表Core接口
 */
public interface PrpDckRateLowerService {

    /**
     *@description 新增
     *@param
     */
    void save(PrpDckRateLowerDto prpDckRateLowerDto);

    /**
     *@description 删除
     *@param
     */
    void remove(java.lang.Integer rateLowerId);
    /**
     *@description 修改
     *@param
     */
    void modify(PrpDckRateLowerDto prpDckRateLowerDto);
    /**
     *@description 按主键查询实体
     *@param 
     */
    PrpDckRateLowerDto queryByPK(java.lang.Integer rateLowerId);
}