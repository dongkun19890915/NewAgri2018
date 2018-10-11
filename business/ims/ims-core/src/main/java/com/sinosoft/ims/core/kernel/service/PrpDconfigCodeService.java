package com.sinosoft.ims.core.kernel.service;


import com.sinosoft.framework.dto.PageInfo;
import com.sinosoft.ims.api.kernel.dto.PrpDconfigCodeDto;

import java.util.List;

/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-11-05 01:10:12.703 
 * @description 开关配置表Core接口
 */
public interface PrpDconfigCodeService {

    /**
     *@description 新增
     *@param
     */
    void save(PrpDconfigCodeDto prpDconfigCodeDto);

    /**
     *@description 删除
     *@param
     */
    void remove(java.util.Date id);
    /**
     *@description 修改
     *@param
     */
    void modify(PrpDconfigCodeDto prpDconfigCodeDto);
    /**
     *@description 按主键查询实体
     *@param 
     */
    PrpDconfigCodeDto queryByPK(java.util.Date id);
}