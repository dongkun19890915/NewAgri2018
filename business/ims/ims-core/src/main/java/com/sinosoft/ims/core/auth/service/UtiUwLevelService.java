package com.sinosoft.ims.core.auth.service;


import com.sinosoft.framework.dto.PageInfo;
import com.sinosoft.ims.api.auth.dto.UtiUwLevelDto;

import java.util.List;

/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-11-05 01:11:08.689 
 * @description UtiUwLevelCore接口
 */
public interface UtiUwLevelService {

    /**
     *@description 新增
     *@param
     */
    void save(UtiUwLevelDto utiUwLevelDto);

    /**
     *@description 删除
     *@param
     */
    void remove(String userCode, String comCode, String riskCode, Integer modelNo, Integer nodeNo, String uwType);
    /**
     *@description 修改
     *@param
     */
    void modify(UtiUwLevelDto utiUwLevelDto);
    /**
     *@description 按主键查询实体
     *@param 
     */
    UtiUwLevelDto queryByPK(String userCode, String comCode, String riskCode, Integer modelNo, Integer nodeNo, String uwType);
}