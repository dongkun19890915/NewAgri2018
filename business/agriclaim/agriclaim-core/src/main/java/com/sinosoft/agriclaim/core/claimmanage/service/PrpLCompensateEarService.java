package com.sinosoft.agriclaim.core.claimmanage.service;


import com.sinosoft.agriclaim.api.claimmanage.dto.PrpLCompensateEarDto;
import com.sinosoft.framework.dto.PageInfo;

import java.util.List;

/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-11-08 05:39:53.061 
 * @description 理赔分户清单表Core接口
 */
public interface PrpLCompensateEarService {

    /**
     *@description 新增
     *@param
     */
    void save(PrpLCompensateEarDto prpLCompensateEarDto);

    /**
     *@description 删除
     *@param
     */
    void remove(String earNo,String registNo,String nodeType,String businessNo);
    /**
     *@description 修改
     *@param
     */
    void modify(PrpLCompensateEarDto prpLCompensateEarDto);
    /**
     *@description 按主键查询实体
     *@param 
     */
    PrpLCompensateEarDto queryByPK(String earNo,String registNo,String nodeType,String businessNo);
}