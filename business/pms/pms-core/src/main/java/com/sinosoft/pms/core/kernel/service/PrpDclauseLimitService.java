package com.sinosoft.pms.core.kernel.service;


import com.sinosoft.pms.api.kernel.dto.PrpDclauseLimitDto;
import com.sinosoft.framework.dto.PageInfo;

import java.util.List;

/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-08-22 03:00:50.124 
 * @description 条款限额免赔保额表Core接口
 */
public interface PrpDclauseLimitService {

    /**
     *@description 新增
     *@param
     */
    void save(PrpDclauseLimitDto prpDclauseLimitDto);

    /**
     *@description 删除
     *@param
     */
    void remove(String clauseCode,java.lang.Integer serialNo,String limitCode);
    /**
     *@description 修改
     *@param
     */
    void modify(PrpDclauseLimitDto prpDclauseLimitDto);
    /**
     *@description 按主键查询实体
     *@param 
     */
    PrpDclauseLimitDto queryByPK(String clauseCode,java.lang.Integer serialNo,String limitCode);
}