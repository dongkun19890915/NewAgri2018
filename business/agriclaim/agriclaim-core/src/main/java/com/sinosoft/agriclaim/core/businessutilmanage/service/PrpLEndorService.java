package com.sinosoft.agriclaim.core.businessutilmanage.service;


import com.sinosoft.agriclaim.api.businessutilmanage.dto.PrpLEndorDto;
import com.sinosoft.framework.dto.PageInfo;

import java.util.List;

/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-11-08 05:35:28.283 
 * @description 理赔冲减保额表Core接口
 */
public interface PrpLEndorService {

    /**
     *@description 新增
     *@param
     */
    void save(PrpLEndorDto prpLEndorDto);

    /**
     *@description 删除
     *@param
     */
    void remove(String compensateNo,String policyNo,String endorType);
    /**
     *@description 修改
     *@param
     */
    void modify(PrpLEndorDto prpLEndorDto);
    /**
     *@description 按主键查询实体
     *@param 
     */
    PrpLEndorDto queryByPK(String compensateNo,String policyNo,String endorType);
}