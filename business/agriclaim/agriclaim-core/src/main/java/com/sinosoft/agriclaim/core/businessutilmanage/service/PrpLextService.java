package com.sinosoft.agriclaim.core.businessutilmanage.service;


import com.sinosoft.agriclaim.api.businessutilmanage.dto.PrpLextDto;
import com.sinosoft.framework.dto.PageInfo;

import java.util.List;

/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-11-08 05:35:28.283 
 * @description 理赔扩展系统表Core接口
 */
public interface PrpLextService {

    /**
     *@description 新增
     *@param
     */
    void save(PrpLextDto prpLextDto);

    /**
     *@description 删除
     *@param
     */
    void remove(String certiNo,String certiType);
    /**
     *@description 修改
     *@param
     */
    void modify(PrpLextDto prpLextDto);
    /**
     *@description 按主键查询实体
     *@param 
     */
    PrpLextDto queryByPK(String certiNo,String certiType);
}