package com.sinosoft.agriclaim.core.checkmanage.service;


import com.sinosoft.agriclaim.api.checkmanage.dto.PrpLAcciCheckDto;
import com.sinosoft.framework.dto.PageInfo;

import java.util.List;

/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-11-08 05:38:49.324 
 * @description 意健险调查主表Core接口
 */
public interface PrpLAcciCheckService {

    /**
     *@description 新增
     *@param
     */
    void save(PrpLAcciCheckDto prpLAcciCheckDto);

    /**
     *@description 删除
     *@param
     */
    void remove(String checkNo);
    /**
     *@description 修改
     *@param
     */
    void modify(PrpLAcciCheckDto prpLAcciCheckDto);
    /**
     *@description 按主键查询实体
     *@param 
     */
    PrpLAcciCheckDto queryByPK(String checkNo);
}