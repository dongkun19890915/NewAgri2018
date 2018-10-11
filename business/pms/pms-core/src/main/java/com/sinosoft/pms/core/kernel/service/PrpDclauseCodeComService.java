package com.sinosoft.pms.core.kernel.service;


import com.sinosoft.pms.api.kernel.dto. PrpDclauseCodeComDto;
import com.sinosoft.framework.dto.PageInfo;

import java.util.List;

/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-11-07 03:36:19.515 
 * @description 条款机构配置表Core接口
 */
public interface  PrpDclauseCodeComService {

    /**
     *@description 新增
     *@param
     */
    void save( PrpDclauseCodeComDto  PrpDclauseCodeComDto);

    /**
     *@description 删除
     *@param
     */
    void remove(String clauseCode,String comCode,String comName);
    /**
     *@description 修改
     *@param
     */
    void modify( PrpDclauseCodeComDto  PrpDclauseCodeComDto);
    /**
     *@description 按主键查询实体
     *@param 
     */
     PrpDclauseCodeComDto queryByPK(String clauseCode,String comCode,String comName);
}