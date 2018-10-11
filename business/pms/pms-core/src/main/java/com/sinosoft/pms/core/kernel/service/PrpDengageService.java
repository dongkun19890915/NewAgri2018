package com.sinosoft.pms.core.kernel.service;


import com.sinosoft.pms.api.kernel.dto.PrpDengageDto;
import com.sinosoft.framework.dto.PageInfo;

import java.util.List;

/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-08-22 03:00:50.124 
 * @description 特别约定表Core接口
 */
public interface PrpDengageService {

    /**
     *@description 新增
     *@param
     */
    void save(PrpDengageDto prpDengageDto);

    /**
     *@description 删除
     *@param
     */
    void remove(String engageCode);
    /**
     *@description 修改
     *@param
     */
    void modify(PrpDengageDto prpDengageDto);
    /**
     *@description 按主键查询实体
     *@param 
     */
    PrpDengageDto queryByPK(String engageCode);
}