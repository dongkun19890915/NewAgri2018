package com.sinosoft.pms.core.kernel.service;


import com.sinosoft.pms.api.kernel.dto.PrpDclauseKindDto;
import com.sinosoft.framework.dto.PageInfo;

import java.util.List;

/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-11-04 10:42:46.546 
 * @description 条款险别关系表Core接口
 */
public interface PrpDclauseKindService {

    /**
     *@description 新增
     *@param
     */
    void save(PrpDclauseKindDto prpDclauseKindDto);

    /**
     *@description 删除
     *@param
     */
    void remove(String riskCode, String clauseType, String kindCode, String relateKindCode);
    /**
     *@description 修改
     *@param
     */
    void modify(PrpDclauseKindDto prpDclauseKindDto);
    /**
     *@description 按主键查询实体
     *@param 
     */
    PrpDclauseKindDto queryByPK(String riskCode, String clauseType, String kindCode, String relateKindCode);
}