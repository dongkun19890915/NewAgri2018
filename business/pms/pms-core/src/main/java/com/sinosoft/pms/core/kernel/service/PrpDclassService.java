package com.sinosoft.pms.core.kernel.service;


import com.sinosoft.pms.api.kernel.dto.PrpDclassDto;

import java.util.List;

/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-10-16 12:48:22.282 
 * @description 险类代码表Core接口
 */
public interface PrpDclassService {

    /**
     *@description 新增
     *@param
     */
    void save(PrpDclassDto prpDclassDto);

    /**
     *@description 删除
     *@param
     */
    void remove(String classCode);
    /**
     *@description 修改
     *@param
     */
    void modify(PrpDclassDto prpDclassDto);
    /**
     *@description 按主键查询实体
     *@param 
     */
    PrpDclassDto queryByPK(String classCode);

    /**
     *@description 查询所有实体
     *@param
     */
    List<PrpDclassDto> queryAll(String classCode);


}