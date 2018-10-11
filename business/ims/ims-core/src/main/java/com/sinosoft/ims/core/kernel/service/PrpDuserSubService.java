package com.sinosoft.ims.core.kernel.service;


import com.sinosoft.ims.api.kernel.dto.PrpDuserSubDto;

/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-08-22 03:00:27.902 
 * @description 用户表附表Core接口
 */
public interface PrpDuserSubService {

    /**
     *@description 新增
     *@param
     */
    void save(PrpDuserSubDto prpDuserSubDto);

    /**
     *@description 删除
     *@param
     */
    void remove(String userCode);
    /**
     *@description 修改
     *@param
     */
    void modify(PrpDuserSubDto prpDuserSubDto);
    /**
     *@description 按主键查询实体
     *@param 
     */
    PrpDuserSubDto queryByPK(String userCode);
}