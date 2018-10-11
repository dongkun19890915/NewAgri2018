package com.sinosoft.agriclaim.core.claimmanage.service;


import com.sinosoft.agriclaim.api.claimmanage.dto.PrpLEarDto;
import com.sinosoft.framework.dto.PageInfo;

import java.util.List;

/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-12-01 01:33:42.103 
 * @description 耳标号表Core接口
 */
public interface PrpLEarService {

    /**
     *@description 新增
     *@param
     */
    void save(PrpLEarDto prpLEarDto);

    /**
     *@description 删除
     *@param
     */
    void remove(String policyNo,String earNo,String registNo);
    /**
     *@description 修改
     *@param
     */
    void modify(PrpLEarDto prpLEarDto);
    /**
     *@description 按主键查询实体
     *@param 
     */
    PrpLEarDto queryByPK(String policyNo,String earNo,String registNo);
}