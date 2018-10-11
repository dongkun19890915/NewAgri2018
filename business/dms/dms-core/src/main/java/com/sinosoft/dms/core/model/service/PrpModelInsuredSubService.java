package com.sinosoft.dms.core.model.service;


import com.sinosoft.dms.api.model.dto.PrpModelInsuredSubDto;
import com.sinosoft.framework.dto.PageInfo;

import java.util.List;

/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-11-13 11:42:08.278 
 * @description 模板保险关系人表Core接口
 */
public interface PrpModelInsuredSubService {

    /**
     *@description 新增
     *@param
     */
    void save(PrpModelInsuredSubDto prpModelInsuredSubDto);

    /**
     *@description 删除
     *@param
     */
    void remove(String modelCode, Integer serialNo);
    /**
     *@description 修改
     *@param
     */
    void modify(PrpModelInsuredSubDto prpModelInsuredSubDto);
    /**
     *@description 按主键查询实体
     *@param 
     */
    PrpModelInsuredSubDto queryByPK(String modelCode, Integer serialNo);
}