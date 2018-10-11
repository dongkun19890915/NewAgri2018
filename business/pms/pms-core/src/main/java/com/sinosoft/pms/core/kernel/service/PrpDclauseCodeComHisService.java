package com.sinosoft.pms.core.kernel.service;


import com.sinosoft.pms.api.kernel.dto. PrpDclauseCodeComHisDto;
import com.sinosoft.framework.dto.PageInfo;

import java.util.List;

/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-11-07 03:36:19.515 
 * @description 条款机构配置轨迹表Core接口
 */
public interface  PrpDclauseCodeComHisService {

    /**
     *@description 新增
     *@param
     */
    void save( PrpDclauseCodeComHisDto  PrpDclauseCodeComHisDto);

    /**
     *@description 删除
     *@param
     */
    void remove(String clauseCode,String comCode,java.lang.Double indexNo);
    /**
     *@description 修改
     *@param
     */
    void modify( PrpDclauseCodeComHisDto  PrpDclauseCodeComHisDto);
    /**
     *@description 按主键查询实体
     *@param 
     */
     PrpDclauseCodeComHisDto queryByPK(String clauseCode,String comCode,java.lang.Double indexNo);
}