package com.sinosoft.dms.core.model.service;


import com.sinosoft.dms.api.model.dto.PrpModelItemKindAgriDto;
import com.sinosoft.framework.dto.PageInfo;

import java.util.List;

/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-11-16 01:04:20.471 
 * @description 模板农险标的附加表Core接口
 */
public interface PrpModelItemKindAgriService {

    /**
     *@description 新增
     *@param
     */
    void save(PrpModelItemKindAgriDto prpModelItemKindAgriDto);

    /**
     *@description 删除
     *@param
     */
    void remove(String modelCode,Integer itemKindNo,String kindCode,Integer times);
    /**
     *@description 修改
     *@param
     */
    void modify(PrpModelItemKindAgriDto prpModelItemKindAgriDto);
    /**
     *@description 按主键查询实体
     *@param 
     */
    PrpModelItemKindAgriDto queryByPK(String modelCode,Integer itemKindNo,String kindCode,Integer times);
}