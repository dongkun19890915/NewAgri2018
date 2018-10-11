package com.sinosoft.pms.core.kernel.service;


import com.sinosoft.pms.api.kernel.dto.PrpDclauseCodeKindHisDto;
import com.sinosoft.framework.dto.PageInfo;

import java.util.List;

/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-11-07 03:36:19.515 
 * @description 条款险别配置轨迹表Core接口
 */
public interface PrpDclauseCodeKindHisService {

    /**
     *@description 新增
     *@param
     */
    void save(PrpDclauseCodeKindHisDto prpDclauseCodeKindHisDto);

    /**
     *@description 删除
     *@param
     */
    void remove(String clauseCode,java.lang.Double serialNo,String kindCode,java.lang.Double indexNo);
    /**
     *@description 修改
     *@param
     */
    void modify(PrpDclauseCodeKindHisDto prpDclauseCodeKindHisDto);
    /**
     *@description 按主键查询实体
     *@param 
     */
    PrpDclauseCodeKindHisDto queryByPK(String clauseCode,java.lang.Double serialNo,String kindCode,java.lang.Double indexNo);
}