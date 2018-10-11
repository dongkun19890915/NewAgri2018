package com.sinosoft.agriclaim.core.businessutilmanage.service;


import com.sinosoft.agriclaim.api.businessutilmanage.dto.PrpLAccIPersonDto;
import com.sinosoft.framework.dto.PageInfo;

import java.util.List;

/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-11-08 05:35:28.283 
 * @description 索赔申请人信息表Core接口
 */
public interface PrpLAccIPersonService {

    /**
     *@description 新增
     *@param
     */
    void save(PrpLAccIPersonDto prpLAccIPersonDto);

    /**
     *@description 删除
     *@param
     */
    void remove(String certiNo,String certiType,java.lang.Integer serialNo);
    /**
     *@description 修改
     *@param
     */
    void modify(PrpLAccIPersonDto prpLAccIPersonDto);
    /**
     *@description 按主键查询实体
     *@param 
     */
    PrpLAccIPersonDto queryByPK(String certiNo,String certiType,java.lang.Integer serialNo);
}