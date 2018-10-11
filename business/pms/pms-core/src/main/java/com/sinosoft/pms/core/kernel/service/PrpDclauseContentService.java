package com.sinosoft.pms.core.kernel.service;


import com.sinosoft.pms.api.kernel.dto.PrpDclauseContentDto;
import com.sinosoft.framework.dto.PageInfo;

import java.util.List;

/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-08-22 03:00:50.124 
 * @description 条款文档表Core接口
 */
public interface PrpDclauseContentService {

    /**
     *@description 新增
     *@param
     */
    void save(PrpDclauseContentDto prpDclauseContentDto);

    /**
     *@description 删除
     *@param
     */
    void remove(String clauseCode,java.lang.Integer serialNo);
    /**
     *@description 修改
     *@param
     */
    void modify(PrpDclauseContentDto prpDclauseContentDto);
    /**
     *@description 按主键查询实体
     *@param 
     */
    PrpDclauseContentDto queryByPK(String clauseCode,java.lang.Integer serialNo);
}