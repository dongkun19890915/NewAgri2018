package com.sinosoft.ims.core.auth.service;


import com.sinosoft.ims.api.auth.dto.UtiSystemDto;
import com.sinosoft.framework.dto.PageInfo;

import java.util.List;

/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-08-22 03:00:50.124 
 * @description 系统定义表Core接口
 */
public interface UtiSystemService {

    /**
     *@description 新增
     *@param
     */
    void save(UtiSystemDto utiSystemDto);

    /**
     *@description 删除
     *@param
     */
    void remove(String systemCode);
    /**
     *@description 修改
     *@param
     */
    void modify(UtiSystemDto utiSystemDto);
    /**
     *@description 按主键查询实体
     *@param 
     */
    UtiSystemDto queryByPK(String systemCode);
}