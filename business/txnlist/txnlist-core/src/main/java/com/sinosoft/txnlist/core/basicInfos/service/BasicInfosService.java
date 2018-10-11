package com.sinosoft.txnlist.core.basicInfos.service;


import com.sinosoft.txnlist.api.basicInfos.dto.BasicInfosDto;
import com.sinosoft.framework.dto.PageInfo;

import java.util.List;

/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-10-23 12:58:53.230 
 * @description basicInfosCore接口
 */
public interface BasicInfosService {

    /**
     *@description 新增
     *@param
     */
    void save(BasicInfosDto basicInfosDto);

    /**
     *@description 删除
     *@param
     */
    void remove(String code);
    /**
     *@description 修改
     *@param
     */
    void modify(BasicInfosDto basicInfosDto);
    /**
     *@description 按主键查询实体
     *@param 
     */
    BasicInfosDto queryByPK(String code);
}