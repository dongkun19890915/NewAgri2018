package com.sinosoft.pms.core.kernel.service;


import com.sinosoft.pms.api.kernel.dto.PrpDclauseEngageDto;
import com.sinosoft.framework.dto.PageInfo;

import java.util.List;

/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-08-22 03:00:50.124 
 * @description 条款特别约定表Core接口
 */
public interface PrpDclauseEngageService {

    /**
     *@description 新增
     *@param
     */
    void save(PrpDclauseEngageDto prpDclauseEngageDto);

    /**
     *@description 删除
     *@param
     */
    void remove(String clauseCode,String engageCode);
    /**
     *@description 修改
     *@param
     */
    void modify(PrpDclauseEngageDto prpDclauseEngageDto);
    /**
     *@description 按主键查询实体
     *@param 
     */
    PrpDclauseEngageDto queryByPK(String clauseCode,String engageCode);
}