package com.sinosoft.pms.api.kernel;

import com.sinosoft.pms.PMSConstant;
import com.sinosoft.pms.api.kernel.dto.*;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.sinosoft.framework.dto.PageInfo;

/**
 * @description 自动特约接口服务api
 * @author hrx
 * @date 2017年9月12
 */
@FeignClient(name = PMSConstant.PMS_SERVICE_NAME, path = AutoClauseApi.PATH)
public interface AutoClauseApi {
    String PATH = "autoClause";

    /**
     * @description 新增自动特约
     * @param autoClauseRequestDto
     * @author hrx
     * @date 2017年9月12
     */
    @RequestMapping(value = "saveAutoClause", method = {RequestMethod.POST})
    String saveAutoClause(@RequestBody AutoClauseRequestDto autoClauseRequestDto) throws Exception;

    /**
     * @description 查询自动特约
     * @param autoClauseQueryConditionDto
     * @author hrx
     * @date 2017年9月18
     */
    @RequestMapping(value = "queryAutoClause", method = {RequestMethod.POST})
    PageInfo<PrpDautoClauseDto> queryAutoClause(@RequestBody AutoClauseQueryConditionDto autoClauseQueryConditionDto) throws Exception;

    /**
     * @description 自动特约删除
     * @param autoClauseDeleteConditionDto
     * @author hrx
     * @date 2017年9月19
     */
    @RequestMapping(value = "deleteAutoClause", method = {RequestMethod.POST})
    String deleteAutoClause(@RequestBody AutoClauseDeleteConditionDto autoClauseDeleteConditionDto) throws Exception;

    /**
     * @description 自动特约修改
     * @param autoClauseQueryConditionDto
     * @author hrx
     * @date 2017年9月20
     */
    @RequestMapping(value = "updateAutoClause", method = {RequestMethod.POST})
    AutoClauseResponseDto updateAutoClause(@RequestBody AutoClauseQueryConditionDto autoClauseQueryConditionDto) throws Exception;
}
