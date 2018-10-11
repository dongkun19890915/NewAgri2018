package com.sinosoft.dms.core.dict.service;


import com.sinosoft.dms.api.dict.dto.PrpDnewTypeDto;
import com.sinosoft.framework.dto.PageInfo;

import java.util.List;

/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-08-22 03:00:01.505 
 * @description 通用代码类表Core接口
 */
public interface PrpDnewTypeService {

    /**
     *@description 新增
     *@param
     */
    void save(PrpDnewTypeDto prpDnewTypeDto);

    /**
     *@description 删除
     *@param
     */
    void remove(String codeType);
    /**
     *@description 修改
     *@param
     */
    void modify(PrpDnewTypeDto prpDnewTypeDto);
    /**
     *@description 按主键查询实体
     *@param 
     */
    PrpDnewTypeDto queryByPK(String codeType);
}