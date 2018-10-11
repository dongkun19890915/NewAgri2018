package com.sinosoft.pms.core.kernel.service;


import com.sinosoft.pms.api.kernel.dto. PrpDclauseCodeHisDto;
import com.sinosoft.framework.dto.PageInfo;

import java.util.List;

/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-11-07 03:36:19.515 
 * @description 条款配置轨迹表主表Core接口
 */
public interface  PrpDclauseCodeHisService {

    /**
     *@description 新增
     *@param
     */
    void save( PrpDclauseCodeHisDto  PrpDclauseCodeHisDto);

    /**
     *@description 删除
     *@param
     */
    void remove(String clauseCode,java.lang.Double indexNo);
    /**
     *@description 修改
     *@param
     */
    void modify( PrpDclauseCodeHisDto  PrpDclauseCodeHisDto);
    /**
     *@description 按主键查询实体
     *@param 
     */
     PrpDclauseCodeHisDto queryByPK(String clauseCode,java.lang.Double indexNo);
}