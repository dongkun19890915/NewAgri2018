package com.sinosoft.agriclaim.core.cetainmanage.service;


import com.sinosoft.agriclaim.api.cetainmanage.dto.PrpLPropDto;
import com.sinosoft.framework.dto.PageInfo;

import java.util.List;

/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-11-08 05:36:28.690 
 * @description 财产核定损明细清单表Core接口
 */
public interface PrpLPropService {

    /**
     *@description 新增
     *@param
     */
    void save(PrpLPropDto prpLPropDto);

    /**
     *@description 删除
     *@param
     */
    void remove(java.lang.Integer serialNo,String registNo,String lossItemCode);
    /**
     *@description 修改
     *@param
     */
    void modify(PrpLPropDto prpLPropDto);
    /**
     *@description 按主键查询实体
     *@param 
     */
    PrpLPropDto queryByPK(java.lang.Integer serialNo,String registNo,String lossItemCode);
}