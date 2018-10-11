package com.sinosoft.agriclaim.core.businessutilmanage.service;


import com.sinosoft.agriclaim.api.businessutilmanage.dto.PrpLAfterwardDto;
import com.sinosoft.framework.dto.PageInfo;

import java.util.List;

/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-11-08 05:35:28.283 
 * @description 案后费用处理表Core接口
 */
public interface PrpLAfterwardService {

    /**
     *@description 新增
     *@param
     */
    void save(PrpLAfterwardDto prpLAfterwardDto);

    /**
     *@description 删除
     *@param
     */
    void remove(String claimNo,java.lang.Double serialNo);
    /**
     *@description 修改
     *@param
     */
    void modify(PrpLAfterwardDto prpLAfterwardDto);
    /**
     *@description 按主键查询实体
     *@param 
     */
    PrpLAfterwardDto queryByPK(String claimNo,java.lang.Double serialNo);
}