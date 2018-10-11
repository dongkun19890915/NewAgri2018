package com.sinosoft.pms.core.kernel.service;


import com.sinosoft.pms.api.kernel.dto.PrpDautoClauseContentDto;
import com.sinosoft.framework.dto.PageInfo;

import java.util.List;

/**
 * @author codegen@研发中心
 * @mail sucong13146@sinosoft.com.cn
 * @time  2017-09-12 12:28:14.022 
 * @description 动态生成特约内容规则表Core接口
 */
public interface PrpDautoClauseContentService {

    /**
     *@description 新增
     *@param
     */
    void save(PrpDautoClauseContentDto prpDautoClauseContentDto);

    /**
     *@description 删除
     *@param
     */
    void remove(String clauseCode, String comCode, String riskCode, String serialNo);
    /**
     *@description 修改
     *@param
     */
    void modify(PrpDautoClauseContentDto prpDautoClauseContentDto);
    /**
     *@description 按主键查询实体
     *@param 
     */
    PrpDautoClauseContentDto queryByPK(String clauseCode, String comCode, String riskCode, String serialNo);

    /**
     *@description 按条件查询实体
     *@param
     */
    List<PrpDautoClauseContentDto> queryByCondition(String clauseCode, String comCode, String riskCode);
}