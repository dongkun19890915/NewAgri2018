package com.sinosoft.ims.core.auth.service;


import com.sinosoft.ims.api.auth.dto.UtiUserMenuDto;

/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-11-13 07:55:48.156 
 * @description 常用菜单信息表Core接口
 */
public interface UtiUserMenuService {

    /**
     *@description 新增
     *@param
     */
    void save(UtiUserMenuDto utiUserMenuDto);

    /**
     *@description 删除
     *@param
     */
    void remove(String userCode, Integer menuId, String comCode);
    /**
     *@description 修改
     *@param
     */
    void modify(UtiUserMenuDto utiUserMenuDto);
    /**
     *@description 按主键查询实体
     *@param 
     */
    UtiUserMenuDto queryByPK(String userCode, Integer menuId, String comCode);
}