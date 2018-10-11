package com.sinosoft.ims.core.auth.service;


import com.sinosoft.framework.dto.PageInfo;
import com.sinosoft.ims.api.auth.dto.UtiUserLoginDto;

import java.util.List;

/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-11-05 01:11:08.689 
 * @description UtiUserLoginCore接口
 */
public interface UtiUserLoginService {

    /**
     *@description 新增
     *@param
     */
    void save(UtiUserLoginDto utiUserLoginDto);

    /**
     *@description 删除
     *@param
     */
    void remove(String userCode);
    /**
     *@description 修改
     *@param
     */
    void modify(UtiUserLoginDto utiUserLoginDto);
    /**
     *@description 按主键查询实体
     *@param 
     */
    UtiUserLoginDto queryByPK(String userCode);
}