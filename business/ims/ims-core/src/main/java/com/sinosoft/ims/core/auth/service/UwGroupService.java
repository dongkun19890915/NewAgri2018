package com.sinosoft.ims.core.auth.service;


import com.sinosoft.framework.dto.PageInfo;
import com.sinosoft.ims.api.auth.dto.UwGroupDto;

import java.util.List;

/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-11-05 01:11:08.689 
 * @description UwGroupCore接口
 */
public interface UwGroupService {

    /**
     *@description 新增
     *@param
     */
    void save(UwGroupDto uwGroupDto);

    /**
     *@description 删除
     *@param
     */
    void remove(Integer groupNo, String comCode, String riskCode, String classCode);
    /**
     *@description 修改
     *@param
     */
    void modify(UwGroupDto uwGroupDto);
    /**
     *@description 按主键查询实体
     *@param 
     */
    UwGroupDto queryByPK(Integer groupNo, String comCode, String riskCode, String classCode);
}