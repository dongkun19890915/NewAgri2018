package com.sinosoft.agriclaim.core.registmanage.service;


import com.sinosoft.agriclaim.api.registmanage.dto.PrpLRelatePersonDto;
import com.sinosoft.framework.dto.PageInfo;

import java.util.List;

/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-11-08 05:45:22.527 
 * @description 联系人表Core接口
 */
public interface PrpLRelatePersonService {

    /**
     *@description 新增
     *@param
     */
    void save(PrpLRelatePersonDto prpLRelatePersonDto);

    /**
     *@description 删除
     *@param
     */
    void remove(String registNo,String personType,java.lang.Integer serialNo);
    /**
     *@description 修改
     *@param
     */
    void modify(PrpLRelatePersonDto prpLRelatePersonDto);
    /**
     *@description 按主键查询实体
     *@param 
     */
    PrpLRelatePersonDto queryByPK(String registNo,String personType,java.lang.Integer serialNo);
}