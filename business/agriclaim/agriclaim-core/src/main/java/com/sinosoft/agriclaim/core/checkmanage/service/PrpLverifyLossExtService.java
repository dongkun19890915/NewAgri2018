package com.sinosoft.agriclaim.core.checkmanage.service;


import com.sinosoft.agriclaim.api.checkmanage.dto.PrpLverifyLossExtDto;
import com.sinosoft.framework.dto.PageInfo;

import java.util.List;

/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-11-17 08:28:31.346 
 * @description 处理意见表Core接口
 */
public interface PrpLverifyLossExtService {

    /**
     *@description 新增
     *@param
     */
    void save(PrpLverifyLossExtDto prpLverifyLossExtDto);

    /**
     *@description 删除
     *@param
     */
    void remove(String registNo);
    /**
     *@description 修改
     *@param
     */
    void modify(PrpLverifyLossExtDto prpLverifyLossExtDto);
    /**
     *@description 按主键查询实体
     *@param 
     */
    PrpLverifyLossExtDto queryByPK(String registNo);
}