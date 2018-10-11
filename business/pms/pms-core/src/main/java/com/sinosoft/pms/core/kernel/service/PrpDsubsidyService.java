package com.sinosoft.pms.core.kernel.service;


import com.sinosoft.framework.dto.PageInfo;
import com.sinosoft.pms.api.kernel.dto.PrpDsubsidyDto;

import java.util.List;

/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-11-04 10:42:46.546 
 * @description PrpDsubsidyCore接口
 */
public interface PrpDsubsidyService {

    /**
     *@description 新增
     *@param
     */
    void save(PrpDsubsidyDto prpDsubsidyDto);

    /**
     *@description 删除
     *@param
     */
    void remove(String riskCode, String comCode, String subsidyYear, String validStatus, String subsidyCode, String subsidyType);
    /**
     *@description 修改
     *@param
     */
    void modify(PrpDsubsidyDto prpDsubsidyDto);
    /**
     *@description 按主键查询实体
     *@param 
     */
    PrpDsubsidyDto queryByPK(String riskCode, String comCode, String subsidyYear, String validStatus, String subsidyCode, String subsidyType);

    /**
     * 根据条件查询PrpDsubsidy补贴信息表信息(此方法只针对3218险种)
     * @author: 田健
     * @date: 2017/12/1 18:41
     * @param riskCode 险种代码
     * @param comCode 归属机构代码
     * @param subsidyYear 年份
     * @return 返回List<PrpDsubsidyDto>补贴信息表信息集合
     * @throws Exception
     */
    List<PrpDsubsidyDto> findPrpDsubsidyDtoListByCondition(String riskCode, String comCode, String subsidyYear)throws Exception;
}