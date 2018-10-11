package com.sinosoft.agriclaim.core.endcasemanage.service;


import com.sinosoft.agriclaim.api.endcasemanage.dto.PrpLEndCaseListDto;
import com.sinosoft.framework.dto.PageInfo;

import java.util.List;

/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-11-08 05:42:04.174 
 * @description 结案基本信息表Core接口
 */
public interface PrpLEndCaseListService {

    /**
     *@description 新增
     *@param
     */
    void save(PrpLEndCaseListDto prpLEndCaseListDto);

    /**
     *@description 删除
     *@param
     */
    void remove(java.lang.Integer id);
    /**
     *@description 修改
     *@param
     */
    void modify(PrpLEndCaseListDto prpLEndCaseListDto);
    /**
     *@description 按主键查询实体
     *@param 
     */
    PrpLEndCaseListDto queryByPK(java.lang.Integer id);
}