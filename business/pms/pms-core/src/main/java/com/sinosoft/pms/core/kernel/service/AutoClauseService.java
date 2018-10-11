package com.sinosoft.pms.core.kernel.service;

import com.sinosoft.framework.dto.PageInfo;
import com.sinosoft.pms.api.kernel.dto.*;

/**
 * @description 自动特约接口服务service
 * @author hrx
 * @date 2017年9月13
 */
public interface AutoClauseService {
    /**
     * @description 新增自动特约
     * @param autoClauseRequestDto
     * @author hrx
     * @date 2017年9月13
     */
    String saveAutoClause(AutoClauseRequestDto autoClauseRequestDto) throws Exception;

    /**
     * @description 查询自动特约
     * @param autoClauseQueryConditionDto
     * @author hrx
     * @date 2017年9月18
     */
    PageInfo<PrpDautoClauseDto> queryAutoClause(AutoClauseQueryConditionDto autoClauseQueryConditionDto) throws Exception;

    /**
     * @description 自动特约删除
     * @param autoClauseDeleteConditionDto
     * @author hrx
     * @date 2017年9月19
     */
    String deleteAutoClause(AutoClauseDeleteConditionDto autoClauseDeleteConditionDto) throws Exception;

    /**
     * @description 自动特约修改
     * @param autoClauseQueryConditionDto
     * @author hrx
     * @date 2017年9月20
     */
    AutoClauseResponseDto updateAutoClause(AutoClauseQueryConditionDto autoClauseQueryConditionDto) throws Exception;
}
