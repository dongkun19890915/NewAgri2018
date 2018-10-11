package com.sinosoft.agriclaim.core.checkmanage.service;


import com.sinosoft.agriclaim.api.checkmanage.dto.PrpLverifyLossDto;
import com.sinosoft.framework.dto.PageInfo;

import java.util.List;

/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-11-17 08:28:31.346 
 * @description 定核损主表Core接口
 */
public interface PrpLverifyLossService {

    /**
     *@description 新增
     *@param
     */
    void save(PrpLverifyLossDto prpLverifyLossDto);

    /**
     *@description 删除
     *@param
     */
    void remove(String registNo,String lossItemCode);
    /**
     *@description 修改
     *@param
     */
    void modify(PrpLverifyLossDto prpLverifyLossDto);
    /**
     *@description 按主键查询实体
     *@param 
     */
    PrpLverifyLossDto queryByPK(String registNo,String lossItemCode);
}