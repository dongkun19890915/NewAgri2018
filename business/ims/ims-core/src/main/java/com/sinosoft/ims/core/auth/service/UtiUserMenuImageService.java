package com.sinosoft.ims.core.auth.service;


import com.sinosoft.ims.api.auth.dto.UtiUserMenuImageDto;
import com.sinosoft.framework.dto.PageInfo;

import java.util.List;

/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-11-13 07:56:24.672 
 * @description 常用菜单图标信息表Core接口
 */
public interface UtiUserMenuImageService {

    /**
     *@description 新增
     *@param
     */
    void save(UtiUserMenuImageDto utiUserMenuImageDto);

    /**
     *@description 删除
     *@param
     */
    void remove(String imageId);
    /**
     *@description 修改
     *@param
     */
    void modify(UtiUserMenuImageDto utiUserMenuImageDto);
    /**
     *@description 按主键查询实体
     *@param 
     */
    UtiUserMenuImageDto queryByPK(String imageId);
}