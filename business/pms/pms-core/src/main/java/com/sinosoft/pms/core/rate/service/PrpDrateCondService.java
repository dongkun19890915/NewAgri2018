package com.sinosoft.pms.core.rate.service;


import com.sinosoft.pms.api.rate.dto.PrpDrateCondDto;
import com.sinosoft.framework.dto.PageInfo;

import java.util.List;

/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time 2017-08-22 03:00:50.124
 * @description 费率条件表Core接口
 */
public interface PrpDrateCondService {

    /**
     * @param
     * @description 新增
     */
    void save(PrpDrateCondDto prpDrateCondDto);

    /**
     * @param
     * @description 删除
     */
    void remove(String comCode, String riskCode, String factorType, String kindCode, java.lang.Integer ratePeriod, String factorCode);

    /**
     * @param
     * @description 修改
     */
    void modify(PrpDrateCondDto prpDrateCondDto);

    /**
     * @param
     * @description 按主键查询实体
     */
    PrpDrateCondDto queryByPK(String comCode, String riskCode, String factorType, String kindCode, java.lang.Integer ratePeriod, String factorCode);

    /**
     * 查询列表
     *
     * @param rateCondCondition
     * @return
     */
    List<PrpDrateCondDto> queryList(PrpDrateCondDto rateCondCondition);
}