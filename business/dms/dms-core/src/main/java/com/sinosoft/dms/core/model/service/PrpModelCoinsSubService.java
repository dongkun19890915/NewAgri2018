package com.sinosoft.dms.core.model.service;


import com.sinosoft.dms.api.model.dto.PrpModelCoinsSubDto;
import com.sinosoft.framework.dto.PageInfo;

import java.util.List;

/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-11-13 11:42:08.278 
 * @description 模板共保信息表Core接口
 */
public interface PrpModelCoinsSubService {

    /**
     *@description 新增
     *@param
     */
    void save(PrpModelCoinsSubDto prpModelCoinsSubDto);

    /**
     *@description 删除
     *@param
     */
    void remove(String modelCode);
    /**
     *@description 修改
     *@param
     */
    void modify(PrpModelCoinsSubDto prpModelCoinsSubDto);
    /**
     *@description 按主键查询实体
     *@param 
     */
    PrpModelCoinsSubDto queryByPK(String modelCode);
}