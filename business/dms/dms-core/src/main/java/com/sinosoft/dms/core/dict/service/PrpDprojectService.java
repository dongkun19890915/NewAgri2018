package com.sinosoft.dms.core.dict.service;


import com.sinosoft.dms.api.dict.dto.PrpDprojectDto;
import com.sinosoft.framework.dto.PageInfo;

import java.util.List;

/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-08-22 00:47:08.153 
 * @description 项目定义表Core接口
 */
public interface PrpDprojectService {

    /**
     *@description 新增
     *@param
     */
    void save(PrpDprojectDto prpDprojectDto);

    /**
     *@description 删除
     *@param
     */
    void remove(String projectCode);
    /**
     *@description 修改
     *@param
     */
    void modify(PrpDprojectDto prpDprojectDto);
    /**
     *@description 按主键查询实体
     *@param 
     */
    PrpDprojectDto queryByPK(String projectCode);
}