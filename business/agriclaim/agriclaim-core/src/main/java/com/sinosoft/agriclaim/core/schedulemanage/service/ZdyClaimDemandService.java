package com.sinosoft.agriclaim.core.schedulemanage.service;


import com.sinosoft.agriclaim.api.schedulemanage.dto.ZdyClaimDemandDto;
import com.sinosoft.framework.dto.PageInfo;

import java.util.List;

/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-11-10 02:49:33.975 
 * @description 驻点员App案件推送日志表Core接口
 */
public interface ZdyClaimDemandService {

    /**
     *@description 新增
     *@param
     */
    void save(ZdyClaimDemandDto zdyClaimDemandDto);

    /**
     *@description 删除
     *@param
     */
    void remove(String id);
    /**
     *@description 修改
     *@param
     */
    void modify(ZdyClaimDemandDto zdyClaimDemandDto);
    /**
     *@description 按主键查询实体
     *@param 
     */
    ZdyClaimDemandDto queryByPK(String id);
}