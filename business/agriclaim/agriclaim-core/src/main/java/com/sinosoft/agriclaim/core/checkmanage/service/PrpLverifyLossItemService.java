package com.sinosoft.agriclaim.core.checkmanage.service;


import com.sinosoft.agriclaim.api.checkmanage.dto.PrpLverifyLossItemDto;
import com.sinosoft.framework.dto.PageInfo;

import java.util.List;

/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-11-17 08:28:31.346 
 * @description 核损明细表Core接口
 */
public interface PrpLverifyLossItemService {

    /**
     *@description 新增
     *@param
     */
    void save(PrpLverifyLossItemDto prpLverifyLossItemDto);

    /**
     *@description 删除
     *@param
     */
    void remove(String registNo,String policyNo);
    /**
     *@description 修改
     *@param
     */
    void modify(PrpLverifyLossItemDto prpLverifyLossItemDto);
    /**
     *@description 按主键查询实体
     *@param 
     */
    PrpLverifyLossItemDto queryByPK(String registNo,String policyNo);
}