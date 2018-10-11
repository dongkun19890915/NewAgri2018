package com.sinosoft.pms.core.kernel.service;


import com.sinosoft.pms.api.kernel.dto.PrpDengageClassDto;
import com.sinosoft.framework.dto.PageInfo;

import java.util.List;

/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-08-22 03:00:50.124 
 * @description 特别约定险类表Core接口
 */
public interface PrpDengageClassService {

    /**
     *@description 新增
     *@param
     */
    void save(PrpDengageClassDto prpDengageClassDto);

    /**
     *@description 删除
     *@param
     */
    void remove(String engageCode,String classCode);
    /**
     *@description 修改
     *@param
     */
    void modify(PrpDengageClassDto prpDengageClassDto);
    /**
     *@description 按主键查询实体
     *@param 
     */
    PrpDengageClassDto queryByPK(String engageCode,String classCode);
}