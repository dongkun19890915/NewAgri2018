package com.sinosoft.ims.core.auth.service;


import com.sinosoft.framework.dto.PageInfo;
import com.sinosoft.ims.api.auth.dto.UtiMenuTaskDto;

import java.util.List;

/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-11-05 01:10:45.148 
 * @description UtiMenuTaskCore接口
 */
public interface UtiMenuTaskService {

    /**
     *@description 新增
     *@param
     */
    void save(UtiMenuTaskDto utiMenuTaskDto);

    /**
     *@description 删除
     *@param
     */
    void remove(String menuId);
    /**
     *@description 修改
     *@param
     */
    void modify(UtiMenuTaskDto utiMenuTaskDto);
    /**
     *@description 按主键查询实体
     *@param 
     */
    UtiMenuTaskDto queryByPK(String menuId);
}