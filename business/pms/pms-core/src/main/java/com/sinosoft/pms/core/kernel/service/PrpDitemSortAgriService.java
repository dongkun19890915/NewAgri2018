package com.sinosoft.pms.core.kernel.service;

import com.sinosoft.pms.api.kernel.dto.PrpDitemSortAgriDto;

public interface PrpDitemSortAgriService {
    /**
     * 新增
     *@param
     */
    void save(PrpDitemSortAgriDto prpDitemSortAgriDto);

    /**
     * 删除
     *@param
     */
    void remove(String itemCode);
    /**
     * 修改
     *@param
     */
    void modify(PrpDitemSortAgriDto prpDitemSortAgriDto);
    /**
     * 按主键查询实体
     *@param
     */
    PrpDitemSortAgriDto queryByPK(String itemCode);
}
