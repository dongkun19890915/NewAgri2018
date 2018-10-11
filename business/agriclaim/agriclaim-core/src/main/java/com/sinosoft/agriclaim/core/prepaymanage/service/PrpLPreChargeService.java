package com.sinosoft.agriclaim.core.prepaymanage.service;


import com.sinosoft.agriclaim.api.prepaymanage.dto.PrpLPreChargeDto;
import com.sinosoft.framework.dto.PageInfo;

import java.util.List;

/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-11-08 05:44:02.119 
 * @description 预赔费用信息表Core接口
 */
public interface PrpLPreChargeService {

    /**
     *@description 新增
     *@param
     */
    void save(PrpLPreChargeDto prpLPreChargeDto);

    /**
     *@description 删除
     *@param
     */
    void remove(java.lang.Integer id);
    /**
     *@description 修改
     *@param
     */
    void modify(PrpLPreChargeDto prpLPreChargeDto);
    /**
     *@description 按主键查询实体
     *@param 
     */
    PrpLPreChargeDto queryByPK(java.lang.Integer id);
}