package com.sinosoft.ims.core.kernel.service;


import com.sinosoft.framework.dto.PageInfo;
import com.sinosoft.ims.api.kernel.dto.PrpDfacConfigDto;

import java.util.List;

/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-11-05 01:10:12.703 
 * @description 临分权限控制表Core接口
 */
public interface PrpDfacConfigService {

    /**
     *@description 新增
     *@param
     */
    void save(PrpDfacConfigDto prpDfacConfigDto);

    /**
     *@description 删除
     *@param
     */
    void remove(String id);
    /**
     *@description 修改
     *@param
     */
    void modify(PrpDfacConfigDto prpDfacConfigDto);
    /**
     *@description 按主键查询实体
     *@param 
     */
    PrpDfacConfigDto queryByPK(String id);
}