package com.sinosoft.agriclaim.core.cetainmanage.service;


import com.sinosoft.agriclaim.api.cetainmanage.dto.PrpLCetainLossDto;
import com.sinosoft.framework.dto.PageInfo;

import java.util.List;

/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-11-08 05:36:28.690 
 * @description 确定损失表（无表名）Core接口
 */
public interface PrpLCetainLossService {

    /**
     *@description 新增
     *@param
     */
    void save(PrpLCetainLossDto prpLCetainLossDto);

    /**
     *@description 删除
     *@param
     */
    void remove(java.lang.Double id);
    /**
     *@description 修改
     *@param
     */
    void modify(PrpLCetainLossDto prpLCetainLossDto);
    /**
     *@description 按主键查询实体
     *@param 
     */
    PrpLCetainLossDto queryByPK(java.lang.Double id);
}