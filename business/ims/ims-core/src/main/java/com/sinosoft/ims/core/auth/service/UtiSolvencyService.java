package com.sinosoft.ims.core.auth.service;


import com.sinosoft.framework.dto.PageInfo;
import com.sinosoft.ims.api.auth.dto.UtiSolvencyDto;

import java.util.List;

/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-11-05 01:10:45.148 
 * @description UtiSolvencyCore接口
 */
public interface UtiSolvencyService {

    /**
     *@description 新增
     *@param
     */
    void save(UtiSolvencyDto utiSolvencyDto);

    /**
     *@description 删除
     *@param
     */
    void remove(java.util.Date id);
    /**
     *@description 修改
     *@param
     */
    void modify(UtiSolvencyDto utiSolvencyDto);
    /**
     *@description 按主键查询实体
     *@param 
     */
    UtiSolvencyDto queryByPK(java.util.Date id);
}